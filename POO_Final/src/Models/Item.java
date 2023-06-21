package Models;

import java.io.Serializable;

import Enums.ETipoItem;

public class Item implements Serializable {
	
	private static final long serialVersionUID = -5892768973800124329L;
	
	private final long codigo;
	private final String descricao;
	private double preco;
	private ETipoItem tipo;
	
	public Item(long codigo, ETipoItem tipo, String descricao, double preco) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public long getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
