package Views.FluxoRegistrosHospedagem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.HospedagemController;
import controller.MainController;
import models.Hospedagem;

public class TelaInserirPagamento extends JFrame implements Serializable {

    private static final long serialVersionUID = 6259099661714699281L;
    Hospedagem hospedagem;
    private JTextField txtR;
    private JFrame frame;
    private JTextArea textArea;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnNewRadioButton_1;
    private JRadioButton rdbtnNewRadioButton_2;
    private JRadioButton rdbtnNewRadioButton_3;

    public TelaInserirPagamento(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
        initialize();
    }

    private void initialize() {
        frame = this;
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("PAGAMENTO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(168, 10, 103, 20);
        this.getContentPane().add(lblNewLabel);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(27, 40, 207, 169);
        this.getContentPane().add(scrollPane);

        JButton btnNewButton_2 = new JButton("Cancelar");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNewButton_2.setBounds(85, 232, 85, 21);
        this.getContentPane().add(btnNewButton_2);

        JButton btnNewButton = new JButton("Adicionar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionAdicionar();
            }
        });
        btnNewButton.setBounds(260, 232, 85, 21);
        this.getContentPane().add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("Adicionar Pagamento:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(260, 45, 121, 13);
        this.getContentPane().add(lblNewLabel_1);

        rdbtnNewRadioButton = new JRadioButton("PIX");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clearRadioButton(rdbtnNewRadioButton);
            }
        });

        rdbtnNewRadioButton.setBounds(260, 64, 103, 21);
        this.getContentPane().add(rdbtnNewRadioButton);

        rdbtnNewRadioButton_1 = new JRadioButton("Crédito");
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clearRadioButton(rdbtnNewRadioButton_1);
            }
        });
        rdbtnNewRadioButton_1.setBounds(260, 87, 103, 21);
        this.getContentPane().add(rdbtnNewRadioButton_1);

        rdbtnNewRadioButton_2 = new JRadioButton("Débito");
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clearRadioButton(rdbtnNewRadioButton_2);
            }
        });
        rdbtnNewRadioButton_2.setBounds(260, 110, 103, 21);
        this.getContentPane().add(rdbtnNewRadioButton_2);

        rdbtnNewRadioButton_3 = new JRadioButton("Estorno");
        rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	clearRadioButton(rdbtnNewRadioButton_3);
            }
        });
        rdbtnNewRadioButton_3.setBounds(260, 133, 103, 21);
        this.getContentPane().add(rdbtnNewRadioButton_3);

        JLabel lblNewLabel_2 = new JLabel("Valor:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(260, 167, 45, 13);
        this.getContentPane().add(lblNewLabel_2);

        txtR = new JTextField();
        txtR.setText("0,00");
        txtR.setBounds(296, 167, 114, 19);
        this.getContentPane().add(txtR);
        txtR.setColumns(10);

        extrato();
    }

    private void actionAdicionar() {
        HospedagemController controller = MainController.getHospedagemController();

        try {
            String tipoPagamento = null;

            if (rdbtnNewRadioButton.isSelected()) {
                tipoPagamento = rdbtnNewRadioButton.getText();
            } else if (rdbtnNewRadioButton_1.isSelected()) {
                tipoPagamento = rdbtnNewRadioButton_1.getText();
            } else if (rdbtnNewRadioButton_2.isSelected()) {
                tipoPagamento = rdbtnNewRadioButton_2.getText();
            } else if (rdbtnNewRadioButton_3.isSelected()) {
                tipoPagamento = rdbtnNewRadioButton_3.getText();
            }

            controller.addPagamento(hospedagem, tipoPagamento, txtR.getText());
            extrato();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro ao adicionar pagamento", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void extrato() {
        HospedagemController controller = MainController.getHospedagemController();

        textArea.setText(null);
        textArea.append(controller.getExtrato(hospedagem));

    }
    
    private void clearRadioButton(JRadioButton button) {
		if(button == rdbtnNewRadioButton) {
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_1) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button == rdbtnNewRadioButton_2) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_3.setSelected(false);
			
		}else if(button ==rdbtnNewRadioButton_3) {
			rdbtnNewRadioButton.setSelected(false);
			rdbtnNewRadioButton_1.setSelected(false);
			rdbtnNewRadioButton_2.setSelected(false);
		}
	}
}