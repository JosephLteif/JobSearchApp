package utilities;



import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
                return Base64.getEncoder().encodeToString(encodedValue);
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
                byte[] decodedValue = Base64.getDecoder().decode(encodedText);
                byte[] decValue = cipher.doFinal(decodedValue);
                return new String(decValue);
            } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        static Key getSalt() {
            return new SecretKeySpec(secretcode, ALGORITHM);
        }
}
