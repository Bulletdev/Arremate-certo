/*     */ package br.com.arremate.l.o;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.b.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.k.a.o;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a {
/*     */   public b(d paramd, int paramInt) {
/*  30 */     super(paramd, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  37 */       byte b1 = 1;
/*  38 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, liccriterio, licsrp, licunitario";
/*  39 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, ?, ?, ?";
/*     */       
/*  41 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  42 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  43 */       preparedStatement.setInt(b1++, b().v());
/*  44 */       preparedStatement.setLong(b1++, C());
/*  45 */       preparedStatement.setInt(b1++, v());
/*  46 */       preparedStatement.setString(b1++, bo());
/*  47 */       preparedStatement.setInt(b1++, K());
/*  48 */       preparedStatement.setString(b1++, bT());
/*  49 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  50 */       preparedStatement.setString(b1++, (a().w() == 1) ? "por item" : "por lote");
/*  51 */       preparedStatement.setBoolean(b1++, bf());
/*  52 */       preparedStatement.setBoolean(b1++, aZ());
/*     */       
/*  54 */       return (preparedStatement.executeUpdate() == 1);
/*  55 */     } catch (Exception exception) {
/*  56 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  59 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public String bg() {
/*  64 */     if (a() == m.b) {
/*  65 */       return "modo Aberto";
/*     */     }
/*     */     
/*  68 */     if (a() == m.c) {
/*  69 */       return "modo Aberto/Fechado";
/*     */     }
/*     */     
/*  72 */     if (a() != null) {
/*  73 */       switch (null.m[a().ordinal()]) {
/*     */         case 1:
/*     */         case 2:
/*  76 */           return "Lote";
/*     */         case 3:
/*  78 */           return "Maior Desconto";
/*     */         case 4:
/*  80 */           return "Taxa Administrativa ou Taxa de Transação";
/*     */       } 
/*  82 */       return "";
/*     */     } 
/*     */ 
/*     */     
/*  86 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  91 */     o o = new o(this);
/*  92 */     return new br.com.arremate.d.b((g)o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  99 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/* 101 */     if (parami != null && !parami.isRunning()) {
/* 102 */       parami.z();
/*     */     }
/*     */     
/* 105 */     if (parami instanceof a && parami.isRunning()) {
/*     */       
/* 107 */       a a1 = (a)parami;
/*     */ 
/*     */       
/* 110 */       String str1 = v() + "&" + bo();
/* 111 */       String str2 = a1.m(str1);
/* 112 */       Document document = Jsoup.parse(str2);
/* 113 */       Elements elements1 = document.select("table:contains(Descrição do Item) tr");
/* 114 */       if (elements1 == null) {
/* 115 */         return arrayList;
/*     */       }
/* 117 */       Elements elements2 = a(a1);
/* 118 */       byte b1 = -1;
/*     */ 
/*     */       
/* 121 */       for (Element element : elements2) {
/* 122 */         Elements elements = element.select("> td");
/*     */         
/* 124 */         if (b1 == -1) {
/* 125 */           for (byte b2 = 0; b2 < elements.size(); b2++) {
/* 126 */             String str = elements.get(b2).text();
/*     */             
/* 128 */             if (str.contains("Minha Proposta") || str.contains("Vl. Final Proposta")) {
/* 129 */               b1 = b2; break;
/*     */             } 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 134 */         if (b1 > elements.size() - 1) {
/*     */           continue;
/*     */         }
/*     */         
/* 138 */         String str3 = elements.get(b1).text().trim();
/* 139 */         str3 = str3.replace(" ", "").replace(".", "").replace(",", ".");
/* 140 */         double d1 = str3.contains("--") ? 0.0D : Double.parseDouble(str3);
/*     */         
/* 142 */         String str4 = elements.get(0).text();
/*     */         
/* 144 */         if (str4.isEmpty()) {
/*     */           continue;
/*     */         }
/*     */         
/* 148 */         String str5 = str4;
/*     */         
/* 150 */         if (str4.contains("-")) {
/* 151 */           String[] arrayOfString = str4.split(" - ");
/* 152 */           str5 = arrayOfString[0];
/* 153 */           str4 = arrayOfString[1];
/*     */         } 
/*     */         
/* 156 */         if (str5.toLowerCase().contains("lote"))
/* 157 */           return new ArrayList<>(); 
/* 158 */         if (!str5.toLowerCase().contains("item")) {
/*     */           break;
/*     */         }
/*     */         
/* 162 */         int k = 1;
/* 163 */         int m = 0;
/* 164 */         str5 = str5.replaceAll("[\\D]", "").trim();
/*     */         
/* 166 */         for (Element element1 : elements1) {
/* 167 */           if (element1.text().contains(str5 + " - ")) {
/* 168 */             Elements elements3 = element1.select("td");
/* 169 */             String str = elements3.get(3).text().replaceAll("[\\D]", "");
/* 170 */             k = Integer.parseInt(str);
/* 171 */             m = Integer.parseInt(elements3.get(0).select("input[name=id_item]").first().val());
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 176 */         double d2 = d1 / k;
/*     */         
/* 178 */         if (m != 0) {
/* 179 */           a a2 = new a(m, this);
/* 180 */           a2.T(str5);
/* 181 */           a2.ag(str4);
/* 182 */           a2.k(k);
/* 183 */           a2.m(d2);
/* 184 */           a2.n(d1);
/* 185 */           a2.R(0);
/*     */           
/* 187 */           arrayList.add(a2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 193 */     return arrayList;
/*     */   }
/*     */   
/*     */   private Elements a(a parama) {
/* 197 */     String str = parama.d(v());
/*     */     
/* 199 */     if (str.contains("A Licitação encontra-se em outra Fase.")) {
/* 200 */       return b(parama);
/*     */     }
/* 202 */     Document document = Jsoup.parse(str);
/* 203 */     return document.select("form[id=Form1] > table > tbody > tr[height=17]");
/*     */   }
/*     */ 
/*     */   
/*     */   private Elements b(a parama) {
/* 208 */     String str1 = cg();
/* 209 */     String str2 = parama.a(v(), str1);
/* 210 */     Document document = null;
/* 211 */     Elements elements1 = new Elements();
/*     */     
/* 213 */     String str3 = "/mercatto/aplicacao/asp/pregao/List_Envelopes.asp?offset=";
/*     */     
/* 215 */     String str4 = null;
/*     */     do {
/* 217 */       document = Jsoup.parse(str2);
/* 218 */       Elements elements = document.select("a[href^=" + str3 + "]");
/* 219 */       String str = str4;
/* 220 */       str4 = null;
/*     */       
/* 222 */       for (Element element : elements) {
/* 223 */         String str5 = element.attr("href").replace(str3, "");
/*     */         
/* 225 */         if (!str5.equals("-1") && !str5.equals("0") && (str == null || Integer.parseInt(str) < Integer.parseInt(str5))) {
/* 226 */           str4 = str5;
/*     */         }
/*     */       } 
/*     */       
/* 230 */       elements1.addAll((Collection)document.select("tr:has(img[src=/mercatto/images/botoes/tools/sinal_verde.gif])"));
/*     */       
/* 232 */       if (str4 == null)
/* 233 */         continue;  str2 = parama.a(v(), str1, str4);
/*     */     }
/* 235 */     while (str4 != null);
/*     */     
/* 237 */     Elements elements2 = document.select("form[name=FrmEnvelopes] > table > tbody > tr");
/* 238 */     elements1.add(0, elements2.get(3));
/*     */     
/* 240 */     return elements1;
/*     */   }
/*     */   
/*     */   private String cg() {
/* 244 */     String str = "";
/*     */     
/*     */     try {
/* 247 */       str = URLEncoder.encode(bo(), "UTF-8");
/* 248 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */     
/* 250 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\o\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */