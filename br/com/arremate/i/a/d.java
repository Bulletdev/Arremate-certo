/*    */ package br.com.arremate.i.a;
/*    */ 
/*    */ import br.com.arremate.f.v;
/*    */ import br.com.arremate.i.b;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import br.com.arremate.l.q.b.i;
/*    */ import br.com.arremate.m.y;
/*    */ import java.text.DecimalFormat;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   implements b
/*    */ {
/*    */   public Object transformValue(Object paramObject, int paramInt1, int paramInt2, TableModel paramTableModel) {
/* 19 */     if (paramObject instanceof Double) {
/* 20 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 21 */       paramObject = decimalFormat.format(((Double)paramObject).doubleValue());
/* 22 */     } else if (paramObject instanceof Float) {
/* 23 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 24 */       paramObject = decimalFormat.format(((Float)paramObject).floatValue());
/*    */     } 
/*    */     
/* 27 */     if (paramObject != null && !String.valueOf(paramObject).isEmpty() && paramTableModel != null && paramTableModel instanceof i) {
/* 28 */       i i = (i)paramTableModel;
/* 29 */       e e = i.b(paramInt1);
/*    */       
/* 31 */       if (e.w() == v.b.v()) {
/* 32 */         String str = String.valueOf(paramObject);
/* 33 */         paramObject = str + "%";
/*    */       } 
/*    */     } 
/*    */     
/* 37 */     return paramObject;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\i\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */