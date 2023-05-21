package com.example.CovidVaccineBooking.Uuid;

import java.util.Random;

public class RandomNo {
    public static int uid(){
        Random random=new Random();
        return random.nextInt(1000000);
    }
}
