package fr.esiea.tetris2016.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GameShow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[][] grid;
	private Color[] color;

	public GameShow(){

		GridLayout layout = new GridLayout(16,10);
		setLayout(layout);

		//initialisation des 8 couleurs
		color= new Color[8];
		this.assignColor();

		//Construction de la grille
		grid= new JPanel[16][10];
		this.buildGrid();



	}
	public JPanel[][] getGrid(){

		return this.grid;
	}



	public Color getColor(int nb){

		return color[nb];
	}

	public void assignColor(){
		// Couleurs inspirés de "Tetris Friend"
		color[0] = Color.black; // background
		color[1] = Color.magenta; //T
		color[2] = Color.cyan; // I
		color[3] = Color.red; //Z
		color[4] = Color.yellow; // O
		color[5] = Color.green; //S
		color[6] = Color.blue; //J
		color[7] = Color.orange; //L




	}

	public void buildGrid(){

		Dimension cellSize = new Dimension(35,35);

		for( int i = 0; i < 16; i++){

			for (int j = 0; j < 10 ; j++){

				grid[i][j] = new JPanel();
				grid[i][j].setPreferredSize(cellSize);
				grid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				add(grid[i][j]);
			}

		}


	}

	// met une couleur à tout ce qui est statique (background et pieces ancrées)
	public void addColorBackground(int [][] grid){ 

		int nbCell=0; //numéro de la cellule

		for (int i = 0; i<16; i++) {
			for (int j = 0; j<10; j++) {
				nbCell = grid[i][j];
				this.grid[i][j].setBackground(color[nbCell]);
			}
		}

	}


	public void addColorPieces( int [][] grid, int [][] instancedPiece, int[] currentPiecePos, int currentPieceRot){


		int nbCell = 0;
		int count=0;
		for (int i=0; i < 4; i++) {
			for (int j=0; j < 4; j++) {
				nbCell= instancedPiece[currentPieceRot][count];
				if (nbCell!=0  && currentPiecePos[0]+i<=15) {
					this.grid[currentPiecePos[0]+i][currentPiecePos[1]+j].setBackground(color[nbCell]);
				}


				count++;
			}

		}
	}
}



