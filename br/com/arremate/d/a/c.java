/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.j.d.b;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.a.a;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends e
/*     */ {
/*     */   private final Map<Integer, m> f;
/*     */   
/*     */   public c(g paramg, i parami) {
/*  36 */     super(paramg, parami);
/*  37 */     h(TimeUnit.SECONDS.toMillis(10L));
/*     */     
/*  39 */     this.f = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  44 */     ArrayList<m> arrayList = new ArrayList();
/*  45 */     int i = a().a().v();
/*  46 */     String str = a().h(i);
/*     */     
/*  48 */     if (!"".equals(str)) {
/*     */       try {
/*  50 */         Document document = Jsoup.parse(str);
/*  51 */         Elements elements = document.select("fieldset table tr td");
/*  52 */         for (byte b = 0; b < elements.size(); b += 2) {
/*  53 */           String str1 = elements.get(b).text().replace(" às ", " ");
/*  54 */           Date date = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(str1);
/*  55 */           String str2 = elements.get(b + 1).text().trim();
/*     */           
/*  57 */           m m = new m(str2, date, "PREGOEIRO");
/*  58 */           if (a(m)) {
/*     */             break;
/*     */           }
/*     */           
/*  62 */           if (!arrayList.contains(m)) {
/*  63 */             arrayList.add(m);
/*     */           }
/*     */         } 
/*  66 */         Collections.reverse(arrayList);
/*  67 */       } catch (Exception exception) {
/*  68 */         a.warn("Erro ao capturar mensagem", exception);
/*     */       } 
/*     */     }
/*     */     
/*  72 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void a(Integer paramInteger, f paramf) {
/*  80 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  82 */     for (byte b = 0; b < paramf.length(); b++) {
/*  83 */       i i = paramf.b(b);
/*  84 */       Date date = new Date(i.getLong("dataHora"));
/*  85 */       String str = i.getString("texto");
/*     */       
/*     */       try {
/*  88 */         str = new String(str.getBytes("ISO_8859_1"), "UTF-8");
/*  89 */         str = str.replaceAll("&amp;", "&");
/*     */         
/*  91 */         String str1 = (i.getInt("codigoTipoEmitente") == 1) ? "Pregoeiro" : "Sistema";
/*  92 */         String str2 = (paramInteger.intValue() != 0) ? Integer.toString(paramInteger.intValue()) : "";
/*     */         
/*  94 */         m m = new m(str2, str, date, str1);
/*  95 */         if (!b(m)) {
/*  96 */           if (!arrayList.contains(m)) {
/*  97 */             arrayList.add(m);
/*     */           }
/*     */         } else {
/*     */           break;
/*     */         } 
/* 102 */       } catch (Exception exception) {
/* 103 */         a.warn("{} - Erro ao capturar mensagem do item", exception, paramInteger);
/*     */       } 
/*     */     } 
/*     */     
/* 107 */     if (!arrayList.isEmpty()) {
/* 108 */       this.f.put(paramInteger, arrayList.get(0));
/* 109 */       Collections.reverse(arrayList);
/* 110 */       d(arrayList);
/* 111 */       m m = a().a().a();
/*     */       
/* 113 */       arrayList.forEach(paramm1 -> {
/*     */             String str1 = paramm1.j().toLowerCase();
/*     */             String str2 = paramm1.bo();
/*     */             a a = (a)a().a(str2).a();
/*     */             if (str1.contains("diferença entre os valores da melhor e da segunda melhor propostas")) {
/*     */               a(str1, a);
/*     */             }
/*     */             if (paramm == m.b || paramm == m.c) {
/*     */               Date date = paramm1.b();
/*     */               long l = n.a().longValue() - date.getTime();
/*     */               if (str1.contains("começou a disputa do lote")) {
/*     */                 l = ((paramm == m.b) ? TimeUnit.MINUTES.toMillis(10L) : TimeUnit.MINUTES.toMillis(15L)) - l;
/*     */                 if (a.z() == 0L) {
/*     */                   a.x(l);
/*     */                 }
/*     */               } 
/*     */               if (str1.contains("haverá prorrogação automática da etapa de envio de lances em 2 minutos")) {
/*     */                 l = TimeUnit.MINUTES.toMillis(2L) - l;
/*     */                 if (l > a.z()) {
/*     */                   a.x(l);
/*     */                 }
/*     */               } 
/*     */               if (str1.contains("final e fechado dentro do prazo de até cinco minutos") || str1.contains("será iniciada uma nova etapa fechada para os demais licitantes")) {
/*     */                 a.v(false);
/*     */                 a.n(true);
/*     */                 l = TimeUnit.MINUTES.toMillis(5L) - l;
/*     */                 if (l > a.z()) {
/*     */                   a.x(l);
/*     */                 }
/*     */               } 
/*     */               if (str1.contains(a().a().a().bv().toLowerCase()) && str1.contains("está convocado para ofertar um lance final e fechado em até cinco minutos")) {
/*     */                 a.v(true);
/*     */               }
/*     */             } 
/*     */           });
/*     */     } 
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
/*     */   
/*     */   private void a(String paramString, a parama) {
/*     */     try {
/* 165 */       paramString = paramString.substring(paramString.indexOf("$"));
/* 166 */       paramString = paramString.substring(paramString.indexOf("$"), paramString.indexOf("e")).replaceAll("[^0-9,]", "").replace(",", ".");
/* 167 */       BigDecimal bigDecimal = new BigDecimal(paramString);
/* 168 */       parama.e(bigDecimal);
/* 169 */     } catch (Exception exception) {
/* 170 */       a.warn("Couldn't update minimum value between bids from chat, error: {}", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   void a(String paramString, Element paramElement) {
/* 175 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*     */     try {
/* 178 */       int i = -1;
/* 179 */       int j = -1;
/* 180 */       int k = -1;
/*     */       
/* 182 */       Elements elements = paramElement.select("thead").select("th");
/* 183 */       for (Element element : elements) {
/* 184 */         if (element.text().toLowerCase().contains("data e hora")) {
/* 185 */           i = element.elementSiblingIndex().intValue(); continue;
/* 186 */         }  if (element.text().toLowerCase().contains("participante")) {
/* 187 */           j = element.elementSiblingIndex().intValue(); continue;
/* 188 */         }  if (element.text().toLowerCase().contains("mensagem")) {
/* 189 */           k = element.elementSiblingIndex().intValue();
/*     */         }
/*     */       } 
/*     */       
/* 193 */       if (i > -1 && j > -1 && k > -1) {
/* 194 */         Elements elements1 = paramElement.select("tr");
/* 195 */         if (elements1.size() > 2) {
/* 196 */           elements1.remove(0);
/* 197 */           elements1.remove(0);
/*     */           
/* 199 */           for (int m = elements1.size() - 1; m >= 0; ) {
/* 200 */             Elements elements2 = elements1.get(m).select("td");
/*     */             
/* 202 */             String str1 = elements2.get(i).text();
/* 203 */             Date date = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).parse(str1);
/* 204 */             String str2 = elements2.get(j).text().toLowerCase().contains("pregoeiro") ? "Pregoeiro" : "Sistema";
/* 205 */             String str3 = elements2.get(k).text();
/* 206 */             str3 = str3.replaceAll("&amp;", "&");
/*     */             
/* 208 */             m m1 = new m(paramString, str3, date, str2);
/* 209 */             if (!b(m1)) {
/* 210 */               if (!arrayList.contains(m1)) {
/* 211 */                 arrayList.add(m1);
/*     */               }
/*     */               
/*     */               m--;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 220 */       if (!arrayList.isEmpty()) {
/* 221 */         this.f.put(Integer.valueOf(Integer.parseInt(paramString)), arrayList.get(0));
/*     */       }
/* 223 */     } catch (Exception exception) {
/* 224 */       a.warn("{} - Erro ao capturar mensagem do item", exception, paramString);
/*     */     } 
/*     */     
/* 227 */     d(arrayList);
/*     */   }
/*     */   
/*     */   protected boolean b(m paramm) {
/* 231 */     int i = Integer.parseInt(paramm.bo());
/* 232 */     if (!this.f.containsKey(Integer.valueOf(i))) {
/* 233 */       return false;
/*     */     }
/*     */     
/* 236 */     return (((m)this.f.get(Integer.valueOf(i))).a(paramm) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 241 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */