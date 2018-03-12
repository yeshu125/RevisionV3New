package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by kkothagundu on 3/12/2018.
 */

public class OptionList {
    private String message;

    private String status;

    private List<Options> options;

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

    public List<Options> getOptions ()
    {
        return options;
    }

    public void setOptions (List<Options> options)
    {
        this.options = options;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", options = "+options+"]";
    }
}
