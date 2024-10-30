/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTChartsheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.ChartsheetDocument;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFChartSheet
/*     */   extends XSSFSheet
/*     */ {
/*  50 */   private static final byte[] BLANK_WORKSHEET = blankWorksheet();
/*     */ 
/*     */   
/*     */   protected CTChartsheet chartsheet;
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFChartSheet(PackagePart paramPackagePart) {
/*  58 */     super(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFChartSheet(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  66 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void read(InputStream paramInputStream) throws IOException {
/*  71 */     super.read(new ByteArrayInputStream(BLANK_WORKSHEET));
/*     */     
/*     */     try {
/*  74 */       this.chartsheet = ChartsheetDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartsheet();
/*  75 */     } catch (XmlException xmlException) {
/*  76 */       throw new POIXMLException(xmlException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CTChartsheet getCTChartsheet() {
/*  86 */     return this.chartsheet;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTDrawing getCTDrawing() {
/*  91 */     return this.chartsheet.getDrawing();
/*     */   }
/*     */ 
/*     */   
/*     */   protected CTLegacyDrawing getCTLegacyDrawing() {
/*  96 */     return this.chartsheet.getLegacyDrawing();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void write(OutputStream paramOutputStream) throws IOException {
/* 101 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 102 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTChartsheet.type.getName().getNamespaceURI(), "chartsheet"));
/*     */     
/* 104 */     this.chartsheet.save(paramOutputStream, xmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] blankWorksheet() {
/* 109 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     try {
/* 111 */       (new XSSFSheet()).write(byteArrayOutputStream);
/* 112 */     } catch (IOException iOException) {
/* 113 */       throw new RuntimeException(iOException);
/*     */     } 
/* 115 */     return byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFChartSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */