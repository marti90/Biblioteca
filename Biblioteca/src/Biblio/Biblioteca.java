package Biblio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca implements ValidaDati{
	
	private String nome="";
	//private List<Libro> libri = new ArrayList<Libro>();
	//private List<Utente> utenti = new ArrayList<Utente>();
	private Map<String,Libro> libri=new HashMap<String,Libro>();
	private Map<String,Utente> utenti=new HashMap<String,Utente>();
	private List<Prestito> prestiti = new ArrayList<Prestito>();

	public Biblioteca(){
		
	}
	
	public Biblioteca(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Map<String, Libro> getLibri() {
		return libri;
	}

	public void setLibri(Map<String, Libro> libri) {
		this.libri = libri;
	}
	
	public void aggiungiLibro(Libro l){
		this.libri.put(l.getSerialNumber(), l);
	}
	
	public Map<String, Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(Map<String,Utente> utenti) {
		this.utenti = utenti;
	}
	
	public void aggiungiUtente(Utente u){
		this.utenti.put(u.getCf(), u);
	}

	public List<Prestito> getPrestiti() {
		return prestiti;
	}

	public void setPrestiti(List<Prestito> prestiti) {
		this.prestiti = prestiti;
	}

	@Override
	public boolean isValid() {

		boolean res = false;
		if (!nome.isEmpty() && nome != null) {
			res = true;
		}
		return res;
	}


}
