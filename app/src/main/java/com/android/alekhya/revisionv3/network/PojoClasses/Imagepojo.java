package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class Imagepojo {

        private String message;

        private String status;

        private List<MImage> image;

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

    public List<MImage> getImage ()
    {
        return image;
    }

    public void setImage (List<MImage> image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+", image = "+image+"]";
    }
}



