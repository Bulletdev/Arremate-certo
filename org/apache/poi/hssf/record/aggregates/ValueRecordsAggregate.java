/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.hssf.model.RecordStream;
/*     */ import org.apache.poi.hssf.record.BlankRecord;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.MulBlankRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordBase;
/*     */ import org.apache.poi.hssf.record.StringRecord;
/*     */ import org.apache.poi.ss.formula.FormulaShifter;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ValueRecordsAggregate
/*     */   implements Iterable<CellValueRecordInterface>
/*     */ {
/*     */   private static final int MAX_ROW_INDEX = 65535;
/*     */   private static final int INDEX_NOT_SET = -1;
/*  45 */   private int firstcell = -1;
/*  46 */   private int lastcell = -1;
/*     */   
/*     */   private CellValueRecordInterface[][] records;
/*     */ 
/*     */   
/*     */   public ValueRecordsAggregate() {
/*  52 */     this(-1, -1, new CellValueRecordInterface[30][]);
/*     */   }
/*     */   private ValueRecordsAggregate(int paramInt1, int paramInt2, CellValueRecordInterface[][] paramArrayOfCellValueRecordInterface) {
/*  55 */     this.firstcell = paramInt1;
/*  56 */     this.lastcell = paramInt2;
/*  57 */     this.records = paramArrayOfCellValueRecordInterface;
/*     */   }
/*     */   
/*     */   public void insertCell(CellValueRecordInterface paramCellValueRecordInterface) {
/*  61 */     short s = paramCellValueRecordInterface.getColumn();
/*  62 */     int i = paramCellValueRecordInterface.getRow();
/*  63 */     if (i >= this.records.length) {
/*  64 */       CellValueRecordInterface[][] arrayOfCellValueRecordInterface1 = this.records;
/*  65 */       int j = arrayOfCellValueRecordInterface1.length * 2;
/*  66 */       if (j < i + 1)
/*  67 */         j = i + 1; 
/*  68 */       this.records = new CellValueRecordInterface[j][];
/*  69 */       System.arraycopy(arrayOfCellValueRecordInterface1, 0, this.records, 0, arrayOfCellValueRecordInterface1.length);
/*     */     } 
/*  71 */     CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[i];
/*  72 */     if (arrayOfCellValueRecordInterface == null) {
/*  73 */       int j = s + 1;
/*  74 */       if (j < 10)
/*  75 */         j = 10; 
/*  76 */       arrayOfCellValueRecordInterface = new CellValueRecordInterface[j];
/*  77 */       this.records[i] = arrayOfCellValueRecordInterface;
/*     */     } 
/*  79 */     if (s >= arrayOfCellValueRecordInterface.length) {
/*  80 */       CellValueRecordInterface[] arrayOfCellValueRecordInterface1 = arrayOfCellValueRecordInterface;
/*  81 */       int j = arrayOfCellValueRecordInterface1.length * 2;
/*  82 */       if (j < s + 1) {
/*  83 */         j = s + 1;
/*     */       }
/*  85 */       arrayOfCellValueRecordInterface = new CellValueRecordInterface[j];
/*  86 */       System.arraycopy(arrayOfCellValueRecordInterface1, 0, arrayOfCellValueRecordInterface, 0, arrayOfCellValueRecordInterface1.length);
/*  87 */       this.records[i] = arrayOfCellValueRecordInterface;
/*     */     } 
/*  89 */     arrayOfCellValueRecordInterface[s] = paramCellValueRecordInterface;
/*     */     
/*  91 */     if (s < this.firstcell || this.firstcell == -1) {
/*  92 */       this.firstcell = s;
/*     */     }
/*  94 */     if (s > this.lastcell || this.lastcell == -1) {
/*  95 */       this.lastcell = s;
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeCell(CellValueRecordInterface paramCellValueRecordInterface) {
/* 100 */     if (paramCellValueRecordInterface == null) {
/* 101 */       throw new IllegalArgumentException("cell must not be null");
/*     */     }
/* 103 */     int i = paramCellValueRecordInterface.getRow();
/* 104 */     if (i >= this.records.length) {
/* 105 */       throw new RuntimeException("cell row is out of range");
/*     */     }
/* 107 */     CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[i];
/* 108 */     if (arrayOfCellValueRecordInterface == null) {
/* 109 */       throw new RuntimeException("cell row is already empty");
/*     */     }
/* 111 */     short s = paramCellValueRecordInterface.getColumn();
/* 112 */     if (s >= arrayOfCellValueRecordInterface.length) {
/* 113 */       throw new RuntimeException("cell column is out of range");
/*     */     }
/* 115 */     arrayOfCellValueRecordInterface[s] = null;
/*     */   }
/*     */   
/*     */   public void removeAllCellsValuesForRow(int paramInt) {
/* 119 */     if (paramInt < 0 || paramInt > 65535) {
/* 120 */       throw new IllegalArgumentException("Specified rowIndex " + paramInt + " is outside the allowable range (0.." + Character.MAX_VALUE + ")");
/*     */     }
/*     */     
/* 123 */     if (paramInt >= this.records.length) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 129 */     this.records[paramInt] = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPhysicalNumberOfCells() {
/* 134 */     byte b1 = 0;
/* 135 */     for (byte b2 = 0; b2 < this.records.length; b2++) {
/* 136 */       CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[b2];
/* 137 */       if (arrayOfCellValueRecordInterface != null)
/* 138 */         for (byte b = 0; b < arrayOfCellValueRecordInterface.length; b++) {
/* 139 */           if (arrayOfCellValueRecordInterface[b] != null) {
/* 140 */             b1++;
/*     */           }
/*     */         }  
/*     */     } 
/* 144 */     return b1;
/*     */   }
/*     */   
/*     */   public int getFirstCellNum() {
/* 148 */     return this.firstcell;
/*     */   }
/*     */   
/*     */   public int getLastCellNum() {
/* 152 */     return this.lastcell;
/*     */   }
/*     */   
/*     */   public void addMultipleBlanks(MulBlankRecord paramMulBlankRecord) {
/* 156 */     for (byte b = 0; b < paramMulBlankRecord.getNumColumns(); b++) {
/* 157 */       BlankRecord blankRecord = new BlankRecord();
/*     */       
/* 159 */       blankRecord.setColumn((short)(b + paramMulBlankRecord.getFirstColumn()));
/* 160 */       blankRecord.setRow(paramMulBlankRecord.getRow());
/* 161 */       blankRecord.setXFIndex(paramMulBlankRecord.getXFAt(b));
/* 162 */       insertCell((CellValueRecordInterface)blankRecord);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void construct(CellValueRecordInterface paramCellValueRecordInterface, RecordStream paramRecordStream, SharedValueManager paramSharedValueManager) {
/* 171 */     if (paramCellValueRecordInterface instanceof FormulaRecord) {
/* 172 */       StringRecord stringRecord; FormulaRecord formulaRecord = (FormulaRecord)paramCellValueRecordInterface;
/*     */ 
/*     */       
/* 175 */       Class<StringRecord> clazz = paramRecordStream.peekNextClass();
/* 176 */       if (clazz == StringRecord.class) {
/* 177 */         stringRecord = (StringRecord)paramRecordStream.getNext();
/*     */       } else {
/* 179 */         stringRecord = null;
/*     */       } 
/* 181 */       insertCell(new FormulaRecordAggregate(formulaRecord, stringRecord, paramSharedValueManager));
/*     */     } else {
/* 183 */       insertCell(paramCellValueRecordInterface);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowCellBlockSize(int paramInt1, int paramInt2) {
/* 191 */     int i = 0;
/* 192 */     for (int j = paramInt1; j <= paramInt2 && j < this.records.length; j++) {
/* 193 */       i += getRowSerializedSize(this.records[j]);
/*     */     }
/* 195 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean rowHasCells(int paramInt) {
/* 200 */     if (paramInt >= this.records.length) {
/* 201 */       return false;
/*     */     }
/* 203 */     CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[paramInt];
/* 204 */     if (arrayOfCellValueRecordInterface == null) return false; 
/* 205 */     for (byte b = 0; b < arrayOfCellValueRecordInterface.length; b++) {
/* 206 */       if (arrayOfCellValueRecordInterface[b] != null) return true; 
/*     */     } 
/* 208 */     return false;
/*     */   }
/*     */   
/*     */   private static int getRowSerializedSize(CellValueRecordInterface[] paramArrayOfCellValueRecordInterface) {
/* 212 */     if (paramArrayOfCellValueRecordInterface == null) {
/* 213 */       return 0;
/*     */     }
/* 215 */     int i = 0;
/* 216 */     for (int j = 0; j < paramArrayOfCellValueRecordInterface.length; j++) {
/* 217 */       RecordBase recordBase = (RecordBase)paramArrayOfCellValueRecordInterface[j];
/* 218 */       if (recordBase != null) {
/*     */ 
/*     */         
/* 221 */         int k = countBlanks(paramArrayOfCellValueRecordInterface, j);
/* 222 */         if (k > 1) {
/* 223 */           i += 10 + 2 * k;
/* 224 */           j += k - 1;
/*     */         } else {
/* 226 */           i += recordBase.getRecordSize();
/*     */         } 
/*     */       } 
/* 229 */     }  return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void visitCellsForRow(int paramInt, RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 234 */     CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[paramInt];
/* 235 */     if (arrayOfCellValueRecordInterface == null) {
/* 236 */       throw new IllegalArgumentException("Row [" + paramInt + "] is empty");
/*     */     }
/*     */ 
/*     */     
/* 240 */     for (int i = 0; i < arrayOfCellValueRecordInterface.length; i++) {
/* 241 */       RecordBase recordBase = (RecordBase)arrayOfCellValueRecordInterface[i];
/* 242 */       if (recordBase != null) {
/*     */ 
/*     */         
/* 245 */         int j = countBlanks(arrayOfCellValueRecordInterface, i);
/* 246 */         if (j > 1) {
/* 247 */           paramRecordVisitor.visitRecord((Record)createMBR(arrayOfCellValueRecordInterface, i, j));
/* 248 */           i += j - 1;
/* 249 */         } else if (recordBase instanceof RecordAggregate) {
/* 250 */           RecordAggregate recordAggregate = (RecordAggregate)recordBase;
/* 251 */           recordAggregate.visitContainedRecords(paramRecordVisitor);
/*     */         } else {
/* 253 */           paramRecordVisitor.visitRecord((Record)recordBase);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countBlanks(CellValueRecordInterface[] paramArrayOfCellValueRecordInterface, int paramInt) {
/* 263 */     int i = paramInt;
/* 264 */     while (i < paramArrayOfCellValueRecordInterface.length) {
/* 265 */       CellValueRecordInterface cellValueRecordInterface = paramArrayOfCellValueRecordInterface[i];
/* 266 */       if (!(cellValueRecordInterface instanceof BlankRecord)) {
/*     */         break;
/*     */       }
/* 269 */       i++;
/*     */     } 
/* 271 */     return i - paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private MulBlankRecord createMBR(CellValueRecordInterface[] paramArrayOfCellValueRecordInterface, int paramInt1, int paramInt2) {
/* 276 */     short[] arrayOfShort = new short[paramInt2]; int i;
/* 277 */     for (i = 0; i < arrayOfShort.length; i++) {
/* 278 */       arrayOfShort[i] = ((BlankRecord)paramArrayOfCellValueRecordInterface[paramInt1 + i]).getXFIndex();
/*     */     }
/* 280 */     i = paramArrayOfCellValueRecordInterface[paramInt1].getRow();
/* 281 */     return new MulBlankRecord(i, paramInt1, arrayOfShort);
/*     */   }
/*     */   
/*     */   public void updateFormulasAfterRowShift(FormulaShifter paramFormulaShifter, int paramInt) {
/* 285 */     for (byte b = 0; b < this.records.length; b++) {
/* 286 */       CellValueRecordInterface[] arrayOfCellValueRecordInterface = this.records[b];
/* 287 */       if (arrayOfCellValueRecordInterface != null)
/*     */       {
/*     */         
/* 290 */         for (byte b1 = 0; b1 < arrayOfCellValueRecordInterface.length; b1++) {
/* 291 */           CellValueRecordInterface cellValueRecordInterface = arrayOfCellValueRecordInterface[b1];
/* 292 */           if (cellValueRecordInterface instanceof FormulaRecordAggregate) {
/* 293 */             FormulaRecordAggregate formulaRecordAggregate = (FormulaRecordAggregate)cellValueRecordInterface;
/* 294 */             Ptg[] arrayOfPtg1 = formulaRecordAggregate.getFormulaTokens();
/* 295 */             Ptg[] arrayOfPtg2 = ((FormulaRecordAggregate)cellValueRecordInterface).getFormulaRecord().getParsedExpression();
/*     */             
/* 297 */             if (paramFormulaShifter.adjustFormula(arrayOfPtg1, paramInt)) {
/* 298 */               formulaRecordAggregate.setParsedExpression(arrayOfPtg1);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   class ValueIterator
/*     */     implements Iterator<CellValueRecordInterface>
/*     */   {
/* 310 */     int curRowIndex = 0, curColIndex = -1;
/* 311 */     int nextRowIndex = 0; int nextColIndex = -1;
/*     */     
/*     */     public ValueIterator() {
/* 314 */       getNextPos();
/*     */     }
/*     */     
/*     */     void getNextPos() {
/* 318 */       if (this.nextRowIndex >= ValueRecordsAggregate.this.records.length) {
/*     */         return;
/*     */       }
/* 321 */       while (this.nextRowIndex < ValueRecordsAggregate.this.records.length) {
/* 322 */         this.nextColIndex++;
/* 323 */         if (ValueRecordsAggregate.this.records[this.nextRowIndex] == null || this.nextColIndex >= (ValueRecordsAggregate.this.records[this.nextRowIndex]).length) {
/* 324 */           this.nextRowIndex++;
/* 325 */           this.nextColIndex = -1;
/*     */           
/*     */           continue;
/*     */         } 
/* 329 */         if (ValueRecordsAggregate.this.records[this.nextRowIndex][this.nextColIndex] != null) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 336 */       return (this.nextRowIndex < ValueRecordsAggregate.this.records.length);
/*     */     }
/*     */     
/*     */     public CellValueRecordInterface next() {
/* 340 */       if (!hasNext()) {
/* 341 */         throw new IndexOutOfBoundsException("iterator has no next");
/*     */       }
/* 343 */       this.curRowIndex = this.nextRowIndex;
/* 344 */       this.curColIndex = this.nextColIndex;
/* 345 */       CellValueRecordInterface cellValueRecordInterface = ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex];
/* 346 */       getNextPos();
/* 347 */       return cellValueRecordInterface;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 351 */       ValueRecordsAggregate.this.records[this.curRowIndex][this.curColIndex] = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<CellValueRecordInterface> iterator() {
/* 357 */     return new ValueIterator();
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 361 */     throw new RuntimeException("clone() should not be called.  ValueRecordsAggregate should be copied via Sheet.cloneSheet()");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\ValueRecordsAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */