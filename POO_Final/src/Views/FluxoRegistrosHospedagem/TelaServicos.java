package Views.FluxoRegistrosHospedagem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class TelaServicos {

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
		
		JList list = new JList(); //EXIBIR LISTA DE ITENS
		list.setBounds(196, 116, 1, 1);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //permite selecionar varias opções
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(264, 216, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(83, 216, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
	}

}
