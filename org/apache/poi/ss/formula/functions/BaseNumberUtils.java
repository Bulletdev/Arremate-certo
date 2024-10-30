/*    */ package org.apache.poi.ss.formula.functions;
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
/*    */ public class BaseNumberUtils
/*    */ {
/*    */   public static double convertToDecimal(String paramString, int paramInt1, int paramInt2) throws IllegalArgumentException {
/* 28 */     if (paramString == null || paramString.length() == 0) {
/* 29 */       return 0.0D;
/*    */     }
/*    */     
/* 32 */     long l1 = paramString.length();
/* 33 */     if (l1 > paramInt2) {
/* 34 */       throw new IllegalArgumentException();
/*    */     }
/*    */     
/* 37 */     double d = 0.0D;
/*    */     
/* 39 */     long l2 = 0L;
/* 40 */     boolean bool1 = true;
/* 41 */     char[] arrayOfChar = paramString.toCharArray();
/* 42 */     for (char c : arrayOfChar) {
/*    */       long l;
/*    */       
/* 45 */       if ('0' <= c && c <= '9') {
/* 46 */         l = (c - 48);
/* 47 */       } else if ('A' <= c && c <= 'Z') {
/* 48 */         l = (10 + c - 65);
/* 49 */       } else if ('a' <= c && c <= 'z') {
/* 50 */         l = (10 + c - 97);
/*    */       } else {
/* 52 */         l = paramInt1;
/*    */       } 
/*    */       
/* 55 */       if (l < paramInt1) {
/* 56 */         if (bool1) {
/* 57 */           bool1 = false;
/* 58 */           l2 = l;
/*    */         } 
/* 60 */         d = d * paramInt1 + l;
/*    */       } else {
/* 62 */         throw new IllegalArgumentException("character not allowed");
/*    */       } 
/*    */     } 
/*    */     
/* 66 */     boolean bool2 = (!bool1 && l1 == paramInt2 && l2 >= (paramInt1 / 2)) ? true : false;
/* 67 */     if (bool2) {
/* 68 */       d = getTwoComplement(paramInt1, paramInt2, d);
/* 69 */       d *= -1.0D;
/*    */     } 
/*    */     
/* 72 */     return d;
/*    */   }
/*    */   
/*    */   private static double getTwoComplement(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 76 */     return Math.pow(paramDouble1, paramDouble2) - paramDouble3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\BaseNumberUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */