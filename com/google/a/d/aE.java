/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.function.ObjIntConsumer;
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
/*     */ @b(cl = true)
/*     */ public final class ae<E extends Enum<E>>
/*     */   extends i<E>
/*     */   implements Serializable
/*     */ {
/*     */   private transient Class<E> type;
/*     */   private transient E[] a;
/*     */   private transient int[] O;
/*     */   private transient int er;
/*     */   private transient long size;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <E extends Enum<E>> ae<E> a(Class<E> paramClass) {
/*  52 */     return new ae<>(paramClass);
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
/*     */   public static <E extends Enum<E>> ae<E> a(Iterable<E> paramIterable) {
/*  64 */     Iterator<E> iterator = paramIterable.iterator();
/*  65 */     D.a(iterator.hasNext(), "EnumMultiset constructor passed empty Iterable");
/*  66 */     ae<Enum> ae1 = new ae<>(((Enum<Enum>)iterator.next()).getDeclaringClass());
/*  67 */     bG.addAll(ae1, paramIterable);
/*  68 */     return (ae)ae1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Enum<E>> ae<E> a(Iterable<E> paramIterable, Class<E> paramClass) {
/*  78 */     ae<E> ae1 = a(paramClass);
/*  79 */     bG.addAll(ae1, paramIterable);
/*  80 */     return ae1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ae(Class<E> paramClass) {
/*  91 */     this.type = paramClass;
/*  92 */     D.checkArgument(paramClass.isEnum());
/*  93 */     this.a = paramClass.getEnumConstants();
/*  94 */     this.O = new int[this.a.length];
/*     */   }
/*     */   
/*     */   private boolean f(Object paramObject) {
/*  98 */     if (paramObject instanceof Enum) {
/*  99 */       Enum enum_ = (Enum)paramObject;
/* 100 */       int j = enum_.ordinal();
/* 101 */       return (j < this.a.length && this.a[j] == enum_);
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void k(Object paramObject) {
/* 111 */     D.checkNotNull(paramObject);
/* 112 */     if (!f(paramObject)) {
/* 113 */       String str1 = String.valueOf(this.type), str2 = String.valueOf(paramObject); throw new ClassCastException((new StringBuilder(21 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Expected an ").append(str1).append(" but got ").append(str2).toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   int ah() {
/* 119 */     return this.er;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 124 */     return k.e(this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public int b(Object paramObject) {
/* 129 */     if (!f(paramObject)) {
/* 130 */       return 0;
/*     */     }
/* 132 */     Enum enum_ = (Enum)paramObject;
/* 133 */     return this.O[enum_.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int a(E paramE, int paramInt) {
/* 140 */     k(paramE);
/* 141 */     C.b(paramInt, "occurrences");
/* 142 */     if (paramInt == 0) {
/* 143 */       return b(paramE);
/*     */     }
/* 145 */     int j = paramE.ordinal();
/* 146 */     int k = this.O[j];
/* 147 */     long l = k + paramInt;
/* 148 */     D.a((l <= 2147483647L), "too many occurrences: %s", l);
/* 149 */     this.O[j] = (int)l;
/* 150 */     if (k == 0) {
/* 151 */       this.er++;
/*     */     }
/* 153 */     this.size += paramInt;
/* 154 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int remove(Object paramObject, int paramInt) {
/* 161 */     if (!f(paramObject)) {
/* 162 */       return 0;
/*     */     }
/* 164 */     Enum enum_ = (Enum)paramObject;
/* 165 */     C.b(paramInt, "occurrences");
/* 166 */     if (paramInt == 0) {
/* 167 */       return b(paramObject);
/*     */     }
/* 169 */     int j = enum_.ordinal();
/* 170 */     int k = this.O[j];
/* 171 */     if (k == 0)
/* 172 */       return 0; 
/* 173 */     if (k <= paramInt) {
/* 174 */       this.O[j] = 0;
/* 175 */       this.er--;
/* 176 */       this.size -= k;
/*     */     } else {
/* 178 */       this.O[j] = k - paramInt;
/* 179 */       this.size -= paramInt;
/*     */     } 
/* 181 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public int b(E paramE, int paramInt) {
/* 188 */     k(paramE);
/* 189 */     C.b(paramInt, "count");
/* 190 */     int j = paramE.ordinal();
/* 191 */     int k = this.O[j];
/* 192 */     this.O[j] = paramInt;
/* 193 */     this.size += (paramInt - k);
/* 194 */     if (k == 0 && paramInt > 0) {
/* 195 */       this.er++;
/* 196 */     } else if (k > 0 && paramInt == 0) {
/* 197 */       this.er--;
/*     */     } 
/* 199 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 204 */     Arrays.fill(this.O, 0);
/* 205 */     this.size = 0L;
/* 206 */     this.er = 0;
/*     */   }
/*     */   
/*     */   abstract class a<T> implements Iterator<T> {
/* 210 */     int index = 0;
/* 211 */     int es = -1;
/*     */     a(ae this$0) {}
/*     */     
/*     */     abstract T c(int param1Int);
/*     */     
/*     */     public boolean hasNext() {
/* 217 */       for (; this.index < (ae.a(this.a)).length; this.index++) {
/* 218 */         if (ae.a(this.a)[this.index] > 0) {
/* 219 */           return true;
/*     */         }
/*     */       } 
/* 222 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public T next() {
/* 227 */       if (!hasNext()) {
/* 228 */         throw new NoSuchElementException();
/*     */       }
/* 230 */       T t = c(this.index);
/* 231 */       this.es = this.index;
/* 232 */       this.index++;
/* 233 */       return t;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 238 */       C.ad((this.es >= 0));
/* 239 */       if (ae.a(this.a)[this.es] > 0) {
/* 240 */         ae.a(this.a);
/* 241 */         ae.a(this.a, ae.a(this.a)[this.es]);
/* 242 */         ae.a(this.a)[this.es] = 0;
/*     */       } 
/* 244 */       this.es = -1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<E> e() {
/* 250 */     return new a<E>(this)
/*     */       {
/*     */         E a(int param1Int) {
/* 253 */           return (E)ae.a(this.a)[param1Int];
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<cc.a<E>> c() {
/* 260 */     return new a<cc.a<E>>(this)
/*     */       {
/*     */         cc.a<E> b(final int index) {
/* 263 */           return new cd.a<E>(this)
/*     */             {
/*     */               public E a() {
/* 266 */                 return (E)ae.a(this.a.a)[index];
/*     */               }
/*     */ 
/*     */               
/*     */               public int getCount() {
/* 271 */                 return ae.a(this.a.a)[index];
/*     */               }
/*     */             };
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ObjIntConsumer<? super E> paramObjIntConsumer) {
/* 280 */     D.checkNotNull(paramObjIntConsumer);
/* 281 */     for (byte b = 0; b < this.a.length; b++) {
/* 282 */       if (this.O[b] > 0) {
/* 283 */         paramObjIntConsumer.accept(this.a[b], this.O[b]);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 290 */     return cd.a(this);
/*     */   }
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 295 */     paramObjectOutputStream.defaultWriteObject();
/* 296 */     paramObjectOutputStream.writeObject(this.type);
/* 297 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 306 */     paramObjectInputStream.defaultReadObject();
/*     */     
/* 308 */     Class<E> clazz = (Class)paramObjectInputStream.readObject();
/* 309 */     this.type = clazz;
/* 310 */     this.a = this.type.getEnumConstants();
/* 311 */     this.O = new int[this.a.length];
/* 312 */     cE.a(this, paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ae.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */