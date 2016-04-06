package fr.esiea.tetris2016.model;






public class Model {
	

	private Pieces currentPiece;	
	private Scores score;
	private LineOp fullLineGet;
	private int fullLines;
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


		
//		fullLines = fullLineGet.checkFullLines();
		gridGame = new Gameboard();
		score = new Scores();
		fullLineGet = new LineOp();
		currentPiece = Pieces.getClone();	
		
		currentPiecePos= currentPiece.getCurrentPiecePos();
		System.out.println("test2:" +  currentPiecePos[1]);
		this.newPiece();


		gridGame.initArray();
		instancedPiece= currentPiece.pieceChoice;
	
		pieceIsBlocked = restricted.Down(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);
		rotationIsBlocked = restricted.Rotation(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);
		leftIsBlocked = restricted.Left(currentPiecePos, currentPiece.getCurrentPieceRot(), gridGame.grid , instancedPiece);

	}

	public Pieces getPiece(){
		return this.currentPiece;

	}

	public Gameboard getGrid(){
		return this.gridGame;
	}


	public void newPiece() {
		System.out.println("test:" +  currentPiece.getCurrentPieceRot());
		this.currentPiece.create_piece();
		this.currentPiecePos[0]=0; // Position verticale
		this.currentPiecePos[1]=3; // Position horizontale 
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
		for (int i=currentPiecePos[0]; i < currentPiecePos[0]+4; i++) {
			for (int j=currentPiecePos[1]; j < currentPiecePos[1]+4; j++) {
				if (count < 16) {
					if (instancedPiece[currentPiece.getCurrentPieceRot()][count]>0) {
						gridGame.grid[i][j]=instancedPiece[currentPiece.getCurrentPieceRot()][count];
					}
				}
				count++;
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
		
		if(pieceIsBlocked==true){
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
		return fullLines;
	}


}





