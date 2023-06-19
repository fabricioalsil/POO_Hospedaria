package Views.FluxoRegistrosHospedagem;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class TelaSelecionarAcomodacaoPagamento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSelecionarAcomodacaoPagamento window = new TelaSelecionarAcomodacaoPagamento();
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
	public TelaSelecionarAcomodacaoPagamento() {
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
		
		JLabel lblNewLabel = new JLabel("SELECIONAR ACOMODAÇÃO PAGAMENTO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(73, 20, 304, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JList list = new JList(); //INSERIR A LISTA DE ACOMODAÇÕES OCUPADAS <<<<<<<
		list.setBounds(151, 89, 1, 1);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(243, 205, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(97, 205, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

}
