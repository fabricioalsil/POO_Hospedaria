package Views.FluxoRegistrosHospedagem;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInserirPagamento {

	private JFrame frame;
	private JTextField txtR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserirPagamento window = new TelaInserirPagamento();
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
	public TelaInserirPagamento() {
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
		
		JLabel lblNewLabel = new JLabel("PAGAMENTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(168, 10, 103, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 40, 207, 169);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setBounds(69, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(186, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar Pagamento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(260, 45, 121, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("PIX");
		rdbtnNewRadioButton.setBounds(260, 64, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Crédito");
		rdbtnNewRadioButton_1.setBounds(260, 87, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Débito");
		rdbtnNewRadioButton_2.setBounds(260, 110, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Estorno");
		rdbtnNewRadioButton_3.setBounds(260, 133, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(260, 167, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtR = new JTextField();
		txtR.setText("0,00");
		txtR.setBounds(296, 167, 114, 19);
		frame.getContentPane().add(txtR);
		txtR.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.setBounds(296, 232, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
	}

}
