/*    */ package org.apache.commons.collections4;
/*    */ 
/*    */ import org.apache.commons.collections4.trie.UnmodifiableTrie;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TrieUtils
/*    */ {
/*    */   public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> paramTrie) {
/* 46 */     return UnmodifiableTrie.unmodifiableTrie(paramTrie);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\TrieUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */