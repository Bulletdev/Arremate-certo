/*     */ package br.com.arremate.b.a.a;
/*     */ 
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.Calendar;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*     */   private final Document doc;
/*     */   private final Elements a;
/*     */   private final String description;
/*     */   private final String B;
/*     */   private String C;
/*     */   private String D;
/*     */   
/*     */   public static final f a(String paramString) throws Exception {
/*  24 */     return new f(Jsoup.parse(paramString));
/*     */   }
/*     */   
/*     */   private f(Document paramDocument) {
/*  28 */     this.doc = paramDocument;
/*  29 */     this.a = paramDocument.select("table[class=td] > tbody > tr");
/*  30 */     this.description = this.a.get(0).text().trim().toLowerCase();
/*  31 */     this.B = this.a.get(1).text().trim().replace("UASG: ", "");
/*     */   }
/*     */   
/*     */   int b() throws Exception {
/*  35 */     return Integer.parseInt(this.doc.select("input[name=cot_codigo]").attr("value"));
/*     */   }
/*     */   
/*     */   String h() throws Exception {
/*  39 */     return this.a.get(2).text().replaceAll("\\D", "");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Integer a() throws Exception {
/*  46 */     String str = this.B.substring(0, this.B.indexOf("-")).replaceAll("\\D", "");
/*  47 */     return Integer.valueOf(Integer.parseInt(str));
/*     */   }
/*     */   
/*     */   String i() throws Exception {
/*  51 */     return this.B.substring(this.B.indexOf("-") + 1).trim();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Calendar a() throws Exception {
/*  59 */     if (this.D == null) {
/*  60 */       d();
/*     */     }
/*     */     
/*  63 */     return a(this.D);
/*     */   }
/*     */   
/*     */   Calendar b() throws Exception {
/*  67 */     if (this.D == null) {
/*  68 */       d();
/*     */     }
/*     */     
/*  71 */     return b(this.D);
/*     */   }
/*     */   
/*     */   private void d() {
/*  75 */     this.D = this.a.get(9).text().replace("Período de lances: entre ", "").trim();
/*     */   }
/*     */ 
/*     */   
/*     */   Calendar c() throws Exception {
/*  80 */     if (this.C == null) {
/*  81 */       e();
/*     */     }
/*     */     
/*  84 */     return a(this.C);
/*     */   }
/*     */   
/*     */   Calendar d() throws Exception {
/*  88 */     if (this.C == null) {
/*  89 */       e();
/*     */     }
/*     */     
/*  92 */     return b(this.C);
/*     */   }
/*     */   
/*     */   private void e() {
/*  96 */     this
/*  97 */       .C = this.a.get(8).text().replace("Período de propostas e lances: entre", "").replace("(Após esse horário, há um período aleatório de 1 a 30 min sob aviso de iminência)", " ").trim();
/*     */   }
/*     */ 
/*     */   
/*     */   private Calendar a(String paramString) throws Exception {
/* 102 */     String str = paramString.substring(0, paramString.indexOf("e")).trim().replace("h", ":");
/* 103 */     return y.c(str);
/*     */   }
/*     */ 
/*     */   
/*     */   private Calendar b(String paramString) throws Exception {
/* 108 */     String str = paramString.substring(paramString.indexOf("e") + 1).trim();
/* 109 */     str = str.replace("h", ":");
/* 110 */     return y.c(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean i() throws Exception {
/* 118 */     return this.description.contains("dispensa eletrônica");
/*     */   }
/*     */   
/*     */   boolean j() throws Exception {
/* 122 */     return this.description.contains("cotação eletrônica");
/*     */   }
/*     */   
/*     */   boolean k() throws Exception {
/* 126 */     return this.description.contains("icms");
/*     */   }
/*     */   
/*     */   boolean l() throws Exception {
/* 130 */     return this.a.get(7).select("span").text().trim().contains("Em Andamento");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */