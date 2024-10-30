/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Util
/*     */ {
/*     */   private static a SECURITY_MANAGER;
/*     */   
/*     */   public static String safeGetSystemProperty(String paramString) {
/*  40 */     if (paramString == null) {
/*  41 */       throw new IllegalArgumentException("null input");
/*     */     }
/*  43 */     String str = null;
/*     */     try {
/*  45 */       str = System.getProperty(paramString);
/*  46 */     } catch (SecurityException securityException) {}
/*     */ 
/*     */     
/*  49 */     return str;
/*     */   }
/*     */   
/*     */   public static boolean safeGetBooleanSystemProperty(String paramString) {
/*  53 */     String str = safeGetSystemProperty(paramString);
/*  54 */     if (str == null) {
/*  55 */       return false;
/*     */     }
/*  57 */     return str.equalsIgnoreCase("true");
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class a
/*     */     extends SecurityManager
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     protected Class<?>[] getClassContext() {
/*  67 */       return super.getClassContext();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;
/*     */   
/*     */   private static a getSecurityManager() {
/*  75 */     if (SECURITY_MANAGER != null)
/*  76 */       return SECURITY_MANAGER; 
/*  77 */     if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
/*  78 */       return null;
/*     */     }
/*  80 */     SECURITY_MANAGER = safeCreateSecurityManager();
/*  81 */     SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
/*  82 */     return SECURITY_MANAGER;
/*     */   }
/*     */ 
/*     */   
/*     */   private static a safeCreateSecurityManager() {
/*     */     try {
/*  88 */       return new a();
/*  89 */     } catch (SecurityException securityException) {
/*  90 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getCallingClass() {
/* 100 */     a a1 = getSecurityManager();
/* 101 */     if (a1 == null)
/* 102 */       return null; 
/* 103 */     Class[] arrayOfClass = a1.getClassContext();
/* 104 */     String str = Util.class.getName();
/*     */     
/*     */     byte b;
/*     */     
/* 108 */     for (b = 0; b < arrayOfClass.length && 
/* 109 */       !str.equals(arrayOfClass[b].getName()); b++);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (b >= arrayOfClass.length || b + 2 >= arrayOfClass.length) {
/* 115 */       throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
/*     */     }
/*     */     
/* 118 */     return arrayOfClass[b + 2];
/*     */   }
/*     */   
/*     */   public static final void report(String paramString, Throwable paramThrowable) {
/* 122 */     System.err.println(paramString);
/* 123 */     System.err.println("Reported exception:");
/* 124 */     paramThrowable.printStackTrace();
/*     */   }
/*     */   
/*     */   public static final void report(String paramString) {
/* 128 */     System.err.println("SLF4J: " + paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\Util.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */