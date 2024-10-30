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
/*    */ 
/*    */ 
/*    */ public class KeepCommand<T>
/*    */   extends EditCommand<T>
/*    */ {
/*    */   public KeepCommand(T paramT) {
/* 45 */     super(paramT);
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
/* 56 */     paramCommandVisitor.visitKeepCommand(getObject());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\KeepCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */