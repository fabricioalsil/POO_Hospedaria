package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;

import models.Hospedagem;

public class TelaSelecionarCatalogo extends JFrame implements Serializable {

	private static final long serialVersionUID = -2128866272667041474L;
	private Hospedagem hospedagem;

	/**
	 * Create the application.
	 */
	public TelaSelecionarCatalogo(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATÁLOGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(157, 10, 94, 20);
		this.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Serviços");
		rdbtnNewRadioButton.setBounds(65, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Produtos");
		rdbtnNewRadioButton_1.setBounds(171, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(280, 71, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.setBounds(267, 232, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(91, 232, 85, 21);
		this.getContentPane().add(btnNewButton_2);
		
		JList list = new JList(); //EXIBIR LISTA DA CATEGORIA SELECIONADA(SERVICO OU PRODUTO)
		list.setBounds(197, 146, 1, 1);
		this.getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione a Categoria:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(65, 43, 164, 22);
		this.getContentPane().add(lblNewLabel_1);
	}
}
