package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaSelecionarSolicitação extends JFrame implements Serializable {

	private static final long serialVersionUID = 7116332691622616441L;
	//private JFrame frame;
	private JTextField txtInsiraApenasNmeros;

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
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Catálogo de Serviços/Produtos");
		rdbtnNewRadioButton.setBounds(132, 96, 168, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Realizar pagamento");
		rdbtnNewRadioButton_1.setBounds(132, 119, 124, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("SELECIONAR SOLICITAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(122, 10, 216, 30);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha a opção desejada:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(132, 77, 168, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(252, 211, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(95, 211, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número quarto:");
		lblNewLabel_2.setBounds(122, 166, 79, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(204, 163, 113, 19);
		this.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
	}

}
