package gui;

//HyerynByeon, 24605137

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import containers.BigContainer;
import containers.Container;
import containers.SmallContainer;
import items.Item;
import methods.Calculation;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class GUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtLaptop;
    private JTextField txtMouse;
    private JTextField txtDesktop;
    private JTextField txtLCDScreens;
    private JLabel lblShippingMethod;
    private JLabel lblShippingCost;
    private JLabel lblTotalWeight;
    private JLabel lblTotalVolume;

    //extends of JFrame(panels, labels, text fields, and buttons)
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Container Shipping App");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Container Shipping Calculator");
        lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(195, 6, 400, 29);
        contentPane.add(lblTitle);

        JPanel panelItems = new JPanel();
        panelItems.setBounds(50, 70, 300, 370);
        contentPane.add(panelItems);
        panelItems.setLayout(null);

        JLabel lblItems = new JLabel("Items:");
        lblItems.setHorizontalAlignment(SwingConstants.LEFT);
        lblItems.setBounds(6, 6, 100, 16);
        panelItems.add(lblItems);

        JLabel lblLaptop = new JLabel("Laptop");
        lblLaptop.setHorizontalAlignment(SwingConstants.LEFT);
        lblLaptop.setBounds(6, 34, 61, 16);
        panelItems.add(lblLaptop);

        JLabel lblMouse = new JLabel("Mouse");
        lblMouse.setHorizontalAlignment(SwingConstants.LEFT);
        lblMouse.setBounds(6, 78, 61, 16);
        panelItems.add(lblMouse);

        JLabel lblDesktop = new JLabel("Desktop");
        lblDesktop.setHorizontalAlignment(SwingConstants.LEFT);
        lblDesktop.setBounds(6, 122, 61, 16);
        panelItems.add(lblDesktop);

        JLabel lblLCDScreens = new JLabel("LCD screens");
        lblLCDScreens.setHorizontalAlignment(SwingConstants.LEFT);
        lblLCDScreens.setBounds(6, 166, 88, 16);
        panelItems.add(lblLCDScreens);

        txtLaptop = new JTextField("0");
        txtLaptop.setHorizontalAlignment(SwingConstants.CENTER);
        txtLaptop.setBounds(200, 30, 60, 26);
        panelItems.add(txtLaptop);
        txtLaptop.setColumns(10);

        txtMouse = new JTextField("0");
        txtMouse.setHorizontalAlignment(SwingConstants.CENTER);
        txtMouse.setColumns(10);
        txtMouse.setBounds(200, 74, 60, 26);
        panelItems.add(txtMouse);

        txtDesktop = new JTextField("0");
        txtDesktop.setHorizontalAlignment(SwingConstants.CENTER);
        txtDesktop.setColumns(10);
        txtDesktop.setBounds(200, 118, 60, 26);
        panelItems.add(txtDesktop);

        txtLCDScreens = new JTextField("0");
        txtLCDScreens.setHorizontalAlignment(SwingConstants.CENTER);
        txtLCDScreens.setColumns(10);
        txtLCDScreens.setBounds(200, 162, 60, 26);
        panelItems.add(txtLCDScreens);

        JPanel panelOrder = new JPanel();
        panelOrder.setBounds(450, 70, 300, 300);
        contentPane.add(panelOrder);
        panelOrder.setLayout(null);

        JLabel lblOrder = new JLabel("Order:");
        lblOrder.setHorizontalAlignment(SwingConstants.LEFT);
        lblOrder.setBounds(6, 6, 100, 16);
        panelOrder.add(lblOrder);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 34, 288, 127);
        panelOrder.add(scrollPane);

        JTable tblOrder = new JTable();
        scrollPane.setViewportView(tblOrder);
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Item", "Quantity"}, 0);
        tblOrder.setModel(model);

        JPanel panelResult = new JPanel();
        panelResult.setBounds(50, 470, 700, 100);
        contentPane.add(panelResult);
        panelResult.setLayout(null);

        JLabel lblResults = new JLabel("Results:");
        lblResults.setHorizontalAlignment(SwingConstants.LEFT);
        lblResults.setBounds(6, 6, 100, 16);
        panelResult.add(lblResults);

        JLabel lblBestShippingMethod = new JLabel("Best shipping method:");
        lblBestShippingMethod.setHorizontalAlignment(SwingConstants.LEFT);
        lblBestShippingMethod.setBounds(6, 34, 150, 16);
        panelResult.add(lblBestShippingMethod);

        JLabel lblShippingCostLabel = new JLabel("Total shipping cost:");
        lblShippingCostLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblShippingCostLabel.setBounds(6, 62, 150, 16);
        panelResult.add(lblShippingCostLabel);

        JLabel lblTotalWeightLabel = new JLabel("Total weight:");
        lblTotalWeightLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalWeightLabel.setBounds(400, 34, 100, 16);
        panelResult.add(lblTotalWeightLabel);

        JLabel lblTotalVolumeLabel = new JLabel("Total volume:");
        lblTotalVolumeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalVolumeLabel.setBounds(400, 62, 100, 16);
        panelResult.add(lblTotalVolumeLabel);

        lblShippingMethod = new JLabel("");
        lblShippingMethod.setHorizontalAlignment(SwingConstants.LEFT);
        lblShippingMethod.setBounds(150, 34, 250, 16);
        panelResult.add(lblShippingMethod);

        lblShippingCost = new JLabel("");
        lblShippingCost.setHorizontalAlignment(SwingConstants.LEFT);
        lblShippingCost.setBounds(150, 62, 250, 16);
        panelResult.add(lblShippingCost);

        lblTotalWeight = new JLabel("");
        lblTotalWeight.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalWeight.setBounds(500, 34, 250, 16);
        panelResult.add(lblTotalWeight);

        lblTotalVolume = new JLabel("");
        lblTotalVolume.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotalVolume.setBounds(500, 62, 250, 16);
        panelResult.add(lblTotalVolume);

        //Constructor(main frame, sets its title, creates the content pane, and sets its layout to null)
        JButton btnRun = new JButton("Run");
        btnRun.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	    //Get the quantity of each item from text fields
        	    int laptopQuantity = Integer.parseInt(txtLaptop.getText());
        	    int mouseQuantity = Integer.parseInt(txtMouse.getText());
        	    int desktopQuantity = Integer.parseInt(txtDesktop.getText());
        	    int lcdScreensQuantity = Integer.parseInt(txtLCDScreens.getText());

        	    //Calculate shipping method, cost, weight, and volume based on quantities
        	    String shippingMethod = calculateShippingMethod(laptopQuantity, mouseQuantity, desktopQuantity,
        	            lcdScreensQuantity);
        	    double shippingCost = calculateFinalCost(laptopQuantity, mouseQuantity, desktopQuantity,
        	            lcdScreensQuantity);
        	    double totalWeight = calculateTotalWeight(laptopQuantity, mouseQuantity, desktopQuantity,
        	            lcdScreensQuantity);
        	    double totalVolume = calculateTotalVolume(laptopQuantity, mouseQuantity, desktopQuantity,
        	            lcdScreensQuantity);

        	    //Display results in labels
        	    lblShippingMethod.setText(shippingMethod);
        	    lblShippingCost.setText(String.valueOf(shippingCost));
        	    lblTotalWeight.setText(String.valueOf(totalWeight));
        	    lblTotalVolume.setText(String.valueOf(totalVolume));

        	    //Add items to the order table
        	    model.setRowCount(0); // Clear previous items
        	    if (laptopQuantity > 0) {
        	        model.addRow(new Object[]{"Laptop", laptopQuantity});
        	    }
        	    if (mouseQuantity > 0) {
        	        model.addRow(new Object[]{"Mouse", mouseQuantity});
        	    }
        	    if (desktopQuantity > 0) {
        	        model.addRow(new Object[]{"Desktop", desktopQuantity});
        	    }
        	    if (lcdScreensQuantity > 0) {
        	        model.addRow(new Object[]{"LCD screens", lcdScreensQuantity});
        	    }
        	}

        });
        btnRun.setBounds(350, 250, 100, 29);
        contentPane.add(btnRun);
    }

    private String calculateShippingMethod(int laptopQuantity, int mouseQuantity, int desktopQuantity,
            int lcdScreensQuantity) {
    	Calculation calculation = new Calculation();
    	
    	//Creating items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcdScreens = new Item("LCD screens", 120, 140, 80, 2.6);

        //Adding items and quantities to the calculation
        for (int i = 0; i < laptopQuantity; i++) {
            calculation.addItems(laptop);
        }
        for (int i = 0; i < mouseQuantity; i++) {
            calculation.addItems(mouse);
        }
        for (int i = 0; i < desktopQuantity; i++) {
            calculation.addItems(desktop);
        }
        for (int i = 0; i < lcdScreensQuantity; i++) {
            calculation.addItems(lcdScreens);
        }

        //Creating containers
        Container smallContainer = new SmallContainer(259, 243, 606);
        Container bigContainer = new BigContainer(259, 243, 1201);

        //Calculating best shipping method
        List<String> res = calculation.bestShipping(bigContainer, smallContainer);

        //Returning the shipping method
        int bestBigCount = Integer.parseInt(res.get(0));
        int bestSmallCount = Integer.parseInt(res.get(1)); {
        	return bestBigCount + " big containers and " + bestSmallCount + " small containers";
        }
    }

    private double calculateFinalCost(int laptopQuantity, int mouseQuantity, int desktopQuantity,
            int lcdScreensQuantity) {
        Calculation calculation = new Calculation();
        
        //Creating items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcdScreens = new Item("LCD screens", 120, 140, 80, 2.6);

        //Adding items and quantities to the calculation
        for (int i = 0; i < laptopQuantity; i++) {
            calculation.addItems(laptop);
        }
        for (int i = 0; i < mouseQuantity; i++) {
            calculation.addItems(mouse);
        }
        for (int i = 0; i < desktopQuantity; i++) {
            calculation.addItems(desktop);
        }
        for (int i = 0; i < lcdScreensQuantity; i++) {
            calculation.addItems(lcdScreens);
        }

        Container smallContainer = new SmallContainer(259, 243, 606);
        Container bigContainer = new BigContainer(259, 243, 1201);

        List<String> res = calculation.bestShipping(bigContainer,smallContainer);


        //Calculating shipping cost
        double calculateFinalCost = Double.parseDouble(res.get(2)); {
        	return calculateFinalCost;
        }
    }

    private double calculateTotalWeight(int laptopQuantity, int mouseQuantity, int desktopQuantity,
            int lcdScreensQuantity) {
        Calculation calculation = new Calculation();
        
        //Creating items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcdScreens = new Item("LCD screens", 120, 140, 80, 2.6);

        //Adding items and quantities to the calculation
        for (int i = 0; i < laptopQuantity; i++) {
            calculation.addItems(laptop);
        }
        for (int i = 0; i < mouseQuantity; i++) {
            calculation.addItems(mouse);
        }
        for (int i = 0; i < desktopQuantity; i++) {
            calculation.addItems(desktop);
        }
        for (int i = 0; i < lcdScreensQuantity; i++) {
            calculation.addItems(lcdScreens);
        }

        //Calculating total weight
        double calculateTotalWeight = calculation.totalWeight();
        return calculateTotalWeight;
    }

    private double calculateTotalVolume(int laptopQuantity, int mouseQuantity, int desktopQuantity,
            int lcdScreensQuantity) {
        Calculation calculation = new Calculation();
        
        //Creating items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcdScreens = new Item("LCD screens", 120, 140, 80, 2.6);

        //Adding items and quantities to the calculation
        for (int i = 0; i < laptopQuantity; i++) {
            calculation.addItems(laptop);
        }
        for (int i = 0; i < mouseQuantity; i++) {
            calculation.addItems(mouse);
        }
        for (int i = 0; i < desktopQuantity; i++) {
            calculation.addItems(desktop);
        }
        for (int i = 0; i < lcdScreensQuantity; i++) {
            calculation.addItems(lcdScreens);
        }

        //Calculating total volume
        double totalVolume = calculation.calculateTotalVolume();
        return totalVolume;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

