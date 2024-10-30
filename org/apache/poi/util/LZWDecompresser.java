/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LZWDecompresser
/*     */ {
/*     */   private final boolean maskMeansCompressed;
/*     */   private final int codeLengthIncrease;
/*     */   private final boolean positionIsBigEndian;
/*     */   
/*     */   protected LZWDecompresser(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {
/*  54 */     this.maskMeansCompressed = paramBoolean1;
/*  55 */     this.codeLengthIncrease = paramInt;
/*  56 */     this.positionIsBigEndian = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int populateDictionary(byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int adjustDictionaryOffset(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] decompress(InputStream paramInputStream) throws IOException {
/*  80 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  81 */     decompress(paramInputStream, byteArrayOutputStream);
/*  82 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public void decompress(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 116 */     byte[] arrayOfByte1 = new byte[4096];
/* 117 */     int i = populateDictionary(arrayOfByte1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     byte[] arrayOfByte2 = new byte[16 + this.codeLengthIncrease];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     while ((j = paramInputStream.read()) != -1) {
/*     */       int k;
/* 134 */       for (k = 1; k < 256; k <<= 1) {
/*     */ 
/*     */         
/* 137 */         boolean bool = ((j & k) > 0);
/* 138 */         if (bool ^ this.maskMeansCompressed) {
/*     */           int m;
/* 140 */           if ((m = paramInputStream.read()) != -1)
/*     */           {
/* 142 */             arrayOfByte1[i & 0xFFF] = fromInt(m);
/* 143 */             i++;
/*     */             
/* 145 */             paramOutputStream.write(new byte[] { fromInt(m) });
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 150 */           int m = paramInputStream.read();
/* 151 */           int n = paramInputStream.read();
/* 152 */           if (m == -1 || n == -1) {
/*     */             break;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 158 */           int i1 = (n & 0xF) + this.codeLengthIncrease;
/* 159 */           if (this.positionIsBigEndian) {
/* 160 */             i2 = (m << 4) + (n >> 4);
/*     */           } else {
/* 162 */             i2 = m + ((n & 0xF0) << 4);
/*     */           } 
/*     */ 
/*     */           
/* 166 */           int i2 = adjustDictionaryOffset(i2);
/*     */ 
/*     */           
/* 169 */           for (byte b = 0; b < i1; b++) {
/* 170 */             arrayOfByte2[b] = arrayOfByte1[i2 + b & 0xFFF];
/* 171 */             arrayOfByte1[i + b & 0xFFF] = arrayOfByte2[b];
/*     */           } 
/* 173 */           paramOutputStream.write(arrayOfByte2, 0, i1);
/*     */ 
/*     */           
/* 176 */           i += i1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte fromInt(int paramInt) {
/* 188 */     if (paramInt < 128) return (byte)paramInt; 
/* 189 */     return (byte)(paramInt - 256);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int fromByte(byte paramByte) {
/* 197 */     if (paramByte >= 0) {
/* 198 */       return paramByte;
/*     */     }
/* 200 */     return paramByte + 256;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LZWDecompresser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */