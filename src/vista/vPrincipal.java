package vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class vPrincipal extends JFrame {

	private JPanel contentPane;
	double ancho=Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	double alto=Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JToolBar barraHerramientas;
	vUsuario vusuario =new vUsuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vPrincipal frame = new vPrincipal();
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
	public vPrincipal() {
		setTitle("SISTEMA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH );
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 543, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cruds");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CRUD USUARIOS");
		mnNewMenu.add(mntmNewMenuItem);
		
		JToolBar toolBar = new JToolBar();
		mnNewMenu.add(toolBar);
		
		JButton btnNewButton = new JButton("CRUD USUARIOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vusuario.setVisible(true);
			}
		});
		toolBar.add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 64, 414, 186);
		contentPane.add(desktopPane);
		desktopPane.setSize((int)ancho,(int)alto);
		desktopPane.add(vusuario);
	}
}
