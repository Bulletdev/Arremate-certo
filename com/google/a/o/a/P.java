/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import java.util.concurrent.atomic.AtomicReference;
/*    */ import java.util.concurrent.atomic.AtomicReferenceArray;
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
/*    */ @c
/*    */ public final class p
/*    */ {
/*    */   public static <V> AtomicReference<V> a() {
/* 38 */     return new AtomicReference<>();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <V> AtomicReference<V> a(V paramV) {
/* 48 */     return new AtomicReference<>(paramV);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> AtomicReferenceArray<E> b(int paramInt) {
/* 58 */     return new AtomicReferenceArray<>(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> AtomicReferenceArray<E> a(E[] paramArrayOfE) {
/* 69 */     return new AtomicReferenceArray<>(paramArrayOfE);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */