package util.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Security;

/**
 * Author: Piyush Bedi
 */
public class EncryptionUtilsImpl {

    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    public static String generateBase64EncodedKey() throws Exception {
        return base64Encode(generateKey().getEncoded());
    }

    public static String base64Encode(byte[] data) {
        return new String(Base64.encode(data));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(generateBase64EncodedKey());
    }
}
