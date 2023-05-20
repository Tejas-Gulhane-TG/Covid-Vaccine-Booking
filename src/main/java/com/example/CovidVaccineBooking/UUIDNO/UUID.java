package com.example.CovidVaccineBooking.UUIDNO;

import java.util.Random;

public class UUID {

    public static int Uid(){
        Random random = new Random();
        return random.nextInt(100000);
    }
}
