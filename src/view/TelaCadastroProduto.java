package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDescricao;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descrição");
		lblNewLabel.setBounds(10, 11, 69, 14);
		contentPane.add(lblNewLabel);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(10, 36, 314, 20);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setColumns(10);
		textFieldQuantidade.setBounds(10, 92, 86, 20);
		contentPane.add(textFieldQuantidade);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em estoque");
		lblQuantidadeEmEstoque.setBounds(10, 67, 142, 14);
		contentPane.add(lblQuantidadeEmEstoque);
		
		textFieldValor = new JTextField();
		textFieldValor.setColumns(10);
		textFieldValor.setBounds(174, 92, 86, 20);
		contentPane.add(textFieldValor);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(174, 67, 46, 14);
		contentPane.add(lblValor);
		
		JButton btnNewButtonProcurarFornecedor = new JButton("Procurar Fornecedor");
		btnNewButtonProcurarFornecedor.setBounds(270, 91, 174, 23);
		contentPane.add(btnNewButtonProcurarFornecedor);
		
		JButton btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.setBounds(7, 122, 89, 23);
		contentPane.add(btnNewButtonSalvar);
		
		JButton btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.setBounds(119, 122, 89, 23);
		contentPane.add(btnNewButtonEditar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(230, 123, 89, 23);
		contentPane.add(btnNewButtonCancelar);
	}

}
