/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.b.a.j;
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
/*     */ @j(a = {"N"})
/*     */ @a
/*     */ public abstract class n<N>
/*     */   implements Iterable<N>
/*     */ {
/*     */   private final N al;
/*     */   private final N am;
/*     */   
/*     */   private n(N paramN1, N paramN2) {
/*  47 */     this.al = (N)D.checkNotNull(paramN1);
/*  48 */     this.am = (N)D.checkNotNull(paramN2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <N> n<N> a(N paramN1, N paramN2) {
/*  53 */     return new a<>(paramN1, paramN2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <N> n<N> b(N paramN1, N paramN2) {
/*  59 */     return new b<>(paramN2, paramN1);
/*     */   }
/*     */ 
/*     */   
/*     */   static <N> n<N> a(s<?> params, N paramN1, N paramN2) {
/*  64 */     return params.cX() ? a(paramN1, paramN2) : b(paramN1, paramN2);
/*     */   }
/*     */ 
/*     */   
/*     */   static <N> n<N> a(H<?, ?> paramH, N paramN1, N paramN2) {
/*  69 */     return paramH.cX() ? a(paramN1, paramN2) : b(paramN1, paramN2);
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
/*     */   public final N D() {
/*  91 */     return this.al;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final N E() {
/*  99 */     return this.am;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final N A(Object paramObject) {
/* 108 */     if (paramObject.equals(this.al))
/* 109 */       return this.am; 
/* 110 */     if (paramObject.equals(this.am)) {
/* 111 */       return this.al;
/*     */     }
/* 113 */     String str1 = String.valueOf(this), str2 = String.valueOf(paramObject); throw new IllegalArgumentException((new StringBuilder(36 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("EndpointPair ").append(str1).append(" does not contain node ").append(str2).toString());
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
/*     */   public final dj<N> b() {
/* 126 */     return bH.a(new Object[] { this.al, this.am });
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract N B();
/*     */ 
/*     */   
/*     */   public abstract N C();
/*     */ 
/*     */   
/*     */   public abstract boolean cZ();
/*     */ 
/*     */   
/*     */   public abstract boolean equals(Object paramObject);
/*     */   
/*     */   public abstract int hashCode();
/*     */   
/*     */   private static final class a<N>
/*     */     extends n<N>
/*     */   {
/*     */     private a(N param1N1, N param1N2) {
/* 147 */       super(param1N1, param1N2);
/*     */     }
/*     */ 
/*     */     
/*     */     public N B() {
/* 152 */       return D();
/*     */     }
/*     */ 
/*     */     
/*     */     public N C() {
/* 157 */       return E();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean cZ() {
/* 162 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 167 */       if (param1Object == this) {
/* 168 */         return true;
/*     */       }
/* 170 */       if (!(param1Object instanceof n)) {
/* 171 */         return false;
/*     */       }
/*     */       
/* 174 */       n n1 = (n)param1Object;
/* 175 */       if (cZ() != n1.cZ()) {
/* 176 */         return false;
/*     */       }
/*     */       
/* 179 */       return (B().equals(n1.B()) && C().equals(n1.C()));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 184 */       return y.a(new Object[] { B(), C() });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 189 */       String str1 = String.valueOf(B()), str2 = String.valueOf(C()); return (new StringBuilder(6 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("<").append(str1).append(" -> ").append(str2).append(">").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b<N> extends n<N> {
/*     */     private b(N param1N1, N param1N2) {
/* 195 */       super(param1N1, param1N2);
/*     */     }
/*     */ 
/*     */     
/*     */     public N B() {
/* 200 */       throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
/*     */     }
/*     */ 
/*     */     
/*     */     public N C() {
/* 205 */       throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean cZ() {
/* 210 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 215 */       if (param1Object == this) {
/* 216 */         return true;
/*     */       }
/* 218 */       if (!(param1Object instanceof n)) {
/* 219 */         return false;
/*     */       }
/*     */       
/* 222 */       n n1 = (n)param1Object;
/* 223 */       if (cZ() != n1.cZ()) {
/* 224 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 231 */       if (D().equals(n1.D()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 237 */         return E().equals(n1.E());
/*     */       }
/* 239 */       return (D().equals(n1.E()) && E().equals(n1.D()));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 244 */       return D().hashCode() + E().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 249 */       String str1 = String.valueOf(D()), str2 = String.valueOf(E()); return (new StringBuilder(4 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("[").append(str1).append(", ").append(str2).append("]").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */