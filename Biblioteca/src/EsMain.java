import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import Biblio.Biblioteca;
import Biblio.DateUtility;
import Biblio.Gestione;
import Biblio.Libro;
import Biblio.Utente;
import Biblio.UtenteGiaEsiste;



public class EsMain {

	public static void main(String[] args) throws UtenteGiaEsiste, ParseException {
		
		Gestione g= new Gestione();
		Biblioteca b= new Biblioteca("Ciriè");
		
		g.registraLibro("Cent'anni di solitudine", "Garcia Marquez", "abc1", 2, b);
		g.registraLibro("Delitto e castigo", "Fedor Dostoevskij", "def2", 4, b);
		g.registraLibro("Anna Karenina", "Lev Tolstoj", "ghi3", 1, b);
		g.registraLibro("Il processo", "Franz Kafka", "lmn4", 2, b);
		g.registraLibro("Il vecchio e il mare", "Hernest Hemingway", "opq5", 3, b);
		System.out.println(g.registraLibro("Delitto e castigo", "Fedor Dostoevskij", "def2", 2, b));
		System.out.println(g.registraLibro("Anna Karenina", "Lev Tolstoj", "ghi3", 3, b));
		
		
		g.registraUtente("Martina", "Debernardi", "MRTDBRN90", b);
		g.registraUtente("Luca", "Umoretto", "MRTLCA90", b);
		g.registraUtente("Irene", "Aimone", "MNERN90", b);
		
		System.out.println();
		
		for(Libro l:b.getLibri().values()){
			System.out.println(l.toString());
		}
		
		System.out.println();
		
		for(Utente u:b.getUtenti().values()){
			System.out.println(u.toString());
		}
		
		System.out.println();
		
		DateUtility dt= new DateUtility();
	
		Date dataInizioPrestito= dt.convertStringtoDate("15/09/2016");
		Calendar cal= dt.convertDateToCalendar(dataInizioPrestito);
		cal.add(Calendar.DATE, 14);
		
		Date dataScadenza= cal.getTime();
		System.out.println(dataInizioPrestito+" + 14 giorni = "+dataScadenza);
		
		g.prestaLibro("def2", "MRTDBRN90", dataInizioPrestito, b);
		g.prestaLibro("ghi3", "MRTDBRN90", dataInizioPrestito, b);
		
		g.prestaLibro("lmn4", "MRTLCA90", dataInizioPrestito, b);
		
		System.out.println();
		
		Utente u = null;
		for(Utente utemp:b.getUtenti().values()){
			if((utemp.getNome().equals("Martina"))&&(utemp.getCognome().equals("Debernardi"))){
				u=utemp;
		    }
		}
		
		for(Libro l: u.getLibriInPrestito().values()){
			System.out.println(l.toString());
		}
		
		System.out.println();
		
		g.restituzioneLibro("def2","MRTDBRN90", dataInizioPrestito, dataScadenza, b);
		
		g.prestaLibro("abc1", "MRTDBRN90", dataInizioPrestito, b);
		
		System.out.println();
		
		for(Libro l: u.getLibriInPrestito().values()){
			System.out.println(l.toString());
		}
		
		System.out.println();
		
		
		

	}

}
