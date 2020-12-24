import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.io.*;

public class Note implements ActionListener {
    JFrame frame;
    JScrollPane scrollPane;
    JTextArea area;
    JTextField file_name;
    JButton save;
    JMenuItem close_item;

    public Note() {
        frame = new JFrame("Note");

        JMenuBar mb = new JMenuBar();
        JMenu file_menu = new JMenu("File");
        JMenu help_menu = new JMenu("Help");
        close_item = new JMenuItem("Close");
        close_item.addActionListener(this);

        file_menu.add(close_item);
        mb.add(file_menu);
        mb.add(help_menu);
        frame.setJMenuBar(mb);

        area = new JTextArea("Delete and keep typing...");
        area.setBounds(0, 0, 640, 400);
        area.setCaretPosition(area.getDocument().getLength());

        scrollPane = new JScrollPane(area);
        scrollPane.setViewportView(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setBounds(0, 310, 640, 100);

        JLabel fileLabel = new JLabel("File Name: ");
        fileLabel.setBorder(new EmptyBorder(5, 0, 5, 5));
        panel.add(fileLabel, BorderLayout.WEST);

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new EmptyBorder(0, 0, 0, 5));
        file_name = new JTextField("");
        panel1.add(file_name, BorderLayout.CENTER);
        panel.add(panel1, BorderLayout.CENTER);

        save = new JButton(" SAVE ");
        save.addActionListener(this);
        panel.add(save, BorderLayout.EAST);

        frame.add(panel, BorderLayout.SOUTH);
        
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == close_item) {
            frame.dispose();
            System.exit(1);
        }
        else if(e.getSource() == save) {
            String text = area.getText();
            String file = file_name.getText();
            FileWriter fw;

            try {
                fw = new FileWriter(file + ".txt");
                fw.write(text);
                fw.close();
            }
            catch(Exception error) {
                System.err.println(error.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Note();
    }
}