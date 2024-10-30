/*    */ package org.junit.c.e.c;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.junit.f.a.d;
/*    */ import org.junit.f.a.l;
/*    */ 
/*    */ 
/*    */ public class f
/*    */   extends l
/*    */ {
/*    */   private final l b;
/*    */   private final Object target;
/*    */   private final List<d> aI;
/*    */   
/*    */   public f(l paraml, List<d> paramList, Object paramObject) {
/* 16 */     this.b = paraml;
/* 17 */     this.aI = paramList;
/* 18 */     this.target = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public void io() throws Throwable {
/* 23 */     for (d d : this.aI) {
/* 24 */       a(d);
/*    */     }
/* 26 */     this.b.io();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void a(d paramd) throws Throwable {
/* 33 */     paramd.c(this.target, new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\c\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */