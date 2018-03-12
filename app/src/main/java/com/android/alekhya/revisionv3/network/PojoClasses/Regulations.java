package com.android.alekhya.revisionv3.network.PojoClasses;

import java.util.List;

/**
 * Created by kkothagundu on 2/12/2018.
 */

public class Regulations {

        private String message;

        private String status;

        private List<Reg> Reg;

        public String getMessage ()
        {
            return message;
        }

        public void setMessage (String message)
        {
            this.message = message;
        }

        public String getStatus ()
        {
            return status;
        }

        public void setStatus (String status)
        {
            this.status = status;
        }

        public List<Reg> getReg ()
        {
            return Reg;
        }

        public void setReg (List<Reg> Reg)
        {
            this.Reg = Reg;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [message = "+message+", status = "+status+", Reg = "+Reg+"]";
        }
}
