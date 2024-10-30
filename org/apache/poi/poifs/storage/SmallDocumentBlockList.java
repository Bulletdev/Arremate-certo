/*    */ package org.apache.poi.poifs.storage;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ public class SmallDocumentBlockList
/*    */   extends BlockListImpl
/*    */ {
/*    */   public SmallDocumentBlockList(List<SmallDocumentBlock> paramList) {
/* 38 */     setBlocks(paramList.<ListManagedBlock>toArray((ListManagedBlock[])new SmallDocumentBlock[paramList.size()]));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\SmallDocumentBlockList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */