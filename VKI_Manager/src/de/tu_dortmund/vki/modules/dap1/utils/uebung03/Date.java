package de.tu_dortmund.vki.modules.dap1.utils.uebung03;

public class Date {
    private String name;
    private PointInTime start;
    private Period duration;

    public Date(String name, PointInTime start, Period duration) {
        this.name = name;
        this.start = start;
        this.duration = duration;
    }

    public Date clone() {
        return new Date(this.name, this.start, this.duration);
    }

    public void set(PointInTime start, Period duration) {
        this.start = start;
        this.duration = duration;
    }

    public boolean change(int hoursToAdd) {
        if(this.start != null) {
            start.change(hoursToAdd);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String result = "Date: " + this.name;
        if(this.start != null) {
            result = result + ", Start of Date: " + this.start.toString();
        }
        if(this.duration != null) {
            result = result + ", duration of Date: " + this.duration.toString();
        }

        return result;
    }

    // --- Getters


    public String getName() {
        return name;
    }

    public PointInTime getStart() {
        return start;
    }

    public Period getDuration() {
        return duration;
    }
}
