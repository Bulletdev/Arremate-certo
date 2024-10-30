/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedMap<K, V>
/*     */   extends AbstractInputCheckedMapDecorator<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7023152376788900464L;
/*     */   protected final Transformer<? super K, ? extends K> keyTransformer;
/*     */   protected final Transformer<? super V, ? extends V> valueTransformer;
/*     */   
/*     */   public static <K, V> TransformedMap<K, V> transformingMap(Map<K, V> paramMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/*  79 */     return new TransformedMap<K, V>(paramMap, paramTransformer, paramTransformer1);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> TransformedMap<K, V> transformedMap(Map<K, V> paramMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 102 */     TransformedMap<K, V> transformedMap = new TransformedMap<K, V>(paramMap, paramTransformer, paramTransformer1);
/* 103 */     if (paramMap.size() > 0) {
/* 104 */       Map<K, V> map = transformedMap.transformMap(paramMap);
/* 105 */       transformedMap.clear();
/* 106 */       transformedMap.decorated().putAll(map);
/*     */     } 
/* 108 */     return transformedMap;
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
/*     */   protected TransformedMap(Map<K, V> paramMap, Transformer<? super K, ? extends K> paramTransformer, Transformer<? super V, ? extends V> paramTransformer1) {
/* 125 */     super(paramMap);
/* 126 */     this.keyTransformer = paramTransformer;
/* 127 */     this.valueTransformer = paramTransformer1;
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
/* 139 */     paramObjectOutputStream.defaultWriteObject();
/* 140 */     paramObjectOutputStream.writeObject(this.map);
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
/* 153 */     paramObjectInputStream.defaultReadObject();
/* 154 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
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
/*     */   protected K transformKey(K paramK) {
/* 167 */     if (this.keyTransformer == null) {
/* 168 */       return paramK;
/*     */     }
/* 170 */     return (K)this.keyTransformer.transform(paramK);
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
/*     */   protected V transformValue(V paramV) {
/* 182 */     if (this.valueTransformer == null) {
/* 183 */       return paramV;
/*     */     }
/* 185 */     return (V)this.valueTransformer.transform(paramV);
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
/*     */   protected Map<K, V> transformMap(Map<? extends K, ? extends V> paramMap) {
/* 198 */     if (paramMap.isEmpty()) {
/* 199 */       return (Map)paramMap;
/*     */     }
/* 201 */     LinkedMap<Object, Object> linkedMap = new LinkedMap<Object, Object>(paramMap.size());
/*     */     
/* 203 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 204 */       linkedMap.put(transformKey((K)entry.getKey()), transformValue((V)entry.getValue()));
/*     */     }
/* 206 */     return (Map)linkedMap;
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
/*     */   protected V checkSetValue(V paramV) {
/* 218 */     return (V)this.valueTransformer.transform(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSetValueChecking() {
/* 229 */     return (this.valueTransformer != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 235 */     paramK = transformKey(paramK);
/* 236 */     paramV = transformValue(paramV);
/* 237 */     return decorated().put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 242 */     paramMap = transformMap(paramMap);
/* 243 */     decorated().putAll(paramMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\TransformedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */