package com.hp.gekko.ordermanagement.util;

import java.time.LocalDateTime;
import java.util.UUID;

public class MyUtils {
	public static String getWelcomeMessage(String username, boolean isCustomer) {
	    if (isCustomer) {
	      return "Dear " + username;
	    } else {
	      return "Hello " + username;
	    }
	  }

}
