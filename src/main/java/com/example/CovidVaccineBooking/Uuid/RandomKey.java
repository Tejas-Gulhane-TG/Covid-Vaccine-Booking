package com.example.CovidVaccineBooking.Uuid;

import java.util.Random;

public class RandomKey {
    public static int UID(){
        Random random = new Random();
        return random.nextInt(100000);
    }
}
