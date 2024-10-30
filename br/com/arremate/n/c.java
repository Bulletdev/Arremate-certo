/*     */ package br.com.arremate.n;
/*     */ 
/*     */ import br.com.arremate.c.b;
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.m.m;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.plaf.basic.BasicComboPopup;
/*     */ 
/*     */ public class c
/*     */   extends JDialog {
/*  28 */   n a = n.a();
/*     */   
/*     */   private b b;
/*     */   
/*     */   private JLabel y;
/*     */ 
/*     */   
/*     */   public c() throws SQLException {
/*  36 */     k();
/*  37 */     f();
/*  38 */     pack();
/*  39 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void f() throws SQLException {
/*  49 */     StringBuilder stringBuilder = new StringBuilder();
/*  50 */     stringBuilder.append("SELECT L.EMPCNPJ, L.LICCODIGO, L.LICNUMERO, L.LICDATAABERTURA, L.LICDATAENCERRAMENTO,");
/*  51 */     stringBuilder.append(" L.LICUASG, L.LICSRP, L.LICOCULTA, L.LICHASH, L.LICUASGNOME, L.LICCRITERIO, L.PORCODIGO ");
/*  52 */     stringBuilder.append("FROM TBLICITACAO L ");
/*  53 */     stringBuilder.append("INNER JOIN TBEMPRESA E ON E.EMPCNPJ = L.EMPCNPJ AND E.PORCODIGO = L.PORCODIGO ");
/*  54 */     stringBuilder.append("ORDER BY L.LICCODIGO");
/*     */     
/*  56 */     try(Statement null = a.a().createStatement(); 
/*  57 */         ResultSet null = statement.executeQuery(stringBuilder.toString())) {
/*  58 */       while (resultSet.next()) {
/*  59 */         j j = m.a(resultSet.getLong("EMPCNPJ"), resultSet.getInt("LICCODIGO"), resultSet.getString("LICNUMERO"), resultSet
/*  60 */             .getInt("LICUASG"), resultSet.getString("LICUASGNOME"), resultSet.getBoolean("LICSRP"), resultSet.getBoolean("LICOCULTA"), resultSet.getTimestamp("LICDATAABERTURA"), resultSet
/*  61 */             .getInt("PORCODIGO"), resultSet.getString("LICCRITERIO"), resultSet.getString("LICHASH"), resultSet.getTimestamp("LICDATAENCERRAMENTO"));
/*     */         
/*  63 */         if (j != null) {
/*  64 */           this.b.addItem(j);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  70 */     this.b.a().setText("");
/*     */ 
/*     */     
/*  73 */     this.b.a().addKeyListener(new KeyAdapter(this)
/*     */         {
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/*  76 */             if (param1KeyEvent.getKeyCode() == 10) {
/*  77 */               c.a(this.a);
/*     */             }
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  83 */     BasicComboPopup basicComboPopup = (BasicComboPopup)this.b.getUI().getAccessibleChild((JComponent)this.b, 0);
/*  84 */     basicComboPopup.getList().addMouseListener(new MouseAdapter(this)
/*     */         {
/*     */           public void mouseReleased(MouseEvent param1MouseEvent) {
/*  87 */             c.a(this.a);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dh() {
/*  96 */     j j = (j)this.b.getSelectedItem();
/*     */ 
/*     */     
/*  99 */     if (!j.be()) {
/* 100 */       this.a.t(j);
/*     */     } else {
/* 102 */       this.a.b(j);
/*     */       
/* 104 */       JMenu jMenu = this.a.a();
/* 105 */       for (byte b1 = 0; b1 < jMenu.getItemCount(); b1++) {
/*     */         
/* 107 */         String str = jMenu.getItem(b1).getText().toLowerCase();
/* 108 */         if (str.contains(j.bf().toLowerCase()) && str
/* 109 */           .contains(y.k("##.###.###/####-##", String.valueOf(j.C())))) {
/* 110 */           jMenu.remove(jMenu.getItem(b1));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     j.a().m(j);
/* 116 */     dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/* 127 */     this.y = new JLabel();
/* 128 */     this.b = new b();
/*     */     
/* 130 */     setDefaultCloseOperation(2);
/* 131 */     setTitle("Effecti - Buscar Pregão");
/* 132 */     setIconImage(null);
/* 133 */     setIconImages(null);
/* 134 */     setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
/* 135 */     setResizable(false);
/*     */     
/* 137 */     this.y.setText("Digite o número do pregão");
/*     */     
/* 139 */     GroupLayout groupLayout = new GroupLayout(getContentPane());
/* 140 */     getContentPane().setLayout(groupLayout);
/* 141 */     groupLayout.setHorizontalGroup(groupLayout
/* 142 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 143 */         .addGroup(groupLayout.createSequentialGroup()
/* 144 */           .addContainerGap()
/* 145 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 146 */             .addGroup(groupLayout.createSequentialGroup()
/* 147 */               .addComponent(this.y)
/* 148 */               .addGap(0, 133, 32767))
/* 149 */             .addComponent((Component)this.b, -1, -1, 32767))
/* 150 */           .addContainerGap()));
/*     */     
/* 152 */     groupLayout.setVerticalGroup(groupLayout
/* 153 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 154 */         .addGroup(groupLayout.createSequentialGroup()
/* 155 */           .addContainerGap()
/* 156 */           .addComponent(this.y)
/* 157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 158 */           .addComponent((Component)this.b, -2, -1, -2)
/* 159 */           .addContainerGap(-1, 32767)));
/*     */ 
/*     */     
/* 162 */     pack();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */