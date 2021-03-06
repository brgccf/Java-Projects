package sockets;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FrameRTT extends JFrame {
	private RTTClient th;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameRTT frame = new FrameRTT();
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
	public FrameRTT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblPainel = new JLabel("painel");
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				th = new RTTClient(lblPainel);
				(new Thread(th)).start();
			}
		});
		btnStart.setBounds(83, 154, 96, 30);
		contentPane.add(btnStart);
		lblPainel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPainel.setBounds(68, 79, 281, 30);
		contentPane.add(lblPainel);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				th.finish();
			}
		});
		btnStop.setBounds(244, 154, 105, 30);
		contentPane.add(btnStop);
	}
}
