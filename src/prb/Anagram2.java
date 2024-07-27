package prb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Anagram2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Logger logger = Logger.getLogger(Anagram2.class.getName());

        String a = scan.nextLine().toLowerCase().trim();
        String b = scan.nextLine().toLowerCase().trim();

        if(sortString(a).equals(sortString(b))) logger.info("Anagrams");
        else logger.warning("Not Anagrams");


    }

    public static String sortString(String str){
         return  Arrays.stream(str.split(""))
                 .sorted()
                 .reduce("",String::concat);
    }

}
