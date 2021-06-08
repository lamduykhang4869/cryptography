public class Cipher {
    // Driver code
    public static void main(String[] args)
    {
        String text = "I can get by the escaped convict falling into an open air particle accelerator (we have one in the vacant lot next door and I am always telling my 8 year old to stop playing near it), I can even get by the space slime landing coincidently metres from Peter and jumping on his bike... What I cant get past is Mary Jane. What a fucking bitch. In the first movie she is letting the school bully do her, then she lets the rich guy, then Peter has a turn. In the second movie she goes through about eighteen different guys before abandoning her big expensive wedding after realising Peter is spiderman. In the third film I think she does about sixty guys and whinges a lot about peter saving lives instead of coming to the theatre to watch her crap acting. Why does he put up with her? It makes no sense and is the one glaring discrepancy in an otherwise completely scientifically believable movie.";
        // String text = "Hello world";
        int key = 10;
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + key);

        // Encrypt
        Encrypt.caesar("input.txt", key).toString();
        Encrypt.rail_fence("input.txt", key).toString();

        Decrypt.caesar_without_key("caesar_cipher.txt");
        Decrypt.rail_fence_without_key("rail_fence_cipher.txt");

        
    }
}
