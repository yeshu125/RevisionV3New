package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;


public class Sems {
    private String message;

    private String status;

    private List<Sem> sem;

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

    public List<Sem> getSem ()
    {
        return sem;
    }

    public void setSem (List<Sem> year)
    {
        this.sem = sem;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", sem = "+sem+"]";
    }
}
