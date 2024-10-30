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
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHdrFtr;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumbering;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtBlock;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;
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
/*     */ public class XWPFHeader
/*     */   extends XWPFHeaderFooter
/*     */ {
/*     */   public XWPFHeader() {}
/*     */   
/*     */   public XWPFHeader(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart) throws IOException {
/*  54 */     super(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFHeader(POIXMLDocumentPart paramPOIXMLDocumentPart, PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  62 */     this(paramPOIXMLDocumentPart, paramPackagePart);
/*     */   }
/*     */   
/*     */   public XWPFHeader(XWPFDocument paramXWPFDocument, CTHdrFtr paramCTHdrFtr) {
/*  66 */     super(paramXWPFDocument, paramCTHdrFtr);
/*  67 */     XmlCursor xmlCursor = this.headerFooter.newCursor();
/*  68 */     xmlCursor.selectPath("./*");
/*  69 */     while (xmlCursor.toNextSelection()) {
/*  70 */       XmlObject xmlObject = xmlCursor.getObject();
/*  71 */       if (xmlObject instanceof CTP) {
/*  72 */         XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/*  73 */         this.paragraphs.add(xWPFParagraph);
/*     */       } 
/*  75 */       if (xmlObject instanceof CTTbl) {
/*  76 */         XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/*  77 */         this.tables.add(xWPFTable);
/*     */       } 
/*     */     } 
/*  80 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/*  88 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  89 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTNumbering.type.getName().getNamespaceURI(), "hdr"));
/*  90 */     PackagePart packagePart = getPackagePart();
/*  91 */     OutputStream outputStream = packagePart.getOutputStream();
/*  92 */     _getHdrFtr().save(outputStream, xmlOptions);
/*  93 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/* 103 */     super.onDocumentRead();
/* 104 */     HdrDocument hdrDocument = null;
/* 105 */     InputStream inputStream = null;
/*     */     try {
/* 107 */       inputStream = getPackagePart().getInputStream();
/* 108 */       hdrDocument = HdrDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 109 */       this.headerFooter = hdrDocument.getHdr();
/*     */ 
/*     */       
/* 112 */       XmlCursor xmlCursor = this.headerFooter.newCursor();
/* 113 */       xmlCursor.selectPath("./*");
/* 114 */       while (xmlCursor.toNextSelection()) {
/* 115 */         XmlObject xmlObject = xmlCursor.getObject();
/* 116 */         if (xmlObject instanceof CTP) {
/* 117 */           XWPFParagraph xWPFParagraph = new XWPFParagraph((CTP)xmlObject, this);
/* 118 */           this.paragraphs.add(xWPFParagraph);
/* 119 */           this.bodyElements.add(xWPFParagraph);
/*     */         } 
/* 121 */         if (xmlObject instanceof CTTbl) {
/* 122 */           XWPFTable xWPFTable = new XWPFTable((CTTbl)xmlObject, this);
/* 123 */           this.tables.add(xWPFTable);
/* 124 */           this.bodyElements.add(xWPFTable);
/*     */         } 
/* 126 */         if (xmlObject instanceof CTSdtBlock) {
/* 127 */           XWPFSDT xWPFSDT = new XWPFSDT((CTSdtBlock)xmlObject, this);
/* 128 */           this.bodyElements.add(xWPFSDT);
/*     */         } 
/*     */       } 
/* 131 */       xmlCursor.dispose();
/* 132 */     } catch (XmlException xmlException) {
/* 133 */       throw new POIXMLException(xmlException);
/*     */     } finally {
/* 135 */       if (inputStream != null) {
/* 136 */         inputStream.close();
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
/* 147 */     return BodyType.HEADER;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */