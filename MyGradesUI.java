package edu.fau.COT4930;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MyGradesUI {

	public static void main(String[] args) 
	{
		final int FIELD_WIDTH = 30;
		JFrame frame = new JFrame("My Grade"); //frame object is created

		MyGrades Q = new MyGrades(); //MyGrades object Q

		JTextField textField = new JTextField(FIELD_WIDTH); //A text field object is created with initial text

		textField.setText("Enter number values only"); //Initial text prompt in text field
		JTextArea jt = new JTextArea("Isaack Morales", 10, 20); // JTextArea object is jt


		JButton Fbutton = new JButton("Final Exam"); // Final exam button

		Fbutton.addActionListener(new // An ActionListener object is added to the button using an anonymous class
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String st;
				st = textField.getText(); //string value within text field
				try {
					int j = Integer.parseInt(st); //parsed string st into an integer
					Q.setFinalExam(j);  //sets final exam grade
					jt.setText("Final Exam grade: " + st); //outputs final exam grade into text area
				}
				catch(IllegalArgumentException e) //if input is not a number
				{
					jt.setText("Invalid input"); 
				}

			}
		});


		JButton MButton = new JButton("Midterm Exam"); //Midterm exam button
		MButton.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String rt;
				rt = textField.getText(); //string value within text field
				try {
					int k = Integer.parseInt(rt); //parsed string rt into an integer
					Q.setMidtermExam(k); 
					jt.setText("Midterm Exam grade: " + rt); //outputs midterm exam grade into text area
				}
				catch(IllegalArgumentException e) //if input is not a number
				{
					jt.setText("Invalid input");
				}

			}
		});
		JButton gButton = new JButton("Homework"); // Homework button
		// An ActionListener object is added to the button using an anonymous class
		gButton.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				String qt;
				qt = textField.getText(); //string value within text field
				try {
					int l = Integer.parseInt(qt); //parsed string qt into an integer
					Q.setHomework(l); 
					jt.setText("Homework grade: " + qt);
				}
				catch(IllegalArgumentException e) //if input is not a number
				{
					jt.setText("Invalid input"); 
				}

			}
		});

		

		JButton AButton = new JButton("Final Average Grade"); //button for the final grade average
		// An ActionListener object is added to the button using an anonymous class
		AButton.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{

				double avg = Q.getFinalGrade();  
				jt.setText("Final Average grade: " + avg); //prints out the final average grade into text area

			}
		});

		frame.setLayout(new FlowLayout());

		// the button components and the text field component is added to the frame
		frame.add(Fbutton); //Final exam button
		frame.add(MButton); //Midterm exam button
		frame.add(gButton); // Homework button
		frame.add(AButton); //button for the final grade average
		frame.add(textField); //text field
		frame.add(jt); //text area

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();  // sizes the frames for the components contained
		frame.setVisible(true);

	}

}