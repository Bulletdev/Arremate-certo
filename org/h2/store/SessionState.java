/*    */ package org.h2.store;
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
/*    */ class SessionState
/*    */ {
/*    */   public int sessionId;
/*    */   public int lastCommitLog;
/*    */   public int lastCommitPos;
/*    */   public PageStoreInDoubtTransaction inDoubtTransaction;
/*    */   
/*    */   public boolean isCommitted(int paramInt1, int paramInt2) {
/* 43 */     if (paramInt1 != this.lastCommitLog) {
/* 44 */       return (this.lastCommitLog > paramInt1);
/*    */     }
/* 46 */     return (this.lastCommitPos >= paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "sessionId:" + this.sessionId + " log:" + this.lastCommitLog + " pos:" + this.lastCommitPos + " inDoubt:" + this.inDoubtTransaction;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\SessionState.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */