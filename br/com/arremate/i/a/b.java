/*    */ package br.com.arremate.i.a;
/*    */ 
/*    */ import br.com.arremate.f.r;
/*    */ import br.com.arremate.i.b;
/*    */ import javax.swing.table.TableModel;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   implements b
/*    */ {
/*    */   public Object transformValue(Object paramObject, int paramInt1, int paramInt2, TableModel paramTableModel) {
/* 16 */     if (paramObject != null && paramObject instanceof r) {
/* 17 */       r r = (r)paramObject;
/*    */       
/* 19 */       switch (null.i[r.ordinal()]) {
/*    */         case 1:
/* 21 */           return "/img/pause.png";
/*    */         case 2:
/* 23 */           return "/img/play.png";
/*    */       } 
/*    */     
/*    */     } 
/* 27 */     return "/img/transparent.png";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\i\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */