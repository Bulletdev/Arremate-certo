/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
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
/*     */ public class XWPFFootnote
/*     */   implements Iterable<XWPFParagraph>, IBody
/*     */ {
/*  35 */   private List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>();
/*  36 */   private List<XWPFTable> tables = new ArrayList<XWPFTable>();
/*  37 */   private List<XWPFPictureData> pictures = new ArrayList<XWPFPictureData>();
/*  38 */   private List<IBodyElement> bodyElements = new ArrayList<IBodyElement>();
/*     */   
/*     */   private CTFtnEdn ctFtnEdn;
/*     */   private XWPFFootnotes footnotes;
/*     */   private XWPFDocument document;
/*     */   
/*     */   public XWPFFootnote(CTFtnEdn paramCTFtnEdn, XWPFFootnotes paramXWPFFootnotes) {
/*  45 */     this.footnotes = paramXWPFFootnotes;
/*  46 */     this.ctFtnEdn = paramCTFtnEdn;
/*  47 */     this.document = paramXWPFFootnotes.getXWPFDocument();
/*  48 */     init();
/*     */   }
/*     */   
/*     */   public XWPFFootnote(XWPFDocument paramXWPFDocument, CTFtnEdn paramCTFtnEdn) {
/*  52 */     this.ctFtnEdn = paramCTFtnEdn;
/*  53 */     this.document = paramXWPFDocument;
/*  54 */     init();
/*     */   }
/*     */   
/*     */   private void init() {
/*  58 */     XmlCursor xmlCursor = this.ctFtnEdn.newCursor();
/*     */ 
/*     */     
/*  61 */     xmlCursor.selectPath("./*");
/*  62 */     while (xmlCursor.toNextSelection()) {
/*  63 */       XmlObject xmlObject = xmlCursor.getObject();
/*  64 */       if (xmlObject instanceof CTP) {
/*  65 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/*  66 */         this.bodyElements.add(xWPFParagraph);
/*  67 */         this.paragraphs.add(xWPFParagraph); continue;
/*  68 */       }  if (xmlObject instanceof CTTbl) {
/*  69 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/*  70 */         this.bodyElements.add(xWPFTable);
/*  71 */         this.tables.add(xWPFTable); continue;
/*  72 */       }  if (xmlObject instanceof CTSdtBlock) {
/*  73 */         XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this);
/*  74 */         this.bodyElements.add(xWPFSDT);
/*     */       } 
/*     */     } 
/*     */     
/*  78 */     xmlCursor.dispose();
/*     */   }
/*     */   
/*     */   public List<XWPFParagraph> getParagraphs() {
/*  82 */     return this.paragraphs;
/*     */   }
/*     */   
/*     */   public Iterator<XWPFParagraph> iterator() {
/*  86 */     return this.paragraphs.iterator();
/*     */   }
/*     */   
/*     */   public List<XWPFTable> getTables() {
/*  90 */     return this.tables;
/*     */   }
/*     */   
/*     */   public List<XWPFPictureData> getPictures() {
/*  94 */     return this.pictures;
/*     */   }
/*     */   
/*     */   public List<IBodyElement> getBodyElements() {
/*  98 */     return this.bodyElements;
/*     */   }
/*     */   
/*     */   public CTFtnEdn getCTFtnEdn() {
/* 102 */     return this.ctFtnEdn;
/*     */   }
/*     */   
/*     */   public void setCTFtnEdn(CTFtnEdn paramCTFtnEdn) {
/* 106 */     this.ctFtnEdn = paramCTFtnEdn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable getTableArray(int paramInt) {
/* 115 */     if (paramInt >= 0 && paramInt < this.tables.size()) {
/* 116 */       return this.tables.get(paramInt);
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertTable(int paramInt, XWPFTable paramXWPFTable) {
/* 129 */     this.bodyElements.add(paramInt, paramXWPFTable);
/* 130 */     byte b = 0;
/* 131 */     for (CTTbl cTTbl : this.ctFtnEdn.getTblArray()) {
/* 132 */       if (cTTbl == paramXWPFTable.getCTTbl()) {
/*     */         break;
/*     */       }
/* 135 */       b++;
/*     */     } 
/* 137 */     this.tables.add(b, paramXWPFTable);
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
/*     */   public XWPFTable getTable(CTTbl paramCTTbl) {
/* 150 */     for (XWPFTable xWPFTable : this.tables) {
/* 151 */       if (xWPFTable == null)
/* 152 */         return null; 
/* 153 */       if (xWPFTable.getCTTbl().equals(paramCTTbl))
/* 154 */         return xWPFTable; 
/*     */     } 
/* 156 */     return null;
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
/*     */   public XWPFParagraph getParagraph(CTP paramCTP) {
/* 170 */     for (XWPFParagraph xWPFParagraph : this.paragraphs) {
/* 171 */       if (xWPFParagraph.getCTP().equals(paramCTP))
/* 172 */         return xWPFParagraph; 
/*     */     } 
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph getParagraphArray(int paramInt) {
/* 184 */     if (paramInt >= 0 && paramInt < this.paragraphs.size()) {
/* 185 */       return this.paragraphs.get(paramInt);
/*     */     }
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell getTableCell(CTTc paramCTTc) {
/* 197 */     XmlCursor xmlCursor = paramCTTc.newCursor();
/* 198 */     xmlCursor.toParent();
/* 199 */     XmlObject xmlObject = xmlCursor.getObject();
/* 200 */     if (!(xmlObject instanceof CTRow)) {
/* 201 */       return null;
/*     */     }
/* 203 */     CTRow cTRow = (CTRow)xmlObject;
/* 204 */     xmlCursor.toParent();
/* 205 */     xmlObject = xmlCursor.getObject();
/* 206 */     xmlCursor.dispose();
/* 207 */     if (!(xmlObject instanceof CTTbl)) {
/* 208 */       return null;
/*     */     }
/* 210 */     CTTbl cTTbl = (CTTbl)xmlObject;
/* 211 */     XWPFTable xWPFTable = getTable(cTTbl);
/* 212 */     if (xWPFTable == null) {
/* 213 */       return null;
/*     */     }
/* 215 */     XWPFTableRow xWPFTableRow = xWPFTable.getRow(cTRow);
/* 216 */     if (xWPFTableRow == null) {
/* 217 */       return null;
/*     */     }
/* 219 */     return xWPFTableRow.getTableCell(paramCTTc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCursorInFtn(XmlCursor paramXmlCursor) {
/* 228 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 229 */     xmlCursor.toParent();
/* 230 */     if (xmlCursor.getObject() == this.ctFtnEdn) {
/* 231 */       return true;
/*     */     }
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   public POIXMLDocumentPart getOwner() {
/* 237 */     return this.footnotes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable insertNewTbl(XmlCursor paramXmlCursor) {
/* 246 */     if (isCursorInFtn(paramXmlCursor)) {
/* 247 */       String str1 = CTTbl.type.getName().getNamespaceURI();
/* 248 */       String str2 = "tbl";
/* 249 */       paramXmlCursor.beginElement(str2, str1);
/* 250 */       paramXmlCursor.toParent();
/* 251 */       CTTbl cTTbl = (CTTbl)paramXmlCursor.getObject();
/* 252 */       XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
/* 253 */       paramXmlCursor.removeXmlContents();
/* 254 */       XmlObject xmlObject = null;
/* 255 */       while (!(xmlObject instanceof CTTbl) && paramXmlCursor.toPrevSibling()) {
/* 256 */         xmlObject = paramXmlCursor.getObject();
/*     */       }
/* 258 */       if (!(xmlObject instanceof CTTbl)) {
/* 259 */         this.tables.add(0, xWPFTable);
/*     */       } else {
/* 261 */         int i = this.tables.indexOf(getTable((CTTbl)xmlObject)) + 1;
/* 262 */         this.tables.add(i, xWPFTable);
/*     */       } 
/* 264 */       byte b = 0;
/* 265 */       paramXmlCursor = cTTbl.newCursor();
/* 266 */       while (paramXmlCursor.toPrevSibling()) {
/* 267 */         xmlObject = paramXmlCursor.getObject();
/* 268 */         if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/* 269 */           b++; 
/*     */       } 
/* 271 */       this.bodyElements.add(b, xWPFTable);
/* 272 */       XmlCursor xmlCursor = cTTbl.newCursor();
/* 273 */       paramXmlCursor.toCursor(xmlCursor);
/* 274 */       paramXmlCursor.toEndToken();
/* 275 */       xmlCursor.dispose();
/* 276 */       return xWPFTable;
/*     */     } 
/* 278 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph insertNewParagraph(XmlCursor paramXmlCursor) {
/* 289 */     if (isCursorInFtn(paramXmlCursor)) {
/* 290 */       String str1 = CTP.type.getName().getNamespaceURI();
/* 291 */       String str2 = "p";
/* 292 */       paramXmlCursor.beginElement(str2, str1);
/* 293 */       paramXmlCursor.toParent();
/* 294 */       CTP cTP = (CTP)paramXmlCursor.getObject();
/* 295 */       XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/* 296 */       XmlObject xmlObject = null;
/* 297 */       while (!(xmlObject instanceof CTP) && paramXmlCursor.toPrevSibling()) {
/* 298 */         xmlObject = paramXmlCursor.getObject();
/*     */       }
/* 300 */       if (!(xmlObject instanceof CTP) || (CTP)xmlObject == cTP) {
/* 301 */         this.paragraphs.add(0, xWPFParagraph);
/*     */       } else {
/* 303 */         int i = this.paragraphs.indexOf(getParagraph((CTP)xmlObject)) + 1;
/* 304 */         this.paragraphs.add(i, xWPFParagraph);
/*     */       } 
/* 306 */       byte b = 0;
/* 307 */       XmlCursor xmlCursor = cTP.newCursor();
/* 308 */       paramXmlCursor.toCursor(xmlCursor);
/* 309 */       xmlCursor.dispose();
/* 310 */       while (paramXmlCursor.toPrevSibling()) {
/* 311 */         xmlObject = paramXmlCursor.getObject();
/* 312 */         if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/* 313 */           b++; 
/*     */       } 
/* 315 */       this.bodyElements.add(b, xWPFParagraph);
/* 316 */       xmlCursor = cTP.newCursor();
/* 317 */       paramXmlCursor.toCursor(xmlCursor);
/* 318 */       paramXmlCursor.toEndToken();
/* 319 */       xmlCursor.dispose();
/* 320 */       return xWPFParagraph;
/*     */     } 
/* 322 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable addNewTbl(CTTbl paramCTTbl) {
/* 332 */     CTTbl cTTbl = this.ctFtnEdn.addNewTbl();
/* 333 */     cTTbl.set((XmlObject)paramCTTbl);
/* 334 */     XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
/* 335 */     this.tables.add(xWPFTable);
/* 336 */     return xWPFTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph addNewParagraph(CTP paramCTP) {
/* 346 */     CTP cTP = this.ctFtnEdn.addNewP();
/* 347 */     cTP.set((XmlObject)paramCTP);
/* 348 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/* 349 */     this.paragraphs.add(xWPFParagraph);
/* 350 */     return xWPFParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFDocument getXWPFDocument() {
/* 357 */     return this.document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getPart() {
/* 366 */     return this.footnotes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyType getPartType() {
/* 375 */     return BodyType.FOOTNOTE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFFootnote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */