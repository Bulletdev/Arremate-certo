/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.nio.charset.Charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class m
/*     */ {
/*     */   public static l<byte[]> a() {
/*  36 */     return (l<byte[]>)a.a;
/*     */   }
/*     */   
/*     */   private enum a implements l<byte[]> {
/*  40 */     a;
/*     */ 
/*     */     
/*     */     public void a(byte[] param1ArrayOfbyte, D param1D) {
/*  44 */       param1D.a(param1ArrayOfbyte);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  49 */       return "Funnels.byteArrayFunnel()";
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
/*     */   public static l<CharSequence> b() {
/*  61 */     return (l<CharSequence>)g.a;
/*     */   }
/*     */   
/*     */   private enum g implements l<CharSequence> {
/*  65 */     a;
/*     */ 
/*     */     
/*     */     public void a(CharSequence param1CharSequence, D param1D) {
/*  69 */       param1D.a(param1CharSequence);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  74 */       return "Funnels.unencodedCharsFunnel()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l<CharSequence> a(Charset paramCharset) {
/*  85 */     return new f(paramCharset);
/*     */   }
/*     */   
/*     */   private static class f implements l<CharSequence>, Serializable {
/*     */     private final Charset charset;
/*     */     
/*     */     f(Charset param1Charset) {
/*  92 */       this.charset = (Charset)D.checkNotNull(param1Charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(CharSequence param1CharSequence, D param1D) {
/*  97 */       param1D.a(param1CharSequence, this.charset);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 102 */       String str = this.charset.name(); return (new StringBuilder(22 + String.valueOf(str).length())).append("Funnels.stringFunnel(").append(str).append(")").toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 107 */       if (param1Object instanceof f) {
/* 108 */         f f1 = (f)param1Object;
/* 109 */         return this.charset.equals(f1.charset);
/*     */       } 
/* 111 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 116 */       return f.class.hashCode() ^ this.charset.hashCode();
/*     */     }
/*     */     
/*     */     Object writeReplace() {
/* 120 */       return new a(this.charset);
/*     */     }
/*     */     
/*     */     private static class a implements Serializable { private final String gQ;
/*     */       private static final long serialVersionUID = 0L;
/*     */       
/*     */       a(Charset param2Charset) {
/* 127 */         this.gQ = param2Charset.name();
/*     */       }
/*     */       
/*     */       private Object readResolve() {
/* 131 */         return m.a(Charset.forName(this.gQ));
/*     */       } }
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
/*     */   public static l<Integer> c() {
/* 144 */     return (l<Integer>)b.a;
/*     */   }
/*     */   
/*     */   private enum b implements l<Integer> {
/* 148 */     a;
/*     */ 
/*     */     
/*     */     public void a(Integer param1Integer, D param1D) {
/* 152 */       param1D.a(param1Integer.intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 157 */       return "Funnels.integerFunnel()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> l<Iterable<? extends E>> a(l<E> paraml) {
/* 168 */     return new d<>(paraml);
/*     */   }
/*     */   
/*     */   private static class d<E> implements l<Iterable<? extends E>>, Serializable {
/*     */     private final l<E> b;
/*     */     
/*     */     d(l<E> param1l) {
/* 175 */       this.b = (l<E>)D.checkNotNull(param1l);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(Iterable<? extends E> param1Iterable, D param1D) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   6: astore_3
/*     */       //   7: aload_3
/*     */       //   8: invokeinterface hasNext : ()Z
/*     */       //   13: ifeq -> 39
/*     */       //   16: aload_3
/*     */       //   17: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   22: astore #4
/*     */       //   24: aload_0
/*     */       //   25: getfield b : Lcom/google/a/h/l;
/*     */       //   28: aload #4
/*     */       //   30: aload_2
/*     */       //   31: invokeinterface a : (Ljava/lang/Object;Lcom/google/a/h/D;)V
/*     */       //   36: goto -> 7
/*     */       //   39: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #180	-> 0
/*     */       //   #181	-> 24
/*     */       //   #182	-> 36
/*     */       //   #183	-> 39
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 187 */       String str = String.valueOf(this.b); return (new StringBuilder(26 + String.valueOf(str).length())).append("Funnels.sequentialFunnel(").append(str).append(")").toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 192 */       if (param1Object instanceof d) {
/* 193 */         d d1 = (d)param1Object;
/* 194 */         return this.b.equals(d1.b);
/*     */       } 
/* 196 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 201 */       return d.class.hashCode() ^ this.b.hashCode();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l<Long> d() {
/* 211 */     return (l<Long>)c.a;
/*     */   }
/*     */   
/*     */   private enum c implements l<Long> {
/* 215 */     a;
/*     */ 
/*     */     
/*     */     public void a(Long param1Long, D param1D) {
/* 219 */       param1D.a(param1Long.longValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 224 */       return "Funnels.longFunnel()";
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
/*     */   public static OutputStream a(D paramD) {
/* 239 */     return new e(paramD);
/*     */   }
/*     */   
/*     */   private static class e extends OutputStream {
/*     */     final D a;
/*     */     
/*     */     e(D param1D) {
/* 246 */       this.a = (D)D.checkNotNull(param1D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(int param1Int) {
/* 251 */       this.a.a((byte)param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte) {
/* 256 */       this.a.a(param1ArrayOfbyte);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 261 */       this.a.a(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 266 */       String str = String.valueOf(this.a); return (new StringBuilder(24 + String.valueOf(str).length())).append("Funnels.asOutputStream(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */