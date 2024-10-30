/*    */ package org.apache.commons.text.diff;
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
/*    */ public class DeleteCommand<T>
/*    */   extends EditCommand<T>
/*    */ {
/*    */   public DeleteCommand(T paramT) {
/* 43 */     super(paramT);
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
/* 54 */     paramCommandVisitor.visitDeleteCommand(getObject());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\DeleteCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */