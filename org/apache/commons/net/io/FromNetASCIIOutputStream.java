/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
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
/*     */ public final class FromNetASCIIOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private boolean lastWasCR;
/*     */   
/*     */   public FromNetASCIIOutputStream(OutputStream paramOutputStream) {
/*  51 */     super(paramOutputStream);
/*  52 */     this.lastWasCR = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeInt(int paramInt) throws IOException {
/*  58 */     switch (paramInt) {
/*     */       
/*     */       case 13:
/*  61 */         this.lastWasCR = true;
/*     */         return;
/*     */       
/*     */       case 10:
/*  65 */         if (this.lastWasCR) {
/*     */           
/*  67 */           this.out.write(FromNetASCIIInputStream._lineSeparatorBytes);
/*  68 */           this.lastWasCR = false;
/*     */         } else {
/*     */           
/*  71 */           this.lastWasCR = false;
/*  72 */           this.out.write(10);
/*     */         }  return;
/*     */     } 
/*  75 */     if (this.lastWasCR) {
/*     */       
/*  77 */       this.out.write(13);
/*  78 */       this.lastWasCR = false;
/*     */     } 
/*  80 */     this.out.write(paramInt);
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
/*     */   public synchronized void write(int paramInt) throws IOException {
/* 102 */     if (FromNetASCIIInputStream._noConversionRequired) {
/*     */       
/* 104 */       this.out.write(paramInt);
/*     */       
/*     */       return;
/*     */     } 
/* 108 */     writeInt(paramInt);
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
/*     */   public synchronized void write(byte[] paramArrayOfbyte) throws IOException {
/* 123 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public synchronized void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 141 */     if (FromNetASCIIInputStream._noConversionRequired) {
/*     */ 
/*     */ 
/*     */       
/* 145 */       this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */       
/*     */       return;
/*     */     } 
/* 149 */     while (paramInt2-- > 0) {
/* 150 */       writeInt(paramArrayOfbyte[paramInt1++]);
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
/*     */   public synchronized void close() throws IOException {
/* 164 */     if (FromNetASCIIInputStream._noConversionRequired) {
/*     */       
/* 166 */       super.close();
/*     */       
/*     */       return;
/*     */     } 
/* 170 */     if (this.lastWasCR) {
/* 171 */       this.out.write(13);
/*     */     }
/* 173 */     super.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\FromNetASCIIOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */