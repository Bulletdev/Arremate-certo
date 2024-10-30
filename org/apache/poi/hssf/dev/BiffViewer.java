/*     */ package org.apache.poi.hssf.dev;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.ArrayRecord;
/*     */ import org.apache.poi.hssf.record.AutoFilterInfoRecord;
/*     */ import org.apache.poi.hssf.record.BOFRecord;
/*     */ import org.apache.poi.hssf.record.BackupRecord;
/*     */ import org.apache.poi.hssf.record.BlankRecord;
/*     */ import org.apache.poi.hssf.record.BookBoolRecord;
/*     */ import org.apache.poi.hssf.record.BoolErrRecord;
/*     */ import org.apache.poi.hssf.record.BottomMarginRecord;
/*     */ import org.apache.poi.hssf.record.BoundSheetRecord;
/*     */ import org.apache.poi.hssf.record.CFHeader12Record;
/*     */ import org.apache.poi.hssf.record.CFHeaderRecord;
/*     */ import org.apache.poi.hssf.record.CFRule12Record;
/*     */ import org.apache.poi.hssf.record.CFRuleRecord;
/*     */ import org.apache.poi.hssf.record.CalcCountRecord;
/*     */ import org.apache.poi.hssf.record.CalcModeRecord;
/*     */ import org.apache.poi.hssf.record.CodepageRecord;
/*     */ import org.apache.poi.hssf.record.ColumnInfoRecord;
/*     */ import org.apache.poi.hssf.record.ContinueRecord;
/*     */ import org.apache.poi.hssf.record.CountryRecord;
/*     */ import org.apache.poi.hssf.record.DBCellRecord;
/*     */ import org.apache.poi.hssf.record.DConRefRecord;
/*     */ import org.apache.poi.hssf.record.DSFRecord;
/*     */ import org.apache.poi.hssf.record.DVALRecord;
/*     */ import org.apache.poi.hssf.record.DVRecord;
/*     */ import org.apache.poi.hssf.record.DateWindow1904Record;
/*     */ import org.apache.poi.hssf.record.DefaultColWidthRecord;
/*     */ import org.apache.poi.hssf.record.DefaultRowHeightRecord;
/*     */ import org.apache.poi.hssf.record.DeltaRecord;
/*     */ import org.apache.poi.hssf.record.DimensionsRecord;
/*     */ import org.apache.poi.hssf.record.DrawingGroupRecord;
/*     */ import org.apache.poi.hssf.record.DrawingRecordForBiffViewer;
/*     */ import org.apache.poi.hssf.record.DrawingSelectionRecord;
/*     */ import org.apache.poi.hssf.record.EOFRecord;
/*     */ import org.apache.poi.hssf.record.ExtSSTRecord;
/*     */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*     */ import org.apache.poi.hssf.record.ExternSheetRecord;
/*     */ import org.apache.poi.hssf.record.ExternalNameRecord;
/*     */ import org.apache.poi.hssf.record.FeatHdrRecord;
/*     */ import org.apache.poi.hssf.record.FeatRecord;
/*     */ import org.apache.poi.hssf.record.FilePassRecord;
/*     */ import org.apache.poi.hssf.record.FileSharingRecord;
/*     */ import org.apache.poi.hssf.record.FnGroupCountRecord;
/*     */ import org.apache.poi.hssf.record.FontRecord;
/*     */ import org.apache.poi.hssf.record.FooterRecord;
/*     */ import org.apache.poi.hssf.record.FormatRecord;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.GridsetRecord;
/*     */ import org.apache.poi.hssf.record.GutsRecord;
/*     */ import org.apache.poi.hssf.record.HCenterRecord;
/*     */ import org.apache.poi.hssf.record.HeaderRecord;
/*     */ import org.apache.poi.hssf.record.HideObjRecord;
/*     */ import org.apache.poi.hssf.record.HorizontalPageBreakRecord;
/*     */ import org.apache.poi.hssf.record.HyperlinkRecord;
/*     */ import org.apache.poi.hssf.record.IndexRecord;
/*     */ import org.apache.poi.hssf.record.InterfaceEndRecord;
/*     */ import org.apache.poi.hssf.record.InterfaceHdrRecord;
/*     */ import org.apache.poi.hssf.record.IterationRecord;
/*     */ import org.apache.poi.hssf.record.LabelRecord;
/*     */ import org.apache.poi.hssf.record.LabelSSTRecord;
/*     */ import org.apache.poi.hssf.record.LeftMarginRecord;
/*     */ import org.apache.poi.hssf.record.MMSRecord;
/*     */ import org.apache.poi.hssf.record.MergeCellsRecord;
/*     */ import org.apache.poi.hssf.record.MulBlankRecord;
/*     */ import org.apache.poi.hssf.record.MulRKRecord;
/*     */ import org.apache.poi.hssf.record.NameCommentRecord;
/*     */ import org.apache.poi.hssf.record.NameRecord;
/*     */ import org.apache.poi.hssf.record.NoteRecord;
/*     */ import org.apache.poi.hssf.record.NumberRecord;
/*     */ import org.apache.poi.hssf.record.ObjRecord;
/*     */ import org.apache.poi.hssf.record.PaletteRecord;
/*     */ import org.apache.poi.hssf.record.PaneRecord;
/*     */ import org.apache.poi.hssf.record.PasswordRecord;
/*     */ import org.apache.poi.hssf.record.PasswordRev4Record;
/*     */ import org.apache.poi.hssf.record.PrecisionRecord;
/*     */ import org.apache.poi.hssf.record.PrintGridlinesRecord;
/*     */ import org.apache.poi.hssf.record.PrintHeadersRecord;
/*     */ import org.apache.poi.hssf.record.PrintSetupRecord;
/*     */ import org.apache.poi.hssf.record.ProtectRecord;
/*     */ import org.apache.poi.hssf.record.ProtectionRev4Record;
/*     */ import org.apache.poi.hssf.record.RKRecord;
/*     */ import org.apache.poi.hssf.record.RecalcIdRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.RefModeRecord;
/*     */ import org.apache.poi.hssf.record.RefreshAllRecord;
/*     */ import org.apache.poi.hssf.record.RightMarginRecord;
/*     */ import org.apache.poi.hssf.record.RowRecord;
/*     */ import org.apache.poi.hssf.record.SCLRecord;
/*     */ import org.apache.poi.hssf.record.SSTRecord;
/*     */ import org.apache.poi.hssf.record.SaveRecalcRecord;
/*     */ import org.apache.poi.hssf.record.SelectionRecord;
/*     */ import org.apache.poi.hssf.record.SharedFormulaRecord;
/*     */ import org.apache.poi.hssf.record.StringRecord;
/*     */ import org.apache.poi.hssf.record.StyleRecord;
/*     */ import org.apache.poi.hssf.record.SupBookRecord;
/*     */ import org.apache.poi.hssf.record.TabIdRecord;
/*     */ import org.apache.poi.hssf.record.TableRecord;
/*     */ import org.apache.poi.hssf.record.TableStylesRecord;
/*     */ import org.apache.poi.hssf.record.TextObjectRecord;
/*     */ import org.apache.poi.hssf.record.TopMarginRecord;
/*     */ import org.apache.poi.hssf.record.UncalcedRecord;
/*     */ import org.apache.poi.hssf.record.UnknownRecord;
/*     */ import org.apache.poi.hssf.record.UseSelFSRecord;
/*     */ import org.apache.poi.hssf.record.VCenterRecord;
/*     */ import org.apache.poi.hssf.record.VerticalPageBreakRecord;
/*     */ import org.apache.poi.hssf.record.WSBoolRecord;
/*     */ import org.apache.poi.hssf.record.WindowOneRecord;
/*     */ import org.apache.poi.hssf.record.WindowProtectRecord;
/*     */ import org.apache.poi.hssf.record.WindowTwoRecord;
/*     */ import org.apache.poi.hssf.record.WriteAccessRecord;
/*     */ import org.apache.poi.hssf.record.WriteProtectRecord;
/*     */ import org.apache.poi.hssf.record.chart.AreaFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.AreaRecord;
/*     */ import org.apache.poi.hssf.record.chart.AxisLineFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.AxisOptionsRecord;
/*     */ import org.apache.poi.hssf.record.chart.AxisParentRecord;
/*     */ import org.apache.poi.hssf.record.chart.AxisRecord;
/*     */ import org.apache.poi.hssf.record.chart.AxisUsedRecord;
/*     */ import org.apache.poi.hssf.record.chart.BarRecord;
/*     */ import org.apache.poi.hssf.record.chart.BeginRecord;
/*     */ import org.apache.poi.hssf.record.chart.CatLabRecord;
/*     */ import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartEndBlockRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartFRTInfoRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
/*     */ import org.apache.poi.hssf.record.chart.DatRecord;
/*     */ import org.apache.poi.hssf.record.chart.DataFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.DefaultDataLabelTextPropertiesRecord;
/*     */ import org.apache.poi.hssf.record.chart.EndRecord;
/*     */ import org.apache.poi.hssf.record.chart.FontBasisRecord;
/*     */ import org.apache.poi.hssf.record.chart.FontIndexRecord;
/*     */ import org.apache.poi.hssf.record.chart.FrameRecord;
/*     */ import org.apache.poi.hssf.record.chart.LegendRecord;
/*     */ import org.apache.poi.hssf.record.chart.LineFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.LinkedDataRecord;
/*     */ import org.apache.poi.hssf.record.chart.ObjectLinkRecord;
/*     */ import org.apache.poi.hssf.record.chart.PlotAreaRecord;
/*     */ import org.apache.poi.hssf.record.chart.PlotGrowthRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesIndexRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesListRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesTextRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesToChartGroupRecord;
/*     */ import org.apache.poi.hssf.record.chart.SheetPropertiesRecord;
/*     */ import org.apache.poi.hssf.record.chart.TextRecord;
/*     */ import org.apache.poi.hssf.record.chart.TickRecord;
/*     */ import org.apache.poi.hssf.record.chart.UnitsRecord;
/*     */ import org.apache.poi.hssf.record.chart.ValueRangeRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.DataItemRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.PageItemRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewDefinitionRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewFieldsRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.RecordFormatException;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class BiffViewer
/*     */ {
/* 207 */   private static final char[] NEW_LINE_CHARS = System.getProperty("line.separator").toCharArray();
/* 208 */   private static final POILogger logger = POILogFactory.getLogger(BiffViewer.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int DUMP_LINE_LEN = 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Record[] createRecords(InputStream paramInputStream, PrintWriter paramPrintWriter, BiffRecordListener paramBiffRecordListener, boolean paramBoolean) throws RecordFormatException {
/* 227 */     ArrayList<Record> arrayList = new ArrayList();
/*     */     
/* 229 */     RecordInputStream recordInputStream = new RecordInputStream(paramInputStream);
/*     */     while (true) {
/*     */       boolean bool;
/*     */       try {
/* 233 */         bool = recordInputStream.hasNextRecord();
/* 234 */       } catch (org.apache.poi.hssf.record.RecordInputStream.LeftoverDataException leftoverDataException) {
/* 235 */         logger.log(7, new Object[] { "Discarding " + recordInputStream.remaining() + " bytes and continuing", leftoverDataException });
/* 236 */         recordInputStream.readRemainder();
/* 237 */         bool = recordInputStream.hasNextRecord();
/*     */       } 
/* 239 */       if (!bool) {
/*     */         break;
/*     */       }
/* 242 */       recordInputStream.nextRecord();
/* 243 */       if (recordInputStream.getSid() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 247 */       if (paramBoolean) {
/* 248 */         Record record = createRecord(recordInputStream);
/* 249 */         if (record.getSid() == 60) {
/*     */           continue;
/*     */         }
/* 252 */         arrayList.add(record);
/*     */         
/* 254 */         if (paramBoolean) {
/* 255 */           for (String str : paramBiffRecordListener.getRecentHeaders()) {
/* 256 */             paramPrintWriter.println(str);
/*     */           }
/* 258 */           paramPrintWriter.print(record.toString());
/*     */         } 
/*     */       } else {
/* 261 */         recordInputStream.readRemainder();
/*     */       } 
/* 263 */       paramPrintWriter.println();
/*     */     } 
/* 265 */     Record[] arrayOfRecord = new Record[arrayList.size()];
/* 266 */     arrayList.toArray(arrayOfRecord);
/* 267 */     return arrayOfRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Record createRecord(RecordInputStream paramRecordInputStream) {
/* 277 */     switch (paramRecordInputStream.getSid()) { case 4106:
/* 278 */         return (Record)new AreaFormatRecord(paramRecordInputStream);
/* 279 */       case 4122: return (Record)new AreaRecord(paramRecordInputStream);
/* 280 */       case 545: return (Record)new ArrayRecord(paramRecordInputStream);
/* 281 */       case 4129: return (Record)new AxisLineFormatRecord(paramRecordInputStream);
/* 282 */       case 4194: return (Record)new AxisOptionsRecord(paramRecordInputStream);
/* 283 */       case 4161: return (Record)new AxisParentRecord(paramRecordInputStream);
/* 284 */       case 4125: return (Record)new AxisRecord(paramRecordInputStream);
/* 285 */       case 4166: return (Record)new AxisUsedRecord(paramRecordInputStream);
/* 286 */       case 157: return (Record)new AutoFilterInfoRecord(paramRecordInputStream);
/* 287 */       case 2057: return (Record)new BOFRecord(paramRecordInputStream);
/* 288 */       case 64: return (Record)new BackupRecord(paramRecordInputStream);
/* 289 */       case 4119: return (Record)new BarRecord(paramRecordInputStream);
/* 290 */       case 4147: return (Record)new BeginRecord(paramRecordInputStream);
/* 291 */       case 513: return (Record)new BlankRecord(paramRecordInputStream);
/* 292 */       case 218: return (Record)new BookBoolRecord(paramRecordInputStream);
/* 293 */       case 517: return (Record)new BoolErrRecord(paramRecordInputStream);
/* 294 */       case 41: return (Record)new BottomMarginRecord(paramRecordInputStream);
/* 295 */       case 133: return (Record)new BoundSheetRecord(paramRecordInputStream);
/* 296 */       case 432: return (Record)new CFHeaderRecord(paramRecordInputStream);
/* 297 */       case 2169: return (Record)new CFHeader12Record(paramRecordInputStream);
/* 298 */       case 433: return (Record)new CFRuleRecord(paramRecordInputStream);
/* 299 */       case 2170: return (Record)new CFRule12Record(paramRecordInputStream);
/*     */       case 12:
/* 301 */         return (Record)new CalcCountRecord(paramRecordInputStream);
/* 302 */       case 13: return (Record)new CalcModeRecord(paramRecordInputStream);
/* 303 */       case 4128: return (Record)new CategorySeriesAxisRecord(paramRecordInputStream);
/* 304 */       case 4116: return (Record)new ChartFormatRecord(paramRecordInputStream);
/* 305 */       case 4098: return (Record)new ChartRecord(paramRecordInputStream);
/* 306 */       case 66: return (Record)new CodepageRecord(paramRecordInputStream);
/* 307 */       case 125: return (Record)new ColumnInfoRecord(paramRecordInputStream);
/* 308 */       case 60: return (Record)new ContinueRecord(paramRecordInputStream);
/* 309 */       case 140: return (Record)new CountryRecord(paramRecordInputStream);
/* 310 */       case 215: return (Record)new DBCellRecord(paramRecordInputStream);
/* 311 */       case 353: return (Record)new DSFRecord(paramRecordInputStream);
/* 312 */       case 4195: return (Record)new DatRecord(paramRecordInputStream);
/* 313 */       case 4102: return (Record)new DataFormatRecord(paramRecordInputStream);
/* 314 */       case 34: return (Record)new DateWindow1904Record(paramRecordInputStream);
/* 315 */       case 81: return (Record)new DConRefRecord(paramRecordInputStream);
/* 316 */       case 85: return (Record)new DefaultColWidthRecord(paramRecordInputStream);
/* 317 */       case 4132: return (Record)new DefaultDataLabelTextPropertiesRecord(paramRecordInputStream);
/* 318 */       case 549: return (Record)new DefaultRowHeightRecord(paramRecordInputStream);
/* 319 */       case 16: return (Record)new DeltaRecord(paramRecordInputStream);
/* 320 */       case 512: return (Record)new DimensionsRecord(paramRecordInputStream);
/* 321 */       case 235: return (Record)new DrawingGroupRecord(paramRecordInputStream);
/* 322 */       case 236: return (Record)new DrawingRecordForBiffViewer(paramRecordInputStream);
/* 323 */       case 237: return (Record)new DrawingSelectionRecord(paramRecordInputStream);
/* 324 */       case 446: return (Record)new DVRecord(paramRecordInputStream);
/* 325 */       case 434: return (Record)new DVALRecord(paramRecordInputStream);
/* 326 */       case 10: return (Record)new EOFRecord(paramRecordInputStream);
/* 327 */       case 4148: return (Record)new EndRecord(paramRecordInputStream);
/* 328 */       case 255: return (Record)new ExtSSTRecord(paramRecordInputStream);
/* 329 */       case 224: return (Record)new ExtendedFormatRecord(paramRecordInputStream);
/* 330 */       case 23: return (Record)new ExternSheetRecord(paramRecordInputStream);
/* 331 */       case 35: return (Record)new ExternalNameRecord(paramRecordInputStream);
/* 332 */       case 2152: return (Record)new FeatRecord(paramRecordInputStream);
/* 333 */       case 2151: return (Record)new FeatHdrRecord(paramRecordInputStream);
/* 334 */       case 47: return (Record)new FilePassRecord(paramRecordInputStream);
/* 335 */       case 91: return (Record)new FileSharingRecord(paramRecordInputStream);
/* 336 */       case 156: return (Record)new FnGroupCountRecord(paramRecordInputStream);
/* 337 */       case 4192: return (Record)new FontBasisRecord(paramRecordInputStream);
/* 338 */       case 4134: return (Record)new FontIndexRecord(paramRecordInputStream);
/* 339 */       case 49: return (Record)new FontRecord(paramRecordInputStream);
/* 340 */       case 21: return (Record)new FooterRecord(paramRecordInputStream);
/* 341 */       case 1054: return (Record)new FormatRecord(paramRecordInputStream);
/* 342 */       case 6: return (Record)new FormulaRecord(paramRecordInputStream);
/* 343 */       case 4146: return (Record)new FrameRecord(paramRecordInputStream);
/* 344 */       case 130: return (Record)new GridsetRecord(paramRecordInputStream);
/* 345 */       case 128: return (Record)new GutsRecord(paramRecordInputStream);
/* 346 */       case 131: return (Record)new HCenterRecord(paramRecordInputStream);
/* 347 */       case 20: return (Record)new HeaderRecord(paramRecordInputStream);
/* 348 */       case 141: return (Record)new HideObjRecord(paramRecordInputStream);
/* 349 */       case 27: return (Record)new HorizontalPageBreakRecord(paramRecordInputStream);
/* 350 */       case 440: return (Record)new HyperlinkRecord(paramRecordInputStream);
/* 351 */       case 523: return (Record)new IndexRecord(paramRecordInputStream);
/* 352 */       case 226: return InterfaceEndRecord.create(paramRecordInputStream);
/* 353 */       case 225: return (Record)new InterfaceHdrRecord(paramRecordInputStream);
/* 354 */       case 17: return (Record)new IterationRecord(paramRecordInputStream);
/* 355 */       case 516: return (Record)new LabelRecord(paramRecordInputStream);
/* 356 */       case 253: return (Record)new LabelSSTRecord(paramRecordInputStream);
/* 357 */       case 38: return (Record)new LeftMarginRecord(paramRecordInputStream);
/* 358 */       case 4117: return (Record)new LegendRecord(paramRecordInputStream);
/* 359 */       case 4103: return (Record)new LineFormatRecord(paramRecordInputStream);
/* 360 */       case 4177: return (Record)new LinkedDataRecord(paramRecordInputStream);
/* 361 */       case 193: return (Record)new MMSRecord(paramRecordInputStream);
/* 362 */       case 229: return (Record)new MergeCellsRecord(paramRecordInputStream);
/* 363 */       case 190: return (Record)new MulBlankRecord(paramRecordInputStream);
/* 364 */       case 189: return (Record)new MulRKRecord(paramRecordInputStream);
/* 365 */       case 24: return (Record)new NameRecord(paramRecordInputStream);
/* 366 */       case 2196: return (Record)new NameCommentRecord(paramRecordInputStream);
/* 367 */       case 28: return (Record)new NoteRecord(paramRecordInputStream);
/* 368 */       case 515: return (Record)new NumberRecord(paramRecordInputStream);
/* 369 */       case 93: return (Record)new ObjRecord(paramRecordInputStream);
/* 370 */       case 4135: return (Record)new ObjectLinkRecord(paramRecordInputStream);
/* 371 */       case 146: return (Record)new PaletteRecord(paramRecordInputStream);
/* 372 */       case 65: return (Record)new PaneRecord(paramRecordInputStream);
/* 373 */       case 19: return (Record)new PasswordRecord(paramRecordInputStream);
/* 374 */       case 444: return (Record)new PasswordRev4Record(paramRecordInputStream);
/* 375 */       case 4149: return (Record)new PlotAreaRecord(paramRecordInputStream);
/* 376 */       case 4196: return (Record)new PlotGrowthRecord(paramRecordInputStream);
/* 377 */       case 14: return (Record)new PrecisionRecord(paramRecordInputStream);
/* 378 */       case 43: return (Record)new PrintGridlinesRecord(paramRecordInputStream);
/* 379 */       case 42: return (Record)new PrintHeadersRecord(paramRecordInputStream);
/* 380 */       case 161: return (Record)new PrintSetupRecord(paramRecordInputStream);
/* 381 */       case 18: return (Record)new ProtectRecord(paramRecordInputStream);
/* 382 */       case 431: return (Record)new ProtectionRev4Record(paramRecordInputStream);
/* 383 */       case 638: return (Record)new RKRecord(paramRecordInputStream);
/* 384 */       case 449: return (Record)new RecalcIdRecord(paramRecordInputStream);
/* 385 */       case 15: return (Record)new RefModeRecord(paramRecordInputStream);
/* 386 */       case 439: return (Record)new RefreshAllRecord(paramRecordInputStream);
/* 387 */       case 39: return (Record)new RightMarginRecord(paramRecordInputStream);
/* 388 */       case 520: return (Record)new RowRecord(paramRecordInputStream);
/* 389 */       case 160: return (Record)new SCLRecord(paramRecordInputStream);
/* 390 */       case 252: return (Record)new SSTRecord(paramRecordInputStream);
/* 391 */       case 95: return (Record)new SaveRecalcRecord(paramRecordInputStream);
/* 392 */       case 29: return (Record)new SelectionRecord(paramRecordInputStream);
/* 393 */       case 4197: return (Record)new SeriesIndexRecord(paramRecordInputStream);
/* 394 */       case 4118: return (Record)new SeriesListRecord(paramRecordInputStream);
/* 395 */       case 4099: return (Record)new SeriesRecord(paramRecordInputStream);
/* 396 */       case 4109: return (Record)new SeriesTextRecord(paramRecordInputStream);
/* 397 */       case 4165: return (Record)new SeriesToChartGroupRecord(paramRecordInputStream);
/* 398 */       case 1212: return (Record)new SharedFormulaRecord(paramRecordInputStream);
/* 399 */       case 4164: return (Record)new SheetPropertiesRecord(paramRecordInputStream);
/* 400 */       case 519: return (Record)new StringRecord(paramRecordInputStream);
/* 401 */       case 659: return (Record)new StyleRecord(paramRecordInputStream);
/* 402 */       case 430: return (Record)new SupBookRecord(paramRecordInputStream);
/* 403 */       case 317: return (Record)new TabIdRecord(paramRecordInputStream);
/* 404 */       case 2190: return (Record)new TableStylesRecord(paramRecordInputStream);
/* 405 */       case 566: return (Record)new TableRecord(paramRecordInputStream);
/* 406 */       case 438: return (Record)new TextObjectRecord(paramRecordInputStream);
/* 407 */       case 4133: return (Record)new TextRecord(paramRecordInputStream);
/* 408 */       case 4126: return (Record)new TickRecord(paramRecordInputStream);
/* 409 */       case 40: return (Record)new TopMarginRecord(paramRecordInputStream);
/* 410 */       case 94: return (Record)new UncalcedRecord(paramRecordInputStream);
/* 411 */       case 4097: return (Record)new UnitsRecord(paramRecordInputStream);
/* 412 */       case 352: return (Record)new UseSelFSRecord(paramRecordInputStream);
/* 413 */       case 132: return (Record)new VCenterRecord(paramRecordInputStream);
/* 414 */       case 4127: return (Record)new ValueRangeRecord(paramRecordInputStream);
/* 415 */       case 26: return (Record)new VerticalPageBreakRecord(paramRecordInputStream);
/* 416 */       case 129: return (Record)new WSBoolRecord(paramRecordInputStream);
/* 417 */       case 61: return (Record)new WindowOneRecord(paramRecordInputStream);
/* 418 */       case 25: return (Record)new WindowProtectRecord(paramRecordInputStream);
/* 419 */       case 574: return (Record)new WindowTwoRecord(paramRecordInputStream);
/* 420 */       case 92: return (Record)new WriteAccessRecord(paramRecordInputStream);
/* 421 */       case 134: return (Record)new WriteProtectRecord(paramRecordInputStream);
/*     */       
/*     */       case 2134:
/* 424 */         return (Record)new CatLabRecord(paramRecordInputStream);
/* 425 */       case 2131: return (Record)new ChartEndBlockRecord(paramRecordInputStream);
/* 426 */       case 2133: return (Record)new ChartEndObjectRecord(paramRecordInputStream);
/* 427 */       case 2128: return (Record)new ChartFRTInfoRecord(paramRecordInputStream);
/* 428 */       case 2130: return (Record)new ChartStartBlockRecord(paramRecordInputStream);
/* 429 */       case 2132: return (Record)new ChartStartObjectRecord(paramRecordInputStream);
/*     */       
/*     */       case 213:
/* 432 */         return (Record)new StreamIDRecord(paramRecordInputStream);
/* 433 */       case 227: return (Record)new ViewSourceRecord(paramRecordInputStream);
/* 434 */       case 182: return (Record)new PageItemRecord(paramRecordInputStream);
/* 435 */       case 176: return (Record)new ViewDefinitionRecord(paramRecordInputStream);
/* 436 */       case 177: return (Record)new ViewFieldsRecord(paramRecordInputStream);
/* 437 */       case 197: return (Record)new DataItemRecord(paramRecordInputStream);
/* 438 */       case 256: return (Record)new ExtendedPivotTableViewFieldsRecord(paramRecordInputStream); }
/*     */     
/* 440 */     return (Record)new UnknownRecord(paramRecordInputStream);
/*     */   }
/*     */   
/*     */   private static final class CommandArgs
/*     */   {
/*     */     private final boolean _biffhex;
/*     */     private final boolean _noint;
/*     */     private final boolean _out;
/*     */     private final boolean _rawhex;
/*     */     private final boolean _noHeader;
/*     */     private final File _file;
/*     */     
/*     */     private CommandArgs(boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4, boolean param1Boolean5, File param1File) {
/* 453 */       this._biffhex = param1Boolean1;
/* 454 */       this._noint = param1Boolean2;
/* 455 */       this._out = param1Boolean3;
/* 456 */       this._rawhex = param1Boolean4;
/* 457 */       this._file = param1File;
/* 458 */       this._noHeader = param1Boolean5;
/*     */     }
/*     */     
/*     */     public static CommandArgs parse(String[] param1ArrayOfString) throws BiffViewer.CommandParseException {
/* 462 */       int i = param1ArrayOfString.length;
/* 463 */       boolean bool1 = false;
/* 464 */       boolean bool2 = false;
/* 465 */       boolean bool3 = false;
/* 466 */       boolean bool4 = false;
/* 467 */       boolean bool5 = false;
/* 468 */       File file = null;
/* 469 */       for (byte b = 0; b < i; b++) {
/* 470 */         String str = param1ArrayOfString[b];
/* 471 */         if (str.startsWith("--")) {
/* 472 */           if ("--biffhex".equals(str)) {
/* 473 */             bool1 = true;
/* 474 */           } else if ("--noint".equals(str)) {
/* 475 */             bool2 = true;
/* 476 */           } else if ("--out".equals(str)) {
/* 477 */             bool3 = true;
/* 478 */           } else if ("--escher".equals(str)) {
/* 479 */             System.setProperty("poi.deserialize.escher", "true");
/* 480 */           } else if ("--rawhex".equals(str)) {
/* 481 */             bool4 = true;
/* 482 */           } else if ("--noheader".equals(str)) {
/* 483 */             bool5 = true;
/*     */           } else {
/* 485 */             throw new BiffViewer.CommandParseException("Unexpected option '" + str + "'");
/*     */           } 
/*     */         } else {
/*     */           
/* 489 */           file = new File(str);
/* 490 */           if (!file.exists()) {
/* 491 */             throw new BiffViewer.CommandParseException("Specified file '" + str + "' does not exist");
/*     */           }
/* 493 */           if (b + 1 < i)
/* 494 */             throw new BiffViewer.CommandParseException("File name must be the last arg"); 
/*     */         } 
/*     */       } 
/* 497 */       if (file == null) {
/* 498 */         throw new BiffViewer.CommandParseException("Biff viewer needs a filename");
/*     */       }
/* 500 */       return new CommandArgs(bool1, bool2, bool3, bool4, bool5, file);
/*     */     }
/*     */     public boolean shouldDumpBiffHex() {
/* 503 */       return this._biffhex;
/*     */     }
/*     */     public boolean shouldDumpRecordInterpretations() {
/* 506 */       return !this._noint;
/*     */     }
/*     */     public boolean shouldOutputToFile() {
/* 509 */       return this._out;
/*     */     }
/*     */     public boolean shouldOutputRawHexOnly() {
/* 512 */       return this._rawhex;
/*     */     }
/*     */     public boolean suppressHeader() {
/* 515 */       return this._noHeader;
/*     */     }
/*     */     public File getFile() {
/* 518 */       return this._file;
/*     */     } }
/*     */   
/*     */   private static final class CommandParseException extends Exception {
/*     */     public CommandParseException(String param1String) {
/* 523 */       super(param1String);
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
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException, CommandParseException {
/*     */     PrintWriter printWriter;
/* 552 */     CommandArgs commandArgs = CommandArgs.parse(paramArrayOfString);
/*     */ 
/*     */     
/* 555 */     if (commandArgs.shouldOutputToFile()) {
/* 556 */       FileOutputStream fileOutputStream = new FileOutputStream(commandArgs.getFile().getAbsolutePath() + ".out");
/* 557 */       printWriter = new PrintWriter(new OutputStreamWriter(fileOutputStream, StringUtil.UTF8));
/*     */     } else {
/*     */       
/* 560 */       printWriter = new PrintWriter(new OutputStreamWriter(System.out, Charset.defaultCharset()));
/*     */     } 
/*     */     
/*     */     try {
/* 564 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(commandArgs.getFile(), true);
/*     */       try {
/* 566 */         InputStream inputStream = getPOIFSInputStream(nPOIFSFileSystem);
/*     */         
/*     */         try {
/* 569 */           if (commandArgs.shouldOutputRawHexOnly()) {
/* 570 */             int i = inputStream.available();
/* 571 */             byte[] arrayOfByte = new byte[i];
/*     */             
/* 573 */             inputStream.read(arrayOfByte);
/* 574 */             HexDump.dump(arrayOfByte, 0L, System.out, 0);
/*     */           } else {
/* 576 */             boolean bool1 = commandArgs.shouldDumpRecordInterpretations();
/* 577 */             boolean bool2 = commandArgs.shouldDumpBiffHex();
/* 578 */             boolean bool3 = bool1;
/* 579 */             runBiffViewer(printWriter, inputStream, bool1, bool2, bool3, commandArgs.suppressHeader());
/*     */           } 
/*     */         } finally {
/*     */           
/* 583 */           inputStream.close();
/*     */         } 
/*     */       } finally {
/* 586 */         nPOIFSFileSystem.close();
/*     */       } 
/*     */     } finally {
/* 589 */       printWriter.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected static InputStream getPOIFSInputStream(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException, FileNotFoundException {
/* 595 */     String str = HSSFWorkbook.getWorkbookDirEntryName(paramNPOIFSFileSystem.getRoot());
/* 596 */     return (InputStream)paramNPOIFSFileSystem.createDocumentInputStream(str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static void runBiffViewer(PrintWriter paramPrintWriter, InputStream paramInputStream, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
/* 602 */     BiffRecordListener biffRecordListener = new BiffRecordListener(paramBoolean2 ? paramPrintWriter : null, paramBoolean3, paramBoolean4);
/* 603 */     paramInputStream = new BiffDumpingStream(paramInputStream, biffRecordListener);
/* 604 */     createRecords(paramInputStream, paramPrintWriter, biffRecordListener, paramBoolean1);
/*     */   }
/*     */   
/*     */   private static final class BiffRecordListener implements IBiffRecordListener { private final Writer _hexDumpWriter;
/*     */     private List<String> _headers;
/*     */     private final boolean _zeroAlignEachRecord;
/*     */     private final boolean _noHeader;
/*     */     
/*     */     public BiffRecordListener(Writer param1Writer, boolean param1Boolean1, boolean param1Boolean2) {
/* 613 */       this._hexDumpWriter = param1Writer;
/* 614 */       this._zeroAlignEachRecord = param1Boolean1;
/* 615 */       this._noHeader = param1Boolean2;
/* 616 */       this._headers = new ArrayList<String>();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void processRecord(int param1Int1, int param1Int2, int param1Int3, int param1Int4, byte[] param1ArrayOfbyte) {
/* 622 */       String str = formatRecordDetails(param1Int1, param1Int3, param1Int4, param1Int2);
/* 623 */       if (!this._noHeader) this._headers.add(str); 
/* 624 */       Writer writer = this._hexDumpWriter;
/* 625 */       if (writer != null)
/*     */         try {
/* 627 */           writer.write(str);
/* 628 */           writer.write(BiffViewer.NEW_LINE_CHARS);
/* 629 */           BiffViewer.hexDumpAligned(writer, param1ArrayOfbyte, param1Int4 + 4, param1Int1, this._zeroAlignEachRecord);
/* 630 */           writer.flush();
/* 631 */         } catch (IOException iOException) {
/* 632 */           throw new RuntimeException(iOException);
/*     */         }  
/*     */     }
/*     */     
/*     */     public List<String> getRecentHeaders() {
/* 637 */       List<String> list = this._headers;
/* 638 */       this._headers = new ArrayList<String>();
/* 639 */       return list;
/*     */     }
/*     */     private static String formatRecordDetails(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
/* 642 */       StringBuilder stringBuilder = new StringBuilder(64);
/* 643 */       stringBuilder.append("Offset=").append(HexDump.intToHex(param1Int1)).append("(").append(param1Int1).append(")");
/* 644 */       stringBuilder.append(" recno=").append(param1Int4);
/* 645 */       stringBuilder.append(" sid=").append(HexDump.shortToHex(param1Int2));
/* 646 */       stringBuilder.append(" size=").append(HexDump.shortToHex(param1Int3)).append("(").append(param1Int3).append(")");
/* 647 */       return stringBuilder.toString();
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static interface IBiffRecordListener
/*     */   {
/*     */     void processRecord(int param1Int1, int param1Int2, int param1Int3, int param1Int4, byte[] param1ArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class BiffDumpingStream
/*     */     extends InputStream
/*     */   {
/*     */     private final DataInputStream _is;
/*     */     
/*     */     private final BiffViewer.IBiffRecordListener _listener;
/*     */     private final byte[] _data;
/*     */     private int _recordCounter;
/*     */     private int _overallStreamPos;
/*     */     private int _currentPos;
/*     */     private int _currentSize;
/*     */     private boolean _innerHasReachedEOF;
/*     */     
/*     */     public BiffDumpingStream(InputStream param1InputStream, BiffViewer.IBiffRecordListener param1IBiffRecordListener) {
/* 672 */       this._is = new DataInputStream(param1InputStream);
/* 673 */       this._listener = param1IBiffRecordListener;
/* 674 */       this._data = new byte[8228];
/* 675 */       this._recordCounter = 0;
/* 676 */       this._overallStreamPos = 0;
/* 677 */       this._currentSize = 0;
/* 678 */       this._currentPos = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 683 */       if (this._currentPos >= this._currentSize) {
/* 684 */         fillNextBuffer();
/*     */       }
/* 686 */       if (this._currentPos >= this._currentSize) {
/* 687 */         return -1;
/*     */       }
/* 689 */       int i = this._data[this._currentPos] & 0xFF;
/* 690 */       this._currentPos++;
/* 691 */       this._overallStreamPos++;
/* 692 */       formatBufferIfAtEndOfRec();
/* 693 */       return i;
/*     */     }
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*     */       int j;
/* 697 */       if (this._currentPos >= this._currentSize) {
/* 698 */         fillNextBuffer();
/*     */       }
/* 700 */       if (this._currentPos >= this._currentSize) {
/* 701 */         return -1;
/*     */       }
/* 703 */       int i = this._currentSize - this._currentPos;
/*     */       
/* 705 */       if (param1Int2 > i) {
/* 706 */         System.err.println("Unexpected request to read past end of current biff record");
/* 707 */         j = i;
/*     */       } else {
/* 709 */         j = param1Int2;
/*     */       } 
/* 711 */       System.arraycopy(this._data, this._currentPos, param1ArrayOfbyte, param1Int1, j);
/* 712 */       this._currentPos += j;
/* 713 */       this._overallStreamPos += j;
/* 714 */       formatBufferIfAtEndOfRec();
/* 715 */       return j;
/*     */     }
/*     */ 
/*     */     
/*     */     public int available() throws IOException {
/* 720 */       return this._currentSize - this._currentPos + this._is.available();
/*     */     }
/*     */     private void fillNextBuffer() throws IOException {
/* 723 */       if (this._innerHasReachedEOF) {
/*     */         return;
/*     */       }
/* 726 */       int i = this._is.read();
/* 727 */       if (i == -1) {
/* 728 */         this._innerHasReachedEOF = true;
/*     */         return;
/*     */       } 
/* 731 */       this._data[0] = (byte)i;
/* 732 */       this._is.readFully(this._data, 1, 3);
/* 733 */       short s = LittleEndian.getShort(this._data, 2);
/* 734 */       this._is.readFully(this._data, 4, s);
/* 735 */       this._currentPos = 0;
/* 736 */       this._currentSize = s + 4;
/* 737 */       this._recordCounter++;
/*     */     }
/*     */     private void formatBufferIfAtEndOfRec() {
/* 740 */       if (this._currentPos != this._currentSize) {
/*     */         return;
/*     */       }
/* 743 */       int i = this._currentSize - 4;
/* 744 */       short s = LittleEndian.getShort(this._data, 0);
/* 745 */       int j = this._overallStreamPos - this._currentSize;
/* 746 */       this._listener.processRecord(j, this._recordCounter, s, i, this._data);
/*     */     }
/*     */     
/*     */     public void close() throws IOException {
/* 750 */       this._is.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 755 */   private static final char[] COLUMN_SEPARATOR = " | ".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void hexDumpAligned(Writer paramWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/*     */     int n, i1;
/* 763 */     byte b = 0;
/*     */ 
/*     */     
/* 766 */     int i = paramInt2 + b;
/* 767 */     int j = paramInt2 + b + paramInt1;
/* 768 */     int k = i % 16;
/* 769 */     int m = j % 16;
/* 770 */     if (paramBoolean) {
/* 771 */       m -= k;
/* 772 */       if (m < 0) {
/* 773 */         m += 16;
/*     */       }
/* 775 */       k = 0;
/*     */     } 
/*     */ 
/*     */     
/* 779 */     if (paramBoolean) {
/* 780 */       i1 = j - m - i - k;
/* 781 */       n = 0;
/*     */     } else {
/* 783 */       n = i - k;
/* 784 */       i1 = j - m;
/*     */     } 
/*     */     
/* 787 */     int i2 = b - k;
/* 788 */     int i3 = n;
/*     */ 
/*     */     
/* 791 */     if (n == i1) {
/* 792 */       hexDumpLine(paramWriter, paramArrayOfbyte, i3, i2, k, m);
/*     */       return;
/*     */     } 
/* 795 */     hexDumpLine(paramWriter, paramArrayOfbyte, i3, i2, k, 16);
/*     */ 
/*     */     
/*     */     while (true) {
/* 799 */       i3 += 16;
/* 800 */       i2 += 16;
/* 801 */       if (i3 >= i1) {
/*     */         break;
/*     */       }
/* 804 */       hexDumpLine(paramWriter, paramArrayOfbyte, i3, i2, 0, 16);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 809 */     if (m != 0) {
/* 810 */       hexDumpLine(paramWriter, paramArrayOfbyte, i3, i2, 0, m);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void hexDumpLine(Writer paramWriter, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 815 */     char[] arrayOfChar = new char[8 + 2 * COLUMN_SEPARATOR.length + 48 - 1 + 16 + NEW_LINE_CHARS.length];
/*     */     
/* 817 */     if (paramInt3 >= paramInt4) {
/* 818 */       throw new IllegalArgumentException("Bad start/end delta");
/*     */     }
/* 820 */     int i = 0;
/*     */     try {
/* 822 */       writeHex(arrayOfChar, i, paramInt1, 8);
/* 823 */       i = arraycopy(COLUMN_SEPARATOR, arrayOfChar, i + 8);
/*     */       byte b;
/* 825 */       for (b = 0; b < 16; b++) {
/* 826 */         if (b > 0) {
/* 827 */           arrayOfChar[i++] = ' ';
/*     */         }
/* 829 */         if (b >= paramInt3 && b < paramInt4) {
/* 830 */           writeHex(arrayOfChar, i, paramArrayOfbyte[paramInt2 + b], 2);
/*     */         } else {
/* 832 */           arrayOfChar[i] = ' ';
/* 833 */           arrayOfChar[i + 1] = ' ';
/*     */         } 
/* 835 */         i += 2;
/*     */       } 
/* 837 */       i = arraycopy(COLUMN_SEPARATOR, arrayOfChar, i);
/*     */ 
/*     */       
/* 840 */       for (b = 0; b < 16; b++) {
/* 841 */         char c = ' ';
/* 842 */         if (b >= paramInt3 && b < paramInt4) {
/* 843 */           c = getPrintableChar(paramArrayOfbyte[paramInt2 + b]);
/*     */         }
/* 845 */         arrayOfChar[i++] = c;
/*     */       } 
/*     */       
/* 848 */       i = arraycopy(NEW_LINE_CHARS, arrayOfChar, i);
/*     */       
/* 850 */       paramWriter.write(arrayOfChar, 0, i);
/* 851 */     } catch (IOException iOException) {
/* 852 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int arraycopy(char[] paramArrayOfchar1, char[] paramArrayOfchar2, int paramInt) {
/* 857 */     int i = paramInt;
/* 858 */     for (char c : paramArrayOfchar1) {
/* 859 */       paramArrayOfchar2[i++] = c;
/*     */     }
/* 861 */     return i;
/*     */   }
/*     */   
/*     */   private static char getPrintableChar(byte paramByte) {
/* 865 */     char c = (char)(paramByte & 0xFF);
/* 866 */     if (c < ' ' || c > '~') {
/* 867 */       return '.';
/*     */     }
/* 869 */     return c;
/*     */   }
/*     */   
/*     */   private static void writeHex(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) throws IOException {
/* 873 */     int i = paramInt2;
/* 874 */     for (int j = paramInt3 - 1; j >= 0; j--) {
/* 875 */       int k = i & 0xF;
/* 876 */       paramArrayOfchar[paramInt1 + j] = (char)((k < 10) ? (48 + k) : (65 + k - 10));
/* 877 */       i >>>= 4;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\dev\BiffViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */