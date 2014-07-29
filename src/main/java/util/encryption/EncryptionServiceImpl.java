package util.encryption;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Security;

/**
 * Author: Piyush Bedi
 */
public class EncryptionServiceImpl implements EncryptionService {

    private static final String CIPHER_CONFIG = "AES";
    private static final String SECRET_KEY_CONFIG = "AES";
    private static SecretKey secretKeySpec;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public EncryptionServiceImpl(String secretKey) {
        secretKeySpec = new SecretKeySpec(Base64.decode(secretKey.getBytes()), SECRET_KEY_CONFIG);
    }

    @Override
    public String encrypt(String value) {
        try {
            Cipher encryptionCipher = Cipher.getInstance(CIPHER_CONFIG);
            encryptionCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return new String(Base64.encode(encryptionCipher.doFinal(value.getBytes())));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(String encryptedValue) {
        try {
            Cipher decryptionCipher = Cipher.getInstance(CIPHER_CONFIG);
            decryptionCipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(decryptionCipher.doFinal(Base64.decode(encryptedValue.getBytes())));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
}