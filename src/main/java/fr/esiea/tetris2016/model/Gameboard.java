package fr.esiea.tetris2016.model;

public class Gameboard {

	
	
	
	public final static int SIZEX=10,SIZEY=16;
	public static int[][] grid;
	
	public Gameboard(){
		
		grid = new int[SIZEY][SIZEX];
	}
	
	public void initArray(){
		
		for (int y = 0; y < SIZEY; y++){
			
			for (int x = 0; x < SIZEX; x++) {
				
				grid[y][x] = 0;
			}
		}
		
	}
	
}
