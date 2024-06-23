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

import Controlador.SuministroControlador;
import Modelo.Suministro;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class tablaSuministro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private SuministroControlador controlador;
    private JLabel elemento;
    private SuministroControlador seleccionado;
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
    public tablaSuministro() {
    	this.setVisible(true);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 909, 452);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        controlador = new SuministroControlador();
        Suministro seleccionado = new Suministro();
       

      
        String[] columnNames = {"id", "suministro_peluqueria", "suministro_higiene","suministro_paseos","suministro_alojamiento"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizartablaSuministro();
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
					
        			controlador.deleteSupply(seleccionado.getId());
        			JOptionPane.showMessageDialog(null, "Eliminado");
        			 actualizartablaSuministro();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un Suministro");
				}
        		
        	}
});
        btnEliminar.setBounds(150, 280, 187, 58);
        contentPane.add(btnEliminar);
        
        Editar = new JButton("Editar Suministro");
        Editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		if (seleccionado.getId()!=0) {
					
        			EditarSuministro editarSuministro = new EditarSuministro(seleccionado);
        			dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un Suministro");
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
                        String Suministro_peluqueria = (String) table.getValueAt(selectedRow, 1);
                        String Suministro_higiene = (String) table.getValueAt(selectedRow, 2);
                        String Suministro_paseos = (String) table.getValueAt(selectedRow, 3);
                        String Suministro_alojamiento = (String) table.getValueAt(selectedRow, 4);
                        elemento.setText("Seleccionado: id=" + id + ", suministro_peluqueria=" + Suministro_peluqueria + ", suministro_higiene=" + Suministro_higiene + ", suministro_paseos=" + Suministro_paseos + ", suministro_alojamiento=" + Suministro_alojamiento );
                        seleccionado.setSuministro_peluqueria(Suministro_peluqueria);
                        seleccionado.setSuministro_higiene(Suministro_higiene);
                        seleccionado.setSuministro_paseos(Suministro_paseos);
                        seleccionado.setSuministro_alojamiento(Suministro_alojamiento);
                        seleccionado.setId(id);
                
                    }
                }
            }
        });
    }

    private void actualizartablaSuministro() {
        
        model.setRowCount(0);

        
        List<Suministro> Suministros = controlador.getAllSupply();

        
        for (Suministro Suministro : Suministros) {
            model.addRow(
            		new Object[]
            				{
            						  Suministro.getId()
            						, Suministro.getSuministro_peluqueria()
            						, Suministro.getSuministro_higiene()
            						, Suministro.getSuministro_paseos()
            						, Suministro.getSuministro_alojamiento()
            				}
            		
            		    		);
        }
    }
}

