/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import org.h2.compress.CompressLZF;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.RowFactory;
/*     */ import org.h2.util.BitField;
/*     */ import org.h2.util.IntArray;
/*     */ import org.h2.util.IntIntHashMap;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PageLog
/*     */ {
/*     */   public static final int NOOP = 0;
/*     */   public static final int UNDO = 1;
/*     */   public static final int COMMIT = 2;
/*     */   public static final int PREPARE_COMMIT = 3;
/*     */   public static final int ROLLBACK = 4;
/*     */   public static final int ADD = 5;
/*     */   public static final int REMOVE = 6;
/*     */   public static final int TRUNCATE = 7;
/*     */   public static final int CHECKPOINT = 8;
/*     */   public static final int FREE_LOG = 9;
/*     */   static final int RECOVERY_STAGE_UNDO = 0;
/*     */   static final int RECOVERY_STAGE_ALLOCATE = 1;
/*     */   static final int RECOVERY_STAGE_REDO = 2;
/*     */   private static final boolean COMPRESS_UNDO = true;
/*     */   private final PageStore store;
/*     */   private final Trace trace;
/*     */   private Data writeBuffer;
/*     */   private PageOutputStream pageOut;
/*     */   private int firstTrunkPage;
/*     */   private int firstDataPage;
/*     */   private final Data dataBuffer;
/*     */   private int logKey;
/*     */   private int logSectionId;
/*     */   private int logPos;
/*     */   private int firstSectionId;
/*     */   private final CompressLZF compress;
/*     */   private final byte[] compressBuffer;
/* 135 */   private BitField undo = new BitField();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 141 */   private final BitField undoAll = new BitField();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   private final IntIntHashMap logSectionPageMap = new IntIntHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 153 */   private HashMap<Integer, SessionState> sessionStates = New.hashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   private BitField usedLogPages;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean freeing;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PageLog(PageStore paramPageStore) {
/* 167 */     this.store = paramPageStore;
/* 168 */     this.dataBuffer = paramPageStore.createData();
/* 169 */     this.trace = paramPageStore.getTrace();
/* 170 */     this.compress = new CompressLZF();
/* 171 */     this.compressBuffer = new byte[paramPageStore.getPageSize() * 2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void openForWriting(int paramInt, boolean paramBoolean) {
/* 182 */     this.trace.debug("log openForWriting firstPage: " + paramInt);
/* 183 */     this.firstTrunkPage = paramInt;
/* 184 */     this.logKey++;
/* 185 */     this.pageOut = new PageOutputStream(this.store, paramInt, this.undoAll, this.logKey, paramBoolean);
/*     */     
/* 187 */     this.pageOut.reserve(1);
/*     */     
/* 189 */     this.store.setLogFirstPage(this.logKey, paramInt, this.pageOut.getCurrentDataPageId());
/*     */     
/* 191 */     this.writeBuffer = this.store.createData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void free() {
/* 198 */     if (this.trace.isDebugEnabled()) {
/* 199 */       this.trace.debug("log free");
/*     */     }
/* 201 */     int i = 0;
/* 202 */     if (this.pageOut != null) {
/* 203 */       i = this.pageOut.getCurrentDataPageId();
/* 204 */       this.pageOut.freeReserved();
/*     */     } 
/*     */     try {
/* 207 */       this.freeing = true;
/* 208 */       int j = 0;
/* 209 */       int k = 1024; byte b = 0;
/* 210 */       PageStreamTrunk.Iterator iterator = new PageStreamTrunk.Iterator(this.store, this.firstTrunkPage);
/*     */       
/* 212 */       while (this.firstTrunkPage != 0 && this.firstTrunkPage < this.store.getPageCount()) {
/* 213 */         PageStreamTrunk pageStreamTrunk = iterator.next();
/* 214 */         if (pageStreamTrunk == null) {
/* 215 */           if (iterator.canDelete()) {
/* 216 */             this.store.free(this.firstTrunkPage, false);
/*     */           }
/*     */           break;
/*     */         } 
/* 220 */         if (b++ >= k) {
/* 221 */           j = pageStreamTrunk.getPos();
/* 222 */           b = 0;
/* 223 */           k *= 2;
/* 224 */         } else if (j != 0 && j == pageStreamTrunk.getPos()) {
/* 225 */           throw DbException.throwInternalError("endless loop at " + pageStreamTrunk);
/*     */         } 
/*     */         
/* 228 */         pageStreamTrunk.free(i);
/* 229 */         this.firstTrunkPage = pageStreamTrunk.getNextTrunk();
/*     */       } 
/*     */     } finally {
/* 232 */       this.freeing = false;
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
/*     */   void openForReading(int paramInt1, int paramInt2, int paramInt3) {
/* 245 */     this.logKey = paramInt1;
/* 246 */     this.firstTrunkPage = paramInt2;
/* 247 */     this.firstDataPage = paramInt3;
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
/*     */   boolean recover(int paramInt) {
/* 260 */     if (this.trace.isDebugEnabled()) {
/* 261 */       this.trace.debug("log recover stage: " + paramInt);
/*     */     }
/* 263 */     if (paramInt == 1) {
/* 264 */       PageInputStream pageInputStream1 = new PageInputStream(this.store, this.logKey, this.firstTrunkPage, this.firstDataPage);
/*     */       
/* 266 */       this.usedLogPages = pageInputStream1.allocateAllPages();
/* 267 */       pageInputStream1.close();
/* 268 */       return true;
/*     */     } 
/* 270 */     PageInputStream pageInputStream = new PageInputStream(this.store, this.logKey, this.firstTrunkPage, this.firstDataPage);
/*     */     
/* 272 */     DataReader dataReader = new DataReader(pageInputStream);
/* 273 */     byte b = 0;
/* 274 */     Data data = this.store.createData();
/* 275 */     boolean bool = true;
/*     */     try {
/* 277 */       byte b1 = 0;
/*     */       while (true) {
/* 279 */         byte b2 = dataReader.readByte();
/* 280 */         if (b2 < 0) {
/*     */           break;
/*     */         }
/* 283 */         b1++;
/* 284 */         bool = false;
/* 285 */         if (b2 == 1) {
/* 286 */           int i = dataReader.readVarInt();
/* 287 */           int j = dataReader.readVarInt();
/* 288 */           if (j == 0) {
/* 289 */             dataReader.readFully(data.getBytes(), this.store.getPageSize());
/* 290 */           } else if (j == 1) {
/*     */             
/* 292 */             Arrays.fill(data.getBytes(), 0, this.store.getPageSize(), (byte)0);
/*     */           } else {
/* 294 */             dataReader.readFully(this.compressBuffer, j);
/*     */             try {
/* 296 */               this.compress.expand(this.compressBuffer, 0, j, data.getBytes(), 0, this.store.getPageSize());
/*     */             }
/* 298 */             catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 299 */               DbException.convertToIOException(arrayIndexOutOfBoundsException);
/*     */             } 
/*     */           } 
/* 302 */           if (paramInt == 0) {
/* 303 */             if (!this.undo.get(i)) {
/* 304 */               if (this.trace.isDebugEnabled()) {
/* 305 */                 this.trace.debug("log undo {0}", new Object[] { Integer.valueOf(i) });
/*     */               }
/* 307 */               this.store.writePage(i, data);
/* 308 */               this.undo.set(i);
/* 309 */               this.undoAll.set(i); continue;
/*     */             } 
/* 311 */             if (this.trace.isDebugEnabled())
/* 312 */               this.trace.debug("log undo skip {0}", new Object[] { Integer.valueOf(i) }); 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 316 */         if (b2 == 5) {
/* 317 */           int i = dataReader.readVarInt();
/* 318 */           int j = dataReader.readVarInt();
/* 319 */           Row row = readRow(this.store.getDatabase().getRowFactory(), dataReader, data);
/* 320 */           if (paramInt == 0) {
/* 321 */             this.store.allocateIfIndexRoot(b1, j, row); continue;
/* 322 */           }  if (paramInt == 2) {
/* 323 */             if (isSessionCommitted(i, b, b1)) {
/* 324 */               if (this.trace.isDebugEnabled()) {
/* 325 */                 this.trace.debug("log redo + table: " + j + " s: " + i + " " + row);
/*     */               }
/*     */               
/* 328 */               this.store.redo(j, row, true); continue;
/*     */             } 
/* 330 */             if (this.trace.isDebugEnabled()) {
/* 331 */               this.trace.debug("log ignore s: " + i + " + table: " + j + " " + row);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         } 
/* 336 */         if (b2 == 6) {
/* 337 */           int i = dataReader.readVarInt();
/* 338 */           int j = dataReader.readVarInt();
/* 339 */           long l = dataReader.readVarLong();
/* 340 */           if (paramInt == 2) {
/* 341 */             if (isSessionCommitted(i, b, b1)) {
/* 342 */               if (this.trace.isDebugEnabled()) {
/* 343 */                 this.trace.debug("log redo - table: " + j + " s:" + i + " key: " + l);
/*     */               }
/*     */               
/* 346 */               this.store.redoDelete(j, l); continue;
/*     */             } 
/* 348 */             if (this.trace.isDebugEnabled()) {
/* 349 */               this.trace.debug("log ignore s: " + i + " - table: " + j + " " + l);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         } 
/* 354 */         if (b2 == 7) {
/* 355 */           int i = dataReader.readVarInt();
/* 356 */           int j = dataReader.readVarInt();
/* 357 */           if (paramInt == 2) {
/* 358 */             if (isSessionCommitted(i, b, b1)) {
/* 359 */               if (this.trace.isDebugEnabled()) {
/* 360 */                 this.trace.debug("log redo truncate table: " + j);
/*     */               }
/* 362 */               this.store.redoTruncate(j); continue;
/*     */             } 
/* 364 */             if (this.trace.isDebugEnabled()) {
/* 365 */               this.trace.debug("log ignore s: " + i + " truncate table: " + j);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         } 
/* 370 */         if (b2 == 3) {
/* 371 */           int i = dataReader.readVarInt();
/* 372 */           String str = dataReader.readString();
/* 373 */           if (this.trace.isDebugEnabled()) {
/* 374 */             this.trace.debug("log prepare commit " + i + " " + str + " pos: " + b1);
/*     */           }
/*     */           
/* 377 */           if (paramInt == 0) {
/* 378 */             int j = pageInputStream.getDataPage();
/* 379 */             setPrepareCommit(i, j, str);
/*     */           }  continue;
/* 381 */         }  if (b2 == 4) {
/* 382 */           int i = dataReader.readVarInt();
/* 383 */           if (this.trace.isDebugEnabled())
/* 384 */             this.trace.debug("log rollback " + i + " pos: " + b1); 
/*     */           continue;
/*     */         } 
/* 387 */         if (b2 == 2) {
/* 388 */           int i = dataReader.readVarInt();
/* 389 */           if (this.trace.isDebugEnabled()) {
/* 390 */             this.trace.debug("log commit " + i + " pos: " + b1);
/*     */           }
/* 392 */           if (paramInt == 0)
/* 393 */             setLastCommitForSession(i, b, b1);  continue;
/*     */         } 
/* 395 */         if (b2 == 0)
/*     */           continue; 
/* 397 */         if (b2 == 8) {
/* 398 */           b++; continue;
/* 399 */         }  if (b2 == 9) {
/* 400 */           int i = dataReader.readVarInt();
/* 401 */           for (byte b3 = 0; b3 < i; b3++) {
/* 402 */             int j = dataReader.readVarInt();
/* 403 */             if (paramInt == 2 && 
/* 404 */               !this.usedLogPages.get(j)) {
/* 405 */               this.store.free(j, false);
/*     */             }
/*     */           } 
/*     */           continue;
/*     */         } 
/* 410 */         if (this.trace.isDebugEnabled()) {
/* 411 */           this.trace.debug("log end");
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 416 */     } catch (DbException dbException) {
/* 417 */       if (dbException.getErrorCode() == 90030) {
/* 418 */         this.trace.debug("log recovery stopped");
/*     */       } else {
/* 420 */         throw dbException;
/*     */       } 
/* 422 */     } catch (IOException iOException) {
/* 423 */       this.trace.debug("log recovery completed");
/*     */     } 
/* 425 */     this.undo = new BitField();
/* 426 */     if (paramInt == 2) {
/* 427 */       this.usedLogPages = null;
/*     */     }
/* 429 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setPrepareCommit(int paramInt1, int paramInt2, String paramString) {
/*     */     PageStoreInDoubtTransaction pageStoreInDoubtTransaction;
/* 441 */     SessionState sessionState = getOrAddSessionState(paramInt1);
/*     */     
/* 443 */     if (paramString == null) {
/* 444 */       pageStoreInDoubtTransaction = null;
/*     */     } else {
/* 446 */       pageStoreInDoubtTransaction = new PageStoreInDoubtTransaction(this.store, paramInt1, paramInt2, paramString);
/*     */     } 
/*     */     
/* 449 */     sessionState.inDoubtTransaction = pageStoreInDoubtTransaction;
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
/*     */   public static Row readRow(RowFactory paramRowFactory, DataReader paramDataReader, Data paramData) throws IOException {
/* 461 */     long l = paramDataReader.readVarLong();
/* 462 */     int i = paramDataReader.readVarInt();
/* 463 */     paramData.reset();
/* 464 */     paramData.checkCapacity(i);
/* 465 */     paramDataReader.readFully(paramData.getBytes(), i);
/* 466 */     int j = paramData.readVarInt();
/* 467 */     Value[] arrayOfValue = new Value[j];
/* 468 */     for (byte b = 0; b < j; b++) {
/* 469 */       arrayOfValue[b] = paramData.readValue();
/*     */     }
/* 471 */     Row row = paramRowFactory.createRow(arrayOfValue, -1);
/* 472 */     row.setKey(l);
/* 473 */     return row;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean getUndo(int paramInt) {
/* 483 */     return this.undo.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addUndo(int paramInt, Data paramData) {
/* 494 */     if (this.undo.get(paramInt) || this.freeing) {
/*     */       return;
/*     */     }
/* 497 */     if (this.trace.isDebugEnabled()) {
/* 498 */       this.trace.debug("log undo " + paramInt);
/*     */     }
/* 500 */     if (SysProperties.CHECK && 
/* 501 */       paramData == null) {
/* 502 */       DbException.throwInternalError("Undo entry not written");
/*     */     }
/*     */     
/* 505 */     this.undo.set(paramInt);
/* 506 */     this.undoAll.set(paramInt);
/* 507 */     Data data = getBuffer();
/* 508 */     data.writeByte((byte)1);
/* 509 */     data.writeVarInt(paramInt);
/* 510 */     if (paramData.getBytes()[0] == 0) {
/* 511 */       data.writeVarInt(1);
/*     */     } else {
/* 513 */       int i = this.store.getPageSize();
/*     */       
/* 515 */       int j = this.compress.compress(paramData.getBytes(), i, this.compressBuffer, 0);
/*     */       
/* 517 */       if (j < i) {
/* 518 */         data.writeVarInt(j);
/* 519 */         data.checkCapacity(j);
/* 520 */         data.write(this.compressBuffer, 0, j);
/*     */       } else {
/* 522 */         data.writeVarInt(0);
/* 523 */         data.checkCapacity(i);
/* 524 */         data.write(paramData.getBytes(), 0, i);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 532 */     write(data);
/*     */   }
/*     */   
/*     */   private void freeLogPages(IntArray paramIntArray) {
/* 536 */     if (this.trace.isDebugEnabled()) {
/* 537 */       this.trace.debug("log frees " + paramIntArray.get(0) + ".." + paramIntArray.get(paramIntArray.size() - 1));
/*     */     }
/*     */     
/* 540 */     Data data = getBuffer();
/* 541 */     data.writeByte((byte)9);
/* 542 */     int i = paramIntArray.size();
/* 543 */     data.writeVarInt(i);
/* 544 */     for (byte b = 0; b < i; b++) {
/* 545 */       data.writeVarInt(paramIntArray.get(b));
/*     */     }
/* 547 */     write(data);
/*     */   }
/*     */   
/*     */   private void write(Data paramData) {
/* 551 */     this.pageOut.write(paramData.getBytes(), 0, paramData.length());
/* 552 */     paramData.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void commit(int paramInt) {
/* 561 */     if (this.trace.isDebugEnabled()) {
/* 562 */       this.trace.debug("log commit s: " + paramInt);
/*     */     }
/* 564 */     if (this.store.getDatabase().getPageStore() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 568 */     Data data = getBuffer();
/* 569 */     data.writeByte((byte)2);
/* 570 */     data.writeVarInt(paramInt);
/* 571 */     write(data);
/* 572 */     if (this.store.getDatabase().getFlushOnEachCommit()) {
/* 573 */       flush();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void prepareCommit(Session paramSession, String paramString) {
/* 584 */     if (this.trace.isDebugEnabled()) {
/* 585 */       this.trace.debug("log prepare commit s: " + paramSession.getId() + ", " + paramString);
/*     */     }
/* 587 */     if (this.store.getDatabase().getPageStore() == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 592 */     int i = this.store.getPageSize();
/* 593 */     this.pageOut.flush();
/* 594 */     this.pageOut.fillPage();
/* 595 */     Data data = getBuffer();
/* 596 */     data.writeByte((byte)3);
/* 597 */     data.writeVarInt(paramSession.getId());
/* 598 */     data.writeString(paramString);
/* 599 */     if (data.length() >= PageStreamData.getCapacity(i)) {
/* 600 */       throw DbException.getInvalidValueException("transaction name (too long)", paramString);
/*     */     }
/*     */     
/* 603 */     write(data);
/*     */     
/* 605 */     flushOut();
/* 606 */     this.pageOut.fillPage();
/* 607 */     if (this.store.getDatabase().getFlushOnEachCommit()) {
/* 608 */       flush();
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
/*     */   void logAddOrRemoveRow(Session paramSession, int paramInt, Row paramRow, boolean paramBoolean) {
/* 621 */     if (this.trace.isDebugEnabled()) {
/* 622 */       this.trace.debug("log " + (paramBoolean ? "+" : "-") + " s: " + paramSession.getId() + " table: " + paramInt + " row: " + paramRow);
/*     */     }
/*     */     
/* 625 */     paramSession.addLogPos(this.logSectionId, this.logPos);
/* 626 */     this.logPos++;
/* 627 */     Data data1 = this.dataBuffer;
/* 628 */     data1.reset();
/* 629 */     int i = paramRow.getColumnCount();
/* 630 */     data1.writeVarInt(i);
/* 631 */     data1.checkCapacity(paramRow.getByteCount(data1));
/* 632 */     if (paramSession.isRedoLogBinaryEnabled()) {
/* 633 */       for (byte b = 0; b < i; b++) {
/* 634 */         data1.writeValue(paramRow.getValue(b));
/*     */       }
/*     */     } else {
/* 637 */       for (byte b = 0; b < i; b++) {
/* 638 */         Value value = paramRow.getValue(b);
/* 639 */         if (value.getType() == 12) {
/* 640 */           data1.writeValue((Value)ValueNull.INSTANCE);
/*     */         } else {
/* 642 */           data1.writeValue(value);
/*     */         } 
/*     */       } 
/*     */     } 
/* 646 */     Data data2 = getBuffer();
/* 647 */     data2.writeByte((byte)(paramBoolean ? 5 : 6));
/* 648 */     data2.writeVarInt(paramSession.getId());
/* 649 */     data2.writeVarInt(paramInt);
/* 650 */     data2.writeVarLong(paramRow.getKey());
/* 651 */     if (paramBoolean) {
/* 652 */       data2.writeVarInt(data1.length());
/* 653 */       data2.checkCapacity(data1.length());
/* 654 */       data2.write(data1.getBytes(), 0, data1.length());
/*     */     } 
/* 656 */     write(data2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void logTruncate(Session paramSession, int paramInt) {
/* 666 */     if (this.trace.isDebugEnabled()) {
/* 667 */       this.trace.debug("log truncate s: " + paramSession.getId() + " table: " + paramInt);
/*     */     }
/* 669 */     paramSession.addLogPos(this.logSectionId, this.logPos);
/* 670 */     this.logPos++;
/* 671 */     Data data = getBuffer();
/* 672 */     data.writeByte((byte)7);
/* 673 */     data.writeVarInt(paramSession.getId());
/* 674 */     data.writeVarInt(paramInt);
/* 675 */     write(data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void flush() {
/* 682 */     if (this.pageOut != null) {
/* 683 */       flushOut();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void checkpoint() {
/* 691 */     Data data = getBuffer();
/* 692 */     data.writeByte((byte)8);
/* 693 */     write(data);
/* 694 */     this.undo = new BitField();
/* 695 */     this.logSectionId++;
/* 696 */     this.logPos = 0;
/* 697 */     this.pageOut.flush();
/* 698 */     this.pageOut.fillPage();
/* 699 */     int i = this.pageOut.getCurrentDataPageId();
/* 700 */     this.logSectionPageMap.put(this.logSectionId, i);
/*     */   }
/*     */   
/*     */   int getLogSectionId() {
/* 704 */     return this.logSectionId;
/*     */   }
/*     */   
/*     */   int getLogFirstSectionId() {
/* 708 */     return this.firstSectionId;
/*     */   }
/*     */   
/*     */   int getLogPos() {
/* 712 */     return this.logPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeUntil(int paramInt) {
/* 721 */     if (paramInt == 0) {
/*     */       return;
/*     */     }
/* 724 */     int i = this.logSectionPageMap.get(paramInt);
/* 725 */     this.firstTrunkPage = removeUntil(this.firstTrunkPage, i);
/* 726 */     this.store.setLogFirstPage(this.logKey, this.firstTrunkPage, i);
/* 727 */     while (this.firstSectionId < paramInt) {
/* 728 */       if (this.firstSectionId > 0)
/*     */       {
/* 730 */         this.logSectionPageMap.remove(this.firstSectionId);
/*     */       }
/* 732 */       this.firstSectionId++;
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
/*     */   private int removeUntil(int paramInt1, int paramInt2) {
/* 744 */     this.trace.debug("log.removeUntil " + paramInt1 + " " + paramInt2);
/* 745 */     int i = paramInt1;
/*     */     while (true) {
/* 747 */       Page page = this.store.getPage(paramInt1);
/* 748 */       PageStreamTrunk pageStreamTrunk = (PageStreamTrunk)page;
/* 749 */       if (pageStreamTrunk == null) {
/* 750 */         throw DbException.throwInternalError("log.removeUntil not found: " + paramInt2 + " last " + i);
/*     */       }
/*     */       
/* 753 */       this.logKey = pageStreamTrunk.getLogKey();
/* 754 */       i = pageStreamTrunk.getPos();
/* 755 */       if (pageStreamTrunk.contains(paramInt2)) {
/* 756 */         return i;
/*     */       }
/* 758 */       paramInt1 = pageStreamTrunk.getNextTrunk();
/* 759 */       IntArray intArray = new IntArray();
/* 760 */       intArray.add(pageStreamTrunk.getPos());
/* 761 */       for (byte b = 0;; b++) {
/* 762 */         int j = pageStreamTrunk.getPageData(b);
/* 763 */         if (j == -1) {
/*     */           break;
/*     */         }
/* 766 */         intArray.add(j);
/*     */       } 
/* 768 */       freeLogPages(intArray);
/* 769 */       this.pageOut.free(pageStreamTrunk);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void close() {
/* 777 */     this.trace.debug("log close");
/* 778 */     if (this.pageOut != null) {
/* 779 */       this.pageOut.close();
/* 780 */       this.pageOut = null;
/*     */     } 
/* 782 */     this.writeBuffer = null;
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
/*     */   private boolean isSessionCommitted(int paramInt1, int paramInt2, int paramInt3) {
/* 794 */     SessionState sessionState = this.sessionStates.get(Integer.valueOf(paramInt1));
/* 795 */     if (sessionState == null) {
/* 796 */       return false;
/*     */     }
/* 798 */     return sessionState.isCommitted(paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setLastCommitForSession(int paramInt1, int paramInt2, int paramInt3) {
/* 809 */     SessionState sessionState = getOrAddSessionState(paramInt1);
/* 810 */     sessionState.lastCommitLog = paramInt2;
/* 811 */     sessionState.lastCommitPos = paramInt3;
/* 812 */     sessionState.inDoubtTransaction = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SessionState getOrAddSessionState(int paramInt) {
/* 823 */     Integer integer = Integer.valueOf(paramInt);
/* 824 */     SessionState sessionState = this.sessionStates.get(integer);
/* 825 */     if (sessionState == null) {
/* 826 */       sessionState = new SessionState();
/* 827 */       this.sessionStates.put(integer, sessionState);
/* 828 */       sessionState.sessionId = paramInt;
/*     */     } 
/* 830 */     return sessionState;
/*     */   }
/*     */   
/*     */   long getSize() {
/* 834 */     return (this.pageOut == null) ? 0L : this.pageOut.getSize();
/*     */   }
/*     */   
/*     */   ArrayList<InDoubtTransaction> getInDoubtTransactions() {
/* 838 */     ArrayList<PageStoreInDoubtTransaction> arrayList = New.arrayList();
/* 839 */     for (SessionState sessionState : this.sessionStates.values()) {
/* 840 */       PageStoreInDoubtTransaction pageStoreInDoubtTransaction = sessionState.inDoubtTransaction;
/* 841 */       if (pageStoreInDoubtTransaction != null) {
/* 842 */         arrayList.add(pageStoreInDoubtTransaction);
/*     */       }
/*     */     } 
/* 845 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setInDoubtTransactionState(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 856 */     PageStreamData pageStreamData = (PageStreamData)this.store.getPage(paramInt2);
/* 857 */     pageStreamData.initWrite();
/* 858 */     Data data = this.store.createData();
/* 859 */     data.writeByte((byte)(paramBoolean ? 2 : 4));
/* 860 */     data.writeVarInt(paramInt1);
/* 861 */     byte[] arrayOfByte = data.getBytes();
/* 862 */     pageStreamData.write(arrayOfByte, 0, arrayOfByte.length);
/* 863 */     arrayOfByte = new byte[pageStreamData.getRemaining()];
/* 864 */     pageStreamData.write(arrayOfByte, 0, arrayOfByte.length);
/* 865 */     pageStreamData.write();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void recoverEnd() {
/* 872 */     this.sessionStates = New.hashMap();
/*     */   }
/*     */   
/*     */   private void flushOut() {
/* 876 */     this.pageOut.flush();
/*     */   }
/*     */   
/*     */   private Data getBuffer() {
/* 880 */     if (this.writeBuffer.length() == 0) {
/* 881 */       return this.writeBuffer;
/*     */     }
/* 883 */     return this.store.createData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getMinPageId() {
/* 894 */     return (this.pageOut == null) ? 0 : this.pageOut.getMinPageId();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */