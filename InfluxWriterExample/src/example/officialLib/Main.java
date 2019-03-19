/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.officialLib;

import java.util.concurrent.TimeUnit;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;

/**
 *
 * @author steshenko3-ma
 */
public class Main {
    
     public static void main(String[] args) {
     
         InfluxDB influxDB = InfluxDBFactory.connect("http://somehost:8086");
         String dbName = "testDB";
        /*
         influxDB.createDatabase(dbName);
         influxDB.setDatabase(dbName);
         String rpName = "aRetentionPolicy";
         influxDB.createRetentionPolicy(rpName, dbName, "30d", "30m", 2, true);
         influxDB.setRetentionPolicy(rpName);

         influxDB.enableBatch(BatchOptions.DEFAULTS);
*/
         influxDB.setDatabase(dbName);
         influxDB.write(Point.measurement("cpu")
                 .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                 .addField("idle", 90L)
                 .addField("user", 9L)
                 .addField("system", 50L)
                 .build());

         influxDB.write(Point.measurement("disk")
                 .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                 .addField("used", 80L)
                 .addField("free", 1L)
                 .build());

         Query query = new Query("SELECT idle FROM cpu", dbName);
         
         
         System.out.println(influxDB.query(query));
         
 //        influxDB.dropRetentionPolicy(rpName, dbName);
  //       influxDB.deleteDatabase(dbName);
         influxDB.close();

     
     
     
     
     
     }
    
}
