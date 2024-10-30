/*     */ package org.apache.commons.net.telnet;
/*     */ 
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
/*     */ final class TelnetOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private final TelnetClient client;
/*     */   private final boolean convertCRtoCRLF = true;
/*     */   private boolean lastWasCR;
/*     */   
/*     */   TelnetOutputStream(TelnetClient paramTelnetClient) {
/*  44 */     this.client = paramTelnetClient;
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
/*     */   public void write(int paramInt) throws IOException {
/*  59 */     synchronized (this.client) {
/*     */       
/*  61 */       paramInt &= 0xFF;
/*     */       
/*  63 */       if (this.client.requestedWont(0)) {
/*     */         
/*  65 */         if (this.lastWasCR) {
/*     */ 
/*     */ 
/*     */           
/*  69 */           this.client.sendByte(10);
/*  70 */           if (paramInt == 10) {
/*     */             
/*  72 */             this.lastWasCR = false;
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  82 */         switch (paramInt) {
/*     */           
/*     */           case 13:
/*  85 */             this.client.sendByte(13);
/*  86 */             this.lastWasCR = true;
/*     */             break;
/*     */           case 10:
/*  89 */             if (!this.lastWasCR) {
/*  90 */               this.client.sendByte(13);
/*     */             }
/*  92 */             this.client.sendByte(paramInt);
/*  93 */             this.lastWasCR = false;
/*     */             break;
/*     */           case 255:
/*  96 */             this.client.sendByte(255);
/*  97 */             this.client.sendByte(255);
/*  98 */             this.lastWasCR = false;
/*     */             break;
/*     */           default:
/* 101 */             this.client.sendByte(paramInt);
/* 102 */             this.lastWasCR = false;
/*     */             break;
/*     */         } 
/*     */       
/* 106 */       } else if (paramInt == 255) {
/*     */         
/* 108 */         this.client.sendByte(paramInt);
/* 109 */         this.client.sendByte(255);
/*     */       } else {
/* 111 */         this.client.sendByte(paramInt);
/*     */       } 
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
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 127 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 144 */     synchronized (this.client) {
/*     */       
/* 146 */       while (paramInt2-- > 0) {
/* 147 */         write(paramArrayOfbyte[paramInt1++]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 156 */     this.client.flushOutputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 163 */     this.client.closeOutputStream();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\TelnetOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */