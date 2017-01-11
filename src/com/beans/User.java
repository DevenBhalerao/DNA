package com.beans;

import java.util.Calendar;
import java.util.Date;

public class User {

	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
	public boolean chkClientLogin(String email,String password){
		if(email.equals("client") && password.equals("1234")){
			return true;
		}
		return false;
	}

}
