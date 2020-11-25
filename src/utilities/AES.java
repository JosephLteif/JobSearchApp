package utilities;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "AES";
    private static final byte[] secretcode = "tHeApAcHe6410111".getBytes();

    public AES() {

    }
    
            public static String encrypt(String plainText) {

            if (plainText == null) {
                return null;
            }

            Key salt = getSalt();

            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, salt);
                byte[] encodedValue = cipher.doFinal(plainText.getBytes());
                return Base64.encode(encodedValue);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                System.out.println(e.getMessage());
            }

            throw new IllegalArgumentException("Failed to encrypt data");
        }

        public static String getDecrypted(String encodedText) {

            if (encodedText == null) {
                return null;
            }

            Key salt = getSalt();
            try {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, salt);
                byte[] decodedValue = Base64.decode(encodedText);
                byte[] decValue = cipher.doFinal(decodedValue);
                return new String(decValue);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                System.out.println(e.getMessage());
            } catch (Base64DecodingException ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
        }

        static Key getSalt() {
            return new SecretKeySpec(secretcode, ALGORITHM);
        }
}
