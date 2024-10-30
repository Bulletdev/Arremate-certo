/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.command.Prepared;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.result.ResultInterface;
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
/*    */ public abstract class DefineCommand
/*    */   extends Prepared
/*    */ {
/*    */   protected boolean transactional;
/*    */   
/*    */   DefineCommand(Session paramSession) {
/* 30 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReadOnly() {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface queryMeta() {
/* 40 */     return null;
/*    */   }
/*    */   
/*    */   public void setTransactional(boolean paramBoolean) {
/* 44 */     this.transactional = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 49 */     return this.transactional;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DefineCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */