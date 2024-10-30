/*    */ package com.google.a.c;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.d.bj;
/*    */ import com.google.a.o.a.au;
/*    */ import java.util.concurrent.ExecutionException;
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
/*    */ @c
/*    */ public abstract class b<K, V>
/*    */   extends a<K, V>
/*    */   implements j<K, V>
/*    */ {
/*    */   public V h(K paramK) {
/*    */     try {
/* 50 */       return get(paramK);
/* 51 */     } catch (ExecutionException executionException) {
/* 52 */       throw new au(executionException.getCause());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public bj<K, V> b(Iterable<? extends K> paramIterable) throws ExecutionException {
/*    */     // Byte code:
/*    */     //   0: invokestatic a : ()Ljava/util/LinkedHashMap;
/*    */     //   3: astore_2
/*    */     //   4: aload_1
/*    */     //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   10: astore_3
/*    */     //   11: aload_3
/*    */     //   12: invokeinterface hasNext : ()Z
/*    */     //   17: ifeq -> 57
/*    */     //   20: aload_3
/*    */     //   21: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   26: astore #4
/*    */     //   28: aload_2
/*    */     //   29: aload #4
/*    */     //   31: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*    */     //   36: ifne -> 54
/*    */     //   39: aload_2
/*    */     //   40: aload #4
/*    */     //   42: aload_0
/*    */     //   43: aload #4
/*    */     //   45: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   48: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*    */     //   53: pop
/*    */     //   54: goto -> 11
/*    */     //   57: aload_2
/*    */     //   58: invokestatic a : (Ljava/util/Map;)Lcom/google/a/d/bj;
/*    */     //   61: areturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #58	-> 0
/*    */     //   #59	-> 4
/*    */     //   #60	-> 28
/*    */     //   #61	-> 39
/*    */     //   #63	-> 54
/*    */     //   #64	-> 57
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final V apply(K paramK) {
/* 69 */     return h(paramK);
/*    */   }
/*    */ 
/*    */   
/*    */   public void e(K paramK) {
/* 74 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */