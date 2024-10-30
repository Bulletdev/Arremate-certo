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
/*    */ public abstract class EditCommand<T>
/*    */ {
/*    */   private final T object;
/*    */   
/*    */   protected EditCommand(T paramT) {
/* 66 */     this.object = paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected T getObject() {
/* 75 */     return this.object;
/*    */   }
/*    */   
/*    */   public abstract void accept(CommandVisitor<T> paramCommandVisitor);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\EditCommand.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */