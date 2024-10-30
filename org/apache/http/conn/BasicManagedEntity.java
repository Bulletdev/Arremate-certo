/*     */ package org.apache.http.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.SocketException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.entity.HttpEntityWrapper;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class BasicManagedEntity
/*     */   extends HttpEntityWrapper
/*     */   implements ConnectionReleaseTrigger, EofSensorWatcher
/*     */ {
/*     */   protected ManagedClientConnection managedConn;
/*     */   protected final boolean attemptReuse;
/*     */   
/*     */   public BasicManagedEntity(HttpEntity paramHttpEntity, ManagedClientConnection paramManagedClientConnection, boolean paramBoolean) {
/*  72 */     super(paramHttpEntity);
/*  73 */     Args.notNull(paramManagedClientConnection, "Connection");
/*  74 */     this.managedConn = paramManagedClientConnection;
/*  75 */     this.attemptReuse = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException {
/*  85 */     return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
/*     */   }
/*     */   
/*     */   private void ensureConsumed() throws IOException {
/*  89 */     if (this.managedConn == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  94 */       if (this.attemptReuse) {
/*     */         
/*  96 */         EntityUtils.consume(this.wrappedEntity);
/*  97 */         this.managedConn.markReusable();
/*     */       } else {
/*  99 */         this.managedConn.unmarkReusable();
/*     */       } 
/*     */     } finally {
/* 102 */       releaseManagedConnection();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void consumeContent() throws IOException {
/* 112 */     ensureConsumed();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 117 */     super.writeTo(paramOutputStream);
/* 118 */     ensureConsumed();
/*     */   }
/*     */ 
/*     */   
/*     */   public void releaseConnection() throws IOException {
/* 123 */     ensureConsumed();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void abortConnection() throws IOException {
/* 129 */     if (this.managedConn != null) {
/*     */       try {
/* 131 */         this.managedConn.abortConnection();
/*     */       } finally {
/* 133 */         this.managedConn = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean eofDetected(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 141 */       if (this.managedConn != null) {
/* 142 */         if (this.attemptReuse) {
/*     */ 
/*     */           
/* 145 */           paramInputStream.close();
/* 146 */           this.managedConn.markReusable();
/*     */         } else {
/* 148 */           this.managedConn.unmarkReusable();
/*     */         } 
/*     */       }
/*     */     } finally {
/* 152 */       releaseManagedConnection();
/*     */     } 
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean streamClosed(InputStream paramInputStream) throws IOException {
/*     */     try {
/* 160 */       if (this.managedConn != null) {
/* 161 */         if (this.attemptReuse) {
/* 162 */           boolean bool = this.managedConn.isOpen();
/*     */ 
/*     */           
/*     */           try {
/* 166 */             paramInputStream.close();
/* 167 */             this.managedConn.markReusable();
/* 168 */           } catch (SocketException socketException) {
/* 169 */             if (bool) {
/* 170 */               throw socketException;
/*     */             }
/*     */           } 
/*     */         } else {
/* 174 */           this.managedConn.unmarkReusable();
/*     */         } 
/*     */       }
/*     */     } finally {
/* 178 */       releaseManagedConnection();
/*     */     } 
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean streamAbort(InputStream paramInputStream) throws IOException {
/* 185 */     if (this.managedConn != null) {
/* 186 */       this.managedConn.abortConnection();
/*     */     }
/* 188 */     return false;
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
/*     */   protected void releaseManagedConnection() throws IOException {
/* 202 */     if (this.managedConn != null)
/*     */       try {
/* 204 */         this.managedConn.releaseConnection();
/*     */       } finally {
/* 206 */         this.managedConn = null;
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\BasicManagedEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */