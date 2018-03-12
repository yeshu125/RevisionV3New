package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by kkothagundu on 2/12/2018.
 */

public class Reg
{
    private String regulation_id;

    private String regulation_name;

    public String getregulation_id ()
    {
        return regulation_id;
    }

    public void setregulation_id (String regulation_id)
    {
        this.regulation_id = regulation_id;
    }

    public String getregulation_name ()
    {
        return regulation_name;
    }

    public void setregulation_name (String regulation_name)
    {
        this.regulation_name = regulation_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [regulation_id = "+regulation_id+", regulation_name = "+regulation_name+"]";
    }
}
