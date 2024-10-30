/*    */ package org.h2.mvstore;
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
/*    */ public class CursorPos
/*    */ {
/*    */   public Page page;
/*    */   public int index;
/*    */   public final CursorPos parent;
/*    */   
/*    */   public CursorPos(Page paramPage, int paramInt, CursorPos paramCursorPos) {
/* 29 */     this.page = paramPage;
/* 30 */     this.index = paramInt;
/* 31 */     this.parent = paramCursorPos;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\CursorPos.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */