/*    */ package com.google.a.d;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.D;
/*    */ import com.google.a.b.E;
/*    */ import com.google.a.b.F;
/*    */ import com.google.a.b.y;
/*    */ import com.google.c.a.i;
/*    */ import java.util.AbstractCollection;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
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
/*    */ final class an<K, V>
/*    */   extends AbstractCollection<V>
/*    */ {
/*    */   @i
/*    */   private final am<K, V> a;
/*    */   
/*    */   an(am<K, V> paramam) {
/* 40 */     this.a = (am<K, V>)D.checkNotNull(paramam);
/*    */   }
/*    */ 
/*    */   
/*    */   public Iterator<V> iterator() {
/* 45 */     return bW.d(this.a.entries().iterator());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(Object paramObject) {
/* 50 */     return this.a.containsValue(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 55 */     return this.a.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean remove(Object paramObject) {
/* 60 */     E<? super Map.Entry<K, V>> e = this.a.f();
/* 61 */     Iterator<Map.Entry> iterator = this.a.b().entries().iterator();
/* 62 */     while (iterator.hasNext()) {
/* 63 */       Map.Entry entry = iterator.next();
/* 64 */       if (e.b(entry) && y.equal(entry.getValue(), paramObject)) {
/* 65 */         iterator.remove();
/* 66 */         return true;
/*    */       } 
/*    */     } 
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean removeAll(Collection<?> paramCollection) {
/* 74 */     return bG.a(this.a
/* 75 */         .b().entries(), 
/*    */         
/* 77 */         F.a(this.a
/* 78 */           .f(), bW.c(F.a(paramCollection))));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean retainAll(Collection<?> paramCollection) {
/* 83 */     return bG.a(this.a
/* 84 */         .b().entries(), 
/*    */         
/* 86 */         F.a(this.a
/* 87 */           .f(), 
/* 88 */           bW.c(F.a(F.a(paramCollection)))));
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 93 */     this.a.clear();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\an.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */