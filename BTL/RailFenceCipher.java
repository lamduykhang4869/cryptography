//A Java Program to illustrate Rail Fence Cipher Technique
class RailFenceCipher
{
    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int key)
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
 
    // Driver code
    public static void main(String[] args)
    {
        String text = "ATTACKATONCE";
        int key = 4;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + key);
        System.out.println("Cipher: " + encrypt(text, key));
    }
}