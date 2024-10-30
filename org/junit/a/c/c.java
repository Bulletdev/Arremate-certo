/*    */ package org.junit.a.c;
/*    */ 
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.k;
/*    */ import org.d.p;
/*    */ import org.junit.runner.b.a;
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
/*    */ public class c
/*    */ {
/*    */   public static k<b> d() {
/* 31 */     return a(0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static k<b> a(int paramInt) {
/* 38 */     return (k<b>)new p<b>(paramInt) {
/*    */         public void a(g param1g) {
/* 40 */           param1g.a("has " + this.iP + " failures");
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean a(b param1b) {
/* 45 */           return (param1b.be() == this.iP);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static k<Object> e(String paramString) {
/* 54 */     return (k<Object>)new b<Object>(paramString) {
/*    */         public boolean E(Object param1Object) {
/* 56 */           return (param1Object.toString().contains(this.lR) && c.a(1).E(param1Object));
/*    */         }
/*    */         
/*    */         public void a(g param1g) {
/* 60 */           param1g.a("has single failure containing " + this.lR);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static k<b> e(k<Throwable> paramk) {
/* 71 */     return (k<b>)new p<b>(paramk)
/*    */       {
/*    */         public boolean a(b param1b) {
/* 74 */           return (param1b.be() == 1 && this.e.E(((a)param1b.bd().get(0)).e()));
/*    */         }
/*    */         
/*    */         public void a(g param1g) {
/* 78 */           param1g.a("has failure with exception matching ");
/* 79 */           this.e.a(param1g);
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static k<b> f(String paramString) {
/* 89 */     return (k<b>)new p<b>(paramString)
/*    */       {
/*    */         public boolean a(b param1b) {
/* 92 */           return (param1b.be() > 0 && param1b.toString().contains(this.lR));
/*    */         }
/*    */         
/*    */         public void a(g param1g) {
/* 96 */           param1g.a("has failure containing " + this.lR);
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\c\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */