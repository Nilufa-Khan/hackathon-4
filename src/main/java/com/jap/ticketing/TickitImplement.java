package com.jap.ticketing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TickitImplement {
    public List<BusRoute> readFile(String fileName) {
        List<BusRoute> busRoutes = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = bufferedReader.readLine();
            while((data = bufferedReader.readLine()) != null){
                String[] val = data.split(",");
                String schedule_no = val[0];
                String route_no =val[1];
                int ticket_from_stop_id = Integer.parseInt(val[2]);
                int ticket_from_stop_seq_no = Integer.parseInt(val[3]);
                int ticket_till_stop_id = Integer.parseInt(val[4]);
                int ticket_till_stop_seq_no = Integer.parseInt(val[5]);
                String ticket_date  = val[6];
                String ticket_time  = val[7];
                int total_ticket_amount = Integer.parseInt(val[8]);
                double travelled_KM = Double.parseDouble(val[9]);


                busRoutes.add(new BusRoute(schedule_no,route_no,ticket_from_stop_id,ticket_from_stop_seq_no,ticket_till_stop_id,ticket_till_stop_seq_no,ticket_date,ticket_time,total_ticket_amount,travelled_KM));

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return busRoutes;
    }
    public List<BusRoute> sortDistance(List<BusRoute> tickitDist, DistanceComparator distanceComparator){

        Collections.sort(tickitDist,new DistanceComparator());

        return tickitDist;
    }

   public int calculateTotalCollections(List<BusRoute> price_of_tickit){
       Iterator<BusRoute> iterator = price_of_tickit.iterator();
        int total_collection = 0;
         while(iterator.hasNext()) {
             total_collection = total_collection + iterator.next().getTotal_ticket_amount();

         }
         return total_collection;
   }

    public static void main(String[] args) {
        TickitImplement t1 = new TickitImplement();
        String filename = "sample.csv";

        List<BusRoute> routeList = t1.readFile(filename);
        System.out.println(routeList);

        System.out.println("-----------------------------------------");
        int output = t1.calculateTotalCollections(routeList);
        System.out.println("output = " + output);
        System.out.println("--------------------------------------------");

        System.out.println(t1.sortDistance(routeList,new DistanceComparator()));


    }
}
