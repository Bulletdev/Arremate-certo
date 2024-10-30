/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ToNetASCIIInputStream
/*     */   extends FilterInputStream
/*     */ {
/*     */   private static final int NOTHING_SPECIAL = 0;
/*     */   private static final int LAST_WAS_CR = 1;
/*     */   private static final int LAST_WAS_NL = 2;
/*     */   private int status;
/*     */   
/*     */   public ToNetASCIIInputStream(InputStream paramInputStream) {
/*  50 */     super(paramInputStream);
/*  51 */     this.status = 0;
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
/*     */   public int read() throws IOException {
/*  69 */     if (this.status == 2) {
/*     */       
/*  71 */       this.status = 0;
/*  72 */       return 10;
/*     */     } 
/*     */     
/*  75 */     int i = this.in.read();
/*     */     
/*  77 */     switch (i) {
/*     */       
/*     */       case 13:
/*  80 */         this.status = 1;
/*  81 */         return 13;
/*     */       case 10:
/*  83 */         if (this.status != 1) {
/*     */           
/*  85 */           this.status = 2;
/*  86 */           return 13;
/*     */         } 
/*     */         break;
/*     */     } 
/*  90 */     this.status = 0;
/*  91 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 112 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 136 */     if (paramInt2 < 1) {
/* 137 */       return 0;
/*     */     }
/*     */     
/* 140 */     int i = available();
/*     */     
/* 142 */     if (paramInt2 > i) {
/* 143 */       paramInt2 = i;
/*     */     }
/*     */ 
/*     */     
/* 147 */     if (paramInt2 < 1) {
/* 148 */       paramInt2 = 1;
/*     */     }
/*     */     
/* 151 */     if ((i = read()) == -1) {
/* 152 */       return -1;
/*     */     }
/*     */     
/* 155 */     int j = paramInt1;
/*     */ 
/*     */     
/*     */     do {
/* 159 */       paramArrayOfbyte[paramInt1++] = (byte)i;
/*     */     }
/* 161 */     while (--paramInt2 > 0 && (i = read()) != -1);
/*     */     
/* 163 */     return paramInt1 - j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 178 */     int i = this.in.available();
/*     */     
/* 180 */     if (this.status == 2) {
/* 181 */       return i + 1;
/*     */     }
/*     */     
/* 184 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\ToNetASCIIInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */