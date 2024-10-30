/*    */ package br.com.arremate.a.a;
/*    */ 
/*    */ import org.apache.commons.codec.binary.Base64;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class c
/*    */ {
/* 10 */   protected static final Logger a = LoggerFactory.getLogger(c.class);
/*    */   
/* 12 */   private static final c a = new c();
/*    */   
/*    */   private String z;
/*    */   private int code;
/*    */   private String user;
/*    */   private String A;
/*    */   private String v;
/*    */   private String w;
/*    */   private boolean d;
/*    */   
/*    */   public static c a() {
/* 23 */     return a;
/*    */   }
/*    */   
/*    */   public String f() {
/* 27 */     return this.z;
/*    */   }
/*    */   
/*    */   public void b(String paramString) {
/* 31 */     this.z = paramString;
/*    */     
/*    */     try {
/* 34 */       String[] arrayOfString = this.z.split("\\.");
/* 35 */       String str = new String(Base64.decodeBase64(arrayOfString[1]));
/* 36 */       i i = new i(str);
/* 37 */       this.code = i.j("account").getInt("company");
/* 38 */     } catch (RuntimeException runtimeException) {
/* 39 */       a.warn("Failed jwt");
/*    */     } 
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 44 */     return this.code;
/*    */   }
/*    */   
/*    */   public String getUser() {
/* 48 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(String paramString) {
/* 52 */     this.user = paramString;
/*    */   }
/*    */   
/*    */   public String g() {
/* 56 */     return this.A;
/*    */   }
/*    */   
/*    */   public void c(String paramString) {
/* 60 */     this.A = paramString;
/*    */   }
/*    */   
/*    */   public String d() {
/* 64 */     return this.v;
/*    */   }
/*    */   
/*    */   public void d(String paramString) {
/* 68 */     this.v = paramString;
/*    */   }
/*    */   
/*    */   public String e() {
/* 72 */     return this.w;
/*    */   }
/*    */   
/*    */   public void e(String paramString) {
/* 76 */     this.w = paramString;
/*    */   }
/*    */   
/*    */   public boolean f() {
/* 80 */     return this.d;
/*    */   }
/*    */   
/*    */   public void a(boolean paramBoolean) {
/* 84 */     this.d = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */