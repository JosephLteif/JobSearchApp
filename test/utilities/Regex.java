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
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the password is empty 
        // return false 
        if (password == null) {
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
        if (name == null) {
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
}
