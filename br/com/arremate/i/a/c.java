/*    */ package br.com.arremate.i.a;
/*    */ 
/*    */ import br.com.arremate.i.b;
/*    */ import br.com.arremate.m.y;
/*    */ import java.util.Date;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */   implements b
/*    */ {
/*    */   public Object transformValue(Object paramObject, int paramInt1, int paramInt2, TableModel paramTableModel) {
/* 16 */     if (paramObject != null) {
/* 17 */       if (paramObject instanceof Long) {
/* 18 */         paramObject = y.formatDate(new Date(((Long)paramObject).longValue()));
/* 19 */       } else if (paramObject instanceof Date) {
/* 20 */         paramObject = y.formatDate((Date)paramObject);
/*    */       } 
/*    */     }
/*    */     
/* 24 */     return paramObject;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\i\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */