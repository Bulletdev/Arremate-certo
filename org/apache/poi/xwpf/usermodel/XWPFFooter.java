/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.FtrDocument;
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
/*     */ public class XWPFFooter
/*     */   extends XWPFHeaderFooter
/*     */ {
/*     */   public XWPFFooter() {}
/*     */   
/*     */   public XWPFFooter(XWPFDocument paramXWPFDocument, CTHdrFtr paramCTHdrFtr) throws IOException {
/*  50 */     super(paramXWPFDocument, paramCTHdrFtr);
/*  51 */     XmlCursor xmlCursor = this.headerFooter.newCursor();
/*  52 */     xmlCursor.selectPath("./*");
/*  53 */     while (xmlCursor.toNextSelection()) {
/*  54 */       XmlObject xmlObject = xmlCursor.getObject();
/*  55 */       if (xmlObject instanceof CTP) {
/*  56 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/*  57 */         this.paragraphs.add(xWPFParagraph);
/*  58 */         this.bodyElements.add(xWPFParagraph);
/*     */       } 
/*  60 */       if (xmlObject instanceof CTTbl) {
/*  61 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/*  62 */         this.tables.add(xWPFTable);
/*  63 */         this.bodyElements.add(xWPFTable);
/*     */       } 
/*     */     } 
/*     */     
/*  67 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFooter(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) throws IOException {
/*  74 */     super(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFFooter(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  82 */     this(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  90 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  91 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTNumbering.type.getName().getNamespaceURI(), "ftr"));
/*  92 */     PackagePart packagePart = getPackagePart();
/*  93 */     OutputStream outputStream = packagePart.getOutputStream();
/*  94 */     _getHdrFtr().save(outputStream, xmlOptions);
/*  95 */     outputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/* 100 */     super.onDocumentRead();
/* 101 */     FtrDocument ftrDocument = null;
/* 102 */     InputStream inputStream = null;
/*     */     try {
/* 104 */       inputStream = getPackagePart().getInputStream();
/* 105 */       ftrDocument = FtrDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 106 */       this.headerFooter = ftrDocument.getFtr();
/*     */ 
/*     */       
/* 109 */       XmlCursor xmlCursor = this.headerFooter.newCursor();
/* 110 */       xmlCursor.selectPath("./*");
/* 111 */       while (xmlCursor.toNextSelection()) {
/* 112 */         XmlObject xmlObject = xmlCursor.getObject();
/* 113 */         if (xmlObject instanceof CTP) {
/* 114 */           XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/* 115 */           this.paragraphs.add(xWPFParagraph);
/* 116 */           this.bodyElements.add(xWPFParagraph);
/*     */         } 
/* 118 */         if (xmlObject instanceof CTTbl) {
/* 119 */           XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/* 120 */           this.tables.add(xWPFTable);
/* 121 */           this.bodyElements.add(xWPFTable);
/*     */         } 
/* 123 */         if (xmlObject instanceof CTSdtBlock) {
/* 124 */           XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this);
/* 125 */           this.bodyElements.add(xWPFSDT);
/*     */         } 
/*     */       } 
/* 128 */       xmlCursor.dispose();
/* 129 */     } catch (Exception exception) {
/* 130 */       throw new POIXMLException(exception);
/*     */     } finally {
/* 132 */       if (inputStream != null) {
/* 133 */         inputStream.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BodyType getPartType() {
/* 144 */     return BodyType.FOOTER;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */