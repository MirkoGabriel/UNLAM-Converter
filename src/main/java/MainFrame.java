import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
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
    private final List<StandardConverter> converters;
    private StandardConverter converterSelected;

    public MainFrame() {
        setContentPane(mainPanel);
        setTitle("Conveter");
        setSize(450, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        converters = new ArrayList<>();
        converters.add(new CmToInConverter());
        converters.add(new MeToKmConverter());
        converters.forEach(c -> comboBox1.addItem(c.getType()));
        getConverterSelected();

        buttonConversor.addActionListener(e -> {
            if (focusPrimaryField) {
                primaryFieldToSecondaryField();
            } else {
                secondaryFieldToPrimaryField();
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
            getConverterSelected();
            resetBothInput();
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }

    public void resetBothInput() {
        secondaryField.setText("");
        primaryField.setText("");
    }

    public void validateInput(KeyEvent e) {
        char character = e.getKeyChar();

        if (((character < '0') || (character > '9'))
                && (character != '\b')
                && (character != '.')
                && (character != '-')) {
            e.consume();
        }
    }

    public void primaryFieldToSecondaryField() {
        double primaryUnit;
        try {
            primaryUnit = Double.parseDouble(primaryField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double secondaryUnit = converterSelected.convertFirstValueToSecondValue(primaryUnit);
        Double secondaryUnitRounding = Precision.round(secondaryUnit, 5);
        secondaryField.setText(String.valueOf(secondaryUnitRounding));
    }

    public void secondaryFieldToPrimaryField() {
        double secondaryUnit;
        try {
            secondaryUnit = Double.parseDouble(secondaryField.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, nfe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double primaryUnit = converterSelected.convertSecondValueToFirstValue(secondaryUnit);
        Double primaryUnitRounding = Precision.round(primaryUnit, 5);
        primaryField.setText(String.valueOf(primaryUnitRounding));
    }

    private void getConverterSelected() {
        converterSelected = converters.get(comboBox1.getSelectedIndex());

        primaryFieldLabel.setText(converterSelected.getFirstLabel());
        secondaryFieldLabel.setText(converterSelected.getSecondLabel());
    }
}
