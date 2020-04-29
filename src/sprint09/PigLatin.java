package sprint09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatin {
    public static void main(String[] args) {
        String text = "";
        System.out.println(pigLatinConverter(text));
    }

    public static String pigLatinConverter(String text) {
        String[] textToArray = text.split(" ");
        String vowels = "aeiouy";
        Pattern startWithVowel = Pattern.compile("^[aieouAIEOU].*");
        Pattern allConsonant = Pattern.compile("[a-z&&[^aeiou]]*");


        StringBuilder sb = new StringBuilder("");

        if(text.isEmpty()){
            return "";
        }
        for (String s : textToArray) {
            boolean isLetter = Character.isLetter(s.charAt(s.length() - 1));
            Matcher matcher = startWithVowel.matcher(s);
            Matcher matcher1 = allConsonant.matcher(s);
            if (matcher.matches()) {
                if (!isLetter) {

                    sb.append(s.substring(0, s.length() - 1)).append("hay").append(s.charAt(s.length() - 1)).append(" ");
                } else {
                    sb.append(s).append("hay").append(" ");
                }

            } else if (matcher1.matches()) {
                if (!isLetter) {
                    sb.append(s.substring(0, s.length() - 1)).append("ay").append(s.charAt(s.length() - 1)).append(" ");
                } else {
                    sb.append(s).append("ay").append(" ");
                }
            } else {
                for (int index = 0; index < s.length(); index++) {
                    if (vowels.contains(String.valueOf(s.toLowerCase().charAt(index)))) {
                        if (!isLetter) {
                            sb.append(s.substring(index, s.length() - 1)).append(s, 0, index).append("ay").append(s.charAt(s.length() - 1)).append(" ");
                        } else if(s.contains("-")){
                            String[] temp = s.split("-");
                            sb.append(s.substring(index, temp[0].length())).append(s.substring(0,index)).append("ay").append("-");
                            for (int ind = 0; ind < temp[1].length(); ind++) {
                                if(vowels.contains(String.valueOf(temp[1].toLowerCase().charAt(ind)))){
                                    sb.append(temp[1].substring(ind, temp[1].length())).append(temp[1].substring(0,index)).append("ay").append(" ");
                                    break;
                                }
                            }

                        } else{
                            sb.append(s.substring(index)).append(s, 0, index).append("ay").append(" ");
                        }
                        break;
                    }
                }
            }
        }


        return sb.toString().trim();
    }
}
