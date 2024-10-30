/*    */ package org.junit.c.e.c;
/*    */ 
/*    */ import org.junit.c.b;
/*    */ import org.junit.f.a.l;
/*    */ 
/*    */ public class a extends l {
/*    */   private final l b;
/*    */   private final Class<? extends Throwable> p;
/*    */   
/*    */   public a(l paraml, Class<? extends Throwable> paramClass) {
/* 11 */     this.b = paraml;
/* 12 */     this.p = paramClass;
/*    */   }
/*    */ 
/*    */   
/*    */   public void io() throws Exception {
/* 17 */     boolean bool = false;
/*    */     try {
/* 19 */       this.b.io();
/* 20 */       bool = true;
/* 21 */     } catch (b b) {
/* 22 */       if (!this.p.isAssignableFrom(b.getClass())) {
/* 23 */         throw b;
/*    */       }
/* 25 */     } catch (Throwable throwable) {
/* 26 */       if (!this.p.isAssignableFrom(throwable.getClass())) {
/* 27 */         String str = "Unexpected exception, expected<" + this.p.getName() + "> but was<" + throwable.getClass().getName() + ">";
/*    */ 
/*    */         
/* 30 */         throw new Exception(str, throwable);
/*    */       } 
/*    */     } 
/* 33 */     if (bool)
/* 34 */       throw new AssertionError("Expected exception: " + this.p.getName()); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\c\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */