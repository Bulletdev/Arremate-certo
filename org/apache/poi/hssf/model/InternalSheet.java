/*      */ package org.apache.poi.hssf.model;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.apache.poi.hssf.record.BOFRecord;
/*      */ import org.apache.poi.hssf.record.CalcCountRecord;
/*      */ import org.apache.poi.hssf.record.CalcModeRecord;
/*      */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*      */ import org.apache.poi.hssf.record.ColumnInfoRecord;
/*      */ import org.apache.poi.hssf.record.DefaultColWidthRecord;
/*      */ import org.apache.poi.hssf.record.DefaultRowHeightRecord;
/*      */ import org.apache.poi.hssf.record.DeltaRecord;
/*      */ import org.apache.poi.hssf.record.DimensionsRecord;
/*      */ import org.apache.poi.hssf.record.DrawingRecord;
/*      */ import org.apache.poi.hssf.record.EOFRecord;
/*      */ import org.apache.poi.hssf.record.EscherAggregate;
/*      */ import org.apache.poi.hssf.record.GridsetRecord;
/*      */ import org.apache.poi.hssf.record.GutsRecord;
/*      */ import org.apache.poi.hssf.record.IterationRecord;
/*      */ import org.apache.poi.hssf.record.NoteRecord;
/*      */ import org.apache.poi.hssf.record.PaneRecord;
/*      */ import org.apache.poi.hssf.record.PrintGridlinesRecord;
/*      */ import org.apache.poi.hssf.record.PrintHeadersRecord;
/*      */ import org.apache.poi.hssf.record.Record;
/*      */ import org.apache.poi.hssf.record.RecordBase;
/*      */ import org.apache.poi.hssf.record.RecordFormatException;
/*      */ import org.apache.poi.hssf.record.RefModeRecord;
/*      */ import org.apache.poi.hssf.record.RowRecord;
/*      */ import org.apache.poi.hssf.record.SCLRecord;
/*      */ import org.apache.poi.hssf.record.SaveRecalcRecord;
/*      */ import org.apache.poi.hssf.record.SelectionRecord;
/*      */ import org.apache.poi.hssf.record.UncalcedRecord;
/*      */ import org.apache.poi.hssf.record.WSBoolRecord;
/*      */ import org.apache.poi.hssf.record.WindowTwoRecord;
/*      */ import org.apache.poi.hssf.record.aggregates.ChartSubstreamRecordAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
/*      */ import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.DataValidityTable;
/*      */ import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
/*      */ import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
/*      */ import org.apache.poi.hssf.record.aggregates.RecordAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
/*      */ import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
/*      */ import org.apache.poi.ss.formula.FormulaShifter;
/*      */ import org.apache.poi.ss.util.CellRangeAddress;
/*      */ import org.apache.poi.ss.util.PaneInformation;
/*      */ import org.apache.poi.util.Internal;
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
/*      */ @Internal
/*      */ public final class InternalSheet
/*      */ {
/*      */   public static final short LeftMargin = 0;
/*      */   public static final short RightMargin = 1;
/*      */   public static final short TopMargin = 2;
/*      */   public static final short BottomMargin = 3;
/*  101 */   private static POILogger log = POILogFactory.getLogger(InternalSheet.class);
/*      */   
/*      */   private List<RecordBase> _records;
/*  104 */   protected PrintGridlinesRecord printGridlines = null;
/*  105 */   protected PrintHeadersRecord printHeaders = null;
/*  106 */   protected GridsetRecord gridset = null;
/*      */   private GutsRecord _gutsRecord;
/*  108 */   protected DefaultColWidthRecord defaultcolwidth = new DefaultColWidthRecord();
/*  109 */   protected DefaultRowHeightRecord defaultrowheight = new DefaultRowHeightRecord();
/*      */ 
/*      */ 
/*      */   
/*      */   private PageSettingsBlock _psBlock;
/*      */ 
/*      */   
/*  116 */   private final WorksheetProtectionBlock _protectionBlock = new WorksheetProtectionBlock();
/*      */   
/*  118 */   protected WindowTwoRecord windowTwo = null;
/*  119 */   protected SelectionRecord _selection = null;
/*      */   
/*      */   private final MergedCellsTable _mergedCellsTable;
/*      */   
/*      */   ColumnInfoRecordsAggregate _columnInfos;
/*      */   
/*      */   private DimensionsRecord _dimensions;
/*      */   
/*      */   protected final RowRecordsAggregate _rowsAggregate;
/*  128 */   private DataValidityTable _dataValidityTable = null;
/*      */   
/*      */   private ConditionalFormattingTable condFormatting;
/*  131 */   private Iterator<RowRecord> rowRecIterator = null;
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean _isUncalced = false;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte PANE_LOWER_RIGHT = 0;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte PANE_UPPER_RIGHT = 1;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte PANE_LOWER_LEFT = 2;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final byte PANE_UPPER_LEFT = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InternalSheet createSheet(RecordStream paramRecordStream) {
/*  157 */     return new InternalSheet(paramRecordStream);
/*      */   }
/*      */   private InternalSheet(RecordStream paramRecordStream) {
/*  160 */     this._mergedCellsTable = new MergedCellsTable();
/*  161 */     RowRecordsAggregate rowRecordsAggregate = null;
/*      */     
/*  163 */     ArrayList<RecordBase> arrayList = new ArrayList(128);
/*  164 */     this._records = arrayList;
/*  165 */     int i = -1;
/*      */     
/*  167 */     if (paramRecordStream.peekNextSid() != 2057) {
/*  168 */       throw new RecordFormatException("BOF record expected");
/*      */     }
/*      */     
/*  171 */     BOFRecord bOFRecord = (BOFRecord)paramRecordStream.getNext();
/*  172 */     if (bOFRecord.getType() != 16)
/*      */     {
/*  174 */       if (bOFRecord.getType() != 32 && bOFRecord.getType() != 64) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  181 */         while (paramRecordStream.hasNext()) {
/*  182 */           Record record = paramRecordStream.getNext();
/*  183 */           if (record instanceof EOFRecord) {
/*      */             break;
/*      */           }
/*      */         } 
/*  187 */         throw new UnsupportedBOFType(bOFRecord.getType());
/*      */       }  } 
/*  189 */     arrayList.add(bOFRecord);
/*      */     
/*  191 */     while (paramRecordStream.hasNext()) {
/*  192 */       int j = paramRecordStream.peekNextSid();
/*      */       
/*  194 */       if (j == 432 || j == 2169) {
/*  195 */         this.condFormatting = new ConditionalFormattingTable(paramRecordStream);
/*  196 */         arrayList.add(this.condFormatting);
/*      */         
/*      */         continue;
/*      */       } 
/*  200 */       if (j == 125) {
/*  201 */         this._columnInfos = new ColumnInfoRecordsAggregate(paramRecordStream);
/*  202 */         arrayList.add(this._columnInfos);
/*      */         continue;
/*      */       } 
/*  205 */       if (j == 434) {
/*  206 */         this._dataValidityTable = new DataValidityTable(paramRecordStream);
/*  207 */         arrayList.add(this._dataValidityTable);
/*      */         
/*      */         continue;
/*      */       } 
/*  211 */       if (RecordOrderer.isRowBlockRecord(j)) {
/*      */         
/*  213 */         if (rowRecordsAggregate != null) {
/*  214 */           throw new RecordFormatException("row/cell records found in the wrong place");
/*      */         }
/*  216 */         RowBlocksReader rowBlocksReader = new RowBlocksReader(paramRecordStream);
/*  217 */         this._mergedCellsTable.addRecords(rowBlocksReader.getLooseMergedCells());
/*  218 */         rowRecordsAggregate = new RowRecordsAggregate(rowBlocksReader.getPlainRecordStream(), rowBlocksReader.getSharedFormulaManager());
/*  219 */         arrayList.add(rowRecordsAggregate);
/*      */         
/*      */         continue;
/*      */       } 
/*  223 */       if (CustomViewSettingsRecordAggregate.isBeginRecord(j)) {
/*      */ 
/*      */         
/*  226 */         arrayList.add(new CustomViewSettingsRecordAggregate(paramRecordStream));
/*      */         
/*      */         continue;
/*      */       } 
/*  230 */       if (PageSettingsBlock.isComponentRecord(j)) {
/*  231 */         if (this._psBlock == null) {
/*      */           
/*  233 */           this._psBlock = new PageSettingsBlock(paramRecordStream);
/*  234 */           arrayList.add(this._psBlock);
/*      */         } else {
/*      */           
/*  237 */           this._psBlock.addLateRecords(paramRecordStream);
/*      */         } 
/*      */ 
/*      */         
/*  241 */         this._psBlock.positionRecords(arrayList);
/*      */         
/*      */         continue;
/*      */       } 
/*  245 */       if (WorksheetProtectionBlock.isComponentRecord(j)) {
/*  246 */         this._protectionBlock.addRecords(paramRecordStream);
/*      */         
/*      */         continue;
/*      */       } 
/*  250 */       if (j == 229) {
/*      */         
/*  252 */         this._mergedCellsTable.read(paramRecordStream);
/*      */         
/*      */         continue;
/*      */       } 
/*  256 */       if (j == 2057) {
/*  257 */         ChartSubstreamRecordAggregate chartSubstreamRecordAggregate = new ChartSubstreamRecordAggregate(paramRecordStream);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  262 */         spillAggregate((RecordAggregate)chartSubstreamRecordAggregate, arrayList);
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  267 */       Record record = paramRecordStream.getNext();
/*  268 */       if (j == 523) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  275 */       if (j == 94) {
/*      */         
/*  277 */         this._isUncalced = true;
/*      */         
/*      */         continue;
/*      */       } 
/*  281 */       if (j == 2152 || j == 2151) {
/*      */         
/*  283 */         arrayList.add(record);
/*      */         
/*      */         continue;
/*      */       } 
/*  287 */       if (j == 10) {
/*  288 */         arrayList.add(record);
/*      */         
/*      */         break;
/*      */       } 
/*  292 */       if (j == 512) {
/*      */ 
/*      */         
/*  295 */         if (this._columnInfos == null) {
/*      */           
/*  297 */           this._columnInfos = new ColumnInfoRecordsAggregate();
/*  298 */           arrayList.add(this._columnInfos);
/*      */         } 
/*      */         
/*  301 */         this._dimensions = (DimensionsRecord)record;
/*  302 */         i = arrayList.size();
/*      */       }
/*  304 */       else if (j == 85) {
/*      */         
/*  306 */         this.defaultcolwidth = (DefaultColWidthRecord)record;
/*      */       }
/*  308 */       else if (j == 549) {
/*      */         
/*  310 */         this.defaultrowheight = (DefaultRowHeightRecord)record;
/*      */       }
/*  312 */       else if (j == 43) {
/*      */         
/*  314 */         this.printGridlines = (PrintGridlinesRecord)record;
/*      */       }
/*  316 */       else if (j == 42) {
/*      */         
/*  318 */         this.printHeaders = (PrintHeadersRecord)record;
/*      */       }
/*  320 */       else if (j == 130) {
/*      */         
/*  322 */         this.gridset = (GridsetRecord)record;
/*      */       }
/*  324 */       else if (j == 29) {
/*      */         
/*  326 */         this._selection = (SelectionRecord)record;
/*      */       }
/*  328 */       else if (j == 574) {
/*      */         
/*  330 */         this.windowTwo = (WindowTwoRecord)record;
/*      */       }
/*  332 */       else if (j == 128) {
/*      */         
/*  334 */         this._gutsRecord = (GutsRecord)record;
/*      */       } 
/*      */       
/*  337 */       arrayList.add(record);
/*      */     } 
/*  339 */     if (this.windowTwo == null) {
/*  340 */       throw new RecordFormatException("WINDOW2 was not found");
/*      */     }
/*  342 */     if (this._dimensions == null) {
/*      */ 
/*      */       
/*  345 */       if (rowRecordsAggregate == null) {
/*      */ 
/*      */ 
/*      */         
/*  349 */         rowRecordsAggregate = new RowRecordsAggregate();
/*      */       }
/*  351 */       else if (log.check(5)) {
/*  352 */         log.log(5, new Object[] { "DIMENSION record not found even though row/cells present" });
/*      */       } 
/*      */ 
/*      */       
/*  356 */       i = findFirstRecordLocBySid((short)574);
/*  357 */       this._dimensions = rowRecordsAggregate.createDimensions();
/*  358 */       arrayList.add(i, this._dimensions);
/*      */     } 
/*  360 */     if (rowRecordsAggregate == null) {
/*  361 */       rowRecordsAggregate = new RowRecordsAggregate();
/*  362 */       arrayList.add(i + 1, rowRecordsAggregate);
/*      */     } 
/*  364 */     this._rowsAggregate = rowRecordsAggregate;
/*      */     
/*  366 */     RecordOrderer.addNewSheetRecord(arrayList, (RecordBase)this._mergedCellsTable);
/*  367 */     RecordOrderer.addNewSheetRecord(arrayList, (RecordBase)this._protectionBlock);
/*  368 */     if (log.check(1))
/*  369 */       log.log(1, new Object[] { "sheet createSheet (existing file) exited" }); 
/*      */   }
/*      */   private static void spillAggregate(RecordAggregate paramRecordAggregate, final List<RecordBase> recs) {
/*  372 */     paramRecordAggregate.visitContainedRecords(new RecordAggregate.RecordVisitor() {
/*      */           public void visitRecord(Record param1Record) {
/*  374 */             recs.add(param1Record);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public static class UnsupportedBOFType extends RecordFormatException {
/*      */     protected UnsupportedBOFType(int param1Int) {
/*  381 */       super("BOF not of a supported type, found " + param1Int);
/*  382 */       this.type = param1Int;
/*      */     }
/*      */     private final int type;
/*      */     public int getType() {
/*  386 */       return this.type;
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class RecordCloner
/*      */     implements RecordAggregate.RecordVisitor {
/*      */     private final List<Record> _destList;
/*      */     
/*      */     public RecordCloner(List<Record> param1List) {
/*  395 */       this._destList = param1List;
/*      */     }
/*      */     public void visitRecord(Record param1Record) {
/*      */       try {
/*  399 */         this._destList.add((Record)param1Record.clone());
/*  400 */       } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  401 */         throw new RecordFormatException(cloneNotSupportedException);
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
/*      */   public InternalSheet cloneSheet() {
/*  416 */     ArrayList<Record> arrayList = new ArrayList(this._records.size());
/*  417 */     for (byte b = 0; b < this._records.size(); b++) {
/*  418 */       RecordBase recordBase = this._records.get(b);
/*  419 */       if (recordBase instanceof RecordAggregate) {
/*  420 */         ((RecordAggregate)recordBase).visitContainedRecords(new RecordCloner(arrayList));
/*      */       } else {
/*      */         DrawingRecord drawingRecord;
/*  423 */         if (recordBase instanceof EscherAggregate)
/*      */         {
/*      */ 
/*      */           
/*  427 */           drawingRecord = new DrawingRecord();
/*      */         }
/*      */         try {
/*  430 */           Record record = (Record)((Record)drawingRecord).clone();
/*  431 */           arrayList.add(record);
/*  432 */         } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  433 */           throw new RecordFormatException(cloneNotSupportedException);
/*      */         } 
/*      */       } 
/*  436 */     }  return createSheet(new RecordStream(arrayList, 0));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InternalSheet createSheet() {
/*  447 */     return new InternalSheet();
/*      */   }
/*      */   private InternalSheet() {
/*  450 */     this._mergedCellsTable = new MergedCellsTable();
/*  451 */     ArrayList<BOFRecord> arrayList = new ArrayList(32);
/*      */     
/*  453 */     if (log.check(1)) {
/*  454 */       log.log(1, new Object[] { "Sheet createsheet from scratch called" });
/*      */     }
/*  456 */     arrayList.add(createBOF());
/*      */     
/*  458 */     arrayList.add(createCalcMode());
/*  459 */     arrayList.add(createCalcCount());
/*  460 */     arrayList.add(createRefMode());
/*  461 */     arrayList.add(createIteration());
/*  462 */     arrayList.add(createDelta());
/*  463 */     arrayList.add(createSaveRecalc());
/*  464 */     this.printHeaders = createPrintHeaders();
/*  465 */     arrayList.add(this.printHeaders);
/*  466 */     this.printGridlines = createPrintGridlines();
/*  467 */     arrayList.add(this.printGridlines);
/*  468 */     this.gridset = createGridset();
/*  469 */     arrayList.add(this.gridset);
/*  470 */     this._gutsRecord = createGuts();
/*  471 */     arrayList.add(this._gutsRecord);
/*  472 */     this.defaultrowheight = createDefaultRowHeight();
/*  473 */     arrayList.add(this.defaultrowheight);
/*  474 */     arrayList.add(createWSBool());
/*      */ 
/*      */     
/*  477 */     this._psBlock = new PageSettingsBlock();
/*  478 */     arrayList.add(this._psBlock);
/*      */ 
/*      */     
/*  481 */     arrayList.add(this._protectionBlock);
/*      */     
/*  483 */     this.defaultcolwidth = createDefaultColWidth();
/*  484 */     arrayList.add(this.defaultcolwidth);
/*  485 */     ColumnInfoRecordsAggregate columnInfoRecordsAggregate = new ColumnInfoRecordsAggregate();
/*  486 */     arrayList.add(columnInfoRecordsAggregate);
/*  487 */     this._columnInfos = columnInfoRecordsAggregate;
/*  488 */     this._dimensions = createDimensions();
/*  489 */     arrayList.add(this._dimensions);
/*  490 */     this._rowsAggregate = new RowRecordsAggregate();
/*  491 */     arrayList.add(this._rowsAggregate);
/*      */     
/*  493 */     arrayList.add(this.windowTwo = createWindowTwo());
/*  494 */     this._selection = createSelection();
/*  495 */     arrayList.add(this._selection);
/*      */     
/*  497 */     arrayList.add(this._mergedCellsTable);
/*  498 */     arrayList.add(EOFRecord.instance);
/*      */     
/*  500 */     this._records = (List)arrayList;
/*  501 */     if (log.check(1))
/*  502 */       log.log(1, new Object[] { "Sheet createsheet from scratch exit" }); 
/*      */   }
/*      */   
/*      */   public RowRecordsAggregate getRowsAggregate() {
/*  506 */     return this._rowsAggregate;
/*      */   }
/*      */ 
/*      */   
/*      */   private MergedCellsTable getMergedRecords() {
/*  511 */     return this._mergedCellsTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateFormulasAfterCellShift(FormulaShifter paramFormulaShifter, int paramInt) {
/*  521 */     getRowsAggregate().updateFormulasAfterRowShift(paramFormulaShifter, paramInt);
/*  522 */     if (this.condFormatting != null) {
/*  523 */       getConditionalFormattingTable().updateFormulasAfterCellShift(paramFormulaShifter, paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int addMergedRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  530 */     if (paramInt3 < paramInt1) {
/*  531 */       throw new IllegalArgumentException("The 'to' row (" + paramInt3 + ") must not be less than the 'from' row (" + paramInt1 + ")");
/*      */     }
/*      */     
/*  534 */     if (paramInt4 < paramInt2) {
/*  535 */       throw new IllegalArgumentException("The 'to' col (" + paramInt4 + ") must not be less than the 'from' col (" + paramInt2 + ")");
/*      */     }
/*      */ 
/*      */     
/*  539 */     MergedCellsTable mergedCellsTable = getMergedRecords();
/*  540 */     mergedCellsTable.addArea(paramInt1, paramInt2, paramInt3, paramInt4);
/*  541 */     return mergedCellsTable.getNumberOfMergedRegions() - 1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeMergedRegion(int paramInt) {
/*  546 */     MergedCellsTable mergedCellsTable = getMergedRecords();
/*  547 */     if (paramInt >= mergedCellsTable.getNumberOfMergedRegions()) {
/*      */       return;
/*      */     }
/*  550 */     mergedCellsTable.remove(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   public CellRangeAddress getMergedRegionAt(int paramInt) {
/*  555 */     MergedCellsTable mergedCellsTable = getMergedRecords();
/*  556 */     if (paramInt >= mergedCellsTable.getNumberOfMergedRegions()) {
/*  557 */       return null;
/*      */     }
/*  559 */     return mergedCellsTable.get(paramInt);
/*      */   }
/*      */   
/*      */   public int getNumMergedRegions() {
/*  563 */     return getMergedRecords().getNumberOfMergedRegions();
/*      */   }
/*      */   public ConditionalFormattingTable getConditionalFormattingTable() {
/*  566 */     if (this.condFormatting == null) {
/*  567 */       this.condFormatting = new ConditionalFormattingTable();
/*  568 */       RecordOrderer.addNewSheetRecord(this._records, (RecordBase)this.condFormatting);
/*      */     } 
/*  570 */     return this.condFormatting;
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
/*      */   public void setDimensions(int paramInt1, short paramShort1, int paramInt2, short paramShort2) {
/*  587 */     if (log.check(1)) {
/*      */       
/*  589 */       log.log(1, new Object[] { "Sheet.setDimensions" });
/*  590 */       log.log(1, new Object[] { "firstrow" + paramInt1 + "firstcol" + paramShort1 + "lastrow" + paramInt2 + "lastcol" + paramShort2 });
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  596 */     this._dimensions.setFirstCol(paramShort1);
/*  597 */     this._dimensions.setFirstRow(paramInt1);
/*  598 */     this._dimensions.setLastCol(paramShort2);
/*  599 */     this._dimensions.setLastRow(paramInt2);
/*  600 */     if (log.check(1)) {
/*  601 */       log.log(1, new Object[] { "Sheet.setDimensions exiting" });
/*      */     }
/*      */   }
/*      */   
/*      */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor, int paramInt) {
/*  606 */     RecordAggregate.PositionTrackingVisitor positionTrackingVisitor = new RecordAggregate.PositionTrackingVisitor(paramRecordVisitor, paramInt);
/*      */     
/*  608 */     boolean bool = false;
/*      */     
/*  610 */     for (byte b = 0; b < this._records.size(); b++) {
/*  611 */       RecordBase recordBase = this._records.get(b);
/*      */       
/*  613 */       if (recordBase instanceof RecordAggregate) {
/*  614 */         RecordAggregate recordAggregate = (RecordAggregate)recordBase;
/*  615 */         recordAggregate.visitContainedRecords((RecordAggregate.RecordVisitor)positionTrackingVisitor);
/*      */       } else {
/*  617 */         positionTrackingVisitor.visitRecord((Record)recordBase);
/*      */       } 
/*      */ 
/*      */       
/*  621 */       if (recordBase instanceof BOFRecord && 
/*  622 */         !bool) {
/*  623 */         bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  628 */         if (this._isUncalced) {
/*  629 */           positionTrackingVisitor.visitRecord((Record)new UncalcedRecord());
/*      */         }
/*      */ 
/*      */         
/*  633 */         if (this._rowsAggregate != null) {
/*      */           
/*  635 */           int i = getSizeOfInitialSheetRecords(b);
/*  636 */           int j = positionTrackingVisitor.getPosition();
/*  637 */           positionTrackingVisitor.visitRecord((Record)this._rowsAggregate.createIndexRecord(j, i));
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
/*      */   private int getSizeOfInitialSheetRecords(int paramInt) {
/*  650 */     int i = 0;
/*      */     
/*  652 */     for (int j = paramInt + 1; j < this._records.size(); j++) {
/*  653 */       RecordBase recordBase = this._records.get(j);
/*  654 */       if (recordBase instanceof RowRecordsAggregate) {
/*      */         break;
/*      */       }
/*  657 */       i += recordBase.getRecordSize();
/*      */     } 
/*  659 */     if (this._isUncalced) {
/*  660 */       i += UncalcedRecord.getStaticRecordSize();
/*      */     }
/*  662 */     return i;
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
/*      */   public void addValueRecord(int paramInt, CellValueRecordInterface paramCellValueRecordInterface) {
/*  679 */     if (log.check(1)) {
/*  680 */       log.log(1, new Object[] { "add value record  row" + paramInt });
/*      */     }
/*  682 */     DimensionsRecord dimensionsRecord = this._dimensions;
/*      */     
/*  684 */     if (paramCellValueRecordInterface.getColumn() >= dimensionsRecord.getLastCol()) {
/*  685 */       dimensionsRecord.setLastCol((short)(paramCellValueRecordInterface.getColumn() + 1));
/*      */     }
/*  687 */     if (paramCellValueRecordInterface.getColumn() < dimensionsRecord.getFirstCol()) {
/*  688 */       dimensionsRecord.setFirstCol(paramCellValueRecordInterface.getColumn());
/*      */     }
/*  690 */     this._rowsAggregate.insertCell(paramCellValueRecordInterface);
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
/*      */   public void removeValueRecord(int paramInt, CellValueRecordInterface paramCellValueRecordInterface) {
/*  704 */     log.log(1, new Object[] { "remove value record row " + paramInt });
/*  705 */     this._rowsAggregate.removeCell(paramCellValueRecordInterface);
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
/*      */   public void replaceValueRecord(CellValueRecordInterface paramCellValueRecordInterface) {
/*  720 */     if (log.check(1)) {
/*  721 */       log.log(1, new Object[] { "replaceValueRecord " });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  727 */     this._rowsAggregate.removeCell(paramCellValueRecordInterface);
/*  728 */     this._rowsAggregate.insertCell(paramCellValueRecordInterface);
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
/*      */   public void addRow(RowRecord paramRowRecord) {
/*  744 */     if (log.check(1))
/*  745 */       log.log(1, new Object[] { "addRow " }); 
/*  746 */     DimensionsRecord dimensionsRecord = this._dimensions;
/*      */     
/*  748 */     if (paramRowRecord.getRowNumber() >= dimensionsRecord.getLastRow()) {
/*  749 */       dimensionsRecord.setLastRow(paramRowRecord.getRowNumber() + 1);
/*      */     }
/*  751 */     if (paramRowRecord.getRowNumber() < dimensionsRecord.getFirstRow()) {
/*  752 */       dimensionsRecord.setFirstRow(paramRowRecord.getRowNumber());
/*      */     }
/*      */ 
/*      */     
/*  756 */     RowRecord rowRecord = this._rowsAggregate.getRow(paramRowRecord.getRowNumber());
/*  757 */     if (rowRecord != null) {
/*  758 */       this._rowsAggregate.removeRow(rowRecord);
/*      */     }
/*      */     
/*  761 */     this._rowsAggregate.insertRow(paramRowRecord);
/*      */     
/*  763 */     if (log.check(1)) {
/*  764 */       log.log(1, new Object[] { "exit addRow" });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeRow(RowRecord paramRowRecord) {
/*  775 */     this._rowsAggregate.removeRow(paramRowRecord);
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
/*      */   public Iterator<CellValueRecordInterface> getCellValueIterator() {
/*  792 */     return this._rowsAggregate.getCellValueIterator();
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
/*      */   public RowRecord getNextRow() {
/*  808 */     if (this.rowRecIterator == null)
/*      */     {
/*  810 */       this.rowRecIterator = this._rowsAggregate.getIterator();
/*      */     }
/*  812 */     if (!this.rowRecIterator.hasNext())
/*      */     {
/*  814 */       return null;
/*      */     }
/*  816 */     return this.rowRecIterator.next();
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
/*      */   public RowRecord getRow(int paramInt) {
/*  835 */     return this._rowsAggregate.getRow(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static BOFRecord createBOF() {
/*  842 */     BOFRecord bOFRecord = new BOFRecord();
/*      */     
/*  844 */     bOFRecord.setVersion(1536);
/*  845 */     bOFRecord.setType(16);
/*      */     
/*  847 */     bOFRecord.setBuild(3515);
/*  848 */     bOFRecord.setBuildYear(1996);
/*  849 */     bOFRecord.setHistoryBitMask(193);
/*  850 */     bOFRecord.setRequiredVersion(6);
/*  851 */     return bOFRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CalcModeRecord createCalcMode() {
/*  858 */     CalcModeRecord calcModeRecord = new CalcModeRecord();
/*      */     
/*  860 */     calcModeRecord.setCalcMode((short)1);
/*  861 */     return calcModeRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static CalcCountRecord createCalcCount() {
/*  868 */     CalcCountRecord calcCountRecord = new CalcCountRecord();
/*      */     
/*  870 */     calcCountRecord.setIterations((short)100);
/*  871 */     return calcCountRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static RefModeRecord createRefMode() {
/*  878 */     RefModeRecord refModeRecord = new RefModeRecord();
/*      */     
/*  880 */     refModeRecord.setMode((short)1);
/*  881 */     return refModeRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static IterationRecord createIteration() {
/*  888 */     return new IterationRecord(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DeltaRecord createDelta() {
/*  895 */     return new DeltaRecord(0.001D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static SaveRecalcRecord createSaveRecalc() {
/*  902 */     SaveRecalcRecord saveRecalcRecord = new SaveRecalcRecord();
/*      */     
/*  904 */     saveRecalcRecord.setRecalc(true);
/*  905 */     return saveRecalcRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PrintHeadersRecord createPrintHeaders() {
/*  912 */     PrintHeadersRecord printHeadersRecord = new PrintHeadersRecord();
/*      */     
/*  914 */     printHeadersRecord.setPrintHeaders(false);
/*  915 */     return printHeadersRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static PrintGridlinesRecord createPrintGridlines() {
/*  923 */     PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
/*      */     
/*  925 */     printGridlinesRecord.setPrintGridlines(false);
/*  926 */     return printGridlinesRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static GridsetRecord createGridset() {
/*  933 */     GridsetRecord gridsetRecord = new GridsetRecord();
/*      */     
/*  935 */     gridsetRecord.setGridset(true);
/*  936 */     return gridsetRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static GutsRecord createGuts() {
/*  943 */     GutsRecord gutsRecord = new GutsRecord();
/*      */     
/*  945 */     gutsRecord.setLeftRowGutter((short)0);
/*  946 */     gutsRecord.setTopColGutter((short)0);
/*  947 */     gutsRecord.setRowLevelMax((short)0);
/*  948 */     gutsRecord.setColLevelMax((short)0);
/*  949 */     return gutsRecord;
/*      */   }
/*      */   
/*      */   private GutsRecord getGutsRecord() {
/*  953 */     if (this._gutsRecord == null) {
/*  954 */       GutsRecord gutsRecord = createGuts();
/*  955 */       RecordOrderer.addNewSheetRecord(this._records, (RecordBase)gutsRecord);
/*  956 */       this._gutsRecord = gutsRecord;
/*      */     } 
/*      */     
/*  959 */     return this._gutsRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DefaultRowHeightRecord createDefaultRowHeight() {
/*  966 */     DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord();
/*      */     
/*  968 */     defaultRowHeightRecord.setOptionFlags((short)0);
/*  969 */     defaultRowHeightRecord.setRowHeight((short)255);
/*  970 */     return defaultRowHeightRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static WSBoolRecord createWSBool() {
/*  977 */     WSBoolRecord wSBoolRecord = new WSBoolRecord();
/*      */     
/*  979 */     wSBoolRecord.setWSBool1((byte)4);
/*  980 */     wSBoolRecord.setWSBool2((byte)-63);
/*  981 */     return wSBoolRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DefaultColWidthRecord createDefaultColWidth() {
/*  989 */     DefaultColWidthRecord defaultColWidthRecord = new DefaultColWidthRecord();
/*  990 */     defaultColWidthRecord.setColWidth(8);
/*  991 */     return defaultColWidthRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getDefaultColumnWidth() {
/*  999 */     return this.defaultcolwidth.getColWidth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isGridsPrinted() {
/* 1006 */     if (this.gridset == null) {
/* 1007 */       this.gridset = createGridset();
/*      */       
/* 1009 */       int i = findFirstRecordLocBySid((short)10);
/* 1010 */       this._records.add(i, this.gridset);
/*      */     } 
/* 1012 */     return !this.gridset.getGridset();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setGridsPrinted(boolean paramBoolean) {
/* 1020 */     this.gridset.setGridset(!paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultColumnWidth(int paramInt) {
/* 1028 */     this.defaultcolwidth.setColWidth(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefaultRowHeight(short paramShort) {
/* 1037 */     this.defaultrowheight.setRowHeight(paramShort);
/*      */     
/* 1039 */     this.defaultrowheight.setOptionFlags((short)1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getDefaultRowHeight() {
/* 1047 */     return this.defaultrowheight.getRowHeight();
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
/*      */   public int getColumnWidth(int paramInt) {
/* 1060 */     ColumnInfoRecord columnInfoRecord = this._columnInfos.findColumnInfo(paramInt);
/* 1061 */     if (columnInfoRecord != null) {
/* 1062 */       return columnInfoRecord.getColumnWidth();
/*      */     }
/*      */ 
/*      */     
/* 1066 */     return 256 * this.defaultcolwidth.getColWidth();
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
/*      */   public short getXFIndexForColAt(short paramShort) {
/* 1084 */     ColumnInfoRecord columnInfoRecord = this._columnInfos.findColumnInfo(paramShort);
/* 1085 */     if (columnInfoRecord != null) {
/* 1086 */       return (short)columnInfoRecord.getXFIndex();
/*      */     }
/* 1088 */     return 15;
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
/*      */   public void setColumnWidth(int paramInt1, int paramInt2) {
/* 1100 */     if (paramInt2 > 65280) throw new IllegalArgumentException("The maximum column width for an individual cell is 255 characters.");
/*      */     
/* 1102 */     setColumn(paramInt1, null, Integer.valueOf(paramInt2), null, null, null);
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
/*      */   public boolean isColumnHidden(int paramInt) {
/* 1114 */     ColumnInfoRecord columnInfoRecord = this._columnInfos.findColumnInfo(paramInt);
/* 1115 */     if (columnInfoRecord == null) {
/* 1116 */       return false;
/*      */     }
/* 1118 */     return columnInfoRecord.getHidden();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setColumnHidden(int paramInt, boolean paramBoolean) {
/* 1127 */     setColumn(paramInt, null, null, null, Boolean.valueOf(paramBoolean), null);
/*      */   }
/*      */   public void setDefaultColumnStyle(int paramInt1, int paramInt2) {
/* 1130 */     setColumn(paramInt1, Short.valueOf((short)paramInt2), null, null, null, null);
/*      */   }
/*      */   
/*      */   private void setColumn(int paramInt, Short paramShort, Integer paramInteger1, Integer paramInteger2, Boolean paramBoolean1, Boolean paramBoolean2) {
/* 1134 */     this._columnInfos.setColumn(paramInt, paramShort, paramInteger1, paramInteger2, paramBoolean1, paramBoolean2);
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
/*      */   public void groupColumnRange(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 1148 */     this._columnInfos.groupColumnRange(paramInt1, paramInt2, paramBoolean);
/*      */ 
/*      */     
/* 1151 */     int i = this._columnInfos.getMaxOutlineLevel();
/*      */     
/* 1153 */     GutsRecord gutsRecord = getGutsRecord();
/* 1154 */     gutsRecord.setColLevelMax((short)(i + 1));
/* 1155 */     if (i == 0) {
/* 1156 */       gutsRecord.setTopColGutter((short)0);
/*      */     } else {
/* 1158 */       gutsRecord.setTopColGutter((short)(29 + 12 * (i - 1)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static DimensionsRecord createDimensions() {
/* 1167 */     DimensionsRecord dimensionsRecord = new DimensionsRecord();
/*      */     
/* 1169 */     dimensionsRecord.setFirstCol((short)0);
/* 1170 */     dimensionsRecord.setLastRow(1);
/* 1171 */     dimensionsRecord.setFirstRow(0);
/* 1172 */     dimensionsRecord.setLastCol((short)1);
/* 1173 */     return dimensionsRecord;
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
/*      */   private static WindowTwoRecord createWindowTwo() {
/* 1186 */     WindowTwoRecord windowTwoRecord = new WindowTwoRecord();
/*      */     
/* 1188 */     windowTwoRecord.setOptions((short)1718);
/* 1189 */     windowTwoRecord.setTopRow((short)0);
/* 1190 */     windowTwoRecord.setLeftCol((short)0);
/* 1191 */     windowTwoRecord.setHeaderColor(64);
/* 1192 */     windowTwoRecord.setPageBreakZoom((short)0);
/* 1193 */     windowTwoRecord.setNormalZoom((short)0);
/* 1194 */     return windowTwoRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static SelectionRecord createSelection() {
/* 1201 */     return new SelectionRecord(0, 0);
/*      */   }
/*      */   
/*      */   public short getTopRow() {
/* 1205 */     return (this.windowTwo == null) ? 0 : this.windowTwo.getTopRow();
/*      */   }
/*      */   
/*      */   public void setTopRow(short paramShort) {
/* 1209 */     if (this.windowTwo != null) {
/* 1210 */       this.windowTwo.setTopRow(paramShort);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLeftCol(short paramShort) {
/* 1219 */     if (this.windowTwo != null) {
/* 1220 */       this.windowTwo.setLeftCol(paramShort);
/*      */     }
/*      */   }
/*      */   
/*      */   public short getLeftCol() {
/* 1225 */     return (this.windowTwo == null) ? 0 : this.windowTwo.getLeftCol();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getActiveCellRow() {
/* 1235 */     if (this._selection == null) {
/* 1236 */       return 0;
/*      */     }
/* 1238 */     return this._selection.getActiveCellRow();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCellRow(int paramInt) {
/* 1249 */     if (this._selection != null) {
/* 1250 */       this._selection.setActiveCellRow(paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public short getActiveCellCol() {
/* 1259 */     if (this._selection == null) {
/* 1260 */       return 0;
/*      */     }
/* 1262 */     return (short)this._selection.getActiveCellCol();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setActiveCellCol(short paramShort) {
/* 1273 */     if (this._selection != null)
/*      */     {
/* 1275 */       this._selection.setActiveCellCol(paramShort);
/*      */     }
/*      */   }
/*      */   
/*      */   public List<RecordBase> getRecords() {
/* 1280 */     return this._records;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GridsetRecord getGridsetRecord() {
/* 1290 */     return this.gridset;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Record findFirstRecordBySid(short paramShort) {
/* 1301 */     int i = findFirstRecordLocBySid(paramShort);
/* 1302 */     if (i < 0) {
/* 1303 */       return null;
/*      */     }
/* 1305 */     return (Record)this._records.get(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSCLRecord(SCLRecord paramSCLRecord) {
/* 1315 */     int i = findFirstRecordLocBySid((short)160);
/* 1316 */     if (i == -1) {
/*      */       
/* 1318 */       int j = findFirstRecordLocBySid((short)574);
/* 1319 */       this._records.add(j + 1, paramSCLRecord);
/*      */     } else {
/* 1321 */       this._records.set(i, paramSCLRecord);
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
/*      */   public int findFirstRecordLocBySid(short paramShort) {
/* 1333 */     int i = this._records.size();
/* 1334 */     for (byte b = 0; b < i; b++) {
/* 1335 */       Record record = (Record)this._records.get(b);
/* 1336 */       if (record instanceof Record) {
/*      */ 
/*      */         
/* 1339 */         Record record1 = record;
/* 1340 */         if (record1.getSid() == paramShort)
/* 1341 */           return b; 
/*      */       } 
/*      */     } 
/* 1344 */     return -1;
/*      */   }
/*      */   
/*      */   public WindowTwoRecord getWindowTwo() {
/* 1348 */     return this.windowTwo;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PrintGridlinesRecord getPrintGridlines() {
/* 1357 */     return this.printGridlines;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintGridlines(PrintGridlinesRecord paramPrintGridlinesRecord) {
/* 1366 */     this.printGridlines = paramPrintGridlinesRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PrintHeadersRecord getPrintHeaders() {
/* 1375 */     return this.printHeaders;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintHeaders(PrintHeadersRecord paramPrintHeadersRecord) {
/* 1384 */     this.printHeaders = paramPrintHeadersRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSelected(boolean paramBoolean) {
/* 1392 */     this.windowTwo.setSelected(paramBoolean);
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
/*      */   public void createFreezePane(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1406 */     int i = findFirstRecordLocBySid((short)65);
/* 1407 */     if (i != -1) {
/* 1408 */       this._records.remove(i);
/*      */     }
/*      */     
/* 1411 */     if (paramInt1 == 0 && paramInt2 == 0) {
/* 1412 */       this.windowTwo.setFreezePanes(false);
/* 1413 */       this.windowTwo.setFreezePanesNoSplit(false);
/* 1414 */       SelectionRecord selectionRecord1 = (SelectionRecord)findFirstRecordBySid((short)29);
/* 1415 */       selectionRecord1.setPane((byte)3);
/*      */       
/*      */       return;
/*      */     } 
/* 1419 */     int j = findFirstRecordLocBySid((short)574);
/* 1420 */     PaneRecord paneRecord = new PaneRecord();
/* 1421 */     paneRecord.setX((short)paramInt1);
/* 1422 */     paneRecord.setY((short)paramInt2);
/* 1423 */     paneRecord.setTopRow((short)paramInt3);
/* 1424 */     paneRecord.setLeftColumn((short)paramInt4);
/* 1425 */     if (paramInt2 == 0) {
/* 1426 */       paneRecord.setTopRow((short)0);
/* 1427 */       paneRecord.setActivePane((short)1);
/* 1428 */     } else if (paramInt1 == 0) {
/* 1429 */       paneRecord.setLeftColumn((short)0);
/* 1430 */       paneRecord.setActivePane((short)2);
/*      */     } else {
/* 1432 */       paneRecord.setActivePane((short)0);
/*      */     } 
/* 1434 */     this._records.add(j + 1, paneRecord);
/*      */     
/* 1436 */     this.windowTwo.setFreezePanes(true);
/* 1437 */     this.windowTwo.setFreezePanesNoSplit(true);
/*      */     
/* 1439 */     SelectionRecord selectionRecord = (SelectionRecord)findFirstRecordBySid((short)29);
/* 1440 */     selectionRecord.setPane((byte)paneRecord.getActivePane());
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
/* 1458 */     int i = findFirstRecordLocBySid((short)65);
/* 1459 */     if (i != -1) {
/* 1460 */       this._records.remove(i);
/*      */     }
/* 1462 */     int j = findFirstRecordLocBySid((short)574);
/* 1463 */     PaneRecord paneRecord = new PaneRecord();
/* 1464 */     paneRecord.setX((short)paramInt1);
/* 1465 */     paneRecord.setY((short)paramInt2);
/* 1466 */     paneRecord.setTopRow((short)paramInt3);
/* 1467 */     paneRecord.setLeftColumn((short)paramInt4);
/* 1468 */     paneRecord.setActivePane((short)paramInt5);
/* 1469 */     this._records.add(j + 1, paneRecord);
/*      */     
/* 1471 */     this.windowTwo.setFreezePanes(false);
/* 1472 */     this.windowTwo.setFreezePanesNoSplit(false);
/*      */     
/* 1474 */     SelectionRecord selectionRecord = (SelectionRecord)findFirstRecordBySid((short)29);
/* 1475 */     selectionRecord.setPane((byte)0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public PaneInformation getPaneInformation() {
/* 1484 */     PaneRecord paneRecord = (PaneRecord)findFirstRecordBySid((short)65);
/* 1485 */     if (paneRecord == null) {
/* 1486 */       return null;
/*      */     }
/* 1488 */     return new PaneInformation(paneRecord.getX(), paneRecord.getY(), paneRecord.getTopRow(), paneRecord.getLeftColumn(), (byte)paneRecord.getActivePane(), this.windowTwo.getFreezePanes());
/*      */   }
/*      */ 
/*      */   
/*      */   public SelectionRecord getSelection() {
/* 1493 */     return this._selection;
/*      */   }
/*      */   
/*      */   public void setSelection(SelectionRecord paramSelectionRecord) {
/* 1497 */     this._selection = paramSelectionRecord;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public WorksheetProtectionBlock getProtectionBlock() {
/* 1504 */     return this._protectionBlock;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayGridlines(boolean paramBoolean) {
/* 1511 */     this.windowTwo.setDisplayGridlines(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayGridlines() {
/* 1518 */     return this.windowTwo.getDisplayGridlines();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayFormulas(boolean paramBoolean) {
/* 1526 */     this.windowTwo.setDisplayFormulas(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayFormulas() {
/* 1534 */     return this.windowTwo.getDisplayFormulas();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDisplayRowColHeadings(boolean paramBoolean) {
/* 1542 */     this.windowTwo.setDisplayRowColHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDisplayRowColHeadings() {
/* 1550 */     return this.windowTwo.getDisplayRowColHeadings();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPrintRowColHeadings(boolean paramBoolean) {
/* 1558 */     this.windowTwo.setDisplayRowColHeadings(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPrintRowColHeadings() {
/* 1566 */     return this.windowTwo.getDisplayRowColHeadings();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getUncalced() {
/* 1574 */     return this._isUncalced;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUncalced(boolean paramBoolean) {
/* 1580 */     this._isUncalced = paramBoolean;
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
/*      */   public int aggregateDrawingRecords(DrawingManager2 paramDrawingManager2, boolean paramBoolean) {
/* 1594 */     int i = findFirstRecordLocBySid((short)236);
/* 1595 */     boolean bool = (i == -1) ? true : false;
/* 1596 */     if (bool) {
/* 1597 */       if (!paramBoolean)
/*      */       {
/* 1599 */         return -1;
/*      */       }
/*      */       
/* 1602 */       EscherAggregate escherAggregate = new EscherAggregate(true);
/* 1603 */       i = findFirstRecordLocBySid((short)9876);
/* 1604 */       if (i == -1) {
/* 1605 */         i = findFirstRecordLocBySid((short)574);
/*      */       } else {
/* 1607 */         getRecords().remove(i);
/*      */       } 
/* 1609 */       getRecords().add(i, escherAggregate);
/* 1610 */       return i;
/*      */     } 
/* 1612 */     List<RecordBase> list = getRecords();
/*      */     
/* 1614 */     EscherAggregate.createAggregate(list, i);
/*      */     
/* 1616 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void preSerialize() {
/* 1625 */     for (RecordBase recordBase : getRecords()) {
/* 1626 */       if (recordBase instanceof EscherAggregate)
/*      */       {
/* 1628 */         recordBase.getRecordSize();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public PageSettingsBlock getPageSettings() {
/* 1635 */     if (this._psBlock == null) {
/* 1636 */       this._psBlock = new PageSettingsBlock();
/* 1637 */       RecordOrderer.addNewSheetRecord(this._records, (RecordBase)this._psBlock);
/*      */     } 
/* 1639 */     return this._psBlock;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setColumnGroupCollapsed(int paramInt, boolean paramBoolean) {
/* 1644 */     if (paramBoolean) {
/* 1645 */       this._columnInfos.collapseColumn(paramInt);
/*      */     } else {
/* 1647 */       this._columnInfos.expandColumn(paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void groupRowRange(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 1654 */     for (int i = paramInt1; i <= paramInt2; i++) {
/*      */       
/* 1656 */       RowRecord rowRecord = getRow(i);
/* 1657 */       if (rowRecord == null) {
/*      */         
/* 1659 */         rowRecord = RowRecordsAggregate.createRow(i);
/* 1660 */         addRow(rowRecord);
/*      */       } 
/* 1662 */       short s = rowRecord.getOutlineLevel();
/* 1663 */       if (paramBoolean) { s++; } else { s--; }
/* 1664 */        int j = Math.max(0, s);
/* 1665 */       j = Math.min(7, j);
/* 1666 */       rowRecord.setOutlineLevel((short)j);
/*      */     } 
/*      */     
/* 1669 */     recalcRowGutter();
/*      */   }
/*      */   
/*      */   private void recalcRowGutter() {
/* 1673 */     int i = 0;
/* 1674 */     Iterator<RowRecord> iterator = this._rowsAggregate.getIterator();
/* 1675 */     while (iterator.hasNext()) {
/* 1676 */       RowRecord rowRecord = iterator.next();
/* 1677 */       i = Math.max(rowRecord.getOutlineLevel(), i);
/*      */     } 
/*      */ 
/*      */     
/* 1681 */     GutsRecord gutsRecord = getGutsRecord();
/*      */     
/* 1683 */     gutsRecord.setRowLevelMax((short)(i + 1));
/* 1684 */     gutsRecord.setLeftRowGutter((short)(29 + 12 * i));
/*      */   }
/*      */   
/*      */   public DataValidityTable getOrCreateDataValidityTable() {
/* 1688 */     if (this._dataValidityTable == null) {
/* 1689 */       DataValidityTable dataValidityTable = new DataValidityTable();
/* 1690 */       RecordOrderer.addNewSheetRecord(this._records, (RecordBase)dataValidityTable);
/* 1691 */       this._dataValidityTable = dataValidityTable;
/*      */     } 
/* 1693 */     return this._dataValidityTable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NoteRecord[] getNoteRecords() {
/* 1700 */     ArrayList<NoteRecord> arrayList = new ArrayList();
/* 1701 */     for (int i = this._records.size() - 1; i >= 0; i--) {
/* 1702 */       RecordBase recordBase = this._records.get(i);
/* 1703 */       if (recordBase instanceof NoteRecord) {
/* 1704 */         arrayList.add((NoteRecord)recordBase);
/*      */       }
/*      */     } 
/* 1707 */     if (arrayList.size() < 1) {
/* 1708 */       return NoteRecord.EMPTY_ARRAY;
/*      */     }
/* 1710 */     NoteRecord[] arrayOfNoteRecord = new NoteRecord[arrayList.size()];
/* 1711 */     arrayList.toArray(arrayOfNoteRecord);
/* 1712 */     return arrayOfNoteRecord;
/*      */   }
/*      */   
/*      */   public int getColumnOutlineLevel(int paramInt) {
/* 1716 */     return this._columnInfos.getOutlineLevel(paramInt);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\InternalSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */