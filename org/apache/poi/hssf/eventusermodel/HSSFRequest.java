/*     */ package org.apache.poi.hssf.eventusermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFRequest
/*     */ {
/*  41 */   private final Map<Short, List<HSSFListener>> _records = new HashMap<Short, List<HSSFListener>>(50);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(HSSFListener paramHSSFListener, short paramShort) {
/*  58 */     List<HSSFListener> list = this._records.get(Short.valueOf(paramShort));
/*     */     
/*  60 */     if (list == null) {
/*  61 */       list = new ArrayList(1);
/*  62 */       this._records.put(Short.valueOf(paramShort), list);
/*     */     } 
/*  64 */     list.add(paramHSSFListener);
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
/*     */   public void addListenerForAllRecords(HSSFListener paramHSSFListener) {
/*  78 */     short[] arrayOfShort = RecordFactory.getAllKnownRecordSIDs();
/*     */     
/*  80 */     for (short s : arrayOfShort) {
/*  81 */       addListener(paramHSSFListener, s);
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
/*     */   protected short processRecord(Record paramRecord) throws HSSFUserException {
/*  95 */     List<Object> list = (List)this._records.get(Short.valueOf(paramRecord.getSid()));
/*  96 */     short s = 0;
/*     */     
/*  98 */     if (list != null)
/*     */     {
/* 100 */       for (byte b = 0; b < list.size(); b++) {
/* 101 */         AbortableHSSFListener abortableHSSFListener = (AbortableHSSFListener)list.get(b);
/* 102 */         if (abortableHSSFListener instanceof AbortableHSSFListener) {
/* 103 */           AbortableHSSFListener abortableHSSFListener1 = abortableHSSFListener;
/* 104 */           s = abortableHSSFListener1.abortableProcessRecord(paramRecord);
/* 105 */           if (s != 0)
/*     */             break; 
/*     */         } else {
/* 108 */           AbortableHSSFListener abortableHSSFListener1 = abortableHSSFListener;
/* 109 */           abortableHSSFListener1.processRecord(paramRecord);
/*     */         } 
/*     */       } 
/*     */     }
/* 113 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\eventusermodel\HSSFRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */