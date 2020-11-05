/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joelt
 */
public class Regex {
    // Function to validate the password. 

    public static boolean isValidPassword(String password) {

        // Regex to check valid password. 
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the password is empty 
        // return false 
        if (password.equals("")) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(password);

        // Return if the password 
        // matched the ReGex 
        return m.matches();
    }

    // Function to validate the username 
    public static boolean isValidUsername(String name) {

        // Regex to check valid username. 
        String regex = "^[A-Za-z]\\w{5,29}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the username is empty 
        // return false 
        if (name.equals("")) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given username 
        // and regular expression. 
        Matcher m = p.matcher(name);

        // Return if the username 
        // matched the ReGex 
        return m.matches();
    }

    public static boolean isValidEmail(String email) {

        // Regex to check valid email. 
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the email is empty 
        // return false 
        if (email.equals("")) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given email 
        // and regular expression. 
        Matcher m = p.matcher(email);

        // Return if the email 
        // matched the ReGex 
        return m.matches();
    }

    public static boolean isValidName(String name) {

        // Regex to check valid name. 
        String regex = "\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the name is empty 
        // return false 
        if (name.equals("")) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given name 
        // and regular expression. 
        Matcher m = p.matcher(name);

        // Return if the name 
        // matched the ReGex 
        return m.matches();
    }
}
