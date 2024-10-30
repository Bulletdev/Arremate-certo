/*    */ package org.c.a.b.r;
/*    */ 
/*    */ import java.io.Closeable;
/*    */ import java.io.IOException;
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
/*    */ public class i
/*    */ {
/*    */   public static void close(Closeable paramCloseable) {
/* 32 */     if (paramCloseable == null) {
/*    */       return;
/*    */     }
/*    */     
/*    */     try {
/* 37 */       paramCloseable.close();
/* 38 */     } catch (IOException iOException) {}
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */