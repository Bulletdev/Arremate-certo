/*      */ package org.apache.xmlbeans.impl.common;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
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
/*      */ public class ConcurrentReaderHashMap
/*      */   extends AbstractMap
/*      */   implements Serializable, Cloneable, Map
/*      */ {
/*      */   protected static class BarrierLock
/*      */     implements Serializable {}
/*      */   
/*  200 */   protected final BarrierLock barrierLock = new BarrierLock();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient Object lastWrite;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void recordModification(Object paramObject) {
/*  214 */     synchronized (this.barrierLock) {
/*  215 */       this.lastWrite = paramObject;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Entry[] getTableForReading() {
/*  225 */     synchronized (this.barrierLock) {
/*  226 */       return this.table;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  235 */   public static int DEFAULT_INITIAL_CAPACITY = 32;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MINIMUM_CAPACITY = 4;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MAXIMUM_CAPACITY = 1073741824;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final float DEFAULT_LOAD_FACTOR = 0.75F;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient Entry[] table;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient int count;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int threshold;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float loadFactor;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient Set keySet;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient Set entrySet;
/*      */ 
/*      */ 
/*      */   
/*      */   protected transient Collection values;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int p2capacity(int paramInt) {
/*  290 */     int j, i = paramInt;
/*      */ 
/*      */ 
/*      */     
/*  294 */     if (i > 1073741824 || i < 0) {
/*  295 */       j = 1073741824;
/*      */     } else {
/*  297 */       j = 4;
/*  298 */       while (j < i)
/*  299 */         j <<= 1; 
/*      */     } 
/*  301 */     return j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int hash(Object paramObject) {
/*  310 */     int i = paramObject.hashCode();
/*      */ 
/*      */ 
/*      */     
/*  314 */     return (i << 7) - i + (i >>> 9) + (i >>> 17);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean eq(Object paramObject1, Object paramObject2) {
/*  321 */     return (paramObject1 == paramObject2 || paramObject1.equals(paramObject2));
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
/*      */   public ConcurrentReaderHashMap(int paramInt) {
/*  360 */     this(paramInt, 0.75F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ConcurrentReaderHashMap() {
/*  369 */     this(DEFAULT_INITIAL_CAPACITY, 0.75F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ConcurrentReaderHashMap(Map paramMap) {
/*  379 */     this(Math.max((int)(paramMap.size() / 0.75F) + 1, 16), 0.75F);
/*      */     
/*  381 */     putAll(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized int size() {
/*  391 */     return this.count;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized boolean isEmpty() {
/*  401 */     return (this.count == 0);
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
/*      */   public Object get(Object paramObject) {
/*  422 */     int i = hash(paramObject);
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
/*  433 */     Entry[] arrayOfEntry = this.table;
/*  434 */     int j = i & arrayOfEntry.length - 1;
/*  435 */     Entry entry1 = arrayOfEntry[j];
/*  436 */     Entry entry2 = entry1;
/*      */     
/*      */     while (true) {
/*  439 */       while (entry2 == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  444 */         Entry[] arrayOfEntry1 = getTableForReading();
/*  445 */         if (arrayOfEntry == arrayOfEntry1 && entry1 == arrayOfEntry[j]) {
/*  446 */           return null;
/*      */         }
/*      */         
/*  449 */         arrayOfEntry = arrayOfEntry1;
/*  450 */         entry2 = entry1 = arrayOfEntry[j = i & arrayOfEntry.length - 1];
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  455 */       if (entry2.hash == i && eq(paramObject, entry2.key)) {
/*  456 */         Object object = entry2.value;
/*  457 */         if (object != null) {
/*  458 */           return object;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  465 */         synchronized (this) {
/*  466 */           arrayOfEntry = this.table;
/*      */         } 
/*  468 */         entry2 = entry1 = arrayOfEntry[j = i & arrayOfEntry.length - 1];
/*      */         
/*      */         continue;
/*      */       } 
/*  472 */       entry2 = entry2.next;
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
/*      */   public boolean containsKey(Object paramObject) {
/*  491 */     return (get(paramObject) != null);
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
/*      */   public Object put(Object paramObject1, Object paramObject2) {
/*  513 */     if (paramObject2 == null) {
/*  514 */       throw new NullPointerException();
/*      */     }
/*  516 */     int i = hash(paramObject1);
/*  517 */     Entry[] arrayOfEntry = this.table;
/*  518 */     int j = i & arrayOfEntry.length - 1;
/*  519 */     Entry entry1 = arrayOfEntry[j];
/*      */     
/*      */     Entry entry2;
/*  522 */     for (entry2 = entry1; entry2 != null && (
/*  523 */       entry2.hash != i || !eq(paramObject1, entry2.key)); entry2 = entry2.next);
/*      */ 
/*      */     
/*  526 */     synchronized (this) {
/*  527 */       if (arrayOfEntry == this.table) {
/*  528 */         if (entry2 == null) {
/*      */           
/*  530 */           if (entry1 == arrayOfEntry[j]) {
/*      */             
/*  532 */             Entry entry = new Entry(i, paramObject1, paramObject2, entry1);
/*  533 */             arrayOfEntry[j] = entry;
/*  534 */             if (++this.count >= this.threshold) { rehash(); }
/*  535 */             else { recordModification(entry); }
/*  536 */              return null;
/*      */           } 
/*      */         } else {
/*      */           
/*  540 */           Object object = entry2.value;
/*  541 */           if (entry1 == arrayOfEntry[j] && object != null) {
/*  542 */             entry2.value = paramObject2;
/*  543 */             return object;
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  549 */       return sput(paramObject1, paramObject2, i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object sput(Object paramObject1, Object paramObject2, int paramInt) {
/*  560 */     Entry[] arrayOfEntry = this.table;
/*  561 */     int i = paramInt & arrayOfEntry.length - 1;
/*  562 */     Entry entry1 = arrayOfEntry[i];
/*  563 */     Entry entry2 = entry1;
/*      */     
/*      */     while (true) {
/*  566 */       if (entry2 == null) {
/*  567 */         Entry entry = new Entry(paramInt, paramObject1, paramObject2, entry1);
/*  568 */         arrayOfEntry[i] = entry;
/*  569 */         if (++this.count >= this.threshold) { rehash(); }
/*  570 */         else { recordModification(entry); }
/*  571 */          return null;
/*      */       } 
/*  573 */       if (entry2.hash == paramInt && eq(paramObject1, entry2.key)) {
/*  574 */         Object object = entry2.value;
/*  575 */         entry2.value = paramObject2;
/*  576 */         return object;
/*      */       } 
/*      */       
/*  579 */       entry2 = entry2.next;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void rehash() {
/*  590 */     Entry[] arrayOfEntry1 = this.table;
/*  591 */     int i = arrayOfEntry1.length;
/*  592 */     if (i >= 1073741824) {
/*  593 */       this.threshold = Integer.MAX_VALUE;
/*      */       
/*      */       return;
/*      */     } 
/*  597 */     int j = i << 1;
/*  598 */     int k = j - 1;
/*  599 */     this.threshold = (int)(j * this.loadFactor);
/*      */     
/*  601 */     Entry[] arrayOfEntry2 = new Entry[j];
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
/*  616 */     for (byte b = 0; b < i; b++) {
/*      */ 
/*      */       
/*  619 */       Entry entry = arrayOfEntry1[b];
/*      */       
/*  621 */       if (entry != null) {
/*  622 */         int m = entry.hash & k;
/*  623 */         Entry entry1 = entry.next;
/*      */ 
/*      */         
/*  626 */         if (entry1 == null) {
/*  627 */           arrayOfEntry2[m] = entry;
/*      */         }
/*      */         else {
/*      */           
/*  631 */           Entry entry2 = entry;
/*  632 */           int n = m; Entry entry3;
/*  633 */           for (entry3 = entry1; entry3 != null; entry3 = entry3.next) {
/*  634 */             int i1 = entry3.hash & k;
/*  635 */             if (i1 != n) {
/*  636 */               n = i1;
/*  637 */               entry2 = entry3;
/*      */             } 
/*      */           } 
/*  640 */           arrayOfEntry2[n] = entry2;
/*      */ 
/*      */           
/*  643 */           for (entry3 = entry; entry3 != entry2; entry3 = entry3.next) {
/*  644 */             int i1 = entry3.hash & k;
/*  645 */             arrayOfEntry2[i1] = new Entry(entry3.hash, entry3.key, entry3.value, arrayOfEntry2[i1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  652 */     this.table = arrayOfEntry2;
/*  653 */     recordModification(arrayOfEntry2);
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
/*      */   
/*      */   public Object remove(Object paramObject) {
/*  679 */     int i = hash(paramObject);
/*  680 */     Entry[] arrayOfEntry = this.table;
/*  681 */     int j = i & arrayOfEntry.length - 1;
/*  682 */     Entry entry1 = arrayOfEntry[j];
/*  683 */     Entry entry2 = entry1;
/*      */     
/*  685 */     for (entry2 = entry1; entry2 != null && (
/*  686 */       entry2.hash != i || !eq(paramObject, entry2.key)); entry2 = entry2.next);
/*      */ 
/*      */ 
/*      */     
/*  690 */     synchronized (this) {
/*  691 */       if (arrayOfEntry == this.table) {
/*  692 */         if (entry2 == null) {
/*  693 */           if (entry1 == arrayOfEntry[j]) {
/*  694 */             return null;
/*      */           }
/*      */         } else {
/*  697 */           Object object = entry2.value;
/*  698 */           if (entry1 == arrayOfEntry[j] && object != null) {
/*  699 */             entry2.value = null;
/*  700 */             this.count--;
/*      */             
/*  702 */             Entry entry3 = entry2.next;
/*  703 */             for (Entry entry4 = entry1; entry4 != entry2; entry4 = entry4.next) {
/*  704 */               entry3 = new Entry(entry4.hash, entry4.key, entry4.value, entry3);
/*      */             }
/*  706 */             arrayOfEntry[j] = entry3;
/*  707 */             recordModification(entry3);
/*  708 */             return object;
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  714 */       return sremove(paramObject, i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object sremove(Object paramObject, int paramInt) {
/*  724 */     Entry[] arrayOfEntry = this.table;
/*  725 */     int i = paramInt & arrayOfEntry.length - 1;
/*  726 */     Entry entry1 = arrayOfEntry[i];
/*      */     
/*  728 */     for (Entry entry2 = entry1; entry2 != null; entry2 = entry2.next) {
/*  729 */       if (entry2.hash == paramInt && eq(paramObject, entry2.key)) {
/*  730 */         Object object = entry2.value;
/*  731 */         entry2.value = null;
/*  732 */         this.count--;
/*  733 */         Entry entry3 = entry2.next;
/*  734 */         for (Entry entry4 = entry1; entry4 != entry2; entry4 = entry4.next) {
/*  735 */           entry3 = new Entry(entry4.hash, entry4.key, entry4.value, entry3);
/*      */         }
/*  737 */         arrayOfEntry[i] = entry3;
/*  738 */         recordModification(entry3);
/*  739 */         return object;
/*      */       } 
/*      */     } 
/*  742 */     return null;
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
/*      */   public boolean containsValue(Object paramObject) {
/*  759 */     if (paramObject == null) throw new NullPointerException();
/*      */     
/*  761 */     Entry[] arrayOfEntry = getTableForReading();
/*      */     
/*  763 */     for (byte b = 0; b < arrayOfEntry.length; b++) {
/*  764 */       for (Entry entry = arrayOfEntry[b]; entry != null; entry = entry.next) {
/*  765 */         if (paramObject.equals(entry.value))
/*  766 */           return true; 
/*      */       } 
/*      */     } 
/*  769 */     return false;
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
/*      */   public boolean contains(Object paramObject) {
/*  792 */     return containsValue(paramObject);
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
/*      */   public synchronized void putAll(Map paramMap) {
/*  806 */     int i = paramMap.size();
/*  807 */     if (i == 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  813 */     while (i >= this.threshold) {
/*  814 */       rehash();
/*      */     }
/*  816 */     for (Map.Entry entry : paramMap.entrySet()) {
/*      */       
/*  818 */       Object object1 = entry.getKey();
/*  819 */       Object object2 = entry.getValue();
/*  820 */       put(object1, object2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void clear() {
/*  829 */     Entry[] arrayOfEntry = this.table;
/*  830 */     for (byte b = 0; b < arrayOfEntry.length; b++) {
/*      */ 
/*      */       
/*  833 */       for (Entry entry = arrayOfEntry[b]; entry != null; entry = entry.next) {
/*  834 */         entry.value = null;
/*      */       }
/*  836 */       arrayOfEntry[b] = null;
/*      */     } 
/*  838 */     this.count = 0;
/*  839 */     recordModification(arrayOfEntry);
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
/*      */   public synchronized Object clone() {
/*      */     try {
/*  852 */       ConcurrentReaderHashMap concurrentReaderHashMap = (ConcurrentReaderHashMap)super.clone();
/*      */       
/*  854 */       concurrentReaderHashMap.keySet = null;
/*  855 */       concurrentReaderHashMap.entrySet = null;
/*  856 */       concurrentReaderHashMap.values = null;
/*      */       
/*  858 */       Entry[] arrayOfEntry1 = this.table;
/*  859 */       concurrentReaderHashMap.table = new Entry[arrayOfEntry1.length];
/*  860 */       Entry[] arrayOfEntry2 = concurrentReaderHashMap.table;
/*      */       
/*  862 */       for (byte b = 0; b < arrayOfEntry1.length; b++) {
/*  863 */         Entry entry1 = null;
/*  864 */         for (Entry entry2 = arrayOfEntry1[b]; entry2 != null; entry2 = entry2.next)
/*  865 */           entry1 = new Entry(entry2.hash, entry2.key, entry2.value, entry1); 
/*  866 */         arrayOfEntry2[b] = entry1;
/*      */       } 
/*      */       
/*  869 */       return concurrentReaderHashMap;
/*      */     }
/*  871 */     catch (CloneNotSupportedException cloneNotSupportedException) {
/*      */       
/*  873 */       throw new InternalError();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ConcurrentReaderHashMap(int paramInt, float paramFloat) {
/*  879 */     this.keySet = null;
/*  880 */     this.entrySet = null;
/*  881 */     this.values = null;
/*      */     if (paramFloat <= 0.0F) {
/*      */       throw new IllegalArgumentException("Illegal Load factor: " + paramFloat);
/*      */     }
/*      */     this.loadFactor = paramFloat;
/*      */     int i = p2capacity(paramInt);
/*      */     this.table = new Entry[i];
/*      */     this.threshold = (int)(i * paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set keySet() {
/*  896 */     Set set = this.keySet;
/*  897 */     return (set != null) ? set : (this.keySet = new KeySet());
/*      */   }
/*      */   private class KeySet extends AbstractSet { private final ConcurrentReaderHashMap this$0;
/*      */     
/*      */     public Iterator iterator() {
/*  902 */       return new ConcurrentReaderHashMap.KeyIterator();
/*      */     } private KeySet() {}
/*      */     public int size() {
/*  905 */       return ConcurrentReaderHashMap.this.size();
/*      */     }
/*      */     public boolean contains(Object param1Object) {
/*  908 */       return ConcurrentReaderHashMap.this.containsKey(param1Object);
/*      */     }
/*      */     public boolean remove(Object param1Object) {
/*  911 */       return (ConcurrentReaderHashMap.this.remove(param1Object) != null);
/*      */     }
/*      */     public void clear() {
/*  914 */       ConcurrentReaderHashMap.this.clear();
/*      */     } }
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
/*      */   public Collection values() {
/*  931 */     Collection collection = this.values;
/*  932 */     return (collection != null) ? collection : (this.values = new Values());
/*      */   }
/*      */   private class Values extends AbstractCollection { private final ConcurrentReaderHashMap this$0;
/*      */     private Values() {}
/*      */     public Iterator iterator() {
/*  937 */       return new ConcurrentReaderHashMap.ValueIterator();
/*      */     }
/*      */     public int size() {
/*  940 */       return ConcurrentReaderHashMap.this.size();
/*      */     }
/*      */     public boolean contains(Object param1Object) {
/*  943 */       return ConcurrentReaderHashMap.this.containsValue(param1Object);
/*      */     }
/*      */     public void clear() {
/*  946 */       ConcurrentReaderHashMap.this.clear();
/*      */     } }
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
/*      */   public Set entrySet() {
/*  964 */     Set set = this.entrySet;
/*  965 */     return (set != null) ? set : (this.entrySet = new EntrySet());
/*      */   }
/*      */   private class EntrySet extends AbstractSet { private final ConcurrentReaderHashMap this$0;
/*      */     private EntrySet() {}
/*      */     public Iterator iterator() {
/*  970 */       return new ConcurrentReaderHashMap.HashIterator();
/*      */     }
/*      */     public boolean contains(Object param1Object) {
/*  973 */       if (!(param1Object instanceof Map.Entry))
/*  974 */         return false; 
/*  975 */       Map.Entry entry = (Map.Entry)param1Object;
/*  976 */       Object object = ConcurrentReaderHashMap.this.get(entry.getKey());
/*  977 */       return (object != null && object.equals(entry.getValue()));
/*      */     }
/*      */     public boolean remove(Object param1Object) {
/*  980 */       if (!(param1Object instanceof Map.Entry))
/*  981 */         return false; 
/*  982 */       return ConcurrentReaderHashMap.this.findAndRemoveEntry((Map.Entry)param1Object);
/*      */     }
/*      */     public int size() {
/*  985 */       return ConcurrentReaderHashMap.this.size();
/*      */     }
/*      */     public void clear() {
/*  988 */       ConcurrentReaderHashMap.this.clear();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected synchronized boolean findAndRemoveEntry(Map.Entry paramEntry) {
/*  996 */     Object object1 = paramEntry.getKey();
/*  997 */     Object object2 = get(object1);
/*  998 */     if (object2 != null && object2.equals(paramEntry.getValue())) {
/*  999 */       remove(object1);
/* 1000 */       return true;
/*      */     } 
/*      */     
/* 1003 */     return false;
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
/*      */   public Enumeration keys() {
/* 1016 */     return new KeyIterator();
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
/*      */   public Enumeration elements() {
/* 1032 */     return new ValueIterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class Entry
/*      */     implements Map.Entry
/*      */   {
/*      */     protected final int hash;
/*      */ 
/*      */     
/*      */     protected final Object key;
/*      */ 
/*      */     
/*      */     protected final Entry next;
/*      */ 
/*      */     
/*      */     protected volatile Object value;
/*      */ 
/*      */ 
/*      */     
/*      */     Entry(int param1Int, Object param1Object1, Object param1Object2, Entry param1Entry) {
/* 1055 */       this.hash = param1Int;
/* 1056 */       this.key = param1Object1;
/* 1057 */       this.next = param1Entry;
/* 1058 */       this.value = param1Object2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getKey() {
/* 1064 */       return this.key;
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
/*      */     public Object getValue() {
/* 1080 */       return this.value;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object setValue(Object param1Object) {
/* 1105 */       if (param1Object == null)
/* 1106 */         throw new NullPointerException(); 
/* 1107 */       Object object = this.value;
/* 1108 */       this.value = param1Object;
/* 1109 */       return object;
/*      */     }
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1113 */       if (!(param1Object instanceof Map.Entry))
/* 1114 */         return false; 
/* 1115 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1116 */       return (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue()));
/*      */     }
/*      */     
/*      */     public int hashCode() {
/* 1120 */       return this.key.hashCode() ^ this.value.hashCode();
/*      */     }
/*      */     
/*      */     public String toString() {
/* 1124 */       return this.key + "=" + this.value;
/*      */     }
/*      */   }
/*      */   
/*      */   protected class HashIterator
/*      */     implements Enumeration, Iterator {
/*      */     protected final ConcurrentReaderHashMap.Entry[] tab;
/*      */     protected int index;
/* 1132 */     protected ConcurrentReaderHashMap.Entry entry = null;
/*      */     protected Object currentKey;
/*      */     protected Object currentValue;
/* 1135 */     protected ConcurrentReaderHashMap.Entry lastReturned = null; private final ConcurrentReaderHashMap this$0;
/*      */     
/*      */     protected HashIterator() {
/* 1138 */       this.tab = ConcurrentReaderHashMap.this.getTableForReading();
/* 1139 */       this.index = this.tab.length - 1;
/*      */     }
/*      */     
/* 1142 */     public boolean hasMoreElements() { return hasNext(); } public Object nextElement() {
/* 1143 */       return next();
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
/*      */     public boolean hasNext() {
/*      */       while (true) {
/* 1157 */         if (this.entry != null) {
/* 1158 */           Object object = this.entry.value;
/* 1159 */           if (object != null) {
/* 1160 */             this.currentKey = this.entry.key;
/* 1161 */             this.currentValue = object;
/* 1162 */             return true;
/*      */           } 
/*      */           
/* 1165 */           this.entry = this.entry.next;
/*      */         } 
/*      */         
/* 1168 */         while (this.entry == null && this.index >= 0) {
/* 1169 */           this.entry = this.tab[this.index--];
/*      */         }
/* 1171 */         if (this.entry == null) {
/* 1172 */           this.currentKey = this.currentValue = null;
/* 1173 */           return false;
/*      */         } 
/*      */       } 
/*      */     }
/*      */     protected Object returnValueOfNext() {
/* 1178 */       return this.entry;
/*      */     }
/*      */     public Object next() {
/* 1181 */       if (this.currentKey == null && !hasNext()) {
/* 1182 */         throw new NoSuchElementException();
/*      */       }
/* 1184 */       Object object = returnValueOfNext();
/* 1185 */       this.lastReturned = this.entry;
/* 1186 */       this.currentKey = this.currentValue = null;
/* 1187 */       this.entry = this.entry.next;
/* 1188 */       return object;
/*      */     }
/*      */     
/*      */     public void remove() {
/* 1192 */       if (this.lastReturned == null)
/* 1193 */         throw new IllegalStateException(); 
/* 1194 */       ConcurrentReaderHashMap.this.remove(this.lastReturned.key);
/* 1195 */       this.lastReturned = null;
/*      */     }
/*      */   }
/*      */   
/*      */   protected class KeyIterator extends HashIterator { private final ConcurrentReaderHashMap this$0;
/*      */     
/*      */     protected Object returnValueOfNext() {
/* 1202 */       return this.currentKey;
/*      */     } }
/*      */   protected class ValueIterator extends HashIterator { private final ConcurrentReaderHashMap this$0;
/*      */     protected Object returnValueOfNext() {
/* 1206 */       return this.currentValue;
/*      */     } }
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
/*      */   private synchronized void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 1228 */     paramObjectOutputStream.defaultWriteObject();
/*      */ 
/*      */     
/* 1231 */     paramObjectOutputStream.writeInt(this.table.length);
/*      */ 
/*      */     
/* 1234 */     paramObjectOutputStream.writeInt(this.count);
/*      */ 
/*      */     
/* 1237 */     for (int i = this.table.length - 1; i >= 0; i--) {
/* 1238 */       Entry entry = this.table[i];
/*      */       
/* 1240 */       while (entry != null) {
/* 1241 */         paramObjectOutputStream.writeObject(entry.key);
/* 1242 */         paramObjectOutputStream.writeObject(entry.value);
/* 1243 */         entry = entry.next;
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
/*      */   private synchronized void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1256 */     paramObjectInputStream.defaultReadObject();
/*      */ 
/*      */     
/* 1259 */     int i = paramObjectInputStream.readInt();
/* 1260 */     this.table = new Entry[i];
/*      */ 
/*      */     
/* 1263 */     int j = paramObjectInputStream.readInt();
/*      */ 
/*      */     
/* 1266 */     for (byte b = 0; b < j; b++) {
/* 1267 */       Object object1 = paramObjectInputStream.readObject();
/* 1268 */       Object object2 = paramObjectInputStream.readObject();
/* 1269 */       put(object1, object2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized int capacity() {
/* 1278 */     return this.table.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float loadFactor() {
/* 1285 */     return this.loadFactor;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\ConcurrentReaderHashMap.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */