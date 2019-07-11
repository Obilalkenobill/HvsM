package HeroesVsMonster;

public class Dragonnet extends Monster {
	private static String NomPerso="Dragonnet";
	public int getQtiteCuir() {
		return De.jeterMDeNface(1, 4);
	}
	public void setQtiteCuir(int qtiteCuir) {
		QtiteCuir = qtiteCuir;
	}
	public int getQtiteOr() {
		return De.jeterMDeNface(1, 6);
	}
	public void setQtiteOr(int qtiteOr) {
		QtiteOr = qtiteOr;
	}
	public String getNomPerso() {
		return NomPerso;
	}
	public void setNomPerso(String nomPerso) {
		NomPerso = nomPerso;
	}
}
