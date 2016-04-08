### tetris2016

DONDIN Max
TA Nicolas
DEMAN Julien
_______________________________________

### Projet abandonné
Ce projet a connu deux architectures:
L'ancien projet se trouve ici : https://github.com/Forbzz/PourquoiTetriste 
(avec les commits de tous les membres)
Nous avions au début une classe façade Tetris n'était qu'un
menu permetant d'instancier une classe Game, Score ou de quitter le jeu.
Score servait à voir les top scores et Game lançait la Game loop.
Nous avions créé une classe abstraite Piece ainsi que d'autres classes pour chaque
Tetrimino qui héritait de Piece.
Nous avions aussi une classe PieceFactory qui encapsulait la création des pièces.

__________________________________

### Résumé du projet actuel (fini)
Plus tard en voulant implémenter la partie graphique au projet nous avons décidé de changer
d'architecture suite à des difficultés.

### Architecture
Nous avons suivi un pattern global MVC, avec notre classe main qui masque le controleur.
-Controller: fr.esiea.tetris2016.controller; instancie View et Model
-View: fr.esiea.tetris2016.view; se charge de tout ce que l'utilisateur voit (interface graphique, score, ..)
-Model: fr.esiea.tetris2016.model; reunit tout ce qui n'est pas visible par l'utilisateur mais dont le controlleur a besoin pour utiliser ses objets, fonctions et affichages.



 ##Les 3 design paterns sont: 

- Facade , dans le "main.java", qui permet de masquer le controleur qui agit un peu comme le vrai "main"
- Singleton, qui permet de recycler un tetromino en la ré-instanciant lorsque la précédante est déjà ancrée dans le jeu
- Listener, contenu dans controller.java, permet d'interpreter l'utilisation du clavier dans le programme Java

Nous avons tenté de toujours respecter les normes d'appellations de packages, classes, méthodes, et constantes.


### Instruction
1- Si ce n'est pas déjà fait, télécharger le fichier [Tetris2016.jar](https://github.com/Forbzz/tetris2016/blob/master/Tetris2016.jar) (visible sur ce github) clic droit > enregistrer sous
2- Sur Linux: se placer dans le repertoire où se trouve Tetris2016.jar et executer la commande:
```
jar -xvf Tetris2016.jar
```
(pour extraire le contenu, dont le fichier score.txt)
Puis
```
java -jar Tetris2016.jar
```

2 - Sur Windows: Clic droit sur Tetris2016.jar > Extraire tout ici (soyez sûr d'être dans un bon dossier pour extraire) > double cliquez sur Tetris2016.jar

pour executer le fichier
### FEATURES
- Jouable au clavier 
- Interface graphique 
- Score affiché qui évolue en direct
- Highscores! <--- Lecture et écriture dans un fichier texte + affichage en fin de partie
- Tentative d'approche TDD avec les librairies Mockito, JUnit..
- 7 pieces tetromino
- Grande importance attaché au découpage du code par fonctionnalité, et de la conception des objets
- Prise en compte des restrictions de mouvement de la pièce
- Les lignes peuvent être détruites

- features non incorporées: Le jeu multijoueur

### Comment jouer
- Touche HAUT : Tourne la piece
- Touche BAS  : Fais descendre la piece
- Touche GAUCHE/DROITE : Déplace la pièce gauche/Droite

### Les tests
Ce projet maven incorpore les différents tests suggérés par Maxence Labusquiere : https://github.com/MLabusquiere/TP_4A_ESIEA_Tetris
Mais on ne sait pas les utiliser.
