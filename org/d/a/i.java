/*    */ package org.d.a;
/*    */ 
/*    */ import java.lang.reflect.Array;
/*    */ import org.d.b;
/*    */ import org.d.g;
/*    */ import org.d.k;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class i<T>
/*    */   extends b<T>
/*    */ {
/*    */   private final Object aB;
/*    */   
/*    */   public i(T paramT) {
/* 21 */     this.aB = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean E(Object paramObject) {
/* 26 */     return k(paramObject, this.aB);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 31 */     paramg.a(this.aB);
/*    */   }
/*    */   
/*    */   private static boolean k(Object paramObject1, Object paramObject2) {
/* 35 */     if (paramObject1 == null) {
/* 36 */       return (paramObject2 == null);
/*    */     }
/*    */     
/* 39 */     if (paramObject2 != null && isArray(paramObject1)) {
/* 40 */       return (isArray(paramObject2) && l(paramObject1, paramObject2));
/*    */     }
/*    */     
/* 43 */     return paramObject1.equals(paramObject2);
/*    */   }
/*    */   
/*    */   private static boolean l(Object paramObject1, Object paramObject2) {
/* 47 */     return (m(paramObject1, paramObject2) && n(paramObject1, paramObject2));
/*    */   }
/*    */   
/*    */   private static boolean m(Object paramObject1, Object paramObject2) {
/* 51 */     return (Array.getLength(paramObject1) == Array.getLength(paramObject2));
/*    */   }
/*    */   
/*    */   private static boolean n(Object paramObject1, Object paramObject2) {
/* 55 */     for (byte b1 = 0; b1 < Array.getLength(paramObject1); b1++) {
/* 56 */       if (!k(Array.get(paramObject1, b1), Array.get(paramObject2, b1))) {
/* 57 */         return false;
/*    */       }
/*    */     } 
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private static boolean isArray(Object paramObject) {
/* 64 */     return paramObject.getClass().isArray();
/*    */   }
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
/*    */   @org.d.i
/*    */   public static <T> k<T> c(T paramT) {
/* 92 */     return (k<T>)new i<T>(paramT);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */