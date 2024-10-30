/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hssf.record.ArrayRecord;
/*     */ import org.apache.poi.hssf.record.SharedFormulaRecord;
/*     */ import org.apache.poi.hssf.record.SharedValueRecordBase;
/*     */ import org.apache.poi.hssf.record.TableRecord;
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SharedValueManager
/*     */ {
/*     */   private final List<ArrayRecord> _arrayRecords;
/*     */   private final TableRecord[] _tableRecords;
/*     */   private final Map<SharedFormulaRecord, SharedFormulaGroup> _groupsBySharedFormulaRecord;
/*     */   private Map<Integer, SharedFormulaGroup> _groupsCache;
/*     */   
/*     */   private static final class SharedFormulaGroup
/*     */   {
/*     */     private final SharedFormulaRecord _sfr;
/*     */     private final FormulaRecordAggregate[] _frAggs;
/*     */     private int _numberOfFormulas;
/*     */     private final CellReference _firstCell;
/*     */     
/*     */     public SharedFormulaGroup(SharedFormulaRecord param1SharedFormulaRecord, CellReference param1CellReference) {
/*  60 */       if (!param1SharedFormulaRecord.isInRange(param1CellReference.getRow(), param1CellReference.getCol())) {
/*  61 */         throw new IllegalArgumentException("First formula cell " + param1CellReference.formatAsString() + " is not shared formula range " + param1SharedFormulaRecord.getRange().toString() + ".");
/*     */       }
/*     */       
/*  64 */       this._sfr = param1SharedFormulaRecord;
/*  65 */       this._firstCell = param1CellReference;
/*  66 */       int i = param1SharedFormulaRecord.getLastColumn() - param1SharedFormulaRecord.getFirstColumn() + 1;
/*  67 */       int j = param1SharedFormulaRecord.getLastRow() - param1SharedFormulaRecord.getFirstRow() + 1;
/*  68 */       this._frAggs = new FormulaRecordAggregate[i * j];
/*  69 */       this._numberOfFormulas = 0;
/*     */     }
/*     */     
/*     */     public void add(FormulaRecordAggregate param1FormulaRecordAggregate) {
/*  73 */       if (this._numberOfFormulas == 0 && (
/*  74 */         this._firstCell.getRow() != param1FormulaRecordAggregate.getRow() || this._firstCell.getCol() != param1FormulaRecordAggregate.getColumn())) {
/*  75 */         throw new IllegalStateException("shared formula coding error: " + this._firstCell.getCol() + '/' + this._firstCell.getRow() + " != " + param1FormulaRecordAggregate.getColumn() + '/' + param1FormulaRecordAggregate.getRow());
/*     */       }
/*     */       
/*  78 */       if (this._numberOfFormulas >= this._frAggs.length) {
/*  79 */         throw new RuntimeException("Too many formula records for shared formula group");
/*     */       }
/*  81 */       this._frAggs[this._numberOfFormulas++] = param1FormulaRecordAggregate;
/*     */     }
/*     */     
/*     */     public void unlinkSharedFormulas() {
/*  85 */       for (byte b = 0; b < this._numberOfFormulas; b++) {
/*  86 */         this._frAggs[b].unlinkSharedFormula();
/*     */       }
/*     */     }
/*     */     
/*     */     public SharedFormulaRecord getSFR() {
/*  91 */       return this._sfr;
/*     */     }
/*     */     
/*     */     public final String toString() {
/*  95 */       StringBuffer stringBuffer = new StringBuffer(64);
/*  96 */       stringBuffer.append(getClass().getName()).append(" [");
/*  97 */       stringBuffer.append(this._sfr.getRange().toString());
/*  98 */       stringBuffer.append("]");
/*  99 */       return stringBuffer.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedValueManager createEmpty() {
/* 108 */     return new SharedValueManager(new SharedFormulaRecord[0], new CellReference[0], new ArrayRecord[0], new TableRecord[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SharedValueManager(SharedFormulaRecord[] paramArrayOfSharedFormulaRecord, CellReference[] paramArrayOfCellReference, ArrayRecord[] paramArrayOfArrayRecord, TableRecord[] paramArrayOfTableRecord) {
/* 119 */     int i = paramArrayOfSharedFormulaRecord.length;
/* 120 */     if (i != paramArrayOfCellReference.length) {
/* 121 */       throw new IllegalArgumentException("array sizes don't match: " + i + "!=" + paramArrayOfCellReference.length + ".");
/*     */     }
/* 123 */     this._arrayRecords = toList(paramArrayOfArrayRecord);
/* 124 */     this._tableRecords = paramArrayOfTableRecord;
/* 125 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(i * 3 / 2);
/* 126 */     for (byte b = 0; b < i; b++) {
/* 127 */       SharedFormulaRecord sharedFormulaRecord = paramArrayOfSharedFormulaRecord[b];
/* 128 */       hashMap.put(sharedFormulaRecord, new SharedFormulaGroup(sharedFormulaRecord, paramArrayOfCellReference[b]));
/*     */     } 
/* 130 */     this._groupsBySharedFormulaRecord = (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <Z> List<Z> toList(Z[] paramArrayOfZ) {
/* 137 */     ArrayList<Z> arrayList = new ArrayList(paramArrayOfZ.length);
/* 138 */     for (byte b = 0; b < paramArrayOfZ.length; b++) {
/* 139 */       arrayList.add(paramArrayOfZ[b]);
/*     */     }
/* 141 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedValueManager create(SharedFormulaRecord[] paramArrayOfSharedFormulaRecord, CellReference[] paramArrayOfCellReference, ArrayRecord[] paramArrayOfArrayRecord, TableRecord[] paramArrayOfTableRecord) {
/* 148 */     if (paramArrayOfSharedFormulaRecord.length + paramArrayOfCellReference.length + paramArrayOfArrayRecord.length + paramArrayOfTableRecord.length < 1) {
/* 149 */       return createEmpty();
/*     */     }
/* 151 */     return new SharedValueManager(paramArrayOfSharedFormulaRecord, paramArrayOfCellReference, paramArrayOfArrayRecord, paramArrayOfTableRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SharedFormulaRecord linkSharedFormulaRecord(CellReference paramCellReference, FormulaRecordAggregate paramFormulaRecordAggregate) {
/* 160 */     SharedFormulaGroup sharedFormulaGroup = findFormulaGroupForCell(paramCellReference);
/* 161 */     if (null == sharedFormulaGroup) {
/* 162 */       throw new RuntimeException("Failed to find a matching shared formula record");
/*     */     }
/* 164 */     sharedFormulaGroup.add(paramFormulaRecordAggregate);
/* 165 */     return sharedFormulaGroup.getSFR();
/*     */   }
/*     */   
/*     */   private SharedFormulaGroup findFormulaGroupForCell(CellReference paramCellReference) {
/* 169 */     if (null == this._groupsCache) {
/* 170 */       this._groupsCache = new HashMap<Integer, SharedFormulaGroup>(this._groupsBySharedFormulaRecord.size());
/* 171 */       for (SharedFormulaGroup sharedFormulaGroup : this._groupsBySharedFormulaRecord.values()) {
/* 172 */         this._groupsCache.put(getKeyForCache(sharedFormulaGroup._firstCell), sharedFormulaGroup);
/*     */       }
/*     */     } 
/* 175 */     return this._groupsCache.get(getKeyForCache(paramCellReference));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer getKeyForCache(CellReference paramCellReference) {
/* 181 */     return Integer.valueOf(paramCellReference.getCol() + 1 << 16 | paramCellReference.getRow());
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
/*     */   public SharedValueRecordBase getRecordForFirstCell(FormulaRecordAggregate paramFormulaRecordAggregate) {
/* 197 */     CellReference cellReference = paramFormulaRecordAggregate.getFormulaRecord().getFormula().getExpReference();
/*     */ 
/*     */     
/* 200 */     if (cellReference == null)
/*     */     {
/* 202 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 206 */     int i = cellReference.getRow();
/* 207 */     short s = cellReference.getCol();
/* 208 */     if (paramFormulaRecordAggregate.getRow() != i || paramFormulaRecordAggregate.getColumn() != s)
/*     */     {
/* 210 */       return null;
/*     */     }
/*     */     
/* 213 */     if (!this._groupsBySharedFormulaRecord.isEmpty()) {
/* 214 */       SharedFormulaGroup sharedFormulaGroup = findFormulaGroupForCell(cellReference);
/* 215 */       if (null != sharedFormulaGroup) {
/* 216 */         return (SharedValueRecordBase)sharedFormulaGroup.getSFR();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     for (TableRecord tableRecord : this._tableRecords) {
/* 225 */       if (tableRecord.isFirstCell(i, s)) {
/* 226 */         return (SharedValueRecordBase)tableRecord;
/*     */       }
/*     */     } 
/* 229 */     for (ArrayRecord arrayRecord : this._arrayRecords) {
/* 230 */       if (arrayRecord.isFirstCell(i, s)) {
/* 231 */         return (SharedValueRecordBase)arrayRecord;
/*     */       }
/*     */     } 
/* 234 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unlink(SharedFormulaRecord paramSharedFormulaRecord) {
/* 242 */     SharedFormulaGroup sharedFormulaGroup = this._groupsBySharedFormulaRecord.remove(paramSharedFormulaRecord);
/* 243 */     if (sharedFormulaGroup == null) {
/* 244 */       throw new IllegalStateException("Failed to find formulas for shared formula");
/*     */     }
/* 246 */     this._groupsCache = null;
/* 247 */     sharedFormulaGroup.unlinkSharedFormulas();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addArrayRecord(ArrayRecord paramArrayRecord) {
/* 255 */     this._arrayRecords.add(paramArrayRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress8Bit removeArrayFormula(int paramInt1, int paramInt2) {
/* 264 */     for (ArrayRecord arrayRecord : this._arrayRecords) {
/* 265 */       if (arrayRecord.isInRange(paramInt1, paramInt2)) {
/* 266 */         this._arrayRecords.remove(arrayRecord);
/* 267 */         return arrayRecord.getRange();
/*     */       } 
/*     */     } 
/* 270 */     String str = (new CellReference(paramInt1, paramInt2, false, false)).formatAsString();
/* 271 */     throw new IllegalArgumentException("Specified cell " + str + " is not part of an array formula.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayRecord getArrayRecord(int paramInt1, int paramInt2) {
/* 279 */     for (ArrayRecord arrayRecord : this._arrayRecords) {
/* 280 */       if (arrayRecord.isFirstCell(paramInt1, paramInt2)) {
/* 281 */         return arrayRecord;
/*     */       }
/*     */     } 
/* 284 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\SharedValueManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */