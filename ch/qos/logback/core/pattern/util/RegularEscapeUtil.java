/*    */ package ch.qos.logback.core.pattern.util;
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
/*    */ public class RegularEscapeUtil
/*    */   implements IEscapeUtil
/*    */ {
/*    */   public void escape(String paramString, StringBuffer paramStringBuffer, char paramChar, int paramInt) {
/* 24 */     if (paramString.indexOf(paramChar) >= 0) {
/* 25 */       paramStringBuffer.append(paramChar);
/*    */     }
/* 27 */     switch (paramChar) {
/*    */       case '_':
/*    */         return;
/*    */       
/*    */       case '\\':
/* 32 */         paramStringBuffer.append(paramChar);
/*    */       
/*    */       case 't':
/* 35 */         paramStringBuffer.append('\t');
/*    */       
/*    */       case 'r':
/* 38 */         paramStringBuffer.append('\r');
/*    */       
/*    */       case 'n':
/* 41 */         paramStringBuffer.append('\n');
/*    */     } 
/*    */     
/* 44 */     String str = formatEscapeCharsForListing(paramString);
/* 45 */     throw new IllegalArgumentException("Illegal char '" + paramChar + " at column " + paramInt + ". Only \\\\, \\_" + str + ", \\t, \\n, \\r combinations are allowed as escape characters.");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   String formatEscapeCharsForListing(String paramString) {
/* 51 */     StringBuilder stringBuilder = new StringBuilder();
/* 52 */     for (byte b = 0; b < paramString.length(); b++) {
/* 53 */       stringBuilder.append(", \\").append(paramString.charAt(b));
/*    */     }
/* 55 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public static String basicEscape(String paramString) {
/* 60 */     int i = paramString.length();
/* 61 */     StringBuilder stringBuilder = new StringBuilder(i);
/*    */     
/* 63 */     byte b = 0;
/* 64 */     while (b < i) {
/* 65 */       char c = paramString.charAt(b++);
/* 66 */       if (c == '\\') {
/* 67 */         c = paramString.charAt(b++);
/* 68 */         if (c == 'n') {
/* 69 */           c = '\n';
/* 70 */         } else if (c == 'r') {
/* 71 */           c = '\r';
/* 72 */         } else if (c == 't') {
/* 73 */           c = '\t';
/* 74 */         } else if (c == 'f') {
/* 75 */           c = '\f';
/* 76 */         } else if (c == '\b') {
/* 77 */           c = '\b';
/* 78 */         } else if (c == '"') {
/* 79 */           c = '"';
/* 80 */         } else if (c == '\'') {
/* 81 */           c = '\'';
/* 82 */         } else if (c == '\\') {
/* 83 */           c = '\\';
/*    */         } 
/*    */       } 
/* 86 */       stringBuilder.append(c);
/*    */     } 
/* 88 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\patter\\util\RegularEscapeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */