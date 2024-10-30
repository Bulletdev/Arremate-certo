/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.Transformer;
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
/*     */ public class LazyMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7990956402564206740L;
/*     */   protected final Transformer<? super K, ? extends V> factory;
/*     */   
/*     */   public static <K, V> LazyMap<K, V> lazyMap(Map<K, V> paramMap, Factory<? extends V> paramFactory) {
/*  82 */     return new LazyMap<K, V>(paramMap, paramFactory);
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
/*     */   public static <V, K> LazyMap<K, V> lazyMap(Map<K, V> paramMap, Transformer<? super K, ? extends V> paramTransformer) {
/*  97 */     return new LazyMap<K, V>(paramMap, paramTransformer);
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
/*     */   protected LazyMap(Map<K, V> paramMap, Factory<? extends V> paramFactory) {
/* 109 */     super(paramMap);
/* 110 */     if (paramFactory == null) {
/* 111 */       throw new NullPointerException("Factory must not be null");
/*     */     }
/* 113 */     this.factory = FactoryTransformer.factoryTransformer(paramFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LazyMap(Map<K, V> paramMap, Transformer<? super K, ? extends V> paramTransformer) {
/* 124 */     super(paramMap);
/* 125 */     if (paramTransformer == null) {
/* 126 */       throw new NullPointerException("Factory must not be null");
/*     */     }
/* 128 */     this.factory = paramTransformer;
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
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 140 */     paramObjectOutputStream.defaultWriteObject();
/* 141 */     paramObjectOutputStream.writeObject(this.map);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 154 */     paramObjectInputStream.defaultReadObject();
/* 155 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 162 */     if (!this.map.containsKey(paramObject)) {
/*     */       
/* 164 */       Object object1 = paramObject;
/* 165 */       Object object2 = this.factory.transform(object1);
/* 166 */       this.map.put((K)object1, (V)object2);
/* 167 */       return (V)object2;
/*     */     } 
/* 169 */     return this.map.get(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\LazyMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */