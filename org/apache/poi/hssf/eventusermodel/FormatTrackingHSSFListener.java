/*     */ package org.apache.poi.hssf.eventusermodel;
/*     */ 
/*     */ import java.text.NumberFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.ExtendedFormatRecord;
/*     */ import org.apache.poi.hssf.record.FormatRecord;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.NumberRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.usermodel.HSSFDataFormat;
/*     */ import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormatTrackingHSSFListener
/*     */   implements HSSFListener
/*     */ {
/*  44 */   private static POILogger logger = POILogFactory.getLogger(FormatTrackingHSSFListener.class);
/*     */   private final HSSFListener _childListener;
/*     */   private final HSSFDataFormatter _formatter;
/*     */   private final NumberFormat _defaultFormat;
/*  48 */   private final Map<Integer, FormatRecord> _customFormatRecords = new HashMap<Integer, FormatRecord>();
/*  49 */   private final List<ExtendedFormatRecord> _xfRecords = new ArrayList<ExtendedFormatRecord>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FormatTrackingHSSFListener(HSSFListener paramHSSFListener) {
/*  58 */     this(paramHSSFListener, LocaleUtil.getUserLocale());
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
/*     */   public FormatTrackingHSSFListener(HSSFListener paramHSSFListener, Locale paramLocale) {
/*  70 */     this._childListener = paramHSSFListener;
/*  71 */     this._formatter = new HSSFDataFormatter(paramLocale);
/*  72 */     this._defaultFormat = NumberFormat.getInstance(paramLocale);
/*     */   }
/*     */   
/*     */   protected int getNumberOfCustomFormats() {
/*  76 */     return this._customFormatRecords.size();
/*     */   }
/*     */   
/*     */   protected int getNumberOfExtendedFormats() {
/*  80 */     return this._xfRecords.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processRecord(Record paramRecord) {
/*  89 */     processRecordInternally(paramRecord);
/*     */ 
/*     */     
/*  92 */     this._childListener.processRecord(paramRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processRecordInternally(Record paramRecord) {
/* 102 */     if (paramRecord instanceof FormatRecord) {
/* 103 */       FormatRecord formatRecord = (FormatRecord)paramRecord;
/* 104 */       this._customFormatRecords.put(Integer.valueOf(formatRecord.getIndexCode()), formatRecord);
/*     */     } 
/* 106 */     if (paramRecord instanceof ExtendedFormatRecord) {
/* 107 */       ExtendedFormatRecord extendedFormatRecord = (ExtendedFormatRecord)paramRecord;
/* 108 */       this._xfRecords.add(extendedFormatRecord);
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
/*     */   public String formatNumberDateCell(CellValueRecordInterface paramCellValueRecordInterface) {
/*     */     double d;
/* 126 */     if (paramCellValueRecordInterface instanceof NumberRecord) {
/* 127 */       d = ((NumberRecord)paramCellValueRecordInterface).getValue();
/* 128 */     } else if (paramCellValueRecordInterface instanceof FormulaRecord) {
/* 129 */       d = ((FormulaRecord)paramCellValueRecordInterface).getValue();
/*     */     } else {
/* 131 */       throw new IllegalArgumentException("Unsupported CellValue Record passed in " + paramCellValueRecordInterface);
/*     */     } 
/*     */ 
/*     */     
/* 135 */     int i = getFormatIndex(paramCellValueRecordInterface);
/* 136 */     String str = getFormatString(paramCellValueRecordInterface);
/*     */     
/* 138 */     if (str == null) {
/* 139 */       return this._defaultFormat.format(d);
/*     */     }
/*     */ 
/*     */     
/* 143 */     return this._formatter.formatRawCellContents(d, i, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormatString(int paramInt) {
/* 154 */     String str = null;
/* 155 */     if (paramInt >= HSSFDataFormat.getNumberOfBuiltinBuiltinFormats()) {
/* 156 */       FormatRecord formatRecord = this._customFormatRecords.get(Integer.valueOf(paramInt));
/* 157 */       if (formatRecord == null) {
/* 158 */         logger.log(7, new Object[] { "Requested format at index " + paramInt + ", but it wasn't found" });
/*     */       } else {
/*     */         
/* 161 */         str = formatRecord.getFormatString();
/*     */       } 
/*     */     } else {
/* 164 */       str = HSSFDataFormat.getBuiltinFormat((short)paramInt);
/*     */     } 
/* 166 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormatString(CellValueRecordInterface paramCellValueRecordInterface) {
/* 177 */     int i = getFormatIndex(paramCellValueRecordInterface);
/* 178 */     if (i == -1)
/*     */     {
/* 180 */       return null;
/*     */     }
/* 182 */     return getFormatString(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFormatIndex(CellValueRecordInterface paramCellValueRecordInterface) {
/* 193 */     ExtendedFormatRecord extendedFormatRecord = this._xfRecords.get(paramCellValueRecordInterface.getXFIndex());
/* 194 */     if (extendedFormatRecord == null) {
/* 195 */       logger.log(7, new Object[] { "Cell " + paramCellValueRecordInterface.getRow() + "," + paramCellValueRecordInterface.getColumn() + " uses XF with index " + paramCellValueRecordInterface.getXFIndex() + ", but we don't have that" });
/*     */       
/* 197 */       return -1;
/*     */     } 
/* 199 */     return extendedFormatRecord.getFormatIndex();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\FormatTrackingHSSFListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */