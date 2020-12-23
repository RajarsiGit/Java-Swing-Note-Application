import java.awt.*;
import javax.swing.*;

public class Note {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Note");

        JMenuBar mb = new JMenuBar();
        JMenu file_menu = new JMenu("File");
        JMenu help_menu = new JMenu("Help");
        JMenuItem close_item = new JMenuItem("Close");

        file_menu.add(close_item);
        mb.add(file_menu);
        mb.add(help_menu);
        frame.setJMenuBar(mb);

        JTextArea area = new JTextArea("Please type..");
        area.setBounds(0, 0, 640, 400);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane = new JScrollPane(area);
        scrollPane.setViewportView(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBounds(0, 310, 640, 100);

        JTextField file_name = new JTextField("file0.txt");
        file_name.setColumns(50);
        panel.add(file_name);

        JButton b2 = new JButton(" SAVE ");
        panel.add(b2);

        frame.add(panel, BorderLayout.SOUTH);
        
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}