/*    */ package br.com.arremate.h;
/*    */ 
/*    */ import br.com.arremate.j.i;
/*    */ import java.util.List;
/*    */ import org.apache.http.cookie.Cookie;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class h
/*    */   implements b
/*    */ {
/* 15 */   protected static final Logger a = LoggerFactory.getLogger(h.class);
/*    */   
/*    */   private final i a;
/*    */   private final b b;
/*    */   private final a a;
/*    */   
/*    */   h(i parami, b paramb, a parama) {
/* 22 */     this.a = (a)parami;
/* 23 */     this.b = paramb;
/* 24 */     this.a = parama;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public e a(f paramf) {
/* 32 */     int j = this.a.B();
/* 33 */     e e = this.b.a(paramf);
/*    */     
/* 35 */     if (e.P()) {
/* 36 */       this.a.bZ();
/* 37 */       this.a.ca();
/* 38 */       return e;
/*    */     } 
/*    */     
/* 41 */     if (paramf.S()) {
/* 42 */       return e;
/*    */     }
/*    */     
/*    */     try {
/* 46 */       if (this.a.lockRequestsBySessionControl(e)) {
/* 47 */         this.a.N(j);
/* 48 */         e.setData("");
/*    */       } 
/* 50 */     } catch (Exception exception) {
/* 51 */       a.warn("Failed to precess response", exception);
/*    */     } 
/*    */     
/* 54 */     return e;
/*    */   }
/*    */ 
/*    */   
/*    */   public void b() {
/* 59 */     this.b.b();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Cookie> getCookies() {
/* 64 */     return this.b.getCookies();
/*    */   }
/*    */ 
/*    */   
/*    */   public String P() {
/* 69 */     return this.b.P();
/*    */   }
/*    */ 
/*    */   
/*    */   public void bB() {
/* 74 */     this.b.bB();
/*    */   }
/*    */ 
/*    */   
/*    */   public void addCookie(Cookie paramCookie) {
/* 79 */     this.b.addCookie(paramCookie);
/*    */   }
/*    */ 
/*    */   
/*    */   public void bC() {
/* 84 */     this.b.bC();
/*    */   }
/*    */ 
/*    */   
/*    */   public void bD() {
/* 89 */     this.b.bD();
/*    */   }
/*    */   
/*    */   public static interface a {
/*    */     boolean lockRequestsBySessionControl(e param1e) throws Exception;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */