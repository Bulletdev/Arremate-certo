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
/*     */ import java.util.HashMap;
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
/*     */ public final class ad<K extends Enum<K>, V>
/*     */   extends a<K, V>
/*     */ {
/*     */   private transient Class<K> b;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K extends Enum<K>, V> ad<K, V> a(Class<K> paramClass) {
/*  53 */     return new ad<>(paramClass);
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
/*     */   public static <K extends Enum<K>, V> ad<K, V> a(Map<K, ? extends V> paramMap) {
/*  67 */     ad<Enum, ?> ad1 = a(ac.a(paramMap));
/*  68 */     ad1.putAll(paramMap);
/*  69 */     return (ad)ad1;
/*     */   }
/*     */   
/*     */   private ad(Class<K> paramClass) {
/*  73 */     super(new EnumMap<>(paramClass), 
/*     */         
/*  75 */         bW.a(((Enum[])paramClass.getEnumConstants()).length));
/*  76 */     this.b = paramClass;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   K a(K paramK) {
/*  83 */     return (K)D.checkNotNull(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public V a(K paramK, V paramV) {
/*  89 */     return super.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public V b(K paramK, V paramV) {
/*  95 */     return super.c(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<K> b() {
/* 100 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 109 */     paramObjectOutputStream.defaultWriteObject();
/* 110 */     paramObjectOutputStream.writeObject(this.b);
/* 111 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 117 */     paramObjectInputStream.defaultReadObject();
/* 118 */     this.b = (Class<K>)paramObjectInputStream.readObject();
/* 119 */     a(new EnumMap<>(this.b), new HashMap<>(((Enum[])this.b
/* 120 */           .getEnumConstants()).length * 3 / 2));
/* 121 */     cE.a(this, paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */