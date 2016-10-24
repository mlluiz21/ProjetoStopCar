package modelo.dominio;

import java.io.Serializable;

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
@Table (name = "tabProdutos")
public class Produto implements CodigoSequencial, Serializable{
	
	@Id
	@GeneratedValue (generator = "COD_PRODUTO", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator (name = "COD_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
	private Long codProduto;
	
	@Column (length = 50, nullable = false)
	private String nomeProduto;
	
	@Column (length = 30, nullable = false)
	private String tipoDeProduto;
	
	@Column (length = 50, nullable = false)
	private String descricaoProduto;
	
	@Column (length = 5, nullable = false)
	private int quantDoProdutoEmEstoque;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	private Servico servico;
	
	public Produto(){
		
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTipoDeProduto() {
		return tipoDeProduto;
	}

	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getQuantDoProdutoEmEstoque() {
		return quantDoProdutoEmEstoque;
	}

	public void setQuantDoProdutoEmEstoque(int quantDoProdutoEmEstoque) {
		this.quantDoProdutoEmEstoque = quantDoProdutoEmEstoque;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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
