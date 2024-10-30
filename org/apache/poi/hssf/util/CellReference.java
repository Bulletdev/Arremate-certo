/*    */ package org.apache.poi.hssf.util;
/*    */ 
/*    */ import org.apache.poi.ss.util.CellReference;
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
/*    */ public final class CellReference
/*    */   extends CellReference
/*    */ {
/*    */   public CellReference(String paramString) {
/* 31 */     super(paramString);
/*    */   }
/*    */   
/*    */   public CellReference(int paramInt1, int paramInt2) {
/* 35 */     super(paramInt1, paramInt2, true, true);
/*    */   }
/*    */   
/*    */   public CellReference(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 39 */     super(null, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
/*    */   }
/*    */   
/*    */   public CellReference(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 43 */     super(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\CellReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */