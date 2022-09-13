package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ProdutoDAO;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable jTableListaDeProdutos;
	private ProdutoDAO produtoDao;
	private JTextField TextFieldCodigo;
	private double valorTotal, valorUnitario, quantidade;
	private ArrayList lista ;  
    private double total =0;
    private model.ModelTabela modelo;
    private JLabel jLabelValorTotal;
    private String descricao = "";
    
	public void preencherTabela() {
        try {
            int id = Integer.parseInt(TextFieldCodigo.getText());
            //descricao = jLabelNomeProduto.getText();
            //valorUnitario = Double.parseDouble(jTextFieldValorUnitario.getText());
            //quantidade = Double.parseDouble(jTextFieldQuantidade.getText());
            if(produtoDao.achar_produto(id) == null){
                JOptionPane.showMessageDialog(null, "Id de Produto Invalido");
            }else {
                valorTotal = valorUnitario * quantidade;
                total += valorTotal;
                jLabelValorTotal.setText(Double.toString(total));

                String[] colunas = new String[]{"ID", "Descrição", "V. unitário", "Quantidade", "V. total"};

                lista.add(new Object[]{id, descricao, valorUnitario, quantidade, valorTotal});

                modelo = new model.ModelTabela(lista, colunas);

                jTableListaDeProdutos.setModel(modelo);
                jTableListaDeProdutos.getColumnModel().getColumn(0).setPreferredWidth(40);
                jTableListaDeProdutos.getColumnModel().getColumn(0).setResizable(false);
                jTableListaDeProdutos.getColumnModel().getColumn(1).setPreferredWidth(203);
                jTableListaDeProdutos.getColumnModel().getColumn(1).setResizable(false);
                jTableListaDeProdutos.getColumnModel().getColumn(2).setPreferredWidth(70);
                jTableListaDeProdutos.getColumnModel().getColumn(2).setResizable(false);
                jTableListaDeProdutos.getColumnModel().getColumn(3).setPreferredWidth(78);
                jTableListaDeProdutos.getColumnModel().getColumn(3).setResizable(false);
                jTableListaDeProdutos.getColumnModel().getColumn(4).setPreferredWidth(70);
                jTableListaDeProdutos.getColumnModel().getColumn(4).setResizable(false);
                jTableListaDeProdutos.getTableHeader().setReorderingAllowed(false);
                jTableListaDeProdutos.setAutoResizeMode(jTableListaDeProdutos.AUTO_RESIZE_OFF);
                jTableListaDeProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                //jButtonConfirmar.setEnabled(true);
                //jTextFieldQuantidade.setEnabled(false);
                //jTextFieldValorUnitario.setEnabled(false);
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Digite apenas numeros e coloque ponto ' . ' em ver de virgula ' , '.");
        }

 }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTableListaDeProdutos = new JTable();
		jTableListaDeProdutos.setBounds(336, 158, -331, -154);
		contentPane.add(jTableListaDeProdutos);
		
		TextFieldCodigo = new JTextField();
		TextFieldCodigo.setBounds(0, 171, 86, 20);
		contentPane.add(TextFieldCodigo);
		TextFieldCodigo.setColumns(10);
		
		jLabelValorTotal = new JLabel("R$ 0.00");
		jLabelValorTotal.setBounds(325, 230, 81, 20);
		contentPane.add(jLabelValorTotal);
	}
}
