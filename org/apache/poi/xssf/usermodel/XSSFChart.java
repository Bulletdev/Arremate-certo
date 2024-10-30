/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Chart;
/*     */ import org.apache.poi.ss.usermodel.charts.AxisPosition;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxis;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartAxisFactory;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartData;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartDataFactory;
/*     */ import org.apache.poi.ss.usermodel.charts.ChartLegend;
/*     */ import org.apache.poi.ss.usermodel.charts.ManualLayout;
/*     */ import org.apache.poi.ss.usermodel.charts.ValueAxis;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFCategoryAxis;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFChartAxis;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFChartDataFactory;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFManualLayout;
/*     */ import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.chart.ChartSpaceDocument;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTRegularTextRun;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextField;
/*     */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
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
/*     */ public final class XSSFChart
/*     */   extends POIXMLDocumentPart
/*     */   implements Chart, ChartAxisFactory
/*     */ {
/*     */   private XSSFGraphicFrame frame;
/*     */   private CTChartSpace chartSpace;
/*     */   private CTChart chart;
/*  84 */   List<XSSFChartAxis> axis = new ArrayList<XSSFChartAxis>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFChart() {
/*  91 */     createChart();
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
/*     */   protected XSSFChart(PackagePart paramPackagePart) throws IOException, XmlException {
/* 103 */     super(paramPackagePart);
/*     */     
/* 105 */     this.chartSpace = ChartSpaceDocument.Factory.parse(paramPackagePart.getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getChartSpace();
/* 106 */     this.chart = this.chartSpace.getChart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFChart(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException, XmlException {
/* 114 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createChart() {
/* 125 */     this.chartSpace = CTChartSpace.Factory.newInstance();
/* 126 */     this.chart = this.chartSpace.addNewChart();
/* 127 */     CTPlotArea cTPlotArea = this.chart.addNewPlotArea();
/*     */     
/* 129 */     cTPlotArea.addNewLayout();
/* 130 */     this.chart.addNewPlotVisOnly().setVal(true);
/*     */     
/* 132 */     CTPrintSettings cTPrintSettings = this.chartSpace.addNewPrintSettings();
/* 133 */     cTPrintSettings.addNewHeaderFooter();
/*     */     
/* 135 */     CTPageMargins cTPageMargins = cTPrintSettings.addNewPageMargins();
/* 136 */     cTPageMargins.setB(0.75D);
/* 137 */     cTPageMargins.setL(0.7D);
/* 138 */     cTPageMargins.setR(0.7D);
/* 139 */     cTPageMargins.setT(0.75D);
/* 140 */     cTPageMargins.setHeader(0.3D);
/* 141 */     cTPageMargins.setFooter(0.3D);
/* 142 */     cTPrintSettings.addNewPageSetup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTChartSpace getCTChartSpace() {
/* 152 */     return this.chartSpace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTChart getCTChart() {
/* 162 */     return this.chart;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 167 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 176 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
/*     */     
/* 178 */     PackagePart packagePart = getPackagePart();
/* 179 */     OutputStream outputStream = packagePart.getOutputStream();
/* 180 */     this.chartSpace.save(outputStream, xmlOptions);
/* 181 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFGraphicFrame getGraphicFrame() {
/* 189 */     return this.frame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setGraphicFrame(XSSFGraphicFrame paramXSSFGraphicFrame) {
/* 196 */     this.frame = paramXSSFGraphicFrame;
/*     */   }
/*     */   
/*     */   public XSSFChartDataFactory getChartDataFactory() {
/* 200 */     return XSSFChartDataFactory.getInstance();
/*     */   }
/*     */   
/*     */   public XSSFChart getChartAxisFactory() {
/* 204 */     return this;
/*     */   }
/*     */   
/*     */   public void plot(ChartData paramChartData, ChartAxis... paramVarArgs) {
/* 208 */     paramChartData.fillChart(this, paramVarArgs);
/*     */   }
/*     */   
/*     */   public XSSFValueAxis createValueAxis(AxisPosition paramAxisPosition) {
/* 212 */     long l = (this.axis.size() + 1);
/* 213 */     XSSFValueAxis xSSFValueAxis = new XSSFValueAxis(this, l, paramAxisPosition);
/* 214 */     if (this.axis.size() == 1) {
/* 215 */       ChartAxis chartAxis = (ChartAxis)this.axis.get(0);
/* 216 */       chartAxis.crossAxis((ChartAxis)xSSFValueAxis);
/* 217 */       xSSFValueAxis.crossAxis(chartAxis);
/*     */     } 
/* 219 */     this.axis.add(xSSFValueAxis);
/* 220 */     return xSSFValueAxis;
/*     */   }
/*     */   
/*     */   public XSSFCategoryAxis createCategoryAxis(AxisPosition paramAxisPosition) {
/* 224 */     long l = (this.axis.size() + 1);
/* 225 */     XSSFCategoryAxis xSSFCategoryAxis = new XSSFCategoryAxis(this, l, paramAxisPosition);
/* 226 */     if (this.axis.size() == 1) {
/* 227 */       ChartAxis chartAxis = (ChartAxis)this.axis.get(0);
/* 228 */       chartAxis.crossAxis((ChartAxis)xSSFCategoryAxis);
/* 229 */       xSSFCategoryAxis.crossAxis(chartAxis);
/*     */     } 
/* 231 */     this.axis.add(xSSFCategoryAxis);
/* 232 */     return xSSFCategoryAxis;
/*     */   }
/*     */   
/*     */   public List<? extends XSSFChartAxis> getAxis() {
/* 236 */     if (this.axis.isEmpty() && hasAxis()) {
/* 237 */       parseAxis();
/*     */     }
/* 239 */     return this.axis;
/*     */   }
/*     */   
/*     */   public XSSFManualLayout getManualLayout() {
/* 243 */     return new XSSFManualLayout(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPlotOnlyVisibleCells() {
/* 251 */     return this.chart.getPlotVisOnly().getVal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlotOnlyVisibleCells(boolean paramBoolean) {
/* 259 */     this.chart.getPlotVisOnly().setVal(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFRichTextString getTitle() {
/* 266 */     if (!this.chart.isSetTitle()) {
/* 267 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 271 */     CTTitle cTTitle = this.chart.getTitle();
/*     */     
/* 273 */     StringBuffer stringBuffer = new StringBuffer();
/* 274 */     XmlObject[] arrayOfXmlObject = cTTitle.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t");
/*     */     
/* 276 */     for (byte b = 0; b < arrayOfXmlObject.length; b++) {
/* 277 */       NodeList nodeList = arrayOfXmlObject[b].getDomNode().getChildNodes();
/* 278 */       int i = nodeList.getLength();
/* 279 */       for (byte b1 = 0; b1 < i; b1++) {
/* 280 */         Node node = nodeList.item(b1);
/* 281 */         if (node instanceof org.w3c.dom.Text) {
/* 282 */           stringBuffer.append(node.getNodeValue());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 287 */     return new XSSFRichTextString(stringBuffer.toString());
/*     */   }
/*     */   
/*     */   public void setTitle(String paramString) {
/*     */     CTTitle cTTitle;
/*     */     CTTx cTTx;
/*     */     CTTextBody cTTextBody;
/*     */     CTTextParagraph cTTextParagraph;
/* 295 */     if (this.chart.isSetTitle()) {
/* 296 */       cTTitle = this.chart.getTitle();
/*     */     } else {
/* 298 */       cTTitle = this.chart.addNewTitle();
/*     */     } 
/*     */ 
/*     */     
/* 302 */     if (cTTitle.isSetTx()) {
/* 303 */       cTTx = cTTitle.getTx();
/*     */     } else {
/* 305 */       cTTx = cTTitle.addNewTx();
/*     */     } 
/*     */     
/* 308 */     if (cTTx.isSetStrRef()) {
/* 309 */       cTTx.unsetStrRef();
/*     */     }
/*     */ 
/*     */     
/* 313 */     if (cTTx.isSetRich()) {
/* 314 */       cTTextBody = cTTx.getRich();
/*     */     } else {
/* 316 */       cTTextBody = cTTx.addNewRich();
/* 317 */       cTTextBody.addNewBodyPr();
/*     */     } 
/*     */ 
/*     */     
/* 321 */     if (cTTextBody.sizeOfPArray() > 0) {
/* 322 */       cTTextParagraph = cTTextBody.getPArray(0);
/*     */     } else {
/* 324 */       cTTextParagraph = cTTextBody.addNewP();
/*     */     } 
/*     */     
/* 327 */     if (cTTextParagraph.sizeOfRArray() > 0) {
/* 328 */       CTRegularTextRun cTRegularTextRun = cTTextParagraph.getRArray(0);
/* 329 */       cTRegularTextRun.setT(paramString);
/* 330 */     } else if (cTTextParagraph.sizeOfFldArray() > 0) {
/* 331 */       CTTextField cTTextField = cTTextParagraph.getFldArray(0);
/* 332 */       cTTextField.setT(paramString);
/*     */     } else {
/* 334 */       CTRegularTextRun cTRegularTextRun = cTTextParagraph.addNewR();
/* 335 */       cTRegularTextRun.setT(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public XSSFChartLegend getOrCreateLegend() {
/* 340 */     return new XSSFChartLegend(this);
/*     */   }
/*     */   
/*     */   public void deleteLegend() {
/* 344 */     if (this.chart.isSetLegend()) {
/* 345 */       this.chart.unsetLegend();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean hasAxis() {
/* 350 */     CTPlotArea cTPlotArea = this.chart.getPlotArea();
/* 351 */     int i = cTPlotArea.sizeOfValAxArray() + cTPlotArea.sizeOfCatAxArray() + cTPlotArea.sizeOfDateAxArray() + cTPlotArea.sizeOfSerAxArray();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 356 */     return (i > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseAxis() {
/* 361 */     parseCategoryAxis();
/* 362 */     parseValueAxis();
/*     */   }
/*     */   
/*     */   private void parseCategoryAxis() {
/* 366 */     for (CTCatAx cTCatAx : this.chart.getPlotArea().getCatAxArray()) {
/* 367 */       this.axis.add(new XSSFCategoryAxis(this, cTCatAx));
/*     */     }
/*     */   }
/*     */   
/*     */   private void parseValueAxis() {
/* 372 */     for (CTValAx cTValAx : this.chart.getPlotArea().getValAxArray())
/* 373 */       this.axis.add(new XSSFValueAxis(this, cTValAx)); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */