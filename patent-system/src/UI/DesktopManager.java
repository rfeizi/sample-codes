package UI;

import invention.Invention;
import invention.InventionFile;
import invention.InventionHome;
import invention.Invention.Status;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
//import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.GroupLayout.Alignment;
//import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import expertise.ExpertiseHome;
import expertise.NewExpertiseDomainRequest;

import user.Manager;
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
public class DesktopManager extends javax.swing.JFrame {

	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane2;
	private JLabel jLabel13;
	private JButton authorizeButton;
	private JButton viewInventionButton;
	private JLabel jLabel8;
	private JPanel jPanel4;
	private JButton assignExpertiseButton;
	private JTable usersTable;
	private SingleSelectableTableModel<User> usersTableModel;
	private JScrollPane usersScrollPane;
	private JLabel jLabel1;
	// private JMenuItem jMenuItem1;
	// private ButtonGroup buttonGroup1;
	private JPanel jPanel2;

	ImageIcon images = new javax.swing.ImageIcon("ax.jpg");
	ImageIcon image = new javax.swing.ImageIcon("warning-icon.png");
	private Manager manager;
	private JButton rejectNewDomainButton;
	private JPanel jPanel6;
	private FarsiTable newDomainsTable;
	private JScrollPane jScrollPane1;
	private JLabel jLabel4;
	private JButton registerNewDomainButton;
	private JButton viewNewDomainInventionButton;
	private JLabel jLabel3;
	private JPanel jPanel5;
	private JButton unauthorizeButton;
	private FarsiTable authorizingInventionsTable;
	private JButton addNewUserButton;
	private JButton removeUserButton;
	private JPanel jPanel3;
	private JLabel welcomeLabel;
	private JButton jButton1;
	private JButton jButton2;
	private JButton logoutButton;
	private SingleSelectableTableModel<Invention> authorizingInventionsTableModel;
	private SingleSelectableTableModel<NewExpertiseDomainRequest> newDomainsTableModel;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DesktopManager inst = new DesktopManager();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public DesktopManager(Manager manager) {
		super("میز کار مدیر");
		this.manager = manager;
		initGUI();
		updateAuthorizingInventionsTable();
		updateNewDomainsTable();

	}

	public DesktopManager() {
		super("میز کار مدیر");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {

					closeConfirm();
				}
			});

			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			{
				jTabbedPane1 = new JTabbedPane();
				jTabbedPane1
						.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14));
				{
					jPanel3 = new JPanel();
					jTabbedPane1.addTab("ویرایش اطلاعات کاربری", null, jPanel3,
							null);
					jPanel3.setFont(new java.awt.Font("Tahoma", 0, 14));
					jPanel3.setBackground(new java.awt.Color(255, 255, 255));
					jPanel3.setLayout(null);
					jPanel3.setPreferredSize(new java.awt.Dimension(479, 433));
					{
						welcomeLabel = new JLabel();
						jPanel3.add(welcomeLabel);
						welcomeLabel.setText(manager.getFullName()
								+ "! به سامانه ثبت اختراع خوش آمدید.");
						welcomeLabel.setBounds(146, 112, 415, 34);
						welcomeLabel
								.setFont(new java.awt.Font("Tahoma", 1, 14));
						welcomeLabel.setBorder(BorderFactory.createEmptyBorder(
								0, 0, 0, 0));
						welcomeLabel
								.setHorizontalAlignment(SwingConstants.RIGHT);
						welcomeLabel.setForeground(new java.awt.Color(128, 0,
								64));

					}
					{
						jButton1 = new JButton();
						jPanel3.add(jButton1);
						jButton1.setText("\u062a\u063a\u06cc\u06cc\u0631 \u0631\u0645\u0632 \u0639\u0628\u0648\u0631");
						jButton1.setBounds(375, 252, 150, 44);
						jButton1.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						jButton1.setBackground(new java.awt.Color(255, 236, 255));
						jButton1.setFont(new java.awt.Font("Tahoma", 0, 14));
						jButton1.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent evt) {
								Click_Change_Password(evt);
							}
						});

					}
					{
						jButton2 = new JButton();
						jPanel3.add(jButton2);
						jButton2.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634 \u0645\u0634\u062e\u0635\u0627\u062a");
						jButton2.setBounds(375, 328, 150, 44);
						jButton2.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						jButton2.setBackground(new java.awt.Color(255, 236, 255));
						jButton2.setFont(new java.awt.Font("Tahoma", 0, 14));
						jButton2.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent evt) {
								Click_Profile_change(evt);
							}
						});

					}
					{
						jLabel1 = new JLabel();
						jPanel3.add(jLabel1);
						jLabel1.setBounds(375, 456, 204, 77);
						jLabel1.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("ax.jpg")));
					}
					{
						logoutButton = new JButton();
						jPanel3.add(logoutButton);
						logoutButton.setText("\u062e\u0631\u0648\u062c");
						logoutButton.setBounds(12, 56, 87, 34);
						logoutButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						logoutButton.setBackground(new java.awt.Color(255, 236,
								255));
						logoutButton
								.setFont(new java.awt.Font("Tahoma", 0, 14));
						logoutButton.addMouseListener(new MouseAdapter() {
							public void mousePressed(MouseEvent evt) {
								closeConfirm();
							}
						});
					}
				}
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("مدیریت کاربرها", null, jPanel1, null);
					jPanel1.setBackground(new java.awt.Color(255, 255, 255));
					jPanel1.setLayout(null);
					jPanel1.add(getUsersScrollPane());
					jPanel1.add(getAssignExpertiseButton());
					jPanel1.add(getJButton3());
					jPanel1.add(getJButton4());
					jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14));
					jTabbedPane1
							.setBackground(new java.awt.Color(255, 255, 255));

				}
				{
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("اجازه ثبت بیش از 3 احتراع", null,
							jPanel2, null);
					jTabbedPane1.addTab("ثبت درخواست حوزه های جدید", null,
							getJPanel5(), null);
					jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14));
					jPanel2.setBackground(new java.awt.Color(255, 255, 255));
					jPanel2.setLayout(null);
					jPanel2.setPreferredSize(new java.awt.Dimension(579, 496));
					jPanel2.add(getJLabel8());
					jPanel2.add(getViewInventionButton());
					jPanel2.add(getAuthorizeButton());
					jPanel2.add(getJLabel13());
					jPanel2.add(getJScrollPane2());
					jPanel2.add(getJPanel4(), "اختراعات نیازمند بررسی");
					jPanel2.add(getJButton3x());
					jTabbedPane1
							.setBackground(new java.awt.Color(255, 255, 255));
					jTabbedPane1.setPreferredSize(new java.awt.Dimension(584,
							523));

				}
			}
			pack();
			this.setSize(600, 560);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(385, 451, 194, 82);
			jLabel1.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("ax.jpg")));
		}
		return jLabel1;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("jLabel2");
			jLabel2.setBounds(384, 456, 195, 77);
			jLabel2.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("ax.jpg")));
		}
		return jLabel2;
	}

	private JScrollPane getUsersScrollPane() {
		if (usersScrollPane == null) {
			usersScrollPane = new JScrollPane();
			usersScrollPane.setBounds(56, 27, 458, 215);
			usersScrollPane.setViewportView(getUsersTable());
		}
		return usersScrollPane;
	}

	private void updateUsersTable() {
		List<User> allUsers = UserHome.getInstance().getAllUsers();
		List<User> nonManagerUsers = new ArrayList<User>();
		for (User u : allUsers) {
			if (!(u instanceof Manager))
				nonManagerUsers.add(u);
		}
		usersTableModel.setData(nonManagerUsers);
	}

	private JTable getUsersTable() {

		if (usersTable == null) {

			usersTableModel = new SingleSelectableTableModel<User>("user",
					User.getColumnNames("user"), new ArrayList<User>());
			updateUsersTable();
			usersTableModel.addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent tme) {
					assignExpertiseButton.setEnabled(usersTableModel
							.isSelected());
					removeUserButton.setEnabled(usersTableModel.isSelected());

				}
			});
			usersTable = new FarsiTable();
			usersTable.setModel(usersTableModel);
		}
		return usersTable;
	}

	private JButton getAssignExpertiseButton() {
		if (assignExpertiseButton == null) {
			assignExpertiseButton = new JButton();
			assignExpertiseButton
					.setText("\u062a\u062e\u0635\u06cc\u0635 \u0646\u0642\u0634 \u06a9\u0627\u0631\u0634\u0646\u0627\u0633\u06cc");
			assignExpertiseButton.setHorizontalAlignment(SwingConstants.CENTER);
			assignExpertiseButton.setBackground(new java.awt.Color(255, 236,
					255));
			assignExpertiseButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			assignExpertiseButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			assignExpertiseButton.setBounds(68, 290, 157, 38);

			assignExpertiseButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					User selectedUser = (User) usersTableModel.getSelectedRow();
					assignExpertise(selectedUser);
				}
			});
			assignExpertiseButton.setEnabled(false);
		}
		return assignExpertiseButton;
	}

	protected void assignExpertise(User selectedUser) {
		AssignExpertiseForm aef = new AssignExpertiseForm(selectedUser);
		aef.setVisible(true);
		aef.setLocationRelativeTo(this);

	}

	protected void closeConfirm() {
		String warning;
		Font font;
		font = new Font("tahoma", 0, 12);
		UIManager.put("OptionPane.messageFont", font);
		warning = "آیا برای خروج از سامانه مطمئن هستید؟";
		String title = "هشدار";
		Object[] options = { "خیر", "بلی" };
		int confirmed = JOptionPane.showOptionDialog(this, warning, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				options, options[0]);

		if (confirmed == 1) {
			DesktopManager.this.dispose();
			LoginPage l = new LoginPage();
			l.setLocationRelativeTo(null);
			l.setVisible(true);
		}

	}

	protected void Click_Change_Password(MouseEvent evt) {
		UI.ChangePassWord CP = new UI.ChangePassWord(manager);
		CP.setLocationRelativeTo(null);
		CP.setVisible(true);
	}

	protected void Click_Profile_change(MouseEvent evt) {
		UI.ProfileForm CCP = new UI.ProfileForm(manager);
		CCP.setLocationRelativeTo(null);
		CCP.setVisible(true);
	}

	private JButton getJButton3() {
		if (removeUserButton == null) {
			removeUserButton = new JButton();
			removeUserButton.setEnabled(false);
			removeUserButton
					.setText("\u062d\u0630\u0641 \u06a9\u0627\u0631\u0628\u0631");
			removeUserButton.setHorizontalAlignment(SwingConstants.CENTER);
			removeUserButton.setBackground(new java.awt.Color(255, 236, 255));
			removeUserButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			removeUserButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			removeUserButton.setBounds(251, 290, 113, 38);
			removeUserButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeUserButtonActionPerformed();

				}
			});
		}
		return removeUserButton;
	}

	protected void removeUserButtonActionPerformed() {
		User selectedUser = (User) usersTableModel.getSelectedRow();
		String warning;
		Font font;
		font = new Font("tahoma", 0, 12);
		UIManager.put("OptionPane.messageFont", font);
		warning = "آیا از حذف این کاربر اطمینان دارید؟";
		String title = "هشدار";
		Object[] options = { "خیر", "بلی" };
		int confirmed = JOptionPane.showOptionDialog(this, warning, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				options, options[0]);

		if (confirmed == 1) {
			UserHome.getInstance().removeUser(selectedUser);
			JOptionPane.showMessageDialog(null, "این کاربر با موفقیت حذف شد.");
			updateUsersTable();
		}

	}

	private JButton getJButton4() {
		if (addNewUserButton == null) {
			addNewUserButton = new JButton();
			addNewUserButton
					.setText("\u0627\u06cc\u062c\u0627\u062f \u06a9\u0627\u0631\u0628\u0631 \u062c\u062f\u06cc\u062f");
			addNewUserButton.setHorizontalAlignment(SwingConstants.CENTER);
			addNewUserButton.setBackground(new java.awt.Color(255, 236, 255));
			addNewUserButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			addNewUserButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			addNewUserButton.setBounds(393, 290, 105, 38);
			addNewUserButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProfileForm pf = new ProfileForm(DesktopManager.this);
					pf.setLocationRelativeTo(DesktopManager.this);
					pf.setVisible(true);
				}
			});
		}
		return addNewUserButton;
	}

	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setBackground(new java.awt.Color(255, 255, 255));
			jPanel4.setPreferredSize(new java.awt.Dimension(479, 433));
			jPanel4.setLayout(null);
		}
		return jPanel4;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("\u062f\u0631\u062e\u0648\u0627\u0633\u062a \u0647\u0627\u06cc \u062b\u0628\u062a \u0627\u062e\u062a\u0631\u0627\u0639");
			jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13));
			jLabel8.setForeground(new java.awt.Color(128, 0, 64));
			jLabel8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel8.setBounds(391, 21, 168, 22);
		}
		return jLabel8;
	}

	private JButton getViewInventionButton() {
		if (viewInventionButton == null) {
			viewInventionButton = new JButton();
			viewInventionButton.setEnabled(false);
			viewInventionButton
					.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u067e\u0631\u0648\u0646\u062f\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
			viewInventionButton
					.setBackground(new java.awt.Color(255, 236, 255));
			viewInventionButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			viewInventionButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			viewInventionButton.setBounds(365, 351, 150, 44);
			viewInventionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewInventionButtonActionPerformed();
				}
			});
		}
		return viewInventionButton;
	}

	protected void viewInventionButtonActionPerformed() {
		Invention inv = authorizingInventionsTableModel.getSelectedRow();
		InventionForm iform = new InventionForm(inv.getInventionFile());
		iform.setLocationRelativeTo(this);
		iform.setVisible(true);
	}

	private JButton getAuthorizeButton() {
		if (authorizeButton == null) {
			authorizeButton = new JButton();
			authorizeButton
					.setText("\u0627\u0639\u0637\u0627\u06cc \u0627\u062c\u0627\u0632\u0647 \u062b\u0628\u062a \u0627\u062e\u062a\u0631\u0627\u0639");
			authorizeButton.setBackground(new java.awt.Color(255, 236, 255));
			authorizeButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			authorizeButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			authorizeButton.setBounds(203, 351, 150, 44);
			authorizeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					authorizeButtonActionPerformed();

				}
			});
		}
		return authorizeButton;
	}

	protected void authorizeButtonActionPerformed() {
		String warning;
		Font font;
		font = new Font("tahoma", 0, 12);
		UIManager.put("OptionPane.messageFont", font);
		warning = "آیا برای اعطای اجازه ثبت به این اختراع اطمینان دارید؟";
		String title = "هشدار";
		Object[] options = { "خیر", "بلی" };
		int confirmed = JOptionPane.showOptionDialog(this, warning, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				options, options[0]);
		if (confirmed == 1) {
			Invention invention = authorizingInventionsTableModel
					.getSelectedRow();
			invention.setStatus(Status.pending);
			InventionHome.getInstance().updateInvention(invention);
			if (invention.getInventionFile().getNewExpertiseDomainRequest() == null) {
				Set<User> experts = invention.getInventionFile()
						.getExpertiseDomain().getExperts();
				if (!experts.isEmpty()) {
					User expert = (User) experts.toArray()[0];
					InventionHome.getInstance().saveInventionFileAssesment(
							invention, expert);
				} else {
					// nothing
				}
			}

			updateAuthorizingInventionsTable();
		}

	}

	private JLabel getJLabel13() {
		if (jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("ax.jpg")));
			jLabel13.setBounds(403, 421, 202, 75);
		}
		return jLabel13;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBackground(new java.awt.Color(79, 0, 55));
			jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14));
			jScrollPane2.setBounds(49, 74, 466, 236);
			jScrollPane2.setViewportView(getAuthorizingInventionsTable());
		}
		return jScrollPane2;
	}

	private JTable getAuthorizingInventionsTable() {
		if (authorizingInventionsTable == null) {
			authorizingInventionsTableModel = new SingleSelectableTableModel<Invention>(
					"authorize", Invention.getColumnNames("authorize"),
					new ArrayList<Invention>());

			authorizingInventionsTableModel
					.addTableModelListener(new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent arg0) {
							viewInventionButton
									.setEnabled(authorizingInventionsTableModel
											.isSelected());
							authorizeButton
									.setEnabled(authorizingInventionsTableModel
											.isSelected());
							unauthorizeButton
									.setEnabled(authorizingInventionsTableModel
											.isSelected());
						}
					});
			

			authorizingInventionsTable = new FarsiTable();
			authorizingInventionsTable
					.setModel(authorizingInventionsTableModel);
			authorizingInventionsTable.setFont(new java.awt.Font("Tahoma", 0,
					14));
		}
		return authorizingInventionsTable;
	}

	private void updateAuthorizingInventionsTable() {
		ArrayList<Invention> authorizingInventions = InventionHome
				.getInstance().getAuthorizingInventions();
		authorizingInventionsTableModel.setData(authorizingInventions);

	}

	private JButton getJButton3x() {
		if (unauthorizeButton == null) {
			unauthorizeButton = new JButton();
			unauthorizeButton
					.setText("\u0631\u062f \u062f\u0631\u062e\u0648\u0627\u0633\u062a \u062b\u0628\u062a \u0627\u062e\u062a\u0631\u0627\u0639");
			unauthorizeButton.setBackground(new java.awt.Color(255, 236, 255));
			unauthorizeButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			unauthorizeButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			unauthorizeButton.setBounds(37, 351, 150, 44);
			unauthorizeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					unauthorizeButtonActionPerformed(evt);
				}
			});
		}
		return unauthorizeButton;
	}

	private void unauthorizeButtonActionPerformed(ActionEvent evt) {
		String warning;
		Font font;
		font = new Font("tahoma", 0, 12);
		UIManager.put("OptionPane.messageFont", font);
		warning = "آیا برای رد این درخواست ثبت اختراع اطمینان دارید؟";
		String title = "هشدار";
		Object[] options = { "خیر", "بلی" };
		int confirmed = JOptionPane.showOptionDialog(this, warning, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, image,
				options, options[0]);
		if (confirmed == 1) {
			Invention invention = authorizingInventionsTableModel
					.getSelectedRow();
			invention.setStatus(Status.unauthorized);
			InventionHome.getInstance().updateInvention(invention);

			updateAuthorizingInventionsTable();
		}
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setBackground(new java.awt.Color(255, 255, 255));
			jPanel5.setFont(new java.awt.Font("Tahoma", 0, 14));
			jPanel5.setPreferredSize(new java.awt.Dimension(579, 496));
			jPanel5.setLayout(null);
			jPanel5.add(getJLabel3());
			jPanel5.add(getJButton3xx());
			jPanel5.add(getJButton4x());
			jPanel5.add(getJLabel4());
			jPanel5.add(getJScrollPane1());
			jPanel5.add(getJPanel6(), "اختراعات نیازمند بررسی");
			jPanel5.add(getJButton5());
		}
		return jPanel5;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("\u062f\u0631\u062e\u0648\u0627\u0633\u062a \u0647\u0627\u06cc \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f");
			jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13));
			jLabel3.setForeground(new java.awt.Color(128, 0, 64));
			jLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel3.setBounds(391, 21, 168, 22);
		}
		return jLabel3;
	}

	private JButton getJButton3xx() {
		if (viewNewDomainInventionButton == null) {
			viewNewDomainInventionButton = new JButton();
			viewNewDomainInventionButton.setEnabled(false);
			viewNewDomainInventionButton
					.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u067e\u0631\u0648\u0646\u062f\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
			viewNewDomainInventionButton.setBackground(new java.awt.Color(255, 236,
					255));
			viewNewDomainInventionButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			viewNewDomainInventionButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			viewNewDomainInventionButton.setBounds(365, 351, 150, 44);
			viewNewDomainInventionButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					viewNewDomainInventionButtonActionPerformed(evt);
				}
			});
		}
		return viewNewDomainInventionButton;
	}

	private void viewNewDomainInventionButtonActionPerformed(ActionEvent evt) {
		NewExpertiseDomainRequest nedr=newDomainsTableModel.getSelectedRow();
		InventionForm iform = new InventionForm(nedr.getInventionFile());
		iform.setLocationRelativeTo(this);
		iform.setVisible(true);
	}

	private JButton getJButton4x() {
		if (registerNewDomainButton == null) {
			registerNewDomainButton = new JButton();
			registerNewDomainButton.setBackground(new java.awt.Color(255, 236,
					255));
			registerNewDomainButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			registerNewDomainButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			registerNewDomainButton.setBounds(203, 351, 150, 44);
			registerNewDomainButton
					.setText("\u062b\u0628\u062a \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f");
			registerNewDomainButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					registerNewDomainButtonActionPerformed(evt);
				}
			});
		}
		return registerNewDomainButton;
	}

	private void registerNewDomainButtonActionPerformed(ActionEvent evt) {
		ExpertiseHome.getInstance().AcceptNewDomain(
				newDomainsTableModel.getSelectedRow());
		updateNewDomainsTable();
	}

	private void updateNewDomainsTable() {
		ArrayList<NewExpertiseDomainRequest> newDomains=new ArrayList<NewExpertiseDomainRequest>();
		List<NewExpertiseDomainRequest> allNewDomains=ExpertiseHome.getInstance().getAllNewDomains();
		for(NewExpertiseDomainRequest nedr: allNewDomains)
			if(nedr.getStatus()==NewExpertiseDomainRequest.Status.pending)
				newDomains.add(nedr);
		
		newDomainsTableModel.setData(newDomains);
		
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setIcon(new ImageIcon(getClass().getClassLoader()
					.getResource("ax.jpg")));
			jLabel4.setBounds(403, 421, 202, 75);
		}
		return jLabel4;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBackground(new java.awt.Color(79, 0, 55));
			jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14));
			jScrollPane1.setBounds(49, 74, 466, 236);
			jScrollPane1.setViewportView(getNewDomainsTable());
		}
		return jScrollPane1;
	}

	private FarsiTable getNewDomainsTable() {
		if (newDomainsTable == null) {
			newDomainsTableModel = new SingleSelectableTableModel<NewExpertiseDomainRequest>(
					"new_domain",
					NewExpertiseDomainRequest.getColumnNames("new_domain"),
					new ArrayList<NewExpertiseDomainRequest>());
			newDomainsTableModel
					.addTableModelListener(new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent arg0) {
							viewNewDomainInventionButton.setEnabled(newDomainsTableModel
									.isSelected());
							registerNewDomainButton.setEnabled(newDomainsTableModel
									.isSelected());
							rejectNewDomainButton.setEnabled(newDomainsTableModel
									.isSelected());
						}
					});
			newDomainsTable = new FarsiTable();
			newDomainsTable.setModel(newDomainsTableModel);
			newDomainsTable.setFont(new java.awt.Font("Tahoma", 0, 14));
		}
		return newDomainsTable;
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setBackground(new java.awt.Color(255, 255, 255));
			jPanel6.setPreferredSize(new java.awt.Dimension(479, 433));
			jPanel6.setLayout(null);
		}
		return jPanel6;
	}

	private JButton getJButton5() {
		if (rejectNewDomainButton == null) {
			rejectNewDomainButton = new JButton();
			rejectNewDomainButton
					.setText(" \u0631\u062f \u062f\u0631\u062e\u0648\u0627\u0633\u062a \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f");
			rejectNewDomainButton.setBackground(new java.awt.Color(255, 236,
					255));
			rejectNewDomainButton.setFont(new java.awt.Font("Tahoma", 0, 14));
			rejectNewDomainButton.setBorder(BorderFactory
					.createEtchedBorder(BevelBorder.LOWERED));
			rejectNewDomainButton.setBounds(37, 351, 150, 44);
			rejectNewDomainButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					rejectNewDomainButtonActionPerformed(evt);
				}
			});
		}
		return rejectNewDomainButton;
	}

	private void rejectNewDomainButtonActionPerformed(ActionEvent evt) {
		ExpertiseHome.getInstance().RejectNewDomain(
				newDomainsTableModel.getSelectedRow());
		updateNewDomainsTable();
	}

}
