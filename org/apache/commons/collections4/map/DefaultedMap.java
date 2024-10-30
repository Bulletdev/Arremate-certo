/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.functors.ConstantTransformer;
/*     */ import org.apache.commons.collections4.functors.FactoryTransformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultedMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 19698628745827L;
/*     */   private final Transformer<? super K, ? extends V> value;
/*     */   
/*     */   public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> paramMap, V paramV) {
/*  87 */     return new DefaultedMap<K, V>(paramMap, ConstantTransformer.constantTransformer(paramV));
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
/*     */   public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> paramMap, Factory<? extends V> paramFactory) {
/* 105 */     if (paramFactory == null) {
/* 106 */       throw new IllegalArgumentException("Factory must not be null");
/*     */     }
/* 108 */     return new DefaultedMap<K, V>(paramMap, FactoryTransformer.factoryTransformer(paramFactory));
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
/*     */   
/*     */   public static <K, V> Map<K, V> defaultedMap(Map<K, V> paramMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 128 */     if (paramTransformer == null) {
/* 129 */       throw new IllegalArgumentException("Transformer must not be null");
/*     */     }
/* 131 */     return (Map<K, V>)new DefaultedMap<K, V>(paramMap, paramTransformer);
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
/*     */   public DefaultedMap(V paramV) {
/* 145 */     this(ConstantTransformer.constantTransformer(paramV));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultedMap(Transformer<? super K, ? extends V> paramTransformer) {
/* 154 */     this(new HashMap<K, V>(), paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected DefaultedMap(Map<K, V> paramMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 165 */     super(paramMap);
/* 166 */     if (paramTransformer == null) {
/* 167 */       throw new NullPointerException("Transformer must not be null.");
/*     */     }
/* 169 */     this.value = paramTransformer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 180 */     paramObjectOutputStream.defaultWriteObject();
/* 181 */     paramObjectOutputStream.writeObject(this.map);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 193 */     paramObjectInputStream.defaultReadObject();
/* 194 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 202 */     if (!this.map.containsKey(paramObject)) {
/* 203 */       return (V)this.value.transform(paramObject);
/*     */     }
/* 205 */     return this.map.get(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\DefaultedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */