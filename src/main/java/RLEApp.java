import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RLEApp {
    public static void main(String[] args) {
        String text = RLEApp.getValue();
        System.out.println(compress(text));
        System.out.println(compressStream(text));
    }

    public static @NotNull String compress(String inputString) {
        String outputString = "";
        Integer count;
        for (int i = 0; i < inputString.length(); i++) {
            count = 1;
            while (i < inputString.length() - 1 && inputString.charAt(i) == inputString.charAt(i + 1)) {
                count++;
                i++;
            }
            outputString = outputString + inputString.charAt(i) + count;
        }
        return outputString;
    }

    public static @NotNull String compressStream(String text) {
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("(([a-zA-Z])(\\2*))");
        pattern.matcher(text).results().forEach(result -> {
            int repetitions = result.group(1).length();
            sb.append(result.group(2)).append(repetitions);
        });
        return sb.toString();
    }

    public static String getValue() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
