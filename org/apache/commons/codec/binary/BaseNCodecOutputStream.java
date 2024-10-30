/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BaseNCodecOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*     */   private final boolean doEncode;
/*     */   private final BaseNCodec baseNCodec;
/*  46 */   private final byte[] singleByte = new byte[1];
/*     */   
/*  48 */   private final BaseNCodec.Context context = new BaseNCodec.Context();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BaseNCodecOutputStream(OutputStream paramOutputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean) {
/*  58 */     super(paramOutputStream);
/*  59 */     this.baseNCodec = paramBaseNCodec;
/*  60 */     this.doEncode = paramBoolean;
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
/*     */   public void close() throws IOException {
/*  77 */     eof();
/*  78 */     flush();
/*  79 */     this.out.close();
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
/*     */   public void eof() throws IOException {
/*  91 */     if (this.doEncode) {
/*  92 */       this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
/*     */     } else {
/*  94 */       this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
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
/*     */   public void flush() throws IOException {
/* 106 */     flush(true);
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
/*     */   private void flush(boolean paramBoolean) throws IOException {
/* 119 */     int i = this.baseNCodec.available(this.context);
/* 120 */     if (i > 0) {
/* 121 */       byte[] arrayOfByte = new byte[i];
/* 122 */       int j = this.baseNCodec.readResults(arrayOfByte, 0, i, this.context);
/* 123 */       if (j > 0) {
/* 124 */         this.out.write(arrayOfByte, 0, j);
/*     */       }
/*     */     } 
/* 127 */     if (paramBoolean) {
/* 128 */       this.out.flush();
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
/*     */   public boolean isStrictDecoding() {
/* 143 */     return this.baseNCodec.isStrictDecoding();
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
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 166 */     Objects.requireNonNull(paramArrayOfbyte, "array");
/* 167 */     if (paramInt1 < 0 || paramInt2 < 0)
/* 168 */       throw new IndexOutOfBoundsException(); 
/* 169 */     if (paramInt1 > paramArrayOfbyte.length || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/* 170 */       throw new IndexOutOfBoundsException(); 
/* 171 */     if (paramInt2 > 0) {
/* 172 */       if (this.doEncode) {
/* 173 */         this.baseNCodec.encode(paramArrayOfbyte, paramInt1, paramInt2, this.context);
/*     */       } else {
/* 175 */         this.baseNCodec.decode(paramArrayOfbyte, paramInt1, paramInt2, this.context);
/*     */       } 
/* 177 */       flush(false);
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
/*     */   public void write(int paramInt) throws IOException {
/* 191 */     this.singleByte[0] = (byte)paramInt;
/* 192 */     write(this.singleByte, 0, 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\BaseNCodecOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */