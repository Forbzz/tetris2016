package fr.esiea.tetris2016.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scores {

	static FileWriter fw;
	static FileReader fr;
	static File ladder = new File("src/scores.txt");

	private static int[] scoreArray;
	private static int[] newScoreArray;
	private int score;
	public Scores() throws IOException
	{
		this.score = 0;

	}

	public void increaseScore(int lineCleared, int combo)
	{

		this.score += (10 * lineCleared);
		if(combo==2){ this.score *= 2; }
		if(combo==3){ this.score *=3;}
		if(combo>=4){ this.score *=4;} 
	}



	public int getScore(){
		return this.score;
	}



	public static int[] readScore() throws IOException {
		//Lecture des scores
		fr = new FileReader(ladder);
		BufferedReader br = new BufferedReader(fr); 
		Scanner scan = new Scanner(ladder);

		int[] fiveBestScore= new int [5];


		//Lecture des données        

		int i= 0;
		while((br.readLine()) != null && i <5) {

			// On stocke la valeur recupérée dans un tableau


			fiveBestScore[i]= scan.nextInt();


			i++;

		}
		scan.close();
		br.close();
		fr.close();


		// Retourne les 5 scores représentant les meilleurs.
		return fiveBestScore;
	}


	public static void writeScore(File filename, int[]x) throws IOException{
		String Newline=System.getProperty("line.separator"); 
		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < x.length; i++) {
		
			outputWriter.write(x[i]+Newline);
			
		}

		for(int i=0; i< x.length; i++){


		}
		outputWriter.flush();  
		outputWriter.close();  
	}



	public void setScoreEndGame() throws IOException {

		boolean changeLadder= false;
		scoreArray=readScore();
		newScoreArray=readScore();
		for(int i =0; i<5; i++){

		}




		// permet de remplir avec nouveau classement
		int i = 0;

		while(i<5){

			if (changeLadder == false) {
				newScoreArray[i]= scoreArray[i];		

			}
			if (changeLadder == false && this.score > scoreArray[i]) {

				newScoreArray[i]= score;

				for(int j =0; j<5; j++){

				}

				i++;
				changeLadder= true;
			}
			if(changeLadder==true){

				newScoreArray[i] = scoreArray[i-1]; 

			}
			i++;

		}


		for ( i=0; i<5 ; i ++){

			scoreArray[i]= newScoreArray[i];
		}

		writeScore(ladder,scoreArray);

	}

	public int[] getLadder() throws IOException {
		setScoreEndGame();
		writeScore(ladder, scoreArray);
		return scoreArray;
	}

}





