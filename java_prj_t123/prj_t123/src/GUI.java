//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


//import clock_interface.types_arrow;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI extends JFrame {
    private Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Dimension ApplicationSize = new Dimension(520, 310);
    private shop myShop = new shop();
    private JButton buttonMaxPrice = new JButton("max price");
    private JButton buttonPopularBrand = new JButton("popular brand");
    private JButton buttonSetTime = new JButton("set time");
    private JTextField inputTypeArrow = new JTextField("", 5);
    private JTextField inputTimeValue = new JTextField("", 5);
    private DefaultListModel<String> datalist = new DefaultListModel();
    private JList<String> list;
    private JPanel dataPanel;
    private JPanel inputPanel;
    private JPanel buttonsPanel;
    private JScrollPane scrollPanel;

    public GUI() {
        super("Main application");
        this.list = new JList(this.datalist);
        this.dataPanel = new JPanel();
        this.inputPanel = new JPanel();
        this.buttonsPanel = new JPanel();
        this.scrollPanel = new JScrollPane(new JList(this.datalist));
        this.setSize(this.ApplicationSize.width, this.ApplicationSize.height);
        this.setDefaultCloseOperation(3);
        Container container = this.getContentPane();
        this.setResizable(false);
        container.setLayout(new GridLayout(2, 1));
        container.add(this.scrollPanel);
        container.add(this.inputPanel);
        this.inputPanel.add(this.inputTypeArrow);
        this.inputPanel.add(this.inputTimeValue);
        this.inputPanel.add(this.buttonsPanel);
        this.buttonsPanel.add(this.buttonMaxPrice);
        this.buttonsPanel.add(this.buttonSetTime);
        this.buttonsPanel.add(this.buttonPopularBrand);
        this.inputPanel.setLayout(new GridLayout(3, 1));
        this.buttonsPanel.setLayout(new GridLayout(1, 3));
        this.buttonMaxPrice.addActionListener(new btnEventListener());
        this.buttonPopularBrand.addActionListener(new btnEventListener());
        this.buttonSetTime.addActionListener(new btnEventListener());
        this.setLocation((int)((double)this.ScreenSize.width * 0.5 - (double)this.ApplicationSize.width * 0.5), (int)((double)this.ScreenSize.height * 0.5 - (double)this.ApplicationSize.height * 0.5));
    }

    public void fillList(shop s) {
        for(int i = 0; i < s.list.size(); ++i) {
            this.datalist.addElement(((clock)s.list.get(i)).toString());
        }

    }

    public void clearList() {
        this.datalist.clear();
    }

    public void delFromList() {
        this.datalist.remove(this.list.getSelectedIndex());
    }

    class btnEventListener implements ActionListener {
        btnEventListener() {
        }

        public clock_interface.types_arrow parseArrow(String str) {
            if (!str.equals("H") && !str.equals("Hours")) {
                if (!str.equals("M") && !str.equals("Minutes")) {
                    if (!str.equals("S") && !str.equals("Seconds")) {
                        throw new ArrayStoreException("Enter only \"H(Hours), M(Minutes), S(Seconds)\"");
                    } else {
                        return clock_interface.types_arrow.S;
                    }
                } else {
                    return clock_interface.types_arrow.M;
                }
            } else {
                return clock_interface.types_arrow.H;
            }
        }

        public void actionPerformed(ActionEvent event) {
            String message;
            if (event.getActionCommand().equals("max price")) {
                message = String.valueOf(GUI.this.myShop.getMaxPrice());
                JOptionPane.showMessageDialog((Component)null, message, "Price", -1);
            }

            if (event.getActionCommand().equals("popular brand")) {
                message = GUI.this.myShop.getMaxCountName();
                JOptionPane.showMessageDialog((Component)null, message, "Brand", -1);
            }

            if (event.getActionCommand().equals("set time")) {
                try {
                    clock_interface.types_arrow temp1 = this.parseArrow(GUI.this.inputTypeArrow.getText());
                    int temp2 = Integer.parseInt(GUI.this.inputTimeValue.getText());
                    if (temp1 == clock_interface.types_arrow.H) {
                        GUI.this.myShop.setTimeAllclocks(temp1, temp2);
                    }

                    if (temp1 == clock_interface.types_arrow.M) {
                        GUI.this.myShop.setTimeAllclocks(temp1, temp2);
                    }

                    if (temp1 == clock_interface.types_arrow.S) {
                        GUI.this.myShop.setTimeAllclocks(temp1, temp2);
                    }

                    GUI.this.datalist.clear();

                    for(int i = 0; i < GUI.this.myShop.list.size(); ++i) {
                        GUI.this.datalist.addElement(((clock)GUI.this.myShop.list.get(i)).toString());
                    }
                } catch (Exception var5) {
                    JOptionPane.showMessageDialog((Component)null, var5, "Error", -1);
                }
            }

        }
    }
}

