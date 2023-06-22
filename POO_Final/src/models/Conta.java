package models;
import java.io.Serializable;
import java.util.ArrayList;

import interfaces.IConta;

public class Conta implements IConta, Serializable {
	
	private static final long serialVersionUID = 3090048274608081644L;
	
	private ArrayList<ItemConta> itens = new ArrayList<>();

	public void addItem(Item item, int qtde) {
		itens.add(new ItemConta(item, qtde));
	}

	public void removeItem(int index) {
		itens.remove(index);
	}

	public double getTotal() {
		
		double total = 0;
		for (ItemConta itemConta : itens) {
			total += itemConta.getPreco();
		}
		
		return total;
	}
	
	public StringBuilder listar() {
		
		StringBuilder listarItens = new StringBuilder();
		
		for (ItemConta itemConta : itens) {
			listarItens.append(itemConta.getItem().getDescricao());
			listarItens.append("\tValor: R$");
			listarItens.append(itemConta.getItem().getPreco());
			listarItens.append("\n");
		}
		listarItens.append("> SUBTOTAL: R$" + getTotal() + "\n");
		
		return listarItens;
	}

}
