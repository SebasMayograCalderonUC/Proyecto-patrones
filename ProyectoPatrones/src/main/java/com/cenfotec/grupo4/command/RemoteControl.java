package com.cenfotec.grupo4.command;

import com.cenfotec.grupo4.interfaces.ICommand;

public class RemoteControl {
	ICommand  unSlot;
	
	public void setCommand(ICommand pCommand) {
		unSlot = pCommand;
	}
	public void receivedsSignal() {
		unSlot.executar();
	}
}
