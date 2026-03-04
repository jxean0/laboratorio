package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VentanaLista extends JFrame {

    public VentanaLista(String contenido) {
        setTitle("Lista de Estudiantes");
        setSize(500, 400);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitulo = new JLabel("LISTA DE ESTUDIANTES");
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(10, 10, 460, 35);
        add(lblTitulo);

        JTextArea textArea = new JTextArea(contenido);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 55, 445, 290);
        add(scrollPane);
    }
}
