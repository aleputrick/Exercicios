package Exercicios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Tela_Cadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Cadastro frame = new Tela_Cadastro();
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
	public Tela_Cadastro() {
		setTitle("Tela de Dados Dos Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLExemplo = new JLabel("AQUI FICAR\u00C3O OS ");
		JLExemplo.setFont(new Font("Arial", Font.BOLD, 30));
		JLExemplo.setBounds(72, 52, 284, 90);
		contentPane.add(JLExemplo);
		
		JLabel lblDadosDosClientes = new JLabel("DADOS DOS CLIENTES");
		lblDadosDosClientes.setFont(new Font("Arial", Font.BOLD, 30));
		lblDadosDosClientes.setBounds(43, 110, 350, 90);
		contentPane.add(lblDadosDosClientes);
	}
}
