/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.io.EofSensor;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ import org.apache.http.io.SessionInputBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class LoggingSessionInputBuffer
/*     */   implements EofSensor, SessionInputBuffer
/*     */ {
/*     */   private final SessionInputBuffer in;
/*     */   private final EofSensor eofSensor;
/*     */   private final Wire wire;
/*     */   private final String charset;
/*     */   
/*     */   public LoggingSessionInputBuffer(SessionInputBuffer paramSessionInputBuffer, Wire paramWire, String paramString) {
/*  69 */     this.in = paramSessionInputBuffer;
/*  70 */     this.eofSensor = (paramSessionInputBuffer instanceof EofSensor) ? (EofSensor)paramSessionInputBuffer : null;
/*  71 */     this.wire = paramWire;
/*  72 */     this.charset = (paramString != null) ? paramString : Consts.ASCII.name();
/*     */   }
/*     */   
/*     */   public LoggingSessionInputBuffer(SessionInputBuffer paramSessionInputBuffer, Wire paramWire) {
/*  76 */     this(paramSessionInputBuffer, paramWire, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDataAvailable(int paramInt) throws IOException {
/*  81 */     return this.in.isDataAvailable(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  86 */     int i = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
/*  87 */     if (this.wire.enabled() && i > 0) {
/*  88 */       this.wire.input(paramArrayOfbyte, paramInt1, i);
/*     */     }
/*  90 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  95 */     int i = this.in.read();
/*  96 */     if (this.wire.enabled() && i != -1) {
/*  97 */       this.wire.input(i);
/*     */     }
/*  99 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 104 */     int i = this.in.read(paramArrayOfbyte);
/* 105 */     if (this.wire.enabled() && i > 0) {
/* 106 */       this.wire.input(paramArrayOfbyte, 0, i);
/*     */     }
/* 108 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String readLine() throws IOException {
/* 113 */     String str = this.in.readLine();
/* 114 */     if (this.wire.enabled() && str != null) {
/* 115 */       String str1 = str + "\r\n";
/* 116 */       this.wire.input(str1.getBytes(this.charset));
/*     */     } 
/* 118 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readLine(CharArrayBuffer paramCharArrayBuffer) throws IOException {
/* 123 */     int i = this.in.readLine(paramCharArrayBuffer);
/* 124 */     if (this.wire.enabled() && i >= 0) {
/* 125 */       int j = paramCharArrayBuffer.length() - i;
/* 126 */       String str1 = new String(paramCharArrayBuffer.buffer(), j, i);
/* 127 */       String str2 = str1 + "\r\n";
/* 128 */       this.wire.input(str2.getBytes(this.charset));
/*     */     } 
/* 130 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpTransportMetrics getMetrics() {
/* 135 */     return this.in.getMetrics();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEof() {
/* 140 */     if (this.eofSensor != null) {
/* 141 */       return this.eofSensor.isEof();
/*     */     }
/* 143 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\LoggingSessionInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */