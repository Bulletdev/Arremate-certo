/*     */ package br.com.arremate.l.a;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.i.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.a.a;
/*     */ import br.com.arremate.k.a.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.StringJoiner;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends j
/*     */   implements a
/*     */ {
/*  34 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   public b(d paramd, int paramInt) {
/*  37 */     super(paramd, paramInt);
/*  38 */     super.Q(999);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] a() {
/*  43 */     Object[] arrayOfObject = super.a();
/*  44 */     arrayOfObject[2] = Integer.valueOf(v());
/*  45 */     return arrayOfObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*     */     try {
/*  51 */       byte b1 = 1;
/*  52 */       String str1 = "porcodigo, empcnpj, liccodigo, licnumero, licuasg, licuasgnome, licdataabertura, licoculta, licsrp, licunitario, lictipoapuracao, licmododedisputa, liclimitecasasdecimais, licicms";
/*  53 */       String str2 = "?, ?, ?, ?, ?, ?, ?, 0, FALSE, FALSE, ?, ?, ?, ?";
/*     */       
/*  55 */       String str3 = "INSERT INTO tblicitacao (" + str1 + ") VALUES (" + str2 + ");";
/*  56 */       PreparedStatement preparedStatement = a.a().prepareStatement(str3);
/*  57 */       preparedStatement.setInt(b1++, b().v());
/*  58 */       preparedStatement.setLong(b1++, C());
/*  59 */       preparedStatement.setInt(b1++, v());
/*  60 */       preparedStatement.setString(b1++, bo());
/*  61 */       preparedStatement.setInt(b1++, K());
/*  62 */       preparedStatement.setString(b1++, bT());
/*  63 */       preparedStatement.setTimestamp(b1++, new Timestamp(h().getTimeInMillis()));
/*  64 */       preparedStatement.setInt(b1++, a().w());
/*  65 */       preparedStatement.setInt(b1++, a().getId());
/*  66 */       preparedStatement.setInt(b1++, N());
/*  67 */       preparedStatement.setBoolean(b1++, k());
/*     */       
/*  69 */       return (preparedStatement.executeUpdate() == 1);
/*  70 */     } catch (Exception exception) {
/*  71 */       exception.printStackTrace();
/*     */ 
/*     */       
/*  74 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public br.com.arremate.d.b b() {
/*  79 */     a a1 = new a(this);
/*  80 */     return new br.com.arremate.d.b((g)a1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<g> a(i parami) {
/*  87 */     ArrayList<g> arrayList = new ArrayList();
/*  88 */     byte b1 = 1;
/*  89 */     int k = 0;
/*  90 */     StringBuilder stringBuilder = new StringBuilder();
/*  91 */     StringJoiner stringJoiner = new StringJoiner(", ");
/*     */     
/*  93 */     if (!(parami instanceof br.com.arremate.j.d.b) || !parami.isRunning()) {
/*  94 */       return arrayList;
/*     */     }
/*     */     
/*  97 */     br.com.arremate.j.d.b b2 = (br.com.arremate.j.d.b)parami;
/*     */     
/*     */     do {
/* 100 */       String str = b2.b(v(), b1, b1 + 10);
/*     */       
/* 102 */       if (str == null || str.isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/* 106 */       Document document = Jsoup.parse(str);
/*     */ 
/*     */       
/* 109 */       if (!k) {
/* 110 */         Elements elements1 = document.select("div > a");
/*     */         
/* 112 */         if (elements1.size() > 0) {
/* 113 */           String str1 = elements1.last().text();
/*     */ 
/*     */           
/* 116 */           if (str1.toLowerCase().trim().equals("opções")) {
/* 117 */             k = -1;
/* 118 */           } else if (str1.contains("-")) {
/* 119 */             str1 = str1.split("-")[1].trim();
/* 120 */             str1 = str1.replace("]", "");
/* 121 */             k = Integer.parseInt(str1);
/*     */           } else {
/* 123 */             k = -1;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 128 */       Elements elements = document.select("fieldset");
/*     */       
/* 130 */       if (elements.size() > 0) {
/* 131 */         elements.remove(0);
/*     */       }
/*     */       
/* 134 */       for (Element element : elements) {
/* 135 */         if (element.text().toLowerCase().contains("não existe proposta cadastrada")) {
/*     */           continue;
/*     */         }
/*     */         
/* 139 */         int m = stringBuilder.length();
/* 140 */         int n = stringJoiner.length();
/*     */         
/* 142 */         g g = a(element, b2, stringBuilder, stringJoiner);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 148 */         if (g == null && stringBuilder.length() == m && n == stringJoiner.length()) {
/* 149 */           arrayList.clear();
/*     */ 
/*     */           
/* 152 */           k = -1;
/*     */ 
/*     */           
/* 155 */           stringBuilder.delete(0, stringBuilder.length());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 168 */         arrayList.add(g);
/*     */       } 
/*     */       
/* 171 */       b1 += 10;
/* 172 */     } while (k >= b1 || k == 0);
/*     */     
/* 174 */     if (stringBuilder.length() > 0) {
/* 175 */       if (arrayList.size() > 0)
/*     */       {
/* 177 */         JOptionPane.showMessageDialog(null, "A disputa do(s) lote(s) " + stringBuilder + " é por % de desconto.\nNosso sistema ainda não está preparado para este tipo de disputa.\nSerá necessário realizar a disputa deste(s) lote(s) diretamente no portal.");
/*     */       
/*     */       }
/*     */       else
/*     */       {
/* 182 */         JOptionPane.showMessageDialog(null, "A disputa de todos os lotes da licitação " + v() + " é por % de desconto.\nNosso sistema ainda não está preparado para este tipo de disputa.\nSerá necessário realizar a disputa diretamente no portal.");
/*     */       }
/*     */     
/*     */     }
/* 186 */     else if (stringJoiner.length() > 0) {
/* 187 */       JOptionPane.showMessageDialog(null, "Não foi possível capturar o(s) lote(s) " + stringJoiner + ". Verfique no portal\nse a proposta do(s) lote(s) se encontra(m) classificada(s) para a disputa!");
/*     */     } 
/*     */ 
/*     */     
/* 191 */     return arrayList;
/*     */   }
/*     */   
/*     */   private g a(Element paramElement, br.com.arremate.j.d.b paramb, StringBuilder paramStringBuilder, StringJoiner paramStringJoiner) {
/* 195 */     String str1 = paramElement.select("legend").first().text();
/* 196 */     str1 = str1.split("\\[", 2)[1];
/* 197 */     str1 = str1.split(" ", 2)[1];
/* 198 */     str1 = str1.replace("]", "");
/*     */     
/* 200 */     Elements elements = paramElement.select("div.campo");
/* 201 */     String str2 = elements.get(0).text();
/* 202 */     byte b1 = (a() == u.d) ? 3 : 2;
/* 203 */     String str3 = (a() == u.d) ? "%" : "R$";
/* 204 */     String str4 = elements.get(b1).text();
/* 205 */     str4 = str4.replace(str3, "").replace(".", "").replace(",", ".").trim();
/*     */     
/* 207 */     String str5 = paramElement.select("img").first().attr("src");
/* 208 */     boolean bool = str5.contains("45.gif");
/* 209 */     a a1 = new a(Integer.parseInt(str1), this);
/*     */     
/* 211 */     String str6 = (a1.v() < 10) ? ("LOTE 0" + a1.v()) : ("LOTE " + a1.v());
/*     */     
/* 213 */     a1.R((a() == u.d) ? 1 : 0);
/* 214 */     a1.ag(str6);
/* 215 */     a1.x(bool);
/* 216 */     a1.n(Double.parseDouble(str4));
/* 217 */     a1.ah(str2);
/*     */     
/* 219 */     String str7 = paramb.c(v(), Integer.parseInt(str1));
/* 220 */     if (str7 != null && !str7.isEmpty()) {
/* 221 */       Document document = Jsoup.parse(str7);
/* 222 */       elements = document.select("div#posicaoLote_1");
/*     */       
/* 224 */       if (!elements.isEmpty()) {
/* 225 */         Element element = elements.get(0);
/*     */         
/* 227 */         if (element != null) {
/* 228 */           Elements elements1 = element.getAllElements();
/*     */           
/* 230 */           elements1.remove(0);
/* 231 */           elements1.remove(0);
/*     */           
/* 233 */           byte b2 = 0;
/*     */           
/* 235 */           for (Element element1 : elements1) {
/* 236 */             int i; BigDecimal bigDecimal; String str = element1.text().toLowerCase().trim();
/*     */ 
/*     */             
/* 239 */             switch (b2) {
/*     */               case true:
/* 241 */                 str = str.replaceAll("\\D", "");
/*     */                 
/* 243 */                 i = Integer.parseInt(str);
/* 244 */                 a1.z(TimeUnit.SECONDS.toMillis(i));
/*     */                 
/* 246 */                 b2 = 0;
/*     */                 continue;
/*     */               case true:
/* 249 */                 if (!str7.contains("O valor mínimo entre os lances é a diferença entre os valores da melhor e da segunda melhor propostas aplicado o percentual cadastrado.")) {
/* 250 */                   if (str.contains("r$")) {
/* 251 */                     str = str.replace("r$", "").replace(".", "").replace(",", ".").trim().substring(1);
/* 252 */                     BigDecimal bigDecimal1 = new BigDecimal(str);
/* 253 */                     a1.d(bigDecimal1);
/*     */                   } else {
/* 255 */                     str = str.replace("%", "").replace(",", ".").trim();
/* 256 */                     BigDecimal bigDecimal1 = new BigDecimal(str);
/* 257 */                     a1.f(bigDecimal1);
/*     */                   } 
/*     */                 }
/*     */                 
/* 261 */                 b2 = 0;
/*     */                 continue;
/*     */               case true:
/* 264 */                 str = str.replace("r$", "").replace(".", "").replace(",", ".").trim().substring(1);
/* 265 */                 bigDecimal = new BigDecimal(str);
/* 266 */                 a1.e(bigDecimal);
/*     */                 
/* 268 */                 b2 = 0;
/*     */                 continue;
/*     */               case true:
/* 271 */                 str = str.replaceAll("\\D", "");
/*     */                 
/* 273 */                 i = Integer.parseInt(str);
/*     */ 
/*     */                 
/* 276 */                 b2 = 0;
/*     */                 continue;
/*     */               case true:
/* 279 */                 str = str.replaceAll("\\D", "");
/*     */                 
/* 281 */                 i = Integer.parseInt(str);
/* 282 */                 a1.z(TimeUnit.SECONDS.toMillis(i));
/*     */                 
/* 284 */                 b2 = 0;
/*     */                 continue;
/*     */               case true:
/* 287 */                 return null;
/*     */             } 
/* 289 */             if (str.contains("tempo mínimo entre o melhor lance")) {
/* 290 */               b2 = 1; continue;
/* 291 */             }  if (str.contains("valor mínimo entre lances")) {
/* 292 */               b2 = 2; continue;
/* 293 */             }  if (str.contains("valor mínimo cobrir melhor oferta")) {
/* 294 */               b2 = 3; continue;
/* 295 */             }  if (str.contains("tempo mínimo lances intermediários")) {
/* 296 */               b2 = 4; continue;
/* 297 */             }  if (str.contains("tempo mínimo cobrir melhor oferta")) {
/* 298 */               b2 = 5;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 304 */         if (str7.contains("Digite os caracteres abaixo para continuar:") && str7
/* 305 */           .contains("https://www.licitacoes-e.com.br/aop/captchaServletAux.png")) {
/* 306 */           paramStringJoiner.add(a1.bo());
/*     */         } else {
/* 308 */           paramStringBuilder.append(a1.v());
/* 309 */           a.info("Erro ao buscar dados: " + a1.K());
/*     */         } 
/*     */         
/* 312 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 316 */     return a1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void Q(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String bf() {
/* 330 */     return Integer.toString(v());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String bg() {
/* 336 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */