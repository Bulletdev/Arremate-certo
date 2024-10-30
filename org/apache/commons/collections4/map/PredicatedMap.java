/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedMap<K, V>
/*     */   extends AbstractInputCheckedMapDecorator<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 7412622456128415156L;
/*     */   protected final Predicate<? super K> keyPredicate;
/*     */   protected final Predicate<? super V> valuePredicate;
/*     */   
/*     */   public static <K, V> PredicatedMap<K, V> predicatedMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/*  81 */     return new PredicatedMap<K, V>(paramMap, paramPredicate, paramPredicate1);
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
/*     */   protected PredicatedMap(Map<K, V> paramMap, Predicate<? super K> paramPredicate, Predicate<? super V> paramPredicate1) {
/*  95 */     super(paramMap);
/*  96 */     this.keyPredicate = paramPredicate;
/*  97 */     this.valuePredicate = paramPredicate1;
/*     */     
/*  99 */     Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
/* 100 */     while (iterator.hasNext()) {
/* 101 */       Map.Entry entry = iterator.next();
/* 102 */       validate((K)entry.getKey(), (V)entry.getValue());
/*     */     } 
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
/* 115 */     paramObjectOutputStream.defaultWriteObject();
/* 116 */     paramObjectOutputStream.writeObject(this.map);
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
/* 129 */     paramObjectInputStream.defaultReadObject();
/* 130 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
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
/*     */   protected void validate(K paramK, V paramV) {
/* 142 */     if (this.keyPredicate != null && !this.keyPredicate.evaluate(paramK)) {
/* 143 */       throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
/*     */     }
/* 145 */     if (this.valuePredicate != null && !this.valuePredicate.evaluate(paramV)) {
/* 146 */       throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
/*     */     }
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
/*     */   protected V checkSetValue(V paramV) {
/* 160 */     if (!this.valuePredicate.evaluate(paramV)) {
/* 161 */       throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
/*     */     }
/* 163 */     return paramV;
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
/* 174 */     return (this.valuePredicate != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 180 */     validate(paramK, paramV);
/* 181 */     return this.map.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 186 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 187 */       validate((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/* 189 */     super.putAll(paramMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\PredicatedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */