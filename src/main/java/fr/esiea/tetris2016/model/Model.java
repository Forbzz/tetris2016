package fr.esiea.tetris2016.model;

import java.io.IOException;






public class Model {


	private Pieces currentPiece;	
	private Scores score;
	public int fullLines;
	private Gameboard gridGame;
	public int[][] instancedPiece;
	private int[] currentPiecePos;
	private Restricted restricted;

	private boolean rightIsBlocked;
	private boolean pieceIsBlocked;
	private boolean rotationIsBlocked;
	private boolean leftIsBlocked;





	public Model() throws IOException {

		restricted = new Restricted();

		gridGame= new Gameboard();

		score = new Scores();

		currentPiece = Pieces.getClone();	
		currentPiecePos= currentPiece.getCurrentPiecePos();

		this.newPiece();

		gridGame.initArray();



	}


	public void newPiece() {

		currentPiecePos[0]=0; // Position verticale
		currentPiecePos[1]=3; // Position horizontale 	
		currentPiece.currentPieceRot=0;
		instancedPiece=currentPiece.create_piece();
	}

	public Pieces getPiece(){
		return this.currentPiece;

	}

	public Gameboard getGrid(){
		return this.gridGame;
	}






	// Verifie si la piece créé entre déjà en collision = defaite
	public boolean isGameEnded() {


		int count=0;		
		for (int i=currentPiecePos[0]; i < currentPiecePos[0]+4; i++) {

			for (int j=currentPiecePos[1]; j <currentPiecePos[1]+4; j++) {

				if (count < 16 ) {

					if ((instancedPiece[currentPiece.getCurrentPieceRot()][count]>0) && (Gameboard.grid[i][j] > 0)) {

						return true;
					}
				}
				count++;
			}
		}	 return false;

	} 




	// Cette fonction met à jour le plateau avec l'ancrage de la piece.
	public void gridUpdate(){

		int count=0;		
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if (count < 16) {
					if (instancedPiece[currentPiece.getCurrentPieceRot()][count]!=0) {
						Gameboard.grid[currentPiecePos[0]-1+i][currentPiecePos[1]+j]=instancedPiece[currentPiece.getCurrentPieceRot()][count];


					}
					count++;
				}




			}
		}
	}

	// Ici on met les actions de deplacements en fonction des restrictions




	public boolean goLeft(){
		leftIsBlocked = restricted.Left(currentPiecePos, currentPiece.getCurrentPieceRot(), Gameboard.grid , instancedPiece);

		if(leftIsBlocked==true){		
			return false;
		}

		if(pieceIsBlocked==true){
			return false;
		}

		currentPiece.left();
		return true;

	}


	public boolean goRight(){
		rightIsBlocked= restricted.Right(currentPiecePos, currentPiece.getCurrentPieceRot(), Gameboard.grid , instancedPiece);
		if(rightIsBlocked==true){		
			return false;
		}

		if(pieceIsBlocked==true){
			return false;
		}

		currentPiece.right();
		return true;

	}

	public boolean goTurn(){
		rotationIsBlocked = restricted.Rotation(currentPiecePos, currentPiece.getCurrentPieceRot(), Gameboard.grid , instancedPiece);

		if(rotationIsBlocked==true){

			return false;
		}

		currentPiece.rotate();
		return true;

	}

	public boolean isDownFree(){
		pieceIsBlocked=restricted.Down(currentPiecePos, currentPiece.getCurrentPieceRot(), Gameboard.grid , instancedPiece);
		if(pieceIsBlocked==true  ){

			currentPiecePos[0]++;
			return false;
		}


		return true;
	}

	public Scores getScore() {
		return score;
	}

	public void emergencyUp(){ // remonte la piece quand elle traverse une autre

		currentPiece.up();
	}

	public void goDown(){

		currentPiece.down();
	}

	public int getFullLines() {
		fullLines= LineOp.checkFullLines();
		return fullLines;
	}


}





