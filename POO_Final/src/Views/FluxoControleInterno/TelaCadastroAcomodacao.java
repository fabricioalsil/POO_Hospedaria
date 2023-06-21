package Views.FluxoControleInterno;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AcomodacaoController;
import controller.MainController;

public class TelaCadastroAcomodacao extends JFrame implements Serializable {

	private static final long serialVersionUID = 1248853447842650386L;
	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JTextField txtInsiraApenasNmeros_1;
	private JComboBox<String> comboBox;

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
		txtInsiraApenasNmeros.setBounds(149, 58, 110, 20);
		frame.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
		
		txtInsiraApenasNmeros_1 = new JTextField();
		txtInsiraApenasNmeros_1.setText("Insira apenas números");
		txtInsiraApenasNmeros_1.setBounds(149, 81, 110, 19);
		frame.getContentPane().add(txtInsiraApenasNmeros_1);
		txtInsiraApenasNmeros_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		btnNewButton.setBounds(261, 219, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(107, 219, 103, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		initJComboBox();
		
	}
	
	private void initJComboBox() {
		
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		comboBox = new JComboBox<String>(new Vector<String>(controller.getTipoAcomodacao())); 
		comboBox.setBounds(149, 103, 110, 20);
		frame.getContentPane().add(comboBox);
		
	}

	private void actionCadastrar() {
		
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		try {
			int numero = Integer.parseInt(txtInsiraApenasNmeros.getText());
			
			try {
				int ocupacao = Integer.parseInt(txtInsiraApenasNmeros.getText());
				String tipo = (String) comboBox.getSelectedItem();
				controller.addAcomodacao(numero, ocupacao, tipo);
				JOptionPane.showMessageDialog(frame, "Cadastrado com sucesso");
				
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "Valor inválido para a ocupacao maxima! Certifique-se de fornecer um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(frame, "Valor inválido para o numero da acomodacao! Certifique-se de fornecer um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
		}		
	}
}
