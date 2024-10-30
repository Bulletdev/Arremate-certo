/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.apache.xmlbeans.XmlOptions;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
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
/*    */ public class XSSFPivotCache
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   private CTPivotCache ctPivotCache;
/*    */   
/*    */   public XSSFPivotCache() {
/* 39 */     this.ctPivotCache = CTPivotCache.Factory.newInstance();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public XSSFPivotCache(CTPivotCache paramCTPivotCache) {
/* 45 */     this.ctPivotCache = paramCTPivotCache;
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
/*    */   protected XSSFPivotCache(PackagePart paramPackagePart) throws IOException {
/* 58 */     super(paramPackagePart);
/* 59 */     readFrom(paramPackagePart.getInputStream());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected XSSFPivotCache(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/* 67 */     this(paramPackagePart);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void readFrom(InputStream paramInputStream) throws IOException {
/*    */     try {
/* 73 */       XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*    */       
/* 75 */       xmlOptions.setLoadReplaceDocumentElement(null);
/* 76 */       this.ctPivotCache = CTPivotCache.Factory.parse(paramInputStream, xmlOptions);
/* 77 */     } catch (XmlException xmlException) {
/* 78 */       throw new IOException(xmlException.getLocalizedMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CTPivotCache getCTPivotCache() {
/* 84 */     return this.ctPivotCache;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPivotCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */