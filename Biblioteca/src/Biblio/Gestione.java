package Biblio;

import java.util.Date;

public class Gestione {
	
	public Libro registraLibro(String titolo, String autore, String serialNumber, int copieDaRegistrare, Biblioteca b){

		Libro l= b.getLibri().get(serialNumber);
		
		if(l!=null){                //se esiste il libro nella mappa libri allora aggiorniamo numero di copie 
			                        //totali e disponibili
		   l.setCopieTotali(l.getCopieTotali()+copieDaRegistrare);
		   l.setCopieDisponibili(l.getCopieDisponibili()+copieDaRegistrare);
		   
		} else{                     // se non esiste creiamo un nuovo libro da aggiungere alla mappa libri            
			
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
	
	public boolean prestaLibro(String serialNumber, String cf, Biblioteca b){
		
		Libro l= b.getLibri().get(serialNumber);
		
		Utente u= b.getUtenti().get(cf);
		
		if((l!=null)&&(u!=null)&&(u.getNumeroLibri()<3)&&(l.getCopieDisponibili()>0)){                              //se libro e utente esistono
			
			if(l.getCopieDisponibili()==0){
				System.out.println("Attenzione il libro non e' disponibile!");
			}
			
			if(u.getLibriInPrestito().size()<3){
				
				u.getLibriInPrestito().put(l.getSerialNumber(),l);
				l.setCopieDisponibili((l.getCopieDisponibili())-1);
				Date d = new Date();
				Prestito p = new Prestito(l,u,d,null);
				b.getPrestiti().add(p);
				
			}else 
				System.out.println("Attenzione ho gia 3 libri in prestito, non posso prenderne un altro!");
			
			return true;
			
		} else {
			System.out.println("Attenzione uno tra libro o utente non e' registrato!");
		    return false;
		}

	}
	
	public boolean restituzioneLibro(String serialNumber, String cf, String dataPrestito, Biblioteca b){
		Libro l= b.getLibri().get(serialNumber);
		
		Utente u=b.getUtenti().get(cf);
	
		if((l!=null && u!= null)){
			u.getLibriInPrestito().remove(l);
			
			return true;
		} else return false;
	}
	
/*	public Libro cercaLibro(String titolo,String autore, Biblioteca b){
        Libro l= null;
		
		for(Libro libro :b.getLibri().values()){
			if((libro.getTitolo().equals(titolo))&&(libro.getAutore().equals(autore))){
		        l=libro;
			
			}
		}
		return l;
	}*/
	
/*   public Utente cercaUtente(String nome, String cognome,Biblioteca b){
		Utente u= null;
		
		for(Utente utente : b.getUtenti()){
			if((utente.getNome().equals(nome))&&(utente.getCognome().equals(cognome))){
				u=utente;
			}
		}
		return u;
	}*/

}
