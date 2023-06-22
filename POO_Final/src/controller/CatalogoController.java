package controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import enums.ETipoItem;
import models.Categoria;
import models.Item;

public class CatalogoController implements Serializable {

	private static final long serialVersionUID = 5328919611273653058L;

	private Map<String, Categoria> categorias;
	private Map<Long, Item> itens;

	public CatalogoController() {

		categorias = new TreeMap<>();
		itens = new TreeMap<>();
	}

	public void addCategoria(String nome) {
		if(categorias.get(nome) == null) {
			categorias.put(nome, new Categoria(nome));	// insere novo objeto categoria no map categorias
			MainController.save();
		}
	}

	public Set<String> getCategorias() {
		return categorias.keySet();	 // retorna lista das chaves do map categorias
	}

	public void addItem(String nomeCategoria, ETipoItem tipo, String codigoString, String descricao, String precoString) throws NumberFormatException, Exception {

		Categoria categoria = categorias.get(nomeCategoria);  // retorna objeto Categoria para chave do map

		try {
            long codigo = Long.parseLong(codigoString);
            
            try {
                double preco = Double.parseDouble(precoString); 
                
                //Formata o valor para 0.00
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String valorFormatado = decimalFormat.format(preco);
                NumberFormat numberFormat = NumberFormat.getInstance();
                double valorFormatadoDouble = numberFormat.parse(valorFormatado).doubleValue();
                
                Item item = new Item(codigo, tipo, descricao, valorFormatadoDouble);
                itens.put(item.getCodigo(), item);
        		categoria.addItem(item);
                                
            } catch (NumberFormatException e) {
            	throw new NumberFormatException("O preco digitado nao e um valor valido.");
            }
        } catch (NumberFormatException e) {
        	throw new NumberFormatException("O codigo digitado nao e um numero valido.");
        }

		MainController.save();
	}

	public List<String> getItens() {

		List<String> lista = new ArrayList<>();

		for (Item item : itens.values()) {
			lista.add(String.format("%d\t%s\t%.2f", item.getCodigo(), item.getDescricao(), item.getPreco()));
		}

		return lista;
	}

	public List<String> getItens(String nomeCategoria, ETipoItem tipo) {

		Categoria categoria = categorias.get(nomeCategoria);
		
		List<String> lista = new ArrayList<>();

		for (Item item : categoria.getItens())
			lista.add(String.format("%d\t%s\t%.2f", item.getCodigo(), item.getDescricao(), item.getPreco()));

		return lista;
	}
	
	public Item getItem(long codigo) {
		return itens.get(codigo);
	}
}
