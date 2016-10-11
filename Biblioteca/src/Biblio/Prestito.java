package Biblio;

import java.util.Date;

public class Prestito implements ValidaDati{
	
	private Libro l=null;
	private Utente u=null;
	private Date dataPrestito;
	private Date dataRestituzione;
	private Date dataScadenza;
	
	private int id_Prestito;
	
	public Prestito(){
		
	}
	
	public Prestito(Libro l, Utente u, Date dataPrestito, Date dataRestituzione, Date dataScadenza) {
		
		this.setL(l);
		this.setU(u);
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
		this.dataScadenza=dataScadenza;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public Date getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Libro getL() {
		return l;
	}

	public void setL(Libro l) {
		this.l = l;
	}

	public Utente getU() {
		return u;
	}

	public void setU(Utente u) {
		this.u = u;
	}

	public int getId_Prestito() {
		return id_Prestito;
	}

	public void setId_Prestito(int id_Prestito) {
		this.id_Prestito = id_Prestito;
	}
	
	

}
