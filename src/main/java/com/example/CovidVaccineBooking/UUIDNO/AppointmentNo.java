package com.example.CovidVaccineBooking.UUIDNO;

import java.util.Random;

public class AppointmentNo {

    public static int AppointmentNo(){
        Random random = new Random();
        return random.nextInt(500000);
    }
}
