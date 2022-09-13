package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldSenha;
	private JTextField textFieldCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 31, 161, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 62, 46, 14);
		contentPane.add(lblSenha);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(10, 82, 161, 20);
		textFieldSenha.setColumns(10);
		contentPane.add(textFieldSenha);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 113, 46, 14);
		contentPane.add(lblCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(10, 133, 161, 20);
		textFieldCpf.setColumns(10);
		contentPane.add(textFieldCpf);
		
		JButton btnNewButtonSalvar = new JButton("Salvar");
		btnNewButtonSalvar.setBounds(218, 30, 89, 23);
		contentPane.add(btnNewButtonSalvar);
		
		JButton btnNewButtonEditar = new JButton("Editar");
		btnNewButtonEditar.setBounds(218, 79, 89, 23);
		contentPane.add(btnNewButtonEditar);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setBounds(216, 132, 89, 23);
		contentPane.add(btnNewButtonCancelar);
	}

}
