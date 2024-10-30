/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.apache.poi.hssf.record.GutsRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordBase;
/*     */ import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
/*     */ import org.apache.poi.hssf.record.aggregates.DataValidityTable;
/*     */ import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
/*     */ import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
/*     */ import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RecordOrderer
/*     */ {
/*     */   public static void addNewSheetRecord(List<RecordBase> paramList, RecordBase paramRecordBase) {
/*  92 */     int i = findSheetInsertPos(paramList, (Class)paramRecordBase.getClass());
/*  93 */     paramList.add(i, paramRecordBase);
/*     */   }
/*     */   
/*     */   private static int findSheetInsertPos(List<RecordBase> paramList, Class<? extends RecordBase> paramClass) {
/*  97 */     if (paramClass == DataValidityTable.class) {
/*  98 */       return findDataValidationTableInsertPos(paramList);
/*     */     }
/* 100 */     if (paramClass == MergedCellsTable.class) {
/* 101 */       return findInsertPosForNewMergedRecordTable(paramList);
/*     */     }
/* 103 */     if (paramClass == ConditionalFormattingTable.class) {
/* 104 */       return findInsertPosForNewCondFormatTable(paramList);
/*     */     }
/* 106 */     if (paramClass == GutsRecord.class) {
/* 107 */       return getGutsRecordInsertPos(paramList);
/*     */     }
/* 109 */     if (paramClass == PageSettingsBlock.class) {
/* 110 */       return getPageBreakRecordInsertPos(paramList);
/*     */     }
/* 112 */     if (paramClass == WorksheetProtectionBlock.class) {
/* 113 */       return getWorksheetProtectionBlockInsertPos(paramList);
/*     */     }
/* 115 */     throw new RuntimeException("Unexpected record class (" + paramClass.getName() + ")");
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
/*     */   private static int getWorksheetProtectionBlockInsertPos(List<RecordBase> paramList) {
/* 140 */     int i = getDimensionsIndex(paramList);
/* 141 */     while (i > 0) {
/* 142 */       i--;
/* 143 */       Object object = paramList.get(i);
/* 144 */       if (!isProtectionSubsequentRecord(object)) {
/* 145 */         return i + 1;
/*     */       }
/*     */     } 
/* 148 */     throw new IllegalStateException("did not find insert pos for protection block");
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
/*     */   private static boolean isProtectionSubsequentRecord(Object paramObject) {
/* 161 */     if (paramObject instanceof org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate) {
/* 162 */       return true;
/*     */     }
/* 164 */     if (paramObject instanceof Record) {
/* 165 */       Record record = (Record)paramObject;
/* 166 */       switch (record.getSid()) {
/*     */         case 85:
/*     */         case 144:
/* 169 */           return true;
/*     */       } 
/*     */     } 
/* 172 */     return false;
/*     */   }
/*     */   
/*     */   private static int getPageBreakRecordInsertPos(List<RecordBase> paramList) {
/* 176 */     int i = getDimensionsIndex(paramList);
/* 177 */     int j = i - 1;
/* 178 */     while (j > 0) {
/* 179 */       j--;
/* 180 */       Object object = paramList.get(j);
/* 181 */       if (isPageBreakPriorRecord(object)) {
/* 182 */         return j + 1;
/*     */       }
/*     */     } 
/* 185 */     throw new RuntimeException("Did not find insert point for GUTS");
/*     */   }
/*     */   private static boolean isPageBreakPriorRecord(Object paramObject) {
/* 188 */     if (paramObject instanceof Record) {
/* 189 */       Record record = (Record)paramObject;
/* 190 */       switch (record.getSid()) {
/*     */ 
/*     */         
/*     */         case 12:
/*     */         case 13:
/*     */         case 14:
/*     */         case 15:
/*     */         case 16:
/*     */         case 17:
/*     */         case 34:
/*     */         case 42:
/*     */         case 43:
/*     */         case 94:
/*     */         case 95:
/*     */         case 129:
/*     */         case 130:
/*     */         case 523:
/*     */         case 549:
/*     */         case 2057:
/* 209 */           return true;
/*     */       } 
/*     */     
/*     */     } 
/* 213 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int findInsertPosForNewCondFormatTable(List<RecordBase> paramList) {
/* 220 */     for (int i = paramList.size() - 2; i >= 0; i--) {
/* 221 */       Record record = (Record)paramList.get(i);
/* 222 */       if (record instanceof MergedCellsTable) {
/* 223 */         return i + 1;
/*     */       }
/* 225 */       if (!(record instanceof DataValidityTable)) {
/*     */ 
/*     */ 
/*     */         
/* 229 */         Record record1 = record;
/* 230 */         switch (record1.getSid()) {
/*     */ 
/*     */           
/*     */           case 29:
/*     */           case 65:
/*     */           case 153:
/*     */           case 160:
/*     */           case 239:
/*     */           case 351:
/*     */           case 574:
/* 240 */             return i + 1;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 245 */     throw new RuntimeException("Did not find Window2 record");
/*     */   }
/*     */   
/*     */   private static int findInsertPosForNewMergedRecordTable(List<RecordBase> paramList) {
/* 249 */     for (int i = paramList.size() - 2; i >= 0; i--) {
/* 250 */       Record record = (Record)paramList.get(i);
/* 251 */       if (record instanceof Record) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 256 */         Record record1 = record;
/* 257 */         switch (record1.getSid()) {
/*     */ 
/*     */           
/*     */           case 29:
/*     */           case 65:
/*     */           case 153:
/*     */           case 160:
/*     */           case 574:
/* 265 */             return i + 1;
/*     */         } 
/*     */       } 
/* 268 */     }  throw new RuntimeException("Did not find Window2 record");
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
/*     */   private static int findDataValidationTableInsertPos(List<RecordBase> paramList) {
/* 293 */     int i = paramList.size() - 1;
/* 294 */     if (!(paramList.get(i) instanceof org.apache.poi.hssf.record.EOFRecord)) {
/* 295 */       throw new IllegalStateException("Last sheet record should be EOFRecord");
/*     */     }
/* 297 */     while (i > 0) {
/* 298 */       i--;
/* 299 */       RecordBase recordBase = paramList.get(i);
/* 300 */       if (isDVTPriorRecord(recordBase)) {
/* 301 */         Record record1 = (Record)paramList.get(i + 1);
/* 302 */         if (!isDVTSubsequentRecord(record1.getSid())) {
/* 303 */           throw new IllegalStateException("Unexpected (" + record1.getClass().getName() + ") found after (" + recordBase.getClass().getName() + ")");
/*     */         }
/*     */         
/* 306 */         return i + 1;
/*     */       } 
/* 308 */       Record record = (Record)recordBase;
/* 309 */       if (!isDVTSubsequentRecord(record.getSid())) {
/* 310 */         throw new IllegalStateException("Unexpected (" + record.getClass().getName() + ") while looking for DV Table insert pos");
/*     */       }
/*     */     } 
/*     */     
/* 314 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDVTPriorRecord(RecordBase paramRecordBase) {
/* 319 */     if (paramRecordBase instanceof MergedCellsTable || paramRecordBase instanceof ConditionalFormattingTable) {
/* 320 */       return true;
/*     */     }
/* 322 */     short s = ((Record)paramRecordBase).getSid();
/* 323 */     switch (s) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 29:
/*     */       case 65:
/*     */       case 153:
/*     */       case 160:
/*     */       case 239:
/*     */       case 351:
/*     */       case 440:
/*     */       case 442:
/*     */       case 574:
/*     */       case 2048:
/* 337 */         return true;
/*     */     } 
/* 339 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isDVTSubsequentRecord(short paramShort) {
/* 343 */     switch (paramShort) {
/*     */       case 10:
/*     */       case 2146:
/*     */       case 2151:
/*     */       case 2152:
/*     */       case 2248:
/* 349 */         return true;
/*     */     } 
/* 351 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getDimensionsIndex(List<RecordBase> paramList) {
/* 357 */     int i = paramList.size();
/* 358 */     for (byte b = 0; b < i; b++) {
/* 359 */       if (paramList.get(b) instanceof org.apache.poi.hssf.record.DimensionsRecord) {
/* 360 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 364 */     throw new RuntimeException("DimensionsRecord not found");
/*     */   }
/*     */   
/*     */   private static int getGutsRecordInsertPos(List<RecordBase> paramList) {
/* 368 */     int i = getDimensionsIndex(paramList);
/* 369 */     int j = i - 1;
/* 370 */     while (j > 0) {
/* 371 */       j--;
/* 372 */       RecordBase recordBase = paramList.get(j);
/* 373 */       if (isGutsPriorRecord(recordBase)) {
/* 374 */         return j + 1;
/*     */       }
/*     */     } 
/* 377 */     throw new RuntimeException("Did not find insert point for GUTS");
/*     */   }
/*     */   
/*     */   private static boolean isGutsPriorRecord(RecordBase paramRecordBase) {
/* 381 */     if (paramRecordBase instanceof Record) {
/* 382 */       Record record = (Record)paramRecordBase;
/* 383 */       switch (record.getSid()) {
/*     */ 
/*     */         
/*     */         case 12:
/*     */         case 13:
/*     */         case 14:
/*     */         case 15:
/*     */         case 16:
/*     */         case 17:
/*     */         case 34:
/*     */         case 42:
/*     */         case 43:
/*     */         case 94:
/*     */         case 95:
/*     */         case 130:
/*     */         case 523:
/*     */         case 2057:
/* 400 */           return true;
/*     */       } 
/*     */     
/*     */     } 
/* 404 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isEndOfRowBlock(int paramInt) {
/* 412 */     switch (paramInt) {
/*     */ 
/*     */       
/*     */       case 61:
/*     */       case 93:
/*     */       case 125:
/*     */       case 128:
/*     */       case 176:
/*     */       case 236:
/*     */       case 237:
/*     */       case 438:
/*     */       case 574:
/* 424 */         return true;
/*     */       
/*     */       case 434:
/* 427 */         return true;
/*     */       
/*     */       case 10:
/* 430 */         throw new RuntimeException("Found EOFRecord before WindowTwoRecord was encountered");
/*     */     } 
/* 432 */     return PageSettingsBlock.isComponentRecord(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isRowBlockRecord(int paramInt) {
/* 440 */     switch (paramInt) {
/*     */ 
/*     */       
/*     */       case 6:
/*     */       case 253:
/*     */       case 513:
/*     */       case 515:
/*     */       case 516:
/*     */       case 517:
/*     */       case 520:
/*     */       case 545:
/*     */       case 566:
/*     */       case 638:
/*     */       case 1212:
/* 454 */         return true;
/*     */     } 
/* 456 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\RecordOrderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */