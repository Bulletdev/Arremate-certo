/*    */ package org.passay;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ public final class z
/*    */ {
/*    */   public static String p(String paramString1, String paramString2) {
/* 29 */     return a(paramString1, paramString2, 2147483647);
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
/*    */   public static String a(String paramString1, String paramString2, int paramInt) {
/* 44 */     StringBuilder stringBuilder = new StringBuilder(paramString2.length());
/* 45 */     for (byte b = 0; b < paramString2.length(); b++) {
/* 46 */       char c = paramString2.charAt(b);
/* 47 */       if (paramString1.indexOf(c) != -1) {
/* 48 */         if (stringBuilder.length() < paramInt) {
/* 49 */           stringBuilder.append(c);
/*    */         } else {
/*    */           break;
/*    */         } 
/*    */       }
/*    */     } 
/* 55 */     return stringBuilder.toString();
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
/*    */   public static int d(String paramString1, String paramString2) {
/* 69 */     return (int)paramString2.chars().filter(paramInt -> (paramString.indexOf(paramInt) != -1)).count();
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
/*    */   public static char[] a(char[] paramArrayOfchar, char[]... paramVarArgs) {
/* 83 */     int i = paramArrayOfchar.length;
/* 84 */     for (char[] arrayOfChar1 : paramVarArgs) {
/* 85 */       if (arrayOfChar1 != null) {
/* 86 */         i += arrayOfChar1.length;
/*    */       }
/*    */     } 
/*    */     
/* 90 */     char[] arrayOfChar = Arrays.copyOf(paramArrayOfchar, i);
/*    */     
/* 92 */     int j = paramArrayOfchar.length;
/* 93 */     for (char[] arrayOfChar1 : paramVarArgs) {
/* 94 */       if (arrayOfChar1 != null) {
/* 95 */         System.arraycopy(arrayOfChar1, 0, arrayOfChar, j, arrayOfChar1.length);
/* 96 */         j += arrayOfChar1.length;
/*    */       } 
/*    */     } 
/* 99 */     return arrayOfChar;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */