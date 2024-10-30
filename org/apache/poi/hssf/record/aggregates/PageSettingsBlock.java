/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.BottomMarginRecord;
/*     */ import org.apache.poi.hssf.record.ContinueRecord;
/*     */ import org.apache.poi.hssf.record.FooterRecord;
/*     */ import org.apache.poi.hssf.record.HCenterRecord;
/*     */ import org.apache.poi.hssf.record.HeaderFooterRecord;
/*     */ import org.apache.poi.hssf.record.HeaderRecord;
/*     */ import org.apache.poi.hssf.record.LeftMarginRecord;
/*     */ import org.apache.poi.hssf.record.Margin;
/*     */ import org.apache.poi.hssf.record.PageBreakRecord;
/*     */ import org.apache.poi.hssf.record.PrintSetupRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordBase;
/*     */ import org.apache.poi.hssf.record.RightMarginRecord;
/*     */ import org.apache.poi.hssf.record.TopMarginRecord;
/*     */ import org.apache.poi.hssf.record.UserSViewBegin;
/*     */ import org.apache.poi.hssf.record.VCenterRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ 
/*     */ public final class PageSettingsBlock extends RecordAggregate {
/*     */   private PageBreakRecord _rowBreaksRecord;
/*     */   private PageBreakRecord _columnBreaksRecord;
/*     */   private HeaderRecord _header;
/*     */   private FooterRecord _footer;
/*     */   private HCenterRecord _hCenter;
/*     */   private VCenterRecord _vCenter;
/*     */   private LeftMarginRecord _leftMargin;
/*     */   private RightMarginRecord _rightMargin;
/*     */   private TopMarginRecord _topMargin;
/*     */   private BottomMarginRecord _bottomMargin;
/*     */   private final List<PLSAggregate> _plsRecords;
/*     */   private PrintSetupRecord _printSetup;
/*     */   private Record _bitmap;
/*     */   private HeaderFooterRecord _headerFooter;
/*     */   
/*     */   private static final class PLSAggregate extends RecordAggregate {
/*  42 */     private static final ContinueRecord[] EMPTY_CONTINUE_RECORD_ARRAY = new ContinueRecord[0];
/*     */ 
/*     */     
/*     */     private final Record _pls;
/*     */ 
/*     */     
/*     */     private ContinueRecord[] _plsContinues;
/*     */ 
/*     */ 
/*     */     
/*     */     public PLSAggregate(RecordStream param1RecordStream) {
/*  53 */       this._pls = param1RecordStream.getNext();
/*  54 */       if (param1RecordStream.peekNextSid() == 60) {
/*  55 */         ArrayList<ContinueRecord> arrayList = new ArrayList();
/*  56 */         while (param1RecordStream.peekNextSid() == 60) {
/*  57 */           arrayList.add((ContinueRecord)param1RecordStream.getNext());
/*     */         }
/*  59 */         this._plsContinues = new ContinueRecord[arrayList.size()];
/*  60 */         arrayList.toArray(this._plsContinues);
/*     */       } else {
/*  62 */         this._plsContinues = EMPTY_CONTINUE_RECORD_ARRAY;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void visitContainedRecords(RecordAggregate.RecordVisitor param1RecordVisitor) {
/*  68 */       param1RecordVisitor.visitRecord(this._pls);
/*  69 */       for (ContinueRecord continueRecord : this._plsContinues) {
/*  70 */         param1RecordVisitor.visitRecord((Record)continueRecord);
/*     */       }
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
/*  96 */   private final List<HeaderFooterRecord> _sviewHeaderFooters = new ArrayList<HeaderFooterRecord>();
/*     */   private Record _printSize;
/*     */   
/*     */   public PageSettingsBlock(RecordStream paramRecordStream) {
/* 100 */     this._plsRecords = new ArrayList<PLSAggregate>(); do {
/*     */     
/* 102 */     } while (readARecord(paramRecordStream));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PageSettingsBlock() {
/* 112 */     this._plsRecords = new ArrayList<PLSAggregate>();
/* 113 */     this._rowBreaksRecord = (PageBreakRecord)new HorizontalPageBreakRecord();
/* 114 */     this._columnBreaksRecord = (PageBreakRecord)new VerticalPageBreakRecord();
/* 115 */     this._header = new HeaderRecord("");
/* 116 */     this._footer = new FooterRecord("");
/* 117 */     this._hCenter = createHCenter();
/* 118 */     this._vCenter = createVCenter();
/* 119 */     this._printSetup = createPrintSetup();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isComponentRecord(int paramInt) {
/* 129 */     switch (paramInt) {
/*     */       case 20:
/*     */       case 21:
/*     */       case 26:
/*     */       case 27:
/*     */       case 38:
/*     */       case 39:
/*     */       case 40:
/*     */       case 41:
/*     */       case 51:
/*     */       case 77:
/*     */       case 131:
/*     */       case 132:
/*     */       case 161:
/*     */       case 233:
/*     */       case 2204:
/* 145 */         return true;
/*     */     } 
/* 147 */     return false;
/*     */   }
/*     */   private boolean readARecord(RecordStream paramRecordStream) {
/*     */     HeaderFooterRecord headerFooterRecord;
/* 151 */     switch (paramRecordStream.peekNextSid()) {
/*     */       case 27:
/* 153 */         checkNotPresent((Record)this._rowBreaksRecord);
/* 154 */         this._rowBreaksRecord = (PageBreakRecord)paramRecordStream.getNext();
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
/* 220 */         return true;case 26: checkNotPresent((Record)this._columnBreaksRecord); this._columnBreaksRecord = (PageBreakRecord)paramRecordStream.getNext(); return true;case 20: checkNotPresent((Record)this._header); this._header = (HeaderRecord)paramRecordStream.getNext(); return true;case 21: checkNotPresent((Record)this._footer); this._footer = (FooterRecord)paramRecordStream.getNext(); return true;case 131: checkNotPresent((Record)this._hCenter); this._hCenter = (HCenterRecord)paramRecordStream.getNext(); return true;case 132: checkNotPresent((Record)this._vCenter); this._vCenter = (VCenterRecord)paramRecordStream.getNext(); return true;case 38: checkNotPresent((Record)this._leftMargin); this._leftMargin = (LeftMarginRecord)paramRecordStream.getNext(); return true;case 39: checkNotPresent((Record)this._rightMargin); this._rightMargin = (RightMarginRecord)paramRecordStream.getNext(); return true;case 40: checkNotPresent((Record)this._topMargin); this._topMargin = (TopMarginRecord)paramRecordStream.getNext(); return true;case 41: checkNotPresent((Record)this._bottomMargin); this._bottomMargin = (BottomMarginRecord)paramRecordStream.getNext(); return true;case 77: this._plsRecords.add(new PLSAggregate(paramRecordStream)); return true;case 161: checkNotPresent((Record)this._printSetup); this._printSetup = (PrintSetupRecord)paramRecordStream.getNext(); return true;case 233: checkNotPresent(this._bitmap); this._bitmap = paramRecordStream.getNext(); return true;case 51: checkNotPresent(this._printSize); this._printSize = paramRecordStream.getNext(); return true;case 2204: headerFooterRecord = (HeaderFooterRecord)paramRecordStream.getNext(); if (headerFooterRecord.isCurrentSheet()) { this._headerFooter = headerFooterRecord; } else { this._sviewHeaderFooters.add(headerFooterRecord); }  return true;
/*     */     } 
/*     */     return false;
/*     */   } private void checkNotPresent(Record paramRecord) {
/* 224 */     if (paramRecord != null) {
/* 225 */       throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(paramRecord.getSid()) + ")");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private PageBreakRecord getRowBreaksRecord() {
/* 231 */     if (this._rowBreaksRecord == null) {
/* 232 */       this._rowBreaksRecord = (PageBreakRecord)new HorizontalPageBreakRecord();
/*     */     }
/* 234 */     return this._rowBreaksRecord;
/*     */   }
/*     */   
/*     */   private PageBreakRecord getColumnBreaksRecord() {
/* 238 */     if (this._columnBreaksRecord == null) {
/* 239 */       this._columnBreaksRecord = (PageBreakRecord)new VerticalPageBreakRecord();
/*     */     }
/* 241 */     return this._columnBreaksRecord;
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
/*     */   public void setColumnBreak(short paramShort1, short paramShort2, short paramShort3) {
/* 253 */     getColumnBreaksRecord().addBreak(paramShort1, paramShort2, paramShort3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeColumnBreak(int paramInt) {
/* 262 */     getColumnBreaksRecord().removeBreak(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 272 */     visitIfPresent(this._rowBreaksRecord, paramRecordVisitor);
/* 273 */     visitIfPresent(this._columnBreaksRecord, paramRecordVisitor);
/*     */     
/* 275 */     if (this._header == null) {
/* 276 */       paramRecordVisitor.visitRecord((Record)new HeaderRecord(""));
/*     */     } else {
/* 278 */       paramRecordVisitor.visitRecord((Record)this._header);
/*     */     } 
/* 280 */     if (this._footer == null) {
/* 281 */       paramRecordVisitor.visitRecord((Record)new FooterRecord(""));
/*     */     } else {
/* 283 */       paramRecordVisitor.visitRecord((Record)this._footer);
/*     */     } 
/* 285 */     visitIfPresent((Record)this._hCenter, paramRecordVisitor);
/* 286 */     visitIfPresent((Record)this._vCenter, paramRecordVisitor);
/* 287 */     visitIfPresent((Record)this._leftMargin, paramRecordVisitor);
/* 288 */     visitIfPresent((Record)this._rightMargin, paramRecordVisitor);
/* 289 */     visitIfPresent((Record)this._topMargin, paramRecordVisitor);
/* 290 */     visitIfPresent((Record)this._bottomMargin, paramRecordVisitor);
/* 291 */     for (RecordAggregate recordAggregate : this._plsRecords) {
/* 292 */       recordAggregate.visitContainedRecords(paramRecordVisitor);
/*     */     }
/* 294 */     visitIfPresent((Record)this._printSetup, paramRecordVisitor);
/* 295 */     visitIfPresent(this._printSize, paramRecordVisitor);
/* 296 */     visitIfPresent((Record)this._headerFooter, paramRecordVisitor);
/* 297 */     visitIfPresent(this._bitmap, paramRecordVisitor);
/*     */   }
/*     */   private static void visitIfPresent(Record paramRecord, RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 300 */     if (paramRecord != null)
/* 301 */       paramRecordVisitor.visitRecord(paramRecord); 
/*     */   }
/*     */   
/*     */   private static void visitIfPresent(PageBreakRecord paramPageBreakRecord, RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 305 */     if (paramPageBreakRecord != null) {
/* 306 */       if (paramPageBreakRecord.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 310 */       paramRecordVisitor.visitRecord((Record)paramPageBreakRecord);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static HCenterRecord createHCenter() {
/* 318 */     HCenterRecord hCenterRecord = new HCenterRecord();
/*     */     
/* 320 */     hCenterRecord.setHCenter(false);
/* 321 */     return hCenterRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static VCenterRecord createVCenter() {
/* 328 */     VCenterRecord vCenterRecord = new VCenterRecord();
/*     */     
/* 330 */     vCenterRecord.setVCenter(false);
/* 331 */     return vCenterRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PrintSetupRecord createPrintSetup() {
/* 341 */     PrintSetupRecord printSetupRecord = new PrintSetupRecord();
/*     */     
/* 343 */     printSetupRecord.setPaperSize((short)1);
/* 344 */     printSetupRecord.setScale((short)100);
/* 345 */     printSetupRecord.setPageStart((short)1);
/* 346 */     printSetupRecord.setFitWidth((short)1);
/* 347 */     printSetupRecord.setFitHeight((short)1);
/* 348 */     printSetupRecord.setOptions((short)2);
/* 349 */     printSetupRecord.setHResolution((short)300);
/* 350 */     printSetupRecord.setVResolution((short)300);
/* 351 */     printSetupRecord.setHeaderMargin(0.5D);
/* 352 */     printSetupRecord.setFooterMargin(0.5D);
/* 353 */     printSetupRecord.setCopies((short)1);
/* 354 */     return printSetupRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderRecord getHeader() {
/* 364 */     return this._header;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeader(HeaderRecord paramHeaderRecord) {
/* 373 */     this._header = paramHeaderRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FooterRecord getFooter() {
/* 382 */     return this._footer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFooter(FooterRecord paramFooterRecord) {
/* 391 */     this._footer = paramFooterRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintSetupRecord getPrintSetup() {
/* 400 */     return this._printSetup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrintSetup(PrintSetupRecord paramPrintSetupRecord) {
/* 409 */     this._printSetup = paramPrintSetupRecord;
/*     */   }
/*     */ 
/*     */   
/*     */   private Margin getMarginRec(int paramInt) {
/* 414 */     switch (paramInt) { case 0:
/* 415 */         return (Margin)this._leftMargin;
/* 416 */       case 1: return (Margin)this._rightMargin;
/* 417 */       case 2: return (Margin)this._topMargin;
/* 418 */       case 3: return (Margin)this._bottomMargin; }
/*     */     
/* 420 */     throw new IllegalArgumentException("Unknown margin constant:  " + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMargin(short paramShort) {
/* 430 */     Margin margin = getMarginRec(paramShort);
/* 431 */     if (margin != null) {
/* 432 */       return margin.getMargin();
/*     */     }
/* 434 */     switch (paramShort) { case 0:
/* 435 */         return 0.75D;
/* 436 */       case 1: return 0.75D;
/* 437 */       case 2: return 1.0D;
/* 438 */       case 3: return 1.0D; }
/*     */     
/* 440 */     throw new IllegalArgumentException("Unknown margin constant:  " + paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMargin(short paramShort, double paramDouble) {
/*     */     BottomMarginRecord bottomMarginRecord;
/* 449 */     Margin margin = getMarginRec(paramShort);
/* 450 */     if (margin == null) {
/* 451 */       LeftMarginRecord leftMarginRecord; RightMarginRecord rightMarginRecord; TopMarginRecord topMarginRecord; switch (paramShort) {
/*     */         case 0:
/* 453 */           this._leftMargin = new LeftMarginRecord();
/* 454 */           leftMarginRecord = this._leftMargin;
/*     */           break;
/*     */         case 1:
/* 457 */           this._rightMargin = new RightMarginRecord();
/* 458 */           rightMarginRecord = this._rightMargin;
/*     */           break;
/*     */         case 2:
/* 461 */           this._topMargin = new TopMarginRecord();
/* 462 */           topMarginRecord = this._topMargin;
/*     */           break;
/*     */         case 3:
/* 465 */           this._bottomMargin = new BottomMarginRecord();
/* 466 */           bottomMarginRecord = this._bottomMargin;
/*     */           break;
/*     */         default:
/* 469 */           throw new IllegalArgumentException("Unknown margin constant:  " + paramShort);
/*     */       } 
/*     */     } 
/* 472 */     bottomMarginRecord.setMargin(paramDouble);
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
/*     */   private static void shiftBreaks(PageBreakRecord paramPageBreakRecord, int paramInt1, int paramInt2, int paramInt3) {
/* 484 */     Iterator<PageBreakRecord.Break> iterator = paramPageBreakRecord.getBreaksIterator();
/* 485 */     ArrayList<PageBreakRecord.Break> arrayList = new ArrayList();
/* 486 */     while (iterator.hasNext()) {
/*     */       
/* 488 */       PageBreakRecord.Break break_ = iterator.next();
/* 489 */       int i = break_.main;
/* 490 */       boolean bool1 = (i >= paramInt1) ? true : false;
/* 491 */       boolean bool2 = (i <= paramInt2) ? true : false;
/* 492 */       if (bool1 && bool2) {
/* 493 */         arrayList.add(break_);
/*     */       }
/*     */     } 
/*     */     
/* 497 */     iterator = arrayList.iterator();
/* 498 */     while (iterator.hasNext()) {
/* 499 */       PageBreakRecord.Break break_ = iterator.next();
/* 500 */       paramPageBreakRecord.removeBreak(break_.main);
/* 501 */       paramPageBreakRecord.addBreak((short)(break_.main + paramInt3), break_.subFrom, break_.subTo);
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
/*     */   public void setRowBreak(int paramInt, short paramShort1, short paramShort2) {
/* 513 */     getRowBreaksRecord().addBreak((short)paramInt, paramShort1, paramShort2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRowBreak(int paramInt) {
/* 521 */     if ((getRowBreaksRecord().getBreaks()).length < 1) {
/* 522 */       throw new IllegalArgumentException("Sheet does not define any row breaks");
/*     */     }
/* 524 */     getRowBreaksRecord().removeBreak((short)paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRowBroken(int paramInt) {
/* 535 */     return (getRowBreaksRecord().getBreak(paramInt) != null);
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
/*     */   public boolean isColumnBroken(int paramInt) {
/* 547 */     return (getColumnBreaksRecord().getBreak(paramInt) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shiftRowBreaks(int paramInt1, int paramInt2, int paramInt3) {
/* 557 */     shiftBreaks(getRowBreaksRecord(), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shiftColumnBreaks(short paramShort1, short paramShort2, short paramShort3) {
/* 567 */     shiftBreaks(getColumnBreaksRecord(), paramShort1, paramShort2, paramShort3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getRowBreaks() {
/* 574 */     return getRowBreaksRecord().getBreaks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumRowBreaks() {
/* 581 */     return getRowBreaksRecord().getNumBreaks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getColumnBreaks() {
/* 588 */     return getColumnBreaksRecord().getBreaks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumColumnBreaks() {
/* 595 */     return getColumnBreaksRecord().getNumBreaks();
/*     */   }
/*     */   
/*     */   public VCenterRecord getVCenter() {
/* 599 */     return this._vCenter;
/*     */   }
/*     */   
/*     */   public HCenterRecord getHCenter() {
/* 603 */     return this._hCenter;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addLateHeaderFooter(HeaderFooterRecord paramHeaderFooterRecord) {
/* 613 */     if (this._headerFooter != null) {
/* 614 */       throw new IllegalStateException("This page settings block already has a header/footer record");
/*     */     }
/* 616 */     if (paramHeaderFooterRecord.getSid() != 2204) {
/* 617 */       throw new RecordFormatException("Unexpected header-footer record sid: 0x" + Integer.toHexString(paramHeaderFooterRecord.getSid()));
/*     */     }
/* 619 */     this._headerFooter = paramHeaderFooterRecord;
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
/*     */   public void addLateRecords(RecordStream paramRecordStream) {
/*     */     do {
/*     */     
/* 655 */     } while (readARecord(paramRecordStream));
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
/*     */ 
/*     */   
/*     */   public void positionRecords(List<RecordBase> paramList) {
/* 675 */     ArrayList<HeaderFooterRecord> arrayList = new ArrayList<HeaderFooterRecord>(this._sviewHeaderFooters);
/*     */     
/* 677 */     final HashMap<Object, Object> hfGuidMap = new HashMap<Object, Object>();
/*     */     
/* 679 */     for (HeaderFooterRecord headerFooterRecord : arrayList) {
/* 680 */       hashMap.put(HexDump.toHex(headerFooterRecord.getGuid()), headerFooterRecord);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 685 */     for (RecordBase recordBase : paramList) {
/* 686 */       if (recordBase instanceof CustomViewSettingsRecordAggregate) {
/* 687 */         final CustomViewSettingsRecordAggregate cv = (CustomViewSettingsRecordAggregate)recordBase;
/* 688 */         customViewSettingsRecordAggregate.visitContainedRecords(new RecordAggregate.RecordVisitor()
/*     */             {
/*     */               public void visitRecord(Record param1Record) {
/* 691 */                 if (param1Record.getSid() == 426) {
/* 692 */                   String str = HexDump.toHex(((UserSViewBegin)param1Record).getGuid());
/* 693 */                   HeaderFooterRecord headerFooterRecord = (HeaderFooterRecord)hfGuidMap.get(str);
/*     */                   
/* 695 */                   if (headerFooterRecord != null) {
/* 696 */                     cv.append((RecordBase)headerFooterRecord);
/* 697 */                     PageSettingsBlock.this._sviewHeaderFooters.remove(headerFooterRecord);
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\PageSettingsBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */