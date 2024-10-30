/*     */ package br.com.arremate.d.d;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d.a;
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
/*     */ public class b
/*     */   extends e {
/*     */   public b(g paramg, i parami) {
/*  24 */     super(paramg, parami);
/*  25 */     h(TimeUnit.SECONDS.toMillis(10L));
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  30 */     ArrayList<m> arrayList = new ArrayList();
/*  31 */     if (a().t().isEmpty()) {
/*  32 */       return arrayList;
/*     */     }
/*     */ 
/*     */     
/*  36 */     boolean bool = a().L().stream().anyMatch(parame -> (parame.bt() || parame.bx() || parame.au()));
/*  37 */     if (!bool) {
/*  38 */       return arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  47 */       boolean bool1 = false;
/*  48 */       while (!bool1) {
/*     */         String str; Elements elements; do {
/*  50 */           if (arrayList.isEmpty()) {
/*  51 */             str = a().z(a().t()).getData();
/*     */           } else {
/*     */             
/*  54 */             str = a().m(a().t(), y.formatDate(((m)arrayList.get(arrayList.size() - 1)).b())).getData();
/*     */           } 
/*  56 */         } while (str.isEmpty());
/*     */         
/*  58 */         i i = a.g(str);
/*  59 */         if (i == null) {
/*     */           break;
/*     */         }
/*     */         
/*  63 */         if (arrayList.isEmpty()) {
/*  64 */           Document document = Jsoup.parse(i.getString("html"));
/*  65 */           elements = document.select("table#tableProcessAlert > tbody > tr");
/*  66 */           elements.remove(0);
/*     */         } else {
/*  68 */           Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/*  69 */           elements = document.select("tr");
/*     */         } 
/*     */         
/*  72 */         if (elements.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/*  76 */         for (Element element : elements) {
/*  77 */           Elements elements1 = element.select("td");
/*  78 */           String str1 = elements1.get(0).text().trim();
/*  79 */           String str2 = elements1.get(1).text().trim();
/*  80 */           String str3 = str2.substring(0, str2.indexOf(":")).replaceAll("\\D", "");
/*     */           
/*  82 */           m m = new m(str3, str2, y.a(str1), "Sistema");
/*  83 */           if (a(m)) {
/*  84 */             bool1 = true;
/*     */             
/*     */             break;
/*     */           } 
/*  88 */           arrayList.add(m);
/*     */         } 
/*     */       } 
/*     */       
/*  92 */       Collections.reverse(arrayList);
/*     */       
/*  94 */       arrayList.forEach(paramm -> {
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
/* 108 */     } catch (Exception exception) {
/* 109 */       a.warn("Failed to capture new alerts", exception);
/*     */     } 
/*     */     
/* 112 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 117 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a a() {
/* 125 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */