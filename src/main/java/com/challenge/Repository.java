package com.challenge;

import com.challenge.models.Client;

import java.util.HashMap;


public class Repository {
    public static Integer index = 0;
    public static HashMap<Integer, Client> clients;

    public static Integer getIndex(){
        index++;
        return index;
    }
}
