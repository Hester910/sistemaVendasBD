package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FornecedorDAO;
import model.Fornecedor;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRazaoSocial;
	private JButton btnNewButtonPesquisar;
	private JButton btnNewButtonSalvar;
	private JButton btnNewButtonEditar;
	private JButton btnNewButtonCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 126);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldRazaoSocial = new JTextField();
		textFieldRazaoSocial.setBounds(10, 23, 316, 20);
		contentPane.add(textFieldRazaoSocial);
		textFieldRazaoSocial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Razão social");
		lblNewLabel.setBounds(10, 0, 87, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButtonPesquisar = new JButton("Pesquisar");
		btnNewButtonPesquisar.setBounds(339, 22, 94, 23);
		contentPane.add(btnNewButtonPesquisar);
		
		btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textFieldRazaoSocial.getText();
				if(nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Digite o nome do fornecedor");
				}else {
					Fornecedor fornecedor = new Fornecedor(nome);
					FornecedorDAO fornecedorDAO = new FornecedorDAO();
					fornecedorDAO.inserirFornecedor(fornecedor);
				}
			}
		});
		btnNewButtonSalvar.setBounds(20, 54, 89, 23);
		contentPane.add(btnNewButtonSalvar);
		
		btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.setBounds(128, 54, 89, 23);
		contentPane.add(btnNewButtonEditar);
		
		btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonCancelar.setBounds(227, 54, 89, 23);
		contentPane.add(btnNewButtonCancelar);
	}
}
