/*      */ package org.h2.mvstore;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import org.h2.compress.CompressDeflate;
/*      */ import org.h2.compress.CompressLZF;
/*      */ import org.h2.compress.Compressor;
/*      */ import org.h2.mvstore.cache.CacheLongKeyLIRS;
/*      */ import org.h2.mvstore.type.DataType;
/*      */ import org.h2.mvstore.type.StringDataType;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MVStore
/*      */ {
/*      */   public static final boolean ASSERT = false;
/*      */   static final int BLOCK_SIZE = 4096;
/*      */   private static final int FORMAT_WRITE = 1;
/*      */   private static final int FORMAT_READ = 1;
/*      */   private static final int MARKED_FREE = 10000000;
/*      */   volatile BackgroundWriterThread backgroundWriterThread;
/*      */   private volatile boolean reuseSpace = true;
/*      */   private boolean closed;
/*      */   private FileStore fileStore;
/*      */   private boolean fileStoreIsProvided;
/*      */   private final int pageSplitSize;
/*      */   private CacheLongKeyLIRS<Page> cache;
/*      */   private CacheLongKeyLIRS<Page.PageChildren> cacheChunkRef;
/*      */   private Chunk lastChunk;
/*  182 */   private final ConcurrentHashMap<Integer, Chunk> chunks = new ConcurrentHashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  190 */   private final ConcurrentHashMap<Long, HashMap<Integer, Chunk>> freedPageSpace = new ConcurrentHashMap<>();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private MVMap<String, String> meta;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  200 */   private final ConcurrentHashMap<Integer, MVMap<?, ?>> maps = new ConcurrentHashMap<>();
/*      */ 
/*      */   
/*  203 */   private HashMap<String, Object> storeHeader = New.hashMap();
/*      */   
/*      */   private WriteBuffer writeBuffer;
/*      */   
/*      */   private int lastMapId;
/*      */   
/*  209 */   private int versionsToKeep = 5;
/*      */ 
/*      */ 
/*      */   
/*      */   private final int compressionLevel;
/*      */ 
/*      */ 
/*      */   
/*      */   private Compressor compressorFast;
/*      */ 
/*      */ 
/*      */   
/*      */   private Compressor compressorHigh;
/*      */ 
/*      */ 
/*      */   
/*      */   private final Thread.UncaughtExceptionHandler backgroundExceptionHandler;
/*      */ 
/*      */ 
/*      */   
/*      */   private long currentVersion;
/*      */ 
/*      */ 
/*      */   
/*      */   private long lastStoredVersion;
/*      */ 
/*      */ 
/*      */   
/*      */   private int unsavedMemory;
/*      */ 
/*      */ 
/*      */   
/*      */   private int autoCommitMemory;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean saveNeeded;
/*      */ 
/*      */ 
/*      */   
/*      */   private long creationTime;
/*      */ 
/*      */ 
/*      */   
/*      */   private int retentionTime;
/*      */ 
/*      */   
/*      */   private long lastCommitTime;
/*      */ 
/*      */   
/*      */   private Chunk retainChunk;
/*      */ 
/*      */   
/*  262 */   private volatile long currentStoreVersion = -1L;
/*      */ 
/*      */   
/*      */   private Thread currentStoreThread;
/*      */ 
/*      */   
/*      */   private volatile boolean metaChanged;
/*      */   
/*      */   private int autoCommitDelay;
/*      */   
/*      */   private int autoCompactFillRate;
/*      */   
/*      */   private long autoCompactLastFileOpCount;
/*      */   
/*  276 */   private Object compactSync = new Object();
/*      */ 
/*      */ 
/*      */   
/*      */   private IllegalStateException panicException;
/*      */ 
/*      */ 
/*      */   
/*      */   private long lastTimeAbsolute;
/*      */ 
/*      */ 
/*      */   
/*      */   private long lastFreeUnusedChunks;
/*      */ 
/*      */ 
/*      */   
/*      */   MVStore(HashMap<String, Object> paramHashMap) {
/*  293 */     Object object = paramHashMap.get("compress");
/*  294 */     this.compressionLevel = (object == null) ? 0 : ((Integer)object).intValue();
/*  295 */     String str = (String)paramHashMap.get("fileName");
/*  296 */     object = paramHashMap.get("pageSplitSize");
/*  297 */     if (object == null) {
/*  298 */       this.pageSplitSize = (str == null) ? 4096 : 16384;
/*      */     } else {
/*  300 */       this.pageSplitSize = ((Integer)object).intValue();
/*      */     } 
/*  302 */     object = paramHashMap.get("backgroundExceptionHandler");
/*  303 */     this.backgroundExceptionHandler = (Thread.UncaughtExceptionHandler)object;
/*  304 */     this.meta = new MVMap<>((DataType)StringDataType.INSTANCE, (DataType)StringDataType.INSTANCE);
/*      */     
/*  306 */     HashMap<String, Integer> hashMap = New.hashMap();
/*  307 */     hashMap.put("id", Integer.valueOf(0));
/*  308 */     hashMap.put("createVersion", Long.valueOf(this.currentVersion));
/*  309 */     this.meta.init(this, (HashMap)hashMap);
/*  310 */     this.fileStore = (FileStore)paramHashMap.get("fileStore");
/*  311 */     if (str == null && this.fileStore == null) {
/*  312 */       this.cache = null;
/*  313 */       this.cacheChunkRef = null;
/*      */       return;
/*      */     } 
/*  316 */     if (this.fileStore == null) {
/*  317 */       this.fileStoreIsProvided = false;
/*  318 */       this.fileStore = new FileStore();
/*      */     } else {
/*  320 */       this.fileStoreIsProvided = true;
/*      */     } 
/*  322 */     this.retentionTime = this.fileStore.getDefaultRetentionTime();
/*  323 */     boolean bool = paramHashMap.containsKey("readOnly");
/*  324 */     object = paramHashMap.get("cacheSize");
/*  325 */     boolean bool1 = (object == null) ? true : ((Integer)object).intValue();
/*  326 */     if (bool1) {
/*  327 */       CacheLongKeyLIRS.Config config = new CacheLongKeyLIRS.Config();
/*  328 */       config.maxMemory = bool1 * 1024L * 1024L;
/*  329 */       object = paramHashMap.get("cacheConcurrency");
/*  330 */       if (object != null) {
/*  331 */         config.segmentCount = ((Integer)object).intValue();
/*      */       }
/*  333 */       this.cache = new CacheLongKeyLIRS(config);
/*  334 */       config.maxMemory /= 4L;
/*  335 */       this.cacheChunkRef = new CacheLongKeyLIRS(config);
/*      */     } 
/*  337 */     object = paramHashMap.get("autoCommitBufferSize");
/*  338 */     byte b = (object == null) ? 1024 : ((Integer)object).intValue();
/*      */     
/*  340 */     this.autoCommitMemory = b * 1024 * 19;
/*      */     
/*  342 */     object = paramHashMap.get("autoCompactFillRate");
/*  343 */     this.autoCompactFillRate = (object == null) ? 50 : ((Integer)object).intValue();
/*      */     
/*  345 */     char[] arrayOfChar = (char[])paramHashMap.get("encryptionKey");
/*      */     try {
/*  347 */       if (!this.fileStoreIsProvided) {
/*  348 */         this.fileStore.open(str, bool, arrayOfChar);
/*      */       }
/*  350 */       if (this.fileStore.size() == 0L) {
/*  351 */         this.creationTime = getTimeAbsolute();
/*  352 */         this.lastCommitTime = this.creationTime;
/*  353 */         this.storeHeader.put("H", Integer.valueOf(2));
/*  354 */         this.storeHeader.put("blockSize", Integer.valueOf(4096));
/*  355 */         this.storeHeader.put("format", Integer.valueOf(1));
/*  356 */         this.storeHeader.put("created", Long.valueOf(this.creationTime));
/*  357 */         writeStoreHeader();
/*      */       } else {
/*  359 */         readStoreHeader();
/*      */       } 
/*  361 */     } catch (IllegalStateException illegalStateException) {
/*  362 */       panic(illegalStateException);
/*      */     } finally {
/*  364 */       if (arrayOfChar != null) {
/*  365 */         Arrays.fill(arrayOfChar, false);
/*      */       }
/*      */     } 
/*  368 */     this.lastCommitTime = getTimeSinceCreation();
/*      */ 
/*      */ 
/*      */     
/*  372 */     object = paramHashMap.get("autoCommitDelay");
/*  373 */     boolean bool2 = (object == null) ? true : ((Integer)object).intValue();
/*  374 */     setAutoCommitDelay(bool2);
/*      */   }
/*      */   
/*      */   private void panic(IllegalStateException paramIllegalStateException) {
/*  378 */     if (this.backgroundExceptionHandler != null) {
/*  379 */       this.backgroundExceptionHandler.uncaughtException(null, paramIllegalStateException);
/*      */     }
/*  381 */     this.panicException = paramIllegalStateException;
/*  382 */     closeImmediately();
/*  383 */     throw paramIllegalStateException;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static MVStore open(String paramString) {
/*  394 */     HashMap<String, String> hashMap = New.hashMap();
/*  395 */     hashMap.put("fileName", paramString);
/*  396 */     return new MVStore((HashMap)hashMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   <T extends MVMap<?, ?>> T openMapVersion(long paramLong, int paramInt, MVMap<?, ?> paramMVMap) {
/*  410 */     MVMap<String, String> mVMap = getMetaMap(paramLong);
/*  411 */     long l = getRootPos(mVMap, paramInt);
/*  412 */     MVMap<?, ?> mVMap1 = paramMVMap.openReadOnly();
/*  413 */     mVMap1.setRootPos(l, paramLong);
/*  414 */     return (T)mVMap1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <K, V> MVMap<K, V> openMap(String paramString) {
/*  428 */     return openMap(paramString, new MVMap.Builder<>());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized <M extends MVMap<K, V>, K, V> M openMap(String paramString, MVMap.MapBuilder<M, K, V> paramMapBuilder) {
/*      */     int i;
/*      */     long l;
/*      */     M m;
/*  444 */     checkOpen();
/*  445 */     String str = this.meta.get("name." + paramString);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  450 */     if (str != null) {
/*  451 */       i = DataUtils.parseHexInt(str);
/*      */       
/*  453 */       MVMap mVMap = this.maps.get(Integer.valueOf(i));
/*  454 */       if (mVMap != null) {
/*  455 */         return (M)mVMap;
/*      */       }
/*  457 */       M m1 = paramMapBuilder.create();
/*  458 */       String str1 = this.meta.get(MVMap.getMapKey(i));
/*  459 */       HashMap<String, String> hashMap = New.hashMap();
/*  460 */       hashMap.putAll(DataUtils.parseMap(str1));
/*  461 */       hashMap.put("id", Integer.valueOf(i));
/*  462 */       m1.init(this, (HashMap)hashMap);
/*  463 */       l = getRootPos(this.meta, i);
/*      */     } else {
/*  465 */       HashMap<String, Integer> hashMap = New.hashMap();
/*  466 */       i = ++this.lastMapId;
/*  467 */       hashMap.put("id", Integer.valueOf(i));
/*  468 */       hashMap.put("createVersion", Long.valueOf(this.currentVersion));
/*  469 */       m = paramMapBuilder.create();
/*  470 */       m.init(this, (HashMap)hashMap);
/*  471 */       markMetaChanged();
/*  472 */       str = Integer.toHexString(i);
/*  473 */       this.meta.put(MVMap.getMapKey(i), m.asString(paramString));
/*  474 */       this.meta.put("name." + paramString, str);
/*  475 */       l = 0L;
/*      */     } 
/*  477 */     m.setRootPos(l, -1L);
/*  478 */     this.maps.put(Integer.valueOf(i), (MVMap<?, ?>)m);
/*  479 */     return m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized Set<String> getMapNames() {
/*  488 */     HashSet<String> hashSet = New.hashSet();
/*  489 */     checkOpen();
/*  490 */     for (Iterator<String> iterator = this.meta.keyIterator("name."); iterator.hasNext(); ) {
/*  491 */       String str = iterator.next();
/*  492 */       if (!str.startsWith("name.")) {
/*      */         break;
/*      */       }
/*  495 */       hashSet.add(str.substring("name.".length()));
/*      */     } 
/*  497 */     return hashSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MVMap<String, String> getMetaMap() {
/*  520 */     checkOpen();
/*  521 */     return this.meta;
/*      */   }
/*      */   
/*      */   private MVMap<String, String> getMetaMap(long paramLong) {
/*  525 */     Chunk chunk = getChunkForVersion(paramLong);
/*  526 */     DataUtils.checkArgument((chunk != null), "Unknown version {0}", new Object[] { Long.valueOf(paramLong) });
/*  527 */     chunk = readChunkHeader(chunk.block);
/*  528 */     MVMap<String, String> mVMap = this.meta.openReadOnly();
/*  529 */     mVMap.setRootPos(chunk.metaRootPos, paramLong);
/*  530 */     return mVMap;
/*      */   }
/*      */   
/*      */   private Chunk getChunkForVersion(long paramLong) {
/*  534 */     Chunk chunk = null;
/*  535 */     for (Chunk chunk1 : this.chunks.values()) {
/*  536 */       if (chunk1.version <= paramLong && (
/*  537 */         chunk == null || chunk1.id > chunk.id)) {
/*  538 */         chunk = chunk1;
/*      */       }
/*      */     } 
/*      */     
/*  542 */     return chunk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasMap(String paramString) {
/*  552 */     return this.meta.containsKey("name." + paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void markMetaChanged() {
/*  558 */     this.metaChanged = true;
/*      */   }
/*      */   
/*      */   private synchronized void readStoreHeader() {
/*  562 */     Chunk chunk1 = null;
/*  563 */     boolean bool = false;
/*      */ 
/*      */     
/*  566 */     ByteBuffer byteBuffer = this.fileStore.readFully(0L, 8192);
/*  567 */     byte[] arrayOfByte = new byte[4096];
/*  568 */     for (byte b = 0; b <= 'က'; b += 4096) {
/*  569 */       byteBuffer.get(arrayOfByte);
/*      */       
/*      */       try {
/*  572 */         String str = (new String(arrayOfByte, 0, 4096, DataUtils.LATIN)).trim();
/*      */         
/*  574 */         HashMap<String, String> hashMap = DataUtils.parseMap(str);
/*  575 */         int j = DataUtils.readHexInt((HashMap)hashMap, "blockSize", 4096);
/*      */         
/*  577 */         if (j != 4096) {
/*  578 */           throw DataUtils.newIllegalStateException(5, "Block size {0} is currently not supported", new Object[] { Integer.valueOf(j) });
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  583 */         int k = DataUtils.readHexInt((HashMap)hashMap, "fletcher", 0);
/*  584 */         hashMap.remove("fletcher");
/*  585 */         str = str.substring(0, str.lastIndexOf("fletcher") - 1);
/*  586 */         byte[] arrayOfByte1 = str.getBytes(DataUtils.LATIN);
/*  587 */         int m = DataUtils.getFletcher32(arrayOfByte1, arrayOfByte1.length);
/*      */         
/*  589 */         if (k == m) {
/*      */ 
/*      */           
/*  592 */           long l = DataUtils.readHexLong((Map)hashMap, "version", 0L);
/*  593 */           if (chunk1 == null || l > chunk1.version) {
/*  594 */             bool = true;
/*  595 */             this.storeHeader.putAll(hashMap);
/*  596 */             this.creationTime = DataUtils.readHexLong((Map)hashMap, "created", 0L);
/*  597 */             int n = DataUtils.readHexInt((HashMap)hashMap, "chunk", 0);
/*  598 */             long l3 = DataUtils.readHexLong((Map)hashMap, "block", 0L);
/*  599 */             Chunk chunk = readChunkHeaderAndFooter(l3);
/*  600 */             if (chunk != null && chunk.id == n)
/*  601 */               chunk1 = chunk; 
/*      */           } 
/*      */         } 
/*  604 */       } catch (Exception exception) {}
/*      */     } 
/*      */ 
/*      */     
/*  608 */     if (!bool) {
/*  609 */       throw DataUtils.newIllegalStateException(6, "Store header is corrupt: {0}", new Object[] { this.fileStore });
/*      */     }
/*      */ 
/*      */     
/*  613 */     long l1 = DataUtils.readHexLong(this.storeHeader, "format", 1L);
/*  614 */     if (l1 > 1L && !this.fileStore.isReadOnly()) {
/*  615 */       throw DataUtils.newIllegalStateException(5, "The write format {0} is larger than the supported format {1}, and the file was not opened in read-only mode", new Object[] { Long.valueOf(l1), Integer.valueOf(1) });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  622 */     l1 = DataUtils.readHexLong(this.storeHeader, "formatRead", l1);
/*  623 */     if (l1 > 1L) {
/*  624 */       throw DataUtils.newIllegalStateException(5, "The read format {0} is larger than the supported format {1}", new Object[] { Long.valueOf(l1), Integer.valueOf(1) });
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  630 */     this.lastStoredVersion = -1L;
/*  631 */     this.chunks.clear();
/*  632 */     long l2 = System.currentTimeMillis();
/*      */ 
/*      */     
/*  635 */     int i = 1970 + (int)(l2 / 31557600000L);
/*  636 */     if (i < 2014) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  641 */       this.creationTime = l2 - this.fileStore.getDefaultRetentionTime();
/*  642 */     } else if (l2 < this.creationTime) {
/*      */ 
/*      */       
/*  645 */       this.creationTime = l2;
/*  646 */       this.storeHeader.put("created", Long.valueOf(this.creationTime));
/*      */     } 
/*  648 */     Chunk chunk2 = readChunkFooter(this.fileStore.size());
/*  649 */     if (chunk2 != null) {
/*  650 */       chunk2 = readChunkHeaderAndFooter(chunk2.block);
/*  651 */       if (chunk2 != null && (
/*  652 */         chunk1 == null || chunk2.version > chunk1.version)) {
/*  653 */         chunk1 = chunk2;
/*      */       }
/*      */     } 
/*      */     
/*  657 */     if (chunk1 == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  664 */     while (chunk1.next != 0L && chunk1.next < this.fileStore.size() / 4096L) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  669 */       chunk2 = readChunkHeaderAndFooter(chunk1.next);
/*  670 */       if (chunk2 == null || chunk2.id <= chunk1.id) {
/*      */         break;
/*      */       }
/*  673 */       chunk1 = chunk2;
/*      */     } 
/*  675 */     setLastChunk(chunk1);
/*  676 */     loadChunkMeta();
/*      */ 
/*      */     
/*  679 */     verifyLastChunks();
/*      */     
/*  681 */     for (Chunk chunk : this.chunks.values()) {
/*  682 */       if (chunk.pageCountLive == 0)
/*      */       {
/*  684 */         registerFreePage(this.currentVersion, chunk.id, 0L, 0);
/*      */       }
/*  686 */       long l = chunk.block * 4096L;
/*  687 */       int j = chunk.len * 4096;
/*  688 */       this.fileStore.markUsed(l, j);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void loadChunkMeta() {
/*  695 */     for (Iterator<String> iterator = this.meta.keyIterator("chunk."); iterator.hasNext(); ) {
/*  696 */       String str = iterator.next();
/*  697 */       if (!str.startsWith("chunk.")) {
/*      */         break;
/*      */       }
/*  700 */       str = this.meta.get(str);
/*  701 */       Chunk chunk = Chunk.fromString(str);
/*  702 */       if (!this.chunks.containsKey(Integer.valueOf(chunk.id))) {
/*  703 */         if (chunk.block == Long.MAX_VALUE) {
/*  704 */           throw DataUtils.newIllegalStateException(6, "Chunk {0} is invalid", new Object[] { Integer.valueOf(chunk.id) });
/*      */         }
/*      */ 
/*      */         
/*  708 */         this.chunks.put(Integer.valueOf(chunk.id), chunk);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setLastChunk(Chunk paramChunk) {
/*  714 */     this.lastChunk = paramChunk;
/*  715 */     if (paramChunk == null) {
/*      */       
/*  717 */       this.lastMapId = 0;
/*  718 */       this.currentVersion = 0L;
/*  719 */       this.meta.setRootPos(0L, -1L);
/*      */     } else {
/*  721 */       this.lastMapId = paramChunk.mapId;
/*  722 */       this.currentVersion = paramChunk.version;
/*  723 */       this.chunks.put(Integer.valueOf(paramChunk.id), paramChunk);
/*  724 */       this.meta.setRootPos(paramChunk.metaRootPos, -1L);
/*      */     } 
/*  726 */     setWriteVersion(this.currentVersion);
/*      */   }
/*      */   
/*      */   private void verifyLastChunks() {
/*  730 */     long l = getTimeSinceCreation();
/*  731 */     ArrayList<Comparable> arrayList = new ArrayList(this.chunks.keySet());
/*  732 */     Collections.sort(arrayList);
/*  733 */     int i = -1;
/*  734 */     Chunk chunk1 = null;
/*  735 */     for (Integer integer : arrayList) {
/*  736 */       Chunk chunk3 = this.chunks.get(integer);
/*  737 */       if (chunk1 != null && chunk3.time < chunk1.time) {
/*      */         break;
/*      */       }
/*      */       
/*  741 */       chunk1 = chunk3;
/*  742 */       if (chunk3.time + this.retentionTime < l) {
/*      */         
/*  744 */         i = chunk3.id;
/*      */         continue;
/*      */       } 
/*  747 */       Chunk chunk4 = readChunkHeaderAndFooter(chunk3.block);
/*  748 */       if (chunk4 == null || chunk4.id != chunk3.id) {
/*      */         break;
/*      */       }
/*  751 */       i = integer.intValue();
/*      */     } 
/*  753 */     Chunk chunk2 = this.chunks.get(Integer.valueOf(i));
/*  754 */     if (chunk2 != this.lastChunk)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  759 */       rollbackTo((chunk2 == null) ? 0L : chunk2.version);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Chunk readChunkHeaderAndFooter(long paramLong) {
/*      */     Chunk chunk1;
/*      */     try {
/*  773 */       chunk1 = readChunkHeader(paramLong);
/*  774 */     } catch (Exception exception) {
/*      */       
/*  776 */       return null;
/*      */     } 
/*  778 */     if (chunk1 == null) {
/*  779 */       return null;
/*      */     }
/*  781 */     Chunk chunk2 = readChunkFooter((paramLong + chunk1.len) * 4096L);
/*  782 */     if (chunk2 == null || chunk2.id != chunk1.id) {
/*  783 */       return null;
/*      */     }
/*  785 */     return chunk1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Chunk readChunkFooter(long paramLong) {
/*      */     try {
/*  798 */       ByteBuffer byteBuffer = this.fileStore.readFully(paramLong - 128L, 128);
/*      */       
/*  800 */       byte[] arrayOfByte1 = new byte[128];
/*  801 */       byteBuffer.get(arrayOfByte1);
/*  802 */       String str = (new String(arrayOfByte1, DataUtils.LATIN)).trim();
/*  803 */       HashMap<String, String> hashMap = DataUtils.parseMap(str);
/*  804 */       int i = DataUtils.readHexInt((HashMap)hashMap, "fletcher", 0);
/*  805 */       hashMap.remove("fletcher");
/*  806 */       str = str.substring(0, str.lastIndexOf("fletcher") - 1);
/*  807 */       byte[] arrayOfByte2 = str.getBytes(DataUtils.LATIN);
/*  808 */       int j = DataUtils.getFletcher32(arrayOfByte2, arrayOfByte2.length);
/*  809 */       if (i == j) {
/*  810 */         int k = DataUtils.readHexInt((HashMap)hashMap, "chunk", 0);
/*  811 */         Chunk chunk = new Chunk(k);
/*  812 */         chunk.version = DataUtils.readHexLong((Map)hashMap, "version", 0L);
/*  813 */         chunk.block = DataUtils.readHexLong((Map)hashMap, "block", 0L);
/*  814 */         return chunk;
/*      */       } 
/*  816 */     } catch (Exception exception) {}
/*      */ 
/*      */     
/*  819 */     return null;
/*      */   }
/*      */   
/*      */   private void writeStoreHeader() {
/*  823 */     StringBuilder stringBuilder = new StringBuilder();
/*  824 */     if (this.lastChunk != null) {
/*  825 */       this.storeHeader.put("block", Long.valueOf(this.lastChunk.block));
/*  826 */       this.storeHeader.put("chunk", Integer.valueOf(this.lastChunk.id));
/*  827 */       this.storeHeader.put("version", Long.valueOf(this.lastChunk.version));
/*      */     } 
/*  829 */     DataUtils.appendMap(stringBuilder, this.storeHeader);
/*  830 */     byte[] arrayOfByte = stringBuilder.toString().getBytes(DataUtils.LATIN);
/*  831 */     int i = DataUtils.getFletcher32(arrayOfByte, arrayOfByte.length);
/*  832 */     DataUtils.appendMap(stringBuilder, "fletcher", Integer.valueOf(i));
/*  833 */     stringBuilder.append("\n");
/*  834 */     arrayOfByte = stringBuilder.toString().getBytes(DataUtils.LATIN);
/*  835 */     ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
/*  836 */     byteBuffer.put(arrayOfByte);
/*  837 */     byteBuffer.position(4096);
/*  838 */     byteBuffer.put(arrayOfByte);
/*  839 */     byteBuffer.rewind();
/*  840 */     write(0L, byteBuffer);
/*      */   }
/*      */   
/*      */   private void write(long paramLong, ByteBuffer paramByteBuffer) {
/*      */     try {
/*  845 */       this.fileStore.writeFully(paramLong, paramByteBuffer);
/*  846 */     } catch (IllegalStateException illegalStateException) {
/*  847 */       panic(illegalStateException);
/*  848 */       throw illegalStateException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() {
/*  856 */     if (this.closed) {
/*      */       return;
/*      */     }
/*  859 */     FileStore fileStore = this.fileStore;
/*  860 */     if (fileStore != null && !fileStore.isReadOnly()) {
/*  861 */       stopBackgroundThread();
/*  862 */       if (hasUnsavedChanges()) {
/*  863 */         commitAndSave();
/*      */       }
/*      */     } 
/*  866 */     closeStore(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void closeImmediately() {
/*      */     try {
/*  875 */       closeStore(false);
/*  876 */     } catch (Exception exception) {
/*  877 */       if (this.backgroundExceptionHandler != null) {
/*  878 */         this.backgroundExceptionHandler.uncaughtException(null, exception);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void closeStore(boolean paramBoolean) {
/*  884 */     if (this.closed) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  890 */     stopBackgroundThread();
/*  891 */     this.closed = true;
/*  892 */     if (this.fileStore == null) {
/*      */       return;
/*      */     }
/*  895 */     synchronized (this) {
/*  896 */       if (paramBoolean) {
/*  897 */         shrinkFileIfPossible(0);
/*      */       }
/*      */ 
/*      */       
/*  901 */       this.cache = null;
/*  902 */       this.cacheChunkRef = null;
/*  903 */       for (MVMap mVMap : New.arrayList(this.maps.values())) {
/*  904 */         mVMap.close();
/*      */       }
/*  906 */       this.meta = null;
/*  907 */       this.chunks.clear();
/*  908 */       this.maps.clear();
/*      */       try {
/*  910 */         if (!this.fileStoreIsProvided) {
/*  911 */           this.fileStore.close();
/*      */         }
/*      */       } finally {
/*  914 */         this.fileStore = null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isChunkLive(int paramInt) {
/*  926 */     String str = this.meta.get(Chunk.getMetaKey(paramInt));
/*  927 */     return (str != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Chunk getChunk(long paramLong) {
/*  937 */     Chunk chunk = getChunkIfFound(paramLong);
/*  938 */     if (chunk == null) {
/*  939 */       int i = DataUtils.getPageChunkId(paramLong);
/*  940 */       throw DataUtils.newIllegalStateException(6, "Chunk {0} not found", new Object[] { Integer.valueOf(i) });
/*      */     } 
/*      */ 
/*      */     
/*  944 */     return chunk;
/*      */   }
/*      */   
/*      */   private Chunk getChunkIfFound(long paramLong) {
/*  948 */     int i = DataUtils.getPageChunkId(paramLong);
/*  949 */     Chunk chunk = this.chunks.get(Integer.valueOf(i));
/*  950 */     if (chunk == null) {
/*  951 */       checkOpen();
/*  952 */       if (!Thread.holdsLock(this))
/*      */       {
/*      */         
/*  955 */         throw DataUtils.newIllegalStateException(9, "Chunk {0} no longer exists", new Object[] { Integer.valueOf(i) });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  960 */       String str = this.meta.get(Chunk.getMetaKey(i));
/*  961 */       if (str == null) {
/*  962 */         return null;
/*      */       }
/*  964 */       chunk = Chunk.fromString(str);
/*  965 */       if (chunk.block == Long.MAX_VALUE) {
/*  966 */         throw DataUtils.newIllegalStateException(6, "Chunk {0} is invalid", new Object[] { Integer.valueOf(i) });
/*      */       }
/*      */ 
/*      */       
/*  970 */       this.chunks.put(Integer.valueOf(chunk.id), chunk);
/*      */     } 
/*  972 */     return chunk;
/*      */   }
/*      */   
/*      */   private void setWriteVersion(long paramLong) {
/*  976 */     for (MVMap<?, ?> mVMap1 : this.maps.values()) {
/*  977 */       mVMap1.setWriteVersion(paramLong);
/*      */     }
/*  979 */     MVMap<String, String> mVMap = this.meta;
/*  980 */     if (mVMap == null) {
/*  981 */       checkOpen();
/*      */     }
/*  983 */     mVMap.setWriteVersion(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long commit() {
/* 1001 */     if (this.fileStore != null) {
/* 1002 */       return commitAndSave();
/*      */     }
/* 1004 */     long l = ++this.currentVersion;
/* 1005 */     setWriteVersion(l);
/* 1006 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized long commitAndSave() {
/* 1019 */     if (this.closed) {
/* 1020 */       return this.currentVersion;
/*      */     }
/* 1022 */     if (this.fileStore == null) {
/* 1023 */       throw DataUtils.newIllegalStateException(2, "This is an in-memory store", new Object[0]);
/*      */     }
/*      */ 
/*      */     
/* 1027 */     if (this.currentStoreVersion >= 0L)
/*      */     {
/* 1029 */       return this.currentVersion;
/*      */     }
/* 1031 */     if (!hasUnsavedChanges()) {
/* 1032 */       return this.currentVersion;
/*      */     }
/* 1034 */     if (this.fileStore.isReadOnly()) {
/* 1035 */       throw DataUtils.newIllegalStateException(2, "This store is read-only", new Object[0]);
/*      */     }
/*      */     
/*      */     try {
/* 1039 */       this.currentStoreVersion = this.currentVersion;
/* 1040 */       this.currentStoreThread = Thread.currentThread();
/* 1041 */       return storeNow();
/*      */     }
/*      */     finally {
/*      */       
/* 1045 */       this.currentStoreVersion = -1L;
/* 1046 */       this.currentStoreThread = null;
/*      */     } 
/*      */   }
/*      */   
/*      */   private long storeNow() {
/*      */     try {
/* 1052 */       return storeNowTry();
/* 1053 */     } catch (IllegalStateException illegalStateException) {
/* 1054 */       panic(illegalStateException);
/* 1055 */       return -1L;
/*      */     } 
/*      */   }
/*      */   private long storeNowTry() {
/*      */     int k;
/* 1060 */     long l5, l1 = getTimeSinceCreation();
/* 1061 */     int i = this.retentionTime / 10;
/* 1062 */     if (l1 >= this.lastFreeUnusedChunks + i) {
/*      */       
/* 1064 */       this.lastFreeUnusedChunks = l1;
/* 1065 */       freeUnusedChunks();
/*      */       
/* 1067 */       this.lastFreeUnusedChunks = getTimeSinceCreation();
/*      */     } 
/* 1069 */     int j = this.unsavedMemory;
/* 1070 */     long l2 = this.currentStoreVersion;
/* 1071 */     long l3 = ++this.currentVersion;
/* 1072 */     setWriteVersion(l3);
/* 1073 */     this.lastCommitTime = l1;
/* 1074 */     this.retainChunk = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1080 */     if (this.lastChunk == null) {
/* 1081 */       k = 0;
/*      */     } else {
/* 1083 */       k = this.lastChunk.id;
/* 1084 */       this.meta.put(Chunk.getMetaKey(k), this.lastChunk.asString());
/*      */       
/* 1086 */       l1 = Math.max(this.lastChunk.time, l1);
/*      */     } 
/* 1088 */     int m = k;
/*      */     while (true) {
/* 1090 */       m = (m + 1) % 67108863;
/* 1091 */       Chunk chunk1 = this.chunks.get(Integer.valueOf(m));
/* 1092 */       if (chunk1 == null) {
/*      */         break;
/*      */       }
/* 1095 */       if (chunk1.block == Long.MAX_VALUE) {
/* 1096 */         IllegalStateException illegalStateException = DataUtils.newIllegalStateException(3, "Last block not stored, possibly due to out-of-memory", new Object[0]);
/*      */ 
/*      */         
/* 1099 */         panic(illegalStateException);
/*      */       } 
/*      */     } 
/* 1102 */     Chunk chunk = new Chunk(m);
/*      */     
/* 1104 */     chunk.pageCount = Integer.MAX_VALUE;
/* 1105 */     chunk.pageCountLive = Integer.MAX_VALUE;
/* 1106 */     chunk.maxLen = Long.MAX_VALUE;
/* 1107 */     chunk.maxLenLive = Long.MAX_VALUE;
/* 1108 */     chunk.metaRootPos = Long.MAX_VALUE;
/* 1109 */     chunk.block = Long.MAX_VALUE;
/* 1110 */     chunk.len = Integer.MAX_VALUE;
/* 1111 */     chunk.time = l1;
/* 1112 */     chunk.version = l3;
/* 1113 */     chunk.mapId = this.lastMapId;
/* 1114 */     chunk.next = Long.MAX_VALUE;
/* 1115 */     this.chunks.put(Integer.valueOf(chunk.id), chunk);
/*      */     
/* 1117 */     this.meta.put(Chunk.getMetaKey(chunk.id), chunk.asString());
/* 1118 */     this.meta.remove(Chunk.getMetaKey(chunk.id));
/* 1119 */     ArrayList arrayList = New.arrayList(this.maps.values());
/* 1120 */     ArrayList<MVMap> arrayList1 = New.arrayList();
/* 1121 */     for (MVMap mVMap : arrayList) {
/* 1122 */       mVMap.setWriteVersion(l3);
/* 1123 */       long l = mVMap.getVersion();
/* 1124 */       if (mVMap.getCreateVersion() > l2) {
/*      */         continue;
/*      */       }
/*      */       
/* 1128 */       if (mVMap.isVolatile()) {
/*      */         continue;
/*      */       }
/* 1131 */       if (l >= 0L && l >= this.lastStoredVersion) {
/* 1132 */         MVMap mVMap1 = mVMap.openVersion(l2);
/* 1133 */         if (mVMap1.getRoot().getPos() == 0L) {
/* 1134 */           arrayList1.add(mVMap1);
/*      */         }
/*      */       } 
/*      */     } 
/* 1138 */     applyFreedSpace(l2);
/* 1139 */     WriteBuffer writeBuffer = getWriteBuffer();
/*      */     
/* 1141 */     chunk.writeChunkHeader(writeBuffer, 0);
/* 1142 */     int n = writeBuffer.position();
/* 1143 */     chunk.pageCount = 0;
/* 1144 */     chunk.pageCountLive = 0;
/* 1145 */     chunk.maxLen = 0L;
/* 1146 */     chunk.maxLenLive = 0L;
/* 1147 */     for (MVMap mVMap : arrayList1) {
/* 1148 */       Page page1 = mVMap.getRoot();
/* 1149 */       String str = MVMap.getMapRootKey(mVMap.getId());
/* 1150 */       if (page1.getTotalCount() == 0L) {
/* 1151 */         this.meta.put(str, "0"); continue;
/*      */       } 
/* 1153 */       page1.writeUnsavedRecursive(chunk, writeBuffer);
/* 1154 */       long l = page1.getPos();
/* 1155 */       this.meta.put(str, Long.toHexString(l));
/*      */     } 
/*      */     
/* 1158 */     this.meta.setWriteVersion(l3);
/*      */     
/* 1160 */     Page page = this.meta.getRoot();
/* 1161 */     page.writeUnsavedRecursive(chunk, writeBuffer);
/*      */     
/* 1163 */     int i1 = writeBuffer.position();
/*      */ 
/*      */     
/* 1166 */     int i2 = MathUtils.roundUpInt(i1 + 128, 4096);
/*      */     
/* 1168 */     writeBuffer.limit(i2);
/*      */ 
/*      */ 
/*      */     
/* 1172 */     long l4 = getFileLengthInUse();
/*      */     
/* 1174 */     if (this.reuseSpace) {
/* 1175 */       l5 = this.fileStore.allocate(i2);
/*      */     } else {
/* 1177 */       l5 = l4;
/*      */     } 
/*      */     
/* 1180 */     boolean bool1 = (l5 + i2 >= this.fileStore.size()) ? true : false;
/*      */     
/* 1182 */     if (!this.reuseSpace)
/*      */     {
/*      */ 
/*      */       
/* 1186 */       this.fileStore.markUsed(l4, i2);
/*      */     }
/*      */     
/* 1189 */     chunk.block = l5 / 4096L;
/* 1190 */     chunk.len = i2 / 4096;
/* 1191 */     chunk.metaRootPos = page.getPos();
/*      */     
/* 1193 */     if (this.reuseSpace) {
/* 1194 */       int i3 = chunk.len;
/* 1195 */       long l = this.fileStore.allocate(i3 * 4096);
/*      */       
/* 1197 */       this.fileStore.free(l, i3 * 4096);
/* 1198 */       chunk.next = l / 4096L;
/*      */     } else {
/*      */       
/* 1201 */       chunk.next = 0L;
/*      */     } 
/* 1203 */     writeBuffer.position(0);
/* 1204 */     chunk.writeChunkHeader(writeBuffer, n);
/* 1205 */     revertTemp(l2);
/*      */     
/* 1207 */     writeBuffer.position(writeBuffer.limit() - 128);
/* 1208 */     writeBuffer.put(chunk.getFooterBytes());
/*      */     
/* 1210 */     writeBuffer.position(0);
/* 1211 */     write(l5, writeBuffer.getBuffer());
/* 1212 */     releaseWriteBuffer(writeBuffer);
/*      */ 
/*      */     
/* 1215 */     boolean bool2 = false;
/* 1216 */     if (!bool1) {
/* 1217 */       if (this.lastChunk == null) {
/* 1218 */         bool2 = true;
/* 1219 */       } else if (this.lastChunk.next != chunk.block) {
/*      */         
/* 1221 */         bool2 = true;
/*      */       } else {
/* 1223 */         long l = DataUtils.readHexLong(this.storeHeader, "version", 0L);
/*      */         
/* 1225 */         if (this.lastChunk.version - l > 20L) {
/*      */           
/* 1227 */           bool2 = true;
/*      */         } else {
/* 1229 */           int i3 = DataUtils.readHexInt(this.storeHeader, "chunk", 0);
/*      */           while (true) {
/* 1231 */             Chunk chunk1 = this.chunks.get(Integer.valueOf(i3));
/* 1232 */             if (chunk1 == null) {
/*      */ 
/*      */               
/* 1235 */               bool2 = true;
/*      */               break;
/*      */             } 
/* 1238 */             if (i3 == this.lastChunk.id) {
/*      */               break;
/*      */             }
/* 1241 */             i3++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1247 */     this.lastChunk = chunk;
/* 1248 */     if (bool2) {
/* 1249 */       writeStoreHeader();
/*      */     }
/* 1251 */     if (!bool1)
/*      */     {
/* 1253 */       shrinkFileIfPossible(1);
/*      */     }
/* 1255 */     for (MVMap mVMap : arrayList1) {
/* 1256 */       Page page1 = mVMap.getRoot();
/* 1257 */       if (page1.getTotalCount() > 0L) {
/* 1258 */         page1.writeEnd();
/*      */       }
/*      */     } 
/* 1261 */     page.writeEnd();
/*      */ 
/*      */ 
/*      */     
/* 1265 */     this.unsavedMemory = Math.max(0, this.unsavedMemory - j);
/*      */ 
/*      */     
/* 1268 */     this.metaChanged = false;
/* 1269 */     this.lastStoredVersion = l2;
/*      */     
/* 1271 */     return l3;
/*      */   }
/*      */   
/*      */   private synchronized void freeUnusedChunks() {
/* 1275 */     if (this.lastChunk == null || !this.reuseSpace) {
/*      */       return;
/*      */     }
/* 1278 */     Set<Integer> set = collectReferencedChunks();
/* 1279 */     ArrayList<Chunk> arrayList = New.arrayList();
/* 1280 */     long l = getTimeSinceCreation();
/* 1281 */     for (Chunk chunk : this.chunks.values()) {
/* 1282 */       if (!set.contains(Integer.valueOf(chunk.id))) {
/* 1283 */         arrayList.add(chunk);
/*      */       }
/*      */     } 
/* 1286 */     for (Chunk chunk : arrayList) {
/* 1287 */       if (canOverwriteChunk(chunk, l)) {
/* 1288 */         this.chunks.remove(Integer.valueOf(chunk.id));
/* 1289 */         markMetaChanged();
/* 1290 */         this.meta.remove(Chunk.getMetaKey(chunk.id));
/* 1291 */         long l1 = chunk.block * 4096L;
/* 1292 */         int i = chunk.len * 4096;
/* 1293 */         this.fileStore.free(l1, i); continue;
/*      */       } 
/* 1295 */       if (chunk.unused == 0L) {
/* 1296 */         chunk.unused = l;
/* 1297 */         this.meta.put(Chunk.getMetaKey(chunk.id), chunk.asString());
/* 1298 */         markMetaChanged();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private Set<Integer> collectReferencedChunks() {
/* 1305 */     long l1 = this.lastChunk.version;
/* 1306 */     DataUtils.checkArgument((l1 > 0L), "Collect references on version 0", new Object[0]);
/* 1307 */     long l2 = (getFileStore()).readCount;
/* 1308 */     HashSet<Integer> hashSet = New.hashSet();
/* 1309 */     for (Cursor<String, String> cursor = this.meta.cursor("root."); cursor.hasNext(); ) {
/* 1310 */       String str = cursor.next();
/* 1311 */       if (!str.startsWith("root.")) {
/*      */         break;
/*      */       }
/* 1314 */       long l = DataUtils.parseHexLong(cursor.getValue());
/* 1315 */       if (l == 0L) {
/*      */         continue;
/*      */       }
/* 1318 */       int i = DataUtils.parseHexInt(str.substring("root.".length()));
/* 1319 */       collectReferencedChunks(hashSet, i, l, 0);
/*      */     } 
/* 1321 */     long l3 = this.lastChunk.metaRootPos;
/* 1322 */     collectReferencedChunks(hashSet, 0, l3, 0);
/* 1323 */     l2 = this.fileStore.readCount - l2;
/* 1324 */     return hashSet;
/*      */   }
/*      */ 
/*      */   
/*      */   private void collectReferencedChunks(Set<Integer> paramSet, int paramInt1, long paramLong, int paramInt2) {
/* 1329 */     int i = DataUtils.getPageChunkId(paramLong);
/* 1330 */     paramSet.add(Integer.valueOf(i));
/* 1331 */     if (DataUtils.getPageType(paramLong) == 0) {
/*      */       return;
/*      */     }
/* 1334 */     Page.PageChildren pageChildren = readPageChunkReferences(paramInt1, paramLong, -1);
/* 1335 */     if (!pageChildren.chunkList) {
/* 1336 */       HashSet<Integer> hashSet = New.hashSet();
/* 1337 */       for (byte b1 = 0; b1 < pageChildren.children.length; b1++) {
/* 1338 */         long l = pageChildren.children[b1];
/* 1339 */         collectReferencedChunks(hashSet, paramInt1, l, paramInt2 + 1);
/*      */       } 
/*      */       
/* 1342 */       hashSet.remove(Integer.valueOf(i));
/* 1343 */       long[] arrayOfLong = new long[hashSet.size()];
/* 1344 */       byte b2 = 0;
/* 1345 */       for (Integer integer : hashSet) {
/* 1346 */         arrayOfLong[b2++] = DataUtils.getPagePos(integer.intValue(), 0, 0, 0);
/*      */       }
/*      */       
/* 1349 */       pageChildren.children = arrayOfLong;
/* 1350 */       pageChildren.chunkList = true;
/* 1351 */       if (this.cacheChunkRef != null) {
/* 1352 */         this.cacheChunkRef.put(pageChildren.pos, pageChildren, pageChildren.getMemory());
/*      */       }
/*      */     } 
/* 1355 */     for (long l : pageChildren.children)
/* 1356 */       paramSet.add(Integer.valueOf(DataUtils.getPageChunkId(l))); 
/*      */   }
/*      */   
/*      */   private Page.PageChildren readPageChunkReferences(int paramInt1, long paramLong, int paramInt2) {
/*      */     Page.PageChildren pageChildren;
/* 1361 */     if (DataUtils.getPageType(paramLong) == 0) {
/* 1362 */       return null;
/*      */     }
/*      */     
/* 1365 */     if (this.cacheChunkRef != null) {
/* 1366 */       pageChildren = (Page.PageChildren)this.cacheChunkRef.get(paramLong);
/*      */     } else {
/* 1368 */       pageChildren = null;
/*      */     } 
/* 1370 */     if (pageChildren == null) {
/*      */       
/* 1372 */       if (this.cache != null) {
/* 1373 */         Page page = (Page)this.cache.get(paramLong);
/* 1374 */         if (page != null) {
/* 1375 */           pageChildren = new Page.PageChildren(page);
/*      */         }
/*      */       } 
/* 1378 */       if (pageChildren == null) {
/*      */         
/* 1380 */         Chunk chunk = getChunk(paramLong);
/* 1381 */         long l1 = chunk.block * 4096L;
/* 1382 */         l1 += DataUtils.getPageOffset(paramLong);
/* 1383 */         if (l1 < 0L) {
/* 1384 */           throw DataUtils.newIllegalStateException(6, "Negative position {0}; p={1}, c={2}", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong), chunk.toString() });
/*      */         }
/*      */ 
/*      */         
/* 1388 */         long l2 = (chunk.block + chunk.len) * 4096L;
/* 1389 */         pageChildren = Page.PageChildren.read(this.fileStore, paramLong, paramInt1, l1, l2);
/*      */       } 
/* 1391 */       pageChildren.removeDuplicateChunkReferences();
/* 1392 */       if (this.cacheChunkRef != null) {
/* 1393 */         this.cacheChunkRef.put(paramLong, pageChildren, pageChildren.getMemory());
/*      */       }
/*      */     } 
/* 1396 */     if (pageChildren.children.length == 0) {
/* 1397 */       int i = DataUtils.getPageChunkId(paramLong);
/* 1398 */       if (i == paramInt2) {
/* 1399 */         return null;
/*      */       }
/*      */     } 
/* 1402 */     return pageChildren;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private WriteBuffer getWriteBuffer() {
/*      */     WriteBuffer writeBuffer;
/* 1413 */     if (this.writeBuffer != null) {
/* 1414 */       writeBuffer = this.writeBuffer;
/* 1415 */       writeBuffer.clear();
/*      */     } else {
/* 1417 */       writeBuffer = new WriteBuffer();
/*      */     } 
/* 1419 */     return writeBuffer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void releaseWriteBuffer(WriteBuffer paramWriteBuffer) {
/* 1429 */     if (paramWriteBuffer.capacity() <= 4194304) {
/* 1430 */       this.writeBuffer = paramWriteBuffer;
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean canOverwriteChunk(Chunk paramChunk, long paramLong) {
/* 1435 */     if (this.retentionTime >= 0) {
/* 1436 */       if (paramChunk.time + this.retentionTime > paramLong) {
/* 1437 */         return false;
/*      */       }
/* 1439 */       if (paramChunk.unused == 0L || paramChunk.unused + (this.retentionTime / 2) > paramLong) {
/* 1440 */         return false;
/*      */       }
/*      */     } 
/* 1443 */     Chunk chunk = this.retainChunk;
/* 1444 */     if (chunk != null && paramChunk.version > chunk.version) {
/* 1445 */       return false;
/*      */     }
/* 1447 */     return true;
/*      */   }
/*      */   
/*      */   private long getTimeSinceCreation() {
/* 1451 */     return Math.max(0L, getTimeAbsolute() - this.creationTime);
/*      */   }
/*      */   
/*      */   private long getTimeAbsolute() {
/* 1455 */     long l = System.currentTimeMillis();
/* 1456 */     if (this.lastTimeAbsolute != 0L && l < this.lastTimeAbsolute) {
/*      */ 
/*      */ 
/*      */       
/* 1460 */       l = this.lastTimeAbsolute;
/*      */     } else {
/* 1462 */       this.lastTimeAbsolute = l;
/*      */     } 
/* 1464 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void applyFreedSpace(long paramLong) {
/*      */     ArrayList<Chunk> arrayList;
/*      */     do {
/* 1476 */       arrayList = New.arrayList();
/*      */       
/* 1478 */       Iterator<Map.Entry> iterator = this.freedPageSpace.entrySet().iterator();
/* 1479 */       while (iterator.hasNext()) {
/* 1480 */         Map.Entry entry = iterator.next();
/* 1481 */         long l = ((Long)entry.getKey()).longValue();
/* 1482 */         if (l > paramLong) {
/*      */           continue;
/*      */         }
/* 1485 */         HashMap hashMap = (HashMap)entry.getValue();
/* 1486 */         for (Chunk chunk1 : hashMap.values()) {
/* 1487 */           Chunk chunk2 = this.chunks.get(Integer.valueOf(chunk1.id));
/* 1488 */           if (chunk2 == null) {
/*      */             continue;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/* 1494 */           chunk2.maxLenLive += chunk1.maxLenLive;
/* 1495 */           chunk2.pageCountLive += chunk1.pageCountLive;
/* 1496 */           if (chunk2.pageCountLive < 0 && chunk2.pageCountLive > -10000000)
/*      */           {
/* 1498 */             chunk2.pageCountLive = 0;
/*      */           }
/* 1500 */           if (chunk2.maxLenLive < 0L && chunk2.maxLenLive > -10000000L)
/*      */           {
/* 1502 */             chunk2.maxLenLive = 0L;
/*      */           }
/* 1504 */           arrayList.add(chunk2);
/*      */         } 
/* 1506 */         iterator.remove();
/*      */       } 
/* 1508 */       for (Chunk chunk : arrayList) {
/* 1509 */         this.meta.put(Chunk.getMetaKey(chunk.id), chunk.asString());
/*      */       }
/* 1511 */     } while (arrayList.size() != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void shrinkFileIfPossible(int paramInt) {
/* 1524 */     if (this.fileStore.isReadOnly()) {
/*      */       return;
/*      */     }
/* 1527 */     long l1 = getFileLengthInUse();
/* 1528 */     long l2 = this.fileStore.size();
/* 1529 */     if (l1 >= l2) {
/*      */       return;
/*      */     }
/* 1532 */     if (paramInt > 0 && l2 - l1 < 4096L) {
/*      */       return;
/*      */     }
/* 1535 */     int i = (int)(100L - l1 * 100L / l2);
/* 1536 */     if (i < paramInt) {
/*      */       return;
/*      */     }
/* 1539 */     if (!this.closed) {
/* 1540 */       sync();
/*      */     }
/* 1542 */     this.fileStore.truncate(l1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long getFileLengthInUse() {
/* 1551 */     long l = 8192L;
/* 1552 */     for (Chunk chunk : this.chunks.values()) {
/* 1553 */       if (chunk.len != Integer.MAX_VALUE) {
/* 1554 */         long l1 = (chunk.block + chunk.len) * 4096L;
/* 1555 */         l = Math.max(l, l1);
/*      */       } 
/*      */     } 
/* 1558 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasUnsavedChanges() {
/* 1567 */     checkOpen();
/* 1568 */     if (this.metaChanged) {
/* 1569 */       return true;
/*      */     }
/* 1571 */     for (MVMap<?, ?> mVMap : this.maps.values()) {
/* 1572 */       if (!mVMap.isClosed()) {
/* 1573 */         long l = mVMap.getVersion();
/* 1574 */         if (l >= 0L && l > this.lastStoredVersion) {
/* 1575 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/* 1579 */     return false;
/*      */   }
/*      */   
/*      */   private Chunk readChunkHeader(long paramLong) {
/* 1583 */     long l = paramLong * 4096L;
/* 1584 */     ByteBuffer byteBuffer = this.fileStore.readFully(l, 1024);
/* 1585 */     return Chunk.readChunkHeader(byteBuffer, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized boolean compactRewriteFully() {
/* 1594 */     checkOpen();
/* 1595 */     if (this.lastChunk == null)
/*      */     {
/* 1597 */       return false;
/*      */     }
/* 1599 */     for (MVMap<Object, Object> mVMap1 : this.maps.values()) {
/*      */       
/* 1601 */       MVMap<Object, Object> mVMap2 = mVMap1;
/* 1602 */       Cursor cursor = mVMap2.cursor(null);
/* 1603 */       Page page = null;
/* 1604 */       while (cursor.hasNext()) {
/* 1605 */         cursor.next();
/* 1606 */         Page page1 = cursor.getPage();
/* 1607 */         if (page1 == page) {
/*      */           continue;
/*      */         }
/* 1610 */         Object object1 = page1.getKey(0);
/* 1611 */         Object object2 = page1.getValue(0);
/* 1612 */         mVMap2.put(object1, object2);
/* 1613 */         page = page1;
/*      */       } 
/*      */     } 
/* 1616 */     commitAndSave();
/* 1617 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized boolean compactMoveChunks() {
/* 1626 */     return compactMoveChunks(100, Long.MAX_VALUE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized boolean compactMoveChunks(int paramInt, long paramLong) {
/* 1641 */     checkOpen();
/* 1642 */     if (this.lastChunk == null || !this.reuseSpace)
/*      */     {
/* 1644 */       return false;
/*      */     }
/* 1646 */     int i = this.retentionTime;
/* 1647 */     boolean bool = this.reuseSpace;
/*      */     try {
/* 1649 */       this.retentionTime = -1;
/* 1650 */       freeUnusedChunks();
/* 1651 */       if (this.fileStore.getFillRate() > paramInt) {
/* 1652 */         return false;
/*      */       }
/* 1654 */       long l = this.fileStore.getFirstFree() / 4096L;
/* 1655 */       ArrayList<Chunk> arrayList = compactGetMoveBlocks(l, paramLong);
/* 1656 */       compactMoveChunks(arrayList);
/* 1657 */       freeUnusedChunks();
/* 1658 */       storeNow();
/*      */     } finally {
/* 1660 */       this.reuseSpace = bool;
/* 1661 */       this.retentionTime = i;
/*      */     } 
/* 1663 */     return true;
/*      */   }
/*      */   
/*      */   private ArrayList<Chunk> compactGetMoveBlocks(long paramLong1, long paramLong2) {
/* 1667 */     ArrayList<Chunk> arrayList = New.arrayList();
/* 1668 */     for (Chunk chunk : this.chunks.values()) {
/* 1669 */       if (chunk.block > paramLong1) {
/* 1670 */         arrayList.add(chunk);
/*      */       }
/*      */     } 
/*      */     
/* 1674 */     Collections.sort(arrayList, new Comparator<Chunk>()
/*      */         {
/*      */           public int compare(Chunk param1Chunk1, Chunk param1Chunk2) {
/* 1677 */             return Long.signum(param1Chunk1.block - param1Chunk2.block);
/*      */           }
/*      */         });
/*      */     
/* 1681 */     byte b = 0;
/* 1682 */     long l = 0L;
/* 1683 */     for (Chunk chunk : arrayList) {
/* 1684 */       long l1 = chunk.len * 4096L;
/* 1685 */       if (l + l1 > paramLong2) {
/*      */         break;
/*      */       }
/* 1688 */       l += l1;
/* 1689 */       b++;
/*      */     } 
/*      */ 
/*      */     
/* 1693 */     while (arrayList.size() > b && arrayList.size() > 1) {
/* 1694 */       arrayList.remove(1);
/*      */     }
/*      */     
/* 1697 */     return arrayList;
/*      */   }
/*      */   
/*      */   private void compactMoveChunks(ArrayList<Chunk> paramArrayList) {
/* 1701 */     for (Chunk chunk : paramArrayList) {
/* 1702 */       WriteBuffer writeBuffer = getWriteBuffer();
/* 1703 */       long l1 = chunk.block * 4096L;
/* 1704 */       int i = chunk.len * 4096;
/* 1705 */       writeBuffer.limit(i);
/* 1706 */       ByteBuffer byteBuffer = this.fileStore.readFully(l1, i);
/* 1707 */       Chunk.readChunkHeader(byteBuffer, l1);
/* 1708 */       int j = byteBuffer.position();
/* 1709 */       writeBuffer.position(j);
/* 1710 */       writeBuffer.put(byteBuffer);
/* 1711 */       long l2 = getFileLengthInUse();
/* 1712 */       this.fileStore.markUsed(l2, i);
/* 1713 */       this.fileStore.free(l1, i);
/* 1714 */       chunk.block = l2 / 4096L;
/* 1715 */       chunk.next = 0L;
/* 1716 */       writeBuffer.position(0);
/* 1717 */       chunk.writeChunkHeader(writeBuffer, j);
/* 1718 */       writeBuffer.position(i - 128);
/* 1719 */       writeBuffer.put(chunk.getFooterBytes());
/* 1720 */       writeBuffer.position(0);
/* 1721 */       write(l2, writeBuffer.getBuffer());
/* 1722 */       releaseWriteBuffer(writeBuffer);
/* 1723 */       markMetaChanged();
/* 1724 */       this.meta.put(Chunk.getMetaKey(chunk.id), chunk.asString());
/*      */     } 
/*      */ 
/*      */     
/* 1728 */     this.reuseSpace = false;
/* 1729 */     commitAndSave();
/* 1730 */     sync();
/*      */ 
/*      */     
/* 1733 */     this.reuseSpace = true;
/* 1734 */     for (Chunk chunk : paramArrayList) {
/* 1735 */       if (!this.chunks.containsKey(Integer.valueOf(chunk.id))) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1740 */       WriteBuffer writeBuffer = getWriteBuffer();
/* 1741 */       long l1 = chunk.block * 4096L;
/* 1742 */       int i = chunk.len * 4096;
/* 1743 */       writeBuffer.limit(i);
/* 1744 */       ByteBuffer byteBuffer = this.fileStore.readFully(l1, i);
/* 1745 */       Chunk.readChunkHeader(byteBuffer, 0L);
/* 1746 */       int j = byteBuffer.position();
/* 1747 */       writeBuffer.position(j);
/* 1748 */       writeBuffer.put(byteBuffer);
/* 1749 */       long l2 = this.fileStore.allocate(i);
/* 1750 */       this.fileStore.free(l1, i);
/* 1751 */       writeBuffer.position(0);
/* 1752 */       chunk.block = l2 / 4096L;
/* 1753 */       chunk.writeChunkHeader(writeBuffer, j);
/* 1754 */       writeBuffer.position(i - 128);
/* 1755 */       writeBuffer.put(chunk.getFooterBytes());
/* 1756 */       writeBuffer.position(0);
/* 1757 */       write(l2, writeBuffer.getBuffer());
/* 1758 */       releaseWriteBuffer(writeBuffer);
/* 1759 */       markMetaChanged();
/* 1760 */       this.meta.put(Chunk.getMetaKey(chunk.id), chunk.asString());
/*      */     } 
/*      */ 
/*      */     
/* 1764 */     commitAndSave();
/* 1765 */     sync();
/* 1766 */     shrinkFileIfPossible(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sync() {
/* 1774 */     checkOpen();
/* 1775 */     FileStore fileStore = this.fileStore;
/* 1776 */     if (fileStore != null) {
/* 1777 */       fileStore.sync();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean compact(int paramInt1, int paramInt2) {
/* 1800 */     if (!this.reuseSpace) {
/* 1801 */       return false;
/*      */     }
/* 1803 */     synchronized (this.compactSync) {
/* 1804 */       ArrayList<Chunk> arrayList; checkOpen();
/*      */       
/* 1806 */       synchronized (this) {
/* 1807 */         arrayList = compactGetOldChunks(paramInt1, paramInt2);
/*      */       } 
/* 1809 */       if (arrayList == null || arrayList.size() == 0) {
/* 1810 */         return false;
/*      */       }
/* 1812 */       compactRewrite(arrayList);
/* 1813 */       return true;
/*      */     } 
/*      */   }
/*      */   
/*      */   private ArrayList<Chunk> compactGetOldChunks(int paramInt1, int paramInt2) {
/* 1818 */     if (this.lastChunk == null)
/*      */     {
/* 1820 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1824 */     long l1 = 0L;
/* 1825 */     long l2 = 0L;
/*      */     
/* 1827 */     long l3 = getTimeSinceCreation();
/*      */     
/* 1829 */     for (Chunk chunk : this.chunks.values()) {
/*      */       
/* 1831 */       if (chunk.time + this.retentionTime > l3) {
/*      */         continue;
/*      */       }
/* 1834 */       l1 += chunk.maxLen;
/* 1835 */       l2 += chunk.maxLenLive;
/*      */     } 
/* 1837 */     if (l2 < 0L)
/*      */     {
/* 1839 */       return null;
/*      */     }
/*      */     
/* 1842 */     if (l1 <= 0L)
/*      */     {
/* 1844 */       l1 = 1L;
/*      */     }
/* 1846 */     int i = (int)(100L * l2 / l1);
/* 1847 */     if (i >= paramInt1) {
/* 1848 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1852 */     ArrayList<Chunk> arrayList = New.arrayList();
/* 1853 */     Chunk chunk1 = this.chunks.get(Integer.valueOf(this.lastChunk.id));
/* 1854 */     for (Chunk chunk : this.chunks.values()) {
/*      */ 
/*      */ 
/*      */       
/* 1858 */       if (chunk.time + this.retentionTime > l3) {
/*      */         continue;
/*      */       }
/* 1861 */       long l = chunk1.version - chunk.version + 1L;
/* 1862 */       chunk.collectPriority = (int)((chunk.getFillRate() * 1000) / l);
/* 1863 */       arrayList.add(chunk);
/*      */     } 
/* 1865 */     if (arrayList.size() == 0) {
/* 1866 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1870 */     Collections.sort(arrayList, new Comparator<Chunk>()
/*      */         {
/*      */           public int compare(Chunk param1Chunk1, Chunk param1Chunk2) {
/* 1873 */             int i = (new Integer(param1Chunk1.collectPriority)).compareTo(Integer.valueOf(param1Chunk2.collectPriority));
/*      */             
/* 1875 */             if (i == 0) {
/* 1876 */               i = (new Long(param1Chunk1.maxLenLive)).compareTo(Long.valueOf(param1Chunk2.maxLenLive));
/*      */             }
/*      */             
/* 1879 */             return i;
/*      */           }
/*      */         });
/*      */     
/* 1883 */     long l4 = 0L;
/* 1884 */     byte b = 0;
/* 1885 */     Chunk chunk2 = null;
/* 1886 */     for (Chunk chunk : arrayList) {
/* 1887 */       if (chunk2 != null && 
/* 1888 */         chunk.collectPriority > 0 && l4 > paramInt2) {
/*      */         break;
/*      */       }
/*      */       
/* 1892 */       l4 += chunk.maxLenLive;
/* 1893 */       b++;
/* 1894 */       chunk2 = chunk;
/*      */     } 
/* 1896 */     if (b < 1) {
/* 1897 */       return null;
/*      */     }
/*      */     
/* 1900 */     boolean bool = false;
/* 1901 */     for (Iterator<Chunk> iterator = arrayList.iterator(); iterator.hasNext(); ) {
/* 1902 */       Chunk chunk = iterator.next();
/* 1903 */       if (chunk2 == chunk) {
/* 1904 */         bool = true; continue;
/* 1905 */       }  if (bool) {
/* 1906 */         iterator.remove();
/*      */       }
/*      */     } 
/* 1909 */     return arrayList;
/*      */   }
/*      */   
/*      */   private void compactRewrite(ArrayList<Chunk> paramArrayList) {
/* 1913 */     HashSet<Integer> hashSet = New.hashSet();
/* 1914 */     for (Chunk chunk : paramArrayList) {
/* 1915 */       hashSet.add(Integer.valueOf(chunk.id));
/*      */     }
/* 1917 */     for (MVMap<?, ?> mVMap1 : this.maps.values()) {
/*      */       
/* 1919 */       MVMap<?, ?> mVMap2 = mVMap1;
/* 1920 */       if (!mVMap2.rewrite(hashSet)) {
/*      */         return;
/*      */       }
/*      */     } 
/* 1924 */     if (!this.meta.rewrite(hashSet)) {
/*      */       return;
/*      */     }
/* 1927 */     freeUnusedChunks();
/* 1928 */     commitAndSave();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Page readPage(MVMap<?, ?> paramMVMap, long paramLong) {
/* 1939 */     if (paramLong == 0L) {
/* 1940 */       throw DataUtils.newIllegalStateException(6, "Position 0", new Object[0]);
/*      */     }
/*      */     
/* 1943 */     Page page = (this.cache == null) ? null : (Page)this.cache.get(paramLong);
/* 1944 */     if (page == null) {
/* 1945 */       Chunk chunk = getChunk(paramLong);
/* 1946 */       long l1 = chunk.block * 4096L;
/* 1947 */       l1 += DataUtils.getPageOffset(paramLong);
/* 1948 */       if (l1 < 0L) {
/* 1949 */         throw DataUtils.newIllegalStateException(6, "Negative position {0}", new Object[] { Long.valueOf(l1) });
/*      */       }
/*      */ 
/*      */       
/* 1953 */       long l2 = (chunk.block + chunk.len) * 4096L;
/* 1954 */       page = Page.read(this.fileStore, paramLong, paramMVMap, l1, l2);
/* 1955 */       cachePage(paramLong, page, page.getMemory());
/*      */     } 
/* 1957 */     return page;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void removePage(MVMap<?, ?> paramMVMap, long paramLong, int paramInt) {
/* 1970 */     if (paramLong == 0L) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1975 */       this.unsavedMemory = Math.max(0, this.unsavedMemory - paramInt);
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1983 */     if (this.cache != null && 
/* 1984 */       DataUtils.getPageType(paramLong) == 0)
/*      */     {
/*      */       
/* 1987 */       this.cache.remove(paramLong);
/*      */     }
/*      */ 
/*      */     
/* 1991 */     Chunk chunk = getChunk(paramLong);
/* 1992 */     long l = this.currentVersion;
/* 1993 */     if (paramMVMap == this.meta && this.currentStoreVersion >= 0L && 
/* 1994 */       Thread.currentThread() == this.currentStoreThread)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/* 1999 */       l = this.currentStoreVersion;
/*      */     }
/*      */     
/* 2002 */     registerFreePage(l, chunk.id, DataUtils.getPageMaxLength(paramLong), 1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void registerFreePage(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {
/* 2008 */     HashMap<Integer, Chunk> hashMap = this.freedPageSpace.get(Long.valueOf(paramLong1));
/* 2009 */     if (hashMap == null) {
/* 2010 */       hashMap = New.hashMap();
/* 2011 */       HashMap<Integer, Chunk> hashMap1 = this.freedPageSpace.putIfAbsent(Long.valueOf(paramLong1), hashMap);
/*      */       
/* 2013 */       if (hashMap1 != null) {
/* 2014 */         hashMap = hashMap1;
/*      */       }
/*      */     } 
/*      */     
/* 2018 */     synchronized (hashMap) {
/* 2019 */       Chunk chunk = hashMap.get(Integer.valueOf(paramInt1));
/* 2020 */       if (chunk == null) {
/* 2021 */         chunk = new Chunk(paramInt1);
/* 2022 */         hashMap.put(Integer.valueOf(paramInt1), chunk);
/*      */       } 
/* 2024 */       chunk.maxLenLive -= paramLong2;
/* 2025 */       chunk.pageCountLive -= paramInt2;
/*      */     } 
/*      */   }
/*      */   
/*      */   Compressor getCompressorFast() {
/* 2030 */     if (this.compressorFast == null) {
/* 2031 */       this.compressorFast = (Compressor)new CompressLZF();
/*      */     }
/* 2033 */     return this.compressorFast;
/*      */   }
/*      */   
/*      */   Compressor getCompressorHigh() {
/* 2037 */     if (this.compressorHigh == null) {
/* 2038 */       this.compressorHigh = (Compressor)new CompressDeflate();
/*      */     }
/* 2040 */     return this.compressorHigh;
/*      */   }
/*      */   
/*      */   int getCompressionLevel() {
/* 2044 */     return this.compressionLevel;
/*      */   }
/*      */   
/*      */   public int getPageSplitSize() {
/* 2048 */     return this.pageSplitSize;
/*      */   }
/*      */   
/*      */   public boolean getReuseSpace() {
/* 2052 */     return this.reuseSpace;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setReuseSpace(boolean paramBoolean) {
/* 2069 */     this.reuseSpace = paramBoolean;
/*      */   }
/*      */   
/*      */   public int getRetentionTime() {
/* 2073 */     return this.retentionTime;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRetentionTime(int paramInt) {
/* 2098 */     this.retentionTime = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVersionsToKeep(int paramInt) {
/* 2108 */     this.versionsToKeep = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getVersionsToKeep() {
/* 2117 */     return this.versionsToKeep;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   long getOldestVersionToKeep() {
/* 2127 */     long l1 = this.currentVersion;
/* 2128 */     if (this.fileStore == null) {
/* 2129 */       return l1 - this.versionsToKeep;
/*      */     }
/* 2131 */     long l2 = this.currentStoreVersion;
/* 2132 */     if (l2 > -1L) {
/* 2133 */       l1 = Math.min(l1, l2);
/*      */     }
/* 2135 */     return l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean isKnownVersion(long paramLong) {
/* 2147 */     if (paramLong > this.currentVersion || paramLong < 0L) {
/* 2148 */       return false;
/*      */     }
/* 2150 */     if (paramLong == this.currentVersion || this.chunks.size() == 0)
/*      */     {
/* 2152 */       return true;
/*      */     }
/*      */     
/* 2155 */     Chunk chunk = getChunkForVersion(paramLong);
/* 2156 */     if (chunk == null) {
/* 2157 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 2161 */     MVMap<String, String> mVMap = getMetaMap(paramLong);
/* 2162 */     if (mVMap == null) {
/* 2163 */       return false;
/*      */     }
/*      */     try {
/* 2166 */       Iterator<String> iterator = mVMap.keyIterator("chunk.");
/* 2167 */       while (iterator.hasNext()) {
/* 2168 */         String str = iterator.next();
/* 2169 */         if (!str.startsWith("chunk.")) {
/*      */           break;
/*      */         }
/* 2172 */         if (!this.meta.containsKey(str)) {
/* 2173 */           String str1 = mVMap.get(str);
/* 2174 */           Chunk chunk1 = Chunk.fromString(str1);
/* 2175 */           Chunk chunk2 = readChunkHeaderAndFooter(chunk1.block);
/* 2176 */           if (chunk2 == null || chunk2.id != chunk1.id) {
/* 2177 */             return false;
/*      */           }
/*      */           
/* 2180 */           this.chunks.put(Integer.valueOf(chunk1.id), chunk1);
/*      */         } 
/*      */       } 
/* 2183 */     } catch (IllegalStateException illegalStateException) {
/*      */       
/* 2185 */       return false;
/*      */     } 
/* 2187 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void registerUnsavedPage(int paramInt) {
/* 2196 */     this.unsavedMemory += paramInt;
/* 2197 */     int i = this.unsavedMemory;
/* 2198 */     if (i > this.autoCommitMemory && this.autoCommitMemory > 0) {
/* 2199 */       this.saveNeeded = true;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void beforeWrite(MVMap<?, ?> paramMVMap) {
/* 2209 */     if (this.saveNeeded) {
/* 2210 */       if (paramMVMap == this.meta) {
/*      */         return;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2217 */       this.saveNeeded = false;
/*      */       
/* 2219 */       if (this.unsavedMemory > this.autoCommitMemory && this.autoCommitMemory > 0) {
/* 2220 */         commitAndSave();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getStoreVersion() {
/* 2233 */     checkOpen();
/* 2234 */     String str = this.meta.get("setting.storeVersion");
/* 2235 */     return (str == null) ? 0 : DataUtils.parseHexInt(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void setStoreVersion(int paramInt) {
/* 2244 */     checkOpen();
/* 2245 */     markMetaChanged();
/* 2246 */     this.meta.put("setting.storeVersion", Integer.toHexString(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void rollback() {
/* 2254 */     rollbackTo(this.currentVersion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void rollbackTo(long paramLong) {
/* 2266 */     checkOpen();
/* 2267 */     if (paramLong == 0L) {
/*      */       
/* 2269 */       for (MVMap<?, ?> mVMap : this.maps.values()) {
/* 2270 */         mVMap.close();
/*      */       }
/* 2272 */       this.meta.clear();
/* 2273 */       this.chunks.clear();
/* 2274 */       if (this.fileStore != null) {
/* 2275 */         this.fileStore.clear();
/*      */       }
/* 2277 */       this.maps.clear();
/* 2278 */       this.freedPageSpace.clear();
/* 2279 */       this.currentVersion = paramLong;
/* 2280 */       setWriteVersion(paramLong);
/* 2281 */       this.metaChanged = false;
/*      */       return;
/*      */     } 
/* 2284 */     DataUtils.checkArgument(isKnownVersion(paramLong), "Unknown version {0}", new Object[] { Long.valueOf(paramLong) });
/*      */ 
/*      */     
/* 2287 */     for (MVMap<?, ?> mVMap : this.maps.values()) {
/* 2288 */       mVMap.rollbackTo(paramLong);
/*      */     }
/* 2290 */     for (long l = this.currentVersion; l >= paramLong && 
/* 2291 */       this.freedPageSpace.size() != 0; l--)
/*      */     {
/*      */       
/* 2294 */       this.freedPageSpace.remove(Long.valueOf(l));
/*      */     }
/* 2296 */     this.meta.rollbackTo(paramLong);
/* 2297 */     this.metaChanged = false;
/* 2298 */     boolean bool = false;
/*      */ 
/*      */ 
/*      */     
/* 2302 */     ArrayList<Integer> arrayList = new ArrayList();
/* 2303 */     Chunk chunk = null;
/* 2304 */     for (Chunk chunk1 : this.chunks.values()) {
/* 2305 */       if (chunk1.version > paramLong) {
/* 2306 */         arrayList.add(Integer.valueOf(chunk1.id)); continue;
/* 2307 */       }  if (chunk == null || chunk.id < chunk1.id) {
/* 2308 */         chunk = chunk1;
/*      */       }
/*      */     } 
/* 2311 */     if (arrayList.size() > 0) {
/*      */ 
/*      */       
/* 2314 */       Collections.sort(arrayList, Collections.reverseOrder());
/* 2315 */       revertTemp(paramLong);
/* 2316 */       bool = true;
/* 2317 */       for (Iterator<Integer> iterator = arrayList.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 2318 */         Chunk chunk1 = this.chunks.remove(Integer.valueOf(i));
/* 2319 */         long l1 = chunk1.block * 4096L;
/* 2320 */         int j = chunk1.len * 4096;
/* 2321 */         this.fileStore.free(l1, j);
/*      */ 
/*      */         
/* 2324 */         WriteBuffer writeBuffer = getWriteBuffer();
/* 2325 */         writeBuffer.limit(j);
/*      */         
/* 2327 */         Arrays.fill(writeBuffer.getBuffer().array(), (byte)0);
/* 2328 */         write(l1, writeBuffer.getBuffer());
/* 2329 */         releaseWriteBuffer(writeBuffer);
/*      */ 
/*      */ 
/*      */         
/* 2333 */         sync(); }
/*      */       
/* 2335 */       this.lastChunk = chunk;
/* 2336 */       writeStoreHeader();
/* 2337 */       readStoreHeader();
/*      */     } 
/* 2339 */     for (MVMap mVMap : New.arrayList(this.maps.values())) {
/* 2340 */       int i = mVMap.getId();
/* 2341 */       if (mVMap.getCreateVersion() >= paramLong) {
/* 2342 */         mVMap.close();
/* 2343 */         this.maps.remove(Integer.valueOf(i)); continue;
/*      */       } 
/* 2345 */       if (bool) {
/* 2346 */         mVMap.setRootPos(getRootPos(this.meta, i), -1L);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 2351 */     if (this.lastChunk != null) {
/* 2352 */       for (Chunk chunk1 : this.chunks.values()) {
/* 2353 */         this.meta.put(Chunk.getMetaKey(chunk1.id), chunk1.asString());
/*      */       }
/*      */     }
/* 2356 */     this.currentVersion = paramLong;
/* 2357 */     setWriteVersion(paramLong);
/*      */   }
/*      */   
/*      */   private static long getRootPos(MVMap<String, String> paramMVMap, int paramInt) {
/* 2361 */     String str = paramMVMap.get(MVMap.getMapRootKey(paramInt));
/* 2362 */     return (str == null) ? 0L : DataUtils.parseHexLong(str);
/*      */   }
/*      */   
/*      */   private void revertTemp(long paramLong) {
/* 2366 */     null = this.freedPageSpace.keySet().iterator();
/* 2367 */     while (null.hasNext()) {
/* 2368 */       long l = ((Long)null.next()).longValue();
/* 2369 */       if (l > paramLong) {
/*      */         continue;
/*      */       }
/* 2372 */       null.remove();
/*      */     } 
/* 2374 */     for (MVMap mVMap : this.maps.values()) {
/* 2375 */       mVMap.removeUnusedOldVersions();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getCurrentVersion() {
/* 2386 */     return this.currentVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FileStore getFileStore() {
/* 2395 */     return this.fileStore;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, Object> getStoreHeader() {
/* 2406 */     return this.storeHeader;
/*      */   }
/*      */   
/*      */   private void checkOpen() {
/* 2410 */     if (this.closed) {
/* 2411 */       throw DataUtils.newIllegalStateException(4, "This store is closed", new Object[] { this.panicException });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void renameMap(MVMap<?, ?> paramMVMap, String paramString) {
/* 2423 */     checkOpen();
/* 2424 */     DataUtils.checkArgument((paramMVMap != this.meta), "Renaming the meta map is not allowed", new Object[0]);
/*      */     
/* 2426 */     int i = paramMVMap.getId();
/* 2427 */     String str1 = getMapName(i);
/* 2428 */     if (str1.equals(paramString)) {
/*      */       return;
/*      */     }
/* 2431 */     DataUtils.checkArgument(!this.meta.containsKey("name." + paramString), "A map named {0} already exists", new Object[] { paramString });
/*      */ 
/*      */     
/* 2434 */     markMetaChanged();
/* 2435 */     String str2 = Integer.toHexString(i);
/* 2436 */     this.meta.remove("name." + str1);
/* 2437 */     this.meta.put(MVMap.getMapKey(i), paramMVMap.asString(paramString));
/* 2438 */     this.meta.put("name." + paramString, str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void removeMap(MVMap<?, ?> paramMVMap) {
/* 2448 */     checkOpen();
/* 2449 */     DataUtils.checkArgument((paramMVMap != this.meta), "Removing the meta map is not allowed", new Object[0]);
/*      */     
/* 2451 */     paramMVMap.clear();
/* 2452 */     int i = paramMVMap.getId();
/* 2453 */     String str = getMapName(i);
/* 2454 */     markMetaChanged();
/* 2455 */     this.meta.remove(MVMap.getMapKey(i));
/* 2456 */     this.meta.remove("name." + str);
/* 2457 */     this.meta.remove(MVMap.getMapRootKey(i));
/* 2458 */     this.maps.remove(Integer.valueOf(i));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized String getMapName(int paramInt) {
/* 2468 */     checkOpen();
/* 2469 */     String str = this.meta.get(MVMap.getMapKey(paramInt));
/* 2470 */     return (str == null) ? null : DataUtils.parseMap(str).get("name");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void writeInBackground() {
/* 2478 */     if (this.closed) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2485 */     long l = getTimeSinceCreation();
/* 2486 */     if (l <= this.lastCommitTime + this.autoCommitDelay) {
/*      */       return;
/*      */     }
/* 2489 */     if (hasUnsavedChanges()) {
/*      */       try {
/* 2491 */         commitAndSave();
/* 2492 */       } catch (Exception exception) {
/* 2493 */         if (this.backgroundExceptionHandler != null) {
/* 2494 */           this.backgroundExceptionHandler.uncaughtException(null, exception);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     }
/* 2499 */     if (this.autoCompactFillRate > 0) {
/*      */       try {
/*      */         boolean bool;
/*      */ 
/*      */         
/* 2504 */         long l1 = this.fileStore.getWriteCount() + this.fileStore.getReadCount();
/* 2505 */         if (this.autoCompactLastFileOpCount != l1) {
/* 2506 */           bool = true;
/*      */         } else {
/* 2508 */           bool = false;
/*      */         } 
/*      */         
/* 2511 */         int i = bool ? (this.autoCompactFillRate / 3) : this.autoCompactFillRate;
/*      */ 
/*      */         
/* 2514 */         compact(i, this.autoCommitMemory);
/* 2515 */         this.autoCompactLastFileOpCount = this.fileStore.getWriteCount() + this.fileStore.getReadCount();
/* 2516 */       } catch (Exception exception) {
/* 2517 */         if (this.backgroundExceptionHandler != null) {
/* 2518 */           this.backgroundExceptionHandler.uncaughtException(null, exception);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCacheSize(int paramInt) {
/* 2530 */     if (this.cache != null) {
/* 2531 */       this.cache.setMaxMemory(paramInt * 1024L * 1024L);
/* 2532 */       this.cache.clear();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isClosed() {
/* 2537 */     return this.closed;
/*      */   }
/*      */   
/*      */   private void stopBackgroundThread() {
/* 2541 */     BackgroundWriterThread backgroundWriterThread = this.backgroundWriterThread;
/* 2542 */     if (backgroundWriterThread == null) {
/*      */       return;
/*      */     }
/* 2545 */     this.backgroundWriterThread = null;
/* 2546 */     if (Thread.currentThread() == backgroundWriterThread) {
/*      */       return;
/*      */     }
/*      */     
/* 2550 */     synchronized (backgroundWriterThread.sync) {
/* 2551 */       backgroundWriterThread.sync.notifyAll();
/*      */     } 
/* 2553 */     if (Thread.holdsLock(this)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 2559 */       backgroundWriterThread.join();
/* 2560 */     } catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAutoCommitDelay(int paramInt) {
/* 2577 */     if (this.autoCommitDelay == paramInt) {
/*      */       return;
/*      */     }
/* 2580 */     this.autoCommitDelay = paramInt;
/* 2581 */     if (this.fileStore == null || this.fileStore.isReadOnly()) {
/*      */       return;
/*      */     }
/* 2584 */     stopBackgroundThread();
/*      */     
/* 2586 */     if (paramInt > 0) {
/* 2587 */       int i = Math.max(1, paramInt / 10);
/* 2588 */       BackgroundWriterThread backgroundWriterThread = new BackgroundWriterThread(this, i, this.fileStore.toString());
/*      */ 
/*      */       
/* 2591 */       backgroundWriterThread.start();
/* 2592 */       this.backgroundWriterThread = backgroundWriterThread;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAutoCommitDelay() {
/* 2602 */     return this.autoCommitDelay;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getAutoCommitMemory() {
/* 2612 */     return this.autoCommitMemory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getUnsavedMemory() {
/* 2624 */     return this.unsavedMemory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void cachePage(long paramLong, Page paramPage, int paramInt) {
/* 2635 */     if (this.cache != null) {
/* 2636 */       this.cache.put(paramLong, paramPage, paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCacheSizeUsed() {
/* 2646 */     if (this.cache == null) {
/* 2647 */       return 0;
/*      */     }
/* 2649 */     return (int)(this.cache.getUsedMemory() / 1024L / 1024L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getCacheSize() {
/* 2658 */     if (this.cache == null) {
/* 2659 */       return 0;
/*      */     }
/* 2661 */     return (int)(this.cache.getMaxMemory() / 1024L / 1024L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CacheLongKeyLIRS<Page> getCache() {
/* 2670 */     return this.cache;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isReadOnly() {
/* 2679 */     return (this.fileStore == null) ? false : this.fileStore.isReadOnly();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class BackgroundWriterThread
/*      */     extends Thread
/*      */   {
/* 2688 */     public final Object sync = new Object();
/*      */     private final MVStore store;
/*      */     private final int sleep;
/*      */     
/*      */     BackgroundWriterThread(MVStore param1MVStore, int param1Int, String param1String) {
/* 2693 */       super("MVStore background writer " + param1String);
/* 2694 */       this.store = param1MVStore;
/* 2695 */       this.sleep = param1Int;
/* 2696 */       setDaemon(true);
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/*      */       while (true) {
/* 2702 */         BackgroundWriterThread backgroundWriterThread = this.store.backgroundWriterThread;
/* 2703 */         if (backgroundWriterThread == null) {
/*      */           break;
/*      */         }
/* 2706 */         synchronized (this.sync) {
/*      */           try {
/* 2708 */             this.sync.wait(this.sleep);
/* 2709 */           } catch (InterruptedException interruptedException) {
/*      */             continue;
/*      */           } 
/*      */         } 
/* 2713 */         this.store.writeInBackground();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Builder
/*      */   {
/* 2724 */     private final HashMap<String, Object> config = New.hashMap();
/*      */     
/*      */     private Builder set(String param1String, Object param1Object) {
/* 2727 */       this.config.put(param1String, param1Object);
/* 2728 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder autoCommitDisabled() {
/* 2742 */       set("autoCommitBufferSize", Integer.valueOf(0));
/* 2743 */       return set("autoCommitDelay", Integer.valueOf(0));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder autoCommitBufferSize(int param1Int) {
/* 2760 */       return set("autoCommitBufferSize", Integer.valueOf(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder autoCompactFillRate(int param1Int) {
/* 2778 */       return set("autoCompactFillRate", Integer.valueOf(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder fileName(String param1String) {
/* 2789 */       return set("fileName", param1String);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder encryptionKey(char[] param1ArrayOfchar) {
/* 2804 */       return set("encryptionKey", param1ArrayOfchar);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder readOnly() {
/* 2820 */       return set("readOnly", Integer.valueOf(1));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder cacheSize(int param1Int) {
/* 2830 */       return set("cacheSize", Integer.valueOf(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder cacheConcurrency(int param1Int) {
/* 2841 */       return set("cacheConcurrency", Integer.valueOf(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder compress() {
/* 2856 */       return set("compress", Integer.valueOf(1));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder compressHigh() {
/* 2871 */       return set("compress", Integer.valueOf(2));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder pageSplitSize(int param1Int) {
/* 2885 */       return set("pageSplitSize", Integer.valueOf(param1Int));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder backgroundExceptionHandler(Thread.UncaughtExceptionHandler param1UncaughtExceptionHandler) {
/* 2897 */       return set("backgroundExceptionHandler", param1UncaughtExceptionHandler);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder fileStore(FileStore param1FileStore) {
/* 2914 */       return set("fileStore", param1FileStore);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public MVStore open() {
/* 2923 */       return new MVStore(this.config);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2928 */       return DataUtils.appendMap(new StringBuilder(), this.config).toString();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static Builder fromString(String param1String) {
/* 2938 */       HashMap<String, String> hashMap = DataUtils.parseMap(param1String);
/* 2939 */       Builder builder = new Builder();
/* 2940 */       builder.config.putAll(hashMap);
/* 2941 */       return builder;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\MVStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */