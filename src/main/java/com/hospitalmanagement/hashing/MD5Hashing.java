package com.hospitalmanagement.hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashing {

    public static String doHashing(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Hashes the input password using SHA-256 algorithm.
     *
     * @param password The plain text password to be hashed.
     * @return The SHA-256 hashed value in hexadecimal format.
     */
    public static String doHashing(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convert password string to byte array and compute the hash
            byte[] hashBytes = md.digest(password.getBytes());

            // Convert byte array into hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b)); // Format each byte as hex
            }

            return sb.toString(); // Return the final hashed string
        } catch (NoSuchAlgorithmException e) {
            // SHA-256 algorithm should always be available; rethrow as unchecked exception
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }
}
