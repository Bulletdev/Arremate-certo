/*    */ package org.apache.http.impl.conn.tsccm;
/*    */ 
/*    */ import java.lang.ref.ReferenceQueue;
/*    */ import java.lang.ref.WeakReference;
/*    */ import org.apache.http.conn.routing.HttpRoute;
/*    */ import org.apache.http.util.Args;
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
/*    */ @Deprecated
/*    */ public class BasicPoolEntryRef
/*    */   extends WeakReference<BasicPoolEntry>
/*    */ {
/*    */   private final HttpRoute route;
/*    */   
/*    */   public BasicPoolEntryRef(BasicPoolEntry paramBasicPoolEntry, ReferenceQueue<Object> paramReferenceQueue) {
/* 59 */     super(paramBasicPoolEntry, paramReferenceQueue);
/* 60 */     Args.notNull(paramBasicPoolEntry, "Pool entry");
/* 61 */     this.route = paramBasicPoolEntry.getPlannedRoute();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final HttpRoute getRoute() {
/* 72 */     return this.route;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\BasicPoolEntryRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */