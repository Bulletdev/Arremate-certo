/*    */ package br.com.arremate.j.l.a;
/*    */ 
/*    */ import br.com.arremate.l.d;
/*    */ import br.com.arremate.m.y;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/* 19 */   private static final String dc = y.ac(d.DOMAIN + "consultaPregoesLances_linhaPregao.html");
/* 20 */   private static final String dd = y.ac(d.DOMAIN + "consultaPregoesAgendados_linhaPregao.html");
/*    */   
/*    */   private final int code;
/*    */   
/*    */   private final String de;
/*    */   
/*    */   private final int aF;
/*    */   private final String df;
/*    */   private final Date a;
/*    */   private final boolean C;
/*    */   private final boolean D;
/*    */   private final List<c> s;
/*    */   
/*    */   public a(d paramd, int paramInt1, String paramString1, int paramInt2, String paramString2, Date paramDate, boolean paramBoolean1, boolean paramBoolean2) {
/* 34 */     this.code = paramInt1;
/* 35 */     this.de = paramString1;
/* 36 */     this.aF = paramInt2;
/* 37 */     this.df = paramString2;
/* 38 */     this.a = paramDate;
/* 39 */     this.C = paramBoolean1;
/* 40 */     this.D = paramBoolean2;
/* 41 */     this.s = new ArrayList<>();
/*    */   }
/*    */   
/*    */   public void a(c paramc) {
/* 45 */     this.s.add(paramc);
/*    */   }
/*    */   
/*    */   public String aK() {
/* 49 */     if (this.a.getTime() > System.currentTimeMillis()) {
/* 50 */       return "";
/*    */     }
/*    */     
/* 53 */     String str = dc.replace("##NUMERO##", this.de);
/* 54 */     str = str.replaceAll("##CODIGO##", Integer.toString(this.code));
/* 55 */     str = str.replace("##UASG_CODIGO##", Integer.toString(this.aF));
/* 56 */     str = str.replace("##UASG##", this.df);
/* 57 */     str = str.replace("##DATA##", y.formatDate(this.a, "dd/MM/YYYY HH:mm"));
/* 58 */     str = str.replace("##SRP##", aM());
/* 59 */     str = str.replace("##ICMS##", aN());
/* 60 */     return str;
/*    */   }
/*    */   
/*    */   public String aL() {
/* 64 */     if (this.a.getTime() <= System.currentTimeMillis()) {
/* 65 */       return "";
/*    */     }
/*    */     
/* 68 */     String str = dd.replace("##NUMERO##", this.de);
/* 69 */     str = str.replace("##CODIGO##", Integer.toString(this.code));
/* 70 */     str = str.replace("##UASG_CODIGO##", Integer.toString(this.aF));
/* 71 */     str = str.replace("##UASG##", this.df);
/* 72 */     str = str.replace("##DATA##", y.formatDate(this.a, "dd/MM/YYYY HH:mm"));
/* 73 */     str = str.replace("##SRP##", aM());
/* 74 */     str = str.replace("##ICMS##", aN());
/* 75 */     return str;
/*    */   }
/*    */   
/*    */   private String aM() {
/* 79 */     return this.C ? "Sim" : "Não";
/*    */   }
/*    */   
/*    */   private String aN() {
/* 83 */     return this.D ? "Sim" : "Não";
/*    */   }
/*    */   
/*    */   public int getCode() {
/* 87 */     return this.code;
/*    */   }
/*    */   
/*    */   public Date a() {
/* 91 */     return this.a;
/*    */   }
/*    */   
/*    */   public List<c> w() {
/* 95 */     return this.s;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\l\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */