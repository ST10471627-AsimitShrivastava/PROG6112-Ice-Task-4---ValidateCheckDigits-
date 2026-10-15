package validatecheckdigits;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Reads account numbers from a text file and checks their sixth digit. */
public class ValidateCheckDigits {

    /** An account is valid if it contains six digits and its final digit
     * equals the sum of its first five digits modulo 10. */
    public static boolean isValidAccount(String account) {
        if (account == null || !account.matches("[0-9]{6}")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += account.charAt(i) - '0';
        }

        int checkDigit = sum % 10;
        int lastDigit = account.charAt(5) - '0';
        return checkDigit == lastDigit;
    }

    public static void main(String[] args) {
        // By default, the file is in the NetBeans project folder.
        // An alternative file path may also be passed as an argument.
        Path file = Paths.get(args.length > 0 ? args[0] : "account_numbers.txt");
        int total = 0;
        int valid = 0;
        int invalid = 0;

        System.out.println("ACCOUNT NUMBER VALIDATION");
        System.out.println("File: " + file.toAbsolutePath());
        System.out.println("----------------------------------------");

        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String account = line.trim();
                total++;

                if (isValidAccount(account)) {
                    valid++;
                    System.out.printf("%2d. %-12s VALID%n", total, account);
                } else {
                    invalid++;
                    System.out.printf("%2d. %-12s INVALID%n", total, account);
                }
            }

            System.out.println("----------------------------------------");
            System.out.println("Total account numbers: " + total);
            System.out.println("Valid account numbers: " + valid);
            System.out.println("Invalid account numbers: " + invalid);
        } catch (IOException ex) {
            System.err.println("Could not read the account file: " + ex.getMessage());
            System.err.println("Ensure account_numbers.txt is in the project folder.");
        }
    }
}
