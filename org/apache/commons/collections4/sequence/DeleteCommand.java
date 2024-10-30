/*    */ package org.apache.commons.collections4.sequence;
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
/*    */ public class DeleteCommand<T>
/*    */   extends EditCommand<T>
/*    */ {
/*    */   public DeleteCommand(T paramT) {
/* 42 */     super(paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void accept(CommandVisitor<T> paramCommandVisitor) {
/* 53 */     paramCommandVisitor.visitDeleteCommand(getObject());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\sequence\DeleteCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */