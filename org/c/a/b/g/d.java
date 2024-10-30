/*     */ package org.c.a.b.g;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.e;
/*     */ import org.c.a.a.f;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.b.p.a;
/*     */ import org.c.a.b.r.a;
/*     */ import org.c.a.b.r.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   implements c
/*     */ {
/*     */   private final org.c.a.a.h.d a;
/*     */   private final a a;
/*     */   private final b a;
/*     */   private final boolean cs;
/*     */   
/*     */   d(org.c.a.a.h.d paramd, a parama, b paramb, boolean paramBoolean) {
/*  78 */     this.a = (b)paramd;
/*  79 */     this.a = (b)parama;
/*  80 */     this.a = paramb;
/*  81 */     this.cs = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public org.c.a.a.h.d a() {
/*  91 */     return (org.c.a.a.h.d)this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a a() {
/*  98 */     return (a)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 103 */     if (this.a != null) {
/* 104 */       return this.a.a();
/*     */     }
/* 106 */     return this.a.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer d() {
/* 111 */     if (this.a != null) {
/* 112 */       return this.a.d();
/*     */     }
/* 114 */     return this.a.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public g c() {
/* 119 */     if (this.a != null) {
/* 120 */       return this.a.c();
/*     */     }
/* 122 */     return this.a.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/* 127 */     if (this.a != null) {
/* 128 */       return this.a.getDescription();
/*     */     }
/* 130 */     return this.a.getDescription();
/*     */   }
/*     */ 
/*     */   
/*     */   public String es() {
/* 135 */     if (this.a != null) {
/* 136 */       return this.a.es();
/*     */     }
/* 138 */     return this.a.es();
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 143 */     if (this.a == null) {
/* 144 */       if (this.a.c() != null) {
/* 145 */         if (this.a.c().a(this.a.h) < 0) {
/* 146 */           return e.c;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 153 */         if (this.a.d != null && this.a.c().a(this.a.d) > 0) {
/* 154 */           return e.b;
/*     */         }
/* 156 */         if (this.a.c().a(this.a.j) < 0 && !this.a.cs) {
/* 157 */           return e.e;
/*     */         }
/*     */       } 
/* 160 */       return e.a;
/*     */     } 
/*     */     
/* 163 */     if (f.b == this.a.a()) {
/* 164 */       return e.d;
/*     */     }
/*     */     
/* 167 */     if (this.a == null) {
/* 168 */       if (f.a == this.a.a()) {
/* 169 */         return e.h;
/*     */       }
/*     */       
/* 172 */       if (this.a.c() == null || c().a(this.a.i) < 0) {
/* 173 */         if (this.a.g()) {
/* 174 */           return e.f;
/*     */         }
/* 176 */         return e.g;
/*     */       } 
/* 178 */       if (this.a.g()) {
/* 179 */         return e.m;
/*     */       }
/* 181 */       return e.n;
/*     */     } 
/*     */ 
/*     */     
/* 185 */     if (!this.a.g()) {
/* 186 */       return e.k;
/*     */     }
/*     */     
/* 189 */     if (this.a.c() == null) {
/* 190 */       if (this.a.bQ() == ((Integer)this.a.ar.get(this.a.getDescription())).intValue()) {
/* 191 */         if (k.j(this.a.d(), this.a.d())) {
/* 192 */           return e.h;
/*     */         }
/* 194 */         return e.o;
/*     */       } 
/* 196 */       return e.p;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     if (this.cs) {
/* 205 */       return e.l;
/*     */     }
/* 207 */     return e.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public Date d() {
/* 212 */     if (this.a != null) {
/* 213 */       return this.a.d();
/*     */     }
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String eo() {
/* 220 */     if (this.a != null) {
/* 221 */       return this.a.eo();
/*     */     }
/* 223 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer e() {
/* 228 */     if (this.a != null) {
/* 229 */       return Integer.valueOf(this.a.bQ());
/*     */     }
/* 231 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer f() {
/* 236 */     if (this.a != null) {
/* 237 */       return Integer.valueOf(this.a.bR());
/*     */     }
/* 239 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String ex() {
/* 248 */     e e = a();
/*     */ 
/*     */     
/* 251 */     if (e.b.equals(e)) {
/* 252 */       return null;
/*     */     }
/*     */     
/* 255 */     if (e.fr() && (!this.a.cO || e.n != e)) {
/* 256 */       if (c() == null) {
/* 257 */         return "Detected failed repeatable migration: " + getDescription();
/*     */       }
/* 259 */       return "Detected failed migration to version " + c() + " (" + getDescription() + ")";
/*     */     } 
/*     */     
/* 262 */     if (this.a == null && this.a
/* 263 */       .a() != f.a && this.a
/* 264 */       .a() != f.b && this.a
/* 265 */       .c() != null && (!this.a.cM || (e.f != e && e.g != e)) && (!this.a.cO || (e.m != e && e.n != e)))
/*     */     {
/*     */       
/* 268 */       return "Detected applied migration not resolved locally: " + c();
/*     */     }
/*     */     
/* 271 */     if ((!this.a.cz && e.a == e) || (!this.a.cN && e.e == e)) {
/* 272 */       if (c() != null) {
/* 273 */         return "Detected resolved migration not applied to database: " + c();
/*     */       }
/* 275 */       return "Detected resolved repeatable migration not applied to database: " + getDescription();
/*     */     } 
/*     */     
/* 278 */     if (!this.a.cz && e.o == e) {
/* 279 */       return "Detected outdated resolved repeatable migration that should be re-applied to database: " + getDescription();
/*     */     }
/*     */     
/* 282 */     if (this.a != null && this.a != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 287 */       String str = (this.a.c() == null) ? this.a.es() : ("version " + this.a.c());
/* 288 */       if (c() == null || c().a(this.a.h) > 0) {
/* 289 */         if (this.a.a() != this.a.a()) {
/* 290 */           return a("type", str, this.a
/* 291 */               .a(), this.a.a());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 296 */         if (this.a.c() != null || (this.a.cz && e.o != e && e.p != e))
/*     */         {
/* 298 */           if (!k.j(this.a.d(), this.a.d())) {
/* 299 */             return a("checksum", str, this.a
/* 300 */                 .d(), this.a.d());
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 307 */         if (!a.be(this.a.getDescription()).equals(this.a.getDescription())) {
/* 308 */           return a("description", str, this.a
/* 309 */               .getDescription(), this.a.getDescription());
/*     */         }
/*     */       } 
/*     */     } 
/* 313 */     return null;
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
/*     */   private String a(String paramString1, String paramString2, Object paramObject1, Object paramObject2) {
/* 326 */     return String.format("Migration " + paramString1 + " mismatch for migration %s\n-> Applied to database : %s\n-> Resolved locally    : %s", new Object[] { paramString2, paramObject1, paramObject2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(c paramc) {
/* 334 */     if (e() != null && paramc.e() != null) {
/* 335 */       return e().intValue() - paramc.e().intValue();
/*     */     }
/*     */     
/* 338 */     e e1 = a();
/* 339 */     e e2 = paramc.a();
/*     */ 
/*     */     
/* 342 */     if (e1 == e.c && e2.fq()) {
/* 343 */       return Integer.MIN_VALUE;
/*     */     }
/* 345 */     if (e1.fq() && e2 == e.c) {
/* 346 */       return Integer.MAX_VALUE;
/*     */     }
/*     */     
/* 349 */     if (e1 == e.e && e2.fq()) {
/* 350 */       if (c() != null && paramc.c() != null) {
/* 351 */         return c().a(paramc.c());
/*     */       }
/* 353 */       return Integer.MIN_VALUE;
/*     */     } 
/* 355 */     if (e1.fq() && e2 == e.e) {
/* 356 */       if (c() != null && paramc.c() != null) {
/* 357 */         return c().a(paramc.c());
/*     */       }
/* 359 */       return Integer.MAX_VALUE;
/*     */     } 
/*     */ 
/*     */     
/* 363 */     if (e() != null) {
/* 364 */       return Integer.MIN_VALUE;
/*     */     }
/* 366 */     if (paramc.e() != null) {
/* 367 */       return Integer.MAX_VALUE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 372 */     if (c() != null && paramc.c() != null) {
/* 373 */       int i = c().a(paramc.c());
/* 374 */       if (i != 0) {
/* 375 */         return i;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 388 */       return 0;
/*     */     } 
/*     */ 
/*     */     
/* 392 */     if (c() != null) {
/* 393 */       return Integer.MIN_VALUE;
/*     */     }
/* 395 */     if (paramc.c() != null) {
/* 396 */       return Integer.MAX_VALUE;
/*     */     }
/*     */ 
/*     */     
/* 400 */     return getDescription().compareTo(paramc.getDescription());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 406 */     if (this == paramObject) return true; 
/* 407 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 409 */     d d1 = (d)paramObject;
/*     */     
/* 411 */     if ((this.a != null) ? !this.a.equals(d1.a) : (d1.a != null))
/* 412 */       return false; 
/* 413 */     if (!this.a.equals(d1.a)) return false; 
/* 414 */     if ((this.a != null) ? !this.a.equals(d1.a) : (d1.a != null)) return false;
/*     */   
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 419 */     int i = (this.a != null) ? this.a.hashCode() : 0;
/* 420 */     i = 31 * i + ((this.a != null) ? this.a.hashCode() : 0);
/* 421 */     i = 31 * i + this.a.hashCode();
/* 422 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\g\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */