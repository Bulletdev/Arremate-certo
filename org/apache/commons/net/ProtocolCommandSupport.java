/*     */ package org.apache.commons.net;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class ProtocolCommandSupport
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8017692739988399978L;
/*     */   private final Object source;
/*     */   private final ListenerList listeners;
/*     */   
/*     */   public ProtocolCommandSupport(Object paramObject) {
/*  51 */     this.listeners = new ListenerList();
/*  52 */     this.source = paramObject;
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
/*     */   public void fireCommandSent(String paramString1, String paramString2) {
/*  71 */     ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.source, paramString1, paramString2);
/*     */     
/*  73 */     for (EventListener eventListener : this.listeners)
/*     */     {
/*  75 */       ((ProtocolCommandListener)eventListener).protocolCommandSent(protocolCommandEvent);
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
/*     */   public void fireReplyReceived(int paramInt, String paramString) {
/*  95 */     ProtocolCommandEvent protocolCommandEvent = new ProtocolCommandEvent(this.source, paramInt, paramString);
/*     */     
/*  97 */     for (EventListener eventListener : this.listeners)
/*     */     {
/*  99 */       ((ProtocolCommandListener)eventListener).protocolReplyReceived(protocolCommandEvent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProtocolCommandListener(ProtocolCommandListener paramProtocolCommandListener) {
/* 110 */     this.listeners.addListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeProtocolCommandListener(ProtocolCommandListener paramProtocolCommandListener) {
/* 120 */     this.listeners.removeListener(paramProtocolCommandListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getListenerCount() {
/* 131 */     return this.listeners.getListenerCount();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ProtocolCommandSupport.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */