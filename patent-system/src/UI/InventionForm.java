package UI;

import invention.Invention.Status;
import invention.Invention;
import invention.InventionFile;
import invention.InventionFileEdition;
import invention.InventionHome;
import invention.InventorCollaboration;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import expertise.NewExpertiseDomainRequest;

import user.User;
import util.Attachment;

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
public class InventionForm extends javax.swing.JFrame {


	public InventionFile inventionFile;

	private JLabel jLabel1;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel11;
	private JLabel jLabel12;
	private JLabel jLabel13;

	private FarsiTable inventorsTable;
	private JScrollPane jScrollPane1;

	private JTextArea historyField;
	private JTextArea indictmentField;
	private JTextArea explanField;

	DefaultTableModel inventorsTableModel;
	private JTextArea abstractField;
	private JLabel editionCommentLabel;
	private JScrollPane jScrollPane2;
	private SingleSelectableTableModel<Attachment> filesTableModel;
	private JPanel jPanel5;
	private JLabel jLabel4;
	private JLabel inventionStatusLabel;
	private JButton viewStudyButton;
	private JButton downloadButton;
	private JButton priceSpecButton;
	private JLabel priceLabel;
	private JLabel priceValueLabel;
	private JLabel domainLabel;
	private JLabel domainNameLabel;
	private JPanel jPanel4;
	private JLabel inventorNameLabel;
	private JButton olderEditionsButton;
	private JLabel inventionNameLabel;
	private JLabel jLabel2;
	private JLabel domainNoteLabel;
	private JLabel domainField;
	private JPanel jPanel2;
	private JButton sendButton;
	private JButton registerButton;
	private JButton cancelButton;
	private JLabel jLabel14;
	private JPanel jPanel3;
	private JPanel jPanel1;
	private JLabel newDomainNoteLabel;
	private JButton removeFileButton;
	private JButton attachNewFileButton;
	private JTable filesTable;

	private InventionFileChangeSession session;


	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InventionForm inst = new InventionForm();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public InventionForm(InventionFileChangeSession inventionFileChangeSession) {
		super("ویرایش اختراع");
		session = inventionFileChangeSession;
		this.inventionFile = session.inventionFile;
		initGUI();
		setFields(this.inventionFile);
	}

	public InventionForm(InventionFile iFile) {
		super("جزییات اختراع");
		this.inventionFile = iFile;
		initGUI();
		setFields(iFile);

	}

	public InventionForm() {
		super("جزییات اختراع");
		initGUI();
	}

	private void setFields(InventionFile iFile) {
		InventionFileEdition ife = iFile.getLastEdition();
		abstractField.setText(ife.getAbstract_());
		historyField.setText(ife.getHistory());
		indictmentField.setText(ife.getIndictment());
		explanField.setText(ife.getExplan());
		inventionNameLabel.setText(iFile.getTitle());
		domainNameLabel.setText(iFile.getExpertiseDomain().toString());
		if(iFile.getNewExpertiseDomainRequest()==null){
			domainField.getParent().remove(domainField);
			domainNoteLabel.getParent().remove(domainNoteLabel);
			jLabel12.getParent().remove(jLabel12);
		}else{
			domainField.setText(iFile.getNewExpertiseDomainRequest().getDomainName());
			switch (iFile.getNewExpertiseDomainRequest().getStatus()) {
			case pending:
				domainNoteLabel.setText("حوزه کارشناسی هنوز به تایید مدیر نرسیده است.");
				break;
				
			case accepted:
				domainNoteLabel.setText("حوزه کارشناسی جدید ثبت شده است.");
				break;
				
			case rejected:
				domainNoteLabel.setText("حزوه کارشناسی جدید رد شده است.");
	
				break;

			default:
				break;
			}
		}

		inventionStatusLabel.setText(inventionFile.getStatus());

		if (iFile.isIndividual()) {
			System.out.println("IS INDIVIDUAL");
			jLabel2.setText("مخترع");
			jScrollPane1.getParent().remove(jScrollPane1);
			inventorNameLabel.getParent().setPreferredSize(
					new java.awt.Dimension(607, 40));

			inventorNameLabel.setText(((InventorCollaboration) iFile
					.getInventorCollaborations().toArray()[0]).getInventor()
					.getFullName());
		} else {
			System.out.println("IS GROUP");
			jLabel2.setText("مخترعین");
			inventorNameLabel.getParent().remove(inventorNameLabel);

			Set<InventorCollaboration> colabs = iFile
					.getInventorCollaborations();
			String[][] colabRows = new String[colabs.size()][3];
			int count = 0;
			for (InventorCollaboration ic : colabs)
				colabRows[count++] = ic
						.showRowRepresentation("inventor_collaboration");

			inventorsTableModel = new DefaultTableModel(colabRows,
					InventorCollaboration.getColumnNames("form"));
			inventorsTable.setModel(inventorsTableModel);
		}
		if (session != null){
			if (session.editor.getUserId() != iFile.getCreator().getUserId()) {
				jPanel3.remove(sendButton);
			}
		}else{
			sendButton.getParent().remove(sendButton);
			registerButton.getParent().remove(registerButton);
		}

		if (iFile.getInvention() != null) {
			if (iFile.getInvention().getStatus() == Status.rejected) {

			} else{
				viewStudyButton.getParent().remove(viewStudyButton);
				
				if(iFile.getInvention().getStatus() != Status.unauthorized){
					jPanel3.remove(sendButton);
					jPanel3.remove(registerButton);
					attachNewFileButton.getParent().remove(attachNewFileButton);
					removeFileButton.getParent().remove(removeFileButton);
	
					abstractField.setEditable(false);
					historyField.setEditable(false);
					explanField.setEditable(false);
					indictmentField.setEditable(false);
				}
			}

			if (iFile.getInvention().getStatus() != Status.accepted) {
				priceLabel.getParent().remove(priceLabel);
				priceValueLabel.getParent().remove(priceValueLabel);
				priceSpecButton.getParent().remove(priceSpecButton);
			} else {
				if (iFile.getInvention().getPrice() == null) {
					priceValueLabel.setText("نامشخص");
				} else {
					priceValueLabel.setText(iFile.getInvention().getPrice()
							.toString());
				}
			}
		} else {
			viewStudyButton.getParent().remove(viewStudyButton);
			priceLabel.getParent().remove(priceLabel);
			priceValueLabel.getParent().remove(priceValueLabel);
			priceSpecButton.getParent().remove(priceSpecButton);
		}

		filesTableModel.setData(iFile.getAttachments());

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				getContentPane().revalidate();
				getContentPane().repaint();

			}
		});

	}

	private void initGUI() {
		try {
			
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosed(WindowEvent arg0) {
					InventionHome.getInstance().refreshInventionFile(
							InventionForm.this.inventionFile);
					super.windowClosed(arg0);

				}

			});
		
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			{
				jPanel3 = new JPanel();
				getContentPane().add(jPanel3, BorderLayout.SOUTH);
				jPanel3.setBackground(new java.awt.Color(255, 255, 255));
				jPanel3.setLayout(null);
				jPanel3.setBounds(22, 525, 599, 112);
				jPanel3.setPreferredSize(new java.awt.Dimension(784, 78));
				{
					jLabel14 = new JLabel();
					jPanel3.add(jLabel14);
					jLabel14.setIcon(new ImageIcon(getClass().getClassLoader()
							.getResource("ax.jpg")));
					jLabel14.setBounds(580, 0, 204, 78);
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
					cancelButton.setBounds(27, 28, 112, 41);
					cancelButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent ae) {
							cancelButtonActionPerformed();

						}
					});
				}
				{
					registerButton = new JButton();
					jPanel3.add(registerButton);
					registerButton
							.setText("\u062b\u0628\u062a \u0648\u06cc\u0631\u0627\u06cc\u0634");
					registerButton.setBackground(new java.awt.Color(255, 236,
							255));
					registerButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					registerButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					registerButton.setBounds(148, 28, 112, 41);
					registerButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							session.nextDialog(InventionForm.this, null);
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
					sendButton.setBounds(269, 28, 112, 41);
					sendButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {

							session.nextDialog(InventionForm.this, "send");
						}
					});
				}
			}

			{
				jPanel1 = new JPanel();
				jPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(jPanel1, BorderLayout.NORTH);
				jPanel1.setBounds(254, 23, 454, 119);
				jPanel1.setBackground(new java.awt.Color(255, 255, 255));
				jPanel1.setPreferredSize(new java.awt.Dimension(784, 239));
				{
					olderEditionsButton = new JButton();
					jPanel1.add(olderEditionsButton);
					olderEditionsButton
							.setText("\u0648\u06cc\u0631\u0627\u06cc\u0634 \u0647\u0627\u06cc \u0642\u0628\u0644\u06cc");
					olderEditionsButton.setBackground(new java.awt.Color(255,
							236, 255));
					olderEditionsButton.setFont(new java.awt.Font("Tahoma", 0,
							14));
					olderEditionsButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					olderEditionsButton.setBounds(145, 48, 112, 41);
					olderEditionsButton
							.setPreferredSize(new java.awt.Dimension(113, 30));
					olderEditionsButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							session.showOlderEditions();
						}
					});
				}
				{
					inventionNameLabel = new JLabel();
					jPanel1.add(inventionNameLabel);
					inventionNameLabel
							.setText("\u0627\u062e\u062a\u0631\u0627\u0639 \u0628\u0627 \u0646\u0627\u0645 \u0645\u0634\u062e\u0635");
					inventionNameLabel.setPreferredSize(new java.awt.Dimension(
							507, 26));
					inventionNameLabel.setFont(new java.awt.Font("Tahoma", 0,
							12));
					inventionNameLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u0646\u0627\u0645 \u0627\u062e\u062a\u0631\u0627\u0639");
					jLabel1.setBounds(621, 18, 108, 26);
					jLabel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel1.setPreferredSize(new java.awt.Dimension(115, 25));
					jLabel1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

				}
				{
					domainNameLabel = new JLabel();
					jPanel1.add(domainNameLabel);
					domainNameLabel
							.setText("\u062d\u0648\u0632\u0647 \u0627\u062e\u062a\u0631\u0627\u0639 \u0645\u0634\u062e\u0635");
					domainNameLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
					domainNameLabel.setPreferredSize(new java.awt.Dimension(
							572, 25));
					domainNameLabel
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					domainLabel = new JLabel();
					jPanel1.add(domainLabel);
					domainLabel
							.setText("\u062d\u0648\u0632\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
					domainLabel.setHorizontalAlignment(SwingConstants.CENTER);
					domainLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
					domainLabel
							.setPreferredSize(new java.awt.Dimension(115, 25));
					domainLabel.setBorder(BorderFactory.createEmptyBorder(0, 0,
							0, 0));
					domainLabel.setBounds(621, 18, 108, 26);
					domainLabel
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					jPanel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					jPanel1.add(jPanel4);
					jPanel4.setPreferredSize(new java.awt.Dimension(607, 80));
					jPanel4.setBackground(new java.awt.Color(255, 255, 255));
					{
						jScrollPane1 = new JScrollPane();
						jPanel4.add(jScrollPane1);
						jScrollPane1.setBounds(253, 56, 454, 78);
						jScrollPane1.setPreferredSize(new java.awt.Dimension(
								423, 73));
						{
							inventorsTableModel = new DefaultTableModel(
									new String[][] {
											{ "60", "20", "معصومه ذبیحی" },
											{ "40", "80", "محبوبه ریاحی" } },
									new String[] { "مالکیت معنوی",
											"مالکیت مادی", "نام مخترع" });
							inventorsTable = new FarsiTable();
							jScrollPane1.setViewportView(inventorsTable);
							inventorsTable.setModel(inventorsTableModel);
						}
					}
					{
						inventorNameLabel = new JLabel();
						jPanel4.add(inventorNameLabel);
						inventorNameLabel
								.setPreferredSize(new java.awt.Dimension(563,
										33));
						inventorNameLabel
								.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u0645\u062e\u062a\u0631\u0639\u06cc\u0646");
					jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel2.setPreferredSize(new java.awt.Dimension(115, 25));
					jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel2.setBounds(621, 18, 108, 26);
					jLabel2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					jPanel5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					jPanel1.add(jPanel5);
					jPanel5.setPreferredSize(new java.awt.Dimension(752, 37));
					jPanel5.setBackground(new java.awt.Color(255, 255, 255));
					{
						viewStudyButton = new JButton();
						jPanel5.add(viewStudyButton);
						viewStudyButton
								.setText("\u0645\u0634\u0627\u0647\u062f\u0647 \u062f\u0644\u0627\u06cc\u0644 \u0631\u062f \u0634\u062f\u0646");
						viewStudyButton.setBackground(new java.awt.Color(255,
								236, 255));
						viewStudyButton.setFont(new java.awt.Font("Tahoma", 0,
								14));
						viewStudyButton
								.setPreferredSize(new java.awt.Dimension(144,
										25));
						viewStudyButton.setBorder(BorderFactory
								.createEtchedBorder(BevelBorder.LOWERED));
						viewStudyButton.setBounds(145, 48, 112, 41);
						viewStudyButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								viewStudyButtonActionPerformed(evt);
							}
						});
					}
					{
						inventionStatusLabel = new JLabel();
						jPanel5.add(inventionStatusLabel);
						inventionStatusLabel.setFont(new java.awt.Font(
								"Tahoma", 0, 12));
						inventionStatusLabel
								.setPreferredSize(new java.awt.Dimension(277,
										25));
						inventionStatusLabel
								.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
						inventionStatusLabel
								.setText("\u0648\u0636\u0639\u06cc\u062a \u0627\u062e\u062a\u0631\u0627\u0639 \u0645\u0634\u062e\u0635");
					}
					{
						jLabel4 = new JLabel();
						jPanel5.add(jLabel4);
						jLabel4.setText("\u0648\u0636\u0639\u06cc\u062a \u0627\u062e\u062a\u0631\u0627\u0639");
						jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
						jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
						jLabel4.setPreferredSize(new java.awt.Dimension(115, 25));
						jLabel4.setBorder(BorderFactory.createEmptyBorder(0, 0,
								0, 0));
						jLabel4.setBounds(621, 18, 108, 26);
						jLabel4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
					}
				}
				{
					priceSpecButton = new JButton();
					jPanel1.add(priceSpecButton);
					priceSpecButton
							.setText("\u062a\u0639\u06cc\u06cc\u0646 \u0642\u06cc\u0645\u062a");
					priceSpecButton.setBackground(new java.awt.Color(255, 236,
							255));
					priceSpecButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					priceSpecButton.setPreferredSize(new java.awt.Dimension(96,
							25));
					priceSpecButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					priceSpecButton.setBounds(145, 48, 112, 41);
					priceSpecButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							priceSpecButtonActionPerformed();
						}
					});
				}
				{
					priceValueLabel = new JLabel();
					jPanel1.add(priceValueLabel);
					priceValueLabel
							.setText("\u0642\u06cc\u0645\u062a \u0645\u0634\u062e\u0635");
					priceValueLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
					priceValueLabel.setPreferredSize(new java.awt.Dimension(
							150, 25));
					priceValueLabel
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					priceLabel = new JLabel();
					jPanel1.add(priceLabel);
					priceLabel.setText("\u0642\u06cc\u0645\u062a");
					priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
					priceLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
					priceLabel
							.setPreferredSize(new java.awt.Dimension(115, 25));
					priceLabel.setBorder(BorderFactory.createEmptyBorder(0, 0,
							0, 0));
					priceLabel.setBounds(621, 18, 108, 26);
					priceLabel
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
			}
			{
				jPanel2 = new JPanel();
				getContentPane().add(jPanel2, BorderLayout.CENTER);
				jPanel2.setPreferredSize(new java.awt.Dimension(784, 411));
				jPanel2.setLayout(null);
				jPanel2.setBackground(new java.awt.Color(255, 255, 255));
				{
					jScrollPane2 = new JScrollPane();
					jPanel2.add(jScrollPane2);
					jScrollPane2.setBounds(142, 305, 247, 79);
					{
						filesTableModel = new SingleSelectableTableModel<Attachment>(
								"attachment", Attachment.getColumnNames("attachment"),
								new ArrayList<Attachment>());

						filesTable = new FarsiTable();
						jScrollPane2.setViewportView(filesTable);
						filesTable.setModel(filesTableModel);
						filesTableModel
								.addTableModelListener(new TableModelListener() {

									@Override
									public void tableChanged(TableModelEvent tme) {
										System.out.println("table changed");
										switch (tme.getType()) {
										case TableModelEvent.DELETE:
											attachNewFileButton
													.setEnabled(true);
										case TableModelEvent.INSERT:
											if (filesTableModel.getRowCount() == 3)
												attachNewFileButton
														.setEnabled(false);
										case TableModelEvent.UPDATE:
											if (filesTableModel
													.getSelectedRows().size() == 0) {
												removeFileButton
														.setEnabled(false);
												downloadButton
														.setEnabled(false);
											} else {
												removeFileButton
														.setEnabled(true);
												downloadButton
														.setEnabled(filesTableModel
																.getSelectedRow()
																.getExtension() != null);

											}

										}

									}
								});

						filesTable.setRowSelectionAllowed(false);
					}

				}
				{
					attachNewFileButton = new JButton();
					jPanel2.add(attachNewFileButton);
					attachNewFileButton
							.setText("\u0627\u0636\u0627\u0641\u0647");
					attachNewFileButton.setBackground(new java.awt.Color(255,
							236, 255));
					attachNewFileButton.setFont(new java.awt.Font("Tahoma", 0,
							14));
					attachNewFileButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					attachNewFileButton.setBounds(22, 333, 108, 23);
					attachNewFileButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							attachNewFile();
						}
					});
				}
				{
					removeFileButton = new JButton();
					jPanel2.add(removeFileButton);
					removeFileButton.setText("\u062d\u0630\u0641");
					removeFileButton.setBackground(new java.awt.Color(255, 236,
							255));
					removeFileButton
							.setFont(new java.awt.Font("Tahoma", 0, 14));
					removeFileButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					removeFileButton.setBounds(22, 362, 108, 23);
					removeFileButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							removeFileButtonActionPerformed();

						}
					});

					removeFileButton.setEnabled(false);
				}
				{
					newDomainNoteLabel = new JLabel();
					jPanel2.add(newDomainNoteLabel);
					newDomainNoteLabel
							.setText("\u062f\u0631\u062e\u0648\u0627\u0633\u062a \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f \u062a\u0648\u0633\u0637 \u0645\u062f\u06cc\u0631 \u0628\u0631\u0631\u0633\u06cc \u0634\u062f\u0647 \u0648 \u0646\u062a\u06cc\u062c\u0647 \u0627\u0639\u0644\u0627\u0645 \u062e\u0648\u0627\u0647\u062f \u0634\u062f");
					newDomainNoteLabel.setBounds(453, 439, 267, 15);
					newDomainNoteLabel
							.setFont(new java.awt.Font("Tahoma", 1, 8));
					newDomainNoteLabel.setVisible(false);
				}

				{
					jLabel8 = new JLabel();
					jPanel2.add(jLabel8);
					jLabel8.setText("\u0686\u06a9\u06cc\u062f\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
					jLabel8.setBounds(616, 6, 115, 23);
					jLabel8.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					jLabel9 = new JLabel();
					jPanel2.add(jLabel9);
					jLabel9.setText("\u0633\u0627\u0628\u0642\u0647 \u0627\u062e\u062a\u0631\u0627\u0639");
					jLabel9.setBounds(261, 6, 115, 23);
					jLabel9.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
				}
				{
					jLabel11 = new JLabel();
					jPanel2.add(jLabel11);
					jLabel11.setText("\u0627\u062f\u0639\u0627\u0646\u0627\u0645\u0647");
					jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel11.setBounds(616, 132, 115, 23);
				}
				{
					jLabel10 = new JLabel();
					jPanel2.add(jLabel10);
					jLabel10.setText("\u0634\u0631\u062d \u06a9\u0627\u0645\u0644 \u0627\u062e\u062a\u0631\u0627\u0639");
					jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel10.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel10.setBounds(261, 132, 115, 23);
				}
				{
					indictmentField = new JTextArea();
					jPanel2.add(indictmentField);
					indictmentField.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					indictmentField.setBounds(426, 161, 305, 97);
					indictmentField
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					jLabel12 = new JLabel();
					jPanel2.add(jLabel12);
					jLabel12.setText("\u062f\u0631\u062e\u0648\u0627\u0633\u062a \u062d\u0648\u0632\u0647 \u062c\u062f\u06cc\u062f");
					jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel12.setBounds(607, 285, 124, 33);
				}
				{
					jLabel13 = new JLabel();
					jPanel2.add(jLabel13);
					jLabel13.setText("\u0641\u0627\u06cc\u0644 \u0647\u0627\u06cc \u0636\u0645\u06cc\u0645\u0647");
					jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
					jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12));
					jLabel13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
							0));
					jLabel13.setBounds(274, 274, 115, 25);
				}
				{
					historyField = new JTextArea();
					jPanel2.add(historyField);
					historyField.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					historyField.setBounds(52, 29, 324, 97);
					historyField
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					explanField = new JTextArea();
					jPanel2.add(explanField);
					explanField.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					explanField.setBounds(52, 161, 324, 97);
					explanField
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					editionCommentLabel = new JLabel();
					jPanel2.add(editionCommentLabel);
					editionCommentLabel
							.setText("\u062a\u0648\u0636\u06cc\u062d \u0648\u06cc\u0631\u0627\u06cc\u0634");
					editionCommentLabel
							.setHorizontalAlignment(SwingConstants.CENTER);
					editionCommentLabel.setFont(new java.awt.Font("Tahoma", 1,
							12));
					editionCommentLabel.setBorder(BorderFactory
							.createEmptyBorder(0, 0, 0, 0));
					editionCommentLabel.setBounds(623, 500, 108, 33);
				}
				{
					abstractField = new JTextArea();
					jPanel2.add(abstractField);
					abstractField.setBorder(BorderFactory
							.createBevelBorder(BevelBorder.LOWERED));
					abstractField.setBounds(426, 29, 305, 97);
					abstractField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					domainField = new JLabel();
					jPanel2.add(domainField);
					domainField
							.setText("\u062d\u0648\u0632\u0647 \u06cc \u0627\u062e\u062a\u0631\u0627\u0639");
					domainField.setBounds(523, 329, 208, 33);
					domainField.setFont(new java.awt.Font("Tahoma", 0, 12));
					domainField
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					domainNoteLabel = new JLabel();
					jPanel2.add(domainNoteLabel);
					domainNoteLabel
							.setText("\u062d\u0648\u0632\u0647 \u0647\u0646\u0648\u0632 \u0628\u0647 \u062a\u0627\u06cc\u06cc\u062f \u0646\u0631\u0633\u06cc\u062f\u0647 \u0627\u0633\u062a");
					domainNoteLabel.setBounds(518, 368, 213, 19);
					domainNoteLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
					domainNoteLabel
							.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				}
				{
					downloadButton = new JButton();
					jPanel2.add(downloadButton);
					downloadButton
							.setText("\u062f\u0627\u0646\u0644\u0648\u062f");
					downloadButton.setBackground(new java.awt.Color(255, 236,
							255));
					downloadButton.setFont(new java.awt.Font("Tahoma", 0, 14));
					downloadButton.setBorder(BorderFactory
							.createEtchedBorder(BevelBorder.LOWERED));
					downloadButton.setBounds(22, 304, 108, 23);
					downloadButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							downloadButtonActionPerformed(evt);
						}
					});
				}
			}

			pack();
			this.setSize(800, 749);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	protected void priceSpecButtonActionPerformed() {
		Invention inv = this.inventionFile.getInvention();
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
					priceValueLabel.setText(inv.getPrice().toString());
				}
			}
		}

	}

	protected void removeFileButtonActionPerformed() {
		Attachment att = filesTableModel.getSelectedRow();
		if(att.getStatus()==Attachment.Status.added)
			inventionFile.getAttachments().remove(att);
		else
			att.setStatus(Attachment.Status.removed);
		
		updateFilesTableModel();

	}

	private void updateFilesTableModel() {
		ArrayList<Attachment> attachments=new ArrayList<Attachment>();
		for(Attachment att: inventionFile.getAttachments())
			if(att.getStatus()!=Attachment.Status.removed)
				attachments.add(att);
		
		filesTableModel.setData(attachments);
		
	}

	protected void cancelButtonActionPerformed() {
		this.dispose();

	}

	protected void registerButtonMouseClicked() {
		EditionExplanForm ii = new UI.EditionExplanForm();
		ii.setLocationRelativeTo(null);
		ii.setVisible(true);
	}

	private void attachNewFile() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();

			String filename = JOptionPane.showInputDialog(this, "نام فایل",
					f.getName());
			if (filename == null)
				filename = f.getName();

			Attachment af = new Attachment(filename, f);

			inventionFile.getAttachments().add(af);
			af.setStatus(Attachment.Status.added);
			af.setInventionFile(inventionFile);
			filesTableModel.setData(inventionFile.getAttachments());
		}
	}

	public JTextArea getHistoryField() {
		return historyField;
	}

	public JTextArea getIndictmentField() {
		return indictmentField;
	}

	public JTextArea getExplanField() {
		return explanField;
	}

	public JTextArea getAbstractField() {
		return abstractField;
	}

	private void downloadButtonActionPerformed(ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfc.getSelectedFile();
			Attachment att = filesTableModel.getSelectedRow();

			try {

				InputStream in = new FileInputStream("attachments/att_"
						+ att.getId());

				OutputStream out = new FileOutputStream(file + "."
						+ att.getExtension());

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
				in.close();
				out.close();
				JOptionPane.showMessageDialog(this, "فایل با موفقیت دانلود شد");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}

	private void viewStudyButtonActionPerformed(ActionEvent evt) {
		StudyForm sf = new StudyForm(inventionFile.getInvention()
				.getCurrentAssesment());
		sf.setLocationRelativeTo(this);
		sf.setVisible(true);
	}

}
