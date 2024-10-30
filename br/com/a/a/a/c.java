/*     */ package br.com.a.a.a;
/*     */ 
/*     */ import br.com.a.c.a;
/*     */ import br.com.a.d.a.b;
/*     */ import br.com.a.d.a.d;
/*     */ import br.com.a.d.a.e;
/*     */ import java.util.Random;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends d
/*     */   implements a
/*     */ {
/*  22 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   private String user;
/*     */   private String password;
/*     */   
/*     */   public c() {
/*  28 */     this.a = (Logger)new br.com.a.b.c.c();
/*  29 */     this.a = (Logger)new br.com.a.b.d.a((br.com.a.c.c)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public i f(String paramString1, String paramString2) throws e, d, b, br.com.a.d.a.c {
/*  35 */     this.user = paramString1;
/*  36 */     this.password = paramString2;
/*     */     
/*  38 */     el();
/*  39 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void eb() throws e, d, b, br.com.a.d.a.c {
/*  45 */     ep();
/*  46 */     ec();
/*  47 */     ed();
/*  48 */     ef();
/*     */   }
/*     */   
/*     */   private void ec() throws d, b {
/*  52 */     this.a.b(this.a.cJ(), a.b(this.a
/*  53 */           .cX(), this.a
/*  54 */           .cY(), this.a
/*  55 */           .cW()));
/*     */     
/*  57 */     if (this.a.getStatusCode() != 200) {
/*  58 */       a.error("Failed on validate portal keys {}", Integer.valueOf(this.a.getStatusCode()));
/*  59 */       throw new b("Falha ao validar as chaves de acesso no portal");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ed() throws d, br.com.a.d.a.c, b {
/*  64 */     this.a.a(this.a.cN(), a.c(this.user, this.password, 
/*     */ 
/*     */           
/*  67 */           o(32)));
/*     */     
/*  69 */     if (this.a.getStatusCode() != 200) {
/*  70 */       a.error("Failed on make user login from portal {}", Integer.valueOf(this.a.getStatusCode()));
/*  71 */       String str = this.a.cH();
/*  72 */       if (str != null) {
/*  73 */         str = str.toLowerCase();
/*     */         
/*  75 */         if (str.contains("identificador e/ou senha inválidos") || str
/*  76 */           .contains("senha bloqueada")) {
/*  77 */           throw new br.com.a.d.a.c("invalid login");
/*     */         }
/*     */       } 
/*  80 */       throw new b("Error on execute login. Response body " + this.a
/*  81 */           .cH());
/*     */     } 
/*     */   }
/*     */   
/*     */   private String o(int paramInt) {
/*  86 */     byte b = 8;
/*  87 */     int i = (int)Math.pow(16.0D, (Math.min(paramInt, b) - 1));
/*  88 */     int j = (int)(Math.pow(16.0D, Math.min(paramInt, b)) - 1.0D);
/*     */     
/*  90 */     Random random = new Random();
/*  91 */     int k = random.nextInt(j - i + 1) + i;
/*  92 */     String str = Integer.toHexString(k);
/*     */     
/*  94 */     while (str.length() < paramInt) {
/*  95 */       str = str + o(paramInt - b);
/*     */     }
/*     */     
/*  98 */     return str;
/*     */   }
/*     */   
/*     */   private void ef() throws d, br.com.a.d.a.c {
/* 102 */     String str1 = this.a.get(this.a.cR());
/* 103 */     if (this.a.getStatusCode() != 200) {
/* 104 */       a.error("Failed to load user authorization {}", Integer.valueOf(this.a.getStatusCode()));
/* 105 */       i i = new i(this.a.cH());
/* 106 */       if (i.has("msg")) {
/* 107 */         throw new br.com.a.d.a.c(i.getString("msg"));
/*     */       }
/* 109 */       throw new br.com.a.d.a.c(i.getString("Error on execute login. Response body " + this.a
/* 110 */             .cH()));
/*     */     } 
/* 112 */     i i1 = new i(str1);
/* 113 */     if (!i1.has("data")) {
/* 114 */       throw new br.com.a.d.a.c("Error get user authorization data");
/*     */     }
/* 116 */     if (!i1.j("data").has("autorizacoes")) {
/* 117 */       throw new br.com.a.d.a.c("Error get user authorizations");
/*     */     }
/* 119 */     f f = i1.j("data").c("autorizacoes");
/* 120 */     if (f.isEmpty()) {
/* 121 */       throw new br.com.a.d.a.c("Credential without any authorization registered on the portal");
/*     */     }
/*     */     
/* 124 */     i i2 = f.b(0);
/* 125 */     String str2 = this.a.a(this.a.cP(), a.a(i2
/* 126 */           .getInt("codigoUnidadeOrganizacional"), i2
/* 127 */           .getInt("numeroAutorizacaoRepresentante"), i2
/* 128 */           .getInt("numeroTipoPerfil")));
/*     */     
/* 130 */     if (this.a.getStatusCode() != 200) {
/* 131 */       a.error("Failed to load user data {}", Integer.valueOf(this.a.getStatusCode()));
/* 132 */       throw new br.com.a.d.a.c("Failed to load user data. Response body " + this.a
/* 133 */           .cH());
/*     */     } 
/* 135 */     i i3 = new i(str2);
/* 136 */     if (!i3.has("data") && !i3.j("data").has("token")) {
/* 137 */       throw new br.com.a.d.a.c("Failed to load user token");
/*     */     }
/* 139 */     i i4 = i3.j("data");
/* 140 */     this.authorization = i4.getString("token");
/* 141 */     this.aE = i4.j("dadosDoUsuario").getInt("codigoCliente");
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
/*     */   static class a
/*     */   {
/*     */     public static NameValuePair[] b(String param1String1, String param1String2, String param1String3) {
/* 155 */       return new NameValuePair[] { (NameValuePair)new BasicNameValuePair("info", param1String1), (NameValuePair)new BasicNameValuePair("f10", param1String2), (NameValuePair)new BasicNameValuePair("randomId", param1String3), (NameValuePair)new BasicNameValuePair("urlRetorno", "") };
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
/*     */     
/*     */     public static i c(String param1String1, String param1String2, String param1String3) {
/* 172 */       return (new i())
/* 173 */         .b("checked", true)
/* 174 */         .c("identificador", param1String1.replace("j", "J"))
/* 175 */         .c("senha", param1String2)
/* 176 */         .c("tipoIdentificador", "usuario-pj")
/* 177 */         .c("tipoSenha", "usuario-pj")
/* 178 */         .c("sessionId", param1String3);
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
/*     */     public static i a(int param1Int1, int param1Int2, int param1Int3) {
/* 191 */       return (new i())
/* 192 */         .a("codigoUnidadeOrganizacional", param1Int1)
/* 193 */         .a("numeroAutorizacaoRepresentante", param1Int2)
/* 194 */         .a("numeroTipoPerfil", param1Int3);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\a\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */