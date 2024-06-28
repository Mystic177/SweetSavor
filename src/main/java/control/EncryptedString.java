package control;

public class EncryptedString {
    private String encryptedStringResult;

    public EncryptedString(String stringToEncrypt) {

        String s = stringToEncrypt;

        StringBuffer resultString = new StringBuffer();

        for(int i = 0; i < s.length(); i++){
            char c = (char) (((int) s.charAt(i) + 3 - 65) % 26 + 65);
            resultString.append(c);
        }
        
        this.encryptedStringResult = resultString.toString();
    }
}
