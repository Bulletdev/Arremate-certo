/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
/*     */ import org.apache.commons.collections4.set.AbstractSetDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableEntrySet<K, V>
/*     */   extends AbstractSetDecorator<Map.Entry<K, V>>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 1678353579659253473L;
/*     */   
/*     */   public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet) {
/*  55 */     if (paramSet instanceof Unmodifiable) {
/*  56 */       return paramSet;
/*     */     }
/*  58 */     return (Set)new UnmodifiableEntrySet<K, V>(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableEntrySet(Set<Map.Entry<K, V>> paramSet) {
/*  69 */     super(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(Map.Entry<K, V> paramEntry) {
/*  75 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection) {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/*  95 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 100 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Map.Entry<K, V>> iterator() {
/* 106 */     return (Iterator<Map.Entry<K, V>>)new UnmodifiableEntrySetIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 112 */     Object[] arrayOfObject = decorated().toArray();
/* 113 */     for (byte b = 0; b < arrayOfObject.length; b++) {
/* 114 */       arrayOfObject[b] = new UnmodifiableEntry((Map.Entry<K, V>)arrayOfObject[b]);
/*     */     }
/* 116 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 122 */     T[] arrayOfT = paramArrayOfT;
/* 123 */     if (paramArrayOfT.length > 0)
/*     */     {
/*     */       
/* 126 */       arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 0);
/*     */     }
/* 128 */     arrayOfT = decorated().toArray((Object[])arrayOfT);
/* 129 */     for (byte b = 0; b < arrayOfT.length; b++) {
/* 130 */       arrayOfT[b] = (T)new UnmodifiableEntry((Map.Entry<K, V>)arrayOfT[b]);
/*     */     }
/*     */ 
/*     */     
/* 134 */     if (arrayOfT.length > paramArrayOfT.length) {
/* 135 */       return arrayOfT;
/*     */     }
/*     */ 
/*     */     
/* 139 */     System.arraycopy(arrayOfT, 0, paramArrayOfT, 0, arrayOfT.length);
/* 140 */     if (paramArrayOfT.length > arrayOfT.length) {
/* 141 */       paramArrayOfT[arrayOfT.length] = null;
/*     */     }
/* 143 */     return paramArrayOfT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class UnmodifiableEntrySetIterator
/*     */     extends AbstractIteratorDecorator<Map.Entry<K, V>>
/*     */   {
/*     */     protected UnmodifiableEntrySetIterator(Iterator<Map.Entry<K, V>> param1Iterator) {
/* 153 */       super(param1Iterator);
/*     */     }
/*     */ 
/*     */     
/*     */     public Map.Entry<K, V> next() {
/* 158 */       return (Map.Entry<K, V>)new UnmodifiableEntrySet.UnmodifiableEntry(getIterator().next());
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 163 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class UnmodifiableEntry
/*     */     extends AbstractMapEntryDecorator<K, V>
/*     */   {
/*     */     protected UnmodifiableEntry(Map.Entry<K, V> param1Entry) {
/* 174 */       super(param1Entry);
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 179 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\UnmodifiableEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */