/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HexDump
/*     */ {
/*     */   public static void dump(byte[] paramArrayOfbyte, long paramLong, OutputStream paramOutputStream, int paramInt) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
/*  76 */     if (paramInt < 0 || paramInt >= paramArrayOfbyte.length) {
/*  77 */       throw new ArrayIndexOutOfBoundsException("illegal index: " + paramInt + " into array of length " + paramArrayOfbyte.length);
/*     */     }
/*     */ 
/*     */     
/*  81 */     if (paramOutputStream == null) {
/*  82 */       throw new IllegalArgumentException("cannot write to nullstream");
/*     */     }
/*  84 */     long l = paramLong + paramInt;
/*  85 */     StringBuilder stringBuilder = new StringBuilder(74);
/*     */     
/*  87 */     for (int i = paramInt; i < paramArrayOfbyte.length; i += 16) {
/*  88 */       int j = paramArrayOfbyte.length - i;
/*     */       
/*  90 */       if (j > 16) {
/*  91 */         j = 16;
/*     */       }
/*  93 */       dump(stringBuilder, l).append(' '); byte b;
/*  94 */       for (b = 0; b < 16; b++) {
/*  95 */         if (b < j) {
/*  96 */           dump(stringBuilder, paramArrayOfbyte[b + i]);
/*     */         } else {
/*  98 */           stringBuilder.append("  ");
/*     */         } 
/* 100 */         stringBuilder.append(' ');
/*     */       } 
/* 102 */       for (b = 0; b < j; b++) {
/* 103 */         if (paramArrayOfbyte[b + i] >= 32 && paramArrayOfbyte[b + i] < Byte.MAX_VALUE) {
/* 104 */           stringBuilder.append((char)paramArrayOfbyte[b + i]);
/*     */         } else {
/* 106 */           stringBuilder.append('.');
/*     */         } 
/*     */       } 
/* 109 */       stringBuilder.append(EOL);
/*     */       
/* 111 */       paramOutputStream.write(stringBuilder.toString().getBytes(Charset.defaultCharset()));
/* 112 */       paramOutputStream.flush();
/* 113 */       stringBuilder.setLength(0);
/* 114 */       l += j;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 122 */   public static final String EOL = System.getProperty("line.separator");
/* 123 */   private static final char[] _hexcodes = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 128 */   private static final int[] _shifts = new int[] { 28, 24, 20, 16, 12, 8, 4, 0 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static StringBuilder dump(StringBuilder paramStringBuilder, long paramLong) {
/* 141 */     for (byte b = 0; b < 8; b++) {
/* 142 */       paramStringBuilder
/* 143 */         .append(_hexcodes[(int)(paramLong >> _shifts[b]) & 0xF]);
/*     */     }
/* 145 */     return paramStringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static StringBuilder dump(StringBuilder paramStringBuilder, byte paramByte) {
/* 156 */     for (byte b = 0; b < 2; b++) {
/* 157 */       paramStringBuilder.append(_hexcodes[paramByte >> _shifts[b + 6] & 0xF]);
/*     */     }
/* 159 */     return paramStringBuilder;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\HexDump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */