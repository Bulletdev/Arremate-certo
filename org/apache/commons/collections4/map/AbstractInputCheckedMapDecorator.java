/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractInputCheckedMapDecorator<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */ {
/*     */   protected AbstractInputCheckedMapDecorator() {}
/*     */   
/*     */   protected AbstractInputCheckedMapDecorator(Map<K, V> paramMap) {
/*  62 */     super(paramMap);
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
/*     */   protected abstract V checkSetValue(V paramV);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSetValueChecking() {
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  99 */     if (isSetValueChecking()) {
/* 100 */       return (Set<Map.Entry<K, V>>)new EntrySet(this.map.entrySet(), this);
/*     */     }
/* 102 */     return this.map.entrySet();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class EntrySet
/*     */     extends AbstractSetDecorator<Map.Entry<K, V>>
/*     */   {
/*     */     private static final long serialVersionUID = 4354731610923110264L;
/*     */ 
/*     */     
/*     */     private final AbstractInputCheckedMapDecorator<K, V> parent;
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySet(Set<Map.Entry<K, V>> param1Set, AbstractInputCheckedMapDecorator<K, V> param1AbstractInputCheckedMapDecorator) {
/* 118 */       super(param1Set);
/* 119 */       this.parent = param1AbstractInputCheckedMapDecorator;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 124 */       return (Iterator<Map.Entry<K, V>>)new AbstractInputCheckedMapDecorator.EntrySetIterator(decorated().iterator(), this.parent);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Object[] toArray() {
/* 130 */       Object[] arrayOfObject = decorated().toArray();
/* 131 */       for (byte b = 0; b < arrayOfObject.length; b++) {
/* 132 */         arrayOfObject[b] = new AbstractInputCheckedMapDecorator.MapEntry((Map.Entry<K, V>)arrayOfObject[b], this.parent);
/*     */       }
/* 134 */       return arrayOfObject;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> T[] toArray(T[] param1ArrayOfT) {
/* 140 */       T[] arrayOfT = param1ArrayOfT;
/* 141 */       if (param1ArrayOfT.length > 0)
/*     */       {
/*     */         
/* 144 */         arrayOfT = (T[])Array.newInstance(param1ArrayOfT.getClass().getComponentType(), 0);
/*     */       }
/* 146 */       arrayOfT = decorated().toArray((Object[])arrayOfT);
/* 147 */       for (byte b = 0; b < arrayOfT.length; b++) {
/* 148 */         arrayOfT[b] = (T)new AbstractInputCheckedMapDecorator.MapEntry((Map.Entry<K, V>)arrayOfT[b], this.parent);
/*     */       }
/*     */ 
/*     */       
/* 152 */       if (arrayOfT.length > param1ArrayOfT.length) {
/* 153 */         return arrayOfT;
/*     */       }
/*     */ 
/*     */       
/* 157 */       System.arraycopy(arrayOfT, 0, param1ArrayOfT, 0, arrayOfT.length);
/* 158 */       if (param1ArrayOfT.length > arrayOfT.length) {
/* 159 */         param1ArrayOfT[arrayOfT.length] = null;
/*     */       }
/* 161 */       return param1ArrayOfT;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class EntrySetIterator
/*     */     extends AbstractIteratorDecorator<Map.Entry<K, V>>
/*     */   {
/*     */     private final AbstractInputCheckedMapDecorator<K, V> parent;
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySetIterator(Iterator<Map.Entry<K, V>> param1Iterator, AbstractInputCheckedMapDecorator<K, V> param1AbstractInputCheckedMapDecorator) {
/* 175 */       super(param1Iterator);
/* 176 */       this.parent = param1AbstractInputCheckedMapDecorator;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map.Entry<K, V> next() {
/* 181 */       Map.Entry<K, V> entry = getIterator().next();
/* 182 */       return (Map.Entry<K, V>)new AbstractInputCheckedMapDecorator.MapEntry(entry, this.parent);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class MapEntry
/*     */     extends AbstractMapEntryDecorator<K, V>
/*     */   {
/*     */     private final AbstractInputCheckedMapDecorator<K, V> parent;
/*     */ 
/*     */     
/*     */     protected MapEntry(Map.Entry<K, V> param1Entry, AbstractInputCheckedMapDecorator<K, V> param1AbstractInputCheckedMapDecorator) {
/* 195 */       super(param1Entry);
/* 196 */       this.parent = param1AbstractInputCheckedMapDecorator;
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 201 */       param1V = this.parent.checkSetValue(param1V);
/* 202 */       return (V)getMapEntry().setValue(param1V);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractInputCheckedMapDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */