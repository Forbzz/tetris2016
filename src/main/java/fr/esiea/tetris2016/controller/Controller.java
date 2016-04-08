package fr.esiea.tetris2016.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import fr.esiea.tetris2016.model.*;
import fr.esiea.tetris2016.view.*;




public class Controller{
	private KeyListener keyListener;
	private Model model;
	private View view;
	private boolean isGameEnded;
	private long time;
	private long timeStep;
	private int combo;


	public Controller() throws IOException{



		this.view = new View();
		this.model = new Model();
		this.isGameEnded = false;
		this.time= 0;
		this.timeStep=0;
		this.combo=1;



		this.keyListener = new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				if(e.getKeyCode()== KeyEvent.VK_UP){
					if(model.goTurn()){

						model.getGrid();
						view.showGrid(Gameboard.grid, model.instancedPiece, 
								model.getPiece().currentPiecePos, model.getPiece().getCurrentPieceRot());


					}
				}


				if(e.getKeyCode() == KeyEvent.VK_LEFT){

					if(model.goLeft()){

						model.getGrid();
						view.showGrid(Gameboard.grid, model.instancedPiece, 
								model.getPiece().currentPiecePos, model.getPiece().getCurrentPieceRot());

					}




				}

				if(e.getKeyCode()== KeyEvent.VK_RIGHT){

					if(model.goRight()){

						model.getGrid();
						view.showGrid(Gameboard.grid, model.instancedPiece, 
								model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());

					}
				}

				if(e.getKeyCode()== KeyEvent.VK_DOWN){
					if(model.isDownFree()==true){
						model.goDown();
						model.getGrid();
						view.showGrid(Gameboard.grid, model.instancedPiece, 
								model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());

					}else{  model.emergencyUp();}

				}


				e.consume();



			}




			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}




			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		};



		view.addKeyListener(keyListener);	





	}

	public void run() throws IOException
	{
		this.gameLoop();
		this.endScreen();
	}

	public void gameLoop() throws IOException{

		while(!isGameEnded){

			time= System.currentTimeMillis();
			timeStep = time + 400;

			while(timeStep > time){
				time = System.currentTimeMillis();}



			if(model.isDownFree()){
				model.goDown();
				model.getGrid();
				view.showGrid(
						Gameboard.grid,
						model.instancedPiece,
						model.getPiece().currentPiecePos,
						model.getPiece().currentPieceRot);

			}else{
				if(isGameEnded){ 
					this.endScreen(); break; }
				this.step();	
			}

		}



	}


	public void step(){


		model.gridUpdate();
		combo=1; // pour ajouter un systeme de combo plus tard
		model.getScore().increaseScore(model.getFullLines(),combo);

		view.refreshScore(model.getScore().getScore());				

		model.newPiece();	
		model.getGrid();
		view.showGrid(Gameboard.grid, model.instancedPiece, 
				model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());
		isGameEnded = model.isGameEnded();


	}

	public void endScreen() throws IOException{


		view.showScore(model.getScore().getScore(),model.getScore().getLadder());

	}
}

