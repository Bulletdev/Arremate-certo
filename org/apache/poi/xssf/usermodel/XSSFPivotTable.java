/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.poi.POIXMLDocumentPart;
/*     */ import org.apache.poi.POIXMLTypeLoader;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.ss.usermodel.DataConsolidateFunction;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCacheSource;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataField;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTField;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTItems;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLocation;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageField;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCacheDefinition;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotField;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableDefinition;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotTableStyle;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRowFields;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheetSource;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataConsolidateFunction;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFPivotTable
/*     */   extends POIXMLDocumentPart
/*     */ {
/*     */   protected static final short CREATED_VERSION = 3;
/*     */   protected static final short MIN_REFRESHABLE_VERSION = 3;
/*     */   protected static final short UPDATED_VERSION = 3;
/*     */   private CTPivotTableDefinition pivotTableDefinition;
/*     */   private XSSFPivotCacheDefinition pivotCacheDefinition;
/*     */   private XSSFPivotCache pivotCache;
/*     */   private XSSFPivotCacheRecords pivotCacheRecords;
/*     */   private Sheet parentSheet;
/*     */   private Sheet dataSheet;
/*     */   
/*     */   protected XSSFPivotTable() {
/*  62 */     this.pivotTableDefinition = CTPivotTableDefinition.Factory.newInstance();
/*  63 */     this.pivotCache = new XSSFPivotCache();
/*  64 */     this.pivotCacheDefinition = new XSSFPivotCacheDefinition();
/*  65 */     this.pivotCacheRecords = new XSSFPivotCacheRecords();
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
/*     */   protected XSSFPivotTable(PackagePart paramPackagePart) throws IOException {
/*  78 */     super(paramPackagePart);
/*  79 */     readFrom(paramPackagePart.getInputStream());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected XSSFPivotTable(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) throws IOException {
/*  87 */     this(paramPackagePart);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFrom(InputStream paramInputStream) throws IOException {
/*     */     try {
/*  93 */       XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */       
/*  95 */       xmlOptions.setLoadReplaceDocumentElement(null);
/*  96 */       this.pivotTableDefinition = CTPivotTableDefinition.Factory.parse(paramInputStream, xmlOptions);
/*  97 */     } catch (XmlException xmlException) {
/*  98 */       throw new IOException(xmlException.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPivotCache(XSSFPivotCache paramXSSFPivotCache) {
/* 104 */     this.pivotCache = paramXSSFPivotCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFPivotCache getPivotCache() {
/* 109 */     return this.pivotCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public Sheet getParentSheet() {
/* 114 */     return this.parentSheet;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParentSheet(XSSFSheet paramXSSFSheet) {
/* 119 */     this.parentSheet = paramXSSFSheet;
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTPivotTableDefinition getCTPivotTableDefinition() {
/* 125 */     return this.pivotTableDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public void setCTPivotTableDefinition(CTPivotTableDefinition paramCTPivotTableDefinition) {
/* 131 */     this.pivotTableDefinition = paramCTPivotTableDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFPivotCacheDefinition getPivotCacheDefinition() {
/* 136 */     return this.pivotCacheDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPivotCacheDefinition(XSSFPivotCacheDefinition paramXSSFPivotCacheDefinition) {
/* 141 */     this.pivotCacheDefinition = paramXSSFPivotCacheDefinition;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFPivotCacheRecords getPivotCacheRecords() {
/* 146 */     return this.pivotCacheRecords;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPivotCacheRecords(XSSFPivotCacheRecords paramXSSFPivotCacheRecords) {
/* 151 */     this.pivotCacheRecords = paramXSSFPivotCacheRecords;
/*     */   }
/*     */ 
/*     */   
/*     */   public Sheet getDataSheet() {
/* 156 */     return this.dataSheet;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setDataSheet(Sheet paramSheet) {
/* 161 */     this.dataSheet = paramSheet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void commit() throws IOException {
/* 167 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*     */     
/* 169 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTPivotTableDefinition.type.getName().getNamespaceURI(), "pivotTableDefinition"));
/*     */     
/* 171 */     PackagePart packagePart = getPackagePart();
/* 172 */     OutputStream outputStream = packagePart.getOutputStream();
/* 173 */     this.pivotTableDefinition.save(outputStream, xmlOptions);
/* 174 */     outputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setDefaultPivotTableDefinition() {
/* 183 */     this.pivotTableDefinition.setMultipleFieldFilters(false);
/*     */     
/* 185 */     this.pivotTableDefinition.setIndent(0L);
/*     */     
/* 187 */     this.pivotTableDefinition.setCreatedVersion((short)3);
/*     */     
/* 189 */     this.pivotTableDefinition.setMinRefreshableVersion((short)3);
/*     */     
/* 191 */     this.pivotTableDefinition.setUpdatedVersion((short)3);
/*     */     
/* 193 */     this.pivotTableDefinition.setItemPrintTitles(true);
/*     */     
/* 195 */     this.pivotTableDefinition.setUseAutoFormatting(true);
/* 196 */     this.pivotTableDefinition.setApplyNumberFormats(false);
/* 197 */     this.pivotTableDefinition.setApplyWidthHeightFormats(true);
/* 198 */     this.pivotTableDefinition.setApplyAlignmentFormats(false);
/* 199 */     this.pivotTableDefinition.setApplyPatternFormats(false);
/* 200 */     this.pivotTableDefinition.setApplyFontFormats(false);
/* 201 */     this.pivotTableDefinition.setApplyBorderFormats(false);
/* 202 */     this.pivotTableDefinition.setCacheId(this.pivotCache.getCTPivotCache().getCacheId());
/* 203 */     this.pivotTableDefinition.setName("PivotTable" + this.pivotTableDefinition.getCacheId());
/* 204 */     this.pivotTableDefinition.setDataCaption("Values");
/*     */ 
/*     */     
/* 207 */     CTPivotTableStyle cTPivotTableStyle = this.pivotTableDefinition.addNewPivotTableStyleInfo();
/* 208 */     cTPivotTableStyle.setName("PivotStyleLight16");
/* 209 */     cTPivotTableStyle.setShowLastColumn(true);
/* 210 */     cTPivotTableStyle.setShowColStripes(false);
/* 211 */     cTPivotTableStyle.setShowRowStripes(false);
/* 212 */     cTPivotTableStyle.setShowColHeaders(true);
/* 213 */     cTPivotTableStyle.setShowRowHeaders(true);
/*     */   }
/*     */   
/*     */   protected AreaReference getPivotArea() {
/* 217 */     return new AreaReference(getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheSource().getWorksheetSource().getRef(), SpreadsheetVersion.EXCEL2007);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkColumnIndex(int paramInt) throws IndexOutOfBoundsException {
/* 235 */     AreaReference areaReference = getPivotArea();
/* 236 */     int i = areaReference.getLastCell().getCol() - areaReference.getFirstCell().getCol() + 1;
/*     */     
/* 238 */     if (paramInt < 0 || paramInt >= i) {
/* 239 */       throw new IndexOutOfBoundsException("Column Index: " + paramInt + ", Size: " + i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRowLabel(int paramInt) {
/*     */     CTRowFields cTRowFields;
/* 250 */     checkColumnIndex(paramInt);
/*     */     
/* 252 */     AreaReference areaReference = getPivotArea();
/* 253 */     int i = areaReference.getLastCell().getRow() - areaReference.getFirstCell().getRow();
/* 254 */     CTPivotFields cTPivotFields = this.pivotTableDefinition.getPivotFields();
/*     */     
/* 256 */     CTPivotField cTPivotField = CTPivotField.Factory.newInstance();
/* 257 */     CTItems cTItems = cTPivotField.addNewItems();
/*     */     
/* 259 */     cTPivotField.setAxis(STAxis.AXIS_ROW);
/* 260 */     cTPivotField.setShowAll(false);
/* 261 */     for (byte b = 0; b <= i; b++) {
/* 262 */       cTItems.addNewItem().setT(STItemType.DEFAULT);
/*     */     }
/* 264 */     cTItems.setCount(cTItems.sizeOfItemArray());
/* 265 */     cTPivotFields.setPivotFieldArray(paramInt, cTPivotField);
/*     */ 
/*     */     
/* 268 */     if (this.pivotTableDefinition.getRowFields() != null) {
/* 269 */       cTRowFields = this.pivotTableDefinition.getRowFields();
/*     */     } else {
/* 271 */       cTRowFields = this.pivotTableDefinition.addNewRowFields();
/*     */     } 
/*     */     
/* 274 */     cTRowFields.addNewField().setX(paramInt);
/* 275 */     cTRowFields.setCount(cTRowFields.sizeOfFieldArray());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Integer> getRowLabelColumns() {
/* 280 */     if (this.pivotTableDefinition.getRowFields() != null) {
/* 281 */       ArrayList<Integer> arrayList = new ArrayList();
/* 282 */       for (CTField cTField : this.pivotTableDefinition.getRowFields().getFieldArray()) {
/* 283 */         arrayList.add(Integer.valueOf(cTField.getX()));
/*     */       }
/* 285 */       return arrayList;
/*     */     } 
/* 287 */     return Collections.emptyList();
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
/*     */   
/*     */   public void addColumnLabel(DataConsolidateFunction paramDataConsolidateFunction, int paramInt, String paramString) {
/* 302 */     checkColumnIndex(paramInt);
/*     */     
/* 304 */     addDataColumn(paramInt, true);
/* 305 */     addDataField(paramDataConsolidateFunction, paramInt, paramString);
/*     */ 
/*     */     
/* 308 */     if (this.pivotTableDefinition.getDataFields().getCount() == 2L) {
/*     */       CTColFields cTColFields;
/* 310 */       if (this.pivotTableDefinition.getColFields() != null) {
/* 311 */         cTColFields = this.pivotTableDefinition.getColFields();
/*     */       } else {
/* 313 */         cTColFields = this.pivotTableDefinition.addNewColFields();
/*     */       } 
/* 315 */       cTColFields.addNewField().setX(-2);
/* 316 */       cTColFields.setCount(cTColFields.sizeOfFieldArray());
/*     */     } 
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
/*     */   public void addColumnLabel(DataConsolidateFunction paramDataConsolidateFunction, int paramInt) {
/* 330 */     addColumnLabel(paramDataConsolidateFunction, paramInt, paramDataConsolidateFunction.getName());
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
/*     */   private void addDataField(DataConsolidateFunction paramDataConsolidateFunction, int paramInt, String paramString) {
/*     */     CTDataFields cTDataFields;
/* 343 */     checkColumnIndex(paramInt);
/*     */     
/* 345 */     AreaReference areaReference = getPivotArea();
/*     */ 
/*     */     
/* 348 */     if (this.pivotTableDefinition.getDataFields() != null) {
/* 349 */       cTDataFields = this.pivotTableDefinition.getDataFields();
/*     */     } else {
/* 351 */       cTDataFields = this.pivotTableDefinition.addNewDataFields();
/*     */     } 
/* 353 */     CTDataField cTDataField = cTDataFields.addNewDataField();
/* 354 */     cTDataField.setSubtotal(STDataConsolidateFunction.Enum.forInt(paramDataConsolidateFunction.getValue()));
/* 355 */     Cell cell = getDataSheet().getRow(areaReference.getFirstCell().getRow()).getCell(areaReference.getFirstCell().getCol() + paramInt);
/*     */     
/* 357 */     cell.setCellType(CellType.STRING);
/* 358 */     cTDataField.setName(paramString);
/* 359 */     cTDataField.setFld(paramInt);
/* 360 */     cTDataFields.setCount(cTDataFields.sizeOfDataFieldArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addDataColumn(int paramInt, boolean paramBoolean) {
/* 370 */     checkColumnIndex(paramInt);
/*     */     
/* 372 */     CTPivotFields cTPivotFields = this.pivotTableDefinition.getPivotFields();
/* 373 */     CTPivotField cTPivotField = CTPivotField.Factory.newInstance();
/*     */     
/* 375 */     cTPivotField.setDataField(paramBoolean);
/* 376 */     cTPivotField.setShowAll(false);
/* 377 */     cTPivotFields.setPivotFieldArray(paramInt, cTPivotField);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addReportFilter(int paramInt) {
/*     */     CTPageFields cTPageFields;
/* 386 */     checkColumnIndex(paramInt);
/*     */     
/* 388 */     AreaReference areaReference = getPivotArea();
/* 389 */     int i = areaReference.getLastCell().getRow() - areaReference.getFirstCell().getRow();
/*     */     
/* 391 */     CTPivotFields cTPivotFields = this.pivotTableDefinition.getPivotFields();
/*     */     
/* 393 */     CTPivotField cTPivotField = CTPivotField.Factory.newInstance();
/* 394 */     CTItems cTItems = cTPivotField.addNewItems();
/*     */     
/* 396 */     cTPivotField.setAxis(STAxis.AXIS_PAGE);
/* 397 */     cTPivotField.setShowAll(false);
/* 398 */     for (byte b = 0; b <= i; b++) {
/* 399 */       cTItems.addNewItem().setT(STItemType.DEFAULT);
/*     */     }
/* 401 */     cTItems.setCount(cTItems.sizeOfItemArray());
/* 402 */     cTPivotFields.setPivotFieldArray(paramInt, cTPivotField);
/*     */ 
/*     */     
/* 405 */     if (this.pivotTableDefinition.getPageFields() != null) {
/* 406 */       cTPageFields = this.pivotTableDefinition.getPageFields();
/*     */       
/* 408 */       this.pivotTableDefinition.setMultipleFieldFilters(true);
/*     */     } else {
/* 410 */       cTPageFields = this.pivotTableDefinition.addNewPageFields();
/*     */     } 
/* 412 */     CTPageField cTPageField = cTPageFields.addNewPageField();
/* 413 */     cTPageField.setHier(-1);
/* 414 */     cTPageField.setFld(paramInt);
/*     */     
/* 416 */     cTPageFields.setCount(cTPageFields.sizeOfPageFieldArray());
/* 417 */     this.pivotTableDefinition.getLocation().setColPageCount(cTPageFields.getCount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void createSourceReferences(AreaReference paramAreaReference, CellReference paramCellReference, Sheet paramSheet) {
/*     */     CTLocation cTLocation;
/* 429 */     AreaReference areaReference = new AreaReference(paramCellReference, new CellReference(paramCellReference.getRow() + 1, paramCellReference.getCol() + 1));
/*     */ 
/*     */     
/* 432 */     if (this.pivotTableDefinition.getLocation() == null) {
/* 433 */       cTLocation = this.pivotTableDefinition.addNewLocation();
/* 434 */       cTLocation.setFirstDataCol(1L);
/* 435 */       cTLocation.setFirstDataRow(1L);
/* 436 */       cTLocation.setFirstHeaderRow(1L);
/*     */     } else {
/* 438 */       cTLocation = this.pivotTableDefinition.getLocation();
/*     */     } 
/* 440 */     cTLocation.setRef(areaReference.formatAsString());
/* 441 */     this.pivotTableDefinition.setLocation(cTLocation);
/*     */ 
/*     */     
/* 444 */     CTPivotCacheDefinition cTPivotCacheDefinition = getPivotCacheDefinition().getCTPivotCacheDefinition();
/* 445 */     CTCacheSource cTCacheSource = cTPivotCacheDefinition.addNewCacheSource();
/* 446 */     cTCacheSource.setType(STSourceType.WORKSHEET);
/* 447 */     CTWorksheetSource cTWorksheetSource = cTCacheSource.addNewWorksheetSource();
/* 448 */     cTWorksheetSource.setSheet(paramSheet.getSheetName());
/* 449 */     setDataSheet(paramSheet);
/*     */     
/* 451 */     String[] arrayOfString1 = paramAreaReference.getFirstCell().getCellRefParts();
/* 452 */     String[] arrayOfString2 = paramAreaReference.getLastCell().getCellRefParts();
/* 453 */     cTWorksheetSource.setRef(arrayOfString1[2] + arrayOfString1[1] + ':' + arrayOfString2[2] + arrayOfString2[1]);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void createDefaultDataColumns() {
/*     */     CTPivotFields cTPivotFields;
/* 459 */     if (this.pivotTableDefinition.getPivotFields() != null) {
/* 460 */       cTPivotFields = this.pivotTableDefinition.getPivotFields();
/*     */     } else {
/* 462 */       cTPivotFields = this.pivotTableDefinition.addNewPivotFields();
/*     */     } 
/* 464 */     AreaReference areaReference = getPivotArea();
/* 465 */     short s1 = areaReference.getFirstCell().getCol();
/* 466 */     short s2 = areaReference.getLastCell().getCol();
/*     */     
/* 468 */     for (byte b = 0; b <= s2 - s1; b++) {
/* 469 */       CTPivotField cTPivotField = cTPivotFields.addNewPivotField();
/* 470 */       cTPivotField.setDataField(false);
/* 471 */       cTPivotField.setShowAll(false);
/*     */     } 
/* 473 */     cTPivotFields.setCount(cTPivotFields.sizeOfPivotFieldArray());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPivotTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */