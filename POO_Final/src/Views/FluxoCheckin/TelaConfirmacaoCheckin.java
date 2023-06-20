package Views.FluxoCheckin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;

public class TelaConfirmacaoCheckin implements Serializable {

	private static final long serialVersionUID = 8333899366496520507L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmacaoCheckin window = new TelaConfirmacaoCheckin();
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
	public TelaConfirmacaoCheckin() {
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
		
		JLabel lblNewLabel = new JLabel("CHECK-IN REALIZADO COM SUCESSO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(83, 107, 288, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.setBounds(157, 154, 103, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
