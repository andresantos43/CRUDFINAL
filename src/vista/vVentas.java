package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Usuario;
import dao.douUsuario;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class vVentas extends JFrame {
	douUsuario dou=new douUsuario();
	int fila= -1;
	DefaultTableModel modelo=new DefaultTableModel();
	ArrayList<Usuario>lista=new ArrayList<Usuario>();
	private JTable tblUsuario;
	Usuario usuario=new Usuario();
	private JLabel lblEmpleado;
	private JLabel lblID;
	private JLabel lblCliente;
	private JTextField txtMonto;
	private JTextField txtFecha;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vVentas frame = new vVentas();
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
	public vVentas() {
		setTitle("CRUD VENTAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 499);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblID = new JLabel("1");
		lblID.setBounds(127, 32, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_1 = new JLabel("Empleado");
		lblNewLabel_1.setBounds(10, 60, 67, 14);
		contentPane.add(lblNewLabel_1);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(385, 11, 86, 20);
		contentPane.add(txtMonto);
		txtMonto.setColumns(10); 
		
		JLabel lblNewLabel_1_1 = new JLabel("Cliente");
		lblNewLabel_1_1.setBounds(10, 99, 79, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(385, 57, 86, 20);
		contentPane.add(txtFecha);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario user=new Usuario();
					user.setUser(txtMonto.getText());
					user.setPassword(txtFecha.getText());
					if(dou.insertarUsuario(user)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "SE AGREGO CORRERTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				}catch(Exception ex ) {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}
		});
		btnAgregar.setBounds(0, 188, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(txtMonto.getText().equals("")||txtFecha.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"campos vacios");
						return;
					}
		
					usuario.setUser(txtMonto.getText());
					usuario.setPassword(txtFecha.getText());
					if(dou.editarUsuario(usuario)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "SE EDITO CORRERTAMENTE");
					}else {
						JOptionPane.showMessageDialog(null, "ERROR");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERROR");
					
				}
				
			}
		});
		btnEditar.setBounds(110, 188, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int opcion = JOptionPane.showConfirmDialog(null, "ESTAS SEGURO DE ELIMINAR ESTE USUARIO?");
					if(opcion ==0) {
						
					}
				if(dou.eliminarUsuario(lista.get(fila).getId())) {
					actualizarTabla();
					JOptionPane.showMessageDialog(null, "ELIMNAR CORRECTAMENTE!!");
				}else {
					JOptionPane.showMessageDialog(null, "ERROR");
				}
			}catch(Exception ex ) {
				JOptionPane.showMessageDialog(null, "ERROR");
			}
			}
		});
		btnEliminar.setBounds(213, 188, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(335, 188, 89, 23);
		contentPane.add(btnBorrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 222, 383, 227);
		contentPane.add(scrollPane);
		
		tblUsuario = new JTable();
		tblUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila=tblUsuario.getSelectedRow();
				usuario=lista.get(fila);
				lblID.setText(""+usuario.getId());
				txtMonto.setText(usuario.getUser());
				txtFecha.setText(usuario.getPassword());
			}
		});
		tblUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblUsuario);

	modelo.addColumn("ID");
	modelo.addColumn("USER");
	modelo.addColumn("PASSWORD");
	modelo.addColumn("NOMBRE");
	tblUsuario.setModel(modelo);
	
	lblEmpleado = new JLabel("1");
	lblEmpleado.setBounds(127, 60, 46, 14);
	contentPane.add(lblEmpleado);
	
	lblCliente = new JLabel("1");
	lblCliente.setBounds(127, 99, 46, 14);
	contentPane.add(lblCliente);
	
	JLabel lblNewLabel_2 = new JLabel("Monto");
	lblNewLabel_2.setBounds(291, 14, 46, 14);
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("Fecha");
	lblNewLabel_3.setBounds(291, 60, 46, 14);
	contentPane.add(lblNewLabel_3);
	actualizarTabla();
	}
	public void actualizarTabla () {
		while(modelo.getRowCount()>0) {
			modelo.removeRow(0);
		}
		lista=dou.fetchUsusarios();
		for(Usuario u: lista) {
			Object o[]=new Object[4];
			o[0]=u.getId();
			o[1]=u.getUser();
			o[2]=u.getPassword();
			o[3]=u.getNombre();
			modelo.addRow(o);
		}
		tblUsuario.setModel(modelo);
	}
	
	}

