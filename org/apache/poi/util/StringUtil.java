/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ @Internal
/*     */ public class StringUtil
/*     */ {
/*  30 */   protected static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
/*  31 */   protected static final Charset UTF16LE = Charset.forName("UTF-16LE");
/*  32 */   public static final Charset UTF8 = Charset.forName("UTF-8");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<Integer, Integer> msCodepointToUnicode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFromUnicodeLE(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
/*  65 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfbyte.length) {
/*  66 */       throw new ArrayIndexOutOfBoundsException("Illegal offset " + paramInt1 + " (String data is of length " + paramArrayOfbyte.length + ")");
/*     */     }
/*  68 */     if (paramInt2 < 0 || (paramArrayOfbyte.length - paramInt1) / 2 < paramInt2) {
/*  69 */       throw new IllegalArgumentException("Illegal length " + paramInt2);
/*     */     }
/*     */     
/*  72 */     return new String(paramArrayOfbyte, paramInt1, paramInt2 * 2, UTF16LE);
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
/*     */   public static String getFromUnicodeLE(byte[] paramArrayOfbyte) {
/*  86 */     if (paramArrayOfbyte.length == 0) return ""; 
/*  87 */     return getFromUnicodeLE(paramArrayOfbyte, 0, paramArrayOfbyte.length / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getToUnicodeLE(String paramString) {
/*  97 */     return paramString.getBytes(UTF16LE);
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
/*     */   public static String getFromCompressedUnicode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 114 */     int i = Math.min(paramInt2, paramArrayOfbyte.length - paramInt1);
/* 115 */     return new String(paramArrayOfbyte, paramInt1, i, ISO_8859_1);
/*     */   }
/*     */   
/*     */   public static String readCompressedUnicode(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 119 */     byte[] arrayOfByte = new byte[paramInt];
/* 120 */     paramLittleEndianInput.readFully(arrayOfByte);
/* 121 */     return new String(arrayOfByte, ISO_8859_1);
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
/*     */   public static String readUnicodeString(LittleEndianInput paramLittleEndianInput) {
/* 137 */     int i = paramLittleEndianInput.readUShort();
/* 138 */     byte b = paramLittleEndianInput.readByte();
/* 139 */     if ((b & 0x1) == 0) {
/* 140 */       return readCompressedUnicode(paramLittleEndianInput, i);
/*     */     }
/* 142 */     return readUnicodeLE(paramLittleEndianInput, i);
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
/*     */   public static String readUnicodeString(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 157 */     byte b = paramLittleEndianInput.readByte();
/* 158 */     if ((b & 0x1) == 0) {
/* 159 */       return readCompressedUnicode(paramLittleEndianInput, paramInt);
/*     */     }
/* 161 */     return readUnicodeLE(paramLittleEndianInput, paramInt);
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
/*     */   public static void writeUnicodeString(LittleEndianOutput paramLittleEndianOutput, String paramString) {
/* 173 */     int i = paramString.length();
/* 174 */     paramLittleEndianOutput.writeShort(i);
/* 175 */     boolean bool = hasMultibyte(paramString);
/* 176 */     paramLittleEndianOutput.writeByte(bool ? 1 : 0);
/* 177 */     if (bool) {
/* 178 */       putUnicodeLE(paramString, paramLittleEndianOutput);
/*     */     } else {
/* 180 */       putCompressedUnicode(paramString, paramLittleEndianOutput);
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
/*     */ 
/*     */   
/*     */   public static void writeUnicodeStringFlagAndData(LittleEndianOutput paramLittleEndianOutput, String paramString) {
/* 196 */     boolean bool = hasMultibyte(paramString);
/* 197 */     paramLittleEndianOutput.writeByte(bool ? 1 : 0);
/* 198 */     if (bool) {
/* 199 */       putUnicodeLE(paramString, paramLittleEndianOutput);
/*     */     } else {
/* 201 */       putCompressedUnicode(paramString, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getEncodedSize(String paramString) {
/* 209 */     int i = 3;
/* 210 */     i += paramString.length() * (hasMultibyte(paramString) ? 2 : 1);
/* 211 */     return i;
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
/*     */   public static void putCompressedUnicode(String paramString, byte[] paramArrayOfbyte, int paramInt) {
/* 225 */     byte[] arrayOfByte = paramString.getBytes(ISO_8859_1);
/* 226 */     System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, paramInt, arrayOfByte.length);
/*     */   }
/*     */   
/*     */   public static void putCompressedUnicode(String paramString, LittleEndianOutput paramLittleEndianOutput) {
/* 230 */     byte[] arrayOfByte = paramString.getBytes(ISO_8859_1);
/* 231 */     paramLittleEndianOutput.write(arrayOfByte);
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
/*     */   public static void putUnicodeLE(String paramString, byte[] paramArrayOfbyte, int paramInt) {
/* 244 */     byte[] arrayOfByte = paramString.getBytes(UTF16LE);
/* 245 */     System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, paramInt, arrayOfByte.length);
/*     */   }
/*     */   public static void putUnicodeLE(String paramString, LittleEndianOutput paramLittleEndianOutput) {
/* 248 */     byte[] arrayOfByte = paramString.getBytes(UTF16LE);
/* 249 */     paramLittleEndianOutput.write(arrayOfByte);
/*     */   }
/*     */   
/*     */   public static String readUnicodeLE(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 253 */     byte[] arrayOfByte = new byte[paramInt * 2];
/* 254 */     paramLittleEndianInput.readFully(arrayOfByte);
/* 255 */     return new String(arrayOfByte, UTF16LE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPreferredEncoding() {
/* 262 */     return ISO_8859_1.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasMultibyte(String paramString) {
/* 272 */     if (paramString == null)
/* 273 */       return false; 
/* 274 */     for (char c : paramString.toCharArray()) {
/* 275 */       if (c > 'ÿ') {
/* 276 */         return true;
/*     */       }
/*     */     } 
/* 279 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isUnicodeString(String paramString) {
/* 289 */     return !paramString.equals(new String(paramString.getBytes(ISO_8859_1), ISO_8859_1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean startsWithIgnoreCase(String paramString1, String paramString2) {
/* 296 */     return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean endsWithIgnoreCase(String paramString1, String paramString2) {
/* 303 */     int i = paramString2.length();
/* 304 */     int j = paramString1.length() - i;
/* 305 */     return paramString1.regionMatches(true, j, paramString2, 0, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class StringsIterator
/*     */     implements Iterator<String>
/*     */   {
/* 312 */     private String[] strings = new String[0];
/* 313 */     private int position = 0;
/*     */     public StringsIterator(String[] param1ArrayOfString) {
/* 315 */       if (param1ArrayOfString != null) {
/* 316 */         this.strings = (String[])param1ArrayOfString.clone();
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 321 */       return (this.position < this.strings.length);
/*     */     }
/*     */     public String next() {
/* 324 */       int i = this.position++;
/* 325 */       if (i >= this.strings.length) {
/* 326 */         throw new ArrayIndexOutOfBoundsException(i);
/*     */       }
/* 328 */       return this.strings[i];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String mapMsCodepointString(String paramString) {
/* 346 */     if (paramString == null || "".equals(paramString)) return paramString; 
/* 347 */     initMsCodepointMap();
/*     */     
/* 349 */     StringBuilder stringBuilder = new StringBuilder();
/* 350 */     int i = paramString.length();
/* 351 */     for (int j = 0; j < i; ) {
/* 352 */       Integer integer1 = Integer.valueOf(paramString.codePointAt(j));
/* 353 */       Integer integer2 = msCodepointToUnicode.get(integer1);
/* 354 */       stringBuilder.appendCodePoint(((integer2 == null) ? integer1 : integer2).intValue());
/* 355 */       j += Character.charCount(integer1.intValue());
/*     */     } 
/*     */     
/* 358 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static synchronized void mapMsCodepoint(int paramInt1, int paramInt2) {
/* 362 */     initMsCodepointMap();
/* 363 */     msCodepointToUnicode.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*     */   }
/*     */   
/*     */   private static synchronized void initMsCodepointMap() {
/* 367 */     if (msCodepointToUnicode != null)
/* 368 */       return;  msCodepointToUnicode = new HashMap<Integer, Integer>();
/* 369 */     char c = '';
/* 370 */     for (int i : symbolMap_f020) {
/* 371 */       msCodepointToUnicode.put(Integer.valueOf(c++), Integer.valueOf(i));
/*     */     }
/* 373 */     c = '';
/* 374 */     for (int i : symbolMap_f0a0) {
/* 375 */       msCodepointToUnicode.put(Integer.valueOf(c++), Integer.valueOf(i));
/*     */     }
/*     */   }
/*     */   
/* 379 */   private static final int[] symbolMap_f020 = new int[] { 32, 33, 8704, 35, 8707, 37, 38, 8717, 40, 41, 8727, 43, 44, 8722, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, 91, 8765, 93, 8869, 95, 32, 945, 946, 967, 948, 949, 966, 947, 951, 953, 981, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, 123, 124, 125, 8764, 32 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 478 */   private static final int[] symbolMap_f0a0 = new int[] { 8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8591, 8593, 8594, 8595, 176, 177, 8243, 8805, 215, 181, 8706, 8729, 247, 8800, 8801, 8776, 8230, 9168, 9135, 8629, 8501, 8475, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 174, 169, 8482, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 32, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 32 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public static String join(Object[] paramArrayOfObject, String paramString) {
/* 580 */     if (paramArrayOfObject.length == 0) return ""; 
/* 581 */     StringBuilder stringBuilder = new StringBuilder();
/* 582 */     stringBuilder.append(paramArrayOfObject[0]);
/* 583 */     for (byte b = 1; b < paramArrayOfObject.length; b++) {
/* 584 */       stringBuilder.append(paramString).append(paramArrayOfObject[b]);
/*     */     }
/* 586 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public static String join(String paramString, Object... paramVarArgs) {
/* 591 */     return join(paramVarArgs, paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */