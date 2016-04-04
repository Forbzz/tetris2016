package fr.esiea.tetris2016.model;



public class Model {

private Pieces piece;	
private int[] nextMove;
private int moveX;
private int moveY;
	
	
	
public Model() {
	
	piece = Pieces.getClone();
	this.newTetrimino();
	nextMove = Pieces.currentPiecePos;
}

private void newTetrimino() {

	Pieces.create_piece();
	moveX = 0;
	moveY = 0;	
}

public Pieces getPiece(){
	return this.piece;

}
	
	
	
	
	/* public boolean isGameEnded() {


	  	int compteur=0;		
			for (int i=Pieces.currentPiecePos[0]; i < Pieces.currentPiecePos[0]+4; i++) {
				
				for (int j=Pieces.currentPiecePos[1]; j < Pieces.currentPiecePos[1]+4; j++) {
					
					if (compteur < 16) {
						
					if (this.piece_courante[Pieces.currentPieceRot][compteur]>0 && Deroulement.Board[i][j] > 0) {
						
					 return true;
					}
					}
					compteur++;
					}
			}	 return false;
		
		} */
	}
	
	
	
	
	
