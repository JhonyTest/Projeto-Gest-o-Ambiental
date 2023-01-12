
package View;


public class FrMenuPrincipal extends javax.swing.JFrame {

    public FrMenuPrincipal() {
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoginEmpresa = new javax.swing.JButton();
        lblMenuPrincipal = new javax.swing.JLabel();
        btnLoginFiscal = new javax.swing.JButton();
        lblMenuPrincipal1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLoginEmpresa.setText("Empresa");
        btnLoginEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEmpresa(evt);
            }
        });

        lblMenuPrincipal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal.setText("Tipo de Usuário");

        btnLoginFiscal.setText("Fiscal");
        btnLoginFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginFiscal(evt);
            }
        });

        lblMenuPrincipal1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblMenuPrincipal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuPrincipal1.setText("Sistema Gestão Ambiental");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLoginFiscal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLoginEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblMenuPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblMenuPrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMenuPrincipal)
                .addGap(31, 31, 31)
                .addComponent(btnLoginFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnLoginEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginEmpresa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEmpresa
        FrLoginEmpresa janela = new FrLoginEmpresa();
        janela.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginEmpresa

    private void btnLoginFiscal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginFiscal
        FrLoginFiscal janela = new FrLoginFiscal();
        janela.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginFiscal

   
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginEmpresa;
    private javax.swing.JButton btnLoginFiscal;
    private javax.swing.JLabel lblMenuPrincipal;
    private javax.swing.JLabel lblMenuPrincipal1;
    // End of variables declaration//GEN-END:variables
}
