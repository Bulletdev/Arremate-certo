/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtCell;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
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
/*     */ 
/*     */ 
/*     */ public class XWPFTableRow
/*     */ {
/*     */   private CTRow ctRow;
/*     */   private XWPFTable table;
/*     */   private List<XWPFTableCell> tableCells;
/*     */   
/*     */   public XWPFTableRow(CTRow paramCTRow, XWPFTable paramXWPFTable) {
/*  46 */     this.table = paramXWPFTable;
/*  47 */     this.ctRow = paramCTRow;
/*  48 */     getTableCells();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTRow getCtRow() {
/*  53 */     return this.ctRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell createCell() {
/*  62 */     XWPFTableCell xWPFTableCell = new XWPFTableCell(this.ctRow.addNewTc(), this, this.table.getBody());
/*  63 */     this.tableCells.add(xWPFTableCell);
/*  64 */     return xWPFTableCell;
/*     */   }
/*     */   
/*     */   public XWPFTableCell getCell(int paramInt) {
/*  68 */     if (paramInt >= 0 && paramInt < this.ctRow.sizeOfTcArray()) {
/*  69 */       return getTableCells().get(paramInt);
/*     */     }
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   public void removeCell(int paramInt) {
/*  75 */     if (paramInt >= 0 && paramInt < this.ctRow.sizeOfTcArray()) {
/*  76 */       this.tableCells.remove(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell addNewTableCell() {
/*  84 */     CTTc cTTc = this.ctRow.addNewTc();
/*  85 */     XWPFTableCell xWPFTableCell = new XWPFTableCell(cTTc, this, this.table.getBody());
/*  86 */     this.tableCells.add(xWPFTableCell);
/*  87 */     return xWPFTableCell;
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
/*     */ 
/*     */   
/*     */   public int getHeight() {
/* 101 */     CTTrPr cTTrPr = getTrPr();
/* 102 */     return (cTTrPr.sizeOfTrHeightArray() == 0) ? 0 : cTTrPr.getTrHeightArray(0).getVal().intValue();
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
/*     */ 
/*     */   
/*     */   public void setHeight(int paramInt) {
/* 116 */     CTTrPr cTTrPr = getTrPr();
/* 117 */     CTHeight cTHeight = (cTTrPr.sizeOfTrHeightArray() == 0) ? cTTrPr.addNewTrHeight() : cTTrPr.getTrHeightArray(0);
/* 118 */     cTHeight.setVal(new BigInteger("" + paramInt));
/*     */   }
/*     */   
/*     */   private CTTrPr getTrPr() {
/* 122 */     return this.ctRow.isSetTrPr() ? this.ctRow.getTrPr() : this.ctRow.addNewTrPr();
/*     */   }
/*     */   
/*     */   public XWPFTable getTable() {
/* 126 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ICell> getTableICells() {
/* 137 */     ArrayList<XWPFTableCell> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 140 */     XmlCursor xmlCursor = this.ctRow.newCursor();
/* 141 */     xmlCursor.selectPath("./*");
/* 142 */     while (xmlCursor.toNextSelection()) {
/* 143 */       XmlObject xmlObject = xmlCursor.getObject();
/* 144 */       if (xmlObject instanceof CTTc) {
/* 145 */         arrayList.add(new XWPFTableCell((CTTc)xmlObject, this, this.table.getBody())); continue;
/* 146 */       }  if (xmlObject instanceof CTSdtCell) {
/* 147 */         arrayList.add(new XWPFSDTCell((CTSdtCell)xmlObject, this, this.table.getBody()));
/*     */       }
/*     */     } 
/* 150 */     xmlCursor.dispose();
/* 151 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFTableCell> getTableCells() {
/* 161 */     if (this.tableCells == null) {
/* 162 */       ArrayList<XWPFTableCell> arrayList = new ArrayList();
/* 163 */       for (CTTc cTTc : this.ctRow.getTcArray()) {
/* 164 */         arrayList.add(new XWPFTableCell(cTTc, this, this.table.getBody()));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 169 */       this.tableCells = arrayList;
/*     */     } 
/* 171 */     return this.tableCells;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell getTableCell(CTTc paramCTTc) {
/* 179 */     for (byte b = 0; b < this.tableCells.size(); b++) {
/* 180 */       if (((XWPFTableCell)this.tableCells.get(b)).getCTTc() == paramCTTc)
/* 181 */         return this.tableCells.get(b); 
/*     */     } 
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCantSplitRow() {
/* 194 */     boolean bool = false;
/* 195 */     CTTrPr cTTrPr = getTrPr();
/* 196 */     if (cTTrPr.sizeOfCantSplitArray() > 0) {
/* 197 */       CTOnOff cTOnOff = cTTrPr.getCantSplitArray(0);
/* 198 */       bool = cTOnOff.getVal().equals(STOnOff.ON);
/*     */     } 
/* 200 */     return bool;
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
/*     */   public void setCantSplitRow(boolean paramBoolean) {
/* 212 */     CTTrPr cTTrPr = getTrPr();
/* 213 */     CTOnOff cTOnOff = cTTrPr.addNewCantSplit();
/* 214 */     cTOnOff.setVal(paramBoolean ? STOnOff.ON : STOnOff.OFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRepeatHeader() {
/* 225 */     boolean bool = false;
/* 226 */     CTTrPr cTTrPr = getTrPr();
/* 227 */     if (cTTrPr.sizeOfTblHeaderArray() > 0) {
/* 228 */       CTOnOff cTOnOff = cTTrPr.getTblHeaderArray(0);
/* 229 */       bool = cTOnOff.getVal().equals(STOnOff.ON);
/*     */     } 
/* 231 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRepeatHeader(boolean paramBoolean) {
/* 242 */     CTTrPr cTTrPr = getTrPr();
/* 243 */     CTOnOff cTOnOff = cTTrPr.addNewTblHeader();
/* 244 */     cTOnOff.setVal(paramBoolean ? STOnOff.ON : STOnOff.OFF);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFTableRow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */