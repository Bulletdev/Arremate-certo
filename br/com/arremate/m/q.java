/*    */ package br.com.arremate.m;
/*    */ 
/*    */ import br.com.arremate.l.q.b.i;
/*    */ import java.awt.Component;
/*    */ import java.text.DecimalFormat;
/*    */ import java.text.NumberFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.ParsePosition;
/*    */ import java.util.Locale;
/*    */ import javax.swing.DefaultCellEditor;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.text.DefaultFormatterFactory;
/*    */ import javax.swing.text.NumberFormatter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class q
/*    */   extends DefaultCellEditor
/*    */ {
/* 20 */   private final Locale locale = Locale.getDefault();
/*    */   
/*    */   public q() {
/* 23 */     super(new f());
/*    */   }
/*    */ 
/*    */   
/*    */   public Component getTableCellEditorComponent(JTable paramJTable, Object paramObject, boolean paramBoolean, int paramInt1, int paramInt2) {
/* 28 */     f f = (f)super.getTableCellEditorComponent(paramJTable, paramObject, paramBoolean, paramInt1, paramInt2);
/*    */     
/* 30 */     if (paramObject instanceof Number) {
/* 31 */       int i = ((i)paramJTable.getModel()).b(paramInt1).b().E();
/* 32 */       if (i > 4) {
/* 33 */         i = 4;
/*    */       }
/*    */       
/* 36 */       int j = 4 - i;
/*    */       
/* 38 */       DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(this.locale);
/* 39 */       decimalFormat.setMaximumFractionDigits(j);
/* 40 */       decimalFormat.setMinimumFractionDigits(j);
/* 41 */       decimalFormat.setMinimumIntegerDigits(1);
/*    */       
/* 43 */       f.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(decimalFormat)));
/* 44 */       f.setHorizontalAlignment(4);
/* 45 */       f.aq(j);
/* 46 */       f.setValue(paramObject);
/*    */     } 
/*    */     
/* 49 */     return f;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean stopCellEditing() {
/*    */     try {
/* 55 */       getCellEditorValue();
/* 56 */       return super.stopCellEditing();
/* 57 */     } catch (Exception exception) {
/* 58 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getCellEditorValue() {
/* 64 */     String str = (String)super.getCellEditorValue();
/*    */     
/* 66 */     if (str == null || str.length() == 0) {
/* 67 */       return null;
/*    */     }
/*    */     
/*    */     try {
/* 71 */       ParsePosition parsePosition = new ParsePosition(0);
/* 72 */       Number number = NumberFormat.getInstance().parse(str, parsePosition);
/*    */       
/* 74 */       if (parsePosition.getIndex() != str.length()) {
/* 75 */         throw new ParseException("parsing incomplete", parsePosition.getIndex());
/*    */       }
/*    */       
/* 78 */       return Double.valueOf(number.doubleValue());
/* 79 */     } catch (ParseException parseException) {
/* 80 */       throw new RuntimeException(parseException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */