package org.example;

import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());

        String[] url = new String[]{"http://107.20.124.123:4568/json","http://34.229.254.99:4568/json","http://54.167.90.176:4568/json"};

        get("main", (req,res) -> "<h1>This is main!</h1>");
//        post("api", (req,res) -> {
//            HttpConnection.getAPIInfo("")
//
//        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
