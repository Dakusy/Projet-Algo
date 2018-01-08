import extensions.CSVFile;
import extensions.Image;
import extensions.RGBColor;


class JeuDeCalculMental extends Program {
    
    //Calcul les differents operandes.
    int operande(){
	int nombre=(int)(random()*25);
	return nombre;
    }
    
    
    //Fonction permettant d'initialiser le jeu. 
    int[][] initialiser(int operande1, int operande2){
	int[][] tab=new int[3][3];
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=operande();
	    }
	}
	tab[(int)(random()*length(tab,1))][(int)(random()*length(tab,2))]=operande1 + operande2;
	return tab;
    }

    //Test l'Affichage des additions.
    void testAffichageAdd(){
	assertEquals("2 + 5", affichageAdd(2,5));
    }
    
    //Affiche les additions dans le jeu.
    String affichageAdd(int operande1, int operande2){
	String res=operande1 + " + " + operande2;
	return res;
    }
    
    //Test l'Affichage des soustractions.
    void testAffichageSou(){
	assertEquals("2 - 5", affichageSou(2,5));
    }
    
    //Affiche les soustractions dans le jeu.
    String affichageSou(int operande1, int operande2){
	String res=operande1 + " - " + operande2;
	return res;
    }
    
    //Test l'Affichage des multiplications.
    void testAffichageMul(){
	assertEquals("2 * 5", affichageMul(2,5));
    }
    
    //Affiche les multiplications dans le jeu.
    String affichageMul(int operande1, int operande2){
	String res=operande1 + " * " + operande2;
	return res;
    }

    //Test l'affichage du tableau d'entier.
    void testAffichageTableau(){
	int[][] tab = new int[][]{
	    {1,2,3},
	    {4,5,6},
	    {7,8,9}
	};
	assertEquals(" 1 2 3\n 4 5 6\n 7 8 9\n",affichageTableau(tab));
    }
    
    //Affiche le tableau en chaine de caractere.
    String affichageTableau(int[][] tab){
	String res="";
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		res+=" " + tab[i][j];
	    }
	    res+="\n";
	}
	return res;
    }
    
    //Test la fonction saisie
    void testSaisie(){
	int[][] tab = new int[][]{
	    {10,25,3},
	    {42,5,76},
	    {12,89,100}
	};
	assertTrue(saisie(1,2,tab));
	assertTrue(saisie(2,0,tab));
	assertFalse(saisie(3,4,tab));
    }
   
    //Verifie que la saisie des coordonnees soit dans le tableau.
    boolean saisie(int a, int b, int[][] tab){
	boolean res=false;
	if(a<=length(tab,1) && b<=length(tab,2)){
	    res=true;
	}
	return res;
    }
    
    //Test la fonction bonneReponse.
    void testBonneReponse(){
	int[][] tab = new int[][]{
	    {10,25,3},
	    {42,5,76},
	    {12,89,100}
	};
	assertEquals(true, bonneReponse(1,2,tab,50,26));
    }
       
    //Verifie que l'entier selectionner dans le tableau soit le resultat des 2 operandes.
    boolean bonneReponse(int l, int c, int[][] tab, int operande1, int operande2){
	boolean res=false;
	if(tab[l][c]==operande1+operande2){
	    res=true;
	}
	return res;
    }
    
    void algorithm(){
	
	int choix=0;
	println("Bienvenue sur le jeu du Calcul Mental !");
	println();
	println("1.Jouer");
	println("2.Score");
	println("3.Quitter");
	println();
	print("Choisissez votre option : ");
	choix = readInt();
	if(choix == 1) {
	    println("Vous avez choisi jouer !");
	    println();
	    println("4.CE1/CE2");
	    println("5.CM1/CM2");
	    println();
	    print("Quel est votre niveau ? : ");
	    choix = readInt();
	    if(choix == 4) {
		println("Vous avez choisi CE1/CE2 Bonne chance !");
		int note=0;
		for (int tours=0; tours<=5; tours++) {
		    int operande1=operande();
		    int operande2=operande();
		    int[][] plateau=initialiser(operande1, operande2);
		    println(); //Saut d'une ligne.	
		    println("Combien font: " + affichageAdd(operande1, operande2));
		    println();
		    println(affichageTableau(plateau));
		    println("Veuillez saisir un indice de ligne: ");
		    int l=readInt();
		    println("Veuillez saisir un indice de colonne: ");
		    int c=readInt();
		    while(saisie(l,c,plateau)!=true){
			println("Veuillez saisir un indice de ligne correct: ");
			l=readInt();
			println("Veuillez saisir un indice de colonne correct: ");
			c=readInt();
		    }
		    if(bonneReponse(l, c, plateau, operande1, operande2)==true) {
			println();
			println("Bravo, tu as trouve le bon resultat :) ");
			note++;
		    }
		    else {
			println();
			println("Dommage, ce n'est pas le non resultat :( ");
		    }
		}
		println();
		println("Tu as obtenu la note de : " + (note) + "/10");
		if(note==0){
		    println("AH !!!!!!!!!!!!!!!");
		}
		else if(note>0 && note<5){
		    println("");
		}
		else if(note==5){
		    println("");
		}
		else if(note>5 && note <10){
		    println("");
		}
		else if(note==10){
		    println("");
		}
		println();
	    }
	    else if ( choix == 5) {
		println("Vous avez choisi CM1/CM2");
	    }
	    else if( choix == 2) {
		println("Vous avez choisi score !");
	    }
	    else if( choix == 3) {
		println("Vous avez choisi quitter le jeu !");
		return;	
	    }
	}
    }
}

