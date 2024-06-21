// Person.java
package com.example.agecalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private Date dateOfBirth;

    public Person(String dob) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.dateOfBirth = dateFormat.parse(dob);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dob) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.dateOfBirth = dateFormat.parse(dob);
    }

    public int calculateAge(Date currentDate) {
        long diffInMillis = Math.abs(currentDate.getTime() - dateOfBirth.getTime());
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);
        return (int) (diffInDays / 365);
    }
}
