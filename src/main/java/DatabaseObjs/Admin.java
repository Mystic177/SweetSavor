package DatabaseObjs;

import java.util.Random;

public class Admin extends User {
    private String adminID;

    public Admin(String username, String password, String email, String address) {
        super(username, password, email, address);
        String subFix = adminIDSubFix();
        this.adminID = "05AD" + subFix;
    }

    public String getAdminID() {
        return adminID;
    }
    

    public String adminIDSubFix(){
        //prefisso = 05AD   
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
