package Frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DataManager.AddressDB;
import DataManager.OrderProductDB;
import DataManager.OrderProductManager;
import DataManager.UserManagerAddress;
import DatabaseAndTools.DataTableRenderer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class SettingUser extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel contentPane;
	private JLabel lbl_Manage_Account;
	private JLabel lbl_Manage_MyProfile;
	private JLabel lbl_Manage_Address;
	private JLabel lbl_Manage_MyOrders;
	private JPanel panel_Manage_Account;
	private JPanel panel_Manage_EditMyAccount;
	static LinkedList<OrderProductDB> orderMyAccount;
	private int[] checkDuplicateOrderID;
	private JTextField text_name;
	private JTextField text_AddAddress_name;
	private JTextField text_AddAddress_phone;
	private JTextField text_AddAddress_address;
	private JTextField text_AddAddress_district;
	private JTextField text_AddAddress_zipcode;
	JPanel panel_Manage_AddAddress;
	JTextPane textAdress;
	JTextPane textAdress2;
	JScrollPane NewProduct_SCP;
	JLabel textPhone2;
	JLabel textName;
	JLabel textName2;
	JLabel textPhone;
	JPanel panel_3;
	JLabel lblstatus2;
	int user_id;
	JLabel iconaddress ;
	String username;
	JLabel lblstatus;
	JLabel lbl_edit;
	UserManagerAddress managerAddress = new UserManagerAddress();
	private JTable NewProduct_tbl;
	
	public static void main(String[] a) {
		SettingUser showTest = new SettingUser("Panuwat",1);
		showTest.setVisible(true);
	}

	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	public SettingUser(String username, int user_id) {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			Home open = new Home();
			open.setVisible(true);
			}
		});
		this.username=username;
		setMinimumSize(new Dimension(900, 900));
		this.user_id = user_id;
		OrderProductManager manager = new OrderProductManager();
		orderMyAccount = manager.get_Image_Order(user_id);
		
		System.out.println(orderMyAccount.size());
		checkDuplicateOrderID = new int[orderMyAccount.size()];
		checkDuplicateImage();
		for(int i = 0 ;i<checkDuplicateOrderID.length;i++) {
			System.out.print(checkDuplicateOrderID[i]+" ");
		}
		System.out.println();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//Home showHome = new Home();
				//showHome.setVisible(true);
				//dispose();
				System.exit(1);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BIG SALE - Home");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image icons = kit.createImage(Home.class.getResource("/Image/ICON.png"));
		setIconImage(icons);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 1285, 909);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelShow = new JPanel();
		panelShow.setVisible(false);

		JPanel panelShowTag = new JPanel();
		panelShowTag.setVisible(false);
		panelShowTag.setBackground(Color.WHITE);
		panelShowTag.setBounds(671, 42, 232, 225);
		contentPane.add(panelShowTag);
		panelShow.setBounds(907, 42, 232, 226);
		contentPane.add(panelShow);
		panelShow.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panelShow.setBackground(Color.WHITE);
		panelShow.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E01\u0E31\u0E1A\u0E1A\u0E31\u0E0D\u0E0A\u0E35\u0E02\u0E2D\u0E07\u0E09\u0E31\u0E19");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(67, 35, 134, 24);
		panelShow.add(lblNewLabel);

		JLabel lblProfile = new JLabel("");
		ImageIcon icon = new ImageIcon(SettingUser.class.getResource("/Image/smile.png"));
		lblProfile.setBounds(21, 35, 36, 34);
		int offset = lblProfile.getInsets().left;
		lblProfile.setIcon(resizeIcon(icon, lblProfile.getWidth() - offset, lblProfile.getHeight() - offset));
		panelShow.add(lblProfile);

		JLabel lblOrder = new JLabel("");
		icon = new ImageIcon(SettingUser.class.getResource("/Image/box.png"));
		offset = lblOrder.getInsets().left;
		lblOrder.setBounds(21, 95, 36, 34);
		lblOrder.setIcon(resizeIcon(icon, lblOrder.getWidth() - offset, lblOrder.getHeight() - offset));
		panelShow.add(lblOrder);

		JLabel label_5 = new JLabel(
				"\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E2A\u0E31\u0E48\u0E07\u0E0B\u0E37\u0E49\u0E2D\u0E02\u0E2D\u0E07\u0E09\u0E31\u0E19");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(67, 95, 134, 34);
		panelShow.add(label_5);

		JLabel lblLogout = new JLabel("");
		offset = lblLogout.getInsets().left;
		icon = new ImageIcon(SettingUser.class.getResource("/Image/logout.png"));
		lblLogout.setBounds(21, 150, 36, 34);
		lblLogout.setIcon(resizeIcon(icon, lblLogout.getWidth() - offset, lblLogout.getHeight() - offset));
		panelShow.add(lblLogout);

		JLabel label_7 = new JLabel("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home open = new Home();
				open.setVisible(true);
				dispose();
			}
		});
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(67, 157, 134, 27);
		panelShow.add(label_7);

		JPanel MenuBar = new JPanel();
		MenuBar.setBounds(0, 0, 1281, 42);
		contentPane.add(MenuBar);
		MenuBar.setBackground(new Color(0, 51, 51));
		MenuBar.setLayout(null);

		JLabel taggingProduct_Bar = new JLabel(
				"\u0E15\u0E34\u0E14\u0E15\u0E32\u0E21\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		taggingProduct_Bar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		taggingProduct_Bar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				taggingProduct_Bar.setForeground(new Color(255, 69, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				taggingProduct_Bar.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelShow.setVisible(false);
				panelShowTag.setVisible(true);
			}
		});
		taggingProduct_Bar.setBorder(UIManager.getBorder("MenuBar.border"));
		taggingProduct_Bar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taggingProduct_Bar.setForeground(Color.WHITE);
		taggingProduct_Bar.setBounds(773, 12, 76, 23);
		MenuBar.add(taggingProduct_Bar);

		JLabel about_Bar = new JLabel("");
		about_Bar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		about_Bar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				About ab = new About();
				ab.setVisible(true);
			}
		});
		about_Bar.setBounds(1135, 8, 22, 27);
		MenuBar.add(about_Bar);
		about_Bar.setIcon(new ImageIcon(Home.class.getResource("/Image/markz.png")));

		JLabel lblUser = new JLabel("\u0E1A\u0E31\u0E0D\u0E0A\u0E35\u0E02\u0E2D\u0E07 PANUWAT RUEHAROM");
		lblUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelShow.setVisible(true);
				panelShowTag.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblUser.setForeground(new Color(255, 69, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblUser.setForeground(Color.WHITE);
			}

		});

		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setBounds(937, 11, 188, 23);
		MenuBar.add(lblUser);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(0, 42, 1281, 129);
		contentPane.add(SearchPanel);
		SearchPanel.setBackground(new Color(8, 54, 69));
		SearchPanel.setLayout(null);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				goHome();
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(
				Home.class.getResource("/Image/\u0E42\u0E25\u0E42\u0E01\u0E49\u0E2A\u0E35\u0E02\u0E32\u0E273.png")));
		label.setBounds(135, 13, 108, 96);
		SearchPanel.add(label);

		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(527, 56, 504, 40);
		SearchPanel.add(textField);
		textField.setColumns(10);

		JLabel lblBigSale = new JLabel("SALE");
		lblBigSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goHome();
			}
		});
		lblBigSale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBigSale.setFont(new Font("Segoe WP Black", Font.BOLD, 24));
		lblBigSale.setForeground(Color.WHITE);
		lblBigSale.setBounds(304, 39, 70, 40);
		SearchPanel.add(lblBigSale);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 102, 51));
		panel_1.setBounds(1028, 56, 44, 40);
		SearchPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(
				Home.class.getResource("/Image/\u0E04\u0E49\u0E19\u0E2B\u0E32 \u0E2A\u0E35\u0E02\u0E32\u0E272.png")));
		label_1.setBounds(10, 0, 33, 43);
		panel_1.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Home.class.getResource(
				"/Image/\u0E15\u0E23\u0E30\u0E01\u0E25\u0E49\u0E32\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E322.png")));
		label_2.setBounds(1133, 56, 32, 40);
		SearchPanel.add(label_2);

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goHome();
			}
		});
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_2.setBackground(new Color(255, 102, 51));
		panel_2.setBounds(254, 77, 115, 10);
		SearchPanel.add(panel_2);

		JLabel lblBig = new JLabel("BIG");
		lblBig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goHome();
			}
		});
		lblBig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBig.setBackground(Color.WHITE);
		lblBig.setForeground(new Color(255, 102, 51));
		lblBig.setFont(new Font("Segoe WP Black", Font.BOLD, 24));
		lblBig.setBounds(253, 39, 53, 40);
		SearchPanel.add(lblBig);

		JPanel panelSetting = new JPanel();
		panelSetting.setBounds(0, 193, 232, 383);
		contentPane.add(panelSetting);
		panelSetting.setLayout(null);

		JLabel lblShowuser = new JLabel("\u0E2A\u0E27\u0E31\u0E2A\u0E14\u0E35, PANUWAT RUEHAROM");
		lblShowuser.setForeground(Color.GRAY);
		lblShowuser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblShowuser.setBounds(36, 16, 222, 28);
		panelSetting.add(lblShowuser);

		lbl_Manage_Account = new JLabel(
				"\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E01\u0E31\u0E1A\u0E1A\u0E31\u0E0D\u0E0A\u0E35\u0E02\u0E2D\u0E07\u0E09\u0E31\u0E19");
		lbl_Manage_Account.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Manage_Account.setForeground(Color.BLUE);
		lbl_Manage_Account.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Manage_Account.setBounds(46, 46, 205, 28);
		panelSetting.add(lbl_Manage_Account);

		lbl_Manage_MyProfile = new JLabel(
				"\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E48\u0E27\u0E19\u0E15\u0E31\u0E27");
		lbl_Manage_MyProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Manage_MyProfile.setForeground(Color.GRAY);
		lbl_Manage_MyProfile.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Manage_MyProfile.setBounds(56, 80, 157, 16);
		panelSetting.add(lbl_Manage_MyProfile);

		lbl_Manage_Address = new JLabel("\u0E2A\u0E21\u0E38\u0E14\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48");
		lbl_Manage_Address.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Manage_Address.setForeground(Color.GRAY);
		lbl_Manage_Address.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Manage_Address.setBounds(56, 107, 157, 16);
		panelSetting.add(lbl_Manage_Address);

		lbl_Manage_MyOrders = new JLabel(
				"\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E2A\u0E31\u0E48\u0E07\u0E0B\u0E37\u0E49\u0E2D\u0E02\u0E2D\u0E07\u0E09\u0E31\u0E19 ");
		lbl_Manage_MyOrders.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_Manage_MyOrders.setForeground(Color.GRAY);
		lbl_Manage_MyOrders.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_Manage_MyOrders.setBounds(46, 136, 148, 28);
		panelSetting.add(lbl_Manage_MyOrders);

		JPanel panel = new JPanel();
		panel.setBounds(255, 193, 1027, 678);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		panel_Manage_Account = new JPanel();
		panel.add(panel_Manage_Account, "name_274882012486984");
		panel_Manage_Account.setLayout(null);

		JPanel panel_My = new JPanel();
		panel_My.setBounds(28, 67, 281, 224);
		panel_My.setBackground(Color.WHITE);
		panel_Manage_Account.add(panel_My);
		panel_My.setLayout(null);

		JLabel label_4 = new JLabel("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E48\u0E27\u0E19\u0E15\u0E31\u0E27");
		label_4.setBounds(29, 11, 84, 28);
		panel_My.add(label_4);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label_6 = new JLabel("\u0E41\u0E01\u0E49\u0E44\u0E02");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(123, 12, 46, 28);
		panel_My.add(label_6);

		JLabel lbl_MA_user = new JLabel("Panuwat Rueharom");
		lbl_MA_user.setForeground(Color.BLACK);
		lbl_MA_user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MA_user.setBounds(29, 50, 224, 28);
		panel_My.add(lbl_MA_user);
		lbl_MA_user.setText(username);

		JLabel lbl_MA_email = new JLabel("m.game.m@gmail.com");
		lbl_MA_email.setForeground(Color.BLACK);
		lbl_MA_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_MA_email.setBounds(29, 89, 224, 28);
		panel_My.add(lbl_MA_email);
		lbl_MA_email.setText(managerAddress.getEmail(user_id));

		JPanel panel_Address = new JPanel();
		panel_Address.setBounds(335, 67, 627, 224);
		panel_Address.setBackground(Color.WHITE);
		panel_Manage_Account.add(panel_Address);
		panel_Address.setLayout(null);
		
		iconaddress = new JLabel("");
		iconaddress.setIcon(new ImageIcon(SettingUser.class.getResource("/Image/AddIcon.png")));
		iconaddress.setVisible(false);
		iconaddress.setBounds(39, 99, 46, 51);
		panel_Address.add(iconaddress);

		JLabel label_8 = new JLabel("\u0E2A\u0E21\u0E38\u0E14\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(29, 11, 63, 28);
		panel_Address.add(label_8);

		lbl_edit = new JLabel("\u0E41\u0E01\u0E49\u0E44\u0E02");
		lbl_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					falseAll();
					panel_Manage_AddAddress.setVisible(true);
				
			}
		});
		lbl_edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_edit.setForeground(Color.BLUE);
		lbl_edit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_edit.setBounds(97, 12, 46, 28);
		panel_Address.add(lbl_edit);

		lblstatus = new JLabel(
				"\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48\u0E40\u0E23\u0E34\u0E48\u0E21\u0E15\u0E49\u0E19\u0E43\u0E19\u0E01\u0E32\u0E23\u0E08\u0E31\u0E14\u0E2A\u0E48\u0E07\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblstatus.setForeground(Color.BLACK);
		lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblstatus.setBounds(29, 50, 224, 28);
		panel_Address.add(lblstatus);

		textName = new JLabel(
				"\u0E20\u0E32\u0E19\u0E38\u0E27\u0E31\u0E12\u0E19\u0E4C \u0E24\u0E2B\u0E30\u0E23\u0E21\u0E13\u0E4C");
		textName.setForeground(Color.BLACK);
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBounds(29, 89, 224, 28);
		panel_Address.add(textName);

		textAdress = new JTextPane();
		textAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAdress.setText(
				"147/292 \u0E2B\u0E21\u0E39\u0E48 5 \u0E21.\u0E21\u0E13\u0E35\u0E41\u0E01\u0E49\u0E27\u0E01\u0E23\u0E35\u0E19\u0E40\u0E2E\u0E49\u0E32\u0E23\u0E4C \u0E15.\u0E2B\u0E49\u0E27\u0E22\u0E01\u0E30\u0E1B\u0E34 \u0E2D.\u0E40\u0E21\u0E37\u0E2D\u0E07 \u0E0A\u0E25\u0E1A\u0E38\u0E23\u0E35");
		textAdress.setBounds(29, 114, 261, 40);
		panel_Address.add(textAdress);

		textPhone = new JLabel("0616577015");
		textPhone.setForeground(Color.BLACK);
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPhone.setBounds(29, 151, 224, 28);
		panel_Address.add(textPhone);

		lblstatus2 = new JLabel(
				"\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48\u0E40\u0E23\u0E34\u0E48\u0E21\u0E15\u0E49\u0E19\u0E43\u0E19\u0E01\u0E32\u0E23\u0E2D\u0E2D\u0E01\u0E43\u0E1A\u0E01\u0E33\u0E01\u0E31\u0E1A\u0E20\u0E32\u0E29\u0E35");
		lblstatus2.setForeground(Color.BLACK);
		lblstatus2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblstatus2.setBounds(355, 50, 224, 28);
		panel_Address.add(lblstatus2);

		textPhone2 = new JLabel("0616577015");
		textPhone2.setForeground(Color.BLACK);
		textPhone2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPhone2.setBounds(355, 151, 224, 28);
		panel_Address.add(textPhone2);

		textAdress2 = new JTextPane();
		textAdress2.setText(
				"147/292 \u0E2B\u0E21\u0E39\u0E48 5 \u0E21.\u0E21\u0E13\u0E35\u0E41\u0E01\u0E49\u0E27\u0E01\u0E23\u0E35\u0E19\u0E40\u0E2E\u0E49\u0E32\u0E23\u0E4C \u0E15.\u0E2B\u0E49\u0E27\u0E22\u0E01\u0E30\u0E1B\u0E34 \u0E2D.\u0E40\u0E21\u0E37\u0E2D\u0E07 \u0E0A\u0E25\u0E1A\u0E38\u0E23\u0E35");
		textAdress2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAdress2.setBounds(355, 114, 246, 40);
		panel_Address.add(textAdress2);

		textName2 = new JLabel(
				"\u0E20\u0E32\u0E19\u0E38\u0E27\u0E31\u0E12\u0E19\u0E4C \u0E24\u0E2B\u0E30\u0E23\u0E21\u0E13\u0E4C");
		textName2.setForeground(Color.BLACK);
		textName2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName2.setBounds(355, 89, 224, 28);
		panel_Address.add(textName2);

		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(SettingUser.class.getResource("/Image/line.PNG")));
		label_16.setBounds(311, 20, 18, 193);
		panel_Address.add(label_16);

		JLabel label_3 = new JLabel(
				"\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E01\u0E31\u0E1A\u0E1A\u0E31\u0E0D\u0E0A\u0E35\u0E02\u0E2D\u0E07\u0E09\u0E31\u0E19");
		label_3.setBounds(28, 22, 205, 34);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Manage_Account.add(label_3);

		panel_3 = new JPanel();
		panel_3.setVisible(false);
		panel_3.setBounds(28, 340, 934, 48);
		panel_3.setBackground(Color.WHITE);
		panel_Manage_Account.add(panel_3);
		panel_3.setLayout(null);

		JLabel label_17 = new JLabel(
				"\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E04\u0E33\u0E2A\u0E31\u0E48\u0E07\u0E0B\u0E37\u0E49\u0E2D\u0E25\u0E48\u0E32\u0E2A\u0E38\u0E14");
		label_17.setBounds(10, 11, 129, 19);
		panel_3.add(label_17);
		label_17.setForeground(Color.BLACK);
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 15));

		panel_Manage_EditMyAccount = new JPanel();
		panel.add(panel_Manage_EditMyAccount, "name_302356133327288");
		panel_Manage_EditMyAccount.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel(
				"\u0E41\u0E01\u0E49\u0E44\u0E02\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E48\u0E27\u0E19\u0E15\u0E31\u0E27");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(24, 11, 176, 60);
		panel_Manage_EditMyAccount.add(lblNewLabel_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(24, 70, 982, 570);
		panel_Manage_EditMyAccount.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D-\u0E2A\u0E01\u0E38\u0E25");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(65, 40, 117, 33);
		panel_4.add(lblNewLabel_2);

		text_name = new JTextField();
		text_name.setBounds(65, 72, 305, 33);
		panel_4.add(text_name);
		text_name.setColumns(10);

		JLabel label_18 = new JLabel("\u0E2D\u0E35\u0E40\u0E21\u0E25 |");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_18.setBounds(448, 40, 50, 33);
		panel_4.add(label_18);

		JLabel label_19 = new JLabel("\u0E41\u0E01\u0E49\u0E44\u0E02");
		label_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_19.setForeground(Color.BLUE);
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_19.setBounds(491, 40, 56, 33);
		panel_4.add(label_19);

		JLabel lblAprchamphotmailcom = new JLabel("apr_champ@hotmail.com");
		lblAprchamphotmailcom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAprchamphotmailcom.setBounds(448, 70, 222, 33);
		panel_4.add(lblAprchamphotmailcom);

		JLabel label_20 = new JLabel("0616544215");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_20.setBounds(712, 70, 222, 33);
		panel_4.add(label_20);

		JLabel label_21 = new JLabel(
				"\u0E40\u0E1A\u0E2D\u0E23\u0E4C\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C\u0E21\u0E37\u0E2D\u0E16\u0E37\u0E2D |");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_21.setBounds(712, 40, 126, 33);
		panel_4.add(label_21);

		JLabel label_22 = new JLabel("\u0E41\u0E01\u0E49\u0E44\u0E02");
		label_22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_22.setForeground(Color.BLUE);
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_22.setBounds(841, 40, 56, 33);
		panel_4.add(label_22);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u0E27\u0E31\u0E19", "1", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
				"25", "26", "27", "28", "29", "30", "31" }));
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBorder(UIManager.getBorder("ComboBox.border"));
		comboBox.setBounds(74, 254, 83, 44);
		panel_4.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "\u0E40\u0E14\u0E37\u0E2D\u0E19",
				"\u0E21\u0E01\u0E23\u0E32\u0E04\u0E21", "\u0E01\u0E38\u0E21\u0E20\u0E32\u0E1E\u0E31\u0E19\u0E18\u0E4C",
				"\u0E21\u0E35\u0E19\u0E32\u0E04\u0E21", "\u0E40\u0E21\u0E29\u0E32\u0E22\u0E19",
				"\u0E1E\u0E24\u0E29\u0E20\u0E32\u0E04\u0E21", "\u0E21\u0E34\u0E16\u0E38\u0E19\u0E32\u0E22\u0E19",
				"\u0E01\u0E23\u0E01\u0E0E\u0E32\u0E04\u0E21", "\u0E2A\u0E34\u0E07\u0E2B\u0E32\u0E04\u0E21",
				"\u0E01\u0E31\u0E19\u0E22\u0E32\u0E22\u0E19", "\u0E15\u0E38\u0E25\u0E32\u0E04\u0E21",
				"\u0E1E\u0E24\u0E28\u0E08\u0E34\u0E01\u0E32\u0E22\u0E19",
				"\u0E18\u0E31\u0E19\u0E27\u0E32\u0E04\u0E21" }));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(156, 254, 116, 44);
		panel_4.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "\u0E04.\u0E28.", "2018", "2017", "2016", "2015",
				"2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002",
				"2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989",
				"1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976",
				"1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963",
				"1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950",
				"1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937",
				"1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924",
				"1923", "1922", "1921", "1920", "1919" }));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(271, 254, 75, 44);
		panel_4.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(
				new String[] { "\u0E40\u0E1E\u0E28", "\u0E0A\u0E32\u0E22", "\u0E2B\u0E0D\u0E34\u0E07" }));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setBounds(448, 254, 75, 44);
		panel_4.add(comboBox_3);

		JLabel label_23 = new JLabel(
				"\u0E27\u0E31\u0E19\u0E40\u0E14\u0E37\u0E2D\u0E19\u0E1B\u0E35\u0E40\u0E01\u0E34\u0E14");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_23.setBounds(74, 208, 116, 33);
		panel_4.add(label_23);

		JLabel label_24 = new JLabel("\u0E40\u0E1E\u0E28");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_24.setBounds(448, 208, 116, 33);
		panel_4.add(label_24);

		Button button = new Button("\u0E41\u0E01\u0E49\u0E44\u0E02");
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button.setBackground(new Color(255, 99, 71));
		button.setBounds(65, 445, 296, 49);
		panel_4.add(button);

		panel_Manage_AddAddress = new JPanel();
		panel.add(panel_Manage_AddAddress, "name_350229783274078");
		panel_Manage_AddAddress.setLayout(null);

		falseAll();
		panel_Manage_Account.setVisible(true);

		JLabel lblNewLabel_3 = new JLabel(
				"\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48\u0E43\u0E2B\u0E21\u0E48");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(41, 41, 179, 41);
		panel_Manage_AddAddress.add(lblNewLabel_3);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(51, 95, 941, 532);
		panel_Manage_AddAddress.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D - \u0E19\u0E32\u0E21\u0E2A\u0E01\u0E38\u0E25");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(39, 44, 145, 25);
		panel_5.add(lblNewLabel_4);

		text_AddAddress_name = new JTextField();
		text_AddAddress_name.setBounds(39, 80, 393, 40);
		panel_5.add(text_AddAddress_name);
		text_AddAddress_name.setColumns(10);

		text_AddAddress_phone = new JTextField();
		text_AddAddress_phone.setColumns(10);
		text_AddAddress_phone.setBounds(39, 199, 393, 40);
		panel_5.add(text_AddAddress_phone);

		JLabel label_25 = new JLabel(
				"\u0E2B\u0E21\u0E32\u0E22\u0E40\u0E25\u0E02\u0E42\u0E17\u0E23\u0E28\u0E31\u0E1E\u0E17\u0E4C");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_25.setBounds(39, 163, 145, 25);
		panel_5.add(label_25);

		text_AddAddress_address = new JTextField();
		text_AddAddress_address.setColumns(10);
		text_AddAddress_address.setBounds(488, 80, 393, 40);
		panel_5.add(text_AddAddress_address);

		JLabel label_26 = new JLabel("\u0E17\u0E35\u0E48\u0E2D\u0E22\u0E39\u0E48");
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_26.setBounds(488, 44, 145, 25);
		panel_5.add(label_26);

		JLabel label_27 = new JLabel("\u0E08\u0E31\u0E07\u0E2B\u0E27\u0E31\u0E14");
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_27.setBounds(488, 150, 145, 25);
		panel_5.add(label_27);

		text_AddAddress_district = new JTextField();
		text_AddAddress_district.setColumns(10);
		text_AddAddress_district.setBounds(488, 292, 393, 40);
		panel_5.add(text_AddAddress_district);

		JLabel label_28 = new JLabel("\u0E40\u0E02\u0E15/\u0E2D\u0E33\u0E40\u0E20\u0E2D");
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_28.setBounds(488, 256, 145, 25);
		panel_5.add(label_28);

		text_AddAddress_zipcode = new JTextField();
		text_AddAddress_zipcode.setColumns(10);
		text_AddAddress_zipcode.setBounds(488, 404, 393, 40);
		panel_5.add(text_AddAddress_zipcode);

		JLabel label_29 = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E44\u0E1B\u0E23\u0E29\u0E13\u0E35\u0E22\u0E4C");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_29.setBounds(488, 368, 145, 25);
		panel_5.add(label_29);

		Button button_1 = new Button("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
		button_1.setBackground(new Color(255, 99, 71));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		button_1.setBounds(39, 292, 285, 50);
		panel_5.add(button_1);

		JComboBox combobox_AddAddress_province = new JComboBox();
		combobox_AddAddress_province.setModel(new DefaultComboBoxModel(new String[] {"Bangkok", "Krabi Province", "Kanchanaburi Province", "Kalasin Province", "Kamphaeng Phet Province", "Khon Kaen Province", "Chanthaburi Province", "Chachoengsao Province", "Chonburi Province", "Chainat Province", "Chaiyaphum Province", "Chumphon Province", "Chiang Mai Province", "Chiang Rai Province", "Trang Province", "Trat Province", "Tak Province", "Nakhon Nayok Province", "Nakhon Pathom Province", "Nakhon Phanom Province", "Nakhon Ratchasima Province", "Nakhon Si Thammarat Province", "Nakhon Sawan Province", "Nonthaburi Province", "Narathiwat Province", "Nan Province", "Bueng Kan Province", "Buriram Province", "Pathum Thani Province", "Prachuap Khiri Khan Province", "Prachinburi Province", "Pattani Province", "Phra Nakhon Si Ayutthaya Province", "Phayao Province", "Phang Nga Province", "Phatthalung Province", "Phichit Province", "Phitsanulok Province", "Phetchaburi Province", "Phetchabun Province", "Phrae Province", "Phuket Province", "Maha Sarakham Province", "Mukdahan Province", "Mae Hong Son Province", "Yasothon Province", "Yala Province", "Roi Et Province", "Ranong Province", "Rayong Province", "Ratchaburi Province", "Lopburi Province", "Lampang Province", "Lamphun Province", "Loei Province", "Sisaket Province", "Sakon Nakhon Province", "Songkhla Province", "Satun Province", "Samut Prakan Province", "Samut Songkhram Province", "Samut Sakhon Province", "Sa Kaeo Province", "Saraburi Province", "Sing Buri Province", "Sukhothai Province", "Suphan Buri Province", "Surat Thani Province", "Surin Province", "Nong Khai Province", "Nong Bua Lamphu Province", "Ang Thong Province", "Amnat Charoen Province", "Udon Thani Province", "Uttaradit Province", "Uthai Thani Province", "Ubon Ratchathani Province"}));
		combobox_AddAddress_province.setBounds(488, 186, 393, 40);
		panel_5.add(combobox_AddAddress_province);
		
		JLabel alert_name_AA = new JLabel("\u0E0A\u0E48\u0E2D\u0E07\u0E19\u0E35\u0E49\u0E40\u0E27\u0E49\u0E19\u0E27\u0E48\u0E32\u0E07\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49");
		alert_name_AA.setForeground(Color.RED);
		alert_name_AA.setVisible(false);
		alert_name_AA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alert_name_AA.setBounds(39, 131, 393, 25);
		panel_5.add(alert_name_AA);
		
		JLabel alert_phone_AA = new JLabel("\u0E0A\u0E48\u0E2D\u0E07\u0E19\u0E35\u0E49\u0E40\u0E27\u0E49\u0E19\u0E27\u0E48\u0E32\u0E07\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49");
		alert_phone_AA.setForeground(Color.RED);
		alert_phone_AA.setVisible(false);
		alert_phone_AA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alert_phone_AA.setBounds(39, 250, 393, 25);
		panel_5.add(alert_phone_AA);
		
		JLabel alert_address_AA = new JLabel("\u0E0A\u0E48\u0E2D\u0E07\u0E19\u0E35\u0E49\u0E40\u0E27\u0E49\u0E19\u0E27\u0E48\u0E32\u0E07\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49");
		alert_address_AA.setVisible(false);
		alert_address_AA.setForeground(Color.RED);
		alert_address_AA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alert_address_AA.setBounds(498, 128, 377, 31);
		panel_5.add(alert_address_AA);
		
		JLabel alert_district_AA = new JLabel("\u0E0A\u0E48\u0E2D\u0E07\u0E19\u0E35\u0E49\u0E40\u0E27\u0E49\u0E19\u0E27\u0E48\u0E32\u0E07\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49");
		alert_district_AA.setVisible(false);
		alert_district_AA.setForeground(Color.RED);
		alert_district_AA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alert_district_AA.setBounds(488, 338, 393, 31);
		panel_5.add(alert_district_AA);
		
		JLabel alert_zipcode_AA = new JLabel("\u0E0A\u0E48\u0E2D\u0E07\u0E19\u0E35\u0E49\u0E40\u0E27\u0E49\u0E19\u0E27\u0E48\u0E32\u0E07\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49");
		alert_zipcode_AA.setVisible(false);
		alert_zipcode_AA.setForeground(Color.RED);
		alert_zipcode_AA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		alert_zipcode_AA.setBounds(488, 455, 393, 31);
		panel_5.add(alert_zipcode_AA);

		panelShow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						lblNewLabel.setForeground(new Color(255, 69, 0));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						lblNewLabel.setForeground(Color.BLACK);
					}
				});
				label_5.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						label_5.setForeground(new Color(255, 69, 0));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						label_5.setForeground(Color.BLACK);
					}
				});
				label_7.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						label_7.setForeground(new Color(255, 69, 0));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						label_7.setForeground(Color.BLACK);
					}
				});
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
			}

		});
		lbl_Manage_Account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setManage();
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
				lbl_Manage_Account.setForeground(Color.blue);
				loadTablePageAccount();
				falseAll();
				panel_Manage_Account.setVisible(true);
			}
		});
		lbl_Manage_MyProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setManage();
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
				lbl_Manage_MyProfile.setForeground(Color.blue);
				falseAll();
				panel_Manage_EditMyAccount.setVisible(true);
			}
		});
		lbl_Manage_Address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setManage();
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
				lbl_Manage_Address.setForeground(Color.blue);
				falseAll();
				panel_Manage_AddAddress.setVisible(true);
			}
		});
		lbl_Manage_MyOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setManage();
				panelShow.setVisible(false);
				panelShowTag.setVisible(false);
				lbl_Manage_MyOrders.setForeground(Color.blue);
			}
		});

		NewProduct_SCP = new JScrollPane();
		NewProduct_SCP.setVisible(false);
		NewProduct_SCP.setBounds(28, 388, 934, 266);
		panel_Manage_Account.add(NewProduct_SCP);
		
		NewProduct_tbl = new JTable();
		NewProduct_tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				loadTablePageAccount();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JOptionPane.showMessageDialog(SettingUser.this, "�����");
				}catch(Exception exp) {
					
				}
			}
		});
		NewProduct_SCP.setViewportView(NewProduct_tbl);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			boolean redyInsert = true;
			String address = Service.SettingService.isValidAddress(text_AddAddress_name.getText().trim());
			String phone   = Service.SettingService.isValidPhone(text_AddAddress_phone.getText().trim());
			String name = Service.SettingService.isValidName(text_AddAddress_name.getText().trim());
			String zipcode =Service.SettingService.isValidZipcode(text_AddAddress_zipcode.getText().trim());
			String district = Service.SettingService.isValidDistrict(text_AddAddress_district.getText().trim());
			System.out.println(address+phone+name+zipcode+district);
				if(!(address.equals("PASS")&&phone.equals("PASS")&&name.equals("PASS")&&zipcode.equals("PASS")&&district.equals("PASS"))) {
					redyInsert=false;
					JOptionPane.showMessageDialog(SettingUser.this, "���������١��ͧ", "����͹", JOptionPane.WARNING_MESSAGE);
				}if(redyInsert) {
					boolean checkInsert = managerAddress.saveTable_address(user_id, text_AddAddress_phone.getText().trim(), text_AddAddress_address.getText().trim(), combobox_AddAddress_province.getSelectedItem().toString(), text_AddAddress_district.getText().trim(), text_AddAddress_zipcode.getText().trim(),text_AddAddress_name.getText().trim());
					if(checkInsert) {
						JOptionPane.showMessageDialog(SettingUser.this, "�ѹ�֡�����������");
					}else
						JOptionPane.showMessageDialog(SettingUser.this, "�Դ��ͼԴ��ҡ","����͹",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		lblUser.setText("�ѭ�բͧ " + username.toUpperCase());
		loadAddress();
		loadTablePageAccount();
		if(orderMyAccount.size()!=0) {
			panel_3.setVisible(true);
			NewProduct_SCP.setVisible(true);
		}
		//Key Address
		text_AddAddress_phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				alert_phone_AA.setVisible(false);
				String st = text_AddAddress_phone.getText();
				String tempPhone = st.replaceAll("\\s+","");
				String tempCheck=Service.SettingService.isValidPhone(tempPhone);
				if(tempCheck.equals("PASS")||tempCheck.equals("Not text")) {
					alert_phone_AA.setVisible(false);
				}
				else {
					alert_phone_AA.setVisible(true);
					alert_phone_AA.setText(tempCheck);
				}
			}
		});
		text_AddAddress_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				alert_name_AA.setVisible(false);
				String st = text_AddAddress_name.getText();
				String tempPassword = st.replaceAll("\\s+","");
				String tempCheck=Service.SettingService.isValidName(tempPassword);
				if(tempCheck.equals("PASS")||tempCheck.equals("Not text")) {
					alert_name_AA.setVisible(false);
				}
				else {
					alert_name_AA.setVisible(true);
					alert_name_AA.setText(tempCheck);
				}
			}
		});
		text_AddAddress_address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				alert_address_AA.setVisible(false);
				String st = text_AddAddress_address.getText();
				String tempAddress = st.replaceAll("\\s+","");
				String tempCheck=Service.SettingService.isValidAddress(tempAddress);
				if(tempCheck.equals("PASS")||tempCheck.equals("Not text")) {
					alert_address_AA.setVisible(false);
				}
				else {
					alert_address_AA.setVisible(true);
					alert_address_AA.setText(tempCheck);
				}
			}
		});
		text_AddAddress_district.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				alert_district_AA.setVisible(false);
				String st = text_AddAddress_district.getText();
				String tempDistrict = st.replaceAll("\\s+","");
				String tempCheck=Service.SettingService.isValidDistrict(tempDistrict);
				if(tempCheck.equals("PASS")||tempCheck.equals("Not text")) {
					alert_district_AA.setVisible(false);
				}
				else {
					alert_district_AA.setVisible(true);
					alert_district_AA.setText(tempCheck);
				}
			}
		});
		text_AddAddress_zipcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				alert_zipcode_AA.setVisible(false);
				String st = text_AddAddress_zipcode.getText();
				String tempZipcode = st.replaceAll("\\s+","");
				String tempCheck=Service.SettingService.isValidZipcode(tempZipcode);
				if(tempCheck.equals("PASS")||tempCheck.equals("Not text")) {
					alert_zipcode_AA.setVisible(false);
				}
				else {
					alert_zipcode_AA.setVisible(true);
					alert_zipcode_AA.setText(tempCheck);
				}
			}
		});
		//Key Address
	}

	public void loadAddress() {
		LinkedList<AddressDB> addressUser = managerAddress.getAddress(user_id);
		if (addressUser.size() == 0) {
			lblstatus.setText("�ѹ�֡�����㹡�èѴ���Թ��ҷ����");
			lbl_edit.setText("����");
			textName.setText("");
			textAdress.setText("");
			textPhone.setText("");
			lblstatus2.setText("�ѹ�֡�������㹡���͡㺡ӡѺ���շ����");
			textName2.setText("");
			textAdress2.setText("");
			textPhone2.setText("");
			iconaddress.setVisible(true);
		}
		else {
			iconaddress.setVisible(false);
			textName.setText(addressUser.getFirst().getName());
			textAdress.setText(addressUser.getFirst().getAddress());
			textPhone.setText(addressUser.getFirst().getPhone());
			textName2.setText(addressUser.getFirst().getName());
			textAdress2.setText(addressUser.getFirst().getAddress());
			textPhone2.setText(addressUser.getFirst().getPhone());
		}
	}

	public void setManage() {
		lbl_Manage_Account.setForeground(Color.GRAY);
		lbl_Manage_MyProfile.setForeground(Color.GRAY);
		lbl_Manage_Address.setForeground(Color.GRAY);
		lbl_Manage_MyOrders.setForeground(Color.GRAY);
	}
	public void checkDuplicateImage() {
		int tempCheck = 0;
		for (int i = 1,j=0; i < orderMyAccount.size(); i++) {
			if(orderMyAccount.get(i).get_order_id()== orderMyAccount.get(i-1).get_order_id()) {
				tempCheck++;
			}
			else  {
				if(tempCheck!=0)
					checkDuplicateOrderID[j]=tempCheck+1;
				else
					checkDuplicateOrderID[j]=tempCheck;
				tempCheck=0;
				j++;
			}
		}
	}
	public void loadTablePageAccount() {
		checkDuplicateImage();
		BufferedImage[] img= new BufferedImage[4] ;
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("����觫��� #");
		model.addColumn("��觫����ѹ���");
		model.addColumn("��¡���Թ���#1");
		model.addColumn("��¡���Թ���#2");
		model.addColumn("��¡���Թ���#3");
		model.addColumn("��¡���Թ���#4");
		model.addColumn("�ʹ���������");
		model.addColumn("");
		int[] temp  = checkDuplicateOrderID;
		boolean checkImage = false;
		for (int i = 0,j=0; i < orderMyAccount.size(); i++) {
			if(temp[j]>0) {
				 img[temp[j]-1]=orderMyAccount.get(i).getNewProduct_Img();
				 temp[j]=temp[j]-1;
				 checkImage=true;
			}
			if(temp[j]==0) {
				if(checkImage) {
				model.addRow(new Object[] { orderMyAccount.get(i).get_order_id(), orderMyAccount.get(i).get_date(),
						img[0],img[1],img[2],img[3], "�" + orderMyAccount.get(i).get_priceAll() + ".00",
					"�Ѵ��ä���觫���" });
				checkImage =false;
				}
				else {
					model.addRow(new Object[] { orderMyAccount.get(i).get_order_id(), orderMyAccount.get(i).get_date(),
							orderMyAccount.get(i).getNewProduct_Img(),img[1],img[2],img[3], "�" + orderMyAccount.get(i).get_priceAll() + ".00",
						"�Ѵ��ä���觫���" });
				}
				img[0]=null;
				img[1]=null;
				img[2]=null;
				img[3]=null;
			}
		}
		NewProduct_tbl.setModel(model);
		for(int i =1 ; i<5;i++) {
			if(	NewProduct_tbl.getColumn("��¡���Թ���#"+i)!=null)
				NewProduct_tbl.getColumn("��¡���Թ���#"+i).setCellRenderer(new DataTableRenderer());
		}
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)NewProduct_tbl.getDefaultRenderer(Object.class);
	    renderer.setHorizontalAlignment( SwingConstants.CENTER );
		NewProduct_tbl.setRowHeight(120);

	}

	public void falseAll() {
		panel_Manage_Account.setVisible(false);
		panel_Manage_EditMyAccount.setVisible(false);
		panel_Manage_AddAddress.setVisible(false);
	}
	public void goHome() {
		HomeLoggedIn open = new HomeLoggedIn(username,user_id);
		open.setVisible(true);
		dispose();
	}
}
