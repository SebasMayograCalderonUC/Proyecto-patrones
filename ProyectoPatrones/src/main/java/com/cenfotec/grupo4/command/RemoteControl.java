package com.cenfotec.grupo4.command;

public class RemoteControl {
	ICommand  unSlot;
	
	public void setCommand(ICommand pCommand) {
		unSlot = pCommand;
	}
	public void receivedsSignal() {
		unSlot.executar();
	}
}
