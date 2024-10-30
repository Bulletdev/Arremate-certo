/*     */ package org.apache.http;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpException
/*     */   extends Exception
/*     */ {
/*     */   private static final int FIRST_VALID_CHAR = 32;
/*     */   private static final long serialVersionUID = -5437299376222011036L;
/*     */   
/*     */   static String clean(String paramString) {
/*  48 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     
/*     */     byte b;
/*  51 */     for (b = 0; b < arrayOfChar.length && 
/*  52 */       arrayOfChar[b] >= ' '; b++);
/*     */ 
/*     */ 
/*     */     
/*  56 */     if (b == arrayOfChar.length) {
/*  57 */       return paramString;
/*     */     }
/*  59 */     StringBuilder stringBuilder = new StringBuilder(arrayOfChar.length * 2);
/*  60 */     for (b = 0; b < arrayOfChar.length; b++) {
/*  61 */       char c = arrayOfChar[b];
/*  62 */       if (c < ' ') {
/*  63 */         stringBuilder.append("[0x");
/*  64 */         String str = Integer.toHexString(b);
/*  65 */         if (str.length() == 1) {
/*  66 */           stringBuilder.append("0");
/*     */         }
/*  68 */         stringBuilder.append(str);
/*  69 */         stringBuilder.append("]");
/*     */       } else {
/*  71 */         stringBuilder.append(c);
/*     */       } 
/*     */     } 
/*  74 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpException() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpException(String paramString) {
/*  91 */     super(clean(paramString));
/*     */   }
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
/*     */   public HttpException(String paramString, Throwable paramThrowable) {
/* 105 */     super(clean(paramString));
/* 106 */     initCause(paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */