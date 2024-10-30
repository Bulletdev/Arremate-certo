/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFootnotes;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.FootnotesDocument;
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
/*     */ public class XWPFFootnotes
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   protected XWPFDocument document;
/*  46 */   private List<XWPFFootnote> listFootnote = new ArrayList<XWPFFootnote>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CTFootnotes ctFootnotes;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFootnotes(PackagePart paramPackagePart) throws IOException, OpenXML4JException {
/*  57 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XWPFFootnotes(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, OpenXML4JException {
/*  65 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFootnotes() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() throws IOException {
/*  80 */     InputStream inputStream = null;
/*     */     try {
/*  82 */       inputStream = getPackagePart().getInputStream();
/*  83 */       FootnotesDocument footnotesDocument = FootnotesDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  84 */       this.ctFootnotes = footnotesDocument.getFootnotes();
/*  85 */     } catch (XmlException xmlException) {
/*  86 */       throw new POIXMLException();
/*     */     } finally {
/*  88 */       if (inputStream != null) {
/*  89 */         inputStream.close();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  94 */     for (CTFtnEdn cTFtnEdn : this.ctFootnotes.getFootnoteArray()) {
/*  95 */       this.listFootnote.add(new XWPFFootnote(cTFtnEdn, this));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 101 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 102 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTFootnotes.type.getName().getNamespaceURI(), "footnotes"));
/* 103 */     PackagePart packagePart = getPackagePart();
/* 104 */     OutputStream outputStream = packagePart.getOutputStream();
/* 105 */     this.ctFootnotes.save(outputStream, xmlOptions);
/* 106 */     outputStream.close();
/*     */   }
/*     */   
/*     */   public List<XWPFFootnote> getFootnotesList() {
/* 110 */     return this.listFootnote;
/*     */   }
/*     */   
/*     */   public XWPFFootnote getFootnoteById(int paramInt) {
/* 114 */     for (XWPFFootnote xWPFFootnote : this.listFootnote) {
/* 115 */       if (xWPFFootnote.getCTFtnEdn().getId().intValue() == paramInt)
/* 116 */         return xWPFFootnote; 
/*     */     } 
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFootnotes(CTFootnotes paramCTFootnotes) {
/* 127 */     this.ctFootnotes = paramCTFootnotes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addFootnote(XWPFFootnote paramXWPFFootnote) {
/* 137 */     this.listFootnote.add(paramXWPFFootnote);
/* 138 */     this.ctFootnotes.addNewFootnote().set((XmlObject)paramXWPFFootnote.getCTFtnEdn());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFFootnote addFootnote(CTFtnEdn paramCTFtnEdn) {
/* 148 */     CTFtnEdn cTFtnEdn = this.ctFootnotes.addNewFootnote();
/* 149 */     cTFtnEdn.set((XmlObject)paramCTFtnEdn);
/* 150 */     XWPFFootnote xWPFFootnote = new XWPFFootnote(cTFtnEdn, this);
/* 151 */     this.listFootnote.add(xWPFFootnote);
/* 152 */     return xWPFFootnote;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFDocument getXWPFDocument() {
/* 159 */     if (this.document != null) {
/* 160 */       return this.document;
/*     */     }
/* 162 */     return (XWPFDocument)getParent();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setXWPFDocument(XWPFDocument paramXWPFDocument) {
/* 167 */     this.document = paramXWPFDocument;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFFootnotes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */