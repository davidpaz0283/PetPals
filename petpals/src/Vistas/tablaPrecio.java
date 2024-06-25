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

import Controlador.PrecioControlador;
import Modelo.Precio;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class tablaPrecio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private PrecioControlador controlador;
    private JLabel elemento;
    private PrecioControlador seleccionado;
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
    public tablaPrecio() {
    	this.setVisible(true);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        controlador = new PrecioControlador();
        Precio seleccionado = new Precio();
       

      
        String[] columnNames = {"id", "tarifa_corte_de_pelo", "tarifa_paseos","tarifa_baños","tarifa_alojamiento"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizartablaPrecio();
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
					
        			controlador.deletePrice(seleccionado.getId());
        			JOptionPane.showMessageDialog(null, "Eliminado");
        			 actualizartablaPrecio();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un precio");
				}
        		
        	}
        });
        btnEliminar.setBounds(60, 280, 166, 58);
        contentPane.add(btnEliminar);
        
        Editar = new JButton("Editar Precio");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			EditarPrecio editarPrecio = new EditarPrecio(seleccionado);
        			dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un precio");
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
        menuBar.setBounds(150, 220, 101, 22);
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
                        String Tarifa_corte_de_pelo = (String) table.getValueAt(selectedRow, 1);
                        String Tarifa_paseos = (String) table.getValueAt(selectedRow, 2);
                        String Tarifa_baños = (String) table.getValueAt(selectedRow, 3);
                        String Tarifa_alojamiento = (String) table.getValueAt(selectedRow, 4);
                        elemento.setText("Seleccionado: id=" + id + ", tarifa_corte_de_pelo=" + Tarifa_corte_de_pelo + ", tarifa_paseos=" + Tarifa_paseos + ", tarifa_baños=" + Tarifa_baños + ", tarifa_alojamiento=" + Tarifa_alojamiento );
                        seleccionado.setTarifa_corte_de_pelo(Tarifa_corte_de_pelo);
                        seleccionado.setTarifa_paseos(Tarifa_paseos);
                        seleccionado.setTarifa_baños(Tarifa_baños);
                        seleccionado.setTarifa_alojamiento(Tarifa_alojamiento);
                        seleccionado.setId(id);
                
                    }
                }
            }
        });
    }

    private void actualizartablaPrecio() {
        
        model.setRowCount(0);

        
        List<Precio> precios = controlador.getAllPrice();

        
        for (Precio precio : precios) {
            model.addRow(
            		new Object[]
            				{
            						  precio.getId()
            						, precio.getTarifa_corte_de_pelo()
            						, precio.getTarifa_paseos()
            						, precio.getTarifa_baños()
            						, precio.getTarifa_alojamiento()
            				}
            		
            		    		);
        }
        
    }
}
    

