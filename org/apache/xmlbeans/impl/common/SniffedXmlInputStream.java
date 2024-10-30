/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SniffedXmlInputStream
/*     */   extends BufferedInputStream
/*     */ {
/*  29 */   public static int MAX_SNIFFED_BYTES = 192;
/*     */ 
/*     */   
/*     */   public SniffedXmlInputStream(InputStream paramInputStream) throws IOException {
/*  33 */     super(paramInputStream);
/*     */ 
/*     */     
/*  36 */     this._encoding = sniffFourBytes();
/*     */     
/*  38 */     if (this._encoding != null && this._encoding.equals("IBM037")) {
/*     */ 
/*     */       
/*  41 */       String str = sniffForXmlDecl(this._encoding);
/*  42 */       if (str != null) {
/*  43 */         this._encoding = str;
/*     */       }
/*     */     } 
/*  46 */     if (this._encoding == null)
/*     */     {
/*     */ 
/*     */       
/*  50 */       this._encoding = sniffForXmlDecl("UTF-8");
/*     */     }
/*     */     
/*  53 */     if (this._encoding == null)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  80 */       this._encoding = "UTF-8";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int readAsMuchAsPossible(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  86 */     int i = 0;
/*  87 */     while (i < paramInt2) {
/*     */       
/*  89 */       int j = read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
/*  90 */       if (j < 0)
/*     */         break; 
/*  92 */       i += j;
/*     */     } 
/*  94 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private String sniffFourBytes() throws IOException {
/*  99 */     mark(4);
/* 100 */     boolean bool = false;
/*     */     
/*     */     try {
/* 103 */       byte[] arrayOfByte = new byte[4];
/* 104 */       if (readAsMuchAsPossible(arrayOfByte, 0, 4) < 4)
/* 105 */         return null; 
/* 106 */       long l = (0xFF000000 & arrayOfByte[0] << 24 | 0xFF0000 & arrayOfByte[1] << 16 | 0xFF00 & arrayOfByte[2] << 8 | 0xFF & arrayOfByte[3]);
/*     */       
/* 108 */       if (l == 65279L)
/* 109 */         return "UCS-4"; 
/* 110 */       if (l == -131072L)
/* 111 */         return "UCS-4"; 
/* 112 */       if (l == 60L)
/* 113 */         return "UCS-4BE"; 
/* 114 */       if (l == 1006632960L)
/* 115 */         return "UCS-4LE"; 
/* 116 */       if (l == 3932223L)
/* 117 */         return "UTF-16BE"; 
/* 118 */       if (l == 1006649088L)
/* 119 */         return "UTF-16LE"; 
/* 120 */       if (l == 1010792557L)
/* 121 */         return null; 
/* 122 */       if (l == 1282385812L)
/* 123 */         return "IBM037"; 
/* 124 */       if ((l & 0xFFFFFFFFFFFF0000L) == -16842752L)
/* 125 */         return "UTF-16"; 
/* 126 */       if ((l & 0xFFFFFFFFFFFF0000L) == -131072L)
/* 127 */         return "UTF-16"; 
/* 128 */       if ((l & 0xFFFFFFFFFFFFFF00L) == -272908544L)
/* 129 */         return "UTF-8"; 
/* 130 */       return null;
/*     */     }
/*     */     finally {
/*     */       
/* 134 */       reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   private static Charset dummy1 = Charset.forName("UTF-8");
/* 142 */   private static Charset dummy2 = Charset.forName("UTF-16");
/* 143 */   private static Charset dummy3 = Charset.forName("UTF-16BE");
/* 144 */   private static Charset dummy4 = Charset.forName("UTF-16LE");
/* 145 */   private static Charset dummy5 = Charset.forName("ISO-8859-1");
/* 146 */   private static Charset dummy6 = Charset.forName("US-ASCII");
/* 147 */   private static Charset dummy7 = Charset.forName("Cp1252");
/*     */   
/*     */   private String _encoding;
/*     */   
/*     */   private String sniffForXmlDecl(String paramString) throws IOException {
/* 152 */     mark(MAX_SNIFFED_BYTES);
/*     */     
/*     */     try {
/* 155 */       byte[] arrayOfByte = new byte[MAX_SNIFFED_BYTES];
/* 156 */       int i = readAsMuchAsPossible(arrayOfByte, 0, MAX_SNIFFED_BYTES);
/*     */ 
/*     */       
/* 159 */       Charset charset = Charset.forName(paramString);
/* 160 */       InputStreamReader inputStreamReader = new InputStreamReader(new ByteArrayInputStream(arrayOfByte, 0, i), charset);
/* 161 */       char[] arrayOfChar = new char[i];
/* 162 */       int j = 0;
/* 163 */       while (j < i) {
/*     */         
/* 165 */         int k = inputStreamReader.read(arrayOfChar, j, i - j);
/* 166 */         if (k < 0)
/*     */           break; 
/* 168 */         j += k;
/*     */       } 
/*     */       
/* 171 */       return extractXmlDeclEncoding(arrayOfChar, 0, j);
/*     */     }
/*     */     finally {
/*     */       
/* 175 */       reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getXmlEncoding() {
/* 183 */     return this._encoding;
/*     */   }
/*     */ 
/*     */   
/*     */   static String extractXmlDeclEncoding(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 188 */     int i = paramInt1 + paramInt2;
/* 189 */     int j = firstIndexOf("<?xml", paramArrayOfchar, paramInt1, i);
/* 190 */     if (j >= 0) {
/*     */       
/* 192 */       int k = j + 5;
/* 193 */       ScannedAttribute scannedAttribute = new ScannedAttribute();
/* 194 */       while (k < i) {
/*     */         
/* 196 */         k = scanAttribute(paramArrayOfchar, k, i, scannedAttribute);
/* 197 */         if (k < 0)
/* 198 */           return null; 
/* 199 */         if (scannedAttribute.name.equals("encoding"))
/* 200 */           return scannedAttribute.value; 
/*     */       } 
/*     */     } 
/* 203 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int firstIndexOf(String paramString, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 208 */     assert paramString.length() > 0;
/* 209 */     char[] arrayOfChar = paramString.toCharArray();
/*     */     
/* 211 */     char c = arrayOfChar[0];
/* 212 */     for (paramInt2 -= arrayOfChar.length; paramInt1 < paramInt2; paramInt1++) {
/*     */       
/* 214 */       if (paramArrayOfchar[paramInt1] == c) {
/*     */         
/* 216 */         byte b = 1; while (true) { if (b < arrayOfChar.length) {
/*     */             
/* 218 */             if (paramArrayOfchar[paramInt1 + b] != arrayOfChar[b])
/*     */               break; 
/*     */             b++;
/*     */             continue;
/*     */           } 
/* 223 */           return paramInt1; }
/*     */       
/*     */       } 
/*     */     } 
/* 227 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int nextNonmatchingByte(char[] paramArrayOfchar1, char[] paramArrayOfchar2, int paramInt1, int paramInt2) {
/* 232 */     for (; paramInt1 < paramInt2; paramInt1++) {
/*     */       
/* 234 */       char c = paramArrayOfchar2[paramInt1];
/* 235 */       byte b = 0; while (true) { if (b < paramArrayOfchar1.length) {
/* 236 */           if (c == paramArrayOfchar1[b])
/*     */             break;  b++; continue;
/* 238 */         }  return paramInt1; }
/*     */     
/* 240 */     }  return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int nextMatchingByte(char[] paramArrayOfchar1, char[] paramArrayOfchar2, int paramInt1, int paramInt2) {
/* 245 */     for (; paramInt1 < paramInt2; paramInt1++) {
/*     */       
/* 247 */       char c = paramArrayOfchar2[paramInt1];
/* 248 */       for (byte b = 0; b < paramArrayOfchar1.length; b++) {
/* 249 */         if (c == paramArrayOfchar1[b])
/* 250 */           return paramInt1; 
/*     */       } 
/* 252 */     }  return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int nextMatchingByte(char paramChar, char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 257 */     for (; paramInt1 < paramInt2; paramInt1++) {
/*     */       
/* 259 */       if (paramArrayOfchar[paramInt1] == paramChar)
/* 260 */         return paramInt1; 
/*     */     } 
/* 262 */     return -1;
/*     */   }
/* 264 */   private static char[] WHITESPACE = new char[] { ' ', '\r', '\t', '\n' };
/* 265 */   private static char[] NOTNAME = new char[] { '=', ' ', '\r', '\t', '\n', '?', '>', '<', '\'', '"' };
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static class ScannedAttribute {
/*     */     public String name;
/*     */     public String value;
/*     */     
/*     */     private ScannedAttribute() {} }
/*     */   
/*     */   private static int scanAttribute(char[] paramArrayOfchar, int paramInt1, int paramInt2, ScannedAttribute paramScannedAttribute) {
/* 275 */     int i = nextNonmatchingByte(WHITESPACE, paramArrayOfchar, paramInt1, paramInt2);
/* 276 */     if (i < 0)
/* 277 */       return -1; 
/* 278 */     int j = nextMatchingByte(NOTNAME, paramArrayOfchar, i, paramInt2);
/* 279 */     if (j < 0)
/* 280 */       return -1; 
/* 281 */     int k = nextNonmatchingByte(WHITESPACE, paramArrayOfchar, j, paramInt2);
/* 282 */     if (k < 0)
/* 283 */       return -1; 
/* 284 */     if (paramArrayOfchar[k] != '=')
/* 285 */       return -1; 
/* 286 */     int m = nextNonmatchingByte(WHITESPACE, paramArrayOfchar, k + 1, paramInt2);
/* 287 */     if (paramArrayOfchar[m] != '\'' && paramArrayOfchar[m] != '"')
/* 288 */       return -1; 
/* 289 */     int n = nextMatchingByte(paramArrayOfchar[m], paramArrayOfchar, m + 1, paramInt2);
/* 290 */     if (n < 0)
/* 291 */       return -1; 
/* 292 */     paramScannedAttribute.name = new String(paramArrayOfchar, i, j - i);
/* 293 */     paramScannedAttribute.value = new String(paramArrayOfchar, m + 1, n - m - 1);
/* 294 */     return n + 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\SniffedXmlInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */