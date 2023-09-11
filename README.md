# PixQRCodeGenerator

Welcome to the repository. Here you will find how this framework was made, example usages, and more
Issues & Pull-Requests are welcome in this repository, thanks.

* Actual Version: 1.1.2 (Stable).

## Import the framework to the your project:

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
        <version>1.1.2</version>
    </dependency>
</dependencies>
```

### Gradle:
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.mattnicee7:PixQRCodeGenerator:1.1.2'
}
```

## Example Usages:

#### Example 1 (A PIX without assigned value):

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

#### Example 2 (A PIX with assigned value):

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

## Frameworks used:

* [Lombok](https://projectlombok.org/) - Makes building code easier with your annotations.
* [Jetbrains Annotations](https://www.jetbrains.com/help/idea/annotating-source-code.html) - Use annotations in your fields/methods to point out something important.

## Documentation and tools used:

* [Manual BRCode](https://www.bcb.gov.br/content/estabilidadefinanceira/spb_docs/ManualBRCode.pdf)
* [Pix Nascent](https://github.com/NascentSecureTech/pix-qrcode-utils) 

## See too:

* [Pix-API](https://github.com/bacen/pix-api) - Official Repository of PIX API.
