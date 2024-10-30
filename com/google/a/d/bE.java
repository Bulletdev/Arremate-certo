/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import java.io.Serializable;
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
/*    */ @b(ck = true)
/*    */ class be<K, V>
/*    */   extends g<K, V>
/*    */   implements Serializable
/*    */ {
/*    */   final K key;
/*    */   final V value;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   be(K paramK, V paramV) {
/* 30 */     this.key = paramK;
/* 31 */     this.value = paramV;
/*    */   }
/*    */ 
/*    */   
/*    */   public final K getKey() {
/* 36 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V getValue() {
/* 41 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V setValue(V paramV) {
/* 46 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\be.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */