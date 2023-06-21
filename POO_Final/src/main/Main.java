package main;

import java.awt.EventQueue;

import Views.TelaPrincipal;
import controller.MainController;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					MainController.load();

					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
