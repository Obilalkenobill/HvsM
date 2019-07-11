package HeroesVsMonster;

public interface De {
	public static int jeterDeNfaces(int n) {
		int NbreDe;
		double NbreDe1;
		do {NbreDe1= Math.random()*10;
		NbreDe=(int)NbreDe1;
		}
		while (NbreDe>=n ||NbreDe==0);
		//System.out.println(NbreDe);
		return NbreDe;
	}
	public static int jeter4DeNface(int n) {
		int i=0;
		int []NbreCaract1 = new int[4];
		int NbreCaract=0;
		while (i<4) {
			NbreCaract1[i]=jeterDeNfaces(n);
			i++;	}
		i=1;
		int k=0;
			i=1;
		while(i<=3) {
			if (NbreCaract1[i]>NbreCaract1[i-1]) {
				int temps=NbreCaract1[i-1];
				NbreCaract1[i-1]=NbreCaract1[i];
				NbreCaract1[i]=temps;
			}
			i++;
		}
		i=0;
		while (i<3) {
			NbreCaract+= NbreCaract1[i];
			i++;
		}
		//System.out.println("caract :"+NbreCaract);
		return NbreCaract;
	}
	public static int jeterMDeNface(int M,int n) {
		int i=0;
		int []NbreCaract1 = new int[M];
		int NbreCaract=0;
		while (i<M) {
			NbreCaract1[i]=jeterDeNfaces(n);
			NbreCaract+= NbreCaract1[i];
			i++;	}
		return NbreCaract;
	}
	

}



