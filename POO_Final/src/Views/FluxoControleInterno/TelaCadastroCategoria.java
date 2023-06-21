package Views.FluxoControleInterno;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.CatalogoController;
import controller.MainController;

public class TelaCadastroCategoria extends JFrame implements Serializable {

	private static final long serialVersionUID = -6042173958072169649L;
	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Create the application.
	 */
	public TelaCadastroCategoria() {
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
		
		JLabel lblNewLabel = new JLabel("CADASTRAR CATEGORIA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(120, 10, 196, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(27, 48, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(67, 46, 221, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		btnNewButton.setBounds(313, 45, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 85, 261, 155);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});
		btnNewButton_1.setBounds(313, 87, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar ao Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(313, 219, 113, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	private void actionCadastrar () {

		CatalogoController controller = MainController.getCatalogoController();

		String nome = textField.getText();

		controller.addCategoria(nome);
		JOptionPane.showMessageDialog(frame, "Categoria cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		
		limparForm();
	}
	
	private void actionListar() {
		CatalogoController controller = MainController.getCatalogoController();

		textArea.setText(null);
		for (String nomeCategoria : controller.getCategorias()) {
			textArea.append(String.format("%s\n", nomeCategoria));
		}
	}
	
	private void limparForm() {
		textField.setText("");
	}

}
