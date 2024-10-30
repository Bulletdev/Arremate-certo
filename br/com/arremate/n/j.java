/*    */ package br.com.arremate.n;
/*    */ import br.com.arremate.c.a.a;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Container;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JDialog;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.KeyStroke;
/*    */ 
/*    */ public class j extends JDialog {
/*    */   public j() {
/* 17 */     k();
/* 18 */     setLocationRelativeTo(null);
/* 19 */     this.aU.setText("VERSÃO 2.97.0");
/* 20 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/* 21 */     byte b = 2;
/* 22 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b);
/*    */   }
/*    */   
/*    */   private a a;
/*    */   private JLabel aU;
/*    */   
/*    */   private void k() {
/* 29 */     this.a = new a("/img/backgroundSobre.png");
/* 30 */     this.aU = new JLabel();
/*    */     
/* 32 */     setDefaultCloseOperation(2);
/* 33 */     setTitle("Effecti - Sobre");
/* 34 */     setIconImage((new ImageIcon(getClass().getResource("/img/icone.jpg"))).getImage());
/* 35 */     setResizable(false);
/*    */     
/* 37 */     this.a.setPreferredSize(new Dimension(1249, 652));
/*    */     
/* 39 */     this.aU.setFont(new Font("Tahoma", 1, 18));
/* 40 */     this.aU.setForeground(new Color(255, 255, 255));
/* 41 */     this.aU.setHorizontalAlignment(0);
/* 42 */     this.aU.setText("VERSÃO 2.52.0");
/*    */     
/* 44 */     GroupLayout groupLayout1 = new GroupLayout((Container)this.a);
/* 45 */     this.a.setLayout(groupLayout1);
/* 46 */     groupLayout1.setHorizontalGroup(groupLayout1
/* 47 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 48 */         .addComponent(this.aU, -2, 1249, -2));
/*    */     
/* 50 */     groupLayout1.setVerticalGroup(groupLayout1
/* 51 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 52 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout1.createSequentialGroup()
/* 53 */           .addContainerGap(505, 32767)
/* 54 */           .addComponent(this.aU)
/* 55 */           .addGap(125, 125, 125)));
/*    */ 
/*    */     
/* 58 */     GroupLayout groupLayout2 = new GroupLayout(getContentPane());
/* 59 */     getContentPane().setLayout(groupLayout2);
/* 60 */     groupLayout2.setHorizontalGroup(groupLayout2
/* 61 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 62 */         .addComponent((Component)this.a, -2, -1, -2));
/*    */     
/* 64 */     groupLayout2.setVerticalGroup(groupLayout2
/* 65 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 66 */         .addComponent((Component)this.a, -2, -1, -2));
/*    */ 
/*    */     
/* 69 */     pack();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */