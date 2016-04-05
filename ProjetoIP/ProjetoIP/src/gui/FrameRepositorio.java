package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameRepositorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRepositorio frame = new FrameRepositorio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameRepositorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Defina seu Reposit\u00F3rio:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Array");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				defineArray();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.ITALIC, 22));
		btnNewButton.setBounds(10, 64, 414, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lista");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defineLista();
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		btnNewButton_1.setBounds(10, 119, 414, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defineJakarta();
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.ITALIC, 22));
		btnNewButton_2.setBounds(10, 174, 414, 49);
		contentPane.add(btnNewButton_2);
	}
	
	private void defineArray(){
		
		
		FrameInicio frame = new FrameInicio();
		frame.setVisible(true);
	}
	
	private void defineLista(){
		
		
		FrameInicio frame = new FrameInicio();
		frame.setVisible(true);
	}
	
	private void defineJakarta(){
		
		
		
		FrameInicio frame = new FrameInicio();
		frame.setVisible(true);
	}
	
}
