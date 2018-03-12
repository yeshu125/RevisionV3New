package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class MImage {
    private String image_name;

    private String filename;

    private String image_id;

    public String getImage_name ()
    {
        return image_name;
    }

    public void setImage_name (String image_name)
    {
        this.image_name = image_name;
    }

    public String getFilename ()
    {
        return filename;
    }

    public void setFilename (String filename)
    {
        this.filename = filename;
    }

    public String getImage_id ()
    {
        return image_id;
    }

    public void setImage_id (String image_id)
    {
        this.image_id = image_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image_name = "+image_name+", filename = "+filename+", image_id = "+image_id+"]";
    }
}
