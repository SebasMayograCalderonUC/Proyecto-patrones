package com.cenfotec.grupo4.main;

public class CommunicationManager {
    public static int CantOptions = 4;
    public void ShowMenu() {
 	   	ShowMessage("Select action");
 	   	ShowMessage("1. Crear procedimiento");
        ShowMessage("2. Obtener procedimiento");
        ShowMessage("3: Enviar procedimiento");
        ShowMessage("4: Salir");
        ShowMessageLine("Enter option: ");
    }
    
    public void ShowMessageLine(String message) {
    	System.out.print(message);
    }
    
    public void ShowMessage(String message) {
 	   System.out.println(message);
    }
}
