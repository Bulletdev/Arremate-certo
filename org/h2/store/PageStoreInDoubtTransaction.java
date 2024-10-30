/*    */ package org.h2.store;
/*    */ 
/*    */ import org.h2.message.DbException;
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
/*    */ public class PageStoreInDoubtTransaction
/*    */   implements InDoubtTransaction
/*    */ {
/*    */   private final PageStore store;
/*    */   private final int sessionId;
/*    */   private final int pos;
/*    */   private final String transactionName;
/*    */   private int state;
/*    */   
/*    */   public PageStoreInDoubtTransaction(PageStore paramPageStore, int paramInt1, int paramInt2, String paramString) {
/* 31 */     this.store = paramPageStore;
/* 32 */     this.sessionId = paramInt1;
/* 33 */     this.pos = paramInt2;
/* 34 */     this.transactionName = paramString;
/* 35 */     this.state = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setState(int paramInt) {
/* 40 */     switch (paramInt) {
/*    */       case 1:
/* 42 */         this.store.setInDoubtTransactionState(this.sessionId, this.pos, true);
/*    */         break;
/*    */       case 2:
/* 45 */         this.store.setInDoubtTransactionState(this.sessionId, this.pos, false);
/*    */         break;
/*    */       default:
/* 48 */         DbException.throwInternalError("state=" + paramInt); break;
/*    */     } 
/* 50 */     this.state = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getState() {
/* 55 */     switch (this.state) {
/*    */       case 0:
/* 57 */         return "IN_DOUBT";
/*    */       case 1:
/* 59 */         return "COMMIT";
/*    */       case 2:
/* 61 */         return "ROLLBACK";
/*    */     } 
/* 63 */     throw DbException.throwInternalError("state=" + this.state);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTransactionName() {
/* 69 */     return this.transactionName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageStoreInDoubtTransaction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */