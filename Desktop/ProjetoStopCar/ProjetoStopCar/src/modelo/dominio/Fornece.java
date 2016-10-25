package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "tabFornece")
public class Fornece implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_COMPRA", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_COMPRA", sequenceName = "SEQ_COMPRA", allocationSize = 1)
	private int codCompra;
	
	@Column (nullable = false)
	private Date dataCompra;
	
	@Column (length = 6, nullable = false)
	private float valorCompra;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Produto produto;
	
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
	
	@Override
	public Long getCod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCod(Long cod) {
		// TODO Auto-generated method stub
		
	}
        
}
