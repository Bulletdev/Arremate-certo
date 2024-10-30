/*    */ package br.com.arremate.l;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.util.EntityUtils;
/*    */ import org.e.i;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class l
/*    */ {
/* 18 */   private static final Logger a = LoggerFactory.getLogger(l.class);
/*    */   
/*    */   private final int status;
/*    */   
/*    */   private final String message;
/*    */   
/*    */   private final i k;
/*    */ 
/*    */   
/*    */   public l() {
/* 28 */     this.status = 500;
/* 29 */     this.message = "Não foi possível enviar a requisição";
/* 30 */     this.k = new i();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public l(int paramInt, i parami) {
/* 40 */     this.status = paramInt;
/* 41 */     this.k = new i(parami);
/* 42 */     this.message = this.k.has("message") ? this.k.getString("message") : "";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public l(HttpEntity paramHttpEntity, int paramInt) throws IOException {
/* 53 */     this.status = paramInt;
/*    */     
/* 55 */     if (bj()) {
/* 56 */       String str = EntityUtils.toString(paramHttpEntity);
/* 57 */       this.k = new i(str);
/* 58 */       this.message = this.k.has("message") ? this.k.getString("message") : "";
/*    */     } else {
/* 60 */       this.k = new i();
/* 61 */       this.message = "";
/* 62 */       a.warn("{} - MDW Response", Integer.valueOf(this.status));
/*    */     } 
/*    */   }
/*    */   
/*    */   public int getStatus() {
/* 67 */     return this.status;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 71 */     return this.message;
/*    */   }
/*    */   
/*    */   public i r() {
/* 75 */     return this.k;
/*    */   }
/*    */   
/*    */   public boolean bj() {
/* 79 */     return (this.status == 200);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */