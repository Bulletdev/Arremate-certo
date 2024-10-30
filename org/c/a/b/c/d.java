/*     */ package org.c.a.b.c;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.c.a.a.b.e;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.c.b;
/*     */ import org.c.a.a.e;
/*     */ import org.c.a.a.e.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.a.g;
/*     */ import org.c.a.a.h.c;
/*     */ import org.c.a.b.e.a.b;
/*     */ import org.c.a.b.g.e;
/*     */ import org.c.a.b.h.i;
/*     */ import org.c.a.b.p.c;
/*     */ import org.c.a.b.r.f;
/*     */ import org.c.a.b.r.m;
/*     */ import org.c.a.b.r.n;
/*     */ import org.c.a.b.r.o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*  55 */   private static final org.c.a.a.f.a a = c.b(d.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.e.a.d a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final c a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final b a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.a.a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final org.c.a.b.e.a.a c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d(b paramb, c paramc, org.c.a.b.e.a.d paramd, c paramc1, b paramb1, org.c.a.b.a.a parama) {
/* 104 */     this.a = (org.c.a.b.a.a)paramb;
/* 105 */     this.c = paramb.b();
/* 106 */     this.a = (org.c.a.b.a.a)paramc;
/* 107 */     this.a = (org.c.a.b.a.a)paramd;
/* 108 */     this.a = (org.c.a.b.a.a)paramc1;
/* 109 */     this.a = (org.c.a.b.a.a)paramb1;
/* 110 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bL() throws org.c.a.a.a {
/*     */     int i;
/* 120 */     this.a.b(e.d);
/*     */ 
/*     */     
/*     */     try {
/* 124 */       m m = new m();
/* 125 */       m.start();
/*     */       
/* 127 */       this.a.hS();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 139 */       i = this.a.fk() ? ((Integer)this.a.a(new Callable<Integer>(this) { public Integer g() { return Integer.valueOf(d.a(this.a)); } })).intValue() : bN();
/*     */       
/* 141 */       m.stop();
/*     */       
/* 143 */       c(i, m.al());
/* 144 */     } catch (org.c.a.a.a a1) {
/* 145 */       this.a.b(e.l);
/* 146 */       throw a1;
/*     */     } 
/*     */     
/* 149 */     this.a.b(e.k);
/* 150 */     return i;
/*     */   }
/*     */   
/*     */   private int bN() {
/* 154 */     int j, i = 0;
/*     */     do {
/* 156 */       boolean bool = !i ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       j = this.a.fk() ? a(bool).intValue() : ((Integer)this.a.a(new Callable<Integer>(this, bool)
/*     */           {
/*     */             public Integer g() {
/* 164 */               return d.a(this.a, this.cy);
/*     */             }
/*     */           })).intValue();
/* 167 */       i += j;
/* 168 */     } while (j != 0);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     return i;
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
/*     */   private Integer a(boolean paramBoolean) {
/* 185 */     e e = new e((c)this.a, (c)this.a, (b)this.a, this.a.a(), this.a.fh(), true, true, true, true);
/*     */     
/* 187 */     e.cx();
/*     */     
/* 189 */     c c1 = e.a();
/* 190 */     g g = (c1 == null) ? g.a : c1.c();
/* 191 */     if (paramBoolean) {
/* 192 */       a.info("Current version of schema " + this.a + ": " + g);
/*     */       
/* 194 */       if (this.a.fh()) {
/* 195 */         a.warn("outOfOrder mode is active. Migration of schema " + this.a + " may not be reproducible.");
/*     */       }
/*     */     } 
/*     */     
/* 199 */     c[] arrayOfC1 = e.f();
/* 200 */     if (arrayOfC1.length > 0) {
/* 201 */       List<c> list = Arrays.asList(e.d());
/* 202 */       Collections.reverse(list);
/* 203 */       if (list.isEmpty()) {
/* 204 */         a.warn("Schema " + this.a + " has version " + g + ", but no migration could be resolved in the configured locations !");
/*     */       } else {
/*     */         
/* 207 */         for (c c2 : list) {
/*     */           
/* 209 */           if (c2.c() != null) {
/* 210 */             a.warn("Schema " + this.a + " has a version (" + g + ") that is newer than the latest available migration (" + c2
/*     */                 
/* 212 */                 .c() + ") !");
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 219 */     c[] arrayOfC2 = e.e();
/* 220 */     if (arrayOfC2.length > 0) {
/* 221 */       if (arrayOfC2.length == 1 && arrayOfC2[0]
/* 222 */         .a() == e.n && this.a
/* 223 */         .fc()) {
/* 224 */         a.warn("Schema " + this.a + " contains a failed future migration to version " + arrayOfC2[0].c() + " !");
/*     */       } else {
/* 226 */         if (arrayOfC2[0].c() == null) {
/* 227 */           throw new org.c.a.a.a("Schema " + this.a + " contains a failed repeatable migration (" + arrayOfC2[0].getDescription() + ") !");
/*     */         }
/* 229 */         throw new org.c.a.a.a("Schema " + this.a + " contains a failed migration to version " + arrayOfC2[0].c() + " !");
/*     */       } 
/*     */     }
/*     */     
/* 233 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 234 */     for (org.c.a.b.g.d d1 : e.a()) {
/*     */       
/* 236 */       boolean bool = (d1.c() != null && d1.c().a(g) < 0) ? true : false;
/* 237 */       linkedHashMap.put(d1, Boolean.valueOf(bool));
/*     */       
/* 239 */       if (!this.a.fk()) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 245 */     if (!linkedHashMap.isEmpty()) {
/* 246 */       a((LinkedHashMap)linkedHashMap);
/*     */     }
/* 248 */     return Integer.valueOf(linkedHashMap.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(int paramInt, long paramLong) {
/* 259 */     if (paramInt == 0) {
/* 260 */       a.info("Schema " + this.a + " is up to date. No migration necessary.");
/*     */       
/*     */       return;
/*     */     } 
/* 264 */     if (paramInt == 1) {
/* 265 */       a.info("Successfully applied 1 migration to schema " + this.a + " (execution time " + o.format(paramLong) + ")");
/*     */     } else {
/* 267 */       a.info("Successfully applied " + paramInt + " migrations to schema " + this.a + " (execution time " + o.format(paramLong) + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(LinkedHashMap<org.c.a.b.g.d, Boolean> paramLinkedHashMap) {
/* 277 */     boolean bool = a(paramLinkedHashMap);
/* 278 */     m m = new m();
/*     */     try {
/* 280 */       if (bool) {
/* 281 */         (new i(this.c.c())).execute(new Callable(this, paramLinkedHashMap, m)
/*     */             {
/*     */               public Object call() {
/* 284 */                 d.a(this.a, this.c, (m)this.a);
/* 285 */                 return null;
/*     */               }
/*     */             });
/*     */       } else {
/* 289 */         a(paramLinkedHashMap, m);
/*     */       } 
/* 291 */     } catch (a a1) {
/* 292 */       org.c.a.b.g.d d1 = a1.a();
/* 293 */       String str = "Migration of " + a(d1, a1.fh()) + " failed!";
/* 294 */       if (this.a.fx() && bool) {
/* 295 */         a.error(str + " Changes successfully rolled back.");
/*     */       } else {
/* 297 */         a.error(str + " Please restore backups and roll back database and code!");
/*     */         
/* 299 */         m.stop();
/* 300 */         int i = (int)m.al();
/* 301 */         this.a.a(d1.c(), d1.getDescription(), d1
/* 302 */             .a(), d1.es(), d1.a().d(), i, false);
/*     */       } 
/* 304 */       throw a1;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(LinkedHashMap<org.c.a.b.g.d, Boolean> paramLinkedHashMap) {
/* 309 */     boolean bool = true;
/* 310 */     boolean bool1 = true;
/*     */     
/* 312 */     for (Map.Entry<org.c.a.b.g.d, Boolean> entry : paramLinkedHashMap.entrySet()) {
/* 313 */       org.c.a.a.h.d d1 = ((org.c.a.b.g.d)entry.getKey()).a();
/* 314 */       boolean bool2 = d1.a().fv();
/*     */       
/* 316 */       if (bool1) {
/* 317 */         bool = bool2;
/* 318 */         bool1 = false;
/*     */         
/*     */         continue;
/*     */       } 
/* 322 */       if (!this.a.fj() && bool != bool2) {
/* 323 */         throw new org.c.a.a.a("Detected both transactional and non-transactional migrations within the same migration group (even though mixed is false). First offending migration:" + (
/*     */ 
/*     */             
/* 326 */             (d1.c() == null) ? "" : (" " + d1.c())) + (
/* 327 */             n.W(d1.getDescription()) ? (" " + d1.getDescription()) : "") + (
/* 328 */             bool2 ? "" : " [non-transactional]"));
/*     */       }
/*     */       
/* 331 */       bool &= bool2;
/*     */     } 
/*     */     
/* 334 */     return bool;
/*     */   }
/*     */   
/*     */   private void a(LinkedHashMap<org.c.a.b.g.d, Boolean> paramLinkedHashMap, m paramm) {
/* 338 */     org.c.a.a.e.a a1 = new org.c.a.a.e.a(this)
/*     */       {
/*     */         public b a() {
/* 341 */           return d.a(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public Connection getConnection() {
/* 346 */           return d.a(this.a).c();
/*     */         }
/*     */       };
/*     */     
/* 350 */     for (Map.Entry<org.c.a.b.g.d, Boolean> entry : paramLinkedHashMap.entrySet()) {
/* 351 */       org.c.a.b.g.d d1 = (org.c.a.b.g.d)entry.getKey();
/* 352 */       boolean bool = ((Boolean)entry.getValue()).booleanValue();
/*     */       
/* 354 */       String str = a(d1, bool);
/*     */       
/* 356 */       paramm.start();
/*     */       
/* 358 */       a.info("Migrating " + str);
/*     */       
/* 360 */       this.c.hU();
/* 361 */       this.c.c((org.c.a.b.e.a.d)this.a);
/*     */       
/*     */       try {
/* 364 */         this.a.a((c)d1);
/* 365 */         this.a.c(e.e);
/*     */         try {
/* 367 */           d1.a().a().a(a1);
/* 368 */         } catch (org.c.a.a.a a2) {
/* 369 */           this.a.c(e.j);
/* 370 */           throw new a(d1, bool, a2);
/* 371 */         } catch (SQLException sQLException) {
/* 372 */           this.a.c(e.j);
/* 373 */           throw new a(d1, bool, sQLException);
/*     */         } 
/*     */         
/* 376 */         a.debug("Successfully completed migration of " + str);
/* 377 */         this.a.c(e.i);
/*     */       } finally {
/* 379 */         this.a.a(null);
/*     */       } 
/*     */       
/* 382 */       paramm.stop();
/* 383 */       int i = (int)paramm.al();
/*     */       
/* 385 */       this.a.a(d1.c(), d1.getDescription(), d1.a(), d1
/* 386 */           .es(), d1.a().d(), i, true);
/*     */     } 
/*     */   }
/*     */   private String a(org.c.a.b.g.d paramd, boolean paramBoolean) {
/*     */     String str;
/* 391 */     b b1 = paramd.a().a();
/*     */     
/* 393 */     if (paramd.c() != null) {
/*     */       
/* 395 */       str = "schema " + this.a + " to version " + paramd.c() + " - " + paramd.getDescription() + (paramBoolean ? " [out of order]" : "") + (b1.fv() ? "" : " [non-transactional]");
/*     */     } else {
/*     */       
/* 398 */       str = "schema " + this.a + " with repeatable migration " + paramd.getDescription() + (b1.fv() ? "" : " [non-transactional]");
/*     */     } 
/* 400 */     return str;
/*     */   }
/*     */   
/*     */   public static class a extends org.c.a.a.a {
/*     */     private final org.c.a.b.g.d a;
/*     */     private final boolean cs;
/*     */     
/*     */     a(org.c.a.b.g.d param1d, boolean param1Boolean, SQLException param1SQLException) {
/* 408 */       super(f.a(param1SQLException), param1SQLException);
/* 409 */       this.a = param1d;
/* 410 */       this.cs = param1Boolean;
/*     */     }
/*     */     
/*     */     a(org.c.a.b.g.d param1d, boolean param1Boolean, org.c.a.a.a param1a) {
/* 414 */       super(param1a.getMessage(), (Throwable)param1a);
/* 415 */       this.a = param1d;
/* 416 */       this.cs = param1Boolean;
/*     */     }
/*     */     
/*     */     public org.c.a.b.g.d a() {
/* 420 */       return this.a;
/*     */     }
/*     */     
/*     */     public boolean fh() {
/* 424 */       return this.cs;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */