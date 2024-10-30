/*    */ package br.com.arremate.a;
/*    */ 
/*    */ import br.com.arremate.f.b;
/*    */ import br.com.arremate.h.g;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.e.i;
/*    */ 
/*    */ public class f
/*    */ {
/* 12 */   private static final f a = new f();
/*    */   
/*    */   private final l a;
/*    */   
/*    */   public static f a() {
/* 17 */     return (f)a;
/*    */   }
/*    */   
/*    */   private f() {
/* 21 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 27 */       .a = new l(g.c().c(15000).b(180000).d(200).e(300).a(StandardCharsets.UTF_8).a());
/*    */   }
/*    */   
/*    */   public i b(String paramString) {
/* 31 */     i i = (new i()).c("portal", paramString);
/* 32 */     return this.a.a("v1/captcha/portal-anchor", i, a());
/*    */   }
/*    */   
/*    */   i a(i parami, b paramb) {
/* 36 */     String str = "v1/captcha/" + paramb.getDescription();
/* 37 */     return this.a.a(str, parami, a());
/*    */   }
/*    */   
/*    */   i c(String paramString) {
/* 41 */     String str = "v1/captcha/report/" + paramString;
/* 42 */     return this.a.a(str, new i(), a());
/*    */   }
/*    */   
/*    */   private Map<String, String> a() {
/* 46 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 47 */     hashMap.put("Content-Type", "application/json");
/* 48 */     hashMap.put("From", "arremate");
/*    */     
/* 50 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */