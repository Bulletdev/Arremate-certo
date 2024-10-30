/*      */ package org.apache.poi.hssf.model;
/*      */ 
/*      */ import java.security.AccessControlException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.poi.ddf.EscherBSERecord;
/*      */ import org.apache.poi.ddf.EscherBoolProperty;
/*      */ import org.apache.poi.ddf.EscherContainerRecord;
/*      */ import org.apache.poi.ddf.EscherDgRecord;
/*      */ import org.apache.poi.ddf.EscherDggRecord;
/*      */ import org.apache.poi.ddf.EscherOptRecord;
/*      */ import org.apache.poi.ddf.EscherProperty;
/*      */ import org.apache.poi.ddf.EscherRGBProperty;
/*      */ import org.apache.poi.ddf.EscherRecord;
/*      */ import org.apache.poi.ddf.EscherSimpleProperty;
/*      */ import org.apache.poi.ddf.EscherSpRecord;
/*      */ import org.apache.poi.ddf.EscherSplitMenuColorsRecord;
/*      */ import org.apache.poi.hssf.record.BOFRecord;
/*      */ import org.apache.poi.hssf.record.BackupRecord;
/*      */ import org.apache.poi.hssf.record.BookBoolRecord;
/*      */ import org.apache.poi.hssf.record.BoundSheetRecord;
/*      */ import org.apache.poi.hssf.record.CodepageRecord;
/*      */ import org.apache.poi.hssf.record.CountryRecord;
/*      */ import org.apache.poi.hssf.record.DSFRecord;
/*      */ import org.apache.poi.hssf.record.DateWindow1904Record;
/*      */ import org.apache.poi.hssf.record.DrawingGroupRecord;
/*      */ import org.apache.poi.hssf.record.EOFRecord;
/*      */ import org.apache.poi.hssf.record.EscherAggregate;
/*      */ import org.apache.poi.hssf.record.ExtSSTRecord;
/*      */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*      */ import org.apache.poi.hssf.record.FileSharingRecord;
/*      */ import org.apache.poi.hssf.record.FnGroupCountRecord;
/*      */ import org.apache.poi.hssf.record.FontRecord;
/*      */ import org.apache.poi.hssf.record.FormatRecord;
/*      */ import org.apache.poi.hssf.record.HideObjRecord;
/*      */ import org.apache.poi.hssf.record.HyperlinkRecord;
/*      */ import org.apache.poi.hssf.record.InterfaceEndRecord;
/*      */ import org.apache.poi.hssf.record.InterfaceHdrRecord;
/*      */ import org.apache.poi.hssf.record.MMSRecord;
/*      */ import org.apache.poi.hssf.record.NameCommentRecord;
/*      */ import org.apache.poi.hssf.record.NameRecord;
/*      */ import org.apache.poi.hssf.record.PaletteRecord;
/*      */ import org.apache.poi.hssf.record.PasswordRecord;
/*      */ import org.apache.poi.hssf.record.PasswordRev4Record;
/*      */ import org.apache.poi.hssf.record.PrecisionRecord;
/*      */ import org.apache.poi.hssf.record.ProtectRecord;
/*      */ import org.apache.poi.hssf.record.ProtectionRev4Record;
/*      */ import org.apache.poi.hssf.record.RecalcIdRecord;
/*      */ import org.apache.poi.hssf.record.Record;
/*      */ import org.apache.poi.hssf.record.RefreshAllRecord;
/*      */ import org.apache.poi.hssf.record.SSTRecord;
/*      */ import org.apache.poi.hssf.record.StyleRecord;
/*      */ import org.apache.poi.hssf.record.TabIdRecord;
/*      */ import org.apache.poi.hssf.record.UseSelFSRecord;
/*      */ import org.apache.poi.hssf.record.WindowOneRecord;
/*      */ import org.apache.poi.hssf.record.WindowProtectRecord;
/*      */ import org.apache.poi.hssf.record.WriteAccessRecord;
/*      */ import org.apache.poi.hssf.record.WriteProtectRecord;
/*      */ import org.apache.poi.hssf.record.common.UnicodeString;
/*      */ import org.apache.poi.poifs.crypt.CryptoFunctions;
/*      */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*      */ import org.apache.poi.ss.formula.FormulaShifter;
/*      */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*      */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*      */ import org.apache.poi.ss.formula.ptg.OperandPtg;
/*      */ import org.apache.poi.ss.formula.ptg.Ptg;
/*      */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*      */ import org.apache.poi.ss.formula.udf.UDFFinder;
/*      */ import org.apache.poi.ss.usermodel.BuiltinFormats;
/*      */ import org.apache.poi.ss.usermodel.Workbook;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.LocaleUtil;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Internal
/*      */ public final class InternalWorkbook
/*      */ {
/*      */   private static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
/*  132 */   public static final String[] WORKBOOK_DIR_ENTRY_NAMES = new String[] { "Workbook", "WORKBOOK", "BOOK" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String OLD_WORKBOOK_DIR_ENTRY_NAME = "Book";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  144 */   private static final POILogger log = POILogFactory.getLogger(InternalWorkbook.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final short CODEPAGE = 1200;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  196 */   private final WorkbookRecordList records = new WorkbookRecordList(); protected SSTRecord sst;
/*      */   private LinkTable linkTable;
/*  198 */   private final List<BoundSheetRecord> boundsheets = new ArrayList<BoundSheetRecord>();
/*  199 */   private final List<FormatRecord> formats = new ArrayList<FormatRecord>();
/*  200 */   private final List<HyperlinkRecord> hyperlinks = new ArrayList<HyperlinkRecord>();
/*  201 */   private int numxfs = 0;
/*  202 */   private int numfonts = 0;
/*  203 */   private int maxformatid = -1; private boolean uses1904datewindowing = false;
/*      */   private DrawingManager2 drawingManager;
/*  205 */   private List<EscherBSERecord> escherBSERecords = new ArrayList<EscherBSERecord>(); private WindowOneRecord windowOne; private FileSharingRecord fileShare; private WriteAccessRecord writeAccess; private WriteProtectRecord writeProtect;
/*  206 */   private final Map<String, NameCommentRecord> commentRecords = new LinkedHashMap<String, NameCommentRecord>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InternalWorkbook createWorkbook(List<Record> paramList) {
/*  222 */     if (log.check(1)) {
/*  223 */       log.log(1, new Object[] { "Workbook (readfile) created with reclen=", Integer.valueOf(paramList.size()) });
/*      */     }
/*  225 */     InternalWorkbook internalWorkbook = new InternalWorkbook();
/*  226 */     ArrayList<Record> arrayList = new ArrayList(paramList.size() / 3);
/*  227 */     internalWorkbook.records.setRecords(arrayList);
/*      */     
/*      */     int i;
/*  230 */     for (i = 0; i < paramList.size(); i++) {
/*  231 */       NameCommentRecord nameCommentRecord; Record record = paramList.get(i);
/*      */       
/*  233 */       if (record.getSid() == 10) {
/*  234 */         arrayList.add(record);
/*  235 */         if (log.check(1))
/*  236 */           log.log(1, new Object[] { "found workbook eof record at " + i }); 
/*      */         break;
/*      */       } 
/*  239 */       switch (record.getSid()) {
/*      */         
/*      */         case 133:
/*  242 */           if (log.check(1))
/*  243 */             log.log(1, new Object[] { "found boundsheet record at " + i }); 
/*  244 */           internalWorkbook.boundsheets.add((BoundSheetRecord)record);
/*  245 */           internalWorkbook.records.setBspos(i);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  343 */           arrayList.add(record); break;case 252: if (log.check(1)) log.log(1, new Object[] { "found sst record at " + i });  internalWorkbook.sst = (SSTRecord)record; arrayList.add(record); break;case 49: if (log.check(1)) log.log(1, new Object[] { "found font record at " + i });  internalWorkbook.records.setFontpos(i); internalWorkbook.numfonts++; arrayList.add(record); break;case 224: if (log.check(1)) log.log(1, new Object[] { "found XF record at " + i });  internalWorkbook.records.setXfpos(i); internalWorkbook.numxfs++; arrayList.add(record); break;case 317: if (log.check(1)) log.log(1, new Object[] { "found tabid record at " + i });  internalWorkbook.records.setTabpos(i); arrayList.add(record); break;case 18: if (log.check(1)) log.log(1, new Object[] { "found protect record at " + i });  internalWorkbook.records.setProtpos(i); arrayList.add(record); break;case 64: if (log.check(1)) log.log(1, new Object[] { "found backup record at " + i });  internalWorkbook.records.setBackuppos(i); arrayList.add(record); break;case 23: throw new RuntimeException("Extern sheet is part of LinkTable");case 24: case 430: if (log.check(1)) log.log(1, new Object[] { "found SupBook record at " + i });  internalWorkbook.linkTable = new LinkTable(paramList, i, internalWorkbook.records, internalWorkbook.commentRecords); i += internalWorkbook.linkTable.getRecordCount() - 1; break;case 1054: if (log.check(1)) log.log(1, new Object[] { "found format record at " + i });  internalWorkbook.formats.add((FormatRecord)record); internalWorkbook.maxformatid = (internalWorkbook.maxformatid >= ((FormatRecord)record).getIndexCode()) ? internalWorkbook.maxformatid : ((FormatRecord)record).getIndexCode(); arrayList.add(record); break;case 34: if (log.check(1)) log.log(1, new Object[] { "found datewindow1904 record at " + i });  internalWorkbook.uses1904datewindowing = (((DateWindow1904Record)record).getWindowing() == 1); arrayList.add(record); break;case 146: if (log.check(1)) log.log(1, new Object[] { "found palette record at " + i });  internalWorkbook.records.setPalettepos(i); arrayList.add(record); break;case 61: if (log.check(1)) log.log(1, new Object[] { "found WindowOneRecord at " + i });  internalWorkbook.windowOne = (WindowOneRecord)record; arrayList.add(record); break;case 92: if (log.check(1)) log.log(1, new Object[] { "found WriteAccess at " + i });  internalWorkbook.writeAccess = (WriteAccessRecord)record; arrayList.add(record); break;case 134: if (log.check(1)) log.log(1, new Object[] { "found WriteProtect at " + i });  internalWorkbook.writeProtect = (WriteProtectRecord)record; arrayList.add(record); break;case 91: if (log.check(1)) log.log(1, new Object[] { "found FileSharing at " + i });  internalWorkbook.fileShare = (FileSharingRecord)record; arrayList.add(record); break;case 2196: nameCommentRecord = (NameCommentRecord)record; if (log.check(1)) log.log(1, new Object[] { "found NameComment at " + i });  internalWorkbook.commentRecords.put(nameCommentRecord.getNameText(), nameCommentRecord); arrayList.add(record); break;default: if (log.check(1)) log.log(1, new Object[] { "ignoring record (sid=" + record.getSid() + ") at " + i });  arrayList.add(record);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/*  353 */     for (; i < paramList.size(); i++) {
/*  354 */       Record record = paramList.get(i);
/*  355 */       switch (record.getSid()) {
/*      */         case 440:
/*  357 */           internalWorkbook.hyperlinks.add((HyperlinkRecord)record);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/*  364 */     if (internalWorkbook.windowOne == null) {
/*  365 */       internalWorkbook.windowOne = createWindowOne();
/*      */     }
/*  367 */     if (log.check(1))
/*  368 */       log.log(1, new Object[] { "exit create workbook from existing file function" }); 
/*  369 */     return internalWorkbook;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InternalWorkbook createWorkbook() {
/*  380 */     if (log.check(1))
/*  381 */       log.log(1, new Object[] { "creating new workbook from scratch" }); 
/*  382 */     InternalWorkbook internalWorkbook = new InternalWorkbook();
/*  383 */     ArrayList<Record> arrayList = new ArrayList(30);
/*  384 */     internalWorkbook.records.setRecords(arrayList);
/*  385 */     List<FormatRecord> list = internalWorkbook.formats;
/*      */     
/*  387 */     arrayList.add(createBOF());
/*  388 */     arrayList.add(new InterfaceHdrRecord(1200));
/*  389 */     arrayList.add(createMMS());
/*  390 */     arrayList.add(InterfaceEndRecord.instance);
/*  391 */     arrayList.add(createWriteAccess());
/*  392 */     arrayList.add(createCodepage());
/*  393 */     arrayList.add(createDSF());
/*  394 */     arrayList.add(createTabId());
/*  395 */     internalWorkbook.records.setTabpos(arrayList.size() - 1);
/*  396 */     arrayList.add(createFnGroupCount());
/*  397 */     arrayList.add(createWindowProtect());
/*  398 */     arrayList.add(createProtect());
/*  399 */     internalWorkbook.records.setProtpos(arrayList.size() - 1);
/*  400 */     arrayList.add(createPassword());
/*  401 */     arrayList.add(createProtectionRev4());
/*  402 */     arrayList.add(createPasswordRev4());
/*  403 */     internalWorkbook.windowOne = createWindowOne();
/*  404 */     arrayList.add(internalWorkbook.windowOne);
/*  405 */     arrayList.add(createBackup());
/*  406 */     internalWorkbook.records.setBackuppos(arrayList.size() - 1);
/*  407 */     arrayList.add(createHideObj());
/*  408 */     arrayList.add(createDateWindow1904());
/*  409 */     arrayList.add(createPrecision());
/*  410 */     arrayList.add(createRefreshAll());
/*  411 */     arrayList.add(createBookBool());
/*  412 */     arrayList.add(createFont());
/*  413 */     arrayList.add(createFont());
/*  414 */     arrayList.add(createFont());
/*  415 */     arrayList.add(createFont());
/*  416 */     internalWorkbook.records.setFontpos(arrayList.size() - 1);
/*  417 */     internalWorkbook.numfonts = 4;
/*      */     
/*      */     byte b1;
/*  420 */     for (b1 = 0; b1 <= 7; b1++) {
/*  421 */       FormatRecord formatRecord = createFormat(b1);
/*  422 */       internalWorkbook.maxformatid = (internalWorkbook.maxformatid >= formatRecord.getIndexCode()) ? internalWorkbook.maxformatid : formatRecord.getIndexCode();
/*  423 */       list.add(formatRecord);
/*  424 */       arrayList.add(formatRecord);
/*      */     } 
/*      */     
/*  427 */     for (b1 = 0; b1 < 21; b1++) {
/*  428 */       arrayList.add(createExtendedFormat(b1));
/*  429 */       internalWorkbook.numxfs++;
/*      */     } 
/*  431 */     internalWorkbook.records.setXfpos(arrayList.size() - 1);
/*  432 */     for (b1 = 0; b1 < 6; b1++) {
/*  433 */       arrayList.add(createStyle(b1));
/*      */     }
/*  435 */     arrayList.add(createUseSelFS());
/*      */     
/*  437 */     b1 = 1; byte b2;
/*  438 */     for (b2 = 0; b2 < b1; b2++) {
/*  439 */       BoundSheetRecord boundSheetRecord = createBoundSheet(b2);
/*      */       
/*  441 */       arrayList.add(boundSheetRecord);
/*  442 */       internalWorkbook.boundsheets.add(boundSheetRecord);
/*  443 */       internalWorkbook.records.setBspos(arrayList.size() - 1);
/*      */     } 
/*  445 */     arrayList.add(createCountry());
/*  446 */     for (b2 = 0; b2 < b1; b2++) {
/*  447 */       internalWorkbook.getOrCreateLinkTable().checkExternSheet(b2);
/*      */     }
/*  449 */     internalWorkbook.sst = new SSTRecord();
/*  450 */     arrayList.add(internalWorkbook.sst);
/*  451 */     arrayList.add(createExtendedSST());
/*      */     
/*  453 */     arrayList.add(EOFRecord.instance);
/*  454 */     if (log.check(1))
/*  455 */       log.log(1, new Object[] { "exit create new workbook from scratch" }); 
/*  456 */     return internalWorkbook;
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
/*      */   public NameRecord getSpecificBuiltinRecord(byte paramByte, int paramInt) {
/*  468 */     return getOrCreateLinkTable().getSpecificBuiltinRecord(paramByte, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeBuiltinRecord(byte paramByte, int paramInt) {
/*  477 */     this.linkTable.removeBuiltinRecord(paramByte, paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNumRecords() {
/*  482 */     return this.records.size();
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
/*      */   public FontRecord getFontRecordAt(int paramInt) {
/*  495 */     int i = paramInt;
/*      */     
/*  497 */     if (i > 4) {
/*  498 */       i--;
/*      */     }
/*  500 */     if (i > this.numfonts - 1) {
/*  501 */       throw new ArrayIndexOutOfBoundsException("There are only " + this.numfonts + " font records, you asked for " + paramInt);
/*      */     }
/*      */ 
/*      */     
/*  505 */     return (FontRecord)this.records.get(this.records.getFontpos() - this.numfonts - 1 + i);
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
/*      */   public int getFontIndex(FontRecord paramFontRecord) {
/*  521 */     for (byte b = 0; b <= this.numfonts; b++) {
/*  522 */       FontRecord fontRecord = (FontRecord)this.records.get(this.records.getFontpos() - this.numfonts - 1 + b);
/*      */       
/*  524 */       if (fontRecord == paramFontRecord) {
/*      */         
/*  526 */         if (b > 3) {
/*  527 */           return b + 1;
/*      */         }
/*  529 */         return b;
/*      */       } 
/*      */     } 
/*  532 */     throw new IllegalArgumentException("Could not find that font!");
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
/*      */   public FontRecord createNewFont() {
/*  544 */     FontRecord fontRecord = createFont();
/*      */     
/*  546 */     this.records.add(this.records.getFontpos() + 1, (Record)fontRecord);
/*  547 */     this.records.setFontpos(this.records.getFontpos() + 1);
/*  548 */     this.numfonts++;
/*  549 */     return fontRecord;
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
/*      */   public void removeFontRecord(FontRecord paramFontRecord) {
/*  561 */     this.records.remove(paramFontRecord);
/*  562 */     this.numfonts--;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumberOfFontRecords() {
/*  572 */     return this.numfonts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetBof(int paramInt1, int paramInt2) {
/*  583 */     if (log.check(1)) {
/*  584 */       log.log(1, new Object[] { "setting bof for sheetnum =", Integer.valueOf(paramInt1), " at pos=", Integer.valueOf(paramInt2) });
/*      */     }
/*  586 */     checkSheets(paramInt1);
/*  587 */     getBoundSheetRec(paramInt1).setPositionOfBof(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private BoundSheetRecord getBoundSheetRec(int paramInt) {
/*  592 */     return this.boundsheets.get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BackupRecord getBackupRecord() {
/*  601 */     return (BackupRecord)this.records.get(this.records.getBackuppos());
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
/*      */   public void setSheetName(int paramInt, String paramString) {
/*  614 */     checkSheets(paramInt);
/*      */ 
/*      */     
/*  617 */     if (paramString.length() > 31) paramString = paramString.substring(0, 31);
/*      */     
/*  619 */     BoundSheetRecord boundSheetRecord = this.boundsheets.get(paramInt);
/*  620 */     boundSheetRecord.setSheetname(paramString);
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
/*      */   public boolean doesContainsSheetName(String paramString, int paramInt) {
/*  632 */     String str = paramString;
/*  633 */     if (str.length() > 31) {
/*  634 */       str = str.substring(0, 31);
/*      */     }
/*  636 */     for (byte b = 0; b < this.boundsheets.size(); b++) {
/*  637 */       BoundSheetRecord boundSheetRecord = getBoundSheetRec(b);
/*  638 */       if (paramInt != b) {
/*      */ 
/*      */         
/*  641 */         String str1 = boundSheetRecord.getSheetname();
/*  642 */         if (str1.length() > 31) {
/*  643 */           str1 = str1.substring(0, 31);
/*      */         }
/*  645 */         if (str.equalsIgnoreCase(str1))
/*  646 */           return true; 
/*      */       } 
/*      */     } 
/*  649 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetOrder(String paramString, int paramInt) {
/*  659 */     int i = getSheetIndex(paramString);
/*      */     
/*  661 */     this.boundsheets.add(paramInt, this.boundsheets.remove(i));
/*      */ 
/*      */     
/*  664 */     int j = this.records.getBspos();
/*  665 */     int k = j - this.boundsheets.size() - 1;
/*  666 */     Record record = this.records.get(k + i);
/*  667 */     this.records.remove(k + i);
/*  668 */     this.records.add(k + paramInt, record);
/*  669 */     this.records.setBspos(j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getSheetName(int paramInt) {
/*  679 */     return getBoundSheetRec(paramInt).getSheetname();
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
/*      */   public boolean isSheetHidden(int paramInt) {
/*  692 */     return getBoundSheetRec(paramInt).isHidden();
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
/*      */   public boolean isSheetVeryHidden(int paramInt) {
/*  705 */     return getBoundSheetRec(paramInt).isVeryHidden();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSheetHidden(int paramInt, boolean paramBoolean) {
/*  715 */     getBoundSheetRec(paramInt).setHidden(paramBoolean);
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
/*      */   public void setSheetHidden(int paramInt1, int paramInt2) {
/*  728 */     BoundSheetRecord boundSheetRecord = getBoundSheetRec(paramInt1);
/*  729 */     boolean bool1 = false;
/*  730 */     boolean bool2 = false;
/*  731 */     if (paramInt2 != 0)
/*  732 */       if (paramInt2 == 1) {
/*  733 */         bool1 = true;
/*  734 */       } else if (paramInt2 == 2) {
/*  735 */         bool2 = true;
/*      */       } else {
/*  737 */         throw new IllegalArgumentException("Invalid hidden flag " + paramInt2 + " given, must be 0, 1 or 2");
/*      */       }  
/*  739 */     boundSheetRecord.setHidden(bool1);
/*  740 */     boundSheetRecord.setVeryHidden(bool2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getSheetIndex(String paramString) {
/*  750 */     byte b = -1;
/*      */     
/*  752 */     for (byte b1 = 0; b1 < this.boundsheets.size(); b1++) {
/*  753 */       String str = getSheetName(b1);
/*      */       
/*  755 */       if (str.equalsIgnoreCase(paramString)) {
/*  756 */         b = b1;
/*      */         break;
/*      */       } 
/*      */     } 
/*  760 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void checkSheets(int paramInt) {
/*  768 */     if (this.boundsheets.size() <= paramInt) {
/*  769 */       if (this.boundsheets.size() + 1 <= paramInt) {
/*  770 */         throw new RuntimeException("Sheet number out of bounds!");
/*      */       }
/*  772 */       BoundSheetRecord boundSheetRecord = createBoundSheet(paramInt);
/*      */       
/*  774 */       this.records.add(this.records.getBspos() + 1, (Record)boundSheetRecord);
/*  775 */       this.records.setBspos(this.records.getBspos() + 1);
/*  776 */       this.boundsheets.add(boundSheetRecord);
/*  777 */       getOrCreateLinkTable().checkExternSheet(paramInt);
/*  778 */       fixTabIdRecord();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeSheet(int paramInt) {
/*  786 */     if (this.boundsheets.size() > paramInt) {
/*  787 */       this.records.remove(this.records.getBspos() - this.boundsheets.size() - 1 + paramInt);
/*  788 */       this.boundsheets.remove(paramInt);
/*  789 */       fixTabIdRecord();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  799 */     int i = paramInt + 1;
/*  800 */     for (byte b = 0; b < getNumNames(); b++) {
/*  801 */       NameRecord nameRecord = getNameRecord(b);
/*      */       
/*  803 */       if (nameRecord.getSheetNumber() == i) {
/*      */         
/*  805 */         nameRecord.setSheetNumber(0);
/*  806 */       } else if (nameRecord.getSheetNumber() > i) {
/*      */ 
/*      */         
/*  809 */         nameRecord.setSheetNumber(nameRecord.getSheetNumber() - 1);
/*      */       } 
/*      */     } 
/*      */     
/*  813 */     if (this.linkTable != null)
/*      */     {
/*      */       
/*  816 */       this.linkTable.removeSheet(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void fixTabIdRecord() {
/*  824 */     Record record = this.records.get(this.records.getTabpos());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  829 */     if (this.records.getTabpos() <= 0) {
/*      */       return;
/*      */     }
/*      */     
/*  833 */     TabIdRecord tabIdRecord = (TabIdRecord)record;
/*  834 */     short[] arrayOfShort = new short[this.boundsheets.size()];
/*      */     short s;
/*  836 */     for (s = 0; s < arrayOfShort.length; s = (short)(s + 1)) {
/*  837 */       arrayOfShort[s] = s;
/*      */     }
/*  839 */     tabIdRecord.setTabIdArray(arrayOfShort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumSheets() {
/*  849 */     if (log.check(1))
/*  850 */       log.log(1, new Object[] { "getNumSheets=", Integer.valueOf(this.boundsheets.size()) }); 
/*  851 */     return this.boundsheets.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumExFormats() {
/*  861 */     if (log.check(1))
/*  862 */       log.log(1, new Object[] { "getXF=", Integer.valueOf(this.numxfs) }); 
/*  863 */     return this.numxfs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ExtendedFormatRecord getExFormatAt(int paramInt) {
/*  874 */     int i = this.records.getXfpos() - this.numxfs - 1;
/*      */     
/*  876 */     i += paramInt;
/*  877 */     return (ExtendedFormatRecord)this.records.get(i);
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
/*      */   public void removeExFormatRecord(ExtendedFormatRecord paramExtendedFormatRecord) {
/*  892 */     this.records.remove(paramExtendedFormatRecord);
/*  893 */     this.numxfs--;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeExFormatRecord(int paramInt) {
/*  904 */     int i = this.records.getXfpos() - this.numxfs - 1 + paramInt;
/*  905 */     this.records.remove(i);
/*  906 */     this.numxfs--;
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
/*      */   public ExtendedFormatRecord createCellXF() {
/*  918 */     ExtendedFormatRecord extendedFormatRecord = createExtendedFormat();
/*      */     
/*  920 */     this.records.add(this.records.getXfpos() + 1, (Record)extendedFormatRecord);
/*  921 */     this.records.setXfpos(this.records.getXfpos() + 1);
/*  922 */     this.numxfs++;
/*  923 */     return extendedFormatRecord;
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
/*      */   public StyleRecord getStyleRecord(int paramInt) {
/*  938 */     for (int i = this.records.getXfpos(); i < this.records.size(); i++) {
/*  939 */       Record record = this.records.get(i);
/*  940 */       if (!(record instanceof ExtendedFormatRecord))
/*      */       {
/*      */         
/*  943 */         if (record instanceof StyleRecord) {
/*      */ 
/*      */           
/*  946 */           StyleRecord styleRecord = (StyleRecord)record;
/*  947 */           if (styleRecord.getXFIndex() == paramInt)
/*  948 */             return styleRecord; 
/*      */         }  } 
/*      */     } 
/*  951 */     return null;
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
/*      */   public StyleRecord createStyleRecord(int paramInt) {
/*  966 */     StyleRecord styleRecord = new StyleRecord();
/*  967 */     styleRecord.setXFIndex(paramInt);
/*      */ 
/*      */     
/*  970 */     int i = -1;
/*  971 */     for (int j = this.records.getXfpos(); j < this.records.size() && i == -1; 
/*  972 */       j++) {
/*  973 */       Record record = this.records.get(j);
/*  974 */       if (!(record instanceof ExtendedFormatRecord) && !(record instanceof StyleRecord))
/*      */       {
/*      */ 
/*      */         
/*  978 */         i = j;
/*      */       }
/*      */     } 
/*  981 */     if (i == -1) {
/*  982 */       throw new IllegalStateException("No XF Records found!");
/*      */     }
/*  984 */     this.records.add(i, (Record)styleRecord);
/*      */     
/*  986 */     return styleRecord;
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
/*      */   public int addSSTString(UnicodeString paramUnicodeString) {
/* 1000 */     if (log.check(1))
/* 1001 */       log.log(1, new Object[] { "insert to sst string='", paramUnicodeString }); 
/* 1002 */     if (this.sst == null) {
/* 1003 */       insertSST();
/*      */     }
/* 1005 */     return this.sst.addString(paramUnicodeString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public UnicodeString getSSTString(int paramInt) {
/* 1014 */     if (this.sst == null) {
/* 1015 */       insertSST();
/*      */     }
/* 1017 */     UnicodeString unicodeString = this.sst.getString(paramInt);
/*      */     
/* 1019 */     if (log.check(1)) {
/* 1020 */       log.log(1, new Object[] { "Returning SST for index=", Integer.valueOf(paramInt), " String= ", unicodeString });
/*      */     }
/* 1022 */     return unicodeString;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertSST() {
/* 1033 */     if (log.check(1))
/* 1034 */       log.log(1, new Object[] { "creating new SST via insertSST!" }); 
/* 1035 */     this.sst = new SSTRecord();
/* 1036 */     this.records.add(this.records.size() - 1, (Record)createExtendedSST());
/* 1037 */     this.records.add(this.records.size() - 2, (Record)this.sst);
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
/*      */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 1077 */     if (log.check(1)) {
/* 1078 */       log.log(1, new Object[] { "Serializing Workbook with offsets" });
/*      */     }
/* 1080 */     int i = 0;
/*      */     
/* 1082 */     SSTRecord sSTRecord = null;
/* 1083 */     int j = 0;
/* 1084 */     boolean bool = false;
/* 1085 */     for (byte b = 0; b < this.records.size(); b++) {
/*      */       ExtSSTRecord extSSTRecord;
/*      */       
/* 1088 */       Record record = this.records.get(b);
/* 1089 */       int k = 0;
/* 1090 */       if (record instanceof SSTRecord) {
/*      */         
/* 1092 */         sSTRecord = (SSTRecord)record;
/* 1093 */         j = i;
/*      */       } 
/* 1095 */       if (record.getSid() == 255 && sSTRecord != null)
/*      */       {
/* 1097 */         extSSTRecord = sSTRecord.createExtSSTRecord(j + paramInt);
/*      */       }
/* 1099 */       if (extSSTRecord instanceof BoundSheetRecord) {
/* 1100 */         if (!bool) {
/* 1101 */           for (byte b1 = 0; b1 < this.boundsheets.size(); b1++) {
/* 1102 */             k += getBoundSheetRec(b1).serialize(i + paramInt + k, paramArrayOfbyte);
/*      */           }
/*      */           
/* 1105 */           bool = true;
/*      */         } 
/*      */       } else {
/* 1108 */         k = extSSTRecord.serialize(i + paramInt, paramArrayOfbyte);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1114 */       i += k;
/*      */     } 
/* 1116 */     if (log.check(1))
/* 1117 */       log.log(1, new Object[] { "Exiting serialize workbook" }); 
/* 1118 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void preSerialize() {
/* 1129 */     if (this.records.getTabpos() > 0) {
/* 1130 */       TabIdRecord tabIdRecord = (TabIdRecord)this.records.get(this.records.getTabpos());
/* 1131 */       if (tabIdRecord._tabids.length < this.boundsheets.size()) {
/* 1132 */         fixTabIdRecord();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getSize() {
/* 1139 */     int i = 0;
/*      */     
/* 1141 */     SSTRecord sSTRecord = null;
/* 1142 */     for (byte b = 0; b < this.records.size(); b++) {
/*      */       
/* 1144 */       Record record = this.records.get(b);
/* 1145 */       if (record instanceof SSTRecord) {
/* 1146 */         sSTRecord = (SSTRecord)record;
/*      */       }
/* 1148 */       if (record.getSid() == 255 && sSTRecord != null) {
/* 1149 */         i += sSTRecord.calcExtSSTRecordSize();
/*      */       } else {
/* 1151 */         i += record.getRecordSize();
/*      */       } 
/*      */     } 
/* 1154 */     return i;
/*      */   }
/*      */   
/*      */   private static BOFRecord createBOF() {
/* 1158 */     BOFRecord bOFRecord = new BOFRecord();
/*      */     
/* 1160 */     bOFRecord.setVersion(1536);
/* 1161 */     bOFRecord.setType(5);
/* 1162 */     bOFRecord.setBuild(4307);
/* 1163 */     bOFRecord.setBuildYear(1996);
/* 1164 */     bOFRecord.setHistoryBitMask(65);
/* 1165 */     bOFRecord.setRequiredVersion(6);
/* 1166 */     return bOFRecord;
/*      */   }
/*      */ 
/*      */   
/*      */   private static MMSRecord createMMS() {
/* 1171 */     MMSRecord mMSRecord = new MMSRecord();
/*      */     
/* 1173 */     mMSRecord.setAddMenuCount((byte)0);
/* 1174 */     mMSRecord.setDelMenuCount((byte)0);
/* 1175 */     return mMSRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static WriteAccessRecord createWriteAccess() {
/* 1182 */     WriteAccessRecord writeAccessRecord = new WriteAccessRecord();
/*      */     
/* 1184 */     String str = "POI";
/*      */     try {
/* 1186 */       String str1 = System.getProperty("user.name");
/*      */       
/* 1188 */       if (str1 == null) str1 = str;
/*      */       
/* 1190 */       writeAccessRecord.setUsername(str1);
/* 1191 */     } catch (AccessControlException accessControlException) {
/*      */ 
/*      */       
/* 1194 */       writeAccessRecord.setUsername(str);
/*      */     } 
/* 1196 */     return writeAccessRecord;
/*      */   }
/*      */   
/*      */   private static CodepageRecord createCodepage() {
/* 1200 */     CodepageRecord codepageRecord = new CodepageRecord();
/*      */     
/* 1202 */     codepageRecord.setCodepage((short)1200);
/* 1203 */     return codepageRecord;
/*      */   }
/*      */   
/*      */   private static DSFRecord createDSF() {
/* 1207 */     return new DSFRecord(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static TabIdRecord createTabId() {
/* 1214 */     return new TabIdRecord();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static FnGroupCountRecord createFnGroupCount() {
/* 1221 */     FnGroupCountRecord fnGroupCountRecord = new FnGroupCountRecord();
/*      */     
/* 1223 */     fnGroupCountRecord.setCount((short)14);
/* 1224 */     return fnGroupCountRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static WindowProtectRecord createWindowProtect() {
/* 1233 */     return new WindowProtectRecord(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ProtectRecord createProtect() {
/* 1242 */     return new ProtectRecord(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PasswordRecord createPassword() {
/* 1249 */     return new PasswordRecord(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ProtectionRev4Record createProtectionRev4() {
/* 1256 */     return new ProtectionRev4Record(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PasswordRev4Record createPasswordRev4() {
/* 1263 */     return new PasswordRev4Record(0);
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
/*      */   private static WindowOneRecord createWindowOne() {
/* 1279 */     WindowOneRecord windowOneRecord = new WindowOneRecord();
/*      */     
/* 1281 */     windowOneRecord.setHorizontalHold((short)360);
/* 1282 */     windowOneRecord.setVerticalHold((short)270);
/* 1283 */     windowOneRecord.setWidth((short)14940);
/* 1284 */     windowOneRecord.setHeight((short)9150);
/* 1285 */     windowOneRecord.setOptions((short)56);
/* 1286 */     windowOneRecord.setActiveSheetIndex(0);
/* 1287 */     windowOneRecord.setFirstVisibleTab(0);
/* 1288 */     windowOneRecord.setNumSelectedTabs((short)1);
/* 1289 */     windowOneRecord.setTabWidthRatio((short)600);
/* 1290 */     return windowOneRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BackupRecord createBackup() {
/* 1297 */     BackupRecord backupRecord = new BackupRecord();
/*      */     
/* 1299 */     backupRecord.setBackup((short)0);
/* 1300 */     return backupRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static HideObjRecord createHideObj() {
/* 1307 */     HideObjRecord hideObjRecord = new HideObjRecord();
/* 1308 */     hideObjRecord.setHideObj((short)0);
/* 1309 */     return hideObjRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DateWindow1904Record createDateWindow1904() {
/* 1316 */     DateWindow1904Record dateWindow1904Record = new DateWindow1904Record();
/*      */     
/* 1318 */     dateWindow1904Record.setWindowing((short)0);
/* 1319 */     return dateWindow1904Record;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PrecisionRecord createPrecision() {
/* 1326 */     PrecisionRecord precisionRecord = new PrecisionRecord();
/* 1327 */     precisionRecord.setFullPrecision(true);
/* 1328 */     return precisionRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static RefreshAllRecord createRefreshAll() {
/* 1335 */     return new RefreshAllRecord(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static BookBoolRecord createBookBool() {
/* 1342 */     BookBoolRecord bookBoolRecord = new BookBoolRecord();
/* 1343 */     bookBoolRecord.setSaveLinkValues((short)0);
/* 1344 */     return bookBoolRecord;
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
/*      */   private static FontRecord createFont() {
/* 1357 */     FontRecord fontRecord = new FontRecord();
/*      */     
/* 1359 */     fontRecord.setFontHeight((short)200);
/* 1360 */     fontRecord.setAttributes((short)0);
/* 1361 */     fontRecord.setColorPaletteIndex('翿');
/* 1362 */     fontRecord.setBoldWeight((short)400);
/* 1363 */     fontRecord.setFontName("Arial");
/* 1364 */     return fontRecord;
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
/*      */   private static FormatRecord createFormat(int paramInt) {
/* 1377 */     switch (paramInt) { case 0:
/* 1378 */         return new FormatRecord(5, BuiltinFormats.getBuiltinFormat(5));
/* 1379 */       case 1: return new FormatRecord(6, BuiltinFormats.getBuiltinFormat(6));
/* 1380 */       case 2: return new FormatRecord(7, BuiltinFormats.getBuiltinFormat(7));
/* 1381 */       case 3: return new FormatRecord(8, BuiltinFormats.getBuiltinFormat(8));
/* 1382 */       case 4: return new FormatRecord(42, BuiltinFormats.getBuiltinFormat(42));
/* 1383 */       case 5: return new FormatRecord(41, BuiltinFormats.getBuiltinFormat(41));
/* 1384 */       case 6: return new FormatRecord(44, BuiltinFormats.getBuiltinFormat(44));
/* 1385 */       case 7: return new FormatRecord(43, BuiltinFormats.getBuiltinFormat(43)); }
/*      */     
/* 1387 */     throw new IllegalArgumentException("Unexpected id " + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ExtendedFormatRecord createExtendedFormat(int paramInt) {
/* 1396 */     ExtendedFormatRecord extendedFormatRecord = new ExtendedFormatRecord();
/*      */     
/* 1398 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1401 */         extendedFormatRecord.setFontIndex((short)0);
/* 1402 */         extendedFormatRecord.setFormatIndex((short)0);
/* 1403 */         extendedFormatRecord.setCellOptions((short)-11);
/* 1404 */         extendedFormatRecord.setAlignmentOptions((short)32);
/* 1405 */         extendedFormatRecord.setIndentionOptions((short)0);
/* 1406 */         extendedFormatRecord.setBorderOptions((short)0);
/* 1407 */         extendedFormatRecord.setPaletteOptions((short)0);
/* 1408 */         extendedFormatRecord.setAdtlPaletteOptions((short)0);
/* 1409 */         extendedFormatRecord.setFillPaletteOptions((short)8384);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1718 */         return extendedFormatRecord;case 1: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 2: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 3: extendedFormatRecord.setFontIndex((short)2); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 4: extendedFormatRecord.setFontIndex((short)2); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 5: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 6: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 7: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 8: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 9: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 10: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 11: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 12: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 13: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 14: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-3072); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 15: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)0); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 16: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)43); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 17: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)41); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 18: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)44); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 19: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)42); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 20: extendedFormatRecord.setFontIndex((short)1); extendedFormatRecord.setFormatIndex((short)9); extendedFormatRecord.setCellOptions((short)-11); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)-2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 21: extendedFormatRecord.setFontIndex((short)5); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)2048); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 22: extendedFormatRecord.setFontIndex((short)6); extendedFormatRecord.setFormatIndex((short)0); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)23552); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 23: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)49); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)23552); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 24: extendedFormatRecord.setFontIndex((short)0); extendedFormatRecord.setFormatIndex((short)8); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)23552); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;case 25: extendedFormatRecord.setFontIndex((short)6); extendedFormatRecord.setFormatIndex((short)8); extendedFormatRecord.setCellOptions((short)1); extendedFormatRecord.setAlignmentOptions((short)32); extendedFormatRecord.setIndentionOptions((short)23552); extendedFormatRecord.setBorderOptions((short)0); extendedFormatRecord.setPaletteOptions((short)0); extendedFormatRecord.setAdtlPaletteOptions((short)0); extendedFormatRecord.setFillPaletteOptions((short)8384); return extendedFormatRecord;
/*      */     } 
/*      */     throw new IllegalStateException("Unrecognized format id: " + paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static ExtendedFormatRecord createExtendedFormat() {
/* 1726 */     ExtendedFormatRecord extendedFormatRecord = new ExtendedFormatRecord();
/*      */     
/* 1728 */     extendedFormatRecord.setFontIndex((short)0);
/* 1729 */     extendedFormatRecord.setFormatIndex((short)0);
/* 1730 */     extendedFormatRecord.setCellOptions((short)1);
/* 1731 */     extendedFormatRecord.setAlignmentOptions((short)32);
/* 1732 */     extendedFormatRecord.setIndentionOptions((short)0);
/* 1733 */     extendedFormatRecord.setBorderOptions((short)0);
/* 1734 */     extendedFormatRecord.setPaletteOptions((short)0);
/* 1735 */     extendedFormatRecord.setAdtlPaletteOptions((short)0);
/* 1736 */     extendedFormatRecord.setFillPaletteOptions((short)8384);
/* 1737 */     extendedFormatRecord.setTopBorderPaletteIdx((short)8);
/* 1738 */     extendedFormatRecord.setBottomBorderPaletteIdx((short)8);
/* 1739 */     extendedFormatRecord.setLeftBorderPaletteIdx((short)8);
/* 1740 */     extendedFormatRecord.setRightBorderPaletteIdx((short)8);
/* 1741 */     return extendedFormatRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static StyleRecord createStyle(int paramInt) {
/* 1750 */     StyleRecord styleRecord = new StyleRecord();
/*      */     
/* 1752 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1755 */         styleRecord.setXFIndex(16);
/* 1756 */         styleRecord.setBuiltinStyle(3);
/* 1757 */         styleRecord.setOutlineStyleLevel(-1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1793 */         return styleRecord;case 1: styleRecord.setXFIndex(17); styleRecord.setBuiltinStyle(6); styleRecord.setOutlineStyleLevel(-1); return styleRecord;case 2: styleRecord.setXFIndex(18); styleRecord.setBuiltinStyle(4); styleRecord.setOutlineStyleLevel(-1); return styleRecord;case 3: styleRecord.setXFIndex(19); styleRecord.setBuiltinStyle(7); styleRecord.setOutlineStyleLevel(-1); return styleRecord;case 4: styleRecord.setXFIndex(0); styleRecord.setBuiltinStyle(0); styleRecord.setOutlineStyleLevel(-1); return styleRecord;case 5: styleRecord.setXFIndex(20); styleRecord.setBuiltinStyle(5); styleRecord.setOutlineStyleLevel(-1); return styleRecord;
/*      */     } 
/*      */     throw new IllegalStateException("Unrecognized style id: " + paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private static PaletteRecord createPalette() {
/* 1800 */     return new PaletteRecord();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static UseSelFSRecord createUseSelFS() {
/* 1807 */     return new UseSelFSRecord(false);
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
/*      */   private static BoundSheetRecord createBoundSheet(int paramInt) {
/* 1819 */     return new BoundSheetRecord("Sheet" + (paramInt + 1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CountryRecord createCountry() {
/* 1827 */     CountryRecord countryRecord = new CountryRecord();
/*      */     
/* 1829 */     countryRecord.setDefaultCountry((short)1);
/*      */ 
/*      */     
/* 1832 */     if (LocaleUtil.getUserLocale().toString().equals("ru_RU")) {
/* 1833 */       countryRecord.setCurrentCountry((short)7);
/*      */     } else {
/*      */       
/* 1836 */       countryRecord.setCurrentCountry((short)1);
/*      */     } 
/*      */     
/* 1839 */     return countryRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static ExtSSTRecord createExtendedSST() {
/* 1848 */     ExtSSTRecord extSSTRecord = new ExtSSTRecord();
/* 1849 */     extSSTRecord.setNumStringsPerBucket((short)8);
/* 1850 */     return extSSTRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LinkTable getOrCreateLinkTable() {
/* 1858 */     if (this.linkTable == null) {
/* 1859 */       this.linkTable = new LinkTable((short)getNumSheets(), this.records);
/*      */     }
/* 1861 */     return this.linkTable;
/*      */   }
/*      */   
/*      */   public int linkExternalWorkbook(String paramString, Workbook paramWorkbook) {
/* 1865 */     return getOrCreateLinkTable().linkExternalWorkbook(paramString, paramWorkbook);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String findSheetFirstNameFromExternSheet(int paramInt) {
/* 1874 */     int i = this.linkTable.getFirstInternalSheetIndexForExtIndex(paramInt);
/* 1875 */     return findSheetNameFromIndex(i);
/*      */   }
/*      */   public String findSheetLastNameFromExternSheet(int paramInt) {
/* 1878 */     int i = this.linkTable.getLastInternalSheetIndexForExtIndex(paramInt);
/* 1879 */     return findSheetNameFromIndex(i);
/*      */   }
/*      */   private String findSheetNameFromIndex(int paramInt) {
/* 1882 */     if (paramInt < 0)
/*      */     {
/*      */       
/* 1885 */       return "";
/*      */     }
/* 1887 */     if (paramInt >= this.boundsheets.size())
/*      */     {
/* 1889 */       return "";
/*      */     }
/* 1891 */     return getSheetName(paramInt);
/*      */   }
/*      */   
/*      */   public EvaluationWorkbook.ExternalSheet getExternalSheet(int paramInt) {
/* 1895 */     String[] arrayOfString = this.linkTable.getExternalBookAndSheetName(paramInt);
/* 1896 */     if (arrayOfString == null) {
/* 1897 */       return null;
/*      */     }
/* 1899 */     if (arrayOfString.length == 2) {
/* 1900 */       return new EvaluationWorkbook.ExternalSheet(arrayOfString[0], arrayOfString[1]);
/*      */     }
/* 1902 */     return (EvaluationWorkbook.ExternalSheet)new EvaluationWorkbook.ExternalSheetRange(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
/*      */   }
/*      */   
/*      */   public EvaluationWorkbook.ExternalName getExternalName(int paramInt1, int paramInt2) {
/* 1906 */     String str = this.linkTable.resolveNameXText(paramInt1, paramInt2, this);
/* 1907 */     if (str == null) {
/* 1908 */       return null;
/*      */     }
/* 1910 */     int i = this.linkTable.resolveNameXIx(paramInt1, paramInt2);
/* 1911 */     return new EvaluationWorkbook.ExternalName(str, paramInt2, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getFirstSheetIndexFromExternSheetIndex(int paramInt) {
/* 1921 */     return this.linkTable.getFirstInternalSheetIndexForExtIndex(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getLastSheetIndexFromExternSheetIndex(int paramInt) {
/* 1932 */     return this.linkTable.getLastInternalSheetIndexForExtIndex(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short checkExternSheet(int paramInt) {
/* 1942 */     return (short)getOrCreateLinkTable().checkExternSheet(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short checkExternSheet(int paramInt1, int paramInt2) {
/* 1952 */     return (short)getOrCreateLinkTable().checkExternSheet(paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public int getExternalSheetIndex(String paramString1, String paramString2) {
/* 1956 */     return getOrCreateLinkTable().getExternalSheetIndex(paramString1, paramString2, paramString2);
/*      */   }
/*      */   public int getExternalSheetIndex(String paramString1, String paramString2, String paramString3) {
/* 1959 */     return getOrCreateLinkTable().getExternalSheetIndex(paramString1, paramString2, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getNumNames() {
/* 1967 */     if (this.linkTable == null) {
/* 1968 */       return 0;
/*      */     }
/* 1970 */     return this.linkTable.getNumNames();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NameRecord getNameRecord(int paramInt) {
/* 1979 */     return this.linkTable.getNameRecord(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NameCommentRecord getNameCommentRecord(NameRecord paramNameRecord) {
/* 1988 */     return this.commentRecords.get(paramNameRecord.getNameText());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NameRecord createName() {
/* 1996 */     return addName(new NameRecord());
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
/*      */   public NameRecord addName(NameRecord paramNameRecord) {
/* 2009 */     LinkTable linkTable = getOrCreateLinkTable();
/* 2010 */     linkTable.addName(paramNameRecord);
/*      */     
/* 2012 */     return paramNameRecord;
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
/*      */   public NameRecord createBuiltInName(byte paramByte, int paramInt) {
/* 2024 */     if (paramInt < 0 || paramInt + 1 > 32767) {
/* 2025 */       throw new IllegalArgumentException("Sheet number [" + paramInt + "]is not valid ");
/*      */     }
/*      */     
/* 2028 */     NameRecord nameRecord = new NameRecord(paramByte, paramInt);
/*      */     
/* 2030 */     if (this.linkTable.nameAlreadyExists(nameRecord)) {
/* 2031 */       throw new RuntimeException("Builtin (" + paramByte + ") already exists for sheet (" + paramInt + ")");
/*      */     }
/*      */     
/* 2034 */     addName(nameRecord);
/* 2035 */     return nameRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeName(int paramInt) {
/* 2044 */     if (this.linkTable.getNumNames() > paramInt) {
/* 2045 */       int i = findFirstRecordLocBySid((short)24);
/* 2046 */       this.records.remove(i + paramInt);
/* 2047 */       this.linkTable.removeName(paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNameCommentRecordCache(NameCommentRecord paramNameCommentRecord) {
/* 2058 */     if (this.commentRecords.containsValue(paramNameCommentRecord)) {
/* 2059 */       for (Map.Entry<String, NameCommentRecord> entry : this.commentRecords.entrySet()) {
/* 2060 */         if (((NameCommentRecord)entry.getValue()).equals(paramNameCommentRecord)) {
/* 2061 */           this.commentRecords.remove(entry.getKey());
/*      */           break;
/*      */         } 
/*      */       } 
/*      */     }
/* 2066 */     this.commentRecords.put(paramNameCommentRecord.getNameText(), paramNameCommentRecord);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getFormat(String paramString, boolean paramBoolean) {
/* 2076 */     for (FormatRecord formatRecord : this.formats) {
/* 2077 */       if (formatRecord.getFormatString().equals(paramString)) {
/* 2078 */         return (short)formatRecord.getIndexCode();
/*      */       }
/*      */     } 
/*      */     
/* 2082 */     if (paramBoolean) {
/* 2083 */       return (short)createFormat(paramString);
/*      */     }
/*      */     
/* 2086 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<FormatRecord> getFormats() {
/* 2094 */     return this.formats;
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
/*      */   public int createFormat(String paramString) {
/* 2106 */     this.maxformatid = (this.maxformatid >= 164) ? (this.maxformatid + 1) : 164;
/* 2107 */     FormatRecord formatRecord = new FormatRecord(this.maxformatid, paramString);
/*      */     
/* 2109 */     int i = 0;
/* 2110 */     while (i < this.records.size() && this.records.get(i).getSid() != 1054)
/* 2111 */       i++; 
/* 2112 */     i += this.formats.size();
/* 2113 */     this.formats.add(formatRecord);
/* 2114 */     this.records.add(i, (Record)formatRecord);
/* 2115 */     return this.maxformatid;
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
/*      */   public Record findFirstRecordBySid(short paramShort) {
/* 2128 */     for (Record record : this.records) {
/* 2129 */       if (record.getSid() == paramShort) {
/* 2130 */         return record;
/*      */       }
/*      */     } 
/* 2133 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int findFirstRecordLocBySid(short paramShort) {
/* 2142 */     byte b = 0;
/* 2143 */     for (Record record : this.records) {
/* 2144 */       if (record.getSid() == paramShort) {
/* 2145 */         return b;
/*      */       }
/* 2147 */       b++;
/*      */     } 
/* 2149 */     return -1;
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
/*      */   public Record findNextRecordBySid(short paramShort, int paramInt) {
/* 2161 */     byte b = 0;
/* 2162 */     for (Record record : this.records) {
/* 2163 */       if (record.getSid() == paramShort && 
/* 2164 */         b++ == paramInt) {
/* 2165 */         return record;
/*      */       }
/*      */     } 
/* 2168 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public List<HyperlinkRecord> getHyperlinks() {
/* 2173 */     return this.hyperlinks;
/*      */   }
/*      */   
/*      */   public List<Record> getRecords() {
/* 2177 */     return this.records.getRecords();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUsing1904DateWindowing() {
/* 2187 */     return this.uses1904datewindowing;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaletteRecord getCustomPalette() {
/*      */     PaletteRecord paletteRecord;
/* 2199 */     int i = this.records.getPalettepos();
/* 2200 */     if (i != -1) {
/* 2201 */       Record record = this.records.get(i);
/* 2202 */       if (record instanceof PaletteRecord)
/* 2203 */       { paletteRecord = (PaletteRecord)record; }
/* 2204 */       else { throw new RuntimeException("InternalError: Expected PaletteRecord but got a '" + record + "'"); }
/*      */     
/*      */     } else {
/*      */       
/* 2208 */       paletteRecord = createPalette();
/*      */       
/* 2210 */       this.records.add(1, (Record)paletteRecord);
/* 2211 */       this.records.setPalettepos(1);
/*      */     } 
/* 2213 */     return paletteRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DrawingManager2 findDrawingGroup() {
/* 2222 */     if (this.drawingManager != null)
/*      */     {
/* 2224 */       return this.drawingManager;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2229 */     for (Record record : this.records) {
/* 2230 */       if (record instanceof DrawingGroupRecord) {
/* 2231 */         DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)record;
/* 2232 */         drawingGroupRecord.processChildRecords();
/*      */         
/* 2234 */         EscherContainerRecord escherContainerRecord1 = drawingGroupRecord.getEscherContainer();
/*      */         
/* 2236 */         if (escherContainerRecord1 == null) {
/*      */           continue;
/*      */         }
/*      */         
/* 2240 */         EscherDggRecord escherDggRecord = null;
/* 2241 */         EscherContainerRecord escherContainerRecord2 = null; Iterator<EscherRecord> iterator;
/* 2242 */         for (iterator = escherContainerRecord1.getChildIterator(); iterator.hasNext(); ) {
/* 2243 */           EscherRecord escherRecord = iterator.next();
/* 2244 */           if (escherRecord instanceof EscherDggRecord) {
/* 2245 */             escherDggRecord = (EscherDggRecord)escherRecord; continue;
/* 2246 */           }  if (escherRecord.getRecordId() == -4095) {
/* 2247 */             escherContainerRecord2 = (EscherContainerRecord)escherRecord;
/*      */           }
/*      */         } 
/*      */         
/* 2251 */         if (escherDggRecord != null) {
/* 2252 */           this.drawingManager = new DrawingManager2(escherDggRecord);
/* 2253 */           if (escherContainerRecord2 != null)
/* 2254 */             for (EscherRecord escherRecord : escherContainerRecord2.getChildRecords()) {
/* 2255 */               if (escherRecord instanceof EscherBSERecord) this.escherBSERecords.add((EscherBSERecord)escherRecord);
/*      */             
/*      */             }  
/* 2258 */           return this.drawingManager;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2264 */     int i = findFirstRecordLocBySid((short)235);
/*      */ 
/*      */     
/* 2267 */     if (i != -1) {
/* 2268 */       DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)this.records.get(i);
/* 2269 */       EscherDggRecord escherDggRecord = null;
/* 2270 */       EscherContainerRecord escherContainerRecord = null;
/* 2271 */       for (EscherRecord escherRecord : drawingGroupRecord.getEscherRecords()) {
/* 2272 */         if (escherRecord instanceof EscherDggRecord) {
/* 2273 */           escherDggRecord = (EscherDggRecord)escherRecord; continue;
/* 2274 */         }  if (escherRecord.getRecordId() == -4095) {
/* 2275 */           escherContainerRecord = (EscherContainerRecord)escherRecord;
/*      */         }
/*      */       } 
/*      */       
/* 2279 */       if (escherDggRecord != null) {
/* 2280 */         this.drawingManager = new DrawingManager2(escherDggRecord);
/* 2281 */         if (escherContainerRecord != null)
/* 2282 */           for (EscherRecord escherRecord : escherContainerRecord.getChildRecords()) {
/* 2283 */             if (escherRecord instanceof EscherBSERecord) this.escherBSERecords.add((EscherBSERecord)escherRecord);
/*      */           
/*      */           }  
/*      */       } 
/*      */     } 
/* 2288 */     return this.drawingManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void createDrawingGroup() {
/* 2296 */     if (this.drawingManager == null) {
/* 2297 */       EscherContainerRecord escherContainerRecord1 = new EscherContainerRecord();
/* 2298 */       EscherDggRecord escherDggRecord = new EscherDggRecord();
/* 2299 */       EscherOptRecord escherOptRecord = new EscherOptRecord();
/* 2300 */       EscherSplitMenuColorsRecord escherSplitMenuColorsRecord = new EscherSplitMenuColorsRecord();
/*      */       
/* 2302 */       escherContainerRecord1.setRecordId((short)-4096);
/* 2303 */       escherContainerRecord1.setOptions((short)15);
/* 2304 */       escherDggRecord.setRecordId((short)-4090);
/* 2305 */       escherDggRecord.setOptions((short)0);
/* 2306 */       escherDggRecord.setShapeIdMax(1024);
/* 2307 */       escherDggRecord.setNumShapesSaved(0);
/* 2308 */       escherDggRecord.setDrawingsSaved(0);
/* 2309 */       escherDggRecord.setFileIdClusters(new EscherDggRecord.FileIdCluster[0]);
/* 2310 */       this.drawingManager = new DrawingManager2(escherDggRecord);
/* 2311 */       EscherContainerRecord escherContainerRecord2 = null;
/* 2312 */       if (this.escherBSERecords.size() > 0) {
/*      */         
/* 2314 */         escherContainerRecord2 = new EscherContainerRecord();
/* 2315 */         escherContainerRecord2.setRecordId((short)-4095);
/* 2316 */         escherContainerRecord2.setOptions((short)(this.escherBSERecords.size() << 4 | 0xF));
/* 2317 */         for (EscherRecord escherRecord : this.escherBSERecords) {
/* 2318 */           escherContainerRecord2.addChildRecord(escherRecord);
/*      */         }
/*      */       } 
/* 2321 */       escherOptRecord.setRecordId((short)-4085);
/* 2322 */       escherOptRecord.setOptions((short)51);
/* 2323 */       escherOptRecord.addEscherProperty((EscherProperty)new EscherBoolProperty((short)191, 524296));
/* 2324 */       escherOptRecord.addEscherProperty((EscherProperty)new EscherRGBProperty((short)385, 134217793));
/* 2325 */       escherOptRecord.addEscherProperty((EscherProperty)new EscherRGBProperty((short)448, 134217792));
/* 2326 */       escherSplitMenuColorsRecord.setRecordId((short)-3810);
/* 2327 */       escherSplitMenuColorsRecord.setOptions((short)64);
/* 2328 */       escherSplitMenuColorsRecord.setColor1(134217741);
/* 2329 */       escherSplitMenuColorsRecord.setColor2(134217740);
/* 2330 */       escherSplitMenuColorsRecord.setColor3(134217751);
/* 2331 */       escherSplitMenuColorsRecord.setColor4(268435703);
/*      */       
/* 2333 */       escherContainerRecord1.addChildRecord((EscherRecord)escherDggRecord);
/* 2334 */       if (escherContainerRecord2 != null)
/* 2335 */         escherContainerRecord1.addChildRecord((EscherRecord)escherContainerRecord2); 
/* 2336 */       escherContainerRecord1.addChildRecord((EscherRecord)escherOptRecord);
/* 2337 */       escherContainerRecord1.addChildRecord((EscherRecord)escherSplitMenuColorsRecord);
/*      */       
/* 2339 */       int i = findFirstRecordLocBySid((short)235);
/* 2340 */       if (i == -1) {
/* 2341 */         DrawingGroupRecord drawingGroupRecord = new DrawingGroupRecord();
/* 2342 */         drawingGroupRecord.addEscherRecord((EscherRecord)escherContainerRecord1);
/* 2343 */         int j = findFirstRecordLocBySid((short)140);
/*      */         
/* 2345 */         getRecords().add(j + 1, drawingGroupRecord);
/*      */       } else {
/* 2347 */         DrawingGroupRecord drawingGroupRecord = new DrawingGroupRecord();
/* 2348 */         drawingGroupRecord.addEscherRecord((EscherRecord)escherContainerRecord1);
/* 2349 */         getRecords().set(i, drawingGroupRecord);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public WindowOneRecord getWindowOne() {
/* 2356 */     return this.windowOne;
/*      */   }
/*      */   
/*      */   public EscherBSERecord getBSERecord(int paramInt) {
/* 2360 */     return this.escherBSERecords.get(paramInt - 1);
/*      */   }
/*      */   public int addBSERecord(EscherBSERecord paramEscherBSERecord) {
/*      */     EscherContainerRecord escherContainerRecord2;
/* 2364 */     createDrawingGroup();
/*      */ 
/*      */     
/* 2367 */     this.escherBSERecords.add(paramEscherBSERecord);
/*      */     
/* 2369 */     int i = findFirstRecordLocBySid((short)235);
/* 2370 */     DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)getRecords().get(i);
/*      */     
/* 2372 */     EscherContainerRecord escherContainerRecord1 = (EscherContainerRecord)drawingGroupRecord.getEscherRecord(0);
/*      */     
/* 2374 */     if (escherContainerRecord1.getChild(1).getRecordId() == -4095) {
/*      */       
/* 2376 */       escherContainerRecord2 = (EscherContainerRecord)escherContainerRecord1.getChild(1);
/*      */     }
/*      */     else {
/*      */       
/* 2380 */       escherContainerRecord2 = new EscherContainerRecord();
/* 2381 */       escherContainerRecord2.setRecordId((short)-4095);
/* 2382 */       List<EscherContainerRecord> list = escherContainerRecord1.getChildRecords();
/* 2383 */       list.add(1, escherContainerRecord2);
/* 2384 */       escherContainerRecord1.setChildRecords(list);
/*      */     } 
/* 2386 */     escherContainerRecord2.setOptions((short)(this.escherBSERecords.size() << 4 | 0xF));
/*      */     
/* 2388 */     escherContainerRecord2.addChildRecord((EscherRecord)paramEscherBSERecord);
/*      */     
/* 2390 */     return this.escherBSERecords.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public DrawingManager2 getDrawingManager() {
/* 2395 */     return this.drawingManager;
/*      */   }
/*      */   
/*      */   public WriteProtectRecord getWriteProtect() {
/* 2399 */     if (this.writeProtect == null) {
/* 2400 */       this.writeProtect = new WriteProtectRecord();
/* 2401 */       byte b = 0;
/* 2402 */       b = 0;
/* 2403 */       while (b < this.records.size() && !(this.records.get(b) instanceof BOFRecord)) {
/* 2404 */         b++;
/*      */       }
/* 2406 */       this.records.add(b + 1, (Record)this.writeProtect);
/*      */     } 
/* 2408 */     return this.writeProtect;
/*      */   }
/*      */   
/*      */   public WriteAccessRecord getWriteAccess() {
/* 2412 */     if (this.writeAccess == null) {
/* 2413 */       this.writeAccess = createWriteAccess();
/* 2414 */       byte b = 0;
/* 2415 */       b = 0;
/* 2416 */       while (b < this.records.size() && !(this.records.get(b) instanceof InterfaceEndRecord)) {
/* 2417 */         b++;
/*      */       }
/* 2419 */       this.records.add(b + 1, (Record)this.writeAccess);
/*      */     } 
/* 2421 */     return this.writeAccess;
/*      */   }
/*      */   
/*      */   public FileSharingRecord getFileSharing() {
/* 2425 */     if (this.fileShare == null) {
/* 2426 */       this.fileShare = new FileSharingRecord();
/* 2427 */       byte b = 0;
/* 2428 */       b = 0;
/* 2429 */       while (b < this.records.size() && !(this.records.get(b) instanceof WriteAccessRecord)) {
/* 2430 */         b++;
/*      */       }
/* 2432 */       this.records.add(b + 1, (Record)this.fileShare);
/*      */     } 
/* 2434 */     return this.fileShare;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWriteProtected() {
/* 2443 */     if (this.fileShare == null) {
/* 2444 */       return false;
/*      */     }
/* 2446 */     FileSharingRecord fileSharingRecord = getFileSharing();
/* 2447 */     return (fileSharingRecord.getReadOnly() == 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeProtectWorkbook(String paramString1, String paramString2) {
/* 2458 */     FileSharingRecord fileSharingRecord = getFileSharing();
/* 2459 */     WriteAccessRecord writeAccessRecord = getWriteAccess();
/* 2460 */     getWriteProtect();
/* 2461 */     fileSharingRecord.setReadOnly((short)1);
/* 2462 */     fileSharingRecord.setPassword((short)CryptoFunctions.createXorVerifier1(paramString1));
/* 2463 */     fileSharingRecord.setUsername(paramString2);
/* 2464 */     writeAccessRecord.setUsername(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unwriteProtectWorkbook() {
/* 2471 */     this.records.remove(this.fileShare);
/* 2472 */     this.records.remove(this.writeProtect);
/* 2473 */     this.fileShare = null;
/* 2474 */     this.writeProtect = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String resolveNameXText(int paramInt1, int paramInt2) {
/* 2483 */     return this.linkTable.resolveNameXText(paramInt1, paramInt2, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NameXPtg getNameXPtg(String paramString, int paramInt, UDFFinder paramUDFFinder) {
/* 2494 */     LinkTable linkTable = getOrCreateLinkTable();
/* 2495 */     NameXPtg nameXPtg = linkTable.getNameXPtg(paramString, paramInt);
/*      */     
/* 2497 */     if (nameXPtg == null && paramUDFFinder.findFunction(paramString) != null)
/*      */     {
/*      */       
/* 2500 */       nameXPtg = linkTable.addNameXPtg(paramString);
/*      */     }
/* 2502 */     return nameXPtg;
/*      */   }
/*      */   public NameXPtg getNameXPtg(String paramString, UDFFinder paramUDFFinder) {
/* 2505 */     return getNameXPtg(paramString, -1, paramUDFFinder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void cloneDrawings(InternalSheet paramInternalSheet) {
/* 2516 */     findDrawingGroup();
/*      */     
/* 2518 */     if (this.drawingManager == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2524 */     int i = paramInternalSheet.aggregateDrawingRecords(this.drawingManager, false);
/* 2525 */     if (i != -1) {
/* 2526 */       EscherAggregate escherAggregate = (EscherAggregate)paramInternalSheet.findFirstRecordBySid((short)9876);
/* 2527 */       EscherContainerRecord escherContainerRecord = escherAggregate.getEscherContainer();
/* 2528 */       if (escherContainerRecord == null) {
/*      */         return;
/*      */       }
/*      */       
/* 2532 */       EscherDggRecord escherDggRecord = this.drawingManager.getDgg();
/*      */ 
/*      */       
/* 2535 */       short s = this.drawingManager.findNewDrawingGroupId();
/* 2536 */       escherDggRecord.addCluster(s, 0);
/* 2537 */       escherDggRecord.setDrawingsSaved(escherDggRecord.getDrawingsSaved() + 1);
/*      */       
/* 2539 */       EscherDgRecord escherDgRecord = null;
/* 2540 */       for (Iterator<EscherRecord> iterator = escherContainerRecord.getChildIterator(); iterator.hasNext(); ) {
/* 2541 */         EscherRecord escherRecord = iterator.next();
/* 2542 */         if (escherRecord instanceof EscherDgRecord) {
/* 2543 */           escherDgRecord = (EscherDgRecord)escherRecord;
/*      */           
/* 2545 */           escherDgRecord.setOptions((short)(s << 4)); continue;
/* 2546 */         }  if (escherRecord instanceof EscherContainerRecord) {
/*      */           
/* 2548 */           EscherContainerRecord escherContainerRecord1 = (EscherContainerRecord)escherRecord;
/* 2549 */           for (EscherContainerRecord escherContainerRecord2 : escherContainerRecord1.getChildRecords()) {
/*      */             
/* 2551 */             for (EscherRecord escherRecord1 : escherContainerRecord2.getChildRecords()) {
/* 2552 */               short s1 = escherRecord1.getRecordId();
/* 2553 */               if (s1 == -4086) {
/* 2554 */                 EscherSpRecord escherSpRecord = (EscherSpRecord)escherRecord1;
/* 2555 */                 int j = this.drawingManager.allocateShapeId((short)s, escherDgRecord);
/*      */                 
/* 2557 */                 escherDgRecord.setNumShapes(escherDgRecord.getNumShapes() - 1);
/* 2558 */                 escherSpRecord.setShapeId(j); continue;
/* 2559 */               }  if (s1 == -4085) {
/* 2560 */                 EscherOptRecord escherOptRecord = (EscherOptRecord)escherRecord1;
/* 2561 */                 EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty)escherOptRecord.lookup(260);
/*      */                 
/* 2563 */                 if (escherSimpleProperty != null) {
/* 2564 */                   int j = escherSimpleProperty.getPropertyValue();
/*      */                   
/* 2566 */                   EscherBSERecord escherBSERecord = getBSERecord(j);
/* 2567 */                   escherBSERecord.setRef(escherBSERecord.getRef() + 1);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public NameRecord cloneFilter(int paramInt1, int paramInt2) {
/* 2579 */     NameRecord nameRecord1 = getNameRecord(paramInt1);
/*      */     
/* 2581 */     short s = checkExternSheet(paramInt2);
/* 2582 */     Ptg[] arrayOfPtg = nameRecord1.getNameDefinition();
/* 2583 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/* 2584 */       Ptg ptg = arrayOfPtg[b];
/*      */       
/* 2586 */       if (ptg instanceof Area3DPtg) {
/* 2587 */         Area3DPtg area3DPtg = (Area3DPtg)((OperandPtg)ptg).copy();
/* 2588 */         area3DPtg.setExternSheetIndex(s);
/* 2589 */         arrayOfPtg[b] = (Ptg)area3DPtg;
/* 2590 */       } else if (ptg instanceof Ref3DPtg) {
/* 2591 */         Ref3DPtg ref3DPtg = (Ref3DPtg)((OperandPtg)ptg).copy();
/* 2592 */         ref3DPtg.setExternSheetIndex(s);
/* 2593 */         arrayOfPtg[b] = (Ptg)ref3DPtg;
/*      */       } 
/*      */     } 
/* 2596 */     NameRecord nameRecord2 = createBuiltInName((byte)13, paramInt2 + 1);
/* 2597 */     nameRecord2.setNameDefinition(arrayOfPtg);
/* 2598 */     nameRecord2.setHidden(true);
/* 2599 */     return nameRecord2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateNamesAfterCellShift(FormulaShifter paramFormulaShifter) {
/* 2608 */     for (byte b = 0; b < getNumNames(); b++) {
/* 2609 */       NameRecord nameRecord = getNameRecord(b);
/* 2610 */       Ptg[] arrayOfPtg = nameRecord.getNameDefinition();
/* 2611 */       if (paramFormulaShifter.adjustFormula(arrayOfPtg, nameRecord.getSheetNumber())) {
/* 2612 */         nameRecord.setNameDefinition(arrayOfPtg);
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
/*      */   public RecalcIdRecord getRecalcId() {
/* 2625 */     RecalcIdRecord recalcIdRecord = (RecalcIdRecord)findFirstRecordBySid((short)449);
/* 2626 */     if (recalcIdRecord == null) {
/* 2627 */       recalcIdRecord = new RecalcIdRecord();
/*      */       
/* 2629 */       int i = findFirstRecordLocBySid((short)140);
/* 2630 */       this.records.add(i + 1, (Record)recalcIdRecord);
/*      */     } 
/* 2632 */     return recalcIdRecord;
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
/*      */   public boolean changeExternalReference(String paramString1, String paramString2) {
/* 2646 */     return this.linkTable.changeExternalReference(paramString1, paramString2);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\InternalWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */