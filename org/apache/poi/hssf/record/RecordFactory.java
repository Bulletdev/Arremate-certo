/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.hssf.record.chart.BeginRecord;
/*     */ import org.apache.poi.hssf.record.chart.CatLabRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartEndBlockRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartEndObjectRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartFRTInfoRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartStartBlockRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartStartObjectRecord;
/*     */ import org.apache.poi.hssf.record.chart.ChartTitleFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.DataFormatRecord;
/*     */ import org.apache.poi.hssf.record.chart.EndRecord;
/*     */ import org.apache.poi.hssf.record.chart.LegendRecord;
/*     */ import org.apache.poi.hssf.record.chart.LinkedDataRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesTextRecord;
/*     */ import org.apache.poi.hssf.record.chart.SeriesToChartGroupRecord;
/*     */ import org.apache.poi.hssf.record.chart.ValueRangeRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.DataItemRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.PageItemRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.StreamIDRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewDefinitionRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewFieldsRecord;
/*     */ import org.apache.poi.hssf.record.pivottable.ViewSourceRecord;
/*     */ import org.apache.poi.util.RecordFormatException;
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
/*     */ public final class RecordFactory
/*     */ {
/*     */   private static final int NUM_RECORDS = 512;
/*     */   
/*     */   private static interface I_RecordCreator
/*     */   {
/*     */     Record create(RecordInputStream param1RecordInputStream);
/*     */     
/*     */     Class<? extends Record> getRecordClass();
/*     */   }
/*     */   
/*     */   private static final class ReflectionConstructorRecordCreator
/*     */     implements I_RecordCreator
/*     */   {
/*     */     private final Constructor<? extends Record> _c;
/*     */     
/*     */     public ReflectionConstructorRecordCreator(Constructor<? extends Record> param1Constructor) {
/*  78 */       this._c = param1Constructor;
/*     */     }
/*     */     
/*     */     public Record create(RecordInputStream param1RecordInputStream) {
/*  82 */       Object[] arrayOfObject = { param1RecordInputStream };
/*     */       try {
/*  84 */         return this._c.newInstance(arrayOfObject);
/*  85 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  86 */         throw new RuntimeException(illegalArgumentException);
/*  87 */       } catch (InstantiationException instantiationException) {
/*  88 */         throw new RuntimeException(instantiationException);
/*  89 */       } catch (IllegalAccessException illegalAccessException) {
/*  90 */         throw new RuntimeException(illegalAccessException);
/*  91 */       } catch (InvocationTargetException invocationTargetException) {
/*  92 */         Throwable throwable = invocationTargetException.getTargetException();
/*  93 */         if (throwable instanceof RecordFormatException)
/*  94 */           throw (RecordFormatException)throwable; 
/*  95 */         if (throwable instanceof EncryptedDocumentException) {
/*  96 */           throw (EncryptedDocumentException)throwable;
/*     */         }
/*  98 */         throw new RecordFormatException("Unable to construct record instance", throwable);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<? extends Record> getRecordClass() {
/* 104 */       return this._c.getDeclaringClass();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ReflectionMethodRecordCreator
/*     */     implements I_RecordCreator
/*     */   {
/*     */     private final Method _m;
/*     */     
/*     */     public ReflectionMethodRecordCreator(Method param1Method) {
/* 114 */       this._m = param1Method;
/*     */     }
/*     */     
/*     */     public Record create(RecordInputStream param1RecordInputStream) {
/* 118 */       Object[] arrayOfObject = { param1RecordInputStream };
/*     */       try {
/* 120 */         return (Record)this._m.invoke(null, arrayOfObject);
/* 121 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 122 */         throw new RuntimeException(illegalArgumentException);
/* 123 */       } catch (IllegalAccessException illegalAccessException) {
/* 124 */         throw new RuntimeException(illegalAccessException);
/* 125 */       } catch (InvocationTargetException invocationTargetException) {
/* 126 */         throw new RecordFormatException("Unable to construct record instance", invocationTargetException.getTargetException());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Class<? extends Record> getRecordClass() {
/* 132 */       return (Class)this._m.getDeclaringClass();
/*     */     }
/*     */   }
/*     */   
/* 136 */   private static final Class<?>[] CONSTRUCTOR_ARGS = new Class[] { RecordInputStream.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 143 */   private static final Class<? extends Record>[] recordClasses = new Class[] { ArrayRecord.class, AutoFilterInfoRecord.class, BackupRecord.class, BlankRecord.class, BOFRecord.class, BookBoolRecord.class, BoolErrRecord.class, BottomMarginRecord.class, BoundSheetRecord.class, CalcCountRecord.class, CalcModeRecord.class, CFHeaderRecord.class, CFHeader12Record.class, CFRuleRecord.class, CFRule12Record.class, ChartRecord.class, ChartTitleFormatRecord.class, CodepageRecord.class, ColumnInfoRecord.class, ContinueRecord.class, CountryRecord.class, CRNCountRecord.class, CRNRecord.class, DateWindow1904Record.class, DBCellRecord.class, DConRefRecord.class, DefaultColWidthRecord.class, DefaultRowHeightRecord.class, DeltaRecord.class, DimensionsRecord.class, DrawingGroupRecord.class, DrawingRecord.class, DrawingSelectionRecord.class, DSFRecord.class, DVALRecord.class, DVRecord.class, EOFRecord.class, ExtendedFormatRecord.class, ExternalNameRecord.class, ExternSheetRecord.class, ExtSSTRecord.class, FeatRecord.class, FeatHdrRecord.class, FilePassRecord.class, FileSharingRecord.class, FnGroupCountRecord.class, FontRecord.class, FooterRecord.class, FormatRecord.class, FormulaRecord.class, GridsetRecord.class, GutsRecord.class, HCenterRecord.class, HeaderRecord.class, HeaderFooterRecord.class, HideObjRecord.class, HorizontalPageBreakRecord.class, HyperlinkRecord.class, IndexRecord.class, InterfaceEndRecord.class, InterfaceHdrRecord.class, IterationRecord.class, LabelRecord.class, LabelSSTRecord.class, LeftMarginRecord.class, LegendRecord.class, MergeCellsRecord.class, MMSRecord.class, MulBlankRecord.class, MulRKRecord.class, NameRecord.class, NameCommentRecord.class, NoteRecord.class, NumberRecord.class, ObjectProtectRecord.class, ObjRecord.class, PaletteRecord.class, PaneRecord.class, PasswordRecord.class, PasswordRev4Record.class, PrecisionRecord.class, PrintGridlinesRecord.class, PrintHeadersRecord.class, PrintSetupRecord.class, ProtectionRev4Record.class, ProtectRecord.class, RecalcIdRecord.class, RefModeRecord.class, RefreshAllRecord.class, RightMarginRecord.class, RKRecord.class, RowRecord.class, SaveRecalcRecord.class, ScenarioProtectRecord.class, SelectionRecord.class, SeriesRecord.class, SeriesTextRecord.class, SharedFormulaRecord.class, SSTRecord.class, StringRecord.class, StyleRecord.class, SupBookRecord.class, TabIdRecord.class, TableRecord.class, TableStylesRecord.class, TextObjectRecord.class, TopMarginRecord.class, UncalcedRecord.class, UseSelFSRecord.class, UserSViewBegin.class, UserSViewEnd.class, ValueRangeRecord.class, VCenterRecord.class, VerticalPageBreakRecord.class, WindowOneRecord.class, WindowProtectRecord.class, WindowTwoRecord.class, WriteAccessRecord.class, WriteProtectRecord.class, WSBoolRecord.class, BeginRecord.class, ChartFRTInfoRecord.class, ChartStartBlockRecord.class, ChartEndBlockRecord.class, ChartStartObjectRecord.class, ChartEndObjectRecord.class, CatLabRecord.class, DataFormatRecord.class, EndRecord.class, LinkedDataRecord.class, SeriesToChartGroupRecord.class, DataItemRecord.class, ExtendedPivotTableViewFieldsRecord.class, PageItemRecord.class, StreamIDRecord.class, ViewDefinitionRecord.class, ViewFieldsRecord.class, ViewSourceRecord.class };
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
/* 292 */   private static final Map<Integer, I_RecordCreator> _recordCreatorsById = recordsToMap(recordClasses);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static short[] _allKnownRecordSIDs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<? extends Record> getRecordClass(int paramInt) {
/* 309 */     I_RecordCreator i_RecordCreator = _recordCreatorsById.get(Integer.valueOf(paramInt));
/* 310 */     if (i_RecordCreator == null) {
/* 311 */       return null;
/*     */     }
/* 313 */     return i_RecordCreator.getRecordClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Record[] createRecord(RecordInputStream paramRecordInputStream) {
/* 324 */     Record record = createSingleRecord(paramRecordInputStream);
/* 325 */     if (record instanceof DBCellRecord)
/*     */     {
/* 327 */       return new Record[] { null };
/*     */     }
/* 329 */     if (record instanceof RKRecord) {
/* 330 */       return new Record[] { convertToNumberRecord((RKRecord)record) };
/*     */     }
/* 332 */     if (record instanceof MulRKRecord) {
/* 333 */       return (Record[])convertRKRecords((MulRKRecord)record);
/*     */     }
/* 335 */     return new Record[] { record };
/*     */   }
/*     */   
/*     */   public static Record createSingleRecord(RecordInputStream paramRecordInputStream) {
/* 339 */     I_RecordCreator i_RecordCreator = _recordCreatorsById.get(Integer.valueOf(paramRecordInputStream.getSid()));
/*     */     
/* 341 */     if (i_RecordCreator == null) {
/* 342 */       return new UnknownRecord(paramRecordInputStream);
/*     */     }
/*     */     
/* 345 */     return i_RecordCreator.create(paramRecordInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumberRecord convertToNumberRecord(RKRecord paramRKRecord) {
/* 356 */     NumberRecord numberRecord = new NumberRecord();
/*     */     
/* 358 */     numberRecord.setColumn(paramRKRecord.getColumn());
/* 359 */     numberRecord.setRow(paramRKRecord.getRow());
/* 360 */     numberRecord.setXFIndex(paramRKRecord.getXFIndex());
/* 361 */     numberRecord.setValue(paramRKRecord.getRKNumber());
/* 362 */     return numberRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NumberRecord[] convertRKRecords(MulRKRecord paramMulRKRecord) {
/* 372 */     NumberRecord[] arrayOfNumberRecord = new NumberRecord[paramMulRKRecord.getNumColumns()];
/* 373 */     for (byte b = 0; b < paramMulRKRecord.getNumColumns(); b++) {
/* 374 */       NumberRecord numberRecord = new NumberRecord();
/*     */       
/* 376 */       numberRecord.setColumn((short)(b + paramMulRKRecord.getFirstColumn()));
/* 377 */       numberRecord.setRow(paramMulRKRecord.getRow());
/* 378 */       numberRecord.setXFIndex(paramMulRKRecord.getXFAt(b));
/* 379 */       numberRecord.setValue(paramMulRKRecord.getRKNumberAt(b));
/* 380 */       arrayOfNumberRecord[b] = numberRecord;
/*     */     } 
/* 382 */     return arrayOfNumberRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlankRecord[] convertBlankRecords(MulBlankRecord paramMulBlankRecord) {
/* 392 */     BlankRecord[] arrayOfBlankRecord = new BlankRecord[paramMulBlankRecord.getNumColumns()];
/* 393 */     for (byte b = 0; b < paramMulBlankRecord.getNumColumns(); b++) {
/* 394 */       BlankRecord blankRecord = new BlankRecord();
/*     */       
/* 396 */       blankRecord.setColumn((short)(b + paramMulBlankRecord.getFirstColumn()));
/* 397 */       blankRecord.setRow(paramMulBlankRecord.getRow());
/* 398 */       blankRecord.setXFIndex(paramMulBlankRecord.getXFAt(b));
/* 399 */       arrayOfBlankRecord[b] = blankRecord;
/*     */     } 
/* 401 */     return arrayOfBlankRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short[] getAllKnownRecordSIDs() {
/* 408 */     if (_allKnownRecordSIDs == null) {
/* 409 */       short[] arrayOfShort = new short[_recordCreatorsById.size()];
/* 410 */       byte b = 0;
/*     */       
/* 412 */       for (Integer integer : _recordCreatorsById.keySet()) {
/* 413 */         arrayOfShort[b++] = integer.shortValue();
/*     */       }
/* 415 */       Arrays.sort(arrayOfShort);
/* 416 */       _allKnownRecordSIDs = arrayOfShort;
/*     */     } 
/*     */     
/* 419 */     return (short[])_allKnownRecordSIDs.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<Integer, I_RecordCreator> recordsToMap(Class<? extends Record>[] paramArrayOfClass) {
/* 428 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 429 */     HashSet<Class<? extends Record>> hashSet = new HashSet(paramArrayOfClass.length * 3 / 2);
/*     */     
/* 431 */     for (Class<? extends Record> clazz : paramArrayOfClass) {
/* 432 */       short s; if (!Record.class.isAssignableFrom(clazz)) {
/* 433 */         throw new RuntimeException("Invalid record sub-class (" + clazz.getName() + ")");
/*     */       }
/* 435 */       if (Modifier.isAbstract(clazz.getModifiers())) {
/* 436 */         throw new RuntimeException("Invalid record class (" + clazz.getName() + ") - must not be abstract");
/*     */       }
/* 438 */       if (!hashSet.add(clazz)) {
/* 439 */         throw new RuntimeException("duplicate record class (" + clazz.getName() + ")");
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 444 */         s = clazz.getField("sid").getShort(null);
/* 445 */       } catch (Exception exception) {
/* 446 */         throw new RecordFormatException("Unable to determine record types");
/*     */       } 
/*     */       
/* 449 */       Integer integer = Integer.valueOf(s);
/* 450 */       if (hashMap.containsKey(integer)) {
/* 451 */         Class<? extends Record> clazz1 = ((I_RecordCreator)hashMap.get(integer)).getRecordClass();
/* 452 */         throw new RuntimeException("duplicate record sid 0x" + Integer.toHexString(s).toUpperCase(Locale.ROOT) + " for classes (" + clazz.getName() + ") and (" + clazz1.getName() + ")");
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 457 */       hashMap.put(integer, getRecordCreator(clazz));
/*     */     } 
/*     */     
/* 460 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   private static I_RecordCreator getRecordCreator(Class<? extends Record> paramClass) {
/*     */     try {
/* 466 */       Constructor<? extends Record> constructor = paramClass.getConstructor(CONSTRUCTOR_ARGS);
/* 467 */       return new ReflectionConstructorRecordCreator(constructor);
/* 468 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */ 
/*     */       
/*     */       try {
/* 472 */         Method method = paramClass.getDeclaredMethod("create", CONSTRUCTOR_ARGS);
/* 473 */         return new ReflectionMethodRecordCreator(method);
/* 474 */       } catch (NoSuchMethodException noSuchMethodException1) {
/* 475 */         throw new RuntimeException("Failed to find constructor or create method for (" + paramClass.getName() + ").");
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
/*     */   public static List<Record> createRecords(InputStream paramInputStream) throws RecordFormatException {
/* 489 */     ArrayList<Record> arrayList = new ArrayList(512);
/*     */     
/* 491 */     RecordFactoryInputStream recordFactoryInputStream = new RecordFactoryInputStream(paramInputStream, true);
/*     */     
/*     */     Record record;
/* 494 */     while ((record = recordFactoryInputStream.nextRecord()) != null) {
/* 495 */       arrayList.add(record);
/*     */     }
/*     */     
/* 498 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RecordFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */