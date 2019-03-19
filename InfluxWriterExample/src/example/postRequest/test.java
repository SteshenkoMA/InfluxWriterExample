/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.postRequest;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author steshenko3-ma
 */
public class test {
    
     public static void main(String[] args) {
               
     String influx_url = "http://somehost:8086/write?db=abvTest";
         
     long timeMillis = System.currentTimeMillis();   
     long timeNanos = TimeUnit.MILLISECONDS.toNanos(timeMillis);           
     String metric = "abvEventTime,Topic=ABV.CONFIRMATION,Server=ServerName,AdditAttrib=Additional value=100.0 " +timeNanos+"";
     
     InfluxCommon influxDB = new InfluxCommon(influx_url,metric);
     influxDB.SendOne();
     
    }
}
