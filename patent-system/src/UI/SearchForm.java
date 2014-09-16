package UI;

import invention.InventionHome;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.hql.internal.ast.tree.UpdateStatement;

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
public class SearchForm extends javax.swing.JFrame {


	private JLabel jLabel1;
	private JCheckBox abstractBox;
	private JButton searchButton;
	private JScrollPane jScrollPane1;
	private JTable searchResultsTable;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JTextField searchField;
	private JPanel jPanel2;
	private JCheckBox titleBox;
	private JCheckBox indictmentBox;
	private JCheckBox explanBox;
	private JCheckBox historyBox;
	private JCheckBox inventorsBox;
	private ButtonGroup buttonGroup1;
	private JPanel jPanel1;
	private JPanel jPanel3;
	private JLabel jLabel14;
	private JButton cancelButton;
	private JButton showDetailButton;
	private SingleSelectableTableModel<InventionSearchResult> searchResultsTableModel;
	private User user;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SearchForm inst = new SearchForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public SearchForm(User user) {
		super("جست و جو");
		this.user = user;
		initGUI();
		if (!user.isExpert()){
			explanBox.getParent().remove(explanBox);
			
			SwingUtilities.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					SearchForm.this.getContentPane().revalidate();
					SearchForm.this.getContentPane().repaint();
				}
			});
		}

	}

	public SearchForm() {
		super("جست و جو");
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				jPanel1 = new JPanel();
				FlowLayout jPanel1Layout = new FlowLayout();
				getContentPane().add(jPanel1, BorderLayout.WEST);
				{
					jPanel5 = new JPanel();
					BoxLayout jPanel5Layout = new BoxLayout(jPanel5,
							javax.swing.BoxLayout.Y_AXIS);
					jPanel5.setLayout(jPanel5Layout);
					jPanel5.setPreferredSize(new java.awt.Dimension(600, 382));
					{
						jPanel3 = new JPanel();
						{
							jPanel4 = new JPanel();
							jPanel4.setPreferredSize(new java.awt.Dimension(
									600, 258));
							jPanel4.setBackground(new java.awt.Color(255, 255,
									255));
							jPanel5.add(jPanel4);
							jPanel4.add(getJScrollPane1());
						}
						jPanel5.add(jPanel3);
						jPanel3.setLayout(null);
						jPanel3.setBackground(new java.awt.Color(255, 255, 255));
						jPanel3.setPreferredSize(new java.awt.Dimension(600,
								100));
						{
							jLabel14 = new JLabel();
							jPanel3.add(jLabel14);
							jLabel14.setBounds(396, 19, 204, 78);
							jLabel14.setIcon(new ImageIcon(getClass()
									.getClassLoader().getResource("ax.jpg")));
						}
						{
							cancelButton = new JButton();
							jPanel3.add(cancelButton);
							cancelButton
									.setText("\u0627\u0646\u0635\u0631\u0627\u0641");
							cancelButton.setBounds(24, 34, 150, 44);
							cancelButton.setBorder(BorderFactory
									.createEtchedBorder(BevelBorder.LOWERED));
							cancelButton.setBackground(new java.awt.Color(255,
									236, 255));
							cancelButton.setFont(new java.awt.Font("Tahoma", 0,
									14));
							cancelButton.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent arg0) {
									SearchForm.this.dispose();
									
								}
							});
						}
						{
							showDetailButton = new JButton();
							jPanel3.add(showDetailButton);
							showDetailButton
									.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
							showDetailButton.setBackground(new java.awt.Color(
									255, 236, 255));
							showDetailButton.setFont(new java.awt.Font(
									"Tahoma", 0, 14));
							showDetailButton.setBorder(BorderFactory
									.createEtchedBorder(BevelBorder.LOWERED));
							showDetailButton.setBounds(186, 34, 150, 44);
							showDetailButton
									.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent arg0) {
											showDetailButtonActionPerformed();
											
										}
									});
							
							showDetailButton.setEnabled(false);
						}
					}
					getContentPane().add(jPanel5, BorderLayout.SOUTH);

				}

				jPanel1.setBounds(21, 49, 601, 340);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				jPanel1.setLayout(jPanel1Layout);
				jPanel1.setPreferredSize(new java.awt.Dimension(227, 341));
				{
					jPanel1.add(getJRadioButton1());
					jPanel1.add(getJRadioButton2());
					jPanel1.add(getJRadioButton4());
					jPanel1.add(getJRadioButton6());
					jPanel1.add(getJRadioButton7());
					jPanel1.add(getJRadioButton5());

				}
			}

			{
				jPanel2 = new JPanel();
				{
					jLabel1 = new JLabel();
					{
						searchButton = new JButton();
						searchButton.setText("\u062c\u0633\u062a\u062c\u0648");
						searchButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								List<InventionSearchResult> results=InventionHome.getInstance().getSearchResults(searchField
										.getText(), inventorsBox.isSelected(),
										titleBox.isSelected(), historyBox
												.isSelected(), abstractBox
												.isSelected(), indictmentBox
												.isSelected(), explanBox
												.isSelected());
								
								searchResultsTableModel.setData(results);

							}
						});
						jPanel2.add(searchButton);
					}
					{
						searchField = new JTextField();
						searchField.setPreferredSize(new java.awt.Dimension(
								163, 28));
						searchField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						jPanel2.add(searchField);
					}

					jPanel2.add(jLabel1);
					getContentPane().add(jPanel2, BorderLayout.CENTER);
					jPanel2.setPreferredSize(new java.awt.Dimension(373, 96));
					jPanel2.setBackground(new java.awt.Color(255, 255, 255));
					jLabel1.setText("\u0639\u0628\u0627\u0631\u062a \u062c\u0633\u062a\u062c\u0648:");
					jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setForeground(new java.awt.Color(0, 0, 0));
					jLabel1.setPreferredSize(new java.awt.Dimension(103, 28));

				}
			}

			pack();
			setSize(600, 500);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}



	protected void showDetailButtonActionPerformed() {
		InventionSearchResult isr=searchResultsTableModel.getSelectedRow();
		
		InventionForm iForm=new InventionForm(isr.getInvention().getInventionFile());
		iForm.setLocationRelativeTo(this);
		iForm.setVisible(true);
		
	}

	private ButtonGroup getButtonGroup1() {
		if (buttonGroup1 == null) {
			buttonGroup1 = new ButtonGroup();
		}
		return buttonGroup1;
	}

	private JCheckBox getJRadioButton2() {
		if (inventorsBox == null) {
			inventorsBox = new JCheckBox();
			inventorsBox.setText("\u0645\u062e\u062a\u0631\u0639\u06cc\u0646");
			inventorsBox.setBounds(413, 21, 164, 20);
			inventorsBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			inventorsBox.setBackground(new java.awt.Color(255, 255, 255));
			inventorsBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			inventorsBox.setHorizontalAlignment(SwingConstants.RIGHT);
			inventorsBox.setHorizontalTextPosition(SwingConstants.LEFT);
			inventorsBox.setPreferredSize(new java.awt.Dimension(58, 21));

		}
		return inventorsBox;
	}

	private JCheckBox getJRadioButton4() {
		if (historyBox == null) {
			historyBox = new JCheckBox();
			historyBox
					.setText("\u0633\u0627\u0628\u0642\u0647 \u0627\u06cc\u062f\u0647");
			historyBox.setBounds(390, 139, 187, 20);
			historyBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			historyBox.setBackground(new java.awt.Color(255, 255, 255));
			historyBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			historyBox.setHorizontalAlignment(SwingConstants.RIGHT);
			historyBox.setHorizontalTextPosition(SwingConstants.LEFT);
			historyBox.setPreferredSize(new java.awt.Dimension(79, 21));

		}
		return historyBox;
	}

	private JCheckBox getJRadioButton5() {
		if (explanBox == null) {
			explanBox = new JCheckBox();
			explanBox.setText("\u0634\u0631\u062d \u0627\u062e\u062a\u0631\u0627\u0639");
			explanBox.setBounds(430, 179, 147, 21);
			explanBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			explanBox.setBackground(new java.awt.Color(255, 255, 255));
			explanBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			explanBox.setHorizontalAlignment(SwingConstants.RIGHT);
			explanBox.setHorizontalTextPosition(SwingConstants.LEFT);
			explanBox.setPreferredSize(new java.awt.Dimension(74, 21));

		}
		return explanBox;
	}

	private JCheckBox getJRadioButton6() {
		if (indictmentBox == null) {
			indictmentBox = new JCheckBox();
			indictmentBox
					.setText("\u0627\u062f\u0639\u0627\u0646\u0627\u0645\u0647");
			indictmentBox.setBounds(459, 218, 118, 20);
			indictmentBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			indictmentBox.setBackground(new java.awt.Color(255, 255, 255));
			indictmentBox
					.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			indictmentBox.setHorizontalAlignment(SwingConstants.RIGHT);
			indictmentBox.setHorizontalTextPosition(SwingConstants.LEFT);
			indictmentBox.setPreferredSize(new java.awt.Dimension(58, 21));

		}
		return indictmentBox;
	}

	private JCheckBox getJRadioButton7() {
		if (abstractBox == null) {
			abstractBox = new JCheckBox();
			abstractBox.setText("\u0686\u06a9\u06cc\u062f\u0647");
			abstractBox.setBounds(440, 258, 137, 20);
			abstractBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			abstractBox.setBackground(new java.awt.Color(255, 255, 255));
			abstractBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			abstractBox.setHorizontalAlignment(SwingConstants.RIGHT);
			abstractBox.setHorizontalTextPosition(SwingConstants.LEFT);
			abstractBox.setPreferredSize(new java.awt.Dimension(58, 21));

		}
		return abstractBox;
	}

	private JCheckBox getJRadioButton1() {
		if (titleBox == null) {
			titleBox = new JCheckBox();
			titleBox.setText("\u0639\u0646\u0627\u0648\u06cc\u0646 \u0627\u062e\u062a\u0631\u0627\u0639");
			titleBox.setBounds(434, 60, 143, 20);
			titleBox.setBackground(new java.awt.Color(255, 255, 255));
			titleBox.setHorizontalAlignment(SwingConstants.RIGHT);
			titleBox.setHorizontalTextPosition(SwingConstants.LEFT);
			titleBox.setFont(new java.awt.Font("Tahoma", 0, 11));
			titleBox.setPreferredSize(new java.awt.Dimension(84, 21));
		}
		return titleBox;
	}

	private JTable getSearchResultsTable() {
		if (searchResultsTable == null) {
			searchResultsTableModel = new SingleSelectableTableModel<InventionSearchResult>(
					null, InventionSearchResult.getColumnNames(),
					new ArrayList<InventionSearchResult>());

			searchResultsTable = new FarsiTable();
			searchResultsTable.setModel(searchResultsTableModel);

			searchResultsTableModel
					.addTableModelListener(new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent tme) {
							ArrayList<Integer> srows = searchResultsTableModel
									.getSelectedRowsIndexes();
							showDetailButton.setEnabled(!srows.isEmpty());
						}
					});
			
		}
		return searchResultsTable;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setPreferredSize(new java.awt.Dimension(490, 228));
			jScrollPane1.setViewportView(getSearchResultsTable());
		}
		return jScrollPane1;
	}

}
