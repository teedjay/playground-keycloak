package teedjay.restapi;

public class TheToken {

    public String token;

    public TheToken(String authzHeader) {
        token = authzHeader;
    }

}
