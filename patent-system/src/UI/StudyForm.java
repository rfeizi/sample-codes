package UI;

import invention.InventionFileAssesment;
import invention.InventionHome;
import invention.Invention.Status;
import user.User;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

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
public class StudyForm extends JFrame {


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StudyForm inst = new StudyForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	private JPanel jPanel3;
	private JLabel jLabel14;
	private JButton cancelButton;
	private JPanel jPanel1;
	private JButton viewInventionButton;
	private JLabel originalityLabel;
	private ButtonGroup abstractCompGroup;
	private ButtonGroup docCompGroup;
	private JLabel jLabel3;
	private JCheckBox indictmentYesBox;
	private JCheckBox indictmentNoBox;
	private ButtonGroup representationGroup;
	private ButtonGroup indictmentGroup;
	private JLabel jLabel2;
	private JCheckBox abstractCompYesBox;
	private JCheckBox abstractCompNoBox;
	private JLabel jLabel1;
	private JCheckBox docCompNoBox;
	private JCheckBox representationYesBox;
	private JLabel jLabel4;
	private JCheckBox representationNoBox;
	private JCheckBox docCompYesBox;
	private JCheckBox originalityNoBox;
	private JCheckBox originalityYesBox;
	private ButtonGroup originalityGroup;
	private JButton sendButton;
	private JButton saveButton;

	private InventionFileAssesment ifa;
	private DesktopUser desktopUser;
	private String type;
	private InventionFileChangeSession session;

	public StudyForm() {
		super("ارزیابی اختراع");
		initGUI();
	}

	public StudyForm(DesktopUser desktopUser, InventionFileAssesment ifa) {
		super("ارزیابی اختراع");
		this.ifa = ifa;
		this.desktopUser = desktopUser;
		initGUI();
		setFields(ifa);
	}

	public StudyForm(InventionFileAssesment inventionFileAssesment) {
		super("ارزیابی اختراع");
		this.ifa = inventionFileAssesment;
		initGUI();
		setFields(ifa);
		for (Component c : jPanel1.getComponents()) {
			if (c instanceof JCheckBox)
				((JCheckBox) c).setEnabled(false);
		}
		saveButton.getParent().remove(saveButton);
		sendButton.getParent().remove(sendButton);
		viewInventionButton.getParent().remove(viewInventionButton);
	}

	private void setFields(InventionFileAssesment ifa) {
		if (ifa.getDocCompleteness() != null) {
			docCompYesBox.setSelected(ifa.getDocCompleteness());
			docCompNoBox.setSelected(!ifa.getDocCompleteness());
		}

		if (ifa.getAbstractCompleteness() != null) {
			abstractCompYesBox.setSelected(ifa.getAbstractCompleteness());
			abstractCompNoBox.setSelected(!ifa.getAbstractCompleteness());
		}

		if (ifa.getRepresentationCheck() != null) {
			representationYesBox.setSelected(ifa.getRepresentationCheck());
			representationNoBox.setSelected(!ifa.getRepresentationCheck());
		}

		if (ifa.getOriginality() != null) {
			originalityYesBox.setSelected(ifa.getOriginality());
			originalityNoBox.setSelected(!ifa.getOriginality());
		}

		if (ifa.getIndictmentConsistency() != null) {
			indictmentYesBox.setSelected(ifa.getIndictmentConsistency());
			indictmentNoBox.setSelected(!ifa.getIndictmentConsistency());
		}

	}

	private void initGUI() {
		try {
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent arg0) {
					InventionHome.getInstance().refreshAssesment(ifa);
					if(desktopUser!=null){
						desktopUser.updateInventionsTable();
						desktopUser.updateAssesmentsTable();
					}

				}

			});

			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, BorderLayout.SOUTH);
				jPanel3.setLayout(null);
				jPanel3.setBackground(new java.awt.Color(255, 255, 255));
				jPanel3.setPreferredSize(new java.awt.Dimension(600, 110));
				{
					jLabel14 = new JLabel();
					jPanel3.add(jLabel14);
					jLabel14.setBounds(480, 32, 204, 78);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("ax.jpg")));
				}
				{
					cancelButton = new JButton();
					jPanel3.add(cancelButton);
					cancelButton
							.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
					cancelButton.setBounds(25, 48, 118, 44);
					cancelButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					cancelButton
							.setBackground(new java.awt.Color(255, 236, 255));
					cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					cancelButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							StudyForm.this.dispose();
						}
					});
				}
				{
					saveButton = new JButton();
					jPanel3.add(saveButton);
					saveButton.setText("\u0630\u062e\u06cc\u0631\u0647");
					saveButton.setBackground(new java.awt.Color(255, 236, 255));
					saveButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					saveButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					saveButton.setBounds(157, 48, 118, 44);
					saveButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							saveButtonActionPerformed(arg0);
						}
					});

				}
				{
					sendButton = new JButton();
					jPanel3.add(sendButton);
					sendButton
							.setText("\u0627\u0631\u0633\u0627\u0644 \u0646\u0647\u0627\u06cc\u06cc");
					sendButton.setBackground(new java.awt.Color(255, 236, 255));
					sendButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					sendButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					sendButton.setBounds(289, 48, 118, 44);
					sendButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							sendButtonActionPerformed(arg0);
						}
					});
				}

			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				jPanel1.setLayout(null);
				{
					viewInventionButton = new JButton();
					jPanel1.add(viewInventionButton);
					viewInventionButton
							.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u062c\u0632\u06cc\u06cc\u0627\u062a \u0627\u062e\u062a\u0631\u0627\u0639");
					viewInventionButton.setBackground(new java.awt.Color(255,
							236, 255));
					viewInventionButton.setFont(new java.awt.Font("Tahoma", 0,
							14));
					viewInventionButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					viewInventionButton.setBounds(26, 269, 154, 44);
					viewInventionButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							showInventionButtonActionPerformed();
						}
					});
				}
				{
					originalityLabel = new JLabel();
					jPanel1.add(originalityLabel);
					originalityLabel
							.setText("\u0622\u06cc\u0627 \u0627\u062e\u062a\u0631\u0627\u0639 \u0627\u0635\u0627\u0644\u062a \u0648 \u0646\u0648\u0622\u0648\u0631\u06cc \u0644\u0627\u0632\u0645 \u0631\u0627 \u062f\u0627\u0631\u062f\u061f");
					originalityLabel
							.setFont(new java.awt.Font("Tahoma", 0, 12));
					originalityLabel.setBorder(BorderFactory.createEmptyBorder(
							0, 0, 0, 0));
					originalityLabel.setBounds(368, 40, 197, 31);
					originalityLabel
							.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				{
					originalityYesBox = new JCheckBox();
					jPanel1.add(originalityYesBox);
					originalityYesBox.setText("\u0628\u0644\u06cc");
					originalityYesBox.setBounds(321, 40, 48, 31);
					originalityYesBox.setBackground(new java.awt.Color(255,
							255, 255));
					getOriginalityGroup().add(originalityYesBox);
				}
				{
					originalityNoBox = new JCheckBox();
					jPanel1.add(originalityNoBox);
					jPanel1.add(getJCheckBox2());
					jPanel1.add(getJCheckBox3());
					jPanel1.add(getJLabel1());
					jPanel1.add(getJCheckBox4());
					jPanel1.add(getJCheckBox5());
					jPanel1.add(getJLabel2());
					jPanel1.add(getJCheckBox6());
					jPanel1.add(getJCheckBox7());
					jPanel1.add(getJLabel3());
					jPanel1.add(getJCheckBox9());
					jPanel1.add(getJLabel4());
					jPanel1.add(getJCheckBox10());
					originalityNoBox.setText("\u062e\u06cc\u0631");
					originalityNoBox.setBounds(264, 40, 48, 31);
					originalityNoBox.setBackground(new java.awt.Color(255, 255,
							255));
					getOriginalityGroup().add(originalityNoBox);
				}
			}

			pack();
			this.setSize(650, 484);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void sendButtonActionPerformed(ActionEvent arg0) {
		int returnVal = JOptionPane.showConfirmDialog(this,
				"آیا برای ارسال نهایی ارزیابی  پروژه  اطمینان دارید؟", "اخطار",
				JOptionPane.YES_NO_OPTION);
		if (returnVal == JOptionPane.YES_OPTION) {
			boolean allChecked = checkAllChecked();
			if (allChecked) {
				setAssesmentAttributes();
				boolean accepted = ifa.checkAllTrue();
				if (accepted) {
					ifa.getInvention().setStatus(Status.accepted);
				} else {
					ifa.getInvention().setStatus(Status.rejected);
				}

				InventionHome.getInstance().updateAssesment(ifa);
				JOptionPane.showMessageDialog(this, "ارزیابی پروژه ارسال شد.");
				this.dispose();
			}
		} else {
			// save
			setAssesmentAttributes();
			InventionHome.getInstance().updateAssesment(ifa);
			JOptionPane.showMessageDialog(this, "ارزیابی پروژه ذخیره شد.");
		}

	}

	protected void saveButtonActionPerformed(ActionEvent arg0) {
		setAssesmentAttributes();
		InventionHome.getInstance().updateAssesment(ifa);
		JOptionPane.showMessageDialog(this, "ارزیابی پروژه ذخیره شد.");
		this.dispose();
	}

	protected void showInventionButtonActionPerformed() {
		InventionForm invf = new InventionForm(ifa.getInvention()
				.getInventionFile());
		invf.setLocationRelativeTo(this);
		invf.setVisible(true);

	}

	private ButtonGroup getOriginalityGroup() {
		if (originalityGroup == null) {
			originalityGroup = new ButtonGroup();
		}
		return originalityGroup;
	}

	private JCheckBox getJCheckBox2() {
		if (docCompNoBox == null) {
			docCompNoBox = new JCheckBox();
			docCompNoBox.setText("\u062e\u06cc\u0631");
			docCompNoBox.setBackground(new java.awt.Color(255, 255, 255));
			docCompNoBox.setBounds(264, 82, 48, 31);
			getDocCompGroup().add(docCompNoBox);
		}
		return docCompNoBox;
	}

	private JCheckBox getJCheckBox3() {
		if (docCompYesBox == null) {
			docCompYesBox = new JCheckBox();
			docCompYesBox.setText("\u0628\u0644\u06cc");
			docCompYesBox.setBackground(new java.awt.Color(255, 255, 255));
			docCompYesBox.setBounds(321, 82, 48, 31);
			getDocCompGroup().add(docCompYesBox);
		}
		return docCompYesBox;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("\u0622\u06cc\u0627 \u0645\u0633\u062a\u0646\u062f\u0627\u062a \u06a9\u0627\u0645\u0644 \u0627\u0633\u062a\u061f");
			jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
			jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel1.setBounds(368, 82, 197, 31);
		}
		return jLabel1;
	}

	private JCheckBox getJCheckBox4() {
		if (abstractCompNoBox == null) {
			abstractCompNoBox = new JCheckBox();
			abstractCompNoBox.setText("\u062e\u06cc\u0631");
			abstractCompNoBox.setBackground(new java.awt.Color(255, 255, 255));
			abstractCompNoBox.setBounds(264, 125, 48, 31);
			getAbstractCompGroup().add(abstractCompNoBox);
		}
		return abstractCompNoBox;
	}

	private JCheckBox getJCheckBox5() {
		if (abstractCompYesBox == null) {
			abstractCompYesBox = new JCheckBox();
			abstractCompYesBox.setText("\u0628\u0644\u06cc");
			abstractCompYesBox.setBackground(new java.awt.Color(255, 255, 255));
			abstractCompYesBox.setBounds(321, 125, 48, 31);
			getAbstractCompGroup().add(abstractCompYesBox);
		}
		return abstractCompYesBox;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("\u0622\u06cc\u0627 \u0634\u0631\u062d \u06a9\u0644\u06cc \u0627\u062e\u062a\u0631\u0627\u0639 \u06a9\u0627\u0645\u0644 \u0627\u0633\u062a\u061f");
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
			jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel2.setBounds(368, 125, 197, 31);
		}
		return jLabel2;
	}

	private JCheckBox getJCheckBox6() {
		if (indictmentNoBox == null) {
			indictmentNoBox = new JCheckBox();
			indictmentNoBox.setText("\u062e\u06cc\u0631");
			indictmentNoBox.setBackground(new java.awt.Color(255, 255, 255));
			indictmentNoBox.setBounds(264, 167, 48, 31);
			getIndictmentGroup().add(indictmentNoBox);
		}
		return indictmentNoBox;
	}

	private JCheckBox getJCheckBox7() {
		if (indictmentYesBox == null) {
			indictmentYesBox = new JCheckBox();
			indictmentYesBox.setText("\u0628\u0644\u06cc");
			indictmentYesBox.setBackground(new java.awt.Color(255, 255, 255));
			indictmentYesBox.setBounds(321, 167, 48, 31);
			getIndictmentGroup().add(indictmentYesBox);
		}
		return indictmentYesBox;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("\u0622\u06cc\u0627 \u0627\u062f\u0639\u0627\u0646\u0627\u0645\u0647 \u0633\u0627\u0632\u06af\u0627\u0631\u06cc \u062f\u0627\u0631\u062f\u061f");
			jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
			jLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel3.setBounds(368, 167, 197, 31);
		}
		return jLabel3;
	}

	private JCheckBox getJCheckBox9() {
		if (representationNoBox == null) {
			representationNoBox = new JCheckBox();
			representationNoBox.setText("\u062e\u06cc\u0631");
			representationNoBox
					.setBackground(new java.awt.Color(255, 255, 255));
			representationNoBox.setBounds(264, 210, 48, 31);
			getRepresentationGroup().add(representationNoBox);
		}
		return representationNoBox;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("\u0622\u06cc\u0627 \u0646\u0645\u0627\u06cc\u0646\u062f\u06af\u06cc \u0634\u0631\u06a9\u062a \u062a\u0627\u06cc\u06cc\u062f \u0645\u06cc \u0634\u0648\u062f\u061f");
			jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
			jLabel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jLabel4.setBounds(368, 210, 197, 31);
		}
		return jLabel4;
	}

	private JCheckBox getJCheckBox10() {
		if (representationYesBox == null) {
			representationYesBox = new JCheckBox();
			representationYesBox.setText("\u0628\u0644\u06cc");
			representationYesBox
					.setBackground(new java.awt.Color(255, 255, 255));
			representationYesBox.setBounds(321, 210, 48, 31);
			getRepresentationGroup().add(representationYesBox);
		}
		return representationYesBox;
	}

	private ButtonGroup getDocCompGroup() {
		if (docCompGroup == null) {
			docCompGroup = new ButtonGroup();
		}
		return docCompGroup;
	}

	private ButtonGroup getAbstractCompGroup() {
		if (abstractCompGroup == null) {
			abstractCompGroup = new ButtonGroup();
		}
		return abstractCompGroup;
	}

	private ButtonGroup getIndictmentGroup() {
		if (indictmentGroup == null) {
			indictmentGroup = new ButtonGroup();
		}
		return indictmentGroup;
	}

	private ButtonGroup getRepresentationGroup() {
		if (representationGroup == null) {
			representationGroup = new ButtonGroup();
		}
		return representationGroup;
	}

	public Boolean getValueFor(String string) {
		if (string.equals("docCompleteness")) {
			if (docCompYesBox.isSelected())
				return true;
			if (docCompNoBox.isSelected())
				return false;
			return null;
		}

		if (string.equals("originality")) {
			if (originalityYesBox.isSelected())
				return true;
			if (originalityNoBox.isSelected())
				return false;
			return null;
		}

		if (string.equals("abstractCompleteness")) {
			if (abstractCompYesBox.isSelected())
				return true;
			if (abstractCompNoBox.isSelected())
				return false;
			return null;
		}

		if (string.equals("indictmentConsistency")) {
			if (indictmentYesBox.isSelected())
				return true;
			if (indictmentNoBox.isSelected())
				return false;
			return null;
		}

		if (string.equals("representationCheck")) {
			if (representationYesBox.isSelected())
				return true;
			if (representationNoBox.isSelected())
				return false;
			return null;
		}

		return null;
	}

	public boolean checkAllChecked() {
		if (!representationNoBox.isSelected()
				&& !representationYesBox.isSelected())
			return false;
		if (!abstractCompYesBox.isSelected() && !abstractCompNoBox.isSelected())
			return false;
		if (!docCompYesBox.isSelected() && !docCompNoBox.isSelected())
			return false;
		if (!originalityYesBox.isSelected() && !originalityNoBox.isSelected())
			return false;
		if (!representationYesBox.isSelected()
				&& !representationNoBox.isSelected())
			return false;
		return true;
	}

	private void setAssesmentAttributes() {
		ifa.setDocCompleteness(this.getValueFor("docCompleteness"));
		ifa.setAbstractCompleteness(this.getValueFor("abstractCompleteness"));
		ifa.setIndictmentConsistency(this.getValueFor("indictmentConsistency"));
		ifa.setOriginality(this.getValueFor("originality"));
		ifa.setRepresentationCheck(this.getValueFor("representationCheck"));

	}

}
