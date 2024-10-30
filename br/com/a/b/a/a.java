/*    */ package br.com.a.b.a;
/*    */ 
/*    */ import br.com.a.c.b;
/*    */ import br.com.a.d.a.d;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class a
/*    */   implements b
/*    */ {
/* 12 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 18 */   private String id = "";
/* 19 */   private final br.com.a.b.b.a a = new br.com.a.b.b.a();
/*    */   
/*    */   private static final String fP = "https://captcha.effecti.com.br";
/*    */   
/*    */   public String h(String paramString1, String paramString2) throws d {
/* 24 */     String str1 = "";
/* 25 */     String str2 = this.a.a("https://captcha.effecti.com.br".concat("/v1/captcha/recaptchav2"), (new i())
/*    */         
/* 27 */         .c("siteKey", paramString1)
/* 28 */         .c("url", paramString2));
/*    */     
/* 30 */     i i = new i(str2);
/* 31 */     if (i.has("success") && i.getBoolean("success")) {
/* 32 */       this.id = i.getString("id");
/* 33 */       str1 = i.getString("result");
/*    */     } else {
/* 35 */       a.error("Error on solve recaptcha v2 {}", str2);
/*    */     } 
/* 37 */     return str1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean ah() throws d {
/* 42 */     boolean bool = false;
/* 43 */     String str = this.a.ae("https://captcha.effecti.com.br".concat("/v1/captcha/report/" + this.id));
/* 44 */     i i = new i(str);
/* 45 */     if (i.has("success")) {
/* 46 */       bool = i.getBoolean("success");
/*    */     } else {
/* 48 */       a.error("Error on report captcha error {}", str);
/*    */     } 
/* 50 */     return bool;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\b\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */