package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId, Integer.MAX_VALUE);
        // The inboxCapacity is equal to the maximum value an integer can store.

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        this.calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        // m1 -> {10,11} , m2 -> {10:30, 11}, m3 -> {11,11:30}, m4 -> {11:15, 1145}

        ArrayList<Integer> m = new ArrayList<>();

        Meeting.mycomparator mc = new Meeting.mycomparator();

        // Sorting of meeting according to
        // their finish time.
        this.calendar.sort(mc);

        m.add(this.calendar.get(0).getPos());
        LocalTime time_limit = this.calendar.get(0).getEndTime();

        for (int i = 1; i < calendar.size(); i++) {
            if(this.calendar.get(i).getStartTime().isAfter(time_limit)) {
                m.add(this.calendar.get(i).getPos());
                time_limit = this.calendar.get(i).getEndTime();
            }
        }
        return m.size();
    }
}
