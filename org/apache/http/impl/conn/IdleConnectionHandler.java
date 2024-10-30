/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpConnection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class IdleConnectionHandler
/*     */ {
/*  54 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final Map<HttpConnection, TimeValues> connectionToTimes;
/*     */ 
/*     */ 
/*     */   
/*     */   public IdleConnectionHandler() {
/*  62 */     this.connectionToTimes = new HashMap<HttpConnection, TimeValues>();
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
/*     */   public void add(HttpConnection paramHttpConnection, long paramLong, TimeUnit paramTimeUnit) {
/*  75 */     long l = System.currentTimeMillis();
/*     */     
/*  77 */     if (this.log.isDebugEnabled()) {
/*  78 */       this.log.debug("Adding connection at: " + l);
/*     */     }
/*     */     
/*  81 */     this.connectionToTimes.put(paramHttpConnection, new TimeValues(l, paramLong, paramTimeUnit));
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
/*     */   public boolean remove(HttpConnection paramHttpConnection) {
/*  93 */     TimeValues timeValues = this.connectionToTimes.remove(paramHttpConnection);
/*  94 */     if (timeValues == null) {
/*  95 */       this.log.warn("Removing a connection that never existed!");
/*  96 */       return true;
/*     */     } 
/*  98 */     return (System.currentTimeMillis() <= timeValues.timeExpires);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAll() {
/* 106 */     this.connectionToTimes.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong) {
/* 117 */     long l = System.currentTimeMillis() - paramLong;
/*     */     
/* 119 */     if (this.log.isDebugEnabled()) {
/* 120 */       this.log.debug("Checking for connections, idle timeout: " + l);
/*     */     }
/*     */     
/* 123 */     for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
/* 124 */       HttpConnection httpConnection = (HttpConnection)entry.getKey();
/* 125 */       TimeValues timeValues = (TimeValues)entry.getValue();
/* 126 */       long l1 = timeValues.timeAdded;
/* 127 */       if (l1 <= l) {
/* 128 */         if (this.log.isDebugEnabled()) {
/* 129 */           this.log.debug("Closing idle connection, connection time: " + l1);
/*     */         }
/*     */         try {
/* 132 */           httpConnection.close();
/* 133 */         } catch (IOException iOException) {
/* 134 */           this.log.debug("I/O error closing connection", iOException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 142 */     long l = System.currentTimeMillis();
/* 143 */     if (this.log.isDebugEnabled()) {
/* 144 */       this.log.debug("Checking for expired connections, now: " + l);
/*     */     }
/*     */     
/* 147 */     for (Map.Entry<HttpConnection, TimeValues> entry : this.connectionToTimes.entrySet()) {
/* 148 */       HttpConnection httpConnection = (HttpConnection)entry.getKey();
/* 149 */       TimeValues timeValues = (TimeValues)entry.getValue();
/* 150 */       if (timeValues.timeExpires <= l) {
/* 151 */         if (this.log.isDebugEnabled()) {
/* 152 */           this.log.debug("Closing connection, expired @: " + timeValues.timeExpires);
/*     */         }
/*     */         try {
/* 155 */           httpConnection.close();
/* 156 */         } catch (IOException iOException) {
/* 157 */           this.log.debug("I/O error closing connection", iOException);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class TimeValues
/*     */   {
/*     */     private final long timeAdded;
/*     */     
/*     */     private final long timeExpires;
/*     */ 
/*     */     
/*     */     TimeValues(long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
/* 173 */       this.timeAdded = param1Long1;
/* 174 */       if (param1Long2 > 0L) {
/* 175 */         this.timeExpires = param1Long1 + param1TimeUnit.toMillis(param1Long2);
/*     */       } else {
/* 177 */         this.timeExpires = Long.MAX_VALUE;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\IdleConnectionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */