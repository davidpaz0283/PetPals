package Vistas;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlador.RegistroControlador;
import Modelo.Registro;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class tablaRegistro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private RegistroControlador controlador;
    private JLabel elemento;
    private RegistroControlador seleccionado;
    private JButton Editar;
   
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla frame = new tabla();
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
    public tablaRegistro() {
    	this.setVisible(true);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        controlador = new RegistroControlador();
        Registro seleccionado = new Registro();
       

      
        String[] columnNames = {"id", "nombre_mascota", "edad_mascota","especie"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizartablaRegistro();
        contentPane.setLayout(null);
        
       
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 19, 911, 190);
        contentPane.add(scrollPane);

        
        elemento = new JLabel("Seleccionado:");
        elemento.setBounds(5, 5, 911, 14);
        contentPane.add(elemento);
        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			controlador.deleteRegister(seleccionado.getId());
        			JOptionPane.showMessageDialog(null, "Eliminado");
        			 actualizartablaRegistro();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un Registro");
				}
        		
        	}
});
        btnEliminar.setBounds(60, 280, 166, 58);
        contentPane.add(btnEliminar);
        
        Editar = new JButton("Editar Registro");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			EditarRegistro editarRegistro = new EditarRegistro(seleccionado);
        			dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un Registro");
				}
        		
        	}
        });
        Editar.setBounds(330, 280, 166, 58);
        contentPane.add(Editar);
        
        JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		salir.setBounds(600, 280, 166, 58);
		contentPane.add(salir);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(15, 220, 101, 22);
        contentPane.add(menuBar);
       

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int id = (int) table.getValueAt(selectedRow, 0);
                        String nombre_mascota = (String) table.getValueAt(selectedRow, 1);
                        String edad_mascota = (String) table.getValueAt(selectedRow, 2);
                        String especie = (String) table.getValueAt(selectedRow, 3);
                        
                        elemento.setText("Seleccionado: id=" + id + ", Nombre_mascota=" + nombre_mascota + ", Edad_mascota=" + edad_mascota + ", Especie=" + especie);
                        seleccionado.setNombre_mascota(nombre_mascota);
                        seleccionado.setEdad_mascota(edad_mascota);
                        seleccionado.setEspecie(especie);
                        seleccionado.setId(id);
                
                    }
                }
            }
        });
    }

    private void actualizartablaRegistro() {
        
        model.setRowCount(0);

        
        List<Registro> Registros = controlador.getAllRegister();

        
        for (Registro Registro : Registros) {
            model.addRow(
            		new Object[]
            				{
            						  Registro.getId()
            						, Registro.getNombre_mascota()
            						, Registro.getEdad_mascota()
            						, Registro.getEspecie()
            						
            				}
            		
            		    		);
        }
    }
}