
public class Descrypt {
    // Caesar Cipher descrypt function
    public static StringBuffer caesar(String cipher, int key) {
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < cipher.length(); i++) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) (((int) cipher.charAt(i) -
                        key - 65) % 26 + 65);
                result.append(ch);
            } else if (Character.isLowerCase(cipher.charAt(i))){
                char ch = (char) (((int) cipher.charAt(i) -
                        key - 97) % 26 + 97);
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

    // Driver code
    public static void main(String[] args)
    {
        String text = "=== Descrypt Phase ===";
        System.out.println(text);
    }
}
