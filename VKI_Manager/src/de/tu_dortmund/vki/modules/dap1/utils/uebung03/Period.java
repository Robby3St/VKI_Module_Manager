package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

public class Period {
    private int minutes;

    public Period(int minutes) {
        if(minutes > 0) {
            this.minutes = minutes;
        } else {
            this.minutes = 0;
        }
    }

    public Period(int minutes, int hours) {
        int lMinutes = minutes;
        int lHours = hours;

        if(minutes < 0) {
            lMinutes = 0;
        }
        if(hours < 0) {
            lHours = 0;
        }

        this.minutes = minutes + hours * 60;
    }





    // --- Getters/Setters

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.minutes / 60;
    }

    public int getMinorMinutes() {
        return this.minutes % 60;
    }

    public String toString() {
        String h = "";
        String m = "";

        if(this.getHours() < 10) {
            h = "0" + this.getHours();
        } else {
            h = "" + this.getHours();
        }

        if(this.getMinorMinutes() < 10) {
            m = "0" + this.getMinorMinutes();
        } else {
            m = "" + this.getMinorMinutes();
        }

        return h + ":" + m;
    }

    public Period clone() {
        return new Period(this.minutes);
    }

    public void change(int minutesToAdd) {
        if(minutesToAdd > 0) {
            this.minutes += minutesToAdd;
        }
    }
}
