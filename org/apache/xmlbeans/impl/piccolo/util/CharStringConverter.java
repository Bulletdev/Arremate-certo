/*     */ package org.apache.xmlbeans.impl.piccolo.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharStringConverter
/*     */ {
/*     */   private static final float DEFAULT_LOAD = 0.7F;
/*     */   private float loadFactor;
/*  37 */   private int numEntries = 0;
/*     */   private int maxEntries;
/*     */   private int hashmask;
/*     */   private char[][] keys;
/*     */   private String[] values;
/*     */   
/*     */   public CharStringConverter(int paramInt, float paramFloat) {
/*  44 */     if (paramInt < 0) {
/*  45 */       throw new IllegalArgumentException("Illegal initial capacity: " + paramInt);
/*     */     }
/*     */     
/*  48 */     if (paramFloat < 0.0F || paramFloat > 1.0F) {
/*  49 */       throw new IllegalArgumentException("Illegal load factor: " + paramFloat);
/*     */     }
/*  51 */     int i = (int)(paramInt / paramFloat);
/*  52 */     int j = 16;
/*  53 */     while (j < i) {
/*  54 */       j <<= 1;
/*     */     }
/*  56 */     this.hashmask = j - 1;
/*  57 */     this.maxEntries = (int)(j * paramFloat);
/*  58 */     this.keys = new char[j][];
/*  59 */     this.values = new String[j];
/*  60 */     this.loadFactor = paramFloat;
/*     */   }
/*     */   
/*     */   public CharStringConverter() {
/*  64 */     this(0, 0.7F);
/*     */   }
/*     */   
/*     */   public CharStringConverter(int paramInt) {
/*  68 */     this(paramInt, 0.7F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCacheSize() {
/*  75 */     return this.numEntries;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String convert(char[] paramArrayOfchar) {
/*  82 */     return convert(paramArrayOfchar, 0, paramArrayOfchar.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String convert(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  93 */     if (this.numEntries >= this.maxEntries) {
/*  94 */       rehash();
/*     */     }
/*     */     
/*  97 */     int i = hashKey(paramArrayOfchar, paramInt1, paramInt2) & this.hashmask;
/*  98 */     char[] arrayOfChar = null;
/*  99 */     while ((arrayOfChar = this.keys[i]) != null && !keysAreEqual(arrayOfChar, 0, arrayOfChar.length, paramArrayOfchar, paramInt1, paramInt2))
/*     */     {
/* 101 */       i = i - 1 & this.hashmask;
/*     */     }
/* 103 */     if (arrayOfChar != null) {
/* 104 */       return this.values[i];
/*     */     }
/*     */ 
/*     */     
/* 108 */     arrayOfChar = new char[paramInt2];
/* 109 */     System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, 0, paramInt2);
/* 110 */     String str = (new String(arrayOfChar)).intern();
/* 111 */     this.keys[i] = arrayOfChar;
/* 112 */     this.values[i] = str;
/* 113 */     this.numEntries++;
/* 114 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private void rehash() {
/* 119 */     int i = this.keys.length << 1;
/* 120 */     char[][] arrayOfChar = new char[i][];
/* 121 */     String[] arrayOfString = new String[i];
/* 122 */     int j = i - 1;
/* 123 */     for (byte b = 0; b < this.keys.length; b++) {
/* 124 */       char[] arrayOfChar1 = this.keys[b];
/* 125 */       String str = this.values[b];
/* 126 */       if (arrayOfChar1 != null) {
/* 127 */         int k = hashKey(arrayOfChar1, 0, arrayOfChar1.length) & j;
/* 128 */         char[] arrayOfChar2 = null;
/* 129 */         while ((arrayOfChar2 = arrayOfChar[k]) != null && !keysAreEqual(arrayOfChar2, 0, arrayOfChar2.length, arrayOfChar1, 0, arrayOfChar1.length))
/*     */         {
/* 131 */           k = k - 1 & j;
/*     */         }
/* 133 */         arrayOfChar[k] = arrayOfChar1;
/* 134 */         arrayOfString[k] = str;
/*     */       } 
/*     */     } 
/* 137 */     this.keys = arrayOfChar;
/* 138 */     this.values = arrayOfString;
/* 139 */     this.maxEntries = (int)(i * this.loadFactor);
/* 140 */     this.hashmask = j;
/*     */   }
/*     */   
/*     */   public void clearCache() {
/* 144 */     for (byte b = 0; b < this.keys.length; b++) {
/* 145 */       this.keys[b] = null;
/* 146 */       this.values[b] = null;
/*     */     } 
/* 148 */     this.numEntries = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final boolean keysAreEqual(char[] paramArrayOfchar1, int paramInt1, int paramInt2, char[] paramArrayOfchar2, int paramInt3, int paramInt4) {
/* 153 */     if (paramInt2 != paramInt4) {
/* 154 */       return false;
/*     */     }
/*     */     
/* 157 */     for (byte b = 0; b < paramInt2; b++) {
/* 158 */       if (paramArrayOfchar1[paramInt1 + b] != paramArrayOfchar2[paramInt3 + b]) {
/* 159 */         return false;
/*     */       }
/*     */     } 
/* 162 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int hashKey(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 167 */     int i = 0;
/* 168 */     for (byte b = 0; b < paramInt2; b++) {
/* 169 */       i = (i << 5) + paramArrayOfchar[paramInt1 + b];
/*     */     }
/* 171 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccol\\util\CharStringConverter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */