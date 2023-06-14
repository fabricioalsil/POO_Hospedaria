import java.util.ArrayList;

public class Conta implements IConta {
	
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
