package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class Gmail extends Email {


    public class EmailMessage {
        public Date date;
        public String sender;
        public String message;

        public EmailMessage(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }
    }

    int inboxCapacity;
    //maximum number of mails inbox can store
    TreeMap<String, EmailMessage> inbox = new TreeMap<>();
    TreeMap<String, EmailMessage> trash = new TreeMap<>();

    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message) {
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if (inbox.size() >= inboxCapacity) {

            trash.put(inbox.firstEntry().getKey(), inbox.firstEntry().getValue());
            inbox.remove(inbox.firstEntry().getKey());

        }
        inbox.put(message, new EmailMessage(date, sender, message));


    }

    public void deleteMail(String message) {
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        for (Map.Entry<String, EmailMessage>
                entry : inbox.entrySet()) {
            if (entry.getKey().equals(message)) {
                trash.put(entry.getKey(), entry.getValue());
            }
        }
        inbox.remove(message);
    }

    public String findLatestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if (inbox.size() == 0)
            return null;
        else {
            return inbox.lastEntry().getValue().message;
        }
    }

    public String findOldestMessage() {
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if (inbox.size() == 0)
            return null;
        else {
            return inbox.firstEntry().getValue().message;
        }


    }

    public int findMailsBetweenDates(Date start, Date end) {
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        for (Map.Entry<String, EmailMessage>
                entry : inbox.entrySet()) {
            if (entry.getValue().date.after(start) && entry.getValue().date.before(end) || entry.getValue().date.equals(start) || entry.getValue().date.equals(end)) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize() {
        // Return number of mails in inbox
        return inbox.size();

    }

    public int getTrashSize() {
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash() {
        // clear all mails in the trash
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity - inbox.size();
    }
}
