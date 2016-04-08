package fr.esiea.tetris2016.model;



public class Restricted {

	public Restricted(){



	}


	// vérifie si la position suivante de la rotation est possible ou pas
	public boolean Rotation(int [] currentPiecePos,int currentPieceRot, int [][] grid,int[][]currentPiece) {
		int nextRot = (currentPieceRot +1)%4;

		int count=0; 

		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4; j++) {


				if (currentPiece[nextRot][count]!=0 ){
					if((currentPiecePos[1]+i+1) >=15) { // Test que la partie non-vide de la piece ne soit pas en dehors du grid droit
						return true;
					}
					if((currentPiecePos[1]+j-1)< 0){					// Test que la partie non-vide de la piece ne soit pas en dehors du grid gauche
						return true;
					}

				}


				// Test contact en les pieces du board et la piece courante
				if (currentPiece[nextRot][count]!=0 ){

					if(grid[currentPiecePos[0]+i][currentPiecePos[1]+j] != 0 || (currentPiecePos[1]+j)>9) { // Test que la partie non-vide de la piece ne se superpose pas avec une partie non vide du grid
						return true; 
					}
				}
				count++;
			}

		}

		return false; 

	}

	// Verifie que l'on est bloqué à droite ou pas

	public boolean  Right(int [] currentPiecePos, int currentPieceRot, int[][] grid, int[][]currentPiece) {
		int nextPos= currentPiecePos[1]+1;
		int count=0;

		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if(currentPiece[currentPieceRot][count]!=0){			

					if((nextPos+j) >=10){
						return true;
					}

					if(grid[currentPiecePos[0]+i][nextPos+j]!=0){
						return true; 
					}


				}
				count++;
			}

		}	
		return false;
	}

	// Verifie que l'on est bloqué à gauche ou pas
	public  boolean Left(int [] currentPiecePos, int currentPieceRot, int[][] grid,int[][]currentPiece) {

		int count=0;
		int nextPos= currentPiecePos[1]-1;
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				if (currentPiece[currentPieceRot][count]>0 ) {
					if(nextPos+j<0){

						return true;
					}

				}
				if (currentPiece[currentPieceRot][count]>0 ) {
					if( grid[currentPiecePos[0]+i][nextPos+j]>0){
						return true; 
					}
				}
				count++;
			}

		}	
		return false;
	}






	// Verifie que la piece peut descendre
	public boolean Down(int [] currentPiecePos, int currentPieceRot, int[][] grid,int[][] instancedPiece) {
		int nextPos= currentPiecePos[0]+1; // permet prédire a l'avance s'il y aura heurtage 
		int count=0;


		for (int i= 0; i <4; i++) {
			for (int j=0; j < 4; j++) {	

				if( ((nextPos+i)>=16 && instancedPiece[currentPieceRot][count]!=0 ) ){
					if((nextPos ==15)||( nextPos==14 && instancedPiece[currentPieceRot][13]==2)){ currentPiecePos[0]--;}
					return true; 

				}

				if(instancedPiece[currentPieceRot][count]!=0){
					if(  grid[nextPos+i][currentPiecePos[1]+j] != 0 ) {

						return true; 
					}
				}

				count++;
			}

		}
		return false;
	}








}
