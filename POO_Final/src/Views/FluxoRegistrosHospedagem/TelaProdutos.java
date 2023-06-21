package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class TelaProdutos extends JFrame implements Serializable {

	private static final long serialVersionUID = -1989051228745031504L;
	//private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public TelaProdutos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUTOS DISPONÍVEIS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(125, 10, 188, 20);
		this.getContentPane().add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(188, 216, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(67, 216, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar");
		btnNewButton_2.setBounds(311, 216, 85, 21);
		this.getContentPane().add(btnNewButton_2);
		
		JList list = new JList(); //INSERIR LISTA DE ITENS
		list.setBounds(188, 92, 1, 1);
		this.getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(111, 169, 75, 20);
		this.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setBounds(188, 171, 96, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
