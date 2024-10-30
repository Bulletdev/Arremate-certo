/*    */ package org.h2.command.dml;
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
/*    */ public class NoOperation
/*    */   extends Prepared
/*    */ {
/*    */   public NoOperation(Session paramSession) {
/* 19 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 24 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 29 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean needRecompile() {
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReadOnly() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface queryMeta() {
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 49 */     return 63;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\NoOperation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */