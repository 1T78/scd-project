package com.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Main class representing the GUI for managing drugs.
 */
public class Admin_GUI_drugs1 implements ActionListener {
    private JPanel drugsPanel;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton addButton;
    private JButton salesButton;
    private JTable drugsTable;
    private JTextField searchField;
    private JButton searchButton;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JComboBox<String> addTypeComboBox;
    
    private final String url = "jdbc:mysql://localhost:3306/medical_management?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String uname = "root";
    private final String pass = "";
    private final Font font = new Font("Bebas Neue", Font.BOLD, 14);
    
    public Admin_GUI_drugs1() {
        drugsPanel = new JPanel();
        Admin_GUI.center.removeAll();
        Admin_GUI.center.repaint();
        Admin_GUI.center.revalidate();
        Admin_GUI.center.add(drugsPanel);

        drugsPanel.setLayout(new BorderLayout(7, 7));

        createButtons();
        createTable();
        createSearchField();

        drugsPanel.add(createWestPanel(), BorderLayout.WEST);
        drugsPanel.add(createCenterPanel(), BorderLayout.CENTER);
    }

    private void createButtons() {
        addButton = createButton("Add", 33, 100, 80, 30);
        updateButton = createButton("Update", 33, 180, 80, 30);
        deleteButton = createButton("Delete", 33, 260, 80, 30);
        salesButton = createButton("Sales", 33, 340, 80, 30);
        
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        salesButton.addActionListener(this);
    }
    
    private void createTable() {
        tableModel = new DefaultTableModel();
        drugsTable = new JTable(tableModel);
        drugsTable.setBackground(Color.LIGHT_GRAY);
        drugsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(drugsTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<Object>> data = new ArrayList<>();

        String sql = "SELECT * FROM `mm_drugs`";

        try (Connection connection = DriverManager.getConnection(url, uname, pass);
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            // Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            // Get row data
            while (rs.next()) {
                ArrayList<Object> row = new ArrayList<>(columns);
                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // Add column names to the table model
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }

        // Add row data to the table model
        for (ArrayList<Object> row : data) {
            tableModel.addRow(row.toArray());
        }
    }
    
    private void createSearchField() {
        searchField = new JTextField();
        searchButton = createButton("Search", 300, 30, 80, 30);

        searchButton.addActionListener(this);
        searchField.addActionListener(this);
    }
    
    private JPanel createWestPanel() {
        JPanel westPanel = new JPanel();
        westPanel.setLayout(null);

        westPanel.add(addButton);
        westPanel.add(updateButton);
        westPanel.add(deleteButton);
        westPanel.add(salesButton);
        
        return westPanel;
    }
    
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        centerPanel.add(scrollPane, BorderLayout.CENTER);
        centerPanel.add(createSouthPanel(), BorderLayout.SOUTH);

        return centerPanel;
    }
    
    private JPanel createSouthPanel() {
        JPanel southPanel = new JPanel();
        southPanel.setBorder(BorderFactory.createTitledBorder("Search Drugs"));
        southPanel.setPreferredSize(new Dimension(0, 80));
        southPanel.setLayout(null);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setBounds(25, 30, 50, 30);
        searchLabel.setFont(font);

        searchField.setBounds(80, 30, 200, 30);
        searchField.setFont(font);

        searchButton.setBounds(380, 30, 80, 30);
        searchButton.setFont(font);

        southPanel.add(searchLabel);
        southPanel.add(searchField);
        southPanel.add(searchButton);
        
        return southPanel;
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        
        if (source == addButton) {
            openAddDialog();
        } else if (source == updateButton) {
            int selectedRow = drugsTable.getSelectedRow();
            if (selectedRow >= 0) {
                openUpdateDialog(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a drug to update.");
            }
        } else if (source == deleteButton) {
            int selectedRow = drugsTable.getSelectedRow();
            if (selectedRow >= 0) {
                deleteDrug(selectedRow);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a drug to delete.");
            }
        } else if (source == salesButton) {
            openSalesDialog();
        } else if (source == searchButton || source == searchField) {
            searchDrugs();
        }
    }
    
    private void openAddDialog() {
        JDialog addDialog = new JDialog();
        // Dialog contents and logic for adding a drug.
        // Implement the add functionality here.
        addDialog.setVisible(true);
    }
    
    private void openUpdateDialog(int selectedRow) {
        JDialog updateDialog = new JDialog();
        // Dialog contents and logic for updating a drug.
        // Implement the update functionality here.
        updateDialog.setVisible(true);
    }
    
    private void deleteDrug(int selectedRow) {
        // Logic for deleting a drug.
        // Implement the delete functionality here.
    }
    
    private void openSalesDialog() {
        JDialog salesDialog = new JDialog();
        // Dialog contents and logic for sales.
        // Implement the sales functionality here.
        salesDialog.setVisible(true);
    }
    
    private void searchDrugs() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(drugsTable.getModel());
        drugsTable.setRowSorter(sorter);
        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchField.getText());
        sorter.setRowFilter(rowFilter);
    }
}

