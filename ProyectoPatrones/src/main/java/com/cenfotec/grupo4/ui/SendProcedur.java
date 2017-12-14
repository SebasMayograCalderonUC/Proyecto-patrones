package com.cenfotec.grupo4.ui;

import com.cenfotec.grupo4.entities.Department;
import com.cenfotec.grupo4.entities.Employee;
import com.cenfotec.grupo4.gestor.GestorGeneral;
import com.cenfotec.grupo4.interfaces.use.EstrategiaGestor;
import com.cenfotec.grupo4.main.CommunicationManager;
import com.cenfotec.grupo4.main.Login;

public class SendProcedur implements EstrategiaGestor{
	GestorGeneral gestor ;
	public SendProcedur(GestorGeneral pgestor){
		this.gestor = pgestor;
	}
	@Override
	public void RunAction() throws Exception {
		Employee employee = Login.employee;
		if(employee.getTreatedProcedures().size() == 0) {
			CommunicationManager.ShowMessage("");
			CommunicationManager.ShowMessage(employee.getEmployeeFullName()+" "+ "no tiene procediemientos\n"
			+ "Por favor obtenga uno de su Departamento");
			CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		}else {
			int index = this.viewProceduresEmployee(employee);
			String idDep = employee.getDepartment().getIdDep();
			gestor.enviarProcedimiento(index,idDep);//Aqui se cae Sevas
		}
	}
	private int viewProceduresEmployee(Employee employee) {
		boolean exitLoop = false;
		String idProcedure ="";
		while(exitLoop == false) {
			for(int i = 0; i<employee.getTreatedProcedures().size(); i++) {
				CommunicationManager.ShowMessage("");
				CommunicationManager.ShowMessage(employee.getTreatedProcedures().get(i).toString());
				CommunicationManager.ShowMessage("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			}
			idProcedure = CommunicationManager.AskForText("Ingrese el ID del Procedimeinto que dese tratar :");
			exitLoop = beIDProcedure(idProcedure);
		}
		return obtainIndexProcedureIndex(idProcedure);
	}
	
	
	private boolean beIDProcedure(String pidProcedure) {
		Employee employee = Login.employee;
		for(int i = 0; i<employee.getTreatedProcedures().size(); i++) {
			if(employee.getTreatedProcedures().get(i).getIdProcedure().equals(pidProcedure)) {
				return true;
			}
		}
		CommunicationManager.ShowMessage("Id del procedimeinto no existe");
		return false;
	}
	private int obtainIndexProcedureIndex(String pidProcedure) {
		Employee employee = Login.employee;
		for(int index = 0; index<employee.getTreatedProcedures().size(); index++) {
			if(employee.getTreatedProcedures().get(index).getIdProcedure().equals(pidProcedure)) {
				return index;
			}
		}
		return 0;
	}
}
