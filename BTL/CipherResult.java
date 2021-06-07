public class CipherResult{
    private final String plaintext;
    private final int key;

    public CipherResult(String plaintext, int key) {
        this.plaintext = plaintext;
        this.key = key;
    }
    public String getPlaintext() { return this.plaintext; }
    public int getKey() { return this.key; }
}