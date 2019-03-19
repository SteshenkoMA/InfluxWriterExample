/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.postRequest;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
*
* @author out-inyutin-sa
*
*/
public class InfluxCommon {

    private String influx_url;
    private String metric;
    
    
    InfluxCommon(String url, String metric){
    
        this.influx_url=url;
        this.metric=metric;
    
    }

    //private static List<String> queueToInflux = new  ArrayList();
    //private static List<String> queueToInflux = new  ArrayList();
    public void SendOne() {

        String DataToSend = "";

        DataToSend = metric;

        OutputStream os;

        try {
            URL url = new URL(influx_url);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            httpConn.setRequestMethod("POST");

            httpConn.setDoInput(true);

            httpConn.setDoOutput(true);

            os = httpConn.getOutputStream();

            BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(os));

            osw.write(DataToSend);

            osw.flush();

            osw.close();
            int state = httpConn.getResponseCode();
            System.out.println("Influx ret code:" + state);
            if (state != 204) {
                System.out.println("Influx ret code:" + state);
            }

        } catch (MalformedURLException ex) {

            System.out.println("SendDataToInflux:MalformedURLException:" + ex.toString());

        } catch (java.io.IOException ioe) {

            System.out.println("SendDataToInflux:IOException" + ioe.toString());

        }

    }

   
    
}
