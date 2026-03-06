package guru.springframework.spring7authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

import java.util.UUID;

/**
 * Spring Security Configuration
 *
 * @author Juliane Maran
 * @since 06/03/2026
 */
@Configuration
public class SecurityConfig {

  @Bean // 1
  @Order(1)
  public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
    throws Exception {
    OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
      OAuth2AuthorizationServerConfigurer.authorizationServer();

    http
      .securityMatcher(authorizationServerConfigurer.getEndpointsMatcher())

      .with(authorizationServerConfigurer, authorizationServer ->
        authorizationServer
          .oidc(Customizer.withDefaults()) // Enable OpenID Connect 1.0
      )

      .authorizeHttpRequests(authorize ->
        authorize
          .anyRequest().authenticated()
      )

      // Redireciona para /login quando o usuário não está autenticado
      .exceptionHandling(exceptions -> exceptions
        .defaultAuthenticationEntryPointFor(
          new LoginUrlAuthenticationEntryPoint("/login"),
          new MediaTypeRequestMatcher(MediaType.TEXT_HTML)
        )
      )

      // Suporte a JWT para Resource Server
      .oauth2ResourceServer(oauth2 ->
        oauth2.jwt(Customizer.withDefaults())
      );

    return http.build();
  }

  @Bean // 2
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

  @Bean // 3
  public UserDetailsService userDetailsService() {
    UserDetails userDetails = User.withDefaultPasswordEncoder() // 'withDefaultPasswordEncoder()' is deprecated
      .username("user")
      .password("password")
      .roles("USER")
      .build();

    return new InMemoryUserDetailsManager(userDetails);
  }

  @Bean // 4
  public RegisteredClientRepository registeredClientRepository() {
    RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
      .clientId("oidc-client")
      .clientSecret("{noop}secret")
      .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
      .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
      .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
      .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
      .redirectUri("http://127.0.0.1:8080/login/oauth2/code/oidc-client")
      .redirectUri("http://127.0.0.1:8080/authorized")
      .postLogoutRedirectUri("http://127.0.0.1:8080/")
      .scope(OidcScopes.OPENID) // line 89
      .scope(OidcScopes.PROFILE) // line 90
      .scope("message.read") // line 91
      .scope("message.write")
      .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
      .build();

    return new InMemoryRegisteredClientRepository(oidcClient);
  }

}
