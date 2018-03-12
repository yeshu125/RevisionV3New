package com.android.alekhya.revisionv3.network.PojoClasses;

/**
 * Created by kkothagundu on 3/12/2018.
 */

public class Options
{
    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String correct_answer;

    private String Sub_id;

    private String option_id;

    private String questn_id;

    public String getOption1 ()
    {
        return option1;
    }

    public void setOption1 (String option1)
    {
        this.option1 = option1;
    }

    public String getOption2 ()
    {
        return option2;
    }

    public void setOption2 (String option2)
    {
        this.option2 = option2;
    }

    public String getOption3 ()
    {
        return option3;
    }

    public void setOption3 (String option3)
    {
        this.option3 = option3;
    }

    public String getOption4 ()
    {
        return option4;
    }

    public void setOption4 (String option4)
    {
        this.option4 = option4;
    }

    public String getCorrect_answer ()
    {
        return correct_answer;
    }

    public void setCorrect_answer (String correct_answer)
    {
        this.correct_answer = correct_answer;
    }

    public String getSub_id ()
    {
        return Sub_id;
    }

    public void setSub_id (String Sub_id)
    {
        this.Sub_id = Sub_id;
    }

    public String getOption_id ()
    {
        return option_id;
    }

    public void setOption_id (String option_id)
    {
        this.option_id = option_id;
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
        return "ClassPojo [option1 = "+option1+", option2 = "+option2+", option3 = "+option3+", option4 = "+option4+", correct_answer = "+correct_answer+", Sub_id = "+Sub_id+", option_id = "+option_id+", questn_id = "+questn_id+"]";
    }
}
