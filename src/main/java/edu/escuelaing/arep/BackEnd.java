package edu.escuelaing.arep;

import static spark.Spark.*;

public class BackEnd {
    public static void main( String[] args )
    {   
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure(getKeyStore(), "123456", getTrustStore(), "123456");
        port(getPort());
        get("/hello", (req, res) ->{
            return "Hello Moto";
        });
    }

    private static String getTrustStore() {
        if (System.getenv("TRUSTSTORE") != null) {
            return System.getenv("TRUSTSTORE");
        }
        return "keystores/myTrustStore"; //returns default keystore 
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5100; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    static String getKeyStore(){
        if (System.getenv("KEYSTORE") != null) {
            return System.getenv("KEYSTORE");
        }
        return "keystores/ecikeystore.p12"; //returns default keystore 

    }
}