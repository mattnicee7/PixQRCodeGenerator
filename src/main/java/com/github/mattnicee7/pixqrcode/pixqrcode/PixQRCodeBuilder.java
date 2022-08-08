package com.github.mattnicee7.pixqrcode.pixqrcode;

import com.github.mattnicee7.pixqrcode.exception.InvalidValueFormatException;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor
public class PixQRCodeBuilder {

    /**
     * The PixQRCode instance.
     */
    @NotNull
    private final PixQRCode pixQRCode = new PixQRCode();

    /**
     * Set the receiver full name.
     * <br>
     * Regex: "[A-z ]{1, 25}".
     * <br>
     * Rules:
     * <ul>
     *     <li>Cannot be null or empty field.
     *     <li>The receiver's full name cannot be longer than 25 characters.
     * </ul>
     *
     * @param receiverFullName
     *        The receiver full name.
     *
     * @throws InvalidValueFormatException
     *         If the receiver name is longer than 25 characters or is an empty/null field.
     */
    public PixQRCodeBuilder receiverFullName(@NotNull String receiverFullName) throws InvalidValueFormatException {
        if (receiverFullName == null || receiverFullName.trim().equals(""))
            throw new InvalidValueFormatException("O nome do beneficiário não pode ser um campo vazio ou nulo.");

        if (receiverFullName.length() > 25)
            throw new InvalidValueFormatException("O nome do beneficiário não pode ter mais de 25 caracteres.");

        if (!(PixPatternsConstants.RECEIVER_NAME_PATTERN.matcher(receiverFullName).matches()))
            throw new InvalidValueFormatException("Há algo de errado com o nome do beneficiário. Regex: [A-z ]{1,25}");

        this.pixQRCode.setReceiverFullName(receiverFullName);

        return this;
    }

    /**
     * Set the receiver city.
     * <br>
     * Pattern: "[A-z ]{1, 15}"
     * <br>
     * Rules:
     * <ul>
     *     <li>Cannot be null or empty field.
     *     <li>The receiver's city cannot be longer than 15 characters
     * </ul>
     *
     * @param receiverCity
     *        The receiver city.
     *
     * @throws InvalidValueFormatException
     *         If the receiver city is longer than 15 characters or is an empty/null field.
     */
    public PixQRCodeBuilder receiverCity(@NotNull String receiverCity) throws InvalidValueFormatException {
        if (receiverCity == null || receiverCity.trim().equals(""))
            throw new InvalidValueFormatException("O nome da cidade do beneficiário não pode ser um campo vazio ou nulo.");

        if (receiverCity.length() > 15)
            throw new InvalidValueFormatException("O nome da cidade do beneficiário não pode ter mais de 15 caracteres.");

        if (!(PixPatternsConstants.RECEIVER_CITY_PATTERN.matcher(receiverCity).matches()))
            throw new InvalidValueFormatException("Há algo de errado com a cidade do beneficiário. Regex: [A-z ]{1,15}");

        this.pixQRCode.setReceiverCity(receiverCity);

        return this;
    }

    /**
     * Set the withValue boolean.
     *
     * If it is true, you will have to put the value.
     *
     * @param withValue
     *        The withValue boolean.
     */
    public PixQRCodeBuilder withValue(boolean withValue) {
        this.pixQRCode.setWithValue(withValue);

        return this;
    }

    /**
     * Set the transaction value.
     * <br>
     * If the withValue is false, this will not be used.
     * <br>
     * @param value
     *        The transaction value.
     */
    public PixQRCodeBuilder value(double value) {
        this.pixQRCode.setValue(value);

        return this;
    }

    /**
     * Set the transaction identifier.
     * <br>
     * Pattern: "[a-Z0-9]{1, 20}"
     * <br>
     * Rules:
     * <ul>
     *     <li>The transaction identifier cannot have white space.
     *     <li>The transaction identifier can be up to 20 characters long (letters and numbers).
     *     <li>The transaction identifier can be an empty or null field.
     * </ul>
     *
     * @param transactionIdentifier
     *        The transaction identifier.
     *
     * @throws InvalidValueFormatException
     *         If the transaction identifier has blanks, is longer than 20 characters, or has disallowed characters.
     */
    public PixQRCodeBuilder transactionIdentifier(@Nullable String transactionIdentifier) throws InvalidValueFormatException {
        if (transactionIdentifier == null) {
            this.pixQRCode.setTransactionIdentifier("");
            return this;
        }

        if (transactionIdentifier.chars()
                .mapToObj(c -> (char) c)
                .filter(it -> it == ' ')
                .count() > 1)
            throw new InvalidValueFormatException("O identificador não pode ter espaços em branco.");

        if (!(PixPatternsConstants.TRANSACTION_IDENTIFIER_PATTERN.matcher(transactionIdentifier).matches()))
            throw new InvalidValueFormatException("Há algo de errado com o identificador de transação. Regex: [a-Z0-9]{1,20}");

        this.pixQRCode.setTransactionIdentifier(transactionIdentifier);

        return this;
    }

    /**
     * Set the pix key.
     *
     * Rules:
     * <ul>
     *     <li>It can be either CPF, Phone number, E-mail, CNPJ, etc, Random Key.
     *     <li>The pix key cannot be empty or a null field.
     * </ul>
     *
     * @param pixKey
     *        The pix key.
     *
     * @throws InvalidValueFormatException
     *         If the pixKey is empty or null field.
     */
    public PixQRCodeBuilder pixKey(@NotNull String pixKey) throws InvalidValueFormatException {
        if (pixKey == null || pixKey.trim().equals(""))
            throw new InvalidValueFormatException("A chave PIX não pode ser um campo vazio ou nulo");

        this.pixQRCode.setPixKey(pixKey.toUpperCase());

        return this;
    }

    public PixQRCode build() {
        return pixQRCode;
    }

}
