/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8RC4Key;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8XORKey;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RecordFactoryInputStream
/*     */ {
/*     */   private final RecordInputStream _recStream;
/*     */   private final boolean _shouldIncludeContinueRecords;
/*     */   private Record[] _unreadRecordBuffer;
/*     */   
/*     */   private static final class StreamEncryptionInfo
/*     */   {
/*     */     private final int _initialRecordsSize;
/*     */     private final FilePassRecord _filePassRec;
/*     */     private final Record _lastRecord;
/*     */     private final boolean _hasBOFRecord;
/*     */     
/*     */     public StreamEncryptionInfo(RecordInputStream param1RecordInputStream, List<Record> param1List) {
/*  58 */       param1RecordInputStream.nextRecord();
/*  59 */       int i = 4 + param1RecordInputStream.remaining();
/*  60 */       Record record = RecordFactory.createSingleRecord(param1RecordInputStream);
/*  61 */       param1List.add(record);
/*  62 */       FilePassRecord filePassRecord = null;
/*  63 */       if (record instanceof BOFRecord) {
/*  64 */         this._hasBOFRecord = true;
/*     */ 
/*     */ 
/*     */         
/*  68 */         if (param1RecordInputStream.hasNextRecord()) {
/*  69 */           param1RecordInputStream.nextRecord();
/*  70 */           record = RecordFactory.createSingleRecord(param1RecordInputStream);
/*  71 */           i += record.getRecordSize();
/*  72 */           param1List.add(record);
/*     */ 
/*     */ 
/*     */           
/*  76 */           if (record instanceof WriteProtectRecord && param1RecordInputStream.hasNextRecord()) {
/*  77 */             param1RecordInputStream.nextRecord();
/*  78 */             record = RecordFactory.createSingleRecord(param1RecordInputStream);
/*  79 */             i += record.getRecordSize();
/*  80 */             param1List.add(record);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  85 */           if (record instanceof FilePassRecord) {
/*  86 */             filePassRecord = (FilePassRecord)record;
/*  87 */             param1List.remove(param1List.size() - 1);
/*     */             
/*  89 */             record = param1List.get(0);
/*     */           
/*     */           }
/*  92 */           else if (record instanceof EOFRecord) {
/*     */ 
/*     */             
/*  95 */             throw new IllegalStateException("Nothing between BOF and EOF");
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 103 */         this._hasBOFRecord = false;
/*     */       } 
/* 105 */       this._initialRecordsSize = i;
/* 106 */       this._filePassRec = filePassRecord;
/* 107 */       this._lastRecord = record;
/*     */     }
/*     */     public RecordInputStream createDecryptingStream(InputStream param1InputStream) {
/*     */       Biff8XORKey biff8XORKey;
/* 111 */       FilePassRecord filePassRecord = this._filePassRec;
/* 112 */       String str = Biff8EncryptionKey.getCurrentUserPassword();
/* 113 */       if (str == null) {
/* 114 */         str = "VelvetSweatshop";
/*     */       }
/*     */ 
/*     */       
/* 118 */       if (filePassRecord.getRc4KeyData() != null) {
/* 119 */         FilePassRecord.Rc4KeyData rc4KeyData = filePassRecord.getRc4KeyData();
/* 120 */         Biff8RC4Key biff8RC4Key2 = Biff8RC4Key.create(str, rc4KeyData.getSalt());
/* 121 */         Biff8RC4Key biff8RC4Key1 = biff8RC4Key2;
/* 122 */         if (!biff8RC4Key2.validate(rc4KeyData.getEncryptedVerifier(), rc4KeyData.getEncryptedVerifierHash())) {
/* 123 */           throw new EncryptedDocumentException(("VelvetSweatshop".equals(str) ? "Default" : "Supplied") + " password is invalid for salt/verifier/verifierHash");
/*     */         
/*     */         }
/*     */       }
/* 127 */       else if (filePassRecord.getXorKeyData() != null) {
/* 128 */         FilePassRecord.XorKeyData xorKeyData = filePassRecord.getXorKeyData();
/* 129 */         Biff8XORKey biff8XORKey1 = Biff8XORKey.create(str, xorKeyData.getKey());
/* 130 */         biff8XORKey = biff8XORKey1;
/*     */         
/* 132 */         if (!biff8XORKey1.validate(str, xorKeyData.getVerifier())) {
/* 133 */           throw new EncryptedDocumentException(("VelvetSweatshop".equals(str) ? "Default" : "Supplied") + " password is invalid for key/verifier");
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 138 */         throw new EncryptedDocumentException("Crypto API not yet supported.");
/*     */       } 
/*     */       
/* 141 */       return new RecordInputStream(param1InputStream, (Biff8EncryptionKey)biff8XORKey, this._initialRecordsSize);
/*     */     }
/*     */     
/*     */     public boolean hasEncryption() {
/* 145 */       return (this._filePassRec != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Record getLastRecord() {
/* 154 */       return this._lastRecord;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasBOFRecord() {
/* 161 */       return this._hasBOFRecord;
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
/*     */ 
/*     */   
/* 179 */   private int _unreadRecordIndex = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 184 */   private Record _lastRecord = null;
/*     */ 
/*     */ 
/*     */   
/* 188 */   private DrawingRecord _lastDrawingRecord = new DrawingRecord();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int _bofDepth;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _lastRecordWasEOFLevelZero;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RecordFactoryInputStream(InputStream paramInputStream, boolean paramBoolean) {
/* 203 */     RecordInputStream recordInputStream = new RecordInputStream(paramInputStream);
/* 204 */     ArrayList<Record> arrayList = new ArrayList();
/* 205 */     StreamEncryptionInfo streamEncryptionInfo = new StreamEncryptionInfo(recordInputStream, arrayList);
/* 206 */     if (streamEncryptionInfo.hasEncryption()) {
/* 207 */       recordInputStream = streamEncryptionInfo.createDecryptingStream(paramInputStream);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 212 */     if (!arrayList.isEmpty()) {
/* 213 */       this._unreadRecordBuffer = new Record[arrayList.size()];
/* 214 */       arrayList.toArray(this._unreadRecordBuffer);
/* 215 */       this._unreadRecordIndex = 0;
/*     */     } 
/* 217 */     this._recStream = recordInputStream;
/* 218 */     this._shouldIncludeContinueRecords = paramBoolean;
/* 219 */     this._lastRecord = streamEncryptionInfo.getLastRecord();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     this._bofDepth = streamEncryptionInfo.hasBOFRecord() ? 1 : 0;
/* 239 */     this._lastRecordWasEOFLevelZero = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Record nextRecord() {
/* 247 */     Record record = getNextUnreadRecord();
/* 248 */     if (record != null)
/*     */     {
/* 250 */       return record;
/*     */     }
/*     */     while (true) {
/* 253 */       if (!this._recStream.hasNextRecord())
/*     */       {
/* 255 */         return null;
/*     */       }
/*     */       
/* 258 */       if (this._lastRecordWasEOFLevelZero)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 264 */         if (this._recStream.getNextSid() != 2057) {
/* 265 */           return null;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 271 */       this._recStream.nextRecord();
/*     */       
/* 273 */       record = readNextRecord();
/* 274 */       if (record == null)
/*     */         continue; 
/*     */       break;
/*     */     } 
/* 278 */     return record;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Record getNextUnreadRecord() {
/* 287 */     if (this._unreadRecordBuffer != null) {
/* 288 */       int i = this._unreadRecordIndex;
/* 289 */       if (i < this._unreadRecordBuffer.length) {
/* 290 */         Record record = this._unreadRecordBuffer[i];
/* 291 */         this._unreadRecordIndex = i + 1;
/* 292 */         return record;
/*     */       } 
/* 294 */       this._unreadRecordIndex = -1;
/* 295 */       this._unreadRecordBuffer = null;
/*     */     } 
/* 297 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Record readNextRecord() {
/* 307 */     Record record = RecordFactory.createSingleRecord(this._recStream);
/* 308 */     this._lastRecordWasEOFLevelZero = false;
/*     */     
/* 310 */     if (record instanceof BOFRecord) {
/* 311 */       this._bofDepth++;
/* 312 */       return record;
/*     */     } 
/*     */     
/* 315 */     if (record instanceof EOFRecord) {
/* 316 */       this._bofDepth--;
/* 317 */       if (this._bofDepth < 1) {
/* 318 */         this._lastRecordWasEOFLevelZero = true;
/*     */       }
/*     */       
/* 321 */       return record;
/*     */     } 
/*     */     
/* 324 */     if (record instanceof DBCellRecord)
/*     */     {
/* 326 */       return null;
/*     */     }
/*     */     
/* 329 */     if (record instanceof RKRecord) {
/* 330 */       return RecordFactory.convertToNumberRecord((RKRecord)record);
/*     */     }
/*     */     
/* 333 */     if (record instanceof MulRKRecord) {
/* 334 */       NumberRecord[] arrayOfNumberRecord = RecordFactory.convertRKRecords((MulRKRecord)record);
/*     */       
/* 336 */       this._unreadRecordBuffer = (Record[])arrayOfNumberRecord;
/* 337 */       this._unreadRecordIndex = 1;
/* 338 */       return arrayOfNumberRecord[0];
/*     */     } 
/*     */     
/* 341 */     if (record.getSid() == 235 && this._lastRecord instanceof DrawingGroupRecord) {
/*     */       
/* 343 */       DrawingGroupRecord drawingGroupRecord = (DrawingGroupRecord)this._lastRecord;
/* 344 */       drawingGroupRecord.join((AbstractEscherHolderRecord)record);
/* 345 */       return null;
/*     */     } 
/* 347 */     if (record.getSid() == 60) {
/* 348 */       ContinueRecord continueRecord = (ContinueRecord)record;
/*     */       
/* 350 */       if (this._lastRecord instanceof ObjRecord || this._lastRecord instanceof TextObjectRecord) {
/*     */ 
/*     */         
/* 353 */         this._lastDrawingRecord.processContinueRecord(continueRecord.getData());
/*     */ 
/*     */         
/* 356 */         if (this._shouldIncludeContinueRecords) {
/* 357 */           return record;
/*     */         }
/* 359 */         return null;
/*     */       } 
/* 361 */       if (this._lastRecord instanceof DrawingGroupRecord) {
/* 362 */         ((DrawingGroupRecord)this._lastRecord).processContinueRecord(continueRecord.getData());
/* 363 */         return null;
/*     */       } 
/* 365 */       if (this._lastRecord instanceof DrawingRecord)
/*     */       {
/* 367 */         return continueRecord;
/*     */       }
/* 369 */       if (this._lastRecord instanceof UnknownRecord)
/*     */       {
/*     */         
/* 372 */         return record;
/*     */       }
/* 374 */       if (this._lastRecord instanceof EOFRecord)
/*     */       {
/*     */         
/* 377 */         return record;
/*     */       }
/* 379 */       throw new RecordFormatException("Unhandled Continue Record followining " + this._lastRecord.getClass());
/*     */     } 
/* 381 */     this._lastRecord = record;
/* 382 */     if (record instanceof DrawingRecord) {
/* 383 */       this._lastDrawingRecord = (DrawingRecord)record;
/*     */     }
/* 385 */     return record;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RecordFactoryInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */