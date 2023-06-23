package Views.FluxoRegistrosHospedagem;

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
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import controller.CatalogoController;
import controller.HospedagemController;
import controller.MainController;
import enums.ETipoItem;
import models.Hospedagem;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaSelecionarCatalogo extends JFrame implements Serializable {

	private static final long serialVersionUID = -2128866272667041474L;
	private Hospedagem hospedagem;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JComboBox<String> comboBox;
	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Create the application.
	 */
	public TelaSelecionarCatalogo(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
		initialize();
	}

	private void initialize() {
		frame = this;
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATÁLOGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(157, 10, 94, 20);
		this.getContentPane().add(lblNewLabel);
		
		rdbtnNewRadioButton = new JRadioButton("Serviços");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton);
			}
		});
		rdbtnNewRadioButton.setBounds(65, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Produtos");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearRadioButton(rdbtnNewRadioButton_1);
			}
		});
		rdbtnNewRadioButton_1.setBounds(171, 71, 103, 21);
		this.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionOK();
			}
		});
		btnNewButton.setBounds(280, 71, 85, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionContinuar();
			}
		});
		btnNewButton_1.setBounds(267, 232, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(91, 232, 85, 21);
		this.getContentPane().add(btnNewButton_2);
			
		JLabel lblNewLabel_1 = new JLabel("Selecione a Categoria:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(65, 43, 164, 22);
		this.getContentPane().add(lblNewLabel_1);
						
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(269, 203, 83, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(157, 206, 94, 13);
		getContentPane().add(lblNewLabel_2);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		String[] colunas = {"Codigo", "Descricao", "Preco"};

        for (String coluna : colunas) {
        	tableModel.addColumn(coluna);
        }
		
		table.setModel(tableModel);
		table.setBounds(65, 102, 300, 86);
		getContentPane().add(table);
		
		initComboBox();
	}
	
	private void actionContinuar() {
		HospedagemController controller = MainController.getHospedagemController();
		try {
			String item = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
			controller.comprar(hospedagem, item, textField.getText());
			JOptionPane.showMessageDialog(frame, "Item adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Erro: Quantidade invalida", "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frame, "Erro: E necessario selecionar um produto", "Erro ao adicionar", JOptionPane.ERROR_MESSAGE);
		}
			
	}

	private void initComboBox() {
		CatalogoController controller = MainController.getCatalogoController();
		
		try {
			comboBox = new JComboBox<String>(new Vector<String>(controller.getCategorias()));
			comboBox.setBounds(190, 44, 175, 21);
			getContentPane().add(comboBox);
			
			
						
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Erro: E necessário cadastrar uma categoria primeiro", "Erro ao cadastrar", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
		}
	}
	
	private void actionOK() {
		CatalogoController controller = MainController.getCatalogoController();

		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
        }
		
		if(rdbtnNewRadioButton.isSelected()) {
			for (String[] linha : controller.getItens((String) comboBox.getSelectedItem(), ETipoItem.SERVICO)) {
	        	tableModel.addRow(linha);
			}
		}else if(rdbtnNewRadioButton_1.isSelected()) {
			for (String[] linha : controller.getItens((String) comboBox.getSelectedItem(), ETipoItem.PRODUTO)) {
	        	tableModel.addRow(linha);
			}
		}
	}
	
	private void clearRadioButton(JRadioButton button) {
		if(button == rdbtnNewRadioButton) {
			rdbtnNewRadioButton_1.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_1) {
			rdbtnNewRadioButton.setSelected(false);
						
		}
	}
}
