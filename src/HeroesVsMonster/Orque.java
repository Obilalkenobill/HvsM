package HeroesVsMonster;

public class Orque extends Monster {
	private String NomPerso="Orque";
	public int getQtiteOr() {
		return De.jeterMDeNface(1, 6);
	}
	public void setQtiteOr(int qtiteOr) {
		QtiteOr = qtiteOr;
	}
	public int getQtiteCuir() {
		return 0;
	}
	public void setQtiteCuir(int qtiteCuir) {
		QtiteCuir = qtiteCuir;
	}
	public String getNomPerso() {
		return NomPerso;
	}
	public void setNomPerso(String nomPerso) {
		NomPerso = nomPerso;
	}

}
