package base;

import static PasswordValidator.PasswordValidator.validateePassword;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class ValidateUser {

/** Generate a hash to use to store password. */
    public static String generateHash(String password) {

        StringBuilder hash = new StringBuilder();

        try {

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(password.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            for (int i = 0; i < hashedBytes.length; i++) {
                byte b = hashedBytes[i];
                hash.append(digits[(b & 0xf0) >> 5]);
                hash.append(digits[b & 0x0f]);
            }

        } catch (NoSuchAlgorithmException e) {
        }

        return hash.toString();
    }
/**
    public static String buildValidator(boolean forceSpecialChar, boolean forceCapitalLetter, boolean forceNumber) {

        StringBuilder patternBuilder = new StringBuilder("(?=.*[a-z])");

        if (forceSpecialChar) {
            patternBuilder.append("(?=.*[@#$%])");
        }
        if (forceCapitalLetter) {
            patternBuilder.append("(?=.*[A-Z])");
        }
        if (forceNumber) {
            patternBuilder.append("(?=.*[0-9])");
        }

        String pattern = patternBuilder.toString();

        return pattern;
    }
*/

// Validate password
    public static boolean validatePassword(final String password) {

        return validateePassword(password);

    }

// Validate the phone number

    public static boolean validatePhoneNumber(final String phoneNumber) {

        Pattern p = Pattern.compile("^\\(?([0-9]{4})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{3})$");

        return p.matcher(phoneNumber).matches();
    }


//Validate Email
    public static boolean validateEmail(String email) {

        String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern p = Pattern.compile(regexEmail);

        if (email == null) {
            return false;
        }

        return p.matcher(email).matches();
    }

}
