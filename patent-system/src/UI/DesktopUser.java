package UI;

import invention.Invention;
import invention.Invention.Status;
import invention.InventionFile;
import invention.InventionFileAssesment;
import invention.InventionHome;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


import user.User;

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

public class DesktopUser extends javax.swing.JFrame {


	private User inventor;

	private JTabbedPane jTabbedPane1;
	private JPanel jPanel1;
	private JButton jButton1;
	private JLabel jLabel2;
	private JButton logoutButton;
	private JLabel jLabel1;
	private JButton jButton2;
	private JPanel jPanel4;
	private JPanel jPanel2;
	private JLabel welcomeLabel;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JSeparator jSeparator2;
	private JButton searchButton;
	private JButton specCostButton;
	private JSeparator jSeparator1;
	private JLabel jLabel3;
	private JButton newInventionButton;
	private JTable inventionTable;
	private JScrollPane jScrollPane1;
	private JLabel jLabel12;
	private JButton jButton10;
	private JLabel jLabel11;
	private JLabel jLabel7;
	private JButton showDetailButton;
	private JComboBox jComboBox1;
	ImageIcon image = new javax.swing.ImageIcon("warning-icon.png");
	private SingleSelectableTableModel<InventionFile> inventionTableModel;

	private JPanel jPanel3;

	private JLabel jLabel8;

	private JButton studyButton;

	private JButton cancelStudyButton;

	private JLabel jLabel13;

	private JScrollPane jScrollPane2;

	private SingleSelectableTableModel<InventionFileAssesment> assesmentsTableModel;

	private JTable assesmentsTable;

	private WindowAdapter closeConfirmWindowAdapter;


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DesktopUser inst = new DesktopUser();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public DesktopUser(User inv) {
		super("میر کار کاربر");
		inventor = inv;
		initGUI();
		updateInventionsTable();
	}

	public DesktopUser() {
		super("میر کار کاربر");
		initGUI();
	}

	private void initGUI() {
		try {
			Locale arabic= new Locale("ar", "KW");
			ComponentOrientation arabicOrientation=ComponentOrientation.getOrientation(arabic);
			this.applyComponentOrientation(arabicOrientation);
			
			
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			closeConfirmWindowAdapter = new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					closeConfirm();

				}

			};

