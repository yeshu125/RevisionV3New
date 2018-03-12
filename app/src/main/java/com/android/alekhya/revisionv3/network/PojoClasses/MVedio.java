package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by Alekhya on 04-03-2018.
 */

public class MVedio {
    private String vedios_name;

    private String filename;

    private String vedios_id;

    public String getVedios_name ()
    {
        return vedios_name;
    }

    public void setVedios_name (String vedios_name)
    {
        this.vedios_name = vedios_name;
    }

    public String getFilename ()
    {
        return filename;
    }

    public void setFilename (String filename)
    {
        this.filename = filename;
    }

    public String getVedios_id ()
    {
        return vedios_id;
    }

    public void setVedios_id (String vedios_id)
    {
        this.vedios_id = vedios_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vedios_name = "+vedios_name+", filename = "+filename+", vedios_id = "+vedios_id+"]";
    }
}


