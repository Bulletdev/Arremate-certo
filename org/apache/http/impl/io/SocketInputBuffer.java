/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import org.apache.http.io.EofSensor;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class SocketInputBuffer
/*     */   extends AbstractSessionInputBuffer
/*     */   implements EofSensor
/*     */ {
/*     */   private final Socket socket;
/*     */   private boolean eof;
/*     */   
/*     */   public SocketInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams) throws IOException {
/*  67 */     Args.notNull(paramSocket, "Socket");
/*  68 */     this.socket = paramSocket;
/*  69 */     this.eof = false;
/*  70 */     int i = paramInt;
/*  71 */     if (i < 0) {
/*  72 */       i = paramSocket.getReceiveBufferSize();
/*     */     }
/*  74 */     if (i < 1024) {
/*  75 */       i = 1024;
/*     */     }
/*  77 */     init(paramSocket.getInputStream(), i, paramHttpParams);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int fillBuffer() throws IOException {
/*  82 */     int i = super.fillBuffer();
/*  83 */     this.eof = (i == -1);
/*  84 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDataAvailable(int paramInt) throws IOException {
/*  89 */     boolean bool = hasBufferedData();
/*  90 */     if (!bool) {
/*  91 */       int i = this.socket.getSoTimeout();
/*     */       try {
/*  93 */         this.socket.setSoTimeout(paramInt);
/*  94 */         fillBuffer();
/*  95 */         bool = hasBufferedData();
/*     */       } finally {
/*  97 */         this.socket.setSoTimeout(i);
/*     */       } 
/*     */     } 
/* 100 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEof() {
/* 105 */     return this.eof;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\SocketInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */