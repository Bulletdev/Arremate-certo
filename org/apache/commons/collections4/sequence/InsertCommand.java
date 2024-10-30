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
/*    */ public class InsertCommand<T>
/*    */   extends EditCommand<T>
/*    */ {
/*    */   public InsertCommand(T paramT) {
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
/*    */   
/*    */   public void accept(CommandVisitor<T> paramCommandVisitor) {
/* 54 */     paramCommandVisitor.visitInsertCommand(getObject());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\sequence\InsertCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */