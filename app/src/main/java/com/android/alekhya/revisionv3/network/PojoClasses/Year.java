package com.android.alekhya.revisionv3.network.PojoClasses;


public class Year
{
    private String y_name;

    private String y_id;

    public String gety_name ()
    {
        return y_name;
    }

    public void sety_name (String yname)
    {
        this.y_name = yname;
    }

    public String gety_id ()
    {
        return y_id;
    }

    public void sety_id (String yid)
    {
        this.y_id = yid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [y_name = "+y_name+", y_id = "+y_id+"]";
    }
}
