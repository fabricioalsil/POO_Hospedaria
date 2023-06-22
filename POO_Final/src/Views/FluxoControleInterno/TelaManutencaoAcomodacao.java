package Views.FluxoControleInterno;

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

import controller.AcomodacaoController;
import controller.MainController;
import models.Acomodacao;

public class TelaManutencaoAcomodacao extends JFrame implements Serializable {

	private static final long serialVersionUID = 1265825657285107355L;
	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Create the application.
	 */
	public TelaManutencaoAcomodacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANUTENÇÃO ACOMODAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 10, 232, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número do quarto:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(81, 65, 108, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(193, 63, 121, 19);
		frame.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
		
		rdbtnNewRadioButton = new JRadioButton("Manutenção");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(193, 109, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Disponível");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setBounds(193, 132, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionAtualizar();
			}
		});
		btnNewButton.setBounds(226, 192, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(108, 192, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selecionar estado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(81, 112, 108, 13);
		frame.getContentPane().add(lblNewLabel_2);
	}

	private void actionAtualizar() {
		AcomodacaoController controller = MainController.getAcomodacaoController();	
		
		try {			
			if(rdbtnNewRadioButton.isSelected()) {
				controller.setStatus(txtInsiraApenasNmeros.getText(), true);
			}else if(rdbtnNewRadioButton_1.isSelected()) {
				controller.setStatus(txtInsiraApenasNmeros.getText(), false);
			}	
			JOptionPane.showMessageDialog(this, "Atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro ao encontra quarto", JOptionPane.ERROR_MESSAGE);
		}
	}
}
