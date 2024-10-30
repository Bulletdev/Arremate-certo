/*    */ package org.junit.c.e.c;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.junit.f.a.d;
/*    */ import org.junit.f.a.h;
/*    */ import org.junit.f.a.l;
/*    */ 
/*    */ 
/*    */ public class e
/*    */   extends l
/*    */ {
/*    */   private final l b;
/*    */   private final Object target;
/*    */   private final List<d> aH;
/*    */   
/*    */   public e(l paraml, List<d> paramList, Object paramObject) {
/* 18 */     this.b = paraml;
/* 19 */     this.aH = paramList;
/* 20 */     this.target = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public void io() throws Throwable {
/* 25 */     ArrayList<Throwable> arrayList = new ArrayList();
/*    */     try {
/* 27 */       this.b.io();
/* 28 */     } catch (Throwable throwable) {
/* 29 */       arrayList.add(throwable);
/*    */     } finally {
/* 31 */       for (d d : this.aH) {
/*    */         try {
/* 33 */           a(d);
/* 34 */         } catch (Throwable throwable) {
/* 35 */           arrayList.add(throwable);
/*    */         } 
/*    */       } 
/*    */     } 
/* 39 */     h.I(arrayList);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void a(d paramd) throws Throwable {
/* 46 */     paramd.c(this.target, new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\c\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */