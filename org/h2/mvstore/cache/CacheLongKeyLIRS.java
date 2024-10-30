/*      */ package org.h2.mvstore.cache;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.h2.mvstore.DataUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CacheLongKeyLIRS<V>
/*      */ {
/*      */   private long maxMemory;
/*      */   private final Segment<V>[] segments;
/*      */   private final int segmentCount;
/*      */   private final int segmentShift;
/*      */   private final int segmentMask;
/*      */   private final int stackMoveDistance;
/*      */   private final int nonResidentQueueSize;
/*      */   
/*      */   public CacheLongKeyLIRS(Config paramConfig) {
/*   67 */     setMaxMemory(paramConfig.maxMemory);
/*   68 */     this.nonResidentQueueSize = paramConfig.nonResidentQueueSize;
/*   69 */     DataUtils.checkArgument((Integer.bitCount(paramConfig.segmentCount) == 1), "The segment count must be a power of 2, is {0}", new Object[] { Integer.valueOf(paramConfig.segmentCount) });
/*      */ 
/*      */     
/*   72 */     this.segmentCount = paramConfig.segmentCount;
/*   73 */     this.segmentMask = this.segmentCount - 1;
/*   74 */     this.stackMoveDistance = paramConfig.stackMoveDistance;
/*   75 */     this.segments = (Segment<V>[])new Segment[this.segmentCount];
/*   76 */     clear();
/*      */     
/*   78 */     this.segmentShift = 32 - Integer.bitCount(this.segmentMask);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*   85 */     long l = Math.max(1L, this.maxMemory / this.segmentCount);
/*   86 */     for (byte b = 0; b < this.segmentCount; b++) {
/*   87 */       this.segments[b] = new Segment<>(l, this.stackMoveDistance, 8, this.nonResidentQueueSize);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private Entry<V> find(long paramLong) {
/*   93 */     int i = getHash(paramLong);
/*   94 */     return getSegment(i).find(paramLong, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(long paramLong) {
/*  105 */     int i = getHash(paramLong);
/*  106 */     return getSegment(i).containsKey(paramLong, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V peek(long paramLong) {
/*  117 */     Entry<V> entry = find(paramLong);
/*  118 */     return (entry == null) ? null : entry.value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V put(long paramLong, V paramV) {
/*  129 */     return put(paramLong, paramV, sizeOf(paramV));
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
/*      */   public V put(long paramLong, V paramV, int paramInt) {
/*  143 */     int i = getHash(paramLong);
/*  144 */     int j = getSegmentIndex(i);
/*  145 */     Segment<V> segment = this.segments[j];
/*      */ 
/*      */ 
/*      */     
/*  149 */     synchronized (segment) {
/*  150 */       segment = resizeIfNeeded(segment, j);
/*  151 */       return segment.put(paramLong, i, paramV, paramInt);
/*      */     } 
/*      */   }
/*      */   
/*      */   private Segment<V> resizeIfNeeded(Segment<V> paramSegment, int paramInt) {
/*  156 */     int i = paramSegment.getNewMapLen();
/*  157 */     if (i == 0) {
/*  158 */       return paramSegment;
/*      */     }
/*      */ 
/*      */     
/*  162 */     Segment<V> segment = this.segments[paramInt];
/*  163 */     if (paramSegment == segment) {
/*      */       
/*  165 */       paramSegment = new Segment<>(paramSegment, i);
/*  166 */       this.segments[paramInt] = paramSegment;
/*      */     } 
/*  168 */     return paramSegment;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int sizeOf(V paramV) {
/*  178 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V remove(long paramLong) {
/*  189 */     int i = getHash(paramLong);
/*  190 */     int j = getSegmentIndex(i);
/*  191 */     Segment<V> segment = this.segments[j];
/*      */ 
/*      */ 
/*      */     
/*  195 */     synchronized (segment) {
/*  196 */       segment = resizeIfNeeded(segment, j);
/*  197 */       return segment.remove(paramLong, i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMemory(long paramLong) {
/*  208 */     int i = getHash(paramLong);
/*  209 */     return getSegment(i).getMemory(paramLong, i);
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
/*      */   public V get(long paramLong) {
/*  221 */     int i = getHash(paramLong);
/*  222 */     return getSegment(i).get(paramLong, i);
/*      */   }
/*      */   
/*      */   private Segment<V> getSegment(int paramInt) {
/*  226 */     return this.segments[getSegmentIndex(paramInt)];
/*      */   }
/*      */   
/*      */   private int getSegmentIndex(int paramInt) {
/*  230 */     return paramInt >>> this.segmentShift & this.segmentMask;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int getHash(long paramLong) {
/*  241 */     int i = (int)(paramLong >>> 32L ^ paramLong);
/*      */ 
/*      */     
/*  244 */     i = (i >>> 16 ^ i) * 73244475;
/*  245 */     i = (i >>> 16 ^ i) * 73244475;
/*  246 */     i = i >>> 16 ^ i;
/*  247 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getUsedMemory() {
/*  256 */     long l = 0L;
/*  257 */     for (Segment<V> segment : this.segments) {
/*  258 */       l += segment.usedMemory;
/*      */     }
/*  260 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxMemory(long paramLong) {
/*  271 */     DataUtils.checkArgument((paramLong > 0L), "Max memory must be larger than 0, is {0}", new Object[] { Long.valueOf(paramLong) });
/*      */ 
/*      */     
/*  274 */     this.maxMemory = paramLong;
/*  275 */     if (this.segments != null) {
/*  276 */       long l = 1L + paramLong / this.segments.length;
/*  277 */       for (Segment<V> segment : this.segments) {
/*  278 */         segment.setMaxMemory(l);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getMaxMemory() {
/*  289 */     return this.maxMemory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized Set<Map.Entry<Long, V>> entrySet() {
/*  298 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  299 */     for (Iterator<Long> iterator = keySet().iterator(); iterator.hasNext(); ) { long l = ((Long)iterator.next()).longValue();
/*  300 */       hashMap.put(Long.valueOf(l), (find(l)).value); }
/*      */     
/*  302 */     return (Set)hashMap.entrySet();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<Long> keySet() {
/*  311 */     HashSet<Long> hashSet = new HashSet();
/*  312 */     for (Segment<V> segment : this.segments) {
/*  313 */       hashSet.addAll(segment.keySet());
/*      */     }
/*  315 */     return hashSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeNonResident() {
/*  324 */     int i = 0;
/*  325 */     for (Segment<V> segment : this.segments) {
/*  326 */       i += segment.queue2Size;
/*      */     }
/*  328 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeMapArray() {
/*  337 */     int i = 0;
/*  338 */     for (Segment<V> segment : this.segments) {
/*  339 */       i += segment.entries.length;
/*      */     }
/*  341 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeHot() {
/*  350 */     int i = 0;
/*  351 */     for (Segment<V> segment : this.segments) {
/*  352 */       i += segment.mapSize - segment.queueSize - segment.queue2Size;
/*      */     }
/*  354 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getHits() {
/*  363 */     long l = 0L;
/*  364 */     for (Segment<V> segment : this.segments) {
/*  365 */       l += segment.hits;
/*      */     }
/*  367 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getMisses() {
/*  376 */     int i = 0;
/*  377 */     for (Segment<V> segment : this.segments) {
/*  378 */       i = (int)(i + segment.misses);
/*      */     }
/*  380 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  389 */     int i = 0;
/*  390 */     for (Segment<V> segment : this.segments) {
/*  391 */       i += segment.mapSize - segment.queue2Size;
/*      */     }
/*  393 */     return i;
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
/*      */   public List<Long> keys(boolean paramBoolean1, boolean paramBoolean2) {
/*  405 */     ArrayList<Long> arrayList = new ArrayList();
/*  406 */     for (Segment<V> segment : this.segments) {
/*  407 */       arrayList.addAll(segment.keys(paramBoolean1, paramBoolean2));
/*      */     }
/*  409 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<V> values() {
/*  418 */     ArrayList<V> arrayList = new ArrayList();
/*  419 */     for (Iterator<Long> iterator = keySet().iterator(); iterator.hasNext(); ) { long l = ((Long)iterator.next()).longValue();
/*  420 */       V v = (find(l)).value;
/*  421 */       if (v != null) {
/*  422 */         arrayList.add(v);
/*      */       } }
/*      */     
/*  425 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  434 */     return (size() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsValue(Object paramObject) {
/*  444 */     return getMap().containsValue(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<Long, V> getMap() {
/*  453 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  454 */     for (Iterator<Long> iterator = keySet().iterator(); iterator.hasNext(); ) { long l = ((Long)iterator.next()).longValue();
/*  455 */       V v = (find(l)).value;
/*  456 */       if (v != null) {
/*  457 */         hashMap.put(Long.valueOf(l), v);
/*      */       } }
/*      */     
/*  460 */     return (Map)hashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<Long, ? extends V> paramMap) {
/*  469 */     for (Map.Entry<Long, ? extends V> entry : paramMap.entrySet())
/*      */     {
/*  471 */       put(((Long)entry.getKey()).longValue(), (V)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Segment<V>
/*      */   {
/*      */     int mapSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int queueSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int queue2Size;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long hits;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long misses;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final CacheLongKeyLIRS.Entry<V>[] entries;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long usedMemory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int stackMoveDistance;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private long maxMemory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mask;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final int nonResidentQueueSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final CacheLongKeyLIRS.Entry<V> stack;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int stackSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final CacheLongKeyLIRS.Entry<V> queue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final CacheLongKeyLIRS.Entry<V> queue2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int stackMoveCounter;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Segment(long param1Long, int param1Int1, int param1Int2, int param1Int3) {
/*  585 */       setMaxMemory(param1Long);
/*  586 */       this.stackMoveDistance = param1Int1;
/*  587 */       this.nonResidentQueueSize = param1Int3;
/*      */ 
/*      */       
/*  590 */       this.mask = param1Int2 - 1;
/*      */ 
/*      */       
/*  593 */       this.stack = new CacheLongKeyLIRS.Entry<>();
/*  594 */       this.stack.stackPrev = this.stack.stackNext = this.stack;
/*  595 */       this.queue = new CacheLongKeyLIRS.Entry<>();
/*  596 */       this.queue.queuePrev = this.queue.queueNext = this.queue;
/*  597 */       this.queue2 = new CacheLongKeyLIRS.Entry<>();
/*  598 */       this.queue2.queuePrev = this.queue2.queueNext = this.queue2;
/*      */ 
/*      */       
/*  601 */       CacheLongKeyLIRS.Entry[] arrayOfEntry = new CacheLongKeyLIRS.Entry[param1Int2];
/*  602 */       this.entries = (CacheLongKeyLIRS.Entry<V>[])arrayOfEntry;
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
/*      */     Segment(Segment<V> param1Segment, int param1Int) {
/*  614 */       this(param1Segment.maxMemory, param1Segment.stackMoveDistance, param1Int, param1Segment.nonResidentQueueSize);
/*  615 */       this.hits = param1Segment.hits;
/*  616 */       this.misses = param1Segment.misses;
/*  617 */       CacheLongKeyLIRS.Entry<V> entry = param1Segment.stack.stackPrev;
/*  618 */       while (entry != param1Segment.stack) {
/*  619 */         CacheLongKeyLIRS.Entry<V> entry1 = copy(entry);
/*  620 */         addToMap(entry1);
/*  621 */         addToStack(entry1);
/*  622 */         entry = entry.stackPrev;
/*      */       } 
/*  624 */       entry = param1Segment.queue.queuePrev;
/*  625 */       while (entry != param1Segment.queue) {
/*  626 */         CacheLongKeyLIRS.Entry<V> entry1 = find(entry.key, CacheLongKeyLIRS.getHash(entry.key));
/*  627 */         if (entry1 == null) {
/*  628 */           entry1 = copy(entry);
/*  629 */           addToMap(entry1);
/*      */         } 
/*  631 */         addToQueue(this.queue, entry1);
/*  632 */         entry = entry.queuePrev;
/*      */       } 
/*  634 */       entry = param1Segment.queue2.queuePrev;
/*  635 */       while (entry != param1Segment.queue2) {
/*  636 */         CacheLongKeyLIRS.Entry<V> entry1 = find(entry.key, CacheLongKeyLIRS.getHash(entry.key));
/*  637 */         if (entry1 == null) {
/*  638 */           entry1 = copy(entry);
/*  639 */           addToMap(entry1);
/*      */         } 
/*  641 */         addToQueue(this.queue2, entry1);
/*  642 */         entry = entry.queuePrev;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int getNewMapLen() {
/*  653 */       int i = this.mask + 1;
/*  654 */       if (i * 3 < this.mapSize * 4 && i < 268435456)
/*      */       {
/*  656 */         return i * 2; } 
/*  657 */       if (i > 32 && i / 8 > this.mapSize)
/*      */       {
/*  659 */         return i / 2;
/*      */       }
/*  661 */       return 0;
/*      */     }
/*      */     
/*      */     private void addToMap(CacheLongKeyLIRS.Entry<V> param1Entry) {
/*  665 */       int i = CacheLongKeyLIRS.getHash(param1Entry.key) & this.mask;
/*  666 */       param1Entry.mapNext = this.entries[i];
/*  667 */       this.entries[i] = param1Entry;
/*  668 */       this.usedMemory += param1Entry.memory;
/*  669 */       this.mapSize++;
/*      */     }
/*      */     
/*      */     private static <V> CacheLongKeyLIRS.Entry<V> copy(CacheLongKeyLIRS.Entry<V> param1Entry) {
/*  673 */       CacheLongKeyLIRS.Entry<V> entry = new CacheLongKeyLIRS.Entry();
/*  674 */       entry.key = param1Entry.key;
/*  675 */       entry.value = param1Entry.value;
/*  676 */       entry.memory = param1Entry.memory;
/*  677 */       entry.topMove = param1Entry.topMove;
/*  678 */       return entry;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int getMemory(long param1Long, int param1Int) {
/*  689 */       CacheLongKeyLIRS.Entry<V> entry = find(param1Long, param1Int);
/*  690 */       return (entry == null) ? 0 : entry.memory;
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
/*      */     V get(long param1Long, int param1Int) {
/*  703 */       CacheLongKeyLIRS.Entry<V> entry = find(param1Long, param1Int);
/*  704 */       if (entry == null) {
/*      */         
/*  706 */         this.misses++;
/*  707 */         return null;
/*      */       } 
/*  709 */       V v = entry.value;
/*  710 */       if (v == null) {
/*      */         
/*  712 */         this.misses++;
/*  713 */         return null;
/*      */       } 
/*  715 */       if (entry.isHot()) {
/*  716 */         if (entry != this.stack.stackNext && (
/*  717 */           this.stackMoveDistance == 0 || this.stackMoveCounter - entry.topMove > this.stackMoveDistance))
/*      */         {
/*  719 */           access(param1Long, param1Int);
/*      */         }
/*      */       } else {
/*      */         
/*  723 */         access(param1Long, param1Int);
/*      */       } 
/*  725 */       this.hits++;
/*  726 */       return v;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private synchronized void access(long param1Long, int param1Int) {
/*  736 */       CacheLongKeyLIRS.Entry<V> entry = find(param1Long, param1Int);
/*  737 */       if (entry == null || entry.value == null) {
/*      */         return;
/*      */       }
/*  740 */       if (entry.isHot()) {
/*  741 */         if (entry != this.stack.stackNext && (
/*  742 */           this.stackMoveDistance == 0 || this.stackMoveCounter - entry.topMove > this.stackMoveDistance)) {
/*      */ 
/*      */ 
/*      */           
/*  746 */           boolean bool = (entry == this.stack.stackPrev) ? true : false;
/*  747 */           removeFromStack(entry);
/*  748 */           if (bool)
/*      */           {
/*      */             
/*  751 */             pruneStack();
/*      */           }
/*  753 */           addToStack(entry);
/*      */         } 
/*      */       } else {
/*      */         
/*  757 */         removeFromQueue(entry);
/*  758 */         if (entry.stackNext != null) {
/*      */ 
/*      */           
/*  761 */           removeFromStack(entry);
/*      */ 
/*      */ 
/*      */           
/*  765 */           convertOldestHotToCold();
/*      */         }
/*      */         else {
/*      */           
/*  769 */           addToQueue(this.queue, entry);
/*      */         } 
/*      */         
/*  772 */         addToStack(entry);
/*      */       } 
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
/*      */     synchronized V put(long param1Long, int param1Int1, V param1V, int param1Int2) {
/*      */       V v;
/*      */       boolean bool;
/*  788 */       if (param1V == null) {
/*  789 */         throw DataUtils.newIllegalArgumentException("The value may not be null", new Object[0]);
/*      */       }
/*      */ 
/*      */       
/*  793 */       CacheLongKeyLIRS.Entry<V> entry = find(param1Long, param1Int1);
/*      */       
/*  795 */       if (entry == null) {
/*  796 */         bool = false;
/*  797 */         Object object = null;
/*      */       } else {
/*  799 */         bool = true;
/*  800 */         v = entry.value;
/*  801 */         remove(param1Long, param1Int1);
/*      */       } 
/*  803 */       if (param1Int2 > this.maxMemory)
/*      */       {
/*  805 */         return v;
/*      */       }
/*  807 */       entry = new CacheLongKeyLIRS.Entry<>();
/*  808 */       entry.key = param1Long;
/*  809 */       entry.value = param1V;
/*  810 */       entry.memory = param1Int2;
/*  811 */       int i = param1Int1 & this.mask;
/*  812 */       entry.mapNext = this.entries[i];
/*  813 */       this.entries[i] = entry;
/*  814 */       this.usedMemory += param1Int2;
/*  815 */       if (this.usedMemory > this.maxMemory) {
/*      */         
/*  817 */         evict();
/*      */ 
/*      */         
/*  820 */         if (this.stackSize > 0)
/*      */         {
/*  822 */           addToQueue(this.queue, entry);
/*      */         }
/*      */       } 
/*  825 */       this.mapSize++;
/*      */       
/*  827 */       addToStack(entry);
/*  828 */       if (bool)
/*      */       {
/*  830 */         access(param1Long, param1Int1);
/*      */       }
/*  832 */       return v;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     synchronized V remove(long param1Long, int param1Int) {
/*      */       // Byte code:
/*      */       //   0: iload_3
/*      */       //   1: aload_0
/*      */       //   2: getfield mask : I
/*      */       //   5: iand
/*      */       //   6: istore #4
/*      */       //   8: aload_0
/*      */       //   9: getfield entries : [Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   12: iload #4
/*      */       //   14: aaload
/*      */       //   15: astore #5
/*      */       //   17: aload #5
/*      */       //   19: ifnonnull -> 24
/*      */       //   22: aconst_null
/*      */       //   23: areturn
/*      */       //   24: aload #5
/*      */       //   26: getfield key : J
/*      */       //   29: lload_1
/*      */       //   30: lcmp
/*      */       //   31: ifne -> 56
/*      */       //   34: aload #5
/*      */       //   36: getfield value : Ljava/lang/Object;
/*      */       //   39: astore #6
/*      */       //   41: aload_0
/*      */       //   42: getfield entries : [Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   45: iload #4
/*      */       //   47: aload #5
/*      */       //   49: getfield mapNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   52: aastore
/*      */       //   53: goto -> 101
/*      */       //   56: aload #5
/*      */       //   58: astore #7
/*      */       //   60: aload #5
/*      */       //   62: getfield mapNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   65: astore #5
/*      */       //   67: aload #5
/*      */       //   69: ifnonnull -> 74
/*      */       //   72: aconst_null
/*      */       //   73: areturn
/*      */       //   74: aload #5
/*      */       //   76: getfield key : J
/*      */       //   79: lload_1
/*      */       //   80: lcmp
/*      */       //   81: ifne -> 56
/*      */       //   84: aload #5
/*      */       //   86: getfield value : Ljava/lang/Object;
/*      */       //   89: astore #6
/*      */       //   91: aload #7
/*      */       //   93: aload #5
/*      */       //   95: getfield mapNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   98: putfield mapNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   101: aload_0
/*      */       //   102: dup
/*      */       //   103: getfield mapSize : I
/*      */       //   106: iconst_1
/*      */       //   107: isub
/*      */       //   108: putfield mapSize : I
/*      */       //   111: aload_0
/*      */       //   112: dup
/*      */       //   113: getfield usedMemory : J
/*      */       //   116: aload #5
/*      */       //   118: getfield memory : I
/*      */       //   121: i2l
/*      */       //   122: lsub
/*      */       //   123: putfield usedMemory : J
/*      */       //   126: aload #5
/*      */       //   128: getfield stackNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   131: ifnull -> 140
/*      */       //   134: aload_0
/*      */       //   135: aload #5
/*      */       //   137: invokespecial removeFromStack : (Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;)V
/*      */       //   140: aload #5
/*      */       //   142: invokevirtual isHot : ()Z
/*      */       //   145: ifeq -> 189
/*      */       //   148: aload_0
/*      */       //   149: getfield queue : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   152: getfield queueNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   155: astore #5
/*      */       //   157: aload #5
/*      */       //   159: aload_0
/*      */       //   160: getfield queue : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   163: if_acmpeq -> 195
/*      */       //   166: aload_0
/*      */       //   167: aload #5
/*      */       //   169: invokespecial removeFromQueue : (Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;)V
/*      */       //   172: aload #5
/*      */       //   174: getfield stackNext : Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;
/*      */       //   177: ifnonnull -> 195
/*      */       //   180: aload_0
/*      */       //   181: aload #5
/*      */       //   183: invokespecial addToStackBottom : (Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;)V
/*      */       //   186: goto -> 195
/*      */       //   189: aload_0
/*      */       //   190: aload #5
/*      */       //   192: invokespecial removeFromQueue : (Lorg/h2/mvstore/cache/CacheLongKeyLIRS$Entry;)V
/*      */       //   195: aload_0
/*      */       //   196: invokespecial pruneStack : ()V
/*      */       //   199: aload #6
/*      */       //   201: areturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #844	-> 0
/*      */       //   #845	-> 8
/*      */       //   #846	-> 17
/*      */       //   #847	-> 22
/*      */       //   #850	-> 24
/*      */       //   #851	-> 34
/*      */       //   #852	-> 41
/*      */       //   #856	-> 56
/*      */       //   #857	-> 60
/*      */       //   #858	-> 67
/*      */       //   #859	-> 72
/*      */       //   #861	-> 74
/*      */       //   #862	-> 84
/*      */       //   #863	-> 91
/*      */       //   #865	-> 101
/*      */       //   #866	-> 111
/*      */       //   #867	-> 126
/*      */       //   #868	-> 134
/*      */       //   #870	-> 140
/*      */       //   #873	-> 148
/*      */       //   #874	-> 157
/*      */       //   #875	-> 166
/*      */       //   #876	-> 172
/*      */       //   #877	-> 180
/*      */       //   #881	-> 189
/*      */       //   #883	-> 195
/*      */       //   #884	-> 199
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void evict() {
/*      */       do {
/*  894 */         evictBlock();
/*  895 */       } while (this.usedMemory > this.maxMemory);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void evictBlock() {
/*  902 */       while (this.queueSize <= this.mapSize >>> 5 && this.stackSize > 0) {
/*  903 */         convertOldestHotToCold();
/*      */       }
/*      */       
/*  906 */       while (this.usedMemory > this.maxMemory && this.queueSize > 0) {
/*  907 */         CacheLongKeyLIRS.Entry<V> entry = this.queue.queuePrev;
/*  908 */         this.usedMemory -= entry.memory;
/*  909 */         removeFromQueue(entry);
/*  910 */         entry.value = null;
/*  911 */         entry.memory = 0;
/*  912 */         addToQueue(this.queue2, entry);
/*      */         
/*  914 */         int i = this.nonResidentQueueSize * (this.mapSize - this.queue2Size);
/*  915 */         if (i >= 0) {
/*  916 */           while (this.queue2Size > i) {
/*  917 */             entry = this.queue2.queuePrev;
/*  918 */             int j = CacheLongKeyLIRS.getHash(entry.key);
/*  919 */             remove(entry.key, j);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void convertOldestHotToCold() {
/*  927 */       CacheLongKeyLIRS.Entry<V> entry = this.stack.stackPrev;
/*  928 */       if (entry == this.stack)
/*      */       {
/*      */         
/*  931 */         throw new IllegalStateException();
/*      */       }
/*      */ 
/*      */       
/*  935 */       removeFromStack(entry);
/*      */       
/*  937 */       addToQueue(this.queue, entry);
/*  938 */       pruneStack();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void pruneStack() {
/*      */       while (true) {
/*  946 */         CacheLongKeyLIRS.Entry<V> entry = this.stack.stackPrev;
/*      */ 
/*      */ 
/*      */         
/*  950 */         if (entry.isHot()) {
/*      */           break;
/*      */         }
/*      */         
/*  954 */         removeFromStack(entry);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CacheLongKeyLIRS.Entry<V> find(long param1Long, int param1Int) {
/*  966 */       int i = param1Int & this.mask;
/*  967 */       CacheLongKeyLIRS.Entry<V> entry = this.entries[i];
/*  968 */       while (entry != null && entry.key != param1Long) {
/*  969 */         entry = entry.mapNext;
/*      */       }
/*  971 */       return entry;
/*      */     }
/*      */     
/*      */     private void addToStack(CacheLongKeyLIRS.Entry<V> param1Entry) {
/*  975 */       param1Entry.stackPrev = this.stack;
/*  976 */       param1Entry.stackNext = this.stack.stackNext;
/*  977 */       param1Entry.stackNext.stackPrev = param1Entry;
/*  978 */       this.stack.stackNext = param1Entry;
/*  979 */       this.stackSize++;
/*  980 */       param1Entry.topMove = this.stackMoveCounter++;
/*      */     }
/*      */     
/*      */     private void addToStackBottom(CacheLongKeyLIRS.Entry<V> param1Entry) {
/*  984 */       param1Entry.stackNext = this.stack;
/*  985 */       param1Entry.stackPrev = this.stack.stackPrev;
/*  986 */       param1Entry.stackPrev.stackNext = param1Entry;
/*  987 */       this.stack.stackPrev = param1Entry;
/*  988 */       this.stackSize++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void removeFromStack(CacheLongKeyLIRS.Entry<V> param1Entry) {
/*  997 */       param1Entry.stackPrev.stackNext = param1Entry.stackNext;
/*  998 */       param1Entry.stackNext.stackPrev = param1Entry.stackPrev;
/*  999 */       param1Entry.stackPrev = param1Entry.stackNext = null;
/* 1000 */       this.stackSize--;
/*      */     }
/*      */     
/*      */     private void addToQueue(CacheLongKeyLIRS.Entry<V> param1Entry1, CacheLongKeyLIRS.Entry<V> param1Entry2) {
/* 1004 */       param1Entry2.queuePrev = param1Entry1;
/* 1005 */       param1Entry2.queueNext = param1Entry1.queueNext;
/* 1006 */       param1Entry2.queueNext.queuePrev = param1Entry2;
/* 1007 */       param1Entry1.queueNext = param1Entry2;
/* 1008 */       if (param1Entry2.value != null) {
/* 1009 */         this.queueSize++;
/*      */       } else {
/* 1011 */         this.queue2Size++;
/*      */       } 
/*      */     }
/*      */     
/*      */     private void removeFromQueue(CacheLongKeyLIRS.Entry<V> param1Entry) {
/* 1016 */       param1Entry.queuePrev.queueNext = param1Entry.queueNext;
/* 1017 */       param1Entry.queueNext.queuePrev = param1Entry.queuePrev;
/* 1018 */       param1Entry.queuePrev = param1Entry.queueNext = null;
/* 1019 */       if (param1Entry.value != null) {
/* 1020 */         this.queueSize--;
/*      */       } else {
/* 1022 */         this.queue2Size--;
/*      */       } 
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
/*      */     synchronized List<Long> keys(boolean param1Boolean1, boolean param1Boolean2) {
/* 1035 */       ArrayList<Long> arrayList = new ArrayList();
/* 1036 */       if (param1Boolean1) {
/* 1037 */         CacheLongKeyLIRS.Entry<V> entry1 = param1Boolean2 ? this.queue2 : this.queue;
/* 1038 */         for (CacheLongKeyLIRS.Entry<V> entry2 = entry1.queueNext; entry2 != entry1; 
/* 1039 */           entry2 = entry2.queueNext) {
/* 1040 */           arrayList.add(Long.valueOf(entry2.key));
/*      */         }
/*      */       } else {
/* 1043 */         for (CacheLongKeyLIRS.Entry<V> entry = this.stack.stackNext; entry != this.stack; 
/* 1044 */           entry = entry.stackNext) {
/* 1045 */           arrayList.add(Long.valueOf(entry.key));
/*      */         }
/*      */       } 
/* 1048 */       return arrayList;
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
/*      */     boolean containsKey(long param1Long, int param1Int) {
/* 1060 */       CacheLongKeyLIRS.Entry<V> entry = find(param1Long, param1Int);
/* 1061 */       return (entry != null && entry.value != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     synchronized Set<Long> keySet() {
/* 1070 */       HashSet<Long> hashSet = new HashSet(); CacheLongKeyLIRS.Entry<V> entry;
/* 1071 */       for (entry = this.stack.stackNext; entry != this.stack; entry = entry.stackNext) {
/* 1072 */         hashSet.add(Long.valueOf(entry.key));
/*      */       }
/* 1074 */       for (entry = this.queue.queueNext; entry != this.queue; entry = entry.queueNext) {
/* 1075 */         hashSet.add(Long.valueOf(entry.key));
/*      */       }
/* 1077 */       return hashSet;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setMaxMemory(long param1Long) {
/* 1088 */       this.maxMemory = param1Long;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class Entry<V>
/*      */   {
/*      */     long key;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     V value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int memory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int topMove;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry<V> stackNext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry<V> stackPrev;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry<V> queueNext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry<V> queuePrev;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Entry<V> mapNext;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isHot() {
/* 1156 */       return (this.queueNext == null);
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
/*      */   public static class Config
/*      */   {
/* 1169 */     public long maxMemory = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1174 */     public int segmentCount = 16;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1180 */     public int stackMoveDistance = 32;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1186 */     public int nonResidentQueueSize = 3;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\cache\CacheLongKeyLIRS.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */