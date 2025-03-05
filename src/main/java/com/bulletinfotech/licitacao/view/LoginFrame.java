
package com.bulletinfotech.licitacao.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginFrame extends JFrame {

    private final JTextField txtCnpj;
    private final JPasswordField txtPassword;
    private final JComboBox<String> comboPortal;

    public LoginFrame() {
        setTitle("Login - Licitação");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("CNPJ:"));
        txtCnpj = new JTextField();
        panel.add(txtCnpj);

        panel.add(new JLabel("Senha:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        panel.add(new JLabel("Portal:"));
        comboPortal = new JComboBox<>(new String[]{"ComprasNet", "Licitações-e", "Compras Públicas"});
        panel.add(comboPortal);

        JButton btnImportCert = new JButton("Importar Certificado");
        panel.add(btnImportCert);

        JButton btnLogin = new JButton("Login");
        panel.add(btnLogin);

        add(panel, BorderLayout.CENTER);

        btnImportCert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement certificate import logic
                JOptionPane.showMessageDialog(null, "Função de Importar Certificado em desenvolvimento.");
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement login action to authenticate with selected portal
                String cnpj = txtCnpj.getText();
                char[] password = txtPassword.getPassword();
                String portal = Objects.requireNonNull(comboPortal.getSelectedItem()).toString();
                
                // Stub method call to AuthController for authentication
                // AuthController.authenticate(cnpj, new String(password), portal);
                JOptionPane.showMessageDialog(null, "Login em desenvolvimento.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
