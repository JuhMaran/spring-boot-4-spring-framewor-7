package guru.springframework.spring7authserver.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

/**
 * Spring Security Configuration
 *
 * @author Juliane Maran
 * @since 06/03/2026
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfig {

  /**
   * Authorization Server Security Filter Chain
   */
  @Bean
  @Order(1)
  public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
    OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
      new OAuth2AuthorizationServerConfigurer();

    RequestMatcher endpointsMatcher =
      authorizationServerConfigurer.getEndpointsMatcher();

    http
      .securityMatcher(endpointsMatcher)
      .csrf(csrf -> csrf.ignoringRequestMatchers(endpointsMatcher))
      .with(authorizationServerConfigurer, authorizationServer ->
        authorizationServer
          .oidc(Customizer.withDefaults())
      )
      .authorizeHttpRequests(authorize ->
        authorize.anyRequest().authenticated()
      )
      .exceptionHandling(exceptions -> exceptions
        .defaultAuthenticationEntryPointFor(
          new LoginUrlAuthenticationEntryPoint("/login"),
          new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
        )
      );

    return http.build();
  }
//  @Bean
//  @Order(1)
//  public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
//    http
//      .securityMatcher("/oauth2/**", "/.well-known/**")
//      .authorizeHttpRequests(authorize -> authorize
//        .anyRequest().authenticated()
//      )
//      .exceptionHandling(exceptions -> exceptions
//        .defaultAuthenticationEntryPointFor(
//          new LoginUrlAuthenticationEntryPoint("/login"),
//          new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
//        )
//      )
//      .oauth2ResourceServer(resourceServer ->
//        resourceServer.jwt(Customizer.withDefaults())
//      );
//    return http.build();
//  }

  /**
   * Default security for login
   */
  @Bean
  @Order(2)
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .authorizeHttpRequests((authorize) -> authorize
        .anyRequest().authenticated()
      )
      // Form login handles the redirect to the login page from the
      // authorization server filter chain
      .formLogin(Customizer.withDefaults());
    return http.build();
  }

  /**
   * Users
   */
  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails user = User.builder()
      .username("user")
      .password(encoder.encode("password"))
      .roles("USER")
      .build();
    return new InMemoryUserDetailsManager(user);
  }

  /**
   * OAuth Client
   */
  @Bean
  public RegisteredClientRepository registeredClientRepository(PasswordEncoder encoder) {
    RegisteredClient client = RegisteredClient.withId(UUID.randomUUID().toString())
      .clientId("oidc-client")
      .clientSecret(encoder.encode("secret"))
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
      .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
      .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
      .redirectUri("http://127.0.0.1:8080/login/oauth2/code/oidc-client")
      .redirectUri("http://127.0.0.1:8080/authorized")
      .postLogoutRedirectUri("http://127.0.0.1:8080/")
      .scope(OidcScopes.OPENID)
      .scope(OidcScopes.PROFILE)
      .scope("message.read")
      .scope("message.write")
      .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
      .build();

    return new InMemoryRegisteredClientRepository(client);
  }

  /**
   * JWK Source
   */
  @Bean
  public JWKSource<SecurityContext> jwkSource() {
    KeyPair keyPair = generateRsaKey();
    RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
    RSAKey rsaKey = new RSAKey.Builder(publicKey)
      .privateKey(privateKey)
      .keyID(UUID.randomUUID().toString())
      .build();
    JWKSet jwkSet = new JWKSet(rsaKey);
    return new ImmutableJWKSet<>(jwkSet);
  }

  private static KeyPair generateRsaKey() {
    try {
      KeyPairGenerator keyPairGenerator =
        KeyPairGenerator.getInstance("RSA");
      keyPairGenerator.initialize(2048);
      return keyPairGenerator.generateKeyPair();
    } catch (Exception ex) {
      throw new IllegalStateException(ex);
    }
  }

  /**
   * JWT Decoder
   */
  @Bean
  public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
    return NimbusJwtDecoder
      .withJwkSource(jwkSource)
      .build();
  }

  /**
   * Authorization Server Settings
   */
  @Bean
  public AuthorizationServerSettings authorizationServerSettings() {
    return AuthorizationServerSettings
      .builder()
      .build();
  }

  /**
   * Password Encoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
