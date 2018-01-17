class JeuDeCalculMental extends Program {
    
    //Choisit les differents operandes.
    int operande(){
	int nombre=(int)(random()*25);
	return nombre;
    }

    //Choisit les differents operandes pour les multiplications.
    int operandeMul(){
	int nombre=(int)(random()*10);
	return nombre;
    }
    
    //Fonction permettant d'initialiser le jeu pour les additions. 
    int[][] initialiserAdd(int operande1, int operande2){
	int[][] tab=new int[3][3];
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=operande();
	    }
	}
	tab[(int)(random()*length(tab,1))][(int)(random()*length(tab,2))]=operande1 + operande2;
	return tab;
    }

    //Fonction permettant d'initialiser le jeu pour les soustractions. 
    int[][] initialiserSou(int operande1, int operande2){
	int[][] tab=new int[3][3];
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=operande();
	    }
	}
	tab[(int)(random()*length(tab,1))][(int)(random()*length(tab,2))]=operande1 - operande2;
	return tab;
    }

    //Fonction permettant d'initialiser le jeu pour les multiplications. 
    int[][] initialiserMul(int operande1, int operande2){
	int[][] tab=new int[3][3];
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=(int)(random()*100);
	    }
	}
	tab[(int)(random()*length(tab,1))][(int)(random()*length(tab,2))]=operande1 * operande2;
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
	assertTrue(saisie(1,tab));
	assertTrue(saisie(2,tab));
	assertFalse(saisie(3,tab));
    }
   
    //Verifie que la saisie d'une coordonnee soit dans le tableau.
    boolean saisie(int a, int[][] tab){
	boolean res=false;
	if(a<=length(tab,1)-1){
	    res=true;
	}
	return res;
    }
    
    //Test la fonction bonneReponse pour les additions.
    void testBonneReponseAdd(){
	int[][] tab = new int[][]{
	    {10,25,3},
	    {42,5,76},
	    {12,89,100}
	};
	assertEquals(true, bonneReponseAdd(1,2,tab,50,26));
    }
       
    //Verifie que l'entier selectionner dans le tableau soit le resultat de l'addition des 2 operandes.
    boolean bonneReponseAdd(int l, int c, int[][] tab, int operande1, int operande2){
	boolean res=false;
	if(tab[l][c]==operande1+operande2){
	    res=true;
	}
	return res;
    }

    //Test la fonction bonneReponse pour les soustractions.
    void testBonneReponseSou(){
	int[][] tab = new int[][]{
	    {10,25,3},
	    {42,5,76},
	    {12,89,100}
	};
	assertEquals(true, bonneReponseSou(1,1,tab,50,45));
    }
       
    //Verifie que l'entier selectionner dans le tableau soit le resultat de la soustraction des 2 operandes.
    boolean bonneReponseSou(int l, int c, int[][] tab, int operande1, int operande2){
	boolean res=false;
	if(tab[l][c]==operande1-operande2){
	    res=true;
	}
	return res;
    }

    //Test la fonction bonneReponse pour les soustractions.
    void testBonneReponseMul(){
	int[][] tab = new int[][]{
	    {10,2,3},
	    {4,5,7},
	    {6,9,1}
	};
	assertEquals(true, bonneReponseMul(0,0,tab,1,10));
    }
       
    //Verifie que l'entier selectionner dans le tableau soit le resultat de la soustraction des 2 operandes.
    boolean bonneReponseMul(int l, int c, int[][] tab, int operande1, int operande2){
	boolean res=false;
	if(tab[l][c]==operande1*operande2){
	    res=true;
	}
	return res;
    }

    //Affiche un commentaire en fonction de la note ainsi que de la musique.
    void commentaire(int note){
	if(note==0){
		playSound("./ressources/AH.mp3");
		delay(1000);
	    println("AH !!!!!!!!!!!!!!!");
	}
	else if(note>0 && note<5){
		playSound("./ressources/Nein.mp3");
		delay(31000);
	    println("NEIN NEIN NEIN NEIN NEIN !!!!!!!! ");
	}
	else if(note==5){
		playSound("./ressources/BRUH.mp3");
		delay(1000);
	    println("BRUHH !!!!");
	}
	else if(note>5 && note <10){
		playSound("./ressources/DoIt.mp3");
		delay(4000);
	    println("JUST DO IT !!!!! MAKE YOUR DREAM COME TRUE !!!!!");
		
	}
	else if(note==10){
		playSound("ressources/ingenieur.mp3");
		delay(7000);
	    println("Vous etes ingenieur informaticien");
	}
	println();
    }
        
    //Verifie que la chaine de caractere soit un chiffre
    boolean isDigit(String res){
    	boolean digit=false;
    	char[]tab=new char []{'0','1','2','3','4','5','6','7','8','9'};
    	if(length(res)==1){
    		for(int i=0;i<length(res);i++){
    			int j=0;
    			while(j<length(tab) && !digit){
    			    if(charAt(res,i)==tab[j]){
    				    digit=true;
    				}
    			    else {
    				j++;
    			    }
    			}
    		}
    	}
    	else{
    		digit=false;
    	}
    	return digit;
    }
     
    //Convertit le nombre exprime sous la forme d'une chaine de caractere en un entier.
    int entierEnChaineVersEntierEnInt(String nombre) {
        return stringToInt(nombre);
    }
    
    //Niveau des CE1 et CE2.
    void niveauCe(){
  	   	long debut=getTime();
    	int note=0;
    	for (int tours=0; tours<10; tours++) {
    	if(tours<5) {
		int operande1=operande();
		int operande2=operande();
		int[][] plateau=initialiserAdd(operande1, operande2);
		println(); //Saut d'une ligne.	
		println("Combien font: " + affichageAdd(operande1, operande2));
		println();
		println(affichageTableau(plateau));
		println("Veuillez saisir un indice de ligne: ");
		String ligne=readString();
		while(isDigit(ligne)!=true || saisie(entierEnChaineVersEntierEnInt(ligne), plateau)!=true){
		    println("Veuillez saisir un indice de ligne correct: ");
		    ligne=readString();
		}
		println("Veuillez saisir un indice de colonne: ");
		String colonne=readString();
		while(isDigit(colonne)!=true || saisie(entierEnChaineVersEntierEnInt(colonne), plateau)!=true){
			println("Veuillez saisir un indice de colonne correct: ");
		    colonne=readString();
		}
		int l=entierEnChaineVersEntierEnInt(ligne);
		int c=entierEnChaineVersEntierEnInt(colonne);
		if(bonneReponseAdd(l, c, plateau, operande1, operande2)==true) {
		    println();
		    println("Bravo, vous avez trouve le bon resultat :) ");
		    note++;
		}
		else  {
		    println();
		    println("Dommage, ce n'est pas le non resultat :( ");
		}
	    }
	    else {
		int operande1=operande();
		int operande2=operande();
		while (operande1<operande2){
		    operande1=operande();
		    operande2=operande();
		}
		int[][] plateau=initialiserSou(operande1, operande2);
		println(); //Saut d'une ligne.	
		println("Combien font: " + affichageSou(operande1, operande2));
		println();
		println(affichageTableau(plateau));
		println("Veuillez saisir un indice de ligne: ");
		String ligne=readString();
		while(isDigit(ligne)!=true || saisie(entierEnChaineVersEntierEnInt(ligne), plateau)!=true){
		    println("Veuillez saisir un indice de ligne correct: ");
		    ligne=readString();
		}
		println("Veuillez saisir un indice de colonne: ");
		String colonne=readString();
		while(isDigit(colonne)!=true || saisie(entierEnChaineVersEntierEnInt(colonne), plateau)!=true){
			println("Veuillez saisir un indice de colonne correct: ");
		    colonne=readString();
		}
		int l=entierEnChaineVersEntierEnInt(ligne);
		int c=entierEnChaineVersEntierEnInt(colonne);
		if(bonneReponseSou(l, c, plateau, operande1, operande2)==true) {
		    println();
		    println("Bravo, vous avez trouve le bon resultat :) ");
		    note++;
		}
		else  {
		    println();
		    println("Dommage, ce n'est pas le non resultat :( ");
		}
	    }	
	}
    long fin=getTime();
	println();
	println("Vous avez obtenu la note de : " + (note) + "/10");
	println("Vous avez mis " + ((fin-debut)/1000) + " secondes.");
	println();
	commentaire(note);
    }

  	//Niveau des CM1 et CM2.
    void niveauCm(){
	long debut=getTime();
	int note=0;
	for (int tours=0; tours<10; tours++) {
	    int operande1=operandeMul();
	    int operande2=operandeMul();
	    int[][] plateau=initialiserMul(operande1, operande2);
	    println();	
	    println("Combien font: " + affichageMul(operande1, operande2));
	    println();
	    println(affichageTableau(plateau));
		println("Veuillez saisir un indice de ligne: ");
		String ligne=readString();
		while(isDigit(ligne)!=true || saisie(entierEnChaineVersEntierEnInt(ligne), plateau)!=true){
		    println("Veuillez saisir un indice de ligne correct: ");
		    ligne=readString();
		}
		println("Veuillez saisir un indice de colonne: ");
		String colonne=readString();
		while(isDigit(colonne)!=true || saisie(entierEnChaineVersEntierEnInt(colonne), plateau)!=true){
			println("Veuillez saisir un indice de colonne correct: ");
		    colonne=readString();
		}
		int l=entierEnChaineVersEntierEnInt(ligne);
		int c=entierEnChaineVersEntierEnInt(colonne);
	    if(bonneReponseMul(l, c, plateau, operande1, operande2)==true) {
		println();
		println("Bravo, vous avez trouve le bon resultat :) ");
		note++;
	    }
	    else  {
		println();
		println("Dommage, ce n'est pas le bon resultat :( ");
	    }
	}
	
	long fin=getTime();
	println();
	println("Vous avez obtenu la note de : " + (note) + "/10");
	println("Vous avez mis " + ((fin-debut)/1000) + " secondes.");
	println();
	commentaire(note);
    }

    //Affiche le menu.
    void menu(){
	String choixS="";
	String choixS2="";
	println("Bienvenue sur le jeu du Calcul Mental !");
	println();
	println("1.Jouer");
	println("2.Quitter");
	println();
	print("Choisissez votre option : ");
	choixS = readString();
	while(isDigit(choixS)!=true || entierEnChaineVersEntierEnInt(choixS) != 1 && entierEnChaineVersEntierEnInt(choixS) != 2) {
		print("Choisissez une option valide: ");
		choixS = readString();
	}
	int choix=entierEnChaineVersEntierEnInt(choixS);
	if(choix == 1) {
	    println("Vous avez choisi jouer !");
	    println();
	    println("3.CE1/CE2");
	    println("4.CM1/CM2");
	    println();
	    print("Quel est votre niveau ? : ");
		choixS2 = readString();
		while(isDigit(choixS2)!=true || entierEnChaineVersEntierEnInt(choixS2) != 3 && entierEnChaineVersEntierEnInt(choixS2) != 4) {
			print("Choisissez une reponse valide: ");
			choixS2 = readString();
		}
		int choix2=entierEnChaineVersEntierEnInt(choixS2);
		if(choix2 == 3) {
		println("Vous avez choisi CE1/CE2, bonne chance !");
		niveauCe();
	    }
	    else if ( choix2 == 4) {
		println("Vous avez choisi CM1/CM2, bonne chance !");
		niveauCm();
	    }
	}
	else if(choix == 2) {
	    println("Vous avez choisi quitter le jeu !");
	    return;	
		}		
    }

    

    
    void algorithm(){
	menu();
    }
}

