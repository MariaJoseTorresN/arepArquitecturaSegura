package edu.escuelaing.arep;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {   
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), "123456", null, null);
        port(getPort());
        get("/hello", (req, res) ->{
            return "Hello World";
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore(){
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore.p12"; //returns default keystore 

    }
}