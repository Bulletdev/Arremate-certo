/*     */ package org.apache.commons.collections4.trie;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.Trie;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractBitwiseTrie<K, V>
/*     */   extends AbstractMap<K, V>
/*     */   implements Serializable, Trie<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 5826987063535505652L;
/*     */   private final KeyAnalyzer<? super K> keyAnalyzer;
/*     */   
/*     */   protected AbstractBitwiseTrie(KeyAnalyzer<? super K> paramKeyAnalyzer) {
/*  49 */     if (paramKeyAnalyzer == null) {
/*  50 */       throw new NullPointerException("keyAnalyzer");
/*     */     }
/*     */     
/*  53 */     this.keyAnalyzer = paramKeyAnalyzer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected KeyAnalyzer<? super K> getKeyAnalyzer() {
/*  61 */     return this.keyAnalyzer;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  66 */     StringBuilder stringBuilder = new StringBuilder();
/*  67 */     stringBuilder.append("Trie[").append(size()).append("]={\n");
/*  68 */     for (Map.Entry<K, V> entry : entrySet()) {
/*  69 */       stringBuilder.append("  ").append(entry).append("\n");
/*     */     }
/*  71 */     stringBuilder.append("}\n");
/*  72 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final K castKey(Object paramObject) {
/*  80 */     return (K)paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int lengthInBits(K paramK) {
/*  89 */     if (paramK == null) {
/*  90 */       return 0;
/*     */     }
/*     */     
/*  93 */     return this.keyAnalyzer.lengthInBits(paramK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int bitsPerElement() {
/* 102 */     return this.keyAnalyzer.bitsPerElement();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean isBitSet(K paramK, int paramInt1, int paramInt2) {
/* 111 */     if (paramK == null) {
/* 112 */       return false;
/*     */     }
/* 114 */     return this.keyAnalyzer.isBitSet(paramK, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final int bitIndex(K paramK1, K paramK2) {
/* 121 */     return this.keyAnalyzer.bitIndex(paramK1, 0, lengthInBits(paramK1), paramK2, 0, lengthInBits(paramK2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean compareKeys(K paramK1, K paramK2) {
/* 128 */     if (paramK1 == null)
/* 129 */       return (paramK2 == null); 
/* 130 */     if (paramK2 == null) {
/* 131 */       return false;
/*     */     }
/*     */     
/* 134 */     return (this.keyAnalyzer.compare(paramK1, paramK2) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean compare(Object paramObject1, Object paramObject2) {
/* 141 */     return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class BasicEntry<K, V>
/*     */     implements Serializable, Map.Entry<K, V>
/*     */   {
/*     */     private static final long serialVersionUID = -944364551314110330L;
/*     */     
/*     */     protected K key;
/*     */     
/*     */     protected V value;
/*     */ 
/*     */     
/*     */     public BasicEntry(K param1K) {
/* 156 */       this.key = param1K;
/*     */     }
/*     */     
/*     */     public BasicEntry(K param1K, V param1V) {
/* 160 */       this.key = param1K;
/* 161 */       this.value = param1V;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public V setKeyValue(K param1K, V param1V) {
/* 168 */       this.key = param1K;
/* 169 */       return setValue(param1V);
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 173 */       return this.key;
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 177 */       return this.value;
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 181 */       V v = this.value;
/* 182 */       this.value = param1V;
/* 183 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 188 */       return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((getValue() == null) ? 0 : getValue().hashCode());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 194 */       if (param1Object == this)
/* 195 */         return true; 
/* 196 */       if (!(param1Object instanceof Map.Entry)) {
/* 197 */         return false;
/*     */       }
/*     */       
/* 200 */       Map.Entry entry = (Map.Entry)param1Object;
/* 201 */       if (AbstractBitwiseTrie.compare(this.key, entry.getKey()) && AbstractBitwiseTrie.compare(this.value, entry.getValue()))
/*     */       {
/* 203 */         return true;
/*     */       }
/* 205 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 210 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\trie\AbstractBitwiseTrie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */