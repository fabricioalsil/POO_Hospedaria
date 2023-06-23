package Views.FluxoCheckout;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.HospedagemController;
import controller.MainController;
import models.Hospedagem;

public class TelaSelecionarAcomodacaoCheckout extends JFrame implements Serializable {

	private static final long serialVersionUID = 6756937045640783143L;
	private JFrame frame;
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
		frame = this;
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELECIONAR ACOMODAÇÃO CHECKOUT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(73, 20, 304, 20);
		this.getContentPane().add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});
		btnNewButton.setBounds(243, 205, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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

	protected void actionContinuar() {
		HospedagemController controller = MainController.getHospedagemController();
			
		try {
			String numeroAcomodacao = txtInsiraApenasNmeros.getText();
			Hospedagem hospedagem = controller.getHospedagem(numeroAcomodacao);
			if(hospedagem == null) {
				JOptionPane.showMessageDialog(this, "Erro: Nao ha hospedes para esse quarto no momento", "Erro na solitacao", JOptionPane.ERROR_MESSAGE);
			} else {
				TelaVerificarConta telaVerificarConta = new TelaVerificarConta(hospedagem);
				telaVerificarConta.setVisible(true);			
				frame.dispose();	
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro na solitacao", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
