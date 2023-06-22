package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import controller.CatalogoController;
import controller.MainController;
import models.Hospedagem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaSelecionarCatalogo extends JFrame implements Serializable {

	private static final long serialVersionUID = -2128866272667041474L;
	private Hospedagem hospedagem;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox<String> comboBox;
	private JFrame frame;

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
		frame = this;
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATÁLOGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(157, 10, 94, 20);
		this.getContentPane().add(lblNewLabel);
		
		rdbtnNewRadioButton = new JRadioButton("Serviços");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(65, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Produtos");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(171, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(280, 71, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.setBounds(267, 232, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(91, 232, 85, 21);
		this.getContentPane().add(btnNewButton_2);
			
		JLabel lblNewLabel_1 = new JLabel("Selecione a Categoria:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(65, 43, 164, 22);
		this.getContentPane().add(lblNewLabel_1);
			
		initComboBox();
	}
	
	private void initComboBox() {
		CatalogoController controller = MainController.getCatalogoController();
		
		try {
			comboBox = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
			comboBox.setBounds(190, 44, 175, 21);
			getContentPane().add(comboBox);
			
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Erro: É necessário cadastrar uma categoria primeiro", "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
	}
	
}
