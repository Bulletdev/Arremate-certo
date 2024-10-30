/*     */ package br.com.arremate.d.c;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.j.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.c.a;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends e
/*     */ {
/*     */   public b(g paramg, i parami) {
/*  28 */     super(paramg, parami);
/*  29 */     h(TimeUnit.SECONDS.toMillis(10L));
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  34 */     ArrayList<m> arrayList = new ArrayList();
/*  35 */     if (a().t().isEmpty()) {
/*  36 */       return arrayList;
/*     */     }
/*     */ 
/*     */     
/*  40 */     boolean bool = a().L().stream().anyMatch(parame -> (parame.bt() || parame.bx() || parame.au()));
/*  41 */     if (!bool) {
/*  42 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  51 */       boolean bool1 = false;
/*  52 */       while (!bool1) {
/*     */         String str; Elements elements; do {
/*  54 */           if (arrayList.isEmpty()) {
/*  55 */             str = a().z(a().t()).getData();
/*     */           } else {
/*     */             
/*  58 */             str = a().m(a().t(), y.formatDate(((m)arrayList.get(arrayList.size() - 1)).b())).getData();
/*     */           } 
/*  60 */         } while (str.isEmpty());
/*     */         
/*  62 */         i i = a.g(str);
/*  63 */         if (i == null) {
/*     */           break;
/*     */         }
/*     */         
/*  67 */         if (arrayList.isEmpty()) {
/*  68 */           Document document = Jsoup.parse(i.getString("html"));
/*  69 */           elements = document.select("table#tableProcessAlert > tbody > tr");
/*  70 */           elements.remove(0);
/*     */         } else {
/*  72 */           Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/*  73 */           elements = document.select("tr");
/*     */         } 
/*     */         
/*  76 */         if (elements.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/*  80 */         for (Element element : elements) {
/*  81 */           Elements elements1 = element.select("td");
/*  82 */           String str1 = elements1.get(0).text().trim();
/*  83 */           String str2 = elements1.get(1).text().trim();
/*  84 */           String str3 = str2.substring(0, str2.indexOf(":")).replaceAll("\\D", "");
/*     */           
/*  86 */           m m = new m(str3, str2, y.a(str1), "Sistema");
/*  87 */           if (a(m)) {
/*  88 */             bool1 = true;
/*     */             
/*     */             break;
/*     */           } 
/*  92 */           arrayList.add(m);
/*     */         } 
/*     */       } 
/*     */       
/*  96 */       Collections.reverse(arrayList);
/*     */       
/*  98 */       arrayList.forEach(paramm -> {
/*     */             e e1 = a().a(paramm.bo());
/*     */             if (e1 != null) {
/*     */               a a = (a)e1.a();
/*     */               String str = paramm.j().toLowerCase();
/*     */               if (str.contains("possuem direito de efetuar lance final e fechado")) {
/*     */                 a.v(false);
/*     */                 a.o(true);
/*     */                 if (!a.bh().isEmpty() && str.contains(a.bh().toLowerCase())) {
/*     */                   a.v(true);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           });
/* 112 */     } catch (Exception exception) {
/* 113 */       a.warn("Failed to capture new alerts", exception);
/*     */     } 
/*     */     
/* 116 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 121 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a a() {
/* 130 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */