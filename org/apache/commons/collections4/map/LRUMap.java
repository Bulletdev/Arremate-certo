/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.BoundedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LRUMap<K, V>
/*     */   extends AbstractLinkedMap<K, V>
/*     */   implements Serializable, Cloneable, BoundedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = -612114643488955218L;
/*     */   protected static final int DEFAULT_MAX_SIZE = 100;
/*     */   private transient int maxSize;
/*     */   private boolean scanUntilRemovable;
/*     */   
/*     */   public LRUMap() {
/*  77 */     this(100, 0.75F, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LRUMap(int paramInt) {
/*  87 */     this(paramInt, 0.75F);
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
/*     */   public LRUMap(int paramInt1, int paramInt2) {
/* 100 */     this(paramInt1, paramInt2, 0.75F);
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
/*     */   public LRUMap(int paramInt, boolean paramBoolean) {
/* 112 */     this(paramInt, 0.75F, paramBoolean);
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
/*     */   public LRUMap(int paramInt, float paramFloat) {
/* 125 */     this(paramInt, paramFloat, false);
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
/*     */   public LRUMap(int paramInt1, int paramInt2, float paramFloat) {
/* 141 */     this(paramInt1, paramInt2, paramFloat, false);
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
/*     */   public LRUMap(int paramInt, float paramFloat, boolean paramBoolean) {
/* 155 */     this(paramInt, paramInt, paramFloat, paramBoolean);
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
/*     */   public LRUMap(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean) {
/* 175 */     super(paramInt2, paramFloat);
/* 176 */     if (paramInt1 < 1) {
/* 177 */       throw new IllegalArgumentException("LRUMap max size must be greater than 0");
/*     */     }
/* 179 */     if (paramInt2 > paramInt1) {
/* 180 */       throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
/*     */     }
/* 182 */     this.maxSize = paramInt1;
/* 183 */     this.scanUntilRemovable = paramBoolean;
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
/*     */   public LRUMap(Map<? extends K, ? extends V> paramMap) {
/* 196 */     this(paramMap, false);
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
/*     */   public LRUMap(Map<? extends K, ? extends V> paramMap, boolean paramBoolean) {
/* 211 */     this(paramMap.size(), 0.75F, paramBoolean);
/* 212 */     putAll(paramMap);
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
/*     */   public V get(Object paramObject) {
/* 227 */     return get(paramObject, true);
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
/*     */   public V get(Object paramObject, boolean paramBoolean) {
/* 244 */     AbstractLinkedMap.LinkEntry<K, V> linkEntry = getEntry(paramObject);
/* 245 */     if (linkEntry == null) {
/* 246 */       return null;
/*     */     }
/* 248 */     if (paramBoolean) {
/* 249 */       moveToMRU(linkEntry);
/*     */     }
/* 251 */     return linkEntry.getValue();
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
/*     */   protected void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> paramLinkEntry) {
/* 263 */     if (paramLinkEntry.after != this.header) {
/* 264 */       this.modCount++;
/*     */       
/* 266 */       if (paramLinkEntry.before == null) {
/* 267 */         throw new IllegalStateException("Entry.before is null. Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
/*     */       }
/*     */ 
/*     */       
/* 271 */       paramLinkEntry.before.after = paramLinkEntry.after;
/* 272 */       paramLinkEntry.after.before = paramLinkEntry.before;
/*     */       
/* 274 */       paramLinkEntry.after = this.header;
/* 275 */       paramLinkEntry.before = this.header.before;
/* 276 */       this.header.before.after = paramLinkEntry;
/* 277 */       this.header.before = paramLinkEntry;
/* 278 */     } else if (paramLinkEntry == this.header) {
/* 279 */       throw new IllegalStateException("Can't move header to MRU (please report this to dev@commons.apache.org)");
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
/*     */   protected void updateEntry(AbstractHashedMap.HashEntry<K, V> paramHashEntry, V paramV) {
/* 295 */     moveToMRU((AbstractLinkedMap.LinkEntry<K, V>)paramHashEntry);
/* 296 */     paramHashEntry.setValue(paramV);
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
/*     */   protected void addMapping(int paramInt1, int paramInt2, K paramK, V paramV) {
/* 316 */     if (isFull()) {
/* 317 */       AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after;
/* 318 */       boolean bool = false;
/* 319 */       if (this.scanUntilRemovable) {
/* 320 */         while (linkEntry != this.header && linkEntry != null) {
/* 321 */           if (removeLRU(linkEntry)) {
/* 322 */             bool = true;
/*     */             break;
/*     */           } 
/* 325 */           linkEntry = linkEntry.after;
/*     */         } 
/* 327 */         if (linkEntry == null) {
/* 328 */           throw new IllegalStateException("Entry.after=null, header.after" + this.header.after + " header.before" + this.header.before + " key=" + paramK + " value=" + paramV + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 335 */         bool = removeLRU(linkEntry);
/*     */       } 
/*     */       
/* 338 */       if (bool) {
/* 339 */         if (linkEntry == null) {
/* 340 */           throw new IllegalStateException("reuse=null, header.after=" + this.header.after + " header.before" + this.header.before + " key=" + paramK + " value=" + paramV + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 346 */         reuseMapping(linkEntry, paramInt1, paramInt2, paramK, paramV);
/*     */       } else {
/* 348 */         super.addMapping(paramInt1, paramInt2, paramK, paramV);
/*     */       } 
/*     */     } else {
/* 351 */       super.addMapping(paramInt1, paramInt2, paramK, paramV);
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
/*     */   
/*     */   protected void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> paramLinkEntry, int paramInt1, int paramInt2, K paramK, V paramV) {
/*     */     try {
/* 372 */       int i = hashIndex(paramLinkEntry.hashCode, this.data.length);
/* 373 */       AbstractHashedMap.HashEntry<K, V>[] arrayOfHashEntry = this.data;
/* 374 */       AbstractHashedMap.HashEntry<K, V> hashEntry1 = arrayOfHashEntry[i];
/* 375 */       AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
/* 376 */       while (hashEntry1 != paramLinkEntry && hashEntry1 != null) {
/* 377 */         hashEntry2 = hashEntry1;
/* 378 */         hashEntry1 = hashEntry1.next;
/*     */       } 
/* 380 */       if (hashEntry1 == null) {
/* 381 */         throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + this.data[i] + " previous=" + hashEntry2 + " key=" + paramK + " value=" + paramV + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 389 */       this.modCount++;
/* 390 */       removeEntry(paramLinkEntry, i, hashEntry2);
/* 391 */       reuseEntry(paramLinkEntry, paramInt1, paramInt2, paramK, paramV);
/* 392 */       addEntry(paramLinkEntry, paramInt1);
/* 393 */     } catch (NullPointerException nullPointerException) {
/* 394 */       throw new IllegalStateException("NPE, entry=" + paramLinkEntry + " entryIsHeader=" + ((paramLinkEntry == this.header) ? 1 : 0) + " key=" + paramK + " value=" + paramV + " size=" + this.size + " maxSize=" + this.maxSize + " Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> paramLinkEntry) {
/* 437 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 447 */     return (this.size >= this.maxSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int maxSize() {
/* 456 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isScanUntilRemovable() {
/* 467 */     return this.scanUntilRemovable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LRUMap<K, V> clone() {
/* 478 */     return (LRUMap<K, V>)super.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 485 */     paramObjectOutputStream.defaultWriteObject();
/* 486 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 493 */     paramObjectInputStream.defaultReadObject();
/* 494 */     doReadObject(paramObjectInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 505 */     paramObjectOutputStream.writeInt(this.maxSize);
/* 506 */     super.doWriteObject(paramObjectOutputStream);
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
/*     */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 518 */     this.maxSize = paramObjectInputStream.readInt();
/* 519 */     super.doReadObject(paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\LRUMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */