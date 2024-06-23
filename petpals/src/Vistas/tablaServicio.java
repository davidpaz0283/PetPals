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

import Controlador.ServicioControlador;
import Modelo.Servicio;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class tablaServicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private ServicioControlador controlador;
    private JLabel elemento;
    private ServicioControlador seleccionado;
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
    public tablaServicio() {
    	this.setVisible(true);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        controlador = new ServicioControlador();
        Servicio seleccionado = new Servicio();
       

      
        String[] columnNames = {"id", "alojamiento", "baño","corte_de_pelo","paseo"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizartablaServicio();
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
					
        			controlador.deleteService(seleccionado.getId());
        			JOptionPane.showMessageDialog(null, "Eliminado");
        			 actualizartablaServicio();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un servicio");
				}
        		
        	}
});
        btnEliminar.setBounds(150, 280, 187, 58);
        contentPane.add(btnEliminar);
        
        Editar = new JButton("Editar Servicio");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			EditarServicio editarServicio = new EditarServicio(seleccionado);
        			dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un servicio");
				}
        		
        	}
        });
        Editar.setBounds(500, 280, 166, 58);
        contentPane.add(Editar);
        
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
                        String corte_de_pelo = (String) table.getValueAt(selectedRow, 1);
                        String baño = (String) table.getValueAt(selectedRow, 2);
                        String paseo = (String) table.getValueAt(selectedRow, 3);
                        String alojamiento = (String) table.getValueAt(selectedRow, 4);
                        elemento.setText("Seleccionado: id=" + id + ", Corte_de_pelo=" + corte_de_pelo + ", Baño=" + baño + ", Paseo=" + paseo + ", Alojamiento=" + alojamiento );
                        seleccionado.setCorte_de_pelo(corte_de_pelo);
                        seleccionado.setBaño(baño);
                        seleccionado.setPaseo(paseo);
                        seleccionado.setAlojamiento(alojamiento);
                        seleccionado.setId(id);
                
                    }
                }
            }
        });
    }

    private void actualizartablaServicio() {
        
        model.setRowCount(0);

        
        List<Servicio> servicios = controlador.getAllService();

        
        for (Servicio servicio : servicios) {
            model.addRow(
            		new Object[]
            				{
            						  servicio.getId()
            						, servicio.getCorte_de_pelo()
            						, servicio.getBaño()
            						, servicio.getPaseo()
            						, servicio.getAlojamiento()
            				}
            		
            		    		);
        }
    }
}
