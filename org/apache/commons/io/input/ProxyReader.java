/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.FilterReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.nio.CharBuffer;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ProxyReader
/*     */   extends FilterReader
/*     */ {
/*     */   public ProxyReader(Reader paramReader) {
/*  46 */     super(paramReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*     */     try {
/*  58 */       beforeRead(1);
/*  59 */       int i = this.in.read();
/*  60 */       afterRead((i != -1) ? 1 : -1);
/*  61 */       return i;
/*  62 */     } catch (IOException iOException) {
/*  63 */       handleIOException(iOException);
/*  64 */       return -1;
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
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/*     */     try {
/*  77 */       beforeRead(IOUtils.length(paramArrayOfchar));
/*  78 */       int i = this.in.read(paramArrayOfchar);
/*  79 */       afterRead(i);
/*  80 */       return i;
/*  81 */     } catch (IOException iOException) {
/*  82 */       handleIOException(iOException);
/*  83 */       return -1;
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/*  98 */       beforeRead(paramInt2);
/*  99 */       int i = this.in.read(paramArrayOfchar, paramInt1, paramInt2);
/* 100 */       afterRead(i);
/* 101 */       return i;
/* 102 */     } catch (IOException iOException) {
/* 103 */       handleIOException(iOException);
/* 104 */       return -1;
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
/*     */   public int read(CharBuffer paramCharBuffer) throws IOException {
/*     */     try {
/* 118 */       beforeRead(IOUtils.length(paramCharBuffer));
/* 119 */       int i = this.in.read(paramCharBuffer);
/* 120 */       afterRead(i);
/* 121 */       return i;
/* 122 */     } catch (IOException iOException) {
/* 123 */       handleIOException(iOException);
/* 124 */       return -1;
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
/*     */   public long skip(long paramLong) throws IOException {
/*     */     try {
/* 137 */       return this.in.skip(paramLong);
/* 138 */     } catch (IOException iOException) {
/* 139 */       handleIOException(iOException);
/* 140 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ready() throws IOException {
/*     */     try {
/* 152 */       return this.in.ready();
/* 153 */     } catch (IOException iOException) {
/* 154 */       handleIOException(iOException);
/* 155 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/* 166 */       this.in.close();
/* 167 */     } catch (IOException iOException) {
/* 168 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) throws IOException {
/*     */     try {
/* 180 */       this.in.mark(paramInt);
/* 181 */     } catch (IOException iOException) {
/* 182 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/*     */     try {
/* 193 */       this.in.reset();
/* 194 */     } catch (IOException iOException) {
/* 195 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 205 */     return this.in.markSupported();
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
/*     */   protected void beforeRead(int paramInt) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void afterRead(int paramInt) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleIOException(IOException paramIOException) throws IOException {
/* 261 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\ProxyReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */