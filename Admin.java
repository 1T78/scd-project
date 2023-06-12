Admin:
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminGUI {
final JPanel center;
private final JPanel west;
private final JPanel north;
private final JPanel south;
private final JFrame frame;
private final JButton logout;
private final JButton drugs;
private final JButton company;
private final JButton warning;
private final JButton sales;

private static final int GREY = 192;

public AdminGUI() {
frame = new JFrame();
frame.setLayout(new BorderLayout(7, 7));

JLabel name = new JLabel(&quot;Medical Management System&quot;);
name.setFont(new Font(&quot;Josefin Sans&quot;, Font.BOLD, 45));

JLabel logo = new JLabel(new ImageIcon(new ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced java micro-
project\\src\\logo.png&quot;).getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT)));
JLabel bg = new JLabel(new ImageIcon(new ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced java micro-
project\\src\\bg3.jpg&quot;).getImage().getScaledInstance(1020, 600, Image.SCALE_DEFAULT)));
JLabel about_us = new JLabel(new ImageIcon(new ImageIcon(&quot;C:\\Users\\chetan\\OneDrive\\Desktop\\Advanced java
micro-project\\src\\team.png&quot;).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));

logout = new JButton(&quot;Logout&quot;);
drugs = new JButton(&quot;Drugs&quot;);
company = new JButton(&quot;Company&quot;);
warning = new JButton(&quot;Warning&quot;);
sales = new JButton(&quot;Sales&quot;);

JLabel footer = new JLabel(&quot;© Copyright Medical Management System | All rights reserved&quot;);
footer.setFont(new Font(&quot;Bahnschrift Light&quot;, Font.BOLD, 22));

JPanel salesPanel = new JPanel();
JPanel userPanel = new JPanel();

center = new JPanel();
west = new JPanel();
north = new JPanel();
south = new JPanel();

west.setLayout(null);
north.setLayout(null);
center.setLayout(new CardLayout());
south.setLayout(new FlowLayout());

drugs.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
openAdminGUIDrugs();
}
});

company.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
openAdminGUICompany();
}
});

sales.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
openAdminGUISales();
}
});

warning.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
openAdminGUIWarning();
}
});

logout.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
showLogoutDialog();
}
});

about_us.addMouseListener(new MouseAdapter() {
public void mouseClicked(MouseEvent e) {
showAboutUsDialog();
}

private void showAboutUsDialog() {
throw new UnsupportedOperationException(&quot;Not supported yet.&quot;); //To change body of generated methods, choose
Tools | Templates.
}
});

logo.setBounds(300, 15, 80, 70);
name.setBounds(380, 15, 800, 70);

north.add(logo);
north.add(name);
north.add(about_us);

drugs.setBounds(80, 72, 90, 30);
company.setBounds(80, 150, 90, 30);
sales.setBounds(80, 220, 90, 30);
warning.setBounds(80, 290, 90, 30);
logout.setBounds(80, 360, 90, 30);
bg.setBounds(0, 0, 1020, 600);
about_us.setBounds(60, 25, 40, 40);

center.add(bg);
west.add(drugs);
west.add(warning);
west.add(sales);
west.add(company);
west.add(logout);

south.add(footer);

logout.setForeground(Color.WHITE);
logout.setBackground(new Color(GREY));
drugs.setForeground(Color.WHITE);
drugs.setBackground(new Color(GREY));

company.setForeground(Color.WHITE);
company.setBackground(new Color(GREY));
sales.setForeground(Color.WHITE);
sales.setBackground(new Color(GREY));
warning.setForeground(Color.WHITE);
warning.setBackground(new Color(GREY));

center.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));
west.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));
north.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));
south.setBorder(BorderFactory.createMatteBorder(7, 7, 7, 7, new Color(0, 128, 0)));

userPanel.setBackground(new Color(152, 251, 152));
salesPanel.setBackground(new Color(152, 251, 152));

center.setBackground(new Color(152, 251, 152));
west.setBackground(new Color(152, 251, 152));
north.setBackground(new Color(152, 251, 152));
south.setBackground(new Color(152, 251, 152));

north.setPreferredSize(new Dimension(100, 100));
west.setPreferredSize(new Dimension(250, 100));
south.setPreferredSize(new Dimension(100, 70));

frame.add(north, BorderLayout.NORTH);
frame.add(south, BorderLayout.SOUTH);
frame.add(center, BorderLayout.CENTER);
frame.add(west, BorderLayout.WEST);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setVisible(true);
}

private void openAdminGUIDrugs() {
new AdminGUIDrugs();
}

private void openAdminGUICompany() {
new AdminGUICompany();
}

private void openAdminGUISales() {
new AdminGUISales();
}

private void openAdminGUIWarning() {
new AdminGUIWarning();
}

private void showLogoutDialog() {
final JDialog logoutDialog = new JDialog(frame, &quot;Logout&quot;, false);
JLabel logoutLabel = new JLabel(&quot;Really want to logout?&quot;);
JButton yesButton = new JButton(&quot;Yes&quot;);
JButton noButton = new JButton(&quot;No&quot;);

logoutDialog.setLayout(null);

logoutLabel.setFont(new Font(&quot;Bebas Neue&quot;, Font.BOLD, 17));

yesButton.setForeground(Color.WHITE);
yesButton.setBackground(Color.BLACK);
noButton.setForeground(Color.WHITE);
noButton.setBackground(Color.BLACK);

logoutLabel.setBounds(100, 30, 200, 30);
yesButton.setBounds(105, 80, 70, 30);
noButton.setBounds(205, 80, 70, 30);

yesButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
frame.dispose();
frame.setVisible(false);
}
});
noButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
logoutDialog.dispose();
logoutDialog.setVisible(false);
}
});

logoutDialog.add(logoutLabel);
logoutDialog.add(yesButton);
logoutDialog.add(noButton);

logoutDialog.getContentPane().setBackground(new Color(152, 251, 152));
logoutDialog.setVisible(true);
logoutDialog.setSize(400, 200);
logoutDialog.setLocationRelativeTo(null);
}

public void actionPerformed(ActionEvent e) {
if (e.getSource() == drugs) {
openAdminGUIDrugs();
} else if (e.getSource() == company) {
openAdminGUICompany();
} else if (e.getSource() == sales) {
openAdminGUISales();
} else if (e.getSource() == warning) {

openAdminGUIWarning();
} else if (e.getSource() == logout) {
showLogoutDialog();
}
}
}