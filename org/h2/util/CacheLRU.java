/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CacheLRU
/*     */   implements Cache
/*     */ {
/*     */   static final String TYPE_NAME = "LRU";
/*     */   private final CacheWriter writer;
/*     */   private final boolean fifo;
/*  30 */   private final CacheObject head = new CacheHead();
/*     */ 
/*     */   
/*     */   private final int mask;
/*     */ 
/*     */   
/*     */   private CacheObject[] values;
/*     */ 
/*     */   
/*     */   private int recordCount;
/*     */ 
/*     */   
/*     */   private final int len;
/*     */ 
/*     */   
/*     */   private int maxMemory;
/*     */   
/*     */   private int memory;
/*     */ 
/*     */   
/*     */   CacheLRU(CacheWriter paramCacheWriter, int paramInt, boolean paramBoolean) {
/*  51 */     this.writer = paramCacheWriter;
/*  52 */     this.fifo = paramBoolean;
/*  53 */     setMaxMemory(paramInt);
/*  54 */     this.len = MathUtils.nextPowerOf2(this.maxMemory / 64);
/*  55 */     this.mask = this.len - 1;
/*  56 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Cache getCache(CacheWriter paramCacheWriter, String paramString, int paramInt) {
/*     */     CacheTQ cacheTQ;
/*     */     CacheSecondLevel cacheSecondLevel;
/*  69 */     SoftHashMap<Object, Object> softHashMap = null;
/*  70 */     if (paramString.startsWith("SOFT_")) {
/*  71 */       softHashMap = new SoftHashMap<>();
/*  72 */       paramString = paramString.substring("SOFT_".length());
/*     */     } 
/*     */     
/*  75 */     if ("LRU".equals(paramString)) {
/*  76 */       CacheLRU cacheLRU = new CacheLRU(paramCacheWriter, paramInt, false);
/*  77 */     } else if ("TQ".equals(paramString)) {
/*  78 */       cacheTQ = new CacheTQ(paramCacheWriter, paramInt);
/*     */     } else {
/*  80 */       throw DbException.getInvalidValueException("CACHE_TYPE", paramString);
/*     */     } 
/*  82 */     if (softHashMap != null) {
/*  83 */       cacheSecondLevel = new CacheSecondLevel(cacheTQ, (Map)softHashMap);
/*     */     }
/*  85 */     return cacheSecondLevel;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  90 */     this.head.cacheNext = this.head.cachePrevious = this.head;
/*     */     
/*  92 */     this.values = null;
/*  93 */     this.values = new CacheObject[this.len];
/*  94 */     this.recordCount = 0;
/*  95 */     this.memory = this.len * 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(CacheObject paramCacheObject) {
/* 100 */     if (SysProperties.CHECK) {
/* 101 */       int j = paramCacheObject.getPos();
/* 102 */       CacheObject cacheObject = find(j);
/* 103 */       if (cacheObject != null) {
/* 104 */         DbException.throwInternalError("try to add a record twice at pos " + j);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 109 */     int i = paramCacheObject.getPos() & this.mask;
/* 110 */     paramCacheObject.cacheChained = this.values[i];
/* 111 */     this.values[i] = paramCacheObject;
/* 112 */     this.recordCount++;
/* 113 */     this.memory += paramCacheObject.getMemory();
/* 114 */     addToFront(paramCacheObject);
/* 115 */     removeOldIfRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public CacheObject update(int paramInt, CacheObject paramCacheObject) {
/* 120 */     CacheObject cacheObject = find(paramInt);
/* 121 */     if (cacheObject == null) {
/* 122 */       put(paramCacheObject);
/*     */     } else {
/* 124 */       if (SysProperties.CHECK && 
/* 125 */         cacheObject != paramCacheObject) {
/* 126 */         DbException.throwInternalError("old!=record pos:" + paramInt + " old:" + cacheObject + " new:" + paramCacheObject);
/*     */       }
/*     */ 
/*     */       
/* 130 */       if (!this.fifo) {
/* 131 */         removeFromLinkedList(paramCacheObject);
/* 132 */         addToFront(paramCacheObject);
/*     */       } 
/*     */     } 
/* 135 */     return cacheObject;
/*     */   }
/*     */ 
/*     */   
/*     */   private void removeOldIfRequired() {
/* 140 */     if (this.memory >= this.maxMemory) {
/* 141 */       removeOld();
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeOld() {
/* 146 */     byte b = 0;
/* 147 */     ArrayList<?> arrayList = New.arrayList();
/* 148 */     int i = this.memory;
/* 149 */     int j = this.recordCount;
/* 150 */     boolean bool = false;
/* 151 */     CacheObject cacheObject = this.head.cacheNext;
/*     */     
/* 153 */     while (j > 16) {
/*     */ 
/*     */       
/* 156 */       if ((arrayList.size() == 0) ? (
/* 157 */         i <= this.maxMemory) : (
/*     */ 
/*     */ 
/*     */         
/* 161 */         i * 4 <= this.maxMemory * 3)) {
/*     */         break;
/*     */       }
/*     */       
/* 165 */       CacheObject cacheObject1 = cacheObject;
/* 166 */       cacheObject = cacheObject1.cacheNext;
/* 167 */       b++;
/* 168 */       if (b >= this.recordCount) {
/* 169 */         if (!bool) {
/* 170 */           this.writer.flushLog();
/* 171 */           bool = true;
/* 172 */           b = 0;
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 177 */           this.writer.getTrace().info("cannot remove records, cache size too small? records:" + this.recordCount + " memory:" + this.memory);
/*     */           
/*     */           break;
/*     */         } 
/*     */       }
/*     */       
/* 183 */       if (SysProperties.CHECK && cacheObject1 == this.head) {
/* 184 */         DbException.throwInternalError("try to remove head");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 189 */       if (!cacheObject1.canRemove()) {
/* 190 */         removeFromLinkedList(cacheObject1);
/* 191 */         addToFront(cacheObject1);
/*     */         continue;
/*     */       } 
/* 194 */       j--;
/* 195 */       i -= cacheObject1.getMemory();
/* 196 */       if (cacheObject1.isChanged()) {
/* 197 */         arrayList.add(cacheObject1); continue;
/*     */       } 
/* 199 */       remove(cacheObject1.getPos());
/*     */     } 
/*     */     
/* 202 */     if (arrayList.size() > 0) {
/* 203 */       if (!bool) {
/* 204 */         this.writer.flushLog();
/*     */       }
/* 206 */       Collections.sort(arrayList);
/* 207 */       int k = this.maxMemory;
/* 208 */       int m = arrayList.size();
/*     */ 
/*     */       
/*     */       try {
/* 212 */         this.maxMemory = Integer.MAX_VALUE;
/* 213 */         for (b = 0; b < m; b++) {
/* 214 */           CacheObject cacheObject1 = (CacheObject)arrayList.get(b);
/* 215 */           this.writer.writeBack(cacheObject1);
/*     */         } 
/*     */       } finally {
/* 218 */         this.maxMemory = k;
/*     */       } 
/* 220 */       for (b = 0; b < m; b++) {
/* 221 */         CacheObject cacheObject1 = (CacheObject)arrayList.get(b);
/* 222 */         remove(cacheObject1.getPos());
/* 223 */         if (SysProperties.CHECK && 
/* 224 */           cacheObject1.cacheNext != null) {
/* 225 */           throw DbException.throwInternalError();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void addToFront(CacheObject paramCacheObject) {
/* 233 */     if (SysProperties.CHECK && paramCacheObject == this.head) {
/* 234 */       DbException.throwInternalError("try to move head");
/*     */     }
/* 236 */     paramCacheObject.cacheNext = this.head;
/* 237 */     paramCacheObject.cachePrevious = this.head.cachePrevious;
/* 238 */     paramCacheObject.cachePrevious.cacheNext = paramCacheObject;
/* 239 */     this.head.cachePrevious = paramCacheObject;
/*     */   }
/*     */   
/*     */   private void removeFromLinkedList(CacheObject paramCacheObject) {
/* 243 */     if (SysProperties.CHECK && paramCacheObject == this.head) {
/* 244 */       DbException.throwInternalError("try to remove head");
/*     */     }
/* 246 */     paramCacheObject.cachePrevious.cacheNext = paramCacheObject.cacheNext;
/* 247 */     paramCacheObject.cacheNext.cachePrevious = paramCacheObject.cachePrevious;
/*     */ 
/*     */     
/* 250 */     paramCacheObject.cacheNext = null;
/* 251 */     paramCacheObject.cachePrevious = null;
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
/*     */   public boolean remove(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: iload_1
/*     */     //   1: aload_0
/*     */     //   2: getfield mask : I
/*     */     //   5: iand
/*     */     //   6: istore_2
/*     */     //   7: aload_0
/*     */     //   8: getfield values : [Lorg/h2/util/CacheObject;
/*     */     //   11: iload_2
/*     */     //   12: aaload
/*     */     //   13: astore_3
/*     */     //   14: aload_3
/*     */     //   15: ifnonnull -> 20
/*     */     //   18: iconst_0
/*     */     //   19: ireturn
/*     */     //   20: aload_3
/*     */     //   21: invokevirtual getPos : ()I
/*     */     //   24: iload_1
/*     */     //   25: if_icmpne -> 41
/*     */     //   28: aload_0
/*     */     //   29: getfield values : [Lorg/h2/util/CacheObject;
/*     */     //   32: iload_2
/*     */     //   33: aload_3
/*     */     //   34: getfield cacheChained : Lorg/h2/util/CacheObject;
/*     */     //   37: aastore
/*     */     //   38: goto -> 72
/*     */     //   41: aload_3
/*     */     //   42: astore #4
/*     */     //   44: aload_3
/*     */     //   45: getfield cacheChained : Lorg/h2/util/CacheObject;
/*     */     //   48: astore_3
/*     */     //   49: aload_3
/*     */     //   50: ifnonnull -> 55
/*     */     //   53: iconst_0
/*     */     //   54: ireturn
/*     */     //   55: aload_3
/*     */     //   56: invokevirtual getPos : ()I
/*     */     //   59: iload_1
/*     */     //   60: if_icmpne -> 41
/*     */     //   63: aload #4
/*     */     //   65: aload_3
/*     */     //   66: getfield cacheChained : Lorg/h2/util/CacheObject;
/*     */     //   69: putfield cacheChained : Lorg/h2/util/CacheObject;
/*     */     //   72: aload_0
/*     */     //   73: dup
/*     */     //   74: getfield recordCount : I
/*     */     //   77: iconst_1
/*     */     //   78: isub
/*     */     //   79: putfield recordCount : I
/*     */     //   82: aload_0
/*     */     //   83: dup
/*     */     //   84: getfield memory : I
/*     */     //   87: aload_3
/*     */     //   88: invokevirtual getMemory : ()I
/*     */     //   91: isub
/*     */     //   92: putfield memory : I
/*     */     //   95: aload_0
/*     */     //   96: aload_3
/*     */     //   97: invokespecial removeFromLinkedList : (Lorg/h2/util/CacheObject;)V
/*     */     //   100: getstatic org/h2/engine/SysProperties.CHECK : Z
/*     */     //   103: ifeq -> 147
/*     */     //   106: aload_3
/*     */     //   107: aconst_null
/*     */     //   108: putfield cacheChained : Lorg/h2/util/CacheObject;
/*     */     //   111: aload_0
/*     */     //   112: iload_1
/*     */     //   113: invokevirtual find : (I)Lorg/h2/util/CacheObject;
/*     */     //   116: astore #4
/*     */     //   118: aload #4
/*     */     //   120: ifnull -> 147
/*     */     //   123: new java/lang/StringBuilder
/*     */     //   126: dup
/*     */     //   127: invokespecial <init> : ()V
/*     */     //   130: ldc 'not removed: '
/*     */     //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   135: aload #4
/*     */     //   137: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   140: invokevirtual toString : ()Ljava/lang/String;
/*     */     //   143: invokestatic throwInternalError : (Ljava/lang/String;)Ljava/lang/RuntimeException;
/*     */     //   146: pop
/*     */     //   147: iconst_1
/*     */     //   148: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #256	-> 0
/*     */     //   #257	-> 7
/*     */     //   #258	-> 14
/*     */     //   #259	-> 18
/*     */     //   #261	-> 20
/*     */     //   #262	-> 28
/*     */     //   #266	-> 41
/*     */     //   #267	-> 44
/*     */     //   #268	-> 49
/*     */     //   #269	-> 53
/*     */     //   #271	-> 55
/*     */     //   #272	-> 63
/*     */     //   #274	-> 72
/*     */     //   #275	-> 82
/*     */     //   #276	-> 95
/*     */     //   #277	-> 100
/*     */     //   #278	-> 106
/*     */     //   #279	-> 111
/*     */     //   #280	-> 118
/*     */     //   #281	-> 123
/*     */     //   #284	-> 147
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
/*     */   public CacheObject find(int paramInt) {
/* 289 */     CacheObject cacheObject = this.values[paramInt & this.mask];
/* 290 */     while (cacheObject != null && cacheObject.getPos() != paramInt) {
/* 291 */       cacheObject = cacheObject.cacheChained;
/*     */     }
/* 293 */     return cacheObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public CacheObject get(int paramInt) {
/* 298 */     CacheObject cacheObject = find(paramInt);
/* 299 */     if (cacheObject != null && 
/* 300 */       !this.fifo) {
/* 301 */       removeFromLinkedList(cacheObject);
/* 302 */       addToFront(cacheObject);
/*     */     } 
/*     */     
/* 305 */     return cacheObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<CacheObject> getAllChanged() {
/* 342 */     ArrayList<?> arrayList = New.arrayList();
/* 343 */     CacheObject cacheObject = this.head.cacheNext;
/* 344 */     while (cacheObject != this.head) {
/* 345 */       if (cacheObject.isChanged()) {
/* 346 */         arrayList.add(cacheObject);
/*     */       }
/* 348 */       cacheObject = cacheObject.cacheNext;
/*     */     } 
/* 350 */     return (ArrayList)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxMemory(int paramInt) {
/* 355 */     int i = MathUtils.convertLongToInt(paramInt * 1024L / 4L);
/* 356 */     this.maxMemory = (i < 0) ? 0 : i;
/*     */ 
/*     */     
/* 359 */     removeOldIfRequired();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxMemory() {
/* 364 */     return (int)(this.maxMemory * 4L / 1024L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 375 */     return (int)(this.memory * 4L / 1024L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheLRU.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */