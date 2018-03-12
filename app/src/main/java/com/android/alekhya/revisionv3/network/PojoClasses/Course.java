package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by kkothagundu on 2/12/2018.
 */

public class Course
{
    private String course_name;

    private String course_id;

    public String getCourse_name ()
    {
        return course_name;
    }

    public void setCourse_name (String course_name)
    {
        this.course_name = course_name;
    }

    public String getCourse_id ()
    {
        return course_id;
    }

    public void setCourse_id (String course_id)
    {
        this.course_id = course_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [course_name = "+course_name+", course_id = "+course_id+"]";
    }
}
