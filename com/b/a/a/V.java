/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URI;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Collection;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ class v
/*     */ {
/*  40 */   private static final SecureRandom a = new SecureRandom();
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
/*     */   public static byte[] e(String paramString) {
/*  53 */     if (paramString == null)
/*     */     {
/*  55 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  60 */       return paramString.getBytes("UTF-8");
/*     */     }
/*  62 */     catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */ 
/*     */       
/*  65 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(byte[] paramArrayOfbyte) {
/*  75 */     if (paramArrayOfbyte == null)
/*     */     {
/*  77 */       return null;
/*     */     }
/*     */     
/*  80 */     return b(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  89 */     if (paramArrayOfbyte == null)
/*     */     {
/*  91 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  96 */       return new String(paramArrayOfbyte, paramInt1, paramInt2, "UTF-8");
/*     */     }
/*  98 */     catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */ 
/*     */       
/* 101 */       return null;
/*     */     }
/* 103 */     catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*     */       
/* 105 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] b(byte[] paramArrayOfbyte) {
/* 115 */     a.nextBytes(paramArrayOfbyte);
/*     */     
/* 117 */     return paramArrayOfbyte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] nextBytes(int paramInt) {
/* 126 */     byte[] arrayOfByte = new byte[paramInt];
/*     */     
/* 128 */     return b(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String r(int paramInt) {
/* 137 */     switch (paramInt) {
/*     */       
/*     */       case 0:
/* 140 */         return "CONTINUATION";
/*     */       
/*     */       case 1:
/* 143 */         return "TEXT";
/*     */       
/*     */       case 2:
/* 146 */         return "BINARY";
/*     */       
/*     */       case 8:
/* 149 */         return "CLOSE";
/*     */       
/*     */       case 9:
/* 152 */         return "PING";
/*     */       
/*     */       case 10:
/* 155 */         return "PONG";
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     if (1 <= paramInt && paramInt <= 7)
/*     */     {
/* 163 */       return String.format("DATA(0x%X)", new Object[] { Integer.valueOf(paramInt) });
/*     */     }
/*     */     
/* 166 */     if (8 <= paramInt && paramInt <= 15)
/*     */     {
/* 168 */       return String.format("CONTROL(0x%X)", new Object[] { Integer.valueOf(paramInt) });
/*     */     }
/*     */     
/* 171 */     return String.format("0x%X", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(InputStream paramInputStream, String paramString) throws IOException {
/* 180 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 185 */       int i = paramInputStream.read();
/*     */ 
/*     */       
/* 188 */       if (i == -1) {
/*     */         
/* 190 */         if (byteArrayOutputStream.size() == 0)
/*     */         {
/*     */           
/* 193 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */ 
/*     */       
/* 202 */       if (i == 10) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 208 */       if (i != 13) {
/*     */ 
/*     */         
/* 211 */         byteArrayOutputStream.write(i);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 216 */       int j = paramInputStream.read();
/*     */ 
/*     */       
/* 219 */       if (j == -1) {
/*     */ 
/*     */         
/* 222 */         byteArrayOutputStream.write(i);
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */ 
/*     */       
/* 229 */       if (j == 10) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 236 */       byteArrayOutputStream.write(i);
/*     */ 
/*     */       
/* 239 */       byteArrayOutputStream.write(j);
/*     */     } 
/*     */ 
/*     */     
/* 243 */     return byteArrayOutputStream.toString(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int min(int[] paramArrayOfint) {
/* 252 */     int i = Integer.MAX_VALUE;
/*     */     
/* 254 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       
/* 256 */       if (paramArrayOfint[b] < i)
/*     */       {
/* 258 */         i = paramArrayOfint[b];
/*     */       }
/*     */     } 
/*     */     
/* 262 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int max(int[] paramArrayOfint) {
/* 271 */     int i = Integer.MIN_VALUE;
/*     */     
/* 273 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       
/* 275 */       if (i < paramArrayOfint[b])
/*     */       {
/* 277 */         i = paramArrayOfint[b];
/*     */       }
/*     */     } 
/*     */     
/* 281 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String join(Collection<?> paramCollection, String paramString) {
/* 287 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 289 */     a(stringBuilder, paramCollection, paramString);
/*     */     
/* 291 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(StringBuilder paramStringBuilder, Collection<?> paramCollection, String paramString) {
/* 297 */     boolean bool = true;
/*     */     
/* 299 */     for (Object object : paramCollection) {
/*     */       
/* 301 */       if (bool) {
/*     */         
/* 303 */         bool = false;
/*     */       }
/*     */       else {
/*     */         
/* 307 */         paramStringBuilder.append(paramString);
/*     */       } 
/*     */       
/* 310 */       paramStringBuilder.append(object.toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(URI paramURI) {
/* 318 */     String str = paramURI.getHost();
/*     */     
/* 320 */     if (str != null)
/*     */     {
/* 322 */       return str;
/*     */     }
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
/* 335 */     str = az(paramURI.getRawAuthority());
/*     */     
/* 337 */     if (str != null)
/*     */     {
/* 339 */       return str;
/*     */     }
/*     */ 
/*     */     
/* 343 */     return aA(paramURI.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String az(String paramString) {
/* 350 */     if (paramString == null)
/*     */     {
/*     */       
/* 353 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 357 */     Matcher matcher = Pattern.compile("^(.*@)?([^:]+)(:\\d+)?$").matcher(paramString);
/*     */ 
/*     */     
/* 360 */     if (matcher == null || !matcher.matches())
/*     */     {
/*     */       
/* 363 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 367 */     return matcher.group(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String aA(String paramString) {
/* 373 */     if (paramString == null)
/*     */     {
/*     */       
/* 376 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 380 */     Matcher matcher = Pattern.compile("^\\w+://([^@/]*@)?([^:/]+)(:\\d+)?(/.*)?$").matcher(paramString);
/*     */ 
/*     */     
/* 383 */     if (matcher == null || !matcher.matches())
/*     */     {
/*     */       
/* 386 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 390 */     return matcher.group(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Constructor<?> a(String paramString, Class<?>[] paramArrayOfClass) {
/*     */     try {
/* 398 */       return Class.forName(paramString).getConstructor(paramArrayOfClass);
/*     */     }
/* 400 */     catch (Exception exception) {
/*     */       
/* 402 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object a(Constructor<?> paramConstructor, Object... paramVarArgs) {
/* 409 */     if (paramConstructor == null)
/*     */     {
/* 411 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 416 */       return paramConstructor.newInstance(paramVarArgs);
/*     */     }
/* 418 */     catch (Exception exception) {
/*     */       
/* 420 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Method getMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass) {
/*     */     try {
/* 429 */       return Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass);
/*     */     }
/* 431 */     catch (Exception exception) {
/*     */       
/* 433 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object c(Method paramMethod, Object paramObject, Object... paramVarArgs) {
/* 440 */     if (paramMethod == null)
/*     */     {
/* 442 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 447 */       return paramMethod.invoke(paramObject, paramVarArgs);
/*     */     }
/* 449 */     catch (Exception exception) {
/*     */       
/* 451 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\v.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */