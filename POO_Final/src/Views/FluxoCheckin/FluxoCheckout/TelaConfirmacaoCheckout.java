package Views.FluxoCheckin.FluxoCheckout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaConfirmacaoCheckout {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConfirmacaoCheckout window = new TelaConfirmacaoCheckout();
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
	public TelaConfirmacaoCheckout() {
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
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT REALIZADO COM SUCESSO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(72, 90, 311, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.setBounds(159, 131, 103, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
