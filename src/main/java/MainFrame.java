import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.util.Precision;

public class MainFrame extends JFrame {

    private JButton buttonConversor;
    private JTextField primaryField;
    private JTextField secondaryField;
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JLabel primaryFieldLabel;
    private JLabel secondaryFieldLabel;
    private Boolean focusPrimaryField;
    private static final List<Double> TO_CONVERTER_UNITS =  Arrays.asList(2.54, 1000.0, 442.0);
    public double converterUnitSelected = TO_CONVERTER_UNITS.get(0);

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Conveter");
        setSize(450, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        buttonConversor.addActionListener(e -> {
            if(focusPrimaryField){
                primaryFieldToSecondaryField(converterUnitSelected);
            }else {
                secondaryFieldToPrimaryField(converterUnitSelected);
            }
        });

        primaryField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateInput(e);
            }
        });


        primaryField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focusPrimaryField = true;
                resetBothInput();
            }
        });
        secondaryField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focusPrimaryField = false;
                resetBothInput();
            }
        });
        secondaryField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validateInput(e);
            }
        });
        comboBox1.addActionListener(e -> {
            int kindOfconverterPostion = comboBox1.getSelectedIndex();
            switch (kindOfconverterPostion){
                case 0:
                    resetBothInput();
                    converterUnitSelected = TO_CONVERTER_UNITS.get(0);
                    primaryFieldLabel.setText("Centimetres");
                    secondaryFieldLabel.setText("Inches");
                    break;
                case 1:
                    resetBothInput();
                    converterUnitSelected = TO_CONVERTER_UNITS.get(1);
                    primaryFieldLabel.setText("Metres");
                    secondaryFieldLabel.setText("Kilometres");
                    break;
                case 2:
                    resetBothInput();
                    converterUnitSelected = TO_CONVERTER_UNITS.get(2);
                    primaryFieldLabel.setText("Argentine pesos");
                    secondaryFieldLabel.setText("Dollars");
                    break;
                default:
                    break;
            }
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public void resetBothInput(){
        secondaryField.setText("");
        primaryField.setText("");
    }
    public void validateInput(KeyEvent e){
        char character = e.getKeyChar();

        if (((character < '0') || (character > '9')) && (character != '\b') && (character != '.') && (character != '-')) {
            e.consume();
        }
    }
    public void primaryFieldToSecondaryField(double unitToConverter) {
        double primaryUnit;
        try {
            primaryUnit = Double.parseDouble(primaryField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double secondaryUnit = primaryUnit / unitToConverter;
        Double secondaryUnitRounding = Precision.round(secondaryUnit, 5);
        secondaryField.setText(String.valueOf(secondaryUnitRounding));
    }

    public void secondaryFieldToPrimaryField(double unitToConverter) {
        double secondaryUnit;
        try {
            secondaryUnit = Double.parseDouble(secondaryField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double primaryUnit = secondaryUnit * unitToConverter;
        Double primaryUnitRounding = Precision.round(primaryUnit, 5);
        primaryField.setText(String.valueOf(primaryUnitRounding));
    }
}
