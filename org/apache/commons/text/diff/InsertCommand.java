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
/*    */ public class InsertCommand<T>
/*    */   extends EditCommand<T>
/*    */ {
/*    */   public InsertCommand(T paramT) {
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
/*    */   
/*    */   public void accept(CommandVisitor<T> paramCommandVisitor) {
/* 55 */     paramCommandVisitor.visitInsertCommand(getObject());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\InsertCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */