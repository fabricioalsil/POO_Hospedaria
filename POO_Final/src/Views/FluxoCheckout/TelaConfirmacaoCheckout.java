package Views.FluxoCheckout;

import java.awt.Font;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConfirmacaoCheckout extends JFrame implements Serializable {

	private static final long serialVersionUID = -592348124319785218L;
	//private JFrame frame;

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
		//frame = new JFrame();
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECK-OUT REALIZADO COM SUCESSO!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(72, 90, 311, 20);
		this.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Voltar ao Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(159, 131, 103, 21);
		this.getContentPane().add(btnNewButton);
	}

}
