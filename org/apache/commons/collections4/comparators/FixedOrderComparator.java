/*     */ package org.apache.commons.collections4.comparators;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FixedOrderComparator<T>
/*     */   implements Serializable, Comparator<T>
/*     */ {
/*     */   private static final long serialVersionUID = 82794675842863201L;
/*     */   
/*     */   public enum UnknownObjectBehavior
/*     */   {
/*  59 */     BEFORE, AFTER, EXCEPTION;
/*     */   }
/*     */ 
/*     */   
/*  63 */   private final Map<T, Integer> map = new HashMap<T, Integer>();
/*     */ 
/*     */   
/*  66 */   private int counter = 0;
/*     */ 
/*     */   
/*     */   private boolean isLocked = false;
/*     */ 
/*     */   
/*  72 */   private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;
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
/*     */   public FixedOrderComparator() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FixedOrderComparator(T... paramVarArgs) {
/*  94 */     if (paramVarArgs == null) {
/*  95 */       throw new NullPointerException("The list of items must not be null");
/*     */     }
/*  97 */     for (T t : paramVarArgs) {
/*  98 */       add(t);
/*     */     }
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
/*     */   
/*     */   public FixedOrderComparator(List<T> paramList) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial <init> : ()V
/*     */     //   4: aload_0
/*     */     //   5: new java/util/HashMap
/*     */     //   8: dup
/*     */     //   9: invokespecial <init> : ()V
/*     */     //   12: putfield map : Ljava/util/Map;
/*     */     //   15: aload_0
/*     */     //   16: iconst_0
/*     */     //   17: putfield counter : I
/*     */     //   20: aload_0
/*     */     //   21: iconst_0
/*     */     //   22: putfield isLocked : Z
/*     */     //   25: aload_0
/*     */     //   26: getstatic org/apache/commons/collections4/comparators/FixedOrderComparator$UnknownObjectBehavior.EXCEPTION : Lorg/apache/commons/collections4/comparators/FixedOrderComparator$UnknownObjectBehavior;
/*     */     //   29: putfield unknownObjectBehavior : Lorg/apache/commons/collections4/comparators/FixedOrderComparator$UnknownObjectBehavior;
/*     */     //   32: aload_1
/*     */     //   33: ifnonnull -> 46
/*     */     //   36: new java/lang/NullPointerException
/*     */     //   39: dup
/*     */     //   40: ldc 'The list of items must not be null'
/*     */     //   42: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   45: athrow
/*     */     //   46: aload_1
/*     */     //   47: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   52: astore_2
/*     */     //   53: aload_2
/*     */     //   54: invokeinterface hasNext : ()Z
/*     */     //   59: ifeq -> 78
/*     */     //   62: aload_2
/*     */     //   63: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   68: astore_3
/*     */     //   69: aload_0
/*     */     //   70: aload_3
/*     */     //   71: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   74: pop
/*     */     //   75: goto -> 53
/*     */     //   78: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #112	-> 0
/*     */     //   #63	-> 4
/*     */     //   #66	-> 15
/*     */     //   #69	-> 20
/*     */     //   #72	-> 25
/*     */     //   #113	-> 32
/*     */     //   #114	-> 36
/*     */     //   #116	-> 46
/*     */     //   #117	-> 69
/*     */     //   #118	-> 75
/*     */     //   #119	-> 78
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
/*     */   
/*     */   public boolean isLocked() {
/* 131 */     return this.isLocked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkLocked() {
/* 140 */     if (isLocked()) {
/* 141 */       throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnknownObjectBehavior getUnknownObjectBehavior() {
/* 151 */     return this.unknownObjectBehavior;
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
/*     */   public void setUnknownObjectBehavior(UnknownObjectBehavior paramUnknownObjectBehavior) {
/* 163 */     checkLocked();
/* 164 */     if (paramUnknownObjectBehavior == null) {
/* 165 */       throw new NullPointerException("Unknown object behavior must not be null");
/*     */     }
/* 167 */     this.unknownObjectBehavior = paramUnknownObjectBehavior;
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
/*     */   
/*     */   public boolean add(T paramT) {
/* 183 */     checkLocked();
/* 184 */     Integer integer = this.map.put(paramT, Integer.valueOf(this.counter++));
/* 185 */     return (integer == null);
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
/*     */ 
/*     */   
/*     */   public boolean addAsEqual(T paramT1, T paramT2) {
/* 202 */     checkLocked();
/* 203 */     Integer integer1 = this.map.get(paramT1);
/* 204 */     if (integer1 == null) {
/* 205 */       throw new IllegalArgumentException((new StringBuilder()).append(paramT1).append(" not known to ").append(this).toString());
/*     */     }
/* 207 */     Integer integer2 = this.map.put(paramT2, integer1);
/* 208 */     return (integer2 == null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(T paramT1, T paramT2) {
/* 229 */     this.isLocked = true;
/* 230 */     Integer integer1 = this.map.get(paramT1);
/* 231 */     Integer integer2 = this.map.get(paramT2);
/* 232 */     if (integer1 == null || integer2 == null) {
/* 233 */       T t; switch (this.unknownObjectBehavior) {
/*     */         case BEFORE:
/* 235 */           return (integer1 == null) ? ((integer2 == null) ? 0 : -1) : 1;
/*     */         case AFTER:
/* 237 */           return (integer1 == null) ? ((integer2 == null) ? 0 : 1) : -1;
/*     */         case EXCEPTION:
/* 239 */           t = (integer1 == null) ? paramT1 : paramT2;
/* 240 */           throw new IllegalArgumentException("Attempting to compare unknown object " + t);
/*     */       } 
/*     */       
/* 243 */       throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
/*     */     } 
/*     */ 
/*     */     
/* 247 */     return integer1.compareTo(integer2);
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
/*     */   public int hashCode() {
/* 259 */     int i = 17;
/* 260 */     i = i * 37 + ((this.map == null) ? 0 : this.map.hashCode());
/* 261 */     i = i * 37 + ((this.unknownObjectBehavior == null) ? 0 : this.unknownObjectBehavior.hashCode());
/* 262 */     i = i * 37 + this.counter;
/* 263 */     i = i * 37 + (this.isLocked ? 0 : 1);
/* 264 */     return i;
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
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 281 */     if (this == paramObject) {
/* 282 */       return true;
/*     */     }
/* 284 */     if (null == paramObject) {
/* 285 */       return false;
/*     */     }
/* 287 */     if (paramObject.getClass().equals(getClass())) {
/* 288 */       FixedOrderComparator fixedOrderComparator = (FixedOrderComparator)paramObject;
/* 289 */       return (((null == this.map) ? (null == fixedOrderComparator.map) : this.map.equals(fixedOrderComparator.map)) && ((null == this.unknownObjectBehavior) ? (null == fixedOrderComparator.unknownObjectBehavior) : (this.unknownObjectBehavior == fixedOrderComparator.unknownObjectBehavior && this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && this.unknownObjectBehavior == fixedOrderComparator.unknownObjectBehavior)));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 296 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\FixedOrderComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */