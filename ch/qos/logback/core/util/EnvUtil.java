/*    */ package ch.qos.logback.core.util;
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
/*    */ public class EnvUtil
/*    */ {
/*    */   private static boolean isJDK_N_OrHigher(int paramInt) {
/* 25 */     String str = System.getProperty("java.version", "");
/* 26 */     if (str.isEmpty()) {
/* 27 */       return false;
/*    */     }
/* 29 */     int i = getJDKVersion(str);
/* 30 */     return (i > 0 && paramInt <= i);
/*    */   }
/*    */   
/*    */   public static int getJDKVersion(String paramString) {
/* 34 */     int i = 0;
/*    */     
/* 36 */     for (char c : paramString.toCharArray()) {
/* 37 */       if (Character.isDigit(c)) {
/* 38 */         i = i * 10 + c - 48;
/* 39 */       } else if (i == 1) {
/* 40 */         i = 0;
/*    */       } else {
/*    */         break;
/*    */       } 
/*    */     } 
/* 45 */     return i;
/*    */   }
/*    */   
/*    */   public static boolean isJDK5() {
/* 49 */     return isJDK_N_OrHigher(5);
/*    */   }
/*    */   
/*    */   public static boolean isJDK6OrHigher() {
/* 53 */     return isJDK_N_OrHigher(6);
/*    */   }
/*    */   
/*    */   public static boolean isJDK7OrHigher() {
/* 57 */     return isJDK_N_OrHigher(7);
/*    */   }
/*    */   
/*    */   public static boolean isJDK9OrHigher() {
/* 61 */     return isJDK_N_OrHigher(9);
/*    */   }
/*    */   
/*    */   public static boolean isJaninoAvailable() {
/* 65 */     ClassLoader classLoader = EnvUtil.class.getClassLoader();
/*    */     try {
/* 67 */       Class<?> clazz = classLoader.loadClass("org.codehaus.janino.ScriptEvaluator");
/* 68 */       return (clazz != null);
/* 69 */     } catch (ClassNotFoundException classNotFoundException) {
/* 70 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static boolean isWindows() {
/* 75 */     String str = System.getProperty("os.name");
/* 76 */     return str.startsWith("Windows");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\EnvUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */