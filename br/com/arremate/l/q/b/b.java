/*    */ package br.com.arremate.l.q.b;
/*    */ 
/*    */ import javax.swing.RowFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */   extends a
/*    */ {
/*    */   public boolean include(RowFilter.Entry<? extends i, ? extends Integer> paramEntry) {
/* 11 */     e e = ((i)paramEntry.getModel()).b(((Integer)paramEntry.getIdentifier()).intValue());
/* 12 */     return e.bp();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\q\b\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */