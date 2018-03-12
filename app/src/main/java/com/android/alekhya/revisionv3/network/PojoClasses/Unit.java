package com.android.alekhya.revisionv3.network.PojoClasses;

public class Unit
{
    private String filename;

    private String u_id;

    private String u_name;

    public String getFilename ()
    {
        return filename;
    }

    public void setFilename (String filename)
    {
        this.filename = filename;
    }

    public String getU_id ()
    {
        return u_id;
    }

    public void setU_id (String u_id)
    {
        this.u_id = u_id;
    }

    public String getU_name ()
    {
        return u_name;
    }

    public void setU_name (String u_name)
    {
        this.u_name = u_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [filename = "+filename+", u_id = "+u_id+", u_name = "+u_name+"]";
    }
}