package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import org.hibernate.exception.ConstraintViolationException;

import user.Company;
import user.User;
import user.UserHome;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class ProfileForm extends javax.swing.JFrame {

	

	private User user;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JSeparator jSeparator1;
	private JLabel titleLabel;
	private ButtonGroup companyButtonGroup;
	private JPasswordField passwordRepeatField;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JLabel jLabel10;
	private JTextField companyNumberField;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JTextField emailField;
	private JTextField phoneNumberField;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JButton fileSelectionButton;
	private JLabel jLabel5;
	private JTextField representationDocField;
	private JPanel jPanel5;
	private JTextField companyNameField;
	private JLabel jLabel4;
	private JScrollPane jScrollPane1;
	private JTable CompaniesTable;
	private JPanel jPanel4;
	private JPanel jPanel2;
	private JButton saveButton;
	private JButton cancelButton;
	private JPanel jPanel1;
	private JLabel jLabel14;
	private JPanel jPanel3;
	private JRadioButton companyRadioButton;
	private JCheckBox newCompanyCheckBox;
	private JCheckBox findCompanyCheckBox;
	private JTextField lastnameField;
	private JTextField firstnameField;

	private SingleSelectableTableModel<Company> companiesTableModel;

	protected File representationDocFile;

	private Border redBorder;

	private Border regBorder;

	private DesktopManager dmanager;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ProfileForm inst = new ProfileForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ProfileForm() {
		super("پروفایل کاربر");
		initGUI();
		saveButton.setText("ثبت");
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				registerProfile();
				
			}
			
		});
		
		setTitle("ایجاد حساب کاربری جدید");
		titleLabel.setText("ایجاد حساب کاربری جدید");
		
		
		
	}

	public ProfileForm(User u) {
		super("پروفایل کاربر");
		user = u;
		initGUI();
		
		firstnameField.setText(user.getFirstname());
		lastnameField.setText(user.getLastname());
		emailField.setText(user.getEmail());
		phoneNumberField.setText(user.getPhoneNumber().toString());
		
		
		usernameField.getParent().remove(usernameField);
		passwordField.getParent().remove(passwordField);
		passwordRepeatField.getParent().remove(passwordRepeatField);
		jLabel10.getParent().remove(jLabel10);
		jLabel11.getParent().remove(jLabel11);
		jLabel12.getParent().remove(jLabel12);
		
		setTitle("تغییر مشخصات کاربری");
		titleLabel.setText("تغییر مشخصات کاربری");
		
		saveButton.setText("ذخیره");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveProfile();
				
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ProfileForm.this.revalidate();
				ProfileForm.this.repaint();
				
			}
		});
	}

	public ProfileForm(DesktopManager desktopManager) {
		this();
		this.dmanager=desktopManager;
		
	}

	private void initGUI() {
		try {
			
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			
			this.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent arg0) {
					if(user==null && dmanager==null){
						LoginPage lp=new LoginPage();
						lp.setLocationRelativeTo(null);
						lp.setVisible(true);
					}
					ProfileForm.this.dispose();
					
					
				}
				
			});
			
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			redBorder = BorderFactory.createLineBorder(Color.red);
			regBorder = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
			
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			
			{
				jPanel1 = new JPanel();
				BoxLayout jPanel1Layout = new BoxLayout(jPanel1,
						javax.swing.BoxLayout.Y_AXIS);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setBounds(45, 36, 522, 241);
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				jPanel1.setPreferredSize(new java.awt.Dimension(600, 366));
				{
					jPanel2 = new JPanel();
					jPanel1.add(jPanel2);
					jPanel2.setBounds(-1, 5, 601, 182);
					jPanel2.setLayout(null);
					jPanel2.setBackground(new java.awt.Color(255, 255, 255));
					jPanel2.setPreferredSize(new java.awt.Dimension(600, 355));
					{
						titleLabel = new JLabel();
						jPanel2.add(titleLabel);
						titleLabel.setText("\u062a\u063a\u06cc\u06cc\u0631 \u0645\u0634\u062e\u0635\u0627\u062a \u06a9\u0627\u0631\u0628\u0631\u06cc");
						titleLabel.setBounds(403, 37, 164, 21);
						titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
						titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
						titleLabel.setForeground(new java.awt.Color(128, 0, 64));

					}
					{
						jSeparator1 = new JSeparator();
						jPanel2.add(jSeparator1);
						jSeparator1.setBounds(45, 47, 356, 23);
						jSeparator1
								.setBackground(new java.awt.Color(128, 0, 64));
					}
					{
						firstnameField = new JTextField();
						jPanel2.add(firstnameField);
						firstnameField.setBounds(321, 82, 119, 29);
						firstnameField.setBorder(regBorder);
						firstnameField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
					{
						jLabel1 = new JLabel();
						jPanel2.add(jLabel1);
						jLabel1.setText("\u0646\u0627\u0645 ");
						jLabel1.setBounds(456, 82, 80, 21);
						jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
						jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);

					}
					{
						jLabel2 = new JLabel();
						jPanel2.add(jLabel2);
						jLabel2.setText("\u0646\u0627\u0645 \u062e\u0627\u0646\u0648\u0627\u062f\u06af\u06cc ");
						jLabel2.setBounds(456, 130, 80, 21);
						jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
						jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);

					}
					{
						lastnameField = new JTextField();
						jPanel2.add(lastnameField);
						jPanel2.add(getJLabel7());
						jPanel2.add(getPhoneNumberField());
						jPanel2.add(getEmailField());
						jPanel2.add(getJLabel8());
						jPanel2.add(getJLabel10());
						jPanel2.add(getUsernameField());
						jPanel2.add(getPasswordField());
						jPanel2.add(getJLabel11());
						jPanel2.add(getJLabel12());
						jPanel2.add(getPasswordRepeatField());
						lastnameField.setBounds(321, 130, 119, 29);
						lastnameField.setBorder(regBorder);
						lastnameField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
				}
				{
					jPanel4 = new JPanel();
					jPanel1.add(jPanel4);
					BoxLayout jPanel4Layout = new BoxLayout(jPanel4,
							javax.swing.BoxLayout.Y_AXIS);
					jPanel4.setLayout(jPanel4Layout);
					jPanel4.setPreferredSize(new java.awt.Dimension(600, 238));
					jPanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							20));
					jPanel4.setBackground(new java.awt.Color(255, 255, 255));
					{
						companyRadioButton = new JRadioButton();
						jPanel4.add(companyRadioButton);
						companyRadioButton
								.setText("\u0634\u062e\u0635\u06cc\u062a \u062d\u0642\u0648\u0642\u06cc");
						companyRadioButton.setFont(new java.awt.Font("Tahoma",
								0, 11));
						companyRadioButton.setBackground(new java.awt.Color(
								255, 255, 255));
						companyRadioButton.setBorder(null);
						companyRadioButton
								.setHorizontalAlignment(SwingConstants.RIGHT);
						companyRadioButton
								.setHorizontalTextPosition(SwingConstants.LEFT);
						companyRadioButton.setBounds(441, 188, 95, 14);
						companyRadioButton.setAlignmentX(RIGHT_ALIGNMENT);
						companyRadioButton
								.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						companyRadioButton
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {
										findCompanyCheckBox
												.setVisible(companyRadioButton
														.isSelected());
										newCompanyCheckBox
												.setVisible(companyRadioButton
														.isSelected());
										jPanel4.remove(getJPanel5());
										jPanel4.remove(getJScrollPane1());
										SwingUtilities
												.invokeLater(new Runnable() {

													@Override
													public void run() {
														jPanel4.revalidate();
														jPanel4.repaint();
													}
												});
									}
								});

					}
					{
						findCompanyCheckBox = new JCheckBox();
						jPanel4.add(findCompanyCheckBox);
						// jPanel4.add(getJScrollPane1());
						findCompanyCheckBox
								.setText("\u0627\u0646\u062a\u062e\u0627\u0628 \u0634\u0631\u06a9\u062a \u0627\u0632 \u0645\u06cc\u0627\u0646 \u0634\u0631\u06a9\u062a \u0647\u0627\u06cc \u0645\u0648\u062c\u0648\u062f");
						findCompanyCheckBox.setBounds(270, 226, 257, 19);
						findCompanyCheckBox.setBackground(new java.awt.Color(
								255, 255, 255));
						findCompanyCheckBox.setBorder(BorderFactory
								.createEmptyBorder(0, 0, 10, 30));
						findCompanyCheckBox.setAlignmentX(RIGHT_ALIGNMENT);
						findCompanyCheckBox
								.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						getCompanyButtonGroup().add(findCompanyCheckBox);
						findCompanyCheckBox
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {

										jPanel4.remove(getJPanel5());
										jPanel4.add(getJScrollPane1(), 2);
										SwingUtilities
												.invokeLater(new Runnable() {

													@Override
													public void run() {
														jPanel4.revalidate();
														jPanel4.repaint();
													}
												});
									}
								});
						findCompanyCheckBox.setVisible(false);
					}
					{
						newCompanyCheckBox = new JCheckBox();
						jPanel4.add(newCompanyCheckBox);
						// jPanel4.add(getJPanel5());
						newCompanyCheckBox
								.setText("\u0627\u06cc\u062c\u0627\u062f \u0634\u0631\u06a9\u062a \u062c\u062f\u06cc\u062f");
						newCompanyCheckBox.setBounds(270, 258, 257, 19);
						newCompanyCheckBox.setBackground(new java.awt.Color(
								255, 255, 255));
						newCompanyCheckBox.setBorder(BorderFactory
								.createEmptyBorder(0, 0, 10, 30));
						newCompanyCheckBox.setAlignmentX(RIGHT_ALIGNMENT);
						newCompanyCheckBox
								.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						getCompanyButtonGroup().add(newCompanyCheckBox);
						newCompanyCheckBox
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent e) {

										jPanel4.remove(getJScrollPane1());
										jPanel4.add(getJPanel5(), 3);
										SwingUtilities
												.invokeLater(new Runnable() {

													@Override
													public void run() {
														jPanel4.revalidate();
														jPanel4.repaint();
													}
												});
									}
								});
						newCompanyCheckBox.setVisible(false);
					}
				}
			}
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, BorderLayout.SOUTH);
				jPanel3.setBackground(new java.awt.Color(255, 255, 255));
				jPanel3.setLayout(null);
				jPanel3.setBounds(0, 472, 600, 104);
				jPanel3.setPreferredSize(new java.awt.Dimension(600, 105));
				{
					jLabel14 = new JLabel();
					jPanel3.add(jLabel14);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("ax.jpg")));
					jLabel14.setBounds(399, 26, 204, 78);
				}
				{
					cancelButton = new JButton();
					jPanel3.add(cancelButton);
					cancelButton
							.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
					cancelButton
							.setBackground(new java.awt.Color(255, 236, 255));
					cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					cancelButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton.setBounds(25, 48, 112, 41);
					cancelButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							if(user==null && dmanager==null){
								LoginPage lp=new LoginPage();
								lp.setLocationRelativeTo(null);
								lp.setVisible(true);
							}
							ProfileForm.this.dispose();
							
						}
					});
				}
				{
					saveButton = new JButton();
					jPanel3.add(saveButton);
					saveButton.setBackground(new java.awt.Color(255, 236, 255));
					saveButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					saveButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					saveButton.setBounds(145, 48, 112, 41);
					
				}

			}

			pack();
			setSize(600, 650);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	protected void saveProfile() {
		user.setFirstname(firstnameField.getText());
		user.setLastname(lastnameField.getText());
		try{
			user.setPhoneNumber(Long.parseLong(phoneNumberField.getText()));
		}catch(NumberFormatException nfe){
			nfe.printStackTrace();
		}
		
		user.setEmail(emailField.getText());
		if (companyRadioButton.isSelected()) {
			if (findCompanyCheckBox.isSelected()) {
				if (!companiesTableModel.getSelectedRows().isEmpty()) {
					Company company = companiesTableModel.getSelectedRow();
					
				}

			} else if (newCompanyCheckBox.isSelected()) {
				// Company
				// comp=UserCatalog.getInstance().createCompany(companyNameField.getText(),companyNumberField.getText()
				// );
				// user.setCompany(comp,representationDocFile);
			}
		}
		
		UserHome.getInstance().updateUser(user);

	}

	private ButtonGroup getCompanyButtonGroup() {
		if (companyButtonGroup == null) {
			companyButtonGroup = new ButtonGroup();
		}
		return companyButtonGroup;
	}

	private JTable getCompaniesTable() {
		if (CompaniesTable == null) {
			companiesTableModel = new SingleSelectableTableModel<Company>(null,
					new String[] { "شماره تماس", "نام شرکت", "انتخاب" },
					UserHome.getInstance().getAllCompanies());
			CompaniesTable = new JTable();
			CompaniesTable.setModel(companiesTableModel);
			CompaniesTable.setPreferredSize(new java.awt.Dimension(495, 32));
		}
		return CompaniesTable;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBorder(BorderFactory.createEmptyBorder(10, 100, 0,
					100));
			jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 126));
			jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
			jScrollPane1.setAlignmentX(RIGHT_ALIGNMENT);
			jScrollPane1.setViewportView(getCompaniesTable());
		}
		return jScrollPane1;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("\u0646\u0627\u0645 \u0634\u0631\u06a9\u062a");
			jLabel4.setBackground(new java.awt.Color(255, 255, 255));
			jLabel4.setBounds(424, 21, 75, 15);
			jLabel4.setAlignmentX(RIGHT_ALIGNMENT);
		}
		return jLabel4;
	}

	private JTextField getCompanyNameField() {
		if (companyNameField == null) {
			companyNameField = new JTextField();
			companyNameField.setBounds(131, 14, 258, 30);
			companyNameField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return companyNameField;
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setPreferredSize(new java.awt.Dimension(600, 37));
			jPanel5.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 60));
			jPanel5.setLayout(null);
			jPanel5.setBackground(new java.awt.Color(255, 255, 255));
			jPanel5.setAlignmentX(RIGHT_ALIGNMENT);
			jPanel5.add(getJLabel6());
			jPanel5.add(getCompanyNameField());
			jPanel5.add(getJLabel4());
			jPanel5.add(getFileSelectionButton());
			jPanel5.add(getRepresentationDocField());
			jPanel5.add(getJLabel5());
			jPanel5.add(getJLabel9());
			jPanel5.add(getJTextField1x());
		}
		return jPanel5;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("\u0633\u0646\u062f \u0645\u0639\u0631\u0641\u06cc \u0646\u0645\u0627\u06cc\u0646\u062f\u0647 \u0634\u0631\u06a9\u062a");
			jLabel5.setBounds(392, 56, 150, 15);
		}
		return jLabel5;
	}

	private JTextField getRepresentationDocField() {
		if (representationDocField == null) {
			representationDocField = new JTextField();
			representationDocField.setBounds(129, 56, 258, 30);
			representationDocField.setEditable(false);
		}
		return representationDocField;
	}

	private JButton getFileSelectionButton() {
		if (fileSelectionButton == null) {
			fileSelectionButton = new JButton();
			fileSelectionButton
					.setText("\u0627\u0646\u062a\u062e\u0627\u0628 \u0641\u0627\u06cc\u0644");
			fileSelectionButton.setBounds(33, 60, 87, 22);
			fileSelectionButton
					.setBackground(new java.awt.Color(255, 255, 255));
			fileSelectionButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ae) {
					representationDocFile = getRepresentationDocFile();
					if (representationDocField != null)
						representationDocField.setText(representationDocFile
								.getAbsolutePath());
				}
			});
		}
		return fileSelectionButton;
	}

	protected File getRepresentationDocFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String st = "";
			try {
				while ((st = br.readLine()) != null) {
					// add file lines to myfile
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return f;
		}

		return null;

	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setPreferredSize(new java.awt.Dimension(108, 15));
			jLabel6.setBounds(89, 22, 108, 15);
		}
		return jLabel6;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("\u0634\u0645\u0627\u0631\u0647 \u062a\u0645\u0627\u0633");
			jLabel7.setBounds(468, 179, 68, 21);
		}
		return jLabel7;
	}

	private JTextField getPhoneNumberField() {
		if (phoneNumberField == null) {
			phoneNumberField = new JTextField();
			phoneNumberField.setBounds(321, 179, 119, 29);
			phoneNumberField.setBorder(regBorder);
			phoneNumberField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return phoneNumberField;
	}

	private JTextField getEmailField() {
		if (emailField == null) {
			emailField = new JTextField();
			emailField.setBorder(regBorder);
			emailField.setBounds(321, 224, 119, 29);
			emailField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return emailField;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("\u0622\u062f\u0631\u0633 \u0627\u0644\u06a9\u062a\u0631\u0648\u0646\u06cc\u06a9\u06cc");
			jLabel8.setBounds(468, 228, 84, 21);
		}
		return jLabel8;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("\u0634\u0645\u0627\u0631\u0647 \u062a\u0645\u0627\u0633 \u0634\u0631\u06a9\u062a");
			jLabel9.setBounds(392, 107, 150, 15);
		}
		return jLabel9;
	}

	private JTextField getJTextField1x() {
		if (companyNumberField == null) {
			companyNumberField = new JTextField();
			companyNumberField.setBounds(129, 107, 258, 30);
		}
		return companyNumberField;
	}
	
	
	protected void registerProfile() {
		int flag = 1;
		int passflag=1;
		int userflag=1;

		String passwd = new String(passwordField.getPassword());
		if (passwd.equals("")) {
			flag = 0;
			passwordField.setBorder(redBorder);
		}else{
			passwordField.setBorder(regBorder);
		}
		String passwdr = new String(passwordRepeatField.getPassword());
		if (passwdr.equals("")) {
			flag = 0;
			passwordRepeatField.setBorder(redBorder);
		}
		else{
			passwordRepeatField.setBorder(regBorder);
		}

		String uname = new String(usernameField.getText());
		if (uname.equals("")) {
			flag = 0;
			usernameField.setBorder(redBorder);
		}
		else
			usernameField.setBorder(regBorder);

		String fname = new String(firstnameField.getText());
		if (fname.equals("")) {
			flag = 0;
			firstnameField.setBorder(redBorder);
		}
		else
			firstnameField.setBorder(regBorder);

		String lname = new String(lastnameField.getText());
		if (lname.equals("")) {
			flag = 0;
			lastnameField.setBorder(redBorder);
		}
		else
			lastnameField.setBorder(regBorder);

		if (flag == 1) {

			if (!passwd.equals(passwdr)) {
				passflag = 0;
				passwordField.setBorder(redBorder);
				passwordRepeatField.setBorder(redBorder);
			}
			else{
				passwordField.setBorder(regBorder);
				passwordRepeatField.setBorder(regBorder);
			}

			byte[] passwdmd5Bytes = null;
			try {
				passwdmd5Bytes = MessageDigest.getInstance("MD5").digest(
						passwd.getBytes());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String passwdmd5 = new String(passwdmd5Bytes);

			if(passflag==1){
				try {
					UserHome.getInstance().createUser(uname, passwdmd5, fname,
							lname);
	
				} catch (ConstraintViolationException e) {
					userflag=0;
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if(flag==0){
			//TODO
			JOptionPane.showMessageDialog(this, "لطفاً فیلدهای ضروری را پر کنید");
		}
		else if(passflag==0){
			JOptionPane.showMessageDialog(this, "تکرار رمز عبور صحیح نمی باشد");
			//TODO
		}
		else if(userflag==0){
			JOptionPane.showMessageDialog(this, "این نام کاربری قبلاً انتخاب شده است");
			//TODO
		}else{
			JOptionPane.showMessageDialog(this, "حساب کاربری شما با موفقیت ثبت شد");
			if(user==null && dmanager==null){
				LoginPage lp=new LoginPage();
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
			}
			ProfileForm.this.dispose();
		}
		

	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("\u0646\u0627\u0645 \u06a9\u0627\u0631\u0628\u0631\u06cc *");
			jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel10.setFont(new java.awt.Font("Tahoma",0,12));
			jLabel10.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			jLabel10.setBounds(195, 131, 80, 21);
		}
		return jLabel10;
	}
	
	private JTextField getUsernameField() {
		if(usernameField == null) {
			usernameField = new JTextField();
			usernameField.setBounds(45, 131, 119, 28);
			usernameField.setBorder(regBorder);
			usernameField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return usernameField;
	}
	
	private JPasswordField getPasswordField() {
		if(passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(45, 179, 119, 28);
			passwordField.setBorder(regBorder);
			passwordField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return passwordField;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("\u0631\u0645\u0632 \u0639\u0628\u0648\u0631*");
			jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel11.setFont(new java.awt.Font("Tahoma",0,12));
			jLabel11.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			jLabel11.setBounds(195, 179, 80, 21);
		}
		return jLabel11;
	}
	
	private JLabel getJLabel12() {
		if(jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("\u062a\u06a9\u0631\u0627\u0631 \u0631\u0645\u0632 *");
			jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel12.setFont(new java.awt.Font("Tahoma",0,12));
			jLabel12.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			jLabel12.setBounds(195, 228, 80, 21);
		}
		return jLabel12;
	}
	
	private JPasswordField getPasswordRepeatField() {
		if(passwordRepeatField == null) {
			passwordRepeatField = new JPasswordField();
			passwordRepeatField.setBounds(45, 228, 119, 28);
			passwordRepeatField.setBorder(regBorder);
			passwordRepeatField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
		return passwordRepeatField;
	}

}
