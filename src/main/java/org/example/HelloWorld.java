package org.example;

import static spark.Spark.*;
public class HelloWorld {
    public static void main(String[] args) {
        //secure("certificados/ecikeystore.p12", "password", null, null);
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello World");
    }

    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificados/ecikeystore.p12";
    }

    private static String getPwdKeyStore() {
        if (System.getenv("KEYSTOREPWD") != null) {
            return System.getenv("KEYSTOREPWD");
        }
        return "password";
    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}