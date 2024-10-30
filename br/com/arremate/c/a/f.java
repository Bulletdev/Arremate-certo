/*    */ package br.com.arremate.c.a;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ import javax.swing.SpinnerNumberModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ 
/*    */ public class f extends JPanel {
/*    */   private static final int v = 30;
/*    */   private int w;
/*    */   private JLabel a;
/*    */   private JSpinner c;
/*    */   
/*    */   public f() {
/* 19 */     k();
/* 20 */     this.w = 0;
/*    */   }
/*    */   
/*    */   public void a(long paramLong) {
/* 24 */     this
/* 25 */       .w = (int)((paramLong > 0L) ? TimeUnit.MILLISECONDS.toSeconds(paramLong) : 0L);
/*    */ 
/*    */     
/* 28 */     this.c.setValue(Integer.valueOf(this.w));
/* 29 */     this.c.setModel(new SpinnerNumberModel(this.w, this.w, 30, 1));
/*    */   }
/*    */   
/*    */   public void b(long paramLong) {
/* 33 */     if (paramLong >= this.w) {
/*    */       
/* 35 */       int i = (int)((paramLong > 0L) ? TimeUnit.MILLISECONDS.toSeconds(paramLong) : 0L);
/*    */       
/* 37 */       this.c.setValue(Integer.valueOf(i));
/*    */     } 
/*    */   }
/*    */   
/*    */   public long a() {
/* 42 */     int i = ((Integer)this.c.getValue()).intValue();
/*    */     
/* 44 */     if (i < this.w) {
/* 45 */       i = this.w;
/* 46 */     } else if (i > 30) {
/* 47 */       i = 30;
/*    */     } 
/*    */     
/* 50 */     return TimeUnit.SECONDS.toMillis(Integer.toUnsignedLong(i));
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
/*    */   
/*    */   private void k() {
/* 63 */     this.a = new JLabel();
/* 64 */     this.c = new JSpinner();
/*    */     
/* 66 */     this.a.setText(" Segundos");
/*    */     
/* 68 */     this.c.setModel(new SpinnerNumberModel(0, 0, 30, 1));
/* 69 */     this.c.setEditor(new JSpinner.NumberEditor(this.c, ""));
/* 70 */     this.c.addChangeListener(new ChangeListener(this) {
/*    */           public void stateChanged(ChangeEvent param1ChangeEvent) {
/* 72 */             f.a(this.b, param1ChangeEvent);
/*    */           }
/*    */         });
/*    */     
/* 76 */     GroupLayout groupLayout = new GroupLayout(this);
/* 77 */     setLayout(groupLayout);
/* 78 */     groupLayout.setHorizontalGroup(groupLayout
/* 79 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 80 */         .addGroup(groupLayout.createSequentialGroup()
/* 81 */           .addComponent(this.c, -2, 37, -2)
/* 82 */           .addGap(4, 4, 4)
/* 83 */           .addComponent(this.a, -1, -1, 32767)));
/*    */     
/* 85 */     groupLayout.setVerticalGroup(groupLayout
/* 86 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 87 */         .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 88 */           .addComponent(this.a, -2, 14, -2)
/* 89 */           .addComponent(this.c, -2, -1, -2)));
/*    */   }
/*    */   
/*    */   private void c(ChangeEvent paramChangeEvent) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */