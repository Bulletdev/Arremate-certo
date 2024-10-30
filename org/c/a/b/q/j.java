/*     */ package org.c.a.b.q;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.c.a.b.j.c;
/*     */ import org.c.a.b.r.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class j
/*     */ {
/*  40 */   protected final List<c> lines = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean terminated;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean cW = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean cX = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String lH;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean cY = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean cZ = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   protected int iH = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   private int iI = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean da = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final d g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected d d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(d paramd) {
/* 103 */     this.g = paramd;
/* 104 */     this.d = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(d paramd) {
/* 111 */     this.d = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isEmpty() {
/* 120 */     return this.lines.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTerminated() {
/* 129 */     return this.terminated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fV() {
/* 136 */     return (this.iH >= 0);
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
/*     */   public i a() {
/* 150 */     return new l(this.lines, this.d);
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
/*     */   public d a(String paramString) {
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean N(String paramString) {
/* 175 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean K(String paramString) {
/* 185 */     return paramString.startsWith("--");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(c paramc) {
/* 194 */     String str1 = paramc.eG();
/* 195 */     String str2 = str1.trim();
/* 196 */     String str3 = aS(str2);
/*     */ 
/*     */     
/* 199 */     if (isEmpty() && this.d != null && str3.equals(this.d.eL().toUpperCase())) {
/*     */       return;
/*     */     }
/*     */     
/* 203 */     if (N(str2)) {
/* 204 */       this.iH = this.lines.size();
/*     */     }
/*     */     
/* 207 */     bD(str3);
/* 208 */     if (fW() || this.cZ) {
/* 209 */       this.lines.add(paramc);
/*     */       
/*     */       return;
/*     */     } 
/* 213 */     this.d = a(str3, this.d);
/*     */     
/* 215 */     if (!this.cY && a(str3, this.d)) {
/* 216 */       this.terminated = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     this.lines.add(paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean fW() {
/* 234 */     return (this.cW || this.cX);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fO() {
/* 241 */     return (!this.cX && !this.cW && !this.cZ && this.iH < 0 && (this.lines
/*     */       
/* 243 */       .isEmpty() || !n.X(((c)this.lines.get(this.lines.size() - 1)).eG())));
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
/*     */   protected String aS(String paramString) {
/* 256 */     String str = aQ(paramString).replace("--", " -- ").replace("/*", " /* ").replace("*/", " */ ");
/* 257 */     return n.bg(str).trim().toUpperCase();
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
/*     */   protected d a(String paramString, d paramd) {
/* 270 */     return paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(String paramString, d paramd) {
/* 281 */     if (paramd == null || (this.g.equals(paramd) && this.iI > 0)) {
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     String str = paramd.eL().toUpperCase();
/*     */     
/* 287 */     if (paramd.fT()) {
/* 288 */       return paramString.equals(str);
/*     */     }
/*     */     
/* 291 */     return paramString.endsWith(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String aO(String paramString) {
/* 301 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String aT(String paramString) {
/* 311 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bD(String paramString) {
/* 320 */     Collection<String> collection = a(paramString);
/*     */     
/* 322 */     List<a> list = a(collection);
/*     */     
/* 324 */     this.cY = false;
/* 325 */     for (a a : list) {
/* 326 */       if (!this.cW && !this.cX && a.e
/* 327 */         .equals(a)) {
/* 328 */         this.cZ = true;
/*     */       }
/* 330 */       if (!this.cW && !this.cX && a.f
/* 331 */         .equals(a)) {
/* 332 */         this.cZ = false;
/*     */       }
/*     */       
/* 335 */       if (!this.cW && !this.cX && !this.cZ && a.d
/* 336 */         .equals(a)) {
/* 337 */         this.cY = true;
/*     */         
/*     */         return;
/*     */       } 
/* 341 */       if (!this.cZ && !this.cW && a.c
/* 342 */         .equals(a)) {
/* 343 */         this.cX = !this.cX;
/*     */       }
/*     */       
/* 346 */       if (!this.cZ && !this.cX && a.b
/* 347 */         .equals(a)) {
/* 348 */         this.cW = !this.cW;
/*     */       }
/*     */       
/* 351 */       if (!this.cZ && !this.cW && !this.cX && (a.a
/* 352 */         .equals(a) || a.g
/* 353 */         .equals(a) || a.h
/* 354 */         .equals(a))) {
/* 355 */         if (!fV()) {
/* 356 */           this.iH = this.lines.size();
/*     */         }
/* 358 */         if (fD()) {
/* 359 */           if (a.g.equals(a)) {
/* 360 */             this.iI++; continue;
/* 361 */           }  if (a.h.equals(a)) {
/* 362 */             this.iI--;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean fD() {
/* 373 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<String> a(String paramString) {
/* 383 */     return n.f(paramString, " @<>;:=|(),+{}");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<a> a(Collection<String> paramCollection) {
/* 394 */     ArrayList<a> arrayList = new ArrayList();
/* 395 */     for (String str1 : paramCollection) {
/* 396 */       String str2 = aP(str1);
/* 397 */       boolean bool = false;
/*     */       
/* 399 */       if (this.lH == null) {
/* 400 */         String str = aO(str2);
/* 401 */         if (str != null) {
/* 402 */           String str3 = aT(str);
/* 403 */           if (str2.length() >= str.length() + str3.length() && str2
/* 404 */             .startsWith(str) && str2.endsWith(str3)) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */           
/* 409 */           this.lH = str3;
/* 410 */           arrayList.add(a.c);
/*     */           
/*     */           continue;
/*     */         } 
/*     */       } 
/* 415 */       if (this.lH != null && str2.endsWith(this.lH)) {
/* 416 */         this.lH = null;
/* 417 */         arrayList.add(a.c);
/*     */         
/*     */         continue;
/*     */       } 
/* 421 */       if (str2.length() >= 2 && str2.startsWith("'") && str2.endsWith("'")) {
/*     */         continue;
/*     */       }
/*     */       
/* 425 */       if (str2.length() >= 4) {
/* 426 */         int i = n.c(str2, "/*");
/* 427 */         int k = n.c(str2, "*/");
/* 428 */         if (i > 0 && i == k) {
/*     */           continue;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 434 */       if (K(str2)) {
/* 435 */         arrayList.add(a.d);
/* 436 */         bool = true;
/*     */       } 
/*     */       
/* 439 */       if (str2.contains("/*")) {
/* 440 */         arrayList.add(a.e);
/* 441 */         bool = true;
/* 442 */       } else if (str2.startsWith("'")) {
/* 443 */         arrayList.add(a.b);
/* 444 */         bool = true;
/*     */       } 
/*     */       
/* 447 */       if (!str2.contains("/*") && str2.contains("*/")) {
/* 448 */         arrayList.add(a.f);
/* 449 */         bool = true;
/* 450 */       } else if (!str2.startsWith("'") && str2.endsWith("'")) {
/* 451 */         arrayList.add(a.b);
/* 452 */         bool = true;
/*     */       } 
/*     */       
/* 455 */       if (!bool) {
/* 456 */         if (L(str2)) {
/* 457 */           arrayList.add(a.g); continue;
/* 458 */         }  if (M(str2)) {
/* 459 */           arrayList.add(a.h); continue;
/*     */         } 
/* 461 */         arrayList.add((a)a.a);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 466 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected boolean L(String paramString) {
/* 470 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean M(String paramString) {
/* 474 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String aQ(String paramString) {
/* 484 */     return paramString.replace("''", "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String aP(String paramString) {
/* 495 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fU() {
/* 505 */     return this.da;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum a
/*     */   {
/* 515 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 520 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 525 */     c,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 530 */     d,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 535 */     e,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 540 */     f,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 545 */     g,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 550 */     h;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */