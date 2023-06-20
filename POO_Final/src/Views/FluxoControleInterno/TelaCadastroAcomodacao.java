package Views.FluxoControleInterno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class TelaCadastroAcomodacao {

	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JTextField txtInsiraApenasNmeros_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAcomodacao window = new TelaCadastroAcomodacao();
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
	public TelaCadastroAcomodacao() {
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
		
		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(84, 60, 55, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupação máx:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(46, 83, 93, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(102, 106, 37, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRAR ACOMODAÇÃO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(110, 10, 215, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(149, 58, 110, 19);
		frame.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
		
		txtInsiraApenasNmeros_1 = new JTextField();
		txtInsiraApenasNmeros_1.setText("Insira apenas números");
		txtInsiraApenasNmeros_1.setBounds(149, 81, 110, 19);
		frame.getContentPane().add(txtInsiraApenasNmeros_1);
		txtInsiraApenasNmeros_1.setColumns(10);
		
		JList list = new JList(); //INSERIR LISTA DE TIPOS DE ACOMODAÇÃO
		list.setBounds(149, 106, 1, 1);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(261, 219, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu");
		btnNewButton_1.setBounds(107, 219, 103, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

}
