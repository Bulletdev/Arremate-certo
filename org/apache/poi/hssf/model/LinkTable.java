/*     */ package org.apache.poi.hssf.model;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hssf.record.CRNCountRecord;
/*     */ import org.apache.poi.hssf.record.CRNRecord;
/*     */ import org.apache.poi.hssf.record.ExternSheetRecord;
/*     */ import org.apache.poi.hssf.record.ExternalNameRecord;
/*     */ import org.apache.poi.hssf.record.NameCommentRecord;
/*     */ import org.apache.poi.hssf.record.NameRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.SupBookRecord;
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.ss.formula.ptg.ErrPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NameXPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class LinkTable
/*     */ {
/*     */   private ExternalBookBlock[] _externalBookBlocks;
/*     */   private final ExternSheetRecord _externSheetRecord;
/*     */   private final List<NameRecord> _definedNames;
/*     */   private final int _recordCount;
/*     */   private final WorkbookRecordList _workbookRecordList;
/*     */   
/*     */   private static final class CRNBlock
/*     */   {
/*     */     private final CRNCountRecord _countRecord;
/*     */     private final CRNRecord[] _crns;
/*     */     
/*     */     public CRNBlock(RecordStream param1RecordStream) {
/*  79 */       this._countRecord = (CRNCountRecord)param1RecordStream.getNext();
/*  80 */       int i = this._countRecord.getNumberOfCRNs();
/*  81 */       CRNRecord[] arrayOfCRNRecord = new CRNRecord[i];
/*  82 */       for (byte b = 0; b < arrayOfCRNRecord.length; b++) {
/*  83 */         arrayOfCRNRecord[b] = (CRNRecord)param1RecordStream.getNext();
/*     */       }
/*  85 */       this._crns = arrayOfCRNRecord;
/*     */     }
/*     */     public CRNRecord[] getCrns() {
/*  88 */       return (CRNRecord[])this._crns.clone();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ExternalBookBlock {
/*     */     private final SupBookRecord _externalBookRecord;
/*     */     private ExternalNameRecord[] _externalNameRecords;
/*     */     private final LinkTable.CRNBlock[] _crnBlocks;
/*     */     
/*     */     public ExternalBookBlock(RecordStream param1RecordStream) {
/*  98 */       this._externalBookRecord = (SupBookRecord)param1RecordStream.getNext();
/*  99 */       ArrayList<Record> arrayList = new ArrayList();
/* 100 */       while (param1RecordStream.peekNextClass() == ExternalNameRecord.class) {
/* 101 */         arrayList.add(param1RecordStream.getNext());
/*     */       }
/* 103 */       this._externalNameRecords = new ExternalNameRecord[arrayList.size()];
/* 104 */       arrayList.toArray(this._externalNameRecords);
/*     */       
/* 106 */       arrayList.clear();
/*     */       
/* 108 */       while (param1RecordStream.peekNextClass() == CRNCountRecord.class) {
/* 109 */         arrayList.add(new LinkTable.CRNBlock(param1RecordStream));
/*     */       }
/* 111 */       this._crnBlocks = new LinkTable.CRNBlock[arrayList.size()];
/* 112 */       arrayList.toArray(this._crnBlocks);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ExternalBookBlock(String param1String, String[] param1ArrayOfString) {
/* 119 */       this._externalBookRecord = SupBookRecord.createExternalReferences(param1String, param1ArrayOfString);
/* 120 */       this._crnBlocks = new LinkTable.CRNBlock[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ExternalBookBlock(int param1Int) {
/* 129 */       this._externalBookRecord = SupBookRecord.createInternalReferences((short)param1Int);
/* 130 */       this._externalNameRecords = new ExternalNameRecord[0];
/* 131 */       this._crnBlocks = new LinkTable.CRNBlock[0];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ExternalBookBlock() {
/* 140 */       this._externalBookRecord = SupBookRecord.createAddInFunctions();
/* 141 */       this._externalNameRecords = new ExternalNameRecord[0];
/* 142 */       this._crnBlocks = new LinkTable.CRNBlock[0];
/*     */     }
/*     */     
/*     */     public SupBookRecord getExternalBookRecord() {
/* 146 */       return this._externalBookRecord;
/*     */     }
/*     */     
/*     */     public String getNameText(int param1Int) {
/* 150 */       return this._externalNameRecords[param1Int].getText();
/*     */     }
/*     */     
/*     */     public int getNameIx(int param1Int) {
/* 154 */       return this._externalNameRecords[param1Int].getIx();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getIndexOfName(String param1String) {
/* 162 */       for (byte b = 0; b < this._externalNameRecords.length; b++) {
/* 163 */         if (this._externalNameRecords[b].getText().equalsIgnoreCase(param1String)) {
/* 164 */           return b;
/*     */         }
/*     */       } 
/* 167 */       return -1;
/*     */     }
/*     */     
/*     */     public int getNumberOfNames() {
/* 171 */       return this._externalNameRecords.length;
/*     */     }
/*     */     
/*     */     public int addExternalName(ExternalNameRecord param1ExternalNameRecord) {
/* 175 */       ExternalNameRecord[] arrayOfExternalNameRecord = new ExternalNameRecord[this._externalNameRecords.length + 1];
/* 176 */       System.arraycopy(this._externalNameRecords, 0, arrayOfExternalNameRecord, 0, this._externalNameRecords.length);
/* 177 */       arrayOfExternalNameRecord[arrayOfExternalNameRecord.length - 1] = param1ExternalNameRecord;
/* 178 */       this._externalNameRecords = arrayOfExternalNameRecord;
/* 179 */       return this._externalNameRecords.length - 1;
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
/*     */   public LinkTable(List<Record> paramList, int paramInt, WorkbookRecordList paramWorkbookRecordList, Map<String, NameCommentRecord> paramMap) {
/* 191 */     this._workbookRecordList = paramWorkbookRecordList;
/* 192 */     RecordStream recordStream = new RecordStream(paramList, paramInt);
/*     */     
/* 194 */     ArrayList<ExternalBookBlock> arrayList = new ArrayList();
/* 195 */     while (recordStream.peekNextClass() == SupBookRecord.class) {
/* 196 */       arrayList.add(new ExternalBookBlock(recordStream));
/*     */     }
/*     */     
/* 199 */     this._externalBookBlocks = new ExternalBookBlock[arrayList.size()];
/* 200 */     arrayList.toArray(this._externalBookBlocks);
/* 201 */     arrayList.clear();
/*     */     
/* 203 */     if (this._externalBookBlocks.length > 0) {
/*     */       
/* 205 */       if (recordStream.peekNextClass() != ExternSheetRecord.class) {
/*     */         
/* 207 */         this._externSheetRecord = null;
/*     */       } else {
/* 209 */         this._externSheetRecord = readExtSheetRecord(recordStream);
/*     */       } 
/*     */     } else {
/* 212 */       this._externSheetRecord = null;
/*     */     } 
/*     */     
/* 215 */     this._definedNames = new ArrayList<NameRecord>();
/*     */ 
/*     */     
/*     */     while (true) {
/* 219 */       Class<? extends Record> clazz = recordStream.peekNextClass();
/* 220 */       if (clazz == NameRecord.class) {
/* 221 */         NameRecord nameRecord = (NameRecord)recordStream.getNext();
/* 222 */         this._definedNames.add(nameRecord); continue;
/*     */       } 
/* 224 */       if (clazz == NameCommentRecord.class) {
/* 225 */         NameCommentRecord nameCommentRecord = (NameCommentRecord)recordStream.getNext();
/* 226 */         paramMap.put(nameCommentRecord.getNameText(), nameCommentRecord);
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*     */       break;
/*     */     } 
/* 233 */     this._recordCount = recordStream.getCountRead();
/* 234 */     this._workbookRecordList.getRecords().addAll(paramList.subList(paramInt, paramInt + this._recordCount));
/*     */   }
/*     */   
/*     */   private static ExternSheetRecord readExtSheetRecord(RecordStream paramRecordStream) {
/* 238 */     ArrayList<ExternSheetRecord> arrayList = new ArrayList(2);
/* 239 */     while (paramRecordStream.peekNextClass() == ExternSheetRecord.class) {
/* 240 */       arrayList.add((ExternSheetRecord)paramRecordStream.getNext());
/*     */     }
/*     */     
/* 243 */     int i = arrayList.size();
/* 244 */     if (i < 1) {
/* 245 */       throw new RuntimeException("Expected an EXTERNSHEET record but got (" + paramRecordStream.peekNextClass().getName() + ")");
/*     */     }
/*     */     
/* 248 */     if (i == 1)
/*     */     {
/* 250 */       return arrayList.get(0);
/*     */     }
/*     */ 
/*     */     
/* 254 */     ExternSheetRecord[] arrayOfExternSheetRecord = new ExternSheetRecord[i];
/* 255 */     arrayList.toArray(arrayOfExternSheetRecord);
/* 256 */     return ExternSheetRecord.combine(arrayOfExternSheetRecord);
/*     */   }
/*     */   
/*     */   public LinkTable(int paramInt, WorkbookRecordList paramWorkbookRecordList) {
/* 260 */     this._workbookRecordList = paramWorkbookRecordList;
/* 261 */     this._definedNames = new ArrayList<NameRecord>();
/* 262 */     this._externalBookBlocks = new ExternalBookBlock[] { new ExternalBookBlock(paramInt) };
/*     */ 
/*     */     
/* 265 */     this._externSheetRecord = new ExternSheetRecord();
/* 266 */     this._recordCount = 2;
/*     */ 
/*     */ 
/*     */     
/* 270 */     SupBookRecord supBookRecord = this._externalBookBlocks[0].getExternalBookRecord();
/*     */     
/* 272 */     int i = findFirstRecordLocBySid((short)140);
/* 273 */     if (i < 0) {
/* 274 */       throw new RuntimeException("CountryRecord not found");
/*     */     }
/* 276 */     this._workbookRecordList.add(i + 1, (Record)this._externSheetRecord);
/* 277 */     this._workbookRecordList.add(i + 1, (Record)supBookRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordCount() {
/* 284 */     return this._recordCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameRecord getSpecificBuiltinRecord(byte paramByte, int paramInt) {
/* 293 */     Iterator<NameRecord> iterator = this._definedNames.iterator();
/* 294 */     while (iterator.hasNext()) {
/* 295 */       NameRecord nameRecord = iterator.next();
/*     */ 
/*     */       
/* 298 */       if (nameRecord.getBuiltInName() == paramByte && nameRecord.getSheetNumber() == paramInt) {
/* 299 */         return nameRecord;
/*     */       }
/*     */     } 
/*     */     
/* 303 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeBuiltinRecord(byte paramByte, int paramInt) {
/* 309 */     NameRecord nameRecord = getSpecificBuiltinRecord(paramByte, paramInt);
/* 310 */     if (nameRecord != null) {
/* 311 */       this._definedNames.remove(nameRecord);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getNumNames() {
/* 317 */     return this._definedNames.size();
/*     */   }
/*     */   
/*     */   public NameRecord getNameRecord(int paramInt) {
/* 321 */     return this._definedNames.get(paramInt);
/*     */   }
/*     */   
/*     */   public void addName(NameRecord paramNameRecord) {
/* 325 */     this._definedNames.add(paramNameRecord);
/*     */ 
/*     */ 
/*     */     
/* 329 */     int i = findFirstRecordLocBySid((short)23);
/* 330 */     if (i == -1) i = findFirstRecordLocBySid((short)430); 
/* 331 */     if (i == -1) i = findFirstRecordLocBySid((short)140); 
/* 332 */     int j = this._definedNames.size();
/* 333 */     this._workbookRecordList.add(i + j, (Record)paramNameRecord);
/*     */   }
/*     */   
/*     */   public void removeName(int paramInt) {
/* 337 */     this._definedNames.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nameAlreadyExists(NameRecord paramNameRecord) {
/* 346 */     for (int i = getNumNames() - 1; i >= 0; i--) {
/* 347 */       NameRecord nameRecord = getNameRecord(i);
/* 348 */       if (nameRecord != paramNameRecord && 
/* 349 */         isDuplicatedNames(paramNameRecord, nameRecord)) {
/* 350 */         return true;
/*     */       }
/*     */     } 
/* 353 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isDuplicatedNames(NameRecord paramNameRecord1, NameRecord paramNameRecord2) {
/* 357 */     return (paramNameRecord2.getNameText().equalsIgnoreCase(paramNameRecord1.getNameText()) && isSameSheetNames(paramNameRecord1, paramNameRecord2));
/*     */   }
/*     */   
/*     */   private static boolean isSameSheetNames(NameRecord paramNameRecord1, NameRecord paramNameRecord2) {
/* 361 */     return (paramNameRecord2.getSheetNumber() == paramNameRecord1.getSheetNumber());
/*     */   }
/*     */   
/*     */   public String[] getExternalBookAndSheetName(int paramInt) {
/* 365 */     int i = this._externSheetRecord.getExtbookIndexFromRefIndex(paramInt);
/* 366 */     SupBookRecord supBookRecord = this._externalBookBlocks[i].getExternalBookRecord();
/* 367 */     if (!supBookRecord.isExternalReferences()) {
/* 368 */       return null;
/*     */     }
/*     */     
/* 371 */     int j = this._externSheetRecord.getFirstSheetIndexFromRefIndex(paramInt);
/* 372 */     int k = this._externSheetRecord.getLastSheetIndexFromRefIndex(paramInt);
/* 373 */     String str1 = null;
/* 374 */     String str2 = null;
/* 375 */     if (j >= 0) {
/* 376 */       str1 = supBookRecord.getSheetNames()[j];
/*     */     }
/* 378 */     if (k >= 0) {
/* 379 */       str2 = supBookRecord.getSheetNames()[k];
/*     */     }
/* 381 */     if (j == k) {
/* 382 */       return new String[] { supBookRecord.getURL(), str1 };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 387 */     return new String[] { supBookRecord.getURL(), str1, str2 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getExternalWorkbookIndex(String paramString) {
/* 396 */     for (byte b = 0; b < this._externalBookBlocks.length; b++) {
/* 397 */       SupBookRecord supBookRecord = this._externalBookBlocks[b].getExternalBookRecord();
/* 398 */       if (supBookRecord.isExternalReferences())
/*     */       {
/*     */         
/* 401 */         if (paramString.equals(supBookRecord.getURL()))
/* 402 */           return b; 
/*     */       }
/*     */     } 
/* 405 */     return -1;
/*     */   }
/*     */   
/*     */   public int linkExternalWorkbook(String paramString, Workbook paramWorkbook) {
/* 409 */     int i = getExternalWorkbookIndex(paramString);
/* 410 */     if (i != -1)
/*     */     {
/* 412 */       return i;
/*     */     }
/*     */ 
/*     */     
/* 416 */     String[] arrayOfString = new String[paramWorkbook.getNumberOfSheets()];
/* 417 */     for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/* 418 */       arrayOfString[b1] = paramWorkbook.getSheetName(b1);
/*     */     }
/* 420 */     String str = "\000" + paramString;
/* 421 */     ExternalBookBlock externalBookBlock = new ExternalBookBlock(str, arrayOfString);
/*     */ 
/*     */     
/* 424 */     i = extendExternalBookBlocks(externalBookBlock);
/*     */ 
/*     */     
/* 427 */     int j = findFirstRecordLocBySid((short)23);
/* 428 */     if (j == -1) {
/* 429 */       j = this._workbookRecordList.size();
/*     */     }
/* 431 */     this._workbookRecordList.add(j, (Record)externalBookBlock.getExternalBookRecord());
/*     */ 
/*     */     
/* 434 */     for (byte b2 = 0; b2 < arrayOfString.length; b2++) {
/* 435 */       this._externSheetRecord.addRef(i, b2, b2);
/*     */     }
/*     */ 
/*     */     
/* 439 */     return i;
/*     */   }
/*     */   
/*     */   public int getExternalSheetIndex(String paramString1, String paramString2, String paramString3) {
/* 443 */     int i = getExternalWorkbookIndex(paramString1);
/* 444 */     if (i == -1) {
/* 445 */       throw new RuntimeException("No external workbook with name '" + paramString1 + "'");
/*     */     }
/* 447 */     SupBookRecord supBookRecord = this._externalBookBlocks[i].getExternalBookRecord();
/*     */     
/* 449 */     int j = getSheetIndex(supBookRecord.getSheetNames(), paramString2);
/* 450 */     int k = getSheetIndex(supBookRecord.getSheetNames(), paramString3);
/*     */ 
/*     */     
/* 453 */     int m = this._externSheetRecord.getRefIxForSheet(i, j, k);
/* 454 */     if (m < 0) {
/* 455 */       m = this._externSheetRecord.addRef(i, j, k);
/*     */     }
/* 457 */     return m;
/*     */   }
/*     */   
/*     */   private static int getSheetIndex(String[] paramArrayOfString, String paramString) {
/* 461 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 462 */       if (paramArrayOfString[b].equals(paramString)) {
/* 463 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 467 */     throw new RuntimeException("External workbook does not contain sheet '" + paramString + "'");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstInternalSheetIndexForExtIndex(int paramInt) {
/* 475 */     if (paramInt >= this._externSheetRecord.getNumOfRefs() || paramInt < 0) {
/* 476 */       return -1;
/*     */     }
/* 478 */     return this._externSheetRecord.getFirstSheetIndexFromRefIndex(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastInternalSheetIndexForExtIndex(int paramInt) {
/* 485 */     if (paramInt >= this._externSheetRecord.getNumOfRefs() || paramInt < 0) {
/* 486 */       return -1;
/*     */     }
/* 488 */     return this._externSheetRecord.getLastSheetIndexFromRefIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void removeSheet(int paramInt) {
/* 492 */     this._externSheetRecord.removeSheet(paramInt);
/*     */   }
/*     */   
/*     */   public int checkExternSheet(int paramInt) {
/* 496 */     return checkExternSheet(paramInt, paramInt);
/*     */   }
/*     */   public int checkExternSheet(int paramInt1, int paramInt2) {
/* 499 */     int i = -1; int j;
/* 500 */     for (j = 0; j < this._externalBookBlocks.length; j++) {
/* 501 */       SupBookRecord supBookRecord = this._externalBookBlocks[j].getExternalBookRecord();
/* 502 */       if (supBookRecord.isInternalReferences()) {
/* 503 */         i = j;
/*     */         break;
/*     */       } 
/*     */     } 
/* 507 */     if (i < 0) {
/* 508 */       throw new RuntimeException("Could not find 'internal references' EXTERNALBOOK");
/*     */     }
/*     */ 
/*     */     
/* 512 */     j = this._externSheetRecord.getRefIxForSheet(i, paramInt1, paramInt2);
/* 513 */     if (j >= 0) {
/* 514 */       return j;
/*     */     }
/*     */     
/* 517 */     return this._externSheetRecord.addRef(i, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int findFirstRecordLocBySid(short paramShort) {
/* 524 */     byte b = 0;
/* 525 */     for (Record record : this._workbookRecordList) {
/*     */ 
/*     */       
/* 528 */       if (record.getSid() == paramShort) {
/* 529 */         return b;
/*     */       }
/* 531 */       b++;
/*     */     } 
/* 533 */     return -1;
/*     */   }
/*     */   
/*     */   public String resolveNameXText(int paramInt1, int paramInt2, InternalWorkbook paramInternalWorkbook) {
/* 537 */     int i = this._externSheetRecord.getExtbookIndexFromRefIndex(paramInt1);
/* 538 */     int j = this._externSheetRecord.getFirstSheetIndexFromRefIndex(paramInt1);
/* 539 */     if (j == -1)
/*     */     {
/* 541 */       throw new RuntimeException("Referenced sheet could not be found");
/*     */     }
/*     */ 
/*     */     
/* 545 */     ExternalBookBlock externalBookBlock = this._externalBookBlocks[i];
/* 546 */     if (externalBookBlock._externalNameRecords.length > paramInt2)
/* 547 */       return this._externalBookBlocks[i].getNameText(paramInt2); 
/* 548 */     if (j == -2) {
/*     */       
/* 550 */       NameRecord nameRecord = getNameRecord(paramInt2);
/* 551 */       int k = nameRecord.getSheetNumber();
/*     */       
/* 553 */       StringBuffer stringBuffer = new StringBuffer();
/* 554 */       if (k > 0) {
/* 555 */         String str = paramInternalWorkbook.getSheetName(k - 1);
/* 556 */         SheetNameFormatter.appendFormat(stringBuffer, str);
/* 557 */         stringBuffer.append("!");
/*     */       } 
/* 559 */       stringBuffer.append(nameRecord.getNameText());
/* 560 */       return stringBuffer.toString();
/*     */     } 
/* 562 */     throw new ArrayIndexOutOfBoundsException("Ext Book Index relative but beyond the supported length, was " + i + " but maximum is " + this._externalBookBlocks.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int resolveNameXIx(int paramInt1, int paramInt2) {
/* 569 */     int i = this._externSheetRecord.getExtbookIndexFromRefIndex(paramInt1);
/* 570 */     return this._externalBookBlocks[i].getNameIx(paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameXPtg getNameXPtg(String paramString, int paramInt) {
/* 581 */     for (byte b = 0; b < this._externalBookBlocks.length; b++) {
/* 582 */       int i = this._externalBookBlocks[b].getIndexOfName(paramString);
/* 583 */       if (i >= 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 588 */         int j = findRefIndexFromExtBookIndex(b);
/* 589 */         if (j >= 0)
/*     */         {
/* 591 */           if (paramInt == -1 || j == paramInt)
/* 592 */             return new NameXPtg(j, i); 
/*     */         }
/*     */       } 
/*     */     } 
/* 596 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameXPtg addNameXPtg(String paramString) {
/* 606 */     int i = -1;
/* 607 */     ExternalBookBlock externalBookBlock = null;
/*     */     
/*     */     int j;
/* 610 */     for (j = 0; j < this._externalBookBlocks.length; j++) {
/* 611 */       SupBookRecord supBookRecord = this._externalBookBlocks[j].getExternalBookRecord();
/* 612 */       if (supBookRecord.isAddInFunctions()) {
/* 613 */         externalBookBlock = this._externalBookBlocks[j];
/* 614 */         i = j;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 619 */     if (externalBookBlock == null) {
/* 620 */       externalBookBlock = new ExternalBookBlock();
/* 621 */       i = extendExternalBookBlocks(externalBookBlock);
/*     */ 
/*     */       
/* 624 */       j = findFirstRecordLocBySid((short)23);
/* 625 */       this._workbookRecordList.add(j, (Record)externalBookBlock.getExternalBookRecord());
/*     */ 
/*     */ 
/*     */       
/* 629 */       this._externSheetRecord.addRef(this._externalBookBlocks.length - 1, -2, -2);
/*     */     } 
/*     */ 
/*     */     
/* 633 */     ExternalNameRecord externalNameRecord = new ExternalNameRecord();
/* 634 */     externalNameRecord.setText(paramString);
/*     */     
/* 636 */     externalNameRecord.setParsedExpression(new Ptg[] { (Ptg)ErrPtg.REF_INVALID });
/*     */     
/* 638 */     int k = externalBookBlock.addExternalName(externalNameRecord);
/* 639 */     byte b = 0;
/*     */ 
/*     */     
/* 642 */     for (Record record : this._workbookRecordList) {
/*     */       
/* 644 */       if (record instanceof SupBookRecord && (
/* 645 */         (SupBookRecord)record).isAddInFunctions())
/*     */         break;  b++;
/*     */     } 
/* 648 */     int m = externalBookBlock.getNumberOfNames();
/*     */     
/* 650 */     this._workbookRecordList.add(b + m, (Record)externalNameRecord);
/* 651 */     byte b1 = -2;
/* 652 */     int n = this._externSheetRecord.getRefIxForSheet(i, b1, b1);
/* 653 */     return new NameXPtg(n, k);
/*     */   }
/*     */   private int extendExternalBookBlocks(ExternalBookBlock paramExternalBookBlock) {
/* 656 */     ExternalBookBlock[] arrayOfExternalBookBlock = new ExternalBookBlock[this._externalBookBlocks.length + 1];
/* 657 */     System.arraycopy(this._externalBookBlocks, 0, arrayOfExternalBookBlock, 0, this._externalBookBlocks.length);
/* 658 */     arrayOfExternalBookBlock[arrayOfExternalBookBlock.length - 1] = paramExternalBookBlock;
/* 659 */     this._externalBookBlocks = arrayOfExternalBookBlock;
/*     */     
/* 661 */     return this._externalBookBlocks.length - 1;
/*     */   }
/*     */   
/*     */   private int findRefIndexFromExtBookIndex(int paramInt) {
/* 665 */     return this._externSheetRecord.findRefIndexFromExtBookIndex(paramInt);
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
/*     */   public boolean changeExternalReference(String paramString1, String paramString2) {
/* 678 */     for (ExternalBookBlock externalBookBlock : this._externalBookBlocks) {
/* 679 */       SupBookRecord supBookRecord = externalBookBlock.getExternalBookRecord();
/* 680 */       if (supBookRecord.isExternalReferences() && supBookRecord.getURL().equals(paramString1)) {
/*     */ 
/*     */         
/* 683 */         supBookRecord.setURL(paramString2);
/* 684 */         return true;
/*     */       } 
/*     */     } 
/* 687 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\model\LinkTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */