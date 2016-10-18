package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabServico")
public class Servico {
	
	
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
	
}
