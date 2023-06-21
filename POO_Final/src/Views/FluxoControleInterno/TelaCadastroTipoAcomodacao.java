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

import controller.AcomodacaoController;
import controller.MainController;

public class TelaCadastroTipoAcomodacao extends JFrame implements Serializable {

	private static final long serialVersionUID = 6566570562715538878L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextArea textArea;

	/**
	 * Create the application.
	 */
	public TelaCadastroTipoAcomodacao() {
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
		
		JLabel lblNewLabel = new JLabel("CADASTRAR TIPO DE ACOMODAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(71, 10, 284, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(27, 48, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(67, 46, 174, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		
		btnNewButton.setBounds(302, 81, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(27, 121, 255, 119);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton_1 = new JButton("Listar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});
		
		btnNewButton_1.setBounds(302, 123, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Diária: R$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(251, 48, 57, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setText("0,00");
		textField_1.setBounds(307, 46, 80, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Acompanhante: R$");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(71, 84, 113, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setText("0,00");
		textField_2.setBounds(186, 82, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Voltar ao Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(302, 219, 103, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	private void actionCadastrar() {
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		try {
			String nome = textField.getText();
			String diaria = textField_1.getText();
			String acompanhante = textField_2.getText();
			
			controller.addTipoAcomodacao(nome, diaria, acompanhante);
			JOptionPane.showMessageDialog(frame, "Tipo de acomodacao cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(frame, "Erro: " + e.getMessage(), "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void actionListar() {
		AcomodacaoController controller = MainController.getAcomodacaoController();

		textArea.setText(null);
		for (String nomeTipo : controller.getTipoAcomodacao()) {
			textArea.append(String.format("%s\n", nomeTipo));
		}
	}
}
