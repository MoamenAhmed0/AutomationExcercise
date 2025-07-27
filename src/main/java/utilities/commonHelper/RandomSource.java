package utilities.commonHelper;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomSource {
    public static String generateRandomPassword() {
        Faker faker = new Faker();
        return faker.internet().password(8, 12, true, true);
    }
    public static String generateRandomMobileNumber() {
        Random random = new Random();
        String[] prefixes = {"010", "011", "012", "015"};
        String prefix = prefixes[random.nextInt(prefixes.length)];

        StringBuilder number = new StringBuilder(prefix);
        for (int i = 0; i < 8; i++) {
            number.append(random.nextInt(10));
        }
        return number.toString();
    }
    public static String generateRandomEmail() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String[] domains = {"@gmail.com", "@outlook.com"};
        String selectedDomain = domains[(int) (Math.random() * domains.length)];
        String randomEmail = RandomStringUtils.random(3, lowerCaseLetters) + RandomStringUtils.random(3, upperCaseLetters) + RandomStringUtils.random(3, digits) + selectedDomain;
        return randomEmail;
    }

    public static String generateRandomNID() {
        Random random = new Random();
        StringBuilder nid = new StringBuilder();
        // First digit (typically 2 or 3 in Egyptian NID for century)
        int firstDigit = 2 + random.nextInt(2);
        // 2 or 3
        nid.append(firstDigit);
        //   Next 2 digits: year of birth (00 to 99)
        int year = random.nextInt(100);
        nid.append(String.format("%02d", year));
        // Next 2 digits: month (01 to 12)
        int month = 1 + random.nextInt(12);
        nid.append(String.format("%02d", month));
        //Next 2 digits: day (01 to 28 for safety)
        int day = 1 + random.nextInt(28);
        nid.append(String.format("%02d", day));
        // Next 2 digits: governorate code (01 to 29 for example)
        int governorate = 1 + random.nextInt(29);
        nid.append(String.format("%02d", governorate));
        // Next 4 digits: serial number (0000 to 9999)
        int serial = random.nextInt(10000);
        nid.append(String.format("%04d", serial));
        //Last digit: checksum/random
        int checksum = random.nextInt(10);
        nid.append(checksum);
        return nid.toString();
    }
    public static String generateRandomName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
}