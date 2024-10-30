/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;
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
/*     */ 
/*     */ public abstract class XWPFHeaderFooter
/*     */   extends POIXMLDocumentPart
/*     */   implements IBody
/*     */ {
/*  46 */   List<XWPFParagraph> paragraphs = new ArrayList<XWPFParagraph>(1);
/*  47 */   List<XWPFTable> tables = new ArrayList<XWPFTable>(1);
/*  48 */   List<XWPFPictureData> pictures = new ArrayList<XWPFPictureData>();
/*  49 */   List<IBodyElement> bodyElements = new ArrayList<IBodyElement>(1);
/*     */   
/*     */   CTHdrFtr headerFooter;
/*     */   XWPFDocument document;
/*     */   
/*     */   XWPFHeaderFooter(XWPFDocument paramXWPFDocument, CTHdrFtr paramCTHdrFtr) {
/*  55 */     if (paramXWPFDocument == null) {
/*  56 */       throw new NullPointerException();
/*     */     }
/*     */     
/*  59 */     this.document = paramXWPFDocument;
/*  60 */     this.headerFooter = paramCTHdrFtr;
/*  61 */     readHdrFtr();
/*     */   }
/*     */   
/*     */   protected XWPFHeaderFooter() {
/*  65 */     this.headerFooter = CTHdrFtr.Factory.newInstance();
/*  66 */     readHdrFtr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFHeaderFooter(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) throws IOException {
/*  73 */     super(paramPOIXMLDocumentPart, paramPackagePart);
/*  74 */     this.document = (XWPFDocument)getParent();
/*     */     
/*  76 */     if (this.document == null) {
/*  77 */       throw new NullPointerException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFHeaderFooter(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  86 */     this(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  91 */     for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/*  92 */       if (pOIXMLDocumentPart instanceof XWPFPictureData) {
/*  93 */         XWPFPictureData xWPFPictureData = (XWPFPictureData)pOIXMLDocumentPart;
/*  94 */         this.pictures.add(xWPFPictureData);
/*  95 */         this.document.registerPackagePictureData(xWPFPictureData);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @Internal
/*     */   public CTHdrFtr _getHdrFtr() {
/* 102 */     return this.headerFooter;
/*     */   }
/*     */   
/*     */   public List<IBodyElement> getBodyElements() {
/* 106 */     return Collections.unmodifiableList(this.bodyElements);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFParagraph> getParagraphs() {
/* 117 */     return Collections.unmodifiableList(this.paragraphs);
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
/*     */   public List<XWPFTable> getTables() throws ArrayIndexOutOfBoundsException {
/* 130 */     return Collections.unmodifiableList(this.tables);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 139 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     byte b;
/* 141 */     for (b = 0; b < this.paragraphs.size(); b++) {
/* 142 */       if (!((XWPFParagraph)this.paragraphs.get(b)).isEmpty()) {
/* 143 */         String str = ((XWPFParagraph)this.paragraphs.get(b)).getText();
/* 144 */         if (str != null && str.length() > 0) {
/* 145 */           stringBuffer.append(str);
/* 146 */           stringBuffer.append('\n');
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     for (b = 0; b < this.tables.size(); b++) {
/* 152 */       String str = ((XWPFTable)this.tables.get(b)).getText();
/* 153 */       if (str != null && str.length() > 0) {
/* 154 */         stringBuffer.append(str);
/* 155 */         stringBuffer.append('\n');
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     for (IBodyElement iBodyElement : getBodyElements()) {
/* 160 */       if (iBodyElement instanceof XWPFSDT) {
/* 161 */         stringBuffer.append(((XWPFSDT)iBodyElement).getContent().getText() + '\n');
/*     */       }
/*     */     } 
/* 164 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaderFooter(CTHdrFtr paramCTHdrFtr) {
/* 171 */     this.headerFooter = paramCTHdrFtr;
/* 172 */     readHdrFtr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable getTable(CTTbl paramCTTbl) {
/* 183 */     for (XWPFTable xWPFTable : this.tables) {
/* 184 */       if (xWPFTable == null)
/* 185 */         return null; 
/* 186 */       if (xWPFTable.getCTTbl().equals(paramCTTbl))
/* 187 */         return xWPFTable; 
/*     */     } 
/* 189 */     return null;
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
/* 202 */     for (XWPFParagraph xWPFParagraph : this.paragraphs) {
/* 203 */       if (xWPFParagraph.getCTP().equals(paramCTP))
/* 204 */         return xWPFParagraph; 
/*     */     } 
/* 206 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph getParagraphArray(int paramInt) {
/* 215 */     if (paramInt >= 0 && paramInt < this.paragraphs.size()) {
/* 216 */       return this.paragraphs.get(paramInt);
/*     */     }
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFParagraph> getListParagraph() {
/* 227 */     return this.paragraphs;
/*     */   }
/*     */   
/*     */   public List<XWPFPictureData> getAllPictures() {
/* 231 */     return Collections.unmodifiableList(this.pictures);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XWPFPictureData> getAllPackagePictures() {
/* 240 */     return this.document.getAllPackagePictures();
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
/*     */   public String addPictureData(byte[] paramArrayOfbyte, int paramInt) throws InvalidFormatException {
/* 253 */     XWPFPictureData xWPFPictureData = this.document.findPackagePictureData(paramArrayOfbyte, paramInt);
/* 254 */     POIXMLRelation pOIXMLRelation = XWPFPictureData.RELATIONS[paramInt];
/*     */     
/* 256 */     if (xWPFPictureData == null) {
/*     */       
/* 258 */       int i = this.document.getNextPicNameNumber(paramInt);
/* 259 */       xWPFPictureData = (XWPFPictureData)createRelationship(pOIXMLRelation, XWPFFactory.getInstance(), i);
/*     */       
/* 261 */       PackagePart packagePart = xWPFPictureData.getPackagePart();
/* 262 */       OutputStream outputStream = null;
/*     */       try {
/* 264 */         outputStream = packagePart.getOutputStream();
/* 265 */         outputStream.write(paramArrayOfbyte);
/* 266 */       } catch (IOException iOException) {
/* 267 */         throw new POIXMLException(iOException);
/*     */       } finally {
/*     */         try {
/* 270 */           if (outputStream != null) outputStream.close(); 
/* 271 */         } catch (IOException iOException) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 276 */       this.document.registerPackagePictureData(xWPFPictureData);
/* 277 */       this.pictures.add(xWPFPictureData);
/* 278 */       return getRelationId(xWPFPictureData);
/* 279 */     }  if (!getRelations().contains(xWPFPictureData)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 286 */       POIXMLDocumentPart.RelationPart relationPart = addRelation(null, XWPFRelation.IMAGES, xWPFPictureData);
/* 287 */       this.pictures.add(xWPFPictureData);
/* 288 */       return relationPart.getRelationship().getId();
/*     */     } 
/*     */     
/* 291 */     return getRelationId(xWPFPictureData);
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
/*     */   public String addPictureData(InputStream paramInputStream, int paramInt) throws InvalidFormatException, IOException {
/* 305 */     byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
/* 306 */     return addPictureData(arrayOfByte, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFPictureData getPictureDataByID(String paramString) {
/* 317 */     POIXMLDocumentPart pOIXMLDocumentPart = getRelationById(paramString);
/* 318 */     if (pOIXMLDocumentPart != null && pOIXMLDocumentPart instanceof XWPFPictureData) {
/* 319 */       return (XWPFPictureData)pOIXMLDocumentPart;
/*     */     }
/* 321 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph createParagraph() {
/* 328 */     XWPFParagraph xWPFParagraph = new XWPFParagraph(this.headerFooter.addNewP(), this);
/* 329 */     this.paragraphs.add(xWPFParagraph);
/* 330 */     return xWPFParagraph;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFParagraph insertNewParagraph(XmlCursor paramXmlCursor) {
/* 340 */     if (isCursorInHdrF(paramXmlCursor)) {
/* 341 */       String str1 = CTP.type.getName().getNamespaceURI();
/* 342 */       String str2 = "p";
/* 343 */       paramXmlCursor.beginElement(str2, str1);
/* 344 */       paramXmlCursor.toParent();
/* 345 */       CTP cTP = (CTP)paramXmlCursor.getObject();
/* 346 */       XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, this);
/* 347 */       XmlObject xmlObject = null;
/* 348 */       while (!(xmlObject instanceof CTP) && paramXmlCursor.toPrevSibling()) {
/* 349 */         xmlObject = paramXmlCursor.getObject();
/*     */       }
/* 351 */       if (!(xmlObject instanceof CTP) || (CTP)xmlObject == cTP) {
/* 352 */         this.paragraphs.add(0, xWPFParagraph);
/*     */       } else {
/* 354 */         int i = this.paragraphs.indexOf(getParagraph((CTP)xmlObject)) + 1;
/* 355 */         this.paragraphs.add(i, xWPFParagraph);
/*     */       } 
/* 357 */       byte b = 0;
/* 358 */       XmlCursor xmlCursor = cTP.newCursor();
/* 359 */       paramXmlCursor.toCursor(xmlCursor);
/* 360 */       xmlCursor.dispose();
/* 361 */       while (paramXmlCursor.toPrevSibling()) {
/* 362 */         xmlObject = paramXmlCursor.getObject();
/* 363 */         if (xmlObject instanceof CTP || xmlObject instanceof CTTbl)
/* 364 */           b++; 
/*     */       } 
/* 366 */       this.bodyElements.add(b, xWPFParagraph);
/* 367 */       xmlCursor = cTP.newCursor();
/* 368 */       paramXmlCursor.toCursor(xmlCursor);
/* 369 */       paramXmlCursor.toEndToken();
/* 370 */       xmlCursor.dispose();
/* 371 */       return xWPFParagraph;
/*     */     } 
/* 373 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable insertNewTbl(XmlCursor paramXmlCursor) {
/* 382 */     if (isCursorInHdrF(paramXmlCursor)) {
/* 383 */       String str1 = CTTbl.type.getName().getNamespaceURI();
/* 384 */       String str2 = "tbl";
/* 385 */       paramXmlCursor.beginElement(str2, str1);
/* 386 */       paramXmlCursor.toParent();
/* 387 */       CTTbl cTTbl = (CTTbl)paramXmlCursor.getObject();
/* 388 */       XWPFTable xWPFTable = new XWPFTable(cTTbl, this);
/* 389 */       paramXmlCursor.removeXmlContents();
/* 390 */       XmlObject xmlObject = null;
/* 391 */       while (!(xmlObject instanceof CTTbl) && paramXmlCursor.toPrevSibling()) {
/* 392 */         xmlObject = paramXmlCursor.getObject();
/*     */       }
/* 394 */       if (!(xmlObject instanceof CTTbl)) {
/* 395 */         this.tables.add(0, xWPFTable);
/*     */       } else {
/* 397 */         int i = this.tables.indexOf(getTable((CTTbl)xmlObject)) + 1;
/* 398 */         this.tables.add(i, xWPFTable);
/*     */       } 
/* 400 */       byte b = 0;
/* 401 */       XmlCursor xmlCursor = cTTbl.newCursor();
/* 402 */       while (xmlCursor.toPrevSibling()) {
/* 403 */         xmlObject = xmlCursor.getObject();
/* 404 */         if (xmlObject instanceof CTP || xmlObject instanceof CTTbl) {
/* 405 */           b++;
/*     */         }
/*     */       } 
/* 408 */       xmlCursor.dispose();
/* 409 */       this.bodyElements.add(b, xWPFTable);
/* 410 */       xmlCursor = cTTbl.newCursor();
/* 411 */       paramXmlCursor.toCursor(xmlCursor);
/* 412 */       paramXmlCursor.toEndToken();
/* 413 */       xmlCursor.dispose();
/* 414 */       return xWPFTable;
/*     */     } 
/* 416 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCursorInHdrF(XmlCursor paramXmlCursor) {
/* 425 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 426 */     xmlCursor.toParent();
/* 427 */     boolean bool = (xmlCursor.getObject() == this.headerFooter) ? true : false;
/* 428 */     xmlCursor.dispose();
/* 429 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getOwner() {
/* 434 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTable getTableArray(int paramInt) {
/* 443 */     if (paramInt >= 0 && paramInt < this.tables.size()) {
/* 444 */       return this.tables.get(paramInt);
/*     */     }
/* 446 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertTable(int paramInt, XWPFTable paramXWPFTable) {
/* 456 */     this.bodyElements.add(paramInt, paramXWPFTable);
/* 457 */     byte b = 0;
/* 458 */     for (CTTbl cTTbl : this.headerFooter.getTblArray()) {
/* 459 */       if (cTTbl == paramXWPFTable.getCTTbl()) {
/*     */         break;
/*     */       }
/* 462 */       b++;
/*     */     } 
/* 464 */     this.tables.add(b, paramXWPFTable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readHdrFtr() {
/* 469 */     this.bodyElements = new ArrayList<IBodyElement>();
/* 470 */     this.paragraphs = new ArrayList<XWPFParagraph>();
/* 471 */     this.tables = new ArrayList<XWPFTable>();
/*     */ 
/*     */     
/* 474 */     XmlCursor xmlCursor = this.headerFooter.newCursor();
/* 475 */     xmlCursor.selectPath("./*");
/* 476 */     while (xmlCursor.toNextSelection()) {
/* 477 */       XmlObject xmlObject = xmlCursor.getObject();
/* 478 */       if (xmlObject instanceof CTP) {
/* 479 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/* 480 */         this.paragraphs.add(xWPFParagraph);
/* 481 */         this.bodyElements.add(xWPFParagraph);
/*     */       } 
/* 483 */       if (xmlObject instanceof CTTbl) {
/* 484 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/* 485 */         this.tables.add(xWPFTable);
/* 486 */         this.bodyElements.add(xWPFTable);
/*     */       } 
/*     */     } 
/* 489 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFTableCell getTableCell(CTTc paramCTTc) {
/* 498 */     XmlCursor xmlCursor = paramCTTc.newCursor();
/* 499 */     xmlCursor.toParent();
/* 500 */     XmlObject xmlObject = xmlCursor.getObject();
/* 501 */     if (!(xmlObject instanceof CTRow)) {
/* 502 */       xmlCursor.dispose();
/* 503 */       return null;
/*     */     } 
/* 505 */     CTRow cTRow = (CTRow)xmlObject;
/* 506 */     xmlCursor.toParent();
/* 507 */     xmlObject = xmlCursor.getObject();
/* 508 */     xmlCursor.dispose();
/* 509 */     if (!(xmlObject instanceof CTTbl)) {
/* 510 */       return null;
/*     */     }
/* 512 */     CTTbl cTTbl = (CTTbl)xmlObject;
/* 513 */     XWPFTable xWPFTable = getTable(cTTbl);
/* 514 */     if (xWPFTable == null) {
/* 515 */       return null;
/*     */     }
/* 517 */     XWPFTableRow xWPFTableRow = xWPFTable.getRow(cTRow);
/* 518 */     return xWPFTableRow.getTableCell(paramCTTc);
/*     */   }
/*     */   
/*     */   public XWPFDocument getXWPFDocument() {
/* 522 */     if (this.document != null) {
/* 523 */       return this.document;
/*     */     }
/* 525 */     return (XWPFDocument)getParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setXWPFDocument(XWPFDocument paramXWPFDocument) {
/* 530 */     this.document = paramXWPFDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLDocumentPart getPart() {
/* 539 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFHeaderFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */