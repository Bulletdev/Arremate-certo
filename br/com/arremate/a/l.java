/*     */ package br.com.arremate.a;
/*     */ 
/*     */ import br.com.arremate.a.a.c;
/*     */ import br.com.arremate.f.y;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.f;
/*     */ import br.com.arremate.h.g;
/*     */ import java.io.File;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.Map;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ final class l
/*     */ {
/*  18 */   private static final Logger a = LoggerFactory.getLogger(l.class);
/*     */   
/*  20 */   private String domain = y.b.getUrl();
/*     */   
/*     */   private final b a;
/*     */   
/*     */   protected l() {
/*  25 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  31 */       .a = g.c().c(15000).b(180000).d(5).e(25).a(StandardCharsets.UTF_8).a();
/*     */   }
/*     */   
/*     */   protected l(b paramb) {
/*  35 */     this.a = paramb;
/*     */   }
/*     */   
/*     */   protected final void setDomain(String paramString) {
/*  39 */     this.domain = paramString;
/*     */   }
/*     */   
/*     */   final String getDomain() {
/*  43 */     return this.domain;
/*     */   }
/*     */   
/*     */   i f(String paramString) {
/*  47 */     return a(a(paramString, g.c()));
/*     */   }
/*     */   
/*     */   i a(String paramString, Map<String, String> paramMap) {
/*  51 */     f f = a(paramString, g.c());
/*  52 */     paramMap.forEach(f::b);
/*     */     
/*  54 */     return a(f);
/*     */   }
/*     */   
/*     */   i a(String paramString, File paramFile) {
/*  58 */     f f = a(paramString, g.f());
/*  59 */     f.a(paramFile);
/*     */     
/*  61 */     return a(f);
/*     */   }
/*     */   
/*     */   i a(String paramString, i parami) {
/*  65 */     f f = a(paramString, g.e());
/*  66 */     if (parami != null) {
/*  67 */       f.a(parami);
/*     */     }
/*     */     
/*  70 */     return a(f);
/*     */   }
/*     */   
/*     */   i a(String paramString, i parami, Map<String, String> paramMap) {
/*  74 */     f f = a(paramString, g.e());
/*  75 */     paramMap.forEach(f::b);
/*     */     
/*  77 */     if (parami != null) {
/*  78 */       f.a(parami);
/*     */     }
/*     */     
/*  81 */     return a(f);
/*     */   }
/*     */   
/*     */   private f a(String paramString, f paramf) {
/*  85 */     return paramf.a(this.domain).a(paramString);
/*     */   }
/*     */   
/*     */   private i a(f paramf) {
/*  89 */     if (c.a().f() != null) {
/*  90 */       paramf.b("Authorization", "Bearer " + c.a().f());
/*     */     }
/*     */     
/*  93 */     e e = this.a.a(paramf);
/*  94 */     int i = e.getStatusCode();
/*     */     
/*  96 */     if (i == 200) {
/*  97 */       String str = e.getData();
/*  98 */       return !str.isEmpty() ? new i(str) : new i();
/*     */     } 
/* 100 */     a.error("Status code inesperado {}", Integer.valueOf(i));
/* 101 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */