/*    */ package org.junit.e;
/*    */ 
/*    */ import org.junit.c.b;
/*    */ import org.junit.f.a.d;
/*    */ import org.junit.f.a.l;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class n
/*    */   implements f
/*    */ {
/*    */   public l a(l paraml, d paramd, Object paramObject) {
/* 48 */     return new l(this, paramd, paraml)
/*    */       {
/*    */         public void io() throws Throwable {
/* 51 */           this.a.c(this.b);
/*    */           try {
/* 53 */             this.d.io();
/* 54 */             this.a.b(this.b);
/* 55 */           } catch (b b) {
/* 56 */             throw b;
/* 57 */           } catch (Throwable throwable) {
/* 58 */             this.a.a(throwable, this.b);
/* 59 */             throw throwable;
/*    */           } finally {
/* 61 */             this.a.d(this.b);
/*    */           } 
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public void b(d paramd) {}
/*    */   
/*    */   public void a(Throwable paramThrowable, d paramd) {}
/*    */   
/*    */   public void c(d paramd) {}
/*    */   
/*    */   public void d(d paramd) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */