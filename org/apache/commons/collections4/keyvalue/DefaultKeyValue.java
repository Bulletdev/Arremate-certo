/*     */ package org.apache.commons.collections4.keyvalue;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.KeyValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultKeyValue<K, V>
/*     */   extends AbstractKeyValue<K, V>
/*     */ {
/*     */   public DefaultKeyValue() {
/*  39 */     super(null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultKeyValue(K paramK, V paramV) {
/*  49 */     super(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultKeyValue(KeyValue<? extends K, ? extends V> paramKeyValue) {
/*  59 */     super((K)paramKeyValue.getKey(), (V)paramKeyValue.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultKeyValue(Map.Entry<? extends K, ? extends V> paramEntry) {
/*  69 */     super(paramEntry.getKey(), paramEntry.getValue());
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
/*     */   public K setKey(K paramK) {
/*  82 */     if (paramK == this) {
/*  83 */       throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
/*     */     }
/*     */     
/*  86 */     return super.setKey(paramK);
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
/*     */   public V setValue(V paramV) {
/*  98 */     if (paramV == this) {
/*  99 */       throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
/*     */     }
/*     */     
/* 102 */     return super.setValue(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> toMapEntry() {
/* 112 */     return new DefaultMapEntry<K, V>(this);
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
/*     */   public boolean equals(Object paramObject) {
/* 127 */     if (paramObject == this) {
/* 128 */       return true;
/*     */     }
/* 130 */     if (!(paramObject instanceof DefaultKeyValue)) {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     DefaultKeyValue defaultKeyValue = (DefaultKeyValue)paramObject;
/* 135 */     return (((getKey() == null) ? (defaultKeyValue.getKey() == null) : getKey().equals(defaultKeyValue.getKey())) && ((getValue() == null) ? (defaultKeyValue.getValue() == null) : getValue().equals(defaultKeyValue.getValue())));
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
/*     */   public int hashCode() {
/* 150 */     return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((getValue() == null) ? 0 : getValue().hashCode());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\keyvalue\DefaultKeyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */