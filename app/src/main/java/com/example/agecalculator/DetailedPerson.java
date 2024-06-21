// DetailedPerson.java
package com.example.agecalculator;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DetailedPerson extends Person {

    public DetailedPerson(String dob) throws ParseException {
        super(dob);
    }

    public String calculateDetailedAge(Date currentDate) {
        long diffInMillis = Math.abs(currentDate.getTime() - getDateOfBirth().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        int years = (int) (diffInDays / 365);
        int remainingDaysAfterYears = (int) (diffInDays % 365);
        int months = remainingDaysAfterYears / 30;
        int days = remainingDaysAfterYears % 30;

        return "Umur: " + years + " Tahun, " + months + " Bulan, " + days + " Hari";
    }

    @Override
    public int calculateAge(Date currentDate) {
        long diffInMillis = Math.abs(currentDate.getTime() - getDateOfBirth().getTime());
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
        return (int) (diffInDays / 365);
    }
}
