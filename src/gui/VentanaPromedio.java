package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

import clases.Procesos;
import clases.ModeloDatos;
import entidades.Estudiante;

public class VentanaPromedio extends JFrame implements ActionListener {

    private JTextField txtMateria;
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private JLabel lblResultado;
    private JButton btnConsultaIndividual;
    private JButton btnLista;
    private JButton btnEliminar;
    private JButton btnActualizar;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    Procesos misProcesos;
    ModeloDatos miModeloDatos;

    public VentanaPromedio() {
        misProcesos = new Procesos();
        miModeloDatos = new ModeloDatos();
        setTitle("Promedio estudiantes");
        setSize(659, 620);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblTitulo = new JLabel("SISTEMA CONTROL DE NOTAS");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 26, 606, 59);

        JLabel lblMateria = new JLabel("Materia:");
        lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMateria.setBounds(348, 100, 72, 22);

        txtMateria = new JTextField();
        txtMateria.setBounds(430, 100, 180, 19);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(106, 100, 201, 19);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombre.setBounds(24, 100, 72, 22);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDocumento.setBounds(24, 130, 80, 22);

        txtDocumento = new JTextField();
        txtDocumento.setColumns(10);
        txtDocumento.setBounds(106, 130, 201, 19);

        txtNota1 = new JTextField();
        txtNota1.setColumns(10);
        txtNota1.setBounds(106, 162, 96, 19);

        JLabel lblNota1 = new JLabel("Nota1:");
        lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNota1.setBounds(24, 159, 72, 22);

        txtNota2 = new JTextField();
        txtNota2.setColumns(10);
        txtNota2.setBounds(309, 165, 96, 19);

        JLabel lblNota2 = new JLabel("Nota2:");
        lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNota2.setBounds(227, 162, 72, 22);

        txtNota3 = new JTextField();
        txtNota3.setColumns(10);
        txtNota3.setBounds(513, 165, 96, 19);

        JLabel lblNota3 = new JLabel("Nota3:");
        lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNota3.setBounds(431, 162, 72, 22);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblResultado.setBounds(24, 215, 586, 22);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(24, 250, 130, 21);
        btnCalcular.addActionListener(this);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(164, 250, 130, 21);
        btnLimpiar.addActionListener(this);

        btnConsultaIndividual = new JButton("Consultar");
        btnConsultaIndividual.setBounds(304, 250, 130, 21);
        btnConsultaIndividual.addActionListener(this);

        btnLista = new JButton("Lista");
        btnLista.setBounds(444, 250, 130, 21);
        btnLista.addActionListener(this);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(24, 282, 130, 21);
        btnEliminar.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(164, 282, 130, 21);
        btnActualizar.addActionListener(this);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 320, 586, 250);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        add(lblTitulo);
        add(lblMateria);
        add(txtMateria);
        add(btnLimpiar);
        add(btnCalcular);
        add(lblResultado);
        add(lblNota3);
        add(txtNota3);
        add(lblNota2);
        add(txtNota2);
        add(lblNota1);
        add(txtNota1);
        add(lblNombre);
        add(txtNombre);
        add(lblDocumento);
        add(txtDocumento);
        add(btnConsultaIndividual);
        add(btnLista);
        add(btnEliminar);
        add(btnActualizar);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            System.out.println("Calcular");
            calcular();
        } else if (e.getSource() == btnLimpiar) {
            System.out.println("Limpiar");
            limpiar();
        } else if (e.getSource() == btnConsultaIndividual) {
            consultaIndividual();
        } else if (e.getSource() == btnLista) {
            consultarLista();
        } else if (e.getSource() == btnEliminar) {
            eliminar();
        } else if (e.getSource() == btnActualizar) {
            actualizar();
        }
    }

    private void calcular() {
        Estudiante miEstudiante = new Estudiante();
        miEstudiante.setNombre(txtNombre.getText());
        miEstudiante.setDocumento(txtDocumento.getText());
        miEstudiante.setMateria(txtMateria.getText());
        miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
        miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
        miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));

        double promedio = misProcesos.calcularPromedio(miEstudiante);
        miEstudiante.setPromedio(promedio);

        if (promedio != -1) {
            if (promedio < 3.5) {
                lblResultado.setText("Resultado: " + "Hola " + miEstudiante.getNombre() + ", su promedio es: " + promedio + " - PIERDE");
                lblResultado.setForeground(Color.red);
            } else {
                lblResultado.setText("Resultado: " + "Hola " + miEstudiante.getNombre() + ", su promedio es: " + promedio);
                lblResultado.setForeground(Color.blue);
            }
            String registro = miModeloDatos.registrarEstudiante(miEstudiante);
            if (!registro.equals("ok")) {
                JOptionPane.showMessageDialog(null, registro, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            lblResultado.setText("Revise los datos, porq no pueden ser negativos ni mayores a 5");
            lblResultado.setForeground(Color.red);
        }

        System.out.println("EL promedio es: " + promedio);
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtMateria.setText("");
        txtNota1.setText("0");
        txtNota2.setText("0");
        txtNota3.setText("0");
        lblResultado.setText("Resultado: ");
        lblResultado.setForeground(Color.black);
    }

    private void consultarLista() {
        String listaConsultada = miModeloDatos.imprimirListaEstudiantes();
        textArea.setText(listaConsultada);
        VentanaLista ventanaLista = new VentanaLista(listaConsultada);
        ventanaLista.setVisible(true);
    }

    private void consultaIndividual() {
        String documento = JOptionPane.showInputDialog("Ingrese el documento del estudiante a consultar");
        Estudiante estudianteEncontrado = miModeloDatos.consultaEstudiante(documento);

        if (estudianteEncontrado != null) {
            txtNombre.setText(estudianteEncontrado.getNombre());
            txtDocumento.setText(estudianteEncontrado.getDocumento());
            txtMateria.setText(estudianteEncontrado.getMateria());
            txtNota1.setText(estudianteEncontrado.getNota1() + "");
            txtNota2.setText(estudianteEncontrado.getNota2() + "");
            txtNota3.setText(estudianteEncontrado.getNota3() + "");
            lblResultado.setText("El promedio es: " + estudianteEncontrado.getPromedio());
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra el estudiante", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminar() {
        String documento = JOptionPane.showInputDialog("Ingrese el documento del estudiante a eliminar");
        String resultado = miModeloDatos.eliminarEstudiante(documento);
        if (resultado.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra el estudiante", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void actualizar() {
        Estudiante miEstudiante = new Estudiante();
        miEstudiante.setNombre(txtNombre.getText());
        miEstudiante.setDocumento(txtDocumento.getText());
        miEstudiante.setMateria(txtMateria.getText());
        miEstudiante.setNota1(Double.parseDouble(txtNota1.getText()));
        miEstudiante.setNota2(Double.parseDouble(txtNota2.getText()));
        miEstudiante.setNota3(Double.parseDouble(txtNota3.getText()));

        double promedio = misProcesos.calcularPromedio(miEstudiante);
        miEstudiante.setPromedio(promedio);

        String resultado = miModeloDatos.actualizarEstudiante(miEstudiante);
        if (resultado.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Estudiante actualizado correctamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra el estudiante", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
    }
}
