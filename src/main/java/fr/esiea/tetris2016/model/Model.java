package fr.esiea.tetris2016.model;






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
	
	
	


	public Model() {
		
		restricted = new Restricted();

		gridGame= new Gameboard();

		score = new Scores();
System.out.println("fullLinesmodel=" +fullLines);
		currentPiece = Pieces.getClone();	
		currentPiecePos= currentPiece.getCurrentPiecePos();

		this.newPiece();
	
		gridGame.initArray();
		instancedPiece= currentPiece.create_piece();
		System.out.println(" on refait le new piece =" + instancedPiece);
		
		pieceIsBlocked = restricted.Down(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);
		rotationIsBlocked = restricted.Rotation(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);
		rightIsBlocked = restricted.Right(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);
		leftIsBlocked = restricted.Left(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);

		
	}

	
	public void newPiece() {

		currentPiecePos[0]=0; // Position verticale
		currentPiecePos[1]=3; // Position horizontale 	
		currentPiece.currentPieceRot=0;
		instancedPiece=currentPiece.create_piece();
		System.out.println("new piece =" + currentPiece.create_piece());
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

					if ((instancedPiece[currentPiece.getCurrentPieceRot()][count]>0) && (gridGame.grid[i][j] > 0)) {

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
						gridGame.grid[currentPiecePos[0]-1+i][currentPiecePos[1]+j]=instancedPiece[currentPiece.getCurrentPieceRot()][count];
					
					
				}
				count++;
			}
		
		


	}
		}
	}

	// Ici on met les actions de deplacements en fonction des restrictions


	
	
	public boolean goLeft(){

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
		
		if(rotationIsBlocked==true){
			
			return false;
		}
		
		currentPiece.rotate();
		return true;
		
	}
	
	public boolean goDown(){

		if(restricted.Down(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece)==true){
			currentPiecePos[0]++;
			return false;
		}
		
		currentPiece.down();
		return true;
	}

	public Scores getScore() {
		return score;
	}

	public void setScore(Scores score) {
		this.score = score;
	}

	public int getFullLines() {
		fullLines= LineOp.checkFullLines();
		return fullLines;
	}


}





