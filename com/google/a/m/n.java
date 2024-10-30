/*    */ package com.google.a.m;
/*    */ 
/*    */ import com.google.a.a.b;
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
/*    */ @b
/*    */ final class n
/*    */ {
/*    */   final String iQ;
/*    */   final int gm;
/*    */   
/*    */   private n(String paramString, int paramInt) {
/* 26 */     this.iQ = paramString;
/* 27 */     this.gm = paramInt;
/*    */   } static n a(String paramString) {
/*    */     String str;
/*    */     byte b;
/* 31 */     if (paramString.length() == 0) {
/* 32 */       throw new NumberFormatException("empty string");
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 38 */     char c = paramString.charAt(0);
/* 39 */     if (paramString.startsWith("0x") || paramString.startsWith("0X")) {
/* 40 */       str = paramString.substring(2);
/* 41 */       b = 16;
/* 42 */     } else if (c == '#') {
/* 43 */       str = paramString.substring(1);
/* 44 */       b = 16;
/* 45 */     } else if (c == '0' && paramString.length() > 1) {
/* 46 */       str = paramString.substring(1);
/* 47 */       b = 8;
/*    */     } else {
/* 49 */       str = paramString;
/* 50 */       b = 10;
/*    */     } 
/*    */     
/* 53 */     return new n(str, b);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */