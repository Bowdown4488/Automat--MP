import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class GUI extends JFrame {
	private Game game;
	private ShortestSolution solution;
	private JPanel contentPane;
	private JTextField inputField;
	private boolean cont = true;
	private ArrayList<String> visited = new ArrayList();
	private BufferedImage myPicture8;

	/**
	 * Create the frame.
	 */
	public GUI(Machine machine, Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1078, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 11, 1046, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		inputField = new JTextField();
		inputField.setBounds(114, 274, 86, 20);
		panel.add(inputField);
		inputField.setColumns(10);
		
		JLabel lblInput = new JLabel("Input Legend:");
		lblInput.setBounds(10, 11, 86, 14);
		panel.add(lblInput);
		
		JLabel lblHHuman = new JLabel("H - Human");
		lblHHuman.setBounds(10, 30, 67, 14);
		panel.add(lblHHuman);
		
		JLabel lblLLion = new JLabel("L - Lion");
		lblLLion.setBounds(10, 48, 46, 14);
		panel.add(lblLLion);
		
		JLabel lblCCow = new JLabel("C - Cow");
		lblCCow.setBounds(10, 65, 46, 14);
		panel.add(lblCCow);
		
		JLabel lblGGrain = new JLabel("G - Grain");
		lblGGrain.setBounds(10, 83, 46, 14);
		panel.add(lblGGrain);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(309, 11, 454, 347);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 224, 229);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(223, 0, 231, 229);
		panel_1.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 227, 454, 120);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 224, 120);
		panel_5.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(223, 0, 231, 120);
		panel_5.add(panel_17);
		panel_17.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_17.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_17.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_17.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_17.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_17.add(panel_16);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 380, 350, 363);
		contentPane.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		panel_2.add(label_1);
		
		try {
			myPicture8 = ImageIO.read(new File("C:\\Users\\Antoine Salcedo\\Desktop\\SCRAP\\AUTOMAT\\Automat--MP\\src\\Q0.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnGo = new JButton("Bring");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(game.getCurrState().getName());
			if(game.getCurrState().getName().equals("Q0")) {
				try {
					myPicture8 = ImageIO.read(new File("C:\\Users\\Antoine Salcedo\\Desktop\\SCRAP\\AUTOMAT\\Automat--MP\\src\\Q0.png"));
					JLabel state = new JLabel(new ImageIcon(myPicture8));
					panel_2.add(state);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(game.getCurrState().getName().equals("Q1")) {
				try {
					myPicture8 = ImageIO.read(new File("C:\\Users\\Antoine Salcedo\\Desktop\\SCRAP\\AUTOMAT\\Automat--MP\\src\\Q1.png"));
					JLabel state = new JLabel(new ImageIcon(myPicture8));
					panel_2.add(state);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			String playermove = inputField.getText();
			States advance = game.checkTransition(playermove);
			if(advance != null) {
				visited.add(advance.getName());
				if(advance.getisFinal()==true) {
					Game game = new Game(advance);
					cont = false;
				}else {
					Game game = new Game(advance);
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Game Over!");
			}
		}
		});
		btnGo.setBounds(132, 305, 57, 23);
		panel.add(btnGo);
		JLabel state = new JLabel(new ImageIcon(myPicture8));
		state.setBounds(-446, 458, 1508, 650);
		contentPane.add(state);
				
	}
}
