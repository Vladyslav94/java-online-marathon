package sprint09;

import java.util.ArrayList;
import java.util.List;

public class WordsToUpperCase {
    public static void main(String[] args) {
        String originalText = "programming";
        String modifyText = "programming language";
        System.out.println(differentWords(originalText, modifyText));

    }

    public static String differentWords(String originalText, String modifyText) {
        String[] originalArray = originalText.split(" ");
        String[] modifyArray = modifyText.split(" ");

        List<String> strings = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");
        int difference = modifyArray.length - originalArray.length;


        outer:
        while (true) {
            for (int i = 0; i < originalArray.length; i++) {
                if (!originalArray[i].equals(modifyArray[i])) {
                    break outer;
                }
            }
            for (int i = originalArray.length; i < modifyArray.length; i++) {
                modifyArray[i] = modifyArray[i].toUpperCase();
            }

            for (int i = 0; i < modifyArray.length; i++) {
                stringBuilder.append(modifyArray[i]).append(" ");
            }
            return stringBuilder.toString().trim();
        }


        if (difference == 1) {
            for (int i = 0; i < originalArray.length; i++) {
                if (!originalArray[i].equals(modifyArray[i])) {
                    modifyArray[i] = modifyArray[i].toUpperCase();
                    break;
                }
            }

            for (int i = 0; i < modifyArray.length; i++) {
                stringBuilder.append(modifyArray[i]).append(" ");
            }
            return stringBuilder.toString().trim();
        }

        for (String value : modifyArray) {
            if (!originalText.contains(value)) {
                strings.add(value);
            }
        }

        for (int i = 0; i < modifyArray.length; i++) {
            for (String s : strings) {
                if (modifyArray[i].equals(s)) {
                    modifyArray[i] = modifyArray[i].toUpperCase();
                }
            }
        }

        for (String s : modifyArray) {
            stringBuilder.append(s).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}
