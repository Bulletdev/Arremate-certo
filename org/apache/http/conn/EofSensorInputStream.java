/*     */ package org.apache.http.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EofSensorInputStream
/*     */   extends InputStream
/*     */   implements ConnectionReleaseTrigger
/*     */ {
/*     */   protected InputStream wrappedStream;
/*     */   private boolean selfClosed;
/*     */   private final EofSensorWatcher eofWatcher;
/*     */   
/*     */   public EofSensorInputStream(InputStream paramInputStream, EofSensorWatcher paramEofSensorWatcher) {
/*  82 */     Args.notNull(paramInputStream, "Wrapped stream");
/*  83 */     this.wrappedStream = paramInputStream;
/*  84 */     this.selfClosed = false;
/*  85 */     this.eofWatcher = paramEofSensorWatcher;
/*     */   }
/*     */   
/*     */   boolean isSelfClosed() {
/*  89 */     return this.selfClosed;
/*     */   }
/*     */   
/*     */   InputStream getWrappedStream() {
/*  93 */     return this.wrappedStream;
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
/*     */   protected boolean isReadAllowed() throws IOException {
/* 106 */     if (this.selfClosed) {
/* 107 */       throw new IOException("Attempted read on closed stream.");
/*     */     }
/* 109 */     return (this.wrappedStream != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 114 */     int i = -1;
/*     */     
/* 116 */     if (isReadAllowed()) {
/*     */       try {
/* 118 */         i = this.wrappedStream.read();
/* 119 */         checkEOF(i);
/* 120 */       } catch (IOException iOException) {
/* 121 */         checkAbort();
/* 122 */         throw iOException;
/*     */       } 
/*     */     }
/*     */     
/* 126 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 131 */     int i = -1;
/*     */     
/* 133 */     if (isReadAllowed()) {
/*     */       try {
/* 135 */         i = this.wrappedStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/* 136 */         checkEOF(i);
/* 137 */       } catch (IOException iOException) {
/* 138 */         checkAbort();
/* 139 */         throw iOException;
/*     */       } 
/*     */     }
/*     */     
/* 143 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 148 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 153 */     int i = 0;
/*     */     
/* 155 */     if (isReadAllowed()) {
/*     */       try {
/* 157 */         i = this.wrappedStream.available();
/*     */       }
/* 159 */       catch (IOException iOException) {
/* 160 */         checkAbort();
/* 161 */         throw iOException;
/*     */       } 
/*     */     }
/*     */     
/* 165 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 171 */     this.selfClosed = true;
/* 172 */     checkClose();
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
/*     */   protected void checkEOF(int paramInt) throws IOException {
/* 194 */     InputStream inputStream = this.wrappedStream;
/* 195 */     if (inputStream != null && paramInt < 0) {
/*     */       try {
/* 197 */         boolean bool = true;
/* 198 */         if (this.eofWatcher != null) {
/* 199 */           bool = this.eofWatcher.eofDetected(inputStream);
/*     */         }
/* 201 */         if (bool) {
/* 202 */           inputStream.close();
/*     */         }
/*     */       } finally {
/* 205 */         this.wrappedStream = null;
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
/*     */ 
/*     */   
/*     */   protected void checkClose() throws IOException {
/* 223 */     InputStream inputStream = this.wrappedStream;
/* 224 */     if (inputStream != null) {
/*     */       try {
/* 226 */         boolean bool = true;
/* 227 */         if (this.eofWatcher != null) {
/* 228 */           bool = this.eofWatcher.streamClosed(inputStream);
/*     */         }
/* 230 */         if (bool) {
/* 231 */           inputStream.close();
/*     */         }
/*     */       } finally {
/* 234 */         this.wrappedStream = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkAbort() throws IOException {
/* 254 */     InputStream inputStream = this.wrappedStream;
/* 255 */     if (inputStream != null) {
/*     */       try {
/* 257 */         boolean bool = true;
/* 258 */         if (this.eofWatcher != null) {
/* 259 */           bool = this.eofWatcher.streamAbort(inputStream);
/*     */         }
/* 261 */         if (bool) {
/* 262 */           inputStream.close();
/*     */         }
/*     */       } finally {
/* 265 */         this.wrappedStream = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection() throws IOException {
/* 275 */     close();
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
/*     */   public void abortConnection() throws IOException {
/* 288 */     this.selfClosed = true;
/* 289 */     checkAbort();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\EofSensorInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */