/*     */ package com.google.a.l;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.I;
/*     */ import com.google.a.b.c;
/*     */ import com.google.a.b.w;
/*     */ import com.google.a.b.z;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.b.a.j;
/*     */ import com.google.d.a.a;
/*     */ import com.google.d.a.b;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ @a
/*     */ @b(cl = true)
/*     */ public final class e
/*     */ {
/*  79 */   private static final com.google.a.b.e j = com.google.a.b.e.a(".。．｡");
/*  80 */   private static final I g = I.a('.');
/*  81 */   private static final w c = w.a('.');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int gf = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int gg = 127;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MAX_LENGTH = 253;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int gh = 63;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final bh<String> q;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int gi;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int gj;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   e(String paramString) {
/* 138 */     paramString = c.ag(j.a(paramString, '.'));
/*     */     
/* 140 */     if (paramString.endsWith(".")) {
/* 141 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */     
/* 144 */     D.a((paramString.length() <= 253), "Domain name too long: '%s':", paramString);
/* 145 */     this.name = paramString;
/*     */     
/* 147 */     this.q = bh.b(g.a(paramString));
/* 148 */     D.a((this.q.size() <= 127), "Domain has too many parts: '%s'", paramString);
/* 149 */     D.a(a((List<String>)this.q), "Not a valid domain name: '%s'", paramString);
/*     */     
/* 151 */     this.gi = a(z.b());
/* 152 */     this.gj = a(z.a(b.b));
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
/*     */   private int a(z<b> paramz) {
/* 165 */     int i = this.q.size();
/*     */     
/* 167 */     for (byte b = 0; b < i; b++) {
/* 168 */       String str = c.a((Iterable)this.q.a(b, i));
/*     */       
/* 170 */       if (a(paramz, 
/* 171 */           z.b(a.p.get(str)))) {
/* 172 */         return b;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 178 */       if (a.r.containsKey(str)) {
/* 179 */         return b + 1;
/*     */       }
/*     */       
/* 182 */       if (a(paramz, str)) {
/* 183 */         return b;
/*     */       }
/*     */     } 
/*     */     
/* 187 */     return -1;
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
/*     */   public static e a(String paramString) {
/* 210 */     return new e((String)D.checkNotNull(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(List<String> paramList) {
/* 220 */     int i = paramList.size() - 1;
/*     */ 
/*     */ 
/*     */     
/* 224 */     if (!a(paramList.get(i), true)) {
/* 225 */       return false;
/*     */     }
/*     */     
/* 228 */     for (byte b = 0; b < i; b++) {
/* 229 */       String str = paramList.get(b);
/* 230 */       if (!a(str, false)) {
/* 231 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 235 */     return true;
/*     */   }
/*     */   
/* 238 */   private static final com.google.a.b.e k = com.google.a.b.e.a("-_");
/*     */   
/* 240 */   private static final com.google.a.b.e l = com.google.a.b.e.a('0', '9');
/*     */ 
/*     */   
/* 243 */   private static final com.google.a.b.e m = com.google.a.b.e.a('a', 'z').b(com.google.a.b.e.a('A', 'Z'));
/*     */   
/* 245 */   private static final com.google.a.b.e n = l
/* 246 */     .b(m).b(k);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(String paramString, boolean paramBoolean) {
/* 261 */     if (paramString.length() < 1 || paramString.length() > 63) {
/* 262 */       return false;
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
/* 275 */     String str = com.google.a.b.e.e().d(paramString);
/*     */     
/* 277 */     if (!n.b(str)) {
/* 278 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 283 */     if (k.matches(paramString.charAt(0)) || k
/* 284 */       .matches(paramString.charAt(paramString.length() - 1))) {
/* 285 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     if (paramBoolean && l.matches(paramString.charAt(0))) {
/* 296 */       return false;
/*     */     }
/*     */     
/* 299 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bh<String> k() {
/* 308 */     return this.q;
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
/*     */   public boolean dh() {
/* 332 */     return (this.gi == 0);
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
/*     */   public boolean di() {
/* 348 */     return (this.gi != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a() {
/* 358 */     return di() ? a(this.gi) : null;
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
/*     */   public boolean dj() {
/* 374 */     return (this.gi > 0);
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
/*     */   public boolean dk() {
/* 390 */     return (this.gi == 1);
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
/*     */   public e b() {
/* 410 */     if (dk()) {
/* 411 */       return this;
/*     */     }
/* 413 */     D.b(dj(), "Not under a public suffix: %s", this.name);
/* 414 */     return a(this.gi - 1);
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
/*     */   public boolean dl() {
/* 441 */     return (this.gj == 0);
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
/*     */   public boolean dm() {
/* 456 */     return (this.gj != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e c() {
/* 466 */     return dm() ? a(this.gj) : null;
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
/*     */   public boolean dn() {
/* 478 */     return (this.gj > 0);
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
/*     */   public boolean do() {
/* 493 */     return (this.gj == 1);
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
/*     */   public e d() {
/* 512 */     if (do()) {
/* 513 */       return this;
/*     */     }
/* 515 */     D.b(dn(), "Not under a registry suffix: %s", this.name);
/* 516 */     return a(this.gj - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasParent() {
/* 521 */     return (this.q.size() > 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e e() {
/* 532 */     D.b(hasParent(), "Domain '%s' has no parent", this.name);
/* 533 */     return a(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(int paramInt) {
/* 544 */     return a(c.a((Iterable)this.q.a(paramInt, this.q.size())));
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
/*     */   public e b(String paramString) {
/* 557 */     String str1 = (String)D.checkNotNull(paramString), str2 = this.name; return a((new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".").append(str2).toString());
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
/*     */   public static boolean u(String paramString) {
/*     */     try {
/* 585 */       a(paramString);
/* 586 */       return true;
/* 587 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 588 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(z<b> paramz, String paramString) {
/* 598 */     List list = g.b(2).a(paramString);
/* 599 */     return (list.size() == 2 && 
/* 600 */       a(paramz, 
/* 601 */         z.b(a.q.get(list.get(1)))));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(z<b> paramz1, z<b> paramz2) {
/* 610 */     return paramz1.cm() ? paramz1.equals(paramz2) : paramz2.cm();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 616 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 626 */     if (paramObject == this) {
/* 627 */       return true;
/*     */     }
/*     */     
/* 630 */     if (paramObject instanceof e) {
/* 631 */       e e1 = (e)paramObject;
/* 632 */       return this.name.equals(e1.name);
/*     */     } 
/*     */     
/* 635 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 640 */     return this.name.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\l\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */