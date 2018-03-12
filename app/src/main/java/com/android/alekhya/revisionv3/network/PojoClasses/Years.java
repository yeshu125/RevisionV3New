package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

public class Years
{
    
    private String message;

    private String status;

    private List<Year> year;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public List<Year> getYear ()
    {
        return year;
    }

    public void setYear (List<Year> year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", year = "+year+"]";
    }
}
