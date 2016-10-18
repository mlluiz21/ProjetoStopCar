package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name = "tabServico")
public class Servico implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_SERVICO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private int codServico;
	
	@Column (length = 30, nullable = false)
	private String tipoSerico;
	
	@Column (nullable = false)
	private Date dataHoraEntrada;
	
	@Column (nullable = false)
	private Date dataHoraSaida;
	
	public Servico (int codServico, String tipoServico, Date dataHoraEntrada, Date dataHoraSaida){
		this.codServico = codServico;
		this.tipoSerico = tipoServico;
		this.dataHoraEntrada = dataHoraEntrada;
		this.dataHoraSaida = dataHoraSaida;
		
	}

	public int getCodServico() {
		return codServico;
	}

	public void setCodServico(int codServico) {
		this.codServico = codServico;
	}

	public String getTipoSerico() {
		return tipoSerico;
	}

	public void setTipoSerico(String tipoSerico) {
		this.tipoSerico = tipoSerico;
	}

	public Date getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(Date dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public Date getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(Date dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
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
