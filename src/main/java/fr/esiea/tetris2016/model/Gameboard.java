package fr.esiea.tetris2016.model;

public class Gameboard {



	public final static  int SIZEX=10;
	public final static int SIZEY=16;
	public static int[][] grid;
	public int fullLines;

	public Gameboard(){
		grid = new int[16][10];
	}

	public void initArray(){

		for (int y = 0; y < SIZEY; y++){

			for (int x = 0; x < SIZEX; x++) {

				grid[y][x] = 0;

			}
		}

	}

}
