/*Created by: Dhruv Aggarwal
Created on: February 28, 2025
Purpose: To create a simple using the Java swing and AWT library
*/

import javax.swing.*;       //importing swing components
import java.awt.*;          //importing the AWT(Abstract Window Toolkit) library to manae layout
import java.awt.event.*;    //for handling events
public class FirstGUI
{
    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame("My First GUI");      //Creating a window for my GUI
        frame.setSize(400, 300);                //Set the windos size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Set the program to exit if frame is closed
        frame.setLayout(new FlowLayout());                      //Set the layout to be a FlowLayout



        //Create the window components
        JButton button = new JButton("Submit");
        JLabel firstName = new JLabel("Enter your first name");
        JTextField firstNameField = new JTextField(20);
        JLabel lastName = new JLabel("Enter your last name");
        JTextField lastNameField = new JTextField(20);
        JLabel age = new JLabel("Enter your age");
        JTextField ageField = new JTextField(20);
        JLabel drivingInfo = new JLabel("Then you can earn your G licence!");

        //Create Panels for the components to organize them on the window
        JPanel buttonPanel = new JPanel();
        JPanel firstNamePanel = new JPanel();
        JPanel lastNamePanel = new JPanel();
        JPanel agePanel = new JPanel();
        JPanel ageFieldPanel = new JPanel();
        JPanel firstNameFieldPanel = new JPanel();
        JPanel lastNameFieldPanel = new JPanel();
        JPanel drivingInfoPanel = new JPanel();
    
        
        //Add components to the panels
        firstNamePanel.add(firstName);
        firstNameFieldPanel.add(firstNameField);
        lastNamePanel.add(lastName);
        lastNameFieldPanel.add(lastNameField);
        ageFieldPanel.add(ageField);
        agePanel.add(age);
        buttonPanel.add(button);
        drivingInfoPanel.add(drivingInfo);


        
        //Add panels to the window
        frame.add(firstNamePanel);
        frame.add(firstNameFieldPanel);
        frame.add(lastNamePanel);
        frame.add(lastNameFieldPanel);
        frame.add(agePanel);
        frame.add(ageFieldPanel);
        frame.add(buttonPanel);


        // Handle a Click Button
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent click)
            {
                String userFirstName = firstNameField.getText();
                String userLastName = lastNameField.getText();
                String userAge = ageField.getText();
                int integerUserAge = Integer.parseInt(userAge);
                
                frame.remove(firstNameFieldPanel);
                frame.remove(lastNamePanel);
                frame.remove(lastNameFieldPanel);
                frame.remove(ageFieldPanel);
                frame.remove(buttonPanel);
                        
                if (integerUserAge <= 15)
                {
                    frame.remove(agePanel);
                    firstName.setText("Hey " + userFirstName + "!" + " You are too young to drive!");  //Change the text
                }
                else if (integerUserAge < 18)
                {
                    firstName.setText("Hi " + userFirstName + "!" + " You can get your G1 learners permit!");  //Change the text
                    age.setText("If you have your G1 already, you could get your G2 in 1 year");  //Change the text
                    frame.add(drivingInfoPanel);
                    drivingInfo.setText("from the day you got your G1 or 8 months with a certified course!");
                }
                else
                {
                    firstName.setText("Hello Mr. " + userLastName + "!" + " You can drive!");  //Change the text
                    age.setText("Start with the learners permits (G1 & G2) if you haven't already!");  //Change the text
                    frame.add(drivingInfoPanel);
                }

                frame.revalidate();
                frame.repaint();
            
            }
        });

        frame.setVisible(true);
    }
}