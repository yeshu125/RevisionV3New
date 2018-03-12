package com.android.alekhya.revisionv3.network.PojoClasses;


public class User {
    private int user_id;
    private String firstname;
    private String lastname;
    private String user_name;
    private String email;
    private String password;


    public int getUser_id ()
    {
        return user_id;
    }
    public String getfirstname ()
    {
        return firstname;
    }
    public String getlastname ()
    {
        return lastname;
    }
    public String getUser_name ()
    {
        return user_name;
    }
    public String getemail ()
    {
        return email;
    }
    public String getpassword ()
    {
        return password;
    }

    public void setUser_id (int user_id)
    {
        this.user_id = user_id;
    }
    public void setfirstname (String firstname)
    {
        this.firstname = firstname;
    }
    public void setlastname (String lastname)
    {
        this.lastname = lastname;
    }
    public void setEmail (String email)
    {
        this.email = email;
    }
    public void setPassword (String password)
    {
        this.password = password;
    }


    @Override
    public String toString()
    {
        return "Users [user_id = "+user_id+", firstname = "+firstname+", lastname = "+lastname+", user_name = "+user_name+", password = "+password+", email = "+email+"]";
    }
}
