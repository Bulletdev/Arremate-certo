/*    */ package br.com.arremate.c.a;
/*    */ import java.awt.Dimension;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JSpinner;
/*    */ 
/*    */ public class e extends JPanel {
/*    */   private final int t;
/*    */   private final int u;
/*    */   
/*    */   public e() {
/* 13 */     k();
/*    */     
/* 15 */     this.t = 4;
/* 16 */     this.u = 10;
/*    */   }
/*    */   private JCheckBox d; private JLabel n; private JSpinner b;
/*    */   public void l(int paramInt) {
/* 20 */     if (paramInt < this.t) {
/* 21 */       paramInt = this.t;
/* 22 */     } else if (paramInt > this.u) {
/* 23 */       paramInt = this.u;
/*    */     } 
/*    */     
/* 26 */     this.b.setValue(Integer.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   public int j() {
/* 30 */     int i = ((Integer)this.b.getValue()).intValue();
/*    */     
/* 32 */     if (i < this.t) {
/* 33 */       i = this.t;
/* 34 */     } else if (i > this.u) {
/* 35 */       i = this.u;
/*    */     } 
/*    */     
/* 38 */     return i;
/*    */   }
/*    */   
/*    */   public boolean isSelected() {
/* 42 */     return this.d.isSelected();
/*    */   }
/*    */   
/*    */   public void setSelected(boolean paramBoolean) {
/* 46 */     this.d.setSelected(paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void k() {
/* 58 */     this.b = new JSpinner();
/* 59 */     this.d = new JCheckBox();
/* 60 */     this.n = new JLabel();
/*    */     
/* 62 */     this.b.setModel(new SpinnerNumberModel(4, 4, 10, 1));
/* 63 */     this.b.setEditor(new JSpinner.NumberEditor(this.b, ""));
/* 64 */     this.b.setMaximumSize(new Dimension(45, 20));
/* 65 */     this.b.setMinimumSize(new Dimension(45, 20));
/* 66 */     this.b.setPreferredSize(new Dimension(45, 20));
/* 67 */     this.b.setRequestFocusEnabled(false);
/* 68 */     this.b.setValue(Double.valueOf(1.0D));
/*    */     
/* 70 */     this.d.setText("Excluir o");
/* 71 */     this.d.setPreferredSize(new Dimension(75, 20));
/*    */     
/* 73 */     this.n.setText("º colocado");
/*    */     
/* 75 */     GroupLayout groupLayout = new GroupLayout(this);
/* 76 */     setLayout(groupLayout);
/* 77 */     groupLayout.setHorizontalGroup(groupLayout
/* 78 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 79 */         .addGroup(groupLayout.createSequentialGroup()
/* 80 */           .addComponent(this.d, -2, 75, -2)
/* 81 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 82 */           .addComponent(this.b, -2, 45, -2)
/* 83 */           .addGap(4, 4, 4)
/* 84 */           .addComponent(this.n)
/* 85 */           .addContainerGap(-1, 32767)));
/*    */     
/* 87 */     groupLayout.setVerticalGroup(groupLayout
/* 88 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 89 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 90 */           .addComponent(this.b, -2, -1, -2)
/* 91 */           .addComponent(this.d, -2, -1, -2)
/* 92 */           .addComponent(this.n, -2, 20, -2)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */