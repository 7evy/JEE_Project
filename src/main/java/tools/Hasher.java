package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * This class contains the methods to hash a password
 * @author Sébastien HERT
 * @see <a href="https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/">howtodoinjava.com</a> 
 */
public class Hasher {

    /**
     * This method hashes a password and returns a hashed String
     * @param pwd the password to hash
     * @return a hashed password
     * @author Sébastien HERT
     */
    public static String hashing(String pwd){
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            //Add password bytes to digest
            md.update(pwd.getBytes());
            
            //Get the hash's bytes 
            byte[] bytes = md.digest();

            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        return generatedPassword;
    }

    /**
     * Checks if a password is correct or not
     * @param pwdUsed the password used to try to connect
     * @param hashedPwd the hashed password already databaseed
     * @return a Boolean which checks the password
     * @author Sébastien HERT
     */
    public static Boolean isValidePwd(String pwdUsed, String hashedPwd){
        String hashedPwdUsed = Hasher.hashing(pwdUsed);
        return hashedPwd.equals(hashedPwdUsed);
    }

}