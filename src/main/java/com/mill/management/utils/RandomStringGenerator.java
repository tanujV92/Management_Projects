package com.mill.management.utils;

import org.springframework.stereotype.Component;

@Component
public class RandomStringGenerator {

    private String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateInvoiceNumber(){
        int len=10;
        StringBuilder sb=new StringBuilder();
        while(len--!=0){
            int chrIndex = (int)(Math.random()*text.length());
            chrIndex%=text.length();
            sb.append(text.charAt(chrIndex));
        }
        return sb.toString();
    }

}
