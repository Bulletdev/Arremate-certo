/*     */ package br.com.arremate.d.s;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*  23 */   private List<m> p = new ArrayList<>();
/*     */   
/*     */   public a(g paramg, i parami) {
/*  26 */     super(paramg, parami);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  31 */     ArrayList<m> arrayList = new ArrayList();
/*     */     try {
/*     */       boolean bool;
/*  34 */       String str = null;
/*     */       
/*     */       do {
/*     */         String str1;
/*  38 */         bool = false;
/*     */ 
/*     */         
/*  41 */         if (str == null) {
/*  42 */           str1 = a().V();
/*     */         } else {
/*  44 */           str1 = a().k(str);
/*     */         } 
/*     */         
/*  47 */         if (str1 == null || "".equals(str1)) {
/*  48 */           return arrayList;
/*     */         }
/*     */         
/*  51 */         Document document = Jsoup.parse(str1);
/*  52 */         Elements elements = document.select("body > table:eq(2) > tbody> tr > td:last-child");
/*     */ 
/*     */         
/*  55 */         for (int i = elements.size() - 1; i >= 1; i--) {
/*  56 */           String[] arrayOfString = elements.get(i).text().split(" : ", 2);
/*     */           
/*  58 */           if (arrayOfString.length == 2) {
/*     */ 
/*     */             
/*  61 */             String str2 = arrayOfString[1];
/*  62 */             String[] arrayOfString1 = arrayOfString[0].split(" - ", 2);
/*     */             
/*  64 */             if (arrayOfString1.length == 2) {
/*     */               Date date;
/*     */               
/*  67 */               String[] arrayOfString2 = arrayOfString1[0].split(" ");
/*  68 */               String str3 = arrayOfString1[1];
/*     */ 
/*     */               
/*     */               try {
/*  72 */                 date = y.a(arrayOfString2[0], arrayOfString2[1]);
/*  73 */               } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */               
/*  77 */               m m = new m(str2, date, str3);
/*  78 */               if (!this.p.contains(m)) {
/*  79 */                 arrayList.add(m);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*  84 */         Element element = elements.last().select("input ~ a").first();
/*     */         
/*  86 */         if (element == null)
/*  87 */           continue;  str = element.attr("href");
/*  88 */         bool = true;
/*     */       
/*     */       }
/*  91 */       while (bool);
/*  92 */     } catch (Exception exception) {
/*  93 */       a.info("Failed to capture message in Siga RJ");
/*     */     } 
/*     */     
/*  96 */     this.p.addAll(arrayList);
/*  97 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.j.b.a a() {
/* 102 */     return (br.com.arremate.j.b.a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\s\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */