package Views.FluxoCheckout;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaVerificarConta extends JFrame implements Serializable {

	private static final long serialVersionUID = 783922877834338726L;
	//private JFrame frame;
	private JTable table;
	private JTextField txtR;

	/**
	 * Create the application.
	 */
	public TelaVerificarConta() {
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
		
		JLabel lblNewLabel = new JLabel("CONTA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(196, 10, 57, 20);
		this.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 40, 207, 169);
		this.getContentPane().add(textArea);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(85, 232, 85, 21);
		this.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(246, 232, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar Pagamento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(260, 45, 121, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PIX");
		rdbtnNewRadioButton.setBounds(260, 64, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Crédito");
		rdbtnNewRadioButton_1.setBounds(260, 87, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Débito");
		rdbtnNewRadioButton_2.setBounds(260, 110, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Estorno");
		rdbtnNewRadioButton_3.setBounds(260, 133, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(260, 167, 45, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		txtR = new JTextField();
		txtR.setText("0,00");
		txtR.setBounds(296, 167, 114, 19);
		this.getContentPane().add(txtR);
		txtR.setColumns(10);
		
		
		
	}
}
