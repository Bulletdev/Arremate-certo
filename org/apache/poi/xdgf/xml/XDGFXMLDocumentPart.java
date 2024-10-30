/*    */ package org.apache.poi.xdgf.xml;
/*    */ 
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFDocument;
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
/*    */ public class XDGFXMLDocumentPart
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   protected XDGFDocument _document;
/*    */   
/*    */   public XDGFXMLDocumentPart(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/* 32 */     super(paramPackagePart);
/* 33 */     this._document = paramXDGFDocument;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public XDGFXMLDocumentPart(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/* 41 */     this(paramPackagePart, paramXDGFDocument);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdgf\xml\XDGFXMLDocumentPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */