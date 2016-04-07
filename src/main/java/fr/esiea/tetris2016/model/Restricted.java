package fr.esiea.tetris2016.model;



public class Restricted {

	public Restricted(){
		

		
	}
	
	
	// vérifie si la position suivante de la rotation est possible ou pas
	public boolean Rotation(int [] currentPiecePos,int currentPieceRot, int [][] grid,int[][]currentPiece) {
		
		
	currentPieceRot++;

		int count=0; 

		for (int i=currentPiecePos[0]; i < currentPiecePos[0]+4; i++) {
			for (int j=currentPiecePos[1]; j < currentPiecePos[1]+4; j++) {
	

				if (currentPiece[currentPieceRot][count]!=0 
						&& currentPiecePos[1]+count%4+1 > Gameboard.SIZEX) { // Test que la partie non-vide de la piece ne soit pas en dehors du grid droit

					return true;
				}

				if (currentPiece[currentPieceRot][count]!=0 
						&& currentPiecePos[1]+count%4 < 0) {					// Test que la partie non-vide de la piece ne soit pas en dehors du grid gauche

					return true;
				}


				// Test contact en les pieces du board et la piece courante
				if (currentPiece[currentPieceRot][count]!=0 && 
						grid[currentPiecePos[0]+(count/4)][currentPiecePos[1]+(count%4)] != 0) { // Test que la partie non-vide de la piece ne se superpose pas avec une partie non vide du grid
					return true; 
				}

				count++;
			}

		}

		return false;

	}

	// Verifie que l'on est bloqué à droite ou pas

	public boolean  Right(int [] currentPiecePos, int currentPieceRot, int[][] grid, int[][]currentPiece) {
		
		int count=0;
		
		for (int i=currentPiecePos[0]; i < currentPiecePos[0]+4; i++) {
			for (int j=currentPiecePos[1]+1; j < currentPiecePos[1]+5; j++) {

				if (currentPiece[currentPieceRot][count]!=0 && grid[currentPiecePos[0]+(count/4)][currentPiecePos[1]+(count%4)+1]!=0) {
					return true; 
				}
				count++;
			}

		}	
		return false;
	}

	// Verifie que l'on est bloqué à gauche ou pas
	public  boolean Left(int [] currentPiecePos, int currentPieceRot, int[][] grid,int[][]currentPiece) {
		
		int count=0;
		
		for (int i=currentPiecePos[0]; i < currentPiecePos[0]+4; i++) {
			for (int j=currentPiecePos[1]-1; j < currentPiecePos[1]+3; j++) {

				if (currentPiece[currentPieceRot][count]>0 && grid[currentPiecePos[0]+(count/4)][currentPiecePos[1]-1+(count%4)] > 0) {
					return true; 
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
			
				if( (nextPos+i)>=16 && instancedPiece[currentPieceRot][count]!=0){
				
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
