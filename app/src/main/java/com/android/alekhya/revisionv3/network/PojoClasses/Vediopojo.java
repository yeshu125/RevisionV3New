package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class Vediopojo {
    private String message;

    private String status;

    private List<Mvideos> mvideos;

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

    public List<Mvideos> getMvideos()
    {
        return mvideos;
    }

    public void setMvideos(List<Mvideos> mvideos)
    {
        this.mvideos = mvideos;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = " + message + ", status = " + status + ", mvideos = " + mvideos + "]";
    }
}
