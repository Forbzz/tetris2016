package fr.esiea.tetris2016.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class View extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScoreShow score;
	private GameShow grid;
	private ScoreShow ladder;

	public View(){


		setTitle( "Tetris 2016 - Ta, Dondin, Deman");		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setSize(450, 500);




		ladder = new ScoreShow();
		add(ladder,BorderLayout.CENTER);

		score = new ScoreShow();
		add(score, BorderLayout.CENTER);

		grid = new GameShow();
		add(grid, BorderLayout.EAST);


		setFocusable(true);
		setVisible(true);

	}



	public GameShow getGrid() {
		return this.grid;
	}

	public void showGrid(int [][] board, int[][] instancedPiece, int [] currentPiecePos, int currentPieceRot) {
		grid.addColorBackground(board);
		grid.addColorPieces(board, instancedPiece, currentPiecePos, currentPieceRot);

	}

	public void refreshScore(int newScore) {
		score.actualScore(newScore);
	}

	public void showScore(int finalScore, int [] scoreArray) {
		score.showEnd(finalScore, scoreArray);		
	}



}
