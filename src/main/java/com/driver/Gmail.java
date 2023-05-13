package com.driver;

import java.text.DateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Gmail extends Email {

    public ArrayDeque<mail>Mail=new ArrayDeque<>();
    public Stack<mail> trash=new Stack<>();

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
       super(emailId);
       this.inboxCapacity=inboxCapacity;
    }

    public Gmail(String emailId) {
        super(emailId);
    }
    int index=0;
    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(Mail.size()==this.inboxCapacity){
            trash.push(Mail.pollFirst());
        }
        Mail.add(new mail(date,sender,message));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        while(Mail.isEmpty()){
            if(mail.message==message){
                Mail.poll();
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
         if(Mail.isEmpty()) return "null";
         return Mail.peekLast().message;
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(Mail.isEmpty()) return "null";
        return Mail.peekFirst().message;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
       return 1;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
         return Mail.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }

    public static class mail {
        Date date;
        String sender;
        static String message;

        public mail(Date date, String sender, String message) {
            this.date=date;
            this.sender=sender;
            this.message=message;
        }
    }
}
