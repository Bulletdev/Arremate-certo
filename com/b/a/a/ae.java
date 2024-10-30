/*     */ package com.b.a.a;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ae
/*     */   extends ad
/*     */ {
/*     */   private static final int hH = 0;
/*     */   private static final int hI = 1;
/*     */   private static final int hJ = 2;
/*     */   private static final int hK = 3;
/*     */   private static final int hL = 1000;
/*     */   private final LinkedList<X> a;
/*     */   private final A a;
/*     */   private boolean bH;
/*     */   private X a;
/*     */   private boolean bY;
/*     */   private boolean bZ;
/*     */   
/*     */   public ae(Q paramQ) {
/*  43 */     super("WritingThread", paramQ, O.b);
/*     */     
/*  45 */     this.a = (X)new LinkedList();
/*  46 */     this.a = (X)paramQ.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gt() {
/*     */     try {
/*  55 */       gA();
/*     */     }
/*  57 */     catch (Throwable throwable) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  62 */       U u = new U(T.M, "An uncaught throwable was detected in the writing thread: " + throwable.getMessage(), throwable);
/*     */ 
/*     */       
/*  65 */       u u1 = this.b.a();
/*  66 */       u1.c(u);
/*  67 */       u1.d(u);
/*     */     } 
/*     */     
/*  70 */     synchronized (this) {
/*     */ 
/*     */       
/*  73 */       this.bZ = true;
/*  74 */       notifyAll();
/*     */     } 
/*     */ 
/*     */     
/*  78 */     gC();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void gA() {
/*  84 */     this.b.gN();
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/*  89 */       int i = bb();
/*     */       
/*  91 */       if (i == 1) {
/*     */         break;
/*     */       }
/*     */       
/*  95 */       if (i == 3) {
/*     */         
/*  97 */         gV();
/*     */         continue;
/*     */       } 
/* 100 */       if (i == 2) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 108 */         ap(false);
/*     */       }
/* 110 */       catch (U u) {
/*     */         break;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 120 */       ap(true);
/*     */     }
/* 122 */     catch (U u) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gT() {
/* 131 */     synchronized (this) {
/*     */ 
/*     */       
/* 134 */       this.bH = true;
/*     */ 
/*     */       
/* 137 */       notifyAll();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean i(X paramX) {
/* 144 */     synchronized (this) {
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         
/* 149 */         if (this.bZ)
/*     */         {
/*     */           
/* 152 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 157 */         if (this.bH || this.a != null) {
/*     */           break;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 164 */         if (paramX.el()) {
/*     */           break;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 171 */         int i = this.b.aV();
/*     */ 
/*     */         
/* 174 */         if (i == 0) {
/*     */           break;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 181 */         if (this.a.size() < i) {
/*     */           break;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 190 */           wait();
/*     */         }
/* 192 */         catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       if (j(paramX)) {
/*     */ 
/*     */         
/* 201 */         z(paramX);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 206 */         this.a.addLast(paramX);
/*     */       } 
/*     */ 
/*     */       
/* 210 */       notifyAll();
/*     */     } 
/*     */ 
/*     */     
/* 214 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean j(X paramX) {
/* 220 */     return (paramX.ei() || paramX.ej());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void z(X paramX) {
/* 226 */     byte b = 0;
/*     */ 
/*     */ 
/*     */     
/* 230 */     for (X x : this.a) {
/*     */ 
/*     */       
/* 233 */       if (!j(x)) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 238 */       b++;
/*     */     } 
/*     */     
/* 241 */     this.a.add(b, paramX);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gU() {
/* 247 */     synchronized (this) {
/*     */       
/* 249 */       this.bY = true;
/*     */ 
/*     */       
/* 252 */       notifyAll();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void gV() {
/*     */     try {
/* 261 */       flush();
/*     */     }
/* 263 */     catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void flush() throws IOException {
/* 271 */     this.b.a().flush();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int bb() {
/* 277 */     synchronized (this) {
/*     */ 
/*     */       
/* 280 */       if (this.bH)
/*     */       {
/* 282 */         return 1;
/*     */       }
/*     */ 
/*     */       
/* 286 */       if (this.a != null)
/*     */       {
/* 288 */         return 1;
/*     */       }
/*     */ 
/*     */       
/* 292 */       if (this.a.size() == 0) {
/*     */ 
/*     */         
/* 295 */         if (this.bY) {
/*     */           
/* 297 */           this.bY = false;
/* 298 */           return 3;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 305 */           wait();
/*     */         }
/* 307 */         catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 312 */       if (this.bH)
/*     */       {
/* 314 */         return 1;
/*     */       }
/*     */       
/* 317 */       if (this.a.size() == 0) {
/*     */         
/* 319 */         if (this.bY) {
/*     */           
/* 321 */           this.bY = false;
/* 322 */           return 3;
/*     */         } 
/*     */ 
/*     */         
/* 326 */         return 2;
/*     */       } 
/*     */     } 
/*     */     
/* 330 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ap(boolean paramBoolean) throws U {
/* 337 */     long l = System.currentTimeMillis();
/*     */ 
/*     */     
/*     */     while (true) {
/*     */       X x;
/*     */       
/* 343 */       synchronized (this) {
/*     */ 
/*     */         
/* 346 */         x = this.a.poll();
/*     */ 
/*     */         
/* 349 */         notifyAll();
/*     */ 
/*     */         
/* 352 */         if (x == null) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 360 */       A(x);
/*     */ 
/*     */       
/* 363 */       if (x.ei() || x.ej()) {
/*     */ 
/*     */         
/* 366 */         doFlush();
/* 367 */         l = System.currentTimeMillis();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 372 */       if (!c(paramBoolean)) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 379 */       l = l(l);
/*     */     } 
/*     */     
/* 382 */     if (c(paramBoolean))
/*     */     {
/* 384 */       doFlush();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean c(boolean paramBoolean) {
/* 391 */     return (paramBoolean || this.b.dW() || this.bY || this.a != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long l(long paramLong) throws U {
/* 398 */     long l = System.currentTimeMillis();
/*     */ 
/*     */     
/* 401 */     if (1000L < l - paramLong) {
/*     */ 
/*     */       
/* 404 */       doFlush();
/*     */ 
/*     */       
/* 407 */       return l;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 412 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doFlush() throws U {
/*     */     try {
/* 422 */       flush();
/*     */       
/* 424 */       synchronized (this)
/*     */       {
/* 426 */         this.bY = false;
/*     */       }
/*     */     
/* 429 */     } catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 434 */       U u = new U(T.A, "Flushing frames to the server failed: " + iOException.getMessage(), iOException);
/*     */ 
/*     */       
/* 437 */       u u1 = this.b.a();
/* 438 */       u1.c(u);
/* 439 */       u1.b(u, (X)null);
/*     */       
/* 441 */       throw u;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void A(X paramX) throws U {
/* 449 */     paramX = X.a(paramX, (A)this.a);
/*     */ 
/*     */     
/* 452 */     this.b.a().h(paramX);
/*     */     
/* 454 */     boolean bool = false;
/*     */ 
/*     */     
/* 457 */     if (this.a != null) {
/*     */ 
/*     */       
/* 460 */       bool = true;
/*     */     
/*     */     }
/* 463 */     else if (paramX.eh()) {
/*     */       
/* 465 */       this.a = paramX;
/*     */     } 
/*     */     
/* 468 */     if (bool) {
/*     */ 
/*     */       
/* 471 */       this.b.a().j(paramX);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 476 */     if (paramX.eh())
/*     */     {
/*     */ 
/*     */       
/* 480 */       gW();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 486 */       this.b.a().v(paramX);
/*     */     }
/* 488 */     catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 493 */       U u = new U(T.z, "An I/O error occurred when a frame was tried to be sent: " + iOException.getMessage(), iOException);
/*     */ 
/*     */       
/* 496 */       u u1 = this.b.a();
/* 497 */       u1.c(u);
/* 498 */       u1.b(u, paramX);
/*     */       
/* 500 */       throw u;
/*     */     } 
/*     */ 
/*     */     
/* 504 */     this.b.a().i(paramX);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void gW() {
/* 510 */     M m = this.b.a();
/*     */     
/* 512 */     boolean bool = false;
/*     */     
/* 514 */     synchronized (m) {
/*     */ 
/*     */       
/* 517 */       ac ac = m.a();
/*     */ 
/*     */       
/* 520 */       if (ac != ac.e && ac != ac.f) {
/*     */ 
/*     */         
/* 523 */         m.a(M.a.d);
/*     */         
/* 525 */         bool = true;
/*     */       } 
/*     */     } 
/*     */     
/* 529 */     if (bool)
/*     */     {
/*     */       
/* 532 */       this.b.a().a(ac.e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void gC() {
/* 539 */     this.b.u(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\ae.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */