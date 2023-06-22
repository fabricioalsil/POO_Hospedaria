package Views.FluxoCheckin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.AcomodacaoController;
import controller.MainController;

public class TelaDisponibilidadeAcomodacao extends JFrame implements Serializable {

	private static final long serialVersionUID = 6721231452258466300L;
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Create the application.
	 */
	public TelaDisponibilidadeAcomodacao() {
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
		
		JLabel lblNewLabel = new JLabel("VERIFICAR DISPONIBILIDADE ACOMODAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 10, 340, 36);
		this.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número de Hóspedes:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 73, 122, 13);
		this.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 71, 60, 19);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionListar();
			}
		});
		btnNewButton.setBounds(252, 70, 45, 21);
		this.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(252, 209, 85, 21);
		this.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(94, 209, 85, 21);
		this.getContentPane().add(btnNewButton_2);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		String[] colunas = {"Quarto", "Ocupacao Maxima", "Diaria", "Taxa Acompanhante"};

        for (String coluna : colunas) {
        	tableModel.addColumn(coluna);
        }
        
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(94, 110, 243, 89);
		getContentPane().add(table);
		
	}

	private void actionListar() {
		AcomodacaoController controller = MainController.getAcomodacaoController();
		
		String ocupantes = textField.getText();
		
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
        }
		
		try {
			// Adiciona as linhas ao modelo de tabela
	        for (String[] linha : controller.getDisponibilidade(ocupantes)) {
	        	tableModel.addRow(linha);
	        }
	        
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Erro: " + e.getMessage(), "Erro ao buscar", JOptionPane.ERROR_MESSAGE);
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(frame, "Erro: Nenhum quarto disponivel para o valor informado.", "Erro ao buscar", JOptionPane.ERROR_MESSAGE);
		}
	}
}
