/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.commons.collections4.SortedBag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TreeBag<E>
/*     */   extends AbstractMapBag<E>
/*     */   implements Serializable, SortedBag<E>
/*     */ {
/*     */   private static final long serialVersionUID = -7740146511091606676L;
/*     */   
/*     */   public TreeBag() {
/*  53 */     super(new TreeMap<E, AbstractMapBag.MutableInteger>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TreeBag(Comparator<? super E> paramComparator) {
/*  63 */     super(new TreeMap<E, AbstractMapBag.MutableInteger>(paramComparator));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TreeBag(Collection<? extends E> paramCollection) {
/*  73 */     this();
/*  74 */     addAll(paramCollection);
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
/*     */   public boolean add(E paramE) {
/*  88 */     if (comparator() == null && !(paramE instanceof Comparable)) {
/*  89 */       if (paramE == null) {
/*  90 */         throw new NullPointerException();
/*     */       }
/*  92 */       throw new IllegalArgumentException("Objects of type " + paramE.getClass() + " cannot be added to " + "a naturally ordered TreeBag as it does not implement Comparable");
/*     */     } 
/*     */     
/*  95 */     return super.add(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E first() {
/* 102 */     return getMap().firstKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public E last() {
/* 107 */     return getMap().lastKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/* 112 */     return getMap().comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   protected SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
/* 117 */     return (SortedMap<E, AbstractMapBag.MutableInteger>)super.getMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 125 */     paramObjectOutputStream.defaultWriteObject();
/* 126 */     paramObjectOutputStream.writeObject(comparator());
/* 127 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 134 */     paramObjectInputStream.defaultReadObject();
/*     */     
/* 136 */     Comparator<? super E> comparator = (Comparator)paramObjectInputStream.readObject();
/* 137 */     doReadObject(new TreeMap<E, AbstractMapBag.MutableInteger>(comparator), paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\TreeBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */