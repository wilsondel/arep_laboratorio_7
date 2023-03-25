package org.example;

import static spark.Spark.*;

public class OtherService {

    private static final String OTHER_SERVICE_URL = "https://localhost:5000/hello";

    private static final String PATH_FILE = "certificados/ecikeystore.p12";


    public static void main(String[] args) {
        //secure("certificados/ecikeystore.p12", "password", null, null);
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/hello2", (req, res) -> "Hello World, THIS IS OTHER SERVICE!");
        get("/hello2service", (req, res) -> URLReader.main(PATH_FILE,OTHER_SERVICE_URL));
    }

    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "certificados/ecikeystore2.p12";
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
        return 9000;
    }

}