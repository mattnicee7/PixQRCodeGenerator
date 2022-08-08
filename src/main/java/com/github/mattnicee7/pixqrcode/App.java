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
        // Output:
        // 00020126410014BR.GOV.BCB.PIX0119mypix@tests.com5204000053039865802BR5925Fantasy Name6011Sao Paulo62130509SalaryPayment6304F3E5

        System.out.printf("PIX QRCode Example With Value: %s %n", pixQRCodeExampleWithValue.getAsText());
        // Output:
        // 00020126410014BR.GOV.BCB.PIX0119mypix@tests.com5204000053039865407123.455802BR5925Other Fantasy Name6011Brasilia6213050913thSalaryPayment6304577C
    }

}
