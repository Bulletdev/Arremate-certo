/*    */ package org.d;
/*    */ 
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ public class n
/*    */   extends a
/*    */ {
/*    */   private final Appendable d;
/*    */   
/*    */   public n() {
/* 12 */     this(new StringBuilder());
/*    */   }
/*    */   
/*    */   public n(Appendable paramAppendable) {
/* 16 */     this.d = paramAppendable;
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
/*    */   public static String a(m paramm) {
/* 28 */     return (new n()).a(paramm).toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String b(m paramm) {
/* 35 */     return a(paramm);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void append(String paramString) {
/*    */     try {
/* 41 */       this.d.append(paramString);
/* 42 */     } catch (IOException iOException) {
/* 43 */       throw new RuntimeException("Could not write description", iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void append(char paramChar) {
/*    */     try {
/* 50 */       this.d.append(paramChar);
/* 51 */     } catch (IOException iOException) {
/* 52 */       throw new RuntimeException("Could not write description", iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 61 */     return this.d.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */