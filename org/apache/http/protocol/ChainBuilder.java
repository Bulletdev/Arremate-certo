/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
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
/*     */ final class ChainBuilder<E>
/*     */ {
/*  49 */   private final LinkedList<E> list = new LinkedList<E>();
/*  50 */   private final Map<Class<?>, E> uniqueClasses = new HashMap<Class<?>, E>();
/*     */ 
/*     */   
/*     */   private void ensureUnique(E paramE) {
/*  54 */     E e = this.uniqueClasses.remove(paramE.getClass());
/*  55 */     if (e != null) {
/*  56 */       this.list.remove(e);
/*     */     }
/*  58 */     this.uniqueClasses.put(paramE.getClass(), paramE);
/*     */   }
/*     */   
/*     */   public ChainBuilder<E> addFirst(E paramE) {
/*  62 */     if (paramE == null) {
/*  63 */       return this;
/*     */     }
/*  65 */     ensureUnique(paramE);
/*  66 */     this.list.addFirst(paramE);
/*  67 */     return this;
/*     */   }
/*     */   
/*     */   public ChainBuilder<E> addLast(E paramE) {
/*  71 */     if (paramE == null) {
/*  72 */       return this;
/*     */     }
/*  74 */     ensureUnique(paramE);
/*  75 */     this.list.addLast(paramE);
/*  76 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainBuilder<E> addAllFirst(Collection<E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 6
/*     */     //   4: aload_0
/*     */     //   5: areturn
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   12: astore_2
/*     */     //   13: aload_2
/*     */     //   14: invokeinterface hasNext : ()Z
/*     */     //   19: ifeq -> 38
/*     */     //   22: aload_2
/*     */     //   23: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   28: astore_3
/*     */     //   29: aload_0
/*     */     //   30: aload_3
/*     */     //   31: invokevirtual addFirst : (Ljava/lang/Object;)Lorg/apache/http/protocol/ChainBuilder;
/*     */     //   34: pop
/*     */     //   35: goto -> 13
/*     */     //   38: aload_0
/*     */     //   39: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #80	-> 0
/*     */     //   #81	-> 4
/*     */     //   #83	-> 6
/*     */     //   #84	-> 29
/*     */     //   #85	-> 35
/*     */     //   #86	-> 38
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainBuilder<E> addAllFirst(E... paramVarArgs) {
/*  90 */     if (paramVarArgs == null) {
/*  91 */       return this;
/*     */     }
/*  93 */     for (E e : paramVarArgs) {
/*  94 */       addFirst(e);
/*     */     }
/*  96 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainBuilder<E> addAllLast(Collection<E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: ifnonnull -> 6
/*     */     //   4: aload_0
/*     */     //   5: areturn
/*     */     //   6: aload_1
/*     */     //   7: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   12: astore_2
/*     */     //   13: aload_2
/*     */     //   14: invokeinterface hasNext : ()Z
/*     */     //   19: ifeq -> 38
/*     */     //   22: aload_2
/*     */     //   23: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   28: astore_3
/*     */     //   29: aload_0
/*     */     //   30: aload_3
/*     */     //   31: invokevirtual addLast : (Ljava/lang/Object;)Lorg/apache/http/protocol/ChainBuilder;
/*     */     //   34: pop
/*     */     //   35: goto -> 13
/*     */     //   38: aload_0
/*     */     //   39: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #100	-> 0
/*     */     //   #101	-> 4
/*     */     //   #103	-> 6
/*     */     //   #104	-> 29
/*     */     //   #105	-> 35
/*     */     //   #106	-> 38
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChainBuilder<E> addAllLast(E... paramVarArgs) {
/* 110 */     if (paramVarArgs == null) {
/* 111 */       return this;
/*     */     }
/* 113 */     for (E e : paramVarArgs) {
/* 114 */       addLast(e);
/*     */     }
/* 116 */     return this;
/*     */   }
/*     */   
/*     */   public LinkedList<E> build() {
/* 120 */     return new LinkedList<E>(this.list);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ChainBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */