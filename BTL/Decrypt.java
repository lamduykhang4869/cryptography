import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class Decrypt {
    private static char[] single_letters = {'e', 't', 'a', 'o', 'i', 'n', 
                                                's', 'h', 'r', 'd', 'l', 'u'};

    private static String[] digraphs = {"th", "er", "on", "an", "re", "he", "in", "ed",
                                        "nd", "ha", "at", "en", "es", "of", "or", "nt",
                                        "ea", "ti", "to", "it", "st", "io", "le", "is", 
                                        "ou", "ar", "as", "de", "rt", "ve"};

    private static String[] trigraphs = {"the", "and", "tha", "ent", "ion", "tio", "for",
                                        "nde", "has", "nce", "edt", "tis", "oft", "sth", "men"};

    private static String[] most_common_doubles = {"ss", "ee", "tt", "ff", "ll", "mm", "oo"};

    // private static String[] initial_letters = {"T", "O", "A", "W", "B", "C", "D", "S",
    //                                         "F", "M", "R", "H", "I", "Y", "E", "G", "L",
    //                                         "N", "P", "U", "J", "K"};

    // private static String[] final_letters = {"E", "S", "T", "D", "N", "R", "Y", "F", "L",
    //                                         "O", "G", "H", "A", "K", "M", "P", "U", "W"};

    private static String[] one_letter_words = {"a", "I"};

    private static String[] two_letter_words = {"of", "to", "in", "it", "is", "be", "as", "at", "so", "we", "he", "by",
        "or", "on", "do", "if", "me", "my", "up", "an", "go", "no", "us", "am"};

    private static String[] three_letter_words = {"the", "and", "for", "are", "but", "not", "you", "all", "any", "can", "had",
        "her", "was", "one", "our", "out", "day", "get", "has", "him", "his", "how", 
        "man", "new", "now", "old", "see", "two", "way", "who", "boy", "did", "its", 
        "let", "put", "say", "she", "too", "use"};
        
    private static String[] four_letter_words = {"that", "with", "have", "this", "will",
        "your", "from", "they", "know", "want", "been", "good", "much", "some", "time"};

    // Caesar Cipher descrypt function
    public static StringBuffer caesar(String cipher, int key) {
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) -
                        key - 65 + 26) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(cipher.charAt(i))){
                char ch = (char) (((int) cipher.charAt(i) -
                        key - 97 + 26) % 26 + 97);
                result.append(ch);
            } else {
                result.append(cipher.charAt(i));
            }
        }
        return result;
    }

    // Rail Fence Cipher descrypt function
    public static StringBuffer rail_fence(String cipher, int key)
    {
        StringBuffer result = new StringBuffer(cipher);
        
        int cur = 0;
        for (int i = 0; i < key; i++)
        {
            int index = i;
            boolean down = true;
            while(index < cipher.length()){
                result.setCharAt(index, cipher.charAt(cur++));
                
                if (i == 0 || i == key - 1)
                    index += 2 * (key - 1);
                else if (down){
                    index += 2 * (key - i - 1);
                    down = !down;
                }
                else{
                    index += 2 * i;
                    down = !down;   
                } 
            }
        }
        return result;
    }

    // Product Cipher descrypt function
    public static StringBuffer product(String text, int key){
        return caesar(rail_fence(text, key).toString(), key);
    }

    public static HashMap<Character, Integer> count(String text){
        // Remove all non-alphabetic characters from a string and
        // convert that string to an lower case string.
        String temp = text.replaceAll("[^a-zA-Z]", "").toLowerCase();
        HashMap<Character, Integer> hist = new HashMap<>();
        for (char c : temp.toCharArray()){
            if (hist.get(c) == null){
                hist.put(c, 1);
            }
            else{
                int val = hist.get(c);
                hist.put(c, val + 1);
            }
        }
        return sortByValue(hist);
    }

    // function to sort hashmap by values
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        HashMap<Character, Integer> temp = hm.entrySet()
                    .stream()
                    .sorted((i1, i2)
                                ->  i2.getValue().compareTo(
                                    i1.getValue()))
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
 
        return temp;
    }

    public static List<Integer> updateScore(List<Integer> scores, List<String> candidates, List<String> keys, boolean empty){
        for (int i = 0; i < candidates.size(); i++){
            int count = 0;
            for (String c: keys){
                if (candidates.get(i).contains(c)){
                    count++;
                }
            }
            if (empty)
                scores.add(Integer.valueOf(count));
            else
                scores.set(i, scores.get(i) + Integer.valueOf(count));
        }
        return scores;
    }
    
    public static int argmax(List<Integer> array){
        int min = Integer.MIN_VALUE;
        int arg = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > min) {
                arg = i;
                min = array.get(i);
            }
        }
        return arg;
    }

    public static String caesar_without_key(String cipher){
        
        // Round 1
        char most_common_letter = (char) count(cipher).keySet().toArray()[0];
        Stream<Character> cStream = IntStream.range(0, single_letters.length).mapToObj(i -> single_letters[i]);
        List<Integer> most_common_keys = cStream.map(x -> ((int)(most_common_letter - x)) % 26).collect(Collectors.toList());
        List<String> candidates = most_common_keys.stream().map(x -> caesar(cipher, x).toString()).collect(Collectors.toList());
        // System.out.println(candidates);
        
        // Round 2
        List<Integer> scores = new ArrayList<Integer>();
        scores = updateScore(scores, candidates, Arrays.asList(digraphs), true);
        // System.out.println(scores);

        // Round 3
        scores = updateScore(scores, candidates, Arrays.asList(trigraphs), false);
        // System.out.println(scores);

        // Round 4
        scores = updateScore(scores, candidates, Arrays.asList(most_common_doubles), false);
        // System.out.println(scores);

        // Round 5
        scores = updateScore(scores, candidates, Arrays.asList(one_letter_words), false);
        // System.out.println(scores);

        // Round 6
        scores = updateScore(scores, candidates, Arrays.asList(two_letter_words), false);
        // System.out.println(scores);

        // Round 7
        scores = updateScore(scores, candidates, Arrays.asList(three_letter_words), false);
        // System.out.println(scores);

        // Round 8
        scores = updateScore(scores, candidates, Arrays.asList(four_letter_words), false);
        // System.out.println(scores);

        return candidates.get(argmax(scores));
    }

    // Driver code
    public static void main(String[] args)
    {
        System.out.println("=== Decrypt Phase ===");
    }
}
