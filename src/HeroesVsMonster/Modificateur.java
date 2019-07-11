package HeroesVsMonster;

public class Modificateur {
public static int modificateur (int NbreCara){
	int PointModifier=NbreCara;
	if (NbreCara<5&&NbreCara>0) {
		PointModifier=NbreCara-1;
	}
	else if(NbreCara>=5&&NbreCara<10) {
		PointModifier=NbreCara;
	}
	else if(NbreCara>=10&&NbreCara<15) {
		PointModifier=NbreCara+1;
	}
	else {
		PointModifier=NbreCara+2;
	}
	return PointModifier;
}
}
