package com.github.mattnicee7.pixqrcode;

import com.github.mattnicee7.pixqrcode.pixqrcode.PixQRCode;
import com.github.mattnicee7.pixqrcode.pixqrcode.PixQRCodeBuilder;
import lombok.SneakyThrows;

public class App {

    @SneakyThrows
    public static void main(String[] args) {
        final PixQRCode pixQRCodeExampleWithoutValue = new PixQRCodeBuilder()
                .receiverFullName("Fantasy Name")
                .transactionIdentifier("Salary")
                .receiverCity("Sao Paulo")
                .pixKey("mypix@tests.com")
                .withValue(false)
                .build();

        final PixQRCode pixQRCodeExampleWithValue = new PixQRCodeBuilder()
                .receiverFullName("Other Fantasy Name")
                .transactionIdentifier("13thSalaryPayment")
                .receiverCity("Brasilia")
                .pixKey("mypix@tests.com")
                .withValue(true)
                .value(123.45)
                .build();

        System.out.printf("Pix QRCode Example Without Value: %s %n", pixQRCodeExampleWithoutValue.getAsText());

        System.out.printf("PIX QRCode Example With Value: %s %n", pixQRCodeExampleWithValue.getAsText());
    }

}
