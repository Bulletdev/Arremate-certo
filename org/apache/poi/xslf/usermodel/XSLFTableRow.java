/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFTableRow
/*     */   implements Iterable<XSLFTableCell>
/*     */ {
/*     */   private final CTTableRow _row;
/*     */   private final List<XSLFTableCell> _cells;
/*     */   private final XSLFTable _table;
/*     */   
/*     */   XSLFTableRow(CTTableRow paramCTTableRow, XSLFTable paramXSLFTable) {
/*  40 */     this._row = paramCTTableRow;
/*  41 */     this._table = paramXSLFTable;
/*  42 */     CTTableCell[] arrayOfCTTableCell = this._row.getTcArray();
/*  43 */     this._cells = new ArrayList<XSLFTableCell>(arrayOfCTTableCell.length);
/*  44 */     for (CTTableCell cTTableCell : arrayOfCTTableCell) {
/*  45 */       this._cells.add(new XSLFTableCell(cTTableCell, paramXSLFTable));
/*     */     }
/*     */   }
/*     */   
/*     */   public CTTableRow getXmlObject() {
/*  50 */     return this._row;
/*     */   }
/*     */   
/*     */   public Iterator<XSLFTableCell> iterator() {
/*  54 */     return this._cells.iterator();
/*     */   }
/*     */   
/*     */   public List<XSLFTableCell> getCells() {
/*  58 */     return Collections.unmodifiableList(this._cells);
/*     */   }
/*     */   
/*     */   public double getHeight() {
/*  62 */     return Units.toPoints(this._row.getH());
/*     */   }
/*     */   
/*     */   public void setHeight(double paramDouble) {
/*  66 */     this._row.setH(Units.toEMU(paramDouble));
/*     */   }
/*     */   
/*     */   public XSLFTableCell addCell() {
/*  70 */     CTTableCell cTTableCell = this._row.addNewTc();
/*  71 */     cTTableCell.set((XmlObject)XSLFTableCell.prototype());
/*  72 */     XSLFTableCell xSLFTableCell = new XSLFTableCell(cTTableCell, this._table);
/*  73 */     this._cells.add(xSLFTableCell);
/*     */     
/*  75 */     if (this._table.getNumberOfColumns() < this._row.sizeOfTcArray()) {
/*  76 */       this._table.getCTTable().getTblGrid().addNewGridCol().setW(Units.toEMU(100.0D));
/*     */     }
/*  78 */     this._table.updateRowColIndexes();
/*  79 */     return xSLFTableCell;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergeCells(int paramInt1, int paramInt2) {
/*  91 */     if (paramInt1 >= paramInt2) {
/*  92 */       throw new IllegalArgumentException("Cannot merge, first column >= last column : " + paramInt1 + " >= " + paramInt2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     int i = paramInt2 - paramInt1 + 1;
/*     */     
/* 100 */     ((XSLFTableCell)this._cells.get(paramInt1)).setGridSpan(i);
/* 101 */     for (XSLFTableCell xSLFTableCell : this._cells.subList(paramInt1 + 1, paramInt2 + 1))
/* 102 */       xSLFTableCell.setHMerge(true); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTableRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */