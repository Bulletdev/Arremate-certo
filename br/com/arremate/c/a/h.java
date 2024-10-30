/*    */ package br.com.arremate.c.a;
/*    */ import java.awt.Dimension;
/*    */ import java.awt.event.MouseListener;
/*    */ import java.math.BigDecimal;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ 
/*    */ public class h extends JPanel {
/*    */   private final BigDecimal a;
/*    */   private final BigDecimal b;
/*    */   
/*    */   public h() {
/* 16 */     k();
/*    */     
/* 18 */     this.a = BigDecimal.ONE;
/* 19 */     this.b = BigDecimal.TEN;
/*    */   }
/*    */   private JCheckBox d; private JLabel n; private JSpinner d;
/*    */   public void c(BigDecimal paramBigDecimal) {
/* 23 */     if (paramBigDecimal.compareTo(this.a) == -1) {
/* 24 */       paramBigDecimal = this.a;
/* 25 */     } else if (paramBigDecimal.compareTo(this.b) == 1) {
/* 26 */       paramBigDecimal = this.b;
/*    */     } 
/*    */     
/* 29 */     this.d.setValue(paramBigDecimal);
/*    */   }
/*    */   
/*    */   public BigDecimal d() {
/* 33 */     BigDecimal bigDecimal = new BigDecimal(this.d.getValue().toString());
/*    */     
/* 35 */     if (bigDecimal.compareTo(this.a) == -1) {
/* 36 */       bigDecimal = this.a;
/* 37 */     } else if (bigDecimal.compareTo(this.b) == 1) {
/* 38 */       bigDecimal = this.b;
/*    */     } 
/*    */     
/* 41 */     return bigDecimal;
/*    */   }
/*    */   
/*    */   public boolean isSelected() {
/* 45 */     return this.d.isSelected();
/*    */   }
/*    */   
/*    */   public void setSelected(boolean paramBoolean) {
/* 49 */     this.d.setSelected(paramBoolean);
/*    */   }
/*    */   
/*    */   public void a(MouseListener paramMouseListener) {
/* 53 */     this.d.addMouseListener(paramMouseListener);
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
/* 65 */     this.d = new JSpinner();
/* 66 */     this.d = (JSpinner)new JCheckBox();
/* 67 */     this.n = new JLabel();
/*    */     
/* 69 */     this.d.setModel(new SpinnerNumberModel(Float.valueOf(1.0F), Float.valueOf(1.0F), Float.valueOf(10.0F), Float.valueOf(0.1F)));
/* 70 */     this.d.setEditor(new JSpinner.NumberEditor(this.d, "##.#"));
/* 71 */     this.d.setMaximumSize(new Dimension(45, 20));
/* 72 */     this.d.setMinimumSize(new Dimension(45, 20));
/* 73 */     this.d.setPreferredSize(new Dimension(45, 20));
/* 74 */     this.d.setRequestFocusEnabled(false);
/* 75 */     this.d.setValue(Double.valueOf(1.0D));
/*    */     
/* 77 */     this.d.setText("Ficar até");
/* 78 */     this.d.setPreferredSize(new Dimension(75, 20));
/*    */     
/* 80 */     this.n.setText("% do primeiro colocado");
/*    */     
/* 82 */     GroupLayout groupLayout = new GroupLayout(this);
/* 83 */     setLayout(groupLayout);
/* 84 */     groupLayout.setHorizontalGroup(groupLayout
/* 85 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 86 */         .addGroup(groupLayout.createSequentialGroup()
/* 87 */           .addComponent(this.d, -2, 75, -2)
/* 88 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 89 */           .addComponent(this.d, -2, 45, -2)
/* 90 */           .addGap(4, 4, 4)
/* 91 */           .addComponent(this.n)
/* 92 */           .addContainerGap(-1, 32767)));
/*    */     
/* 94 */     groupLayout.setVerticalGroup(groupLayout
/* 95 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 96 */         .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 97 */           .addComponent(this.d, -2, -1, -2)
/* 98 */           .addComponent(this.d, -2, -1, -2)
/* 99 */           .addComponent(this.n, -2, 20, -2)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */