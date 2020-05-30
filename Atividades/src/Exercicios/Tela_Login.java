package Exercicios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Login frame = new Tela_Login();
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
	public Tela_Login() {
		setResizable(false);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBackground(Color.LIGHT_GRAY);
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsuario.setBounds(60, 22, 70, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBackground(Color.LIGHT_GRAY);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 16));
		lblSenha.setBounds(60, 96, 70, 30);
		contentPane.add(lblSenha);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		tfUsuario.setBounds(60, 53, 345, 33);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Arial", Font.PLAIN, 16));
		pfSenha.setBounds(60, 124, 345, 33);
		contentPane.add(pfSenha);
		
		JButton btnLogar = new JButton("ENTRAR");
		btnLogar.setBackground(Color.LIGHT_GRAY);
		btnLogar.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					Connection con = Conexao.testarConexao();
					
					String sql = "select *from dados_clientes where usuario=? and senha=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, tfUsuario.getText());
					stmt.setString(2, new String(pfSenha.getPassword()));
					
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
					Tela_Cadastro exibir = new Tela_Cadastro();
					exibir.setVisible(true);
					setVisible(false);
					
					}else {
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Incorretos!");
					}
					stmt.close();
					con.close();
							
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
		});
		btnLogar.setBounds(60, 167, 345, 49);
		contentPane.add(btnLogar);
	}
}
