/*    */ package org.apache.http.impl.conn.tsccm;
/*    */ 
/*    */ import org.apache.http.conn.ClientConnectionManager;
/*    */ import org.apache.http.impl.conn.AbstractPoolEntry;
/*    */ import org.apache.http.impl.conn.AbstractPooledConnAdapter;
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
/*    */ public class BasicPooledConnAdapter
/*    */   extends AbstractPooledConnAdapter
/*    */ {
/*    */   protected BasicPooledConnAdapter(ThreadSafeClientConnManager paramThreadSafeClientConnManager, AbstractPoolEntry paramAbstractPoolEntry) {
/* 53 */     super(paramThreadSafeClientConnManager, paramAbstractPoolEntry);
/* 54 */     markReusable();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ClientConnectionManager getManager() {
/* 60 */     return super.getManager();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AbstractPoolEntry getPoolEntry() {
/* 66 */     return super.getPoolEntry();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void detach() {
/* 72 */     super.detach();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\BasicPooledConnAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */