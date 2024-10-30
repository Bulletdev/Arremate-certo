/*     */ package org.apache.poi.hssf.eventusermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.BoundSheetRecord;
/*     */ import org.apache.poi.hssf.record.EOFRecord;
/*     */ import org.apache.poi.hssf.record.ExternSheetRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SSTRecord;
/*     */ import org.apache.poi.hssf.record.SupBookRecord;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventWorkbookBuilder
/*     */ {
/*     */   public static InternalWorkbook createStubWorkbook(ExternSheetRecord[] paramArrayOfExternSheetRecord, BoundSheetRecord[] paramArrayOfBoundSheetRecord, SSTRecord paramSSTRecord) {
/*  68 */     ArrayList<BoundSheetRecord> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  71 */     if (paramArrayOfBoundSheetRecord != null) {
/*  72 */       for (BoundSheetRecord boundSheetRecord : paramArrayOfBoundSheetRecord) {
/*  73 */         arrayList.add(boundSheetRecord);
/*     */       }
/*     */     }
/*  76 */     if (paramSSTRecord != null) {
/*  77 */       arrayList.add(paramSSTRecord);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  82 */     if (paramArrayOfExternSheetRecord != null) {
/*  83 */       arrayList.add(SupBookRecord.createInternalReferences((short)paramArrayOfExternSheetRecord.length));
/*     */       
/*  85 */       for (ExternSheetRecord externSheetRecord : paramArrayOfExternSheetRecord) {
/*  86 */         arrayList.add(externSheetRecord);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  91 */     arrayList.add(EOFRecord.instance);
/*     */     
/*  93 */     return InternalWorkbook.createWorkbook(arrayList);
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
/*     */   public static InternalWorkbook createStubWorkbook(ExternSheetRecord[] paramArrayOfExternSheetRecord, BoundSheetRecord[] paramArrayOfBoundSheetRecord) {
/* 105 */     return createStubWorkbook(paramArrayOfExternSheetRecord, paramArrayOfBoundSheetRecord, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SheetRecordCollectingListener
/*     */     implements HSSFListener
/*     */   {
/*     */     private final HSSFListener childListener;
/*     */ 
/*     */     
/* 117 */     private final List<BoundSheetRecord> boundSheetRecords = new ArrayList<BoundSheetRecord>();
/* 118 */     private final List<ExternSheetRecord> externSheetRecords = new ArrayList<ExternSheetRecord>();
/* 119 */     private SSTRecord sstRecord = null;
/*     */     
/*     */     public SheetRecordCollectingListener(HSSFListener param1HSSFListener) {
/* 122 */       this.childListener = param1HSSFListener;
/*     */     }
/*     */ 
/*     */     
/*     */     public BoundSheetRecord[] getBoundSheetRecords() {
/* 127 */       return this.boundSheetRecords.<BoundSheetRecord>toArray(new BoundSheetRecord[this.boundSheetRecords.size()]);
/*     */     }
/*     */ 
/*     */     
/*     */     public ExternSheetRecord[] getExternSheetRecords() {
/* 132 */       return this.externSheetRecords.<ExternSheetRecord>toArray(new ExternSheetRecord[this.externSheetRecords.size()]);
/*     */     }
/*     */ 
/*     */     
/*     */     public SSTRecord getSSTRecord() {
/* 137 */       return this.sstRecord;
/*     */     }
/*     */ 
/*     */     
/*     */     public HSSFWorkbook getStubHSSFWorkbook() {
/* 142 */       HSSFWorkbook hSSFWorkbook = HSSFWorkbook.create(getStubWorkbook());
/*     */       
/* 144 */       for (BoundSheetRecord boundSheetRecord : this.boundSheetRecords) {
/* 145 */         hSSFWorkbook.createSheet(boundSheetRecord.getSheetname());
/*     */       }
/*     */       
/* 148 */       return hSSFWorkbook;
/*     */     }
/*     */     public InternalWorkbook getStubWorkbook() {
/* 151 */       return EventWorkbookBuilder.createStubWorkbook(getExternSheetRecords(), getBoundSheetRecords(), getSSTRecord());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void processRecord(Record param1Record) {
/* 165 */       processRecordInternally(param1Record);
/*     */ 
/*     */       
/* 168 */       this.childListener.processRecord(param1Record);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void processRecordInternally(Record param1Record) {
/* 178 */       if (param1Record instanceof BoundSheetRecord) {
/* 179 */         this.boundSheetRecords.add((BoundSheetRecord)param1Record);
/*     */       }
/* 181 */       else if (param1Record instanceof ExternSheetRecord) {
/* 182 */         this.externSheetRecords.add((ExternSheetRecord)param1Record);
/*     */       }
/* 184 */       else if (param1Record instanceof SSTRecord) {
/* 185 */         this.sstRecord = (SSTRecord)param1Record;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\EventWorkbookBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */