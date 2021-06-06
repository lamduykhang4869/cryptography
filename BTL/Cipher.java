public class Cipher {
    // Driver code
    public static void main(String[] args)
    {
        String text = "Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a whirlwind. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that must still be done. There is a coolness, a calmness, when the sun does set.";
        int key = 22;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + key);

        // Encrypt
        String caesar_cipher = Encrypt.caesar(text, key).toString();
        // String rail_fence_cipher = Encrypt.rail_fence(text, key).toString();
        // String product_cipher = Encrypt.product(text, key).toString();
        // Log
        System.out.println("\n=== Encrypt Phase ===");
        System.out.println("Caesar Cipher: \t\t" + caesar_cipher);
        // System.out.println("Rail Fence Cipher: \t" + rail_fence_cipher);
        // System.out.println("Product Cipher: \t" + product_cipher);

        // Decrypt
        // String caesar_plaintext = Decrypt.caesar(caesar_cipher, key).toString();
        // String rail_fence_plaintext = Decrypt.rail_fence(rail_fence_cipher, key).toString();
        // String product_plaintext = Decrypt.product(product_cipher, key).toString();
        
        // Log
        System.out.println("\n=== Decrypt Phase ===");
        // System.out.println("Caesar Plaintext: \t" + caesar_plaintext);
        // System.out.println("Rail Fence Plaintext: \t" + rail_fence_plaintext);
        // System.out.println("Product Plaintext: \t" + product_plaintext);

        String plaintext = Decrypt.caesar_without_key(caesar_cipher).toString();
        System.out.println("\n\nPlaintext without key: \t" + plaintext);
        System.out.println("Predicted key: " + ((int)(caesar_cipher.charAt(0) - plaintext.charAt(0)) + 26) % 26);
    }
}
