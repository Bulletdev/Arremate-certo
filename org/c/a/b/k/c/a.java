/*    */ package org.c.a.b.k.c;
/*    */ 
/*    */ import org.c.a.a.f.a;
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
/*    */ public class a
/*    */   implements a
/*    */ {
/*    */   private final a a;
/*    */   
/*    */   public enum a
/*    */   {
/* 25 */     b, c, d;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public a(a parama) {
/* 36 */     this.a = parama;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDebugEnabled() {
/* 41 */     return (this.a == a.b);
/*    */   }
/*    */   
/*    */   public void debug(String paramString) {
/* 45 */     if (isDebugEnabled()) {
/* 46 */       System.out.println("DEBUG: " + paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public void info(String paramString) {
/* 51 */     if (this.a.compareTo(a.c) <= 0) {
/* 52 */       System.out.println(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public void warn(String paramString) {
/* 57 */     System.out.println("WARNING: " + paramString);
/*    */   }
/*    */   
/*    */   public void error(String paramString) {
/* 61 */     System.err.println("ERROR: " + paramString);
/*    */   }
/*    */   
/*    */   public void a(String paramString, Exception paramException) {
/* 65 */     System.err.println("ERROR: " + paramString);
/* 66 */     paramException.printStackTrace(System.err);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\k\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */