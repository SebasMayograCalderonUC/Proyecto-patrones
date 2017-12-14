package com.cenfotec.grupo4.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommunicationManager {
    public static int CantOptions = 4;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void ShowMenu() {
 	   	ShowMessage("Select action");
 	   	ShowMessage("1. Crear procedimiento");
        ShowMessage("2. Obtener procedimiento");
        ShowMessage("3: Enviar procedimiento");
        ShowMessage("4. Tratar procedimiento");
        ShowMessage("5. Logout");
        ShowMessage("6: Salir");
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
    				 throw new  Exception("Valor ingresado no valido");
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
    			System.out.println("Valor ingresado no valido");
    		}
		}
  	   return value;
     }
}
