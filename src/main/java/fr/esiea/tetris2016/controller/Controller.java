package fr.esiea.tetris2016.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.esiea.tetris2016.model.*;
import fr.esiea.tetris2016.view.*;




public class Controller {
	private KeyListener keyListener;
	private Model model;
	private View view;
	
	
	
	while (Perdu.isItLoose()==false) {
		deroulement.run();
		}		
		// On arrete bien le programme à la fin
		System.exit(0);

}
