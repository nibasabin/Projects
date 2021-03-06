/*
Class: PrimaryColorChooser
Interface: actionPerformed(ActionEvent e)
Description: Allows user to choose primary color for the filtered image and crates new Frame
 */
package sidewalksketcher;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author Sabin Raj Bajracharya
 */
public class PrimaryColorChooser extends JFrame implements ActionListener {

    private Color SelectColor1;

    public PrimaryColorChooser() {
        super("Welcome To Sidewalk Sketcher Color Chooser");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BufferedImage[] tempImageDB = new BufferedImage[1];
        tempImageDB = SidewalkSketcherGUI.imageDB;
        SelectColor1 = JColorChooser.showDialog(null, "Please Choose Color", SelectColor1);
        int Color1 = 1 * SelectColor1.getRGB();
        SidewalkSketcherGUI.ColorArray[0] = Color1;
        tempImageDB[0] = ImageFilter.Filter(SidewalkSketcherGUI.imageDB[0], 
                SidewalkSketcherGUI.ColorArray[0], 0);
        ImageIcon imageIcon = new ImageIcon(tempImageDB[0]);
        JLabel label = new JLabel(imageIcon);
        SidewalkSketcherGUI.panel1.add(label);
        SidewalkSketcherGUI.panel1.removeAll();
        SidewalkSketcherGUI.panel1.add(label);
        SidewalkSketcherGUI.panel1.setSize(600, 600);
        SidewalkSketcherGUI.myframe.setSize(600, 600);
        SidewalkSketcherGUI.myframe.pack();
        SidewalkSketcherGUI.myframe.setResizable(false);
        SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SidewalkSketcherGUI.myframe.setVisible(true);
    }
}
