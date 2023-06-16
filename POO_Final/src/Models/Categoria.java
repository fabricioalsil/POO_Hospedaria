package Models;
import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1121605513746373182L;
	
	private final String nome;
	private ArrayList<Item> itens = new ArrayList<>();
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public void addItem(Item item) {
		itens.add(item);
	}

	public void removeItem(int index) {
		itens.remove(index);
	}

	public String getNome() {
		return nome;
	}
	
	public StringBuilder listar() {
		
		StringBuilder sb = new StringBuilder();

		for (Item item : itens) {
			sb.append(item.getDescricao());
			sb.append("\n");
		}
		
		return sb;
	}
}
