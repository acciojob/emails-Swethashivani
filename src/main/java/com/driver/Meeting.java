package com.driver;

import java.time.LocalTime;
import java.util.Comparator;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;
    private int pos;

    public Meeting(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getPos() {
        return pos;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
    static class mycomparator implements Comparator<Meeting> {
        @Override public int compare(Meeting o1, Meeting o2)
        {
            if (o1.endTime.isBefore(o2.endTime)) {

                // Return -1 if second object is
                // bigger then first
                return -1;
            }
            else if (o1.endTime.isAfter(o2.endTime))

                // Return 1 if second object is
                // smaller then first
                return 1;

            return 0;
        }
    }

}
