/*    */ package org.junit.runner.b;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.junit.c.l;
/*    */ import org.junit.runner.c;
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
/*    */ public class a
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final c a;
/*    */   private final Throwable f;
/*    */   
/*    */   public a(c paramc, Throwable paramThrowable) {
/* 35 */     this.f = paramThrowable;
/* 36 */     this.a = paramc;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String fb() {
/* 43 */     return this.a.getDisplayName();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public c a() {
/* 50 */     return this.a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Throwable e() {
/* 58 */     return this.f;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return fb() + ": " + this.f.getMessage();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String fc() {
/* 70 */     return l.c(e());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String fd() {
/* 79 */     return l.d(e());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 88 */     return e().getMessage();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */