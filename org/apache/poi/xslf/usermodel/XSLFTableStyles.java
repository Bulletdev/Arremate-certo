/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument;
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
/*    */ public class XSLFTableStyles
/*    */   extends POIXMLDocumentPart
/*    */   implements Iterable<XSLFTableStyle>
/*    */ {
/*    */   private CTTableStyleList _tblStyleLst;
/*    */   private List<XSLFTableStyle> _styles;
/*    */   
/*    */   public XSLFTableStyles() {}
/*    */   
/*    */   public XSLFTableStyles(PackagePart paramPackagePart) throws IOException, XmlException {
/* 48 */     super(paramPackagePart);
/*    */     
/* 50 */     InputStream inputStream = getPackagePart().getInputStream();
/* 51 */     TblStyleLstDocument tblStyleLstDocument = TblStyleLstDocument.Factory.parse(inputStream);
/* 52 */     inputStream.close();
/* 53 */     this._tblStyleLst = tblStyleLstDocument.getTblStyleLst();
/* 54 */     CTTableStyle[] arrayOfCTTableStyle = this._tblStyleLst.getTblStyleArray();
/* 55 */     this._styles = new ArrayList<XSLFTableStyle>(arrayOfCTTableStyle.length);
/* 56 */     for (CTTableStyle cTTableStyle : arrayOfCTTableStyle) {
/* 57 */       this._styles.add(new XSLFTableStyle(cTTableStyle));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public XSLFTableStyles(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/* 66 */     this(paramPackagePart);
/*    */   }
/*    */   
/*    */   public CTTableStyleList getXmlObject() {
/* 70 */     return this._tblStyleLst;
/*    */   }
/*    */   
/*    */   public Iterator<XSLFTableStyle> iterator() {
/* 74 */     return this._styles.iterator();
/*    */   }
/*    */   
/*    */   public List<XSLFTableStyle> getStyles() {
/* 78 */     return Collections.unmodifiableList(this._styles);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFTableStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */