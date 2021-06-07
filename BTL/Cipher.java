public class Cipher {
    // Driver code
    public static void main(String[] args)
    {
        // String text = "I can get by the escaped convict falling into an open air particle accelerator (we have one in the vacant lot next door and I am always telling my 8 year old to stop playing near it), I can even get by the space slime landing coincidently metres from Peter and jumping on his bike... What I cant get past is Mary Jane. What a fucking bitch. In the first movie she is letting the school bully do her, then she lets the rich guy, then Peter has a turn. In the second movie she goes through about eighteen different guys before abandoning her big expensive wedding after realising Peter is spiderman. In the third film I think she does about sixty guys and whinges a lot about peter saving lives instead of coming to the theatre to watch her crap acting. Why does he put up with her? It makes no sense and is the one glaring discrepancy in an otherwise completely scientifically believable movie.";
        String text = "Hello world";
        int key = 10;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + key);

        // Encrypt
        String caesar_cipher = Encrypt.caesar(text, key).toString();
        String rail_fence_cipher = Encrypt.rail_fence(text, key).toString();
        // String product_cipher = Encrypt.product(text, key).toString();
        // Log
        System.out.println("\n=== Encrypt Phase ===");
        System.out.println("Caesar Cipher: \t\t" + caesar_cipher);
        System.out.println("Rail Fence Cipher: \t" + rail_fence_cipher);
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

        CipherResult caesar_result = Decrypt.caesar_without_key(caesar_cipher);
        System.out.println("Plaintext without key: \t" + caesar_result.getPlaintext());
        System.out.println("Predicted key: " + caesar_result.getKey());

        CipherResult railfence_result = Decrypt.rail_fence_without_key(rail_fence_cipher);
        System.out.println("Plaintext without key: \t" + railfence_result.getPlaintext());
        System.out.println("Predicted key: " + railfence_result.getKey());

        
    }
}
