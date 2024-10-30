/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
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
/*    */ public class DrawingTableRow
/*    */ {
/*    */   private final CTTableRow row;
/*    */   
/*    */   public DrawingTableRow(CTTableRow paramCTTableRow) {
/* 27 */     this.row = paramCTTableRow;
/*    */   }
/*    */   
/*    */   public DrawingTableCell[] getCells() {
/* 31 */     CTTableCell[] arrayOfCTTableCell = this.row.getTcArray();
/* 32 */     DrawingTableCell[] arrayOfDrawingTableCell = new DrawingTableCell[arrayOfCTTableCell.length];
/*    */     
/* 34 */     for (byte b = 0; b < arrayOfDrawingTableCell.length; b++) {
/* 35 */       arrayOfDrawingTableCell[b] = new DrawingTableCell(arrayOfCTTableCell[b]);
/*    */     }
/*    */     
/* 38 */     return arrayOfDrawingTableCell;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingTableRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */