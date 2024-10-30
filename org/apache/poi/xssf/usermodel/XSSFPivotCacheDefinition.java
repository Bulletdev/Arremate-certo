/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Date;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheField;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;
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
/*     */ public class XSSFPivotCacheDefinition
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   private CTPivotCacheDefinition ctPivotCacheDefinition;
/*     */   
/*     */   public XSSFPivotCacheDefinition() {
/*  52 */     this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.newInstance();
/*  53 */     createDefaultValues();
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
/*     */   protected XSSFPivotCacheDefinition(PackagePart paramPackagePart) throws IOException {
/*  66 */     super(paramPackagePart);
/*  67 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFPivotCacheDefinition(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  75 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  81 */       XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */       
/*  83 */       xmlOptions.setLoadReplaceDocumentElement(null);
/*  84 */       this.ctPivotCacheDefinition = CTPivotCacheDefinition.Factory.parse(paramInputStream, xmlOptions);
/*  85 */     } catch (XmlException xmlException) {
/*  86 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTPivotCacheDefinition getCTPivotCacheDefinition() {
/*  93 */     return this.ctPivotCacheDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   private void createDefaultValues() {
/*  98 */     this.ctPivotCacheDefinition.setCreatedVersion((short)3);
/*  99 */     this.ctPivotCacheDefinition.setMinRefreshableVersion((short)3);
/* 100 */     this.ctPivotCacheDefinition.setRefreshedVersion((short)3);
/* 101 */     this.ctPivotCacheDefinition.setRefreshedBy("Apache POI");
/* 102 */     this.ctPivotCacheDefinition.setRefreshedDate((new Date()).getTime());
/* 103 */     this.ctPivotCacheDefinition.setRefreshOnLoad(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 109 */     PackagePart packagePart = getPackagePart();
/* 110 */     OutputStream outputStream = packagePart.getOutputStream();
/* 111 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/* 113 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTPivotCacheDefinition.type.getName().getNamespaceURI(), "pivotCacheDefinition"));
/*     */     
/* 115 */     this.ctPivotCacheDefinition.save(outputStream, xmlOptions);
/* 116 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createCacheFields(Sheet paramSheet) {
/*     */     CTCacheFields cTCacheFields;
/* 126 */     AreaReference areaReference = new AreaReference(this.ctPivotCacheDefinition.getCacheSource().getWorksheetSource().getRef());
/* 127 */     CellReference cellReference1 = areaReference.getFirstCell();
/* 128 */     CellReference cellReference2 = areaReference.getLastCell();
/* 129 */     short s1 = cellReference1.getCol();
/* 130 */     short s2 = cellReference2.getCol();
/* 131 */     Row row = paramSheet.getRow(cellReference1.getRow());
/*     */     
/* 133 */     if (this.ctPivotCacheDefinition.getCacheFields() != null) {
/* 134 */       cTCacheFields = this.ctPivotCacheDefinition.getCacheFields();
/*     */     } else {
/* 136 */       cTCacheFields = this.ctPivotCacheDefinition.addNewCacheFields();
/*     */     } 
/*     */     
/* 139 */     for (short s = s1; s <= s2; s++) {
/* 140 */       CTCacheField cTCacheField = cTCacheFields.addNewCacheField();
/* 141 */       if (s == s2) {
/* 142 */         cTCacheFields.setCount(cTCacheFields.sizeOfCacheFieldArray());
/*     */       }
/*     */       
/* 145 */       cTCacheField.setNumFmtId(0L);
/* 146 */       Cell cell = row.getCell(s);
/* 147 */       cell.setCellType(CellType.STRING);
/* 148 */       cTCacheField.setName(row.getCell(s).getStringCellValue());
/* 149 */       cTCacheField.addNewSharedItems();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPivotCacheDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */