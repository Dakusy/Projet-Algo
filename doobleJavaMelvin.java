import extensions.CSVFile;
import extensions.Image;
import extensions.RGBColor;

class doobleJavaMelvin extends Program{ // !!!! ---- il faut changer la ligne 360 ---- !!!!!
    
    // ---- On cree le tableau contenant les "cartes de symboles" ---- 
    
    void testCreaTab(){
	int[][] tab = new int[][]{
	    {1,2,3,10},
	    {4,5,6,10},
	    {7,8,9,10},
	    {1,4,7,11},
	    {2,5,8,11},
	    {3,6,9,11},
	    {1,5,9,12},
	    {2,6,7,12},
	    {3,4,8,12},
	    {1,8,6,13},
	    {2,9,4,13},
	    {3,7,5,13},
	    {10,11,12,13}};
	    
	assertArrayEquals( tab , creaTab());
	
    }
    int[][] creaTab(){
	int[][] tab = new int[][]{
	    {1,2,3,10},
	    {4,5,6,10},
	    {7,8,9,10},
	    {1,4,7,11},
	    {2,5,8,11},
	    {3,6,9,11},
	    {1,5,9,12},
	    {2,6,7,12},
	    {3,4,8,12},
	    {1,8,6,13},
	    {2,9,4,13},
	    {3,7,5,13},
	    {10,11,12,13}};
	return tab;
    }
    
    // ---- Prendre deux cartes aleatoires ----
    
    int[] carteAleatoire(int[][] tableau){
	int aleatoire = (int) (random()*13);
	int[] carte1 = new int[4];
	for (int i = 0; i<4; i++){
	    carte1[i] = tableau[aleatoire][i];
	}
	return carte1;
    }
    
    // ---- Comparer pour qu'elle soit differente ----

    void testEstDifferent(){

	int[] tab1 = new int[]{1,2,3,10};
	int[] tab2 = new int[]{4,5,6,10};
        
	assertTrue(estDifferent(tab1, tab2));
	assertFalse(estDifferent(tab1, tab1));
	
    }
    boolean estDifferent(int[] tab1 , int[] tab2){
	if( tab1 == tab2){	    
	    return false;	    
	}
	else{    
	    return true;	    
	}	
    }

    // ---- Melanger les valeurs d'une carte ----
    
    int[] melangerCarte(int[] carte){
        int stock1 = 0;
        int stock2 = 0;
        
        int index1 = 0;
        int index2 = 0;
        
        for(int i = 0;i < 5; i++){
            index1 = (int)(random()*4);
            index2 = (int)(random()*4);
            stock1 = carte[index1];
            stock2 = carte[index2];
            carte[index1] = stock2;
            carte[index2] = stock1;
        }
        return carte;
    }
    
    // ---- Verifier qu'un seul et meme int est present dans les deux cartes ----    
    
    void testEstDansTab(){
	int[] carte1 = new int[]{1,2,3,10};
	assertTrue(estDansTab(carte1,10));
	assertFalse(estDansTab(carte1,13));
    }

    boolean estDansTab(int[] carte, int nb){
	for(int i=0;i<length(carte);i++){ 
	    if(nb == carte[i]){
		return true;
	    }
	}
	return false;	
    }
    
    // ---- Récupère la saisie de l'utilisateur
    
    int saisie(){
	
        println("Apres avoir calcule, quel nombre se trouve dans les 2 cartes ? ");
        String nb = readString();
	while(!equals(nb, "1") && !equals(nb, "2") && !equals(nb, "3") && !equals(nb, "4") && !equals(nb, "5") && !equals(nb, "6") && !equals(nb, "7") && !equals(nb, "8") && !equals(nb, "9") && !equals(nb, "10") && !equals(nb, "11") && !equals(nb, "12") && !equals(nb, "13")){
	
	    println("la saisie est erronee, recommence la saisie:");
	    nb = readString();
	}
	int nbInt = stringToInt(nb) ;
	return nbInt;
    }
    
    // ---- Affichage des differentes cartes ----
    
    void afficherCarteString1(String[] carte){
    	
        
	    setNewFont(Dooble, carte[0] + "","PLAIN",32); // Redimensionner la police
	    drawString(Dooble,carte[0] + "",150,100);	  // Afficher chaque chiffres
        int longueur = getStringLength(Dooble,carte[0]);    // Récupère la taille du String
        addZone(Dooble,"carte1String1",150,72,longueur,34);  // Créer une zone de la taille du String
	    
	    setNewFont(Dooble, carte[1] + "","PLAIN",32);
	    drawString(Dooble,carte[1] + "",400,100);
        longueur = getStringLength(Dooble,carte[1]);    
        addZone(Dooble,"carte1String2",400,72,longueur,34); 
	
	    setNewFont(Dooble, carte[2] + "","PLAIN",32);
	    drawString(Dooble,carte[2] + "",150,200);
        longueur = getStringLength(Dooble,carte[2]);    
        addZone(Dooble,"carte1String3",150,172,longueur,34); 
	    
	    setNewFont(Dooble, carte[3] + "","PLAIN",32);
	    drawString(Dooble,carte[3] + "",400,200);
        longueur = getStringLength(Dooble,carte[3]);    
        addZone(Dooble,"carte1String4",400,172,longueur,34); 
    
    }
    
    void afficherCarteString2(String[] carte){
    	
	    setNewFont(Dooble, carte[0] + "","PLAIN",32);
	    drawString(Dooble,carte[0] + "",150,350);
        int longueur = getStringLength(Dooble,carte[0]);    
        addZone(Dooble,"carte2String1",150,322,longueur,34); 
	    
	    setNewFont(Dooble, carte[1] + "","PLAIN",32);
	    drawString(Dooble,carte[1] + "",400,350);
        longueur = getStringLength(Dooble,carte[1]);    
        addZone(Dooble,"carte2String2",400,322,longueur,34); 
	
	    setNewFont(Dooble, carte[2] + "","PLAIN",32);
	    drawString(Dooble,carte[2] + "",150,450);
        longueur = getStringLength(Dooble,carte[2]);    
        addZone(Dooble,"carte2String3",150,422,longueur,34); 
	    
	    setNewFont(Dooble, carte[3] + "","PLAIN",32);
	    drawString(Dooble,carte[3] + "",400,450);
        longueur = getStringLength(Dooble,carte[3]);    
        addZone(Dooble,"carte2String4",400,422,longueur,34); 
	    
    }

    // ---- Carte de Int en carte de String ----
    
    void testCarteIntToString() {
    	int[] testCarte = new int[] {1,2,3,4,5,6};
    	String[] testStringCarte = new String[] {"1","2","3","4","5","6"};
    	
    	assertArrayEquals(carteIntToString(testCarte),testStringCarte);
    }
    
    String[] carteIntToString(int[] carte) {
    	String[] carteString = new String[length(carte,1)];
    	for (int i = 0; i < length(carte,1); i++) {
    		carteString[i] = carte[i] + "";
    	}
    	return carteString;
    }
    

    // ---- Ajout de la difficultee, c'est maintenant une addition ----
    
    String[] addAleatoire2op(int[] carte ){	
	String[] res = new String[length(carte)];
	for(int i=0;i<length(carte);i++){
           
	    int rand = (int)(random()*(carte[i]));
	    res[i]= ((rand%carte[i])  + " + " + (carte[i]-rand)) ; 
	}
	return res;
    }
    
    // ---- Ajout de la difficultee, c'est maintenant une addition avec 3 chiffres ----
    
    String[] addAleatoire3op(int[] carte ){
	String[] res = new String[length(carte)];	
	for(int i=0;i<length(carte);i++){
           
	    int rand1 = (int)(random()*(carte[i]));
	    int rand2 = (int)(random()*(carte[i]-rand1));
	    res[i]= (rand1+" + "+ rand2 +  " + " + (carte[i]-rand1-rand2)) ; 
	}
	return res;
    }

    String[] mulAleatoire(int[] carte){
    	String[] res = new String[length(carte)];
    	for (int i = 0; i<length(carte); i++) {
    		
    		if (carte[i]%2 == 1) {
    			int calcule = (carte[i]-1)/2;
    			res[i] = calcule + " * 2 + 1";
    		}
    		else if (carte[i]%2 == 0) {
    			int calcule = carte[i]/2;
    			res[i] = calcule + " * 2";
    		}
    	}
    	return res;
    }
    
    // ---- Ajout de la difficultee, multiplication de 0 a 9
    
    String[] mulAleatoire0a10(int[] carte) {
    	String[] res = new String[length(carte)];
    	for (int i = 0; i < length(carte);i++) {
    		int rand = (int) (random()*8+1);
    		int modulo = carte[i]% rand;
    		int multiplication = carte[i] / rand;
    		res[i] = multiplication + " * " + rand + " + " + modulo;
    	}
    	return res;
    }

    
    
    // ---- Verification de la reponse ----
    
    boolean reussite(int[] carte1, int[] carte2, int saisieJoueur){
	boolean res = false;
	if (estDansTab(carte1, saisieJoueur) && (estDansTab(carte2, saisieJoueur))){
            res = true;
        }
        return res;
    }
    
    //convertie un fichier CSV en tableau String[][]
    
    String[][] tabCsvToString(CSVFile file){
	
        int NbCol = columnCount(file);
        int NbLig = rowCount(file);

	String[][] tab = new String[NbLig][NbCol];
	
        for(int i = 0; i < length(tab,1); i++){
            for(int j = 0; j < length(tab,2); j++){		
                tab[i][j] = getCell(file,i,j);
            }
        }
	return tab;
    }

    
    //Afficer le tableau de score
    
    void afficher(String[][] tab){

	for(int i = 0; i < length(tab,1); i++){
            for(int j = 0; j < length(tab,2); j++){		
		print(tab[i][j]+" | ");
		
            }
        
	print("\n");
	println("-------------");
	}
    }
    // Ranger un tableau par ordre croissant
    
    void ordreDecroissant(String[][] tab ){
	boolean perm = true;
	while(perm){
	    perm=false;
	    for(int i=2;i<length(tab,1);i++){
	    	if( stringToInt(tab[i][1]) > stringToInt(tab[i-1][1]) ){
		    permutation(tab,i);
		    perm=true;
		}
	    }   
	}
    }
    
    // Effectue une permutation
    
    void permutation(String[][] tab,int i){
	
	String tmp1=tab[i][0];
	String tmp2=tab[i][1];
	tab[i][0]=tab[i-1][0];
	tab[i][1]=tab[i-1][1];
	tab[i-1][0]=tmp1;
	tab[i-1][1]=tmp2;
	
    }


    String[][] inscrireScore(int score, String[][] tab ){
	
	String[][] tab2 = new String[length(tab,1)+1][length(tab,2)];

	for(int i=0;i<length(tab,1);i++){
	    for(int j=0;j<length(tab,2);j++){
		
		tab2[i][j]=tab[i][j];
	    }
	}
	print("Ecrit ton nom :");
	String nom = readString();
	int nbAnormale=0;

	if(length(nom)==0){

	    nbAnormale++;

	}
	for(int i=0;i<length(nom);i++){


	    if((int)(charAt(nom, i)) < 48 || (int)(charAt(nom,i)) > 57 &&  (int)(charAt(nom,i)) < 65 || (int)(charAt(nom,i)) > 90 && (int)(charAt(nom,i)) < 97 || (int)(charAt(nom,i)) >122 ){
		nbAnormale++;
		
	    }
	}
	if(nbAnormale !=0){
	    while(nbAnormale !=0){
            
		print("ré-écrit ton nom (Seul les lettres en majuscules, miniscules et les chiffres sont autorisé ! Il faut obligatoirement noté un nom ) : ");
		nom = readString();
		nbAnormale=0;
		
		if(length(nom)==0){
		    
		    nbAnormale++;
		    
		}
		for(int i=0;i<length(nom);i++){    
		    if((int)(charAt(nom, i)) < 48 || (int)(charAt(nom,i)) > 57 &&  (int)(charAt(nom,i)) < 65 || (int)(charAt(nom,i)) > 90 && (int)(charAt(nom,i)) < 97 || (int)(charAt(nom,i)) >122)      {
			     nbAnormale++;
		      }
		  }		
	   }
	}
	tab2[length(tab2,1)-1][0]= nom;
	tab2[length(tab2,1)-1][1]= ""+score; 
	
	return tab2;
    }

    

    void faitSiReussite(){

	score++;
	println(score);
	
	afficherJeux();
	
    }

    void faitSiPasReussite(){
	
	close(Dooble);
	println("Perdu !");
	println("Ton score est de "+score+" !" );
	
	
	

    }
    
    void sauver(String[][] tab, String filename){
	saveCSV(tab,filename);
	println("Fichier CSV sauvegarder !");
    }
    
    
    // ---- Genere et affiche les cartes ---- POUR SIMPLIFIER LE VOID ALGO
    
    void AfficherCarteComplete(int score, int[] carte1, int[] carte2){
	
        while(!estDifferent(carte1,carte2)){
            carte1 = carteAleatoire(creaTab());
        }
        
        carte1 = melangerCarte(carte1);
        carte2 = melangerCarte(carte2);
        
        println();
	
        if (score > 12) { afficherCarteString1(mulAleatoire0a10(carte1));}
        else if (score > 9) { afficherCarteString1(mulAleatoire(carte1));}
        else if (score > 5){ afficherCarteString1(addAleatoire3op(carte1));}
        else if (score > 3){afficherCarteString1(addAleatoire2op(carte1));}
        else { afficherCarteString1(carteIntToString(carte1));}
        
        if (score > 12) { afficherCarteString2(mulAleatoire0a10(carte2));}
        else if (score > 9) { afficherCarteString2(mulAleatoire(carte2));}
        else if (score > 5){ afficherCarteString2(addAleatoire3op(carte2));}
        else if (score > 3){afficherCarteString2(addAleatoire2op(carte2));}
        else { afficherCarteString2(carteIntToString(carte2));}

	setNewFont(Dooble,"Clique sur la bonne réponse !","PLAIN",25);
	drawString(Dooble,"Clique sur la bonne réponse !", 130,50);
    }

    
    
    String recupereDonnee(String[][] tab, int l,int c){

	if(l>length(tab,1)-1 && c==0){

	    return "Nulle";
	}
	if(l>length(tab,1)-1 && c==1){

	    return "0";
	}
	
	return tab[l][c];
    }

    void color(){

	setColor(Dooble,0,228,73);

    }
    
    /*void AfficherLeaderBoard(String[][] tab){

	close(Dooble);
	
	Dooble = newImage("LeaderBoard",650,500);
	
	show(Dooble);

        color();
	
	setNewFont(Dooble,"Classement","PLAIN",48);
	drawString(Dooble,"Classement", 200,50);
	
	setNewFont(Dooble,recupereDonnee(tab,0,0),"PLAIN",28);
	drawString(Dooble,recupereDonnee(tab,0,0), 150,100);

	setNewFont(Dooble,recupereDonnee(tab,0,1),"PLAIN",28);
	drawString(Dooble,recupereDonnee(tab,0,1), 350, 100);


        

	if(length(tab,1)>1){
	    setNewFont(Dooble,recupereDonnee(tab,1,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,1,0), 150,150);
	    
	    
	    setNewFont(Dooble,recupereDonnee(tab,1,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,1,1), 350, 150);
	}
	if(length(tab,1)>2){
	    setNewFont(Dooble,recupereDonnee(tab,2,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,2,0), 150,180);
	    
	    setNewFont(Dooble,recupereDonnee(tab,2,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,2,1), 350, 180);
	}
	if(length(tab,1)>3){
	    setNewFont(Dooble,recupereDonnee(tab,3,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,3,0), 150,210);
	    
	    setNewFont(Dooble,recupereDonnee(tab,3,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,3,1), 350, 210);
	}
	if(length(tab,1)>4){
	    
	    setNewFont(Dooble,recupereDonnee(tab,4,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,4,0), 150,240);
	    
	    setNewFont(Dooble,recupereDonnee(tab,4,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,4,1), 350, 240);
	}
	if(length(tab,1)>5){
	    
	    setNewFont(Dooble,recupereDonnee(tab,5,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,5,0), 150,270);
	    
	    setNewFont(Dooble,recupereDonnee(tab,5,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,5,1), 350, 270);
	}
	if(length(tab,1)>6){
	    
	    setNewFont(Dooble,recupereDonnee(tab,6,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,6,0), 150,300);
	    
	    setNewFont(Dooble,recupereDonnee(tab,6,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,6,1), 350, 300);
	}
	if(length(tab,1)>7){
	    setNewFont(Dooble,recupereDonnee(tab,7,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,7,0), 150,330);
	    
	    setNewFont(Dooble,recupereDonnee(tab,7,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,7,1), 350, 330);
	}
	if(length(tab,1)>8){
	    
	    setNewFont(Dooble,recupereDonnee(tab,8,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,8,0), 150,360);
	    
	    setNewFont(Dooble,recupereDonnee(tab,8,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,8,1), 350, 360);
	}
	if(length(tab,1)>9){
	    
	    setNewFont(Dooble,recupereDonnee(tab,9,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,9,0), 150,390);
	    
	    setNewFont(Dooble,recupereDonnee(tab,9,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,9,1), 350, 390);
	}
	if(length(tab ,1)>10){
	    
	    setNewFont(Dooble,recupereDonnee(tab,10,0),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,10,0), 150,420);
	    
	    setNewFont(Dooble,recupereDonnee(tab,10,1),"PLAIN",28);
	    drawString(Dooble,recupereDonnee(tab,10,1), 350, 420);
	
	}
	readString();

        
	}*/

    void AfficherMenu(){

	close(Dooble);
	Dooble = newImage("Menu",650,500);
	
	show(Dooble);
	removeAllZone(Dooble);
	color();
	setNewFont(Dooble,"Jouer","PLAIN",28);
	drawString(Dooble,"Jouer", 275 , 275);
	int longueur = getStringLength(Dooble,"Jouer")+20;
        addZone(Dooble,"Jouer",265,245,longueur,50);
	
	drawRect(Dooble,265,245,longueur,50);

	
    }

    void afficherJeux(){


	close(Dooble);
	Dooble = newImage("Jeux",650,500);
	
	show(Dooble);	
	removeAllZone(Dooble);
	color();
	drawLine(Dooble, 0,249,650,249);
	drawLine(Dooble, 0,250,650,250);
	drawLine(Dooble, 0,251,650,251);

	carte1=carteAleatoire(creaTab());
	carte2=carteAleatoire(creaTab());
	
	AfficherCarteComplete(score,carte1,carte2);

	
	
	
    }

    
    
    // ---- Affichage graphique ----
   
    Image Dooble = newImage(650,500);
   
    
    CSVFile file = loadCSV("./highScore.csv");
    String[][] tab = tabCsvToString(file);
    
    int[] carte1 = carteAleatoire(creaTab());
    int[] carte2 = carteAleatoire(creaTab());
    int score=0;
    
    
    void mouseHasMoved(int x, int y){
	//action lorsqu'on bouge la souris reussite(carte1,carte2,saisieJoueur)
	//println(x+","+y);
    }
    
    void mouseChanged(String name, int x, int y, int button, String event){
	//action lorsque l'on clique ou l'on quitte le mode graphique avec la souris
	

	if(equals(event,"RELEASED") && equals(name,"Jouer")){

	    
	    afficherJeux();
	}
	if(equals(event,"RELEASED") && equals(name,"carte1String1")) {  // Tu regarde que lorsque tu clic, tu sois dans la zone approprié
	    if(reussite(carte1,carte2,carte1[0])){
                // Et tu regarde que le chiffre associé est bien le même dans les deux cartes
		
		faitSiReussite();
	    }
	    else {
		faitSiPasReussite();
	    }
        }
	
        if(equals(event,"RELEASED") && equals(name,"carte1String2")) {
            if(reussite(carte1,carte2,carte1[1])){
		faitSiReussite();
            }
            else {
		faitSiPasReussite();
	    }
	}
	
	if(equals(event,"RELEASED") && equals(name,"carte1String3")) {
	    if(reussite(carte1,carte2,carte1[2])){
		faitSiReussite();
	    }
	    else {
		faitSiPasReussite();
	    }
        }
	
	if(equals(event,"RELEASED") && equals(name,"carte1String4")) {
	    if(reussite(carte1,carte2,carte1[3])){
		faitSiReussite();
		
	    }
	    else {
		faitSiPasReussite();
	    }
        }
	
	if(equals(event,"RELEASED") && equals(name,"carte2String1")) {
	    if(reussite(carte1,carte2,carte2[0])){
		faitSiReussite();
	      
	    }
	    else {
		faitSiPasReussite();
	    }
        }
	
	if(equals(event,"RELEASED") && equals(name,"carte2String2")) {
	    if(reussite(carte1,carte2,carte2[1])){
		faitSiReussite();
	    }
	    else {
		faitSiPasReussite();
	    }
        }
	
	if(equals(event,"RELEASED") && equals(name,"carte2String3")) {
	    if(reussite(carte1,carte2,carte2[2])){
		faitSiReussite();
	    }
	    else {
		faitSiPasReussite();
	    }
        }
        
        if(equals(event,"RELEASED") && equals(name,"carte2String4")) {
	    if(reussite(carte1,carte2,carte2[3])){
		faitSiReussite();
		
	    }
	    else {
		faitSiPasReussite();
	    }
        }
        
    }
    
    
    void mouseIsDragged(int x, int y, int button, int clickCount){
	//action lorsqu'on maintient le clique et que l'on bouge la souris 

    }

    void textEntered(String text){ 

    }

    void keyChanged(char c, String event){
	

    }
      
    
    
    /* ------------------------------ Void algorithm -------------------------------------------------- */
    
       void algorithm(){
	
	CSVFile file = loadCSV("./highScore.csv");
	String[][] tab = tabCsvToString(file);

	AfficherMenu();
       
	show(Dooble);
	
        
	readString();

	if(length(tab,1)>1){
	    println("Le premier joueur est "+tab[1][0]+" avec un score de "+tab[1][1]+" points !");}
	else{
	    println("Il n'y a pour le moment pas de record !");
	}
	
      

        
	tab = inscrireScore(score,tab);
	ordreDecroissant(tab);
	afficher(tab);
	sauver(tab,"highScore.csv");
	
	AfficherLeaderBoard(tab);
	
	
	
    }
}    


// Afficher une carte FAIT
// Créer un menu.
// Créer un Tableau avec toutes les possibilités des cartes. FAIT
// Créer un Tableau avec toutes les possibilités des valeurs. FAIT
// Générer les cartes/afficher 1 et 2.  FAIT
// Ligne de saisie qui vérifie la réponse.  FAIT   
// Créer un Timer. FAIT (Système de points à la place) FAIT
// Système de sauvegarde de score. FAIT
// Evolution de la difficulté (EN COURS) FAIT + EN COURS
// Affichage graphique EN COURS












