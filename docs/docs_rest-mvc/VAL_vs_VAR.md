# VAR vs VAL

No Java, existe apenas `var` como recurso nativo da linguagem. Já o `val` não faz parte do Java oficial - ele vem de
bibliotecas externas, principalmente do Project Lombok.

## `var` (nativo do Java)

Introduzido no Java 10, o `var` permite **inferência de tipo local**.

### Exemplo

```java
var nome = "João";     // String
var idade = 25;        // int
```

### Características

* O tipo é inferido **em tempo de compilação**
* A variável **continua mutável**
* Só pode ser usado em **variáveis locais** (não em atributos, parâmetros, etc.)

### Equivalente a:

```java
String nome = "João";
int idade = 25;
```

## `val` (Lombok)

O `val` vem do Lombok e funciona como um `var` imutável.

### Exemplo

```java
val nome = "João";  // final String
```

### O que ele faz:

* Infere o tipo
* Marca automaticamente como `final`

### Equivale

```java
final String nome = "João";
```

## Diferença principal

| Característica  | `var`          | `val`                     |
|-----------------|----------------|---------------------------|
| Origem          | Java nativo    | Lombok                    |
| Mutabilidade    | Mutável        | Imutável (`final`)        |
| Uso recomendado | Padrão moderno | Opcional (se usar Lombok) |

## Quando usar cada um?

### Use `var` quando:

* Você quer reduzir verbosidade
* A variável **precisa mudar de valor**
* O tipo é óbvio pelo contexto

```java
var total = calcularTotal();
total +=10;
```

### Use `val` quando:

* Você usa Lombok no projeto
* Quer **garantir imutabilidade**
* Prefere código mais seguro contra reatribuição

```java
import lombok.val;

val total = calcularTotal();
// total += 10; ❌ erro
```

## Observações importantes

* `val` **não existe sem Lombok**
* Em equipes, o uso de `val` pode ser controverso (dependência externa)
* Muitos times preferem apenas:
    * `var`
        * `final` explícito quando necessário

```java
final var total = calcularTotal(); // alternativa moderna sem Lombok
```

## Resumo

* `var`: padrão oficial, mutável
* `val`: Lombok, imutável (`final`)
* Melhor prática moderna:
  * Use `var` + `final` quando quiser imutabilidade
  * Evite depender de `val` se não precisar de Lombok