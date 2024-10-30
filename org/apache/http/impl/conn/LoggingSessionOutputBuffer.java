/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class LoggingSessionOutputBuffer
/*     */   implements SessionOutputBuffer
/*     */ {
/*     */   private final SessionOutputBuffer out;
/*     */   private final Wire wire;
/*     */   private final String charset;
/*     */   
/*     */   public LoggingSessionOutputBuffer(SessionOutputBuffer paramSessionOutputBuffer, Wire paramWire, String paramString) {
/*  64 */     this.out = paramSessionOutputBuffer;
/*  65 */     this.wire = paramWire;
/*  66 */     this.charset = (paramString != null) ? paramString : Consts.ASCII.name();
/*     */   }
/*     */   
/*     */   public LoggingSessionOutputBuffer(SessionOutputBuffer paramSessionOutputBuffer, Wire paramWire) {
/*  70 */     this(paramSessionOutputBuffer, paramWire, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  75 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*  76 */     if (this.wire.enabled()) {
/*  77 */       this.wire.output(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/*  83 */     this.out.write(paramInt);
/*  84 */     if (this.wire.enabled()) {
/*  85 */       this.wire.output(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/*  91 */     this.out.write(paramArrayOfbyte);
/*  92 */     if (this.wire.enabled()) {
/*  93 */       this.wire.output(paramArrayOfbyte);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  99 */     this.out.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
/* 104 */     this.out.writeLine(paramCharArrayBuffer);
/* 105 */     if (this.wire.enabled()) {
/* 106 */       String str1 = new String(paramCharArrayBuffer.buffer(), 0, paramCharArrayBuffer.length());
/* 107 */       String str2 = str1 + "\r\n";
/* 108 */       this.wire.output(str2.getBytes(this.charset));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeLine(String paramString) throws IOException {
/* 114 */     this.out.writeLine(paramString);
/* 115 */     if (this.wire.enabled()) {
/* 116 */       String str = paramString + "\r\n";
/* 117 */       this.wire.output(str.getBytes(this.charset));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 123 */     return this.out.getMetrics();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\LoggingSessionOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */