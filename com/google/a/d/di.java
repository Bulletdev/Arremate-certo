/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.Iterator;
/*     */ import java.util.Queue;
/*     */ import java.util.function.Consumer;
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
/*     */ @a
/*     */ @b
/*     */ public abstract class di<T>
/*     */ {
/*     */   @Deprecated
/*     */   public static <T> di<T> a(s<T, ? extends Iterable<T>> params) {
/*  92 */     D.checkNotNull(params);
/*  93 */     return new di<T>(params)
/*     */       {
/*     */         public Iterable<T> a(T param1T) {
/*  96 */           return (Iterable<T>)this.j.apply(param1T);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Iterable<T> a(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final ap<T> a(T paramT) {
/* 116 */     D.checkNotNull(paramT);
/* 117 */     return new ap<T>(this, paramT)
/*     */       {
/*     */         public dj<T> b() {
/* 120 */           return this.a.b((T)this.Z);
/*     */         }
/*     */ 
/*     */         
/*     */         public void forEach(Consumer<? super T> param1Consumer) {
/* 125 */           D.checkNotNull(param1Consumer);
/* 126 */           (new Consumer<T>(this, param1Consumer)
/*     */             {
/*     */               public void accept(T param2T) {
/* 129 */                 this.a.accept(param2T);
/* 130 */                 this.a.a.a(param2T).forEach(this);
/*     */               }
/* 132 */             }).accept((T)this.Z);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   dj<T> b(T paramT) {
/* 138 */     return new d(this, paramT);
/*     */   }
/*     */   
/*     */   private final class d extends dj<T> {
/*     */     private final Deque<Iterator<T>> stack;
/*     */     
/*     */     d(di this$0, T param1T) {
/* 145 */       this.stack = new ArrayDeque<>();
/* 146 */       this.stack.addLast(bH.a((T)D.checkNotNull(param1T)));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 151 */       return !this.stack.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public T next() {
/* 156 */       Iterator iterator = this.stack.getLast();
/* 157 */       Object object = D.checkNotNull(iterator.next());
/* 158 */       if (!iterator.hasNext()) {
/* 159 */         this.stack.removeLast();
/*     */       }
/* 161 */       Iterator<T> iterator1 = this.a.a(object).iterator();
/* 162 */       if (iterator1.hasNext()) {
/* 163 */         this.stack.addLast(iterator1);
/*     */       }
/* 165 */       return (T)object;
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
/*     */   @Deprecated
/*     */   public final ap<T> b(T paramT) {
/* 181 */     D.checkNotNull(paramT);
/* 182 */     return new ap<T>(this, paramT)
/*     */       {
/*     */         public dj<T> b() {
/* 185 */           return this.a.c((T)this.Z);
/*     */         }
/*     */ 
/*     */         
/*     */         public void forEach(Consumer<? super T> param1Consumer) {
/* 190 */           D.checkNotNull(param1Consumer);
/* 191 */           (new Consumer<T>(this, param1Consumer)
/*     */             {
/*     */               public void accept(T param2T) {
/* 194 */                 this.a.a.a(param2T).forEach(this);
/* 195 */                 this.a.accept(param2T);
/*     */               }
/* 197 */             }).accept((T)this.Z);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   dj<T> c(T paramT) {
/* 203 */     return new b(this, paramT);
/*     */   }
/*     */   
/*     */   private static final class c<T> {
/*     */     final T root;
/*     */     final Iterator<T> I;
/*     */     
/*     */     c(T param1T, Iterator<T> param1Iterator) {
/* 211 */       this.root = (T)D.checkNotNull(param1T);
/* 212 */       this.I = (Iterator<T>)D.checkNotNull(param1Iterator);
/*     */     }
/*     */   }
/*     */   
/*     */   private final class b extends c<T> {
/*     */     private final ArrayDeque<di.c<T>> a;
/*     */     
/*     */     b(di this$0, T param1T) {
/* 220 */       this.a = (di)new ArrayDeque();
/* 221 */       this.a.addLast(a(param1T));
/*     */     }
/*     */ 
/*     */     
/*     */     protected T b() {
/* 226 */       while (!this.a.isEmpty()) {
/* 227 */         di.c c1 = this.a.getLast();
/* 228 */         if (c1.I.hasNext()) {
/* 229 */           T t = (T)c1.I.next();
/* 230 */           this.a.addLast(a(t)); continue;
/*     */         } 
/* 232 */         this.a.removeLast();
/* 233 */         return c1.root;
/*     */       } 
/*     */       
/* 236 */       return c();
/*     */     }
/*     */     
/*     */     private di.c<T> a(T param1T) {
/* 240 */       return new di.c<>(param1T, this.a.a(param1T).iterator());
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
/*     */   @Deprecated
/*     */   public final ap<T> c(T paramT) {
/* 256 */     D.checkNotNull(paramT);
/* 257 */     return new ap<T>(this, paramT)
/*     */       {
/*     */         public dj<T> b() {
/* 260 */           return new di.a(this.a, (T)this.Z);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends dj<T> implements ck<T> {
/*     */     private final Queue<T> f;
/*     */     
/*     */     a(di this$0, T param1T) {
/* 270 */       this.f = new ArrayDeque<>();
/* 271 */       this.f.add(param1T);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 276 */       return !this.f.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public T peek() {
/* 281 */       return this.f.element();
/*     */     }
/*     */ 
/*     */     
/*     */     public T next() {
/* 286 */       T t = this.f.remove();
/* 287 */       bG.addAll(this.f, this.a.a(t));
/* 288 */       return t;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\di.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */