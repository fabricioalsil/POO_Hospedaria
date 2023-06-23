package Views.FluxoControleInterno;

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
	//private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JTextField txtInsiraApenasNmeros_1;
	private JComboBox<String> comboBox;

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
		
		//frame = new JFrame();
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(84, 60, 55, 13);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ocupação máx:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(46, 83, 93, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(102, 106, 37, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRAR ACOMODAÇÃO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(110, 10, 215, 20);
		this.getContentPane().add(lblNewLabel_3);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(149, 58, 110, 20);
		this.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
		
		txtInsiraApenasNmeros_1 = new JTextField();
		txtInsiraApenasNmeros_1.setText("Insira apenas números");
		txtInsiraApenasNmeros_1.setBounds(149, 81, 110, 19);
		this.getContentPane().add(txtInsiraApenasNmeros_1);
		txtInsiraApenasNmeros_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		btnNewButton.setBounds(261, 219, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(107, 219, 103, 21);
		this.getContentPane().add(btnNewButton_1);
		
		initJComboBox();
		
	}
	
	private void initJComboBox() {
		
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		comboBox = new JComboBox<String>(new Vector<String>(controller.getTipoAcomodacao())); 
		comboBox.setBounds(149, 103, 110, 20);
		this.getContentPane().add(comboBox);
		
	}

	private void actionCadastrar() {
		
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		String numero = txtInsiraApenasNmeros.getText();
		String ocupacao = txtInsiraApenasNmeros_1.getText();
		String tipo = (String) comboBox.getSelectedItem();
		
		try {
			controller.addAcomodacao(numero, ocupacao, tipo);
			JOptionPane.showMessageDialog(this, "Acomodacao cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
		}			
	}
}
