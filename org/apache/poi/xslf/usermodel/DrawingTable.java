/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
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
/*    */ public class DrawingTable
/*    */ {
/*    */   private final CTTable table;
/*    */   
/*    */   public DrawingTable(CTTable paramCTTable) {
/* 27 */     this.table = paramCTTable;
/*    */   }
/*    */   
/*    */   public DrawingTableRow[] getRows() {
/* 31 */     CTTableRow[] arrayOfCTTableRow = this.table.getTrArray();
/* 32 */     DrawingTableRow[] arrayOfDrawingTableRow = new DrawingTableRow[arrayOfCTTableRow.length];
/*    */     
/* 34 */     for (byte b = 0; b < arrayOfDrawingTableRow.length; b++) {
/* 35 */       arrayOfDrawingTableRow[b] = new DrawingTableRow(arrayOfCTTableRow[b]);
/*    */     }
/*    */     
/* 38 */     return arrayOfDrawingTableRow;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\DrawingTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */