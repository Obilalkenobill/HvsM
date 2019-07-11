package HeroesVsMonster;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.omg.CORBA.ExceptionList;

public class Plateau implements Combat,De{
	Scanner sc=new Scanner(System.in);
	private String [][] Plat=new String [15][15];
	private String [][] PlatCache=new String [15][15];
	private static boolean Devoiler=false;
	public String[][] getPlatCache() {
		return PlatCache;
	}
	public void setPlatCache(String[][] platCache) {
		PlatCache = platCache;
	}
	private int PosX=14;
	private int PosY=14;
	private int NbreLoup=0;
	private int NbreOrque=0;
	private int NbreDragon=0;
	public void InitPlat(String [][] Plat) {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				Plat[i][j]="?";
			}
		}
	}
	public void FairePlat () {
		int i=1;	
		int l=0;
		int o=0;
		int d=0;
		while (l<4 || o<4 || d<4) {
			i=1;
			while(i<14) {
				int j=1;
				while(j<14) {
					double f=Math.random();
					if(f<0.33&&l<10) {
						Plat[i][j]="L";
						l++;
						setNbreLoup(getNbreLoup()+1);
					}
					else if(f>0.33 && o<10 && f<0.66) {
						Plat[i][j]="O";
						o++;
						setNbreOrque(getNbreOrque()+1);
					}
					else if(f>0.66 && d<10) {
						Plat[i][j]="D";
						d++;
						setNbreDragon(getNbreDragon()+1);
					}
					double k=Math.random()*6;
					int k1=(int)k;
					j+=k1;
				}
					double p=Math.random()*6;
					int p1=(int)p;
				i+=p1;
			}

		}
	}
	public void AfficherTableau (String[][]Tableau) {
		System.out.println("   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15");
		for(int i=1;i<=15;i++) {
			System.out.println(i+"  "+Tableau[i-1][0]+"  "+ Tableau[i-1][1]+"  "+ Tableau[i-1][2]+"  "+ Tableau[i-1][3]+"  "+ Tableau[i-1][4]+"  "+ Tableau[i-1][5]+"  "+ Tableau[i-1][6]+"  "+ Tableau[i-1][7]+"  "+ Tableau[i-1][8]+"  "+ Tableau[i-1][9]+"  "+ Tableau[i-1][10]+"  "+ Tableau[i-1][11]+"  "+ Tableau[i-1][12]+"  "+ Tableau[i-1][13]+"  "+ Tableau[i-1][14]+ "  "+i);
		}
		System.out.println("    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15");

	}
	public String[][] getPlat() {
		return Plat;
	}
	public void setPlat(String[][] plat) {
		Plat = plat;
	}
	public boolean seDeplacer ( Personnage heroes) {
		boolean Gagner=true;
		try{
			System.out.println("Ou voulez-vous vous déplacer, entrez la ligne ?");
			int x=Integer.parseInt(sc.nextLine());
			System.out.println("Entrez la colonne :");
			int y=Integer.parseInt(sc.nextLine());
			try {
				if(	x<=15 && x>=1&& y<=15 &&y>=1&&
						( (  x==getPosX()+1  )	&&  (  (y==getPosY()+2)   ||   (y==getPosY())  )  ) 
						||
						( (y==getPosY()+1    )	&&  (  (x==getPosX()+2)   ||   (x==getPosX())  )  )	)
				{
					PlatCache[getPosX()][getPosY()]=" ";
					setPosX(x-1);
					setPosY(y-1);
					PlatCache[x-1][y-1] = "H";
					Plat[x-1][y-1]="H";
					AfficherTableau(PlatCache);
					if(y!=15) {switch(Plat[x-1][y]) {
					case "O":
						PlatCache[x-1][y]="O";
						AfficherTableau(PlatCache);
						Orque O=new Orque();
						O.setForce(De.jeter4DeNface(6)+1);
						O.setEndurance(De.jeter4DeNface(6));
						O.setPV(Modificateur.modificateur(O.getEndurance()));
						Gagner=Combat.Combattre(heroes, O);
						if(Gagner) {
							AfficherTableau(PlatCache);
							Plat[x-1][y]="X";
							setNbreOrque(getNbreOrque()-1);}
						break;
					case "L":
						PlatCache[x-1][y]="L";
						AfficherTableau(PlatCache);
						Loup l=new Loup();
						l.setForce(De.jeter4DeNface(6));
						l.setEndurance(De.jeter4DeNface(6));
						l.setPV(Modificateur.modificateur(l.getEndurance()));
						Gagner=Combat.Combattre(heroes, l);
						if(Gagner) {
							AfficherTableau(PlatCache);
							Plat[x-1][y]="X";
							if (!isDevoiler()) {MonstreDevoiler();}
							setNbreLoup(getNbreLoup()-1);}
						break;
					case "D":
						PlatCache[x-1][y]="D";
						AfficherTableau(PlatCache);
						Dragonnet D=new Dragonnet();
						D.setForce(De.jeter4DeNface(6)+1);
						D.setEndurance(De.jeter4DeNface(6)+1);
						D.setPV(Modificateur.modificateur(D.getEndurance()));
						Gagner=Combat.Combattre(heroes, D);
						if(Gagner) {
							AfficherTableau(PlatCache);
							Plat[x-1][y]="X";
							setNbreDragon(getNbreDragon()-1);}
						break;
					}}
					if (x!=15) {switch(Plat[x][y-1]) {
					case "O":
						PlatCache[x][y-1]="O";
						AfficherTableau(PlatCache);
						Orque O=new Orque();
						O.setForce(De.jeter4DeNface(6)+1);
						O.setEndurance(De.jeter4DeNface(6));
						O.setPV(Modificateur.modificateur(O.getEndurance()));
						Gagner=Combat.Combattre(heroes, O);
						if(Gagner) {Plat[x][y-1]="X";
						AfficherTableau(PlatCache);
						setNbreOrque(getNbreOrque()-1);}
						break;
					case "L":
						PlatCache[x][y-1]="L";
						AfficherTableau(PlatCache);
						Loup l=new Loup();
						l.setForce(De.jeter4DeNface(6));
						l.setEndurance(De.jeter4DeNface(6));
						l.setPV(Modificateur.modificateur(l.getEndurance()));
						Gagner=Combat.Combattre(heroes, l);
						if(Gagner) {Plat[x][y-1]="X";
						AfficherTableau(PlatCache);
						if (!isDevoiler()) {MonstreDevoiler();}
						setNbreLoup(getNbreLoup()-1);}
						break;
					case "D":
						PlatCache[x][y-1]="D";
						AfficherTableau(PlatCache);
						Dragonnet D=new Dragonnet();
						D.setForce(De.jeter4DeNface(6)+1);
						D.setEndurance(De.jeter4DeNface(6)+1);
						D.setPV(Modificateur.modificateur(D.getEndurance()));
						Gagner=Combat.Combattre(heroes, D);
						AfficherTableau(PlatCache);
						if(Gagner) {Plat[x][y-1]="X";
						setNbreDragon(getNbreDragon()-1);}
						break;
					}}
					if (x!=1 ) {switch(Plat[x-2][y-1]) {
					case "O":
						PlatCache[x-2][y-1]="O";
						AfficherTableau(PlatCache);
						Orque O=new Orque();
						O.setForce(De.jeter4DeNface(6)+1);
						O.setEndurance(De.jeter4DeNface(6));
						O.setPV(Modificateur.modificateur(O.getEndurance()));
						Gagner=Combat.Combattre(heroes, O);
						if(Gagner) {Plat[x-2][y-1]="X";
						AfficherTableau(PlatCache);
						setNbreOrque(getNbreOrque()-1);}
						break;
					case "L":
						PlatCache[x-2][y-1]="L";
						AfficherTableau(PlatCache);
						Loup l=new Loup();
						l.setForce(De.jeter4DeNface(6));
						l.setEndurance(De.jeter4DeNface(6));
						l.setPV(Modificateur.modificateur(l.getEndurance()));
						Gagner=Combat.Combattre(heroes, l);
						if(Gagner) {Plat[x-2][y-1]="X";
						AfficherTableau(PlatCache);
						if (!isDevoiler()) {MonstreDevoiler();}
						setNbreLoup(getNbreLoup()-1);}
						break;
					case "D":
						PlatCache[x-2][y-1]="D";
						AfficherTableau(PlatCache);
						Dragonnet D=new Dragonnet();
						D.setForce(De.jeter4DeNface(6)+1);
						D.setEndurance(De.jeter4DeNface(6)+1);
						D.setPV(Modificateur.modificateur(D.getEndurance()));
						Gagner=Combat.Combattre(heroes, D);
						if(Gagner) {Plat[x-2][y-1]="X";
						AfficherTableau(PlatCache);
						setNbreDragon(getNbreDragon()-1);}
						break;
					}}
					if(y!=1) {switch(Plat[x-1][y-2]) {
					case "O":
						PlatCache[x-1][y-2]="O";
						AfficherTableau(PlatCache);
						Orque O=new Orque();
						O.setForce(De.jeter4DeNface(6)+1);
						O.setEndurance(De.jeter4DeNface(6));
						O.setPV(Modificateur.modificateur(O.getEndurance()));
						Gagner=Combat.Combattre(heroes, O);
						if(Gagner) {Plat[x-1][y-2]="X";
						AfficherTableau(PlatCache);
						setNbreOrque(getNbreOrque()-1);}
						break;
					case "L":
						PlatCache[x-1][y-2]="L";
						AfficherTableau(PlatCache);
						Loup l=new Loup();
						l.setForce(De.jeter4DeNface(6));
						l.setEndurance(De.jeter4DeNface(6));
						l.setPV(Modificateur.modificateur(l.getEndurance()));
						Gagner=Combat.Combattre(heroes, l);
						if(Gagner) {Plat[x-1][y-2]="X";
						AfficherTableau(PlatCache);
						if (!isDevoiler()) {MonstreDevoiler();}
						setNbreLoup(getNbreLoup()-1);
					
						}
						break;
					case "D":
						PlatCache[x-1][y-2]="D";
						AfficherTableau(PlatCache);
						Dragonnet D=new Dragonnet();
						D.setForce(De.jeter4DeNface(6)+1);
						D.setEndurance(De.jeter4DeNface(6)+1);
						D.setPV(Modificateur.modificateur(D.getEndurance()));
						Gagner=Combat.Combattre(heroes, D);
						if(Gagner) {Plat[x-1][y-2]="X";
						AfficherTableau(PlatCache);
						setNbreDragon(getNbreDragon()-1);}
						break;
					}
					}
				}
				else {
					System.out.println("Avancez d'une case (pas en diagonale)! Et dans le plateau !");
					seDeplacer(heroes);
				}
			}

			catch(ArrayIndexOutOfBoundsException exception) {
				seDeplacer(heroes);
			}}
		catch(NumberFormatException exception) {
			seDeplacer(heroes);
		}
//(x==getPosX()|y==getPosY())&&((x==(getPosX()+1)|x==getPosX()-1)|(y==(getPosY()+1)|(y==getPosY()-1)))
		
		return Gagner;
	}
	public int getPosX() {
		return PosX;
	}
	public void setPosX(int posX) {
		PosX = posX;
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
	public int getNbreLoup() {
		return NbreLoup;
	}
	public void setNbreLoup(int nbreLoup) {
		NbreLoup = nbreLoup;
	}
	public int getNbreOrque() {
		return NbreOrque;
	}
	public void setNbreOrque(int nbreOrque) {
		NbreOrque = nbreOrque;
	}
	public int getNbreDragon() {
		return NbreDragon;
	}
	public void setNbreDragon(int nbreDragon) {
		NbreDragon = nbreDragon;
	}
	public void MonstreDevoiler() {
		int NbreSecret=(int)(Math.random()*4.8);
		//System.out.println(NbreSecret);
		System.out.println("L'ésprit du loup émane de la bête...");
		System.out.println("Vous avez la possibilité de l'apprivoiser pour qu'il vous révêle où sont cachés les monstres..grâce à son flair.");
		System.out.println("Pour cela trouver le nombre secret..entre 0 compris et 4 compris..");
		try {
			int NbreDonne=Integer.parseInt(sc.nextLine());
			if (NbreSecret==NbreDonne) {
				AfficherTableau(Plat);
				setDevoiler(true);
			}
			else {
				setDevoiler(false);
				System.out.println("Dommage le nombre à trouver était de : "+NbreSecret+"... L'ésprit s'est évaporer dans la nature..");
			}
		}
		catch(NumberFormatException exception) {
			MonstreDevoiler();
		}
	}
	public static boolean isDevoiler() {
		return Devoiler;
	}
	public static void setDevoiler(boolean devoiler) {
		Devoiler = devoiler;
	}

}
