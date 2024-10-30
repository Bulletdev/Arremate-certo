/*     */ package org.apache.poi.xslf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
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
/*     */ public final class XSLFChart
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTChartSpace chartSpace;
/*     */   private CTChart chart;
/*     */   
/*     */   protected XSLFChart(PackagePart paramPackagePart) throws IOException, XmlException {
/*  67 */     super(paramPackagePart);
/*     */     
/*  69 */     this.chartSpace = ChartSpaceDocument.Factory.parse(paramPackagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
/*  70 */     this.chart = this.chartSpace.getChart();
/*     */   }
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
/*     */   @Deprecated
/*     */   protected XSLFChart(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/*  85 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTChartSpace getCTChartSpace() {
/*  95 */     return this.chartSpace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTChart getCTChart() {
/* 105 */     return this.chart;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 110 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 111 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
/*     */     
/* 113 */     PackagePart packagePart = getPackagePart();
/* 114 */     OutputStream outputStream = packagePart.getOutputStream();
/* 115 */     this.chartSpace.save(outputStream, xmlOptions);
/* 116 */     outputStream.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */