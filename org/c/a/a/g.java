/*     */ package org.c.a.a;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */   implements Comparable<g>
/*     */ {
/*  32 */   public static final g a = new g(null, "<< Empty Schema >>");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   public static final g b = new g(BigInteger.valueOf(-1L), "<< Latest Version >>");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public static final g c = new g(BigInteger.valueOf(-2L), "<< Current Version >>");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   private static Pattern d = Pattern.compile("\\.(?=\\d)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final List<BigInteger> ah;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String jL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g a(String paramString) {
/*  68 */     if ("current".equalsIgnoreCase(paramString)) return c; 
/*  69 */     if (b.getVersion().equals(paramString)) return b; 
/*  70 */     if (paramString == null) return a; 
/*  71 */     return new g(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g(String paramString) {
/*  81 */     String str = paramString.replace('_', '.');
/*  82 */     this.ah = f(str);
/*  83 */     this.jL = str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g(BigInteger paramBigInteger, String paramString) {
/*  94 */     this.ah = new ArrayList<>();
/*  95 */     this.ah.add(paramBigInteger);
/*  96 */     this.jL = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 104 */     return this.jL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 111 */     if (equals(a)) return null; 
/* 112 */     if (equals(b)) return Long.toString(Long.MAX_VALUE); 
/* 113 */     return this.jL;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 118 */     if (this == paramObject) return true; 
/* 119 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 121 */     g g1 = (g)paramObject;
/*     */     
/* 123 */     return (a(g1) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 128 */     return (this.ah == null) ? 0 : this.ah.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean H(String paramString) {
/* 138 */     return (a(a(paramString)) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean I(String paramString) {
/* 148 */     return (a(a(paramString)) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean J(String paramString) {
/* 158 */     return (b().compareTo(a(paramString).b()) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger b() {
/* 165 */     return this.ah.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String et() {
/* 172 */     return ((BigInteger)this.ah.get(0)).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eu() {
/* 179 */     if (this.ah.size() == 1) {
/* 180 */       return "0";
/*     */     }
/* 182 */     return ((BigInteger)this.ah.get(1)).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(g paramg) {
/* 187 */     if (paramg == null) {
/* 188 */       return 1;
/*     */     }
/*     */     
/* 191 */     if (this == a) {
/* 192 */       return (paramg == a) ? 0 : Integer.MIN_VALUE;
/*     */     }
/*     */     
/* 195 */     if (this == c) {
/* 196 */       return (paramg == c) ? 0 : Integer.MIN_VALUE;
/*     */     }
/*     */     
/* 199 */     if (this == b) {
/* 200 */       return (paramg == b) ? 0 : Integer.MAX_VALUE;
/*     */     }
/*     */     
/* 203 */     if (paramg == a) {
/* 204 */       return Integer.MAX_VALUE;
/*     */     }
/*     */     
/* 207 */     if (paramg == c) {
/* 208 */       return Integer.MAX_VALUE;
/*     */     }
/*     */     
/* 211 */     if (paramg == b) {
/* 212 */       return Integer.MIN_VALUE;
/*     */     }
/* 214 */     List<BigInteger> list1 = this.ah;
/* 215 */     List<BigInteger> list2 = paramg.ah;
/* 216 */     int i = Math.max(list1.size(), list2.size());
/* 217 */     for (byte b = 0; b < i; b++) {
/* 218 */       int j = a(list1, b).compareTo(a(list2, b));
/* 219 */       if (j != 0) {
/* 220 */         return j;
/*     */       }
/*     */     } 
/* 223 */     return 0;
/*     */   }
/*     */   
/*     */   private BigInteger a(List<BigInteger> paramList, int paramInt) {
/* 227 */     return (paramInt < paramList.size()) ? paramList.get(paramInt) : BigInteger.ZERO;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<BigInteger> f(String paramString) {
/* 237 */     ArrayList<BigInteger> arrayList = new ArrayList();
/*     */     try {
/* 239 */       for (String str : d.split(paramString)) {
/* 240 */         arrayList.add(new BigInteger(str));
/*     */       }
/* 242 */     } catch (NumberFormatException numberFormatException) {
/* 243 */       throw new a("Invalid version containing non-numeric characters. Only 0..9 and . are allowed. Invalid version: " + paramString);
/*     */     } 
/*     */ 
/*     */     
/* 247 */     for (int i = arrayList.size() - 1; i > 0 && (
/* 248 */       (BigInteger)arrayList.get(i)).equals(BigInteger.ZERO); i--)
/*     */     {
/*     */       
/* 251 */       arrayList.remove(i);
/*     */     }
/* 253 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */