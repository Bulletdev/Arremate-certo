/*     */ package org.h2.mvstore.rtree;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.h2.mvstore.CursorPos;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.mvstore.Page;
/*     */ import org.h2.mvstore.type.DataType;
/*     */ import org.h2.mvstore.type.ObjectDataType;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MVRTreeMap<V>
/*     */   extends MVMap<SpatialKey, V>
/*     */ {
/*     */   final SpatialDataType keyType;
/*     */   private boolean quadraticSplit;
/*     */   
/*     */   public MVRTreeMap(int paramInt, DataType paramDataType) {
/*  35 */     super(new SpatialDataType(paramInt), paramDataType);
/*  36 */     this.keyType = (SpatialDataType)getKeyType();
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
/*     */   public static <V> MVRTreeMap<V> create(int paramInt, DataType paramDataType) {
/*  48 */     return new MVRTreeMap<>(paramInt, paramDataType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/*  54 */     return (V)get(this.root, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RTreeCursor findIntersectingKeys(SpatialKey paramSpatialKey) {
/*  64 */     return new RTreeCursor(this.root, paramSpatialKey)
/*     */       {
/*     */         protected boolean check(boolean param1Boolean, SpatialKey param1SpatialKey1, SpatialKey param1SpatialKey2)
/*     */         {
/*  68 */           return MVRTreeMap.this.keyType.isOverlap(param1SpatialKey1, param1SpatialKey2);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RTreeCursor findContainedKeys(SpatialKey paramSpatialKey) {
/*  81 */     return new RTreeCursor(this.root, paramSpatialKey)
/*     */       {
/*     */         protected boolean check(boolean param1Boolean, SpatialKey param1SpatialKey1, SpatialKey param1SpatialKey2)
/*     */         {
/*  85 */           if (param1Boolean) {
/*  86 */             return MVRTreeMap.this.keyType.isInside(param1SpatialKey1, param1SpatialKey2);
/*     */           }
/*  88 */           return MVRTreeMap.this.keyType.isOverlap(param1SpatialKey1, param1SpatialKey2);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private boolean contains(Page paramPage, int paramInt, Object paramObject) {
/*  94 */     return this.keyType.contains(paramPage.getKey(paramInt), paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object get(Page paramPage, Object paramObject) {
/* 105 */     if (!paramPage.isLeaf()) {
/* 106 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 107 */         if (contains(paramPage, b, paramObject)) {
/* 108 */           Object object = get(paramPage.getChildPage(b), paramObject);
/* 109 */           if (object != null) {
/* 110 */             return object;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/* 115 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 116 */         if (this.keyType.equals(paramPage.getKey(b), paramObject)) {
/* 117 */           return paramPage.getValue(b);
/*     */         }
/*     */       } 
/*     */     } 
/* 121 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected synchronized Object remove(Page paramPage, long paramLong, Object paramObject) {
/* 126 */     Object object = null;
/* 127 */     if (paramPage.isLeaf()) {
/* 128 */       for (byte b1 = 0; b1 < paramPage.getKeyCount(); b1++) {
/* 129 */         if (this.keyType.equals(paramPage.getKey(b1), paramObject)) {
/* 130 */           object = paramPage.getValue(b1);
/* 131 */           paramPage.remove(b1);
/*     */           break;
/*     */         } 
/*     */       } 
/* 135 */       return object;
/*     */     } 
/* 137 */     for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 138 */       if (contains(paramPage, b, paramObject)) {
/* 139 */         Page page1 = paramPage.getChildPage(b);
/*     */ 
/*     */ 
/*     */         
/* 143 */         Page page2 = page1.copy(paramLong);
/* 144 */         long l = page2.getTotalCount();
/* 145 */         object = remove(page2, paramLong, paramObject);
/* 146 */         paramPage.setChild(b, page2);
/* 147 */         if (l != page2.getTotalCount()) {
/*     */ 
/*     */           
/* 150 */           if (page2.getTotalCount() == 0L) {
/*     */             
/* 152 */             paramPage.remove(b);
/* 153 */             if (paramPage.getKeyCount() == 0) {
/* 154 */               page2.removePage();
/*     */             }
/*     */             break;
/*     */           } 
/* 158 */           Object object1 = paramPage.getKey(b);
/* 159 */           if (!this.keyType.isInside(paramObject, object1))
/* 160 */             paramPage.setKey(b, getBounds(page2)); 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 165 */     return object;
/*     */   }
/*     */   
/*     */   private Object getBounds(Page paramPage) {
/* 169 */     Object object = this.keyType.createBoundingBox(paramPage.getKey(0));
/* 170 */     for (byte b = 1; b < paramPage.getKeyCount(); b++) {
/* 171 */       this.keyType.increaseBounds(object, paramPage.getKey(b));
/*     */     }
/* 173 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(SpatialKey paramSpatialKey, V paramV) {
/* 179 */     return (V)putOrAdd(paramSpatialKey, paramV, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(SpatialKey paramSpatialKey, V paramV) {
/* 190 */     putOrAdd(paramSpatialKey, paramV, true);
/*     */   }
/*     */   private synchronized Object putOrAdd(SpatialKey paramSpatialKey, V paramV, boolean paramBoolean) {
/*     */     Object object;
/* 194 */     beforeWrite();
/* 195 */     long l = this.writeVersion;
/* 196 */     Page page = this.root.copy(l);
/*     */     
/* 198 */     if (paramBoolean || get(paramSpatialKey) == null) {
/* 199 */       if (page.getMemory() > this.store.getPageSplitSize() && page.getKeyCount() > 3) {
/*     */ 
/*     */ 
/*     */         
/* 203 */         long l1 = page.getTotalCount();
/* 204 */         Page page1 = split(page, l);
/* 205 */         Object object1 = getBounds(page);
/* 206 */         Object object2 = getBounds(page1);
/* 207 */         Object[] arrayOfObject = { object1, object2 };
/* 208 */         Page.PageReference[] arrayOfPageReference = { new Page.PageReference(page, page.getPos(), page.getTotalCount()), new Page.PageReference(page1, page1.getPos(), page1.getTotalCount()), new Page.PageReference(null, 0L, 0L) };
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 213 */         page = Page.create(this, l, arrayOfObject, null, arrayOfPageReference, l1, 0);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 219 */       add(page, l, paramSpatialKey, paramV);
/* 220 */       object = null;
/*     */     } else {
/* 222 */       object = set(page, l, paramSpatialKey, paramV);
/*     */     } 
/* 224 */     newRoot(page);
/* 225 */     return object;
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
/*     */   private Object set(Page paramPage, long paramLong, Object paramObject1, Object paramObject2) {
/* 238 */     if (paramPage.isLeaf()) {
/* 239 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 240 */         if (this.keyType.equals(paramPage.getKey(b), paramObject1)) {
/* 241 */           paramPage.setKey(b, paramObject1);
/* 242 */           return paramPage.setValue(b, paramObject2);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 246 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 247 */         if (contains(paramPage, b, paramObject1)) {
/* 248 */           Page page = paramPage.getChildPage(b);
/* 249 */           if (get(page, paramObject1) != null) {
/* 250 */             page = page.copy(paramLong);
/* 251 */             Object object = set(page, paramLong, paramObject1, paramObject2);
/* 252 */             paramPage.setChild(b, page);
/* 253 */             return object;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 258 */     throw DataUtils.newIllegalStateException(3, "Not found: {0}", new Object[] { paramObject1 });
/*     */   }
/*     */ 
/*     */   
/*     */   private void add(Page paramPage, long paramLong, Object paramObject1, Object paramObject2) {
/* 263 */     if (paramPage.isLeaf()) {
/* 264 */       paramPage.insertLeaf(paramPage.getKeyCount(), paramObject1, paramObject2);
/*     */       
/*     */       return;
/*     */     } 
/* 268 */     byte b = -1;
/* 269 */     for (byte b1 = 0; b1 < paramPage.getKeyCount(); b1++) {
/* 270 */       if (contains(paramPage, b1, paramObject1)) {
/* 271 */         b = b1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 275 */     if (b < 0) {
/*     */       
/* 277 */       float f = Float.MAX_VALUE;
/* 278 */       for (byte b2 = 0; b2 < paramPage.getKeyCount(); b2++) {
/* 279 */         Object object1 = paramPage.getKey(b2);
/* 280 */         float f1 = this.keyType.getAreaIncrease(object1, paramObject1);
/* 281 */         if (f1 < f) {
/* 282 */           b = b2;
/* 283 */           f = f1;
/*     */         } 
/*     */       } 
/*     */     } 
/* 287 */     Page page = paramPage.getChildPage(b).copy(paramLong);
/* 288 */     if (page.getMemory() > this.store.getPageSplitSize() && page.getKeyCount() > 4) {
/*     */       
/* 290 */       Page page1 = split(page, paramLong);
/* 291 */       paramPage.setKey(b, getBounds(page));
/* 292 */       paramPage.setChild(b, page);
/* 293 */       paramPage.insertNode(b, getBounds(page1), page1);
/*     */       
/* 295 */       add(paramPage, paramLong, paramObject1, paramObject2);
/*     */       return;
/*     */     } 
/* 298 */     add(page, paramLong, paramObject1, paramObject2);
/* 299 */     Object object = paramPage.getKey(b);
/* 300 */     this.keyType.increaseBounds(object, paramObject1);
/* 301 */     paramPage.setKey(b, object);
/* 302 */     paramPage.setChild(b, page);
/*     */   }
/*     */   
/*     */   private Page split(Page paramPage, long paramLong) {
/* 306 */     return this.quadraticSplit ? splitQuadratic(paramPage, paramLong) : splitLinear(paramPage, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Page splitLinear(Page paramPage, long paramLong) {
/* 312 */     ArrayList<Object> arrayList = New.arrayList();
/* 313 */     for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 314 */       arrayList.add(paramPage.getKey(b));
/*     */     }
/* 316 */     int[] arrayOfInt = this.keyType.getExtremes(arrayList);
/* 317 */     if (arrayOfInt == null) {
/* 318 */       return splitQuadratic(paramPage, paramLong);
/*     */     }
/* 320 */     Page page1 = newPage(paramPage.isLeaf(), paramLong);
/* 321 */     Page page2 = newPage(paramPage.isLeaf(), paramLong);
/* 322 */     move(paramPage, page1, arrayOfInt[0]);
/* 323 */     if (arrayOfInt[1] > arrayOfInt[0]) {
/* 324 */       arrayOfInt[1] = arrayOfInt[1] - 1;
/*     */     }
/* 326 */     move(paramPage, page2, arrayOfInt[1]);
/* 327 */     Object object1 = this.keyType.createBoundingBox(page1.getKey(0));
/* 328 */     Object object2 = this.keyType.createBoundingBox(page2.getKey(0));
/* 329 */     while (paramPage.getKeyCount() > 0) {
/* 330 */       Object object = paramPage.getKey(0);
/* 331 */       float f1 = this.keyType.getAreaIncrease(object1, object);
/* 332 */       float f2 = this.keyType.getAreaIncrease(object2, object);
/* 333 */       if (f1 < f2) {
/* 334 */         this.keyType.increaseBounds(object1, object);
/* 335 */         move(paramPage, page1, 0); continue;
/*     */       } 
/* 337 */       this.keyType.increaseBounds(object2, object);
/* 338 */       move(paramPage, page2, 0);
/*     */     } 
/*     */     
/* 341 */     while (page2.getKeyCount() > 0) {
/* 342 */       move(page2, paramPage, 0);
/*     */     }
/* 344 */     return page1;
/*     */   }
/*     */   
/*     */   private Page splitQuadratic(Page paramPage, long paramLong) {
/* 348 */     Page page1 = newPage(paramPage.isLeaf(), paramLong);
/* 349 */     Page page2 = newPage(paramPage.isLeaf(), paramLong);
/* 350 */     float f = Float.MIN_VALUE;
/* 351 */     byte b1 = 0, b2 = 0;
/* 352 */     for (byte b3 = 0; b3 < paramPage.getKeyCount(); b3++) {
/* 353 */       Object object = paramPage.getKey(b3);
/* 354 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 355 */         if (b3 != b) {
/*     */ 
/*     */           
/* 358 */           Object object3 = paramPage.getKey(b);
/* 359 */           float f1 = this.keyType.getCombinedArea(object, object3);
/* 360 */           if (f1 > f) {
/* 361 */             f = f1;
/* 362 */             b1 = b3;
/* 363 */             b2 = b;
/*     */           } 
/*     */         } 
/*     */       } 
/* 367 */     }  move(paramPage, page1, b1);
/* 368 */     if (b1 < b2) {
/* 369 */       b2--;
/*     */     }
/* 371 */     move(paramPage, page2, b2);
/* 372 */     Object object1 = this.keyType.createBoundingBox(page1.getKey(0));
/* 373 */     Object object2 = this.keyType.createBoundingBox(page2.getKey(0));
/* 374 */     while (paramPage.getKeyCount() > 0) {
/* 375 */       float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F;
/* 376 */       byte b4 = 0;
/* 377 */       for (byte b5 = 0; b5 < paramPage.getKeyCount(); b5++) {
/* 378 */         Object object = paramPage.getKey(b5);
/* 379 */         float f4 = this.keyType.getAreaIncrease(object1, object);
/* 380 */         float f5 = this.keyType.getAreaIncrease(object2, object);
/* 381 */         float f6 = Math.abs(f4 - f5);
/* 382 */         if (f6 > f1) {
/* 383 */           f1 = f6;
/* 384 */           f2 = f4;
/* 385 */           f3 = f5;
/* 386 */           b4 = b5;
/*     */         } 
/*     */       } 
/* 389 */       if (f2 < f3) {
/* 390 */         this.keyType.increaseBounds(object1, paramPage.getKey(b4));
/* 391 */         move(paramPage, page1, b4); continue;
/*     */       } 
/* 393 */       this.keyType.increaseBounds(object2, paramPage.getKey(b4));
/* 394 */       move(paramPage, page2, b4);
/*     */     } 
/*     */     
/* 397 */     while (page2.getKeyCount() > 0) {
/* 398 */       move(page2, paramPage, 0);
/*     */     }
/* 400 */     return page1;
/*     */   }
/*     */   
/*     */   private Page newPage(boolean paramBoolean, long paramLong) {
/*     */     Object[] arrayOfObject;
/*     */     Page.PageReference[] arrayOfPageReference;
/* 406 */     if (paramBoolean) {
/* 407 */       arrayOfObject = Page.EMPTY_OBJECT_ARRAY;
/* 408 */       arrayOfPageReference = null;
/*     */     } else {
/* 410 */       arrayOfObject = null;
/* 411 */       arrayOfPageReference = new Page.PageReference[] { new Page.PageReference(null, 0L, 0L) };
/*     */     } 
/*     */     
/* 414 */     return Page.create(this, paramLong, Page.EMPTY_OBJECT_ARRAY, arrayOfObject, arrayOfPageReference, 0L, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void move(Page paramPage1, Page paramPage2, int paramInt) {
/* 420 */     Object object = paramPage1.getKey(paramInt);
/* 421 */     if (paramPage1.isLeaf()) {
/* 422 */       Object object1 = paramPage1.getValue(paramInt);
/* 423 */       paramPage2.insertLeaf(0, object, object1);
/*     */     } else {
/* 425 */       Page page = paramPage1.getChildPage(paramInt);
/* 426 */       paramPage2.insertNode(0, object, page);
/*     */     } 
/* 428 */     paramPage1.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNodeKeys(ArrayList<SpatialKey> paramArrayList, Page paramPage) {
/* 439 */     if (paramPage != null && !paramPage.isLeaf()) {
/* 440 */       for (byte b = 0; b < paramPage.getKeyCount(); b++) {
/* 441 */         paramArrayList.add((SpatialKey)paramPage.getKey(b));
/* 442 */         addNodeKeys(paramArrayList, paramPage.getChildPage(b));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isQuadraticSplit() {
/* 448 */     return this.quadraticSplit;
/*     */   }
/*     */   
/*     */   public void setQuadraticSplit(boolean paramBoolean) {
/* 452 */     this.quadraticSplit = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getChildPageCount(Page paramPage) {
/* 457 */     return paramPage.getRawChildPageCount() - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class RTreeCursor
/*     */     implements Iterator<SpatialKey>
/*     */   {
/*     */     private final SpatialKey filter;
/*     */     
/*     */     private CursorPos pos;
/*     */     private SpatialKey current;
/*     */     private final Page root;
/*     */     private boolean initialized;
/*     */     
/*     */     protected RTreeCursor(Page param1Page, SpatialKey param1SpatialKey) {
/* 472 */       this.root = param1Page;
/* 473 */       this.filter = param1SpatialKey;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 478 */       if (!this.initialized) {
/*     */         
/* 480 */         this.pos = new CursorPos(this.root, 0, null);
/* 481 */         fetchNext();
/* 482 */         this.initialized = true;
/*     */       } 
/* 484 */       return (this.current != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void skip(long param1Long) {
/* 494 */       while (hasNext() && param1Long-- > 0L) {
/* 495 */         fetchNext();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public SpatialKey next() {
/* 501 */       if (!hasNext()) {
/* 502 */         return null;
/*     */       }
/* 504 */       SpatialKey spatialKey = this.current;
/* 505 */       fetchNext();
/* 506 */       return spatialKey;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 511 */       throw DataUtils.newUnsupportedOperationException("Removing is not supported");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void fetchNext() {
/* 519 */       while (this.pos != null) {
/* 520 */         Page page = this.pos.page;
/* 521 */         if (page.isLeaf()) {
/* 522 */           while (this.pos.index < page.getKeyCount()) {
/* 523 */             SpatialKey spatialKey = (SpatialKey)page.getKey(this.pos.index++);
/* 524 */             if (this.filter == null || check(true, spatialKey, this.filter)) {
/* 525 */               this.current = spatialKey;
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 530 */           boolean bool = false;
/* 531 */           while (this.pos.index < page.getKeyCount()) {
/* 532 */             int i = this.pos.index++;
/* 533 */             SpatialKey spatialKey = (SpatialKey)page.getKey(i);
/* 534 */             if (this.filter == null || check(false, spatialKey, this.filter)) {
/* 535 */               Page page1 = this.pos.page.getChildPage(i);
/* 536 */               this.pos = new CursorPos(page1, 0, this.pos);
/* 537 */               bool = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 541 */           if (bool) {
/*     */             continue;
/*     */           }
/*     */         } 
/*     */         
/* 546 */         this.pos = this.pos.parent;
/*     */       } 
/* 548 */       this.current = null;
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
/*     */     protected boolean check(boolean param1Boolean, SpatialKey param1SpatialKey1, SpatialKey param1SpatialKey2) {
/* 560 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 567 */     return "rtree";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder<V>
/*     */     implements MVMap.MapBuilder<MVRTreeMap<V>, SpatialKey, V>
/*     */   {
/* 578 */     private int dimensions = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private DataType valueType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<V> dimensions(int param1Int) {
/* 595 */       this.dimensions = param1Int;
/* 596 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder<V> valueType(DataType param1DataType) {
/* 606 */       this.valueType = param1DataType;
/* 607 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public MVRTreeMap<V> create() {
/* 612 */       if (this.valueType == null) {
/* 613 */         this.valueType = (DataType)new ObjectDataType();
/*     */       }
/* 615 */       return new MVRTreeMap<>(this.dimensions, this.valueType);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\rtree\MVRTreeMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */