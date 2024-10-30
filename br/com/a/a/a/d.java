/*     */ package br.com.a.a.a;
/*     */ 
/*     */ import br.com.a.b.b.a;
/*     */ import br.com.a.b.d.a;
/*     */ import br.com.a.c.c;
/*     */ import br.com.a.d.a.b;
/*     */ import br.com.a.d.a.c;
/*     */ import br.com.a.d.a.e;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class d
/*     */ {
/*  20 */   private static final Logger a = LoggerFactory.getLogger(d.class);
/*     */ 
/*     */ 
/*     */   
/*     */   protected c a;
/*     */ 
/*     */   
/*     */   protected a a;
/*     */ 
/*     */   
/*  30 */   protected a a = new a();
/*     */   protected i l;
/*     */   protected String authorization;
/*     */   
/*     */   public void el() throws br.com.a.d.a.d, e, b, c {
/*  35 */     this.T = System.currentTimeMillis();
/*  36 */     em();
/*  37 */     en();
/*  38 */     eo();
/*  39 */     eb();
/*  40 */     eq();
/*  41 */     er();
/*     */   }
/*     */   protected int aE; private long T;
/*     */   private void em() throws br.com.a.d.a.d {
/*  45 */     this.a.a().clear();
/*  46 */     this.a.get(this.a.cM());
/*  47 */     if (this.a.getStatusCode() != 200) {
/*  48 */       throw new br.com.a.d.a.d("Falha ao requisitar as chaves de acesso ao portal");
/*     */     }
/*     */   }
/*     */   
/*     */   private void en() throws br.com.a.d.a.d {
/*     */     try {
/*  54 */       String str1 = this.a.af(this.a.cW());
/*  55 */       String str2 = this.a.get(str1);
/*  56 */       i i1 = new i(str2);
/*  57 */       this.a.setKey(i1.getString("chave"));
/*  58 */       this.a.aR(i1.getString("seedWarsaw"));
/*  59 */       this.a.aS(i1.getString("infoCMD"));
/*  60 */       this.a.aQ(i1.getString("F10CMD"));
/*  61 */     } catch (Exception exception) {
/*  62 */       a.error("Failed on request portal access keys", exception);
/*  63 */       throw new br.com.a.d.a.d("Falha ao requisitar as chaves de acesso ao portal");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void eo() throws e, br.com.a.d.a.d {
/*  68 */     this.a.et();
/*  69 */     this.a.ev();
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void eb() throws e, br.com.a.d.a.d, b, c;
/*     */   
/*     */   protected void ep() throws e {
/*  76 */     if (this.a.cX().isEmpty() || this.a
/*  77 */       .cY().isEmpty()) {
/*  78 */       a.error("Failed on warsaw generated keys");
/*  79 */       throw new e("Falha no retorno de chaves do warsaw");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void eq() throws e {
/*  84 */     if (!this.a.cZ().isEmpty()) {
/*  85 */       throw new e(this.a.cZ());
/*     */     }
/*     */   }
/*     */   
/*     */   private void er() {
/*  90 */     this.l = new i();
/*  91 */     this.l.c("cookies", g());
/*  92 */     this.l.c("authorization", this.authorization);
/*  93 */     if (this.aE != 0) {
/*  94 */       this.l.a("clientCode", this.aE);
/*     */     }
/*  96 */     this.l.a("time", TimeUnit.MILLISECONDS
/*  97 */         .toSeconds(System.currentTimeMillis() - this.T));
/*     */   }
/*     */   
/*     */   private f g() {
/* 101 */     f f = new f();
/* 102 */     if (this.a.cZ().isEmpty()) {
/* 103 */       for (Cookie cookie : this.a.a().getCookies()) {
/* 104 */         i i1 = new i();
/* 105 */         i1.c("name", cookie.getName());
/* 106 */         i1.c("value", cookie.getValue());
/* 107 */         i1.c("expire", cookie.getExpiryDate());
/* 108 */         i1.c("domain", cookie.getDomain());
/* 109 */         i1.c("path", cookie.getPath());
/* 110 */         i1.b("secure", cookie.isSecure());
/* 111 */         f.a(i1);
/*     */       } 
/*     */     }
/* 114 */     return f;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\a\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */