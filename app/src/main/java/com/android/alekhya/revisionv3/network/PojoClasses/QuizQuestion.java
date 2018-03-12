package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by kkothagundu on 3/11/2018.
 */

public class QuizQuestion
{
    private String message;

    private String status;

    private List<Questn> questn;

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

    public List<Questn> getQuestn ()
    {
        return questn;
    }

    public void setQuestn (List<Questn> questn)
    {
        this.questn = questn;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", questn = "+questn+"]";
    }
}
