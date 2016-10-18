package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tabProdutos")
public class Produto {
	
	
	private Long codProduto;
	
	@Column (length = 50, nullable = false)
	private String nomeProduto;
	
	@Column (length = 30, nullable = false)
	private String tipoDeProduto;
	
	@Column (length = 50, nullable = false)
	private String descricaoProduto;
	
	@Column (length = 5, nullable = false)
	private int quantDoProdutoEmEstoque;
	
//	public Produto(){
//		
//	}

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
}
