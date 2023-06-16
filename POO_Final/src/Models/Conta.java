package Models;
import java.io.Serializable;
import java.util.ArrayList;

import Interfaces.IConta;

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
		
		StringBuilder sb = new StringBuilder();
		
		for (ItemConta itemConta : itens) {
			sb.append(itemConta.getItem().getDescricao());
			sb.append("; Valor: ");
			sb.append(itemConta.getItem().getPreco());
			sb.append("\n");
		}
		sb.append("Total: " + getTotal());
		sb.append("\n");
		
		return sb;
	}

}
