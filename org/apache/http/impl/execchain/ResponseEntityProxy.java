/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.SocketException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.conn.EofSensorInputStream;
/*     */ import org.apache.http.conn.EofSensorWatcher;
/*     */ import org.apache.http.entity.HttpEntityWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResponseEntityProxy
/*     */   extends HttpEntityWrapper
/*     */   implements EofSensorWatcher
/*     */ {
/*     */   private final ConnectionHolder connHolder;
/*     */   
/*     */   public static void enchance(HttpResponse paramHttpResponse, ConnectionHolder paramConnectionHolder) {
/*  51 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/*  52 */     if (httpEntity != null && httpEntity.isStreaming() && paramConnectionHolder != null) {
/*  53 */       paramHttpResponse.setEntity((HttpEntity)new ResponseEntityProxy(httpEntity, paramConnectionHolder));
/*     */     }
/*     */   }
/*     */   
/*     */   ResponseEntityProxy(HttpEntity paramHttpEntity, ConnectionHolder paramConnectionHolder) {
/*  58 */     super(paramHttpEntity);
/*  59 */     this.connHolder = paramConnectionHolder;
/*     */   }
/*     */   
/*     */   private void cleanup() throws IOException {
/*  63 */     if (this.connHolder != null) {
/*  64 */       this.connHolder.close();
/*     */     }
/*     */   }
/*     */   
/*     */   private void abortConnection() {
/*  69 */     if (this.connHolder != null) {
/*  70 */       this.connHolder.abortConnection();
/*     */     }
/*     */   }
/*     */   
/*     */   public void releaseConnection() {
/*  75 */     if (this.connHolder != null) {
/*  76 */       this.connHolder.releaseConnection();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/*  87 */     return (InputStream)new EofSensorInputStream(this.wrappedEntity.getContent(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeContent() throws IOException {
/*  92 */     releaseConnection();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/*     */     try {
/*  98 */       if (paramOutputStream != null) {
/*  99 */         this.wrappedEntity.writeTo(paramOutputStream);
/*     */       }
/* 101 */       releaseConnection();
/* 102 */     } catch (IOException iOException) {
/* 103 */       abortConnection();
/* 104 */       throw iOException;
/* 105 */     } catch (RuntimeException runtimeException) {
/* 106 */       abortConnection();
/* 107 */       throw runtimeException;
/*     */     } finally {
/* 109 */       cleanup();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean eofDetected(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 118 */       if (paramInputStream != null) {
/* 119 */         paramInputStream.close();
/*     */       }
/* 121 */       releaseConnection();
/* 122 */     } catch (IOException iOException) {
/* 123 */       abortConnection();
/* 124 */       throw iOException;
/* 125 */     } catch (RuntimeException runtimeException) {
/* 126 */       abortConnection();
/* 127 */       throw runtimeException;
/*     */     } finally {
/* 129 */       cleanup();
/*     */     } 
/* 131 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean streamClosed(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 137 */       boolean bool = (this.connHolder != null && !this.connHolder.isReleased()) ? true : false;
/*     */ 
/*     */       
/*     */       try {
/* 141 */         if (paramInputStream != null) {
/* 142 */           paramInputStream.close();
/*     */         }
/* 144 */         releaseConnection();
/* 145 */       } catch (SocketException socketException) {
/* 146 */         if (bool) {
/* 147 */           throw socketException;
/*     */         }
/*     */       } 
/* 150 */     } catch (IOException iOException) {
/* 151 */       abortConnection();
/* 152 */       throw iOException;
/* 153 */     } catch (RuntimeException runtimeException) {
/* 154 */       abortConnection();
/* 155 */       throw runtimeException;
/*     */     } finally {
/* 157 */       cleanup();
/*     */     } 
/* 159 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean streamAbort(InputStream paramInputStream) throws IOException {
/* 164 */     cleanup();
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 170 */     StringBuilder stringBuilder = new StringBuilder("ResponseEntityProxy{");
/* 171 */     stringBuilder.append(this.wrappedEntity);
/* 172 */     stringBuilder.append('}');
/* 173 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\ResponseEntityProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */