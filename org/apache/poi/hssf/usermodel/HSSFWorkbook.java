/*      */ package org.apache.poi.hssf.usermodel;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.PrintWriter;
/*      */ import java.nio.charset.Charset;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.regex.Pattern;
/*      */ import org.apache.commons.codec.digest.DigestUtils;
/*      */ import org.apache.poi.EncryptedDocumentException;
/*      */ import org.apache.poi.POIDocument;
/*      */ import org.apache.poi.ddf.EscherBSERecord;
/*      */ import org.apache.poi.ddf.EscherBitmapBlip;
/*      */ import org.apache.poi.ddf.EscherBlipRecord;
/*      */ import org.apache.poi.ddf.EscherMetafileBlip;
/*      */ import org.apache.poi.ddf.EscherRecord;
/*      */ import org.apache.poi.hpsf.ClassID;
/*      */ import org.apache.poi.hssf.OldExcelFormatException;
/*      */ import org.apache.poi.hssf.model.DrawingManager2;
/*      */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*      */ import org.apache.poi.hssf.model.InternalSheet;
/*      */ import org.apache.poi.hssf.model.InternalWorkbook;
/*      */ import org.apache.poi.hssf.model.RecordStream;
/*      */ import org.apache.poi.hssf.record.AbstractEscherHolderRecord;
/*      */ import org.apache.poi.hssf.record.BackupRecord;
/*      */ import org.apache.poi.hssf.record.DrawingGroupRecord;
/*      */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*      */ import org.apache.poi.hssf.record.FontRecord;
/*      */ import org.apache.poi.hssf.record.LabelRecord;
/*      */ import org.apache.poi.hssf.record.LabelSSTRecord;
/*      */ import org.apache.poi.hssf.record.NameRecord;
/*      */ import org.apache.poi.hssf.record.RecalcIdRecord;
/*      */ import org.apache.poi.hssf.record.Record;
/*      */ import org.apache.poi.hssf.record.RecordFactory;
/*      */ import org.apache.poi.hssf.record.UnknownRecord;
/*      */ import org.apache.poi.hssf.record.aggregates.RecordAggregate;
/*      */ import org.apache.poi.hssf.record.common.UnicodeString;
/*      */ import org.apache.poi.hssf.util.CellReference;
/*      */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*      */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*      */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*      */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*      */ import org.apache.poi.poifs.filesystem.EntryUtils;
/*      */ import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
/*      */ import org.apache.poi.poifs.filesystem.NPOIFSDocument;
/*      */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*      */ import org.apache.poi.poifs.filesystem.Ole10Native;
/*      */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*      */ import org.apache.poi.ss.SpreadsheetVersion;
/*      */ import org.apache.poi.ss.formula.FormulaShifter;
/*      */ import org.apache.poi.ss.formula.FormulaType;
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
/*      */ import org.apache.poi.ss.util.WorkbookUtil;
/*      */ import org.apache.poi.util.Configurator;
/*      */ import org.apache.poi.util.HexDump;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.LittleEndian;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class HSSFWorkbook
/*      */   extends POIDocument
/*      */   implements Workbook
/*      */ {
/*  116 */   private static final Pattern COMMA_PATTERN = Pattern.compile(",");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MAX_STYLES = 4030;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int DEBUG = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  137 */   public static final int INITIAL_CAPACITY = Configurator.getIntValue("HSSFWorkbook.SheetInitialCapacity", 3);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private InternalWorkbook workbook;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List<HSSFSheet> _sheets;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ArrayList<HSSFName> names;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Map<Short, HSSFFont> fonts;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean preserveNodes;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private HSSFDataFormat formatter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  182 */   private Row.MissingCellPolicy missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
/*      */   
/*  184 */   private static POILogger log = POILogFactory.getLogger(HSSFWorkbook.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  190 */   private UDFFinder _udfFinder = (UDFFinder)new IndexedUDFFinder(new UDFFinder[] { AggregatingUDFFinder.DEFAULT });
/*      */   
/*      */   public static HSSFWorkbook create(InternalWorkbook paramInternalWorkbook) {
/*  193 */     return new HSSFWorkbook(paramInternalWorkbook);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFWorkbook() {
/*  200 */     this(InternalWorkbook.createWorkbook());
/*      */   }
/*      */   
/*      */   private HSSFWorkbook(InternalWorkbook paramInternalWorkbook) {
/*  204 */     super((DirectoryNode)null);
/*  205 */     this.workbook = paramInternalWorkbook;
/*  206 */     this._sheets = new ArrayList<HSSFSheet>(INITIAL_CAPACITY);
/*  207 */     this.names = new ArrayList<HSSFName>(INITIAL_CAPACITY);
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
/*      */   public HSSFWorkbook(POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/*  221 */     this(paramPOIFSFileSystem, true);
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
/*      */   public HSSFWorkbook(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*  234 */     this(paramNPOIFSFileSystem.getRoot(), true);
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
/*      */   public HSSFWorkbook(POIFSFileSystem paramPOIFSFileSystem, boolean paramBoolean) throws IOException {
/*  251 */     this(paramPOIFSFileSystem.getRoot(), paramPOIFSFileSystem, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public static String getWorkbookDirEntryName(DirectoryNode paramDirectoryNode) {
/*  256 */     for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
/*      */       try {
/*  258 */         paramDirectoryNode.getEntry(str);
/*  259 */         return str;
/*  260 */       } catch (FileNotFoundException fileNotFoundException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/*  267 */       paramDirectoryNode.getEntry("EncryptedPackage");
/*  268 */       throw new EncryptedDocumentException("The supplied spreadsheet seems to be an Encrypted .xlsx file. It must be decrypted before use by XSSF, it cannot be used by HSSF");
/*      */     }
/*  270 */     catch (FileNotFoundException fileNotFoundException) {
/*      */ 
/*      */       
/*      */       try {
/*      */ 
/*      */         
/*  276 */         paramDirectoryNode.getEntry("Book");
/*  277 */         throw new OldExcelFormatException("The supplied spreadsheet seems to be Excel 5.0/7.0 (BIFF5) format. POI only supports BIFF8 format (from Excel versions 97/2000/XP/2003)");
/*      */       }
/*  279 */       catch (FileNotFoundException fileNotFoundException1) {
/*      */ 
/*      */ 
/*      */         
/*  283 */         throw new IllegalArgumentException("The supplied POIFSFileSystem does not contain a BIFF8 'Workbook' entry. Is it really an excel file?");
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
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFWorkbook(DirectoryNode paramDirectoryNode, POIFSFileSystem paramPOIFSFileSystem, boolean paramBoolean) throws IOException {
/*  304 */     this(paramDirectoryNode, paramBoolean);
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
/*      */   public HSSFWorkbook(DirectoryNode paramDirectoryNode, boolean paramBoolean) throws IOException {
/*  323 */     super(paramDirectoryNode);
/*  324 */     String str = getWorkbookDirEntryName(paramDirectoryNode);
/*      */     
/*  326 */     this.preserveNodes = paramBoolean;
/*      */ 
/*      */ 
/*      */     
/*  330 */     if (!paramBoolean) {
/*  331 */       this.directory = null;
/*      */     }
/*      */     
/*  334 */     this._sheets = new ArrayList<HSSFSheet>(INITIAL_CAPACITY);
/*  335 */     this.names = new ArrayList<HSSFName>(INITIAL_CAPACITY);
/*      */ 
/*      */ 
/*      */     
/*  339 */     DocumentInputStream documentInputStream = paramDirectoryNode.createDocumentInputStream(str);
/*      */     
/*  341 */     List<Record> list = RecordFactory.createRecords((InputStream)documentInputStream);
/*      */     
/*  343 */     this.workbook = InternalWorkbook.createWorkbook(list);
/*  344 */     setPropertiesFromWorkbook(this.workbook);
/*  345 */     int i = this.workbook.getNumRecords();
/*      */ 
/*      */     
/*  348 */     convertLabelRecords(list, i);
/*  349 */     RecordStream recordStream = new RecordStream(list, i);
/*  350 */     while (recordStream.hasNext()) {
/*      */       try {
/*  352 */         InternalSheet internalSheet = InternalSheet.createSheet(recordStream);
/*  353 */         this._sheets.add(new HSSFSheet(this, internalSheet));
/*  354 */       } catch (org.apache.poi.hssf.model.InternalSheet.UnsupportedBOFType unsupportedBOFType) {
/*      */         
/*  356 */         log.log(5, new Object[] { "Unsupported BOF found of type " + unsupportedBOFType.getType() });
/*      */       } 
/*      */     } 
/*      */     
/*  360 */     for (byte b = 0; b < this.workbook.getNumNames(); b++) {
/*  361 */       NameRecord nameRecord = this.workbook.getNameRecord(b);
/*  362 */       HSSFName hSSFName = new HSSFName(this, nameRecord, this.workbook.getNameCommentRecord(nameRecord));
/*  363 */       this.names.add(hSSFName);
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
/*      */   public HSSFWorkbook(InputStream paramInputStream) throws IOException {
/*  379 */     this(paramInputStream, true);
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
/*      */   public HSSFWorkbook(InputStream paramInputStream, boolean paramBoolean) throws IOException {
/*  398 */     this((new NPOIFSFileSystem(paramInputStream)).getRoot(), paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void setPropertiesFromWorkbook(InternalWorkbook paramInternalWorkbook) {
/*  407 */     this.workbook = paramInternalWorkbook;
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
/*      */   private void convertLabelRecords(List<Record> paramList, int paramInt) {
/*  431 */     if (log.check(1))
/*  432 */       log.log(1, new Object[] { "convertLabelRecords called" }); 
/*  433 */     for (int i = paramInt; i < paramList.size(); i++) {
/*      */       
/*  435 */       Record record = paramList.get(i);
/*      */       
/*  437 */       if (record.getSid() == 516) {
/*      */         
/*  439 */         LabelRecord labelRecord = (LabelRecord)record;
/*      */         
/*  441 */         paramList.remove(i);
/*  442 */         LabelSSTRecord labelSSTRecord = new LabelSSTRecord();
/*  443 */         int j = this.workbook.addSSTString(new UnicodeString(labelRecord.getValue()));
/*      */ 
/*      */         
/*  446 */         labelSSTRecord.setRow(labelRecord.getRow());
/*  447 */         labelSSTRecord.setColumn(labelRecord.getColumn());
/*  448 */         labelSSTRecord.setXFIndex(labelRecord.getXFIndex());
/*  449 */         labelSSTRecord.setSSTIndex(j);
/*  450 */         paramList.add(i, labelSSTRecord);
/*      */       } 
/*      */     } 
/*  453 */     if (log.check(1)) {
/*  454 */       log.log(1, new Object[] { "convertLabelRecords exit" });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Row.MissingCellPolicy getMissingCellPolicy() {
/*  465 */     return this.missingCellPolicy;
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
/*      */   public void setMissingCellPolicy(Row.MissingCellPolicy paramMissingCellPolicy) {
/*  480 */     this.missingCellPolicy = paramMissingCellPolicy;
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
/*      */   public void setSheetOrder(String paramString, int paramInt) {
/*  492 */     int i = getSheetIndex(paramString);
/*  493 */     this._sheets.add(paramInt, this._sheets.remove(i));
/*  494 */     this.workbook.setSheetOrder(paramString, paramInt);
/*      */     
/*  496 */     FormulaShifter formulaShifter = FormulaShifter.createForSheetShift(i, paramInt);
/*  497 */     for (HSSFSheet hSSFSheet : this._sheets) {
/*  498 */       hSSFSheet.getSheet().updateFormulasAfterCellShift(formulaShifter, -1);
/*      */     }
/*      */     
/*  501 */     this.workbook.updateNamesAfterCellShift(formulaShifter);
/*      */ 
/*      */     
/*  504 */     int j = getActiveSheetIndex();
/*  505 */     if (j == i) {
/*      */       
/*  507 */       setActiveSheet(paramInt);
/*  508 */     } else if ((j >= i || j >= paramInt) && (j <= i || j <= paramInt)) {
/*      */ 
/*      */       
/*  511 */       if (paramInt > i) {
/*      */         
/*  513 */         setActiveSheet(j - 1);
/*      */       } else {
/*      */         
/*  516 */         setActiveSheet(j + 1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void validateSheetIndex(int paramInt) {
/*  521 */     int i = this._sheets.size() - 1;
/*  522 */     if (paramInt < 0 || paramInt > i) {
/*  523 */       String str = "(0.." + i + ")";
/*  524 */       if (i == -1) {
/*  525 */         str = "(no sheets)";
/*      */       }
/*  527 */       throw new IllegalArgumentException("Sheet index (" + paramInt + ") is out of range " + str);
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
/*      */   public void setSelectedTab(int paramInt) {
/*  539 */     validateSheetIndex(paramInt);
/*  540 */     int i = this._sheets.size();
/*  541 */     for (byte b = 0; b < i; b++) {
/*  542 */       getSheetAt(b).setSelected((b == paramInt));
/*      */     }
/*  544 */     this.workbook.getWindowOne().setNumSelectedTabs((short)1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelectedTabs(int[] paramArrayOfint) {
/*  555 */     ArrayList<Integer> arrayList = new ArrayList(paramArrayOfint.length);
/*  556 */     for (int i : paramArrayOfint) {
/*  557 */       arrayList.add(Integer.valueOf(i));
/*      */     }
/*  559 */     setSelectedTabs(arrayList);
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
/*      */   public void setSelectedTabs(Collection<Integer> paramCollection) {
/*  571 */     for (Iterator<Integer> iterator = paramCollection.iterator(); iterator.hasNext(); ) { int j = ((Integer)iterator.next()).intValue();
/*  572 */       validateSheetIndex(j); }
/*      */ 
/*      */     
/*  575 */     HashSet<Integer> hashSet = new HashSet<Integer>(paramCollection);
/*  576 */     int i = this._sheets.size(); short s;
/*  577 */     for (s = 0; s < i; s++) {
/*  578 */       boolean bool = hashSet.contains(Integer.valueOf(s));
/*  579 */       getSheetAt(s).setSelected(bool);
/*      */     } 
/*      */     
/*  582 */     s = (short)hashSet.size();
/*  583 */     this.workbook.getWindowOne().setNumSelectedTabs(s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<Integer> getSelectedTabs() {
/*  592 */     ArrayList<Integer> arrayList = new ArrayList();
/*  593 */     int i = this._sheets.size();
/*  594 */     for (byte b = 0; b < i; b++) {
/*  595 */       HSSFSheet hSSFSheet = getSheetAt(b);
/*  596 */       if (hSSFSheet.isSelected()) {
/*  597 */         arrayList.add(Integer.valueOf(b));
/*      */       }
/*      */     } 
/*  600 */     return Collections.unmodifiableCollection(arrayList);
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
/*  611 */     validateSheetIndex(paramInt);
/*  612 */     int i = this._sheets.size();
/*  613 */     for (byte b = 0; b < i; b++) {
/*  614 */       getSheetAt(b).setActive((b == paramInt));
/*      */     }
/*  616 */     this.workbook.getWindowOne().setActiveSheetIndex(paramInt);
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
/*  628 */     return this.workbook.getWindowOne().getActiveSheetIndex();
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
/*      */   public void setFirstVisibleTab(int paramInt) {
/*  641 */     this.workbook.getWindowOne().setFirstVisibleTab(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstVisibleTab() {
/*  649 */     return this.workbook.getWindowOne().getFirstVisibleTab();
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
/*      */   public void setSheetName(int paramInt, String paramString) {
/*  663 */     if (paramString == null) {
/*  664 */       throw new IllegalArgumentException("sheetName must not be null");
/*      */     }
/*      */     
/*  667 */     if (this.workbook.doesContainsSheetName(paramString, paramInt)) {
/*  668 */       throw new IllegalArgumentException("The workbook already contains a sheet named '" + paramString + "'");
/*      */     }
/*  670 */     validateSheetIndex(paramInt);
/*  671 */     this.workbook.setSheetName(paramInt, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSheetName(int paramInt) {
/*  679 */     validateSheetIndex(paramInt);
/*  680 */     return this.workbook.getSheetName(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isHidden() {
/*  685 */     return this.workbook.getWindowOne().getHidden();
/*      */   }
/*      */ 
/*      */   
/*      */   public void setHidden(boolean paramBoolean) {
/*  690 */     this.workbook.getWindowOne().setHidden(paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSheetHidden(int paramInt) {
/*  695 */     validateSheetIndex(paramInt);
/*  696 */     return this.workbook.isSheetHidden(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isSheetVeryHidden(int paramInt) {
/*  701 */     validateSheetIndex(paramInt);
/*  702 */     return this.workbook.isSheetVeryHidden(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetHidden(int paramInt, boolean paramBoolean) {
/*  708 */     validateSheetIndex(paramInt);
/*  709 */     this.workbook.setSheetHidden(paramInt, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSheetHidden(int paramInt1, int paramInt2) {
/*  714 */     validateSheetIndex(paramInt1);
/*  715 */     WorkbookUtil.validateSheetState(paramInt2);
/*  716 */     this.workbook.setSheetHidden(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSheetIndex(String paramString) {
/*  725 */     return this.workbook.getSheetIndex(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSheetIndex(Sheet paramSheet) {
/*  734 */     for (byte b = 0; b < this._sheets.size(); b++) {
/*  735 */       if (this._sheets.get(b) == paramSheet) {
/*  736 */         return b;
/*      */       }
/*      */     } 
/*  739 */     return -1;
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
/*      */   public HSSFSheet createSheet() {
/*  752 */     HSSFSheet hSSFSheet = new HSSFSheet(this);
/*      */     
/*  754 */     this._sheets.add(hSSFSheet);
/*  755 */     this.workbook.setSheetName(this._sheets.size() - 1, "Sheet" + (this._sheets.size() - 1));
/*  756 */     boolean bool = (this._sheets.size() == 1) ? true : false;
/*  757 */     hSSFSheet.setSelected(bool);
/*  758 */     hSSFSheet.setActive(bool);
/*  759 */     return hSSFSheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFSheet cloneSheet(int paramInt) {
/*  770 */     validateSheetIndex(paramInt);
/*  771 */     HSSFSheet hSSFSheet1 = this._sheets.get(paramInt);
/*  772 */     String str1 = this.workbook.getSheetName(paramInt);
/*  773 */     HSSFSheet hSSFSheet2 = hSSFSheet1.cloneSheet(this);
/*  774 */     hSSFSheet2.setSelected(false);
/*  775 */     hSSFSheet2.setActive(false);
/*      */     
/*  777 */     String str2 = getUniqueSheetName(str1);
/*  778 */     int i = this._sheets.size();
/*  779 */     this._sheets.add(hSSFSheet2);
/*  780 */     this.workbook.setSheetName(i, str2);
/*      */ 
/*      */     
/*  783 */     int j = findExistingBuiltinNameRecordIdx(paramInt, (byte)13);
/*  784 */     if (j != -1) {
/*  785 */       NameRecord nameRecord = this.workbook.cloneFilter(j, i);
/*  786 */       HSSFName hSSFName = new HSSFName(this, nameRecord);
/*  787 */       this.names.add(hSSFName);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  792 */     return hSSFSheet2;
/*      */   }
/*      */   
/*      */   private String getUniqueSheetName(String paramString) {
/*  796 */     int i = 2;
/*  797 */     String str = paramString;
/*  798 */     int j = paramString.lastIndexOf('(');
/*  799 */     if (j > 0 && paramString.endsWith(")")) {
/*  800 */       String str1 = paramString.substring(j + 1, paramString.length() - ")".length());
/*      */       try {
/*  802 */         i = Integer.parseInt(str1.trim());
/*  803 */         i++;
/*  804 */         str = paramString.substring(0, j).trim();
/*  805 */       } catch (NumberFormatException numberFormatException) {}
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  811 */       String str2, str1 = Integer.toString(i++);
/*      */       
/*  813 */       if (str.length() + str1.length() + 2 < 31) {
/*  814 */         str2 = str + " (" + str1 + ")";
/*      */       } else {
/*  816 */         str2 = str.substring(0, 31 - str1.length() - 2) + "(" + str1 + ")";
/*      */       } 
/*      */ 
/*      */       
/*  820 */       if (this.workbook.getSheetIndex(str2) == -1) {
/*  821 */         return str2;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFSheet createSheet(String paramString) {
/*  872 */     if (paramString == null) {
/*  873 */       throw new IllegalArgumentException("sheetName must not be null");
/*      */     }
/*      */     
/*  876 */     if (this.workbook.doesContainsSheetName(paramString, this._sheets.size())) {
/*  877 */       throw new IllegalArgumentException("The workbook already contains a sheet named '" + paramString + "'");
/*      */     }
/*  879 */     HSSFSheet hSSFSheet = new HSSFSheet(this);
/*      */     
/*  881 */     this.workbook.setSheetName(this._sheets.size(), paramString);
/*  882 */     this._sheets.add(hSSFSheet);
/*  883 */     boolean bool = (this._sheets.size() == 1) ? true : false;
/*  884 */     hSSFSheet.setSelected(bool);
/*  885 */     hSSFSheet.setActive(bool);
/*  886 */     return hSSFSheet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> sheetIterator() {
/*  897 */     return new SheetIterator<Sheet>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Sheet> iterator() {
/*  906 */     return sheetIterator();
/*      */   }
/*      */   
/*      */   private final class SheetIterator<T extends Sheet> implements Iterator<T> {
/*      */     private final Iterator<T> it;
/*  911 */     private T cursor = null;
/*      */     
/*      */     public SheetIterator() {
/*  914 */       this.it = (Iterator)HSSFWorkbook.this._sheets.iterator();
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  918 */       return this.it.hasNext();
/*      */     }
/*      */     
/*      */     public T next() throws NoSuchElementException {
/*  922 */       this.cursor = this.it.next();
/*  923 */       return this.cursor;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() throws IllegalStateException {
/*  932 */       throw new UnsupportedOperationException("remove method not supported on HSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
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
/*      */   public int getNumberOfSheets() {
/*  944 */     return this._sheets.size();
/*      */   }
/*      */   
/*      */   private HSSFSheet[] getSheets() {
/*  948 */     HSSFSheet[] arrayOfHSSFSheet = new HSSFSheet[this._sheets.size()];
/*  949 */     this._sheets.toArray(arrayOfHSSFSheet);
/*  950 */     return arrayOfHSSFSheet;
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
/*      */   public HSSFSheet getSheetAt(int paramInt) {
/*  962 */     validateSheetIndex(paramInt);
/*  963 */     return this._sheets.get(paramInt);
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
/*      */   public HSSFSheet getSheet(String paramString) {
/*  975 */     HSSFSheet hSSFSheet = null;
/*      */     
/*  977 */     for (byte b = 0; b < this._sheets.size(); b++) {
/*      */       
/*  979 */       String str = this.workbook.getSheetName(b);
/*      */       
/*  981 */       if (str.equalsIgnoreCase(paramString))
/*      */       {
/*  983 */         hSSFSheet = this._sheets.get(b);
/*      */       }
/*      */     } 
/*  986 */     return hSSFSheet;
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
/* 1005 */     validateSheetIndex(paramInt);
/* 1006 */     boolean bool = getSheetAt(paramInt).isSelected();
/*      */     
/* 1008 */     this._sheets.remove(paramInt);
/* 1009 */     this.workbook.removeSheet(paramInt);
/*      */ 
/*      */     
/* 1012 */     int i = this._sheets.size();
/* 1013 */     if (i < 1) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1018 */     int j = paramInt;
/* 1019 */     if (j >= i) {
/* 1020 */       j = i - 1;
/*      */     }
/*      */     
/* 1023 */     if (bool) {
/* 1024 */       boolean bool1 = false;
/* 1025 */       for (byte b = 0; b < i; b++) {
/* 1026 */         if (getSheetAt(b).isSelected()) {
/* 1027 */           bool1 = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1031 */       if (!bool1) {
/* 1032 */         setSelectedTab(j);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1037 */     int k = getActiveSheetIndex();
/* 1038 */     if (k == paramInt) {
/*      */       
/* 1040 */       setActiveSheet(j);
/* 1041 */     } else if (k > paramInt) {
/*      */       
/* 1043 */       setActiveSheet(k - 1);
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
/*      */   public void setBackupFlag(boolean paramBoolean) {
/* 1055 */     BackupRecord backupRecord = this.workbook.getBackupRecord();
/*      */     
/* 1057 */     backupRecord.setBackup(paramBoolean ? 1 : 0);
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
/*      */   public boolean getBackupFlag() {
/* 1069 */     BackupRecord backupRecord = this.workbook.getBackupRecord();
/*      */     
/* 1071 */     return (backupRecord.getBackup() != 0);
/*      */   }
/*      */   
/*      */   int findExistingBuiltinNameRecordIdx(int paramInt, byte paramByte) {
/* 1075 */     for (byte b = 0; b < this.names.size(); b++) {
/* 1076 */       NameRecord nameRecord = this.workbook.getNameRecord(b);
/* 1077 */       if (nameRecord == null) {
/* 1078 */         throw new RuntimeException("Unable to find all defined names to iterate over");
/*      */       }
/* 1080 */       if (nameRecord.isBuiltInName() && nameRecord.getBuiltInName() == paramByte)
/*      */       {
/*      */         
/* 1083 */         if (nameRecord.getSheetNumber() - 1 == paramInt)
/* 1084 */           return b; 
/*      */       }
/*      */     } 
/* 1087 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   HSSFName createBuiltInName(byte paramByte, int paramInt) {
/* 1092 */     NameRecord nameRecord = this.workbook.createBuiltInName(paramByte, paramInt + 1);
/*      */     
/* 1094 */     HSSFName hSSFName = new HSSFName(this, nameRecord, null);
/* 1095 */     this.names.add(hSSFName);
/* 1096 */     return hSSFName;
/*      */   }
/*      */ 
/*      */   
/*      */   HSSFName getBuiltInName(byte paramByte, int paramInt) {
/* 1101 */     int i = findExistingBuiltinNameRecordIdx(paramInt, paramByte);
/* 1102 */     if (i < 0) {
/* 1103 */       return null;
/*      */     }
/* 1105 */     return this.names.get(i);
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
/*      */   public HSSFFont createFont() {
/* 1118 */     this.workbook.createNewFont();
/* 1119 */     short s = (short)(getNumberOfFonts() - 1);
/*      */     
/* 1121 */     if (s > 3)
/*      */     {
/* 1123 */       s = (short)(s + 1);
/*      */     }
/* 1125 */     if (s == Short.MAX_VALUE) {
/* 1126 */       throw new IllegalArgumentException("Maximum number of fonts was exceeded");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1131 */     return getFontAt(s);
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
/*      */   public HSSFFont findFont(short paramShort1, short paramShort2, short paramShort3, String paramString, boolean paramBoolean1, boolean paramBoolean2, short paramShort4, byte paramByte) {
/* 1144 */     short s = getNumberOfFonts(); short s1;
/* 1145 */     for (s1 = 0; s1 <= s; s1 = (short)(s1 + 1)) {
/*      */       
/* 1147 */       if (s1 != 4) {
/*      */         
/* 1149 */         HSSFFont hSSFFont = getFontAt(s1);
/* 1150 */         if (hSSFFont.getBoldweight() == paramShort1 && hSSFFont.getColor() == paramShort2 && hSSFFont.getFontHeight() == paramShort3 && hSSFFont.getFontName().equals(paramString) && hSSFFont.getItalic() == paramBoolean1 && hSSFFont.getStrikeout() == paramBoolean2 && hSSFFont.getTypeOffset() == paramShort4 && hSSFFont.getUnderline() == paramByte)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1159 */           return hSSFFont;
/*      */         }
/*      */       } 
/*      */     } 
/* 1163 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFFont findFont(boolean paramBoolean1, short paramShort1, short paramShort2, String paramString, boolean paramBoolean2, boolean paramBoolean3, short paramShort3, byte paramByte) {
/* 1173 */     short s = getNumberOfFonts(); short s1;
/* 1174 */     for (s1 = 0; s1 <= s; s1 = (short)(s1 + 1)) {
/*      */       
/* 1176 */       if (s1 != 4) {
/*      */         
/* 1178 */         HSSFFont hSSFFont = getFontAt(s1);
/* 1179 */         if (hSSFFont.getBold() == paramBoolean1 && hSSFFont.getColor() == paramShort1 && hSSFFont.getFontHeight() == paramShort2 && hSSFFont.getFontName().equals(paramString) && hSSFFont.getItalic() == paramBoolean2 && hSSFFont.getStrikeout() == paramBoolean3 && hSSFFont.getTypeOffset() == paramShort3 && hSSFFont.getUnderline() == paramByte)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1188 */           return hSSFFont;
/*      */         }
/*      */       } 
/*      */     } 
/* 1192 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getNumberOfFonts() {
/* 1203 */     return (short)this.workbook.getNumberOfFontRecords();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFFont getFontAt(short paramShort) {
/* 1213 */     if (this.fonts == null) this.fonts = new HashMap<Short, HSSFFont>();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1218 */     Short short_ = Short.valueOf(paramShort);
/* 1219 */     if (this.fonts.containsKey(short_)) {
/* 1220 */       return this.fonts.get(short_);
/*      */     }
/*      */     
/* 1223 */     FontRecord fontRecord = this.workbook.getFontRecordAt(paramShort);
/* 1224 */     HSSFFont hSSFFont = new HSSFFont(paramShort, fontRecord);
/* 1225 */     this.fonts.put(short_, hSSFFont);
/*      */     
/* 1227 */     return hSSFFont;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void resetFontCache() {
/* 1237 */     this.fonts = new HashMap<Short, HSSFFont>();
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
/*      */   public HSSFCellStyle createCellStyle() {
/* 1250 */     if (this.workbook.getNumExFormats() == 4030) {
/* 1251 */       throw new IllegalStateException("The maximum number of cell styles was exceeded. You can define up to 4000 styles in a .xls workbook");
/*      */     }
/*      */     
/* 1254 */     ExtendedFormatRecord extendedFormatRecord = this.workbook.createCellXF();
/* 1255 */     short s = (short)(getNumCellStyles() - 1);
/* 1256 */     return new HSSFCellStyle(s, extendedFormatRecord, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumCellStyles() {
/* 1266 */     return this.workbook.getNumExFormats();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFCellStyle getCellStyleAt(int paramInt) {
/* 1277 */     ExtendedFormatRecord extendedFormatRecord = this.workbook.getExFormatAt(paramInt);
/* 1278 */     return new HSSFCellStyle((short)paramInt, extendedFormatRecord, this);
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
/*      */   public void close() throws IOException {
/* 1291 */     super.close();
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
/*      */   public void write() throws IOException {
/* 1306 */     validateInPlaceWritePossible();
/*      */ 
/*      */     
/* 1309 */     DocumentNode documentNode = (DocumentNode)this.directory.getEntry(getWorkbookDirEntryName(this.directory));
/*      */     
/* 1311 */     NPOIFSDocument nPOIFSDocument = new NPOIFSDocument(documentNode);
/* 1312 */     nPOIFSDocument.replaceContents(new ByteArrayInputStream(getBytes()));
/*      */ 
/*      */     
/* 1315 */     writeProperties();
/*      */ 
/*      */     
/* 1318 */     this.directory.getFileSystem().writeFilesystem();
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
/*      */   public void write(File paramFile) throws IOException {
/* 1338 */     POIFSFileSystem pOIFSFileSystem = POIFSFileSystem.create(paramFile);
/*      */     try {
/* 1340 */       write((NPOIFSFileSystem)pOIFSFileSystem);
/* 1341 */       pOIFSFileSystem.writeFilesystem();
/*      */     } finally {
/* 1343 */       pOIFSFileSystem.close();
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
/*      */   public void write(OutputStream paramOutputStream) throws IOException {
/* 1364 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem();
/*      */     try {
/* 1366 */       write(nPOIFSFileSystem);
/* 1367 */       nPOIFSFileSystem.writeFilesystem(paramOutputStream);
/*      */     } finally {
/* 1369 */       nPOIFSFileSystem.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void write(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 1377 */     ArrayList arrayList = new ArrayList(1);
/*      */ 
/*      */     
/* 1380 */     paramNPOIFSFileSystem.createDocument(new ByteArrayInputStream(getBytes()), "Workbook");
/*      */ 
/*      */     
/* 1383 */     writeProperties(paramNPOIFSFileSystem, arrayList);
/*      */     
/* 1385 */     if (this.preserveNodes) {
/*      */ 
/*      */ 
/*      */       
/* 1389 */       arrayList.addAll(Arrays.asList(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES));
/*      */ 
/*      */       
/* 1392 */       EntryUtils.copyNodes(new FilteringDirectoryNode((DirectoryEntry)this.directory, arrayList), new FilteringDirectoryNode((DirectoryEntry)paramNPOIFSFileSystem.getRoot(), arrayList));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1399 */       paramNPOIFSFileSystem.getRoot().setStorageClsid(this.directory.getStorageClsid());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class SheetRecordCollector
/*      */     implements RecordAggregate.RecordVisitor
/*      */   {
/* 1412 */     private int _totalSize = 0;
/* 1413 */     private List<Record> _list = new ArrayList<Record>(128);
/*      */     
/*      */     public int getTotalSize() {
/* 1416 */       return this._totalSize;
/*      */     }
/*      */     
/*      */     public void visitRecord(Record param1Record) {
/* 1420 */       this._list.add(param1Record);
/* 1421 */       this._totalSize += param1Record.getRecordSize();
/*      */     }
/*      */     
/*      */     public int serialize(int param1Int, byte[] param1ArrayOfbyte) {
/* 1425 */       int i = 0;
/* 1426 */       for (Record record : this._list) {
/* 1427 */         i += record.serialize(param1Int + i, param1ArrayOfbyte);
/*      */       }
/* 1429 */       return i;
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
/*      */   public byte[] getBytes() {
/* 1443 */     if (log.check(1)) {
/* 1444 */       log.log(1, new Object[] { "HSSFWorkbook.getBytes()" });
/*      */     }
/*      */     
/* 1447 */     HSSFSheet[] arrayOfHSSFSheet = getSheets();
/* 1448 */     int i = arrayOfHSSFSheet.length;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1453 */     this.workbook.preSerialize();
/* 1454 */     for (HSSFSheet hSSFSheet : arrayOfHSSFSheet) {
/* 1455 */       hSSFSheet.getSheet().preSerialize();
/* 1456 */       hSSFSheet.preSerialize();
/*      */     } 
/*      */     
/* 1459 */     int j = this.workbook.getSize();
/*      */ 
/*      */     
/* 1462 */     SheetRecordCollector[] arrayOfSheetRecordCollector = new SheetRecordCollector[i];
/* 1463 */     for (byte b1 = 0; b1 < i; b1++) {
/* 1464 */       this.workbook.setSheetBof(b1, j);
/* 1465 */       SheetRecordCollector sheetRecordCollector = new SheetRecordCollector();
/* 1466 */       arrayOfHSSFSheet[b1].getSheet().visitContainedRecords(sheetRecordCollector, j);
/* 1467 */       j += sheetRecordCollector.getTotalSize();
/* 1468 */       arrayOfSheetRecordCollector[b1] = sheetRecordCollector;
/*      */     } 
/*      */     
/* 1471 */     byte[] arrayOfByte = new byte[j];
/* 1472 */     int k = this.workbook.serialize(0, arrayOfByte);
/*      */     
/* 1474 */     for (byte b2 = 0; b2 < i; b2++) {
/* 1475 */       SheetRecordCollector sheetRecordCollector = arrayOfSheetRecordCollector[b2];
/* 1476 */       int m = sheetRecordCollector.serialize(k, arrayOfByte);
/* 1477 */       if (m != sheetRecordCollector.getTotalSize())
/*      */       {
/*      */ 
/*      */         
/* 1481 */         throw new IllegalStateException("Actual serialized sheet size (" + m + ") differs from pre-calculated size (" + sheetRecordCollector.getTotalSize() + ") for sheet (" + b2 + ")");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1486 */       k += m;
/*      */     } 
/* 1488 */     return arrayOfByte;
/*      */   }
/*      */   
/*      */   InternalWorkbook getWorkbook() {
/* 1492 */     return this.workbook;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumberOfNames() {
/* 1497 */     return this.names.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFName getName(String paramString) {
/* 1502 */     int i = getNameIndex(paramString);
/* 1503 */     if (i < 0) {
/* 1504 */       return null;
/*      */     }
/* 1506 */     return this.names.get(i);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<HSSFName> getNames(String paramString) {
/* 1511 */     ArrayList<HSSFName> arrayList = new ArrayList();
/* 1512 */     for (HSSFName hSSFName : this.names) {
/* 1513 */       if (hSSFName.getNameName().equals(paramString)) {
/* 1514 */         arrayList.add(hSSFName);
/*      */       }
/*      */     } 
/*      */     
/* 1518 */     return Collections.unmodifiableList(arrayList);
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFName getNameAt(int paramInt) {
/* 1523 */     int i = this.names.size();
/* 1524 */     if (i < 1) {
/* 1525 */       throw new IllegalStateException("There are no defined names in this workbook");
/*      */     }
/* 1527 */     if (paramInt < 0 || paramInt > i) {
/* 1528 */       throw new IllegalArgumentException("Specified name index " + paramInt + " is outside the allowable range (0.." + (i - 1) + ").");
/*      */     }
/*      */     
/* 1531 */     return this.names.get(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public List<HSSFName> getAllNames() {
/* 1536 */     return Collections.unmodifiableList(this.names);
/*      */   }
/*      */   
/*      */   public NameRecord getNameRecord(int paramInt) {
/* 1540 */     return getWorkbook().getNameRecord(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getNameName(int paramInt) {
/* 1548 */     return getNameAt(paramInt).getNameName();
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
/*      */   public void setPrintArea(int paramInt, String paramString) {
/* 1561 */     NameRecord nameRecord = this.workbook.getSpecificBuiltinRecord((byte)6, paramInt + 1);
/*      */ 
/*      */     
/* 1564 */     if (nameRecord == null) {
/* 1565 */       nameRecord = this.workbook.createBuiltInName((byte)6, paramInt + 1);
/*      */     }
/*      */     
/* 1568 */     String[] arrayOfString = COMMA_PATTERN.split(paramString);
/* 1569 */     StringBuffer stringBuffer = new StringBuffer(32);
/* 1570 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 1571 */       if (b > 0) {
/* 1572 */         stringBuffer.append(",");
/*      */       }
/* 1574 */       SheetNameFormatter.appendFormat(stringBuffer, getSheetName(paramInt));
/* 1575 */       stringBuffer.append("!");
/* 1576 */       stringBuffer.append(arrayOfString[b]);
/*      */     } 
/* 1578 */     nameRecord.setNameDefinition(HSSFFormulaParser.parse(stringBuffer.toString(), this, FormulaType.NAMEDRANGE, paramInt));
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
/*      */   public void setPrintArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 1595 */     CellReference cellReference = new CellReference(paramInt4, paramInt2, true, true);
/* 1596 */     String str = cellReference.formatAsString();
/*      */     
/* 1598 */     cellReference = new CellReference(paramInt5, paramInt3, true, true);
/* 1599 */     str = str + ":" + cellReference.formatAsString();
/*      */     
/* 1601 */     setPrintArea(paramInt1, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPrintArea(int paramInt) {
/* 1612 */     NameRecord nameRecord = this.workbook.getSpecificBuiltinRecord((byte)6, paramInt + 1);
/*      */     
/* 1614 */     if (nameRecord == null) {
/* 1615 */       return null;
/*      */     }
/*      */     
/* 1618 */     return HSSFFormulaParser.toFormulaString(this, nameRecord.getNameDefinition());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePrintArea(int paramInt) {
/* 1627 */     getWorkbook().removeBuiltinRecord((byte)6, paramInt + 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFName createName() {
/* 1635 */     NameRecord nameRecord = this.workbook.createName();
/*      */     
/* 1637 */     HSSFName hSSFName = new HSSFName(this, nameRecord);
/*      */     
/* 1639 */     this.names.add(hSSFName);
/*      */     
/* 1641 */     return hSSFName;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNameIndex(String paramString) {
/* 1647 */     for (byte b = 0; b < this.names.size(); b++) {
/* 1648 */       String str = getNameName(b);
/*      */       
/* 1650 */       if (str.equalsIgnoreCase(paramString)) {
/* 1651 */         return b;
/*      */       }
/*      */     } 
/* 1654 */     return -1;
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
/*      */   int getNameIndex(HSSFName paramHSSFName) {
/* 1668 */     for (byte b = 0; b < this.names.size(); b++) {
/* 1669 */       if (paramHSSFName == this.names.get(b)) {
/* 1670 */         return b;
/*      */       }
/*      */     } 
/* 1673 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeName(int paramInt) {
/* 1679 */     this.names.remove(paramInt);
/* 1680 */     this.workbook.removeName(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HSSFDataFormat createDataFormat() {
/* 1691 */     if (this.formatter == null)
/* 1692 */       this.formatter = new HSSFDataFormat(this.workbook); 
/* 1693 */     return this.formatter;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeName(String paramString) {
/* 1699 */     int i = getNameIndex(paramString);
/* 1700 */     removeName(i);
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
/*      */   public void removeName(Name paramName) {
/* 1712 */     int i = getNameIndex((HSSFName)paramName);
/* 1713 */     removeName(i);
/*      */   }
/*      */ 
/*      */   
/*      */   public HSSFPalette getCustomPalette() {
/* 1718 */     return new HSSFPalette(this.workbook.getCustomPalette());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertChartRecord() {
/* 1724 */     int i = this.workbook.findFirstRecordLocBySid((short)252);
/* 1725 */     byte[] arrayOfByte = { 15, 0, 0, -16, 82, 0, 0, 0, 0, 0, 6, -16, 24, 0, 0, 0, 1, 8, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 51, 0, 11, -16, 18, 0, 0, 0, -65, 0, 8, 0, 8, 0, -127, 1, 9, 0, 0, 8, -64, 1, 64, 0, 0, 8, 64, 0, 30, -15, 16, 0, 0, 0, 13, 0, 0, 8, 12, 0, 0, 8, 23, 0, 0, 8, -9, 0, 0, 16 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1745 */     UnknownRecord unknownRecord = new UnknownRecord(235, arrayOfByte);
/* 1746 */     this.workbook.getRecords().add(i, unknownRecord);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void dumpDrawingGroupRecords(boolean paramBoolean) {
/* 1754 */     DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)this.workbook.findFirstRecordBySid((short)235);
/* 1755 */     drawingGroupRecord.decode();
/* 1756 */     List list = drawingGroupRecord.getEscherRecords();
/* 1757 */     PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
/* 1758 */     for (EscherRecord escherRecord : list) {
/* 1759 */       if (paramBoolean) {
/* 1760 */         System.out.println(escherRecord.toString()); continue;
/*      */       } 
/* 1762 */       escherRecord.display(printWriter, 0);
/*      */     } 
/* 1764 */     printWriter.flush();
/*      */   }
/*      */   
/*      */   void initDrawings() {
/* 1768 */     DrawingManager2 drawingManager2 = this.workbook.findDrawingGroup();
/* 1769 */     if (drawingManager2 != null) {
/* 1770 */       for (HSSFSheet hSSFSheet : this._sheets) {
/* 1771 */         hSSFSheet.getDrawingPatriarch();
/*      */       }
/*      */     } else {
/* 1774 */       this.workbook.createDrawingGroup();
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
/*      */   public int addPicture(byte[] paramArrayOfbyte, int paramInt) {
/*      */     EscherMetafileBlip escherMetafileBlip1;
/*      */     EscherBitmapBlip escherBitmapBlip1;
/*      */     int i;
/*      */     char c;
/*      */     EscherMetafileBlip escherMetafileBlip2;
/*      */     EscherBSERecord escherBSERecord;
/*      */     EscherBitmapBlip escherBitmapBlip2;
/* 1796 */     initDrawings();
/*      */     
/* 1798 */     byte[] arrayOfByte = DigestUtils.md5(paramArrayOfbyte);
/*      */ 
/*      */ 
/*      */     
/* 1802 */     switch (paramInt) {
/*      */ 
/*      */       
/*      */       case 3:
/* 1806 */         if (LittleEndian.getInt(paramArrayOfbyte) == -1698247209) {
/* 1807 */           byte[] arrayOfByte1 = new byte[paramArrayOfbyte.length - 22];
/* 1808 */           System.arraycopy(paramArrayOfbyte, 22, arrayOfByte1, 0, paramArrayOfbyte.length - 22);
/* 1809 */           paramArrayOfbyte = arrayOfByte1;
/*      */         } 
/*      */       
/*      */       case 2:
/* 1813 */         escherMetafileBlip2 = new EscherMetafileBlip();
/* 1814 */         escherMetafileBlip1 = escherMetafileBlip2;
/* 1815 */         escherMetafileBlip2.setUID(arrayOfByte);
/* 1816 */         escherMetafileBlip2.setPictureData(paramArrayOfbyte);
/*      */         
/* 1818 */         escherMetafileBlip2.setFilter((byte)-2);
/* 1819 */         i = escherMetafileBlip2.getCompressedSize() + 58;
/* 1820 */         c = Character.MIN_VALUE;
/*      */         break;
/*      */       default:
/* 1823 */         escherBitmapBlip2 = new EscherBitmapBlip();
/* 1824 */         escherBitmapBlip1 = escherBitmapBlip2;
/* 1825 */         escherBitmapBlip2.setUID(arrayOfByte);
/* 1826 */         escherBitmapBlip2.setMarker((byte)-1);
/* 1827 */         escherBitmapBlip2.setPictureData(paramArrayOfbyte);
/* 1828 */         i = paramArrayOfbyte.length + 25;
/* 1829 */         c = 'ÿ';
/*      */         break;
/*      */     } 
/*      */     
/* 1833 */     escherBitmapBlip1.setRecordId((short)(-4072 + paramInt));
/* 1834 */     switch (paramInt) {
/*      */       
/*      */       case 2:
/* 1837 */         escherBitmapBlip1.setOptions((short)15680);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1858 */         escherBSERecord = new EscherBSERecord();
/* 1859 */         escherBSERecord.setRecordId((short)-4089);
/* 1860 */         escherBSERecord.setOptions((short)(0x2 | paramInt << 4));
/* 1861 */         escherBSERecord.setBlipTypeMacOS((byte)paramInt);
/* 1862 */         escherBSERecord.setBlipTypeWin32((byte)paramInt);
/* 1863 */         escherBSERecord.setUid(arrayOfByte);
/* 1864 */         escherBSERecord.setTag(c);
/* 1865 */         escherBSERecord.setSize(i);
/* 1866 */         escherBSERecord.setRef(0);
/* 1867 */         escherBSERecord.setOffset(0);
/* 1868 */         escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1);
/*      */         
/* 1870 */         return this.workbook.addBSERecord(escherBSERecord);case 3: escherBitmapBlip1.setOptions((short)8544); escherBSERecord = new EscherBSERecord(); escherBSERecord.setRecordId((short)-4089); escherBSERecord.setOptions((short)(0x2 | paramInt << 4)); escherBSERecord.setBlipTypeMacOS((byte)paramInt); escherBSERecord.setBlipTypeWin32((byte)paramInt); escherBSERecord.setUid(arrayOfByte); escherBSERecord.setTag(c); escherBSERecord.setSize(i); escherBSERecord.setRef(0); escherBSERecord.setOffset(0); escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1); return this.workbook.addBSERecord(escherBSERecord);case 4: escherBitmapBlip1.setOptions((short)21536); escherBSERecord = new EscherBSERecord(); escherBSERecord.setRecordId((short)-4089); escherBSERecord.setOptions((short)(0x2 | paramInt << 4)); escherBSERecord.setBlipTypeMacOS((byte)paramInt); escherBSERecord.setBlipTypeWin32((byte)paramInt); escherBSERecord.setUid(arrayOfByte); escherBSERecord.setTag(c); escherBSERecord.setSize(i); escherBSERecord.setRef(0); escherBSERecord.setOffset(0); escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1); return this.workbook.addBSERecord(escherBSERecord);case 6: escherBitmapBlip1.setOptions((short)28160); escherBSERecord = new EscherBSERecord(); escherBSERecord.setRecordId((short)-4089); escherBSERecord.setOptions((short)(0x2 | paramInt << 4)); escherBSERecord.setBlipTypeMacOS((byte)paramInt); escherBSERecord.setBlipTypeWin32((byte)paramInt); escherBSERecord.setUid(arrayOfByte); escherBSERecord.setTag(c); escherBSERecord.setSize(i); escherBSERecord.setRef(0); escherBSERecord.setOffset(0); escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1); return this.workbook.addBSERecord(escherBSERecord);case 5: escherBitmapBlip1.setOptions((short)18080); escherBSERecord = new EscherBSERecord(); escherBSERecord.setRecordId((short)-4089); escherBSERecord.setOptions((short)(0x2 | paramInt << 4)); escherBSERecord.setBlipTypeMacOS((byte)paramInt); escherBSERecord.setBlipTypeWin32((byte)paramInt); escherBSERecord.setUid(arrayOfByte); escherBSERecord.setTag(c); escherBSERecord.setSize(i); escherBSERecord.setRef(0); escherBSERecord.setOffset(0); escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1); return this.workbook.addBSERecord(escherBSERecord);case 7: escherBitmapBlip1.setOptions((short)31360); escherBSERecord = new EscherBSERecord(); escherBSERecord.setRecordId((short)-4089); escherBSERecord.setOptions((short)(0x2 | paramInt << 4)); escherBSERecord.setBlipTypeMacOS((byte)paramInt); escherBSERecord.setBlipTypeWin32((byte)paramInt); escherBSERecord.setUid(arrayOfByte); escherBSERecord.setTag(c); escherBSERecord.setSize(i); escherBSERecord.setRef(0); escherBSERecord.setOffset(0); escherBSERecord.setBlipRecord((EscherBlipRecord)escherBitmapBlip1); return this.workbook.addBSERecord(escherBSERecord);
/*      */     } 
/*      */     throw new IllegalStateException("Unexpected picture format: " + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<HSSFPictureData> getAllPictures() {
/* 1882 */     ArrayList<HSSFPictureData> arrayList = new ArrayList();
/* 1883 */     for (Record record : this.workbook.getRecords()) {
/* 1884 */       if (record instanceof AbstractEscherHolderRecord) {
/* 1885 */         ((AbstractEscherHolderRecord)record).decode();
/* 1886 */         List<EscherRecord> list = ((AbstractEscherHolderRecord)record).getEscherRecords();
/* 1887 */         searchForPictures(list, arrayList);
/*      */       } 
/*      */     } 
/* 1890 */     return Collections.unmodifiableList(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void searchForPictures(List<EscherRecord> paramList, List<HSSFPictureData> paramList1) {
/* 1901 */     for (EscherRecord escherRecord : paramList) {
/*      */       
/* 1903 */       if (escherRecord instanceof EscherBSERecord) {
/*      */         
/* 1905 */         EscherBlipRecord escherBlipRecord = ((EscherBSERecord)escherRecord).getBlipRecord();
/* 1906 */         if (escherBlipRecord != null) {
/*      */ 
/*      */           
/* 1909 */           HSSFPictureData hSSFPictureData = new HSSFPictureData(escherBlipRecord);
/* 1910 */           paramList1.add(hSSFPictureData);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1917 */       searchForPictures(escherRecord.getChildRecords(), paramList1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected static Map<String, ClassID> getOleMap() {
/* 1923 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 1924 */     hashMap.put("PowerPoint Document", ClassID.PPT_SHOW);
/* 1925 */     for (String str : InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES) {
/* 1926 */       hashMap.put(str, ClassID.XLS_WORKBOOK);
/*      */     }
/*      */     
/* 1929 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   public int addOlePackage(POIFSFileSystem paramPOIFSFileSystem, String paramString1, String paramString2, String paramString3) throws IOException {
/* 1934 */     DirectoryNode directoryNode = paramPOIFSFileSystem.getRoot();
/* 1935 */     Map<String, ClassID> map = getOleMap();
/* 1936 */     for (Map.Entry<String, ClassID> entry : map.entrySet()) {
/* 1937 */       if (directoryNode.hasEntry((String)entry.getKey())) {
/* 1938 */         directoryNode.setStorageClsid((ClassID)entry.getValue());
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1943 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 1944 */     paramPOIFSFileSystem.writeFilesystem(byteArrayOutputStream);
/* 1945 */     return addOlePackage(byteArrayOutputStream.toByteArray(), paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int addOlePackage(byte[] paramArrayOfbyte, String paramString1, String paramString2, String paramString3) throws IOException {
/* 1951 */     if (this.directory == null) {
/* 1952 */       this.directory = (new NPOIFSFileSystem()).getRoot();
/* 1953 */       this.preserveNodes = true;
/*      */     } 
/*      */ 
/*      */     
/* 1957 */     byte b = 0;
/* 1958 */     DirectoryEntry directoryEntry = null;
/*      */     do {
/* 1960 */       String str = "MBD" + HexDump.toHex(++b);
/* 1961 */       if (this.directory.hasEntry(str))
/* 1962 */         continue;  directoryEntry = this.directory.createDirectory(str);
/* 1963 */       directoryEntry.setStorageClsid(ClassID.OLE10_PACKAGE);
/*      */     }
/* 1965 */     while (directoryEntry == null);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1970 */     byte[] arrayOfByte = { 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
/* 1971 */     directoryEntry.createDocument("\001Ole", new ByteArrayInputStream(arrayOfByte));
/*      */     
/* 1973 */     Ole10Native ole10Native = new Ole10Native(paramString1, paramString2, paramString3, paramArrayOfbyte);
/* 1974 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 1975 */     ole10Native.writeOut(byteArrayOutputStream);
/* 1976 */     directoryEntry.createDocument("\001Ole10Native", new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
/*      */     
/* 1978 */     return b;
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
/*      */   public int linkExternalWorkbook(String paramString, Workbook paramWorkbook) {
/* 1992 */     return this.workbook.linkExternalWorkbook(paramString, paramWorkbook);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWriteProtected() {
/* 1999 */     return this.workbook.isWriteProtected();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeProtectWorkbook(String paramString1, String paramString2) {
/* 2008 */     this.workbook.writeProtectWorkbook(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unwriteProtectWorkbook() {
/* 2015 */     this.workbook.unwriteProtectWorkbook();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<HSSFObjectData> getAllEmbeddedObjects() {
/* 2025 */     ArrayList<HSSFObjectData> arrayList = new ArrayList();
/* 2026 */     for (HSSFSheet hSSFSheet : this._sheets)
/*      */     {
/* 2028 */       getAllEmbeddedObjects(hSSFSheet, arrayList);
/*      */     }
/* 2030 */     return Collections.unmodifiableList(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getAllEmbeddedObjects(HSSFSheet paramHSSFSheet, List<HSSFObjectData> paramList) {
/* 2041 */     HSSFPatriarch hSSFPatriarch = paramHSSFSheet.getDrawingPatriarch();
/* 2042 */     if (null == hSSFPatriarch) {
/*      */       return;
/*      */     }
/* 2045 */     getAllEmbeddedObjects(hSSFPatriarch, paramList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void getAllEmbeddedObjects(HSSFShapeContainer paramHSSFShapeContainer, List<HSSFObjectData> paramList) {
/* 2055 */     for (HSSFShape hSSFShape : paramHSSFShapeContainer.getChildren()) {
/* 2056 */       if (hSSFShape instanceof HSSFObjectData) {
/* 2057 */         paramList.add((HSSFObjectData)hSSFShape); continue;
/* 2058 */       }  if (hSSFShape instanceof HSSFShapeContainer) {
/* 2059 */         getAllEmbeddedObjects((HSSFShapeContainer)hSSFShape, paramList);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public HSSFCreationHelper getCreationHelper() {
/* 2065 */     return new HSSFCreationHelper(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   UDFFinder getUDFFinder() {
/* 2076 */     return this._udfFinder;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addToolPack(UDFFinder paramUDFFinder) {
/* 2086 */     AggregatingUDFFinder aggregatingUDFFinder = (AggregatingUDFFinder)this._udfFinder;
/* 2087 */     aggregatingUDFFinder.add(paramUDFFinder);
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
/* 2109 */     InternalWorkbook internalWorkbook = getWorkbook();
/* 2110 */     RecalcIdRecord recalcIdRecord = internalWorkbook.getRecalcId();
/* 2111 */     recalcIdRecord.setEngineId(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getForceFormulaRecalculation() {
/* 2121 */     InternalWorkbook internalWorkbook = getWorkbook();
/* 2122 */     RecalcIdRecord recalcIdRecord = (RecalcIdRecord)internalWorkbook.findFirstRecordBySid((short)449);
/* 2123 */     return (recalcIdRecord != null && recalcIdRecord.getEngineId() != 0);
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
/*      */   public boolean changeExternalReference(String paramString1, String paramString2) {
/* 2136 */     return this.workbook.changeExternalReference(paramString1, paramString2);
/*      */   }
/*      */   
/*      */   public DirectoryNode getRootDirectory() {
/* 2140 */     return this.directory;
/*      */   }
/*      */   
/*      */   @Internal
/*      */   public InternalWorkbook getInternalWorkbook() {
/* 2145 */     return this.workbook;
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
/* 2156 */     return SpreadsheetVersion.EXCEL97;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */