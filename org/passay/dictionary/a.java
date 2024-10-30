/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.CoderResult;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   extends b
/*     */ {
/*     */   public static final int je = 5;
/*     */   protected final RandomAccessFile file;
/*     */   protected int size;
/*     */   private a a;
/*     */   private final CharsetDecoder a;
/*  36 */   private final ByteBuffer c = ByteBuffer.allocate(256);
/*     */ 
/*     */   
/*  39 */   private final CharBuffer a = CharBuffer.allocate(this.c.capacity() * 4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long position;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(RandomAccessFile paramRandomAccessFile, boolean paramBoolean, CharsetDecoder paramCharsetDecoder) throws IOException {
/*  61 */     this.file = paramRandomAccessFile;
/*     */     
/*  63 */     if (paramBoolean) {
/*  64 */       this.comparator = l.m;
/*     */     } else {
/*  66 */       this.comparator = l.n;
/*     */     } 
/*  68 */     this.a = (CharBuffer)paramCharsetDecoder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String get(int paramInt) {
/*  75 */     bz(paramInt);
/*     */     try {
/*  77 */       return u(paramInt);
/*  78 */     } catch (IOException iOException) {
/*  79 */       throw new RuntimeException("Error reading from file backing word list", iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  87 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessFile a() {
/*  98 */     return this.file;
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
/*     */   public void close() throws IOException {
/* 110 */     synchronized (this.a) {
/* 111 */       this.file.close();
/*     */     } 
/* 113 */     this.a = null;
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
/*     */   protected void b(int paramInt, boolean paramBoolean) throws IOException {
/* 128 */     this.a = (CharBuffer)new a(this.file.length(), paramInt, paramBoolean);
/*     */     
/* 130 */     b b1 = null;
/* 131 */     synchronized (this.a) {
/* 132 */       this.position = 0L;
/* 133 */       seek(this.position); b b2;
/* 134 */       while ((b2 = a()) != null) {
/* 135 */         if (b1 != null && this.comparator.compare(b2.ms, b1.ms) < 0) {
/* 136 */           throw new IllegalArgumentException("File is not sorted correctly for this comparator");
/*     */         }
/* 138 */         b1 = b2;
/* 139 */         this.a.d(this.size++, b2.offset);
/*     */       } 
/* 141 */       a.a((a)this.a, true);
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
/*     */   protected String u(int paramInt) throws IOException {
/* 160 */     synchronized (this.a) {
/* 161 */       b b1; a.a a1 = this.a.a(paramInt);
/* 162 */       int i = a1.index;
/* 163 */       seek(a1.position);
/*     */       do {
/* 165 */         b1 = a();
/* 166 */       } while (i++ < paramInt && b1 != null);
/* 167 */       return (b1 != null) ? b1.ms : null;
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
/*     */   protected abstract void seek(long paramLong) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract ByteBuffer a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void fill() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b a() throws IOException {
/* 209 */     long l = this.position;
/* 210 */     this.c.clear();
/* 211 */     while (df()) {
/* 212 */       byte b1 = a().get();
/* 213 */       this.position++;
/* 214 */       if ((char)b1 == '\n' || (char)b1 == '\r') {
/*     */         
/* 216 */         if (this.c.position() == 0) {
/* 217 */           l++;
/*     */           continue;
/*     */         } 
/*     */         break;
/*     */       } 
/* 222 */       this.c.put(b1);
/*     */     } 
/* 224 */     if (this.c.position() == 0) {
/* 225 */       return null;
/*     */     }
/*     */     
/* 228 */     this.a.clear();
/* 229 */     this.c.flip();
/* 230 */     CoderResult coderResult = this.a.decode(this.c, this.a, true);
/* 231 */     if (coderResult.isError()) {
/* 232 */       coderResult.throwException();
/*     */     }
/* 234 */     return new b(this.a.flip().toString(), l);
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
/*     */   private boolean df() throws IOException {
/* 249 */     if (a().hasRemaining()) {
/* 250 */       return true;
/*     */     }
/* 252 */     fill();
/* 253 */     return a().hasRemaining();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 260 */     return 
/* 261 */       String.format("%s@%h::size=%s,cache=%s,charDecoder=%s", new Object[] {
/*     */           
/* 263 */           getClass().getName(), 
/* 264 */           Integer.valueOf(hashCode()), 
/* 265 */           Integer.valueOf(this.size), this.a, this.a
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
/*     */   protected static class b
/*     */   {
/*     */     String ms;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     long offset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     b(String param1String, long param1Long) {
/* 294 */       this.ms = param1String;
/* 295 */       this.offset = param1Long;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a
/*     */   {
/*     */     private LongBuffer a;
/*     */ 
/*     */     
/*     */     private int modulus;
/*     */ 
/*     */     
/*     */     private boolean du;
/*     */ 
/*     */     
/*     */     private boolean initialized;
/*     */ 
/*     */     
/*     */     static class a
/*     */     {
/*     */       int index;
/*     */       
/*     */       long position;
/*     */ 
/*     */       
/*     */       a(int param2Int, long param2Long) {
/* 323 */         this.index = param2Int;
/* 324 */         this.position = param2Long;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(long param1Long, int param1Int, boolean param1Boolean) {
/* 353 */       if (param1Int < 0 || param1Int > 100) {
/* 354 */         throw new IllegalArgumentException("cachePercent must be between 0 and 100 inclusive");
/*     */       }
/* 356 */       this.du = param1Boolean;
/* 357 */       long l = param1Long / 100L * param1Int;
/* 358 */       if (l > 0L) {
/* 359 */         this.modulus = (int)(param1Long / l);
/* 360 */         aa(l);
/*     */       } 
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
/*     */ 
/*     */     
/*     */     void d(int param1Int, long param1Long) {
/* 375 */       if (this.initialized) {
/* 376 */         throw new IllegalStateException("Cache initialized, put is not allowed");
/*     */       }
/* 378 */       if (this.modulus == 0 || param1Int % this.modulus > 0) {
/*     */         return;
/*     */       }
/* 381 */       if (this.a.position() == this.a.capacity()) {
/*     */         
/* 383 */         long l = this.a.capacity() * 12L;
/* 384 */         aa(l);
/*     */       } 
/* 386 */       this.a.put(param1Long);
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
/*     */ 
/*     */     
/*     */     a a(int param1Int) {
/* 400 */       if (this.modulus == 0 || param1Int < this.modulus) {
/* 401 */         return new a(0, 0L);
/*     */       }
/* 403 */       int i = param1Int / this.modulus;
/* 404 */       this.a.position(i);
/* 405 */       return new a(i * this.modulus, this.a.get());
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
/*     */ 
/*     */     
/*     */     private void aa(long param1Long) {
/* 419 */       if (param1Long > 2147483647L) {
/* 420 */         throw new IllegalArgumentException("Cache limit exceeded. Try reducing cacheSize.");
/*     */       }
/*     */       
/* 423 */       LongBuffer longBuffer = this.du ? ByteBuffer.allocateDirect((int)param1Long).asLongBuffer() : ByteBuffer.allocate((int)param1Long).asLongBuffer();
/* 424 */       if (this.a == null) {
/* 425 */         this.a = longBuffer;
/*     */       } else {
/* 427 */         this.a.rewind();
/* 428 */         longBuffer.put(this.a);
/* 429 */         this.a = longBuffer;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 437 */       return 
/* 438 */         String.format("%s@%h::size=%s,modulus=%s,allocateDirect=%s,initialized=%s", new Object[] {
/*     */             
/* 440 */             getClass().getSimpleName(), 
/* 441 */             Integer.valueOf(hashCode()), 
/* 442 */             Integer.valueOf((this.a != null) ? this.a.capacity() : 0), 
/* 443 */             Integer.valueOf(this.modulus), 
/* 444 */             Boolean.valueOf(this.du), 
/* 445 */             Boolean.valueOf(this.initialized)
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   static class a {
/*     */     int index;
/*     */     long position;
/*     */     
/*     */     a(int param1Int, long param1Long) {
/*     */       this.index = param1Int;
/*     */       this.position = param1Long;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */