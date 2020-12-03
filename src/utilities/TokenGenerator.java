/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Random;

/**
 *
 * @author Lama
 */
public class TokenGenerator {

    public static String generatetxt() {

        int leftLimit = 65;
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 35;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }
}
