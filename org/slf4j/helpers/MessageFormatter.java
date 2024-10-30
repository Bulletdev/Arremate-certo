/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class MessageFormatter
/*     */ {
/*     */   static final char DELIM_START = '{';
/*     */   static final char DELIM_STOP = '}';
/*     */   static final String DELIM_STR = "{}";
/*     */   private static final char ESCAPE_CHAR = '\\';
/*     */   
/*     */   public static final FormattingTuple format(String paramString, Object paramObject) {
/* 124 */     return arrayFormat(paramString, new Object[] { paramObject });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final FormattingTuple format(String paramString, Object paramObject1, Object paramObject2) {
/* 151 */     return arrayFormat(paramString, new Object[] { paramObject1, paramObject2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject) {
/* 156 */     Throwable throwable = getThrowableCandidate(paramArrayOfObject);
/* 157 */     Object[] arrayOfObject = paramArrayOfObject;
/* 158 */     if (throwable != null) {
/* 159 */       arrayOfObject = trimmedCopy(paramArrayOfObject);
/*     */     }
/* 161 */     return arrayFormat(paramString, arrayOfObject, throwable);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final FormattingTuple arrayFormat(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 166 */     if (paramString == null) {
/* 167 */       return new FormattingTuple(null, paramArrayOfObject, paramThrowable);
/*     */     }
/*     */     
/* 170 */     if (paramArrayOfObject == null) {
/* 171 */       return new FormattingTuple(paramString);
/*     */     }
/*     */     
/* 174 */     int i = 0;
/*     */ 
/*     */     
/* 177 */     StringBuilder stringBuilder = new StringBuilder(paramString.length() + 50);
/*     */ 
/*     */     
/* 180 */     for (byte b = 0; b < paramArrayOfObject.length; b++) {
/*     */       
/* 182 */       int j = paramString.indexOf("{}", i);
/*     */       
/* 184 */       if (j == -1) {
/*     */         
/* 186 */         if (!i) {
/* 187 */           return new FormattingTuple(paramString, paramArrayOfObject, paramThrowable);
/*     */         }
/*     */         
/* 190 */         stringBuilder.append(paramString, i, paramString.length());
/* 191 */         return new FormattingTuple(stringBuilder.toString(), paramArrayOfObject, paramThrowable);
/*     */       } 
/*     */       
/* 194 */       if (isEscapedDelimeter(paramString, j)) {
/* 195 */         if (!isDoubleEscaped(paramString, j)) {
/* 196 */           b--;
/* 197 */           stringBuilder.append(paramString, i, j - 1);
/* 198 */           stringBuilder.append('{');
/* 199 */           i = j + 1;
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 204 */           stringBuilder.append(paramString, i, j - 1);
/* 205 */           deeplyAppendParameter(stringBuilder, paramArrayOfObject[b], (Map)new HashMap<Object, Object>());
/* 206 */           i = j + 2;
/*     */         } 
/*     */       } else {
/*     */         
/* 210 */         stringBuilder.append(paramString, i, j);
/* 211 */         deeplyAppendParameter(stringBuilder, paramArrayOfObject[b], (Map)new HashMap<Object, Object>());
/* 212 */         i = j + 2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 217 */     stringBuilder.append(paramString, i, paramString.length());
/* 218 */     return new FormattingTuple(stringBuilder.toString(), paramArrayOfObject, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   static final boolean isEscapedDelimeter(String paramString, int paramInt) {
/* 223 */     if (paramInt == 0) {
/* 224 */       return false;
/*     */     }
/* 226 */     char c = paramString.charAt(paramInt - 1);
/* 227 */     if (c == '\\') {
/* 228 */       return true;
/*     */     }
/* 230 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static final boolean isDoubleEscaped(String paramString, int paramInt) {
/* 235 */     if (paramInt >= 2 && paramString.charAt(paramInt - 2) == '\\') {
/* 236 */       return true;
/*     */     }
/* 238 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void deeplyAppendParameter(StringBuilder paramStringBuilder, Object paramObject, Map<Object[], Object> paramMap) {
/* 244 */     if (paramObject == null) {
/* 245 */       paramStringBuilder.append("null");
/*     */       return;
/*     */     } 
/* 248 */     if (!paramObject.getClass().isArray()) {
/* 249 */       safeObjectAppend(paramStringBuilder, paramObject);
/*     */ 
/*     */     
/*     */     }
/* 253 */     else if (paramObject instanceof boolean[]) {
/* 254 */       booleanArrayAppend(paramStringBuilder, (boolean[])paramObject);
/* 255 */     } else if (paramObject instanceof byte[]) {
/* 256 */       byteArrayAppend(paramStringBuilder, (byte[])paramObject);
/* 257 */     } else if (paramObject instanceof char[]) {
/* 258 */       charArrayAppend(paramStringBuilder, (char[])paramObject);
/* 259 */     } else if (paramObject instanceof short[]) {
/* 260 */       shortArrayAppend(paramStringBuilder, (short[])paramObject);
/* 261 */     } else if (paramObject instanceof int[]) {
/* 262 */       intArrayAppend(paramStringBuilder, (int[])paramObject);
/* 263 */     } else if (paramObject instanceof long[]) {
/* 264 */       longArrayAppend(paramStringBuilder, (long[])paramObject);
/* 265 */     } else if (paramObject instanceof float[]) {
/* 266 */       floatArrayAppend(paramStringBuilder, (float[])paramObject);
/* 267 */     } else if (paramObject instanceof double[]) {
/* 268 */       doubleArrayAppend(paramStringBuilder, (double[])paramObject);
/*     */     } else {
/* 270 */       objectArrayAppend(paramStringBuilder, (Object[])paramObject, paramMap);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void safeObjectAppend(StringBuilder paramStringBuilder, Object paramObject) {
/*     */     try {
/* 277 */       String str = paramObject.toString();
/* 278 */       paramStringBuilder.append(str);
/* 279 */     } catch (Throwable throwable) {
/* 280 */       Util.report("SLF4J: Failed toString() invocation on an object of type [" + paramObject.getClass().getName() + "]", throwable);
/* 281 */       paramStringBuilder.append("[FAILED toString()]");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void objectArrayAppend(StringBuilder paramStringBuilder, Object[] paramArrayOfObject, Map<Object[], Object> paramMap) {
/* 287 */     paramStringBuilder.append('[');
/* 288 */     if (!paramMap.containsKey(paramArrayOfObject)) {
/* 289 */       paramMap.put(paramArrayOfObject, null);
/* 290 */       int i = paramArrayOfObject.length;
/* 291 */       for (byte b = 0; b < i; b++) {
/* 292 */         deeplyAppendParameter(paramStringBuilder, paramArrayOfObject[b], paramMap);
/* 293 */         if (b != i - 1) {
/* 294 */           paramStringBuilder.append(", ");
/*     */         }
/*     */       } 
/* 297 */       paramMap.remove(paramArrayOfObject);
/*     */     } else {
/* 299 */       paramStringBuilder.append("...");
/*     */     } 
/* 301 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void booleanArrayAppend(StringBuilder paramStringBuilder, boolean[] paramArrayOfboolean) {
/* 305 */     paramStringBuilder.append('[');
/* 306 */     int i = paramArrayOfboolean.length;
/* 307 */     for (byte b = 0; b < i; b++) {
/* 308 */       paramStringBuilder.append(paramArrayOfboolean[b]);
/* 309 */       if (b != i - 1)
/* 310 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 312 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void byteArrayAppend(StringBuilder paramStringBuilder, byte[] paramArrayOfbyte) {
/* 316 */     paramStringBuilder.append('[');
/* 317 */     int i = paramArrayOfbyte.length;
/* 318 */     for (byte b = 0; b < i; b++) {
/* 319 */       paramStringBuilder.append(paramArrayOfbyte[b]);
/* 320 */       if (b != i - 1)
/* 321 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 323 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void charArrayAppend(StringBuilder paramStringBuilder, char[] paramArrayOfchar) {
/* 327 */     paramStringBuilder.append('[');
/* 328 */     int i = paramArrayOfchar.length;
/* 329 */     for (byte b = 0; b < i; b++) {
/* 330 */       paramStringBuilder.append(paramArrayOfchar[b]);
/* 331 */       if (b != i - 1)
/* 332 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 334 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void shortArrayAppend(StringBuilder paramStringBuilder, short[] paramArrayOfshort) {
/* 338 */     paramStringBuilder.append('[');
/* 339 */     int i = paramArrayOfshort.length;
/* 340 */     for (byte b = 0; b < i; b++) {
/* 341 */       paramStringBuilder.append(paramArrayOfshort[b]);
/* 342 */       if (b != i - 1)
/* 343 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 345 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void intArrayAppend(StringBuilder paramStringBuilder, int[] paramArrayOfint) {
/* 349 */     paramStringBuilder.append('[');
/* 350 */     int i = paramArrayOfint.length;
/* 351 */     for (byte b = 0; b < i; b++) {
/* 352 */       paramStringBuilder.append(paramArrayOfint[b]);
/* 353 */       if (b != i - 1)
/* 354 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 356 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void longArrayAppend(StringBuilder paramStringBuilder, long[] paramArrayOflong) {
/* 360 */     paramStringBuilder.append('[');
/* 361 */     int i = paramArrayOflong.length;
/* 362 */     for (byte b = 0; b < i; b++) {
/* 363 */       paramStringBuilder.append(paramArrayOflong[b]);
/* 364 */       if (b != i - 1)
/* 365 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 367 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void floatArrayAppend(StringBuilder paramStringBuilder, float[] paramArrayOffloat) {
/* 371 */     paramStringBuilder.append('[');
/* 372 */     int i = paramArrayOffloat.length;
/* 373 */     for (byte b = 0; b < i; b++) {
/* 374 */       paramStringBuilder.append(paramArrayOffloat[b]);
/* 375 */       if (b != i - 1)
/* 376 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 378 */     paramStringBuilder.append(']');
/*     */   }
/*     */   
/*     */   private static void doubleArrayAppend(StringBuilder paramStringBuilder, double[] paramArrayOfdouble) {
/* 382 */     paramStringBuilder.append('[');
/* 383 */     int i = paramArrayOfdouble.length;
/* 384 */     for (byte b = 0; b < i; b++) {
/* 385 */       paramStringBuilder.append(paramArrayOfdouble[b]);
/* 386 */       if (b != i - 1)
/* 387 */         paramStringBuilder.append(", "); 
/*     */     } 
/* 389 */     paramStringBuilder.append(']');
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
/*     */   public static Throwable getThrowableCandidate(Object[] paramArrayOfObject) {
/* 401 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 402 */       return null;
/*     */     }
/*     */     
/* 405 */     Object object = paramArrayOfObject[paramArrayOfObject.length - 1];
/* 406 */     if (object instanceof Throwable) {
/* 407 */       return (Throwable)object;
/*     */     }
/*     */     
/* 410 */     return null;
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
/*     */   public static Object[] trimmedCopy(Object[] paramArrayOfObject) {
/* 422 */     if (paramArrayOfObject == null || paramArrayOfObject.length == 0) {
/* 423 */       throw new IllegalStateException("non-sensical empty or null argument array");
/*     */     }
/*     */     
/* 426 */     int i = paramArrayOfObject.length - 1;
/*     */     
/* 428 */     Object[] arrayOfObject = new Object[i];
/*     */     
/* 430 */     if (i > 0) {
/* 431 */       System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, i);
/*     */     }
/*     */     
/* 434 */     return arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\MessageFormatter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */