/*     */ package org.apache.commons.collections4.splitmap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.Put;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.map.LinkedMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedSplitMap<J, K, U, V>
/*     */   extends AbstractIterableGetMapDecorator<K, V>
/*     */   implements Serializable, Put<J, U>
/*     */ {
/*     */   private static final long serialVersionUID = 5966875321133456994L;
/*     */   private final Transformer<? super J, ? extends K> keyTransformer;
/*     */   private final Transformer<? super U, ? extends V> valueTransformer;
/*     */   
/*     */   public static <J, K, U, V> TransformedSplitMap<J, K, U, V> transformingMap(Map<K, V> paramMap, Transformer<? super J, ? extends K> paramTransformer, Transformer<? super U, ? extends V> paramTransformer1) {
/*  91 */     return new TransformedSplitMap<J, K, U, V>(paramMap, paramTransformer, paramTransformer1);
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
/*     */   protected TransformedSplitMap(Map<K, V> paramMap, Transformer<? super J, ? extends K> paramTransformer, Transformer<? super U, ? extends V> paramTransformer1) {
/* 108 */     super(paramMap);
/* 109 */     if (paramTransformer == null) {
/* 110 */       throw new NullPointerException("KeyTransformer must not be null.");
/*     */     }
/* 112 */     this.keyTransformer = paramTransformer;
/* 113 */     if (paramTransformer1 == null) {
/* 114 */       throw new NullPointerException("ValueTransformer must not be null.");
/*     */     }
/* 116 */     this.valueTransformer = paramTransformer1;
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
/* 127 */     paramObjectOutputStream.defaultWriteObject();
/* 128 */     paramObjectOutputStream.writeObject(decorated());
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
/* 141 */     paramObjectInputStream.defaultReadObject();
/* 142 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
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
/*     */   protected K transformKey(J paramJ) {
/* 155 */     return (K)this.keyTransformer.transform(paramJ);
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
/*     */   protected V transformValue(U paramU) {
/* 167 */     return (V)this.valueTransformer.transform(paramU);
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
/*     */   protected Map<K, V> transformMap(Map<? extends J, ? extends U> paramMap) {
/* 180 */     if (paramMap.isEmpty()) {
/* 181 */       return (Map)paramMap;
/*     */     }
/* 183 */     LinkedMap<K, V> linkedMap = new LinkedMap(paramMap.size());
/*     */     
/* 185 */     for (Map.Entry<? extends J, ? extends U> entry : paramMap.entrySet()) {
/* 186 */       linkedMap.put(transformKey((J)entry.getKey()), transformValue((U)entry.getValue()));
/*     */     }
/* 188 */     return (Map<K, V>)linkedMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected V checkSetValue(U paramU) {
/* 198 */     return (V)this.valueTransformer.transform(paramU);
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(J paramJ, U paramU) {
/* 203 */     return decorated().put(transformKey(paramJ), transformValue(paramU));
/*     */   }
/*     */   
/*     */   public void putAll(Map<? extends J, ? extends U> paramMap) {
/* 207 */     decorated().putAll(transformMap(paramMap));
/*     */   }
/*     */   
/*     */   public void clear() {
/* 211 */     decorated().clear();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\splitmap\TransformedSplitMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */