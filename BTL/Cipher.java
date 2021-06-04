public class Cipher {
    // Driver code
    public static void main(String[] args)
    {
        String text = "This is a string.";
        int key = 4;
        System.out.println("Text  : " + text);
        char space = ' ';
        System.out.println("Shift : " + key + (int)(space));

        // Encrypt
        String caesar_cipher = Encrypt.caesar(text, key).toString();
        String rail_fence_cipher = Encrypt.rail_fence(text, key).toString();
        String product_cipher = Encrypt.product(text, key).toString();
        // Log
        System.out.println("\n=== Encrypt Phase ===");
        System.out.println("Caesar Cipher: \t\t" + caesar_cipher);
        System.out.println("Rail Fence Cipher: \t" + rail_fence_cipher);
        System.out.println("Product Cipher: \t" + product_cipher);

        // Descrypt
        String caesar_plaintext = Descrypt.caesar(caesar_cipher, key).toString();
        String rail_fence_plaintext = Descrypt.rail_fence(rail_fence_cipher, key).toString();
        String product_plaintext = Descrypt.product(product_cipher, key).toString();
        
        // Log
        System.out.println("\n=== Descrypt Phase ===");
        System.out.println("Caesar Plaintext: \t" + caesar_plaintext);
        System.out.println("Rail Fence Plaintext: \t" + rail_fence_plaintext);
        System.out.println("Product Plaintext: \t" + product_plaintext);
    }
}
