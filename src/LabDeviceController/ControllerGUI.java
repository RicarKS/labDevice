package LabDeviceController;
///<<<<<<< HEAD:src/LabDeviceController/ControllerGUI.java

//=======
//徐涛
//>>>>>>> df9cdf809de689250432920b5712ebbe682d465b:src/实验室电器控制器/ControllerGUI.java
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

public class ControllerGUI extends JPanel{
	private JScrollPane upperLeftPane, upperRightPane;
	private JTextArea txtEquipmentDisplay;
	private JSplitPane bigSplitPane, upSplitPane;
	private JPanel  downPanel, upperLeftPanel, geoDataPanel;
	private JComboBox cmbUser;
	
	
	private JTextField txtTeacherName;
	private JTextField txtTime;
	private JTextField txtClassRoom;
	
	private ButtonHandler btnHandler;
	static final Dimension minimumSize = new Dimension(230, 200);
	public static final String COMPUTE = "Submit";
	public static final String EXIT = "Exit";
	public static final String TEACHER = "teacher";
	public static final String BLANK = "Choose user";
	
	public ControllerGUI() {
		super(new GridLayout(1, 0));
		txtEquipmentDisplay = new JTextArea(6, 30);
		txtEquipmentDisplay.setFont(new Font("Arial", Font.BOLD, 12));
		txtEquipmentDisplay.setBackground(Color.pink);
		txtEquipmentDisplay.setText(" Equipment Information will be shown here");
		btnHandler = new ButtonHandler();
		setupLowerPanel();
		setupUpperLeftPanel();
		buildUpScrollGUI();
	}
	private void setupLowerPanel() {
		downPanel = new JPanel();
		downPanel.setBackground(Color.gray);
		JButton btnSubmit = new JButton(ControllerGUI.COMPUTE);
		btnSubmit.setMnemonic(KeyEvent.VK_G);
		JButton btnExit = new JButton(ControllerGUI.EXIT);
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnSubmit.addActionListener(btnHandler);
		btnExit.addActionListener(btnHandler);
		downPanel.add(btnSubmit);
		downPanel.add(btnExit);
	}
	private void setupUpperLeftPanel() {
		cmbUser = new JComboBox();
		cmbUser.addItem(BLANK);
		cmbUser.addItem(TEACHER);
		cmbUser.addActionListener(btnHandler);

		upperLeftPanel = new JPanel();
		geoDataPanel = new JPanel();
		geoDataPanel.setPreferredSize(new Dimension(250, 180));

		GridBagLayout gridbag = new GridBagLayout();
		upperLeftPanel.setLayout(gridbag);
		GridBagConstraints gbc = new GridBagConstraints();
		upperLeftPanel.add(cmbUser);
		upperLeftPanel.add(geoDataPanel);

		gbc.insets.top = 5;
		gbc.insets.bottom = 5;
		gbc.insets.left = 5;
		gbc.insets.left = 1;
		gbc.insets.right = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gridbag.setConstraints(cmbUser, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gridbag.setConstraints(geoDataPanel, gbc);
	}

	public void displayEquipment(String str) {
		txtEquipmentDisplay.setText(str);
	}

	public String getGeoType() {
		return (String) cmbUser.getSelectedItem();
	}

	public JComboBox getUserCombox() {
		return cmbUser;
	}

	public void displayNewGUI(JPanel panel) {
		geoDataPanel.removeAll();
		geoDataPanel.add(panel);
		geoDataPanel.validate();
		validate();
	}

	private void buildUpScrollGUI() {
		upperLeftPane = new JScrollPane(upperLeftPanel);
		upperLeftPane.setMinimumSize(minimumSize);
		upperRightPane = new JScrollPane(txtEquipmentDisplay);

		upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		upSplitPane.setDividerLocation(280);
		upSplitPane.setPreferredSize(new Dimension(600, 200));
		upSplitPane.setLeftComponent(upperLeftPane);
		upSplitPane.setRightComponent(upperRightPane);

		bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
		bigSplitPane.setDividerLocation(200);

		add(bigSplitPane);
		setSize(new Dimension(600, 300));
		setVisible(true);
	}
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("实验室电器控制器");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ControllerGUI newContentPane = new ControllerGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	static public void main(String argv[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	class ButtonHandler implements ActionListener {
		String selection = null;
		String measure = null;

		public void actionPerformed(ActionEvent e) {
			selection = getGeoType();
			User user = null;

			if (e.getActionCommand().equals(EXIT)) {
				System.exit(1);
			}
			if (e.getActionCommand().equals(COMPUTE)) {
				if (selection.equals(TEACHER)) {
					String teacherName = txtTeacherName.getText();
					String time = txtTime.getText();
					String classRoom = txtClassRoom.getText();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String tn = String.valueOf(teacherName);
					//DataTime t = DataTime(time);
					String cr = String.valueOf(classRoom);

					user = new Teacher(tn, time, cr);
				}
			if (e.getSource() == getUserCombox()) {
				selection = getGeoType();
				if (selection.equals(TEACHER))
					displayNewGUI(getTypePanel(TEACHER));
				upperLeftPanel.repaint();
			}
		}
	}

	private JPanel getTypePanel(String type) {
		JPanel typePanel = new JPanel();

		if (type.equals(TEACHER)) {
			JLabel lblTeacherName = new JLabel("教师姓名");
			JLabel lblTime = new JLabel("到达时间");
			JLabel lblClassRoom = new JLabel("实验教室");
			txtTeacherName = new JTextField(8);
			txtTime = new JTextField(8);
			txtClassRoom = new JTextField(8);

			GridBagLayout gridbag = new GridBagLayout();
			typePanel.setLayout(gridbag);
			GridBagConstraints gbc = new GridBagConstraints();

			typePanel.add(lblTeacherName);
			typePanel.add(lblTime);
			typePanel.add(lblClassRoom);

			typePanel.add(txtTeacherName);
			typePanel.add(txtTime);
			typePanel.add(txtClassRoom);
			
			gbc.insets.top = 5;
			gbc.insets.bottom = 5;
			gbc.insets.left = 1;
			gbc.insets.right = 8;

			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gridbag.setConstraints(lblTeacherName, gbc);
			gbc.gridx = 1;
			gbc.gridy = 0;
			gridbag.setConstraints(txtTeacherName, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
			gridbag.setConstraints(lblTime, gbc);
			gbc.gridx = 1;
			gbc.gridy = 1;
			gridbag.setConstraints(txtTime, gbc);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gridbag.setConstraints(lblClassRoom, gbc);
			gbc.gridx = 1;
			gbc.gridy = 2;
			gridbag.setConstraints(txtClassRoom, gbc);
			gbc.gridx = 0;
			gbc.gridy = 3;
			} 
			return typePanel;
		}
	}
}
