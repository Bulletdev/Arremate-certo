/*    */ package br.com.arremate.d.i;
/*    */ 
/*    */ import br.com.arremate.d.e;
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.m;
/*    */ import br.com.arremate.m.y;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends e
/*    */ {
/*    */   private String q;
/*    */   
/*    */   public a(g paramg, i parami) {
/* 26 */     super(paramg, parami);
/*    */     
/* 28 */     this.q = "";
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<m> d() {
/* 33 */     ArrayList<m> arrayList = new ArrayList();
/* 34 */     if (this.q.isEmpty()) {
/* 35 */       return arrayList;
/*    */     }
/*    */     
/*    */     try {
/* 39 */       String str = a().z(this.q);
/* 40 */       if (str.isEmpty()) {
/* 41 */         return arrayList;
/*    */       }
/*    */       
/* 44 */       Document document = Jsoup.parse(str);
/* 45 */       Elements elements = document.getElementsByTag("table");
/*    */       
/* 47 */       elements.remove(0);
/* 48 */       Collections.reverse((List<?>)elements);
/*    */       
/* 50 */       for (Element element : elements) {
/* 51 */         Elements elements1 = element.getElementsByTag("span");
/*    */         
/* 53 */         String str1 = elements1.get(0).text();
/* 54 */         String str2 = elements1.get(1).text();
/* 55 */         String str3 = elements1.get(2).text();
/*    */         
/* 57 */         m m = new m(str3, y.a(str2), str1);
/* 58 */         if (a(m)) {
/*    */           break;
/*    */         }
/*    */         
/* 62 */         arrayList.add(m);
/*    */       } 
/*    */       
/* 65 */       Collections.reverse(arrayList);
/* 66 */     } catch (Exception exception) {
/* 67 */       a.warn("Failed to capture new messages", exception);
/*    */     } 
/*    */     
/* 70 */     return arrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   public br.com.arremate.j.a a() {
/* 75 */     return (br.com.arremate.j.a)super.a();
/*    */   }
/*    */   
/*    */   String a() {
/* 79 */     return this.q;
/*    */   }
/*    */   
/*    */   void u(String paramString) {
/* 83 */     this.q = paramString.trim();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\i\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */