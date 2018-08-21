package teedjay.backend;

import com.sun.mail.util.BASE64DecoderStream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

@ApplicationScoped
public class JwtDecoderProducer {

    // The public RSA key can be found in keycloak under your Realm Settings -> Keys -> RSA Public key
    private final String rsaKeyFromKeyCloak = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk8+MT+TkURTYKPrUt9WImqWsZw1aCrxJaJPh4T8mTrMWewy1n4SAtj/uLCUnc3DlX9AIKXLyYlWAWW35KHM36CICQMN4d4Yq62W+crM6Mgxoq9pzdnxka4ila2rvlfg2wSSEsM2h0mEiuw7/3FWlwFLREVq5fOjxAedpZiuJaEPbwj82tRepZsl/3PuIN6KRr1Y3gT+sKTIQHIwnxmzJpUozjjmpVX9qjir/IeIj2m6lbXu6X6Y/RVPpRiOxFlIad7P1XVxqS7ntgSVswOGbMdho+pcOfVymj+sc48Xj0pXcGPCV4i9PGxgTkUo2ldY5FjmeZu7lSqcP94rPXBNZiQIDAQAB";

    @Produces
    public JwtDecoder createJwtDecoderForKeyCloak() throws InvalidKeySpecException, NoSuchAlgorithmException {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(BASE64DecoderStream.decode(rsaKeyFromKeyCloak.getBytes()));
        KeyFactory kf = KeyFactory.getInstance("RSA");
        Key publicKey = kf.generatePublic(spec);
        return new JwtDecoder(publicKey);
    }

}