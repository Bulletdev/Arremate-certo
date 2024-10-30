/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.b.a.a;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ @b(ck = true, cl = true)
/*     */ public final class s<K, V>
/*     */   extends t<K, V>
/*     */ {
/*     */   private static final int dT = 3;
/*     */   @d
/*     */   transient int dU;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K, V> s<K, V> a() {
/*  76 */     return new s<>();
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
/*     */   public static <K, V> s<K, V> a(int paramInt1, int paramInt2) {
/*  92 */     return new s<>(paramInt1, paramInt2);
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
/*     */   public static <K, V> s<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 104 */     return new s<>(parambZ);
/*     */   }
/*     */   
/*     */   private s() {
/* 108 */     this(12, 3);
/*     */   }
/*     */   
/*     */   private s(int paramInt1, int paramInt2) {
/* 112 */     super(cl.c(paramInt1));
/* 113 */     C.b(paramInt2, "expectedValuesPerKey");
/* 114 */     this.dU = paramInt2;
/*     */   }
/*     */   
/*     */   private s(bZ<? extends K, ? extends V> parambZ) {
/* 118 */     this(parambZ
/* 119 */         .keySet().size(), 
/* 120 */         (parambZ instanceof s) ? 
/* 121 */         ((s)parambZ).dU : 
/* 122 */         3);
/* 123 */     a(parambZ);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<V> createCollection() {
/* 131 */     return new ArrayList<>(this.dU);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void trimToSize() {
/* 143 */     for (Collection<V> collection : t().values()) {
/* 144 */       ArrayList arrayList = (ArrayList)collection;
/* 145 */       arrayList.trimToSize();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 155 */     paramObjectOutputStream.defaultWriteObject();
/* 156 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */   
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 161 */     paramObjectInputStream.defaultReadObject();
/* 162 */     this.dU = 3;
/* 163 */     int i = cE.a(paramObjectInputStream);
/* 164 */     HashMap<?, ?> hashMap = bW.a();
/* 165 */     setMap((Map)hashMap);
/* 166 */     cE.a(this, paramObjectInputStream, i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */