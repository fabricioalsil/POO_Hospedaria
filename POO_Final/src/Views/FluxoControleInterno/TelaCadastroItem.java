package Views.FluxoControleInterno;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.CatalogoController;
import controller.MainController;
import enums.ETipoItem;

public class TelaCadastroItem extends JFrame implements Serializable {

	private static final long serialVersionUID = -1845066834468929705L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JComboBox<ETipoItem> comboBox;
	JComboBox<String> comboBox_1;

	/**
	 * Create the application.
	 */
	public TelaCadastroItem() {
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
		
		JLabel lblNewLabel = new JLabel("CADASTRAR ITEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(143, 10, 141, 20);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(116, 76, 45, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(126, 99, 35, 13);
		this.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(102, 122, 59, 13);
		this.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(102, 145, 59, 13);
		this.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(116, 168, 35, 13);
		this.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(171, 74, 96, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
				
		textField_1 = new JTextField();
		textField_1.setBounds(171, 143, 96, 19);
		this.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("0.00");
		textField_2.setBounds(171, 166, 96, 19);
		this.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionCadastrar();
			}
		});
		
		btnNewButton.setBounds(232, 215, 120, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar ao Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(73, 215, 120, 21);
		this.getContentPane().add(btnNewButton_1);
		
		initJComboBox();
		
	}
	
	private void initJComboBox() {
		CatalogoController controller = MainController.getCatalogoController();
			
		comboBox = new JComboBox<ETipoItem>(ETipoItem.values());
		comboBox.setBounds(171, 96, 96, 21);
		this.getContentPane().add(comboBox);
		
		try{
			comboBox_1 = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
			comboBox_1.setBounds(171, 119, 96, 21);
			this.getContentPane().add(comboBox_1);
			
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Erro: É necessário cadastrar uma categoria primeiro", "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
	}
	
	private void actionCadastrar() {
		CatalogoController controller = MainController.getCatalogoController();
		      
        try {
        	ETipoItem tipo = (ETipoItem) comboBox.getSelectedItem();
            String categoria = (String) comboBox_1.getSelectedItem();
            String codigo = textField.getText();
            String descricao = textField_1.getText();
            String preco = textField_2.getText();
            
            controller.addItem(categoria, tipo, codigo, descricao, preco);
            JOptionPane.showMessageDialog(this, "Item cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	
        } catch (NumberFormatException e) {
        	JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        	
        } catch(NullPointerException e) {
        	JOptionPane.showMessageDialog(this, "Erro: É necessário cadastrar uma categoria primeiro", "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
        	frame.dispose();
        }catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
}
