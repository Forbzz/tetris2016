package fr.esiea.tetris2016.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.esiea.tetris2016.model.*;
import fr.esiea.tetris2016.view.*;




public class Controller{
	private KeyListener keyListener;
	private Model model;
	private View view;
	private boolean isGameEnded;
	private long time;
	private long timeStep;



	public Controller(){



		this.view = new View();
		this.model = new Model();
		this.isGameEnded = false;
		this.time= 0;
		this.timeStep=0;




		this.keyListener = new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				if(e.getKeyCode()== KeyEvent.VK_UP){
					if(model.goTurn()){

						view.showGrid(model.getGrid().grid, model.instancedPiece, 
								model.getPiece().currentPiecePos, model.getPiece().getCurrentPieceRot());
						System.out.println("at least you tried up");

					}
				}


				if(e.getKeyCode() == KeyEvent.VK_LEFT){

					if(model.goLeft()){

						view.showGrid(model.getGrid().grid, model.instancedPiece, 
								model.getPiece().currentPiecePos, model.getPiece().getCurrentPieceRot());

					}




				}

				if(e.getKeyCode()== KeyEvent.VK_RIGHT){
					
					if(model.goRight()){

						view.showGrid(model.getGrid().grid, model.instancedPiece, 
								model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());

					}
				}

				if(e.getKeyCode()== KeyEvent.VK_DOWN){
					if(model.goDown()){

						view.showGrid(model.getGrid().grid, model.instancedPiece, 
								model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());

					}
				
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









	}

	public void run()
	{
		this.gameLoop();
		this.endScreen();
	}

	public void gameLoop(){
		
		while(!isGameEnded){
			
			time= System.currentTimeMillis();
			timeStep = time + 500;
			
			while(timeStep > time){
				time = System.currentTimeMillis();}
			
			
			
			if(model.goDown()){
				
				System.out.println("descend avec la piece " +model.instancedPiece + " de coordonné " + model.getPiece().currentPiecePos[0] + model.getPiece().currentPiecePos[1]);
				view.showGrid(
						model.getGrid().grid,
						model.instancedPiece,
						model.getPiece().currentPiecePos,
						model.getPiece().currentPieceRot);
model.goDown();
			}else{
				
			this.step();	
			}
			
		}
		
		
		
	}
	
	
	public void step(){
		
	
				model.gridUpdate();
	
				model.getScore().increaseScore(model.getFullLines());

				System.out.println("testGrid:" + model.getScore().getScore() );
				view.refreshScore(model.getScore().getScore());
				
				model.newPiece();
		
		view.showGrid(model.getGrid().grid, model.instancedPiece, 
				model.getPiece().getCurrentPiecePos(), model.getPiece().getCurrentPieceRot());

		
	}

	public void endScreen(){
		
		view.showScore(model.getScore().getScore(),Scores.getLadder());
		
	}
}

