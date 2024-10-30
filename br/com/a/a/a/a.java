/*     */ package br.com.a.a.a;
/*     */ 
/*     */ import br.com.a.c.a;
/*     */ import br.com.a.c.c;
/*     */ import br.com.a.d.a.c;
/*     */ import br.com.a.d.a.d;
/*     */ import br.com.a.d.a.e;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends d
/*     */   implements a
/*     */ {
/*  24 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private String user;
/*     */   private String password;
/*     */   
/*     */   public a() {
/*  30 */     this.a = (Logger)new br.com.a.b.c.b();
/*  31 */     this.a = (Logger)new br.com.a.b.d.a((c)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public i f(String paramString1, String paramString2) throws e, d, br.com.a.d.a.b, c {
/*  37 */     this.user = paramString1;
/*  38 */     this.password = paramString2;
/*     */     
/*  40 */     el();
/*  41 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void eb() throws e, d, br.com.a.d.a.b, c {
/*  47 */     ep();
/*  48 */     ec();
/*  49 */     ed();
/*  50 */     ee();
/*  51 */     ef();
/*     */   }
/*     */   
/*     */   private void ec() throws d, br.com.a.d.a.b {
/*  55 */     this.a.b(this.a.cJ(), a.a(this.a
/*  56 */           .cX(), this.a
/*  57 */           .cY()));
/*     */     
/*  59 */     if (this.a.getStatusCode() != 200) {
/*  60 */       a.error("Failed on validate portal keys {}", Integer.valueOf(this.a.getStatusCode()));
/*  61 */       throw new br.com.a.d.a.b("Falha ao validar as chaves de acesso no portal");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void ed() throws d, c, br.com.a.d.a.b {
/*  67 */     String str = this.a.get(this.a.cO());
/*  68 */     if (this.a.getStatusCode() != 200) {
/*  69 */       a.error("Failed on request password cipher key {}", Integer.valueOf(this.a.getStatusCode()));
/*  70 */       throw new d("Falha ao requisitar a chave de criptografia de senha");
/*     */     } 
/*  72 */     this.a.b(this.a.cN(), a.b(this.user, 
/*     */           
/*  74 */           l(str, this.password)));
/*     */     
/*  76 */     if (this.a.getStatusCode() != 200) {
/*  77 */       a.error("Failed on make user login from portal {}", Integer.valueOf(this.a.getStatusCode()));
/*  78 */       if (this.a.cH() != null && (
/*  79 */         this.a.cH().toLowerCase().contains("senha invalida") || this.a
/*  80 */         .cH().toLowerCase().contains("senha bloqueada"))) {
/*  81 */         throw new c("invalid login");
/*     */       }
/*     */       
/*  84 */       throw new br.com.a.d.a.b("Error on execute login. Response body " + this.a
/*  85 */           .cH());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String l(String paramString1, String paramString2) {
/*     */     try {
/*  92 */       this.a.a().eval("var encrypt = new JSEncrypt();");
/*  93 */       this.a.a().eval("encrypt.setPublicKey('-----BEGIN PUBLIC KEY-----" + paramString1 + "-----END PUBLIC KEY-----');");
/*     */       
/*  95 */       this.a.a().eval("var passwd = encrypt.encrypt('" + paramString2 + "');");
/*  96 */       paramString2 = (String)this.a.a().get("passwd");
/*  97 */     } catch (Exception exception) {
/*  98 */       a.error("Failed in encode user password", exception);
/*     */     } 
/* 100 */     return paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   private void ee() throws d {
/* 105 */     this.a.get(this.a.cK());
/* 106 */     this.a.get(this.a.cL());
/*     */   }
/*     */   
/*     */   protected void ef() throws d, c {
/* 110 */     eg();
/* 111 */     String str = this.a.get(this.a.cQ());
/* 112 */     if (this.a.getStatusCode() != 200) {
/* 113 */       a.error("Failed on portal access home {}", Integer.valueOf(this.a.getStatusCode()));
/* 114 */       throw new d("Falha ao acessar o portal");
/*     */     } 
/* 116 */     b b = new b(this, str);
/* 117 */     if (!str.toLowerCase().contains(this.user.toLowerCase())) {
/* 118 */       if (b.cj()) {
/* 119 */         String str1 = b.cE();
/* 120 */         if (str1.contains("usuário sem senha") || str1
/* 121 */           .contains("inválida") || str1
/* 122 */           .contains("usuário não cadastrado") || str1
/* 123 */           .contains("usuario nao localizado") || str1
/* 124 */           .contains("senha bloqueada") || str1
/* 125 */           .contains("deve possuir 8 caracteres")) {
/* 126 */           a.error("Failed on validate user login {}", str1);
/* 127 */           throw new c(str1);
/*     */         } 
/*     */       } 
/* 130 */       throw new c();
/*     */     } 
/* 132 */     if (str.contains("o cliente não possui representantes cadastrados") || str
/* 133 */       .contains("representante do cliente não possui uma autorização vigente")) {
/* 134 */       a.error("The current user does not have a representation");
/* 135 */       throw new c("O usuário não possui representantes cadastrados");
/*     */     } 
/* 137 */     if (str.contains("por favor, verifique se a sua autorização")) {
/* 138 */       a.error("The current user does not have a valida authorization");
/* 139 */       throw new c("Verifique se a sua autorização de acesso e o seu periodo de representação encontra-se vigente");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void eg() throws d, c {
/* 145 */     String str = this.a.get(this.a.cP());
/* 146 */     if (str.contains("Por favor, verifique se a sua autoriza")) {
/* 147 */       throw new c("expired login");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/*     */     public static NameValuePair[] a(String param1String1, String param1String2) {
/* 161 */       return new NameValuePair[] { (NameValuePair)new BasicNameValuePair("info", param1String1), (NameValuePair)new BasicNameValuePair("f10", param1String2), (NameValuePair)new BasicNameValuePair("urlRetorno", "") };
/*     */     }
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
/*     */     public static NameValuePair[] b(String param1String1, String param1String2) {
/* 177 */       return new NameValuePair[] { (NameValuePair)new BasicNameValuePair("chave", param1String1
/* 178 */             .replace("j", "J")), (NameValuePair)new BasicNameValuePair("senha", param1String2) };
/*     */     }
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
/*     */     public static NameValuePair[] a(String param1String1, String param1String2, String param1String3) {
/* 193 */       return new NameValuePair[] { (NameValuePair)new BasicNameValuePair("idAutorizacaoSelecionada", param1String1), (NameValuePair)new BasicNameValuePair("g-recaptcha-response", param1String3), (NameValuePair)new BasicNameValuePair("method:autorizar", "representar"), (NameValuePair)new BasicNameValuePair("struts.token.name", "token"), (NameValuePair)new BasicNameValuePair("token", param1String2) };
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class b
/*     */   {
/*     */     private final Document a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b(a this$0, String param1String) {
/* 209 */       this.a = (a)Jsoup.parse(param1String);
/*     */     }
/*     */     
/*     */     public boolean cj() {
/* 213 */       return !this.a.select("#msgErro > ul > span:not(:contains(.ng-hide)) > li").isEmpty();
/*     */     }
/*     */     
/*     */     public String cE() {
/* 217 */       return this.a.select("#msgErro").text().toLowerCase();
/*     */     }
/*     */     
/*     */     public String cF() {
/* 221 */       Element element = this.a.getElementById("autorizar_idAutorizacaoSelecionada");
/* 222 */       if (element != null) {
/* 223 */         return element.select("option").first().val();
/*     */       }
/* 225 */       return null;
/*     */     }
/*     */     
/*     */     public String a() {
/* 229 */       Elements elements = this.a.getElementsByAttributeValue("name", "token");
/* 230 */       if (!elements.isEmpty()) {
/* 231 */         return elements.val();
/*     */       }
/* 233 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\a\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */