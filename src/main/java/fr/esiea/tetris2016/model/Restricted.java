package fr.esiea.tetris2016.model;



public class Restricted {

	private boolean restricted;
	
	public Restricted(){
		
		this.setRestricted(true);
		
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

	public static boolean  Right(int [] currentPiecePos, int currentPieceRot, int[][] grid, int[][]currentPiece) {
		
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
	public boolean Down(int [] currentPiecePos, int currentPieceRot, int[][] grid,int[][]currentPiece) {
		
		System.out.println("test une fois si on peut descendre" + currentPiecePos[0] + currentPiecePos[1]  );
		int count=0;
		
		// test que la ligne du bas est rempli ou pas
		for (int i= 0; i <4; i++) {
			for (int j=0; j < 4; j++) {	
				
				if( currentPiecePos[0]+1>=15){
					System.out.println("On atteint le bas");
					return true;
				}
				if((currentPiecePos[0]+i)<16){
				System.out.println("La prochaine valeur de la piece est " + currentPiece[currentPieceRot][count]  
						+ " et la grille :"+ (grid[currentPiecePos[0]+i][currentPiecePos[1]+j]) + " en position=" + currentPiecePos[0]+ currentPiecePos[1]+ "avec i=" +(currentPiecePos[0]+i )+"et j="+(currentPiecePos[1]+j));
				}
				if (currentPiece[currentPieceRot][count]!=0 && (grid[currentPiecePos[0]+i][currentPiecePos[1]+j] != 0 ) ) {
					System.out.println("on rencontre une piece en dessous" + currentPiece[currentPieceRot][count]  
							+ " de valeur :"+ (grid[currentPiecePos[0]+i][currentPiecePos[1]+j]) + " en position=" + (currentPiecePos[0]+i)+ (currentPiecePos[1]+j)+ "avec i=" +(currentPiecePos[0]+i )+"et j="+(currentPiecePos[1]+j));
					return true; 
				}
			
			System.out.println("verifie:" +currentPiecePos[0] + (currentPiecePos[1]));
				count++;
			}

		}
	
		return false;
	}


	public boolean isRestricted() {
		return restricted;
	}


	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}






}
