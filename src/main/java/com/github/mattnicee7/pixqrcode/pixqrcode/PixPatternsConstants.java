package com.github.mattnicee7.pixqrcode.pixqrcode;

import java.util.regex.Pattern;

public class PixPatternsConstants {

    public static final Pattern RECEIVER_NAME_PATTERN = Pattern.compile("[A-z ]{1,25}");

    public static final Pattern RECEIVER_CITY_PATTERN = Pattern.compile("[A-z ]{1,15}");

    public static final Pattern TRANSACTION_IDENTIFIER_PATTERN = Pattern.compile("[A-z0-9]{1,20}");

}
