/**
 * 
 */
package HeroesVsMonster;
import java.util.Scanner;

/**
 * @author Asus
 *
 */
public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plateau Plat1=new Plateau();
		Plat1.InitPlat(Plat1.getPlat());
		Plat1.InitPlat(Plat1.getPlatCache());
		Plat1.FairePlat();
		Plat1.getPlatCache()[Plat1.getPosX()][Plat1.getPosY()]="H";
		Plat1.getPlat()[Plat1.getPosX()][Plat1.getPosY()]="H";
		System.out.println("Bienvenu(e) dans StormWall, Votre héros est représenter par le 'H' !");
		Plat1.AfficherTableau(Plat1.getPlatCache());
		//Plat1.AfficherTableau(Plat1.getPlat());
		Scanner sc= new Scanner(System.in);
		int ClassePerso=0;
		Personnage heroes=new Heroes();
		boolean IfString=false;
		do{System.out.println("Entrez '1' pour combattre avec un nain ou '2' pour combattre avec un humain ?");
		try{ClassePerso=Integer.parseInt(sc.nextLine());
		IfString=true;}
		catch(NumberFormatException exception){
			IfString=false;
		}
		}
		while(ClassePerso!=1 &&ClassePerso!=2&&!IfString);
		if (ClassePerso==1) {
			heroes=new Nain();
		}
		else if(ClassePerso==2) {
			heroes=new Humain();
		}
		System.out.println("Veuillez entrer le nom de votre personnage svp:");
		String Nomperso=sc.next();
		heroes.setNomPerso(Nomperso);
		heroes.setForce(De.jeter4DeNface(6));
		heroes.setEndurance(De.jeter4DeNface(6));
		heroes.setPV(Modificateur.modificateur(heroes.getEndurance()));
		if (ClassePerso==1) {
			heroes.setEndurance(heroes.getEndurance()+2);
		}
		else if(ClassePerso==2) {
			heroes.setForce(heroes.getForce()+1);
		}
		Boolean Sedeplacer=true;
		while(Sedeplacer&&((Plat1.getNbreDragon()!=0)&&(Plat1.getNbreDragon()!=0)&&(Plat1.getNbreLoup()!=0))) {
			Sedeplacer=Plat1.seDeplacer(heroes);
		}
		if(!Sedeplacer) {System.out.println("Game over!");}
		else {System.out.println("Vous avez gagné la partie !");
		}
		//System.out.println("Vous avez récupéré, "+heroes.getQtiteCuir()+"pièce(s) de cuir, et "+heroes.getQtiteOr()+" pièce(s) d'or.");
	}

}
