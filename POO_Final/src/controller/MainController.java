package controller;

import java.io.Serializable;

import persistence.Serializer;

public class MainController implements Serializable {

	private static final long serialVersionUID = -25595180939938054L;
	
	private static MainController instance;

	private CatalogoController catalogoController;
	private AcomodacaoController acomodacaoController;
	private HospedagemController hospedagemController;
	
	private MainController() {
		
		catalogoController = new CatalogoController();
		acomodacaoController = new AcomodacaoController();
		hospedagemController = new HospedagemController();
				
	}
	
	public static MainController getInstance() {
        if (instance == null) {
            load();
        }
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
	
	public static HospedagemController getHospedagemController() {
		return instance.hospedagemController;
	}
}
