package model;

import java.util.Random;

public class Cliente extends User{
    private String clientID;

    public Cliente(String username, String password, String email, String address, String userID, String clientID) {
        super(username, password, email, address, userID);
        this.clientID = "07CL" + clientIDSubFix();
    }

    public String clientIDSubFix(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
