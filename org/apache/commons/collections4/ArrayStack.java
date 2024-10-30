/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.EmptyStackException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class ArrayStack<E>
/*     */   extends ArrayList<E>
/*     */ {
/*     */   private static final long serialVersionUID = 2130079159931574599L;
/*     */   
/*     */   public ArrayStack() {}
/*     */   
/*     */   public ArrayStack(int paramInt) {
/*  66 */     super(paramInt);
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
/*     */   public boolean empty() {
/*  78 */     return isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E peek() throws EmptyStackException {
/*  88 */     int i = size();
/*  89 */     if (i <= 0) {
/*  90 */       throw new EmptyStackException();
/*     */     }
/*  92 */     return get(i - 1);
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
/*     */   public E peek(int paramInt) throws EmptyStackException {
/* 106 */     int i = size() - paramInt - 1;
/* 107 */     if (i < 0) {
/* 108 */       throw new EmptyStackException();
/*     */     }
/* 110 */     return get(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E pop() throws EmptyStackException {
/* 121 */     int i = size();
/* 122 */     if (i <= 0) {
/* 123 */       throw new EmptyStackException();
/*     */     }
/* 125 */     return remove(i - 1);
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
/*     */   public E push(E paramE) {
/* 137 */     add(paramE);
/* 138 */     return paramE;
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
/*     */   public int search(Object paramObject) {
/* 153 */     int i = size() - 1;
/* 154 */     byte b = 1;
/* 155 */     while (i >= 0) {
/* 156 */       E e = get(i);
/* 157 */       if ((paramObject == null && e == null) || (paramObject != null && paramObject.equals(e)))
/*     */       {
/* 159 */         return b;
/*     */       }
/* 161 */       i--;
/* 162 */       b++;
/*     */     } 
/* 164 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\ArrayStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */