/*     */ package br.com.arremate.a.a;
/*     */ 
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ public class b
/*     */ {
/*     */   private final int status;
/*     */   private String message;
/*     */   private int c;
/*     */   private boolean a;
/*     */   private String s;
/*     */   private boolean b;
/*     */   private boolean c;
/*     */   private f a;
/*     */   private i a;
/*     */   private f b;
/*     */   private f c;
/*     */   private String key;
/*     */   private String u;
/*     */   private String v;
/*     */   private String w;
/*     */   
/*     */   public b(int paramInt, String paramString) {
/*  25 */     this.status = paramInt;
/*  26 */     this.message = paramString;
/*     */   }
/*     */   
/*     */   public b(i parami) {
/*  30 */     this.status = parami.getInt("status");
/*  31 */     this.message = parami.getString("message");
/*  32 */     this.c = parami.getInt("daysRemaining");
/*  33 */     this.a = parami.getBoolean("isAcceptedTerms");
/*  34 */     this.b = parami.getBoolean("isSoftwareLatestVersion");
/*  35 */     this.c = parami.getBoolean("isUpdaterLatestVersion");
/*  36 */     this.a = (i)parami.c("portals");
/*  37 */     this.a = parami.j("urls");
/*  38 */     this.b = parami.c("alerts");
/*  39 */     this.c = parami.c("services");
/*  40 */     this.key = parami.getString("key");
/*  41 */     if (parami.has("plan") && !parami.isNull("plan")) {
/*  42 */       this.u = parami.getString("plan");
/*     */     }
/*     */     
/*  45 */     this.v = parami.getString("xTokenLicitanet");
/*  46 */     this.w = parami.getString("apiKeyLicitanet");
/*     */   }
/*     */   
/*     */   public String getMessage() {
/*  50 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String paramString) {
/*  54 */     this.message = paramString;
/*     */   }
/*     */   
/*     */   public String b() {
/*  58 */     return this.s;
/*     */   }
/*     */   
/*     */   public void a(String paramString) {
/*  62 */     this.s = paramString;
/*     */   }
/*     */   
/*     */   public int a() {
/*  66 */     return this.c;
/*     */   }
/*     */   
/*     */   public boolean c() {
/*  70 */     return this.a;
/*     */   }
/*     */   
/*     */   public boolean d() {
/*  74 */     return this.b;
/*     */   }
/*     */   
/*     */   public boolean e() {
/*  78 */     return this.c;
/*     */   }
/*     */   
/*     */   public int getStatus() {
/*  82 */     return this.status;
/*     */   }
/*     */   
/*     */   public boolean f() {
/*  86 */     return (this.status == 2 && this.u == null);
/*     */   }
/*     */   
/*     */   public boolean g() {
/*  90 */     return (this.status == 2);
/*     */   }
/*     */   
/*     */   public boolean h() {
/*  94 */     return (this.status == 1);
/*     */   }
/*     */   
/*     */   public boolean isError() {
/*  98 */     return (this.status == 0);
/*     */   }
/*     */   
/*     */   public f a() {
/* 102 */     return (f)this.a;
/*     */   }
/*     */   
/*     */   public i h() {
/* 106 */     return this.a;
/*     */   }
/*     */   
/*     */   public f b() {
/* 110 */     return this.b;
/*     */   }
/*     */   
/*     */   public f c() {
/* 114 */     return this.c;
/*     */   }
/*     */   
/*     */   public String getKey() {
/* 118 */     return this.key;
/*     */   }
/*     */   
/*     */   public String c() {
/* 122 */     return this.u;
/*     */   }
/*     */   
/*     */   public String d() {
/* 126 */     return this.v;
/*     */   }
/*     */   
/*     */   public String e() {
/* 130 */     return this.w;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */