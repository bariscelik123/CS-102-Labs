import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CatalogGUI extends JFrame{

    JPanel mainPanel;
    JPanel Centerpanel;
    JPanel eastPanel;
    JPanel southPanel;

    private int index;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;

    private JTextArea code;
    private JTextArea price;
    private JTextArea description;
    private JLabel label;
    private JLabel label2;
    private JLabel label3;

    private JRadioButton english;
    private JRadioButton turkish;
    private JCheckBox hidePrice;

    private JButton previous;
    private JButton next;

    private boolean isHide;
    private JCheckBox hide;

    private Catalog catalog = new Catalog();


    public CatalogGUI(String title) {

        this.setTitle(title);
        this.setSize(300,300);
    	this.setLocation(300,200);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );


        mainPanel = new JPanel();
        Centerpanel = new JPanel();
        eastPanel = new JPanel();
        southPanel = new JPanel();


        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();

        code = new JTextArea(1,10);
        label = new JLabel("CODE");
        code.setEditable(false);

        price = new JTextArea(1,10);
        label2 = new JLabel("PRICE");
        price.setEditable(false);

        description = new JTextArea(20,20);
        description.setEditable(false);
        label3 = new JLabel("DESCRIPTION");



        turkish = new JRadioButton("Turkish");
        english = new JRadioButton("English");
        english.setSelected(true);

        hidePrice = new JCheckBox("Hide Price");

        previous = new JButton("<<");
        next = new JButton(">>");

        index = 0;
        
        designWindow();
        set();
        addListeners();

		this.setVisible(true);
    }


    public void addListeners(){
        turkish.addActionListener(new RadioListener());
        english.addActionListener(new RadioListener());
        hidePrice.addActionListener(new BoxListener());
        next.addActionListener(new ButtonListener());
        previous.addActionListener(new ButtonListener());
    }
    public void designWindow() {

        panel1.add(label);
        panel1.add(code);
        panel2.add(label2);
        panel2.add(price);
        panel3.add(label3);
        panel4.add(description);
        Centerpanel.add(panel1);
        Centerpanel.add(panel2);
        Centerpanel.add(panel3);
        Centerpanel.add(panel4);
        

        BoxLayout sp = new BoxLayout(eastPanel, BoxLayout.Y_AXIS);
        eastPanel.setLayout(sp);
        panel5.add(turkish);
        panel6.add(english);
        panel7.add(hidePrice);
        eastPanel.add(panel5);
        eastPanel.add(panel6);
        eastPanel.add(panel7);


        southPanel.add(previous);
        southPanel.add(next);

        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(Centerpanel,BorderLayout.CENTER);
        mainPanel.add(eastPanel,BorderLayout.EAST);
        mainPanel.add(southPanel,BorderLayout.SOUTH);

        this.add(mainPanel);
    }


    public void set() {

        code.setText(catalog.getProductByPosition(index).getProductCode()+"");
        price.setText(catalog.getProductByPosition(index).getPrice()+"");

        if (isHide) {
            price.setVisible(false);
        }
        if(!isHide)  {
            price.setVisible(true);

            

        }
            
        

        if(english.isSelected()) {
            description.setText(catalog.getProductByPosition(index).getEngDescription());
        }
        if (turkish.isSelected()) {
            description.setText(catalog.getProductByPosition(index).getTurkDescription());
        }

        if (next.isSelected()) {
            index++;
        }
        if (previous.isSelected()) {
            index--;
        }
    }

    class RadioListener implements ActionListener {
        public void actionPerformed(ActionEvent x) {
            if(x.getSource() == english) {
                turkish.setSelected(false);
            }

            else if(x.getSource() == turkish) {
                english.setSelected(false);
            }
            set();
            
        }
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent x) {
            if (x.getSource() == next){
                if(index < catalog.getCatalogSize()-1)
                index++;
                else if(index == catalog.getCatalogSize()-1)
                index = 0;
            }
            if (x.getSource()==previous){
                if(0 < index){
                index--;
                }
                else if (index == 0) {
            index = catalog.getCatalogSize()-1; }
            }

            
            set();
        }
    }

    class BoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent x) {
            if (x.getSource()==hide) {
                if (hide.isSelected()) {
                    isHide=true;
                }
                else 
                isHide = false;

            }
            set();


        }
        
    }
    



    public static void main(String[] args) {
        CatalogGUI gui = new CatalogGUI("Browse Product Catalog");
    }
}

        
    
    

