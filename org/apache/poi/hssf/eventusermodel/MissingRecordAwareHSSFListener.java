/*     */ package org.apache.poi.hssf.eventusermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
/*     */ import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
/*     */ import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
/*     */ import org.apache.poi.hssf.record.BOFRecord;
/*     */ import org.apache.poi.hssf.record.BlankRecord;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.MulBlankRecord;
/*     */ import org.apache.poi.hssf.record.MulRKRecord;
/*     */ import org.apache.poi.hssf.record.NoteRecord;
/*     */ import org.apache.poi.hssf.record.NumberRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFactory;
/*     */ import org.apache.poi.hssf.record.RowRecord;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MissingRecordAwareHSSFListener
/*     */   implements HSSFListener
/*     */ {
/*     */   private HSSFListener childListener;
/*     */   private int lastRowRow;
/*     */   private int lastCellRow;
/*     */   private int lastCellColumn;
/*     */   
/*     */   public MissingRecordAwareHSSFListener(HSSFListener paramHSSFListener) {
/*  62 */     resetCounts();
/*  63 */     this.childListener = paramHSSFListener;
/*     */   }
/*     */   
/*     */   public void processRecord(Record paramRecord) {
/*     */     int i, j;
/*     */     NumberRecord[] arrayOfNumberRecord;
/*  69 */     BlankRecord[] arrayOfBlankRecord = null;
/*     */     
/*  71 */     if (paramRecord instanceof CellValueRecordInterface) {
/*  72 */       CellValueRecordInterface cellValueRecordInterface = (CellValueRecordInterface)paramRecord;
/*  73 */       i = cellValueRecordInterface.getRow();
/*  74 */       j = cellValueRecordInterface.getColumn();
/*     */     } else {
/*  76 */       BOFRecord bOFRecord; RowRecord rowRecord; MulBlankRecord mulBlankRecord; MulRKRecord mulRKRecord; NoteRecord noteRecord; if (paramRecord instanceof org.apache.poi.hssf.record.StringRecord) {
/*     */         
/*  78 */         this.childListener.processRecord(paramRecord);
/*     */         return;
/*     */       } 
/*  81 */       i = -1;
/*  82 */       j = -1;
/*     */       
/*  84 */       switch (paramRecord.getSid()) {
/*     */ 
/*     */         
/*     */         case 2057:
/*  88 */           bOFRecord = (BOFRecord)paramRecord;
/*  89 */           if (bOFRecord.getType() == 5 || bOFRecord.getType() == 16)
/*     */           {
/*     */             
/*  92 */             resetCounts();
/*     */           }
/*     */           break;
/*     */         case 520:
/*  96 */           rowRecord = (RowRecord)paramRecord;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 101 */           if (this.lastRowRow + 1 < rowRecord.getRowNumber()) {
/* 102 */             for (int k = this.lastRowRow + 1; k < rowRecord.getRowNumber(); k++) {
/* 103 */               MissingRowDummyRecord missingRowDummyRecord = new MissingRowDummyRecord(k);
/* 104 */               this.childListener.processRecord((Record)missingRowDummyRecord);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/* 109 */           this.lastRowRow = rowRecord.getRowNumber();
/* 110 */           this.lastCellColumn = -1;
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 1212:
/* 117 */           this.childListener.processRecord(paramRecord);
/*     */           return;
/*     */ 
/*     */ 
/*     */         
/*     */         case 190:
/* 123 */           mulBlankRecord = (MulBlankRecord)paramRecord;
/* 124 */           arrayOfBlankRecord = RecordFactory.convertBlankRecords(mulBlankRecord);
/*     */           break;
/*     */ 
/*     */         
/*     */         case 189:
/* 129 */           mulRKRecord = (MulRKRecord)paramRecord;
/* 130 */           arrayOfNumberRecord = RecordFactory.convertRKRecords(mulRKRecord);
/*     */           break;
/*     */         case 28:
/* 133 */           noteRecord = (NoteRecord)paramRecord;
/* 134 */           i = noteRecord.getRow();
/* 135 */           j = noteRecord.getColumn();
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 143 */     if (arrayOfNumberRecord != null && arrayOfNumberRecord.length > 0) {
/* 144 */       i = arrayOfNumberRecord[0].getRow();
/* 145 */       j = arrayOfNumberRecord[0].getColumn();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (i != this.lastCellRow && i > 0) {
/* 152 */       if (this.lastCellRow == -1) this.lastCellRow = 0; 
/* 153 */       for (int k = this.lastCellRow; k < i; k++) {
/* 154 */         int m = -1;
/* 155 */         if (k == this.lastCellRow) {
/* 156 */           m = this.lastCellColumn;
/*     */         }
/* 158 */         this.childListener.processRecord((Record)new LastCellOfRowDummyRecord(k, m));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 164 */     if (this.lastCellRow != -1 && this.lastCellColumn != -1 && i == -1) {
/* 165 */       this.childListener.processRecord((Record)new LastCellOfRowDummyRecord(this.lastCellRow, this.lastCellColumn));
/*     */       
/* 167 */       this.lastCellRow = -1;
/* 168 */       this.lastCellColumn = -1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 173 */     if (i != this.lastCellRow) {
/* 174 */       this.lastCellColumn = -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 179 */     if (this.lastCellColumn != j - 1) {
/* 180 */       for (int k = this.lastCellColumn + 1; k < j; k++) {
/* 181 */         this.childListener.processRecord((Record)new MissingCellDummyRecord(i, k));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 186 */     if (arrayOfNumberRecord != null && arrayOfNumberRecord.length > 0) {
/* 187 */       j = arrayOfNumberRecord[arrayOfNumberRecord.length - 1].getColumn();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 192 */     if (j != -1) {
/* 193 */       this.lastCellColumn = j;
/* 194 */       this.lastCellRow = i;
/*     */     } 
/*     */ 
/*     */     
/* 198 */     if (arrayOfNumberRecord != null && arrayOfNumberRecord.length > 0) {
/* 199 */       for (NumberRecord numberRecord : arrayOfNumberRecord) {
/* 200 */         this.childListener.processRecord((Record)numberRecord);
/*     */       }
/*     */     } else {
/* 203 */       this.childListener.processRecord(paramRecord);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void resetCounts() {
/* 208 */     this.lastRowRow = -1;
/* 209 */     this.lastCellRow = -1;
/* 210 */     this.lastCellColumn = -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\MissingRecordAwareHSSFListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */