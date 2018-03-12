package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by kkothagundu on 3/11/2018.
 */

public class Questn {
    private String question;

    private String questn_id;

    public String getQuestion ()
    {
        return question;
    }

    public void setQuestion (String question)
    {
        this.question = question;
    }

    public String getQuestn_id ()
    {
        return questn_id;
    }

    public void setQuestn_id (String questn_id)
    {
        this.questn_id = questn_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [question = "+question+", questn_id = "+questn_id+"]";
    }
}
