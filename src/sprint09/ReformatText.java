package sprint09;

import java.util.ArrayList;
import java.util.List;

public class ReformatText {
    public static void main(String[] args) {
        String text = "Java    was      originally developed\n" +
                "                by    James   Gosling at Sun Microsystems (which\n" +
                "                has since been\n" +
                "                acquired by Oracle) and released in 1995\n" +
                "                as a core component of Sun Microsystems' Java platform.";

        System.out.println(reformatLines(text));
    }

    public static String reformatLines(String text) {
        text = text.replaceAll("\\s+", " ").trim();


//
//        char[] textToChar = text.toCharArray();
//
//        int temp = 0;

        StringBuilder sb = new StringBuilder("");
//        for (int i = 0; i < textToChar.length; i++) {
//            sb.append(textToChar[i]);
//            if((i+1) % 60 == 0){
//                sb.append("\n");
//            }
//        }

        String[] strings = text.split(" ");


//        int lenghtOf = 60;
//
//        for (int i = 0; i < strings.length; i++){
//            sb.append(strings[i]).append(" ");
//            lenghtOf -= strings[i].length();
//            if(lenghtOf < strings[i].length()){
//                lenghtOf = 60;
//                sb.append("\n");
//            }
//
//        }
//
//        return sb.toString().trim();

        text = text.replaceAll("\\s+", " ");

        StringBuilder fullLine = new StringBuilder("");
        String[] arrayOfText = text.split(" ");
        int temp = 0;
        int fullLineLength;

        int arrayLength = arrayOfText.length;
        int tempForFullLineLength = 0;


        while (arrayLength != 0) {
            for (int i = temp; i < arrayOfText.length; i++) {
                fullLine.append(arrayOfText[i]).append(" ");
                tempForFullLineLength += arrayOfText[i].length() + 1;
                fullLineLength = 60 - tempForFullLineLength;
                arrayLength--;
                if (arrayLength != 0) {
                    if (fullLineLength < arrayOfText[i + 1].length()) {
                        temp = i + 1;
                        tempForFullLineLength = 0;
                        fullLine.append(System.getProperty("line.separator"));
                        break;
                    }
                }
            }
        }
        return fullLine.toString();
    }
}
