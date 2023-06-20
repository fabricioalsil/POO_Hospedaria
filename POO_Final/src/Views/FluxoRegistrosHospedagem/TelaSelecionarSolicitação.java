package Views.FluxoRegistrosHospedagem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaSelecionarSolicitação implements Serializable {

	private static final long serialVersionUID = 7116332691622616441L;
	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecionarSolicitação window = new TelaSelecionarSolicitação();
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
	public TelaSelecionarSolicitação() {
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Catálogo de Serviços/Produtos");
		rdbtnNewRadioButton.setBounds(132, 96, 168, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Realizar pagamento");
		rdbtnNewRadioButton_1.setBounds(132, 119, 124, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("SELECIONAR SOLICITAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(122, 10, 216, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha a opção desejada:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(132, 77, 168, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(252, 211, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(95, 211, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número quarto:");
		lblNewLabel_2.setBounds(122, 166, 79, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(204, 163, 113, 19);
		frame.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
	}

}
