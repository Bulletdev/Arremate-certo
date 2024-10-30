/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import org.apache.poi.sl.draw.DrawPaint;
/*     */ import org.apache.poi.sl.usermodel.ColorStyle;
/*     */ import org.apache.poi.sl.usermodel.PaintStyle;
/*     */ import org.apache.poi.sl.usermodel.StrokeStyle;
/*     */ import org.apache.poi.sl.usermodel.TableCell;
/*     */ import org.apache.poi.sl.usermodel.TextShape;
/*     */ import org.apache.poi.sl.usermodel.VerticalAlignment;
/*     */ import org.apache.poi.util.Units;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineEndProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTable;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCellProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTablePartStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleCellStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleTextStyle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndLength;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STLineEndWidth;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STPresetLineDashVal;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.STTextVerticalType;
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
/*     */ public class XSLFTableCell
/*     */   extends XSLFTextShape
/*     */   implements TableCell<XSLFShape, XSLFTextParagraph>
/*     */ {
/*  72 */   private CTTableCellProperties _tcPr = null;
/*     */   private final XSLFTable table;
/*  74 */   private int row = 0; private int col = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   private Rectangle2D anchor = null;
/*     */   
/*     */   XSLFTableCell(CTTableCell paramCTTableCell, XSLFTable paramXSLFTable) {
/*  82 */     super((XmlObject)paramCTTableCell, paramXSLFTable.getSheet());
/*  83 */     this.table = paramXSLFTable;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTTextBody getTextBody(boolean paramBoolean) {
/*  88 */     CTTableCell cTTableCell = getCell();
/*  89 */     CTTextBody cTTextBody = cTTableCell.getTxBody();
/*  90 */     if (cTTextBody == null && paramBoolean) {
/*  91 */       cTTextBody = cTTableCell.addNewTxBody();
/*  92 */       XSLFAutoShape.initTextBody(cTTextBody);
/*     */     } 
/*  94 */     return cTTextBody;
/*     */   }
/*     */   
/*     */   static CTTableCell prototype() {
/*  98 */     CTTableCell cTTableCell = CTTableCell.Factory.newInstance();
/*  99 */     CTTableCellProperties cTTableCellProperties = cTTableCell.addNewTcPr();
/* 100 */     cTTableCellProperties.addNewLnL().addNewNoFill();
/* 101 */     cTTableCellProperties.addNewLnR().addNewNoFill();
/* 102 */     cTTableCellProperties.addNewLnT().addNewNoFill();
/* 103 */     cTTableCellProperties.addNewLnB().addNewNoFill();
/* 104 */     return cTTableCell;
/*     */   }
/*     */   
/*     */   protected CTTableCellProperties getCellProperties(boolean paramBoolean) {
/* 108 */     if (this._tcPr == null) {
/* 109 */       CTTableCell cTTableCell = getCell();
/* 110 */       this._tcPr = cTTableCell.getTcPr();
/* 111 */       if (this._tcPr == null && paramBoolean) {
/* 112 */         this._tcPr = cTTableCell.addNewTcPr();
/*     */       }
/*     */     } 
/* 115 */     return this._tcPr;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLeftInset(double paramDouble) {
/* 120 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 121 */     cTTableCellProperties.setMarL(Units.toEMU(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRightInset(double paramDouble) {
/* 126 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 127 */     cTTableCellProperties.setMarR(Units.toEMU(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTopInset(double paramDouble) {
/* 132 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 133 */     cTTableCellProperties.setMarT(Units.toEMU(paramDouble));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBottomInset(double paramDouble) {
/* 138 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 139 */     cTTableCellProperties.setMarB(Units.toEMU(paramDouble));
/*     */   }
/*     */   
/*     */   private CTLineProperties getCTLine(TableCell.BorderEdge paramBorderEdge, boolean paramBoolean) {
/* 143 */     if (paramBorderEdge == null) {
/* 144 */       throw new IllegalArgumentException("BorderEdge needs to be specified.");
/*     */     }
/*     */     
/* 147 */     CTTableCellProperties cTTableCellProperties = getCellProperties(paramBoolean);
/* 148 */     if (cTTableCellProperties == null) return null;
/*     */     
/* 150 */     switch (paramBorderEdge) {
/*     */       case HORIZONTAL:
/* 152 */         return cTTableCellProperties.isSetLnB() ? cTTableCellProperties.getLnB() : (paramBoolean ? cTTableCellProperties.addNewLnB() : null);
/*     */       case VERTICAL:
/* 154 */         return cTTableCellProperties.isSetLnL() ? cTTableCellProperties.getLnL() : (paramBoolean ? cTTableCellProperties.addNewLnL() : null);
/*     */       case VERTICAL_270:
/* 156 */         return cTTableCellProperties.isSetLnT() ? cTTableCellProperties.getLnT() : (paramBoolean ? cTTableCellProperties.addNewLnT() : null);
/*     */       case STACKED:
/* 158 */         return cTTableCellProperties.isSetLnR() ? cTTableCellProperties.getLnR() : (paramBoolean ? cTTableCellProperties.addNewLnR() : null);
/*     */     } 
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeBorder(TableCell.BorderEdge paramBorderEdge) {
/* 166 */     CTTableCellProperties cTTableCellProperties = getCellProperties(false);
/* 167 */     if (cTTableCellProperties == null)
/* 168 */       return;  switch (paramBorderEdge) {
/*     */       case HORIZONTAL:
/* 170 */         if (cTTableCellProperties.isSetLnB()) {
/* 171 */           cTTableCellProperties.unsetLnB();
/*     */         }
/*     */         return;
/*     */       case VERTICAL:
/* 175 */         if (cTTableCellProperties.isSetLnL()) {
/* 176 */           cTTableCellProperties.unsetLnL();
/*     */         }
/*     */         return;
/*     */       case VERTICAL_270:
/* 180 */         if (cTTableCellProperties.isSetLnT()) {
/* 181 */           cTTableCellProperties.unsetLnT();
/*     */         }
/*     */         return;
/*     */       case STACKED:
/* 185 */         if (cTTableCellProperties.isSetLnR()) {
/* 186 */           cTTableCellProperties.unsetLnB();
/*     */         }
/*     */         return;
/*     */     } 
/* 190 */     throw new IllegalArgumentException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StrokeStyle getBorderStyle(final TableCell.BorderEdge edge) {
/* 196 */     final Double width = getBorderWidth(edge);
/* 197 */     return (double_ == null) ? null : new StrokeStyle() {
/*     */         public PaintStyle getPaint() {
/* 199 */           return (PaintStyle)DrawPaint.createSolidPaint(XSLFTableCell.this.getBorderColor(edge));
/*     */         }
/*     */         
/*     */         public StrokeStyle.LineCap getLineCap() {
/* 203 */           return XSLFTableCell.this.getBorderCap(edge);
/*     */         }
/*     */         
/*     */         public StrokeStyle.LineDash getLineDash() {
/* 207 */           return XSLFTableCell.this.getBorderDash(edge);
/*     */         }
/*     */         
/*     */         public StrokeStyle.LineCompound getLineCompound() {
/* 211 */           return XSLFTableCell.this.getBorderCompound(edge);
/*     */         }
/*     */         
/*     */         public double getLineWidth() {
/* 215 */           return width.doubleValue();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderStyle(TableCell.BorderEdge paramBorderEdge, StrokeStyle paramStrokeStyle) {
/* 222 */     if (paramStrokeStyle == null) {
/* 223 */       throw new IllegalArgumentException("StrokeStyle needs to be specified.");
/*     */     }
/*     */     
/* 226 */     StrokeStyle.LineCap lineCap = paramStrokeStyle.getLineCap();
/* 227 */     if (lineCap != null) {
/* 228 */       setBorderCap(paramBorderEdge, lineCap);
/*     */     }
/*     */     
/* 231 */     StrokeStyle.LineCompound lineCompound = paramStrokeStyle.getLineCompound();
/* 232 */     if (lineCompound != null) {
/* 233 */       setBorderCompound(paramBorderEdge, lineCompound);
/*     */     }
/*     */     
/* 236 */     StrokeStyle.LineDash lineDash = paramStrokeStyle.getLineDash();
/* 237 */     if (lineDash != null) {
/* 238 */       setBorderDash(paramBorderEdge, lineDash);
/*     */     }
/*     */     
/* 241 */     double d = paramStrokeStyle.getLineWidth();
/* 242 */     setBorderWidth(paramBorderEdge, d);
/*     */   }
/*     */   
/*     */   public Double getBorderWidth(TableCell.BorderEdge paramBorderEdge) {
/* 246 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, false);
/* 247 */     return (cTLineProperties == null || !cTLineProperties.isSetW()) ? null : Double.valueOf(Units.toPoints(cTLineProperties.getW()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderWidth(TableCell.BorderEdge paramBorderEdge, double paramDouble) {
/* 252 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, true);
/* 253 */     cTLineProperties.setW(Units.toEMU(paramDouble));
/*     */   }
/*     */   
/*     */   private CTLineProperties setBorderDefaults(TableCell.BorderEdge paramBorderEdge) {
/* 257 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, true);
/* 258 */     if (cTLineProperties.isSetNoFill()) {
/* 259 */       cTLineProperties.unsetNoFill();
/*     */     }
/*     */     
/* 262 */     if (!cTLineProperties.isSetPrstDash()) {
/* 263 */       cTLineProperties.addNewPrstDash().setVal(STPresetLineDashVal.SOLID);
/*     */     }
/* 265 */     if (!cTLineProperties.isSetCmpd()) {
/* 266 */       cTLineProperties.setCmpd(STCompoundLine.SNG);
/*     */     }
/* 268 */     if (!cTLineProperties.isSetAlgn()) {
/* 269 */       cTLineProperties.setAlgn(STPenAlignment.CTR);
/*     */     }
/* 271 */     if (!cTLineProperties.isSetCap()) {
/* 272 */       cTLineProperties.setCap(STLineCap.FLAT);
/*     */     }
/* 274 */     if (!cTLineProperties.isSetRound()) {
/* 275 */       cTLineProperties.addNewRound();
/*     */     }
/*     */     
/* 278 */     if (!cTLineProperties.isSetHeadEnd()) {
/* 279 */       CTLineEndProperties cTLineEndProperties = cTLineProperties.addNewHeadEnd();
/* 280 */       cTLineEndProperties.setType(STLineEndType.NONE);
/* 281 */       cTLineEndProperties.setW(STLineEndWidth.MED);
/* 282 */       cTLineEndProperties.setLen(STLineEndLength.MED);
/*     */     } 
/*     */     
/* 285 */     if (!cTLineProperties.isSetTailEnd()) {
/* 286 */       CTLineEndProperties cTLineEndProperties = cTLineProperties.addNewTailEnd();
/* 287 */       cTLineEndProperties.setType(STLineEndType.NONE);
/* 288 */       cTLineEndProperties.setW(STLineEndWidth.MED);
/* 289 */       cTLineEndProperties.setLen(STLineEndLength.MED);
/*     */     } 
/*     */     
/* 292 */     return cTLineProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderColor(TableCell.BorderEdge paramBorderEdge, Color paramColor) {
/* 297 */     if (paramColor == null) {
/* 298 */       throw new IllegalArgumentException("Colors need to be specified.");
/*     */     }
/*     */     
/* 301 */     CTLineProperties cTLineProperties = setBorderDefaults(paramBorderEdge);
/* 302 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTLineProperties.addNewSolidFill();
/* 303 */     XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/* 304 */     xSLFColor.setColor(paramColor);
/*     */   }
/*     */   
/*     */   public Color getBorderColor(TableCell.BorderEdge paramBorderEdge) {
/* 308 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, false);
/* 309 */     if (cTLineProperties == null || cTLineProperties.isSetNoFill() || !cTLineProperties.isSetSolidFill()) return null;
/*     */     
/* 311 */     CTSolidColorFillProperties cTSolidColorFillProperties = cTLineProperties.getSolidFill();
/* 312 */     XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/* 313 */     return xSLFColor.getColor();
/*     */   }
/*     */   
/*     */   public StrokeStyle.LineCompound getBorderCompound(TableCell.BorderEdge paramBorderEdge) {
/* 317 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, false);
/* 318 */     if (cTLineProperties == null || cTLineProperties.isSetNoFill() || !cTLineProperties.isSetSolidFill() || !cTLineProperties.isSetCmpd()) {
/* 319 */       return null;
/*     */     }
/*     */     
/* 322 */     return StrokeStyle.LineCompound.fromOoxmlId(cTLineProperties.getCmpd().intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderCompound(TableCell.BorderEdge paramBorderEdge, StrokeStyle.LineCompound paramLineCompound) {
/* 327 */     if (paramLineCompound == null) {
/* 328 */       throw new IllegalArgumentException("LineCompound need to be specified.");
/*     */     }
/*     */     
/* 331 */     CTLineProperties cTLineProperties = setBorderDefaults(paramBorderEdge);
/* 332 */     cTLineProperties.setCmpd(STCompoundLine.Enum.forInt(paramLineCompound.ooxmlId));
/*     */   }
/*     */   
/*     */   public StrokeStyle.LineDash getBorderDash(TableCell.BorderEdge paramBorderEdge) {
/* 336 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, false);
/* 337 */     if (cTLineProperties == null || cTLineProperties.isSetNoFill() || !cTLineProperties.isSetSolidFill() || !cTLineProperties.isSetPrstDash()) {
/* 338 */       return null;
/*     */     }
/*     */     
/* 341 */     return StrokeStyle.LineDash.fromOoxmlId(cTLineProperties.getPrstDash().getVal().intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderDash(TableCell.BorderEdge paramBorderEdge, StrokeStyle.LineDash paramLineDash) {
/* 346 */     if (paramLineDash == null) {
/* 347 */       throw new IllegalArgumentException("LineDash need to be specified.");
/*     */     }
/*     */     
/* 350 */     CTLineProperties cTLineProperties = setBorderDefaults(paramBorderEdge);
/* 351 */     cTLineProperties.getPrstDash().setVal(STPresetLineDashVal.Enum.forInt(paramLineDash.ooxmlId));
/*     */   }
/*     */   
/*     */   public StrokeStyle.LineCap getBorderCap(TableCell.BorderEdge paramBorderEdge) {
/* 355 */     CTLineProperties cTLineProperties = getCTLine(paramBorderEdge, false);
/* 356 */     if (cTLineProperties == null || cTLineProperties.isSetNoFill() || !cTLineProperties.isSetSolidFill() || !cTLineProperties.isSetCap()) {
/* 357 */       return null;
/*     */     }
/*     */     
/* 360 */     return StrokeStyle.LineCap.fromOoxmlId(cTLineProperties.getCap().intValue());
/*     */   }
/*     */   
/*     */   public void setBorderCap(TableCell.BorderEdge paramBorderEdge, StrokeStyle.LineCap paramLineCap) {
/* 364 */     if (paramLineCap == null) {
/* 365 */       throw new IllegalArgumentException("LineCap need to be specified.");
/*     */     }
/*     */     
/* 368 */     CTLineProperties cTLineProperties = setBorderDefaults(paramBorderEdge);
/* 369 */     cTLineProperties.setCap(STLineCap.Enum.forInt(paramLineCap.ooxmlId));
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
/*     */   public void setFillColor(Color paramColor) {
/* 382 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 383 */     if (paramColor == null) {
/* 384 */       if (cTTableCellProperties.isSetSolidFill()) cTTableCellProperties.unsetSolidFill(); 
/*     */     } else {
/* 386 */       CTSolidColorFillProperties cTSolidColorFillProperties = cTTableCellProperties.isSetSolidFill() ? cTTableCellProperties.getSolidFill() : cTTableCellProperties.addNewSolidFill();
/* 387 */       XSLFColor xSLFColor = new XSLFColor((XmlObject)cTSolidColorFillProperties, getSheet().getTheme(), cTSolidColorFillProperties.getSchemeClr());
/* 388 */       xSLFColor.setColor(paramColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Color getFillColor() {
/* 398 */     PaintStyle paintStyle = getFillPaint();
/* 399 */     if (paintStyle instanceof PaintStyle.SolidPaint) {
/* 400 */       ColorStyle colorStyle = ((PaintStyle.SolidPaint)paintStyle).getSolidColor();
/* 401 */       return DrawPaint.applyColorTransform(colorStyle);
/*     */     } 
/*     */     
/* 404 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public PaintStyle getFillPaint() {
/*     */     CTStyleMatrixReference cTStyleMatrixReference;
/* 410 */     XSLFSheet xSLFSheet = getSheet();
/* 411 */     XSLFTheme xSLFTheme = xSLFSheet.getTheme();
/* 412 */     CTTableCellProperties cTTableCellProperties = getCellProperties(false);
/* 413 */     XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTTableCellProperties);
/* 414 */     if (xSLFFillProperties != null) {
/* 415 */       PaintStyle paintStyle = selectPaint(xSLFFillProperties, null, xSLFSheet.getPackagePart(), xSLFTheme);
/* 416 */       if (paintStyle != null) {
/* 417 */         return paintStyle;
/*     */       }
/*     */     } 
/*     */     
/* 421 */     CTTablePartStyle cTTablePartStyle = getTablePartStyle((XSLFTableStyle.TablePartStyle)null);
/* 422 */     if (cTTablePartStyle == null || !cTTablePartStyle.isSetTcStyle()) {
/* 423 */       cTTablePartStyle = getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl);
/* 424 */       if (cTTablePartStyle == null || !cTTablePartStyle.isSetTcStyle()) {
/* 425 */         return null;
/*     */       }
/*     */     } 
/*     */     
/* 429 */     XMLSlideShow xMLSlideShow = xSLFSheet.getSlideShow();
/* 430 */     CTTableStyleCellStyle cTTableStyleCellStyle = cTTablePartStyle.getTcStyle();
/* 431 */     if (cTTableStyleCellStyle.isSetFill()) {
/* 432 */       CTFillProperties cTFillProperties = cTTableStyleCellStyle.getFill();
/* 433 */     } else if (cTTableStyleCellStyle.isSetFillRef()) {
/* 434 */       cTStyleMatrixReference = cTTableStyleCellStyle.getFillRef();
/*     */     } else {
/* 436 */       return null;
/*     */     } 
/*     */     
/* 439 */     xSLFFillProperties = XSLFPropertiesDelegate.getFillDelegate((XmlObject)cTStyleMatrixReference);
/* 440 */     if (xSLFFillProperties != null) {
/* 441 */       PaintStyle paintStyle = XSLFShape.selectPaint(xSLFFillProperties, null, xMLSlideShow.getPackagePart(), xSLFTheme);
/* 442 */       if (paintStyle != null) {
/* 443 */         return paintStyle;
/*     */       }
/*     */     } 
/*     */     
/* 447 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTTablePartStyle getTablePartStyle(XSLFTableStyle.TablePartStyle paramTablePartStyle) {
/*     */     XSLFTableStyle.TablePartStyle tablePartStyle;
/* 458 */     CTTable cTTable = this.table.getCTTable();
/* 459 */     if (!cTTable.isSetTblPr()) {
/* 460 */       return null;
/*     */     }
/*     */     
/* 463 */     CTTableProperties cTTableProperties = cTTable.getTblPr();
/* 464 */     boolean bool1 = (cTTableProperties.isSetBandRow() && cTTableProperties.getBandRow()) ? true : false;
/* 465 */     boolean bool2 = (cTTableProperties.isSetFirstRow() && cTTableProperties.getFirstRow()) ? true : false;
/* 466 */     boolean bool3 = (cTTableProperties.isSetLastRow() && cTTableProperties.getLastRow()) ? true : false;
/* 467 */     boolean bool4 = (cTTableProperties.isSetBandCol() && cTTableProperties.getBandCol()) ? true : false;
/* 468 */     boolean bool5 = (cTTableProperties.isSetFirstCol() && cTTableProperties.getFirstCol()) ? true : false;
/* 469 */     boolean bool6 = (cTTableProperties.isSetLastCol() && cTTableProperties.getLastCol()) ? true : false;
/*     */ 
/*     */     
/* 472 */     if (paramTablePartStyle != null) {
/* 473 */       tablePartStyle = paramTablePartStyle;
/* 474 */     } else if (this.row == 0 && bool2) {
/* 475 */       tablePartStyle = XSLFTableStyle.TablePartStyle.firstRow;
/* 476 */     } else if (this.row == this.table.getNumberOfRows() - 1 && bool3) {
/* 477 */       tablePartStyle = XSLFTableStyle.TablePartStyle.lastRow;
/* 478 */     } else if (this.col == 0 && bool5) {
/* 479 */       tablePartStyle = XSLFTableStyle.TablePartStyle.firstCol;
/* 480 */     } else if (this.col == this.table.getNumberOfColumns() - 1 && bool6) {
/* 481 */       tablePartStyle = XSLFTableStyle.TablePartStyle.lastCol;
/*     */     } else {
/* 483 */       tablePartStyle = XSLFTableStyle.TablePartStyle.wholeTbl;
/*     */       
/* 485 */       int i = this.row + (bool2 ? 1 : 0);
/* 486 */       int j = this.col + (bool5 ? 1 : 0);
/* 487 */       if (bool1 && (i & 0x1) == 0) {
/* 488 */         tablePartStyle = XSLFTableStyle.TablePartStyle.band1H;
/* 489 */       } else if (bool4 && (j & 0x1) == 0) {
/* 490 */         tablePartStyle = XSLFTableStyle.TablePartStyle.band1V;
/*     */       } 
/*     */     } 
/*     */     
/* 494 */     XSLFTableStyle xSLFTableStyle = this.table.getTableStyle();
/* 495 */     if (xSLFTableStyle == null) {
/* 496 */       return null;
/*     */     }
/*     */     
/* 499 */     CTTablePartStyle cTTablePartStyle = xSLFTableStyle.getTablePartStyle(tablePartStyle);
/* 500 */     return (cTTablePartStyle == null) ? xSLFTableStyle.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl) : cTTablePartStyle;
/*     */   }
/*     */   
/*     */   void setGridSpan(int paramInt) {
/* 504 */     getCell().setGridSpan(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getGridSpan() {
/* 509 */     CTTableCell cTTableCell = getCell();
/* 510 */     return cTTableCell.isSetGridSpan() ? cTTableCell.getGridSpan() : 1;
/*     */   }
/*     */   
/*     */   void setRowSpan(int paramInt) {
/* 514 */     getCell().setRowSpan(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRowSpan() {
/* 519 */     CTTableCell cTTableCell = getCell();
/* 520 */     return cTTableCell.isSetRowSpan() ? cTTableCell.getRowSpan() : 1;
/*     */   }
/*     */   
/*     */   void setHMerge(boolean paramBoolean) {
/* 524 */     getCell().setHMerge(paramBoolean);
/*     */   }
/*     */   
/*     */   void setVMerge(boolean paramBoolean) {
/* 528 */     getCell().setVMerge(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVerticalAlignment(VerticalAlignment paramVerticalAlignment) {
/* 533 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 534 */     if (paramVerticalAlignment == null) {
/* 535 */       if (cTTableCellProperties.isSetAnchor()) {
/* 536 */         cTTableCellProperties.unsetAnchor();
/*     */       }
/*     */     } else {
/* 539 */       cTTableCellProperties.setAnchor(STTextAnchoringType.Enum.forInt(paramVerticalAlignment.ordinal() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public VerticalAlignment getVerticalAlignment() {
/* 545 */     CTTableCellProperties cTTableCellProperties = getCellProperties(false);
/*     */     
/* 547 */     VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
/* 548 */     if (cTTableCellProperties != null && cTTableCellProperties.isSetAnchor()) {
/* 549 */       int i = cTTableCellProperties.getAnchor().intValue();
/* 550 */       verticalAlignment = VerticalAlignment.values()[i - 1];
/*     */     } 
/* 552 */     return verticalAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextDirection(TextShape.TextDirection paramTextDirection) {
/* 560 */     CTTableCellProperties cTTableCellProperties = getCellProperties(true);
/* 561 */     if (paramTextDirection == null) {
/* 562 */       if (cTTableCellProperties.isSetVert()) {
/* 563 */         cTTableCellProperties.unsetVert();
/*     */       }
/*     */     } else {
/*     */       STTextVerticalType.Enum enum_;
/* 567 */       switch (paramTextDirection) {
/*     */         
/*     */         default:
/* 570 */           enum_ = STTextVerticalType.HORZ;
/*     */           break;
/*     */         case VERTICAL:
/* 573 */           enum_ = STTextVerticalType.VERT;
/*     */           break;
/*     */         case VERTICAL_270:
/* 576 */           enum_ = STTextVerticalType.VERT_270;
/*     */           break;
/*     */         case STACKED:
/* 579 */           enum_ = STTextVerticalType.WORD_ART_VERT;
/*     */           break;
/*     */       } 
/*     */       
/* 583 */       cTTableCellProperties.setVert(enum_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextShape.TextDirection getTextDirection() {
/*     */     STTextVerticalType.Enum enum_;
/* 592 */     CTTableCellProperties cTTableCellProperties = getCellProperties(false);
/*     */ 
/*     */     
/* 595 */     if (cTTableCellProperties != null && cTTableCellProperties.isSetVert()) {
/* 596 */       enum_ = cTTableCellProperties.getVert();
/*     */     } else {
/* 598 */       enum_ = STTextVerticalType.HORZ;
/*     */     } 
/*     */     
/* 601 */     switch (enum_.intValue())
/*     */     
/*     */     { default:
/* 604 */         return TextShape.TextDirection.HORIZONTAL;
/*     */       case 2:
/*     */       case 5:
/*     */       case 6:
/* 608 */         return TextShape.TextDirection.VERTICAL;
/*     */       case 3:
/* 610 */         return TextShape.TextDirection.VERTICAL_270;
/*     */       case 4:
/*     */       case 7:
/* 613 */         break; }  return TextShape.TextDirection.STACKED;
/*     */   }
/*     */ 
/*     */   
/*     */   private CTTableCell getCell() {
/* 618 */     return (CTTableCell)getXmlObject();
/*     */   }
/*     */   
/*     */   void setRowColIndex(int paramInt1, int paramInt2) {
/* 622 */     this.row = paramInt1;
/* 623 */     this.col = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTTransform2D getXfrm() {
/* 630 */     Rectangle2D rectangle2D = getAnchor();
/* 631 */     CTTransform2D cTTransform2D = CTTransform2D.Factory.newInstance();
/* 632 */     CTPoint2D cTPoint2D = cTTransform2D.addNewOff();
/* 633 */     cTPoint2D.setX(Units.toEMU(rectangle2D.getX()));
/* 634 */     cTPoint2D.setY(Units.toEMU(rectangle2D.getY()));
/* 635 */     CTPositiveSize2D cTPositiveSize2D = cTTransform2D.addNewExt();
/* 636 */     cTPositiveSize2D.setCx(Units.toEMU(rectangle2D.getWidth()));
/* 637 */     cTPositiveSize2D.setCy(Units.toEMU(rectangle2D.getHeight()));
/* 638 */     return cTTransform2D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnchor(Rectangle2D paramRectangle2D) {
/* 649 */     if (this.anchor == null) {
/* 650 */       this.anchor = (Rectangle2D)paramRectangle2D.clone();
/*     */     } else {
/* 652 */       this.anchor.setRect(paramRectangle2D);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle2D getAnchor() {
/* 661 */     if (this.anchor == null) {
/* 662 */       this.table.updateCellAnchor();
/*     */     }
/*     */     
/* 665 */     assert this.anchor != null;
/* 666 */     return this.anchor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMerged() {
/* 674 */     CTTableCell cTTableCell = getCell();
/* 675 */     return ((cTTableCell.isSetHMerge() && cTTableCell.getHMerge()) || (cTTableCell.isSetVMerge() && cTTableCell.getVMerge()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSLFCellTextParagraph newTextParagraph(CTTextParagraph paramCTTextParagraph) {
/* 683 */     return new XSLFCellTextParagraph(paramCTTextParagraph, this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected XmlObject getShapeProperties() {
/* 688 */     return (XmlObject)getCellProperties(false);
/*     */   }
/*     */ 
/*     */   
/*     */   private class XSLFCellTextParagraph
/*     */     extends XSLFTextParagraph
/*     */   {
/*     */     protected XSLFCellTextParagraph(CTTextParagraph param1CTTextParagraph, XSLFTextShape param1XSLFTextShape) {
/* 696 */       super(param1CTTextParagraph, param1XSLFTextShape);
/*     */     }
/*     */ 
/*     */     
/*     */     protected XSLFTableCell.XSLFCellTextRun newTextRun(CTRegularTextRun param1CTRegularTextRun) {
/* 701 */       return new XSLFTableCell.XSLFCellTextRun(param1CTRegularTextRun, this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class XSLFCellTextRun
/*     */     extends XSLFTextRun
/*     */   {
/*     */     protected XSLFCellTextRun(CTRegularTextRun param1CTRegularTextRun, XSLFTextParagraph param1XSLFTextParagraph) {
/* 710 */       super(param1CTRegularTextRun, param1XSLFTextParagraph);
/*     */     }
/*     */ 
/*     */     
/*     */     public PaintStyle getFontColor() {
/* 715 */       CTTableStyleTextStyle cTTableStyleTextStyle = getTextStyle();
/* 716 */       if (cTTableStyleTextStyle == null) {
/* 717 */         return super.getFontColor();
/*     */       }
/*     */       
/* 720 */       CTSchemeColor cTSchemeColor = null;
/* 721 */       CTFontReference cTFontReference = cTTableStyleTextStyle.getFontRef();
/* 722 */       if (cTFontReference != null) {
/* 723 */         cTSchemeColor = cTFontReference.getSchemeClr();
/*     */       }
/*     */       
/* 726 */       XSLFTheme xSLFTheme = XSLFTableCell.this.getSheet().getTheme();
/* 727 */       XSLFColor xSLFColor = new XSLFColor((XmlObject)cTTableStyleTextStyle, xSLFTheme, cTSchemeColor);
/* 728 */       return (PaintStyle)DrawPaint.createSolidPaint(xSLFColor.getColorStyle());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isBold() {
/* 733 */       CTTableStyleTextStyle cTTableStyleTextStyle = getTextStyle();
/* 734 */       if (cTTableStyleTextStyle == null) {
/* 735 */         return super.isBold();
/*     */       }
/* 737 */       return (cTTableStyleTextStyle.isSetB() && cTTableStyleTextStyle.getB().intValue() == 1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isItalic() {
/* 743 */       CTTableStyleTextStyle cTTableStyleTextStyle = getTextStyle();
/* 744 */       if (cTTableStyleTextStyle == null) {
/* 745 */         return super.isItalic();
/*     */       }
/* 747 */       return (cTTableStyleTextStyle.isSetI() && cTTableStyleTextStyle.getI().intValue() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     private CTTableStyleTextStyle getTextStyle() {
/* 752 */       CTTablePartStyle cTTablePartStyle = XSLFTableCell.this.getTablePartStyle((XSLFTableStyle.TablePartStyle)null);
/* 753 */       if (cTTablePartStyle == null || !cTTablePartStyle.isSetTcTxStyle()) {
/* 754 */         cTTablePartStyle = XSLFTableCell.this.getTablePartStyle(XSLFTableStyle.TablePartStyle.wholeTbl);
/*     */       }
/* 756 */       return (cTTablePartStyle == null) ? null : cTTablePartStyle.getTcTxStyle();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */