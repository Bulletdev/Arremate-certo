/*     */ package org.apache.poi.xssf.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EvilUnclosedBRFixingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private InputStream source;
/*     */   private byte[] spare;
/*  39 */   private static byte[] detect = new byte[] { 60, 98, 114, 62 };
/*     */ 
/*     */ 
/*     */   
/*     */   public EvilUnclosedBRFixingInputStream(InputStream paramInputStream) {
/*  44 */     this.source = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  52 */     return this.source.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  58 */     int k, i = readFromSpare(paramArrayOfbyte, paramInt1, paramInt2);
/*     */ 
/*     */     
/*  61 */     int j = this.source.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (j == -1 || j == 0) {
/*  66 */       if (i == 0) {
/*  67 */         return j;
/*     */       }
/*  69 */       k = i;
/*     */     } else {
/*  71 */       k = i + j;
/*     */     } 
/*     */ 
/*     */     
/*  75 */     if (k > 0) {
/*  76 */       k = fixUp(paramArrayOfbyte, paramInt1, k);
/*     */     }
/*     */ 
/*     */     
/*  80 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  85 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readFromSpare(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  92 */     if (this.spare == null) return 0; 
/*  93 */     if (paramInt2 == 0) throw new IllegalArgumentException("Asked to read 0 bytes");
/*     */     
/*  95 */     if (this.spare.length <= paramInt2) {
/*     */       
/*  97 */       System.arraycopy(this.spare, 0, paramArrayOfbyte, paramInt1, this.spare.length);
/*  98 */       int i = this.spare.length;
/*  99 */       this.spare = null;
/* 100 */       return i;
/*     */     } 
/*     */     
/* 103 */     byte[] arrayOfByte = new byte[this.spare.length - paramInt2];
/* 104 */     System.arraycopy(this.spare, 0, paramArrayOfbyte, paramInt1, paramInt2);
/* 105 */     System.arraycopy(this.spare, paramInt2, arrayOfByte, 0, arrayOfByte.length);
/* 106 */     this.spare = arrayOfByte;
/* 107 */     return paramInt2;
/*     */   }
/*     */   
/*     */   private void addToSpare(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 111 */     if (this.spare == null) {
/* 112 */       this.spare = new byte[paramInt2];
/* 113 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.spare, 0, paramInt2);
/*     */     } else {
/* 115 */       byte[] arrayOfByte = new byte[this.spare.length + paramInt2];
/* 116 */       if (paramBoolean) {
/* 117 */         System.arraycopy(this.spare, 0, arrayOfByte, 0, this.spare.length);
/* 118 */         System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, this.spare.length, paramInt2);
/*     */       } else {
/* 120 */         System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/* 121 */         System.arraycopy(this.spare, 0, arrayOfByte, paramInt2, this.spare.length);
/*     */       } 
/* 123 */       this.spare = arrayOfByte;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int fixUp(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 129 */     for (byte b = 0; b < detect.length - 1; b++) {
/* 130 */       int m = paramInt1 + paramInt2 - 1 - b;
/* 131 */       if (m >= 0) {
/*     */         
/* 133 */         boolean bool = true;
/* 134 */         for (byte b1 = 0; b1 <= b && bool; b1++) {
/* 135 */           if (paramArrayOfbyte[m + b1] != detect[b1])
/*     */           {
/*     */             
/* 138 */             bool = false;
/*     */           }
/*     */         } 
/* 141 */         if (bool) {
/*     */           
/* 143 */           addToSpare(paramArrayOfbyte, m, b + 1, true);
/* 144 */           paramInt2--;
/* 145 */           paramInt2 -= b;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 151 */     ArrayList<Integer> arrayList = new ArrayList(); int i;
/* 152 */     for (i = paramInt1; i <= paramInt1 + paramInt2 - detect.length; i++) {
/* 153 */       boolean bool = true;
/* 154 */       for (byte b1 = 0; b1 < detect.length && bool; b1++) {
/* 155 */         if (paramArrayOfbyte[i + b1] != detect[b1]) {
/* 156 */           bool = false;
/*     */         }
/*     */       } 
/* 159 */       if (bool) {
/* 160 */         arrayList.add(Integer.valueOf(i));
/*     */       }
/*     */     } 
/*     */     
/* 164 */     if (arrayList.size() == 0) {
/* 165 */       return paramInt2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 170 */     i = paramInt1 + paramInt2 + arrayList.size();
/* 171 */     int j = i - paramArrayOfbyte.length;
/* 172 */     if (j > 0) {
/*     */       
/* 174 */       byte b1 = 0;
/* 175 */       for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) { int m = ((Integer)iterator.next()).intValue();
/* 176 */         if (m > paramInt1 + paramInt2 - detect.length - j - b1) {
/* 177 */           j = i - m - 1 - b1;
/*     */           break;
/*     */         } 
/* 180 */         b1++; }
/*     */ 
/*     */       
/* 183 */       addToSpare(paramArrayOfbyte, paramInt1 + paramInt2 - j, j, false);
/* 184 */       paramInt2 -= j;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 189 */     for (int k = arrayList.size() - 1; k >= 0; k--) {
/* 190 */       int m = ((Integer)arrayList.get(k)).intValue();
/* 191 */       if (m < paramInt2 + paramInt1)
/*     */       {
/*     */ 
/*     */         
/* 195 */         if (m <= paramInt2 - 3) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 200 */           byte[] arrayOfByte = new byte[paramInt2 - m - 3];
/* 201 */           System.arraycopy(paramArrayOfbyte, m + 3, arrayOfByte, 0, arrayOfByte.length);
/* 202 */           paramArrayOfbyte[m + 3] = 47;
/* 203 */           System.arraycopy(arrayOfByte, 0, paramArrayOfbyte, m + 4, arrayOfByte.length);
/*     */           
/* 205 */           paramInt2++;
/*     */         }  } 
/* 207 */     }  return paramInt2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\util\EvilUnclosedBRFixingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */