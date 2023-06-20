package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaPrincipal implements Serializable {

	private static final long serialVersionUID = 3455281041763317742L;
	
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Check-in");
		rdbtnNewRadioButton.setBounds(136, 76, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Checkout");
		rdbtnNewRadioButton_1.setBounds(136, 99, 127, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Registros Hospedagem");
		rdbtnNewRadioButton_2.setBounds(136, 122, 141, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Controle Interno");
		rdbtnNewRadioButton_3.setBounds(136, 145, 141, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setBounds(154, 184, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("MENU INICIAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(150, 34, 113, 21);
		frame.getContentPane().add(lblNewLabel);
	}
}
