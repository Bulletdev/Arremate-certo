/*    */ package org.apache.poi.xssf.usermodel.helpers;
/*    */ 
/*    */ import org.apache.poi.ss.util.CellReference;
/*    */ import org.apache.poi.xssf.model.SingleXmlCells;
/*    */ import org.apache.poi.xssf.usermodel.XSSFCell;
/*    */ import org.apache.poi.xssf.usermodel.XSSFRow;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSingleXmlCell;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlCellPr;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTXmlPr;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STXmlDataType;
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
/*    */ public class XSSFSingleXmlCell
/*    */ {
/*    */   private CTSingleXmlCell singleXmlCell;
/*    */   private SingleXmlCells parent;
/*    */   
/*    */   public XSSFSingleXmlCell(CTSingleXmlCell paramCTSingleXmlCell, SingleXmlCells paramSingleXmlCells) {
/* 46 */     this.singleXmlCell = paramCTSingleXmlCell;
/* 47 */     this.parent = paramSingleXmlCells;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XSSFCell getReferencedCell() {
/* 55 */     XSSFCell xSSFCell = null;
/*    */ 
/*    */     
/* 58 */     CellReference cellReference = new CellReference(this.singleXmlCell.getR());
/*    */     
/* 60 */     XSSFRow xSSFRow = this.parent.getXSSFSheet().getRow(cellReference.getRow());
/* 61 */     if (xSSFRow == null) {
/* 62 */       xSSFRow = this.parent.getXSSFSheet().createRow(cellReference.getRow());
/*    */     }
/*    */     
/* 65 */     xSSFCell = xSSFRow.getCell(cellReference.getCol());
/* 66 */     if (xSSFCell == null) {
/* 67 */       xSSFCell = xSSFRow.createCell(cellReference.getCol());
/*    */     }
/*    */ 
/*    */     
/* 71 */     return xSSFCell;
/*    */   }
/*    */   
/*    */   public String getXpath() {
/* 75 */     CTXmlCellPr cTXmlCellPr = this.singleXmlCell.getXmlCellPr();
/* 76 */     CTXmlPr cTXmlPr = cTXmlCellPr.getXmlPr();
/* 77 */     return cTXmlPr.getXpath();
/*    */   }
/*    */ 
/*    */   
/*    */   public long getMapId() {
/* 82 */     return this.singleXmlCell.getXmlCellPr().getXmlPr().getMapId();
/*    */   }
/*    */   
/*    */   public STXmlDataType.Enum getXmlDataType() {
/* 86 */     CTXmlCellPr cTXmlCellPr = this.singleXmlCell.getXmlCellPr();
/* 87 */     CTXmlPr cTXmlPr = cTXmlCellPr.getXmlPr();
/* 88 */     return cTXmlPr.getXmlDataType();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFSingleXmlCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */