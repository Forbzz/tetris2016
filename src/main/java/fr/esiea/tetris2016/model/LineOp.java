package fr.esiea.tetris2016.model;




//Cette classe va effectuer toutes les opérations concernant les lignes: vérifications de lignes pleines, suppressions de lignes, descente des lignes du tableau.
public class LineOp extends Gameboard{

	int sizeX= Gameboard.SIZEX;
	int sizeY= Gameboard.SIZEY;
	private static int fullLines;



	public LineOp(){


		fullLines =0;
	}


	/////////////////////////////////////////////////	/////////////////////////////////////////////////	/////////////////////////////////////////////////	//////////////////////////////////////

	public static void deleteFullLines(int firstLineToClean,int fullLinesToClean, int [][] grid){

		int endLineToClean= firstLineToClean- fullLinesToClean +1 ;  //  Derniere ligne a supprimer. Le "+1" est nécessaire sinon on on supprime aussi la ligne d'au dessus

		for(int line=firstLineToClean; line >= endLineToClean; line--){

			for(int column=9; column >=0; column--){

				grid[line][column]= 0;

			}

		}

		makeTheUpperLinesFall(endLineToClean, fullLinesToClean, grid); // On prend directement en parametre la premiere ligne a faire tomber, et la hauteur de la chute pour toutes les lignes supérieures



	}



	/////////////////////////////////////////////////	/////////////////////////////////////////////////	/////////////////////////////////////////////////	//////////////////////////////////////




	// makeTheUpperLinesFall copie les blocs de la ligne x, vers la ligne x + (nb de lignes supprimées), sauf si la ligne est tout en haut auquel cas on la supprime simplement
	public static void makeTheUpperLinesFall(int firstLine, int heightFall, int [][] grid){

		if(firstLine!=0){

			firstLine--;

			for(int line=firstLine; line >= 0; line--){

				for(int column=9; column >=0; column--){

					grid[line+heightFall][column]= grid[line][column];

				}

			}
		}

		for(int column=9; column >= 0; column--){

			grid[0][column]=0;


		}






	}


	public static  int checkFullLines() {
		fullLines=0;
		int firstLineToClean=15;             	// Enregistre la premiere ligne a supprimer, a reutiliser dans la fonction de suppression
		// Compte le nombre de lignes pleines à partir de la premiere ligne pleine
		boolean isFirstLineToClean=true;        // Verifie que c'est bien la premiere ligne a supprimer
		boolean isLineComplete= true;
		for(int line=15; line >= 0; line--){

			isLineComplete= true;
			for(int column=9; column >=0; column--){

				if(grid[line][column]==0){
					isLineComplete=false;

				}

			}

			if(isFirstLineToClean==true && isLineComplete==true){


				firstLineToClean=line;
				isFirstLineToClean=false;

			}

			if(isLineComplete){
				fullLines++;	

			}



		}
		deleteFullLines(firstLineToClean,fullLines, grid);
		return fullLines;  // Pour pouvoir faire des opérations avec le score

	}

}
