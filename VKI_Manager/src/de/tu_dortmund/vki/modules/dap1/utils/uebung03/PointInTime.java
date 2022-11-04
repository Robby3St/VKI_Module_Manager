package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

public class PointInTime {
    private int year;
    private int day;
    private int hour;

    public PointInTime(int year, int day, int hour) {
        boolean success = this.changeTime(year, day, hour);
        if(!success) {
            changeTime(2022, 4, 1);
        }
    }

    public boolean changeTime(int year, int day, int hour) {
        boolean success = true;
        if(year > 999 && year < 10000) {
            this.year = year;
        } else {
            success = false;
        }

        if(day >= 1 && day <= 365) {
            this.day = day;
        } else {
            success = false;
        }

        if(hour >=0 && hour <= 23) {
            this.hour = hour;
        } else {
            success = false;
        }

        return success;
    }

    public String toString() {
        String y = "";
        String d = "";
        String h = "";

        if(this.day < 10) {
            d = "0";
        }

        if(this.hour < 10) {
            h = "0";
        }

        return this.year + "/" + d + this.day + "/" + h + this.hour;
    }

    public PointInTime clone() {
        return new PointInTime(this.year, this.day, this.hour);
    }

    public void change(int hoursToAdd) {
//        if(hour > 0) {
//            int years = hoursToAdd / 8760;
//            int days = hoursToAdd / 8760 / 24;
//
//            this.day += days;
//            this.year += years;
//            this.hour += hoursToAdd % 8760 / 24;
//        }
        boolean addDay = false;
        boolean addYear = false;

        int newHours = this.hour + hoursToAdd % 8760 % 24;
        if(newHours > 23) {
            newHours = newHours - 24;
            addDay = true;
        }
        this.hour = newHours;

        int newDay = this.day + hoursToAdd % 8760 / 24;
        if(addDay)
            newDay++;
        if(newDay > 365) {
            newDay = newDay - 365;
        }
        this.day = newDay;

        int newYear = this.year + hoursToAdd / 8760;
        if(addYear)
            newYear++;
        this.year = newYear;


    }
}
