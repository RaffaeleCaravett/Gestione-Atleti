package test;


import gerarchia.*;

public class GerarchiaTest {
	
	public static void main(String[] args) {
		
		Atleta aa = new Atleta("Atleta", "Specialità");
		Professionista pf = new Professionista("Prof", "specialita", 4);
				
		// ..............................................................
		
		Atleta ap = new Professionista();
//		Professionista pa = new Atleta();
		
		System.out.println(ap.toString()); 		// Professionista
		System.out.println(ap.getNome()); 		// Atleta	
	
		System.out.println(((Professionista) ap).getTessera());	
		
		if(ap instanceof Professionista)
			System.out.println(((Professionista) ap).getTessera());
		
		
	}

}