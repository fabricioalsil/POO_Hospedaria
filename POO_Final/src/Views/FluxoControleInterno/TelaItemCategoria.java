package Views.FluxoControleInterno;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TelaItemCategoria {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaItemCategoria window = new TelaItemCategoria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaItemCategoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ITEM/CATEGORIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(130, 10, 172, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione uma opção:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(130, 58, 132, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cadastrar Item");
		rdbtnNewRadioButton.setBounds(130, 84, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Cadastrar Categoria");
		rdbtnNewRadioButton_1.setBounds(130, 107, 132, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(236, 154, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(87, 154, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

}
