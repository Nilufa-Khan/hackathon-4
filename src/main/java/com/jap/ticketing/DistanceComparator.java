package com.jap.ticketing;

import java.util.Comparator;

public class DistanceComparator implements Comparator<BusRoute> {
    @Override
    public int compare(BusRoute o1, BusRoute o2) {
        return (int) (o2.getTravelled_KM() - o1.getTravelled_KM());
    }
}
