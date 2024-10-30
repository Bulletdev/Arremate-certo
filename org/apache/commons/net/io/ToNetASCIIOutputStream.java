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
/*     */ public final class ToNetASCIIOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private boolean lastWasCR;
/*     */   
/*     */   public ToNetASCIIOutputStream(OutputStream paramOutputStream) {
/*  47 */     super(paramOutputStream);
/*  48 */     this.lastWasCR = false;
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
/*     */   public synchronized void write(int paramInt) throws IOException {
/*  67 */     switch (paramInt) {
/*     */       
/*     */       case 13:
/*  70 */         this.lastWasCR = true;
/*  71 */         this.out.write(13);
/*     */         return;
/*     */       case 10:
/*  74 */         if (!this.lastWasCR) {
/*  75 */           this.out.write(13);
/*     */         }
/*     */         break;
/*     */     } 
/*  79 */     this.lastWasCR = false;
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
/*     */   public synchronized void write(byte[] paramArrayOfbyte) throws IOException {
/*  96 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/* 114 */     while (paramInt2-- > 0)
/* 115 */       write(paramArrayOfbyte[paramInt1++]); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\ToNetASCIIOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */