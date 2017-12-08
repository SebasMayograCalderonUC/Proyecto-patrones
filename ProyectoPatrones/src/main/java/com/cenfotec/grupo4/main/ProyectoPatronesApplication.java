package com.cenfotec.grupo4.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cenfotec.grupo4.gestor.Action;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class ProyectoPatronesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication  app = new SpringApplication(ProyectoPatronesApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
	@Autowired
	private Environment env;

	public void run(String... args) throws Exception {

	
    }
	public void showMenu() {
		System.out.println("Crear procedimiento ->1");
		System.out.println("Obtener procedimiento ->2");
		System.out.println("Enviar procedimiento ->3");
		System.out.println("Salir ->4");
	}
	public void execMenu(int opcion) {
		switch (Action.values()[opcion-1]) {
		case CreateProcedure:
			
			break;

		default:
			break;
		}
	}
	public void createProcedure() {
		String procedureNam;
	}
}




















