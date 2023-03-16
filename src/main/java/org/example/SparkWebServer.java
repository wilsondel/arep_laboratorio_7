package org.example;

import static spark.Spark.*;

public class SparkWebServer {

    static String[] url = new String[]{"http://34.229.255.243:4568/json","http://100.25.109.148:4568/json","http://54.90.40.218:4568/json"};
    static int count = 0;

    public static void main(String... args){
        staticFiles.location("/public");
        port(getPort());


        get("main", (req,res) -> "<h1>This is main!</h1>");
        post("api", (req,res) -> {
            if(count > 2) count = 0;
            String finalUrl = url[count];
            count+=1;
            return HttpConnection.postInformation(finalUrl,req.body()) + finalUrl;

        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
