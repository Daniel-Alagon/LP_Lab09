package Lab09ej01;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class EmpleadoAppGUI extends JFrame {
    private static final String ARCHIVO_EMPLEADOS = "C:\\universidad\\LPIII\\Lab09ej01\\empleados.txt";
    private List<Empleado> empleados;
    private DefaultTableModel tableModel;

    public EmpleadoAppGUI() {
        empleados = new ArrayList<>();
        tableModel = new DefaultTableModel();

        try {
            cargarEmpleados();
        } catch (IOException e) {
            e.printStackTrace();
        }

        initComponents();
    }

    private void initComponents() {
        setTitle("Aplicación de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Configurar la tabla
        JTable empleadoTable = new JTable(tableModel);
        tableModel.addColumn("Número");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Sueldo");

        JScrollPane scrollPane = new JScrollPane(empleadoTable);

        // Configurar el panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Número del Empleado:"));
        JTextField numeroField = new JTextField();
        inputPanel.add(numeroField);

        inputPanel.add(new JLabel("Nombre del Empleado:"));
        JTextField nombreField = new JTextField();
        inputPanel.add(nombreField);

        inputPanel.add(new JLabel("Sueldo del Empleado:"));
        JTextField sueldoField = new JTextField();
        inputPanel.add(sueldoField);

        JButton agregarButton = new JButton("Agregar Empleado");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(numeroField.getText());
                    String nombre = nombreField.getText();
                    double sueldo = Double.parseDouble(sueldoField.getText());

                    Empleado nuevoEmpleado = new Empleado(numero, nombre, sueldo);
                    empleados.add(nuevoEmpleado);

                    // Agregar el nuevo empleado al archivo
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_EMPLEADOS, true))) {
                        bw.write(numero + "," + nombre + "," + sueldo);
                        bw.newLine();
                    }

                    // Actualizar la tabla
                    Object[] rowData = {numero, nombre, sueldo};
                    tableModel.addRow(rowData);
                } catch (IOException | NumberFormatException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(EmpleadoAppGUI.this, "Error al agregar empleado: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        inputPanel.add(agregarButton);

        // Configurar el panel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        add(panel);

        // Mostrar el reporte inicial
        reporteEmpleados();
    }

    private void cargarEmpleados() throws IOException {
        File archivo = new File(ARCHIVO_EMPLEADOS);
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    int numero = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    double sueldo = Double.parseDouble(partes[2]);
                    Empleado empleado = new Empleado(numero, nombre, sueldo);
                    empleados.add(empleado);
                    Object[] rowData = {numero, nombre, sueldo};
                    tableModel.addRow(rowData);
                }
            }
        }
    }

    private void reporteEmpleados() {
        System.out.println("Reporte de empleados:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNumero() + "\t" + empleado.getNombre() + "\t" + empleado.getSueldo());
        }
    }
}