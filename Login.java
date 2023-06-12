Login code:
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
private JFrame frame;
private JPanel centerPanel;
private JPanel northPanel;
private JTextField usernameTextField;
private JPasswordField passwordField;
private JButton submitButton;
private JButton backButton;
private JLabel headerLabel;
private JLabel logoLabel;
private JLabel usernameLabel;
private JLabel passwordLabel;
private JLabel medicineLabel1;

private JLabel medicineLabel2;
private JLabel username;
private JLabel password;
private String validUsername = &quot;admin&quot;;
private String validPassword = &quot;1234&quot;;

public Login() {
frame = new JFrame();
centerPanel = new JPanel();
northPanel = new JPanel();
usernameTextField = new JTextField();
passwordField = new JPasswordField();
usernameLabel = new JLabel(&quot;Username:&quot;);
passwordLabel = new JLabel(&quot;Password:&quot;);
submitButton = new JButton(&quot;Submit&quot;);
backButton = new JButton(&quot;Back&quot;);
headerLabel = new JLabel(&quot;Medical Management System&quot;);
logoLabel = new JLabel(new ImageIcon(new ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced
java micro-project\\src\\logo.png&quot;).getImage().getScaledInstance(60,50, Image.SCALE_DEFAULT)));
medicineLabel1 = new JLabel(new ImageIcon(new
ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced java micro-
project\\src\\medical.png&quot;).getImage().getScaledInstance(512,512, Image.SCALE_DEFAULT)));
medicineLabel2 = new JLabel(new ImageIcon(new
ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced java micro-
project\\src\\medical.png&quot;).getImage().getScaledInstance(512,512, Image.SCALE_DEFAULT)));
username = new JLabel(validUsername);
password = new JLabel(validPassword);

submitButton.setForeground(new Color(255, 250, 250));
submitButton.setBackground(new Color(0, 0, 0));
backButton.setForeground(new Color(255, 250, 250));
backButton.setBackground(new Color(0, 0, 0));

// Set font to labels

headerLabel.setFont(new Font(&quot;Bebas Neue&quot;, Font.BOLD, 45));
usernameLabel.setFont(new Font(&quot;Bebas Neue&quot;, Font.PLAIN, 17));
passwordLabel.setFont(new Font(&quot;Bebas Neue&quot;, Font.PLAIN, 17));

// Set layout to frame, center (center panel) and north (north panel)
frame.setLayout(new BorderLayout(7, 7));
centerPanel.setLayout(null);
northPanel.setLayout(null);

// Set tooltip to usernameTextField and passwordField on center panel
usernameTextField.setToolTipText(&quot;Enter username&quot;);
passwordField.setToolTipText(&quot;Enter password&quot;);

submitButton.addActionListener(this);
backButton.addActionListener(this);

usernameTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

// Set bounds to components on center panel
usernameLabel.setBounds(450, 170, 100, 25);
passwordLabel.setBounds(450, 230, 100, 25);
usernameTextField.setBounds(600, 170, 200, 25);
passwordField.setBounds(600, 230, 200, 25);
backButton.setBounds(500, 285, 80, 30);
submitButton.setBounds(650, 285, 80, 30);
medicineLabel1.setBounds(0, 20, 512, 512);
medicineLabel2.setBounds(765, 20, 512, 512);

logoLabel.setBounds(300, 15, 80, 70);
headerLabel.setBounds(380, 15, 800, 70);

// Add components on center panel (north)
northPanel.add(headerLabel);
northPanel.add(logoLabel);

// Set border to components on center panel
centerPanel.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));
northPanel.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));
usernameTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
passwordField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

// Add components on center panel (center)
centerPanel.add(usernameTextField);
centerPanel.add(passwordField);
centerPanel.add(submitButton);
centerPanel.add(backButton);
centerPanel.add(usernameLabel);
centerPanel.add(passwordLabel);
centerPanel.add(medicineLabel1);
centerPanel.add(medicineLabel2);

// Set background to panels in frame
centerPanel.setBackground(new Color(152, 251, 152));
northPanel.setBackground(new Color(152, 251, 152));

// Set size to panels in frame
northPanel.setPreferredSize(new Dimension(100, 100));

// Add panel to frame
frame.add(centerPanel, BorderLayout.CENTER);
frame.add(northPanel, BorderLayout.NORTH);

// Frame settings

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == submitButton) {
String enteredUsername = usernameTextField.getText();
String enteredPassword = new String(passwordField.getPassword());

if (enteredUsername.equals(validUsername) &amp;&amp; enteredPassword.equals(validPassword)) {
new Admin_GUI();
frame.dispose();
} else if (enteredUsername.equals(&quot;&quot;) || enteredPassword.equals(&quot;&quot;)) {
JOptionPane.showMessageDialog(null, &quot;You can&#39;t leave fields empty.&quot;);
} else {
JOptionPane.showMessageDialog(null, &quot;Username or Password is Invalid.&quot;);
}
} else if (ae.getSource() == backButton) {
new Welcome();
frame.dispose();
}
}
}