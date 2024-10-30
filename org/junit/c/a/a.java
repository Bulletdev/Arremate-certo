/*    */ package org.junit.c.a;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.junit.f.a.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends j
/*    */ {
/*    */   private final boolean dk;
/*    */   
/*    */   public a() {
/* 16 */     this.dk = true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public a(boolean paramBoolean) {
/* 24 */     this.dk = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public m a(Class<?> paramClass) throws Throwable {
/* 29 */     List<j> list = Arrays.asList(new j[] { a(), a(), a(), a(), a() });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     for (j j1 : list) {
/* 37 */       m m = j1.b(paramClass);
/* 38 */       if (m != null) {
/* 39 */         return m;
/*    */       }
/*    */     } 
/* 42 */     return null;
/*    */   }
/*    */   
/*    */   protected f a() {
/* 46 */     return new f();
/*    */   }
/*    */   
/*    */   protected e a() {
/* 50 */     return new e();
/*    */   }
/*    */   
/*    */   protected b a() {
/* 54 */     return new b(this);
/*    */   }
/*    */   
/*    */   protected c a() {
/* 58 */     return new c();
/*    */   }
/*    */   
/*    */   protected j a() {
/* 62 */     if (this.dk) {
/* 63 */       return new h();
/*    */     }
/* 65 */     return new g();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */