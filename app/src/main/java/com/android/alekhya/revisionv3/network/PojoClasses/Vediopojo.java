package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class Vediopojo {
    private String message;

    private String status;

    private List<MVedio> vedios;

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

    public List<MVedio> getVedios ()
    {
        return vedios;
    }

    public void setVedios (List<MVedio> vedios)
    {
        this.vedios = vedios;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", vedios = "+vedios+"]";
    }
}
