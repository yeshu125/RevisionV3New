package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by kkothagundu on 2/12/2018.
 */

public class Courses
{
    private String message;

    private List<Course> course;

    private String status;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public List<Course> getCourse ()
    {
        return course;
    }

    public void setCourse (List<Course> course)
    {
        this.course = course;
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
        return "ClassPojo [message = "+message+", course = "+course+", status = "+status+"]";
    }
}
