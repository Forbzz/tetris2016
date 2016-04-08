package fr.esiea.tetris2016.view;

import java.awt.Dimension;
import java.awt.GridLayout;



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

	private JLabel rank_one;
	private JLabel rank_two;
	private JLabel rank_three;
	private JLabel rank_four;
	private JLabel rank_five;

	public ScoreShow(){

		GridLayout layout = new GridLayout(8,1);
		setLayout(layout);
		this.title = new JLabel("Good Luck!", SwingConstants.CENTER);
		this.currentScore = new JLabel("Score: 0", SwingConstants.CENTER);
		this.ladder = new JLabel(" ", SwingConstants.CENTER);
		this.rank_one = new JLabel(" ", SwingConstants.CENTER);
		this.rank_two = new JLabel(" ", SwingConstants.CENTER);
		this.rank_three = new JLabel(" ", SwingConstants.CENTER);
		this.rank_four = new JLabel(" ", SwingConstants.CENTER);
		this.rank_five = new JLabel(" ", SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(40000,1000));
		currentScore.setPreferredSize(new Dimension(150,10));

		add(title);
		add(currentScore);	
		add(ladder).setPreferredSize(new Dimension(300,10));		
		add(rank_one).setPreferredSize(new Dimension(400,10));
		add(rank_two).setPreferredSize(new Dimension(150,10));
		add(rank_three).setPreferredSize(new Dimension(150,10));
		add(rank_four).setPreferredSize(new Dimension(150,10));
		add(rank_five).setPreferredSize(new Dimension(150,10));




	}


	public void actualScore(int score){


		currentScore.setText("Score: "+score);

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
		String Newline=System.getProperty("line.separator"); 
		System.out.println( "highscore");

		title.setText("PERDU");
		currentScore.setText("Score: "+score);

		title.setVisible(false);
		title.setVisible(true);

		currentScore.setVisible(false);
		currentScore.setVisible(true);;

		ladder.setText("HIGHSCORE" + Newline);
		rank_one.setText("1: " +scoreArray[0] + Newline);
		rank_two.setText("2: "+scoreArray[1]);
		rank_three.setText("3: "+scoreArray[2]);
		rank_four.setText("4: "+scoreArray[3]);
		rank_five.setText("5: "+scoreArray[4]);

	}


}
