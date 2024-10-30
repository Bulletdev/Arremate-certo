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
/*     */ @Deprecated
/*     */ public class BasicEofSensorWatcher
/*     */   implements EofSensorWatcher
/*     */ {
/*     */   protected final ManagedClientConnection managedConn;
/*     */   protected final boolean attemptReuse;
/*     */   
/*     */   public BasicEofSensorWatcher(ManagedClientConnection paramManagedClientConnection, boolean paramBoolean) {
/*  59 */     Args.notNull(paramManagedClientConnection, "Connection");
/*  60 */     this.managedConn = paramManagedClientConnection;
/*  61 */     this.attemptReuse = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean eofDetected(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  69 */       if (this.attemptReuse) {
/*     */ 
/*     */         
/*  72 */         paramInputStream.close();
/*  73 */         this.managedConn.markReusable();
/*     */       } 
/*     */     } finally {
/*  76 */       this.managedConn.releaseConnection();
/*     */     } 
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean streamClosed(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  86 */       if (this.attemptReuse) {
/*     */ 
/*     */         
/*  89 */         paramInputStream.close();
/*  90 */         this.managedConn.markReusable();
/*     */       } 
/*     */     } finally {
/*  93 */       this.managedConn.releaseConnection();
/*     */     } 
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean streamAbort(InputStream paramInputStream) throws IOException {
/* 102 */     this.managedConn.abortConnection();
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\BasicEofSensorWatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */