# PixQRCodeGenerator

Seja bem vindo ao repositório. Aqui você encontrará como esse framework foi feito, exemplos de uso, dependencias usadas.
Issues e Pull-Requests são muito bem vindos ao repositório, obrigado.

* Versão Atual: 1.1.0 (Estável em testes).

## Importe o framework para seu projeto:

### Maven:

```xml
<repositories>
    <repository>
        <id>jitpack</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.mattnicee7</groupId>
        <artifactId>PixQRCodeGenerator</artifactId>
        <version>1.1.0</version>
    </dependency>
</dependencies>
```

### Gradle:
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.mattnicee7:PixQRCodeGenerator:1.1.0'
}
```

## Exemplos de Uso:

#### Exemplo 1 (Um pix sem valor atribuido):

```java
final PixQRCode myPixWithoutValue = new PixQRCodeBuilder()
        .receiverFullName("Fantasy Name")
        .transactionIdentifier("SalaryPayment")
        .receiverCity("Sao Paulo")
        .pixKey("mypix@tests.com")
        .withValue(false)
        .build();

System.out.println(myPixWithoutValue.getAsText());
```

#### Exemplo 2 (Um pix com valor atribuido):

```java
final PixQRCode myPixWithValue = new PixQRCodeBuilder()
        .receiverFullName("Other Fantasy Name")
        .transactionIdentifier("13thSalaryPayment")
        .receiverCity("Brasilia")
        .pixKey("mypix@tests.com")
        .withValue(true)
        .value(123.45)
        .build();

System.out.println(myPixWithValue.getAsText());
```

## Frameworks utilizados:

* [Lombok](https://projectlombok.org/) - Facilita a construção do código com suas anotações.
* [Jetbrains Annotations](https://www.jetbrains.com/help/idea/annotating-source-code.html) - Use anotações em seus campos/metódos para apontar algo importante.

## Documentações e ferramentas utilizadas:

* [Manual BRCode](https://www.bcb.gov.br/content/estabilidadefinanceira/spb_docs/ManualBRCode.pdf)
* [Pix Nascent](https://github.com/NascentSecureTech/pix-qrcode-utils) 

## Veja também:

* [Pix-API](https://github.com/bacen/pix-api) - Repositório oficial da API do PIX.
