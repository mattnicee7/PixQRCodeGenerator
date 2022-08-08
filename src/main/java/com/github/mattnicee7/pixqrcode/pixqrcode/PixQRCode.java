package com.github.mattnicee7.pixqrcode.pixqrcode;

import com.github.mattnicee7.pixqrcode.checksum.Crc16CCITTChecksum;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.ToString;
import lombok.val;

@NoArgsConstructor
@Setter(AccessLevel.PACKAGE)
@ToString
public class PixQRCode {

    private String receiverFullName;
    private String receiverCity;
    private boolean withValue;
    private double value;
    private String transactionIdentifier;
    private String pixKey;

    public String getAsText() {
        val stringBuilder = new StringBuilder();

        // Payload Format Indicator:
        stringBuilder.append("000201");

        // Merchant Account Information - Cartões:
        stringBuilder.append("");

        // Merchant Account Information - PIX:
        stringBuilder.append("26410014BR.GOV.BCB.PIX");
        stringBuilder.append("0119").append(this.pixKey);

        // Merchant Category Code:
        stringBuilder.append("52040000");

        // Transaction Currency:
        stringBuilder.append("5303986");

        // Transaction Amount:
        if (withValue)
            stringBuilder.append("5407").append(value);

        // Country Code:
        stringBuilder.append("5802BR");

        // Merchant Name:
        stringBuilder.append("5925").append(receiverFullName);

        // Merchant City:
        stringBuilder.append("6011").append(receiverCity);

        // Postal code:
        stringBuilder.append("");

        // Additional Data Field:
        stringBuilder.append("62130509").append(transactionIdentifier);

        // Unreserved Templates:
        stringBuilder.append("");

        // CRC16-CCITT (0xffff):
        stringBuilder.append("6304");
        stringBuilder.append(Crc16CCITTChecksum.crc(stringBuilder.toString()).toUpperCase());

        return stringBuilder.toString();
    }

}
