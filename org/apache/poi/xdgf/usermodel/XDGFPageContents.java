/*    */ package org.apache.poi.xdgf.usermodel;
/*    */ 
/*    */ import com.microsoft.schemas.office.visio.x2012.main.PageContentsDocument;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.POIXMLDocumentPart;
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
/*    */ public class XDGFPageContents
/*    */   extends XDGFBaseContents
/*    */ {
/* 35 */   protected Map<Long, XDGFMaster> _masters = new HashMap<Long, XDGFMaster>();
/*    */ 
/*    */   
/*    */   protected XDGFPage _page;
/*    */ 
/*    */   
/*    */   public XDGFPageContents(PackagePart paramPackagePart, XDGFDocument paramXDGFDocument) {
/* 42 */     super(paramPackagePart, paramXDGFDocument);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public XDGFPageContents(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship, XDGFDocument paramXDGFDocument) {
/* 50 */     this(paramPackagePart, paramXDGFDocument);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void onDocumentRead() {
/*    */     try {
/*    */       try {
/* 57 */         this._pageContents = PageContentsDocument.Factory.parse(getPackagePart().getInputStream()).getPageContents();
/* 58 */       } catch (XmlException xmlException) {
/* 59 */         throw new POIXMLException(xmlException);
/* 60 */       } catch (IOException iOException) {
/* 61 */         throw new POIXMLException(iOException);
/*    */       } 
/*    */       
/* 64 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/* 65 */         if (!(pOIXMLDocumentPart instanceof XDGFMasterContents)) {
/*    */           continue;
/*    */         }
/*    */         
/* 69 */         XDGFMaster xDGFMaster = ((XDGFMasterContents)pOIXMLDocumentPart).getMaster();
/* 70 */         this._masters.put(Long.valueOf(xDGFMaster.getID()), xDGFMaster);
/*    */       } 
/*    */       
/* 73 */       super.onDocumentRead();
/*    */       
/* 75 */       for (XDGFShape xDGFShape : this._shapes.values()) {
/* 76 */         if (xDGFShape.isTopmost()) {
/* 77 */           xDGFShape.setupMaster(this, null);
/*    */         }
/*    */       } 
/* 80 */     } catch (POIXMLException pOIXMLException) {
/* 81 */       throw XDGFException.wrap(this, pOIXMLException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XDGFPage getPage() {
/* 89 */     return this._page;
/*    */   }
/*    */   
/*    */   protected void setPage(XDGFPage paramXDGFPage) {
/* 93 */     this._page = paramXDGFPage;
/*    */   }
/*    */   
/*    */   public XDGFMaster getMasterById(long paramLong) {
/* 97 */     return this._masters.get(Long.valueOf(paramLong));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\usermodel\XDGFPageContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */