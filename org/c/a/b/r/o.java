/*    */ package org.c.a.b.r;
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
/*    */ public class o
/*    */ {
/*    */   public static String format(long paramLong) {
/* 36 */     return String.format("%02d:%02d.%03ds", new Object[] { Long.valueOf(paramLong / 60000L), Long.valueOf(paramLong % 60000L / 1000L), Long.valueOf(paramLong % 1000L) });
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */