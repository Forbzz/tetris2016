package fr.esiea.tetris2016.model;

import java.util.Random;


public class Pieces {
	private static int randNb=0;
	private static Random random;
	public static int[] currentPiecePos= {0,3};
	public static int currentPieceRot =0;

	
	// Definition des pieces. Chaque chiffre correspond à une couleur
	static int[][] T = { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
	static int[][] I = { {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},{0,2,0,0,0,2,0,0,0,2,0,0,0,2,0,0},{2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0} };
	static int[][] Z = { {0,0,3,0,0,3,3,0,0,3,0,0,0,0,0,0},{0,0,0,0,0,3,3,0,0,0,3,3,0,0,0,0},{0,0,3,0,0,3,3,0,0,3,0,0,0,0,0,0},{0,0,0,0,0,3,3,0,0,0,3,3,0,0,0,0} };
	static int[][] O = { {0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0},{0,4,4,0,0,4,4,0,0,0,0,0,0,0,0,0} };
	static int[][] S = { {0,5,0,0,0,5,5,0,0,0,5,0,0,0,0,0},{0,0,0,0,0,0,5,5,0,5,5,0,0,0,0,0},{0,5,0,0,0,5,5,0,0,0,5,0,0,0,0,0},{0,0,0,0,0,0,5,5,0,5,5,0,0,0,0,0} };
	static int[][] J = { {0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},{0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},{0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},{0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0} };
	static int[][] L = { {0,7,0,0,0,7,0,0,0,7,7,0,0,0,0,0},{0,0,0,0,0,0,0,7,0,7,7,7,0,0,0,0},{0,7,7,0,0,0,7,0,0,0,7,0,0,0,0,0},{0,0,0,0,0,7,7,7,0,7,0,0,0,0,0,0} };


	
	private static Pieces copy = new Pieces();

	
	

	
	public static Pieces getClone() {
		return copy;
	}
	
	
	private Pieces() {
		random = new Random();
	}
	
	public static int[][] create_piece() {

		randNb = random.nextInt(7);
		
		
       switch (randNb) {
		case 1:
			return T;		
		case 2:
			return I;
		case 3:
			return Z;
		case 4:
			return O;
		case 5:
			return S;
		case 6:
			return J;
		case 7:
			return L;
			
		default: return null;
		}
	}
	
	public void rotate() {
		
	
		Pieces.currentPieceRot  = (currentPieceRot+1)%4;
		
		Pieces.currentPiecePos = create_piece()[currentPieceRot];
	}
	
	public void left() {
		Pieces.currentPiecePos[1]--;
	}
	
	public void right() {
		Pieces.currentPiecePos[1]++;
	}
	
	public void down() {
		Pieces.currentPiecePos[0]++;
	}

}
