package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRazaoSocial;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JLabel lblBairro;
	private JTextField textFieldBairro;
	private JLabel lblCidade;
	private JTextField textFieldCidade;
	private JLabel lblEstado;
	private JTextField textFieldEstado;
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
		setBounds(100, 100, 459, 247);
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
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(10, 77, 316, 20);
		contentPane.add(textFieldRua);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(10, 54, 87, 14);
		contentPane.add(lblRua);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(336, 77, 92, 20);
		contentPane.add(textFieldNumero);
		
		JLabel lblNmero = new JLabel("Número");
		lblNmero.setBounds(336, 54, 92, 14);
		contentPane.add(lblNmero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 111, 92, 14);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(10, 134, 92, 20);
		contentPane.add(textFieldBairro);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(113, 111, 92, 14);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(113, 134, 92, 20);
		contentPane.add(textFieldCidade);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(215, 111, 92, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		textFieldEstado.setBounds(215, 134, 92, 20);
		contentPane.add(textFieldEstado);
		
		btnNewButtonPesquisar = new JButton("Pesquisar");
		btnNewButtonPesquisar.setBounds(339, 22, 94, 23);
		contentPane.add(btnNewButtonPesquisar);
		
		btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.setBounds(10, 174, 89, 23);
		contentPane.add(btnNewButtonSalvar);
		
		btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.setBounds(113, 174, 89, 23);
		contentPane.add(btnNewButtonEditar);
		
		btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(225, 174, 89, 23);
		contentPane.add(btnNewButtonCancelar);
	}
}
