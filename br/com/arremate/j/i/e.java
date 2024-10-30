/*    */ package br.com.arremate.j.i;
/*    */ 
/*    */ import org.e.f;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/*    */   public static final String bu = "CONNECTED";
/*    */   public static final String bv = "MESSAGE";
/*    */   public static final String bw = "ERROR";
/*    */   public static final String cF = "SUBSCRIBE";
/*    */   public static final String cG = "h";
/*    */   public static final String cH = "o";
/*    */   private final String content;
/*    */   private String type;
/*    */   private i i;
/*    */   private boolean B;
/*    */   
/*    */   public e(String paramString) {
/* 21 */     this.content = paramString;
/* 22 */     this.B = false;
/* 23 */     bT();
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 27 */     return this.content;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 31 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String paramString) {
/* 35 */     this.type = paramString;
/*    */   }
/*    */   
/*    */   public i m() {
/* 39 */     return this.i;
/*    */   }
/*    */   
/*    */   public boolean ag() {
/* 43 */     return this.B;
/*    */   }
/*    */   
/*    */   public void l(boolean paramBoolean) {
/* 47 */     this.B = paramBoolean;
/*    */   }
/*    */   
/*    */   public void g(i parami) {
/* 51 */     this.i = parami;
/*    */   }
/*    */   
/*    */   private void bT() {
/* 55 */     if (this.content.contains("CONNECTED")) {
/* 56 */       setType("CONNECTED");
/* 57 */       g((new i())
/* 58 */           .b("connected", true));
/* 59 */     } else if (this.content.contains("MESSAGE")) {
/* 60 */       setType("MESSAGE");
/* 61 */       f f = new f();
/* 62 */       if (this.content.contains("numeroLicitacao")) {
/* 63 */         int j = this.content.indexOf("[{\\\"numeroLicitacao");
/* 64 */         int k = this.content.indexOf("\\u0000");
/* 65 */         String str = this.content.substring(j, k);
/* 66 */         f = new f(str.replaceAll("\\\\\"", "\""));
/*    */         
/* 68 */         l(true);
/* 69 */       } else if (this.content.contains("conteudoVazio")) {
/* 70 */         l(true);
/*    */       } 
/*    */       
/* 73 */       g((new i())
/* 74 */           .b("connected", true)
/* 75 */           .c("message", f));
/* 76 */     } else if (this.content.contains("ERROR")) {
/* 77 */       setType("ERROR");
/* 78 */       g((new i())
/* 79 */           .b("connected", false)
/* 80 */           .c("message", this.content));
/*    */     } else {
/* 82 */       setType(this.content);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     return (new i())
/* 89 */       .c("type", getType())
/* 90 */       .c("message", m())
/* 91 */       .b("dispatch", ag())
/* 92 */       .toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\i\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */