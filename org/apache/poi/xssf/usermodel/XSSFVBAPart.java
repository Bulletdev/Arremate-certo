/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XSSFVBAPart
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   protected XSSFVBAPart() {}
/*    */   
/*    */   protected XSSFVBAPart(PackagePart paramPackagePart) {
/* 41 */     super(paramPackagePart);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected XSSFVBAPart(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/* 49 */     this(paramPackagePart);
/*    */   }
/*    */   
/*    */   protected void prepareForCommit() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFVBAPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */