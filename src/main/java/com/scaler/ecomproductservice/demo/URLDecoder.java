package com.scaler.ecomproductservice.demo;

import java.util.Base64;

public class URLDecoder {
    public static void main(String[] args) {
        // Encoded text
        String encodedText = "aHR0cHM6Ly90bnM0bHBnbXppaXlwbnh4emVsNXNzNW55dTBuZnRvbC5sYW1iZGEtdXJsLnVzLWVhc3QtMS5vbi5hd3MvcmFtcC1jaGFsbGVuZ2UtaW5zdHJ1Y3Rpb25zLw==";

        // Decode the Base64-encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
        String decodedURL = new String(decodedBytes);

        // Print the decoded URL
        System.out.println("Decoded URL: " + decodedURL);
    }
}
