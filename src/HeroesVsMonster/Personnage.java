package HeroesVsMonster;

abstract class Personnage {
public String getNomClasse() {
		return NomClasse;
	}
	public void setNomClasse(String nomClasse) {
		NomClasse = nomClasse;
	}
protected int Endurance;
protected int Force;
protected int PV;
protected String NomPerso;
protected int QtiteCuir=0;
protected int QtiteOr=0;
protected String NomClasse; 
public int getQtiteOr() {
	return QtiteOr;
}
public void setQtiteOr(int qtiteOr) {
	QtiteOr = qtiteOr;
}
public int getQtiteCuir() {
	return QtiteCuir;
}
public void setQtiteCuir(int qtiteCuir) {
	QtiteCuir = qtiteCuir;
}
private static int Frappe;
public int getEndurance() {
	return Endurance;
}
public void setEndurance(int endurance) {
	Endurance = endurance;
}
public int getForce() {
	return Force;
}
public void setForce(int force) {
	Force = force;
}
public int getPV() {
	return PV;
}
public void setPV(int pV) {
	PV = pV;
}
public String getNomPerso() {
	return NomPerso;
}
public void setNomPerso(String nomPerso) {
	NomPerso = nomPerso;
}
public int getFrappe() {
	return Frappe;
}
public void setFrappe(int frappe) {
	Frappe = frappe;
}

}
