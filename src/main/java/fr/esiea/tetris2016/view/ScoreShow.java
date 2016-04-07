package fr.esiea.tetris2016.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ScoreShow extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel currentScore;
	private JLabel title;
	private JLabel ladder;
	public ScoreShow(){
		
		GridLayout layout = new GridLayout(4,1);
		setLayout(layout);
		this.title = new JLabel("SCORE", SwingConstants.CENTER);
		this.currentScore = new JLabel("0", SwingConstants.CENTER);
		this.ladder = new JLabel("ranking", SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(150,30));
		currentScore.setPreferredSize(new Dimension(100,30));
		add(title);
		add(currentScore);	
		
		
		
	}


	public void actualScore(int score){

		
		currentScore.setText(Integer.toString(score));
		
		currentScore.setVisible(false);
		currentScore.setVisible(true);
	}
	
	public String getCurrentScore(){
		
		return currentScore.getText();
	}
	
	public String getTitle(){
		return title.getText();
	}
	
	public String getLadder(){
		
		return ladder.getText();
	}
	
	public void showEnd(int score, int [] scoreArray){
	
		System.out.println("Score dans showend= " + score);
		title.setText("YOU LOST");
		currentScore.setText("Your score is: "+Integer.toString(score));
		
		title.setVisible(false);
		title.setVisible(true);
		
		currentScore.setVisible(false);
		currentScore.setVisible(true);;
		
		ladder.setText("HIGHSCORE:" +Arrays.toString(scoreArray));
		
		
	}
	
	
}
