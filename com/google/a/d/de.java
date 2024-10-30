/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import java.util.function.BiConsumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ public class de<K, V>
/*     */   extends n<K, V>
/*     */ {
/*     */   private transient Comparator<? super K> a;
/*     */   private transient Comparator<? super V> valueComparator;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K extends Comparable, V extends Comparable> de<K, V> a() {
/*  83 */     return new de<>(cj.e(), cj.e());
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
/*     */   public static <K, V> de<K, V> a(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1) {
/*  95 */     return new de<>((Comparator<? super K>)D.checkNotNull(paramComparator), (Comparator<? super V>)D.checkNotNull(paramComparator1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K extends Comparable, V extends Comparable> de<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 106 */     return new de<>(cj.e(), cj.e(), parambZ);
/*     */   }
/*     */   
/*     */   de(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1) {
/* 110 */     super(new TreeMap<>(paramComparator));
/* 111 */     this.a = paramComparator;
/* 112 */     this.valueComparator = paramComparator1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private de(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1, bZ<? extends K, ? extends V> parambZ) {
/* 119 */     this(paramComparator, paramComparator1);
/* 120 */     a(parambZ);
/*     */   }
/*     */ 
/*     */   
/*     */   Map<K, Collection<V>> u() {
/* 125 */     return v();
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
/*     */   SortedSet<V> e() {
/* 137 */     return new TreeSet<>(this.valueComparator);
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> b(K paramK) {
/* 142 */     if (paramK == null) {
/* 143 */       d().compare(paramK, paramK);
/*     */     }
/* 145 */     return super.b(paramK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Comparator<? super K> d() {
/* 155 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super V> valueComparator() {
/* 160 */     return this.valueComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public NavigableSet<V> c(K paramK) {
/* 167 */     return (NavigableSet<V>)super.a(paramK);
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
/*     */   public NavigableSet<K> a() {
/* 181 */     return (NavigableSet<K>)super.b();
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
/*     */   public NavigableMap<K, Collection<V>> f() {
/* 195 */     return (NavigableMap<K, Collection<V>>)super.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 204 */     paramObjectOutputStream.defaultWriteObject();
/* 205 */     paramObjectOutputStream.writeObject(d());
/* 206 */     paramObjectOutputStream.writeObject(valueComparator());
/* 207 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 213 */     paramObjectInputStream.defaultReadObject();
/* 214 */     this.a = (Comparator<? super K>)D.checkNotNull(paramObjectInputStream.readObject());
/* 215 */     this.valueComparator = (Comparator<? super V>)D.checkNotNull(paramObjectInputStream.readObject());
/* 216 */     setMap(new TreeMap<>(this.a));
/* 217 */     cE.a(this, paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\de.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */