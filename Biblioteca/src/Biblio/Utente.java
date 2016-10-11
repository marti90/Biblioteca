package Biblio;


import java.util.HashMap;

import java.util.Map;

public class Utente implements ValidaDati{
	
	private String nome="";
	private String cognome="";
	private String cf="";
	private boolean scaduti=false;
	
	private int id_Utente;
	
	private Map<String,Libro> libriInPrestito = new HashMap<String,Libro>();
	
	public Utente(){
		
	}
	
	public Utente(String nome, String cognome, String cf) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Map<String,Libro> getLibriInPrestito() {
		return libriInPrestito;
	}

	public void setLibriInPrestito(Map<String,Libro> libriInPrestito) {
		this.libriInPrestito = libriInPrestito;
	}
	
	public String toString(){
		return nome+" "+cognome;
	}
	
	public boolean isValid() {
		
		boolean res=false;
		if((!nome.isEmpty() && nome!=null)&&(!cognome.isEmpty() && cognome!=null) 
				&&(!cf.isEmpty() && cf!=null)){
			res=true;
		}
		return res;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}
	
	public int getNumeroLibri(){
		return libriInPrestito.size();
	}
	
	public void aggiungiLibro(Libro l){
		this.libriInPrestito.put(l.getSerialNumber(), l);
	}

	public boolean isScaduti() {
		return scaduti;
	}

	public void setScaduti(boolean scaduti) {
		this.scaduti = scaduti;
	}

	public int getId_Utente() {
		return id_Utente;
	}

	public void setId_Utente(int id_Utente) {
		this.id_Utente = id_Utente;
	}

}
