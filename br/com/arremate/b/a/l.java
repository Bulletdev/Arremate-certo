/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.e;
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.k.b;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class l extends a {
/*     */   public l(d paramd) {
/*  21 */     super((i)paramd);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  26 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/*  31 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) {
/*  36 */     String str = a().D(paramString);
/*     */     
/*  38 */     if (str != null && !str.isEmpty()) {
/*  39 */       Document document = Jsoup.parse(str);
/*  40 */       Elements elements = document.select("table[id=tabelaDadosPregao]");
/*     */       
/*  42 */       if (!elements.isEmpty()) {
/*  43 */         Element element = elements.get(0);
/*  44 */         String str2 = "numeroProcesso";
/*  45 */         String str3 = "unidadeCompra";
/*  46 */         String str4 = "999";
/*     */         
/*  48 */         if (!element.html().contains(str2)) {
/*  49 */           str2 = "numeroPlanejamentoRegistroPrecos";
/*     */         }
/*     */         
/*  52 */         if (!element.html().contains(str3)) {
/*  53 */           str3 = "orgaoGestor";
/*     */         }
/*     */         
/*  56 */         String str5 = element.select("span[id=" + str2 + "]").get(0).text();
/*  57 */         String[] arrayOfString = str5.split(" ");
/*     */         
/*  59 */         if (arrayOfString.length > 1) {
/*  60 */           str4 = arrayOfString[0];
/*     */         }
/*     */         
/*  63 */         String str6 = element.select("span[id=dataInicioSessaoPregao]").get(0).text() + " " + element.select("span[id=horaInicioSessaoPregao]").get(0).text();
/*  64 */         String str7 = element.select("span[id=" + str3 + "]").get(0).text();
/*  65 */         String str8 = element.select("span[id=situacaoAtual]").get(0).text().toLowerCase();
/*  66 */         String str9 = element.select("span[id=criterioJulgamento]").get(0).text().toLowerCase();
/*  67 */         String str10 = "";
/*     */         try {
/*  69 */           str10 = element.select("span[id=modoDisputa]").get(0).text().toLowerCase();
/*  70 */         } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*  71 */           str10 = "aleatorio";
/*     */         } 
/*     */         
/*  74 */         b b = new b(a().a(), Integer.parseInt(paramString));
/*  75 */         b.T(str5);
/*  76 */         b.Q(Integer.parseInt(str4));
/*  77 */         b.aw(str7);
/*  78 */         b.b(y.c(str6));
/*  79 */         b.s(element.text().contains("Pregão para registro de preços"));
/*  80 */         if (str10.equals("aberto e fechado")) {
/*  81 */           b.a(m.c);
/*  82 */         } else if (str10.equals("aberto")) {
/*  83 */           b.a(m.b);
/*     */         } else {
/*  85 */           b.a(m.a);
/*     */         } 
/*     */         
/*  88 */         if (str8.equals("sessão iniciada")) {
/*  89 */           b.a(j.a);
/*  90 */         } else if (str8.equals("concluído")) {
/*  91 */           b.a(j.g);
/*     */         } else {
/*  93 */           b.a(j.d);
/*     */         } 
/*     */         
/*  96 */         switch (str9) {
/*     */           case "por lote":
/*  98 */             b.a(e.a);
/*     */             break;
/*     */           case "por item":
/* 101 */             b.a(e.b);
/*     */             break;
/*     */           case "por maior desconto":
/* 104 */             b.a(u.d);
/*     */             break;
/*     */           default:
/* 107 */             b.a(u.h);
/* 108 */             b.a(e.c);
/*     */             break;
/*     */         } 
/*     */         
/* 112 */         b.z((b.bf() && b.a() == e.b));
/*     */         
/* 114 */         ArrayList<b> arrayList = new ArrayList();
/* 115 */         arrayList.add(b);
/*     */         
/* 117 */         return (List)arrayList;
/*     */       } 
/* 119 */       String str1 = "";
/*     */       
/* 121 */       if (str.contains("erroAcessoConcorrentePregaoExclusivoMEEPPFornecedorTemPorteOutro")) {
/* 122 */         str1 = "erroAcessoConcorrentePregaoExclusivoMEEPPFornecedorTemPorteOutro";
/* 123 */       } else if (str.contains("entidadeNaoEncontrada")) {
/* 124 */         str1 = "entidadeNaoEncontrada";
/*     */       } 
/*     */       
/* 127 */       if (!str1.isEmpty()) {
/* 128 */         Element element = document.select("span[id=" + str1 + "]").first();
/* 129 */         f(element.text());
/* 130 */         a(0);
/*     */       } 
/* 132 */       return null;
/*     */     } 
/*     */     
/* 135 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */