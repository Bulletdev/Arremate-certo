/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblCellMar;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
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
/*     */ 
/*     */ public class XWPFTable
/*     */   implements IBodyElement, ISDTContents
/*     */ {
/*  53 */   private static EnumMap<XWPFBorderType, STBorder.Enum> xwpfBorderTypeMap = new EnumMap<XWPFBorderType, STBorder.Enum>(XWPFBorderType.class); static {
/*  54 */     xwpfBorderTypeMap.put(XWPFBorderType.NIL, STBorder.Enum.forInt(1));
/*  55 */     xwpfBorderTypeMap.put(XWPFBorderType.NONE, STBorder.Enum.forInt(2));
/*  56 */     xwpfBorderTypeMap.put(XWPFBorderType.SINGLE, STBorder.Enum.forInt(3));
/*  57 */     xwpfBorderTypeMap.put(XWPFBorderType.THICK, STBorder.Enum.forInt(4));
/*  58 */     xwpfBorderTypeMap.put(XWPFBorderType.DOUBLE, STBorder.Enum.forInt(5));
/*  59 */     xwpfBorderTypeMap.put(XWPFBorderType.DOTTED, STBorder.Enum.forInt(6));
/*  60 */     xwpfBorderTypeMap.put(XWPFBorderType.DASHED, STBorder.Enum.forInt(7));
/*  61 */     xwpfBorderTypeMap.put(XWPFBorderType.DOT_DASH, STBorder.Enum.forInt(8));
/*     */   }
/*  63 */   private static HashMap<Integer, XWPFBorderType> stBorderTypeMap = new HashMap<Integer, XWPFBorderType>(); static {
/*  64 */     stBorderTypeMap.put(Integer.valueOf(1), XWPFBorderType.NIL);
/*  65 */     stBorderTypeMap.put(Integer.valueOf(2), XWPFBorderType.NONE);
/*  66 */     stBorderTypeMap.put(Integer.valueOf(3), XWPFBorderType.SINGLE);
/*  67 */     stBorderTypeMap.put(Integer.valueOf(4), XWPFBorderType.THICK);
/*  68 */     stBorderTypeMap.put(Integer.valueOf(5), XWPFBorderType.DOUBLE);
/*  69 */     stBorderTypeMap.put(Integer.valueOf(6), XWPFBorderType.DOTTED);
/*  70 */     stBorderTypeMap.put(Integer.valueOf(7), XWPFBorderType.DASHED);
/*  71 */     stBorderTypeMap.put(Integer.valueOf(8), XWPFBorderType.DOT_DASH);
/*     */   }
/*     */   
/*  74 */   protected StringBuffer text = new StringBuffer();
/*     */   
/*     */   protected List<XWPFTableRow> tableRows;
/*     */   
/*     */   protected IBody part;
/*     */   
/*     */   private CTTbl ctTbl;
/*     */   
/*     */   public XWPFTable(CTTbl paramCTTbl, IBody paramIBody, int paramInt1, int paramInt2) {
/*  83 */     this(paramCTTbl, paramIBody);
/*     */     
/*  85 */     for (byte b = 0; b < paramInt1; b++) {
/*  86 */       XWPFTableRow xWPFTableRow = (getRow(b) == null) ? createRow() : getRow(b);
/*  87 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/*  88 */         if (xWPFTableRow.getCell(b1) == null) {
/*  89 */           xWPFTableRow.createCell();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public XWPFTable(CTTbl paramCTTbl, IBody paramIBody) {
/*  96 */     this.part = paramIBody;
/*  97 */     this.ctTbl = paramCTTbl;
/*     */     
/*  99 */     this.tableRows = new ArrayList<XWPFTableRow>();
/*     */ 
/*     */     
/* 102 */     if (paramCTTbl.sizeOfTrArray() == 0) {
/* 103 */       createEmptyTable(paramCTTbl);
/*     */     }
/* 105 */     for (CTRow cTRow : paramCTTbl.getTrArray()) {
/* 106 */       StringBuilder stringBuilder = new StringBuilder();
/* 107 */       XWPFTableRow xWPFTableRow = new XWPFTableRow(cTRow, this);
/* 108 */       this.tableRows.add(xWPFTableRow);
/* 109 */       for (CTTc cTTc : cTRow.getTcArray()) {
/* 110 */         for (CTP cTP : cTTc.getPArray()) {
/* 111 */           XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, paramIBody);
/* 112 */           if (stringBuilder.length() > 0) {
/* 113 */             stringBuilder.append('\t');
/*     */           }
/* 115 */           stringBuilder.append(xWPFParagraph.getText());
/*     */         } 
/*     */       } 
/* 118 */       if (stringBuilder.length() > 0) {
/* 119 */         this.text.append(stringBuilder);
/* 120 */         this.text.append('\n');
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void createEmptyTable(CTTbl paramCTTbl) {
/* 127 */     paramCTTbl.addNewTr().addNewTc().addNewP();
/*     */     
/* 129 */     CTTblPr cTTblPr = paramCTTbl.addNewTblPr();
/* 130 */     cTTblPr.addNewTblW().setW(new BigInteger("0"));
/* 131 */     cTTblPr.getTblW().setType(STTblWidth.AUTO);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     CTTblBorders cTTblBorders = cTTblPr.addNewTblBorders();
/* 138 */     cTTblBorders.addNewBottom().setVal(STBorder.SINGLE);
/* 139 */     cTTblBorders.addNewInsideH().setVal(STBorder.SINGLE);
/* 140 */     cTTblBorders.addNewInsideV().setVal(STBorder.SINGLE);
/* 141 */     cTTblBorders.addNewLeft().setVal(STBorder.SINGLE);
/* 142 */     cTTblBorders.addNewRight().setVal(STBorder.SINGLE);
/* 143 */     cTTblBorders.addNewTop().setVal(STBorder.SINGLE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     getRows();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTTbl getCTTbl() {
/* 157 */     return this.ctTbl;
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
/*     */   public String getText() {
/* 171 */     return this.text.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNewRowBetween(int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNewCol() {
/* 182 */     if (this.ctTbl.sizeOfTrArray() == 0) {
/* 183 */       createRow();
/*     */     }
/* 185 */     for (byte b = 0; b < this.ctTbl.sizeOfTrArray(); b++) {
/* 186 */       XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.getTrArray(b), this);
/* 187 */       xWPFTableRow.createCell();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableRow createRow() {
/* 197 */     boolean bool = (this.ctTbl.sizeOfTrArray() > 0) ? this.ctTbl.getTrArray(0).sizeOfTcArray() : false;
/*     */     
/* 199 */     XWPFTableRow xWPFTableRow = new XWPFTableRow(this.ctTbl.addNewTr(), this);
/* 200 */     addColumn(xWPFTableRow, bool);
/* 201 */     this.tableRows.add(xWPFTableRow);
/* 202 */     return xWPFTableRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableRow getRow(int paramInt) {
/* 210 */     if (paramInt >= 0 && paramInt < this.ctTbl.sizeOfTrArray())
/*     */     {
/* 212 */       return getRows().get(paramInt);
/*     */     }
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/* 221 */     CTTblPr cTTblPr = getTrPr();
/* 222 */     return cTTblPr.isSetTblW() ? cTTblPr.getTblW().getW().intValue() : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWidth(int paramInt) {
/* 229 */     CTTblPr cTTblPr = getTrPr();
/* 230 */     CTTblWidth cTTblWidth = cTTblPr.isSetTblW() ? cTTblPr.getTblW() : cTTblPr.addNewTblW();
/* 231 */     cTTblWidth.setW(new BigInteger("" + paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfRows() {
/* 238 */     return this.ctTbl.sizeOfTrArray();
/*     */   }
/*     */   
/*     */   private CTTblPr getTrPr() {
/* 242 */     return (this.ctTbl.getTblPr() != null) ? this.ctTbl.getTblPr() : this.ctTbl.addNewTblPr();
/*     */   }
/*     */ 
/*     */   
/*     */   private void addColumn(XWPFTableRow paramXWPFTableRow, int paramInt) {
/* 247 */     if (paramInt > 0) {
/* 248 */       for (byte b = 0; b < paramInt; b++) {
/* 249 */         paramXWPFTableRow.createCell();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStyleID() {
/* 260 */     String str = null;
/* 261 */     CTTblPr cTTblPr = this.ctTbl.getTblPr();
/* 262 */     if (cTTblPr != null) {
/* 263 */       CTString cTString = cTTblPr.getTblStyle();
/* 264 */       if (cTString != null) {
/* 265 */         str = cTString.getVal();
/*     */       }
/*     */     } 
/* 268 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStyleID(String paramString) {
/* 278 */     CTTblPr cTTblPr = getTrPr();
/* 279 */     CTString cTString = cTTblPr.getTblStyle();
/* 280 */     if (cTString == null) {
/* 281 */       cTString = cTTblPr.addNewTblStyle();
/*     */     }
/* 283 */     cTString.setVal(paramString);
/*     */   }
/*     */   
/*     */   public XWPFBorderType getInsideHBorderType() {
/* 287 */     XWPFBorderType xWPFBorderType = null;
/*     */     
/* 289 */     CTTblPr cTTblPr = getTrPr();
/* 290 */     if (cTTblPr.isSetTblBorders()) {
/* 291 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 292 */       if (cTTblBorders.isSetInsideH()) {
/* 293 */         CTBorder cTBorder = cTTblBorders.getInsideH();
/* 294 */         xWPFBorderType = stBorderTypeMap.get(Integer.valueOf(cTBorder.getVal().intValue()));
/*     */       } 
/*     */     } 
/* 297 */     return xWPFBorderType;
/*     */   }
/*     */   
/*     */   public int getInsideHBorderSize() {
/* 301 */     int i = -1;
/*     */     
/* 303 */     CTTblPr cTTblPr = getTrPr();
/* 304 */     if (cTTblPr.isSetTblBorders()) {
/* 305 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 306 */       if (cTTblBorders.isSetInsideH()) {
/* 307 */         CTBorder cTBorder = cTTblBorders.getInsideH();
/* 308 */         i = cTBorder.getSz().intValue();
/*     */       } 
/*     */     } 
/* 311 */     return i;
/*     */   }
/*     */   
/*     */   public int getInsideHBorderSpace() {
/* 315 */     int i = -1;
/*     */     
/* 317 */     CTTblPr cTTblPr = getTrPr();
/* 318 */     if (cTTblPr.isSetTblBorders()) {
/* 319 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 320 */       if (cTTblBorders.isSetInsideH()) {
/* 321 */         CTBorder cTBorder = cTTblBorders.getInsideH();
/* 322 */         i = cTBorder.getSpace().intValue();
/*     */       } 
/*     */     } 
/* 325 */     return i;
/*     */   }
/*     */   
/*     */   public String getInsideHBorderColor() {
/* 329 */     String str = null;
/*     */     
/* 331 */     CTTblPr cTTblPr = getTrPr();
/* 332 */     if (cTTblPr.isSetTblBorders()) {
/* 333 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 334 */       if (cTTblBorders.isSetInsideH()) {
/* 335 */         CTBorder cTBorder = cTTblBorders.getInsideH();
/* 336 */         str = cTBorder.xgetColor().getStringValue();
/*     */       } 
/*     */     } 
/* 339 */     return str;
/*     */   }
/*     */   
/*     */   public XWPFBorderType getInsideVBorderType() {
/* 343 */     XWPFBorderType xWPFBorderType = null;
/*     */     
/* 345 */     CTTblPr cTTblPr = getTrPr();
/* 346 */     if (cTTblPr.isSetTblBorders()) {
/* 347 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 348 */       if (cTTblBorders.isSetInsideV()) {
/* 349 */         CTBorder cTBorder = cTTblBorders.getInsideV();
/* 350 */         xWPFBorderType = stBorderTypeMap.get(Integer.valueOf(cTBorder.getVal().intValue()));
/*     */       } 
/*     */     } 
/* 353 */     return xWPFBorderType;
/*     */   }
/*     */   
/*     */   public int getInsideVBorderSize() {
/* 357 */     int i = -1;
/*     */     
/* 359 */     CTTblPr cTTblPr = getTrPr();
/* 360 */     if (cTTblPr.isSetTblBorders()) {
/* 361 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 362 */       if (cTTblBorders.isSetInsideV()) {
/* 363 */         CTBorder cTBorder = cTTblBorders.getInsideV();
/* 364 */         i = cTBorder.getSz().intValue();
/*     */       } 
/*     */     } 
/* 367 */     return i;
/*     */   }
/*     */   
/*     */   public int getInsideVBorderSpace() {
/* 371 */     int i = -1;
/*     */     
/* 373 */     CTTblPr cTTblPr = getTrPr();
/* 374 */     if (cTTblPr.isSetTblBorders()) {
/* 375 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 376 */       if (cTTblBorders.isSetInsideV()) {
/* 377 */         CTBorder cTBorder = cTTblBorders.getInsideV();
/* 378 */         i = cTBorder.getSpace().intValue();
/*     */       } 
/*     */     } 
/* 381 */     return i;
/*     */   }
/*     */   
/*     */   public String getInsideVBorderColor() {
/* 385 */     String str = null;
/*     */     
/* 387 */     CTTblPr cTTblPr = getTrPr();
/* 388 */     if (cTTblPr.isSetTblBorders()) {
/* 389 */       CTTblBorders cTTblBorders = cTTblPr.getTblBorders();
/* 390 */       if (cTTblBorders.isSetInsideV()) {
/* 391 */         CTBorder cTBorder = cTTblBorders.getInsideV();
/* 392 */         str = cTBorder.xgetColor().getStringValue();
/*     */       } 
/*     */     } 
/* 395 */     return str;
/*     */   }
/*     */   
/*     */   public int getRowBandSize() {
/* 399 */     int i = 0;
/* 400 */     CTTblPr cTTblPr = getTrPr();
/* 401 */     if (cTTblPr.isSetTblStyleRowBandSize()) {
/* 402 */       CTDecimalNumber cTDecimalNumber = cTTblPr.getTblStyleRowBandSize();
/* 403 */       i = cTDecimalNumber.getVal().intValue();
/*     */     } 
/* 405 */     return i;
/*     */   }
/*     */   
/*     */   public void setRowBandSize(int paramInt) {
/* 409 */     CTTblPr cTTblPr = getTrPr();
/* 410 */     CTDecimalNumber cTDecimalNumber = cTTblPr.isSetTblStyleRowBandSize() ? cTTblPr.getTblStyleRowBandSize() : cTTblPr.addNewTblStyleRowBandSize();
/* 411 */     cTDecimalNumber.setVal(BigInteger.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public int getColBandSize() {
/* 415 */     int i = 0;
/* 416 */     CTTblPr cTTblPr = getTrPr();
/* 417 */     if (cTTblPr.isSetTblStyleColBandSize()) {
/* 418 */       CTDecimalNumber cTDecimalNumber = cTTblPr.getTblStyleColBandSize();
/* 419 */       i = cTDecimalNumber.getVal().intValue();
/*     */     } 
/* 421 */     return i;
/*     */   }
/*     */   
/*     */   public void setColBandSize(int paramInt) {
/* 425 */     CTTblPr cTTblPr = getTrPr();
/* 426 */     CTDecimalNumber cTDecimalNumber = cTTblPr.isSetTblStyleColBandSize() ? cTTblPr.getTblStyleColBandSize() : cTTblPr.addNewTblStyleColBandSize();
/* 427 */     cTDecimalNumber.setVal(BigInteger.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public void setInsideHBorder(XWPFBorderType paramXWPFBorderType, int paramInt1, int paramInt2, String paramString) {
/* 431 */     CTTblPr cTTblPr = getTrPr();
/* 432 */     CTTblBorders cTTblBorders = cTTblPr.isSetTblBorders() ? cTTblPr.getTblBorders() : cTTblPr.addNewTblBorders();
/* 433 */     CTBorder cTBorder = cTTblBorders.isSetInsideH() ? cTTblBorders.getInsideH() : cTTblBorders.addNewInsideH();
/* 434 */     cTBorder.setVal(xwpfBorderTypeMap.get(paramXWPFBorderType));
/* 435 */     cTBorder.setSz(BigInteger.valueOf(paramInt1));
/* 436 */     cTBorder.setSpace(BigInteger.valueOf(paramInt2));
/* 437 */     cTBorder.setColor(paramString);
/*     */   }
/*     */   
/*     */   public void setInsideVBorder(XWPFBorderType paramXWPFBorderType, int paramInt1, int paramInt2, String paramString) {
/* 441 */     CTTblPr cTTblPr = getTrPr();
/* 442 */     CTTblBorders cTTblBorders = cTTblPr.isSetTblBorders() ? cTTblPr.getTblBorders() : cTTblPr.addNewTblBorders();
/* 443 */     CTBorder cTBorder = cTTblBorders.isSetInsideV() ? cTTblBorders.getInsideV() : cTTblBorders.addNewInsideV();
/* 444 */     cTBorder.setVal(xwpfBorderTypeMap.get(paramXWPFBorderType));
/* 445 */     cTBorder.setSz(BigInteger.valueOf(paramInt1));
/* 446 */     cTBorder.setSpace(BigInteger.valueOf(paramInt2));
/* 447 */     cTBorder.setColor(paramString);
/*     */   }
/*     */   
/*     */   public int getCellMarginTop() {
/* 451 */     int i = 0;
/* 452 */     CTTblPr cTTblPr = getTrPr();
/* 453 */     CTTblCellMar cTTblCellMar = cTTblPr.getTblCellMar();
/* 454 */     if (cTTblCellMar != null) {
/* 455 */       CTTblWidth cTTblWidth = cTTblCellMar.getTop();
/* 456 */       if (cTTblWidth != null) {
/* 457 */         i = cTTblWidth.getW().intValue();
/*     */       }
/*     */     } 
/* 460 */     return i;
/*     */   }
/*     */   
/*     */   public int getCellMarginLeft() {
/* 464 */     int i = 0;
/* 465 */     CTTblPr cTTblPr = getTrPr();
/* 466 */     CTTblCellMar cTTblCellMar = cTTblPr.getTblCellMar();
/* 467 */     if (cTTblCellMar != null) {
/* 468 */       CTTblWidth cTTblWidth = cTTblCellMar.getLeft();
/* 469 */       if (cTTblWidth != null) {
/* 470 */         i = cTTblWidth.getW().intValue();
/*     */       }
/*     */     } 
/* 473 */     return i;
/*     */   }
/*     */   
/*     */   public int getCellMarginBottom() {
/* 477 */     int i = 0;
/* 478 */     CTTblPr cTTblPr = getTrPr();
/* 479 */     CTTblCellMar cTTblCellMar = cTTblPr.getTblCellMar();
/* 480 */     if (cTTblCellMar != null) {
/* 481 */       CTTblWidth cTTblWidth = cTTblCellMar.getBottom();
/* 482 */       if (cTTblWidth != null) {
/* 483 */         i = cTTblWidth.getW().intValue();
/*     */       }
/*     */     } 
/* 486 */     return i;
/*     */   }
/*     */   
/*     */   public int getCellMarginRight() {
/* 490 */     int i = 0;
/* 491 */     CTTblPr cTTblPr = getTrPr();
/* 492 */     CTTblCellMar cTTblCellMar = cTTblPr.getTblCellMar();
/* 493 */     if (cTTblCellMar != null) {
/* 494 */       CTTblWidth cTTblWidth = cTTblCellMar.getRight();
/* 495 */       if (cTTblWidth != null) {
/* 496 */         i = cTTblWidth.getW().intValue();
/*     */       }
/*     */     } 
/* 499 */     return i;
/*     */   }
/*     */   
/*     */   public void setCellMargins(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 503 */     CTTblPr cTTblPr = getTrPr();
/* 504 */     CTTblCellMar cTTblCellMar = cTTblPr.isSetTblCellMar() ? cTTblPr.getTblCellMar() : cTTblPr.addNewTblCellMar();
/*     */     
/* 506 */     CTTblWidth cTTblWidth = cTTblCellMar.isSetLeft() ? cTTblCellMar.getLeft() : cTTblCellMar.addNewLeft();
/* 507 */     cTTblWidth.setType(STTblWidth.DXA);
/* 508 */     cTTblWidth.setW(BigInteger.valueOf(paramInt2));
/*     */     
/* 510 */     cTTblWidth = cTTblCellMar.isSetTop() ? cTTblCellMar.getTop() : cTTblCellMar.addNewTop();
/* 511 */     cTTblWidth.setType(STTblWidth.DXA);
/* 512 */     cTTblWidth.setW(BigInteger.valueOf(paramInt1));
/*     */     
/* 514 */     cTTblWidth = cTTblCellMar.isSetBottom() ? cTTblCellMar.getBottom() : cTTblCellMar.addNewBottom();
/* 515 */     cTTblWidth.setType(STTblWidth.DXA);
/* 516 */     cTTblWidth.setW(BigInteger.valueOf(paramInt3));
/*     */     
/* 518 */     cTTblWidth = cTTblCellMar.isSetRight() ? cTTblCellMar.getRight() : cTTblCellMar.addNewRight();
/* 519 */     cTTblWidth.setType(STTblWidth.DXA);
/* 520 */     cTTblWidth.setW(BigInteger.valueOf(paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRow(XWPFTableRow paramXWPFTableRow) {
/* 529 */     this.ctTbl.addNewTr();
/* 530 */     this.ctTbl.setTrArray(getNumberOfRows() - 1, paramXWPFTableRow.getCtRow());
/* 531 */     this.tableRows.add(paramXWPFTableRow);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addRow(XWPFTableRow paramXWPFTableRow, int paramInt) {
/* 541 */     if (paramInt >= 0 && paramInt <= this.tableRows.size()) {
/* 542 */       this.ctTbl.insertNewTr(paramInt);
/* 543 */       this.ctTbl.setTrArray(paramInt, paramXWPFTableRow.getCtRow());
/* 544 */       this.tableRows.add(paramInt, paramXWPFTableRow);
/* 545 */       return true;
/*     */     } 
/* 547 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableRow insertNewTableRow(int paramInt) {
/* 557 */     if (paramInt >= 0 && paramInt <= this.tableRows.size()) {
/* 558 */       CTRow cTRow = this.ctTbl.insertNewTr(paramInt);
/* 559 */       XWPFTableRow xWPFTableRow = new XWPFTableRow(cTRow, this);
/* 560 */       this.tableRows.add(paramInt, xWPFTableRow);
/* 561 */       return xWPFTableRow;
/*     */     } 
/* 563 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeRow(int paramInt) throws IndexOutOfBoundsException {
/* 572 */     if (paramInt >= 0 && paramInt < this.tableRows.size()) {
/* 573 */       if (this.ctTbl.sizeOfTrArray() > 0) {
/* 574 */         this.ctTbl.removeTr(paramInt);
/*     */       }
/* 576 */       this.tableRows.remove(paramInt);
/* 577 */       return true;
/*     */     } 
/* 579 */     return false;
/*     */   }
/*     */   
/*     */   public List<XWPFTableRow> getRows() {
/* 583 */     return this.tableRows;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyElementType getElementType() {
/* 592 */     return BodyElementType.TABLE;
/*     */   }
/*     */   
/*     */   public IBody getBody() {
/* 596 */     return this.part;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getPart() {
/* 605 */     if (this.part != null) {
/* 606 */       return this.part.getPart();
/*     */     }
/* 608 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyType getPartType() {
/* 617 */     return this.part.getPartType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableRow getRow(CTRow paramCTRow) {
/* 625 */     for (byte b = 0; b < getRows().size(); b++) {
/* 626 */       if (((XWPFTableRow)getRows().get(b)).getCtRow() == paramCTRow) return getRow(b); 
/*     */     } 
/* 628 */     return null;
/*     */   }
/*     */   
/*     */   public enum XWPFBorderType
/*     */   {
/* 633 */     NIL, NONE, SINGLE, THICK, DOUBLE, DOTTED, DASHED, DOT_DASH;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */