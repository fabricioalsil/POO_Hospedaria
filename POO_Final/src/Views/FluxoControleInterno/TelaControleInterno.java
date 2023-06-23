package Views.FluxoControleInterno;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class TelaControleInterno extends JFrame implements Serializable {

	private static final long serialVersionUID = -961149028706264736L;
	//private JFrame frame;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Create the application.
	 */
	public TelaControleInterno() {
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
		
		JLabel lblNewLabel = new JLabel("CONTROLE INTERNO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(130, 10, 172, 20);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione uma opção:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(130, 58, 132, 20);
		this.getContentPane().add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Catálogo");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton);
			}
		});
		rdbtnNewRadioButton.setBounds(130, 84, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Acomodações");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton_1);
			}
		});
		rdbtnNewRadioButton_1.setBounds(130, 107, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});
		btnNewButton.setBounds(236, 154, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(87, 154, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		//frame.setVisible(true);
	}
	
	private void actionContinuar() {
		if(rdbtnNewRadioButton.isSelected()) {
			TelaItemCategoria telaItemCategoria = new TelaItemCategoria();
			telaItemCategoria.setVisible(true);
			dispose();
		}else if(rdbtnNewRadioButton_1.isSelected()) {
			TelaAcomodacao telaAcomodacao = new TelaAcomodacao();
			telaAcomodacao.setVisible(true);
			dispose();
		}
	}
	
	private void clearRadioButton(JRadioButton button) {
		if(button == rdbtnNewRadioButton) {
			rdbtnNewRadioButton_1.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_1) {
			rdbtnNewRadioButton.setSelected(false);
			
		}
	}
	
}
