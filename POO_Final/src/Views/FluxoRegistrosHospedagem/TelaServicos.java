package Views.FluxoRegistrosHospedagem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class TelaServicos extends JFrame implements Serializable {

	private static final long serialVersionUID = 2789391640248414272L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServicos window = new TelaServicos();
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
	public TelaServicos() {
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
		
		JLabel lblNewLabel = new JLabel("SERVIÇOS DISPONÍVEIS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(125, 10, 188, 20);
		frame.getContentPane().add(lblNewLabel);
				
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(188, 216, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(67, 216, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Finalizar");
		btnNewButton_2.setBounds(311, 216, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JList list = new JList(); //INSERIR LISTA DE ITENS
		list.setBounds(188, 92, 1, 1);
		frame.getContentPane().add(list);
	}

}
