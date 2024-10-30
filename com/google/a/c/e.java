/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.I;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bj;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class e
/*     */ {
/*  88 */   private static final I d = I.a(',').b();
/*     */ 
/*     */   
/*  91 */   private static final I e = I.a('=').b();
/*     */ 
/*     */ 
/*     */   
/*  95 */   private static final bj<String, l> a = bj.a()
/*  96 */     .a("initialCapacity", new d())
/*  97 */     .a("maximumSize", new h())
/*  98 */     .a("maximumWeight", new i())
/*  99 */     .a("concurrencyLevel", new b())
/* 100 */     .a("weakKeys", new f(k.r.f))
/* 101 */     .a("softValues", new m(k.r.e))
/* 102 */     .a("weakValues", new m(k.r.f))
/* 103 */     .a("recordStats", new j())
/* 104 */     .a("expireAfterAccess", new a())
/* 105 */     .a("expireAfterWrite", new n())
/* 106 */     .a("refreshAfterWrite", new k())
/* 107 */     .a("refreshInterval", new k())
/* 108 */     .e();
/*     */   
/*     */   @com.google.a.a.d
/*     */   Integer a;
/*     */   
/*     */   @com.google.a.a.d
/*     */   Long d;
/*     */   @com.google.a.a.d
/*     */   Long e;
/*     */   @com.google.a.a.d
/*     */   Integer c;
/*     */   @com.google.a.a.d
/*     */   k.r a;
/*     */   @com.google.a.a.d
/*     */   k.r b;
/*     */   @com.google.a.a.d
/*     */   Boolean b;
/*     */   
/*     */   private e(String paramString) {
/* 127 */     this.gF = paramString;
/*     */   }
/*     */   @com.google.a.a.d
/*     */   long af; @com.google.a.a.d
/*     */   TimeUnit a;
/*     */   @com.google.a.a.d
/*     */   long ag;
/*     */   
/*     */   public static e a(String paramString) {
/* 136 */     e e1 = new e(paramString);
/* 137 */     if (!paramString.isEmpty()) {
/* 138 */       for (String str1 : d.a(paramString)) {
/* 139 */         bh<String> bh = bh.b(e.a(str1));
/* 140 */         D.a(!bh.isEmpty(), "blank key-value pair");
/* 141 */         D.a(
/* 142 */             (bh.size() <= 2), "key-value pair %s with more than one equals sign", str1);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 147 */         String str2 = bh.get(0);
/* 148 */         l l = (l)a.get(str2);
/* 149 */         D.a((l != null), "unknown key %s", str2);
/*     */         
/* 151 */         String str3 = (bh.size() == 1) ? null : bh.get(1);
/* 152 */         l.a(e1, str2, str3);
/*     */       } 
/*     */     }
/*     */     
/* 156 */     return e1;
/*     */   }
/*     */   @com.google.a.a.d
/*     */   TimeUnit b; @com.google.a.a.d
/*     */   long ah;
/*     */   public static e a() {
/* 162 */     return a("maximumSize=0");
/*     */   }
/*     */   @com.google.a.a.d
/*     */   TimeUnit c; private final String gF;
/*     */   d<Object, Object> g() {
/* 167 */     d<Object, Object> d = d.a();
/* 168 */     if (this.a != null) {
/* 169 */       d.a(this.a.intValue());
/*     */     }
/* 171 */     if (this.d != null) {
/* 172 */       d.a(this.d.longValue());
/*     */     }
/* 174 */     if (this.e != null) {
/* 175 */       d.b(this.e.longValue());
/*     */     }
/* 177 */     if (this.c != null) {
/* 178 */       d.b(this.c.intValue());
/*     */     }
/* 180 */     if (this.a != null) {
/* 181 */       switch (null.A[this.a.ordinal()]) {
/*     */         case 1:
/* 183 */           d.c();
/*     */           break;
/*     */         default:
/* 186 */           throw new AssertionError();
/*     */       } 
/*     */     }
/* 189 */     if (this.b != null) {
/* 190 */       switch (null.A[this.b.ordinal()]) {
/*     */         case 2:
/* 192 */           d.e();
/*     */           break;
/*     */         case 1:
/* 195 */           d.d();
/*     */           break;
/*     */         default:
/* 198 */           throw new AssertionError();
/*     */       } 
/*     */     }
/* 201 */     if (this.b != null && this.b.booleanValue()) {
/* 202 */       d.f();
/*     */     }
/* 204 */     if (this.a != null) {
/* 205 */       d.a(this.af, this.a);
/*     */     }
/* 207 */     if (this.b != null) {
/* 208 */       d.b(this.ag, this.b);
/*     */     }
/* 210 */     if (this.c != null) {
/* 211 */       d.c(this.ah, this.c);
/*     */     }
/*     */     
/* 214 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String di() {
/* 223 */     return this.gF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 232 */     return x.a(this).b(di()).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 237 */     return y.a(new Object[] { this.a, this.d, this.e, this.c, this.a, this.b, this.b, 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 245 */           a(this.af, this.a), 
/* 246 */           a(this.ag, this.b), 
/* 247 */           a(this.ah, this.c) });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 252 */     if (this == paramObject) {
/* 253 */       return true;
/*     */     }
/* 255 */     if (!(paramObject instanceof e)) {
/* 256 */       return false;
/*     */     }
/* 258 */     e e1 = (e)paramObject;
/* 259 */     return (y.equal(this.a, e1.a) && 
/* 260 */       y.equal(this.d, e1.d) && 
/* 261 */       y.equal(this.e, e1.e) && 
/* 262 */       y.equal(this.c, e1.c) && 
/* 263 */       y.equal(this.a, e1.a) && 
/* 264 */       y.equal(this.b, e1.b) && 
/* 265 */       y.equal(this.b, e1.b) && 
/* 266 */       y.equal(
/* 267 */         a(this.af, this.a), 
/* 268 */         a(e1.af, e1.a)) && 
/* 269 */       y.equal(
/* 270 */         a(this.ag, this.b), 
/* 271 */         a(e1.ag, e1.b)) && 
/* 272 */       y.equal(
/* 273 */         a(this.ah, this.c), 
/* 274 */         a(e1.ah, e1.c)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Long a(long paramLong, TimeUnit paramTimeUnit) {
/* 282 */     return (paramTimeUnit == null) ? null : Long.valueOf(paramTimeUnit.toNanos(paramLong));
/*     */   }
/*     */   
/*     */   static abstract class e
/*     */     implements l
/*     */   {
/*     */     protected abstract void a(e param1e, int param1Int);
/*     */     
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 291 */       D.a((param1String2 != null && !param1String2.isEmpty()), "value of key %s omitted", param1String1);
/*     */       try {
/* 293 */         a(param1e, Integer.parseInt(param1String2));
/* 294 */       } catch (NumberFormatException numberFormatException) {
/* 295 */         throw new IllegalArgumentException(
/* 296 */             e.c("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }), numberFormatException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class g
/*     */     implements l
/*     */   {
/*     */     protected abstract void a(e param1e, long param1Long);
/*     */     
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 307 */       D.a((param1String2 != null && !param1String2.isEmpty()), "value of key %s omitted", param1String1);
/*     */       try {
/* 309 */         a(param1e, Long.parseLong(param1String2));
/* 310 */       } catch (NumberFormatException numberFormatException) {
/* 311 */         throw new IllegalArgumentException(
/* 312 */             e.c("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }), numberFormatException);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static class d
/*     */     extends e
/*     */   {
/*     */     protected void a(e param1e, int param1Int) {
/* 321 */       D.a((param1e.a == null), "initial capacity was already set to ", param1e.a);
/*     */ 
/*     */ 
/*     */       
/* 325 */       param1e.a = (TimeUnit)Integer.valueOf(param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   static class h
/*     */     extends g
/*     */   {
/*     */     protected void a(e param1e, long param1Long) {
/* 333 */       D.a((param1e.d == null), "maximum size was already set to ", param1e.d);
/* 334 */       D.a((param1e.e == null), "maximum weight was already set to ", param1e.e);
/*     */       
/* 336 */       param1e.d = Long.valueOf(param1Long);
/*     */     }
/*     */   }
/*     */   
/*     */   static class i
/*     */     extends g
/*     */   {
/*     */     protected void a(e param1e, long param1Long) {
/* 344 */       D.a((param1e.e == null), "maximum weight was already set to ", param1e.e);
/*     */       
/* 346 */       D.a((param1e.d == null), "maximum size was already set to ", param1e.d);
/* 347 */       param1e.e = Long.valueOf(param1Long);
/*     */     }
/*     */   }
/*     */   
/*     */   static class b
/*     */     extends e
/*     */   {
/*     */     protected void a(e param1e, int param1Int) {
/* 355 */       D.a((param1e.c == null), "concurrency level was already set to ", param1e.c);
/*     */ 
/*     */ 
/*     */       
/* 359 */       param1e.c = (TimeUnit)Integer.valueOf(param1Int);
/*     */     }
/*     */   }
/*     */   
/*     */   static class f
/*     */     implements l {
/*     */     private final k.r c;
/*     */     
/*     */     public f(k.r param1r) {
/* 368 */       this.c = param1r;
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 373 */       D.a((param1String2 == null), "key %s does not take values", param1String1);
/* 374 */       D.a((param1e.a == null), "%s was already set to %s", param1String1, param1e.a);
/* 375 */       param1e.a = (TimeUnit)this.c;
/*     */     }
/*     */   }
/*     */   
/*     */   static class m
/*     */     implements l {
/*     */     private final k.r c;
/*     */     
/*     */     public m(k.r param1r) {
/* 384 */       this.c = param1r;
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 389 */       D.a((param1String2 == null), "key %s does not take values", param1String1);
/* 390 */       D.a((param1e.b == null), "%s was already set to %s", param1String1, param1e.b);
/*     */ 
/*     */       
/* 393 */       param1e.b = (TimeUnit)this.c;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class j
/*     */     implements l
/*     */   {
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 402 */       D.a((param1String2 == null), "recordStats does not take values");
/* 403 */       D.a((param1e.b == null), "recordStats already set");
/* 404 */       param1e.b = (TimeUnit)Boolean.valueOf(true);
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class c
/*     */     implements l
/*     */   {
/*     */     protected abstract void a(e param1e, long param1Long, TimeUnit param1TimeUnit);
/*     */     
/*     */     public void a(e param1e, String param1String1, String param1String2) {
/* 414 */       D.a((param1String2 != null && !param1String2.isEmpty()), "value of key %s omitted", param1String1); try {
/*     */         TimeUnit timeUnit;
/* 416 */         char c1 = param1String2.charAt(param1String2.length() - 1);
/*     */         
/* 418 */         switch (c1) {
/*     */           case 'd':
/* 420 */             timeUnit = TimeUnit.DAYS;
/*     */             break;
/*     */           case 'h':
/* 423 */             timeUnit = TimeUnit.HOURS;
/*     */             break;
/*     */           case 'm':
/* 426 */             timeUnit = TimeUnit.MINUTES;
/*     */             break;
/*     */           case 's':
/* 429 */             timeUnit = TimeUnit.SECONDS;
/*     */             break;
/*     */           default:
/* 432 */             throw new IllegalArgumentException(
/* 433 */                 e.c("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { param1String1, param1String2 }));
/*     */         } 
/*     */ 
/*     */         
/* 437 */         long l1 = Long.parseLong(param1String2.substring(0, param1String2.length() - 1));
/* 438 */         a(param1e, l1, timeUnit);
/* 439 */       } catch (NumberFormatException numberFormatException) {
/* 440 */         throw new IllegalArgumentException(
/* 441 */             e.c("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static class a
/*     */     extends c
/*     */   {
/*     */     protected void a(e param1e, long param1Long, TimeUnit param1TimeUnit) {
/* 450 */       D.a((param1e.b == null), "expireAfterAccess already set");
/* 451 */       param1e.ag = param1Long;
/* 452 */       param1e.b = param1TimeUnit;
/*     */     }
/*     */   }
/*     */   
/*     */   static class n
/*     */     extends c
/*     */   {
/*     */     protected void a(e param1e, long param1Long, TimeUnit param1TimeUnit) {
/* 460 */       D.a((param1e.a == null), "expireAfterWrite already set");
/* 461 */       param1e.af = param1Long;
/* 462 */       param1e.a = param1TimeUnit;
/*     */     }
/*     */   }
/*     */   
/*     */   static class k
/*     */     extends c
/*     */   {
/*     */     protected void a(e param1e, long param1Long, TimeUnit param1TimeUnit) {
/* 470 */       D.a((param1e.c == null), "refreshAfterWrite already set");
/* 471 */       param1e.ah = param1Long;
/* 472 */       param1e.c = param1TimeUnit;
/*     */     }
/*     */   }
/*     */   
/*     */   private static String b(String paramString, Object... paramVarArgs) {
/* 477 */     return String.format(Locale.ROOT, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   private static interface l {
/*     */     void a(e param1e, String param1String1, String param1String2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */