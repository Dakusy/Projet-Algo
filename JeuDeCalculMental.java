class JeuDeCalculMental extends Program {

    int operande1=operande();
    int operande2=operande();

    void testInitialiser(){
	assertArrayEquals(new int[][]{
		{0,0,0},
		{0,0,0},
		{0,0,0}},initialiser());
    }

    int[][] initialiser(){
	int[][] tab=new int[3][3];
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=0;
	    }
	}
	return tab;
    }
    
    int operande(){
	int nombre=(int)(random()*100);
	return nombre;
    }

    void testAffichage(){
	assertEquals("2 + 5", affichage(2,5));
    }

    String affichage(int operande1, int operande2){
	String res=operande1 + " + " + operande2;
	return res;
    }

    int[][] tableauEntier(int[][] tab){
	for(int i=0; i<length(tab,1); i++){
	    for(int j=0; j<length(tab,2); j++){
		tab[i][j]=operande();
	    }
	}
	tab[(int)(random()*length(tab,1))][(int)(random()*length(tab,2))]=operande1+operande2;
	return tab;
    }

    void testAffichageTableau(){
	int[][] tab = new int[][]{
	    {1,2,3},
	    {4,5,6},
	    {7,8,9}
	};
	assertEquals(" 1 2 3\n 4 5 6\n 7 8 9\n",affichageTableau(tab));
    }

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

    void algorithm(){
	println(affichage(operande1, operande2));
	println();
	println(affichageTableau(tableauEntier(initialiser())));
    }
}

