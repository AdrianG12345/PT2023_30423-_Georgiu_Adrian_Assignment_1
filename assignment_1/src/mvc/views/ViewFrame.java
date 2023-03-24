package mvc.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ViewFrame extends JFrame {

    private JPanel contentPane;
    private JTextField firstTextField;
    private JTextField secondTextField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JTextArea resultTextArea;
    private JButton derivateButton;
    private JButton integrateButton;

    public ViewFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("Polinoame");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
        titleLabel.setBounds(327, 20, 213, 45);
        contentPane.add(titleLabel);

        addButton = new JButton("Add polynoms");
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 44));
        addButton.setBounds(559, 118, 365, 65);
        contentPane.add(addButton);

        subtractButton = new JButton("Subtract Polynoms");
        subtractButton.setFont(new Font("Tahoma", Font.PLAIN, 31));
        subtractButton.setBounds(559, 182, 365, 88);
        contentPane.add(subtractButton);

        multiplyButton = new JButton("Multiply Polynoms\r\n");
        multiplyButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
        multiplyButton.setBounds(559, 268, 365, 70);
        contentPane.add(multiplyButton);

        divideButton = new JButton("Divide Polynoms");
        divideButton.setBounds(559, 337, 365, 70);
        contentPane.add(divideButton);

        firstTextField = new JTextField();
        firstTextField.setBounds(172, 95, 382, 54);
        contentPane.add(firstTextField);
        firstTextField.setColumns(10);

        secondTextField = new JTextField();
        secondTextField.setColumns(10);
        secondTextField.setBounds(172, 208, 382, 54);
        contentPane.add(secondTextField);

        JLabel firstLabel = new JLabel("First Polynom");
        firstLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
        firstLabel.setBounds(10, 112, 152, 34);
        contentPane.add(firstLabel);

        JLabel secondLabel = new JLabel("Second Polynom");
        secondLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        secondLabel.setBounds(10, 208, 152, 34);
        contentPane.add(secondLabel);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        resultLabel.setBounds(10, 305, 152, 34);
        contentPane.add(resultLabel);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(10, 337, 548, 39);
        contentPane.add(resultTextArea);

        derivateButton = new JButton("Derivate 1st Polynom");
        derivateButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        derivateButton.setBounds(559, 403, 365, 65);
        contentPane.add(derivateButton);

        integrateButton = new JButton("Integrate 1st Polynom");
        integrateButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
        integrateButton.setBounds(559, 464, 365, 65);
        contentPane.add(integrateButton);


        this.setVisible(true);
    }

    public String getFirstTextField() {
        return firstTextField.getText();
    }

    public void setFirstTextField(String firstTextField) {
        this.firstTextField .setText(firstTextField);
    }

    public String getSecondTextField() {
        return secondTextField.getText();
    }

    public void setSecondTextField(String secondTextField) {
        this.secondTextField.setText(secondTextField);
    }

    public String getResultTextArea() {
        return resultTextArea.getText();
    }

    public void setResultTextArea(String resultTextArea) {
        this.resultTextArea.setText(resultTextArea);
    }

    /*
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    public void addCreateListener(ActionListener action)
    {
        createButton.addActionListener(action);
    }*/

    public void addCreateListener(ActionListener action)
    {
        addButton.addActionListener(action);
    }
    public void subtractCreateListener(ActionListener action)
    {
        subtractButton.addActionListener(action);
    }public void multiplyCreateListener(ActionListener action)
    {
        multiplyButton.addActionListener(action);
    }public void divideCreateListener(ActionListener action)
    {
        divideButton.addActionListener(action);
    }
    public void derivateCreateListener(ActionListener action)
    {
        derivateButton.addActionListener(action);
    }
    public void integrateCreateListener(ActionListener action)
    {
        integrateButton.addActionListener(action);
    }


    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

}


