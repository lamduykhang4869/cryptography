import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;


public class Encrypt {

    // Caesar Cipher encrypt function
    public static StringBuffer caesar(String inputFileName, int key)
    {
        String text = readFile(inputFileName);

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
        
        writeFile("caesar_cipher.txt", result.toString());
        return result;
    }

    // Rail Fence Cipher encrypt function
    public static StringBuffer rail_fence(String inputFileName, int key)
    {
        String text = readFile(inputFileName);

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

        writeFile("rail_fence_cipher.txt", result.toString());

        return result;
    }

    // Product Cipher encrypt function
    public static StringBuffer product(String inputFileName, int key){
        String text = readFile(inputFileName);

        StringBuffer result = rail_fence(caesar(text, key).toString(), key);
        writeFile("production_cipher.txt", result.toString());

        return result;
    }

    public static String readFile(String fileName){
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            byte[] buffer = new byte[10];
            StringBuilder sb = new StringBuilder();
            while (fis.read(buffer) != -1) {
                sb.append(new String(buffer));
                buffer = new byte[10];
            }

            fis.close();

            String content = sb.toString();
            return content;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFile(String fileName, String content){
        File file;
        FileOutputStream fos;
        try {
            file = new File(fileName);
            fos = new FileOutputStream(file);

            if (!file.exists()) {
                file.createNewFile();
            }
            
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
            fos.write(contentInBytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    // Driver code
    public static void main(String[] args)
    {
        // String text = "=== Encrypt Phase ===";
        // System.out.println(text);
    }
}
