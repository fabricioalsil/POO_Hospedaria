package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.HospedagemController;
import controller.MainController;
import models.Hospedagem;

public class TelaSelecionarSolicitação extends JFrame implements Serializable {

	private static final long serialVersionUID = 7116332691622616441L;
	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

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
		frame = this;
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Catálogo de Serviços/Produtos");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(132, 96, 206, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Realizar pagamento");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(132, 119, 206, 21);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});
		btnNewButton.setBounds(252, 211, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(95, 211, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número quarto:");
		lblNewLabel_2.setBounds(95, 166, 106, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(204, 163, 140, 19);
		this.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
	}
	
	private void actionContinuar() {
		HospedagemController controller = MainController.getHospedagemController();
		
		try {
			String numeroAcomodacao = txtInsiraApenasNmeros.getText();
			Hospedagem hospedagem = controller.getHospedagem(numeroAcomodacao);
			if(hospedagem == null) {
				JOptionPane.showMessageDialog(this, "Erro: O quarto nao existe ou nao ha hospedes no momento" , "Erro na solitacao", JOptionPane.ERROR_MESSAGE);
			}else {
				if(rdbtnNewRadioButton.isSelected()) {
					TelaSelecionarCatalogo telaSelecionarCatalogo = new TelaSelecionarCatalogo(hospedagem);
					telaSelecionarCatalogo.setVisible(true);
					frame.dispose();
					
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					TelaInserirPagamento telaInserirPagamento = new TelaInserirPagamento(hospedagem);
					telaInserirPagamento.setVisible(true);
					frame.dispose();
					
				}
			}
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro na solitacao", JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro na solitacao", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
