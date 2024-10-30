/*     */ package org.apache.poi.xdgf.usermodel;
/*     */ 
/*     */ import com.microsoft.schemas.office.visio.x2012.main.PageType;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.PagesDocument;
/*     */ import com.microsoft.schemas.office.visio.x2012.main.PagesType;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*     */ import org.apache.poi.xdgf.xml.XDGFXMLDocumentPart;
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
/*     */ public class XDGFPages
/*     */   extends XDGFXMLDocumentPart
/*     */ {
/*     */   PagesType _pagesObject;
/*  46 */   List<XDGFPage> _pages = new ArrayList<XDGFPage>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XDGFPages(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/*  52 */     super(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public XDGFPages(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/*  60 */     this(paramPackagePart, paramXDGFDocument);
/*     */   }
/*     */   
/*     */   @Internal
/*     */   PagesType getXmlObject() {
/*  65 */     return this._pagesObject;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onDocumentRead() {
/*     */     try {
/*     */       try {
/*  72 */         this._pagesObject = PagesDocument.Factory.parse(getPackagePart().getInputStream()).getPages();
/*  73 */       } catch (XmlException xmlException) {
/*  74 */         throw new POIXMLException(xmlException);
/*  75 */       } catch (IOException iOException) {
/*  76 */         throw new POIXMLException(iOException);
/*     */       } 
/*     */ 
/*     */       
/*  80 */       for (PageType pageType : this._pagesObject.getPageArray())
/*     */       {
/*  82 */         String str = pageType.getRel().getId();
/*     */         
/*  84 */         POIXMLDocumentPart pOIXMLDocumentPart = getRelationById(str);
/*  85 */         if (pOIXMLDocumentPart == null) {
/*  86 */           throw new POIXMLException("PageSettings relationship for " + str + " not found");
/*     */         }
/*  88 */         if (!(pOIXMLDocumentPart instanceof XDGFPageContents)) {
/*  89 */           throw new POIXMLException("Unexpected pages relationship for " + str + ": " + pOIXMLDocumentPart);
/*     */         }
/*  91 */         XDGFPageContents xDGFPageContents = (XDGFPageContents)pOIXMLDocumentPart;
/*  92 */         XDGFPage xDGFPage = new XDGFPage(pageType, xDGFPageContents, this._document, this);
/*     */         
/*  94 */         xDGFPageContents.onDocumentRead();
/*     */         
/*  96 */         this._pages.add(xDGFPage);
/*     */       }
/*     */     
/*  99 */     } catch (POIXMLException pOIXMLException) {
/* 100 */       throw XDGFException.wrap(this, pOIXMLException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<XDGFPage> getPageList() {
/* 108 */     return Collections.unmodifiableList(this._pages);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFPages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */