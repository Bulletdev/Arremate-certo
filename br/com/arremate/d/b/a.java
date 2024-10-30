/*    */ package br.com.arremate.d.b;
/*    */ 
/*    */ import br.com.arremate.d.e;
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.m;
/*    */ import br.com.arremate.m.y;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends e
/*    */ {
/*    */   public a(c paramc, br.com.arremate.j.a.a parama) {
/* 22 */     super(paramc, (i)parama);
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<m> d() {
/* 27 */     ArrayList<m> arrayList = new ArrayList();
/*    */     
/*    */     try {
/* 30 */       String str = a().b(a().a().bo()).getData();
/* 31 */       if (!str.isEmpty()) {
/* 32 */         Document document = Jsoup.parse(str);
/* 33 */         Elements elements = document.select("div[id=lista_mensagens] > ul > li > div > div");
/*    */         
/* 35 */         for (int i = elements.size() - 1; i >= 0; i--) {
/* 36 */           Element element = elements.get(i);
/* 37 */           Elements elements1 = element.select("p");
/* 38 */           Elements elements2 = elements1.select("span");
/* 39 */           Elements elements3 = element.select("span[class=msg]");
/*    */           
/* 41 */           String str1 = elements2.get(0).text().trim();
/* 42 */           String str2 = elements2.get(2).text().trim();
/* 43 */           String str3 = elements2.get(4).text().trim();
/* 44 */           String str4 = elements3.text().trim();
/* 45 */           str4 = "Para " + str3 + ": " + str4;
/*    */           
/* 47 */           m m = new m(str4, y.a(str1), str2);
/* 48 */           if (a(m)) {
/*    */             break;
/*    */           }
/*    */           
/* 52 */           arrayList.add(0, m);
/*    */         } 
/*    */       } 
/* 55 */     } catch (Exception exception) {
/* 56 */       a.info("Failed to read messages", exception);
/*    */     } 
/*    */     
/* 59 */     return arrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   public br.com.arremate.j.a.a a() {
/* 64 */     return (br.com.arremate.j.a.a)super.a();
/*    */   }
/*    */ 
/*    */   
/*    */   public c a() {
/* 69 */     return (c)super.a();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */