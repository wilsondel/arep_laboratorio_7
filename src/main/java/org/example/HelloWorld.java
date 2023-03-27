package org.example;

import static spark.Spark.*;
public class HelloWorld {

    private static final String OTHER_SERVICE_URL = "https://ec2-52-91-185-212.compute-1.amazonaws.com:9000/hello2";

    private static final String PATH_FILE = "target/certificados/ecikeystore2.p12";

    public static void main(String[] args) {
        //secure("certificados/ecikeystore.p12", "password", null, null);
        secure(getKeyStore(), getPwdKeyStore(), null, null);
        port(getPort());
        get("/hello", (req, res) -> "Hello World, THIS IS HELLO WORLD SERVICE!");
        get("/hellootherservice", (req, res) -> URLReader.main(PATH_FILE,OTHER_SERVICE_URL));
    }

    private static String getKeyStore() {
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "target/certificados/ecikeystore.p12";
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