/*     */ package org.apache.http.impl.conn;
/*     */ 
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
/*     */ class LoggingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final InputStream in;
/*     */   private final Wire wire;
/*     */   
/*     */   public LoggingInputStream(InputStream paramInputStream, Wire paramWire) {
/*  45 */     this.in = paramInputStream;
/*  46 */     this.wire = paramWire;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*     */     try {
/*  52 */       int i = this.in.read();
/*  53 */       if (i == -1) {
/*  54 */         this.wire.input("end of stream");
/*     */       } else {
/*  56 */         this.wire.input(i);
/*     */       } 
/*  58 */       return i;
/*  59 */     } catch (IOException iOException) {
/*  60 */       this.wire.input("[read] I/O error: " + iOException.getMessage());
/*  61 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*     */     try {
/*  68 */       int i = this.in.read(paramArrayOfbyte);
/*  69 */       if (i == -1) {
/*  70 */         this.wire.input("end of stream");
/*  71 */       } else if (i > 0) {
/*  72 */         this.wire.input(paramArrayOfbyte, 0, i);
/*     */       } 
/*  74 */       return i;
/*  75 */     } catch (IOException iOException) {
/*  76 */       this.wire.input("[read] I/O error: " + iOException.getMessage());
/*  77 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/*  84 */       int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/*  85 */       if (i == -1) {
/*  86 */         this.wire.input("end of stream");
/*  87 */       } else if (i > 0) {
/*  88 */         this.wire.input(paramArrayOfbyte, paramInt1, i);
/*     */       } 
/*  90 */       return i;
/*  91 */     } catch (IOException iOException) {
/*  92 */       this.wire.input("[read] I/O error: " + iOException.getMessage());
/*  93 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/*     */     try {
/* 100 */       return super.skip(paramLong);
/* 101 */     } catch (IOException iOException) {
/* 102 */       this.wire.input("[skip] I/O error: " + iOException.getMessage());
/* 103 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/*     */     try {
/* 110 */       return this.in.available();
/* 111 */     } catch (IOException iOException) {
/* 112 */       this.wire.input("[available] I/O error : " + iOException.getMessage());
/* 113 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 119 */     super.mark(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() throws IOException {
/* 124 */     super.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 129 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/* 135 */       this.in.close();
/* 136 */     } catch (IOException iOException) {
/* 137 */       this.wire.input("[close] I/O error: " + iOException.getMessage());
/* 138 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\LoggingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */