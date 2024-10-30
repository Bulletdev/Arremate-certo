/*     */ package org.apache.xmlbeans.impl.util;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
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
/*     */ public final class HexBin
/*     */ {
/*     */   private static final int BASELENGTH = 255;
/*     */   private static final int LOOKUPLENGTH = 16;
/*  29 */   private static byte[] hexNumberTable = new byte[255];
/*  30 */   private static byte[] lookUpHexAlphabet = new byte[16];
/*     */   
/*     */   static {
/*     */     byte b;
/*  34 */     for (b = 0; b < 'ÿ'; b++) {
/*  35 */       hexNumberTable[b] = -1;
/*     */     }
/*  37 */     for (b = 57; b >= 48; b--) {
/*  38 */       hexNumberTable[b] = (byte)(b - 48);
/*     */     }
/*  40 */     for (b = 70; b >= 65; b--) {
/*  41 */       hexNumberTable[b] = (byte)(b - 65 + 10);
/*     */     }
/*  43 */     for (b = 102; b >= 97; b--) {
/*  44 */       hexNumberTable[b] = (byte)(b - 97 + 10);
/*     */     }
/*     */     
/*  47 */     for (b = 0; b < 10; b++)
/*  48 */       lookUpHexAlphabet[b] = (byte)(48 + b); 
/*  49 */     for (b = 10; b <= 15; b++) {
/*  50 */       lookUpHexAlphabet[b] = (byte)(65 + b - 10);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isHex(byte paramByte) {
/*  60 */     return (hexNumberTable[paramByte] != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String bytesToString(byte[] paramArrayOfbyte) {
/*  68 */     if (paramArrayOfbyte == null)
/*  69 */       return null; 
/*  70 */     return new String(encode(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] stringToBytes(String paramString) {
/*  78 */     return decode(paramString.getBytes());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encode(byte[] paramArrayOfbyte) {
/*  88 */     if (paramArrayOfbyte == null)
/*  89 */       return null; 
/*  90 */     int i = paramArrayOfbyte.length;
/*  91 */     int j = i * 2;
/*  92 */     byte[] arrayOfByte = new byte[j];
/*  93 */     for (byte b = 0; b < i; b++) {
/*  94 */       arrayOfByte[b * 2] = lookUpHexAlphabet[paramArrayOfbyte[b] >> 4 & 0xF];
/*  95 */       arrayOfByte[b * 2 + 1] = lookUpHexAlphabet[paramArrayOfbyte[b] & 0xF];
/*     */     } 
/*  97 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public static byte[] decode(byte[] paramArrayOfbyte) {
/* 101 */     if (paramArrayOfbyte == null)
/* 102 */       return null; 
/* 103 */     int i = paramArrayOfbyte.length;
/* 104 */     if (i % 2 != 0) {
/* 105 */       return null;
/*     */     }
/* 107 */     int j = i / 2;
/* 108 */     byte[] arrayOfByte = new byte[j];
/* 109 */     for (byte b = 0; b < j; b++) {
/* 110 */       if (!isHex(paramArrayOfbyte[b * 2]) || !isHex(paramArrayOfbyte[b * 2 + 1])) {
/* 111 */         return null;
/*     */       }
/* 113 */       arrayOfByte[b] = (byte)(hexNumberTable[paramArrayOfbyte[b * 2]] << 4 | hexNumberTable[paramArrayOfbyte[b * 2 + 1]]);
/*     */     } 
/* 115 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String decode(String paramString) {
/* 125 */     if (paramString == null) {
/* 126 */       return null;
/*     */     }
/* 128 */     byte[] arrayOfByte = null;
/*     */     try {
/* 130 */       arrayOfByte = decode(paramString.getBytes("utf-8"));
/*     */     }
/* 132 */     catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */     
/* 134 */     return (arrayOfByte == null) ? null : new String(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encode(String paramString) {
/* 144 */     if (paramString == null) {
/* 145 */       return null;
/*     */     }
/* 147 */     byte[] arrayOfByte = null;
/*     */     try {
/* 149 */       arrayOfByte = encode(paramString.getBytes("utf-8"));
/*     */     }
/* 151 */     catch (UnsupportedEncodingException unsupportedEncodingException) {}
/* 152 */     return (arrayOfByte == null) ? null : new String(arrayOfByte);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\imp\\util\HexBin.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */