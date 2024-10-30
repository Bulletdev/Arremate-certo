/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentDocument1;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocument;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.util.PackageHelper;
/*     */ import org.apache.xmlbeans.XmlException;
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
/*     */ public class XmlVisioDocument
/*     */   extends POIXMLDocument
/*     */ {
/*     */   protected XDGFPages _pages;
/*     */   protected XDGFMasters _masters;
/*     */   protected XDGFDocument _document;
/*     */   
/*     */   public XmlVisioDocument(OPCPackage paramOPCPackage) throws IOException {
/*  64 */     super(paramOPCPackage, "http://schemas.microsoft.com/visio/2010/relationships/document");
/*     */     
/*     */     VisioDocumentType visioDocumentType;
/*     */     
/*     */     try {
/*  69 */       visioDocumentType = VisioDocumentDocument1.Factory.parse(getPackagePart().getInputStream()).getVisioDocument();
/*  70 */     } catch (XmlException xmlException) {
/*  71 */       throw new POIXMLException(xmlException);
/*  72 */     } catch (IOException iOException) {
/*  73 */       throw new POIXMLException(iOException);
/*     */     } 
/*     */     
/*  76 */     this._document = new XDGFDocument(visioDocumentType);
/*     */ 
/*     */     
/*  79 */     load(new XDGFFactory(this._document));
/*     */   }
/*     */   
/*     */   public XmlVisioDocument(InputStream paramInputStream) throws IOException {
/*  83 */     this(PackageHelper.open(paramInputStream));
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
/*     */   protected void onDocumentRead() throws IOException {
/*  95 */     for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/*     */ 
/*     */       
/*  98 */       if (pOIXMLDocumentPart instanceof XDGFPages) {
/*  99 */         this._pages = (XDGFPages)pOIXMLDocumentPart; continue;
/*     */       } 
/* 101 */       if (pOIXMLDocumentPart instanceof XDGFMasters) {
/* 102 */         this._masters = (XDGFMasters)pOIXMLDocumentPart;
/*     */       }
/*     */     } 
/* 105 */     if (this._masters != null) {
/* 106 */       this._masters.onDocumentRead();
/*     */     }
/* 108 */     this._pages.onDocumentRead();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
/* 116 */     return new ArrayList<PackagePart>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<XDGFPage> getPages() {
/* 127 */     return this._pages.getPageList();
/*     */   }
/*     */   
/*     */   public XDGFStyleSheet getStyleById(long paramLong) {
/* 131 */     return this._document.getStyleById(paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XmlVisioDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */