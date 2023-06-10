package com.project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AdminGUICompany implements ActionListener {
    private JPanel companyPanel;
    private JPanel companyPanelWest;
    private JPanel companyPanelCenter;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton addButton;
    private JButton addButtonSubmit;
    private JButton updateButtonSubmit;
    private JLabel addNameLabel;
    private JLabel addAddressLabel;
    private JLabel addPhoneNoLabel;
    private JLabel updateNameLabel;
    private JLabel updateAddressLabel;
    private JLabel updatePhoneNoLabel;
    private JTextField addNameTextField;
    private JTextField addAddressTextField;
    private JTextField addPhoneNoTextField;
    private JTextField updateNameTextField;
    private JTextField updateAddressTextField;
    private JTextField updatePhoneNoTextField;
    private JTable companyListTable;
    private JTextField searchTextField;
    private JButton searchButton;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JComboBox<String> addTypeComboBox;
    private JComboBox<String> updateTypeComboBox;
    private String url = "jdbc:mysql://localhost:3306/medical_management?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private String username = "root";
    private String password = "";
    private Font font = new Font("Bebas Neue", Font.BOLD, 14);
    private TableRowSorter<TableModel> sorter;

    public AdminGUICompany() {
        companyPanel = new JPanel();
        companyPanelWest = new JPanel();
        companyPanelCenter = new JPanel();
        searchTextField = new JTextField(10);
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        addButton = new JButton("Add");
        companyPanel.setLayout(new BorderLayout(7, 7));
        companyPanelWest.setLayout(null);
        companyPanelCenter.setLayout(null);

        tableModel = new DefaultTableModel();
        companyListTable = new JTable(tableModel);
        companyListTable.setBackground(Color.LIGHT_GRAY);
        companyListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<TableModel>(tableModel);
        companyListTable.setRowSorter(sorter);
        scrollPane = new JScrollPane(companyListTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        addButton.setForeground(new Color(255, 250, 250));
        addButton.setBackground(new Color(0, 0, 0));
        deleteButton.setForeground(new Color(255, 250, 250));
        deleteButton.setBackground(new Color(0, 0, 0));
        updateButton.setForeground(new Color(255, 250, 250));
        updateButton.setBackground(new Color(0, 0, 0));
        searchButton.setForeground(new Color(255, 250, 250));
        searchButton.setBackground(new Color(0, 0, 0));

        searchTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        companyPanelWest.setBackground(new Color(152, 251, 152));
        companyPanelCenter.setBackground(new Color(152, 251, 152));
        companyPanelWest.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 7, new Color(0, 128, 0)));
        companyPanel.add(companyPanelWest, BorderLayout.WEST);
        companyPanel.add(companyPanelCenter, BorderLayout.CENTER);

        addNameLabel = new JLabel("Name");
        addNameLabel.setFont(font);
        addNameTextField = new JTextField();
        addNameTextField.setPreferredSize(new Dimension(200, 25));

        addAddressLabel = new JLabel("Address");
        addAddressLabel.setFont(font);
        addAddressTextField = new JTextField();
        addAddressTextField.setPreferredSize(new Dimension(200, 25));

        addPhoneNoLabel = new JLabel("Phone No");
        addPhoneNoLabel.setFont(font);
        addPhoneNoTextField = new JTextField();
        addPhoneNoTextField.setPreferredSize(new Dimension(200, 25));

        updateNameLabel = new JLabel("Name");
        updateNameLabel.setFont(font);
        updateNameTextField = new JTextField();
        updateNameTextField.setPreferredSize(new Dimension(200, 25));

        updateAddressLabel = new JLabel("Address");
        updateAddressLabel.setFont(font);
        updateAddressTextField = new JTextField();
        updateAddressTextField.setPreferredSize(new Dimension(200, 25));

        updatePhoneNoLabel = new JLabel("Phone No");
        updatePhoneNoLabel.setFont(font);
        updatePhoneNoTextField = new JTextField();
        updatePhoneNoTextField.setPreferredSize(new Dimension(200, 25));

        addButtonSubmit = new JButton("Submit");
        addButtonSubmit.setBackground(new Color(135, 206, 235));
        addButtonSubmit.setFont(font);
        addButtonSubmit.addActionListener(this);

        updateButtonSubmit = new JButton("Submit");
        updateButtonSubmit.setBackground(new Color(135, 206, 235));
        updateButtonSubmit.setFont(font);
        updateButtonSubmit.addActionListener(this);

        addTypeComboBox = new JComboBox<String>();
        addTypeComboBox.addItem("Type A");
        addTypeComboBox.addItem("Type B");
        addTypeComboBox.addItem("Type C");

        updateTypeComboBox = new JComboBox<String>();
        updateTypeComboBox.addItem("Type A");
        updateTypeComboBox.addItem("Type B");
        updateTypeComboBox.addItem("Type C");

        companyPanelWest.add(addNameLabel);
        companyPanelWest.add(addNameTextField);
        companyPanelWest.add(addAddressLabel);
        companyPanelWest.add(addAddressTextField);
        companyPanelWest.add(addPhoneNoLabel);
        companyPanelWest.add(addPhoneNoTextField);
        companyPanelWest.add(updateNameLabel);
        companyPanelWest.add(updateNameTextField);
        companyPanelWest.add(updateAddressLabel);
        companyPanelWest.add(updateAddressTextField);
        companyPanelWest.add(updatePhoneNoLabel);
        companyPanelWest.add(updatePhoneNoTextField);
        companyPanelWest.add(addTypeComboBox);
        companyPanelWest.add(updateTypeComboBox);
        companyPanelWest.add(addButtonSubmit);
        companyPanelWest.add(updateButtonSubmit);
        companyPanelCenter.add(scrollPane);
        companyPanelCenter.add(addButton);
        companyPanelCenter.add(updateButton);
        companyPanelCenter.add(deleteButton);
        companyPanelCenter.add(searchTextField);
        companyPanelCenter.add(searchButton);

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);

        initializeTableData();
    }

    public JPanel getCompanyPanel() {
        return companyPanel;
    }

    private void initializeTableData() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM company");

            Vector<String> columns = new Vector<String>();
            columns.add("ID");
            columns.add("Name");
            columns.add("Address");
            columns.add("Phone No");
            columns.add("Type");

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();

            while (resultSet.next()) {
                Vector<Object> row = new Vector<Object>();
                row.add(resultSet.getInt("id"));
                row.add(resultSet.getString("name"));
                row.add(resultSet.getString("address"));
                row.add(resultSet.getString("phone_no"));
                row.add(resultSet.getString("type"));
                data.add(row);
            }

            resultSet.close();
            statement.close();
            connection.close();

            tableModel.setDataVector(data, columns);
            tableModel.fireTableDataChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        addNameTextField.setText("");
        addAddressTextField.setText("");
        addPhoneNoTextField.setText("");
        updateNameTextField.setText("");
        updateAddressTextField.setText("");
        updatePhoneNoTextField.setText("");
    }

    private void filterTableData(String searchQuery) {
        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter(searchQuery, 1);
        sorter.setRowFilter(rowFilter);
    }

    private void addCompany() {
        String name = addNameTextField.getText();
        String address = addAddressTextField.getText();
        String phoneNo = addPhoneNoTextField.getText();
        String type = addTypeComboBox.getSelectedItem().toString();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO company (name, address, phone_no, type) VALUES (?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phoneNo);
            statement.setString(4, type);
            statement.executeUpdate();

            statement.close();
            connection.close();

            clearFields();
            initializeTableData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCompany() {
        int selectedRow = companyListTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a company to update.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int companyId = (int) companyListTable.getValueAt(selectedRow, 0);
        String name = updateNameTextField.getText();
        String address = updateAddressTextField.getText();
        String phoneNo = updatePhoneNoTextField.getText();
        String type = updateTypeComboBox.getSelectedItem().toString();

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE company SET name = ?, address = ?, phone_no = ?, type = ? WHERE id = ?");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phoneNo);
            statement.setString(4, type);
            statement.setInt(5, companyId);
            statement.executeUpdate();

            statement.close();
            connection.close();

            clearFields();
            initializeTableData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteCompany() {
        int selectedRow = companyListTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a company to delete.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int companyId = (int) companyListTable.getValueAt(selectedRow, 0);

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM company WHERE id = ?");
            statement.setInt(1, companyId);
            statement.executeUpdate();

            statement.close();
            connection.close();

            initializeTableData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            clearFields();
            addTypeComboBox.setSelectedIndex(0);
            updateTypeComboBox.setSelectedIndex(0);
        } else if (e.getSource() == updateButton) {
            int selectedRow = companyListTable.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a company to update.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = (String) companyListTable.getValueAt(selectedRow, 1);
            String address = (String) companyListTable.getValueAt(selectedRow, 2);
            String phoneNo = (String) companyListTable.getValueAt(selectedRow, 3);
            String type = (String) companyListTable.getValueAt(selectedRow, 4);

            updateNameTextField.setText(name);
            updateAddressTextField.setText(address);
            updatePhoneNoTextField.setText(phoneNo);

            if (type.equals("Type A")) {
                updateTypeComboBox.setSelectedIndex(0);
            } else if (type.equals("Type B")) {
                updateTypeComboBox.setSelectedIndex(1);
            } else if (type.equals("Type C")) {
                updateTypeComboBox.setSelectedIndex(2);
            }
        } else if (e.getSource() == addButtonSubmit) {
            addCompany();
        } else if (e.getSource() == updateButtonSubmit) {
            updateCompany();
        } else if (e.getSource() == deleteButton) {
            deleteCompany();
        } else if (e.getSource() == searchButton) {
            String searchQuery = searchTextField.getText();
            filterTableData(searchQuery);
        }
    }
}

