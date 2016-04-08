package fr.esiea.tetris2016;

import java.io.IOException;

import fr.esiea.tetris2016.controller.Controller;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		
		System.out.println("Lancement du Tetris");
		//façade cachant le controlleur:	
		Controller hiddenController = new Controller();
		hiddenController.run();
	}
	
	

}