			this.addWindowListener(closeConfirmWindowAdapter);

			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14));
				jTabbedPane1.applyComponentOrientation(arabicOrientation);
				{
					jPanel1 = new JPanel();
					jTabbedPane1.addTab("ویرایش اطلاعات کاربری", null, jPanel1,
							null);
					jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14));
					jPanel1.setBackground(new java.awt.Color(255, 255, 255));
					jPanel1.setLayout(null);
					jPanel1.setPreferredSize(new java.awt.Dimension(479, 433));
					{
						welcomeLabel = new JLabel();
						jPanel1.add(welcomeLabel);
						welcomeLabel.setText(inventor.getFirstname() + " "
								+ inventor.getLastname()
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
						jPanel1.add(jButton1);
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
						jPanel1.add(jButton2);
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
						jPanel1.add(jLabel1);
						jLabel1.setBounds(375, 456, 204, 77);
						jLabel1.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("ax.jpg")));
					}
					{
						logoutButton = new JButton();
						jPanel1.add(logoutButton);
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
					jPanel2 = new JPanel();
					jTabbedPane1.addTab("اختراعات کاربر", null, jPanel2, null);
					jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14));
					jPanel2.setBackground(new java.awt.Color(255, 255, 255));
					jPanel2.setLayout(null);
					jPanel2.setPreferredSize(new java.awt.Dimension(479, 433));
					{
						jLabel2 = new JLabel();
						jPanel2.add(jLabel2);
						jLabel2.setText("\u0628\u0627 \u0627\u0646\u062a\u062e\u0627\u0628 \u0627\u062e\u062a\u0631\u0627\u0639 \u0645\u0648\u0631\u062f \u0646\u0638\u0631 \u0645\u06cc \u062a\u0648\u0627\u0646\u06cc\u062f \u0627\u0637\u0644\u0627\u0639\u0627\u062a \u0622\u0646 \u0631\u0627 \u0645\u0634\u0627\u0647\u062f\u0647 \u06a9\u0646\u06cc\u062f.");
						jLabel2.setBounds(142, 47, 425, 32);
						jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
						jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
						jLabel2.setForeground(new java.awt.Color(128, 0, 64));

					}
					{
						showDetailButton = new JButton();
						jPanel2.add(showDetailButton);
						showDetailButton
								.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u06cc \u062c\u0632\u0626\u06cc\u0627\u062a");
						showDetailButton.setBounds(345, 309, 150, 44);
						showDetailButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						showDetailButton.setBackground(new java.awt.Color(255,
								236, 255));
						showDetailButton.setFont(new java.awt.Font("Tahoma", 0,
								14));
						showDetailButton
								.addActionListener(new ActionListener() {

									@Override
									public void actionPerformed(ActionEvent ae) {
										showDetailButtonActionPerformed();
									}
								});

						showDetailButton.setEnabled(false);

					}
					{
						jLabel7 = new JLabel();
						jPanel2.add(jLabel7);
						jLabel7.setBounds(398, 470, 201, 78);
						jLabel7.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("ax.jpg")));
					}
					{
						jScrollPane1 = new JScrollPane();
						jPanel2.add(jScrollPane1);
						jScrollPane1.setBounds(62, 99, 469, 188);
						jScrollPane1
								.setBackground(new java.awt.Color(79, 0, 55));
						jScrollPane1
								.setFont(new java.awt.Font("Tahoma", 0, 14));
						{
							inventionTableModel = new SingleSelectableTableModel<InventionFile>(
									"invention_file",
									InventionFile
											.getColumnNames("invention_file"),
									new ArrayList<InventionFile>());

							inventionTable = new FarsiTable();
								
							inventionTable.setFont(new java.awt.Font("Tahoma",
									0, 14));
							jScrollPane1.setViewportView(inventionTable);
							inventionTable.setModel(inventionTableModel);
							inventionTable.setRowSelectionAllowed(false);
							inventionTable.applyComponentOrientation(arabicOrientation);

							inventionTableModel
									.addTableModelListener(new TableModelListener() {

										@Override
										public void tableChanged(
												TableModelEvent tme) {
											ArrayList<InventionFile> srows = inventionTableModel
													.getSelectedRows();
											showDetailButton.setEnabled(!srows
													.isEmpty());

											InventionFile iFile = inventionTableModel
													.getSelectedRow();
											if (iFile == null) {
												specCostButton
														.setEnabled(false);
											} else if (iFile.getInvention() == null) {
												specCostButton
														.setEnabled(false);
											} else if (iFile.getInvention()
													.getStatus() != Status.accepted) {
												specCostButton
														.setEnabled(false);
											} else {
												specCostButton.setEnabled(true);
											}

										}
									});

						}
					}
					{
						newInventionButton = new JButton();
						jPanel2.add(newInventionButton);
						newInventionButton
								.setText("\u062b\u0628\u062a \u0627\u062e\u062a\u0631\u0627\u0639 \u062c\u062f\u06cc\u062f");
						newInventionButton.setBounds(328, 420, 150, 44);
						newInventionButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						newInventionButton.setBackground(new java.awt.Color(
								255, 236, 255));
						newInventionButton.setFont(new java.awt.Font("Tahoma",
								0, 14));
						newInventionButton
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										newInventionButtonActionPerformed();
									}
								});

					}
					{
						jLabel3 = new JLabel();
						jPanel2.add(jLabel3);
						jLabel3.setText("\u062b\u0628\u062a \u0627\u062e\u062a\u0631\u0627\u0639 \u062c\u062f\u06cc\u062f");
						jLabel3.setBounds(446, 365, 115, 35);
						jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
						jLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
						jLabel3.setForeground(new java.awt.Color(128, 0, 64));

					}
					{
						jSeparator1 = new JSeparator();
						jPanel2.add(jSeparator1);
						jSeparator1.setBounds(34, 384, 394, 16);
						jSeparator1
								.setBackground(new java.awt.Color(128, 0, 64));
					}
					{
						specCostButton = new JButton();
						jPanel2.add(specCostButton);
						specCostButton
								.setText("\u062a\u0639\u06cc\u06cc\u0646 \u0642\u06cc\u0645\u062a ");
						specCostButton.setBounds(98, 309, 150, 44);
						specCostButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						specCostButton.setBackground(new java.awt.Color(255,
								236, 255));
						specCostButton.setFont(new java.awt.Font("Tahoma", 0,
								14));
						specCostButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent ae) {
								specCostButtonActionPerformed();
							}
						});

						specCostButton.setEnabled(false);

					}
				}
				{
					jPanel4 = new JPanel();
					jTabbedPane1.addTab("جستجو و گزارش", null, jPanel4, null);
					jPanel4.setFont(new java.awt.Font("Tahoma", 0, 14));
					jPanel4.setBackground(new java.awt.Color(255, 255, 255));
					jPanel4.setLayout(null);
					jPanel4.setPreferredSize(new java.awt.Dimension(479, 433));
					{
						jLabel11 = new JLabel();
						jPanel4.add(jLabel11);
						jLabel11.setText("\u0627\u0646\u062a\u062e\u0627\u0628 \u062d\u0648\u0632\u0647");
						jLabel11.setBounds(439, 79, 105, 31);
						jLabel11.setBorder(BorderFactory.createEmptyBorder(0,
								0, 0, 0));
						jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12));
						jLabel11.setHorizontalAlignment(SwingConstants.CENTER);

					}
					{
						jButton10 = new JButton();
						jPanel4.add(jButton10);
						jButton10
								.setText("\u0645\u0634\u0627\u0647\u062f\u0647");
						jButton10.setBounds(115, 130, 150, 44);
						jButton10.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						jButton10.setBackground(new java.awt.Color(255, 236,
								255));
						jButton10.setFont(new java.awt.Font("Tahoma", 0, 14));

					}
					{
						jComboBox1 = new JComboBox();
						jPanel4.add(jComboBox1);
						jComboBox1
								.setModel(new javax.swing.DefaultComboBoxModel(
										new String[] { "-------", "کامپیوتر",
												"برق" }));
						jComboBox1.setCursor(new java.awt.Cursor(
								java.awt.Cursor.DEFAULT_CURSOR));
						jComboBox1.setBounds(233, 81, 167, 26);
						jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12));
						jComboBox1.setBackground(new java.awt.Color(255, 232,
								243));
					}
					{
						jLabel12 = new JLabel();
						jPanel4.add(jLabel12);
						jLabel12.setText("ax3");
						jLabel12.setBounds(382, 452, 196, 81);
						jLabel12.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("ax.jpg")));
					}
					{
						searchButton = new JButton();
						jPanel4.add(searchButton);
						searchButton
								.setText("\u062c\u0633\u062a\u062c\u0648 \u062f\u0631 \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a");
						searchButton.setBounds(120, 277, 150, 44);
						searchButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						searchButton.setBackground(new java.awt.Color(255, 236,
								255));
						searchButton
								.setFont(new java.awt.Font("Tahoma", 0, 14));
						searchButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								searchButtonActionPerformed();

							}
						});

					}
					{
						jSeparator2 = new JSeparator();
						jPanel4.add(jSeparator2);
						jSeparator2.setBounds(138, 219, 369, 7);
					}
					{
						jLabel4 = new JLabel();
						jPanel4.add(jLabel4);
						jLabel4.setText("\u062c\u0633\u062a\u062c\u0648 \u062f\u0631 \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a");
						jLabel4.setBounds(375, 246, 178, 31);
						jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
						jLabel4.setHorizontalAlignment(SwingConstants.CENTER);

					}
					{
						jLabel5 = new JLabel();
						jPanel4.add(jLabel5);
						jLabel5.setText("\u06af\u0632\u0627\u0631\u0634 \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a \u0628\u0647 \u062a\u0641\u06a9\u06cc\u06a9 \u062d\u0648\u0632\u0647");
						jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12));
						jLabel5.setBounds(375, 36, 178, 31);
					}
				}

				if (inventor.isExpert()) {
					{
						jPanel3 = new JPanel();
						jTabbedPane1.addTab("اختراعات نیازمند بررسی", null,
								jPanel3, null);
						jPanel3.setBackground(new java.awt.Color(255, 255, 255));
						jPanel3.setLayout(null);
						jPanel3.setPreferredSize(new java.awt.Dimension(479,
								433));
						{
							jLabel8 = new JLabel();
							jPanel3.add(jLabel8);
							jLabel8.setText("\u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a \u0646\u06cc\u0627\u0632\u0645\u0646\u062f \u0628\u0631\u0631\u0633\u06cc");
							jLabel8.setBounds(366, 57, 168, 22);
							jLabel8.setBorder(BorderFactory.createEmptyBorder(
									0, 0, 0, 0));
							jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13));
							jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
							jLabel8.setForeground(new java.awt.Color(128, 0, 64));

						}
						{
							studyButton = new JButton();
							jPanel3.add(studyButton);
							studyButton
									.setText("\u0628\u0631\u0631\u0633\u06cc \u067e\u0631\u0648\u0646\u062f\u0647");
							studyButton.setBounds(339, 402, 150, 44);
							studyButton.setBorder(BorderFactory
									.createEtchedBorder(BevelBorder.LOWERED));
							studyButton.setBackground(new java.awt.Color(255,
									236, 255));
							studyButton.setFont(new java.awt.Font("Tahoma", 0,
									14));
							studyButton.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									studyButtonActionPerformed(e);
								}
							});
							studyButton.setEnabled(false);

						}
						{
							cancelStudyButton = new JButton();
							jPanel3.add(cancelStudyButton);
							cancelStudyButton
									.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
							cancelStudyButton.setBounds(98, 402, 150, 44);
							cancelStudyButton.setBorder(BorderFactory
									.createEtchedBorder(BevelBorder.LOWERED));
							cancelStudyButton.setBackground(new java.awt.Color(
									255, 236, 255));
							cancelStudyButton.setFont(new java.awt.Font(
									"Tahoma", 0, 14));
						}
						{
							jLabel13 = new JLabel();
							jPanel3.add(jLabel13);
							jLabel13.setBounds(378, 458, 202, 75);
							jLabel13.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource("ax.jpg")));
						}
						{
							jScrollPane2 = new JScrollPane();
							jPanel3.add(jScrollPane2);
							jScrollPane2.setBackground(new java.awt.Color(79,
									0, 55));
							jScrollPane2.setFont(new java.awt.Font("Tahoma", 0,
									14));
							jScrollPane2.setBounds(60, 111, 469, 230);
							{
								ArrayList<InventionFileAssesment> pendingAssesments = new ArrayList<InventionFileAssesment>();

								for (InventionFileAssesment ifa : inventor
										.getInventionFileAssesments()) {
									if (ifa.getInvention().getStatus() == Status.pending && ifa.getInvention().getCurrentAssesment().getId()==ifa.getId())
										pendingAssesments.add(ifa);
								}
								assesmentsTableModel = new SingleSelectableTableModel<InventionFileAssesment>(
										"invention_file_assesment",
										InventionFileAssesment.getColumnNames(),
										pendingAssesments);

								assesmentsTableModel
										.addTableModelListener(new TableModelListener() {

											@Override
											public void tableChanged(
													TableModelEvent arg0) {
												studyButton
														.setEnabled(assesmentsTableModel
																.isSelected());

											}
										});

								assesmentsTable = new FarsiTable();
								jScrollPane2.setViewportView(assesmentsTable);
								assesmentsTable.setModel(assesmentsTableModel);
								assesmentsTable.setFont(new java.awt.Font("Tahoma", 0,
										14));
							}
						}
					}
				}
			}

			pack();
			setSize(600, 600);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
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
			DesktopUser.this.dispose();
			LoginPage l = new LoginPage();
			l.setLocationRelativeTo(null);
			l.setVisible(true);
		}

	}

	protected void studyButtonActionPerformed(ActionEvent e) {
		InventionFileAssesment ifa = assesmentsTableModel.getSelectedRow();
		StudyForm sf = new StudyForm(this, ifa);
		sf.setLocationRelativeTo(this);
		sf.setVisible(true);

	}

	protected void searchButtonActionPerformed() {
		UI.SearchForm se = new UI.SearchForm(this.inventor);
		se.setLocationRelativeTo(null);
		se.setVisible(true);
	}

	protected void specCostButtonActionPerformed() {
		Invention inv = inventionTableModel.getSelectedRow().getInvention();
		String message;
		Font font;
		font = new Font("tahoma", 0, 12);
		UIManager.put("OptionPane.messageFont", font);
		message = "قیمت را وارد کنید (ریال)";
		String title = "پیغام";
		boolean exit = false;
		while (!exit) {
			String priceStr = JOptionPane.showInputDialog(this, message, title,
					JOptionPane.OK_CANCEL_OPTION);
			exit = true;
			Integer price = null;
			if (priceStr != null) {
				try {
					price = Integer.parseInt(priceStr);
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this,
							"قیمت به اشتباه وارد شده است");
					exit = false;
				}

				if (exit == true) {
					inv.setPrice(price);
					InventionHome.getInstance().updateInvention(inv);
				}
			}
		}

	}

	protected void showDetailButtonActionPerformed() {
		InventionFile ifile = inventionTableModel.getSelectedRow();

		InventionFileChangeSession session = new InventionFileChangeSession(
				this, ifile, this.inventor);
		session.startDialog();
	}

	protected void newInventionButtonActionPerformed() {
		NewInventionSession nis = new NewInventionSession(this, this.inventor);
		nis.startDialog();
	}

	protected void Click_Change_Password(MouseEvent evt) {
		UI.ChangePassWord CP = new UI.ChangePassWord(inventor);
		CP.setLocationRelativeTo(null);
		CP.setVisible(true);
	}

	protected void Click_Profile_change(MouseEvent evt) {
		UI.ProfileForm CCP = new UI.ProfileForm(inventor);
		CCP.setLocationRelativeTo(null);
		CCP.setVisible(true);
	}

	public void updateInventionsTable() {
		inventionTableModel.setData(inventor.getCollaboratedInventionFiles());
	}

	public void updateAssesmentsTable() {
		ArrayList<InventionFileAssesment> pendingAssesments = new ArrayList<InventionFileAssesment>();

		for (InventionFileAssesment ifa : inventor.getInventionFileAssesments()) {
			if (ifa.getInvention().getStatus() == Status.pending)
				pendingAssesments.add(ifa);
		}

		assesmentsTableModel.setData(pendingAssesments);

	}

}
