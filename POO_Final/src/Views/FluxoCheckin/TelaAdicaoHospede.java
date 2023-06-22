package Views.FluxoCheckin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.HospedagemController;
import controller.MainController;
import models.Hospede;

public class TelaAdicaoHospede extends JFrame implements Serializable {

	private static final long serialVersionUID = 4641340598900527116L;
	private JFrame frame;
	private JTextField txtInsiraApenasNmeros;
	private JTextField txtInsiraONome;
	private JTextField txtInsiraApenasNmeros_1;
	private JTextField txtopcional;
	private int ocupantes;
	private String numeroQuarto;
	private boolean primeiroHospede;

	/**
	 * Create the application.
	 * @param i 
	 * @param ocupantes 
	 * @param b 
	 */
	public TelaAdicaoHospede(int ocupantes, String numeroQuarto, boolean b) {
		this.ocupantes = ocupantes;
		this.numeroQuarto = numeroQuarto;
		primeiroHospede = b;
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
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(73, 66, 29, 13);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO HÓSPEDE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(131, 20, 175, 31);
		this.getContentPane().add(lblNewLabel_1);
		
		txtInsiraApenasNmeros = new JTextField();
		txtInsiraApenasNmeros.setText("Insira apenas números");
		txtInsiraApenasNmeros.setBounds(108, 64, 137, 19);
		this.getContentPane().add(txtInsiraApenasNmeros);
		txtInsiraApenasNmeros.setColumns(10);
		
		JButton btnNewButton = new JButton("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionVerificar();
			}
		});
		btnNewButton.setBounds(255, 63, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		txtInsiraONome = new JTextField();
		txtInsiraONome.setText("Insira o nome completo");
		txtInsiraONome.setBounds(108, 93, 137, 19);
		this.getContentPane().add(txtInsiraONome);
		txtInsiraONome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(61, 95, 41, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(44, 124, 59, 13);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(67, 156, 35, 13);
		this.getContentPane().add(lblNewLabel_4);
		
		txtInsiraApenasNmeros_1 = new JTextField();
		txtInsiraApenasNmeros_1.setText("Insira apenas números");
		txtInsiraApenasNmeros_1.setBounds(108, 122, 137, 19);
		this.getContentPane().add(txtInsiraApenasNmeros_1);
		txtInsiraApenasNmeros_1.setColumns(10);
		
		txtopcional = new JTextField();
		txtopcional.setText("(opcional)");
		txtopcional.setBounds(108, 154, 137, 19);
		this.getContentPane().add(txtopcional);
		txtopcional.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(73, 215, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.setBounds(255, 215, 85, 21);
		this.getContentPane().add(btnNewButton_2);
	}

	private void actionVerificar() {
		HospedagemController controller = MainController.getHospedagemController();
		
		try {
			Hospede hospede = controller.getHospede(txtInsiraApenasNmeros.getText());
			if(hospede != null) {
				txtInsiraONome.setText(hospede.getNome());
				txtInsiraApenasNmeros_1.setText(""+hospede.getTelefone());
				String email = hospede.getEmail();
				if(email != null) {
					txtopcional.setText(email);
				}
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Erro: " + e.getMessage(), "Erro ao buscar", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
