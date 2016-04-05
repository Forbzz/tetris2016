package fr.esiea.tetris2016.model;






public class Model {

	private Pieces currentPiece;	
	private Gameboard grid;
	private int[] instancedPiece;






	public Model() {

		grid = new Gameboard();
		this.newPiece();
		currentPiece = Pieces.getClone();
		grid.initArray();
		instancedPiece= currentPiece.pieceShape;
	}

	public Pieces getPiece(){
		return this.currentPiece;

	}

	public Gameboard getGrid(){


		return this.grid;
	}


	private void newPiece() {

		currentPiece.create_piece();
		instancedPiece[0]=0; // Position verticale
		instancedPiece[1]=3; // Position horizontale 
	}




 // Verifie si la piece créé entre déjà en collision = defaite
	public boolean isGameEnded() {


		int count=0;		
		for (int i=instancedPiece[0]; i < instancedPiece[0]+4; i++) {

			for (int j=instancedPiece[1]; j <instancedPiece[1]+4; j++) {

				if (count < 16) {

					if (currentPiece.pieceChoice[currentPiece.getCurrentPieceRot()][count]>0 && Gameboard.grid[i][j] > 0) {

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
		for (int i=instancedPiece[0]; i < instancedPiece[0]+4; i++) {
			for (int j=instancedPiece[1]; j < instancedPiece[1]+4; j++) {
				if (count < 16) {
					if (currentPiece.pieceChoice[currentPiece.getCurrentPieceRot()][count]>0) {
						Gameboard.grid[i][j]=currentPiece.pieceChoice[currentPiece.getCurrentPieceRot()][count];
					}
				}
				count++;
			}
		}

	}

		
		
	
	

}