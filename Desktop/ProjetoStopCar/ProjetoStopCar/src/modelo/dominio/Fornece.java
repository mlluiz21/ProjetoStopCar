package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabFornece")
public class Fornece {
	
	
	private int codCompra;
	
	@Column (nullable = false)
	private Date dataCompra;
	
	@Column (length = 6, nullable = false)
	private float valorCompra;
	
    public Fornece (int codCompra, Date dataCompra, float valorCompra){
    	this.codCompra = codCompra;
    	this.dataCompra = dataCompra;
    	this.valorCompra = valorCompra;
    }

	public int getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(int codCompra) {
		this.codCompra = codCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public float getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(float valorCompra) {
		this.valorCompra = valorCompra;
	}
        
}
