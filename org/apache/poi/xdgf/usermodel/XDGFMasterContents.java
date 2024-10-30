/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.MasterContentsDocument;
/*    */ import java.io.IOException;
/*    */ import org.apache.poi.POIXMLException;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.poi.xdgf.exceptions.XDGFException;
/*    */ import org.apache.xmlbeans.XmlException;
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
/*    */ public class XDGFMasterContents
/*    */   extends XDGFBaseContents
/*    */ {
/*    */   protected XDGFMaster _master;
/*    */   
/*    */   public XDGFMasterContents(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/* 41 */     super(paramPackagePart, paramXDGFDocument);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public XDGFMasterContents(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/* 49 */     this(paramPackagePart, paramXDGFDocument);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void onDocumentRead() {
/*    */     try {
/*    */       try {
/* 59 */         this._pageContents = MasterContentsDocument.Factory.parse(getPackagePart().getInputStream()).getMasterContents();
/* 60 */       } catch (XmlException xmlException) {
/* 61 */         throw new POIXMLException(xmlException);
/* 62 */       } catch (IOException iOException) {
/* 63 */         throw new POIXMLException(iOException);
/*    */       } 
/*    */       
/* 66 */       super.onDocumentRead();
/*    */     }
/* 68 */     catch (POIXMLException pOIXMLException) {
/* 69 */       throw XDGFException.wrap(this, pOIXMLException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public XDGFMaster getMaster() {
/* 74 */     return this._master;
/*    */   }
/*    */   
/*    */   protected void setMaster(XDGFMaster paramXDGFMaster) {
/* 78 */     this._master = paramXDGFMaster;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFMasterContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */