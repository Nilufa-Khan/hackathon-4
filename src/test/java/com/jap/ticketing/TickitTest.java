package com.jap.ticketing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class TickitTest {

TickitImplement implement = null;
BusRoute busRoute ;
String fileName = "sample.csv";
    @Before
    public void setUp(){
        implement = new TickitImplement();
        busRoute = new BusRoute("KIAS-12/5","KIAS-12UP",9387,1,11359,39,"01/09/2018","02:02:58",281,49.3);
    }
    @After
    public void tearDown(){
        implement = null;
        busRoute = null;
    }
    @Test(expected = NumberFormatException.class)
    public void givenWrongDataFormatThrowsNumberFormatException() {

        implement.readFile(fileName);
    }
    @Test
    public void givenfileDetailsFileReturnTheNUmberOfRecordObjects() throws NumberFormatException {

        List<BusRoute> output = implement.readFile(fileName);
        assertEquals("Record objects not returned correctly",49,output.size());

    }
    @Test
    public void sortDistanceinDecendingOrder(){
        List<BusRoute> output = implement.readFile(fileName);
        assertEquals(49.3,implement.sortDistance(output,new DistanceComparator()).get(0).getTravelled_KM(),0);
    }
    @Test
    public void totalCollectionCalculated(){
        List<BusRoute> output = implement.readFile(fileName);
        assertEquals(10348,implement.calculateTotalCollections(output));
    }


}