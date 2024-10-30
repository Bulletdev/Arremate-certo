/*    */ package org.apache.commons.lang3.reflect;
/*    */ 
/*    */ import org.apache.commons.lang3.BooleanUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InheritanceUtils
/*    */ {
/*    */   public static int distance(Class<?> paramClass1, Class<?> paramClass2) {
/* 50 */     if (paramClass1 == null || paramClass2 == null) {
/* 51 */       return -1;
/*    */     }
/*    */     
/* 54 */     if (paramClass1.equals(paramClass2)) {
/* 55 */       return 0;
/*    */     }
/*    */     
/* 58 */     Class<?> clazz = paramClass1.getSuperclass();
/* 59 */     int i = BooleanUtils.toInteger(paramClass2.equals(clazz));
/*    */     
/* 61 */     if (i == 1) {
/* 62 */       return i;
/*    */     }
/* 64 */     i += distance(clazz, paramClass2);
/* 65 */     return (i > 0) ? (i + 1) : -1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\InheritanceUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */