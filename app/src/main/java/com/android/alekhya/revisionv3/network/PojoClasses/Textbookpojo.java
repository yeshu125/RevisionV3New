package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by Alekhya on 02-03-2018.
 */

public class Textbookpojo {
    private String message;

    private List<Unit> unit;

    private String status;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public List<Unit> getUnit ()
    {
        return unit;
    }

    public void setUnit (List<Unit> unit)
    {
        this.unit = unit;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", unit = "+unit+", status = "+status+"]";
    }
}

