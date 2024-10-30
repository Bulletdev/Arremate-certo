/*    */ package org.junit.g;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class b
/*    */ {
/* 11 */   private static final ConcurrentHashMap<f, a> a = new ConcurrentHashMap<f, a>();
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
/*    */   public a a(f paramf) {
/* 24 */     a a = a.get(paramf);
/* 25 */     if (a != null) {
/* 26 */       return a;
/*    */     }
/*    */     
/* 29 */     Class<? extends a> clazz = paramf.value();
/*    */     try {
/* 31 */       a a1 = clazz.newInstance();
/* 32 */       a.putIfAbsent(paramf, a1);
/* 33 */       return a.get(paramf);
/* 34 */     } catch (Exception exception) {
/* 35 */       throw new RuntimeException("Exception received when creating AnnotationValidator class " + clazz.getName(), exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\g\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */