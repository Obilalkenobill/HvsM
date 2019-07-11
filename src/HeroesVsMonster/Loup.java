package HeroesVsMonster;

public class Loup extends Monster {
private static String NomPerso ="Loup";
public int getQtiteCuir() {
	return De.jeterMDeNface(1, 4);
}
public void setQtiteCuir(int qtiteCuir) {
	QtiteCuir = qtiteCuir;
}
public int getQtiteOr() {
	return 0;
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
