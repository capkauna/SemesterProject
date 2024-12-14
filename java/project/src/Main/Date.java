package Main;

import java.util.Objects;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private boolean isValidDate(int day, int month, int year)
    {

       if(year < 0 || year > 9999)
                return false;
            if(month < 1 || month > 12)
                return false;
            if(day < 1 || day > 31)
                return false;
            if(month == 2)
            {
                if(isLeapYear(year))
                    return day <= 29;
                else
                    return day <= 28;
            }
            if(month == 4 || month == 6 || month == 9 || month == 11)
                return day <= 30;
            return true;
    }

    private boolean isLeapYear(int year)
    {
        if(year % 400 == 0)
            return true;
        if(year % 100 == 0)
            return false;
        if(year % 4 == 0)
            return true;
        return false;
    }

    public void setDate(int day, int month, int year)
    {
        if(!isValidDate(day, month, year))
            throw new IllegalArgumentException("Invalid date");
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public boolean isBefore(Date other) {
        if (this.year != other.year) return this.year < other.year;
        if (this.month != other.month) return this.month < other.month;
        return this.day < other.day;
    }

    public boolean isAfter(Date other) {
        return !isBefore(other) && !isEqual(other);
    }

    public boolean isEqual(Date other) {
        return this.year == other.year && this.month == other.month && this.day == other.day;
    }

    public int toDays()
    {
        int days = 0;

        for(int y=1; y < year; y++)
        {
            days += isLeapYear(y) ? 366 : 365;
        }
        for(int m = 1; m < month; m++)
        {
            if(m == 2)
            {
                days += isLeapYear(year) ? 29 : 28;
            }
            else if(m == 4 || m == 6 || m == 9 || m == 11)
            {
                days += 30;
            }
            else
            {
                days += 31;
            }
        }
        days += day;
        return days;
    }







    @Override

    public String toString()
    {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    @Override public boolean equals(Object o)
    {
        if (o == null || getClass() != o.getClass())
            return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth()
            && getYear() == date.getYear();
    }

    @Override public int hashCode()
    {
        return Objects.hash(getDay(), getMonth(), getYear());
    }
}

