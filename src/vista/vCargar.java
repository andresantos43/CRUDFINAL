package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class vCargar extends JFrame {

	private JPanel contentPane;
	private JProgressBar prsCargando;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vCargar frame = new vCargar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void cargar () {
		Thread hilo=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i <=100; i++) {
					prsCargando.setValue(i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(i==100) {
						setVisible(false);
						vPrincipal p=new vPrincipal();
						p.setVisible(true);
					}
				}
			}
		});
		hilo.start();
	}
	public vCargar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 126);
		contentPane = new JPanel();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		prsCargando = new JProgressBar();
		prsCargando.setStringPainted(true);
		prsCargando.setBounds(0, 0, 557, 87);
		contentPane.add(prsCargando);
		cargar();
	}
}
