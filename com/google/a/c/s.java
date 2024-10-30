/*    */ package com.google.a.c;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.D;
/*    */ import java.util.AbstractMap;
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
/*    */ @b
/*    */ public final class s<K, V>
/*    */   extends AbstractMap.SimpleImmutableEntry<K, V>
/*    */ {
/*    */   private final p f;
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   public static <K, V> s<K, V> a(K paramK, V paramV, p paramp) {
/* 47 */     return new s<>(paramK, paramV, paramp);
/*    */   }
/*    */   
/*    */   private s(K paramK, V paramV, p paramp) {
/* 51 */     super(paramK, paramV);
/* 52 */     this.f = (p)D.checkNotNull(paramp);
/*    */   }
/*    */ 
/*    */   
/*    */   public p a() {
/* 57 */     return this.f;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean cM() {
/* 65 */     return this.f.cM();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\s.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */