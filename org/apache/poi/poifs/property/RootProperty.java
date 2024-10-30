/*    */ package org.apache.poi.poifs.property;
/*    */ 
/*    */ import org.apache.poi.poifs.storage.SmallDocumentBlock;
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
/*    */ public final class RootProperty
/*    */   extends DirectoryProperty
/*    */ {
/*    */   private static final String NAME = "Root Entry";
/*    */   
/*    */   RootProperty() {
/* 31 */     super("Root Entry");
/*    */ 
/*    */     
/* 34 */     setNodeColor((byte)1);
/* 35 */     setPropertyType((byte)5);
/* 36 */     setStartBlock(-2);
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
/*    */   
/*    */   protected RootProperty(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 49 */     super(paramInt1, paramArrayOfbyte, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSize(int paramInt) {
/* 59 */     super.setSize(SmallDocumentBlock.calcSize(paramInt));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 68 */     return "Root Entry";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\RootProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */