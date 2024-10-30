/*     */ package br.com.arremate.d.h;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends c
/*     */ {
/*     */   private final a a;
/*     */   
/*     */   public d(e parame, a parama, e parame1) {
/*  29 */     super(parame, parama, parame1);
/*     */     
/*  31 */     this.a = new a(this, false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  36 */     return this.a.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String w() {
/*  41 */     String str = super.w();
/*     */     
/*  43 */     if (str.equals("Encerramento da fase de lances fechados")) {
/*  44 */       if (a().z() > 0L) {
/*  45 */         Element element1 = a().select("td[class=td120]").first();
/*  46 */         Element element2 = element1.select("a[title=Enviar Lance Fechado]").first();
/*  47 */         if (a().aS()) {
/*  48 */           str = g.i.getValue();
/*  49 */         } else if (element2 != null) {
/*  50 */           str = g.h.getValue();
/*  51 */           a().v(true);
/*  52 */         } else if (element2 == null && a().aR()) {
/*  53 */           a().w(a().a().aR());
/*  54 */           str = g.i.getValue();
/*     */         } else {
/*  56 */           str = g.p.getValue();
/*     */         } 
/*  58 */       } else if (a().bu()) {
/*  59 */         str = a().bB();
/*     */       } else {
/*  61 */         str = g.l.getValue();
/*     */       } 
/*     */     }
/*     */     
/*  65 */     return str;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*     */     try {
/*  81 */       if (!a().bv()) {
/*  82 */         return super.a(paramh, paramBoolean);
/*     */       }
/*     */       
/*  85 */       if (!k.b()) {
/*     */         
/*  87 */         a().a().y(n.i().getTimeInMillis());
/*  88 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/*  89 */         return true;
/*     */       } 
/*     */       
/*  92 */       String str1 = Integer.toString(a().v());
/*  93 */       String str2 = Integer.toString(a().a().v());
/*  94 */       e e = b().a(paramh.m(), str1, str2);
/*  95 */       return b(e, paramh, paramBoolean);
/*  96 */     } catch (Exception exception) {
/*  97 */       a.error("Erro ao enviar lance", exception);
/*  98 */       h("#009 - Erro enviar lance item");
/*     */ 
/*     */       
/* 101 */       return false;
/*     */     } 
/*     */   }
/*     */   private boolean b(e parame, h paramh, boolean paramBoolean) {
/* 105 */     long l = parame.k();
/* 106 */     a.info("Tempo post item {} = {}ms", a().bo(), Long.valueOf(l));
/* 107 */     String str = "Mensagem de erro: Sem retorno do portal.";
/*     */     
/* 109 */     if (parame.getStatusCode() == 200) {
/* 110 */       String str1 = parame.getData();
/*     */       
/* 112 */       if (str1 != null && !str1.isEmpty()) {
/*     */         
/* 114 */         String str2 = String.join("", new CharSequence[] { "top.location.href='/4/SessaoPublica/?ttCD_CHAVE=", Integer.toString(a().a().v()), "'" });
/* 115 */         if (str1.contains(str2)) {
/* 116 */           a().a().y(n.a().longValue());
/*     */           
/* 118 */           DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 119 */           double d1 = l / 1000.0D;
/* 120 */           String str3 = decimalFormat.format(d1);
/*     */           
/* 122 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { String.join("", new CharSequence[] { "Tempo para envio: ", str3, "s" }) });
/* 123 */           return true;
/*     */         } 
/*     */         
/* 126 */         Document document = Jsoup.parse(str1);
/* 127 */         Element element = document.select("span[class=errorMessage]").first();
/*     */         
/* 129 */         if (element != null) {
/* 130 */           str = element.text();
/*     */         }
/*     */       } 
/*     */     } else {
/* 134 */       str = String.join("", new CharSequence[] { "Mensagem de erro: Falha no envio do lance fechado (Status code: ", parame.Q(), ")." });
/*     */     } 
/*     */     
/* 137 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str });
/* 138 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */