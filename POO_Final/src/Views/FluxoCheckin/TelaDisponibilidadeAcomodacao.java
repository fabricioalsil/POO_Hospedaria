package Views.FluxoCheckin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class TelaDisponibilidadeAcomodacao {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDisponibilidadeAcomodacao window = new TelaDisponibilidadeAcomodacao();
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
	public TelaDisponibilidadeAcomodacao() {
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
		
		JLabel lblNewLabel = new JLabel("VERIFICAR DISPONIBILIDADE ACOMODAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 10, 340, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número de Hóspedes:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 73, 122, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 71, 60, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(252, 70, 45, 21);
		frame.getContentPane().add(btnNewButton);
		
		JList list = new JList(); //Adicionar uma lista exibindo todas as opções de acomodação disponiveis e seu respectivo preço
		list.setBounds(128, 137, 1, 1);
		frame.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.setBounds(252, 209, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(94, 209, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
	}
}
