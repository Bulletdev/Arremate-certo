/*     */ package org.apache.poi.hssf.eventmodel;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFactory;
/*     */ import org.apache.poi.hssf.record.RecordFormatException;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EventRecordFactory
/*     */ {
/*     */   private final ERFListener _listener;
/*     */   private final short[] _sids;
/*     */   
/*     */   public EventRecordFactory(ERFListener paramERFListener, short[] paramArrayOfshort) {
/*  45 */     this._listener = paramERFListener;
/*  46 */     if (paramArrayOfshort == null) {
/*  47 */       this._sids = null;
/*     */     } else {
/*  49 */       this._sids = (short[])paramArrayOfshort.clone();
/*  50 */       Arrays.sort(this._sids);
/*     */     } 
/*     */   }
/*     */   private boolean isSidIncluded(short paramShort) {
/*  54 */     if (this._sids == null) {
/*  55 */       return true;
/*     */     }
/*  57 */     return (Arrays.binarySearch(this._sids, paramShort) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean processRecord(Record paramRecord) {
/*  68 */     if (!isSidIncluded(paramRecord.getSid())) {
/*  69 */       return true;
/*     */     }
/*  71 */     return this._listener.processRecord(paramRecord);
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
/*     */   public void processRecords(InputStream paramInputStream) throws RecordFormatException {
/*  84 */     Record record = null;
/*     */     
/*  86 */     RecordInputStream recordInputStream = new RecordInputStream(paramInputStream);
/*     */     
/*  88 */     while (recordInputStream.hasNextRecord()) {
/*  89 */       recordInputStream.nextRecord();
/*  90 */       Record[] arrayOfRecord = RecordFactory.createRecord(recordInputStream);
/*  91 */       if (arrayOfRecord.length > 1) {
/*  92 */         for (Record record2 : arrayOfRecord) {
/*  93 */           if (record != null && 
/*  94 */             !processRecord(record)) {
/*     */             return;
/*     */           }
/*     */           
/*  98 */           record = record2;
/*     */         }  continue;
/*     */       } 
/* 101 */       Record record1 = arrayOfRecord[0];
/*     */       
/* 103 */       if (record1 != null) {
/* 104 */         if (record != null && 
/* 105 */           !processRecord(record)) {
/*     */           return;
/*     */         }
/*     */         
/* 109 */         record = record1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 114 */     if (record != null)
/* 115 */       processRecord(record); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventmodel\EventRecordFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */