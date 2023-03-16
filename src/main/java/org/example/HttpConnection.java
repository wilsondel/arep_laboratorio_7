package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Allow to make requests to the API
 */
public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";


    /**
     * @return JSON with the information of the movie
     * @throws IOException
     */
    public static String postInformation(String url, String requestBody) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json"); // Establecer el tipo de contenido

        // Habilitar la escritura en la conexión
        con.setDoOutput(true);

        // Escribir el cuerpo de la solicitud en la secuencia de salida
        OutputStream os = con.getOutputStream();
        os.write(requestBody.getBytes());
        os.flush();
        os.close();

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("POST request not worked");
        }
        return null;
    }

}