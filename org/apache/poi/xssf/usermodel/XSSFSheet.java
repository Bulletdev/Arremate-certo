/*      */ package org.apache.poi.xssf.usermodel;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.SortedMap;
/*      */ import java.util.TreeMap;
/*      */ import org.apache.poi.POIXMLDocumentPart;
/*      */ import org.apache.poi.POIXMLException;
/*      */ import org.apache.poi.POIXMLTypeLoader;
/*      */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*      */ import org.apache.poi.openxml4j.opc.PackagePart;
/*      */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*      */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*      */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaShifter;
/*      */ import org.apache.poi.ss.usermodel.Cell;
/*      */ import org.apache.poi.ss.usermodel.CellCopyPolicy;
/*      */ import org.apache.poi.ss.usermodel.CellRange;
/*      */ import org.apache.poi.ss.usermodel.CellStyle;
/*      */ import org.apache.poi.ss.usermodel.Comment;
/*      */ import org.apache.poi.ss.usermodel.DataValidation;
/*      */ import org.apache.poi.ss.usermodel.Drawing;
/*      */ import org.apache.poi.ss.usermodel.Footer;
/*      */ import org.apache.poi.ss.usermodel.Header;
/*      */ import org.apache.poi.ss.usermodel.Hyperlink;
/*      */ import org.apache.poi.ss.usermodel.IgnoredErrorType;
/*      */ import org.apache.poi.ss.usermodel.IndexedColors;
/*      */ import org.apache.poi.ss.usermodel.Row;
/*      */ import org.apache.poi.ss.usermodel.Sheet;
/*      */ import org.apache.poi.ss.util.AreaReference;
/*      */ import org.apache.poi.ss.util.CellAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.CellRangeAddressBase;
/*      */ import org.apache.poi.ss.util.CellRangeAddressList;
/*      */ import org.apache.poi.ss.util.CellReference;
/*      */ import org.apache.poi.ss.util.PaneInformation;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.xssf.model.CommentsTable;
/*      */ import org.apache.poi.xssf.usermodel.helpers.ColumnHelper;
/*      */ import org.apache.poi.xssf.usermodel.helpers.XSSFIgnoredErrorHelper;
/*      */ import org.apache.poi.xssf.usermodel.helpers.XSSFPasswordHelper;
/*      */ import org.apache.poi.xssf.usermodel.helpers.XSSFRowShifter;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTAutoFilter;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBreak;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTComment;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCommentList;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidations;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDrawing;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHyperlink;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredErrors;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTLegacyDrawing;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCell;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTMergeCells;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOutlinePr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetUpPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPane;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSelection;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetCalcPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTablePart;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableParts;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCalcMode;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPane;
/*      */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPaneState;
/*      */ 
/*      */ public class XSSFSheet extends POIXMLDocumentPart implements Sheet {
/*  100 */   private static final POILogger logger = POILogFactory.getLogger(XSSFSheet.class);
/*      */   
/*      */   private static final double DEFAULT_ROW_HEIGHT = 15.0D;
/*      */   
/*      */   private static final double DEFAULT_MARGIN_HEADER = 0.3D;
/*      */   
/*      */   private static final double DEFAULT_MARGIN_FOOTER = 0.3D;
/*      */   
/*      */   private static final double DEFAULT_MARGIN_TOP = 0.75D;
/*      */   private static final double DEFAULT_MARGIN_BOTTOM = 0.75D;
/*      */   private static final double DEFAULT_MARGIN_LEFT = 0.7D;
/*      */   private static final double DEFAULT_MARGIN_RIGHT = 0.7D;
/*      */   public static final int TWIPS_PER_POINT = 20;
/*      */   protected CTSheet sheet;
/*      */   protected CTWorksheet worksheet;
/*  115 */   private final SortedMap<Integer, XSSFRow> _rows = new TreeMap<Integer, XSSFRow>();
/*      */ 
/*      */   
/*      */   private List<XSSFHyperlink> hyperlinks;
/*      */ 
/*      */   
/*      */   private ColumnHelper columnHelper;
/*      */   
/*      */   private CommentsTable sheetComments;
/*      */   
/*      */   private Map<Integer, CTCellFormula> sharedFormulas;
/*      */   
/*      */   private SortedMap<String, XSSFTable> tables;
/*      */   
/*      */   private List<CellRangeAddress> arrayFormulas;
/*      */   
/*      */   private XSSFDataValidationHelper dataValidationHelper;
/*      */ 
/*      */   
/*      */   protected XSSFSheet() {
/*  135 */     this.dataValidationHelper = new XSSFDataValidationHelper(this);
/*  136 */     onDocumentCreate();
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
/*      */   protected XSSFSheet(PackagePart paramPackagePart) {
/*  148 */     super(paramPackagePart);
/*  149 */     this.dataValidationHelper = new XSSFDataValidationHelper(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   protected XSSFSheet(PackagePart paramPackagePart, PackageRelationship paramPackageRelationship) {
/*  157 */     this(paramPackagePart);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFWorkbook getWorkbook() {
/*  167 */     return (XSSFWorkbook)getParent();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDocumentRead() {
/*      */     try {
/*  176 */       read(getPackagePart().getInputStream());
/*  177 */     } catch (IOException iOException) {
/*  178 */       throw new POIXMLException(iOException);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void read(InputStream paramInputStream) throws IOException {
/*      */     try {
/*  184 */       this.worksheet = WorksheetDocument.Factory.parse(paramInputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getWorksheet();
/*  185 */     } catch (XmlException xmlException) {
/*  186 */       throw new POIXMLException(xmlException);
/*      */     } 
/*      */     
/*  189 */     initRows(this.worksheet);
/*  190 */     this.columnHelper = new ColumnHelper(this.worksheet);
/*      */     
/*  192 */     for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  193 */       POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  194 */       if (pOIXMLDocumentPart instanceof CommentsTable) {
/*  195 */         this.sheetComments = (CommentsTable)pOIXMLDocumentPart;
/*      */       }
/*  197 */       if (pOIXMLDocumentPart instanceof XSSFTable) {
/*  198 */         this.tables.put(relationPart.getRelationship().getId(), (XSSFTable)pOIXMLDocumentPart);
/*      */       }
/*  200 */       if (pOIXMLDocumentPart instanceof XSSFPivotTable) {
/*  201 */         getWorkbook().getPivotTables().add((XSSFPivotTable)pOIXMLDocumentPart);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  206 */     initHyperlinks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onDocumentCreate() {
/*  214 */     this.worksheet = newSheet();
/*  215 */     initRows(this.worksheet);
/*  216 */     this.columnHelper = new ColumnHelper(this.worksheet);
/*  217 */     this.hyperlinks = new ArrayList<XSSFHyperlink>();
/*      */   }
/*      */   
/*      */   private void initRows(CTWorksheet paramCTWorksheet) {
/*  221 */     this._rows.clear();
/*  222 */     this.tables = new TreeMap<String, XSSFTable>();
/*  223 */     this.sharedFormulas = new HashMap<Integer, CTCellFormula>();
/*  224 */     this.arrayFormulas = new ArrayList<CellRangeAddress>();
/*  225 */     for (CTRow cTRow : paramCTWorksheet.getSheetData().getRowArray()) {
/*  226 */       XSSFRow xSSFRow = new XSSFRow(cTRow, this);
/*      */       
/*  228 */       Integer integer = new Integer(xSSFRow.getRowNum());
/*  229 */       this._rows.put(integer, xSSFRow);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initHyperlinks() {
/*  238 */     this.hyperlinks = new ArrayList<XSSFHyperlink>();
/*      */     
/*  240 */     if (!this.worksheet.isSetHyperlinks())
/*      */       return; 
/*      */     try {
/*  243 */       PackageRelationshipCollection packageRelationshipCollection = getPackagePart().getRelationshipsByType(XSSFRelation.SHEET_HYPERLINKS.getRelation());
/*      */ 
/*      */ 
/*      */       
/*  247 */       for (CTHyperlink cTHyperlink : this.worksheet.getHyperlinks().getHyperlinkArray()) {
/*  248 */         PackageRelationship packageRelationship = null;
/*  249 */         if (cTHyperlink.getId() != null) {
/*  250 */           packageRelationship = packageRelationshipCollection.getRelationshipByID(cTHyperlink.getId());
/*      */         }
/*      */         
/*  253 */         this.hyperlinks.add(new XSSFHyperlink(cTHyperlink, packageRelationship));
/*      */       } 
/*  255 */     } catch (InvalidFormatException invalidFormatException) {
/*  256 */       throw new POIXMLException(invalidFormatException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CTWorksheet newSheet() {
/*  266 */     CTWorksheet cTWorksheet = CTWorksheet.Factory.newInstance();
/*  267 */     CTSheetFormatPr cTSheetFormatPr = cTWorksheet.addNewSheetFormatPr();
/*  268 */     cTSheetFormatPr.setDefaultRowHeight(15.0D);
/*      */     
/*  270 */     CTSheetView cTSheetView = cTWorksheet.addNewSheetViews().addNewSheetView();
/*  271 */     cTSheetView.setWorkbookViewId(0L);
/*      */     
/*  273 */     cTWorksheet.addNewDimension().setRef("A1");
/*      */     
/*  275 */     cTWorksheet.addNewSheetData();
/*      */     
/*  277 */     CTPageMargins cTPageMargins = cTWorksheet.addNewPageMargins();
/*  278 */     cTPageMargins.setBottom(0.75D);
/*  279 */     cTPageMargins.setFooter(0.3D);
/*  280 */     cTPageMargins.setHeader(0.3D);
/*  281 */     cTPageMargins.setLeft(0.7D);
/*  282 */     cTPageMargins.setRight(0.7D);
/*  283 */     cTPageMargins.setTop(0.75D);
/*      */     
/*  285 */     return cTWorksheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTWorksheet getCTWorksheet() {
/*  295 */     return this.worksheet;
/*      */   }
/*      */   
/*      */   public ColumnHelper getColumnHelper() {
/*  299 */     return this.columnHelper;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSheetName() {
/*  309 */     return this.sheet.getName();
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
/*      */   public int addMergedRegion(CellRangeAddress paramCellRangeAddress) {
/*  323 */     return addMergedRegion(paramCellRangeAddress, true);
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
/*      */   public int addMergedRegionUnsafe(CellRangeAddress paramCellRangeAddress) {
/*  341 */     return addMergedRegion(paramCellRangeAddress, false);
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
/*      */   private int addMergedRegion(CellRangeAddress paramCellRangeAddress, boolean paramBoolean) {
/*  357 */     if (paramCellRangeAddress.getNumberOfCells() < 2) {
/*  358 */       throw new IllegalArgumentException("Merged region " + paramCellRangeAddress.formatAsString() + " must contain 2 or more cells");
/*      */     }
/*  360 */     paramCellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
/*      */     
/*  362 */     if (paramBoolean) {
/*      */ 
/*      */       
/*  365 */       validateArrayFormulas(paramCellRangeAddress);
/*      */ 
/*      */ 
/*      */       
/*  369 */       validateMergedRegions(paramCellRangeAddress);
/*      */     } 
/*      */     
/*  372 */     CTMergeCells cTMergeCells = this.worksheet.isSetMergeCells() ? this.worksheet.getMergeCells() : this.worksheet.addNewMergeCells();
/*  373 */     CTMergeCell cTMergeCell = cTMergeCells.addNewMergeCell();
/*  374 */     cTMergeCell.setRef(paramCellRangeAddress.formatAsString());
/*  375 */     return cTMergeCells.sizeOfMergeCellArray();
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
/*      */   private void validateArrayFormulas(CellRangeAddress paramCellRangeAddress) {
/*  387 */     int i = paramCellRangeAddress.getFirstRow();
/*  388 */     int j = paramCellRangeAddress.getFirstColumn();
/*  389 */     int k = paramCellRangeAddress.getLastRow();
/*  390 */     int m = paramCellRangeAddress.getLastColumn();
/*      */     
/*  392 */     for (int n = i; n <= k; n++) {
/*  393 */       XSSFRow xSSFRow = getRow(n);
/*  394 */       if (xSSFRow != null)
/*      */       {
/*  396 */         for (int i1 = j; i1 <= m; i1++) {
/*  397 */           XSSFCell xSSFCell = xSSFRow.getCell(i1);
/*  398 */           if (xSSFCell != null)
/*      */           {
/*  400 */             if (xSSFCell.isPartOfArrayFormulaGroup()) {
/*  401 */               CellRangeAddress cellRangeAddress = xSSFCell.getArrayFormulaRange();
/*  402 */               if (cellRangeAddress.getNumberOfCells() > 1 && paramCellRangeAddress.intersects((CellRangeAddressBase)cellRangeAddress)) {
/*  403 */                 String str = "The range " + paramCellRangeAddress.formatAsString() + " intersects with a multi-cell array formula. " + "You cannot merge cells of an array.";
/*      */                 
/*  405 */                 throw new IllegalStateException(str);
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkForMergedRegionsIntersectingArrayFormulas() {
/*  418 */     for (CellRangeAddress cellRangeAddress : getMergedRegions()) {
/*  419 */       validateArrayFormulas(cellRangeAddress);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void validateMergedRegions(CellRangeAddress paramCellRangeAddress) {
/*  430 */     for (CellRangeAddress cellRangeAddress : getMergedRegions()) {
/*  431 */       if (cellRangeAddress.intersects((CellRangeAddressBase)paramCellRangeAddress)) {
/*  432 */         throw new IllegalStateException("Cannot add merged region " + paramCellRangeAddress.formatAsString() + " to sheet because it overlaps with an existing merged region (" + cellRangeAddress.formatAsString() + ").");
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
/*      */   private void checkForIntersectingMergedRegions() {
/*  444 */     List<CellRangeAddress> list = getMergedRegions();
/*  445 */     int i = list.size();
/*  446 */     for (byte b = 0; b < i; b++) {
/*  447 */       CellRangeAddress cellRangeAddress = list.get(b);
/*  448 */       for (CellRangeAddress cellRangeAddress1 : list.subList(b + 1, list.size())) {
/*  449 */         if (cellRangeAddress.intersects((CellRangeAddressBase)cellRangeAddress1)) {
/*  450 */           String str = "The range " + cellRangeAddress.formatAsString() + " intersects with another merged region " + cellRangeAddress1.formatAsString() + " in this sheet";
/*      */ 
/*      */           
/*  453 */           throw new IllegalStateException(str);
/*      */         } 
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
/*      */ 
/*      */   
/*      */   public void validateMergedRegions() {
/*  468 */     checkForMergedRegionsIntersectingArrayFormulas();
/*  469 */     checkForIntersectingMergedRegions();
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
/*      */   public void autoSizeColumn(int paramInt) {
/*  483 */     autoSizeColumn(paramInt, false);
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
/*      */   public void autoSizeColumn(int paramInt, boolean paramBoolean) {
/*  501 */     double d = SheetUtil.getColumnWidth(this, paramInt, paramBoolean);
/*      */     
/*  503 */     if (d != -1.0D) {
/*  504 */       d *= 256.0D;
/*  505 */       char c = '＀';
/*  506 */       if (d > c) {
/*  507 */         d = c;
/*      */       }
/*  509 */       setColumnWidth(paramInt, (int)d);
/*  510 */       this.columnHelper.setColBestFit(paramInt, true);
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
/*      */   public XSSFDrawing getDrawingPatriarch() {
/*  523 */     CTDrawing cTDrawing = getCTDrawing();
/*  524 */     if (cTDrawing != null) {
/*      */       
/*  526 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  527 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  528 */         if (pOIXMLDocumentPart instanceof XSSFDrawing) {
/*  529 */           XSSFDrawing xSSFDrawing = (XSSFDrawing)pOIXMLDocumentPart;
/*  530 */           String str = relationPart.getRelationship().getId();
/*  531 */           if (str.equals(cTDrawing.getId())) {
/*  532 */             return xSSFDrawing;
/*      */           }
/*      */           break;
/*      */         } 
/*      */       } 
/*  537 */       logger.log(7, new Object[] { "Can't find drawing with id=" + cTDrawing.getId() + " in the list of the sheet's relationships" });
/*      */     } 
/*  539 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFDrawing createDrawingPatriarch() {
/*  549 */     CTDrawing cTDrawing = getCTDrawing();
/*  550 */     if (cTDrawing != null) {
/*  551 */       return getDrawingPatriarch();
/*      */     }
/*      */ 
/*      */     
/*  555 */     int i = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.DRAWINGS.getContentType()).size() + 1;
/*  556 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSSFRelation.DRAWINGS, XSSFFactory.getInstance(), i, false);
/*  557 */     XSSFDrawing xSSFDrawing = (XSSFDrawing)relationPart.getDocumentPart();
/*  558 */     String str = relationPart.getRelationship().getId();
/*      */ 
/*      */ 
/*      */     
/*  562 */     cTDrawing = this.worksheet.addNewDrawing();
/*  563 */     cTDrawing.setId(str);
/*      */ 
/*      */     
/*  566 */     return xSSFDrawing;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected XSSFVMLDrawing getVMLDrawing(boolean paramBoolean) {
/*  577 */     XSSFVMLDrawing xSSFVMLDrawing = null;
/*  578 */     CTLegacyDrawing cTLegacyDrawing = getCTLegacyDrawing();
/*  579 */     if (cTLegacyDrawing == null) {
/*  580 */       if (paramBoolean) {
/*      */         
/*  582 */         int i = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.VML_DRAWINGS.getContentType()).size() + 1;
/*  583 */         POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSSFRelation.VML_DRAWINGS, XSSFFactory.getInstance(), i, false);
/*  584 */         xSSFVMLDrawing = (XSSFVMLDrawing)relationPart.getDocumentPart();
/*  585 */         String str = relationPart.getRelationship().getId();
/*      */ 
/*      */ 
/*      */         
/*  589 */         cTLegacyDrawing = this.worksheet.addNewLegacyDrawing();
/*  590 */         cTLegacyDrawing.setId(str);
/*      */       } 
/*      */     } else {
/*      */       
/*  594 */       String str = cTLegacyDrawing.getId();
/*  595 */       for (POIXMLDocumentPart.RelationPart relationPart : getRelationParts()) {
/*  596 */         POIXMLDocumentPart pOIXMLDocumentPart = relationPart.getDocumentPart();
/*  597 */         if (pOIXMLDocumentPart instanceof XSSFVMLDrawing) {
/*  598 */           XSSFVMLDrawing xSSFVMLDrawing1 = (XSSFVMLDrawing)pOIXMLDocumentPart;
/*  599 */           String str1 = relationPart.getRelationship().getId();
/*  600 */           if (str1.equals(str)) {
/*  601 */             xSSFVMLDrawing = xSSFVMLDrawing1;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*  607 */       if (xSSFVMLDrawing == null) {
/*  608 */         logger.log(7, new Object[] { "Can't find VML drawing with id=" + str + " in the list of the sheet's relationships" });
/*      */       }
/*      */     } 
/*  611 */     return xSSFVMLDrawing;
/*      */   }
/*      */   
/*      */   protected CTDrawing getCTDrawing() {
/*  615 */     return this.worksheet.getDrawing();
/*      */   }
/*      */   protected CTLegacyDrawing getCTLegacyDrawing() {
/*  618 */     return this.worksheet.getLegacyDrawing();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void createFreezePane(int paramInt1, int paramInt2) {
/*  628 */     createFreezePane(paramInt1, paramInt2, paramInt1, paramInt2);
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
/*      */   public void createFreezePane(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  645 */     CTSheetView cTSheetView = getDefaultSheetView();
/*      */ 
/*      */     
/*  648 */     if (paramInt1 == 0 && paramInt2 == 0) {
/*  649 */       if (cTSheetView.isSetPane()) cTSheetView.unsetPane(); 
/*  650 */       cTSheetView.setSelectionArray(null);
/*      */       
/*      */       return;
/*      */     } 
/*  654 */     if (!cTSheetView.isSetPane()) {
/*  655 */       cTSheetView.addNewPane();
/*      */     }
/*  657 */     CTPane cTPane = cTSheetView.getPane();
/*      */     
/*  659 */     if (paramInt1 > 0)
/*  660 */     { cTPane.setXSplit(paramInt1); }
/*      */     
/*  662 */     else if (cTPane.isSetXSplit()) { cTPane.unsetXSplit(); }
/*      */     
/*  664 */     if (paramInt2 > 0)
/*  665 */     { cTPane.setYSplit(paramInt2); }
/*      */     
/*  667 */     else if (cTPane.isSetYSplit()) { cTPane.unsetYSplit(); }
/*      */ 
/*      */     
/*  670 */     cTPane.setState(STPaneState.FROZEN);
/*  671 */     if (paramInt2 == 0) {
/*  672 */       cTPane.setTopLeftCell((new CellReference(0, paramInt3)).formatAsString());
/*  673 */       cTPane.setActivePane(STPane.TOP_RIGHT);
/*  674 */     } else if (paramInt1 == 0) {
/*  675 */       cTPane.setTopLeftCell((new CellReference(paramInt4, 0)).formatAsString());
/*  676 */       cTPane.setActivePane(STPane.BOTTOM_LEFT);
/*      */     } else {
/*  678 */       cTPane.setTopLeftCell((new CellReference(paramInt4, paramInt3)).formatAsString());
/*  679 */       cTPane.setActivePane(STPane.BOTTOM_RIGHT);
/*      */     } 
/*      */     
/*  682 */     cTSheetView.setSelectionArray(null);
/*  683 */     CTSelection cTSelection = cTSheetView.addNewSelection();
/*  684 */     cTSelection.setPane(cTPane.getActivePane());
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
/*      */   public XSSFRow createRow(int paramInt) {
/*      */     CTRow cTRow;
/*  700 */     Integer integer = new Integer(paramInt);
/*      */     
/*  702 */     XSSFRow xSSFRow1 = this._rows.get(integer);
/*  703 */     if (xSSFRow1 != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  709 */       while (xSSFRow1.getFirstCellNum() != -1) {
/*  710 */         xSSFRow1.removeCell(xSSFRow1.getCell(xSSFRow1.getFirstCellNum()));
/*      */       }
/*      */       
/*  713 */       cTRow = xSSFRow1.getCTRow();
/*  714 */       cTRow.set((XmlObject)CTRow.Factory.newInstance());
/*      */     }
/*  716 */     else if (this._rows.isEmpty() || paramInt > ((Integer)this._rows.lastKey()).intValue()) {
/*      */       
/*  718 */       cTRow = this.worksheet.getSheetData().addNewRow();
/*      */     }
/*      */     else {
/*      */       
/*  722 */       int i = this._rows.headMap(integer).size();
/*  723 */       cTRow = this.worksheet.getSheetData().insertNewRow(i);
/*      */     } 
/*      */     
/*  726 */     XSSFRow xSSFRow2 = new XSSFRow(cTRow, this);
/*  727 */     xSSFRow2.setRowNum(paramInt);
/*  728 */     this._rows.put(integer, xSSFRow2);
/*  729 */     return xSSFRow2;
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
/*      */   public void createSplitPane(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/*  747 */     createFreezePane(paramInt1, paramInt2, paramInt3, paramInt4);
/*  748 */     getPane().setState(STPaneState.SPLIT);
/*  749 */     getPane().setActivePane(STPane.Enum.forInt(paramInt5));
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
/*      */   public XSSFComment getCellComment(int paramInt1, int paramInt2) {
/*  761 */     return getCellComment(new CellAddress(paramInt1, paramInt2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFComment getCellComment(CellAddress paramCellAddress) {
/*  772 */     if (this.sheetComments == null) {
/*  773 */       return null;
/*      */     }
/*      */     
/*  776 */     int i = paramCellAddress.getRow();
/*  777 */     int j = paramCellAddress.getColumn();
/*      */     
/*  779 */     CellAddress cellAddress = new CellAddress(i, j);
/*  780 */     CTComment cTComment = this.sheetComments.getCTComment(cellAddress);
/*  781 */     if (cTComment == null) return null;
/*      */     
/*  783 */     XSSFVMLDrawing xSSFVMLDrawing = getVMLDrawing(false);
/*  784 */     return new XSSFComment(this.sheetComments, cTComment, (xSSFVMLDrawing == null) ? null : xSSFVMLDrawing.findCommentShape(i, j));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<CellAddress, XSSFComment> getCellComments() {
/*  795 */     if (this.sheetComments == null) {
/*  796 */       return Collections.emptyMap();
/*      */     }
/*  798 */     return this.sheetComments.getCellComments();
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
/*      */   public XSSFHyperlink getHyperlink(int paramInt1, int paramInt2) {
/*  810 */     return getHyperlink(new CellAddress(paramInt1, paramInt2));
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
/*      */   public XSSFHyperlink getHyperlink(CellAddress paramCellAddress) {
/*  822 */     String str = paramCellAddress.formatAsString();
/*  823 */     for (XSSFHyperlink xSSFHyperlink : this.hyperlinks) {
/*  824 */       if (xSSFHyperlink.getCellRef().equals(str)) {
/*  825 */         return xSSFHyperlink;
/*      */       }
/*      */     } 
/*  828 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFHyperlink> getHyperlinkList() {
/*  838 */     return Collections.unmodifiableList(this.hyperlinks);
/*      */   }
/*      */   
/*      */   private int[] getBreaks(CTPageBreak paramCTPageBreak) {
/*  842 */     CTBreak[] arrayOfCTBreak = paramCTPageBreak.getBrkArray();
/*  843 */     int[] arrayOfInt = new int[arrayOfCTBreak.length];
/*  844 */     for (byte b = 0; b < arrayOfCTBreak.length; b++) {
/*  845 */       arrayOfInt[b] = (int)arrayOfCTBreak[b].getId() - 1;
/*      */     }
/*  847 */     return arrayOfInt;
/*      */   }
/*      */   
/*      */   private void removeBreak(int paramInt, CTPageBreak paramCTPageBreak) {
/*  851 */     int i = paramInt + 1;
/*  852 */     CTBreak[] arrayOfCTBreak = paramCTPageBreak.getBrkArray();
/*  853 */     for (byte b = 0; b < arrayOfCTBreak.length; b++) {
/*  854 */       if (arrayOfCTBreak[b].getId() == i) {
/*  855 */         paramCTPageBreak.removeBrk(b);
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
/*      */ 
/*      */   
/*      */   public int[] getColumnBreaks() {
/*  869 */     return this.worksheet.isSetColBreaks() ? getBreaks(this.worksheet.getColBreaks()) : new int[0];
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
/*      */   public int getColumnWidth(int paramInt) {
/*  887 */     CTCol cTCol = this.columnHelper.getColumn(paramInt, false);
/*  888 */     double d = (cTCol == null || !cTCol.isSetWidth()) ? getDefaultColumnWidth() : cTCol.getWidth();
/*  889 */     return (int)(d * 256.0D);
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
/*      */   public float getColumnWidthInPixels(int paramInt) {
/*  902 */     float f = getColumnWidth(paramInt);
/*  903 */     return (float)(f / 256.0D * 7.001699924468994D);
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
/*      */   public int getDefaultColumnWidth() {
/*  917 */     CTSheetFormatPr cTSheetFormatPr = this.worksheet.getSheetFormatPr();
/*  918 */     return (cTSheetFormatPr == null) ? 8 : (int)cTSheetFormatPr.getBaseColWidth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getDefaultRowHeight() {
/*  929 */     return (short)(int)(getDefaultRowHeightInPoints() * 20.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getDefaultRowHeightInPoints() {
/*  940 */     CTSheetFormatPr cTSheetFormatPr = this.worksheet.getSheetFormatPr();
/*  941 */     return (float)((cTSheetFormatPr == null) ? 0.0D : cTSheetFormatPr.getDefaultRowHeight());
/*      */   }
/*      */   
/*      */   private CTSheetFormatPr getSheetTypeSheetFormatPr() {
/*  945 */     return this.worksheet.isSetSheetFormatPr() ? this.worksheet.getSheetFormatPr() : this.worksheet.addNewSheetFormatPr();
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
/*      */   public CellStyle getColumnStyle(int paramInt) {
/*  957 */     int i = this.columnHelper.getColDefaultStyle(paramInt);
/*  958 */     return getWorkbook().getCellStyleAt((short)((i == -1) ? 0 : i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRightToLeft(boolean paramBoolean) {
/*  968 */     CTSheetView cTSheetView = getDefaultSheetView();
/*  969 */     cTSheetView.setRightToLeft(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRightToLeft() {
/*  979 */     CTSheetView cTSheetView = getDefaultSheetView();
/*  980 */     return (cTSheetView != null && cTSheetView.getRightToLeft());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getDisplayGuts() {
/*  991 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/*  992 */     CTOutlinePr cTOutlinePr = (cTSheetPr.getOutlinePr() == null) ? CTOutlinePr.Factory.newInstance() : cTSheetPr.getOutlinePr();
/*  993 */     return cTOutlinePr.getShowOutlineSymbols();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGuts(boolean paramBoolean) {
/* 1003 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/* 1004 */     CTOutlinePr cTOutlinePr = (cTSheetPr.getOutlinePr() == null) ? cTSheetPr.addNewOutlinePr() : cTSheetPr.getOutlinePr();
/* 1005 */     cTOutlinePr.setShowOutlineSymbols(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayZeros() {
/* 1016 */     CTSheetView cTSheetView = getDefaultSheetView();
/* 1017 */     return (cTSheetView == null || cTSheetView.getShowZeros());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayZeros(boolean paramBoolean) {
/* 1028 */     CTSheetView cTSheetView = getSheetTypeSheetView();
/* 1029 */     cTSheetView.setShowZeros(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstRowNum() {
/* 1039 */     return this._rows.isEmpty() ? 0 : ((Integer)this._rows.firstKey()).intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getFitToPage() {
/* 1049 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/* 1050 */     CTPageSetUpPr cTPageSetUpPr = (cTSheetPr == null || !cTSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : cTSheetPr.getPageSetUpPr();
/*      */     
/* 1052 */     return cTPageSetUpPr.getFitToPage();
/*      */   }
/*      */   
/*      */   private CTSheetPr getSheetTypeSheetPr() {
/* 1056 */     if (this.worksheet.getSheetPr() == null) {
/* 1057 */       this.worksheet.setSheetPr(CTSheetPr.Factory.newInstance());
/*      */     }
/* 1059 */     return this.worksheet.getSheetPr();
/*      */   }
/*      */   
/*      */   private CTHeaderFooter getSheetTypeHeaderFooter() {
/* 1063 */     if (this.worksheet.getHeaderFooter() == null) {
/* 1064 */       this.worksheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
/*      */     }
/* 1066 */     return this.worksheet.getHeaderFooter();
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
/*      */   public Footer getFooter() {
/* 1082 */     return getOddFooter();
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
/*      */   public Header getHeader() {
/* 1096 */     return getOddHeader();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Footer getOddFooter() {
/* 1105 */     return new XSSFOddFooter(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Footer getEvenFooter() {
/* 1112 */     return new XSSFEvenFooter(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Footer getFirstFooter() {
/* 1119 */     return new XSSFFirstFooter(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Header getOddHeader() {
/* 1128 */     return new XSSFOddHeader(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Header getEvenHeader() {
/* 1135 */     return new XSSFEvenHeader(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Header getFirstHeader() {
/* 1142 */     return new XSSFFirstHeader(getSheetTypeHeaderFooter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getHorizontallyCenter() {
/* 1151 */     CTPrintOptions cTPrintOptions = this.worksheet.getPrintOptions();
/* 1152 */     return (cTPrintOptions != null && cTPrintOptions.getHorizontalCentered());
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLastRowNum() {
/* 1157 */     return this._rows.isEmpty() ? 0 : ((Integer)this._rows.lastKey()).intValue();
/*      */   }
/*      */ 
/*      */   
/*      */   public short getLeftCol() {
/* 1162 */     String str = this.worksheet.getSheetViews().getSheetViewArray(0).getTopLeftCell();
/* 1163 */     if (str == null) {
/* 1164 */       return 0;
/*      */     }
/* 1166 */     CellReference cellReference = new CellReference(str);
/* 1167 */     return cellReference.getCol();
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
/*      */   public double getMargin(short paramShort) {
/* 1184 */     if (!this.worksheet.isSetPageMargins()) return 0.0D;
/*      */     
/* 1186 */     CTPageMargins cTPageMargins = this.worksheet.getPageMargins();
/* 1187 */     switch (paramShort) {
/*      */       case 0:
/* 1189 */         return cTPageMargins.getLeft();
/*      */       case 1:
/* 1191 */         return cTPageMargins.getRight();
/*      */       case 2:
/* 1193 */         return cTPageMargins.getTop();
/*      */       case 3:
/* 1195 */         return cTPageMargins.getBottom();
/*      */       case 4:
/* 1197 */         return cTPageMargins.getHeader();
/*      */       case 5:
/* 1199 */         return cTPageMargins.getFooter();
/*      */     } 
/* 1201 */     throw new IllegalArgumentException("Unknown margin constant:  " + paramShort);
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
/*      */   public void setMargin(short paramShort, double paramDouble) {
/* 1219 */     CTPageMargins cTPageMargins = this.worksheet.isSetPageMargins() ? this.worksheet.getPageMargins() : this.worksheet.addNewPageMargins();
/*      */     
/* 1221 */     switch (paramShort) {
/*      */       case 0:
/* 1223 */         cTPageMargins.setLeft(paramDouble);
/*      */         return;
/*      */       case 1:
/* 1226 */         cTPageMargins.setRight(paramDouble);
/*      */         return;
/*      */       case 2:
/* 1229 */         cTPageMargins.setTop(paramDouble);
/*      */         return;
/*      */       case 3:
/* 1232 */         cTPageMargins.setBottom(paramDouble);
/*      */         return;
/*      */       case 4:
/* 1235 */         cTPageMargins.setHeader(paramDouble);
/*      */         return;
/*      */       case 5:
/* 1238 */         cTPageMargins.setFooter(paramDouble);
/*      */         return;
/*      */     } 
/* 1241 */     throw new IllegalArgumentException("Unknown margin constant:  " + paramShort);
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
/*      */   public CellRangeAddress getMergedRegion(int paramInt) {
/* 1254 */     CTMergeCells cTMergeCells = this.worksheet.getMergeCells();
/* 1255 */     if (cTMergeCells == null) throw new IllegalStateException("This worksheet does not contain merged regions");
/*      */     
/* 1257 */     CTMergeCell cTMergeCell = cTMergeCells.getMergeCellArray(paramInt);
/* 1258 */     String str = cTMergeCell.getRef();
/* 1259 */     return CellRangeAddress.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<CellRangeAddress> getMergedRegions() {
/* 1270 */     ArrayList<CellRangeAddress> arrayList = new ArrayList();
/* 1271 */     CTMergeCells cTMergeCells = this.worksheet.getMergeCells();
/* 1272 */     if (cTMergeCells == null) return arrayList;
/*      */     
/* 1274 */     for (CTMergeCell cTMergeCell : cTMergeCells.getMergeCellArray()) {
/* 1275 */       String str = cTMergeCell.getRef();
/* 1276 */       arrayList.add(CellRangeAddress.valueOf(str));
/*      */     } 
/* 1278 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumMergedRegions() {
/* 1288 */     CTMergeCells cTMergeCells = this.worksheet.getMergeCells();
/* 1289 */     return (cTMergeCells == null) ? 0 : cTMergeCells.sizeOfMergeCellArray();
/*      */   }
/*      */   
/*      */   public int getNumHyperlinks() {
/* 1293 */     return this.hyperlinks.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaneInformation getPaneInformation() {
/* 1303 */     CTPane cTPane = getDefaultSheetView().getPane();
/*      */     
/* 1305 */     if (cTPane == null) return null;
/*      */     
/* 1307 */     CellReference cellReference = cTPane.isSetTopLeftCell() ? new CellReference(cTPane.getTopLeftCell()) : null;
/* 1308 */     return new PaneInformation((short)(int)cTPane.getXSplit(), (short)(int)cTPane.getYSplit(), (short)((cellReference == null) ? 0 : cellReference.getRow()), (cellReference == null) ? 0 : cellReference.getCol(), (byte)(cTPane.getActivePane().intValue() - 1), (cTPane.getState() == STPaneState.FROZEN));
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
/*      */   public int getPhysicalNumberOfRows() {
/* 1320 */     return this._rows.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFPrintSetup getPrintSetup() {
/* 1330 */     return new XSSFPrintSetup(this.worksheet);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getProtect() {
/* 1340 */     return isSheetLocked();
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
/*      */   public void protectSheet(String paramString) {
/* 1352 */     if (paramString != null) {
/* 1353 */       CTSheetProtection cTSheetProtection = safeGetProtectionField();
/* 1354 */       setSheetPassword(paramString, (HashAlgorithm)null);
/* 1355 */       cTSheetProtection.setSheet(true);
/* 1356 */       cTSheetProtection.setScenarios(true);
/* 1357 */       cTSheetProtection.setObjects(true);
/*      */     } else {
/* 1359 */       this.worksheet.unsetSheetProtection();
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
/*      */   public void setSheetPassword(String paramString, HashAlgorithm paramHashAlgorithm) {
/* 1371 */     if (paramString == null && !isSheetProtectionEnabled()) {
/*      */       return;
/*      */     }
/* 1374 */     XSSFPasswordHelper.setPassword((XmlObject)safeGetProtectionField(), paramString, paramHashAlgorithm, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean validateSheetPassword(String paramString) {
/* 1383 */     if (!isSheetProtectionEnabled()) {
/* 1384 */       return (paramString == null);
/*      */     }
/* 1386 */     return XSSFPasswordHelper.validatePassword((XmlObject)safeGetProtectionField(), paramString, null);
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
/*      */   public XSSFRow getRow(int paramInt) {
/* 1399 */     Integer integer = new Integer(paramInt);
/* 1400 */     return this._rows.get(integer);
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
/*      */   private List<XSSFRow> getRows(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 1415 */     if (paramInt1 > paramInt2) {
/* 1416 */       throw new IllegalArgumentException("getRows: startRowNum must be less than or equal to endRowNum");
/*      */     }
/* 1418 */     ArrayList<XSSFRow> arrayList = new ArrayList();
/* 1419 */     if (paramBoolean) {
/* 1420 */       for (int i = paramInt1; i <= paramInt2; i++) {
/* 1421 */         XSSFRow xSSFRow = getRow(i);
/* 1422 */         if (xSSFRow == null) {
/* 1423 */           xSSFRow = createRow(i);
/*      */         }
/* 1425 */         arrayList.add(xSSFRow);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1430 */       Integer integer1 = new Integer(paramInt1);
/* 1431 */       Integer integer2 = new Integer(paramInt2 + 1);
/* 1432 */       Collection<? extends XSSFRow> collection = this._rows.subMap(integer1, integer2).values();
/* 1433 */       arrayList.addAll(collection);
/*      */     } 
/* 1435 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int[] getRowBreaks() {
/* 1446 */     return this.worksheet.isSetRowBreaks() ? getBreaks(this.worksheet.getRowBreaks()) : new int[0];
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
/*      */   public boolean getRowSumsBelow() {
/* 1465 */     CTSheetPr cTSheetPr = this.worksheet.getSheetPr();
/* 1466 */     CTOutlinePr cTOutlinePr = (cTSheetPr != null && cTSheetPr.isSetOutlinePr()) ? cTSheetPr.getOutlinePr() : null;
/*      */     
/* 1468 */     return (cTOutlinePr == null || cTOutlinePr.getSummaryBelow());
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
/*      */   public void setRowSumsBelow(boolean paramBoolean) {
/* 1486 */     ensureOutlinePr().setSummaryBelow(paramBoolean);
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
/*      */   public boolean getRowSumsRight() {
/* 1504 */     CTSheetPr cTSheetPr = this.worksheet.getSheetPr();
/* 1505 */     CTOutlinePr cTOutlinePr = (cTSheetPr != null && cTSheetPr.isSetOutlinePr()) ? cTSheetPr.getOutlinePr() : CTOutlinePr.Factory.newInstance();
/*      */     
/* 1507 */     return cTOutlinePr.getSummaryRight();
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
/*      */   public void setRowSumsRight(boolean paramBoolean) {
/* 1525 */     ensureOutlinePr().setSummaryRight(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CTOutlinePr ensureOutlinePr() {
/* 1533 */     CTSheetPr cTSheetPr = this.worksheet.isSetSheetPr() ? this.worksheet.getSheetPr() : this.worksheet.addNewSheetPr();
/* 1534 */     return cTSheetPr.isSetOutlinePr() ? cTSheetPr.getOutlinePr() : cTSheetPr.addNewOutlinePr();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getScenarioProtect() {
/* 1544 */     return (this.worksheet.isSetSheetProtection() && this.worksheet.getSheetProtection().getScenarios());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getTopRow() {
/* 1555 */     String str = getSheetTypeSheetView().getTopLeftCell();
/* 1556 */     if (str == null) {
/* 1557 */       return 0;
/*      */     }
/* 1559 */     CellReference cellReference = new CellReference(str);
/* 1560 */     return (short)cellReference.getRow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getVerticallyCenter() {
/* 1570 */     CTPrintOptions cTPrintOptions = this.worksheet.getPrintOptions();
/* 1571 */     return (cTPrintOptions != null && cTPrintOptions.getVerticalCentered());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void groupColumn(int paramInt1, int paramInt2) {
/* 1579 */     groupColumn1Based(paramInt1 + 1, paramInt2 + 1);
/*      */   }
/*      */   private void groupColumn1Based(int paramInt1, int paramInt2) {
/* 1582 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 1583 */     CTCol cTCol1 = CTCol.Factory.newInstance();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1588 */     CTCol cTCol2 = this.columnHelper.getColumn1Based(paramInt2, false);
/* 1589 */     if (cTCol2 != null) {
/* 1590 */       cTCol2 = (CTCol)cTCol2.copy();
/*      */     }
/*      */     
/* 1593 */     cTCol1.setMin(paramInt1);
/* 1594 */     cTCol1.setMax(paramInt2);
/* 1595 */     this.columnHelper.addCleanColIntoCols(cTCols, cTCol1);
/*      */     
/* 1597 */     CTCol cTCol3 = this.columnHelper.getColumn1Based(paramInt2, false);
/* 1598 */     if (cTCol2 != null && cTCol3 != null) {
/* 1599 */       this.columnHelper.setColumnAttributes(cTCol2, cTCol3);
/*      */     }
/*      */     
/* 1602 */     for (int i = paramInt1; i <= paramInt2; i++) {
/* 1603 */       CTCol cTCol = this.columnHelper.getColumn1Based(i, false);
/*      */       
/* 1605 */       short s = cTCol.getOutlineLevel();
/* 1606 */       cTCol.setOutlineLevel((short)(s + 1));
/* 1607 */       i = (int)cTCol.getMax();
/*      */     } 
/* 1609 */     this.worksheet.setColsArray(0, cTCols);
/* 1610 */     setSheetFormatPrOutlineLevelCol();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setColWidthAttribute(CTCols paramCTCols) {
/* 1617 */     for (CTCol cTCol : paramCTCols.getColArray()) {
/* 1618 */       if (!cTCol.isSetWidth()) {
/* 1619 */         cTCol.setWidth(getDefaultColumnWidth());
/* 1620 */         cTCol.setCustomWidth(false);
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
/*      */   
/*      */   public void groupRow(int paramInt1, int paramInt2) {
/* 1633 */     for (int i = paramInt1; i <= paramInt2; i++) {
/* 1634 */       XSSFRow xSSFRow = getRow(i);
/* 1635 */       if (xSSFRow == null) {
/* 1636 */         xSSFRow = createRow(i);
/*      */       }
/* 1638 */       CTRow cTRow = xSSFRow.getCTRow();
/* 1639 */       short s = cTRow.getOutlineLevel();
/* 1640 */       cTRow.setOutlineLevel((short)(s + 1));
/*      */     } 
/* 1642 */     setSheetFormatPrOutlineLevelRow();
/*      */   }
/*      */   
/*      */   private short getMaxOutlineLevelRows() {
/* 1646 */     int i = 0;
/* 1647 */     for (XSSFRow xSSFRow : this._rows.values()) {
/* 1648 */       i = Math.max(i, xSSFRow.getCTRow().getOutlineLevel());
/*      */     }
/* 1650 */     return (short)i;
/*      */   }
/*      */   
/*      */   private short getMaxOutlineLevelCols() {
/* 1654 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 1655 */     int i = 0;
/* 1656 */     for (CTCol cTCol : cTCols.getColArray()) {
/* 1657 */       i = Math.max(i, cTCol.getOutlineLevel());
/*      */     }
/* 1659 */     return (short)i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isColumnBroken(int paramInt) {
/* 1667 */     for (int i : getColumnBreaks()) {
/* 1668 */       if (i == paramInt) {
/* 1669 */         return true;
/*      */       }
/*      */     } 
/* 1672 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isColumnHidden(int paramInt) {
/* 1683 */     CTCol cTCol = this.columnHelper.getColumn(paramInt, false);
/* 1684 */     return (cTCol != null && cTCol.getHidden());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayFormulas() {
/* 1694 */     return getSheetTypeSheetView().getShowFormulas();
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
/*      */   public boolean isDisplayGridlines() {
/* 1706 */     return getSheetTypeSheetView().getShowGridLines();
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
/*      */   public void setDisplayGridlines(boolean paramBoolean) {
/* 1720 */     getSheetTypeSheetView().setShowGridLines(paramBoolean);
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
/*      */   public boolean isDisplayRowColHeadings() {
/* 1736 */     return getSheetTypeSheetView().getShowRowColHeaders();
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
/*      */   public void setDisplayRowColHeadings(boolean paramBoolean) {
/* 1752 */     getSheetTypeSheetView().setShowRowColHeaders(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintGridlines() {
/* 1762 */     CTPrintOptions cTPrintOptions = this.worksheet.getPrintOptions();
/* 1763 */     return (cTPrintOptions != null && cTPrintOptions.getGridLines());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintGridlines(boolean paramBoolean) {
/* 1773 */     CTPrintOptions cTPrintOptions = this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions();
/*      */     
/* 1775 */     cTPrintOptions.setGridLines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintRowAndColumnHeadings() {
/* 1785 */     CTPrintOptions cTPrintOptions = this.worksheet.getPrintOptions();
/* 1786 */     return (cTPrintOptions != null && cTPrintOptions.getHeadings());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintRowAndColumnHeadings(boolean paramBoolean) {
/* 1796 */     CTPrintOptions cTPrintOptions = this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions();
/*      */     
/* 1798 */     cTPrintOptions.setHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRowBroken(int paramInt) {
/* 1809 */     for (int i : getRowBreaks()) {
/* 1810 */       if (i == paramInt) {
/* 1811 */         return true;
/*      */       }
/*      */     } 
/* 1814 */     return false;
/*      */   }
/*      */   
/*      */   private void setBreak(int paramInt1, CTPageBreak paramCTPageBreak, int paramInt2) {
/* 1818 */     CTBreak cTBreak = paramCTPageBreak.addNewBrk();
/* 1819 */     cTBreak.setId((paramInt1 + 1));
/* 1820 */     cTBreak.setMan(true);
/* 1821 */     cTBreak.setMax(paramInt2);
/*      */     
/* 1823 */     int i = paramCTPageBreak.sizeOfBrkArray();
/* 1824 */     paramCTPageBreak.setCount(i);
/* 1825 */     paramCTPageBreak.setManualBreakCount(i);
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
/*      */   public void setRowBreak(int paramInt) {
/* 1841 */     if (!isRowBroken(paramInt)) {
/* 1842 */       CTPageBreak cTPageBreak = this.worksheet.isSetRowBreaks() ? this.worksheet.getRowBreaks() : this.worksheet.addNewRowBreaks();
/* 1843 */       setBreak(paramInt, cTPageBreak, SpreadsheetVersion.EXCEL2007.getLastColumnIndex());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeColumnBreak(int paramInt) {
/* 1852 */     if (this.worksheet.isSetColBreaks()) {
/* 1853 */       removeBreak(paramInt, this.worksheet.getColBreaks());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMergedRegion(int paramInt) {
/* 1864 */     if (!this.worksheet.isSetMergeCells())
/*      */       return; 
/* 1866 */     CTMergeCells cTMergeCells = this.worksheet.getMergeCells();
/* 1867 */     int i = cTMergeCells.sizeOfMergeCellArray();
/* 1868 */     assert 0 <= paramInt && paramInt < i;
/* 1869 */     if (i > 1) {
/* 1870 */       cTMergeCells.removeMergeCell(paramInt);
/*      */     } else {
/* 1872 */       this.worksheet.unsetMergeCells();
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
/*      */   public void removeMergedRegions(Collection<Integer> paramCollection) {
/* 1887 */     if (!this.worksheet.isSetMergeCells())
/*      */       return; 
/* 1889 */     CTMergeCells cTMergeCells = this.worksheet.getMergeCells();
/* 1890 */     ArrayList<CTMergeCell> arrayList = new ArrayList(cTMergeCells.sizeOfMergeCellArray());
/*      */     
/* 1892 */     byte b = 0;
/* 1893 */     for (CTMergeCell cTMergeCell : cTMergeCells.getMergeCellArray()) {
/* 1894 */       if (!paramCollection.contains(Integer.valueOf(b++))) {
/* 1895 */         arrayList.add(cTMergeCell);
/*      */       }
/*      */     } 
/*      */     
/* 1899 */     if (arrayList.isEmpty()) {
/* 1900 */       this.worksheet.unsetMergeCells();
/*      */     } else {
/* 1902 */       CTMergeCell[] arrayOfCTMergeCell = new CTMergeCell[arrayList.size()];
/* 1903 */       cTMergeCells.setMergeCellArray(arrayList.<CTMergeCell>toArray(arrayOfCTMergeCell));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRow(Row paramRow) {
/* 1914 */     if (paramRow.getSheet() != this) {
/* 1915 */       throw new IllegalArgumentException("Specified row does not belong to this sheet");
/*      */     }
/*      */     
/* 1918 */     ArrayList<XSSFCell> arrayList = new ArrayList();
/* 1919 */     for (Cell cell : paramRow) {
/* 1920 */       arrayList.add((XSSFCell)cell);
/*      */     }
/*      */     
/* 1923 */     for (XSSFCell xSSFCell : arrayList) {
/* 1924 */       paramRow.removeCell(xSSFCell);
/*      */     }
/*      */ 
/*      */     
/* 1928 */     Integer integer = new Integer(paramRow.getRowNum());
/* 1929 */     int i = this._rows.headMap(integer).size();
/* 1930 */     this._rows.remove(integer);
/* 1931 */     this.worksheet.getSheetData().removeRow(i);
/*      */ 
/*      */     
/* 1934 */     if (this.sheetComments != null) {
/* 1935 */       for (CellAddress cellAddress : getCellComments().keySet()) {
/* 1936 */         if (cellAddress.getRow() == i) {
/* 1937 */           this.sheetComments.removeComment(cellAddress);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRowBreak(int paramInt) {
/* 1948 */     if (this.worksheet.isSetRowBreaks()) {
/* 1949 */       removeBreak(paramInt, this.worksheet.getRowBreaks());
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
/*      */   public void setForceFormulaRecalculation(boolean paramBoolean) {
/* 1975 */     CTCalcPr cTCalcPr = getWorkbook().getCTWorkbook().getCalcPr();
/*      */     
/* 1977 */     if (this.worksheet.isSetSheetCalcPr()) {
/*      */       
/* 1979 */       CTSheetCalcPr cTSheetCalcPr = this.worksheet.getSheetCalcPr();
/* 1980 */       cTSheetCalcPr.setFullCalcOnLoad(paramBoolean);
/*      */     }
/* 1982 */     else if (paramBoolean) {
/*      */       
/* 1984 */       CTSheetCalcPr cTSheetCalcPr = this.worksheet.addNewSheetCalcPr();
/* 1985 */       cTSheetCalcPr.setFullCalcOnLoad(paramBoolean);
/*      */     } 
/* 1987 */     if (paramBoolean && cTCalcPr != null && cTCalcPr.getCalcMode() == STCalcMode.MANUAL) {
/* 1988 */       cTCalcPr.setCalcMode(STCalcMode.AUTO);
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
/* 1999 */     if (this.worksheet.isSetSheetCalcPr()) {
/* 2000 */       CTSheetCalcPr cTSheetCalcPr = this.worksheet.getSheetCalcPr();
/* 2001 */       return cTSheetCalcPr.getFullCalcOnLoad();
/*      */     } 
/* 2003 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Row> rowIterator() {
/* 2014 */     return this._rows.values().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Row> iterator() {
/* 2023 */     return rowIterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAutobreaks() {
/* 2033 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/* 2034 */     CTPageSetUpPr cTPageSetUpPr = (cTSheetPr == null || !cTSheetPr.isSetPageSetUpPr()) ? CTPageSetUpPr.Factory.newInstance() : cTSheetPr.getPageSetUpPr();
/*      */     
/* 2036 */     return cTPageSetUpPr.getAutoPageBreaks();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutobreaks(boolean paramBoolean) {
/* 2046 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/* 2047 */     CTPageSetUpPr cTPageSetUpPr = cTSheetPr.isSetPageSetUpPr() ? cTSheetPr.getPageSetUpPr() : cTSheetPr.addNewPageSetUpPr();
/* 2048 */     cTPageSetUpPr.setAutoPageBreaks(paramBoolean);
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
/*      */   public void setColumnBreak(int paramInt) {
/* 2064 */     if (!isColumnBroken(paramInt)) {
/* 2065 */       CTPageBreak cTPageBreak = this.worksheet.isSetColBreaks() ? this.worksheet.getColBreaks() : this.worksheet.addNewColBreaks();
/* 2066 */       setBreak(paramInt, cTPageBreak, SpreadsheetVersion.EXCEL2007.getLastRowIndex());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColumnGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 2072 */     if (paramBoolean) {
/* 2073 */       collapseColumn(paramInt);
/*      */     } else {
/* 2075 */       expandColumn(paramInt);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void collapseColumn(int paramInt) {
/* 2080 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2081 */     CTCol cTCol1 = this.columnHelper.getColumn(paramInt, false);
/* 2082 */     int i = this.columnHelper.getIndexOfColumn(cTCols, cTCol1);
/* 2083 */     if (i == -1) {
/*      */       return;
/*      */     }
/*      */     
/* 2087 */     int j = findStartOfColumnOutlineGroup(i);
/*      */     
/* 2089 */     CTCol cTCol2 = cTCols.getColArray(j);
/*      */ 
/*      */     
/* 2092 */     int k = setGroupHidden(j, cTCol2.getOutlineLevel(), true);
/*      */ 
/*      */ 
/*      */     
/* 2096 */     setColumn(k + 1, Integer.valueOf(0), (Integer)null, (Boolean)null, Boolean.TRUE);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setColumn(int paramInt, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Boolean paramBoolean2) {
/* 2102 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2103 */     CTCol cTCol = null;
/* 2104 */     for (CTCol cTCol1 : cTCols.getColArray()) {
/* 2105 */       long l3 = cTCol1.getMin();
/* 2106 */       long l4 = cTCol1.getMax();
/* 2107 */       if (l3 >= paramInt && l4 <= paramInt) {
/* 2108 */         cTCol = cTCol1;
/*      */         break;
/*      */       } 
/* 2111 */       if (l3 > paramInt) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2117 */     if (cTCol == null) {
/*      */ 
/*      */       
/* 2120 */       CTCol cTCol1 = CTCol.Factory.newInstance();
/* 2121 */       cTCol1.setMin(paramInt);
/* 2122 */       cTCol1.setMax(paramInt);
/* 2123 */       unsetCollapsed(paramBoolean2.booleanValue(), cTCol1);
/* 2124 */       this.columnHelper.addCleanColIntoCols(cTCols, cTCol1);
/*      */       
/*      */       return;
/*      */     } 
/* 2128 */     boolean bool1 = (paramInteger1 != null && cTCol.getStyle() != paramInteger1.intValue()) ? true : false;
/* 2129 */     boolean bool2 = (paramInteger2 != null && cTCol.getOutlineLevel() != paramInteger2.intValue()) ? true : false;
/* 2130 */     boolean bool3 = (paramBoolean1 != null && cTCol.getHidden() != paramBoolean1.booleanValue()) ? true : false;
/* 2131 */     boolean bool4 = (paramBoolean2 != null && cTCol.getCollapsed() != paramBoolean2.booleanValue()) ? true : false;
/* 2132 */     boolean bool5 = (bool2 || bool3 || bool4 || bool1) ? true : false;
/* 2133 */     if (!bool5) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2138 */     long l1 = cTCol.getMin();
/* 2139 */     long l2 = cTCol.getMax();
/* 2140 */     if (l1 == paramInt && l2 == paramInt) {
/*      */       
/* 2142 */       unsetCollapsed(paramBoolean2.booleanValue(), cTCol);
/*      */       
/*      */       return;
/*      */     } 
/* 2146 */     if (l1 == paramInt || l2 == paramInt) {
/*      */ 
/*      */ 
/*      */       
/* 2150 */       if (l1 == paramInt) {
/* 2151 */         cTCol.setMin((paramInt + 1));
/*      */       } else {
/* 2153 */         cTCol.setMax((paramInt - 1));
/*      */       } 
/* 2155 */       CTCol cTCol1 = this.columnHelper.cloneCol(cTCols, cTCol);
/* 2156 */       cTCol1.setMin(paramInt);
/* 2157 */       unsetCollapsed(paramBoolean2.booleanValue(), cTCol1);
/* 2158 */       this.columnHelper.addCleanColIntoCols(cTCols, cTCol1);
/*      */     }
/*      */     else {
/*      */       
/* 2162 */       CTCol cTCol1 = this.columnHelper.cloneCol(cTCols, cTCol);
/* 2163 */       CTCol cTCol2 = this.columnHelper.cloneCol(cTCols, cTCol);
/* 2164 */       int i = (int)l2;
/*      */       
/* 2166 */       cTCol.setMax((paramInt - 1));
/*      */       
/* 2168 */       cTCol1.setMin(paramInt);
/* 2169 */       cTCol1.setMax(paramInt);
/* 2170 */       unsetCollapsed(paramBoolean2.booleanValue(), cTCol1);
/* 2171 */       this.columnHelper.addCleanColIntoCols(cTCols, cTCol1);
/*      */       
/* 2173 */       cTCol2.setMin((paramInt + 1));
/* 2174 */       cTCol2.setMax(i);
/* 2175 */       this.columnHelper.addCleanColIntoCols(cTCols, cTCol2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void unsetCollapsed(boolean paramBoolean, CTCol paramCTCol) {
/* 2180 */     if (paramBoolean) {
/* 2181 */       paramCTCol.setCollapsed(paramBoolean);
/*      */     } else {
/* 2183 */       paramCTCol.unsetCollapsed();
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
/*      */   private int setGroupHidden(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 2196 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2197 */     int i = paramInt1;
/* 2198 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2199 */     CTCol cTCol = arrayOfCTCol[i];
/* 2200 */     while (i < arrayOfCTCol.length) {
/* 2201 */       cTCol.setHidden(paramBoolean);
/* 2202 */       if (i + 1 < arrayOfCTCol.length) {
/* 2203 */         CTCol cTCol1 = arrayOfCTCol[i + 1];
/*      */         
/* 2205 */         if (!isAdjacentBefore(cTCol, cTCol1)) {
/*      */           break;
/*      */         }
/*      */         
/* 2209 */         if (cTCol1.getOutlineLevel() < paramInt2) {
/*      */           break;
/*      */         }
/* 2212 */         cTCol = cTCol1;
/*      */       } 
/* 2214 */       i++;
/*      */     } 
/* 2216 */     return (int)cTCol.getMax();
/*      */   }
/*      */   
/*      */   private boolean isAdjacentBefore(CTCol paramCTCol1, CTCol paramCTCol2) {
/* 2220 */     return (paramCTCol1.getMax() == paramCTCol2.getMin() - 1L);
/*      */   }
/*      */ 
/*      */   
/*      */   private int findStartOfColumnOutlineGroup(int paramInt) {
/* 2225 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2226 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2227 */     CTCol cTCol = arrayOfCTCol[paramInt];
/* 2228 */     short s = cTCol.getOutlineLevel();
/* 2229 */     int i = paramInt;
/* 2230 */     while (i != 0) {
/* 2231 */       CTCol cTCol1 = arrayOfCTCol[i - 1];
/* 2232 */       if (!isAdjacentBefore(cTCol1, cTCol)) {
/*      */         break;
/*      */       }
/* 2235 */       if (cTCol1.getOutlineLevel() < s) {
/*      */         break;
/*      */       }
/* 2238 */       i--;
/* 2239 */       cTCol = cTCol1;
/*      */     } 
/* 2241 */     return i;
/*      */   }
/*      */   
/*      */   private int findEndOfColumnOutlineGroup(int paramInt) {
/* 2245 */     CTCols cTCols = this.worksheet.getColsArray(0);
/*      */     
/* 2247 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2248 */     CTCol cTCol = arrayOfCTCol[paramInt];
/* 2249 */     short s = cTCol.getOutlineLevel();
/* 2250 */     int i = paramInt;
/* 2251 */     int j = arrayOfCTCol.length - 1;
/* 2252 */     while (i < j) {
/* 2253 */       CTCol cTCol1 = arrayOfCTCol[i + 1];
/* 2254 */       if (!isAdjacentBefore(cTCol, cTCol1)) {
/*      */         break;
/*      */       }
/* 2257 */       if (cTCol1.getOutlineLevel() < s) {
/*      */         break;
/*      */       }
/* 2260 */       i++;
/* 2261 */       cTCol = cTCol1;
/*      */     } 
/* 2263 */     return i;
/*      */   }
/*      */   
/*      */   private void expandColumn(int paramInt) {
/* 2267 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2268 */     CTCol cTCol1 = this.columnHelper.getColumn(paramInt, false);
/* 2269 */     int i = this.columnHelper.getIndexOfColumn(cTCols, cTCol1);
/*      */     
/* 2271 */     int j = findColInfoIdx((int)cTCol1.getMax(), i);
/* 2272 */     if (j == -1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2277 */     if (!isColumnGroupCollapsed(j)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2282 */     int k = findStartOfColumnOutlineGroup(j);
/* 2283 */     int m = findEndOfColumnOutlineGroup(j);
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
/* 2296 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2297 */     CTCol cTCol2 = arrayOfCTCol[m];
/* 2298 */     if (!isColumnGroupHiddenByParent(j)) {
/* 2299 */       short s = cTCol2.getOutlineLevel();
/* 2300 */       boolean bool = false;
/* 2301 */       for (int n = k; n <= m; n++) {
/* 2302 */         CTCol cTCol = arrayOfCTCol[n];
/* 2303 */         if (s == cTCol.getOutlineLevel()) {
/* 2304 */           cTCol.unsetHidden();
/* 2305 */           if (bool) {
/* 2306 */             bool = false;
/* 2307 */             cTCol.setCollapsed(true);
/*      */           } 
/*      */         } else {
/* 2310 */           bool = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2316 */     setColumn((int)cTCol2.getMax() + 1, (Integer)null, (Integer)null, Boolean.FALSE, Boolean.FALSE);
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean isColumnGroupHiddenByParent(int paramInt) {
/* 2321 */     CTCols cTCols = this.worksheet.getColsArray(0);
/*      */     
/* 2323 */     short s1 = 0;
/* 2324 */     boolean bool1 = false;
/* 2325 */     int i = findEndOfColumnOutlineGroup(paramInt);
/* 2326 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2327 */     if (i < arrayOfCTCol.length) {
/* 2328 */       CTCol cTCol = arrayOfCTCol[i + 1];
/* 2329 */       if (isAdjacentBefore(arrayOfCTCol[i], cTCol)) {
/* 2330 */         s1 = cTCol.getOutlineLevel();
/* 2331 */         bool1 = cTCol.getHidden();
/*      */       } 
/*      */     } 
/*      */     
/* 2335 */     short s2 = 0;
/* 2336 */     boolean bool2 = false;
/* 2337 */     int j = findStartOfColumnOutlineGroup(paramInt);
/* 2338 */     if (j > 0) {
/* 2339 */       CTCol cTCol = arrayOfCTCol[j - 1];
/*      */       
/* 2341 */       if (isAdjacentBefore(cTCol, arrayOfCTCol[j])) {
/* 2342 */         s2 = cTCol.getOutlineLevel();
/* 2343 */         bool2 = cTCol.getHidden();
/*      */       } 
/*      */     } 
/*      */     
/* 2347 */     if (s1 > s2) {
/* 2348 */       return bool1;
/*      */     }
/* 2350 */     return bool2;
/*      */   }
/*      */   
/*      */   private int findColInfoIdx(int paramInt1, int paramInt2) {
/* 2354 */     CTCols cTCols = this.worksheet.getColsArray(0);
/*      */     
/* 2356 */     if (paramInt1 < 0) {
/* 2357 */       throw new IllegalArgumentException("column parameter out of range: " + paramInt1);
/*      */     }
/*      */     
/* 2360 */     if (paramInt2 < 0) {
/* 2361 */       throw new IllegalArgumentException("fromIdx parameter out of range: " + paramInt2);
/*      */     }
/*      */ 
/*      */     
/* 2365 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2366 */     for (int i = paramInt2; i < arrayOfCTCol.length; i++) {
/* 2367 */       CTCol cTCol = arrayOfCTCol[i];
/*      */       
/* 2369 */       if (containsColumn(cTCol, paramInt1)) {
/* 2370 */         return i;
/*      */       }
/*      */       
/* 2373 */       if (cTCol.getMin() > paramInt2) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */     
/* 2378 */     return -1;
/*      */   }
/*      */   
/*      */   private boolean containsColumn(CTCol paramCTCol, int paramInt) {
/* 2382 */     return (paramCTCol.getMin() <= paramInt && paramInt <= paramCTCol.getMax());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isColumnGroupCollapsed(int paramInt) {
/* 2393 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 2394 */     CTCol[] arrayOfCTCol = cTCols.getColArray();
/* 2395 */     int i = findEndOfColumnOutlineGroup(paramInt);
/* 2396 */     int j = i + 1;
/* 2397 */     if (j >= arrayOfCTCol.length) {
/* 2398 */       return false;
/*      */     }
/* 2400 */     CTCol cTCol1 = arrayOfCTCol[j];
/*      */     
/* 2402 */     CTCol cTCol2 = arrayOfCTCol[i];
/* 2403 */     if (!isAdjacentBefore(cTCol2, cTCol1)) {
/* 2404 */       return false;
/*      */     }
/*      */     
/* 2407 */     return cTCol1.getCollapsed();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnHidden(int paramInt, boolean paramBoolean) {
/* 2418 */     this.columnHelper.setColHidden(paramInt, paramBoolean);
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
/*      */   public void setColumnWidth(int paramInt1, int paramInt2) {
/* 2467 */     if (paramInt2 > 65280) throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
/*      */     
/* 2469 */     this.columnHelper.setColWidth(paramInt1, paramInt2 / 256.0D);
/* 2470 */     this.columnHelper.setCustomWidth(paramInt1, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDefaultColumnStyle(int paramInt, CellStyle paramCellStyle) {
/* 2475 */     this.columnHelper.setColDefaultStyle(paramInt, paramCellStyle);
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
/*      */   public void setDefaultColumnWidth(int paramInt) {
/* 2487 */     getSheetTypeSheetFormatPr().setBaseColWidth(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultRowHeight(short paramShort) {
/* 2498 */     setDefaultRowHeightInPoints(paramShort / 20.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultRowHeightInPoints(float paramFloat) {
/* 2508 */     CTSheetFormatPr cTSheetFormatPr = getSheetTypeSheetFormatPr();
/* 2509 */     cTSheetFormatPr.setDefaultRowHeight(paramFloat);
/* 2510 */     cTSheetFormatPr.setCustomHeight(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayFormulas(boolean paramBoolean) {
/* 2520 */     getSheetTypeSheetView().setShowFormulas(paramBoolean);
/*      */   }
/*      */   
/*      */   private CTSheetView getSheetTypeSheetView() {
/* 2524 */     if (getDefaultSheetView() == null) {
/* 2525 */       getSheetTypeSheetViews().setSheetViewArray(0, CTSheetView.Factory.newInstance());
/*      */     }
/* 2527 */     return getDefaultSheetView();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFitToPage(boolean paramBoolean) {
/* 2537 */     getSheetTypePageSetUpPr().setFitToPage(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setHorizontallyCenter(boolean paramBoolean) {
/* 2547 */     CTPrintOptions cTPrintOptions = this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions();
/*      */     
/* 2549 */     cTPrintOptions.setHorizontalCentered(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVerticallyCenter(boolean paramBoolean) {
/* 2559 */     CTPrintOptions cTPrintOptions = this.worksheet.isSetPrintOptions() ? this.worksheet.getPrintOptions() : this.worksheet.addNewPrintOptions();
/*      */     
/* 2561 */     cTPrintOptions.setVerticalCentered(paramBoolean);
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
/*      */   public void setRowGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 2578 */     if (paramBoolean) {
/* 2579 */       collapseRow(paramInt);
/*      */     } else {
/* 2581 */       expandRow(paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void collapseRow(int paramInt) {
/* 2589 */     XSSFRow xSSFRow = getRow(paramInt);
/* 2590 */     if (xSSFRow != null) {
/* 2591 */       int i = findStartOfRowOutlineGroup(paramInt);
/*      */ 
/*      */       
/* 2594 */       int j = writeHidden(xSSFRow, i, true);
/* 2595 */       if (getRow(j) != null) {
/* 2596 */         getRow(j).getCTRow().setCollapsed(true);
/*      */       } else {
/* 2598 */         XSSFRow xSSFRow1 = createRow(j);
/* 2599 */         xSSFRow1.getCTRow().setCollapsed(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int findStartOfRowOutlineGroup(int paramInt) {
/* 2609 */     short s = getRow(paramInt).getCTRow().getOutlineLevel();
/* 2610 */     int i = paramInt;
/* 2611 */     while (getRow(i) != null) {
/* 2612 */       if (getRow(i).getCTRow().getOutlineLevel() < s)
/* 2613 */         return i + 1; 
/* 2614 */       i--;
/*      */     } 
/* 2616 */     return i;
/*      */   }
/*      */   
/*      */   private int writeHidden(XSSFRow paramXSSFRow, int paramInt, boolean paramBoolean) {
/* 2620 */     short s = paramXSSFRow.getCTRow().getOutlineLevel();
/* 2621 */     for (Iterator<Row> iterator = rowIterator(); iterator.hasNext(); ) {
/* 2622 */       paramXSSFRow = (XSSFRow)iterator.next();
/*      */ 
/*      */       
/* 2625 */       if (paramXSSFRow.getRowNum() < paramInt) {
/*      */         continue;
/*      */       }
/*      */       
/* 2629 */       if (paramXSSFRow.getCTRow().getOutlineLevel() >= s) {
/* 2630 */         paramXSSFRow.getCTRow().setHidden(paramBoolean);
/* 2631 */         paramInt++;
/*      */       } 
/*      */     } 
/*      */     
/* 2635 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void expandRow(int paramInt) {
/* 2642 */     if (paramInt == -1)
/*      */       return; 
/* 2644 */     XSSFRow xSSFRow = getRow(paramInt);
/*      */     
/* 2646 */     if (!xSSFRow.getCTRow().isSetHidden()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 2651 */     int i = findStartOfRowOutlineGroup(paramInt);
/*      */ 
/*      */     
/* 2654 */     int j = findEndOfRowOutlineGroup(paramInt);
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
/* 2667 */     short s = xSSFRow.getCTRow().getOutlineLevel();
/* 2668 */     if (!isRowGroupHiddenByParent(paramInt)) {
/* 2669 */       for (int k = i; k < j; k++) {
/* 2670 */         if (s == getRow(k).getCTRow().getOutlineLevel()) {
/* 2671 */           getRow(k).getCTRow().unsetHidden();
/* 2672 */         } else if (!isRowGroupCollapsed(k)) {
/* 2673 */           getRow(k).getCTRow().unsetHidden();
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 2678 */     CTRow cTRow = getRow(j).getCTRow();
/*      */     
/* 2680 */     if (cTRow.getCollapsed()) {
/* 2681 */       cTRow.unsetCollapsed();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int findEndOfRowOutlineGroup(int paramInt) {
/* 2689 */     short s = getRow(paramInt).getCTRow().getOutlineLevel();
/*      */     
/* 2691 */     int j = getLastRowNum(); int i;
/* 2692 */     for (i = paramInt; i < j && 
/* 2693 */       getRow(i) != null && getRow(i).getCTRow().getOutlineLevel() >= s; i++);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2698 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isRowGroupHiddenByParent(int paramInt) {
/*      */     short s1;
/*      */     boolean bool1;
/*      */     short s2;
/*      */     boolean bool2;
/* 2708 */     int i = findEndOfRowOutlineGroup(paramInt);
/* 2709 */     if (getRow(i) == null) {
/* 2710 */       s1 = 0;
/* 2711 */       bool1 = false;
/*      */     } else {
/* 2713 */       s1 = getRow(i).getCTRow().getOutlineLevel();
/* 2714 */       bool1 = getRow(i).getCTRow().getHidden();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2720 */     int j = findStartOfRowOutlineGroup(paramInt);
/* 2721 */     if (j < 0 || getRow(j) == null) {
/*      */       
/* 2723 */       s2 = 0;
/* 2724 */       bool2 = false;
/*      */     } else {
/* 2726 */       s2 = getRow(j).getCTRow().getOutlineLevel();
/*      */       
/* 2728 */       bool2 = getRow(j).getCTRow().getHidden();
/*      */     } 
/*      */     
/* 2731 */     if (s1 > s2) {
/* 2732 */       return bool1;
/*      */     }
/* 2734 */     return bool2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isRowGroupCollapsed(int paramInt) {
/* 2741 */     int i = findEndOfRowOutlineGroup(paramInt) + 1;
/* 2742 */     if (getRow(i) == null) {
/* 2743 */       return false;
/*      */     }
/* 2745 */     return getRow(i).getCTRow().getCollapsed();
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
/*      */   @Removal(version = "3.16")
/*      */   public void setZoom(int paramInt1, int paramInt2) {
/* 2760 */     int i = 100 * paramInt1 / paramInt2;
/* 2761 */     setZoom(i);
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
/*      */   public void setZoom(int paramInt) {
/* 2785 */     if (paramInt < 10 || paramInt > 400) {
/* 2786 */       throw new IllegalArgumentException("Valid scale values range from 10 to 400");
/*      */     }
/* 2788 */     getSheetTypeSheetView().setZoomScale(paramInt);
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
/*      */   public void copyRows(List<? extends Row> paramList, int paramInt, CellCopyPolicy paramCellCopyPolicy) {
/* 2807 */     if (paramList == null || paramList.size() == 0) {
/* 2808 */       throw new IllegalArgumentException("No rows to copy");
/*      */     }
/* 2810 */     Row row1 = paramList.get(0);
/* 2811 */     Row row2 = paramList.get(paramList.size() - 1);
/*      */     
/* 2813 */     if (row1 == null) {
/* 2814 */       throw new IllegalArgumentException("copyRows: First row cannot be null");
/*      */     }
/*      */     
/* 2817 */     int i = row1.getRowNum();
/* 2818 */     int j = row2.getRowNum();
/*      */ 
/*      */ 
/*      */     
/* 2822 */     int k = paramList.size();
/* 2823 */     for (byte b = 1; b < k; b++) {
/* 2824 */       Row row = paramList.get(b);
/* 2825 */       if (row == null) {
/* 2826 */         throw new IllegalArgumentException("srcRows may not contain null rows. Found null row at index " + b + ".");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 2831 */       if (row1.getSheet().getWorkbook() != row.getSheet().getWorkbook()) {
/* 2832 */         throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet in the same workbook.Expected all rows from same workbook (" + row1.getSheet().getWorkbook() + "). " + "Got srcRows[" + b + "] from different workbook (" + row.getSheet().getWorkbook() + ").");
/*      */       }
/*      */       
/* 2835 */       if (row1.getSheet() != row.getSheet()) {
/* 2836 */         throw new IllegalArgumentException("All rows in srcRows must belong to the same sheet. Expected all rows from " + row1.getSheet().getSheetName() + ". " + "Got srcRows[" + b + "] from " + row.getSheet().getSheetName());
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2844 */     CellCopyPolicy cellCopyPolicy = new CellCopyPolicy(paramCellCopyPolicy);
/*      */ 
/*      */     
/* 2847 */     cellCopyPolicy.setCopyMergedRegions(false);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2852 */     int m = paramInt;
/* 2853 */     for (Row row : paramList) {
/*      */       int n;
/* 2855 */       if (paramCellCopyPolicy.isCondenseRows()) {
/* 2856 */         n = m++;
/*      */       } else {
/* 2858 */         int i1 = row.getRowNum() - i;
/* 2859 */         n = paramInt + i1;
/*      */       } 
/*      */       
/* 2862 */       XSSFRow xSSFRow = createRow(n);
/* 2863 */       xSSFRow.copyRowFrom(row, cellCopyPolicy);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2871 */     if (paramCellCopyPolicy.isCopyMergedRegions()) {
/*      */       
/* 2873 */       int n = paramInt - i;
/* 2874 */       for (CellRangeAddress cellRangeAddress : row1.getSheet().getMergedRegions()) {
/* 2875 */         if (i <= cellRangeAddress.getFirstRow() && cellRangeAddress.getLastRow() <= j) {
/*      */           
/* 2877 */           CellRangeAddress cellRangeAddress1 = cellRangeAddress.copy();
/* 2878 */           cellRangeAddress1.setFirstRow(cellRangeAddress1.getFirstRow() + n);
/* 2879 */           cellRangeAddress1.setLastRow(cellRangeAddress1.getLastRow() + n);
/* 2880 */           addMergedRegion(cellRangeAddress1);
/*      */         } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void copyRows(int paramInt1, int paramInt2, int paramInt3, CellCopyPolicy paramCellCopyPolicy) {
/* 2899 */     List<XSSFRow> list = getRows(paramInt1, paramInt2, false);
/* 2900 */     copyRows((List)list, paramInt3, paramCellCopyPolicy);
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
/*      */   public void shiftRows(int paramInt1, int paramInt2, int paramInt3) {
/* 2919 */     shiftRows(paramInt1, paramInt2, paramInt3, false, false);
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
/*      */   public void shiftRows(int paramInt1, int paramInt2, final int n, boolean paramBoolean1, boolean paramBoolean2) {
/* 2940 */     XSSFVMLDrawing xSSFVMLDrawing = getVMLDrawing(false);
/*      */ 
/*      */     
/* 2943 */     for (Iterator<Row> iterator = rowIterator(); iterator.hasNext(); ) {
/* 2944 */       XSSFRow xSSFRow = (XSSFRow)iterator.next();
/* 2945 */       int j = xSSFRow.getRowNum();
/*      */ 
/*      */       
/* 2948 */       if (shouldRemoveRow(paramInt1, paramInt2, n, j)) {
/*      */ 
/*      */         
/* 2951 */         Integer integer = new Integer(xSSFRow.getRowNum());
/* 2952 */         int k = this._rows.headMap(integer).size();
/* 2953 */         this.worksheet.getSheetData().removeRow(k);
/*      */ 
/*      */         
/* 2956 */         iterator.remove();
/*      */ 
/*      */ 
/*      */         
/* 2960 */         if (this.sheetComments != null) {
/* 2961 */           CTCommentList cTCommentList = this.sheetComments.getCTComments().getCommentList();
/* 2962 */           for (CTComment cTComment : cTCommentList.getCommentArray()) {
/* 2963 */             String str1 = cTComment.getRef();
/* 2964 */             CellAddress cellAddress = new CellAddress(str1);
/*      */ 
/*      */             
/* 2967 */             if (cellAddress.getRow() == j) {
/* 2968 */               this.sheetComments.removeComment(cellAddress);
/* 2969 */               xSSFVMLDrawing.removeCommentShape(cellAddress.getRow(), cellAddress.getColumn());
/*      */             } 
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2975 */         if (this.hyperlinks != null) {
/* 2976 */           for (XSSFHyperlink xSSFHyperlink : new ArrayList(this.hyperlinks)) {
/* 2977 */             CellReference cellReference = new CellReference(xSSFHyperlink.getCellRef());
/* 2978 */             if (cellReference.getRow() == j) {
/* 2979 */               this.hyperlinks.remove(xSSFHyperlink);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2989 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(new Comparator<XSSFComment>() {
/*      */           public int compare(XSSFComment param1XSSFComment1, XSSFComment param1XSSFComment2) {
/* 2991 */             int i = param1XSSFComment1.getRow();
/* 2992 */             int j = param1XSSFComment2.getRow();
/*      */             
/* 2994 */             if (i == j)
/*      */             {
/*      */               
/* 2997 */               return param1XSSFComment1.hashCode() - param1XSSFComment2.hashCode();
/*      */             }
/*      */ 
/*      */             
/* 3001 */             if (n > 0) {
/* 3002 */               return (i < j) ? 1 : -1;
/*      */             }
/*      */             
/* 3005 */             return (i > j) ? 1 : -1;
/*      */           }
/*      */         });
/*      */ 
/*      */ 
/*      */     
/* 3011 */     for (null = rowIterator(); null.hasNext(); ) {
/* 3012 */       XSSFRow xSSFRow = (XSSFRow)null.next();
/* 3013 */       int j = xSSFRow.getRowNum();
/*      */       
/* 3015 */       if (this.sheetComments != null) {
/*      */         
/* 3017 */         int k = shiftedRowNum(paramInt1, paramInt2, n, j);
/*      */ 
/*      */         
/* 3020 */         if (k != j) {
/* 3021 */           CTCommentList cTCommentList = this.sheetComments.getCTComments().getCommentList();
/* 3022 */           for (CTComment cTComment : cTCommentList.getCommentArray()) {
/* 3023 */             String str1 = cTComment.getRef();
/* 3024 */             CellReference cellReference = new CellReference(str1);
/*      */ 
/*      */             
/* 3027 */             if (cellReference.getRow() == j) {
/* 3028 */               XSSFComment xSSFComment = new XSSFComment(this.sheetComments, cTComment, (xSSFVMLDrawing == null) ? null : xSSFVMLDrawing.findCommentShape(j, cellReference.getCol()));
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 3033 */               treeMap.put(xSSFComment, Integer.valueOf(k));
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 3039 */       if (j < paramInt1 || j > paramInt2)
/*      */         continue; 
/* 3041 */       if (!paramBoolean1) {
/* 3042 */         xSSFRow.setHeight((short)-1);
/*      */       }
/*      */       
/* 3045 */       xSSFRow.shift(n);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3051 */     for (Map.Entry<Object, Object> entry : treeMap.entrySet()) {
/* 3052 */       ((XSSFComment)entry.getKey()).setRow(((Integer)entry.getValue()).intValue());
/*      */     }
/*      */     
/* 3055 */     XSSFRowShifter xSSFRowShifter = new XSSFRowShifter(this);
/*      */     
/* 3057 */     int i = getWorkbook().getSheetIndex(this);
/* 3058 */     String str = getWorkbook().getSheetName(i);
/* 3059 */     FormulaShifter formulaShifter = FormulaShifter.createForRowShift(i, str, paramInt1, paramInt2, n, SpreadsheetVersion.EXCEL2007);
/*      */ 
/*      */     
/* 3062 */     xSSFRowShifter.updateNamedRanges(formulaShifter);
/* 3063 */     xSSFRowShifter.updateFormulas(formulaShifter);
/* 3064 */     xSSFRowShifter.shiftMergedRegions(paramInt1, paramInt2, n);
/* 3065 */     xSSFRowShifter.updateConditionalFormatting(formulaShifter);
/* 3066 */     xSSFRowShifter.updateHyperlinks(formulaShifter);
/*      */ 
/*      */     
/* 3069 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 3070 */     for (XSSFRow xSSFRow : this._rows.values()) {
/*      */       
/* 3072 */       Integer integer = new Integer(xSSFRow.getRowNum());
/* 3073 */       hashMap.put(integer, xSSFRow);
/*      */     } 
/* 3075 */     this._rows.clear();
/* 3076 */     this._rows.putAll(hashMap);
/*      */   }
/*      */ 
/*      */   
/*      */   private int shiftedRowNum(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 3081 */     if (paramInt4 < paramInt1 && (paramInt3 > 0 || paramInt1 - paramInt4 > paramInt3)) {
/* 3082 */       return paramInt4;
/*      */     }
/*      */ 
/*      */     
/* 3086 */     if (paramInt4 > paramInt2 && (paramInt3 < 0 || paramInt4 - paramInt2 > paramInt3)) {
/* 3087 */       return paramInt4;
/*      */     }
/*      */ 
/*      */     
/* 3091 */     if (paramInt4 < paramInt1)
/*      */     {
/* 3093 */       return paramInt4 + paramInt2 - paramInt1;
/*      */     }
/*      */ 
/*      */     
/* 3097 */     if (paramInt4 > paramInt2)
/*      */     {
/* 3099 */       return paramInt4 - paramInt2 - paramInt1;
/*      */     }
/*      */ 
/*      */     
/* 3103 */     return paramInt4 + paramInt3;
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
/*      */   public void showInPane(int paramInt1, int paramInt2) {
/* 3115 */     CellReference cellReference = new CellReference(paramInt1, paramInt2);
/* 3116 */     String str = cellReference.formatAsString();
/* 3117 */     getPane().setTopLeftCell(str);
/*      */   }
/*      */ 
/*      */   
/*      */   public void ungroupColumn(int paramInt1, int paramInt2) {
/* 3122 */     CTCols cTCols = this.worksheet.getColsArray(0);
/* 3123 */     for (int i = paramInt1; i <= paramInt2; i++) {
/* 3124 */       CTCol cTCol = this.columnHelper.getColumn(i, false);
/* 3125 */       if (cTCol != null) {
/* 3126 */         short s = cTCol.getOutlineLevel();
/* 3127 */         cTCol.setOutlineLevel((short)(s - 1));
/* 3128 */         i = (int)cTCol.getMax();
/*      */         
/* 3130 */         if (cTCol.getOutlineLevel() <= 0) {
/* 3131 */           int j = this.columnHelper.getIndexOfColumn(cTCols, cTCol);
/* 3132 */           this.worksheet.getColsArray(0).removeCol(j);
/*      */         } 
/*      */       } 
/*      */     } 
/* 3136 */     this.worksheet.setColsArray(0, cTCols);
/* 3137 */     setSheetFormatPrOutlineLevelCol();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ungroupRow(int paramInt1, int paramInt2) {
/* 3148 */     for (int i = paramInt1; i <= paramInt2; i++) {
/* 3149 */       XSSFRow xSSFRow = getRow(i);
/* 3150 */       if (xSSFRow != null) {
/* 3151 */         CTRow cTRow = xSSFRow.getCTRow();
/* 3152 */         short s = cTRow.getOutlineLevel();
/* 3153 */         cTRow.setOutlineLevel((short)(s - 1));
/*      */         
/* 3155 */         if (s == 1 && xSSFRow.getFirstCellNum() == -1) {
/* 3156 */           removeRow(xSSFRow);
/*      */         }
/*      */       } 
/*      */     } 
/* 3160 */     setSheetFormatPrOutlineLevelRow();
/*      */   }
/*      */   
/*      */   private void setSheetFormatPrOutlineLevelRow() {
/* 3164 */     short s = getMaxOutlineLevelRows();
/* 3165 */     getSheetTypeSheetFormatPr().setOutlineLevelRow(s);
/*      */   }
/*      */   
/*      */   private void setSheetFormatPrOutlineLevelCol() {
/* 3169 */     short s = getMaxOutlineLevelCols();
/* 3170 */     getSheetTypeSheetFormatPr().setOutlineLevelCol(s);
/*      */   }
/*      */   
/*      */   private CTSheetViews getSheetTypeSheetViews() {
/* 3174 */     if (this.worksheet.getSheetViews() == null) {
/* 3175 */       this.worksheet.setSheetViews(CTSheetViews.Factory.newInstance());
/* 3176 */       this.worksheet.getSheetViews().addNewSheetView();
/*      */     } 
/* 3178 */     return this.worksheet.getSheetViews();
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
/*      */   public boolean isSelected() {
/* 3193 */     CTSheetView cTSheetView = getDefaultSheetView();
/* 3194 */     return (cTSheetView != null && cTSheetView.getTabSelected());
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
/*      */   public void setSelected(boolean paramBoolean) {
/* 3210 */     CTSheetViews cTSheetViews = getSheetTypeSheetViews();
/* 3211 */     for (CTSheetView cTSheetView : cTSheetViews.getSheetViewArray()) {
/* 3212 */       cTSheetView.setTabSelected(paramBoolean);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public void addHyperlink(XSSFHyperlink paramXSSFHyperlink) {
/* 3223 */     this.hyperlinks.add(paramXSSFHyperlink);
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
/*      */   @Internal
/*      */   public void removeHyperlink(int paramInt1, int paramInt2) {
/* 3237 */     String str = (new CellReference(paramInt1, paramInt2)).formatAsString();
/* 3238 */     for (Iterator<XSSFHyperlink> iterator = this.hyperlinks.iterator(); iterator.hasNext(); ) {
/* 3239 */       XSSFHyperlink xSSFHyperlink = iterator.next();
/* 3240 */       if (xSSFHyperlink.getCellRef().equals(str)) {
/* 3241 */         iterator.remove();
/*      */         return;
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
/*      */   public CellAddress getActiveCell() {
/* 3254 */     String str = getSheetTypeSelection().getActiveCell();
/* 3255 */     if (str == null) {
/* 3256 */       return null;
/*      */     }
/* 3258 */     return new CellAddress(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCell(String paramString) {
/* 3268 */     CTSelection cTSelection = getSheetTypeSelection();
/* 3269 */     cTSelection.setActiveCell(paramString);
/* 3270 */     cTSelection.setSqref(Arrays.asList(new String[] { paramString }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCell(CellAddress paramCellAddress) {
/* 3278 */     String str = paramCellAddress.formatAsString();
/* 3279 */     CTSelection cTSelection = getSheetTypeSelection();
/* 3280 */     cTSelection.setActiveCell(str);
/* 3281 */     cTSelection.setSqref(Arrays.asList(new String[] { str }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasComments() {
/* 3289 */     return (this.sheetComments != null && this.sheetComments.getNumberOfComments() > 0);
/*      */   }
/*      */   
/*      */   protected int getNumberOfComments() {
/* 3293 */     return (this.sheetComments == null) ? 0 : this.sheetComments.getNumberOfComments();
/*      */   }
/*      */   
/*      */   private CTSelection getSheetTypeSelection() {
/* 3297 */     if (getSheetTypeSheetView().sizeOfSelectionArray() == 0) {
/* 3298 */       getSheetTypeSheetView().insertNewSelection(0);
/*      */     }
/* 3300 */     return getSheetTypeSheetView().getSelectionArray(0);
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
/*      */   private CTSheetView getDefaultSheetView() {
/* 3313 */     CTSheetViews cTSheetViews = getSheetTypeSheetViews();
/* 3314 */     byte b = (cTSheetViews == null) ? 0 : cTSheetViews.sizeOfSheetViewArray();
/* 3315 */     if (!b) {
/* 3316 */       return null;
/*      */     }
/* 3318 */     return cTSheetViews.getSheetViewArray(b - 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected CommentsTable getCommentsTable(boolean paramBoolean) {
/* 3328 */     if (this.sheetComments == null && paramBoolean) {
/*      */       
/*      */       try {
/*      */         
/* 3332 */         this.sheetComments = (CommentsTable)createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), (int)this.sheet.getSheetId());
/*      */       }
/* 3334 */       catch (PartAlreadyExistsException partAlreadyExistsException) {
/*      */ 
/*      */ 
/*      */         
/* 3338 */         this.sheetComments = (CommentsTable)createRelationship(XSSFRelation.SHEET_COMMENTS, XSSFFactory.getInstance(), -1);
/*      */       } 
/*      */     }
/*      */     
/* 3342 */     return this.sheetComments;
/*      */   }
/*      */   
/*      */   private CTPageSetUpPr getSheetTypePageSetUpPr() {
/* 3346 */     CTSheetPr cTSheetPr = getSheetTypeSheetPr();
/* 3347 */     return cTSheetPr.isSetPageSetUpPr() ? cTSheetPr.getPageSetUpPr() : cTSheetPr.addNewPageSetUpPr();
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean shouldRemoveRow(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 3352 */     if (paramInt4 >= paramInt1 + paramInt3 && paramInt4 <= paramInt2 + paramInt3) {
/*      */       
/* 3354 */       if (paramInt3 > 0 && paramInt4 > paramInt2) {
/* 3355 */         return true;
/*      */       }
/* 3357 */       if (paramInt3 < 0 && paramInt4 < paramInt1) {
/* 3358 */         return true;
/*      */       }
/*      */     } 
/* 3361 */     return false;
/*      */   }
/*      */   
/*      */   private CTPane getPane() {
/* 3365 */     if (getDefaultSheetView().getPane() == null) {
/* 3366 */       getDefaultSheetView().addNewPane();
/*      */     }
/* 3368 */     return getDefaultSheetView().getPane();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Internal
/*      */   public CTCellFormula getSharedFormula(int paramInt) {
/* 3379 */     return this.sharedFormulas.get(Integer.valueOf(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   void onReadCell(XSSFCell paramXSSFCell) {
/* 3384 */     CTCell cTCell = paramXSSFCell.getCTCell();
/* 3385 */     CTCellFormula cTCellFormula = cTCell.getF();
/* 3386 */     if (cTCellFormula != null && cTCellFormula.getT() == STCellFormulaType.SHARED && cTCellFormula.isSetRef() && cTCellFormula.getStringValue() != null) {
/*      */ 
/*      */       
/* 3389 */       CTCellFormula cTCellFormula1 = (CTCellFormula)cTCellFormula.copy();
/* 3390 */       CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(cTCellFormula1.getRef());
/* 3391 */       CellReference cellReference = new CellReference(paramXSSFCell);
/*      */ 
/*      */ 
/*      */       
/* 3395 */       if (cellReference.getCol() > cellRangeAddress.getFirstColumn() || cellReference.getRow() > cellRangeAddress.getFirstRow()) {
/* 3396 */         String str = (new CellRangeAddress(Math.max(cellReference.getRow(), cellRangeAddress.getFirstRow()), cellRangeAddress.getLastRow(), Math.max(cellReference.getCol(), cellRangeAddress.getFirstColumn()), cellRangeAddress.getLastColumn())).formatAsString();
/*      */ 
/*      */         
/* 3399 */         cTCellFormula1.setRef(str);
/*      */       } 
/*      */       
/* 3402 */       this.sharedFormulas.put(Integer.valueOf((int)cTCellFormula.getSi()), cTCellFormula1);
/*      */     } 
/* 3404 */     if (cTCellFormula != null && cTCellFormula.getT() == STCellFormulaType.ARRAY && cTCellFormula.getRef() != null) {
/* 3405 */       this.arrayFormulas.add(CellRangeAddress.valueOf(cTCellFormula.getRef()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void commit() throws IOException {
/* 3411 */     PackagePart packagePart = getPackagePart();
/* 3412 */     OutputStream outputStream = packagePart.getOutputStream();
/* 3413 */     write(outputStream);
/* 3414 */     outputStream.close();
/*      */   }
/*      */   
/*      */   protected void write(OutputStream paramOutputStream) throws IOException {
/* 3418 */     boolean bool = false;
/* 3419 */     if (this.worksheet.sizeOfColsArray() == 1) {
/* 3420 */       CTCols cTCols = this.worksheet.getColsArray(0);
/* 3421 */       if (cTCols.sizeOfColArray() == 0) {
/* 3422 */         bool = true;
/*      */ 
/*      */         
/* 3425 */         this.worksheet.setColsArray(null);
/*      */       } else {
/* 3427 */         setColWidthAttribute(cTCols);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3432 */     if (this.hyperlinks.size() > 0) {
/* 3433 */       if (this.worksheet.getHyperlinks() == null) {
/* 3434 */         this.worksheet.addNewHyperlinks();
/*      */       }
/* 3436 */       CTHyperlink[] arrayOfCTHyperlink = new CTHyperlink[this.hyperlinks.size()];
/* 3437 */       for (byte b = 0; b < arrayOfCTHyperlink.length; b++) {
/*      */ 
/*      */         
/* 3440 */         XSSFHyperlink xSSFHyperlink = this.hyperlinks.get(b);
/* 3441 */         xSSFHyperlink.generateRelationIfNeeded(getPackagePart());
/*      */         
/* 3443 */         arrayOfCTHyperlink[b] = xSSFHyperlink.getCTHyperlink();
/*      */       } 
/* 3445 */       this.worksheet.getHyperlinks().setHyperlinkArray(arrayOfCTHyperlink);
/*      */     } 
/*      */     
/* 3448 */     for (XSSFRow xSSFRow : this._rows.values()) {
/* 3449 */       xSSFRow.onDocumentWrite();
/*      */     }
/*      */     
/* 3452 */     XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
/* 3453 */     xmlOptions.setSaveSyntheticDocumentElement(new b(CTWorksheet.type.getName().getNamespaceURI(), "worksheet"));
/*      */     
/* 3455 */     this.worksheet.save(paramOutputStream, xmlOptions);
/*      */ 
/*      */     
/* 3458 */     if (bool) {
/* 3459 */       this.worksheet.addNewCols();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAutoFilterLocked() {
/* 3467 */     return (isSheetLocked() && safeGetProtectionField().getAutoFilter());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDeleteColumnsLocked() {
/* 3474 */     return (isSheetLocked() && safeGetProtectionField().getDeleteColumns());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDeleteRowsLocked() {
/* 3481 */     return (isSheetLocked() && safeGetProtectionField().getDeleteRows());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFormatCellsLocked() {
/* 3488 */     return (isSheetLocked() && safeGetProtectionField().getFormatCells());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFormatColumnsLocked() {
/* 3495 */     return (isSheetLocked() && safeGetProtectionField().getFormatColumns());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFormatRowsLocked() {
/* 3502 */     return (isSheetLocked() && safeGetProtectionField().getFormatRows());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInsertColumnsLocked() {
/* 3509 */     return (isSheetLocked() && safeGetProtectionField().getInsertColumns());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInsertHyperlinksLocked() {
/* 3516 */     return (isSheetLocked() && safeGetProtectionField().getInsertHyperlinks());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInsertRowsLocked() {
/* 3523 */     return (isSheetLocked() && safeGetProtectionField().getInsertRows());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPivotTablesLocked() {
/* 3530 */     return (isSheetLocked() && safeGetProtectionField().getPivotTables());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSortLocked() {
/* 3537 */     return (isSheetLocked() && safeGetProtectionField().getSort());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isObjectsLocked() {
/* 3544 */     return (isSheetLocked() && safeGetProtectionField().getObjects());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isScenariosLocked() {
/* 3551 */     return (isSheetLocked() && safeGetProtectionField().getScenarios());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSelectLockedCellsLocked() {
/* 3558 */     return (isSheetLocked() && safeGetProtectionField().getSelectLockedCells());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSelectUnlockedCellsLocked() {
/* 3565 */     return (isSheetLocked() && safeGetProtectionField().getSelectUnlockedCells());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSheetLocked() {
/* 3572 */     return (this.worksheet.isSetSheetProtection() && safeGetProtectionField().getSheet());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void enableLocking() {
/* 3579 */     safeGetProtectionField().setSheet(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void disableLocking() {
/* 3586 */     safeGetProtectionField().setSheet(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockAutoFilter(boolean paramBoolean) {
/* 3595 */     safeGetProtectionField().setAutoFilter(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockDeleteColumns(boolean paramBoolean) {
/* 3604 */     safeGetProtectionField().setDeleteColumns(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockDeleteRows(boolean paramBoolean) {
/* 3613 */     safeGetProtectionField().setDeleteRows(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockFormatCells(boolean paramBoolean) {
/* 3622 */     safeGetProtectionField().setFormatCells(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockFormatColumns(boolean paramBoolean) {
/* 3631 */     safeGetProtectionField().setFormatColumns(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockFormatRows(boolean paramBoolean) {
/* 3640 */     safeGetProtectionField().setFormatRows(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockInsertColumns(boolean paramBoolean) {
/* 3649 */     safeGetProtectionField().setInsertColumns(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockInsertHyperlinks(boolean paramBoolean) {
/* 3658 */     safeGetProtectionField().setInsertHyperlinks(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockInsertRows(boolean paramBoolean) {
/* 3667 */     safeGetProtectionField().setInsertRows(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockPivotTables(boolean paramBoolean) {
/* 3676 */     safeGetProtectionField().setPivotTables(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockSort(boolean paramBoolean) {
/* 3685 */     safeGetProtectionField().setSort(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockObjects(boolean paramBoolean) {
/* 3694 */     safeGetProtectionField().setObjects(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockScenarios(boolean paramBoolean) {
/* 3703 */     safeGetProtectionField().setScenarios(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockSelectLockedCells(boolean paramBoolean) {
/* 3712 */     safeGetProtectionField().setSelectLockedCells(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void lockSelectUnlockedCells(boolean paramBoolean) {
/* 3721 */     safeGetProtectionField().setSelectUnlockedCells(paramBoolean);
/*      */   }
/*      */   
/*      */   private CTSheetProtection safeGetProtectionField() {
/* 3725 */     if (!isSheetProtectionEnabled()) {
/* 3726 */       return this.worksheet.addNewSheetProtection();
/*      */     }
/* 3728 */     return this.worksheet.getSheetProtection();
/*      */   }
/*      */   
/*      */   boolean isSheetProtectionEnabled() {
/* 3732 */     return this.worksheet.isSetSheetProtection();
/*      */   }
/*      */   
/*      */   boolean isCellInArrayFormulaContext(XSSFCell paramXSSFCell) {
/* 3736 */     for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
/* 3737 */       if (cellRangeAddress.isInRange(paramXSSFCell.getRowIndex(), paramXSSFCell.getColumnIndex())) {
/* 3738 */         return true;
/*      */       }
/*      */     } 
/* 3741 */     return false;
/*      */   }
/*      */   
/*      */   XSSFCell getFirstCellInArrayFormula(XSSFCell paramXSSFCell) {
/* 3745 */     for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
/* 3746 */       if (cellRangeAddress.isInRange(paramXSSFCell.getRowIndex(), paramXSSFCell.getColumnIndex())) {
/* 3747 */         return getRow(cellRangeAddress.getFirstRow()).getCell(cellRangeAddress.getFirstColumn());
/*      */       }
/*      */     } 
/* 3750 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private CellRange<XSSFCell> getCellRange(CellRangeAddress paramCellRangeAddress) {
/* 3757 */     int i = paramCellRangeAddress.getFirstRow();
/* 3758 */     int j = paramCellRangeAddress.getFirstColumn();
/* 3759 */     int k = paramCellRangeAddress.getLastRow();
/* 3760 */     int m = paramCellRangeAddress.getLastColumn();
/* 3761 */     int n = k - i + 1;
/* 3762 */     int i1 = m - j + 1;
/* 3763 */     ArrayList<XSSFCell> arrayList = new ArrayList(n * i1);
/* 3764 */     for (int i2 = i; i2 <= k; i2++) {
/* 3765 */       for (int i3 = j; i3 <= m; i3++) {
/* 3766 */         XSSFRow xSSFRow = getRow(i2);
/* 3767 */         if (xSSFRow == null) {
/* 3768 */           xSSFRow = createRow(i2);
/*      */         }
/* 3770 */         XSSFCell xSSFCell = xSSFRow.getCell(i3);
/* 3771 */         if (xSSFCell == null) {
/* 3772 */           xSSFCell = xSSFRow.createCell(i3);
/*      */         }
/* 3774 */         arrayList.add(xSSFCell);
/*      */       } 
/*      */     } 
/* 3777 */     return (CellRange<XSSFCell>)SSCellRange.create(i, j, n, i1, arrayList, XSSFCell.class);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRange<XSSFCell> setArrayFormula(String paramString, CellRangeAddress paramCellRangeAddress) {
/* 3783 */     CellRange<XSSFCell> cellRange = getCellRange(paramCellRangeAddress);
/*      */     
/* 3785 */     XSSFCell xSSFCell = (XSSFCell)cellRange.getTopLeftCell();
/* 3786 */     xSSFCell.setCellArrayFormula(paramString, paramCellRangeAddress);
/* 3787 */     this.arrayFormulas.add(paramCellRangeAddress);
/* 3788 */     return cellRange;
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRange<XSSFCell> removeArrayFormula(Cell paramCell) {
/* 3793 */     if (paramCell.getSheet() != this) {
/* 3794 */       throw new IllegalArgumentException("Specified cell does not belong to this sheet.");
/*      */     }
/* 3796 */     for (CellRangeAddress cellRangeAddress : this.arrayFormulas) {
/* 3797 */       if (cellRangeAddress.isInRange(paramCell.getRowIndex(), paramCell.getColumnIndex())) {
/* 3798 */         this.arrayFormulas.remove(cellRangeAddress);
/* 3799 */         CellRange<XSSFCell> cellRange = getCellRange(cellRangeAddress);
/* 3800 */         for (XSSFCell xSSFCell : cellRange) {
/* 3801 */           xSSFCell.setCellType(CellType.BLANK);
/*      */         }
/* 3803 */         return cellRange;
/*      */       } 
/*      */     } 
/* 3806 */     String str = ((XSSFCell)paramCell).getCTCell().getR();
/* 3807 */     throw new IllegalArgumentException("Cell " + str + " is not part of an array formula.");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public DataValidationHelper getDataValidationHelper() {
/* 3813 */     return this.dataValidationHelper;
/*      */   }
/*      */   
/*      */   public List<XSSFDataValidation> getDataValidations() {
/* 3817 */     ArrayList<XSSFDataValidation> arrayList = new ArrayList();
/* 3818 */     CTDataValidations cTDataValidations = this.worksheet.getDataValidations();
/* 3819 */     if (cTDataValidations != null && cTDataValidations.getCount() > 0L) {
/* 3820 */       for (CTDataValidation cTDataValidation : cTDataValidations.getDataValidationArray()) {
/* 3821 */         CellRangeAddressList cellRangeAddressList = new CellRangeAddressList();
/*      */ 
/*      */         
/* 3824 */         List list = cTDataValidation.getSqref();
/* 3825 */         for (String str : list) {
/* 3826 */           String[] arrayOfString = str.split(" ");
/* 3827 */           for (String str1 : arrayOfString) {
/* 3828 */             String[] arrayOfString1 = str1.split(":");
/* 3829 */             CellReference cellReference1 = new CellReference(arrayOfString1[0]);
/* 3830 */             CellReference cellReference2 = (arrayOfString1.length > 1) ? new CellReference(arrayOfString1[1]) : cellReference1;
/* 3831 */             CellRangeAddress cellRangeAddress = new CellRangeAddress(cellReference1.getRow(), cellReference2.getRow(), cellReference1.getCol(), cellReference2.getCol());
/* 3832 */             cellRangeAddressList.addCellRangeAddress(cellRangeAddress);
/*      */           } 
/*      */         } 
/* 3835 */         XSSFDataValidation xSSFDataValidation = new XSSFDataValidation(cellRangeAddressList, cTDataValidation);
/* 3836 */         arrayList.add(xSSFDataValidation);
/*      */       } 
/*      */     }
/* 3839 */     return arrayList;
/*      */   }
/*      */ 
/*      */   
/*      */   public void addValidationData(DataValidation paramDataValidation) {
/* 3844 */     XSSFDataValidation xSSFDataValidation = (XSSFDataValidation)paramDataValidation;
/* 3845 */     CTDataValidations cTDataValidations = this.worksheet.getDataValidations();
/* 3846 */     if (cTDataValidations == null) {
/* 3847 */       cTDataValidations = this.worksheet.addNewDataValidations();
/*      */     }
/* 3849 */     int i = cTDataValidations.sizeOfDataValidationArray();
/* 3850 */     CTDataValidation cTDataValidation = cTDataValidations.addNewDataValidation();
/* 3851 */     cTDataValidation.set((XmlObject)xSSFDataValidation.getCtDdataValidation());
/* 3852 */     cTDataValidations.setCount((i + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFAutoFilter setAutoFilter(CellRangeAddress paramCellRangeAddress) {
/* 3859 */     CTAutoFilter cTAutoFilter = this.worksheet.getAutoFilter();
/* 3860 */     if (cTAutoFilter == null) cTAutoFilter = this.worksheet.addNewAutoFilter();
/*      */     
/* 3862 */     CellRangeAddress cellRangeAddress = new CellRangeAddress(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastColumn());
/*      */     
/* 3864 */     String str1 = cellRangeAddress.formatAsString();
/* 3865 */     cTAutoFilter.setRef(str1);
/*      */     
/* 3867 */     XSSFWorkbook xSSFWorkbook = getWorkbook();
/* 3868 */     int i = getWorkbook().getSheetIndex(this);
/* 3869 */     XSSFName xSSFName = xSSFWorkbook.getBuiltInName("_xlnm._FilterDatabase", i);
/* 3870 */     if (xSSFName == null) {
/* 3871 */       xSSFName = xSSFWorkbook.createBuiltInName("_xlnm._FilterDatabase", i);
/*      */     }
/*      */     
/* 3874 */     xSSFName.getCTName().setHidden(true);
/* 3875 */     CellReference cellReference1 = new CellReference(getSheetName(), paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getFirstColumn(), true, true);
/* 3876 */     CellReference cellReference2 = new CellReference(null, paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getLastColumn(), true, true);
/* 3877 */     String str2 = cellReference1.formatAsString() + ":" + cellReference2.formatAsString();
/* 3878 */     xSSFName.setRefersToFormula(str2);
/*      */     
/* 3880 */     return new XSSFAutoFilter(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFTable createTable() {
/* 3887 */     if (!this.worksheet.isSetTableParts()) {
/* 3888 */       this.worksheet.addNewTableParts();
/*      */     }
/*      */     
/* 3891 */     CTTableParts cTTableParts = this.worksheet.getTableParts();
/* 3892 */     CTTablePart cTTablePart = cTTableParts.addNewTablePart();
/*      */ 
/*      */ 
/*      */     
/* 3896 */     int i = getPackagePart().getPackage().getPartsByContentType(XSSFRelation.TABLE.getContentType()).size() + 1;
/* 3897 */     POIXMLDocumentPart.RelationPart relationPart = createRelationship(XSSFRelation.TABLE, XSSFFactory.getInstance(), i, false);
/* 3898 */     XSSFTable xSSFTable = (XSSFTable)relationPart.getDocumentPart();
/* 3899 */     cTTablePart.setId(relationPart.getRelationship().getId());
/*      */     
/* 3901 */     this.tables.put(cTTablePart.getId(), xSSFTable);
/*      */     
/* 3903 */     return xSSFTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFTable> getTables() {
/* 3910 */     return new ArrayList<XSSFTable>(this.tables.values());
/*      */   }
/*      */ 
/*      */   
/*      */   public XSSFSheetConditionalFormatting getSheetConditionalFormatting() {
/* 3915 */     return new XSSFSheetConditionalFormatting(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFColor getTabColor() {
/* 3925 */     CTSheetPr cTSheetPr = this.worksheet.getSheetPr();
/* 3926 */     if (cTSheetPr == null) cTSheetPr = this.worksheet.addNewSheetPr(); 
/* 3927 */     if (!cTSheetPr.isSetTabColor()) {
/* 3928 */       return null;
/*      */     }
/* 3930 */     return new XSSFColor(cTSheetPr.getTabColor());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTabColor(int paramInt) {
/* 3940 */     IndexedColors indexedColors = IndexedColors.fromInt(paramInt);
/* 3941 */     XSSFColor xSSFColor = new XSSFColor(indexedColors);
/* 3942 */     setTabColor(xSSFColor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTabColor(XSSFColor paramXSSFColor) {
/* 3951 */     CTSheetPr cTSheetPr = this.worksheet.getSheetPr();
/* 3952 */     if (cTSheetPr == null) cTSheetPr = this.worksheet.addNewSheetPr(); 
/* 3953 */     cTSheetPr.setTabColor(paramXSSFColor.getCTColor());
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingRows() {
/* 3958 */     return getRepeatingRowsOrColums(true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public CellRangeAddress getRepeatingColumns() {
/* 3964 */     return getRepeatingRowsOrColums(false);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRepeatingRows(CellRangeAddress paramCellRangeAddress) {
/* 3969 */     CellRangeAddress cellRangeAddress = getRepeatingColumns();
/* 3970 */     setRepeatingRowsAndColumns(paramCellRangeAddress, cellRangeAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRepeatingColumns(CellRangeAddress paramCellRangeAddress) {
/* 3976 */     CellRangeAddress cellRangeAddress = getRepeatingRows();
/* 3977 */     setRepeatingRowsAndColumns(cellRangeAddress, paramCellRangeAddress);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setRepeatingRowsAndColumns(CellRangeAddress paramCellRangeAddress1, CellRangeAddress paramCellRangeAddress2) {
/* 3983 */     int i = -1;
/* 3984 */     int j = -1;
/* 3985 */     int k = -1;
/* 3986 */     int m = -1;
/*      */     
/* 3988 */     if (paramCellRangeAddress1 != null) {
/* 3989 */       k = paramCellRangeAddress1.getFirstRow();
/* 3990 */       m = paramCellRangeAddress1.getLastRow();
/* 3991 */       if ((k == -1 && m != -1) || k < -1 || m < -1 || k > m)
/*      */       {
/* 3993 */         throw new IllegalArgumentException("Invalid row range specification");
/*      */       }
/*      */     } 
/* 3996 */     if (paramCellRangeAddress2 != null) {
/* 3997 */       i = paramCellRangeAddress2.getFirstColumn();
/* 3998 */       j = paramCellRangeAddress2.getLastColumn();
/* 3999 */       if ((i == -1 && j != -1) || i < -1 || j < -1 || i > j)
/*      */       {
/* 4001 */         throw new IllegalArgumentException("Invalid column range specification");
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 4006 */     int n = getWorkbook().getSheetIndex(this);
/*      */     
/* 4008 */     boolean bool = (paramCellRangeAddress1 == null && paramCellRangeAddress2 == null) ? true : false;
/*      */     
/* 4010 */     XSSFName xSSFName = getWorkbook().getBuiltInName("_xlnm.Print_Titles", n);
/*      */     
/* 4012 */     if (bool) {
/* 4013 */       if (xSSFName != null) {
/* 4014 */         getWorkbook().removeName(xSSFName);
/*      */       }
/*      */       return;
/*      */     } 
/* 4018 */     if (xSSFName == null) {
/* 4019 */       xSSFName = getWorkbook().createBuiltInName("_xlnm.Print_Titles", n);
/*      */     }
/*      */ 
/*      */     
/* 4023 */     String str = getReferenceBuiltInRecord(xSSFName.getSheetName(), i, j, k, m);
/*      */     
/* 4025 */     xSSFName.setRefersToFormula(str);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4030 */     if (!this.worksheet.isSetPageSetup() || !this.worksheet.isSetPageMargins())
/*      */     {
/*      */ 
/*      */       
/* 4034 */       getPrintSetup().setValidSettings(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String getReferenceBuiltInRecord(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 4043 */     CellReference cellReference1 = new CellReference(paramString, 0, paramInt1, true, true);
/*      */     
/* 4045 */     CellReference cellReference2 = new CellReference(paramString, 0, paramInt2, true, true);
/*      */     
/* 4047 */     CellReference cellReference3 = new CellReference(paramString, paramInt3, 0, true, true);
/*      */     
/* 4049 */     CellReference cellReference4 = new CellReference(paramString, paramInt4, 0, true, true);
/*      */ 
/*      */     
/* 4052 */     String str1 = SheetNameFormatter.format(paramString);
/*      */     
/* 4054 */     String str2 = "";
/* 4055 */     String str3 = "";
/*      */     
/* 4057 */     if (paramInt1 != -1 || paramInt2 != -1) {
/* 4058 */       String str4 = cellReference1.getCellRefParts()[2];
/* 4059 */       String str5 = cellReference2.getCellRefParts()[2];
/* 4060 */       str2 = str1 + "!$" + str4 + ":$" + str5;
/*      */     } 
/*      */     
/* 4063 */     if (paramInt3 != -1 || paramInt4 != -1) {
/* 4064 */       String str4 = cellReference3.getCellRefParts()[1];
/* 4065 */       String str5 = cellReference4.getCellRefParts()[1];
/* 4066 */       if (!str4.equals("0") && !str5.equals("0")) {
/* 4067 */         str3 = str1 + "!$" + str4 + ":$" + str5;
/*      */       }
/*      */     } 
/*      */     
/* 4071 */     StringBuilder stringBuilder = new StringBuilder();
/* 4072 */     stringBuilder.append(str2);
/* 4073 */     if (stringBuilder.length() > 0 && str3.length() > 0) {
/* 4074 */       stringBuilder.append(',');
/*      */     }
/* 4076 */     stringBuilder.append(str3);
/* 4077 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private CellRangeAddress getRepeatingRowsOrColums(boolean paramBoolean) {
/* 4082 */     int i = getWorkbook().getSheetIndex(this);
/* 4083 */     XSSFName xSSFName = getWorkbook().getBuiltInName("_xlnm.Print_Titles", i);
/*      */     
/* 4085 */     if (xSSFName == null) {
/* 4086 */       return null;
/*      */     }
/* 4088 */     String str = xSSFName.getRefersToFormula();
/* 4089 */     if (str == null) {
/* 4090 */       return null;
/*      */     }
/* 4092 */     String[] arrayOfString = str.split(",");
/* 4093 */     int j = SpreadsheetVersion.EXCEL2007.getLastRowIndex();
/* 4094 */     int k = SpreadsheetVersion.EXCEL2007.getLastColumnIndex();
/* 4095 */     for (String str1 : arrayOfString) {
/* 4096 */       CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(str1);
/* 4097 */       if ((cellRangeAddress.getFirstColumn() == 0 && cellRangeAddress.getLastColumn() == k) || (cellRangeAddress.getFirstColumn() == -1 && cellRangeAddress.getLastColumn() == -1)) {
/*      */ 
/*      */ 
/*      */         
/* 4101 */         if (paramBoolean) {
/* 4102 */           return cellRangeAddress;
/*      */         }
/* 4104 */       } else if ((cellRangeAddress.getFirstRow() == 0 && cellRangeAddress.getLastRow() == j) || (cellRangeAddress.getFirstRow() == -1 && cellRangeAddress.getLastRow() == -1)) {
/*      */ 
/*      */ 
/*      */         
/* 4108 */         if (!paramBoolean) {
/* 4109 */           return cellRangeAddress;
/*      */         }
/*      */       } 
/*      */     } 
/* 4113 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private XSSFPivotTable createPivotTable() {
/* 4124 */     XSSFWorkbook xSSFWorkbook1 = getWorkbook();
/* 4125 */     List<XSSFPivotTable> list = xSSFWorkbook1.getPivotTables();
/* 4126 */     int i = getWorkbook().getPivotTables().size() + 1;
/*      */     
/* 4128 */     XSSFPivotTable xSSFPivotTable = (XSSFPivotTable)createRelationship(XSSFRelation.PIVOT_TABLE, XSSFFactory.getInstance(), i);
/*      */     
/* 4130 */     xSSFPivotTable.setParentSheet(this);
/* 4131 */     list.add(xSSFPivotTable);
/* 4132 */     XSSFWorkbook xSSFWorkbook2 = getWorkbook();
/*      */ 
/*      */     
/* 4135 */     XSSFPivotCacheDefinition xSSFPivotCacheDefinition = (XSSFPivotCacheDefinition)xSSFWorkbook2.createRelationship(XSSFRelation.PIVOT_CACHE_DEFINITION, XSSFFactory.getInstance(), i);
/*      */     
/* 4137 */     String str = xSSFWorkbook2.getRelationId(xSSFPivotCacheDefinition);
/*      */     
/* 4139 */     PackagePart packagePart = xSSFPivotTable.getPackagePart();
/* 4140 */     packagePart.addRelationship(xSSFPivotCacheDefinition.getPackagePart().getPartName(), TargetMode.INTERNAL, XSSFRelation.PIVOT_CACHE_DEFINITION.getRelation());
/*      */ 
/*      */     
/* 4143 */     xSSFPivotTable.setPivotCacheDefinition(xSSFPivotCacheDefinition);
/*      */ 
/*      */     
/* 4146 */     xSSFPivotTable.setPivotCache(new XSSFPivotCache(xSSFWorkbook2.addPivotCache(str)));
/*      */ 
/*      */     
/* 4149 */     XSSFPivotCacheRecords xSSFPivotCacheRecords = (XSSFPivotCacheRecords)xSSFPivotCacheDefinition.createRelationship(XSSFRelation.PIVOT_CACHE_RECORDS, XSSFFactory.getInstance(), i);
/*      */ 
/*      */ 
/*      */     
/* 4153 */     xSSFPivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().setId(xSSFPivotCacheDefinition.getRelationId(xSSFPivotCacheRecords));
/*      */     
/* 4155 */     xSSFWorkbook1.setPivotTables(list);
/*      */     
/* 4157 */     return xSSFPivotTable;
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
/*      */   public XSSFPivotTable createPivotTable(AreaReference paramAreaReference, CellReference paramCellReference, Sheet paramSheet) {
/* 4169 */     String str = paramAreaReference.getFirstCell().getSheetName();
/* 4170 */     if (str != null && !str.equalsIgnoreCase(paramSheet.getSheetName())) {
/* 4171 */       throw new IllegalArgumentException("The area is referenced in another sheet than the defined source sheet " + paramSheet.getSheetName() + ".");
/*      */     }
/*      */     
/* 4174 */     XSSFPivotTable xSSFPivotTable = createPivotTable();
/*      */     
/* 4176 */     xSSFPivotTable.setDefaultPivotTableDefinition();
/*      */ 
/*      */     
/* 4179 */     xSSFPivotTable.createSourceReferences(paramAreaReference, paramCellReference, paramSheet);
/*      */ 
/*      */     
/* 4182 */     xSSFPivotTable.getPivotCacheDefinition().createCacheFields(paramSheet);
/* 4183 */     xSSFPivotTable.createDefaultDataColumns();
/*      */     
/* 4185 */     return xSSFPivotTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XSSFPivotTable createPivotTable(AreaReference paramAreaReference, CellReference paramCellReference) {
/* 4196 */     String str = paramAreaReference.getFirstCell().getSheetName();
/* 4197 */     if (str != null && !str.equalsIgnoreCase(getSheetName())) {
/* 4198 */       XSSFSheet xSSFSheet = getWorkbook().getSheet(str);
/* 4199 */       return createPivotTable(paramAreaReference, paramCellReference, xSSFSheet);
/*      */     } 
/* 4201 */     return createPivotTable(paramAreaReference, paramCellReference, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<XSSFPivotTable> getPivotTables() {
/* 4209 */     ArrayList<XSSFPivotTable> arrayList = new ArrayList();
/* 4210 */     for (XSSFPivotTable xSSFPivotTable : getWorkbook().getPivotTables()) {
/* 4211 */       if (xSSFPivotTable.getParent() == this) {
/* 4212 */         arrayList.add(xSSFPivotTable);
/*      */       }
/*      */     } 
/* 4215 */     return arrayList;
/*      */   }
/*      */   
/*      */   public int getColumnOutlineLevel(int paramInt) {
/* 4219 */     CTCol cTCol = this.columnHelper.getColumn(paramInt, false);
/* 4220 */     if (cTCol == null) {
/* 4221 */       return 0;
/*      */     }
/* 4223 */     return cTCol.getOutlineLevel();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addIgnoredErrors(CellReference paramCellReference, IgnoredErrorType... paramVarArgs) {
/* 4234 */     addIgnoredErrors(paramCellReference.formatAsString(), paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addIgnoredErrors(CellRangeAddress paramCellRangeAddress, IgnoredErrorType... paramVarArgs) {
/* 4244 */     paramCellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
/* 4245 */     addIgnoredErrors(paramCellRangeAddress.formatAsString(), paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<IgnoredErrorType, Set<CellRangeAddress>> getIgnoredErrors() {
/* 4255 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 4256 */     if (this.worksheet.isSetIgnoredErrors()) {
/* 4257 */       for (CTIgnoredError cTIgnoredError : this.worksheet.getIgnoredErrors().getIgnoredErrorList()) {
/* 4258 */         for (IgnoredErrorType ignoredErrorType : XSSFIgnoredErrorHelper.getErrorTypes(cTIgnoredError)) {
/* 4259 */           if (!linkedHashMap.containsKey(ignoredErrorType)) {
/* 4260 */             linkedHashMap.put(ignoredErrorType, new LinkedHashSet());
/*      */           }
/* 4262 */           for (Object object : cTIgnoredError.getSqref()) {
/* 4263 */             ((Set<CellRangeAddress>)linkedHashMap.get(ignoredErrorType)).add(CellRangeAddress.valueOf(object.toString()));
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/* 4268 */     return (Map)linkedHashMap;
/*      */   }
/*      */   
/*      */   private void addIgnoredErrors(String paramString, IgnoredErrorType... paramVarArgs) {
/* 4272 */     CTIgnoredErrors cTIgnoredErrors = this.worksheet.isSetIgnoredErrors() ? this.worksheet.getIgnoredErrors() : this.worksheet.addNewIgnoredErrors();
/* 4273 */     CTIgnoredError cTIgnoredError = cTIgnoredErrors.addNewIgnoredError();
/* 4274 */     XSSFIgnoredErrorHelper.addIgnoredErrors(cTIgnoredError, paramString, paramVarArgs);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */