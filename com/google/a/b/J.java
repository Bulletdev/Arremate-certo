/*    */ package com.google.a.b;
/*    */ 
/*    */ import com.google.a.a.c;
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
/*    */ @c
/*    */ public final class j
/*    */ {
/* 32 */   private static final Double h = Double.valueOf(0.0D);
/* 33 */   private static final Float a = Float.valueOf(0.0F);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <T> T a(Class<T> paramClass) {
/* 42 */     D.checkNotNull(paramClass);
/* 43 */     if (paramClass == boolean.class)
/* 44 */       return (T)Boolean.FALSE; 
/* 45 */     if (paramClass == char.class)
/* 46 */       return (T)Character.valueOf(false); 
/* 47 */     if (paramClass == byte.class)
/* 48 */       return (T)Byte.valueOf((byte)0); 
/* 49 */     if (paramClass == short.class)
/* 50 */       return (T)Short.valueOf((short)0); 
/* 51 */     if (paramClass == int.class)
/* 52 */       return (T)Integer.valueOf(0); 
/* 53 */     if (paramClass == long.class)
/* 54 */       return (T)Long.valueOf(0L); 
/* 55 */     if (paramClass == float.class)
/* 56 */       return (T)a; 
/* 57 */     if (paramClass == double.class) {
/* 58 */       return (T)h;
/*    */     }
/* 60 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */