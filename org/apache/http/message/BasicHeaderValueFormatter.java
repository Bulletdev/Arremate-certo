/*     */ package org.apache.http.message;
/*     */ 
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicHeaderValueFormatter
/*     */   implements HeaderValueFormatter
/*     */ {
/*     */   @Deprecated
/*  56 */   public static final BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
/*     */   
/*  58 */   public static final BasicHeaderValueFormatter INSTANCE = new BasicHeaderValueFormatter();
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
/*     */   public static final String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
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
/*     */   public static final String UNSAFE_CHARS = "\"\\";
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
/*     */   public static String formatElements(HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter) {
/*  92 */     return ((paramHeaderValueFormatter != null) ? paramHeaderValueFormatter : INSTANCE).formatElements(null, paramArrayOfHeaderElement, paramBoolean).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatElements(CharArrayBuffer paramCharArrayBuffer, HeaderElement[] paramArrayOfHeaderElement, boolean paramBoolean) {
/* 102 */     Args.notNull(paramArrayOfHeaderElement, "Header element array");
/* 103 */     int i = estimateElementsLen(paramArrayOfHeaderElement);
/* 104 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/* 105 */     if (charArrayBuffer == null) {
/* 106 */       charArrayBuffer = new CharArrayBuffer(i);
/*     */     } else {
/* 108 */       charArrayBuffer.ensureCapacity(i);
/*     */     } 
/*     */     
/* 111 */     for (byte b = 0; b < paramArrayOfHeaderElement.length; b++) {
/* 112 */       if (b > 0) {
/* 113 */         charArrayBuffer.append(", ");
/*     */       }
/* 115 */       formatHeaderElement(charArrayBuffer, paramArrayOfHeaderElement[b], paramBoolean);
/*     */     } 
/*     */     
/* 118 */     return charArrayBuffer;
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
/*     */   protected int estimateElementsLen(HeaderElement[] paramArrayOfHeaderElement) {
/* 130 */     if (paramArrayOfHeaderElement == null || paramArrayOfHeaderElement.length < 1) {
/* 131 */       return 0;
/*     */     }
/*     */     
/* 134 */     int i = (paramArrayOfHeaderElement.length - 1) * 2;
/* 135 */     for (HeaderElement headerElement : paramArrayOfHeaderElement) {
/* 136 */       i += estimateHeaderElementLen(headerElement);
/*     */     }
/*     */     
/* 139 */     return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatHeaderElement(HeaderElement paramHeaderElement, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter) {
/* 159 */     return ((paramHeaderValueFormatter != null) ? paramHeaderValueFormatter : INSTANCE).formatHeaderElement(null, paramHeaderElement, paramBoolean).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatHeaderElement(CharArrayBuffer paramCharArrayBuffer, HeaderElement paramHeaderElement, boolean paramBoolean) {
/* 169 */     Args.notNull(paramHeaderElement, "Header element");
/* 170 */     int i = estimateHeaderElementLen(paramHeaderElement);
/* 171 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/* 172 */     if (charArrayBuffer == null) {
/* 173 */       charArrayBuffer = new CharArrayBuffer(i);
/*     */     } else {
/* 175 */       charArrayBuffer.ensureCapacity(i);
/*     */     } 
/*     */     
/* 178 */     charArrayBuffer.append(paramHeaderElement.getName());
/* 179 */     String str = paramHeaderElement.getValue();
/* 180 */     if (str != null) {
/* 181 */       charArrayBuffer.append('=');
/* 182 */       doFormatValue(charArrayBuffer, str, paramBoolean);
/*     */     } 
/*     */     
/* 185 */     int j = paramHeaderElement.getParameterCount();
/* 186 */     if (j > 0) {
/* 187 */       for (byte b = 0; b < j; b++) {
/* 188 */         charArrayBuffer.append("; ");
/* 189 */         formatNameValuePair(charArrayBuffer, paramHeaderElement.getParameter(b), paramBoolean);
/*     */       } 
/*     */     }
/*     */     
/* 193 */     return charArrayBuffer;
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
/*     */   protected int estimateHeaderElementLen(HeaderElement paramHeaderElement) {
/* 205 */     if (paramHeaderElement == null) {
/* 206 */       return 0;
/*     */     }
/*     */     
/* 209 */     int i = paramHeaderElement.getName().length();
/* 210 */     String str = paramHeaderElement.getValue();
/* 211 */     if (str != null)
/*     */     {
/* 213 */       i += 3 + str.length();
/*     */     }
/*     */     
/* 216 */     int j = paramHeaderElement.getParameterCount();
/* 217 */     if (j > 0) {
/* 218 */       for (byte b = 0; b < j; b++) {
/* 219 */         i += 2 + estimateNameValuePairLen(paramHeaderElement.getParameter(b));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 224 */     return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatParameters(NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter) {
/* 245 */     return ((paramHeaderValueFormatter != null) ? paramHeaderValueFormatter : INSTANCE).formatParameters(null, paramArrayOfNameValuePair, paramBoolean).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatParameters(CharArrayBuffer paramCharArrayBuffer, NameValuePair[] paramArrayOfNameValuePair, boolean paramBoolean) {
/* 255 */     Args.notNull(paramArrayOfNameValuePair, "Header parameter array");
/* 256 */     int i = estimateParametersLen(paramArrayOfNameValuePair);
/* 257 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/* 258 */     if (charArrayBuffer == null) {
/* 259 */       charArrayBuffer = new CharArrayBuffer(i);
/*     */     } else {
/* 261 */       charArrayBuffer.ensureCapacity(i);
/*     */     } 
/*     */     
/* 264 */     for (byte b = 0; b < paramArrayOfNameValuePair.length; b++) {
/* 265 */       if (b > 0) {
/* 266 */         charArrayBuffer.append("; ");
/*     */       }
/* 268 */       formatNameValuePair(charArrayBuffer, paramArrayOfNameValuePair[b], paramBoolean);
/*     */     } 
/*     */     
/* 271 */     return charArrayBuffer;
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
/*     */   protected int estimateParametersLen(NameValuePair[] paramArrayOfNameValuePair) {
/* 283 */     if (paramArrayOfNameValuePair == null || paramArrayOfNameValuePair.length < 1) {
/* 284 */       return 0;
/*     */     }
/*     */     
/* 287 */     int i = (paramArrayOfNameValuePair.length - 1) * 2;
/* 288 */     for (NameValuePair nameValuePair : paramArrayOfNameValuePair) {
/* 289 */       i += estimateNameValuePairLen(nameValuePair);
/*     */     }
/*     */     
/* 292 */     return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatNameValuePair(NameValuePair paramNameValuePair, boolean paramBoolean, HeaderValueFormatter paramHeaderValueFormatter) {
/* 311 */     return ((paramHeaderValueFormatter != null) ? paramHeaderValueFormatter : INSTANCE).formatNameValuePair(null, paramNameValuePair, paramBoolean).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharArrayBuffer formatNameValuePair(CharArrayBuffer paramCharArrayBuffer, NameValuePair paramNameValuePair, boolean paramBoolean) {
/* 321 */     Args.notNull(paramNameValuePair, "Name / value pair");
/* 322 */     int i = estimateNameValuePairLen(paramNameValuePair);
/* 323 */     CharArrayBuffer charArrayBuffer = paramCharArrayBuffer;
/* 324 */     if (charArrayBuffer == null) {
/* 325 */       charArrayBuffer = new CharArrayBuffer(i);
/*     */     } else {
/* 327 */       charArrayBuffer.ensureCapacity(i);
/*     */     } 
/*     */     
/* 330 */     charArrayBuffer.append(paramNameValuePair.getName());
/* 331 */     String str = paramNameValuePair.getValue();
/* 332 */     if (str != null) {
/* 333 */       charArrayBuffer.append('=');
/* 334 */       doFormatValue(charArrayBuffer, str, paramBoolean);
/*     */     } 
/*     */     
/* 337 */     return charArrayBuffer;
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
/*     */   protected int estimateNameValuePairLen(NameValuePair paramNameValuePair) {
/* 349 */     if (paramNameValuePair == null) {
/* 350 */       return 0;
/*     */     }
/*     */     
/* 353 */     int i = paramNameValuePair.getName().length();
/* 354 */     String str = paramNameValuePair.getValue();
/* 355 */     if (str != null)
/*     */     {
/* 357 */       i += 3 + str.length();
/*     */     }
/* 359 */     return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doFormatValue(CharArrayBuffer paramCharArrayBuffer, String paramString, boolean paramBoolean) {
/* 377 */     boolean bool = paramBoolean;
/* 378 */     if (!bool) {
/* 379 */       for (byte b1 = 0; b1 < paramString.length() && !bool; b1++) {
/* 380 */         bool = isSeparator(paramString.charAt(b1));
/*     */       }
/*     */     }
/*     */     
/* 384 */     if (bool) {
/* 385 */       paramCharArrayBuffer.append('"');
/*     */     }
/* 387 */     for (byte b = 0; b < paramString.length(); b++) {
/* 388 */       char c = paramString.charAt(b);
/* 389 */       if (isUnsafe(c)) {
/* 390 */         paramCharArrayBuffer.append('\\');
/*     */       }
/* 392 */       paramCharArrayBuffer.append(c);
/*     */     } 
/* 394 */     if (bool) {
/* 395 */       paramCharArrayBuffer.append('"');
/*     */     }
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
/*     */   protected boolean isSeparator(char paramChar) {
/* 409 */     return (" ;,:@()<>\\\"/[]?={}\t".indexOf(paramChar) >= 0);
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
/*     */   protected boolean isUnsafe(char paramChar) {
/* 422 */     return ("\"\\".indexOf(paramChar) >= 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHeaderValueFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */