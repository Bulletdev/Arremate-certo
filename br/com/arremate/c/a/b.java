/*    */ package br.com.arremate.c.a;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSpinner;
/*    */ import javax.swing.SpinnerNumberModel;
/*    */ import javax.swing.event.ChangeEvent;
/*    */ import javax.swing.event.ChangeListener;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ 
/*    */ public class b extends JPanel {
/*    */   private JLabel a;
/*    */   
/*    */   public b() {
/* 16 */     k();
/*    */   }
/*    */   private JSpinner a;
/*    */   public void i(int paramInt) {
/* 20 */     this.a.setValue(Integer.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   public void j(int paramInt) {
/* 24 */     ((SpinnerNumberModel)this.a.getModel()).setMinimum(Integer.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   public int h() {
/* 28 */     return ((Integer)this.a.getValue()).intValue();
/*    */   }
/*    */   
/*    */   public void a(ChangeListener paramChangeListener) {
/* 32 */     this.a.addChangeListener(paramChangeListener);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void k() {
/* 43 */     this.a = (JSpinner)new JLabel();
/* 44 */     this.a = new JSpinner();
/*    */     
/* 46 */     this.a.setText("0 Casa(s) = R$ 99.999,9999");
/*    */     
/* 48 */     this.a.setModel(new SpinnerNumberModel(0, 0, 8, 1));
/* 49 */     this.a.setEditor(new JSpinner.NumberEditor(this.a, ""));
/* 50 */     this.a.addChangeListener(new ChangeListener(this) {
/*    */           public void stateChanged(ChangeEvent param1ChangeEvent) {
/* 52 */             b.a(this.a, param1ChangeEvent);
/*    */           }
/*    */         });
/*    */     
/* 56 */     GroupLayout groupLayout = new GroupLayout(this);
/* 57 */     setLayout(groupLayout);
/* 58 */     groupLayout.setHorizontalGroup(groupLayout
/* 59 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 60 */         .addGroup(groupLayout.createSequentialGroup()
/* 61 */           .addComponent(this.a, -2, 37, -2)
/* 62 */           .addGap(4, 4, 4)
/* 63 */           .addComponent(this.a, -1, -1, 32767)));
/*    */     
/* 65 */     groupLayout.setVerticalGroup(groupLayout
/* 66 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 67 */         .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 68 */           .addComponent(this.a, -2, 14, -2)
/* 69 */           .addComponent(this.a, -2, -1, -2)));
/*    */   }
/*    */ 
/*    */   
/*    */   private void a(ChangeEvent paramChangeEvent) {
/* 74 */     int i = ((Integer)this.a.getValue()).intValue();
/*    */     
/* 76 */     if (i >= 0 && i <= 8) {
/* 77 */       String str = "999999999";
/* 78 */       str = str.substring(0, str.length() - i);
/* 79 */       str = StringUtils.rightPad(str, 9, "0");
/* 80 */       str = str.substring(0, 5) + "." + str.substring(5);
/*    */       
/* 82 */       DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/* 83 */       str = decimalFormat.format(Double.parseDouble(str));
/*    */       
/* 85 */       StringBuilder stringBuilder = new StringBuilder();
/* 86 */       stringBuilder.append(i);
/* 87 */       stringBuilder.append(" Casa(s) = R$ ").append(str);
/* 88 */       this.a.setText(stringBuilder.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\c\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */