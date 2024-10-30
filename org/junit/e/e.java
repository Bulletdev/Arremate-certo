/*    */ package org.junit.e;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.junit.f.a.h;
/*    */ import org.junit.f.a.l;
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
/*    */ public abstract class e
/*    */   implements l
/*    */ {
/*    */   public l a(l paraml, c paramc) {
/* 43 */     return a(paraml);
/*    */   }
/*    */   
/*    */   private l a(l paraml) {
/* 47 */     return new l(this, paraml)
/*    */       {
/*    */         public void io() throws Throwable {
/* 50 */           this.a.iH();
/*    */           
/* 52 */           ArrayList<Throwable> arrayList = new ArrayList();
/*    */           try {
/* 54 */             this.d.io();
/* 55 */           } catch (Throwable throwable) {
/* 56 */             arrayList.add(throwable);
/*    */           } finally {
/*    */             try {
/* 59 */               this.a.iI();
/* 60 */             } catch (Throwable throwable) {
/* 61 */               arrayList.add(throwable);
/*    */             } 
/*    */           } 
/* 64 */           h.I(arrayList);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   protected void iH() throws Throwable {}
/*    */   
/*    */   protected void iI() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */