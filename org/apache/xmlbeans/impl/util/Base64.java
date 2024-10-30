/*     */ package org.apache.xmlbeans.impl.util;
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
/*     */ public final class Base64
/*     */ {
/*     */   private static final int BASELENGTH = 255;
/*     */   private static final int LOOKUPLENGTH = 64;
/*     */   private static final int TWENTYFOURBITGROUP = 24;
/*     */   private static final int EIGHTBIT = 8;
/*     */   private static final int SIXTEENBIT = 16;
/*     */   private static final int FOURBYTE = 4;
/*     */   private static final int SIGN = -128;
/*     */   private static final byte PAD = 61;
/*     */   private static final boolean fDebug = false;
/*  47 */   private static byte[] base64Alphabet = new byte[255];
/*  48 */   private static byte[] lookUpBase64Alphabet = new byte[64];
/*     */   
/*     */   static {
/*     */     byte b1;
/*  52 */     for (b1 = 0; b1 < 'ÿ'; b1++) {
/*  53 */       base64Alphabet[b1] = -1;
/*     */     }
/*  55 */     for (b1 = 90; b1 >= 65; b1--) {
/*  56 */       base64Alphabet[b1] = (byte)(b1 - 65);
/*     */     }
/*  58 */     for (b1 = 122; b1 >= 97; b1--) {
/*  59 */       base64Alphabet[b1] = (byte)(b1 - 97 + 26);
/*     */     }
/*     */     
/*  62 */     for (b1 = 57; b1 >= 48; b1--) {
/*  63 */       base64Alphabet[b1] = (byte)(b1 - 48 + 52);
/*     */     }
/*     */     
/*  66 */     base64Alphabet[43] = 62;
/*  67 */     base64Alphabet[47] = 63;
/*     */     
/*  69 */     for (b1 = 0; b1 <= 25; b1++)
/*  70 */       lookUpBase64Alphabet[b1] = (byte)(65 + b1); 
/*     */     byte b2;
/*  72 */     for (b1 = 26, b2 = 0; b1 <= 51; b1++, b2++) {
/*  73 */       lookUpBase64Alphabet[b1] = (byte)(97 + b2);
/*     */     }
/*  75 */     for (b1 = 52, b2 = 0; b1 <= 61; b1++, b2++)
/*  76 */       lookUpBase64Alphabet[b1] = (byte)(48 + b2); 
/*  77 */     lookUpBase64Alphabet[62] = 43;
/*  78 */     lookUpBase64Alphabet[63] = 47;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static boolean isWhiteSpace(byte paramByte) {
/*  83 */     return (paramByte == 32 || paramByte == 13 || paramByte == 10 || paramByte == 9);
/*     */   }
/*     */   
/*     */   protected static boolean isPad(byte paramByte) {
/*  87 */     return (paramByte == 61);
/*     */   }
/*     */   
/*     */   protected static boolean isData(byte paramByte) {
/*  91 */     return (base64Alphabet[paramByte] != -1);
/*     */   }
/*     */   
/*     */   protected static boolean isBase64(byte paramByte) {
/*  95 */     return (isWhiteSpace(paramByte) || isPad(paramByte) || isData(paramByte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encode(byte[] paramArrayOfbyte) {
/* 106 */     if (paramArrayOfbyte == null) {
/* 107 */       return null;
/*     */     }
/* 109 */     int i = paramArrayOfbyte.length * 8;
/* 110 */     int j = i % 24;
/* 111 */     int k = i / 24;
/* 112 */     byte[] arrayOfByte = null;
/*     */     
/* 114 */     if (j != 0) {
/* 115 */       arrayOfByte = new byte[(k + 1) * 4];
/*     */     } else {
/* 117 */       arrayOfByte = new byte[k * 4];
/*     */     } 
/* 119 */     byte b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0;
/*     */     
/* 121 */     int m = 0;
/* 122 */     int n = 0;
/* 123 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/* 127 */     for (b = 0; b < k; b++) {
/*     */       
/* 129 */       n = b * 3;
/* 130 */       b3 = paramArrayOfbyte[n];
/* 131 */       b4 = paramArrayOfbyte[n + 1];
/* 132 */       b5 = paramArrayOfbyte[n + 2];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       b2 = (byte)(b4 & 0xF);
/* 139 */       b1 = (byte)(b3 & 0x3);
/*     */       
/* 141 */       m = b * 4;
/* 142 */       byte b6 = ((b3 & 0xFFFFFF80) == 0) ? (byte)(b3 >> 2) : (byte)(b3 >> 2 ^ 0xC0);
/*     */       
/* 144 */       byte b7 = ((b4 & 0xFFFFFF80) == 0) ? (byte)(b4 >> 4) : (byte)(b4 >> 4 ^ 0xF0);
/* 145 */       byte b8 = ((b5 & 0xFFFFFF80) == 0) ? (byte)(b5 >> 6) : (byte)(b5 >> 6 ^ 0xFC);
/*     */       
/* 147 */       arrayOfByte[m] = lookUpBase64Alphabet[b6];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       arrayOfByte[m + 1] = lookUpBase64Alphabet[b7 | b1 << 4];
/* 155 */       arrayOfByte[m + 2] = lookUpBase64Alphabet[b2 << 2 | b8];
/* 156 */       arrayOfByte[m + 3] = lookUpBase64Alphabet[b5 & 0x3F];
/*     */     } 
/*     */ 
/*     */     
/* 160 */     n = b * 3;
/* 161 */     m = b * 4;
/* 162 */     if (j == 8) {
/* 163 */       b3 = paramArrayOfbyte[n];
/* 164 */       b1 = (byte)(b3 & 0x3);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 169 */       byte b6 = ((b3 & 0xFFFFFF80) == 0) ? (byte)(b3 >> 2) : (byte)(b3 >> 2 ^ 0xC0);
/* 170 */       arrayOfByte[m] = lookUpBase64Alphabet[b6];
/* 171 */       arrayOfByte[m + 1] = lookUpBase64Alphabet[b1 << 4];
/* 172 */       arrayOfByte[m + 2] = 61;
/* 173 */       arrayOfByte[m + 3] = 61;
/* 174 */     } else if (j == 16) {
/*     */       
/* 176 */       b3 = paramArrayOfbyte[n];
/* 177 */       b4 = paramArrayOfbyte[n + 1];
/* 178 */       b2 = (byte)(b4 & 0xF);
/* 179 */       b1 = (byte)(b3 & 0x3);
/*     */       
/* 181 */       byte b6 = ((b3 & 0xFFFFFF80) == 0) ? (byte)(b3 >> 2) : (byte)(b3 >> 2 ^ 0xC0);
/* 182 */       byte b7 = ((b4 & 0xFFFFFF80) == 0) ? (byte)(b4 >> 4) : (byte)(b4 >> 4 ^ 0xF0);
/*     */       
/* 184 */       arrayOfByte[m] = lookUpBase64Alphabet[b6];
/* 185 */       arrayOfByte[m + 1] = lookUpBase64Alphabet[b7 | b1 << 4];
/* 186 */       arrayOfByte[m + 2] = lookUpBase64Alphabet[b2 << 2];
/* 187 */       arrayOfByte[m + 3] = 61;
/*     */     } 
/*     */     
/* 190 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(byte[] paramArrayOfbyte) {
/* 201 */     if (paramArrayOfbyte == null) {
/* 202 */       return null;
/*     */     }
/*     */     
/* 205 */     paramArrayOfbyte = removeWhiteSpace(paramArrayOfbyte);
/*     */     
/* 207 */     if (paramArrayOfbyte.length % 4 != 0) {
/* 208 */       return null;
/*     */     }
/*     */     
/* 211 */     int i = paramArrayOfbyte.length / 4;
/*     */     
/* 213 */     if (i == 0) {
/* 214 */       return new byte[0];
/*     */     }
/* 216 */     byte[] arrayOfByte = null;
/* 217 */     byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
/* 218 */     byte b5 = 0, b6 = 0, b7 = 0, b8 = 0;
/*     */ 
/*     */ 
/*     */     
/* 222 */     byte b9 = 0;
/* 223 */     byte b10 = 0;
/* 224 */     byte b11 = 0;
/* 225 */     arrayOfByte = new byte[i * 3];
/*     */     
/* 227 */     for (; b9 < i - 1; b9++) {
/*     */       
/* 229 */       if (!isData(b5 = paramArrayOfbyte[b11++]) || !isData(b6 = paramArrayOfbyte[b11++]) || !isData(b7 = paramArrayOfbyte[b11++]) || !isData(b8 = paramArrayOfbyte[b11++]))
/*     */       {
/*     */ 
/*     */         
/* 233 */         return null;
/*     */       }
/* 235 */       b1 = base64Alphabet[b5];
/* 236 */       b2 = base64Alphabet[b6];
/* 237 */       b3 = base64Alphabet[b7];
/* 238 */       b4 = base64Alphabet[b8];
/*     */       
/* 240 */       arrayOfByte[b10++] = (byte)(b1 << 2 | b2 >> 4);
/* 241 */       arrayOfByte[b10++] = (byte)((b2 & 0xF) << 4 | b3 >> 2 & 0xF);
/* 242 */       arrayOfByte[b10++] = (byte)(b3 << 6 | b4);
/*     */     } 
/*     */     
/* 245 */     if (!isData(b5 = paramArrayOfbyte[b11++]) || !isData(b6 = paramArrayOfbyte[b11++]))
/*     */     {
/* 247 */       return null;
/*     */     }
/*     */     
/* 250 */     b1 = base64Alphabet[b5];
/* 251 */     b2 = base64Alphabet[b6];
/*     */     
/* 253 */     b7 = paramArrayOfbyte[b11++];
/* 254 */     b8 = paramArrayOfbyte[b11++];
/* 255 */     if (!isData(b7) || !isData(b8)) {
/*     */       
/* 257 */       if (isPad(b7) && isPad(b8)) {
/* 258 */         if ((b2 & 0xF) != 0)
/* 259 */           return null; 
/* 260 */         byte[] arrayOfByte1 = new byte[b9 * 3 + 1];
/* 261 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, b9 * 3);
/* 262 */         arrayOfByte1[b10] = (byte)(b1 << 2 | b2 >> 4);
/* 263 */         return arrayOfByte1;
/* 264 */       }  if (!isPad(b7) && isPad(b8)) {
/* 265 */         b3 = base64Alphabet[b7];
/* 266 */         if ((b3 & 0x3) != 0)
/* 267 */           return null; 
/* 268 */         byte[] arrayOfByte1 = new byte[b9 * 3 + 2];
/* 269 */         System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, b9 * 3);
/* 270 */         arrayOfByte1[b10++] = (byte)(b1 << 2 | b2 >> 4);
/* 271 */         arrayOfByte1[b10] = (byte)((b2 & 0xF) << 4 | b3 >> 2 & 0xF);
/* 272 */         return arrayOfByte1;
/*     */       } 
/* 274 */       return null;
/*     */     } 
/*     */     
/* 277 */     b3 = base64Alphabet[b7];
/* 278 */     b4 = base64Alphabet[b8];
/* 279 */     arrayOfByte[b10++] = (byte)(b1 << 2 | b2 >> 4);
/* 280 */     arrayOfByte[b10++] = (byte)((b2 & 0xF) << 4 | b3 >> 2 & 0xF);
/* 281 */     arrayOfByte[b10++] = (byte)(b3 << 6 | b4);
/*     */ 
/*     */ 
/*     */     
/* 285 */     return arrayOfByte;
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
/*     */   protected static byte[] removeWhiteSpace(byte[] paramArrayOfbyte) {
/* 336 */     if (paramArrayOfbyte == null) {
/* 337 */       return null;
/*     */     }
/*     */     
/* 340 */     byte b1 = 0;
/* 341 */     int i = paramArrayOfbyte.length;
/* 342 */     for (byte b2 = 0; b2 < i; b2++) {
/* 343 */       if (!isWhiteSpace(paramArrayOfbyte[b2])) {
/* 344 */         b1++;
/*     */       }
/*     */     } 
/*     */     
/* 348 */     if (b1 == i) {
/* 349 */       return paramArrayOfbyte;
/*     */     }
/*     */     
/* 352 */     byte[] arrayOfByte = new byte[b1];
/*     */     
/* 354 */     byte b3 = 0;
/* 355 */     for (byte b4 = 0; b4 < i; b4++) {
/* 356 */       if (!isWhiteSpace(paramArrayOfbyte[b4]))
/* 357 */         arrayOfByte[b3++] = paramArrayOfbyte[b4]; 
/*     */     } 
/* 359 */     return arrayOfByte;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\imp\\util\Base64.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */