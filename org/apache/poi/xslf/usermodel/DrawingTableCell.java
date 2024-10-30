/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
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
/*    */ public class DrawingTableCell
/*    */ {
/*    */   private final CTTableCell cell;
/*    */   private final DrawingTextBody drawingTextBody;
/*    */   
/*    */   public DrawingTableCell(CTTableCell paramCTTableCell) {
/* 27 */     this.cell = paramCTTableCell;
/* 28 */     this.drawingTextBody = new DrawingTextBody(this.cell.getTxBody());
/*    */   }
/*    */   
/*    */   public DrawingTextBody getTextBody() {
/* 32 */     return this.drawingTextBody;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingTableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */