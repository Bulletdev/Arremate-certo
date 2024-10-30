/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.util.EventObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CopyStreamEvent
/*     */   extends EventObject
/*     */ {
/*     */   private static final long serialVersionUID = -964927635655051867L;
/*     */   public static final long UNKNOWN_STREAM_SIZE = -1L;
/*     */   private final int bytesTransferred;
/*     */   private final long totalBytesTransferred;
/*     */   private final long streamSize;
/*     */   
/*     */   public CopyStreamEvent(Object paramObject, long paramLong1, int paramInt, long paramLong2) {
/*  60 */     super(paramObject);
/*  61 */     this.bytesTransferred = paramInt;
/*  62 */     this.totalBytesTransferred = paramLong1;
/*  63 */     this.streamSize = paramLong2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBytesTransferred() {
/*  74 */     return this.bytesTransferred;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTotalBytesTransferred() {
/*  85 */     return this.totalBytesTransferred;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getStreamSize() {
/*  96 */     return this.streamSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     return getClass().getName() + "[source=" + this.source + ", total=" + this.totalBytesTransferred + ", bytes=" + this.bytesTransferred + ", size=" + this.streamSize + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\CopyStreamEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */