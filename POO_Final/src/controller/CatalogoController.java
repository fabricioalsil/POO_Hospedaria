package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Models.Categoria;
import Models.Item;

public class CatalogoController implements Serializable {

	private static final long serialVersionUID = 5328919611273653058L;

	private Map<String, Categoria> categorias;
	private Map<Long, Item> itens;

	public CatalogoController() {

		categorias = new TreeMap<>();
		itens = new TreeMap<>();
	}

	public void addCategoria(String nome) {

		categorias.put(nome, new Categoria(nome));	// insere novo objeto categoria no map categorias
		MainController.save();
	}

	public Set<String> getCategorias() {
		return categorias.keySet();	 // retorna lista das chaves do map categorias
	}

	public void addItem(String nomeCategoria, int codigo, String descricao, double preco) {

		Categoria categoria = categorias.get(nomeCategoria);  // retorna objeto Categoria para chave do map

		Item item = new Item(codigo, descricao, preco);

		itens.put(item.getCodigo(), item);

		if (categoria != null)
			categoria.addItem(item);

		MainController.save();
	}

	public List<String> getItens() {

		List<String> lista = new ArrayList<>();

		for (Item item : itens.values()) {
			lista.add(String.format("%d\t%s\t%.2f", item.getCodigo(), item.getDescricao(), item.getPreco()));
		}

		return lista;
	}

	public List<String> getItens(String nomeCategoria) {

		Categoria categoria = categorias.get(nomeCategoria);
		
		List<String> lista = new ArrayList<>();

		for (Item item : categoria.getItens())
			lista.add(String.format("%d\t%s\t%.2f", item.getCodigo(), item.getDescricao(), item.getPreco()));

		return lista;
	}
}
