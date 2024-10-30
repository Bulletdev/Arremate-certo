/*    */ package com.google.gson.internal;
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
/*    */ public final class JavaVersion
/*    */ {
/* 26 */   private static final int majorJavaVersion = determineMajorJavaVersion();
/*    */   
/*    */   private static int determineMajorJavaVersion() {
/* 29 */     String str = System.getProperty("java.version");
/* 30 */     return getMajorJavaVersion(str);
/*    */   }
/*    */ 
/*    */   
/*    */   static int getMajorJavaVersion(String paramString) {
/* 35 */     int i = parseDotted(paramString);
/* 36 */     if (i == -1) {
/* 37 */       i = extractBeginningInt(paramString);
/*    */     }
/* 39 */     if (i == -1) {
/* 40 */       return 6;
/*    */     }
/* 42 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   private static int parseDotted(String paramString) {
/*    */     try {
/* 48 */       String[] arrayOfString = paramString.split("[._]");
/* 49 */       int i = Integer.parseInt(arrayOfString[0]);
/* 50 */       if (i == 1 && arrayOfString.length > 1) {
/* 51 */         return Integer.parseInt(arrayOfString[1]);
/*    */       }
/* 53 */       return i;
/*    */     }
/* 55 */     catch (NumberFormatException numberFormatException) {
/* 56 */       return -1;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static int extractBeginningInt(String paramString) {
/*    */     try {
/* 62 */       StringBuilder stringBuilder = new StringBuilder();
/* 63 */       for (byte b = 0; b < paramString.length(); ) {
/* 64 */         char c = paramString.charAt(b);
/* 65 */         if (Character.isDigit(c)) {
/* 66 */           stringBuilder.append(c);
/*    */           
/*    */           b++;
/*    */         } 
/*    */       } 
/* 71 */       return Integer.parseInt(stringBuilder.toString());
/* 72 */     } catch (NumberFormatException numberFormatException) {
/* 73 */       return -1;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int getMajorJavaVersion() {
/* 81 */     return majorJavaVersion;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isJava9OrLater() {
/* 88 */     return (majorJavaVersion >= 9);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\JavaVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */