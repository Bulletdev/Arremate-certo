/*    */ package org.d.a;
/*    */ 
/*    */ import org.d.g;
/*    */ import org.d.i;
/*    */ import org.d.k;
/*    */ import org.d.m;
/*    */ import org.d.o;
/*    */ 
/*    */ public class e<T>
/*    */   extends o<Iterable<T>> {
/*    */   public e(k<? super T> paramk) {
/* 12 */     this.b = paramk;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final k<? super T> b;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean a(Iterable<T> paramIterable, g paramg) {
/*    */     // Byte code:
/*    */     //   0: aload_1
/*    */     //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */     //   6: astore_3
/*    */     //   7: aload_3
/*    */     //   8: invokeinterface hasNext : ()Z
/*    */     //   13: ifeq -> 64
/*    */     //   16: aload_3
/*    */     //   17: invokeinterface next : ()Ljava/lang/Object;
/*    */     //   22: astore #4
/*    */     //   24: aload_0
/*    */     //   25: getfield b : Lorg/d/k;
/*    */     //   28: aload #4
/*    */     //   30: invokeinterface E : (Ljava/lang/Object;)Z
/*    */     //   35: ifne -> 61
/*    */     //   38: aload_2
/*    */     //   39: ldc 'an item '
/*    */     //   41: invokeinterface a : (Ljava/lang/String;)Lorg/d/g;
/*    */     //   46: pop
/*    */     //   47: aload_0
/*    */     //   48: getfield b : Lorg/d/k;
/*    */     //   51: aload #4
/*    */     //   53: aload_2
/*    */     //   54: invokeinterface a : (Ljava/lang/Object;Lorg/d/g;)V
/*    */     //   59: iconst_0
/*    */     //   60: ireturn
/*    */     //   61: goto -> 7
/*    */     //   64: iconst_1
/*    */     //   65: ireturn
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #17	-> 0
/*    */     //   #18	-> 24
/*    */     //   #19	-> 38
/*    */     //   #20	-> 47
/*    */     //   #21	-> 59
/*    */     //   #24	-> 64
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(g paramg) {
/* 29 */     paramg.a("every item is ").a((m)this.b);
/*    */   }
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
/*    */   @i
/*    */   public static <U> k<Iterable<U>> a(k<U> paramk) {
/* 45 */     return (k)new e<U>(paramk);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\d\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */