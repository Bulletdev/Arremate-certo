/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.sl.draw.DrawFactory;
/*     */ import org.apache.poi.sl.draw.DrawTextShape;
/*     */ import org.apache.poi.sl.usermodel.TableCell;
/*     */ import org.apache.poi.sl.usermodel.TableShape;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
/*     */ import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSLFTable
/*     */   extends XSLFGraphicFrame
/*     */   implements Iterable<XSLFTableRow>, TableShape<XSLFShape, XSLFTextParagraph>
/*     */ {
/*     */   static final String TABLE_URI = "http://schemas.openxmlformats.org/drawingml/2006/table";
/*     */   private CTTable _table;
/*     */   private List<XSLFTableRow> _rows;
/*     */   
/*     */   XSLFTable(CTGraphicalObjectFrame paramCTGraphicalObjectFrame, XSLFSheet paramXSLFSheet) {
/*  61 */     super(paramCTGraphicalObjectFrame, paramXSLFSheet);
/*     */     
/*  63 */     XmlObject[] arrayOfXmlObject = paramCTGraphicalObjectFrame.getGraphic().getGraphicData().selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' ./a:tbl");
/*     */     
/*  65 */     if (arrayOfXmlObject.length == 0) {
/*  66 */       throw new IllegalStateException("a:tbl element was not found in\n " + paramCTGraphicalObjectFrame.getGraphic().getGraphicData());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (arrayOfXmlObject[0] instanceof org.apache.xmlbeans.impl.values.XmlAnyTypeImpl) {
/*     */       try {
/*  73 */         arrayOfXmlObject[0] = (XmlObject)CTTable.Factory.parse(arrayOfXmlObject[0].toString(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  74 */       } catch (XmlException xmlException) {
/*  75 */         throw new POIXMLException(xmlException);
/*     */       } 
/*     */     }
/*     */     
/*  79 */     this._table = (CTTable)arrayOfXmlObject[0];
/*  80 */     CTTableRow[] arrayOfCTTableRow = this._table.getTrArray();
/*  81 */     this._rows = new ArrayList<XSLFTableRow>(arrayOfCTTableRow.length);
/*  82 */     for (CTTableRow cTTableRow : arrayOfCTTableRow) {
/*  83 */       XSLFTableRow xSLFTableRow = new XSLFTableRow(cTTableRow, this);
/*  84 */       this._rows.add(xSLFTableRow);
/*     */     } 
/*  86 */     updateRowColIndexes();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSLFTableCell getCell(int paramInt1, int paramInt2) {
/*  91 */     List<XSLFTableRow> list = getRows();
/*  92 */     if (paramInt1 < 0 || list.size() <= paramInt1) {
/*  93 */       return null;
/*     */     }
/*  95 */     XSLFTableRow xSLFTableRow = list.get(paramInt1);
/*  96 */     if (xSLFTableRow == null)
/*     */     {
/*  98 */       return null;
/*     */     }
/* 100 */     List<XSLFTableCell> list1 = xSLFTableRow.getCells();
/* 101 */     if (paramInt2 < 0 || list1.size() <= paramInt2) {
/* 102 */       return null;
/*     */     }
/*     */     
/* 105 */     return list1.get(paramInt2);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTTable getCTTable() {
/* 110 */     return this._table;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfColumns() {
/* 115 */     return this._table.getTblGrid().sizeOfGridColArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumberOfRows() {
/* 120 */     return this._table.sizeOfTrArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getColumnWidth(int paramInt) {
/* 125 */     return Units.toPoints(this._table.getTblGrid().getGridColArray(paramInt).getW());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColumnWidth(int paramInt, double paramDouble) {
/* 131 */     this._table.getTblGrid().getGridColArray(paramInt).setW(Units.toEMU(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public double getRowHeight(int paramInt) {
/* 136 */     return Units.toPoints(this._table.getTrArray(paramInt).getH());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRowHeight(int paramInt, double paramDouble) {
/* 141 */     this._table.getTrArray(paramInt).setH(Units.toEMU(paramDouble));
/*     */   }
/*     */   
/*     */   public Iterator<XSLFTableRow> iterator() {
/* 145 */     return this._rows.iterator();
/*     */   }
/*     */   
/*     */   public List<XSLFTableRow> getRows() {
/* 149 */     return Collections.unmodifiableList(this._rows);
/*     */   }
/*     */   
/*     */   public XSLFTableRow addRow() {
/* 153 */     CTTableRow cTTableRow = this._table.addNewTr();
/* 154 */     XSLFTableRow xSLFTableRow = new XSLFTableRow(cTTableRow, this);
/*     */     
/* 156 */     xSLFTableRow.setHeight(20.0D);
/* 157 */     this._rows.add(xSLFTableRow);
/* 158 */     updateRowColIndexes();
/* 159 */     return xSLFTableRow;
/*     */   }
/*     */   
/*     */   static CTGraphicalObjectFrame prototype(int paramInt) {
/* 163 */     CTGraphicalObjectFrame cTGraphicalObjectFrame = CTGraphicalObjectFrame.Factory.newInstance();
/* 164 */     CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = cTGraphicalObjectFrame.addNewNvGraphicFramePr();
/*     */     
/* 166 */     CTNonVisualDrawingProps cTNonVisualDrawingProps = cTGraphicalObjectFrameNonVisual.addNewCNvPr();
/* 167 */     cTNonVisualDrawingProps.setName("Table " + paramInt);
/* 168 */     cTNonVisualDrawingProps.setId((paramInt + 1));
/* 169 */     cTGraphicalObjectFrameNonVisual.addNewCNvGraphicFramePr().addNewGraphicFrameLocks().setNoGrp(true);
/* 170 */     cTGraphicalObjectFrameNonVisual.addNewNvPr();
/*     */     
/* 172 */     cTGraphicalObjectFrame.addNewXfrm();
/* 173 */     CTGraphicalObjectData cTGraphicalObjectData = cTGraphicalObjectFrame.addNewGraphic().addNewGraphicData();
/* 174 */     XmlCursor xmlCursor = cTGraphicalObjectData.newCursor();
/* 175 */     xmlCursor.toNextToken();
/* 176 */     xmlCursor.beginElement(new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tbl"));
/* 177 */     xmlCursor.beginElement(new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblPr"));
/* 178 */     xmlCursor.toNextToken();
/* 179 */     xmlCursor.beginElement(new b("http://schemas.openxmlformats.org/drawingml/2006/main", "tblGrid"));
/* 180 */     xmlCursor.dispose();
/* 181 */     cTGraphicalObjectData.setUri("http://schemas.openxmlformats.org/drawingml/2006/table");
/* 182 */     return cTGraphicalObjectFrame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mergeCells(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 190 */     if (paramInt1 > paramInt2) {
/* 191 */       throw new IllegalArgumentException("Cannot merge, first row > last row : " + paramInt1 + " > " + paramInt2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 197 */     if (paramInt3 > paramInt4) {
/* 198 */       throw new IllegalArgumentException("Cannot merge, first column > last column : " + paramInt3 + " > " + paramInt4);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     int i = paramInt2 - paramInt1 + 1;
/* 205 */     boolean bool1 = (i > 1) ? true : false;
/*     */     
/* 207 */     int j = paramInt4 - paramInt3 + 1;
/* 208 */     boolean bool2 = (j > 1) ? true : false;
/*     */     
/* 210 */     for (int k = paramInt1; k <= paramInt2; k++) {
/*     */       
/* 212 */       XSLFTableRow xSLFTableRow = this._rows.get(k);
/*     */       
/* 214 */       for (int m = paramInt3; m <= paramInt4; m++) {
/*     */         
/* 216 */         XSLFTableCell xSLFTableCell = xSLFTableRow.getCells().get(m);
/*     */         
/* 218 */         if (bool1) {
/* 219 */           if (k == paramInt1) {
/* 220 */             xSLFTableCell.setRowSpan(i);
/*     */           } else {
/* 222 */             xSLFTableCell.setVMerge(true);
/*     */           } 
/*     */         }
/* 225 */         if (bool2) {
/* 226 */           if (m == paramInt3) {
/* 227 */             xSLFTableCell.setGridSpan(j);
/*     */           } else {
/* 229 */             xSLFTableCell.setHMerge(true);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSLFTableStyle getTableStyle() {
/* 244 */     CTTable cTTable = getCTTable();
/*     */     
/* 246 */     if (!cTTable.isSetTblPr() || !cTTable.getTblPr().isSetTableStyleId()) {
/* 247 */       return null;
/*     */     }
/*     */     
/* 250 */     String str = cTTable.getTblPr().getTableStyleId();
/* 251 */     XSLFTableStyles xSLFTableStyles = getSheet().getSlideShow().getTableStyles();
/* 252 */     for (XSLFTableStyle xSLFTableStyle : xSLFTableStyles.getStyles()) {
/* 253 */       if (xSLFTableStyle.getStyleId().equals(str)) {
/* 254 */         return xSLFTableStyle;
/*     */       }
/*     */     } 
/* 257 */     return null;
/*     */   }
/*     */   
/*     */   void updateRowColIndexes() {
/* 261 */     byte b = 0;
/* 262 */     for (XSLFTableRow xSLFTableRow : this) {
/* 263 */       byte b1 = 0;
/* 264 */       for (XSLFTableCell xSLFTableCell : xSLFTableRow) {
/* 265 */         xSLFTableCell.setRowColIndex(b, b1);
/* 266 */         b1++;
/*     */       } 
/* 268 */       b++;
/*     */     } 
/*     */   }
/*     */   
/*     */   void updateCellAnchor() {
/* 273 */     int i = getNumberOfRows();
/* 274 */     int j = getNumberOfColumns();
/*     */     
/* 276 */     double[] arrayOfDouble1 = new double[j];
/* 277 */     double[] arrayOfDouble2 = new double[i];
/*     */     byte b1;
/* 279 */     for (b1 = 0; b1 < i; b1++) {
/* 280 */       arrayOfDouble2[b1] = getRowHeight(b1);
/*     */     }
/* 282 */     for (b1 = 0; b1 < j; b1++) {
/* 283 */       arrayOfDouble1[b1] = getColumnWidth(b1);
/*     */     }
/*     */     
/* 286 */     Rectangle2D rectangle2D = getAnchor();
/* 287 */     DrawFactory drawFactory = DrawFactory.getInstance(null);
/*     */     
/* 289 */     double d = rectangle2D.getY();
/*     */     
/*     */     byte b2;
/* 292 */     for (b2 = 0; b2 < i; b2++) {
/* 293 */       double d1 = 0.0D;
/* 294 */       for (byte b = 0; b < j; b++) {
/* 295 */         XSLFTableCell xSLFTableCell = getCell(b2, b);
/* 296 */         if (xSLFTableCell.getGridSpan() == 1 && xSLFTableCell.getRowSpan() == 1) {
/*     */ 
/*     */ 
/*     */           
/* 300 */           xSLFTableCell.setAnchor(new Rectangle2D.Double(0.0D, 0.0D, arrayOfDouble1[b], 0.0D));
/* 301 */           DrawTextShape drawTextShape = drawFactory.getDrawable(xSLFTableCell);
/* 302 */           d1 = Math.max(d1, drawTextShape.getTextHeight());
/*     */         } 
/* 304 */       }  arrayOfDouble2[b2] = Math.max(arrayOfDouble2[b2], d1);
/*     */     } 
/*     */ 
/*     */     
/* 308 */     for (b2 = 0; b2 < i; b2++) {
/* 309 */       double d1 = rectangle2D.getX();
/* 310 */       for (byte b = 0; b < j; b++) {
/* 311 */         Rectangle2D.Double double_ = new Rectangle2D.Double(d1, d, arrayOfDouble1[b], arrayOfDouble2[b2]);
/* 312 */         XSLFTableCell xSLFTableCell = getCell(b2, b);
/* 313 */         xSLFTableCell.setAnchor(double_);
/* 314 */         d1 += arrayOfDouble1[b] + 2.0D;
/*     */       } 
/* 316 */       d += arrayOfDouble2[b2] + 2.0D;
/*     */     } 
/*     */ 
/*     */     
/* 320 */     for (b2 = 0; b2 < i; b2++) {
/* 321 */       for (byte b = 0; b < j; b++) {
/* 322 */         XSLFTableCell xSLFTableCell = getCell(b2, b);
/* 323 */         Rectangle2D rectangle2D1 = xSLFTableCell.getAnchor(); int k;
/* 324 */         for (k = b + 1; k < b + xSLFTableCell.getGridSpan(); k++) {
/* 325 */           assert k < j;
/* 326 */           XSLFTableCell xSLFTableCell1 = getCell(b2, k);
/* 327 */           assert xSLFTableCell1.getGridSpan() == 1 && xSLFTableCell1.getRowSpan() == 1;
/* 328 */           rectangle2D1.add(xSLFTableCell1.getAnchor());
/*     */         } 
/* 330 */         for (k = b2 + 1; k < b2 + xSLFTableCell.getRowSpan(); k++) {
/* 331 */           assert k < i;
/* 332 */           XSLFTableCell xSLFTableCell1 = getCell(k, b);
/* 333 */           assert xSLFTableCell1.getGridSpan() == 1 && xSLFTableCell1.getRowSpan() == 1;
/* 334 */           rectangle2D1.add(xSLFTableCell1.getAnchor());
/*     */         } 
/* 336 */         xSLFTableCell.setAnchor(rectangle2D1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */