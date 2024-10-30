/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.I;
/*     */ import com.google.a.b.z;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.cW;
/*     */ import com.google.b.a.l;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.io.Writer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public abstract class k
/*     */ {
/*     */   @com.google.a.a.a
/*     */   public g a(Charset paramCharset) {
/*  90 */     return new a(this, paramCharset);
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
/*     */   
/*     */   public BufferedReader a() throws IOException {
/* 112 */     Reader reader = a();
/* 113 */     return (reader instanceof BufferedReader) ? 
/* 114 */       (BufferedReader)reader : 
/* 115 */       new BufferedReader(reader);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   @l
/*     */   public Stream<String> a() throws IOException {
/* 147 */     BufferedReader bufferedReader = a();
/* 148 */     return bufferedReader
/* 149 */       .lines()
/* 150 */       .onClose(() -> {
/*     */           
/*     */           try {
/*     */             paramBufferedReader.close();
/* 154 */           } catch (IOException iOException) {
/*     */             throw new UncheckedIOException(iOException);
/*     */           } 
/*     */         });
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
/*     */   @com.google.a.a.a
/*     */   public z<Long> f() {
/* 176 */     return z.b();
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
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public long length() throws IOException {
/* 200 */     z<Long> z = f();
/* 201 */     if (z.cm()) {
/* 202 */       return ((Long)z.get()).longValue();
/*     */     }
/*     */     
/* 205 */     n n = n.a();
/*     */     try {
/* 207 */       Reader reader = n.<Reader>a(a());
/* 208 */       return a(reader);
/* 209 */     } catch (Throwable throwable) {
/* 210 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 212 */       n.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private long a(Reader paramReader) throws IOException {
/* 217 */     long l1 = 0L;
/*     */     long l2;
/* 219 */     while ((l2 = paramReader.skip(Long.MAX_VALUE)) != 0L) {
/* 220 */       l1 += l2;
/*     */     }
/* 222 */     return l1;
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
/*     */   @com.google.b.a.a
/*     */   public long a(Appendable paramAppendable) throws IOException {
/* 235 */     D.checkNotNull(paramAppendable);
/*     */     
/* 237 */     n n = n.a();
/*     */     try {
/* 239 */       Reader reader = n.<Reader>a(a());
/* 240 */       return l.a(reader, paramAppendable);
/* 241 */     } catch (Throwable throwable) {
/* 242 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 244 */       n.close();
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
/*     */   @com.google.b.a.a
/*     */   public long a(j paramj) throws IOException {
/* 257 */     D.checkNotNull(paramj);
/*     */     
/* 259 */     n n = n.a();
/*     */     try {
/* 261 */       Reader reader = n.<Reader>a(a());
/* 262 */       Writer writer = n.<Writer>a(paramj.a());
/* 263 */       return l.a(reader, writer);
/* 264 */     } catch (Throwable throwable) {
/* 265 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 267 */       n.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dm() throws IOException {
/* 277 */     n n = n.a();
/*     */     try {
/* 279 */       Reader reader = n.<Reader>a(a());
/* 280 */       return l.a(reader);
/* 281 */     } catch (Throwable throwable) {
/* 282 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 284 */       n.close();
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
/*     */   public String dn() throws IOException {
/* 299 */     n n = n.a();
/*     */     try {
/* 301 */       BufferedReader bufferedReader = n.<BufferedReader>a(a());
/* 302 */       return bufferedReader.readLine();
/* 303 */     } catch (Throwable throwable) {
/* 304 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 306 */       n.close();
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
/*     */   public bh<String> j() throws IOException {
/* 322 */     n n = n.a();
/*     */     try {
/* 324 */       BufferedReader bufferedReader = n.<BufferedReader>a(a());
/* 325 */       ArrayList<String> arrayList = bS.a();
/*     */       String str;
/* 327 */       while ((str = bufferedReader.readLine()) != null) {
/* 328 */         arrayList.add(str);
/*     */       }
/* 330 */       return bh.a(arrayList);
/* 331 */     } catch (Throwable throwable) {
/* 332 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 334 */       n.close();
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
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public <T> T a(x<T> paramx) throws IOException {
/* 355 */     D.checkNotNull(paramx);
/*     */     
/* 357 */     n n = n.a();
/*     */     try {
/* 359 */       Reader reader = n.<Reader>a(a());
/* 360 */       return (T)l.a(reader, (x)paramx);
/* 361 */     } catch (Throwable throwable) {
/* 362 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 364 */       n.close();
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
/*     */   @com.google.a.a.a
/*     */   public void b(Consumer<? super String> paramConsumer) throws IOException {
/*     */     
/* 383 */     try { Stream<String> stream = a();
/*     */       
/* 385 */       try { stream.forEachOrdered(paramConsumer);
/* 386 */         if (stream != null) stream.close();  } catch (Throwable throwable) { if (stream != null) try { stream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (UncheckedIOException uncheckedIOException)
/* 387 */     { throw uncheckedIOException.getCause(); }
/*     */   
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
/*     */   public boolean isEmpty() throws IOException {
/* 404 */     z<Long> z = f();
/* 405 */     if (z.cm()) {
/* 406 */       return (((Long)z.get()).longValue() == 0L);
/*     */     }
/* 408 */     n n = n.a();
/*     */     try {
/* 410 */       Reader reader = n.<Reader>a(a());
/* 411 */       return (reader.read() == -1);
/* 412 */     } catch (Throwable throwable) {
/* 413 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 415 */       n.close();
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
/*     */   public static k a(Iterable<? extends k> paramIterable) {
/* 431 */     return new c(paramIterable);
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
/*     */   
/*     */   public static k a(Iterator<? extends k> paramIterator) {
/* 453 */     return a((Iterable<? extends k>)bh.a(paramIterator));
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
/*     */   public static k a(k... paramVarArgs) {
/* 469 */     return a((Iterable<? extends k>)bh.a((Object[])paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static k a(CharSequence paramCharSequence) {
/* 480 */     return (paramCharSequence instanceof String) ? 
/* 481 */       new e((String)paramCharSequence) : 
/* 482 */       new b(paramCharSequence);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static k a() {
/* 491 */     return d.a();
/*     */   }
/*     */   
/*     */   public abstract Reader a() throws IOException;
/*     */   
/*     */   private final class a extends g {
/*     */     final Charset charset;
/*     */     
/*     */     a(k this$0, Charset param1Charset) {
/* 500 */       this.charset = (Charset)D.checkNotNull(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public k a(Charset param1Charset) {
/* 505 */       if (param1Charset.equals(this.charset)) {
/* 506 */         return this.b;
/*     */       }
/* 508 */       return super.a(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream a() throws IOException {
/* 513 */       return new F(this.b.a(), this.charset, 8192);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 518 */       String str1 = this.b.toString(), str2 = String.valueOf(this.charset); return (new StringBuilder(15 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".asByteSource(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b
/*     */     extends k {
/* 524 */     private static final I f = I.b("\r\n|\n|\r");
/*     */     
/*     */     protected final CharSequence c;
/*     */     
/*     */     protected b(CharSequence param1CharSequence) {
/* 529 */       this.c = (CharSequence)D.checkNotNull(param1CharSequence);
/*     */     }
/*     */ 
/*     */     
/*     */     public Reader a() {
/* 534 */       return new i(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public String dm() {
/* 539 */       return this.c.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 544 */       return (this.c.length() == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public long length() {
/* 549 */       return this.c.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> f() {
/* 554 */       return z.a(Long.valueOf(this.c.length()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Iterator<String> n() {
/* 562 */       return (Iterator<String>)new com.google.a.d.c<String>(this) {
/* 563 */           Iterator<String> P = k.b.c().a(this.a.c).iterator();
/*     */ 
/*     */           
/*     */           protected String dh() {
/* 567 */             if (this.P.hasNext()) {
/* 568 */               String str = this.P.next();
/*     */               
/* 570 */               if (this.P.hasNext() || !str.isEmpty()) {
/* 571 */                 return str;
/*     */               }
/*     */             } 
/* 574 */             return (String)c();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public Stream<String> a() {
/* 581 */       return cW.a(n());
/*     */     }
/*     */ 
/*     */     
/*     */     public String dn() {
/* 586 */       Iterator<String> iterator = n();
/* 587 */       return iterator.hasNext() ? iterator.next() : null;
/*     */     }
/*     */ 
/*     */     
/*     */     public bh<String> j() {
/* 592 */       return bh.a(n());
/*     */     }
/*     */ 
/*     */     
/*     */     public <T> T a(x<T> param1x) throws IOException {
/* 597 */       Iterator<String> iterator = n(); do {  }
/* 598 */       while (iterator.hasNext() && 
/* 599 */         param1x.t(iterator.next()));
/*     */ 
/*     */ 
/*     */       
/* 603 */       return param1x.getResult();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 608 */       String str = com.google.a.b.c.a(this.c, 30, "..."); return (new StringBuilder(17 + String.valueOf(str).length())).append("CharSource.wrap(").append(str).append(")").toString();
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
/*     */   
/*     */   private static class e
/*     */     extends b
/*     */   {
/*     */     protected e(String param1String) {
/* 629 */       super(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public Reader a() {
/* 634 */       return new StringReader((String)this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public long a(Appendable param1Appendable) throws IOException {
/* 639 */       param1Appendable.append(this.c);
/* 640 */       return this.c.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public long a(j param1j) throws IOException {
/* 645 */       D.checkNotNull(param1j);
/* 646 */       n n = n.a();
/*     */       try {
/* 648 */         Writer writer = n.<Writer>a(param1j.a());
/* 649 */         writer.write((String)this.c);
/* 650 */         return this.c.length();
/* 651 */       } catch (Throwable throwable) {
/* 652 */         throw n.rethrow(throwable);
/*     */       } finally {
/* 654 */         n.close();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class d
/*     */     extends e {
/* 661 */     private static final d a = new d();
/*     */     
/*     */     private d() {
/* 664 */       super("");
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 669 */       return "CharSource.empty()";
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class c
/*     */     extends k {
/*     */     private final Iterable<? extends k> g;
/*     */     
/*     */     c(Iterable<? extends k> param1Iterable) {
/* 678 */       this.g = (Iterable<? extends k>)D.checkNotNull(param1Iterable);
/*     */     }
/*     */ 
/*     */     
/*     */     public Reader a() throws IOException {
/* 683 */       return new D(this.g.iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() throws IOException {
/* 688 */       for (k k1 : this.g) {
/* 689 */         if (!k1.isEmpty()) {
/* 690 */           return false;
/*     */         }
/*     */       } 
/* 693 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> f() {
/* 698 */       long l = 0L;
/* 699 */       for (k k1 : this.g) {
/* 700 */         z<Long> z = k1.f();
/* 701 */         if (!z.cm()) {
/* 702 */           return z.b();
/*     */         }
/* 704 */         l += ((Long)z.get()).longValue();
/*     */       } 
/* 706 */       return z.a(Long.valueOf(l));
/*     */     }
/*     */ 
/*     */     
/*     */     public long length() throws IOException {
/* 711 */       long l = 0L;
/* 712 */       for (k k1 : this.g) {
/* 713 */         l += k1.length();
/*     */       }
/* 715 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 720 */       String str = String.valueOf(this.g); return (new StringBuilder(19 + String.valueOf(str).length())).append("CharSource.concat(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */