package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class vAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vAlumno frame = new vAlumno();
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
	public vAlumno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(20, 11, 69, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblID = new JLabel("1");
		lblID.setBounds(144, 16, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(20, 47, 69, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo");
		lblNewLabel_3.setBounds(20, 83, 69, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Municipio");
		lblNewLabel_4.setBounds(20, 134, 69, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Semestre");
		lblNewLabel_5.setBounds(20, 180, 69, 25);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(132, 49, 97, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JComboBox cboGrupo = new JComboBox();
		cboGrupo.setBounds(132, 87, 97, 26);
		contentPane.add(cboGrupo);
		
		JComboBox cboGrupo_1 = new JComboBox();
		cboGrupo_1.setBounds(132, 135, 97, 26);
		contentPane.add(cboGrupo_1);
		
		JComboBox cboGrupo_2 = new JComboBox();
		cboGrupo_2.setBounds(132, 181, 97, 26);
		contentPane.add(cboGrupo_2);
	}
}
