/*    */ package org.h2.command;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.expression.ParameterInterface;
/*    */ import org.h2.result.ResultInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class CommandList
/*    */   extends Command
/*    */ {
/*    */   private final Command command;
/*    */   private final String remaining;
/*    */   
/*    */   CommandList(Parser paramParser, String paramString1, Command paramCommand, String paramString2) {
/* 21 */     super(paramParser, paramString1);
/* 22 */     this.command = paramCommand;
/* 23 */     this.remaining = paramString2;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<? extends ParameterInterface> getParameters() {
/* 28 */     return this.command.getParameters();
/*    */   }
/*    */   
/*    */   private void executeRemaining() {
/* 32 */     Command command = this.session.prepareLocal(this.remaining);
/* 33 */     if (command.isQuery()) {
/* 34 */       command.query(0);
/*    */     } else {
/* 36 */       command.update();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 42 */     int i = this.command.executeUpdate();
/* 43 */     executeRemaining();
/* 44 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public void prepareJoinBatch() {
/* 49 */     this.command.prepareJoinBatch();
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface query(int paramInt) {
/* 54 */     ResultInterface resultInterface = this.command.query(paramInt);
/* 55 */     executeRemaining();
/* 56 */     return resultInterface;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isQuery() {
/* 61 */     return this.command.isQuery();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReadOnly() {
/* 71 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface queryMeta() {
/* 76 */     return this.command.queryMeta();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getCommandType() {
/* 81 */     return this.command.getCommandType();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\CommandList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */