package Views.FluxoCheckin;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TelaDisponibilidadeAcomodacao extends JFrame implements Serializable {

	private static final long serialVersionUID = 6721231452258466300L;
	//private JFrame frame;
	private JTextField textField;

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
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VERIFICAR DISPONIBILIDADE ACOMODAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 10, 340, 36);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número de Hóspedes:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 73, 122, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 71, 60, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(252, 70, 45, 21);
		this.getContentPane().add(btnNewButton);
		
		JList list = new JList(); //Adicionar uma lista exibindo todas as opções de acomodação disponiveis e seu respectivo preço
		list.setBounds(128, 137, 1, 1);
		this.getContentPane().add(list);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.setBounds(252, 209, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(94, 209, 85, 21);
		this.getContentPane().add(btnNewButton_2);
		
	}
}
