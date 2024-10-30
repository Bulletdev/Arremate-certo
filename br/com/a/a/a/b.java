/*     */ package br.com.a.a.a;
/*     */ 
/*     */ import br.com.a.b.a.a;
/*     */ import br.com.a.b.c.a;
/*     */ import br.com.a.b.d.a;
/*     */ import br.com.a.c.c;
/*     */ import br.com.a.d.a.c;
/*     */ import br.com.a.d.a.d;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class b
/*     */   extends a
/*     */ {
/*  16 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   private final br.com.a.c.b a;
/*     */   
/*     */   private String fO;
/*     */ 
/*     */   
/*     */   public b() {
/*  24 */     this((br.com.a.c.b)new a());
/*     */   }
/*     */   
/*     */   public b(br.com.a.c.b paramb) {
/*  28 */     this.a = paramb;
/*  29 */     this.a = (br.com.a.c.b)new a();
/*  30 */     this.a = (br.com.a.c.b)new a((c)this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void ef() throws d, c {
/*  35 */     eg();
/*  36 */     eh();
/*  37 */     ei();
/*  38 */     ej();
/*  39 */     ek();
/*     */   }
/*     */   
/*     */   private void eg() throws d, c {
/*  43 */     this.fO = this.a.get(this.a.cP());
/*  44 */     if (this.fO.contains("Por favor, verifique se a sua autoriza")) {
/*  45 */       throw new c("expired login");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void eh() throws d, c {
/*  51 */     if (this.fO.contains("'sitekey'")) {
/*  52 */       a.b b1 = new a.b(this, this.fO);
/*  53 */       String str1 = b1.cF();
/*  54 */       String str2 = b1.a();
/*     */ 
/*     */ 
/*     */       
/*  58 */       String str3 = d(this.fO, "'sitekey'", "\n").replace("'", "").replace(":", "").trim();
/*  59 */       String str4 = this.a.h(str3, this.a.cP());
/*  60 */       this.a.b(this.a.cU(), a.a.a(str1, str2, str4));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  65 */       if (this.a.getStatusCode() != 200) {
/*  66 */         this.a.ah();
/*  67 */         a.error("Failed on solve portal captcha login {}", Integer.valueOf(this.a.getStatusCode()));
/*  68 */         throw new d("Falha ao resolver captcha do login");
/*     */       } 
/*  70 */       eg();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ei() throws d {
/*  75 */     this.a.get(this.a.cQ());
/*  76 */     if (this.a.getStatusCode() != 200) {
/*  77 */       a.error("Failed on portal access home {}", Integer.valueOf(this.a.getStatusCode()));
/*  78 */       throw new d("Falha ao acessar o portal");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ej() throws d {
/*  83 */     this.a.get(this.a.cS());
/*  84 */     this
/*  85 */       .authorization = d(this.a.cG(), "#?autorizacao=", "$").replaceAll("[^0-9]", "");
/*     */   }
/*     */   
/*     */   private void ek() throws d, c {
/*  89 */     i i = new i();
/*  90 */     i.b("atualizarListaLicitacoes", true);
/*  91 */     i.c("autorizacao", this.authorization);
/*  92 */     i.c("class", "br.com.bb.aop.sala.base.SalaDisputaRequisicao");
/*  93 */     i.a("codigoComando", 0);
/*  94 */     i.c("comunicados", i.NULL);
/*  95 */     i.c("disputas", i.NULL);
/*  96 */     i.b("ignoreLoadingBar", false);
/*  97 */     i.c("salaDisputaLotePK", i.NULL);
/*  98 */     i.c("textoAutorizacaoLance", i.NULL);
/*  99 */     i.c("textoDesafio", i.NULL);
/* 100 */     i.c("textoMensagem", i.NULL);
/* 101 */     i.c("textoValorLance", i.NULL);
/* 102 */     this.a.a(this.a.cT(), i);
/* 103 */     if (this.a.getStatusCode() != 200) {
/* 104 */       a.error("Failed on validate user access from page {}", Integer.valueOf(this.a.getStatusCode()));
/* 105 */       throw new c();
/*     */     } 
/*     */   }
/*     */   
/*     */   private String d(String paramString1, String paramString2, String paramString3) {
/*     */     try {
/* 111 */       paramString1 = "#" + paramString1.trim() + "$";
/* 112 */       int i = paramString1.indexOf(paramString2);
/* 113 */       int j = paramString1.indexOf(paramString3, i + 1);
/* 114 */       paramString1 = paramString1.substring(i + paramString2.length(), j);
/* 115 */       return paramString1.trim();
/* 116 */     } catch (Exception exception) {
/* 117 */       exception.printStackTrace();
/*     */       
/* 119 */       return "";
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\a\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */