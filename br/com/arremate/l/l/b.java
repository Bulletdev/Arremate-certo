/*     */ package br.com.arremate.l.l;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.f;
/*     */ import br.com.arremate.j.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.m;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*     */   public b(d paramd, int paramInt) {
/*  34 */     super(paramd, paramInt);
/*  35 */     Q(999);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(d paramd) {
/*  44 */     super(paramd, 0);
/*  45 */     Q(999);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(b paramb, int paramInt) {
/*  55 */     super(paramb.a(), paramInt);
/*  56 */     Q(999);
/*  57 */     b(paramb.h());
/*  58 */     T(paramb.bo());
/*  59 */     aw(paramb.bT());
/*  60 */     a(paramb.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  66 */       byte b1 = 1;
/*  67 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licmunicipio, licmododedisputa";
/*  68 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?, ?";
/*     */       
/*  70 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  71 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  72 */       preparedStatement.setInt(b1++, b().v());
/*  73 */       preparedStatement.setLong(b1++, C());
/*  74 */       preparedStatement.setInt(b1++, v());
/*  75 */       preparedStatement.setString(b1++, bo());
/*  76 */       preparedStatement.setInt(b1++, K());
/*  77 */       preparedStatement.setString(b1++, bT());
/*  78 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  79 */       preparedStatement.setBoolean(b1++, bf());
/*  80 */       preparedStatement.setBoolean(b1++, aZ());
/*  81 */       preparedStatement.setString(b1++, bW());
/*  82 */       preparedStatement.setInt(b1++, a().getId());
/*     */       
/*  84 */       return (preparedStatement.executeUpdate() == 1);
/*  85 */     } catch (Exception exception) {
/*  86 */       a.error("Falha ao adicionar licitação do MT", exception);
/*     */ 
/*     */       
/*  89 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  94 */     m m = new m(this);
/*  95 */     return new br.com.arremate.d.b((g)m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/* 102 */     f f = (f)parami;
/* 103 */     g g = new g(f);
/* 104 */     g.z();
/*     */     
/* 106 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 108 */     String str = g.f(v());
/* 109 */     if (!str.isEmpty()) {
/* 110 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 111 */       Document document = Jsoup.parse(str);
/*     */       
/* 113 */       e(document);
/*     */       
/* 115 */       Elements elements = document.select("tbody[id=listaLotesTbody]").select("a[id^=lbLote]");
/* 116 */       for (Element element : elements) {
/* 117 */         hashMap.put(element.text().trim().toLowerCase(), Integer.valueOf(element.id().replace("lbLote", "")));
/*     */       }
/*     */       
/* 120 */       a(f, arrayList, (Map)hashMap);
/*     */     } 
/*     */     
/* 123 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(f paramf, List<g> paramList, Map<String, Integer> paramMap) {
/* 127 */     String str = paramf.al();
/* 128 */     byte b1 = 1; int i = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 134 */       String str1 = paramf.b(b1, str, bo());
/* 135 */       Document document = Jsoup.parse(str1);
/*     */       
/* 137 */       if (b1 == 1 && 
/* 138 */         str1.contains("dataScrolleridx")) {
/* 139 */         int k = Integer.parseInt(document.select("tfoot a[id*=:dataScrolleridx]").last().text());
/* 140 */         if (k > 1) {
/* 141 */           i = k;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 146 */       Elements elements = document.select("table[id=formMinhasPropostasPEPageList:propostaDataTable] > tbody > tr");
/* 147 */       for (Element element : elements) {
/* 148 */         String str2 = element.select("a[id$=:visualizarLink]").first().attr("onclick");
/* 149 */         str2 = str2.replaceAll(".*?(?:\\'idPropostaPregaoHidden\\'\\:).*?[\\']", "");
/* 150 */         str2 = str2.replaceAll("\\'.*", "");
/*     */         
/* 152 */         str1 = paramf.f(str2, str);
/* 153 */         a(paramList, Jsoup.parse(str1), paramMap);
/*     */       } 
/*     */       
/* 156 */       ++b1;
/* 157 */     } while (b1 <= i);
/*     */   }
/*     */   
/*     */   private void e(Document paramDocument) {
/* 161 */     String str = paramDocument.getElementsContainingOwnText("Modo de Disputa:").first().nextElementSibling().text().trim();
/* 162 */     switch (str) {
/*     */       case "Aberto":
/* 164 */         a(m.b);
/*     */         return;
/*     */       case "Randômico":
/* 167 */         a(m.a);
/*     */         return;
/*     */     } 
/* 170 */     a(m.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<g> paramList, Document paramDocument, Map<String, Integer> paramMap) {
/*     */     try {
/* 178 */       String str1 = paramDocument.select("span[id=formPropostaFornecedorPregaoEletronicoPageView:loteText]").first().text().trim();
/* 179 */       int i = ((Integer)paramMap.get(str1.toLowerCase())).intValue();
/*     */       
/* 181 */       String str2 = "1";
/*     */       
/* 183 */       if (!str1.toLowerCase().contains("único"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 189 */         str2 = str1.replaceAll("[^0-9.]", "");
/*     */       }
/*     */       
/* 192 */       String str3 = paramDocument.select("span[id$=formPropostaFornecedorPregaoEletronicoPageView:totalLoteUnitarioText]").first().text().trim();
/* 193 */       double d1 = Double.parseDouble(str3.replace(".", "").replace(",", ".").trim());
/*     */       
/* 195 */       String str4 = paramDocument.select("span[id=formPropostaFornecedorPregaoEletronicoPageView:totalLoteGlobalText]").first().text().trim();
/* 196 */       double d2 = Double.parseDouble(str4.replace(".", "").replace(",", ".").trim());
/*     */       
/* 198 */       a a1 = new a(i, this);
/* 199 */       a1.T(str2);
/* 200 */       a1.ag(str1);
/* 201 */       a1.k(1.0D);
/* 202 */       a1.m(d1);
/* 203 */       a1.n(d2);
/*     */       
/* 205 */       paramList.add(a1);
/* 206 */     } catch (Exception exception) {
/* 207 */       a.warn("Falha ao carregar itens MT", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 213 */     if (a() == m.c) {
/* 214 */       return "modo Aberto/Fechado";
/*     */     }
/*     */     
/* 217 */     if (a() == u.h) {
/* 218 */       return "tipo de apuração Não Identificado";
/*     */     }
/*     */     
/* 221 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */