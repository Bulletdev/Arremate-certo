/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
/*     */ import org.apache.commons.collections4.list.UnmodifiableList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LinkedMap<K, V>
/*     */   extends AbstractLinkedMap<K, V>
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 9077234323521161066L;
/*     */   
/*     */   public LinkedMap() {
/*  72 */     super(16, 0.75F, 12);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinkedMap(int paramInt) {
/*  82 */     super(paramInt);
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
/*     */   public LinkedMap(int paramInt, float paramFloat) {
/*  95 */     super(paramInt, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinkedMap(Map<? extends K, ? extends V> paramMap) {
/* 105 */     super(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinkedMap<K, V> clone() {
/* 116 */     return (LinkedMap<K, V>)super.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 123 */     paramObjectOutputStream.defaultWriteObject();
/* 124 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 131 */     paramObjectInputStream.defaultReadObject();
/* 132 */     doReadObject(paramObjectInputStream);
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
/*     */   public K get(int paramInt) {
/* 144 */     return getEntry(paramInt).getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue(int paramInt) {
/* 155 */     return getEntry(paramInt).getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 165 */     paramObject = convertKey(paramObject);
/* 166 */     byte b = 0;
/* 167 */     for (AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after; linkEntry != this.header; linkEntry = linkEntry.after, b++) {
/* 168 */       if (isEqualKey(paramObject, linkEntry.key)) {
/* 169 */         return b;
/*     */       }
/*     */     } 
/* 172 */     return -1;
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
/*     */   public V remove(int paramInt) {
/* 184 */     return remove(get(paramInt));
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
/*     */   public List<K> asList() {
/* 203 */     return new LinkedMapList<K>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   static class LinkedMapList<K>
/*     */     extends AbstractList<K>
/*     */   {
/*     */     private final LinkedMap<K, ?> parent;
/*     */ 
/*     */     
/*     */     LinkedMapList(LinkedMap<K, ?> param1LinkedMap) {
/* 214 */       this.parent = param1LinkedMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 219 */       return this.parent.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public K get(int param1Int) {
/* 224 */       return this.parent.get(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 229 */       return this.parent.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 234 */       return this.parent.indexOf(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 239 */       return this.parent.indexOf(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsAll(Collection<?> param1Collection) {
/* 244 */       return this.parent.keySet().containsAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public K remove(int param1Int) {
/* 249 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 254 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> param1Collection) {
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> param1Collection) {
/* 264 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */ 
/*     */     
/*     */     public Object[] toArray() {
/* 274 */       return this.parent.keySet().toArray();
/*     */     }
/*     */ 
/*     */     
/*     */     public <T> T[] toArray(T[] param1ArrayOfT) {
/* 279 */       return (T[])this.parent.keySet().toArray((Object[])param1ArrayOfT);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<K> iterator() {
/* 284 */       return UnmodifiableIterator.unmodifiableIterator(this.parent.keySet().iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public ListIterator<K> listIterator() {
/* 289 */       return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public ListIterator<K> listIterator(int param1Int) {
/* 294 */       return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public List<K> subList(int param1Int1, int param1Int2) {
/* 299 */       return UnmodifiableList.unmodifiableList(super.subList(param1Int1, param1Int2));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\LinkedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */