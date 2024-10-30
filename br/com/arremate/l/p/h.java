/*    */ package br.com.arremate.l.p;
/*    */ 
/*    */ import br.com.arremate.n.n;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.e.i;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class h
/*    */ {
/*    */   private final int ai;
/*    */   private final boolean ah;
/*    */   private String E;
/*    */   private Date b;
/*    */   private boolean ai;
/*    */   
/*    */   protected h(int paramInt, boolean paramBoolean) {
/* 21 */     this.ai = paramInt;
/* 22 */     this.ah = paramBoolean;
/* 23 */     this.ai = false;
/*    */     
/* 25 */     this.b = n.i().getTime();
/*    */   }
/*    */   
/*    */   public String ci() {
/* 29 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
/*    */     
/* 31 */     return simpleDateFormat.format(b());
/*    */   }
/*    */   
/*    */   public String j() {
/* 35 */     return this.E;
/*    */   }
/*    */   
/*    */   public void f(String paramString) {
/* 39 */     this.E = paramString;
/*    */   }
/*    */   
/*    */   public Date b() {
/* 43 */     return this.b;
/*    */   }
/*    */   
/*    */   public void c(Date paramDate) {
/* 47 */     this.b = paramDate;
/*    */   }
/*    */   
/*    */   public int w() {
/* 51 */     return this.ai;
/*    */   }
/*    */   
/*    */   public boolean bp() {
/* 55 */     return this.ah;
/*    */   }
/*    */   
/*    */   public boolean bq() {
/* 59 */     return this.ai;
/*    */   }
/*    */   
/*    */   public void N(boolean paramBoolean) {
/* 63 */     this.ai = paramBoolean;
/*    */   }
/*    */   
/*    */   public i q() {
/* 67 */     i i = new i();
/*    */     
/* 69 */     i.a("tipo", w());
/* 70 */     i.c("data", ci());
/* 71 */     i.c("mensagem", j());
/*    */     
/* 73 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */