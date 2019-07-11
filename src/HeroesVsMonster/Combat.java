package HeroesVsMonster;

import java.util.Scanner;

public interface Combat {
public static boolean Combattre (Personnage heroes, Monster monster) {
	Scanner sc=new Scanner(System.in);
	boolean GagnerCombattre=false;
	int PVheroes=heroes.getPV();
	int PVmonster=monster.getPV();
	while(PVheroes>0&&PVmonster>0) {
		System.out.println(heroes.getNomPerso() +" Appuyer sur une touche, puis sur Entrer, pour frapper le "+monster.getNomPerso()+" avec votre " +heroes.getNomClasse());
		String Osef=sc.next();
		int frappe=Modificateur.modificateur(heroes.getForce())-heroes.getForce()+De.jeterMDeNface(1, 4);
		System.out.println("Vous infliger : "+frappe+" de dégats au monstre");
		PVmonster-=frappe;
		System.out.println("PV du monstre : "+PVmonster);
		if(PVmonster>0) {
		System.out.println("Le monstre vous frappe !");
		frappe=Modificateur.modificateur(monster.getForce())-monster.getForce()+De.jeterMDeNface(1, 4);
		System.out.println("Le "+monster.getNomPerso() +" vous inflige : "+frappe+" de dégat");
		PVheroes-=frappe;
		System.out.println("Il vous reste :"+PVheroes+" hp");
			}
	}
	if (PVheroes>PVmonster) {
		GagnerCombattre=true;
		System.out.println("Vous avez battu le " +monster.getNomPerso());
		int QtiteCuir=monster.getQtiteCuir();
		heroes.setQtiteCuir(heroes.getQtiteCuir()+QtiteCuir);		
		System.out.println("Vous gagnez : "+QtiteCuir+" pièce(s) de cuir, total : "+heroes.getQtiteCuir());
		int QtiteOr=monster.getQtiteOr();
		heroes.setQtiteOr(heroes.getQtiteOr()+QtiteOr);
		System.out.println("Vous gagnez : "+QtiteOr+" pièce(s) d'or, total : "+heroes.getQtiteOr());
	}
	return GagnerCombattre;
}
}
