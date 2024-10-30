/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ByteOrderMark
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  36 */   public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", new int[] { 239, 187, 191 });
/*     */ 
/*     */   
/*  39 */   public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", new int[] { 254, 255 });
/*     */ 
/*     */   
/*  42 */   public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", new int[] { 255, 254 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  48 */   public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", new int[] { 0, 0, 254, 255 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", new int[] { 255, 254, 0, 0 });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char UTF_BOM = '﻿';
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String charsetName;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int[] bytes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteOrderMark(String paramString, int... paramVarArgs) {
/*  77 */     if (paramString == null || paramString.isEmpty()) {
/*  78 */       throw new IllegalArgumentException("No charsetName specified");
/*     */     }
/*  80 */     if (paramVarArgs == null || paramVarArgs.length == 0) {
/*  81 */       throw new IllegalArgumentException("No bytes specified");
/*     */     }
/*  83 */     this.charsetName = paramString;
/*  84 */     this.bytes = new int[paramVarArgs.length];
/*  85 */     System.arraycopy(paramVarArgs, 0, this.bytes, 0, paramVarArgs.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCharsetName() {
/*  94 */     return this.charsetName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 103 */     return this.bytes.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int paramInt) {
/* 113 */     return this.bytes[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getBytes() {
/* 122 */     byte[] arrayOfByte = new byte[this.bytes.length];
/* 123 */     for (byte b = 0; b < this.bytes.length; b++) {
/* 124 */       arrayOfByte[b] = (byte)this.bytes[b];
/*     */     }
/* 126 */     return arrayOfByte;
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
/*     */   public boolean equals(Object paramObject) {
/* 138 */     if (!(paramObject instanceof ByteOrderMark)) {
/* 139 */       return false;
/*     */     }
/* 141 */     ByteOrderMark byteOrderMark = (ByteOrderMark)paramObject;
/* 142 */     if (this.bytes.length != byteOrderMark.length()) {
/* 143 */       return false;
/*     */     }
/* 145 */     for (byte b = 0; b < this.bytes.length; b++) {
/* 146 */       if (this.bytes[b] != byteOrderMark.get(b)) {
/* 147 */         return false;
/*     */       }
/*     */     } 
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 161 */     int i = getClass().hashCode();
/* 162 */     for (int j : this.bytes) {
/* 163 */       i += j;
/*     */     }
/* 165 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder stringBuilder = new StringBuilder();
/* 176 */     stringBuilder.append(getClass().getSimpleName());
/* 177 */     stringBuilder.append('[');
/* 178 */     stringBuilder.append(this.charsetName);
/* 179 */     stringBuilder.append(": ");
/* 180 */     for (byte b = 0; b < this.bytes.length; b++) {
/* 181 */       if (b > 0) {
/* 182 */         stringBuilder.append(",");
/*     */       }
/* 184 */       stringBuilder.append("0x");
/* 185 */       stringBuilder.append(Integer.toHexString(0xFF & this.bytes[b]).toUpperCase(Locale.ROOT));
/*     */     } 
/* 187 */     stringBuilder.append(']');
/* 188 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\ByteOrderMark.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */