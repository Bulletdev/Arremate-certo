/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d.b;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.stream.Collectors;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends a
/*     */ {
/*     */   public e(i parami) {
/*  36 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(List<j> paramList) throws Exception {
/*  41 */     ArrayList<j> arrayList = new ArrayList();
/*  42 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  43 */     for (j j : paramList) {
/*  44 */       if (a().get()) {
/*  45 */         return arrayList;
/*     */       }
/*     */       
/*  48 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  50 */           hashMap.put(j, Arrays.asList(new String[] { "PUBLICADO", "RECEPÇÃO DE PROPOSTAS", "ANÁLISE DE PROPOSTAS" }));
/*     */         
/*     */         case 2:
/*  53 */           hashMap.put(j, Arrays.asList(new String[] { "DISPUTA" }));
/*     */         
/*     */         case 3:
/*  56 */           hashMap.put(j, Arrays.asList(new String[] { "HABILITAÇÃO", "ADJUDICADO", "HOMOLOGADO", "SUSPENSO" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  63 */     String str = a().k().getData();
/*  64 */     if (str.isEmpty()) {
/*  65 */       return arrayList;
/*     */     }
/*     */     
/*  68 */     Document document = Jsoup.parse(str);
/*  69 */     Elements elements = document.select("tbody#tableProposalDataBody > tr");
/*  70 */     for (Element element : elements) {
/*  71 */       if (a().get()) {
/*  72 */         return arrayList;
/*     */       }
/*     */       
/*  75 */       Elements elements1 = element.select("td");
/*     */       
/*  77 */       Calendar calendar = y.c(elements1.get(7).text());
/*  78 */       if (a(calendar)) {
/*     */         break;
/*     */       }
/*     */       
/*  82 */       l l = a(elements1.get(3).text().toLowerCase().trim());
/*     */       
/*  84 */       if (l == l.l) {
/*     */         continue;
/*     */       }
/*     */       
/*  88 */       j j = null;
/*  89 */       String str1 = elements1.get(5).text().trim();
/*     */       
/*  91 */       for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  92 */         Optional optional = ((List)entry.getValue()).stream().filter(paramString2 -> paramString1.contains(paramString2)).findFirst();
/*  93 */         if (optional.isPresent()) {
/*  94 */           j = (j)entry.getKey();
/*     */         }
/*     */       } 
/*     */       
/*  98 */       if (j == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 102 */       String str2 = URLDecoder.decode(elements1.get(0).select("a").first().attr("href"), "UTF-8");
/* 103 */       str2 = str2.replace("/Proposal/Proposal?param1=", "");
/*     */       
/* 105 */       String str3 = elements1.get(1).text().trim();
/* 106 */       String str4 = elements1.get(2).text().trim();
/*     */       
/* 108 */       String str5 = elements1.get(4).text().trim();
/* 109 */       String str6 = str5;
/* 110 */       if (str5.contains("-")) {
/* 111 */         str5 = str5.split("-")[0];
/*     */       }
/*     */       
/* 114 */       int i = Math.abs(Objects.hash(new Object[] { str4, str3 }));
/* 115 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 119 */       if (a().get()) {
/* 120 */         return arrayList;
/*     */       }
/*     */       
/* 123 */       String str7 = (l == l.f) ? "10" : "1";
/* 124 */       String str8 = a(str3, str4, str6, str7);
/*     */       
/* 126 */       if (str8.isEmpty()) {
/* 127 */         str8 = a(str5, str4, str6, str7);
/* 128 */         if (str8.isEmpty()) {
/*     */           continue;
/*     */         }
/*     */       } 
/*     */       
/* 133 */       str = a().v(str8).getData();
/* 134 */       if (str.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/* 138 */       document = Jsoup.parse(str);
/*     */       
/* 140 */       String str9 = document.select("button:containsOwn(Lotes)").attr("onclick");
/* 141 */       str9 = str9.substring(str9.indexOf("'") + 1, str9.lastIndexOf("'"));
/*     */       
/* 143 */       int k = a(document);
/* 144 */       int m = b(document);
/*     */       
/* 146 */       b b = new b(a().a(), i);
/* 147 */       b.P(str2);
/* 148 */       b.Q(str9);
/* 149 */       b.T(str4);
/* 150 */       b.aw(str3);
/* 151 */       b.a(l);
/* 152 */       b.a(a(str1));
/* 153 */       b.b(calendar);
/* 154 */       b.a(a(document.select("input#ClosingKind").attr("value").toLowerCase()));
/* 155 */       b.a(a(document.select("input#DisputeKind").attr("value").toLowerCase()));
/* 156 */       b.s(document.select("input#ContractKind").attr("value").toLowerCase().contains("registro de preço"));
/* 157 */       b.D(false);
/* 158 */       b.W(k);
/* 159 */       b.X(m);
/* 160 */       b.z(false);
/* 161 */       b.az(str5);
/*     */       
/* 163 */       arrayList.add(b);
/*     */     } 
/*     */     
/* 166 */     return arrayList;
/*     */   }
/*     */   
/*     */   private String a(String paramString1, String paramString2, String paramString3, String paramString4) {
/*     */     try {
/*     */       String str1;
/*     */       do {
/* 173 */         str1 = a().b(paramString1, paramString2, paramString4).getData();
/* 174 */       } while (str1.isEmpty());
/*     */       
/* 176 */       i i = new i(str1);
/* 177 */       Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/* 178 */       Elements elements = document.select("tr:matches(" + paramString3 + ")");
/* 179 */       String str2 = elements.select("td").get(0).select("a").first().attr("href");
/* 180 */       str2 = URLDecoder.decode(str2, "UTF-8");
/* 181 */       str2 = str2.replace("/Process/ProcessView?param1=", "");
/* 182 */       return str2;
/* 183 */     } catch (Exception exception) {
/* 184 */       a.warn("[Promotor: {}] [Nº Pregão: {}] Falha ao carregar o processo da licitação. Teste a consulta no portal!", paramString1, paramString2);
/*     */ 
/*     */       
/* 187 */       return "";
/*     */     } 
/*     */   }
/*     */   private l a(String paramString) {
/* 191 */     if (paramString.contains("licitação 13.303"))
/* 192 */       return l.f; 
/* 193 */     if (paramString.contains("pregão eletrônico"))
/* 194 */       return l.a; 
/* 195 */     if (paramString.contains("concorrência eletrônica")) {
/* 196 */       return l.k;
/*     */     }
/*     */     
/* 199 */     return l.l;
/*     */   }
/*     */   
/*     */   private j a(String paramString) {
/* 203 */     switch (paramString) {
/*     */       case "PUBLICADO":
/*     */       case "ANÁLISE DE PROPOSTAS":
/*     */       case "RECEPÇÃO DE PROPOSTAS":
/* 207 */         return j.d;
/*     */       case "DISPUTA":
/* 209 */         return j.a;
/*     */     } 
/* 211 */     return j.g;
/*     */   }
/*     */ 
/*     */   
/*     */   private m a(String paramString) {
/* 216 */     if (paramString.contains("aberto e fechado"))
/* 217 */       return m.c; 
/* 218 */     if (paramString.contains("aberto"))
/* 219 */       return m.b; 
/* 220 */     if (paramString.contains("prorrogação automática"))
/* 221 */       return m.d; 
/* 222 */     if (paramString.contains("sem disputa")) {
/* 223 */       return m.g;
/*     */     }
/*     */     
/* 226 */     return m.a;
/*     */   }
/*     */   
/*     */   private u a(String paramString) {
/* 230 */     u u = u.c;
/* 231 */     if (paramString.contains("maior lance")) {
/* 232 */       u = u.f;
/* 233 */     } else if (paramString.contains("maior desconto")) {
/* 234 */       u = u.d;
/*     */     } 
/* 236 */     return u;
/*     */   }
/*     */   
/*     */   private int a(Document paramDocument) {
/* 240 */     return a(paramDocument, "input#PreClosingTime", "value");
/*     */   }
/*     */   
/*     */   private int b(Document paramDocument) {
/* 244 */     return a(paramDocument, "input#ClosingTime", "value");
/*     */   }
/*     */   
/*     */   private int a(Document paramDocument, String paramString1, String paramString2) {
/* 248 */     Elements elements = paramDocument.select(paramString1);
/* 249 */     String str = elements.attr(paramString2).trim();
/* 250 */     return !str.isEmpty() ? Integer.parseInt(str) : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> b(String paramString1, String paramString2) {
/* 255 */     List<j> list = new ArrayList();
/*     */     
/*     */     try {
/* 258 */       list = a(Arrays.asList(new j[] { j.d, j.a, j.g }, ), new AtomicBoolean(false));
/* 259 */       list = (List<j>)list.stream().filter(paramj -> (paramj.bT().equals(paramString1.toUpperCase()) && paramj.bo().equals(paramString2))).collect(Collectors.toList());
/* 260 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */     
/* 264 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 269 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */