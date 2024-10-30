/*      */ package org.apache.poi.xssf.usermodel;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.regex.Pattern;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.commons.collections4.ListValuedMap;
/*      */ import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
/*      */ import org.apache.poi.POIXMLDocument;
/*      */ import org.apache.poi.POIXMLDocumentPart;
/*      */ import org.apache.poi.POIXMLException;
/*      */ import org.apache.poi.POIXMLProperties;
/*      */ import org.apache.poi.POIXMLTypeLoader;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*      */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*      */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*      */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*      */ import org.apache.poi.openxml4j.opc.PackagePart;
/*      */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*      */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*      */ import org.apache.poi.openxml4j.opc.PackagingURIHelper;
/*      */ import org.apache.poi.openxml4j.opc.TargetMode;
/*      */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*      */ import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
/*      */ import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
/*      */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.CreationHelper;
/*      */ import org.apache.poi.ss.usermodel.DataFormat;
/*      */ import org.apache.poi.ss.usermodel.Font;
/*      */ import org.apache.poi.ss.usermodel.Name;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.usermodel.Workbook;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.ss.util.WorkbookUtil;
/*      */ import org.apache.poi.util.IOUtils;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.NotImplemented;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ import org.apache.poi.util.PackageHelper;
/*      */ import org.apache.poi.xssf.XLSBUnsupportedException;
/*      */ import org.apache.poi.xssf.model.CalculationChain;
/*      */ import org.apache.poi.xssf.model.ExternalLinksTable;
/*      */ import org.apache.poi.xssf.model.MapInfo;
/*      */ import org.apache.poi.xssf.model.SharedStringsTable;
/*      */ import org.apache.poi.xssf.model.StylesTable;
/*      */ import org.apache.poi.xssf.model.ThemesTable;
/*      */ import org.apache.poi.xssf.usermodel.helpers.XSSFFormulaUtils;
/*      */ import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookView;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReference;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCache;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheet;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetState;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XSSFWorkbook
/*      */   extends POIXMLDocument
/*      */   implements Workbook
/*      */ {
/*  116 */   private static final Pattern COMMA_PATTERN = Pattern.compile(",");
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final float DEFAULT_CHARACTER_WIDTH = 7.0017F;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int PICTURE_TYPE_GIF = 8;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int PICTURE_TYPE_TIFF = 9;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int PICTURE_TYPE_EPS = 10;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int PICTURE_TYPE_BMP = 11;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int PICTURE_TYPE_WPG = 12;
/*      */ 
/*      */ 
/*      */   
/*      */   private CTWorkbook workbook;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<XSSFSheet> sheets;
/*      */ 
/*      */ 
/*      */   
/*      */   private ListValuedMap<String, XSSFName> namedRangesByName;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<XSSFName> namedRanges;
/*      */ 
/*      */ 
/*      */   
/*      */   private SharedStringsTable sharedStringSource;
/*      */ 
/*      */ 
/*      */   
/*      */   private StylesTable stylesSource;
/*      */ 
/*      */ 
/*      */   
/*  173 */   private IndexedUDFFinder _udfFinder = new IndexedUDFFinder(new UDFFinder[] { AggregatingUDFFinder.DEFAULT });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CalculationChain calcChain;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private List<ExternalLinksTable> externalLinks;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private MapInfo mapInfo;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XSSFDataFormat formatter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  203 */   private Row.MissingCellPolicy _missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<XSSFPictureData> pictures;
/*      */ 
/*      */   
/*  210 */   private static POILogger logger = POILogFactory.getLogger(XSSFWorkbook.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XSSFCreationHelper _creationHelper;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<XSSFPivotTable> pivotTables;
/*      */ 
/*      */ 
/*      */   
/*      */   private List<CTPivotCache> pivotCaches;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook() {
/*  229 */     this(XSSFWorkbookType.XLSX);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook(XSSFWorkbookType paramXSSFWorkbookType) {
/*  237 */     super(newPackage(paramXSSFWorkbookType));
/*  238 */     onWorkbookCreate();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook(OPCPackage paramOPCPackage) throws IOException {
/*  255 */     super(paramOPCPackage);
/*      */     
/*  257 */     beforeDocumentRead();
/*      */ 
/*      */     
/*  260 */     load(XSSFFactory.getInstance());
/*      */ 
/*      */     
/*  263 */     if (!this.workbook.isSetBookViews()) {
/*  264 */       CTBookViews cTBookViews = this.workbook.addNewBookViews();
/*  265 */       CTBookView cTBookView = cTBookViews.addNewWorkbookView();
/*  266 */       cTBookView.setActiveTab(0L);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook(InputStream paramInputStream) throws IOException {
/*  285 */     super(PackageHelper.open(paramInputStream));
/*      */     
/*  287 */     beforeDocumentRead();
/*      */ 
/*      */     
/*  290 */     load(XSSFFactory.getInstance());
/*      */ 
/*      */     
/*  293 */     if (!this.workbook.isSetBookViews()) {
/*  294 */       CTBookViews cTBookViews = this.workbook.addNewBookViews();
/*  295 */       CTBookView cTBookView = cTBookViews.addNewWorkbookView();
/*  296 */       cTBookView.setActiveTab(0L);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook(File paramFile) throws IOException, InvalidFormatException {
/*  313 */     this(OPCPackage.open(paramFile));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook(String paramString) throws IOException {
/*  330 */     this(openPackage(paramString));
/*      */   }
/*      */ 
/*      */   
/*      */   protected void beforeDocumentRead() {
/*  335 */     if (getCorePart().getContentType().equals(XSSFRelation.XLSB_BINARY_WORKBOOK.getContentType())) {
/*  336 */       throw new XLSBUnsupportedException();
/*      */     }
/*      */ 
/*      */     
/*  340 */     this.pivotTables = new ArrayList<XSSFPivotTable>();
/*  341 */     this.pivotCaches = new ArrayList<CTPivotCache>();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onDocumentRead() throws IOException {
/*      */     try {
/*  347 */       WorkbookDocument workbookDocument = WorkbookDocument.Factory.parse(getPackagePart().getInputStream(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/*  348 */       this.workbook = workbookDocument.getWorkbook();
/*      */       
/*  350 */       ThemesTable themesTable = null;
/*  351 */       HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/*  352 */       HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/*  353 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  354 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  355 */         if (pOIXMLDocumentPart instanceof SharedStringsTable) { this.sharedStringSource = (SharedStringsTable)pOIXMLDocumentPart; continue; }
/*  356 */          if (pOIXMLDocumentPart instanceof StylesTable) { this.stylesSource = (StylesTable)pOIXMLDocumentPart; continue; }
/*  357 */          if (pOIXMLDocumentPart instanceof ThemesTable) { themesTable = (ThemesTable)pOIXMLDocumentPart; continue; }
/*  358 */          if (pOIXMLDocumentPart instanceof CalculationChain) { this.calcChain = (CalculationChain)pOIXMLDocumentPart; continue; }
/*  359 */          if (pOIXMLDocumentPart instanceof MapInfo) { this.mapInfo = (MapInfo)pOIXMLDocumentPart; continue; }
/*  360 */          if (pOIXMLDocumentPart instanceof XSSFSheet) {
/*  361 */           hashMap1.put(relationPart.getRelationship().getId(), pOIXMLDocumentPart); continue;
/*      */         } 
/*  363 */         if (pOIXMLDocumentPart instanceof ExternalLinksTable) {
/*  364 */           hashMap2.put(relationPart.getRelationship().getId(), pOIXMLDocumentPart);
/*      */         }
/*      */       } 
/*  367 */       boolean bool = (getPackage().getPackageAccess() == PackageAccess.READ) ? true : false;
/*      */       
/*  369 */       if (this.stylesSource == null)
/*      */       {
/*  371 */         if (bool) {
/*  372 */           this.stylesSource = new StylesTable();
/*      */         } else {
/*  374 */           this.stylesSource = (StylesTable)createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
/*      */         } 
/*      */       }
/*  377 */       this.stylesSource.setWorkbook(this);
/*  378 */       this.stylesSource.setTheme(themesTable);
/*      */       
/*  380 */       if (this.sharedStringSource == null)
/*      */       {
/*  382 */         if (bool) {
/*  383 */           this.sharedStringSource = new SharedStringsTable();
/*      */         } else {
/*  385 */           this.sharedStringSource = (SharedStringsTable)createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  391 */       this.sheets = new ArrayList<XSSFSheet>(hashMap1.size());
/*  392 */       for (CTSheet cTSheet : this.workbook.getSheets().getSheetArray()) {
/*  393 */         parseSheet((Map)hashMap1, cTSheet);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  398 */       this.externalLinks = new ArrayList<ExternalLinksTable>(hashMap2.size());
/*  399 */       if (this.workbook.isSetExternalReferences()) {
/*  400 */         for (CTExternalReference cTExternalReference : this.workbook.getExternalReferences().getExternalReferenceArray()) {
/*  401 */           ExternalLinksTable externalLinksTable = (ExternalLinksTable)hashMap2.get(cTExternalReference.getId());
/*  402 */           if (externalLinksTable == null) {
/*  403 */             logger.log(5, new Object[] { "ExternalLinksTable with r:id " + cTExternalReference.getId() + " was defined, but didn't exist in package, skipping" });
/*      */           } else {
/*      */             
/*  406 */             this.externalLinks.add(externalLinksTable);
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  411 */       reprocessNamedRanges();
/*  412 */     } catch (XmlException xmlException) {
/*  413 */       throw new POIXMLException(xmlException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void parseSheet(Map<String, XSSFSheet> paramMap, CTSheet paramCTSheet) {
/*  422 */     XSSFSheet xSSFSheet = paramMap.get(paramCTSheet.getId());
/*  423 */     if (xSSFSheet == null) {
/*  424 */       logger.log(5, new Object[] { "Sheet with name " + paramCTSheet.getName() + " and r:id " + paramCTSheet.getId() + " was defined, but didn't exist in package, skipping" });
/*      */       return;
/*      */     } 
/*  427 */     xSSFSheet.sheet = paramCTSheet;
/*  428 */     xSSFSheet.onDocumentRead();
/*  429 */     this.sheets.add(xSSFSheet);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onWorkbookCreate() {
/*  436 */     this.workbook = CTWorkbook.Factory.newInstance();
/*      */ 
/*      */     
/*  439 */     CTWorkbookPr cTWorkbookPr = this.workbook.addNewWorkbookPr();
/*  440 */     cTWorkbookPr.setDate1904(false);
/*      */     
/*  442 */     CTBookViews cTBookViews = this.workbook.addNewBookViews();
/*  443 */     CTBookView cTBookView = cTBookViews.addNewWorkbookView();
/*  444 */     cTBookView.setActiveTab(0L);
/*  445 */     this.workbook.addNewSheets();
/*      */     
/*  447 */     POIXMLProperties.ExtendedProperties extendedProperties = getProperties().getExtendedProperties();
/*  448 */     extendedProperties.getUnderlyingProperties().setApplication("Apache POI");
/*      */     
/*  450 */     this.sharedStringSource = (SharedStringsTable)createRelationship(XSSFRelation.SHARED_STRINGS, XSSFFactory.getInstance());
/*  451 */     this.stylesSource = (StylesTable)createRelationship(XSSFRelation.STYLES, XSSFFactory.getInstance());
/*  452 */     this.stylesSource.setWorkbook(this);
/*      */     
/*  454 */     this.namedRanges = new ArrayList<XSSFName>();
/*  455 */     this.namedRangesByName = (ListValuedMap<String, XSSFName>)new ArrayListValuedHashMap();
/*  456 */     this.sheets = new ArrayList<XSSFSheet>();
/*  457 */     this.pivotTables = new ArrayList<XSSFPivotTable>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static OPCPackage newPackage(XSSFWorkbookType paramXSSFWorkbookType) {
/*      */     try {
/*  465 */       OPCPackage oPCPackage = OPCPackage.create(new ByteArrayOutputStream());
/*      */       
/*  467 */       PackagePartName packagePartName = PackagingURIHelper.createPartName(XSSFRelation.WORKBOOK.getDefaultFileName());
/*      */       
/*  469 */       oPCPackage.addRelationship(packagePartName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
/*      */       
/*  471 */       oPCPackage.createPart(packagePartName, paramXSSFWorkbookType.getContentType());
/*      */       
/*  473 */       oPCPackage.getPackageProperties().setCreatorProperty("Apache POI");
/*      */       
/*  475 */       return oPCPackage;
/*  476 */     } catch (Exception exception) {
/*  477 */       throw new POIXMLException(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTWorkbook getCTWorkbook() {
/*  488 */     return this.workbook;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int addPicture(byte[] paramArrayOfbyte, int paramInt) {
/*  508 */     int i = getAllPictures().size() + 1;
/*  509 */     XSSFPictureData xSSFPictureData = (XSSFPictureData)createRelationship(XSSFPictureData.RELATIONS[paramInt], XSSFFactory.getInstance(), i, true).getDocumentPart();
/*      */     try {
/*  511 */       OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
/*  512 */       outputStream.write(paramArrayOfbyte);
/*  513 */       outputStream.close();
/*  514 */     } catch (IOException iOException) {
/*  515 */       throw new POIXMLException(iOException);
/*      */     } 
/*  517 */     this.pictures.add(xSSFPictureData);
/*  518 */     return i - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int addPicture(InputStream paramInputStream, int paramInt) throws IOException {
/*  537 */     int i = getAllPictures().size() + 1;
/*  538 */     XSSFPictureData xSSFPictureData = (XSSFPictureData)createRelationship(XSSFPictureData.RELATIONS[paramInt], XSSFFactory.getInstance(), i, true).getDocumentPart();
/*  539 */     OutputStream outputStream = xSSFPictureData.getPackagePart().getOutputStream();
/*  540 */     IOUtils.copy(paramInputStream, outputStream);
/*  541 */     outputStream.close();
/*  542 */     this.pictures.add(xSSFPictureData);
/*  543 */     return i - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet cloneSheet(int paramInt) {
/*  557 */     return cloneSheet(paramInt, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet cloneSheet(int paramInt, String paramString) {
/*  573 */     validateSheetIndex(paramInt);
/*  574 */     XSSFSheet xSSFSheet1 = this.sheets.get(paramInt);
/*      */     
/*  576 */     if (paramString == null) {
/*  577 */       String str = xSSFSheet1.getSheetName();
/*  578 */       paramString = getUniqueSheetName(str);
/*      */     } else {
/*  580 */       validateSheetName(paramString);
/*      */     } 
/*      */     
/*  583 */     XSSFSheet xSSFSheet2 = createSheet(paramString);
/*      */ 
/*      */     
/*  586 */     List list = xSSFSheet1.getRelationParts();
/*      */     
/*  588 */     XSSFDrawing xSSFDrawing = null;
/*  589 */     for (POIXMLDocumentPart.RelationPart relationPart : list) {
/*  590 */       POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*      */       
/*  592 */       if (pOIXMLDocumentPart instanceof XSSFDrawing) {
/*  593 */         xSSFDrawing = (XSSFDrawing)pOIXMLDocumentPart;
/*      */         
/*      */         continue;
/*      */       } 
/*  597 */       addRelation(relationPart, xSSFSheet2);
/*      */     } 
/*      */     
/*      */     try {
/*  601 */       for (PackageRelationship packageRelationship : xSSFSheet1.getPackagePart().getRelationships()) {
/*  602 */         if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/*  603 */           xSSFSheet2.getPackagePart().addExternalRelationship(packageRelationship.getTargetURI().toASCIIString(), packageRelationship.getRelationshipType(), packageRelationship.getId());
/*      */         }
/*      */       }
/*      */     
/*  607 */     } catch (InvalidFormatException invalidFormatException) {
/*  608 */       throw new POIXMLException("Failed to clone sheet", invalidFormatException);
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  613 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  614 */       xSSFSheet1.write(byteArrayOutputStream);
/*  615 */       xSSFSheet2.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
/*  616 */     } catch (IOException iOException) {
/*  617 */       throw new POIXMLException("Failed to clone sheet", iOException);
/*      */     } 
/*  619 */     CTWorksheet cTWorksheet = xSSFSheet2.getCTWorksheet();
/*  620 */     if (cTWorksheet.isSetLegacyDrawing()) {
/*  621 */       logger.log(5, new Object[] { "Cloning sheets with comments is not yet supported." });
/*  622 */       cTWorksheet.unsetLegacyDrawing();
/*      */     } 
/*  624 */     if (cTWorksheet.isSetPageSetup()) {
/*  625 */       logger.log(5, new Object[] { "Cloning sheets with page setup is not yet supported." });
/*  626 */       cTWorksheet.unsetPageSetup();
/*      */     } 
/*      */     
/*  629 */     xSSFSheet2.setSelected(false);
/*      */ 
/*      */     
/*  632 */     if (xSSFDrawing != null) {
/*  633 */       if (cTWorksheet.isSetDrawing())
/*      */       {
/*      */         
/*  636 */         cTWorksheet.unsetDrawing();
/*      */       }
/*  638 */       XSSFDrawing xSSFDrawing1 = xSSFSheet2.createDrawingPatriarch();
/*      */       
/*  640 */       xSSFDrawing1.getCTDrawing().set((XmlObject)xSSFDrawing.getCTDrawing());
/*      */       
/*  642 */       xSSFDrawing1 = xSSFSheet2.createDrawingPatriarch();
/*      */ 
/*      */       
/*  645 */       List list1 = xSSFSheet1.createDrawingPatriarch().getRelationParts();
/*  646 */       for (POIXMLDocumentPart.RelationPart relationPart : list1) {
/*  647 */         addRelation(relationPart, xSSFDrawing1);
/*      */       }
/*      */     } 
/*  650 */     return xSSFSheet2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void addRelation(POIXMLDocumentPart.RelationPart paramRelationPart, POIXMLDocumentPart paramPOIXMLDocumentPart) {
/*  657 */     PackageRelationship packageRelationship = paramRelationPart.getRelationship();
/*  658 */     if (packageRelationship.getTargetMode() == TargetMode.EXTERNAL) {
/*  659 */       paramPOIXMLDocumentPart.getPackagePart().addRelationship(packageRelationship.getTargetURI(), packageRelationship.getTargetMode(), packageRelationship.getRelationshipType(), packageRelationship.getId());
/*      */     } else {
/*      */       
/*  662 */       XSSFRelation xSSFRelation = XSSFRelation.getInstance(packageRelationship.getRelationshipType());
/*  663 */       if (xSSFRelation == null)
/*      */       {
/*  665 */         throw new POIXMLException("Can't clone sheet - unknown relation type found: " + packageRelationship.getRelationshipType());
/*      */       }
/*  667 */       paramPOIXMLDocumentPart.addRelation(packageRelationship.getId(), xSSFRelation, paramRelationPart.getDocumentPart());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String getUniqueSheetName(String paramString) {
/*  678 */     int i = 2;
/*  679 */     String str = paramString;
/*  680 */     int j = paramString.lastIndexOf('(');
/*  681 */     if (j > 0 && paramString.endsWith(")")) {
/*  682 */       String str1 = paramString.substring(j + 1, paramString.length() - ")".length());
/*      */       try {
/*  684 */         i = Integer.parseInt(str1.trim());
/*  685 */         i++;
/*  686 */         str = paramString.substring(0, j).trim();
/*  687 */       } catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  693 */       String str2, str1 = Integer.toString(i++);
/*      */       
/*  695 */       if (str.length() + str1.length() + 2 < 31) {
/*  696 */         str2 = str + " (" + str1 + ")";
/*      */       } else {
/*  698 */         str2 = str.substring(0, 31 - str1.length() - 2) + "(" + str1 + ")";
/*      */       } 
/*      */ 
/*      */       
/*  702 */       if (getSheetIndex(str2) == -1) {
/*  703 */         return str2;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFCellStyle createCellStyle() {
/*  715 */     return this.stylesSource.createCellStyle();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFDataFormat createDataFormat() {
/*  726 */     if (this.formatter == null)
/*  727 */       this.formatter = new XSSFDataFormat(this.stylesSource); 
/*  728 */     return this.formatter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFFont createFont() {
/*  738 */     XSSFFont xSSFFont = new XSSFFont();
/*  739 */     xSSFFont.registerTo(this.stylesSource);
/*  740 */     return xSSFFont;
/*      */   }
/*      */ 
/*      */   
/*      */   public XSSFName createName() {
/*  745 */     CTDefinedName cTDefinedName = CTDefinedName.Factory.newInstance();
/*  746 */     cTDefinedName.setName("");
/*  747 */     return createAndStoreName(cTDefinedName);
/*      */   }
/*      */   
/*      */   private XSSFName createAndStoreName(CTDefinedName paramCTDefinedName) {
/*  751 */     XSSFName xSSFName = new XSSFName(paramCTDefinedName, this);
/*  752 */     this.namedRanges.add(xSSFName);
/*  753 */     this.namedRangesByName.put(paramCTDefinedName.getName().toLowerCase(Locale.ENGLISH), xSSFName);
/*  754 */     return xSSFName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet createSheet() {
/*  765 */     String str = "Sheet" + this.sheets.size();
/*  766 */     byte b = 0;
/*  767 */     while (getSheet(str) != null) {
/*  768 */       str = "Sheet" + b;
/*  769 */       b++;
/*      */     } 
/*  771 */     return createSheet(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet createSheet(String paramString) {
/*  823 */     if (paramString == null) {
/*  824 */       throw new IllegalArgumentException("sheetName must not be null");
/*      */     }
/*      */     
/*  827 */     validateSheetName(paramString);
/*      */ 
/*      */     
/*  830 */     if (paramString.length() > 31) paramString = paramString.substring(0, 31); 
/*  831 */     WorkbookUtil.validateSheetName(paramString);
/*      */     
/*  833 */     CTSheet cTSheet = addSheet(paramString);
/*      */     
/*  835 */     int i = 1;
/*      */     
/*      */     while (true) {
/*  838 */       for (XSSFSheet xSSFSheet1 : this.sheets) {
/*  839 */         i = (int)Math.max(xSSFSheet1.sheet.getSheetId() + 1L, i);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  844 */       String str = XSSFRelation.WORKSHEET.getFileName(i);
/*  845 */       for (POIXMLDocumentPart pOIXMLDocumentPart : getRelations()) {
/*  846 */         if (pOIXMLDocumentPart.getPackagePart() != null && str.equals(pOIXMLDocumentPart.getPackagePart().getPartName().getName()))
/*      */         {
/*      */           
/*  849 */           i++;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*      */       break;
/*      */     } 
/*      */ 
/*      */     
/*  858 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSSFRelation.WORKSHEET, XSSFFactory.getInstance(), i, false);
/*  859 */     XSSFSheet xSSFSheet = (XSSFSheet)relationPart.getDocumentPart();
/*  860 */     xSSFSheet.sheet = cTSheet;
/*  861 */     cTSheet.setId(relationPart.getRelationship().getId());
/*  862 */     cTSheet.setSheetId(i);
/*  863 */     if (this.sheets.isEmpty()) xSSFSheet.setSelected(true); 
/*  864 */     this.sheets.add(xSSFSheet);
/*  865 */     return xSSFSheet;
/*      */   }
/*      */   
/*      */   private void validateSheetName(String paramString) throws IllegalArgumentException {
/*  869 */     if (containsSheet(paramString, this.sheets.size())) {
/*  870 */       throw new IllegalArgumentException("The workbook already contains a sheet named '" + paramString + "'");
/*      */     }
/*      */   }
/*      */   
/*      */   protected XSSFDialogsheet createDialogsheet(String paramString, CTDialogsheet paramCTDialogsheet) {
/*  875 */     XSSFSheet xSSFSheet = createSheet(paramString);
/*  876 */     String str = getRelationId(xSSFSheet);
/*  877 */     PackageRelationship packageRelationship = getPackagePart().getRelationship(str);
/*  878 */     return new XSSFDialogsheet(xSSFSheet, packageRelationship);
/*      */   }
/*      */   
/*      */   private CTSheet addSheet(String paramString) {
/*  882 */     CTSheet cTSheet = this.workbook.getSheets().addNewSheet();
/*  883 */     cTSheet.setName(paramString);
/*  884 */     return cTSheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public XSSFFont findFont(short paramShort1, short paramShort2, short paramShort3, String paramString, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, byte paramByte) {
/*  894 */     return this.stylesSource.findFont(paramShort1, paramShort2, paramShort3, paramString, paramBoolean1, paramBoolean2, paramShort4, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFFont findFont(boolean paramBoolean1, short paramShort1, short paramShort2, String paramString, boolean paramBoolean2, boolean paramBoolean3, short paramShort3, byte paramByte) {
/*  902 */     return this.stylesSource.findFont(paramBoolean1, paramShort1, paramShort2, paramString, paramBoolean2, paramBoolean3, paramShort3, paramByte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getActiveSheetIndex() {
/*  914 */     return (int)this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFPictureData> getAllPictures() {
/*  925 */     if (this.pictures == null) {
/*  926 */       List list = getPackage().getPartsByName(Pattern.compile("/xl/media/.*?"));
/*  927 */       this.pictures = new ArrayList<XSSFPictureData>(list.size());
/*  928 */       for (PackagePart packagePart : list) {
/*  929 */         this.pictures.add(new XSSFPictureData(packagePart));
/*      */       }
/*      */     } 
/*  932 */     return this.pictures;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFCellStyle getCellStyleAt(int paramInt) {
/*  943 */     return this.stylesSource.getStyleAt(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFFont getFontAt(short paramShort) {
/*  954 */     return this.stylesSource.getFontAt(paramShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFName getName(String paramString) {
/*  968 */     List<XSSFName> list = getNames(paramString);
/*  969 */     if (list.isEmpty()) {
/*  970 */       return null;
/*      */     }
/*  972 */     return list.iterator().next();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFName> getNames(String paramString) {
/*  985 */     return Collections.unmodifiableList(this.namedRangesByName.get(paramString.toLowerCase(Locale.ENGLISH)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public XSSFName getNameAt(int paramInt) {
/*  999 */     int i = this.namedRanges.size();
/* 1000 */     if (i < 1) {
/* 1001 */       throw new IllegalStateException("There are no defined names in this workbook");
/*      */     }
/* 1003 */     if (paramInt < 0 || paramInt > i) {
/* 1004 */       throw new IllegalArgumentException("Specified name index " + paramInt + " is outside the allowable range (0.." + (i - 1) + ").");
/*      */     }
/*      */     
/* 1007 */     return this.namedRanges.get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFName> getAllNames() {
/* 1017 */     return Collections.unmodifiableList(this.namedRanges);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public int getNameIndex(String paramString) {
/* 1032 */     XSSFName xSSFName = getName(paramString);
/* 1033 */     if (xSSFName != null) {
/* 1034 */       return this.namedRanges.indexOf(xSSFName);
/*      */     }
/* 1036 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumCellStyles() {
/* 1046 */     return this.stylesSource.getNumCellStyles();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getNumberOfFonts() {
/* 1056 */     return (short)this.stylesSource.getFonts().size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfNames() {
/* 1066 */     return this.namedRanges.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfSheets() {
/* 1076 */     return this.sheets.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPrintArea(int paramInt) {
/* 1086 */     XSSFName xSSFName = getBuiltInName("_xlnm.Print_Area", paramInt);
/* 1087 */     if (xSSFName == null) return null;
/*      */     
/* 1089 */     return xSSFName.getRefersToFormula();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet getSheet(String paramString) {
/* 1101 */     for (XSSFSheet xSSFSheet : this.sheets) {
/* 1102 */       if (paramString.equalsIgnoreCase(xSSFSheet.getSheetName())) {
/* 1103 */         return xSSFSheet;
/*      */       }
/*      */     } 
/* 1106 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFSheet getSheetAt(int paramInt) {
/* 1119 */     validateSheetIndex(paramInt);
/* 1120 */     return this.sheets.get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSheetIndex(String paramString) {
/* 1131 */     byte b = 0;
/* 1132 */     for (XSSFSheet xSSFSheet : this.sheets) {
/* 1133 */       if (paramString.equalsIgnoreCase(xSSFSheet.getSheetName())) {
/* 1134 */         return b;
/*      */       }
/* 1136 */       b++;
/*      */     } 
/* 1138 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSheetIndex(Sheet paramSheet) {
/* 1149 */     byte b = 0;
/* 1150 */     for (XSSFSheet xSSFSheet : this.sheets) {
/* 1151 */       if (xSSFSheet == paramSheet) return b; 
/* 1152 */       b++;
/*      */     } 
/* 1154 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSheetName(int paramInt) {
/* 1165 */     validateSheetIndex(paramInt);
/* 1166 */     return ((XSSFSheet)this.sheets.get(paramInt)).getSheetName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> sheetIterator() {
/* 1180 */     return new SheetIterator<Sheet>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> iterator() {
/* 1200 */     return sheetIterator();
/*      */   }
/*      */ 
/*      */   
/*      */   private final class SheetIterator<T extends Sheet>
/*      */     implements Iterator<T>
/*      */   {
/* 1207 */     private final Iterator<T> it = XSSFWorkbook.this.sheets.iterator();
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 1211 */       return this.it.hasNext();
/*      */     }
/*      */     
/*      */     public T next() throws NoSuchElementException {
/* 1215 */       return this.it.next();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() throws IllegalStateException {
/* 1224 */       throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Iterator<XSSFSheet> xssfSheetIterator() {
/* 1294 */     return new SheetIterator<XSSFSheet>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isMacroEnabled() {
/* 1302 */     return getPackagePart().getContentType().equals(XSSFRelation.MACROS_WORKBOOK.getContentType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void removeName(int paramInt) {
/* 1315 */     removeName(getNameAt(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public void removeName(String paramString) {
/* 1334 */     List<Name> list = this.namedRangesByName.get(paramString.toLowerCase(Locale.ENGLISH));
/* 1335 */     if (list.isEmpty()) {
/* 1336 */       throw new IllegalArgumentException("Named range was not found: " + paramString);
/*      */     }
/* 1338 */     removeName(list.get(0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeName(Name paramName) {
/* 1352 */     if (!this.namedRangesByName.removeMapping(paramName.getNameName().toLowerCase(Locale.ENGLISH), paramName) || !this.namedRanges.remove(paramName))
/*      */     {
/* 1354 */       throw new IllegalArgumentException("Name was not found: " + paramName);
/*      */     }
/*      */   }
/*      */   
/*      */   void updateName(XSSFName paramXSSFName, String paramString) {
/* 1359 */     if (!this.namedRangesByName.removeMapping(paramString.toLowerCase(Locale.ENGLISH), paramXSSFName)) {
/* 1360 */       throw new IllegalArgumentException("Name was not found: " + paramXSSFName);
/*      */     }
/* 1362 */     this.namedRangesByName.put(paramXSSFName.getNameName().toLowerCase(Locale.ENGLISH), paramXSSFName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePrintArea(int paramInt) {
/* 1373 */     XSSFName xSSFName = getBuiltInName("_xlnm.Print_Area", paramInt);
/* 1374 */     if (xSSFName != null) {
/* 1375 */       removeName(xSSFName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeSheetAt(int paramInt) {
/* 1395 */     validateSheetIndex(paramInt);
/*      */     
/* 1397 */     onSheetDelete(paramInt);
/*      */     
/* 1399 */     XSSFSheet xSSFSheet = getSheetAt(paramInt);
/* 1400 */     removeRelation(xSSFSheet);
/* 1401 */     this.sheets.remove(paramInt);
/*      */ 
/*      */     
/* 1404 */     if (this.sheets.size() == 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1409 */     int i = paramInt;
/* 1410 */     if (i >= this.sheets.size()) {
/* 1411 */       i = this.sheets.size() - 1;
/*      */     }
/*      */ 
/*      */     
/* 1415 */     int j = getActiveSheetIndex();
/* 1416 */     if (j == paramInt) {
/*      */       
/* 1418 */       setActiveSheet(i);
/* 1419 */     } else if (j > paramInt) {
/*      */       
/* 1421 */       setActiveSheet(j - 1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void onSheetDelete(int paramInt) {
/* 1432 */     this.workbook.getSheets().removeSheet(paramInt);
/*      */ 
/*      */     
/* 1435 */     if (this.calcChain != null) {
/* 1436 */       removeRelation((POIXMLDocumentPart)this.calcChain);
/* 1437 */       this.calcChain = null;
/*      */     } 
/*      */ 
/*      */     
/* 1441 */     ArrayList<XSSFName> arrayList = new ArrayList();
/* 1442 */     for (XSSFName xSSFName : this.namedRanges) {
/* 1443 */       CTDefinedName cTDefinedName = xSSFName.getCTName();
/* 1444 */       if (!cTDefinedName.isSetLocalSheetId())
/* 1445 */         continue;  if (cTDefinedName.getLocalSheetId() == paramInt) {
/* 1446 */         arrayList.add(xSSFName); continue;
/* 1447 */       }  if (cTDefinedName.getLocalSheetId() > paramInt)
/*      */       {
/* 1449 */         cTDefinedName.setLocalSheetId(cTDefinedName.getLocalSheetId() - 1L);
/*      */       }
/*      */     } 
/* 1452 */     for (XSSFName xSSFName : arrayList) {
/* 1453 */       removeName(xSSFName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row.MissingCellPolicy getMissingCellPolicy() {
/* 1465 */     return this._missingCellPolicy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMissingCellPolicy(Row.MissingCellPolicy paramMissingCellPolicy) {
/* 1476 */     this._missingCellPolicy = paramMissingCellPolicy;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveSheet(int paramInt) {
/* 1487 */     validateSheetIndex(paramInt);
/*      */     
/* 1489 */     for (CTBookView cTBookView : this.workbook.getBookViews().getWorkbookViewArray()) {
/* 1490 */       cTBookView.setActiveTab(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validateSheetIndex(int paramInt) {
/* 1502 */     int i = this.sheets.size() - 1;
/* 1503 */     if (paramInt < 0 || paramInt > i) {
/* 1504 */       String str = "(0.." + i + ")";
/* 1505 */       if (i == -1) {
/* 1506 */         str = "(no sheets)";
/*      */       }
/* 1508 */       throw new IllegalArgumentException("Sheet index (" + paramInt + ") is out of range " + str);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstVisibleTab() {
/* 1520 */     CTBookViews cTBookViews = this.workbook.getBookViews();
/* 1521 */     CTBookView cTBookView = cTBookViews.getWorkbookViewArray(0);
/* 1522 */     return (short)(int)cTBookView.getFirstSheet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFirstVisibleTab(int paramInt) {
/* 1532 */     CTBookViews cTBookViews = this.workbook.getBookViews();
/* 1533 */     CTBookView cTBookView = cTBookViews.getWorkbookViewArray(0);
/* 1534 */     cTBookView.setFirstSheet(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintArea(int paramInt, String paramString) {
/* 1546 */     XSSFName xSSFName = getBuiltInName("_xlnm.Print_Area", paramInt);
/* 1547 */     if (xSSFName == null) {
/* 1548 */       xSSFName = createBuiltInName("_xlnm.Print_Area", paramInt);
/*      */     }
/*      */ 
/*      */     
/* 1552 */     String[] arrayOfString = COMMA_PATTERN.split(paramString);
/* 1553 */     StringBuffer stringBuffer = new StringBuffer(32);
/* 1554 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 1555 */       if (b > 0) {
/* 1556 */         stringBuffer.append(",");
/*      */       }
/* 1558 */       SheetNameFormatter.appendFormat(stringBuffer, getSheetName(paramInt));
/* 1559 */       stringBuffer.append("!");
/* 1560 */       stringBuffer.append(arrayOfString[b]);
/*      */     } 
/* 1562 */     xSSFName.setRefersToFormula(stringBuffer.toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1576 */     String str = getReferencePrintArea(getSheetName(paramInt1), paramInt2, paramInt3, paramInt4, paramInt5);
/* 1577 */     setPrintArea(paramInt1, str);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String getReferencePrintArea(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1582 */     CellReference cellReference1 = new CellReference(paramString, paramInt3, paramInt1, true, true);
/* 1583 */     CellReference cellReference2 = new CellReference(paramString, paramInt4, paramInt2, true, true);
/*      */     
/* 1585 */     return "$" + cellReference1.getCellRefParts()[2] + "$" + cellReference1.getCellRefParts()[1] + ":$" + cellReference2.getCellRefParts()[2] + "$" + cellReference2.getCellRefParts()[1];
/*      */   }
/*      */   
/*      */   XSSFName getBuiltInName(String paramString, int paramInt) {
/* 1589 */     for (XSSFName xSSFName : this.namedRangesByName.get(paramString.toLowerCase(Locale.ENGLISH))) {
/* 1590 */       if (xSSFName.getSheetIndex() == paramInt) {
/* 1591 */         return xSSFName;
/*      */       }
/*      */     } 
/* 1594 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   XSSFName createBuiltInName(String paramString, int paramInt) {
/* 1605 */     validateSheetIndex(paramInt);
/*      */     
/* 1607 */     CTDefinedNames cTDefinedNames = (this.workbook.getDefinedNames() == null) ? this.workbook.addNewDefinedNames() : this.workbook.getDefinedNames();
/* 1608 */     CTDefinedName cTDefinedName = cTDefinedNames.addNewDefinedName();
/* 1609 */     cTDefinedName.setName(paramString);
/* 1610 */     cTDefinedName.setLocalSheetId(paramInt);
/*      */     
/* 1612 */     if (getBuiltInName(paramString, paramInt) != null) {
/* 1613 */       throw new POIXMLException("Builtin (" + paramString + ") already exists for sheet (" + paramInt + ")");
/*      */     }
/*      */ 
/*      */     
/* 1617 */     return createAndStoreName(cTDefinedName);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelectedTab(int paramInt) {
/* 1625 */     int i = 0;
/* 1626 */     for (XSSFSheet xSSFSheet : this.sheets) {
/* 1627 */       xSSFSheet.setSelected((i == paramInt));
/* 1628 */       i++;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetName(int paramInt, String paramString) {
/* 1644 */     validateSheetIndex(paramInt);
/* 1645 */     String str = getSheetName(paramInt);
/*      */ 
/*      */     
/* 1648 */     if (paramString != null && paramString.length() > 31) paramString = paramString.substring(0, 31); 
/* 1649 */     WorkbookUtil.validateSheetName(paramString);
/*      */     
/* 1651 */     assert paramString != null;
/*      */ 
/*      */     
/* 1654 */     if (paramString.equals(str)) {
/*      */       return;
/*      */     }
/* 1657 */     if (containsSheet(paramString, paramInt)) {
/* 1658 */       throw new IllegalArgumentException("The workbook already contains a sheet of this name");
/*      */     }
/*      */     
/* 1661 */     XSSFFormulaUtils xSSFFormulaUtils = new XSSFFormulaUtils(this);
/* 1662 */     xSSFFormulaUtils.updateSheetName(paramInt, str, paramString);
/*      */     
/* 1664 */     this.workbook.getSheets().getSheetArray(paramInt).setName(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetOrder(String paramString, int paramInt) {
/* 1675 */     int i = getSheetIndex(paramString);
/* 1676 */     this.sheets.add(paramInt, this.sheets.remove(i));
/*      */ 
/*      */     
/* 1679 */     CTSheets cTSheets = this.workbook.getSheets();
/* 1680 */     XmlObject xmlObject = cTSheets.getSheetArray(i).copy();
/* 1681 */     this.workbook.getSheets().removeSheet(i);
/* 1682 */     CTSheet cTSheet = cTSheets.insertNewSheet(paramInt);
/* 1683 */     cTSheet.set(xmlObject);
/*      */ 
/*      */     
/* 1686 */     CTSheet[] arrayOfCTSheet = cTSheets.getSheetArray(); int j;
/* 1687 */     for (j = 0; j < arrayOfCTSheet.length; j++) {
/* 1688 */       ((XSSFSheet)this.sheets.get(j)).sheet = arrayOfCTSheet[j];
/*      */     }
/*      */ 
/*      */     
/* 1692 */     j = getActiveSheetIndex();
/* 1693 */     if (j == i) {
/*      */       
/* 1695 */       setActiveSheet(paramInt);
/* 1696 */     } else if ((j >= i || j >= paramInt) && (j <= i || j <= paramInt)) {
/*      */ 
/*      */       
/* 1699 */       if (paramInt > i) {
/*      */         
/* 1701 */         setActiveSheet(j - 1);
/*      */       } else {
/*      */         
/* 1704 */         setActiveSheet(j + 1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void saveNamedRanges() {
/* 1713 */     if (this.namedRanges.size() > 0) {
/* 1714 */       CTDefinedNames cTDefinedNames = CTDefinedNames.Factory.newInstance();
/* 1715 */       CTDefinedName[] arrayOfCTDefinedName = new CTDefinedName[this.namedRanges.size()];
/* 1716 */       byte b = 0;
/* 1717 */       for (XSSFName xSSFName : this.namedRanges) {
/* 1718 */         arrayOfCTDefinedName[b] = xSSFName.getCTName();
/* 1719 */         b++;
/*      */       } 
/* 1721 */       cTDefinedNames.setDefinedNameArray(arrayOfCTDefinedName);
/* 1722 */       if (this.workbook.isSetDefinedNames()) {
/* 1723 */         this.workbook.unsetDefinedNames();
/*      */       }
/* 1725 */       this.workbook.setDefinedNames(cTDefinedNames);
/*      */ 
/*      */       
/* 1728 */       reprocessNamedRanges();
/*      */     }
/* 1730 */     else if (this.workbook.isSetDefinedNames()) {
/* 1731 */       this.workbook.unsetDefinedNames();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void reprocessNamedRanges() {
/* 1737 */     this.namedRangesByName = (ListValuedMap<String, XSSFName>)new ArrayListValuedHashMap();
/* 1738 */     this.namedRanges = new ArrayList<XSSFName>();
/* 1739 */     if (this.workbook.isSetDefinedNames()) {
/* 1740 */       for (CTDefinedName cTDefinedName : this.workbook.getDefinedNames().getDefinedNameArray()) {
/* 1741 */         createAndStoreName(cTDefinedName);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void saveCalculationChain() {
/* 1747 */     if (this.calcChain != null) {
/* 1748 */       int i = this.calcChain.getCTCalcChain().sizeOfCArray();
/* 1749 */       if (i == 0) {
/* 1750 */         removeRelation((POIXMLDocumentPart)this.calcChain);
/* 1751 */         this.calcChain = null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void commit() throws IOException {
/* 1758 */     saveNamedRanges();
/* 1759 */     saveCalculationChain();
/*      */     
/* 1761 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 1762 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTWorkbook.type.getName().getNamespaceURI(), "workbook"));
/*      */     
/* 1764 */     PackagePart packagePart = getPackagePart();
/* 1765 */     OutputStream outputStream = packagePart.getOutputStream();
/* 1766 */     this.workbook.save(outputStream, xmlOptions);
/* 1767 */     outputStream.close();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public SharedStringsTable getSharedStringSource() {
/* 1777 */     return this.sharedStringSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StylesTable getStylesSource() {
/* 1785 */     return this.stylesSource;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ThemesTable getTheme() {
/* 1792 */     if (this.stylesSource == null) return null; 
/* 1793 */     return this.stylesSource.getTheme();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFCreationHelper getCreationHelper() {
/* 1802 */     if (this._creationHelper == null) this._creationHelper = new XSSFCreationHelper(this); 
/* 1803 */     return this._creationHelper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean containsSheet(String paramString, int paramInt) {
/* 1815 */     CTSheet[] arrayOfCTSheet = this.workbook.getSheets().getSheetArray();
/*      */     
/* 1817 */     if (paramString.length() > 31) {
/* 1818 */       paramString = paramString.substring(0, 31);
/*      */     }
/*      */     
/* 1821 */     for (byte b = 0; b < arrayOfCTSheet.length; b++) {
/* 1822 */       String str = arrayOfCTSheet[b].getName();
/* 1823 */       if (str.length() > 31) {
/* 1824 */         str = str.substring(0, 31);
/*      */       }
/*      */       
/* 1827 */       if (paramInt != b && paramString.equalsIgnoreCase(str))
/* 1828 */         return true; 
/*      */     } 
/* 1830 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public boolean isDate1904() {
/* 1843 */     CTWorkbookPr cTWorkbookPr = this.workbook.getWorkbookPr();
/* 1844 */     return (cTWorkbookPr != null && cTWorkbookPr.getDate1904());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<PackagePart> getAllEmbedds() throws OpenXML4JException {
/* 1852 */     LinkedList<PackagePart> linkedList = new LinkedList();
/*      */     
/* 1854 */     for (XSSFSheet xSSFSheet : this.sheets) {
/*      */       
/* 1856 */       for (PackageRelationship packageRelationship : xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.OLEEMBEDDINGS.getRelation())) {
/* 1857 */         linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(packageRelationship));
/*      */       }
/*      */       
/* 1860 */       for (PackageRelationship packageRelationship : xSSFSheet.getPackagePart().getRelationshipsByType(XSSFRelation.PACKEMBEDDINGS.getRelation())) {
/* 1861 */         linkedList.add(xSSFSheet.getPackagePart().getRelatedPart(packageRelationship));
/*      */       }
/*      */     } 
/* 1864 */     return linkedList;
/*      */   }
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public boolean isHidden() {
/* 1870 */     throw new RuntimeException("Not implemented yet");
/*      */   }
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public void setHidden(boolean paramBoolean) {
/* 1876 */     throw new RuntimeException("Not implemented yet");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSheetHidden(int paramInt) {
/* 1890 */     validateSheetIndex(paramInt);
/* 1891 */     CTSheet cTSheet = ((XSSFSheet)this.sheets.get(paramInt)).sheet;
/* 1892 */     return (cTSheet.getState() == STSheetState.HIDDEN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSheetVeryHidden(int paramInt) {
/* 1906 */     validateSheetIndex(paramInt);
/* 1907 */     CTSheet cTSheet = ((XSSFSheet)this.sheets.get(paramInt)).sheet;
/* 1908 */     return (cTSheet.getState() == STSheetState.VERY_HIDDEN);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetHidden(int paramInt, boolean paramBoolean) {
/* 1930 */     setSheetHidden(paramInt, paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetHidden(int paramInt1, int paramInt2) {
/* 1954 */     validateSheetIndex(paramInt1);
/* 1955 */     WorkbookUtil.validateSheetState(paramInt2);
/* 1956 */     CTSheet cTSheet = ((XSSFSheet)this.sheets.get(paramInt1)).sheet;
/* 1957 */     cTSheet.setState(STSheetState.Enum.forInt(paramInt2 + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDeleteFormula(XSSFCell paramXSSFCell) {
/* 1967 */     if (this.calcChain != null) {
/* 1968 */       int i = (int)(paramXSSFCell.getSheet()).sheet.getSheetId();
/* 1969 */       this.calcChain.removeItem(i, paramXSSFCell.getReference());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CalculationChain getCalculationChain() {
/* 1983 */     return this.calcChain;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public List<ExternalLinksTable> getExternalLinksTable() {
/* 2001 */     return this.externalLinks;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<XSSFMap> getCustomXMLMappings() {
/* 2009 */     return (this.mapInfo == null) ? new ArrayList<XSSFMap>() : this.mapInfo.getAllXSSFMaps();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public MapInfo getMapInfo() {
/* 2018 */     return this.mapInfo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NotImplemented
/*      */   public int linkExternalWorkbook(String paramString, Workbook paramWorkbook) {
/* 2033 */     throw new RuntimeException("Not Implemented - see bug #57184");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStructureLocked() {
/* 2045 */     return (workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockStructure());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWindowsLocked() {
/* 2057 */     return (workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockWindows());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRevisionLocked() {
/* 2066 */     return (workbookProtectionPresent() && this.workbook.getWorkbookProtection().getLockRevision());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockStructure() {
/* 2073 */     safeGetWorkbookProtection().setLockStructure(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unLockStructure() {
/* 2080 */     safeGetWorkbookProtection().setLockStructure(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockWindows() {
/* 2087 */     safeGetWorkbookProtection().setLockWindows(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unLockWindows() {
/* 2094 */     safeGetWorkbookProtection().setLockWindows(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockRevision() {
/* 2101 */     safeGetWorkbookProtection().setLockRevision(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unLockRevision() {
/* 2108 */     safeGetWorkbookProtection().setLockRevision(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkbookPassword(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 2119 */     if (paramString == null && !workbookProtectionPresent())
/* 2120 */       return;  XSSFPasswordHelper.setPassword((XmlObject)safeGetWorkbookProtection(), paramString, paramHashAlgorithm, "workbook");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean validateWorkbookPassword(String paramString) {
/* 2129 */     if (!workbookProtectionPresent()) return (paramString == null); 
/* 2130 */     return XSSFPasswordHelper.validatePassword((XmlObject)safeGetWorkbookProtection(), paramString, "workbook");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRevisionsPassword(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 2141 */     if (paramString == null && !workbookProtectionPresent())
/* 2142 */       return;  XSSFPasswordHelper.setPassword((XmlObject)safeGetWorkbookProtection(), paramString, paramHashAlgorithm, "revisions");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean validateRevisionsPassword(String paramString) {
/* 2151 */     if (!workbookProtectionPresent()) return (paramString == null); 
/* 2152 */     return XSSFPasswordHelper.validatePassword((XmlObject)safeGetWorkbookProtection(), paramString, "revisions");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unLock() {
/* 2159 */     if (workbookProtectionPresent()) {
/* 2160 */       this.workbook.unsetWorkbookProtection();
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean workbookProtectionPresent() {
/* 2165 */     return this.workbook.isSetWorkbookProtection();
/*      */   }
/*      */   
/*      */   private CTWorkbookProtection safeGetWorkbookProtection() {
/* 2169 */     if (!workbookProtectionPresent()) {
/* 2170 */       return this.workbook.addNewWorkbookProtection();
/*      */     }
/* 2172 */     return this.workbook.getWorkbookProtection();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   UDFFinder getUDFFinder() {
/* 2188 */     return (UDFFinder)this._udfFinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addToolPack(UDFFinder paramUDFFinder) {
/* 2198 */     this._udfFinder.add(paramUDFFinder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForceFormulaRecalculation(boolean paramBoolean) {
/* 2220 */     CTWorkbook cTWorkbook = getCTWorkbook();
/* 2221 */     CTCalcPr cTCalcPr = cTWorkbook.isSetCalcPr() ? cTWorkbook.getCalcPr() : cTWorkbook.addNewCalcPr();
/*      */ 
/*      */     
/* 2224 */     cTCalcPr.setCalcId(0L);
/*      */     
/* 2226 */     if (paramBoolean && cTCalcPr.getCalcMode() == STCalcMode.MANUAL) {
/* 2227 */       cTCalcPr.setCalcMode(STCalcMode.AUTO);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceFormulaRecalculation() {
/* 2238 */     CTWorkbook cTWorkbook = getCTWorkbook();
/* 2239 */     CTCalcPr cTCalcPr = cTWorkbook.getCalcPr();
/* 2240 */     return (cTCalcPr != null && cTCalcPr.getCalcId() != 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected CTPivotCache addPivotCache(String paramString) {
/*      */     CTPivotCaches cTPivotCaches;
/* 2250 */     CTWorkbook cTWorkbook = getCTWorkbook();
/*      */     
/* 2252 */     if (cTWorkbook.isSetPivotCaches()) {
/* 2253 */       cTPivotCaches = cTWorkbook.getPivotCaches();
/*      */     } else {
/* 2255 */       cTPivotCaches = cTWorkbook.addNewPivotCaches();
/*      */     } 
/* 2257 */     CTPivotCache cTPivotCache = cTPivotCaches.addNewPivotCache();
/*      */     
/* 2259 */     int i = getPivotTables().size() + 1;
/* 2260 */     cTPivotCache.setCacheId(i);
/* 2261 */     cTPivotCache.setId(paramString);
/* 2262 */     if (this.pivotCaches == null) {
/* 2263 */       this.pivotCaches = new ArrayList<CTPivotCache>();
/*      */     }
/* 2265 */     this.pivotCaches.add(cTPivotCache);
/* 2266 */     return cTPivotCache;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<XSSFPivotTable> getPivotTables() {
/* 2271 */     return this.pivotTables;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void setPivotTables(List<XSSFPivotTable> paramList) {
/* 2276 */     this.pivotTables = paramList;
/*      */   }
/*      */   
/*      */   public XSSFWorkbookType getWorkbookType() {
/* 2280 */     return isMacroEnabled() ? XSSFWorkbookType.XLSM : XSSFWorkbookType.XLSX;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setWorkbookType(XSSFWorkbookType paramXSSFWorkbookType) {
/*      */     try {
/* 2288 */       getPackagePart().setContentType(paramXSSFWorkbookType.getContentType());
/* 2289 */     } catch (InvalidFormatException invalidFormatException) {
/* 2290 */       throw new POIXMLException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVBAProject(InputStream paramInputStream) throws IOException {
/*      */     PackagePartName packagePartName;
/*      */     OutputStream outputStream;
/* 2301 */     if (!isMacroEnabled()) {
/* 2302 */       setWorkbookType(XSSFWorkbookType.XLSM);
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 2307 */       packagePartName = PackagingURIHelper.createPartName(XSSFRelation.VBA_MACROS.getDefaultFileName());
/* 2308 */     } catch (InvalidFormatException invalidFormatException) {
/* 2309 */       throw new POIXMLException(invalidFormatException);
/*      */     } 
/* 2311 */     OPCPackage oPCPackage = getPackage();
/*      */     
/* 2313 */     if (!oPCPackage.containPart(packagePartName)) {
/* 2314 */       POIXMLDocumentPart pOIXMLDocumentPart = createRelationship(XSSFRelation.VBA_MACROS, XSSFFactory.getInstance());
/* 2315 */       outputStream = pOIXMLDocumentPart.getPackagePart().getOutputStream();
/*      */     } else {
/* 2317 */       PackagePart packagePart = oPCPackage.getPart(packagePartName);
/* 2318 */       outputStream = packagePart.getOutputStream();
/*      */     } 
/*      */     try {
/* 2321 */       IOUtils.copy(paramInputStream, outputStream);
/*      */     } finally {
/* 2323 */       IOUtils.closeQuietly(outputStream);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVBAProject(XSSFWorkbook paramXSSFWorkbook) throws IOException, InvalidFormatException {
/* 2333 */     if (!paramXSSFWorkbook.isMacroEnabled()) {
/*      */       return;
/*      */     }
/* 2336 */     InputStream inputStream = XSSFRelation.VBA_MACROS.getContents(paramXSSFWorkbook.getCorePart());
/* 2337 */     if (inputStream != null) {
/* 2338 */       setVBAProject(inputStream);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SpreadsheetVersion getSpreadsheetVersion() {
/* 2350 */     return SpreadsheetVersion.EXCEL2007;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFTable getTable(String paramString) {
/* 2361 */     if (paramString != null && this.sheets != null) {
/* 2362 */       for (XSSFSheet xSSFSheet : this.sheets) {
/* 2363 */         for (XSSFTable xSSFTable : xSSFSheet.getTables()) {
/* 2364 */           if (paramString.equalsIgnoreCase(xSSFTable.getName())) {
/* 2365 */             return xSSFTable;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/* 2370 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */