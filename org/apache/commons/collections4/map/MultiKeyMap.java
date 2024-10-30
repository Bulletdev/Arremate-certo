/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.keyvalue.MultiKey;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiKeyMap<K, V>
/*     */   extends AbstractMapDecorator<MultiKey<? extends K>, V>
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = -1788199231038721040L;
/*     */   
/*     */   public static <K, V> MultiKeyMap<K, V> multiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> paramAbstractHashedMap) {
/*  97 */     if (paramAbstractHashedMap == null) {
/*  98 */       throw new NullPointerException("Map must not be null");
/*     */     }
/* 100 */     if (paramAbstractHashedMap.size() > 0) {
/* 101 */       throw new IllegalArgumentException("Map must be empty");
/*     */     }
/* 103 */     return new MultiKeyMap<K, V>(paramAbstractHashedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MultiKeyMap() {
/* 111 */     this(new HashedMap<MultiKey<? extends K>, V>());
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
/*     */   protected MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> paramAbstractHashedMap) {
/* 123 */     super(paramAbstractHashedMap);
/* 124 */     this.map = paramAbstractHashedMap;
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
/*     */   public V get(Object paramObject1, Object paramObject2) {
/* 136 */     int i = hash(paramObject1, paramObject2);
/* 137 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 139 */     while (hashEntry != null) {
/* 140 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2)) {
/* 141 */         return hashEntry.getValue();
/*     */       }
/* 143 */       hashEntry = hashEntry.next;
/*     */     } 
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject1, Object paramObject2) {
/* 156 */     int i = hash(paramObject1, paramObject2);
/* 157 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 159 */     while (hashEntry != null) {
/* 160 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2)) {
/* 161 */         return true;
/*     */       }
/* 163 */       hashEntry = hashEntry.next;
/*     */     } 
/* 165 */     return false;
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
/*     */   public V put(K paramK1, K paramK2, V paramV) {
/* 177 */     int i = hash(paramK1, paramK2);
/* 178 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 179 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[j];
/* 180 */     while (hashEntry != null) {
/* 181 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramK1, paramK2)) {
/* 182 */         V v = hashEntry.getValue();
/* 183 */         decorated().updateEntry(hashEntry, paramV);
/* 184 */         return v;
/*     */       } 
/* 186 */       hashEntry = hashEntry.next;
/*     */     } 
/* 188 */     decorated().addMapping(j, i, new MultiKey(paramK1, paramK2), paramV);
/* 189 */     return null;
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
/*     */   public V removeMultiKey(Object paramObject1, Object paramObject2) {
/* 201 */     int i = hash(paramObject1, paramObject2);
/* 202 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 203 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry1 = (decorated()).data[j];
/* 204 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry2 = null;
/* 205 */     while (hashEntry1 != null) {
/* 206 */       if (hashEntry1.hashCode == i && isEqualKey(hashEntry1, paramObject1, paramObject2)) {
/* 207 */         V v = hashEntry1.getValue();
/* 208 */         decorated().removeMapping(hashEntry1, j, hashEntry2);
/* 209 */         return v;
/*     */       } 
/* 211 */       hashEntry2 = hashEntry1;
/* 212 */       hashEntry1 = hashEntry1.next;
/*     */     } 
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int hash(Object paramObject1, Object paramObject2) {
/* 225 */     int i = 0;
/* 226 */     if (paramObject1 != null) {
/* 227 */       i ^= paramObject1.hashCode();
/*     */     }
/* 229 */     if (paramObject2 != null) {
/* 230 */       i ^= paramObject2.hashCode();
/*     */     }
/* 232 */     i += i << 9 ^ 0xFFFFFFFF;
/* 233 */     i ^= i >>> 14;
/* 234 */     i += i << 4;
/* 235 */     i ^= i >>> 10;
/* 236 */     return i;
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
/*     */   protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> paramHashEntry, Object paramObject1, Object paramObject2) {
/* 249 */     MultiKey multiKey = paramHashEntry.getKey();
/* 250 */     return (multiKey.size() == 2 && (paramObject1 == multiKey.getKey(0) || (paramObject1 != null && paramObject1.equals(multiKey.getKey(0)))) && (paramObject2 == multiKey.getKey(1) || (paramObject2 != null && paramObject2.equals(multiKey.getKey(1)))));
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
/*     */   public V get(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 266 */     int i = hash(paramObject1, paramObject2, paramObject3);
/* 267 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 269 */     while (hashEntry != null) {
/* 270 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3)) {
/* 271 */         return hashEntry.getValue();
/*     */       }
/* 273 */       hashEntry = hashEntry.next;
/*     */     } 
/* 275 */     return null;
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
/*     */   public boolean containsKey(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 287 */     int i = hash(paramObject1, paramObject2, paramObject3);
/* 288 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 290 */     while (hashEntry != null) {
/* 291 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3)) {
/* 292 */         return true;
/*     */       }
/* 294 */       hashEntry = hashEntry.next;
/*     */     } 
/* 296 */     return false;
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
/*     */   public V put(K paramK1, K paramK2, K paramK3, V paramV) {
/* 309 */     int i = hash(paramK1, paramK2, paramK3);
/* 310 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 311 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[j];
/* 312 */     while (hashEntry != null) {
/* 313 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramK1, paramK2, paramK3)) {
/* 314 */         V v = hashEntry.getValue();
/* 315 */         decorated().updateEntry(hashEntry, paramV);
/* 316 */         return v;
/*     */       } 
/* 318 */       hashEntry = hashEntry.next;
/*     */     } 
/* 320 */     decorated().addMapping(j, i, new MultiKey(paramK1, paramK2, paramK3), paramV);
/* 321 */     return null;
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
/*     */   public V removeMultiKey(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 334 */     int i = hash(paramObject1, paramObject2, paramObject3);
/* 335 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 336 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry1 = (decorated()).data[j];
/* 337 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry2 = null;
/* 338 */     while (hashEntry1 != null) {
/* 339 */       if (hashEntry1.hashCode == i && isEqualKey(hashEntry1, paramObject1, paramObject2, paramObject3)) {
/* 340 */         V v = hashEntry1.getValue();
/* 341 */         decorated().removeMapping(hashEntry1, j, hashEntry2);
/* 342 */         return v;
/*     */       } 
/* 344 */       hashEntry2 = hashEntry1;
/* 345 */       hashEntry1 = hashEntry1.next;
/*     */     } 
/* 347 */     return null;
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
/*     */   protected int hash(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 359 */     int i = 0;
/* 360 */     if (paramObject1 != null) {
/* 361 */       i ^= paramObject1.hashCode();
/*     */     }
/* 363 */     if (paramObject2 != null) {
/* 364 */       i ^= paramObject2.hashCode();
/*     */     }
/* 366 */     if (paramObject3 != null) {
/* 367 */       i ^= paramObject3.hashCode();
/*     */     }
/* 369 */     i += i << 9 ^ 0xFFFFFFFF;
/* 370 */     i ^= i >>> 14;
/* 371 */     i += i << 4;
/* 372 */     i ^= i >>> 10;
/* 373 */     return i;
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
/*     */   protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> paramHashEntry, Object paramObject1, Object paramObject2, Object paramObject3) {
/* 387 */     MultiKey multiKey = paramHashEntry.getKey();
/* 388 */     return (multiKey.size() == 3 && (paramObject1 == multiKey.getKey(0) || (paramObject1 != null && paramObject1.equals(multiKey.getKey(0)))) && (paramObject2 == multiKey.getKey(1) || (paramObject2 != null && paramObject2.equals(multiKey.getKey(1)))) && (paramObject3 == multiKey.getKey(2) || (paramObject3 != null && paramObject3.equals(multiKey.getKey(2)))));
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
/*     */   public V get(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 406 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4);
/* 407 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 409 */     while (hashEntry != null) {
/* 410 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3, paramObject4)) {
/* 411 */         return hashEntry.getValue();
/*     */       }
/* 413 */       hashEntry = hashEntry.next;
/*     */     } 
/* 415 */     return null;
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
/*     */   public boolean containsKey(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 428 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4);
/* 429 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 431 */     while (hashEntry != null) {
/* 432 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3, paramObject4)) {
/* 433 */         return true;
/*     */       }
/* 435 */       hashEntry = hashEntry.next;
/*     */     } 
/* 437 */     return false;
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
/*     */   public V put(K paramK1, K paramK2, K paramK3, K paramK4, V paramV) {
/* 451 */     int i = hash(paramK1, paramK2, paramK3, paramK4);
/* 452 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 453 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[j];
/* 454 */     while (hashEntry != null) {
/* 455 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramK1, paramK2, paramK3, paramK4)) {
/* 456 */         V v = hashEntry.getValue();
/* 457 */         decorated().updateEntry(hashEntry, paramV);
/* 458 */         return v;
/*     */       } 
/* 460 */       hashEntry = hashEntry.next;
/*     */     } 
/* 462 */     decorated().addMapping(j, i, new MultiKey(paramK1, paramK2, paramK3, paramK4), paramV);
/* 463 */     return null;
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
/*     */   public V removeMultiKey(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 477 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4);
/* 478 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 479 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry1 = (decorated()).data[j];
/* 480 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry2 = null;
/* 481 */     while (hashEntry1 != null) {
/* 482 */       if (hashEntry1.hashCode == i && isEqualKey(hashEntry1, paramObject1, paramObject2, paramObject3, paramObject4)) {
/* 483 */         V v = hashEntry1.getValue();
/* 484 */         decorated().removeMapping(hashEntry1, j, hashEntry2);
/* 485 */         return v;
/*     */       } 
/* 487 */       hashEntry2 = hashEntry1;
/* 488 */       hashEntry1 = hashEntry1.next;
/*     */     } 
/* 490 */     return null;
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
/*     */   protected int hash(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 503 */     int i = 0;
/* 504 */     if (paramObject1 != null) {
/* 505 */       i ^= paramObject1.hashCode();
/*     */     }
/* 507 */     if (paramObject2 != null) {
/* 508 */       i ^= paramObject2.hashCode();
/*     */     }
/* 510 */     if (paramObject3 != null) {
/* 511 */       i ^= paramObject3.hashCode();
/*     */     }
/* 513 */     if (paramObject4 != null) {
/* 514 */       i ^= paramObject4.hashCode();
/*     */     }
/* 516 */     i += i << 9 ^ 0xFFFFFFFF;
/* 517 */     i ^= i >>> 14;
/* 518 */     i += i << 4;
/* 519 */     i ^= i >>> 10;
/* 520 */     return i;
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
/*     */   protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> paramHashEntry, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 535 */     MultiKey multiKey = paramHashEntry.getKey();
/* 536 */     return (multiKey.size() == 4 && (paramObject1 == multiKey.getKey(0) || (paramObject1 != null && paramObject1.equals(multiKey.getKey(0)))) && (paramObject2 == multiKey.getKey(1) || (paramObject2 != null && paramObject2.equals(multiKey.getKey(1)))) && (paramObject3 == multiKey.getKey(2) || (paramObject3 != null && paramObject3.equals(multiKey.getKey(2)))) && (paramObject4 == multiKey.getKey(3) || (paramObject4 != null && paramObject4.equals(multiKey.getKey(3)))));
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
/*     */   public V get(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5) {
/* 556 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
/* 557 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 559 */     while (hashEntry != null) {
/* 560 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5)) {
/* 561 */         return hashEntry.getValue();
/*     */       }
/* 563 */       hashEntry = hashEntry.next;
/*     */     } 
/* 565 */     return null;
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
/*     */   public boolean containsKey(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5) {
/* 580 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
/* 581 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[decorated().hashIndex(i, (decorated()).data.length)];
/*     */     
/* 583 */     while (hashEntry != null) {
/* 584 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5)) {
/* 585 */         return true;
/*     */       }
/* 587 */       hashEntry = hashEntry.next;
/*     */     } 
/* 589 */     return false;
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
/*     */   public V put(K paramK1, K paramK2, K paramK3, K paramK4, K paramK5, V paramV) {
/* 604 */     int i = hash(paramK1, paramK2, paramK3, paramK4, paramK5);
/* 605 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 606 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry = (decorated()).data[j];
/* 607 */     while (hashEntry != null) {
/* 608 */       if (hashEntry.hashCode == i && isEqualKey(hashEntry, paramK1, paramK2, paramK3, paramK4, paramK5)) {
/* 609 */         V v = hashEntry.getValue();
/* 610 */         decorated().updateEntry(hashEntry, paramV);
/* 611 */         return v;
/*     */       } 
/* 613 */       hashEntry = hashEntry.next;
/*     */     } 
/* 615 */     decorated().addMapping(j, i, new MultiKey(paramK1, paramK2, paramK3, paramK4, paramK5), paramV);
/* 616 */     return null;
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
/*     */   public V removeMultiKey(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5) {
/* 632 */     int i = hash(paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
/* 633 */     int j = decorated().hashIndex(i, (decorated()).data.length);
/* 634 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry1 = (decorated()).data[j];
/* 635 */     AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> hashEntry2 = null;
/* 636 */     while (hashEntry1 != null) {
/* 637 */       if (hashEntry1.hashCode == i && isEqualKey(hashEntry1, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5)) {
/* 638 */         V v = hashEntry1.getValue();
/* 639 */         decorated().removeMapping(hashEntry1, j, hashEntry2);
/* 640 */         return v;
/*     */       } 
/* 642 */       hashEntry2 = hashEntry1;
/* 643 */       hashEntry1 = hashEntry1.next;
/*     */     } 
/* 645 */     return null;
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
/*     */   protected int hash(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5) {
/* 659 */     int i = 0;
/* 660 */     if (paramObject1 != null) {
/* 661 */       i ^= paramObject1.hashCode();
/*     */     }
/* 663 */     if (paramObject2 != null) {
/* 664 */       i ^= paramObject2.hashCode();
/*     */     }
/* 666 */     if (paramObject3 != null) {
/* 667 */       i ^= paramObject3.hashCode();
/*     */     }
/* 669 */     if (paramObject4 != null) {
/* 670 */       i ^= paramObject4.hashCode();
/*     */     }
/* 672 */     if (paramObject5 != null) {
/* 673 */       i ^= paramObject5.hashCode();
/*     */     }
/* 675 */     i += i << 9 ^ 0xFFFFFFFF;
/* 676 */     i ^= i >>> 14;
/* 677 */     i += i << 4;
/* 678 */     i ^= i >>> 10;
/* 679 */     return i;
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
/*     */   protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> paramHashEntry, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5) {
/* 695 */     MultiKey multiKey = paramHashEntry.getKey();
/* 696 */     return (multiKey.size() == 5 && (paramObject1 == multiKey.getKey(0) || (paramObject1 != null && paramObject1.equals(multiKey.getKey(0)))) && (paramObject2 == multiKey.getKey(1) || (paramObject2 != null && paramObject2.equals(multiKey.getKey(1)))) && (paramObject3 == multiKey.getKey(2) || (paramObject3 != null && paramObject3.equals(multiKey.getKey(2)))) && (paramObject4 == multiKey.getKey(3) || (paramObject4 != null && paramObject4.equals(multiKey.getKey(3)))) && (paramObject5 == multiKey.getKey(4) || (paramObject5 != null && paramObject5.equals(multiKey.getKey(4)))));
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
/*     */   public boolean removeAll(Object paramObject) {
/* 716 */     boolean bool = false;
/* 717 */     MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
/* 718 */     while (mapIterator.hasNext()) {
/* 719 */       MultiKey multiKey = (MultiKey)mapIterator.next();
/* 720 */       if (multiKey.size() >= 1 && ((paramObject == null) ? (multiKey.getKey(0) == null) : paramObject.equals(multiKey.getKey(0)))) {
/*     */         
/* 722 */         mapIterator.remove();
/* 723 */         bool = true;
/*     */       } 
/*     */     } 
/* 726 */     return bool;
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
/*     */   public boolean removeAll(Object paramObject1, Object paramObject2) {
/* 740 */     boolean bool = false;
/* 741 */     MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
/* 742 */     while (mapIterator.hasNext()) {
/* 743 */       MultiKey multiKey = (MultiKey)mapIterator.next();
/* 744 */       if (multiKey.size() >= 2 && ((paramObject1 == null) ? (multiKey.getKey(0) == null) : paramObject1.equals(multiKey.getKey(0))) && ((paramObject2 == null) ? (multiKey.getKey(1) == null) : paramObject2.equals(multiKey.getKey(1)))) {
/*     */ 
/*     */         
/* 747 */         mapIterator.remove();
/* 748 */         bool = true;
/*     */       } 
/*     */     } 
/* 751 */     return bool;
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
/*     */   public boolean removeAll(Object paramObject1, Object paramObject2, Object paramObject3) {
/* 766 */     boolean bool = false;
/* 767 */     MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
/* 768 */     while (mapIterator.hasNext()) {
/* 769 */       MultiKey multiKey = (MultiKey)mapIterator.next();
/* 770 */       if (multiKey.size() >= 3 && ((paramObject1 == null) ? (multiKey.getKey(0) == null) : paramObject1.equals(multiKey.getKey(0))) && ((paramObject2 == null) ? (multiKey.getKey(1) == null) : paramObject2.equals(multiKey.getKey(1))) && ((paramObject3 == null) ? (multiKey.getKey(2) == null) : paramObject3.equals(multiKey.getKey(2)))) {
/*     */ 
/*     */ 
/*     */         
/* 774 */         mapIterator.remove();
/* 775 */         bool = true;
/*     */       } 
/*     */     } 
/* 778 */     return bool;
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
/*     */   public boolean removeAll(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4) {
/* 794 */     boolean bool = false;
/* 795 */     MapIterator<MultiKey<? extends K>, V> mapIterator = mapIterator();
/* 796 */     while (mapIterator.hasNext()) {
/* 797 */       MultiKey multiKey = (MultiKey)mapIterator.next();
/* 798 */       if (multiKey.size() >= 4 && ((paramObject1 == null) ? (multiKey.getKey(0) == null) : paramObject1.equals(multiKey.getKey(0))) && ((paramObject2 == null) ? (multiKey.getKey(1) == null) : paramObject2.equals(multiKey.getKey(1))) && ((paramObject3 == null) ? (multiKey.getKey(2) == null) : paramObject3.equals(multiKey.getKey(2))) && ((paramObject4 == null) ? (multiKey.getKey(3) == null) : paramObject4.equals(multiKey.getKey(3)))) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 803 */         mapIterator.remove();
/* 804 */         bool = true;
/*     */       } 
/*     */     } 
/* 807 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkKey(MultiKey<?> paramMultiKey) {
/* 817 */     if (paramMultiKey == null) {
/* 818 */       throw new NullPointerException("Key must not be null");
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
/*     */   public MultiKeyMap<K, V> clone() {
/*     */     try {
/* 831 */       return (MultiKeyMap<K, V>)super.clone();
/* 832 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 833 */       throw new InternalError();
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
/*     */   public V put(MultiKey<? extends K> paramMultiKey, V paramV) {
/* 849 */     checkKey(paramMultiKey);
/* 850 */     return super.put(paramMultiKey, paramV);
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
/*     */   public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> paramMap) {
/* 863 */     for (MultiKey<?> multiKey : paramMap.keySet()) {
/* 864 */       checkKey(multiKey);
/*     */     }
/* 866 */     super.putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapIterator<MultiKey<? extends K>, V> mapIterator() {
/* 872 */     return decorated().mapIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
/* 880 */     return (AbstractHashedMap)super.decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 891 */     paramObjectOutputStream.defaultWriteObject();
/* 892 */     paramObjectOutputStream.writeObject(this.map);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 904 */     paramObjectInputStream.defaultReadObject();
/* 905 */     this.map = (Map<MultiKey<? extends K>, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\MultiKeyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */