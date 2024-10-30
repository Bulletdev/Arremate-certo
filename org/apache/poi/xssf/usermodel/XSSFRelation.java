/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLRelation;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xssf.model.CalculationChain;
/*     */ import org.apache.poi.xssf.model.CommentsTable;
/*     */ import org.apache.poi.xssf.model.ExternalLinksTable;
/*     */ import org.apache.poi.xssf.model.MapInfo;
/*     */ import org.apache.poi.xssf.model.SharedStringsTable;
/*     */ import org.apache.poi.xssf.model.SingleXmlCells;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.model.ThemesTable;
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
/*     */ public final class XSSFRelation
/*     */   extends POIXMLRelation
/*     */ {
/*  52 */   private static final POILogger log = POILogFactory.getLogger(XSSFRelation.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final Map<String, XSSFRelation> _table = new HashMap<String, XSSFRelation>();
/*     */ 
/*     */   
/*  60 */   public static final XSSFRelation WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/workbook", "/xl/workbook.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final XSSFRelation MACROS_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final XSSFRelation TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.template.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  79 */   public static final XSSFRelation MACRO_TEMPLATE_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.template.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  85 */   public static final XSSFRelation MACRO_ADDIN_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.addin.macroEnabled.main+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final XSSFRelation XLSB_BINARY_WORKBOOK = new XSSFRelation("application/vnd.ms-excel.sheet.binary.macroEnabled.main", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument", "/xl/workbook.bin", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   public static final XSSFRelation WORKSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet", "/xl/worksheets/sheet#.xml", (Class)XSSFSheet.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   public static final XSSFRelation CHARTSHEET = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.chartsheet+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chartsheet", "/xl/chartsheets/sheet#.xml", (Class)XSSFChartSheet.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 113 */   public static final XSSFRelation SHARED_STRINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.sharedStrings+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/sharedStrings", "/xl/sharedStrings.xml", (Class)SharedStringsTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 120 */   public static final XSSFRelation STYLES = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles", "/xl/styles.xml", (Class)StylesTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   public static final XSSFRelation DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawing+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/drawing", "/xl/drawings/drawing#.xml", (Class)XSSFDrawing.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   public static final XSSFRelation VML_DRAWINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.vmlDrawing", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/vmlDrawing", "/xl/drawings/vmlDrawing#.vml", (Class)XSSFVMLDrawing.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   public static final XSSFRelation CHART = new XSSFRelation("application/vnd.openxmlformats-officedocument.drawingml.chart+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/chart", "/xl/charts/chart#.xml", (Class)XSSFChart.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 148 */   public static final XSSFRelation CUSTOM_XML_MAPPINGS = new XSSFRelation("application/xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/xmlMaps", "/xl/xmlMaps.xml", (Class)MapInfo.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 155 */   public static final XSSFRelation SINGLE_XML_CELLS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.tableSingleCells+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/tableSingleCells", "/xl/tables/tableSingleCells#.xml", (Class)SingleXmlCells.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   public static final XSSFRelation TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.table+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/table", "/xl/tables/table#.xml", (Class)XSSFTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 169 */   public static final XSSFRelation IMAGES = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", null, (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 176 */   public static final XSSFRelation IMAGE_EMF = new XSSFRelation("image/x-emf", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.emf", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 183 */   public static final XSSFRelation IMAGE_WMF = new XSSFRelation("image/x-wmf", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wmf", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 190 */   public static final XSSFRelation IMAGE_PICT = new XSSFRelation("image/pict", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.pict", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 197 */   public static final XSSFRelation IMAGE_JPEG = new XSSFRelation("image/jpeg", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.jpeg", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 204 */   public static final XSSFRelation IMAGE_PNG = new XSSFRelation("image/png", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.png", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 211 */   public static final XSSFRelation IMAGE_DIB = new XSSFRelation("image/dib", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.dib", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 218 */   public static final XSSFRelation IMAGE_GIF = new XSSFRelation("image/gif", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.gif", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 225 */   public static final XSSFRelation IMAGE_TIFF = new XSSFRelation("image/tiff", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.tiff", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 232 */   public static final XSSFRelation IMAGE_EPS = new XSSFRelation("image/x-eps", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.eps", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 239 */   public static final XSSFRelation IMAGE_BMP = new XSSFRelation("image/x-ms-bmp", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.bmp", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 246 */   public static final XSSFRelation IMAGE_WPG = new XSSFRelation("image/x-wpg", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image", "/xl/media/image#.wpg", (Class)XSSFPictureData.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 253 */   public static final XSSFRelation SHEET_COMMENTS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.comments+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments", "/xl/comments#.xml", (Class)CommentsTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 260 */   public static final XSSFRelation SHEET_HYPERLINKS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 267 */   public static final XSSFRelation OLEEMBEDDINGS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/oleObject", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 274 */   public static final XSSFRelation PACKEMBEDDINGS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/package", null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 281 */   public static final XSSFRelation VBA_MACROS = new XSSFRelation("application/vnd.ms-office.vbaProject", "http://schemas.microsoft.com/office/2006/relationships/vbaProject", "/xl/vbaProject.bin", (Class)XSSFVBAPart.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 288 */   public static final XSSFRelation ACTIVEX_CONTROLS = new XSSFRelation("application/vnd.ms-office.activeX+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/control", "/xl/activeX/activeX#.xml", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 295 */   public static final XSSFRelation ACTIVEX_BINS = new XSSFRelation("application/vnd.ms-office.activeX", "http://schemas.microsoft.com/office/2006/relationships/activeXControlBinary", "/xl/activeX/activeX#.bin", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 302 */   public static final XSSFRelation THEME = new XSSFRelation("application/vnd.openxmlformats-officedocument.theme+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/theme", "/xl/theme/theme#.xml", (Class)ThemesTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 309 */   public static final XSSFRelation CALC_CHAIN = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.calcChain+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/calcChain", "/xl/calcChain.xml", (Class)CalculationChain.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 316 */   public static final XSSFRelation EXTERNAL_LINKS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.externalLink+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/externalLink", "/xl/externalLinks/externalLink#.xmll", (Class)ExternalLinksTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 323 */   public static final XSSFRelation PRINTER_SETTINGS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.printerSettings", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/printerSettings", "/xl/printerSettings/printerSettings#.bin", null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 329 */   public static final XSSFRelation PIVOT_TABLE = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotTable+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotTable", "/xl/pivotTables/pivotTable#.xml", (Class)XSSFPivotTable.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 335 */   public static final XSSFRelation PIVOT_CACHE_DEFINITION = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheDefinition+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheDefinition", "/xl/pivotCache/pivotCacheDefinition#.xml", (Class)XSSFPivotCacheDefinition.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 341 */   public static final XSSFRelation PIVOT_CACHE_RECORDS = new XSSFRelation("application/vnd.openxmlformats-officedocument.spreadsheetml.pivotCacheRecords+xml", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/pivotCacheRecords", "/xl/pivotCache/pivotCacheRecords#.xml", (Class)XSSFPivotCacheRecords.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 348 */   public static final XSSFRelation CTRL_PROP_RECORDS = new XSSFRelation(null, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/ctrlProp", "/xl/ctrlProps/ctrlProp#.xml", null);
/*     */ 
/*     */   
/*     */   public static final String NS_SPREADSHEETML = "http://schemas.openxmlformats.org/spreadsheetml/2006/main";
/*     */ 
/*     */   
/*     */   public static final String NS_DRAWINGML = "http://schemas.openxmlformats.org/drawingml/2006/main";
/*     */   
/*     */   public static final String NS_CHART = "http://schemas.openxmlformats.org/drawingml/2006/chart";
/*     */ 
/*     */   
/*     */   private XSSFRelation(String paramString1, String paramString2, String paramString3, Class<? extends POIXMLDocumentPart> paramClass) {
/* 360 */     super(paramString1, paramString2, paramString3, paramClass);
/* 361 */     _table.put(paramString2, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getContents(PackagePart paramPackagePart) throws IOException, InvalidFormatException {
/* 370 */     PackageRelationshipCollection packageRelationshipCollection = paramPackagePart.getRelationshipsByType(this._relation);
/*     */     
/* 372 */     Iterator<PackageRelationship> iterator = packageRelationshipCollection.iterator();
/* 373 */     if (iterator.hasNext()) {
/* 374 */       PackageRelationship packageRelationship = iterator.next();
/* 375 */       PackagePartName packagePartName = PackagingURIHelper.createPartName(packageRelationship.getTargetURI());
/* 376 */       PackagePart packagePart = paramPackagePart.getPackage().getPart(packagePartName);
/* 377 */       return packagePart.getInputStream();
/*     */     } 
/* 379 */     log.log(5, new Object[] { "No part " + this._defaultName + " found" });
/* 380 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XSSFRelation getInstance(String paramString) {
/* 391 */     return _table.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */