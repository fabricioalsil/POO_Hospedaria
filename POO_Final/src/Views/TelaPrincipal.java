package Views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import Views.FluxoCheckin.TelaDisponibilidadeAcomodacao;
import Views.FluxoCheckout.TelaSelecionarAcomodacaoCheckout;
import Views.FluxoControleInterno.TelaControleInterno;
import Views.FluxoRegistrosHospedagem.TelaSelecionarSolicitação;

public class TelaPrincipal extends JFrame implements Serializable {

	private static final long serialVersionUID = 3455281041763317742L;
	
	//private JFrame frame;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Check-in");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton);
			}
		});
		rdbtnNewRadioButton.setBounds(136, 76, 180, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Checkout");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton_1);
			}
		});
		rdbtnNewRadioButton_1.setBounds(136, 99, 180, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Registros Hospedagem");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton_2);
			}
		});
		rdbtnNewRadioButton_2.setBounds(136, 122, 180, 21);
		this.getContentPane().add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Controle Interno");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton_3);
			}
		});
		rdbtnNewRadioButton_3.setBounds(136, 145, 180, 21);
		this.getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});
		
		btnNewButton.setBounds(154, 184, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("MENU INICIAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(150, 34, 113, 21);
		this.getContentPane().add(lblNewLabel);
		
		//this.setVisible(true);
	}
	
	private void actionContinuar() {
		if(rdbtnNewRadioButton.isSelected()) {
			TelaDisponibilidadeAcomodacao telaDisponibilidadeAcomodacao = new TelaDisponibilidadeAcomodacao();
			telaDisponibilidadeAcomodacao.setVisible(true);
		
		}else if(rdbtnNewRadioButton_1.isSelected()) {
			TelaSelecionarAcomodacaoCheckout telaSelecionarAcomodacaoCheckout = new TelaSelecionarAcomodacaoCheckout();
			telaSelecionarAcomodacaoCheckout.setVisible(true);
		
		}else if(rdbtnNewRadioButton_2.isSelected()) {
			TelaSelecionarSolicitação telaSelecionarSolicitação = new TelaSelecionarSolicitação();
			telaSelecionarSolicitação.setVisible(true);
		
		}else if(rdbtnNewRadioButton_3.isSelected()) {
			TelaControleInterno telaControleInterno = new TelaControleInterno();
			telaControleInterno.setVisible(true);
		
		}
	}
	
	private void clearRadioButton(JRadioButton button) {
		if(button == rdbtnNewRadioButton) {
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_1) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_2) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button ==rdbtnNewRadioButton_3) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
		}
	}
	
}
