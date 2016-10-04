package Biblio;

import java.util.Date;

public class Prestito implements ValidaDati{
	
	Libro l=null;
	Utente u=null;
	private Date dataPrestito;
	private Date dataRestituzione;
	
	public Prestito(){
		
	}
	
	public Prestito(Libro l, Utente u, Date dataPrestito, Date dataRestituzione) {
		
		this.l = l;
		this.u = u;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
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
	
	

}
