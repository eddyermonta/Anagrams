package prb;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Anagram1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Anagram1.class.getName());
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine().toLowerCase().trim();
        String b = scan.nextLine().toLowerCase().trim();
        boolean anagram =isAnagram(a, b);

        if(anagram) {
            logger.fine("Anagrams");
        }else{
            logger.warning("Not Anagrams");
        }

    }

    public static boolean isAnagram(String a, String b) {
        List<Character> distinctLettersA = distinctLetters(a);
        List<Character> distinctLettersB = distinctLetters(b);

        boolean anagram = isSizeEqual(a, b) && distinctLettersA.size() == distinctLettersB.size();

        if(anagram){
           anagram =distinctLettersA.stream().
                   allMatch(letterDistinct -> countLettersEquals(letterDistinct, a).
                           equals(countLettersEquals(letterDistinct, b)));

        }
        return anagram;
    }

    public static boolean isSizeEqual(String a, String b) {
        return a.length() == b.length();
    }

    public static Long countLettersEquals(char targetLetter, String target){
        return target.chars().filter(ch -> ch == targetLetter).count();
    }

    public static List<Character> distinctLetters(String target){
        return target.chars().
                distinct().
                mapToObj(ch -> (char)ch).
                toList();
    }


}
