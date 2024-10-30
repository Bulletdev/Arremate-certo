/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransactionCommand
/*     */   extends Prepared
/*     */ {
/*     */   private final int type;
/*     */   private String savepointName;
/*     */   private String transactionName;
/*     */   
/*     */   public TransactionCommand(Session paramSession, int paramInt) {
/*  25 */     super(paramSession);
/*  26 */     this.type = paramInt;
/*     */   }
/*     */   
/*     */   public void setSavepointName(String paramString) {
/*  30 */     this.savepointName = paramString;
/*     */   }
/*     */   
/*     */   public int update() {
/*     */     Database database;
/*  35 */     switch (this.type)
/*     */     { case 69:
/*  37 */         this.session.setAutoCommit(true);
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
/* 117 */         return 0;case 70: this.session.setAutoCommit(false); return 0;case 83: this.session.begin(); return 0;case 71: this.session.commit(false); return 0;case 72: this.session.rollback(); return 0;case 73: this.session.getUser().checkAdmin(); this.session.getDatabase().checkpoint(); return 0;case 74: this.session.addSavepoint(this.savepointName); return 0;case 75: this.session.rollbackToSavepoint(this.savepointName); return 0;case 76: this.session.getUser().checkAdmin(); this.session.getDatabase().sync(); return 0;case 77: this.session.prepareCommit(this.transactionName); return 0;case 78: this.session.getUser().checkAdmin(); this.session.setPreparedTransaction(this.transactionName, true); return 0;case 79: this.session.getUser().checkAdmin(); this.session.setPreparedTransaction(this.transactionName, false); return 0;case 81: this.session.getUser().checkAdmin(); this.session.getDatabase().shutdownImmediately(); return 0;case 80: case 82: case 84: this.session.getUser().checkAdmin(); this.session.commit(false); if (this.type == 82 || this.type == 84) this.session.getDatabase().setCompactMode(this.type);  this.session.getDatabase().setCloseDelay(0); database = this.session.getDatabase(); this.session.throttle(); for (Session session : database.getSessions(false)) { if (database.isMultiThreaded()) { synchronized (session) { session.rollback(); }  } else { session.rollback(); }  if (session != this.session) session.close();  }  this.session.close(); return 0; }  DbException.throwInternalError("type=" + this.type); return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 122 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRecompile() {
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public void setTransactionName(String paramString) {
/* 131 */     this.transactionName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 141 */     return this.type;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\TransactionCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */