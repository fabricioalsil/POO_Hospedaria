package Views.FluxoCheckout;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaSelecionarAcomodacaoCheckout extends JFrame implements Serializable {

	private static final long serialVersionUID = 6756937045640783143L;
	//private JFrame frame;
	private JTextField txtInsiraApenasNmeros;

	/**
	 * Create the application.
	 */
	public TelaSelecionarAcomodacaoCheckout() {
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
		
		JLabel lblNewLabel = new JLabel("SELECIONAR ACOMODAÇÃO CHECKOUT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(73, 20, 304, 20);
		this.getContentPane().add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBounds(243, 205, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(97, 205, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Número quarto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(61, 100, 98, 20);
		this.getContentPane().add(lblNewLabel_1);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(153, 102, 129, 19);
		this.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
	}
}
