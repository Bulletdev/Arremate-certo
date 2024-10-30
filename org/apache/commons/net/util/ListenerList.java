/*    */ package org.apache.commons.net.util;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.EventListener;
/*    */ import java.util.Iterator;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ListenerList
/*    */   implements Serializable, Iterable<EventListener>
/*    */ {
/*    */   private static final long serialVersionUID = -1934227607974228213L;
/* 36 */   private final CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<>();
/*    */ 
/*    */ 
/*    */   
/*    */   public void addListener(EventListener paramEventListener) {
/* 41 */     this.listeners.add(paramEventListener);
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeListener(EventListener paramEventListener) {
/* 46 */     this.listeners.remove(paramEventListener);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getListenerCount() {
/* 51 */     return this.listeners.size();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<EventListener> iterator() {
/* 63 */     return this.listeners.iterator();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\ListenerList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */