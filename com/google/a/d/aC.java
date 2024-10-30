/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class ac<K extends Enum<K>, V extends Enum<V>>
/*     */   extends a<K, V>
/*     */ {
/*     */   private transient Class<K> b;
/*     */   private transient Class<V> c;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K extends Enum<K>, V extends Enum<V>> ac<K, V> a(Class<K> paramClass, Class<V> paramClass1) {
/*  53 */     return new ac<>(paramClass, paramClass1);
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
/*     */   public static <K extends Enum<K>, V extends Enum<V>> ac<K, V> a(Map<K, V> paramMap) {
/*  66 */     ac<Enum, Enum> ac1 = a(a(paramMap), b(paramMap));
/*  67 */     ac1.putAll(paramMap);
/*  68 */     return (ac)ac1;
/*     */   }
/*     */   
/*     */   private ac(Class<K> paramClass, Class<V> paramClass1) {
/*  72 */     super(new EnumMap<>(paramClass), (Map)new EnumMap<>(paramClass1));
/*  73 */     this.b = paramClass;
/*  74 */     this.c = paramClass1;
/*     */   }
/*     */   
/*     */   static <K extends Enum<K>> Class<K> a(Map<K, ?> paramMap) {
/*  78 */     if (paramMap instanceof ac) {
/*  79 */       return ((ac)paramMap).b();
/*     */     }
/*  81 */     if (paramMap instanceof ad) {
/*  82 */       return ((ad)paramMap).b();
/*     */     }
/*  84 */     D.checkArgument(!paramMap.isEmpty());
/*  85 */     return ((Enum<K>)paramMap.keySet().iterator().next()).getDeclaringClass();
/*     */   }
/*     */   
/*     */   private static <V extends Enum<V>> Class<V> b(Map<?, V> paramMap) {
/*  89 */     if (paramMap instanceof ac) {
/*  90 */       return ((ac)paramMap).c;
/*     */     }
/*  92 */     D.checkArgument(!paramMap.isEmpty());
/*  93 */     return ((Enum<V>)paramMap.values().iterator().next()).getDeclaringClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<K> b() {
/*  98 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<V> c() {
/* 103 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   K a(K paramK) {
/* 108 */     return (K)D.checkNotNull(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   V b(V paramV) {
/* 113 */     return (V)D.checkNotNull(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 122 */     paramObjectOutputStream.defaultWriteObject();
/* 123 */     paramObjectOutputStream.writeObject(this.b);
/* 124 */     paramObjectOutputStream.writeObject(this.c);
/* 125 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 131 */     paramObjectInputStream.defaultReadObject();
/* 132 */     this.b = (Class<K>)paramObjectInputStream.readObject();
/* 133 */     this.c = (Class<V>)paramObjectInputStream.readObject();
/* 134 */     a(new EnumMap<>(this.b), (Map)new EnumMap<>(this.c));
/* 135 */     cE.a(this, paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */