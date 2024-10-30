/*    */ package org.junit.runner;
/*    */ 
/*    */ import org.junit.runner.a.b;
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
/*    */ class d
/*    */ {
/*    */   public static b a(j paramj, String paramString) throws e.a {
/*    */     String[] arrayOfString;
/* 23 */     c c = paramj.a().a();
/*    */ 
/*    */     
/* 26 */     if (paramString.contains("=")) {
/* 27 */       arrayOfString = paramString.split("=", 2);
/*    */     } else {
/* 29 */       arrayOfString = new String[] { paramString, "" };
/*    */     } 
/*    */     
/* 32 */     return a(arrayOfString[0], new f(c, arrayOfString[1]));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static b a(String paramString, f paramf) throws e.a {
/* 43 */     e e = a(paramString);
/*    */     
/* 45 */     return e.a(paramf);
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
/*    */   public static b a(Class<? extends e> paramClass, f paramf) throws e.a {
/* 57 */     e e = a(paramClass);
/*    */     
/* 59 */     return e.a(paramf);
/*    */   }
/*    */ 
/*    */   
/*    */   static e a(String paramString) throws e.a {
/*    */     Class<? extends e> clazz;
/*    */     try {
/* 66 */       clazz = org.junit.c.d.getClass(paramString).asSubclass(e.class);
/* 67 */     } catch (Exception exception) {
/* 68 */       throw new e.a(exception);
/*    */     } 
/*    */     
/* 71 */     return a(clazz);
/*    */   }
/*    */ 
/*    */   
/*    */   static e a(Class<? extends e> paramClass) throws e.a {
/*    */     try {
/* 77 */       return paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
/* 78 */     } catch (Exception exception) {
/* 79 */       throw new e.a(exception);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */