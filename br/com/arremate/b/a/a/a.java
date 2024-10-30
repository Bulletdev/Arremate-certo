/*     */ package br.com.arremate.b.a.a;
/*     */ 
/*     */ import br.com.arremate.b.a.a;
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.e.e;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends a
/*     */ {
/*  42 */   private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
/*     */   
/*     */   private final d a;
/*     */   private final e a;
/*  46 */   private final int d = 3;
/*  47 */   private final int e = 4;
/*  48 */   private final int f = 5;
/*  49 */   private final int h = 6;
/*     */   
/*     */   private List<c> a;
/*     */   
/*     */   public a(c paramc) {
/*  54 */     super((i)paramc);
/*     */     
/*  56 */     this.a = (List<c>)new d(paramc.a());
/*  57 */     this.a.a((i)paramc);
/*     */     
/*  59 */     this.a = (List<c>)new e(paramc.a());
/*  60 */     this.a.a((i)paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  65 */     boolean bool = false;
/*     */     
/*     */     try {
/*  68 */       this.a.bN();
/*  69 */       bool = true;
/*  70 */     } catch (Exception exception) {
/*  71 */       f("Não foi possível efetuar o login na área do Comprasnet 4.0 para realizar a captura dos pregões da Nova Lei de Licitações!");
/*  72 */       a(2);
/*  73 */       a.warn("Failed to enter the new area of Comprasnet");
/*     */     } 
/*     */     
/*  76 */     ArrayList<j> arrayList = new ArrayList();
/*  77 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  78 */     for (j j : paramList) {
/*  79 */       if (a().get()) {
/*  80 */         return arrayList;
/*     */       }
/*     */       
/*  83 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  85 */           if (bool) {
/*  86 */             getClass(); a(arrayList, j, 3);
/*     */           } 
/*  88 */           hashMap.put(a().c(), j);
/*  89 */           a(arrayList, j);
/*     */         
/*     */         case 2:
/*  92 */           if (bool) {
/*  93 */             getClass(); a(arrayList, j, 4);
/*     */           } 
/*  95 */           hashMap.put(a().d(), j);
/*  96 */           b(arrayList, j);
/*     */         
/*     */         case 3:
/*  99 */           if (bool) {
/* 100 */             getClass(); a(arrayList, j, 5);
/* 101 */             getClass(); a(arrayList, j, 6);
/*     */           } 
/* 103 */           hashMap.put(a().e(), j);
/* 104 */           hashMap.put(a().f(), j);
/* 105 */           c(arrayList, j);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 112 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/* 113 */       String str = ((e)entry.getKey()).getData();
/* 114 */       if (str.contains("Não existe pregão aberto no qual você tenha enviado proposta, ou o pregão ou o item do pregão que você enviou proposta já foi encerrado") || str
/* 115 */         .contains("Não existe licitação aberta no qual você tenha enviado proposta, ou a licitação ou o item da licitação que você enviou proposta já foi encerrada") || str
/* 116 */         .contains("No momento não existem propostas para consulta")) {
/*     */         continue;
/*     */       }
/*     */       
/* 120 */       a(str, (j)entry.getValue(), arrayList);
/*     */       
/* 122 */       if (a().get()) {
/* 123 */         return arrayList;
/*     */       }
/*     */     } 
/*     */     
/* 127 */     this.a.b();
/*     */     
/* 129 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(String paramString, j paramj, List<j> paramList) throws Exception {
/* 133 */     Document document = Jsoup.parse(paramString);
/* 134 */     Element element = document.select("table[class=td] > tbody").first();
/* 135 */     if (element == null) {
/*     */       return;
/*     */     }
/*     */     
/* 139 */     Elements elements = element.select("tr");
/* 140 */     elements.remove(0);
/* 141 */     for (Element element1 : elements) {
/* 142 */       e e1; if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/* 146 */       Elements elements1 = element1.select("td");
/*     */       
/* 148 */       Pattern pattern = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2}");
/* 149 */       String str1 = elements1.get(4).text().trim();
/* 150 */       Matcher matcher1 = pattern.matcher(str1);
/* 151 */       Calendar calendar = null;
/*     */       
/* 153 */       if (matcher1.find()) {
/* 154 */         str1 = matcher1.group();
/* 155 */         calendar = y.c(str1);
/* 156 */         if (a(calendar)) {
/*     */           continue;
/*     */         }
/*     */       } 
/*     */       
/* 161 */       pattern = Pattern.compile("(?<!\\d)(\\d{6}|\\d{7})(?!\\d)");
/* 162 */       String str2 = elements1.get(1).select("a").attr("onclick");
/* 163 */       Matcher matcher2 = pattern.matcher(str2);
/* 164 */       if (!matcher2.find()) {
/*     */         continue;
/*     */       }
/*     */       
/* 168 */       int i = Integer.parseInt(matcher2.group(0));
/* 169 */       if (paramList.stream().filter(paramj -> (paramj.v() == paramInt)).findFirst().isPresent()) {
/*     */         continue;
/*     */       }
/*     */       
/* 173 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 177 */       m m = null;
/* 178 */       paramString = a().d(i).getData();
/* 179 */       if (!paramString.isEmpty()) {
/* 180 */         document = Jsoup.parse(paramString);
/* 181 */         Elements elements2 = document.select("p[class=tex3]");
/*     */         
/* 183 */         for (Element element2 : elements2) {
/* 184 */           if (element2.text().contains("Modo de Disputa")) {
/* 185 */             if (element2.text().contains("Aberto/Fechado")) {
/* 186 */               m = m.c; break;
/* 187 */             }  if (element2.text().contains("Aberto")) {
/* 188 */               m = m.b;
/*     */             }
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 196 */       if (m == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 200 */       String str3 = elements1.get(1).text().replaceAll("\\D", "");
/* 201 */       String str4 = elements1.get(2).text().trim();
/* 202 */       String str5 = elements1.get(3).text().trim();
/* 203 */       boolean bool1 = elements1.get(5).text().trim().toLowerCase().equals("sim");
/* 204 */       boolean bool2 = elements1.get(6).text().trim().toLowerCase().equals("sim");
/*     */       
/* 206 */       String str6 = "";
/* 207 */       if (paramj == j.a) {
/* 208 */         str6 = elements1.get(7).text().trim();
/*     */       }
/*     */ 
/*     */       
/* 212 */       if (!bool2) {
/* 213 */         c c = new c(a().a(), i);
/* 214 */         c.D(false);
/*     */       } else {
/* 216 */         e1 = new e(a().a(), i);
/* 217 */         e1.D(true);
/*     */       } 
/*     */       
/* 220 */       e1.a(m);
/* 221 */       e1.D(bool2);
/* 222 */       e1.T(str3);
/* 223 */       e1.Q(Integer.parseInt(str4));
/* 224 */       e1.aw(str5);
/* 225 */       e1.b(calendar);
/* 226 */       e1.s(bool1);
/* 227 */       e1.z(bool1);
/* 228 */       e1.ay(str6);
/* 229 */       e1.a(paramj);
/* 230 */       paramList.add(e1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<j> paramList, j paramj) throws Exception {
/* 238 */     if (this.a == null) {
/* 239 */       c();
/*     */     }
/*     */     
/* 242 */     for (c c : this.a) {
/* 243 */       if (e().compareTo(c.h()) < 0) {
/* 244 */         c.a(paramj);
/* 245 */         paramList.add(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(List<j> paramList, j paramj) throws Exception {
/* 251 */     if (this.a == null) {
/* 252 */       c();
/*     */     }
/*     */     
/* 255 */     for (c c : this.a) {
/* 256 */       Calendar calendar = e();
/* 257 */       if (calendar.compareTo(c.h()) >= 0 && calendar.compareTo(c.g()) <= 0) {
/* 258 */         c.a(paramj);
/* 259 */         paramList.add(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(List<j> paramList, j paramj) throws Exception {
/* 265 */     if (this.a == null) {
/* 266 */       c();
/*     */     }
/*     */     
/* 269 */     for (c c : this.a) {
/* 270 */       if (e().compareTo(c.g()) > 0) {
/* 271 */         c.a(paramj);
/* 272 */         paramList.add(c);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c() throws Exception {
/* 278 */     if (a().get()) {
/*     */       return;
/*     */     }
/*     */     
/* 282 */     String str = this.a.f().getData();
/* 283 */     if (str.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 287 */     this.a = new ArrayList<>();
/*     */     
/* 289 */     e e1 = e.a(str);
/* 290 */     Elements elements = e1.b();
/* 291 */     if (elements.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/* 295 */     for (Element element : elements) {
/* 296 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/* 300 */       String str1 = element.select("a").attr("href").trim();
/* 301 */       str = this.a.g(str1).getData();
/* 302 */       if (str == null || str.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/* 306 */       f f = f.a(str);
/* 307 */       if (f.j()) {
/*     */         continue;
/*     */       }
/*     */       
/* 311 */       Calendar calendar = f.b();
/* 312 */       if (a(calendar)) {
/*     */         continue;
/*     */       }
/*     */       
/* 316 */       int i = f.b();
/* 317 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 321 */       String str2 = "Encerramento: " + y.formatDate(calendar.getTime(), "dd/MM/yy HH:mm");
/*     */       
/* 323 */       c c = new c(a().a(), i);
/* 324 */       c.T(f.h());
/* 325 */       c.Q(f.a().intValue());
/* 326 */       c.aw(f.i());
/* 327 */       c.b(f.a());
/* 328 */       c.a(calendar);
/* 329 */       c.s(false);
/* 330 */       c.D(f.k());
/* 331 */       c.ay(str2);
/* 332 */       c.a(l.c);
/* 333 */       c.a(m.e);
/*     */       
/* 335 */       this.a.add(c);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(List<j> paramList, j paramj, int paramInt) throws Exception {
/*     */     f f;
/* 343 */     if (a().get()) {
/*     */       return;
/*     */     }
/*     */     
/* 347 */     byte b = 0;
/*     */ 
/*     */     
/*     */     do {
/*     */       String str;
/*     */       
/* 353 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*     */       do {
/* 358 */         e e1 = a(this.a.a(b, 10, paramInt));
/* 359 */         str = e1.getData();
/* 360 */       } while (str.isEmpty() || !str.startsWith("["));
/*     */       
/* 362 */       f = new f(str);
/* 363 */       for (byte b1 = 0; b1 < f.length(); ) {
/* 364 */         c c; i i = f.b(b1).j("compra");
/*     */         
/* 366 */         int k = i.getInt("modalidade");
/*     */         
/* 368 */         switch (k) {
/*     */           case 3:
/* 370 */             c = c(i);
/*     */             break;
/*     */           case 5:
/* 373 */             c = b(i);
/*     */             break;
/*     */           case 6:
/* 376 */             c = a(i);
/*     */             break;
/*     */           default:
/*     */             b1++;
/*     */             continue;
/*     */         } 
/* 382 */         if (c == null);
/*     */ 
/*     */ 
/*     */         
/* 386 */         if (paramj.equals(j.d) && !a(c));
/*     */ 
/*     */ 
/*     */         
/* 390 */         if (a(c.v()));
/*     */ 
/*     */ 
/*     */         
/* 394 */         if (c.h() != null && a(c.h()));
/*     */ 
/*     */ 
/*     */         
/* 398 */         c.a(paramj);
/* 399 */         paramList.add(c);
/*     */       } 
/*     */       
/* 402 */       b++;
/* 403 */     } while (f.length() >= 10);
/*     */   }
/*     */   private boolean a(c paramc) {
/*     */     e e1;
/* 407 */     f f = null;
/* 408 */     byte b = 0;
/*     */ 
/*     */     
/*     */     do {
/* 412 */       e1 = a(this.a.b(paramc.bk(), b));
/* 413 */       if (e1.getData().isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/* 417 */       f = new f(e1.getData());
/* 418 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 419 */         i i = f.b(b1);
/* 420 */         if (i.has("proposta")) {
/* 421 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 425 */       b++;
/* 426 */     } while (f == null || f.length() >= 10 || e1.getStatusCode() == 204);
/*     */     
/* 428 */     return false;
/*     */   }
/*     */   private c a(i parami) throws g, ParseException {
/*     */     e e1;
/* 432 */     int j = a(parami);
/* 433 */     String str1 = a(parami);
/* 434 */     String str2 = c.g(j, str1);
/* 435 */     int k = Math.abs(Objects.hash(new Object[] { str2 }));
/*     */     
/* 437 */     c c = new c(this.a.a(), k);
/* 438 */     c.T(str1);
/* 439 */     c.Q(j);
/* 440 */     c.aw(b(parami));
/* 441 */     c.s(false);
/* 442 */     c.z(true);
/* 443 */     c.a(l.g);
/* 444 */     c.a(m.e);
/*     */ 
/*     */     
/*     */     do {
/* 448 */       e1 = a(this.a.i(str2));
/* 449 */     } while (a(e1));
/*     */     
/* 451 */     parami = new i(e1.getData());
/*     */     
/* 453 */     if (parami.has("dataHoraFimDisputa")) {
/* 454 */       Calendar calendar = Calendar.getInstance();
/* 455 */       calendar.setTime(this.dateFormat.parse(parami.getString("dataHoraFimDisputa")));
/* 456 */       c.a(calendar);
/*     */       
/* 458 */       String str = "Encerramento: " + y.formatDate(calendar.getTime(), "dd/MM/yy HH:mm");
/* 459 */       c.ay(str);
/*     */     } 
/*     */     
/* 462 */     if (parami.has("dataHoraInicioDisputa")) {
/* 463 */       Calendar calendar = Calendar.getInstance();
/* 464 */       calendar.setTime(this.dateFormat.parse(parami.getString("dataHoraInicioDisputa")));
/* 465 */       c.b(calendar);
/*     */     } 
/*     */     
/* 468 */     c.D(a(parami));
/* 469 */     return c;
/*     */   }
/*     */   private c b(i parami) throws g, ParseException {
/*     */     e e1;
/* 473 */     int j = a(parami);
/* 474 */     String str1 = a(parami);
/* 475 */     String str2 = c.f(j, str1);
/* 476 */     String str3 = b(parami);
/* 477 */     int k = Math.abs(Objects.hash(new Object[] { str2 }));
/*     */ 
/*     */     
/*     */     do {
/* 481 */       e1 = a(this.a.j(str2));
/* 482 */     } while (a(e1));
/*     */     
/* 484 */     parami = new i(e1.getData());
/*     */     
/* 486 */     c c = new c(this.a.a(), k);
/* 487 */     c.T(str1);
/* 488 */     c.Q(j);
/* 489 */     c.aw(str3);
/* 490 */     c.s(b(parami));
/* 491 */     c.D(a(parami));
/* 492 */     c.z(true);
/* 493 */     c.b(a(parami));
/* 494 */     c.a(l.h);
/* 495 */     c.a(a(parami));
/*     */     
/* 497 */     return c;
/*     */   }
/*     */   private c c(i parami) throws g, ParseException {
/*     */     e e1;
/* 501 */     int j = a(parami);
/* 502 */     String str1 = a(parami);
/* 503 */     String str2 = c.e(j, str1);
/* 504 */     String str3 = b(parami);
/* 505 */     int k = Math.abs(Objects.hash(new Object[] { str2 }));
/*     */ 
/*     */     
/*     */     do {
/* 509 */       e1 = a(this.a.j(str2));
/* 510 */     } while (a(e1));
/*     */     
/* 512 */     parami = new i(e1.getData());
/* 513 */     if (c(parami)) {
/* 514 */       return null;
/*     */     }
/*     */     
/* 517 */     c c = new c(this.a.a(), k);
/* 518 */     c.T(str1);
/* 519 */     c.Q(j);
/* 520 */     c.aw(str3);
/* 521 */     c.s(b(parami));
/* 522 */     c.D(a(parami));
/* 523 */     c.z(true);
/* 524 */     c.b(a(parami));
/* 525 */     c.a(l.k);
/* 526 */     c.a(a(parami));
/*     */     
/* 528 */     return c;
/*     */   }
/*     */   
/*     */   private e a(e parame) {
/* 532 */     if (parame.getStatusCode() == 401) {
/*     */       try {
/* 534 */         this.a.bN();
/* 535 */       } catch (Exception exception) {
/* 536 */         a.warn("Failed to enter the new area of Comprasnet for renew login session!");
/*     */       } 
/*     */     }
/*     */     
/* 540 */     return parame;
/*     */   }
/*     */   
/*     */   private boolean a(e parame) {
/* 544 */     return (parame.getData().isEmpty() || !parame.getData().startsWith("{"));
/*     */   }
/*     */   
/*     */   private int a(i parami) {
/* 548 */     return parami.getInt("numeroUasg");
/*     */   }
/*     */   
/*     */   private String a(i parami) {
/* 552 */     return parami.getInt("numero") + "/" + parami.getInt("ano");
/*     */   }
/*     */   
/*     */   private String b(i parami) {
/* 556 */     return parami.getString("nomeUasg");
/*     */   }
/*     */   
/*     */   private boolean a(i parami) {
/* 560 */     return parami.getBoolean("equalizacaoIcms");
/*     */   }
/*     */   
/*     */   private boolean b(i parami) {
/* 564 */     return (parami.getInt("caracteristica") == 2);
/*     */   }
/*     */   
/*     */   private boolean c(i parami) {
/* 568 */     return !parami.getString("criterioJulgamento").equals("7");
/*     */   }
/*     */   
/*     */   private m a(i parami) {
/* 572 */     switch (parami.getString("modoDisputa")) {
/*     */       case "A":
/* 574 */         return m.b;
/*     */       case "AF":
/* 576 */         return m.c;
/*     */       case "FA":
/* 578 */         return m.f;
/*     */     } 
/* 580 */     return m.e;
/*     */   }
/*     */ 
/*     */   
/*     */   private Calendar a(i parami) throws g, ParseException {
/* 585 */     Calendar calendar = null;
/* 586 */     if (parami.has("dataHoraPrevisaoAbertura")) {
/* 587 */       calendar = Calendar.getInstance();
/* 588 */       calendar.setTime(this.dateFormat.parse(parami.getString("dataHoraPrevisaoAbertura")));
/*     */     } 
/* 590 */     return calendar;
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 595 */     return (c)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */