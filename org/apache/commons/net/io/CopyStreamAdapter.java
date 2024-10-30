/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.util.EventListener;
/*     */ import org.apache.commons.net.util.ListenerList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CopyStreamAdapter
/*     */   implements CopyStreamListener
/*     */ {
/*  49 */   private final ListenerList internalListeners = new ListenerList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bytesTransferred(CopyStreamEvent paramCopyStreamEvent) {
/*  65 */     for (EventListener eventListener : this.internalListeners)
/*     */     {
/*  67 */       ((CopyStreamListener)eventListener).bytesTransferred(paramCopyStreamEvent);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bytesTransferred(long paramLong1, int paramInt, long paramLong2) {
/*  90 */     for (EventListener eventListener : this.internalListeners)
/*     */     {
/*  92 */       ((CopyStreamListener)eventListener).bytesTransferred(paramLong1, paramInt, paramLong2);
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
/*     */   public void addCopyStreamListener(CopyStreamListener paramCopyStreamListener) {
/* 105 */     this.internalListeners.addListener(paramCopyStreamListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCopyStreamListener(CopyStreamListener paramCopyStreamListener) {
/* 115 */     this.internalListeners.removeListener(paramCopyStreamListener);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\CopyStreamAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */