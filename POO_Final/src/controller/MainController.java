package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	private static final long serialVersionUID = -25595180939938054L;
	
	private static MainController instance;

	private CatalogoController catalogoController;
	private AcomodacaoController acomodacaoController;
	
	public static MainController getInstance() {
		return instance;
	}
	
	public static void load() {

		instance = Serializer.readFile();

		if (instance == null) {
			instance = new MainController();
		}
	}

	public static void save() {
		Serializer.writeFile(instance);
	}

	public static CatalogoController getCatalogoController() {
		return instance.catalogoController;
	}
	
	public static AcomodacaoController getAcomodacaoController() {
		return instance.acomodacaoController;
	}
}
