package Biblio;

import java.util.Calendar;
import java.util.Date;

public class Gestione {
	
	public Libro registraLibro(String titolo, String autore, String serialNumber, int copieDaRegistrare, Biblioteca b){

		Libro l= b.getLibri().get(serialNumber);
		
		if(l!=null){                //se esiste il libro nella mappa libri allora aggiorniamo numero di copie 
			                        //totali e disponibili
		   l.setCopieTotali(l.getCopieTotali()+copieDaRegistrare);
		   l.setCopieDisponibili(l.getCopieDisponibili()+copieDaRegistrare);
		   
		} else{                     // se non esiste creiamo un nuovo libro da aggiungere alla mappa libri            
			                        // e settiamo le copie totali e disponibili
			l=new Libro(titolo,autore,serialNumber);
			
			l.setCopieTotali(copieDaRegistrare);
			l.setCopieDisponibili(copieDaRegistrare);
			
			b.aggiungiLibro(l);
		}
		
		return l;
	}
	
	public Utente registraUtente(String nome, String cognome, String cf, Biblioteca b) throws UtenteGiaEsiste{

		if(b.getUtenti().containsKey(cf)){
			
			throw new UtenteGiaEsiste("esiste in biblioteca "+b.getNome());
		} 
			
			Utente u= new Utente(nome,cognome,cf);
			b.aggiungiUtente(u);
			
			return u;
				
	}
	
	public boolean prestaLibro(String serialNumber, String cf, Date dataInizioPrestito, Biblioteca b){
		
		Libro l= b.getLibri().get(serialNumber);
		
		Utente u= b.getUtenti().get(cf);
		
		//se il libro e l'utente esistono, e il numero dei libri presi in prestito dall'utente è inferiore al limite (3)
		//e ci sono copie disponibili di quel libro 
		if((l!=null)&&(u!=null)&&(u.getNumeroLibri()<3)&&(l.getCopieDisponibili()>0)){   
			
			//controllo che l'utente non abbia prestiti scaduti
			if(u.isScaduti()==false){
				
				//metto il libro nella lista dei libri presi in prestito dell'utente
				u.getLibriInPrestito().put(l.getSerialNumber(),l);
				l.setCopieDisponibili((l.getCopieDisponibili())-1);
				
				//setto la data di scadenza del prestito
				DateUtility dt = new DateUtility();
				Calendar cal = dt.convertDateToCalendar(dataInizioPrestito);
				cal.add(Calendar.DATE, 14);
				Date dataScadenza= cal.getTime();
				
				//aggiungo il prestito alla lista
				Prestito p = new Prestito(l,u,dataInizioPrestito,null,dataScadenza);
				b.getPrestiti().add(p);
				
			}else 
				System.out.println("Attenzione ho un prestito scaduto, non posso prenderne un altro!");
			
			return true;
			
		} else {
			System.out.println("Attenzione uno tra libro o utente non e' registrato!");
		    return false;
		}

	}
	
	public boolean restituzioneLibro(String serialNumber, String cf, Date dataInizioPrestito, Date dataScadenza, Biblioteca b){
		Libro l= b.getLibri().get(serialNumber);
		
		Utente u=b.getUtenti().get(cf);
		
	    //controllo che utente e libro esistano
		if((l!=null && u!= null)){
			Date d= new Date();
			//trovo il prestito e setto la data di restituzione a quella attuale
			for(Prestito p:b.getPrestiti()){
				
				if(p.getL().getSerialNumber().equals(serialNumber)&&p.getU().getCf().equals(cf)){
					p.setDataRestituzione(d);
				}
			}
			u.getLibriInPrestito().remove(l);
			
			//se la data di restituzione(che è quella attuale) non è prima della data di scadenza
			//allora setto il prestito come scaduto
			if(!(d.before(dataScadenza))){
				u.setScaduti(true);
			}
			
			return true;
		} else return false;
	}
	
}