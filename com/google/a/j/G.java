/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.z;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.h.D;
/*     */ import com.google.a.h.m;
/*     */ import com.google.a.h.n;
/*     */ import com.google.a.h.o;
/*     */ import com.google.a.h.p;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Reader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class g
/*     */ {
/*     */   public k a(Charset paramCharset) {
/*  79 */     return new a(this, paramCharset);
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
/*     */   public abstract InputStream a() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream b() throws IOException {
/* 105 */     InputStream inputStream = a();
/* 106 */     return (inputStream instanceof BufferedInputStream) ? 
/* 107 */       inputStream : 
/* 108 */       new BufferedInputStream(inputStream);
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
/*     */   public g a(long paramLong1, long paramLong2) {
/* 121 */     return new e(this, paramLong1, paramLong2);
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
/*     */   public boolean isEmpty() throws IOException {
/* 138 */     z<Long> z = e();
/* 139 */     if (z.cm()) {
/* 140 */       return (((Long)z.get()).longValue() == 0L);
/*     */     }
/* 142 */     n n = n.a();
/*     */     try {
/* 144 */       InputStream inputStream = n.<InputStream>a(a());
/* 145 */       return (inputStream.read() == -1);
/* 146 */     } catch (Throwable throwable) {
/* 147 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 149 */       n.close();
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
/*     */   public z<Long> e() {
/* 169 */     return z.b();
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
/*     */   public long size() throws IOException {
/* 192 */     z<Long> z = e();
/* 193 */     if (z.cm()) {
/* 194 */       return ((Long)z.get()).longValue();
/*     */     }
/*     */     
/* 197 */     n n = n.a();
/*     */     try {
/* 199 */       InputStream inputStream = n.<InputStream>a(a());
/* 200 */       return b(inputStream);
/* 201 */     } catch (IOException iOException) {
/*     */     
/*     */     } finally {
/* 204 */       n.close();
/*     */     } 
/*     */     
/* 207 */     n = n.a();
/*     */     try {
/* 209 */       InputStream inputStream = n.<InputStream>a(a());
/* 210 */       return h.c(inputStream);
/* 211 */     } catch (Throwable throwable) {
/* 212 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 214 */       n.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private long b(InputStream paramInputStream) throws IOException {
/* 220 */     long l1 = 0L;
/*     */     long l2;
/* 222 */     while ((l2 = h.a(paramInputStream, 2147483647L)) > 0L) {
/* 223 */       l1 += l2;
/*     */     }
/* 225 */     return l1;
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
/*     */   public long a(OutputStream paramOutputStream) throws IOException {
/* 238 */     D.checkNotNull(paramOutputStream);
/*     */     
/* 240 */     n n = n.a();
/*     */     try {
/* 242 */       InputStream inputStream = n.<InputStream>a(a());
/* 243 */       return h.copy(inputStream, paramOutputStream);
/* 244 */     } catch (Throwable throwable) {
/* 245 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 247 */       n.close();
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
/*     */   public long a(f paramf) throws IOException {
/* 260 */     D.checkNotNull(paramf);
/*     */     
/* 262 */     n n = n.a();
/*     */     try {
/* 264 */       InputStream inputStream = n.<InputStream>a(a());
/* 265 */       OutputStream outputStream = n.<OutputStream>a(paramf.a());
/* 266 */       return h.copy(inputStream, outputStream);
/* 267 */     } catch (Throwable throwable) {
/* 268 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 270 */       n.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] h() throws IOException {
/* 280 */     n n = n.a();
/*     */     try {
/* 282 */       InputStream inputStream = n.<InputStream>a(a());
/* 283 */       z<Long> z = e();
/* 284 */       return z.cm() ? 
/* 285 */         h.toByteArray(inputStream, ((Long)z.get()).longValue()) : 
/* 286 */         h.toByteArray(inputStream);
/* 287 */     } catch (Throwable throwable) {
/* 288 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 290 */       n.close();
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
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public <T> T a(e<T> parame) throws IOException {
/* 306 */     D.checkNotNull(parame);
/*     */     
/* 308 */     n n = n.a();
/*     */     try {
/* 310 */       InputStream inputStream = n.<InputStream>a(a());
/* 311 */       return (T)h.a(inputStream, (e)parame);
/* 312 */     } catch (Throwable throwable) {
/* 313 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 315 */       n.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public n a(o paramo) throws IOException {
/* 325 */     p p = paramo.a();
/* 326 */     a(m.a((D)p));
/* 327 */     return p.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(g paramg) throws IOException {
/* 337 */     D.checkNotNull(paramg);
/*     */     
/* 339 */     byte[] arrayOfByte1 = h.i();
/* 340 */     byte[] arrayOfByte2 = h.i();
/*     */     
/* 342 */     n n = n.a();
/*     */     try {
/* 344 */       InputStream inputStream1 = n.<InputStream>a(a());
/* 345 */       InputStream inputStream2 = n.<InputStream>a(paramg.a());
/*     */       while (true) {
/* 347 */         int i = h.read(inputStream1, arrayOfByte1, 0, arrayOfByte1.length);
/* 348 */         int j = h.read(inputStream2, arrayOfByte2, 0, arrayOfByte2.length);
/* 349 */         if (i != j || !Arrays.equals(arrayOfByte1, arrayOfByte2))
/* 350 */           return false; 
/* 351 */         if (i != arrayOfByte1.length) {
/* 352 */           return true;
/*     */         }
/*     */       } 
/* 355 */     } catch (Throwable throwable) {
/* 356 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 358 */       n.close();
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
/*     */   public static g a(Iterable<? extends g> paramIterable) {
/* 374 */     return new c(paramIterable);
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
/*     */   public static g a(Iterator<? extends g> paramIterator) {
/* 396 */     return a((Iterable<? extends g>)bh.a(paramIterator));
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
/*     */   public static g a(g... paramVarArgs) {
/* 412 */     return a((Iterable<? extends g>)bh.a((Object[])paramVarArgs));
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
/*     */   public static g a(byte[] paramArrayOfbyte) {
/* 427 */     return new b(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a() {
/* 436 */     return d.a;
/*     */   }
/*     */ 
/*     */   
/*     */   class a
/*     */     extends k
/*     */   {
/*     */     final Charset charset;
/*     */ 
/*     */     
/*     */     a(g this$0, Charset param1Charset) {
/* 447 */       this.charset = (Charset)D.checkNotNull(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public g a(Charset param1Charset) {
/* 452 */       if (param1Charset.equals(this.charset)) {
/* 453 */         return this.a;
/*     */       }
/* 455 */       return super.a(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public Reader a() throws IOException {
/* 460 */       return new InputStreamReader(this.a.a(), this.charset);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String dm() throws IOException {
/* 472 */       return new String(this.a.h(), this.charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 477 */       String str1 = this.a.toString(), str2 = String.valueOf(this.charset); return (new StringBuilder(15 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".asCharSource(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private final class e
/*     */     extends g
/*     */   {
/*     */     final long offset;
/*     */     final long length;
/*     */     
/*     */     e(g this$0, long param1Long1, long param1Long2) {
/* 488 */       D.a((param1Long1 >= 0L), "offset (%s) may not be negative", param1Long1);
/* 489 */       D.a((param1Long2 >= 0L), "length (%s) may not be negative", param1Long2);
/* 490 */       this.offset = param1Long1;
/* 491 */       this.length = param1Long2;
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream a() throws IOException {
/* 496 */       return a(this.a.a());
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream b() throws IOException {
/* 501 */       return a(this.a.b());
/*     */     }
/*     */     
/*     */     private InputStream a(InputStream param1InputStream) throws IOException {
/* 505 */       if (this.offset > 0L) {
/*     */         long l;
/*     */         try {
/* 508 */           l = h.a(param1InputStream, this.offset);
/* 509 */         } catch (Throwable throwable) {
/* 510 */           n n = n.a();
/* 511 */           n.a(param1InputStream);
/*     */           try {
/* 513 */             throw n.rethrow(throwable);
/*     */           } finally {
/* 515 */             n.close();
/*     */           } 
/*     */         } 
/*     */         
/* 519 */         if (l < this.offset) {
/*     */           
/* 521 */           param1InputStream.close();
/* 522 */           return new ByteArrayInputStream(new byte[0]);
/*     */         } 
/*     */       } 
/* 525 */       return h.a(param1InputStream, this.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public g a(long param1Long1, long param1Long2) {
/* 530 */       D.a((param1Long1 >= 0L), "offset (%s) may not be negative", param1Long1);
/* 531 */       D.a((param1Long2 >= 0L), "length (%s) may not be negative", param1Long2);
/* 532 */       long l = this.length - param1Long1;
/* 533 */       return (l <= 0L) ? 
/* 534 */         g.a() : 
/* 535 */         this.a.a(this.offset + param1Long1, Math.min(param1Long2, l));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() throws IOException {
/* 540 */       return (this.length == 0L || super.isEmpty());
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> e() {
/* 545 */       z<Long> z = this.a.e();
/* 546 */       if (z.cm()) {
/* 547 */         long l1 = ((Long)z.get()).longValue();
/* 548 */         long l2 = Math.min(this.offset, l1);
/* 549 */         return z.a(Long.valueOf(Math.min(this.length, l1 - l2)));
/*     */       } 
/* 551 */       return z.b();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 556 */       String str = this.a.toString(); long l1 = this.offset, l2 = this.length; return (new StringBuilder(50 + String.valueOf(str).length())).append(str).append(".slice(").append(l1).append(", ").append(l2).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b
/*     */     extends g {
/*     */     final byte[] bytes;
/*     */     final int offset;
/*     */     final int length;
/*     */     
/*     */     b(byte[] param1ArrayOfbyte) {
/* 567 */       this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*     */     }
/*     */ 
/*     */     
/*     */     b(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 572 */       this.bytes = param1ArrayOfbyte;
/* 573 */       this.offset = param1Int1;
/* 574 */       this.length = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream a() {
/* 579 */       return new ByteArrayInputStream(this.bytes, this.offset, this.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream b() throws IOException {
/* 584 */       return a();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 589 */       return (this.length == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public long size() {
/* 594 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> e() {
/* 599 */       return z.a(Long.valueOf(this.length));
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] h() {
/* 604 */       return Arrays.copyOfRange(this.bytes, this.offset, this.offset + this.length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> T a(e<T> param1e) throws IOException {
/* 610 */       param1e.c(this.bytes, this.offset, this.length);
/* 611 */       return param1e.getResult();
/*     */     }
/*     */ 
/*     */     
/*     */     public long a(OutputStream param1OutputStream) throws IOException {
/* 616 */       param1OutputStream.write(this.bytes, this.offset, this.length);
/* 617 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public n a(o param1o) throws IOException {
/* 622 */       return param1o.a(this.bytes, this.offset, this.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public g a(long param1Long1, long param1Long2) {
/* 627 */       D.a((param1Long1 >= 0L), "offset (%s) may not be negative", param1Long1);
/* 628 */       D.a((param1Long2 >= 0L), "length (%s) may not be negative", param1Long2);
/*     */       
/* 630 */       param1Long1 = Math.min(param1Long1, this.length);
/* 631 */       param1Long2 = Math.min(param1Long2, this.length - param1Long1);
/* 632 */       int i = this.offset + (int)param1Long1;
/* 633 */       return new b(this.bytes, i, (int)param1Long2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 639 */       String str = com.google.a.b.c.a(b.h().a(this.bytes, this.offset, this.length), 30, "..."); return (new StringBuilder(17 + String.valueOf(str).length())).append("ByteSource.wrap(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class d
/*     */     extends b
/*     */   {
/* 646 */     static final d a = new d();
/*     */     
/*     */     d() {
/* 649 */       super(new byte[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     public k a(Charset param1Charset) {
/* 654 */       D.checkNotNull(param1Charset);
/* 655 */       return k.a();
/*     */     }
/*     */ 
/*     */     
/*     */     public byte[] h() {
/* 660 */       return this.bytes;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 665 */       return "ByteSource.empty()";
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class c
/*     */     extends g {
/*     */     final Iterable<? extends g> g;
/*     */     
/*     */     c(Iterable<? extends g> param1Iterable) {
/* 674 */       this.g = (Iterable<? extends g>)D.checkNotNull(param1Iterable);
/*     */     }
/*     */ 
/*     */     
/*     */     public InputStream a() throws IOException {
/* 679 */       return new C(this.g.iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() throws IOException {
/* 684 */       for (g g1 : this.g) {
/* 685 */         if (!g1.isEmpty()) {
/* 686 */           return false;
/*     */         }
/*     */       } 
/* 689 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public z<Long> e() {
/* 694 */       if (!(this.g instanceof java.util.Collection))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 700 */         return z.b();
/*     */       }
/* 702 */       long l = 0L;
/* 703 */       for (g g1 : this.g) {
/* 704 */         z<Long> z = g1.e();
/* 705 */         if (!z.cm()) {
/* 706 */           return z.b();
/*     */         }
/* 708 */         l += ((Long)z.get()).longValue();
/* 709 */         if (l < 0L)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 715 */           return z.a(Long.valueOf(Long.MAX_VALUE));
/*     */         }
/*     */       } 
/* 718 */       return z.a(Long.valueOf(l));
/*     */     }
/*     */ 
/*     */     
/*     */     public long size() throws IOException {
/* 723 */       long l = 0L;
/* 724 */       for (g g1 : this.g) {
/* 725 */         l += g1.size();
/* 726 */         if (l < 0L)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 732 */           return Long.MAX_VALUE;
/*     */         }
/*     */       } 
/* 735 */       return l;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 740 */       String str = String.valueOf(this.g); return (new StringBuilder(19 + String.valueOf(str).length())).append("ByteSource.concat(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */