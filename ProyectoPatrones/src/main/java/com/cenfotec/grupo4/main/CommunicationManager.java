package com.cenfotec.grupo4.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommunicationManager {
    public static int CantOptions = 6;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void ShowMenu() {
 	   	ShowMessage("\nSelect action");
 	   	ShowMessage("1. Create procedure");
        ShowMessage("2. Get the Department procedure");
        ShowMessage("3: Send procedure");
        ShowMessage("4. Treat the procedure");
        ShowMessage("5: Get All Active Procedures");
        ShowMessage("6. Get All Finalized Procedures");
        ShowMessage("7. Logout");
        ShowMessage("8: Exit");
        ShowMessageLine("Enter option: ");
    }
    
    public static void  ShowMessageLine(String message) {
    	System.out.print(message);
    }
    
    public static void ShowMessage(String message) {
 	   System.out.println(message);
    }
    
    public static String AskForText(String message) {
    	String value = "Error";
    	boolean exit = true;
    	while (exit) {
    		try {
    			System.out.println(message);
    			value = br.readLine();
    			if(value.trim().length() == 0 || value.equals("")) {
    				 throw new  Exception("The value entered is not valid");
    			}
    			exit = false;
    			System.out.println();
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
		}
  	   return value;
    }
    
    public static int  GetInt(String message) {
    	int value = -1;
    	boolean exit = true;
    	while (exit) {
    		try {
    			System.out.println(message);
    			value = Integer.parseInt(br.readLine());
    			exit = false;
    			System.out.println();
    		} catch (Exception e) {
    		}
		}
  	   return value;
   }
}
