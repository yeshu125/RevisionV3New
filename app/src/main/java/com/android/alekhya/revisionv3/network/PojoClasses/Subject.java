package com.android.alekhya.revisionv3.network.PojoClasses;


public class Subject
{
    private String sub_name;

    private String sub_id;

    public String getSub_name ()
    {
        return sub_name;
    }

    public void setSub_name (String sub_name)
    {
        this.sub_name = sub_name;
    }

    public String getSub_id ()
    {
        return sub_id;
    }

    public void setSub_id (String subid)
    {
        this.sub_id = sub_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sub_name = "+sub_name+", sub_id = "+sub_id+"]";
    }
}
