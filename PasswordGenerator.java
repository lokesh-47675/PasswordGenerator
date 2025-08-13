import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Character sets as arrays
        char[] uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] digits = "0123456789".toCharArray();
        char[] special = "!@#$%^&*()-_=+<>?/{}~|".toCharArray();

        // Combine all sets into one array
        String allCharsString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+<>?/{}~|";
        char[] allChars = allCharsString.toCharArray();

        System.out.print("Enter desired password length (min 8): ");
        int length = sc.nextInt();

        if (length < 8) {
            System.out.println("Password length should be at least 8 for strong security.");
            return;
        }

        char[] password = new char[length];

        // Ensure at least one character from each category
        password[0] = uppercase[random.nextInt(uppercase.length)];
        password[1] = lowercase[random.nextInt(lowercase.length)];
        password[2] = digits[random.nextInt(digits.length)];
        password[3] = special[random.nextInt(special.length)];

        // Fill remaining slots with random characters
        for (int i = 4; i < length; i++) {
            password[i] = allChars[random.nextInt(allChars.length)];
        }

        // Shuffle password array for randomness
        for (int i = 0; i < password.length; i++) {
            int randomIndex = random.nextInt(password.length);
            char temp = password[i];
            password[i] = password[randomIndex];
            password[randomIndex] = temp;
        }

        // Convert char array to string
        String finalPassword = new String(password);
        System.out.println("Generated Strong Password: " + finalPassword);
    }
}
