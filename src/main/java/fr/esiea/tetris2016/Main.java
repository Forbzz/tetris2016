package fr.esiea.tetris2016;

import fr.esiea.tetris2016.controller.Controller;

public class Main {

	public static void main(String[] args) {
		//facade qui cache l'architecture MVC
		Controller controller = new Controller();
		controller.play();
	}
	
}
