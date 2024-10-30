/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTComment;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CTCommentList;
/*    */ import org.openxmlformats.schemas.presentationml.x2006.main.CmLstDocument;
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
/*    */ public class XSLFComments
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   private final CTCommentList _comments;
/*    */   
/*    */   XSLFComments() {
/* 42 */     CmLstDocument cmLstDocument = CmLstDocument.Factory.newInstance();
/* 43 */     this._comments = cmLstDocument.addNewCmLst();
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
/*    */   XSLFComments(PackagePart paramPackagePart) throws IOException, XmlException {
/* 55 */     super(paramPackagePart);
/*    */     
/* 57 */     CmLstDocument cmLstDocument = CmLstDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*    */     
/* 59 */     this._comments = cmLstDocument.getCmLst();
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
/*    */   XSLFComments(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/* 74 */     this(paramPackagePart);
/*    */   }
/*    */   
/*    */   public CTCommentList getCTCommentsList() {
/* 78 */     return this._comments;
/*    */   }
/*    */   
/*    */   public int getNumberOfComments() {
/* 82 */     return this._comments.sizeOfCmArray();
/*    */   }
/*    */   
/*    */   public CTComment getCommentAt(int paramInt) {
/* 86 */     return this._comments.getCmArray(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFComments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */