package UI;

import helper.PatentSysSessionFactory;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;

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
public class LoginPage extends JFrame {


	private JButton loginButton;
	private JLabel jLabel1;
	private JLabel jLabel4;
	private JButton signUpButton;
	private JPasswordField pass;
	private JTextField usertext;
	private JLabel jlabel2;
	private JLabel jLabel3;
	private JLabel errorLabel;
	private JCheckBox remember;

	Border border = BorderFactory.createLineBorder(Color.red);
	Border border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Plastic3DLookAndFeel.setCurrentTheme(new OceanTheme());
		try {
			
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginPage inst = new LoginPage();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public LoginPage() {
		super();
		initGUI();
		// initActionListeners();
	}

	private void initGUI() {
		try {

			Locale arabic = new Locale("ar", "KW");
			ComponentOrientation arabicOrientation = ComponentOrientation
					.getOrientation(arabic);
			this.setComponentOrientation(arabicOrientation);

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

			setTitle("ورود به سامانه");

			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(255, 255, 255));
			{
				loginButton = new JButton();
				getContentPane().add(loginButton);
				loginButton.setText("\u0648\u0631\u0648\u062f");
				loginButton.setBounds(62, 232, 150, 44);
				loginButton.setFont(new java.awt.Font("Tahoma", 0, 14));
				loginButton.setBackground(new java.awt.Color(255, 236, 255));
				loginButton.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				loginButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						loginButtonActionPerformed(e);

					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u0646\u0627\u0645 \u06a9\u0627\u0631\u0628\u0631\u06cc");
				jLabel3.setBounds(343, 91, 109, 36);
				jLabel3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
				jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
				jLabel3.setForeground(new java.awt.Color(128, 0, 64));
			}
			{
				jlabel2 = new JLabel();
				getContentPane().add(jlabel2);
				jlabel2.setText("\u0631\u0645\u0632 \u0648\u0631\u0648\u062f");
				jlabel2.setBounds(370, 146, 63, 22);
				jlabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jlabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
				jlabel2.setHorizontalAlignment(SwingConstants.CENTER);
				jlabel2.setForeground(new java.awt.Color(128, 0, 64));
			}
			{
				usertext = new JTextField();
				getContentPane().add(usertext);
				usertext.setBounds(189, 98, 119, 29);
				usertext.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
			}
			{
				pass = new JPasswordField();
				getContentPane().add(pass);
				pass.setBounds(189, 148, 119, 28);
				pass.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));

			}
			{
				signUpButton = new JButton();
				getContentPane().add(signUpButton);
				signUpButton
						.setText("\u0627\u06cc\u062c\u0627\u062f \u062d\u0633\u0627\u0628 \u06a9\u0627\u0631\u0628\u0631\u06cc");
				signUpButton.setBounds(62, 311, 150, 44);
				signUpButton.setFont(new java.awt.Font("Tahoma", 0, 14));
				signUpButton.setBackground(new java.awt.Color(255, 236, 255));
				signUpButton.setBorder(BorderFactory
						.createEtchedBorder(BevelBorder.LOWERED));
				signUpButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						signUpButtonActionPerformed(e);

					}
				});
			}

			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText(". \u06a9\u0627\u0631\u0628\u0631 \u06af\u0631\u0627\u0645\u06cc ! \u0628\u0647 \u0633\u0627\u0645\u0627\u0646\u0647 \u06cc \u062b\u0628\u062a \u0648 \u0633\u0627\u0628\u0642\u0647 \u06cc \u0627\u062e\u062a\u0631\u0627\u0639\u0627\u062a \u062e\u0648\u0634 \u0622\u0645\u062f\u06cc\u062f");
				jLabel4.setBounds(29, 21, 436, 58);
				jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14));
				jLabel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
				jLabel4.setForeground(new java.awt.Color(128, 0, 64));

			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setBounds(280, 383, 204, 79);
				jLabel1.setIcon(new ImageIcon(getClass().getClassLoader()
						.getResource("ax.jpg")));
			}
			{

				errorLabel = new JLabel();
				getContentPane().add(errorLabel);
				errorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				errorLabel.setForeground(new java.awt.Color(255, 0, 0));
				errorLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
				errorLabel.setBorder(BorderFactory
						.createEmptyBorder(0, 0, 0, 0));
				errorLabel.setBounds(-3, 148, 180, 30);
			}
			{
				remember = new JCheckBox();
				getContentPane().add(remember);
				remember.setText("\u0645\u0631\u0627 \u0628\u0647 \u06cc\u0627\u062f \u0628\u0633\u067e\u0627\u0631");
				remember.setBackground(new java.awt.Color(255, 255, 255));
				remember.setBounds(259, 238, 134, 25);
				remember.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
				remember.setFont(new java.awt.Font("Tahoma", 0, 12));
				// remember.setLayout(RIGHT_ALIGNMENT);

			}

			pack();
			setSize(500, 500);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void signUpButtonActionPerformed(ActionEvent e) {
		UI.ProfileForm SU = new UI.ProfileForm();
		SU.setLocationRelativeTo(this);
		SU.setVisible(true);
		this.dispose();
	}

	private void loginButtonActionPerformed(ActionEvent e) {
		boolean hasError = false;
		if (usertext.getText().equals("") || pass.getPassword().length == 0) {
			if (usertext.getText().equals("") && pass.getPassword().length == 0) {
				errorLabel.setText("نام کاربری و رمز عبور را وارد کنید.");
				usertext.setBorder(border);
				pass.setBorder(border);
				hasError = true;
			}
			if (usertext.getText().equals("") && pass.getPassword().length != 0) {
				errorLabel.setText("نام کاربری را وارد کنید.");
				usertext.setBorder(border);
				pass.setBorder(border1);
				hasError = true;
			}
			if (pass.getPassword().length == 0
					&& !usertext.getText().equals("")) {
				errorLabel
						.setText("*\u0631\u0645\u0632 \u0639\u0628\u0648\u0631 \u0631\u0627 \u0648\u0627\u0631\u062f \u06a9\u0646\u06cc\u062f");
				pass.setBorder(border);
				usertext.setBorder(border1);
				hasError = true;
			}
		} else if (!usertext.getText().equals("")
				&& pass.getPassword().length != 0) {
			errorLabel.setText("");
			pass.setBorder(border1);
			usertext.setBorder(border1);
			if (remember.isSelected()) {
				hasError = true;
				// remember me
			}
			if (!hasError) {
				byte[] passwdmd5Bytes = null;
				String passwd = new String(pass.getPassword());
				try {
					passwdmd5Bytes = MessageDigest.getInstance("MD5").digest(
							passwd.getBytes("ISO-8859-1"));
				} catch (NoSuchAlgorithmException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String passwdmd5 = new String(passwdmd5Bytes);
				String uname = usertext.getText();

				User user = UserHome.getInstance().loginPost(uname, passwdmd5);
				System.out.println(passwdmd5);
				if (user == null) {
					errorLabel.setText("نام کاربری یا کلمه ی عبور اشتباه است");
				} else if (user instanceof Manager) {
					UI.DesktopManager desk = new UI.DesktopManager(
							(Manager) user);
					desk.setLocationRelativeTo(null);
					desk.setVisible(true);
					this.dispose();
				} else {
					DesktopUser dm = new UI.DesktopUser(user);
					dm.setLocationRelativeTo(null);
					dm.setVisible(true);
					this.dispose();

				}
			}
		}
	}
}
