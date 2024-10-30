/*     */ package br.com.arremate.l.h;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.h;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */   private final List<String> w;
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  37 */     super(paramd, paramInt);
/*  38 */     Q(999);
/*  39 */     this.w = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(d paramd) {
/*  48 */     super(paramd, 0);
/*  49 */     Q(999);
/*  50 */     this.w = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(b paramb, int paramInt) {
/*  60 */     super(paramb.a(), paramInt);
/*  61 */     Q(999);
/*  62 */     this.w = paramb.w;
/*  63 */     b(paramb.h());
/*  64 */     T(paramb.bo());
/*  65 */     aw(paramb.bT());
/*  66 */     a(paramb.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  72 */       byte b1 = 1;
/*  73 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, licmunicipio";
/*  74 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?";
/*     */       
/*  76 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  77 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  78 */       preparedStatement.setInt(b1++, b().v());
/*  79 */       preparedStatement.setLong(b1++, C());
/*  80 */       preparedStatement.setInt(b1++, v());
/*  81 */       preparedStatement.setString(b1++, bo());
/*  82 */       preparedStatement.setInt(b1++, K());
/*  83 */       preparedStatement.setString(b1++, bT());
/*  84 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  85 */       preparedStatement.setBoolean(b1++, bf());
/*  86 */       preparedStatement.setBoolean(b1++, aZ());
/*  87 */       preparedStatement.setString(b1++, bW());
/*     */       
/*  89 */       return (preparedStatement.executeUpdate() == 1);
/*  90 */     } catch (Exception exception) {
/*  91 */       a.error("Falha ao adicionar licitação do ES", exception);
/*     */ 
/*     */       
/*  94 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  99 */     h h = new h(this);
/* 100 */     return new br.com.arremate.d.b((g)h);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/* 107 */     br.com.arremate.j.b b1 = (br.com.arremate.j.b)parami;
/* 108 */     c c = new c(b1);
/* 109 */     c.z();
/*     */     
/* 111 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 113 */     String str = c.f(v());
/* 114 */     if (!str.isEmpty()) {
/* 115 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 116 */       Document document = Jsoup.parse(str);
/*     */       
/* 118 */       e(document);
/*     */       
/* 120 */       Elements elements = document.select("tbody[id=listaLotesTbody]").select("label[id^=lbDescLote]");
/* 121 */       for (Element element : elements) {
/* 122 */         hashMap.put(element.text().trim().toLowerCase(), Integer.valueOf(element.id().replace("lbDescLote", "")));
/*     */       }
/*     */       
/* 125 */       String str1 = b1.al();
/* 126 */       for (String str2 : this.w) {
/* 127 */         str = b1.f(str2, str1);
/* 128 */         document = Jsoup.parse(str);
/* 129 */         a(arrayList, document, (Map)hashMap);
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void e(Document paramDocument) {
/* 137 */     Element element = paramDocument.getElementsContainingOwnText("Modo de Disputa:").first();
/* 138 */     if (element != null) {
/* 139 */       String str = element.nextElementSibling().text().trim();
/* 140 */       switch (str) {
/*     */         case "Aberto":
/* 142 */           a(m.b);
/*     */           return;
/*     */         case "Randômico":
/* 145 */           a(m.a);
/*     */           return;
/*     */       } 
/* 148 */       a(m.c);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<g> paramList, Document paramDocument, Map<String, Integer> paramMap) {
/*     */     try {
/* 157 */       String str1 = paramDocument.select("span[id=formPropostaFornecedorPregaoEletronicoPageView:loteText]").first().text().trim();
/* 158 */       int i = ((Integer)paramMap.get(str1.toLowerCase())).intValue();
/*     */       
/* 160 */       String str2 = "1";
/* 161 */       if (!str1.toLowerCase().contains("único")) {
/* 162 */         Pattern pattern = Pattern.compile("\\d+\\s|\\d+$");
/* 163 */         Matcher matcher = pattern.matcher(str1.toLowerCase());
/* 164 */         if (!matcher.find()) {
/*     */           return;
/*     */         }
/*     */         
/* 168 */         str2 = String.valueOf(Integer.parseInt(matcher.group(0).replaceAll("\\D", "")));
/*     */       } 
/*     */       
/* 171 */       String str3 = paramDocument.select("span[id$=formPropostaFornecedorPregaoEletronicoPageView:totalLoteUnitarioText]").first().text().trim();
/* 172 */       double d1 = Double.parseDouble(str3.replace(".", "").replace(",", ".").trim());
/*     */       
/* 174 */       String str4 = paramDocument.select("span[id=formPropostaFornecedorPregaoEletronicoPageView:totalLoteGlobalText]").first().text().trim();
/* 175 */       double d2 = Double.parseDouble(str4.replace(".", "").replace(",", ".").trim());
/*     */       
/* 177 */       a a1 = new a(i, this);
/* 178 */       a1.T(str2);
/* 179 */       a1.ag(str1);
/* 180 */       a1.k(1.0D);
/* 181 */       a1.m(d1);
/* 182 */       a1.n(d2);
/*     */       
/* 184 */       paramList.add(a1);
/* 185 */     } catch (Exception exception) {
/* 186 */       a.warn("Falha ao carregar itens ES", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void Z(String paramString) {
/* 196 */     this.w.add(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String bg() {
/* 201 */     if (a() == m.c) {
/* 202 */       return "modo Aberto/Fechado";
/*     */     }
/* 204 */     if (a() == m.b) {
/* 205 */       return "modo Aberto";
/*     */     }
/* 207 */     if (a() == u.h) {
/* 208 */       return "tipo de apuração Não Identificado";
/*     */     }
/*     */     
/* 211 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\h\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */