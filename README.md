# Java Anagram Checker: 1

This document highlights and explains the key methods used in a Java program to determine if two strings are anagrams and to log the results.

## Main Method

```java
public static void main(String[] args) {
    Logger logger = Logger.getLogger(Anagram1.class.getName());
    Scanner scan = new Scanner(System.in);
    String a = scan.nextLine().toLowerCase().trim();
    String b = scan.nextLine().toLowerCase().trim();
    boolean anagram = isAnagram(a, b);

    if(anagram) {
        logger.fine("Anagrams");
    } else {
        logger.warning("Not Anagrams");
    }
}
```

### Explanation
Logger Creation: Initializes a Logger instance for logging messages.

Input Handling: Reads two lines of input from the user, converts them to lowercase, and trims whitespace.

Anagram Check: Calls the isAnagram method to check if the two strings are anagrams.

Logging: Logs the result as "Anagrams" at the FINE level or "Not Anagrams" at the WARNING level based on the result.
isAnagram Method

```java
public static boolean isAnagram(String a, String b) {
    List<Character> distinctLettersA = distinctLetters(a);
    List<Character> distinctLettersB = distinctLetters(b);

    boolean anagram = isSizeEqual(a, b) && distinctLettersA.size() == distinctLettersB.size();

    if(anagram) {
        anagram = distinctLettersA.stream()
                   .allMatch(letterDistinct -> countLettersEquals(letterDistinct, a)
                   .equals(countLettersEquals(letterDistinct, b)));
    }
    return anagram;
}
```
### Explanation
Distinct Letters Extraction: Retrieves distinct characters from both strings.

Size and Frequency Check: Ensures both strings have the same length and number of distinct characters. If so, checks that the frequency of each character matches in both strings.

## Helper Methods
```java
public static boolean isSizeEqual(String a, String b) {
    return a.length() == b.length();
}
```
### Explanation
Size Comparison: Compares the lengths of two strings and returns true if they are equal, otherwise false.

```java
public static Long countLettersEquals(char targetLetter, String target) {
    return target.chars().filter(ch -> ch == targetLetter).count();
}
```

### Explanation
Character Count: Counts the occurrences of a specified character in a given string.

```java
public static List<Character> distinctLetters(String target) {
    return target.chars()
                 .distinct()
                 .mapToObj(ch -> (char) ch)
                 .toList();
}
```
### Explanation
Distinct Characters: Converts the string to a stream of characters, removes duplicates, and collects the distinct characters into a list.

# Java Anagram Checker: 2
# Java Anagram Checker: Key Methods

This document highlights and explains the key methods used in a Java program to determine if two strings are anagrams and to log the results.

## Main Method

```java
public static void main(String[] args) {
    Logger logger = Logger.getLogger(Anagram2.class.getName());
    Scanner scan = new Scanner(System.in);
    String a = scan.nextLine().toLowerCase().trim();
    String b = scan.nextLine().toLowerCase().trim();

    if (sortString(a).equals(sortString(b))) {
        logger.info("Anagrams");
    } else {
        logger.warning("Not Anagrams");
    }
}
```

Explanation
Logger Creation: Initializes a Logger instance for logging messages.

Input Handling: Uses Scanner to read two lines of input from the user, converts them to lowercase, and trims whitespace.

Anagram Check: Calls the sortString method for both input strings and compares the sorted versions to determine if they are anagrams.

Logging: Logs the result as "Anagrams" at the INFO level or "Not Anagrams" at the WARNING level based on the result.
sortString Method

```java
public static String sortString(String str) {
    return Arrays.stream(str.split(""))
                 .sorted()
                 .reduce("", String::concat);
}
```

Explanation
String Splitting: Splits the input string into individual characters.

Sorting: Sorts the array of characters.

Concatenation: Concatenates the sorted characters back into a single string.
