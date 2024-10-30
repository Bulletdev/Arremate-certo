/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
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
/*     */ public class XWPFTableCell
/*     */   implements IBody, ICell
/*     */ {
/*  52 */   private static EnumMap<XWPFVertAlign, STVerticalJc.Enum> alignMap = new EnumMap<XWPFVertAlign, STVerticalJc.Enum>(XWPFVertAlign.class); static {
/*  53 */     alignMap.put(XWPFVertAlign.TOP, STVerticalJc.Enum.forInt(1));
/*  54 */     alignMap.put(XWPFVertAlign.CENTER, STVerticalJc.Enum.forInt(2));
/*  55 */     alignMap.put(XWPFVertAlign.BOTH, STVerticalJc.Enum.forInt(3));
/*  56 */     alignMap.put(XWPFVertAlign.BOTTOM, STVerticalJc.Enum.forInt(4));
/*     */   }
/*  58 */   private static HashMap<Integer, XWPFVertAlign> stVertAlignTypeMap = new HashMap<Integer, XWPFVertAlign>(); static {
/*  59 */     stVertAlignTypeMap.put(Integer.valueOf(1), XWPFVertAlign.TOP);
/*  60 */     stVertAlignTypeMap.put(Integer.valueOf(2), XWPFVertAlign.CENTER);
/*  61 */     stVertAlignTypeMap.put(Integer.valueOf(3), XWPFVertAlign.BOTH);
/*  62 */     stVertAlignTypeMap.put(Integer.valueOf(4), XWPFVertAlign.BOTTOM);
/*     */   }
/*     */ 
/*     */   
/*     */   private final CTTc ctTc;
/*  67 */   protected List<XWPFParagraph> paragraphs = null;
/*  68 */   protected List<XWPFTable> tables = null;
/*  69 */   protected List<IBodyElement> bodyElements = null;
/*     */   
/*     */   protected IBody part;
/*  72 */   private XWPFTableRow tableRow = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell(CTTc paramCTTc, XWPFTableRow paramXWPFTableRow, IBody paramIBody) {
/*  78 */     this.ctTc = paramCTTc;
/*  79 */     this.part = paramIBody;
/*  80 */     this.tableRow = paramXWPFTableRow;
/*     */     
/*  82 */     if (paramCTTc.sizeOfPArray() < 1)
/*  83 */       paramCTTc.addNewP(); 
/*  84 */     this.bodyElements = new ArrayList<IBodyElement>();
/*  85 */     this.paragraphs = new ArrayList<XWPFParagraph>();
/*  86 */     this.tables = new ArrayList<XWPFTable>();
/*     */     
/*  88 */     XmlCursor xmlCursor = this.ctTc.newCursor();
/*  89 */     xmlCursor.selectPath("./*");
/*  90 */     while (xmlCursor.toNextSelection()) {
/*  91 */       XmlObject xmlObject = xmlCursor.getObject();
/*  92 */       if (xmlObject instanceof CTP) {
/*  93 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/*  94 */         this.paragraphs.add(xWPFParagraph);
/*  95 */         this.bodyElements.add(xWPFParagraph);
/*     */       } 
/*  97 */       if (xmlObject instanceof CTTbl) {
/*  98 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/*  99 */         this.tables.add(xWPFTable);
/* 100 */         this.bodyElements.add(xWPFTable);
/*     */       } 
/* 102 */       if (xmlObject instanceof CTSdtBlock) {
/* 103 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this);
/* 104 */         this.bodyElements.add(xWPFSDT);
/*     */       } 
/* 106 */       if (xmlObject instanceof CTSdtRun) {
/* 107 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtRun)xmlObject, this);
/* 108 */         System.out.println(xWPFSDT.getContent().getText());
/* 109 */         this.bodyElements.add(xWPFSDT);
/*     */       } 
/*     */     } 
/* 112 */     xmlCursor.dispose();
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTTc getCTTc() {
/* 117 */     return this.ctTc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<IBodyElement> getBodyElements() {
/* 126 */     return Collections.unmodifiableList(this.bodyElements);
/*     */   }
/*     */   
/*     */   public void setParagraph(XWPFParagraph paramXWPFParagraph) {
/* 130 */     if (this.ctTc.sizeOfPArray() == 0) {
/* 131 */       this.ctTc.addNewP();
/*     */     }
/* 133 */     this.ctTc.setPArray(0, paramXWPFParagraph.getCTP());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFParagraph> getParagraphs() {
/* 140 */     return this.paragraphs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph addParagraph() {
/* 149 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(this.ctTc.addNewP(), this);
/* 150 */     addParagraph(xWPFParagraph);
/* 151 */     return xWPFParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addParagraph(XWPFParagraph paramXWPFParagraph) {
/* 160 */     this.paragraphs.add(paramXWPFParagraph);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeParagraph(int paramInt) {
/* 169 */     this.paragraphs.remove(paramInt);
/* 170 */     this.ctTc.removeP(paramInt);
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
/*     */   public XWPFParagraph getParagraph(CTP paramCTP) {
/* 183 */     for (XWPFParagraph xWPFParagraph : this.paragraphs) {
/* 184 */       if (paramCTP.equals(xWPFParagraph.getCTP())) {
/* 185 */         return xWPFParagraph;
/*     */       }
/*     */     } 
/* 188 */     return null;
/*     */   }
/*     */   
/*     */   public XWPFTableRow getTableRow() {
/* 192 */     return this.tableRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getColor() {
/* 201 */     String str = null;
/* 202 */     CTTcPr cTTcPr = this.ctTc.getTcPr();
/* 203 */     if (cTTcPr != null) {
/* 204 */       CTShd cTShd = cTTcPr.getShd();
/* 205 */       if (cTShd != null) {
/* 206 */         str = cTShd.xgetFill().getStringValue();
/*     */       }
/*     */     } 
/* 209 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(String paramString) {
/* 219 */     CTTcPr cTTcPr = this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr();
/* 220 */     CTShd cTShd = cTTcPr.isSetShd() ? cTTcPr.getShd() : cTTcPr.addNewShd();
/* 221 */     cTShd.setColor("auto");
/* 222 */     cTShd.setVal(STShd.CLEAR);
/* 223 */     cTShd.setFill(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFVertAlign getVerticalAlignment() {
/* 233 */     XWPFVertAlign xWPFVertAlign = null;
/* 234 */     CTTcPr cTTcPr = this.ctTc.getTcPr();
/* 235 */     if (cTTcPr != null) {
/* 236 */       CTVerticalJc cTVerticalJc = cTTcPr.getVAlign();
/* 237 */       if (cTVerticalJc != null) {
/* 238 */         xWPFVertAlign = stVertAlignTypeMap.get(Integer.valueOf(cTVerticalJc.getVal().intValue()));
/*     */       } else {
/* 240 */         xWPFVertAlign = XWPFVertAlign.TOP;
/*     */       } 
/* 242 */       if (cTVerticalJc != null && cTVerticalJc.getVal() != null) {
/* 243 */         xWPFVertAlign = stVertAlignTypeMap.get(Integer.valueOf(cTVerticalJc.getVal().intValue()));
/*     */       }
/*     */     } 
/* 246 */     return xWPFVertAlign;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalAlignment(XWPFVertAlign paramXWPFVertAlign) {
/* 255 */     CTTcPr cTTcPr = this.ctTc.isSetTcPr() ? this.ctTc.getTcPr() : this.ctTc.addNewTcPr();
/* 256 */     CTVerticalJc cTVerticalJc = cTTcPr.addNewVAlign();
/* 257 */     cTVerticalJc.setVal(alignMap.get(paramXWPFVertAlign));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph insertNewParagraph(XmlCursor paramXmlCursor) {
/* 267 */     if (!isCursorInTableCell(paramXmlCursor)) {
/* 268 */       return null;
/*     */     }
/*     */     
/* 271 */     String str1 = CTP.type.getName().getNamespaceURI();
/* 272 */     String str2 = "p";
/* 273 */     paramXmlCursor.beginElement(str2, str1);
/* 274 */     paramXmlCursor.toParent();
/* 275 */     CTP cTP = (CTP)paramXmlCursor.getObject();
/* 276 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/* 277 */     XmlObject xmlObject = null;
/* 278 */     while (!(xmlObject instanceof CTP) && paramXmlCursor.toPrevSibling()) {
/* 279 */       xmlObject = paramXmlCursor.getObject();
/*     */     }
/* 281 */     if (!(xmlObject instanceof CTP) || (CTP)xmlObject == cTP) {
/* 282 */       this.paragraphs.add(0, xWPFParagraph);
/*     */     } else {
/* 284 */       int i = this.paragraphs.indexOf(getParagraph((CTP)xmlObject)) + 1;
/* 285 */       this.paragraphs.add(i, xWPFParagraph);
/*     */     } 
/* 287 */     byte b = 0;
/* 288 */     XmlCursor xmlCursor = cTP.newCursor();
/* 289 */     paramXmlCursor.toCursor(xmlCursor);
/* 290 */     xmlCursor.dispose();
/* 291 */     while (paramXmlCursor.toPrevSibling()) {
/* 292 */       xmlObject = paramXmlCursor.getObject();
/* 293 */       if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/* 294 */         b++; 
/*     */     } 
/* 296 */     this.bodyElements.add(b, xWPFParagraph);
/* 297 */     xmlCursor = cTP.newCursor();
/* 298 */     paramXmlCursor.toCursor(xmlCursor);
/* 299 */     xmlCursor.dispose();
/* 300 */     paramXmlCursor.toEndToken();
/* 301 */     return xWPFParagraph;
/*     */   }
/*     */   
/*     */   public XWPFTable insertNewTbl(XmlCursor paramXmlCursor) {
/* 305 */     if (isCursorInTableCell(paramXmlCursor)) {
/* 306 */       String str1 = CTTbl.type.getName().getNamespaceURI();
/* 307 */       String str2 = "tbl";
/* 308 */       paramXmlCursor.beginElement(str2, str1);
/* 309 */       paramXmlCursor.toParent();
/* 310 */       CTTbl cTTbl = (CTTbl)paramXmlCursor.getObject();
/* 311 */       XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
/* 312 */       paramXmlCursor.removeXmlContents();
/* 313 */       XmlObject xmlObject = null;
/* 314 */       while (!(xmlObject instanceof CTTbl) && paramXmlCursor.toPrevSibling()) {
/* 315 */         xmlObject = paramXmlCursor.getObject();
/*     */       }
/* 317 */       if (!(xmlObject instanceof CTTbl)) {
/* 318 */         this.tables.add(0, xWPFTable);
/*     */       } else {
/* 320 */         int i = this.tables.indexOf(getTable((CTTbl)xmlObject)) + 1;
/* 321 */         this.tables.add(i, xWPFTable);
/*     */       } 
/* 323 */       byte b = 0;
/* 324 */       XmlCursor xmlCursor = cTTbl.newCursor();
/* 325 */       while (xmlCursor.toPrevSibling()) {
/* 326 */         xmlObject = xmlCursor.getObject();
/* 327 */         if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/* 328 */           b++; 
/*     */       } 
/* 330 */       xmlCursor.dispose();
/* 331 */       this.bodyElements.add(b, xWPFTable);
/* 332 */       xmlCursor = cTTbl.newCursor();
/* 333 */       paramXmlCursor.toCursor(xmlCursor);
/* 334 */       paramXmlCursor.toEndToken();
/* 335 */       xmlCursor.dispose();
/* 336 */       return xWPFTable;
/*     */     } 
/* 338 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCursorInTableCell(XmlCursor paramXmlCursor) {
/* 345 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 346 */     xmlCursor.toParent();
/* 347 */     boolean bool = (xmlCursor.getObject() == this.ctTc) ? true : false;
/* 348 */     xmlCursor.dispose();
/* 349 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph getParagraphArray(int paramInt) {
/* 356 */     if (paramInt >= 0 && paramInt < this.paragraphs.size()) {
/* 357 */       return this.paragraphs.get(paramInt);
/*     */     }
/* 359 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getPart() {
/* 368 */     return this.tableRow.getTable().getPart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyType getPartType() {
/* 375 */     return BodyType.TABLECELL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable getTable(CTTbl paramCTTbl) {
/* 384 */     for (byte b = 0; b < this.tables.size(); b++) {
/* 385 */       if (((XWPFTable)getTables().get(b)).getCTTbl() == paramCTTbl) return getTables().get(b); 
/*     */     } 
/* 387 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable getTableArray(int paramInt) {
/* 394 */     if (paramInt >= 0 && paramInt < this.tables.size()) {
/* 395 */       return this.tables.get(paramInt);
/*     */     }
/* 397 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFTable> getTables() {
/* 404 */     return Collections.unmodifiableList(this.tables);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertTable(int paramInt, XWPFTable paramXWPFTable) {
/* 413 */     this.bodyElements.add(paramInt, paramXWPFTable);
/* 414 */     byte b = 0;
/* 415 */     for (CTTbl cTTbl : this.ctTc.getTblArray()) {
/* 416 */       if (cTTbl == paramXWPFTable.getCTTbl()) {
/*     */         break;
/*     */       }
/* 419 */       b++;
/*     */     } 
/* 421 */     this.tables.add(b, paramXWPFTable);
/*     */   }
/*     */   
/*     */   public String getText() {
/* 425 */     StringBuilder stringBuilder = new StringBuilder();
/* 426 */     for (XWPFParagraph xWPFParagraph : this.paragraphs) {
/* 427 */       stringBuilder.append(xWPFParagraph.getText());
/*     */     }
/* 429 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public void setText(String paramString) {
/* 433 */     CTP cTP = (this.ctTc.sizeOfPArray() == 0) ? this.ctTc.addNewP() : this.ctTc.getPArray(0);
/* 434 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/* 435 */     xWPFParagraph.createRun().setText(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTextRecursively() {
/* 443 */     StringBuffer stringBuffer = new StringBuffer();
/* 444 */     for (byte b = 0; b < this.bodyElements.size(); b++) {
/* 445 */       boolean bool = (b == this.bodyElements.size() - 1) ? true : false;
/* 446 */       appendBodyElementText(stringBuffer, this.bodyElements.get(b), bool);
/*     */     } 
/*     */     
/* 449 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private void appendBodyElementText(StringBuffer paramStringBuffer, IBodyElement paramIBodyElement, boolean paramBoolean) {
/* 453 */     if (paramIBodyElement instanceof XWPFParagraph) {
/* 454 */       paramStringBuffer.append(((XWPFParagraph)paramIBodyElement).getText());
/* 455 */       if (!paramBoolean) {
/* 456 */         paramStringBuffer.append('\t');
/*     */       }
/* 458 */     } else if (paramIBodyElement instanceof XWPFTable) {
/* 459 */       XWPFTable xWPFTable = (XWPFTable)paramIBodyElement;
/* 460 */       for (XWPFTableRow xWPFTableRow : xWPFTable.getRows()) {
/* 461 */         for (XWPFTableCell xWPFTableCell : xWPFTableRow.getTableCells()) {
/* 462 */           List<IBodyElement> list = xWPFTableCell.getBodyElements();
/* 463 */           for (byte b = 0; b < list.size(); b++) {
/* 464 */             boolean bool = (b == list.size() - 1) ? true : false;
/* 465 */             appendBodyElementText(paramStringBuffer, list.get(b), bool);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 470 */       if (!paramBoolean) {
/* 471 */         paramStringBuffer.append('\n');
/*     */       }
/* 473 */     } else if (paramIBodyElement instanceof XWPFSDT) {
/* 474 */       paramStringBuffer.append(((XWPFSDT)paramIBodyElement).getContent().getText());
/* 475 */       if (!paramBoolean) {
/* 476 */         paramStringBuffer.append('\t');
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell getTableCell(CTTc paramCTTc) {
/* 485 */     XmlCursor xmlCursor = paramCTTc.newCursor();
/* 486 */     xmlCursor.toParent();
/* 487 */     XmlObject xmlObject = xmlCursor.getObject();
/* 488 */     if (!(xmlObject instanceof CTRow)) {
/* 489 */       return null;
/*     */     }
/* 491 */     CTRow cTRow = (CTRow)xmlObject;
/* 492 */     xmlCursor.toParent();
/* 493 */     xmlObject = xmlCursor.getObject();
/* 494 */     xmlCursor.dispose();
/* 495 */     if (!(xmlObject instanceof CTTbl)) {
/* 496 */       return null;
/*     */     }
/* 498 */     CTTbl cTTbl = (CTTbl)xmlObject;
/* 499 */     XWPFTable xWPFTable = getTable(cTTbl);
/* 500 */     if (xWPFTable == null) {
/* 501 */       return null;
/*     */     }
/* 503 */     XWPFTableRow xWPFTableRow = xWPFTable.getRow(cTRow);
/* 504 */     if (xWPFTableRow == null) {
/* 505 */       return null;
/*     */     }
/* 507 */     return xWPFTableRow.getTableCell(paramCTTc);
/*     */   }
/*     */   
/*     */   public XWPFDocument getXWPFDocument() {
/* 511 */     return this.part.getXWPFDocument();
/*     */   }
/*     */   
/*     */   public enum XWPFVertAlign
/*     */   {
/* 516 */     TOP, CENTER, BOTH, BOTTOM;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFTableCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */