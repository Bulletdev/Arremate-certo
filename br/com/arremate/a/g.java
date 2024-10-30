/*     */ package br.com.arremate.a;
/*     */ 
/*     */ import br.com.arremate.f.a;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k.c;
/*     */ import org.e.i;
/*     */ 
/*     */ public final class g
/*     */ {
/*  14 */   private static final g a = new g();
/*     */   
/*     */   private final l a;
/*     */   
/*     */   public static g a() {
/*  19 */     return (g)a;
/*     */   }
/*     */   
/*     */   private g() {
/*  23 */     this.a = new l();
/*     */   }
/*     */   
/*     */   public i a(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  27 */     i i = new i();
/*  28 */     i.c("login", paramString1);
/*  29 */     i.c("senha", paramString2);
/*  30 */     i.c("softwareVersion", paramString3);
/*  31 */     i.c("updaterVersion", paramString4);
/*     */     
/*  33 */     return this.a.a("dispute/login", i);
/*     */   }
/*     */   
/*     */   public i c() {
/*  37 */     return this.a.f("dispute/tips/day");
/*     */   }
/*     */   
/*     */   public i d() {
/*  41 */     return this.a.a("arremate/useterms/update", (i)null);
/*     */   }
/*     */   public i a(j paramj) {
/*     */     boolean bool;
/*  45 */     String str1 = String.valueOf(paramj.v());
/*     */     
/*  47 */     o o = paramj.b().a();
/*  48 */     if (a(o, paramj)) {
/*  49 */       str1 = ((c)paramj).bk();
/*  50 */     } else if (o.e.equals(o)) {
/*  51 */       str1 = paramj.bo();
/*  52 */     } else if (o.h.equals(o)) {
/*  53 */       str1 = ((c)paramj).cc();
/*     */     } 
/*     */     
/*  56 */     String str2 = paramj.bo();
/*  57 */     if (o.equals(o.g) || o.equals(o.m)) {
/*  58 */       str2 = paramj.bW();
/*     */     }
/*     */ 
/*     */     
/*  62 */     if (paramj.a() == l.b) {
/*  63 */       bool = true;
/*  64 */     } else if (paramj.a() == l.c || paramj
/*  65 */       .a() == l.i || paramj
/*  66 */       .a() == l.g) {
/*  67 */       bool = true;
/*     */     } else {
/*  69 */       bool = true;
/*     */     } 
/*     */     
/*  72 */     d d = paramj.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     i i = (new i()).a("portal", paramj.b().v()).c("bidding", str1).c("biddingNumber", str2).a("uasgCode", paramj.K()).c("uasgName", paramj.bT()).c("cnpj", d.aw()).a("modality", bool);
/*     */     
/*  82 */     return this.a.a("arremate/bidding/usage", i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(o paramo, j paramj) {
/*  88 */     boolean bool = (paramj.a().equals(l.g) || paramj.a().equals(l.h) || paramj.a().equals(l.k)) ? true : false;
/*  89 */     return (paramo.equals(o.a) && bool);
/*     */   }
/*     */   
/*     */   public i b(i parami) {
/*  93 */     return this.a.a("minha/app/approve", parami);
/*     */   }
/*     */   
/*     */   public i a(a parama) {
/*  97 */     i i = new i();
/*  98 */     i.a("app_id", parama.getId());
/*     */     
/* 100 */     return this.a.a("minha/app/reject", i);
/*     */   }
/*     */   
/*     */   public i b(a parama) {
/* 104 */     return this.a.f("general/apps/{appId}/access".replace("{appId}", String.valueOf(parama.getId())));
/*     */   }
/*     */   
/*     */   public i d(String paramString) {
/* 108 */     i i = new i();
/* 109 */     i.c("log", paramString);
/*     */     
/* 111 */     return this.a.a("arremate/emaillog", i);
/*     */   }
/*     */   
/*     */   public i a(String paramString1, String paramString2) {
/* 115 */     return a(paramString1, paramString2, "arremate/biddinghashbll");
/*     */   }
/*     */   
/*     */   public i b(String paramString1, String paramString2) {
/* 119 */     return a(paramString1, paramString2, "arremate/biddinghashbnc");
/*     */   }
/*     */   
/*     */   private i a(String paramString1, String paramString2, String paramString3) {
/* 123 */     i i = new i();
/* 124 */     i.c("params", new i(this, paramString1, paramString2)
/*     */         {
/*     */         
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 131 */     return this.a.a(paramString3, i);
/*     */   }
/*     */   
/*     */   public i e() {
/* 135 */     return this.a.f("arremate/notifications");
/*     */   }
/*     */   
/*     */   public i e(String paramString) {
/* 139 */     i i = new i();
/* 140 */     i.c("cnpj", paramString);
/*     */     
/* 142 */     return this.a.a("arremate/validcompany", i);
/*     */   }
/*     */   
/*     */   public i c(String paramString1, String paramString2) {
/* 146 */     i i = new i();
/* 147 */     i.c("name", paramString2);
/* 148 */     i.c("cnpj", paramString1);
/*     */     
/* 150 */     return this.a.a("arremate/validcompany", i);
/*     */   }
/*     */   
/*     */   public i f() {
/* 154 */     return this.a.f("arremate/statuslicense");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */