/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthor;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentAuthorList;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CmAuthorLstDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSLFCommentAuthors
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   private final CTCommentAuthorList _authors;
/*    */   
/*    */   XSLFCommentAuthors() {
/* 42 */     CmAuthorLstDocument cmAuthorLstDocument = CmAuthorLstDocument.Factory.newInstance();
/* 43 */     this._authors = cmAuthorLstDocument.addNewCmAuthorLst();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   XSLFCommentAuthors(PackagePart paramPackagePart) throws IOException, XmlException {
/* 55 */     super(paramPackagePart);
/* 56 */     CmAuthorLstDocument cmAuthorLstDocument = CmAuthorLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*    */     
/* 58 */     this._authors = cmAuthorLstDocument.getCmAuthorLst();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   XSLFCommentAuthors(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/* 73 */     this(paramPackagePart);
/*    */   }
/*    */   
/*    */   public CTCommentAuthorList getCTCommentAuthorsList() {
/* 77 */     return this._authors;
/*    */   }
/*    */ 
/*    */   
/*    */   public CTCommentAuthor getAuthorById(long paramLong) {
/* 82 */     for (CTCommentAuthor cTCommentAuthor : this._authors.getCmAuthorArray()) {
/* 83 */       if (cTCommentAuthor.getId() == paramLong) {
/* 84 */         return cTCommentAuthor;
/*    */       }
/*    */     } 
/* 87 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFCommentAuthors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */