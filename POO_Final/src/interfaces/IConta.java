package interfaces;
import models.Item;

public interface IConta {
	
	public void addItem(Item item, int qtde);
	public void removeItem(int index);
	public double getTotal();
	public StringBuilder listar();
	
}
