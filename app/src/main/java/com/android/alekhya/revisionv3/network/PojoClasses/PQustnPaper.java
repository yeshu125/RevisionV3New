package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by Alekhya on 24-02-2018.
 */

public class PQustnPaper
{

    private String p_name;

    private String filename;

    private String p_id;

    public String getP_name ()
    {
        return p_name;
    }

    public void setP_name (String p_name)
    {
        this.p_name = p_name;
    }

    public String getFilename ()
    {
        return filename;
    }

    public void setFilename (String filename)
    {
        this.filename = filename;
    }

    public String getP_id ()
    {
        return p_id;
    }

    public void setP_id (String p_id)
    {
        this.p_id = p_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [p_name = "+p_name+", filename = "+filename+", p_id = "+p_id+"]";
    }
}


