package com.android.alekhya.revisionv3.network.PojoClasses;

public class Sem
{
    private String sem_name;

    private String sem_id;

    public String getSem_name ()
    {
        return sem_name;
    }

    public void setSem_name (String sem_name)
    {
        this.sem_name = sem_name;
    }

    public String getSem_id ()
    {
        return sem_id;
    }

    public void setSem_id (String semid)
    {
        this.sem_id = semid;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sem_name = "+sem_name+", sem_id = "+sem_id+"]";
    }
}