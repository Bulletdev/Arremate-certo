/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.poi.POIXMLDocumentPart;
/*    */ import org.apache.poi.POIXMLTypeLoader;
/*    */ import org.apache.poi.openxml4j.opc.PackagePart;
/*    */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.xmlbeans.XmlException;
/*    */ import org.apache.xmlbeans.XmlOptions;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheRecords;
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
/*    */ public class XSSFPivotCacheRecords
/*    */   extends POIXMLDocumentPart
/*    */ {
/*    */   private CTPivotCacheRecords ctPivotCacheRecords;
/*    */   
/*    */   public XSSFPivotCacheRecords() {
/* 42 */     this.ctPivotCacheRecords = CTPivotCacheRecords.Factory.newInstance();
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
/*    */   protected XSSFPivotCacheRecords(PackagePart paramPackagePart) throws IOException {
/* 55 */     super(paramPackagePart);
/* 56 */     readFrom(paramPackagePart.getInputStream());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   protected XSSFPivotCacheRecords(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/* 64 */     this(paramPackagePart);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void readFrom(InputStream paramInputStream) throws IOException {
/*    */     try {
/* 70 */       XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*    */       
/* 72 */       xmlOptions.setLoadReplaceDocumentElement(null);
/* 73 */       this.ctPivotCacheRecords = CTPivotCacheRecords.Factory.parse(paramInputStream, xmlOptions);
/* 74 */     } catch (XmlException xmlException) {
/* 75 */       throw new IOException(xmlException.getLocalizedMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @Internal
/*    */   public CTPivotCacheRecords getCtPivotCacheRecords() {
/* 82 */     return this.ctPivotCacheRecords;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void commit() throws IOException {
/* 88 */     PackagePart packagePart = getPackagePart();
/* 89 */     OutputStream outputStream = packagePart.getOutputStream();
/* 90 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*    */     
/* 92 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTPivotCacheRecords.type.getName().getNamespaceURI(), "pivotCacheRecords"));
/*    */     
/* 94 */     this.ctPivotCacheRecords.save(outputStream, xmlOptions);
/* 95 */     outputStream.close();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPivotCacheRecords.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */