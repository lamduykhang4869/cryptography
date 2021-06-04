
public class Encrypt {

    // Caesar Cipher encrypt function
    public static StringBuffer caesar(String text, int key)
    {
        StringBuffer result = new StringBuffer();
 
        for (int i = 0; i < text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int) text.charAt(i) +
                                  key - 65) % 26 + 65);
                result.append(ch);
            }
            else if (Character.isLowerCase(text.charAt(i)))
            {
                char ch = (char)(((int) text.charAt(i) +
                                  key - 97) % 26 + 97);
                result.append(ch);
            }
            else{
                result.append(text.charAt(i));
            }
        }
        return result;
    }

    // Rail Fence Cipher encrypt function
    public static StringBuffer rail_fence(String text, int key)
    {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < key; i++)
        {
            int index = i;
            boolean down = true;
            while(index < text.length()){
                result.append(text.charAt(index));
                
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

    // Product Cipher encrypt function
    public static StringBuffer product(String text, int key){
        return rail_fence(caesar(text, key).toString(), key);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String text = "=== Encrypt Phase ===";
        System.out.println(text);
    }
}
