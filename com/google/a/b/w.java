/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.io.IOException;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
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
/*     */ @b
/*     */ public class w
/*     */ {
/*     */   private final String separator;
/*     */   
/*     */   public static w a(String paramString) {
/*  69 */     return new w(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static w a(char paramChar) {
/*  74 */     return new w(String.valueOf(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private w(String paramString) {
/*  80 */     this.separator = D.<String>checkNotNull(paramString);
/*     */   }
/*     */   
/*     */   private w(w paramw) {
/*  84 */     this.separator = paramw.separator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <A extends Appendable> A a(A paramA, Iterable<?> paramIterable) throws IOException {
/*  93 */     return a(paramA, paramIterable.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <A extends Appendable> A a(A paramA, Iterator<?> paramIterator) throws IOException {
/* 104 */     D.checkNotNull(paramA);
/* 105 */     if (paramIterator.hasNext()) {
/* 106 */       paramA.append(a(paramIterator.next()));
/* 107 */       while (paramIterator.hasNext()) {
/* 108 */         paramA.append(this.separator);
/* 109 */         paramA.append(a(paramIterator.next()));
/*     */       } 
/*     */     } 
/* 112 */     return paramA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final <A extends Appendable> A a(A paramA, Object[] paramArrayOfObject) throws IOException {
/* 121 */     return a(paramA, Arrays.asList(paramArrayOfObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final <A extends Appendable> A a(A paramA, Object paramObject1, Object paramObject2, Object... paramVarArgs) throws IOException {
/* 129 */     return a(paramA, a(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder, Iterable<?> paramIterable) {
/* 139 */     return a(paramStringBuilder, paramIterable.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator) {
/*     */     try {
/* 152 */       a(paramStringBuilder, paramIterator);
/* 153 */     } catch (IOException iOException) {
/* 154 */       throw new AssertionError(iOException);
/*     */     } 
/* 156 */     return paramStringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder, Object[] paramArrayOfObject) {
/* 166 */     return a(paramStringBuilder, Arrays.asList(paramArrayOfObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder, Object paramObject1, Object paramObject2, Object... paramVarArgs) {
/* 177 */     return a(paramStringBuilder, a(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Iterable<?> paramIterable) {
/* 185 */     return a(paramIterable.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Iterator<?> paramIterator) {
/* 195 */     return a(new StringBuilder(), paramIterator).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String join(Object[] paramArrayOfObject) {
/* 203 */     return a(Arrays.asList(paramArrayOfObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(Object paramObject1, Object paramObject2, Object... paramVarArgs) {
/* 211 */     return a(a(paramObject1, paramObject2, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w b(String paramString) {
/* 219 */     D.checkNotNull(paramString);
/* 220 */     return new w(this, this, paramString)
/*     */       {
/*     */         CharSequence a(Object param1Object) {
/* 223 */           return (param1Object == null) ? this.gy : this.a.a(param1Object);
/*     */         }
/*     */ 
/*     */         
/*     */         public w b(String param1String) {
/* 228 */           throw new UnsupportedOperationException("already specified useForNull");
/*     */         }
/*     */ 
/*     */         
/*     */         public w a() {
/* 233 */           throw new UnsupportedOperationException("already specified useForNull");
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w a() {
/* 243 */     return new w(this, this)
/*     */       {
/*     */         public <A extends Appendable> A a(A param1A, Iterator<?> param1Iterator) throws IOException {
/* 246 */           D.b(param1A, "appendable");
/* 247 */           D.b(param1Iterator, "parts");
/* 248 */           while (param1Iterator.hasNext()) {
/* 249 */             Object object = param1Iterator.next();
/* 250 */             if (object != null) {
/* 251 */               param1A.append(this.a.a(object));
/*     */               break;
/*     */             } 
/*     */           } 
/* 255 */           while (param1Iterator.hasNext()) {
/* 256 */             Object object = param1Iterator.next();
/* 257 */             if (object != null) {
/* 258 */               param1A.append(w.a(this.a));
/* 259 */               param1A.append(this.a.a(object));
/*     */             } 
/*     */           } 
/* 262 */           return param1A;
/*     */         }
/*     */ 
/*     */         
/*     */         public w b(String param1String) {
/* 267 */           throw new UnsupportedOperationException("already specified skipNulls");
/*     */         }
/*     */ 
/*     */         
/*     */         public w.a a(String param1String) {
/* 272 */           throw new UnsupportedOperationException("can't use .skipNulls() with maps");
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
/*     */   public a a(char paramChar) {
/* 284 */     return a(String.valueOf(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a a(String paramString) {
/* 292 */     return new a(this, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     private final w b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final String gz;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(w param1w, String param1String) {
/* 318 */       this.b = param1w;
/* 319 */       this.gz = D.<String>checkNotNull(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public <A extends Appendable> A a(A param1A, Map<?, ?> param1Map) throws IOException {
/* 328 */       return a(param1A, param1Map.entrySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public StringBuilder a(StringBuilder param1StringBuilder, Map<?, ?> param1Map) {
/* 338 */       return a(param1StringBuilder, param1Map.entrySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     @com.google.b.a.a
/*     */     public <A extends Appendable> A a(A param1A, Iterable<? extends Map.Entry<?, ?>> param1Iterable) throws IOException {
/* 351 */       return a(param1A, param1Iterable.iterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     @com.google.b.a.a
/*     */     public <A extends Appendable> A a(A param1A, Iterator<? extends Map.Entry<?, ?>> param1Iterator) throws IOException {
/* 364 */       D.checkNotNull(param1A);
/* 365 */       if (param1Iterator.hasNext()) {
/* 366 */         Map.Entry entry = param1Iterator.next();
/* 367 */         param1A.append(this.b.a(entry.getKey()));
/* 368 */         param1A.append(this.gz);
/* 369 */         param1A.append(this.b.a(entry.getValue()));
/* 370 */         while (param1Iterator.hasNext()) {
/* 371 */           param1A.append(w.a(this.b));
/* 372 */           Map.Entry entry1 = param1Iterator.next();
/* 373 */           param1A.append(this.b.a(entry1.getKey()));
/* 374 */           param1A.append(this.gz);
/* 375 */           param1A.append(this.b.a(entry1.getValue()));
/*     */         } 
/*     */       } 
/* 378 */       return param1A;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     @com.google.b.a.a
/*     */     public StringBuilder a(StringBuilder param1StringBuilder, Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
/* 391 */       return a(param1StringBuilder, param1Iterable.iterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     @com.google.b.a.a
/*     */     public StringBuilder a(StringBuilder param1StringBuilder, Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
/*     */       try {
/* 405 */         a(param1StringBuilder, param1Iterator);
/* 406 */       } catch (IOException iOException) {
/* 407 */         throw new AssertionError(iOException);
/*     */       } 
/* 409 */       return param1StringBuilder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String c(Map<?, ?> param1Map) {
/* 417 */       return a(param1Map.entrySet());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     public String a(Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
/* 428 */       return a(param1Iterable.iterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.a
/*     */     public String a(Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
/* 439 */       return a(new StringBuilder(), param1Iterator).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a b(String param1String) {
/* 447 */       return new a(this.b.b(param1String), this.gz);
/*     */     }
/*     */   }
/*     */   
/*     */   CharSequence a(Object paramObject) {
/* 452 */     D.checkNotNull(paramObject);
/* 453 */     return (paramObject instanceof CharSequence) ? (CharSequence)paramObject : paramObject.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static Iterable<Object> a(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject) {
/* 458 */     D.checkNotNull(paramArrayOfObject);
/* 459 */     return new AbstractList(paramArrayOfObject, paramObject1, paramObject2)
/*     */       {
/*     */         public int size() {
/* 462 */           return this.b.length + 2;
/*     */         }
/*     */ 
/*     */         
/*     */         public Object get(int param1Int) {
/* 467 */           switch (param1Int) {
/*     */             case 0:
/* 469 */               return this.k;
/*     */             case 1:
/* 471 */               return this.l;
/*     */           } 
/* 473 */           return this.b[param1Int - 2];
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */