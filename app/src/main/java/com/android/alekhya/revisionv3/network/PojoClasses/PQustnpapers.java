package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class PQustnpapers { private String message;

    private String status;

    private List<PQustnPaper> paper;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<PQustnPaper> getPaper()
    {
        return paper;
    }

    public void setPaper(List<PQustnPaper> paper)
    {
        this.paper = paper;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", paper = "+paper+"]";
    }
}
