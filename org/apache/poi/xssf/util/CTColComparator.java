/*    */ package org.apache.poi.xssf.util;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
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
/*    */ 
/*    */ public class CTColComparator
/*    */ {
/* 28 */   public static final Comparator<CTCol> BY_MAX = new Comparator<CTCol>()
/*    */     {
/*    */       public int compare(CTCol param1CTCol1, CTCol param1CTCol2) {
/* 31 */         long l1 = param1CTCol1.getMax();
/* 32 */         long l2 = param1CTCol2.getMax();
/* 33 */         return (l1 < l2) ? -1 : ((l1 > l2) ? 1 : 0);
/*    */       }
/*    */     };
/*    */   
/* 37 */   public static final Comparator<CTCol> BY_MIN_MAX = new Comparator<CTCol>()
/*    */     {
/*    */       public int compare(CTCol param1CTCol1, CTCol param1CTCol2) {
/* 40 */         long l1 = param1CTCol1.getMin();
/* 41 */         long l2 = param1CTCol2.getMin();
/* 42 */         return (l1 < l2) ? -1 : ((l1 > l2) ? 1 : CTColComparator.BY_MAX.compare(param1CTCol1, param1CTCol2));
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\util\CTColComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */