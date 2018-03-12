package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by kkothagundu on 3/10/2018.
 */

public class Users {

    private String message;

    private int status;

    private List<User> users;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public int getStatus ()
    {
        return status;
    }

    public void setStatus (int status)
    {
        this.status = status;
    }

    public List<User> getUsers ()
    {
        return users;
    }

    public void setUsers (List<User> users)
    {
        this.users = users;
    }

    @Override
    public String toString()
    {
        return "Users [message = "+message+", status = "+status+", users = "+users+"]";
    }
}
