package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

public class Subjects
{
    private String message;

    private String status;

    private List<Subject> subject;

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

    public List<Subject> getSubject ()
    {
        return subject;
    }

    public void setSubject (List<Subject> subject)
    {
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", subject = "+subject+"]";
    }
}