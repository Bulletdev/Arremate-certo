/*    */ package br.com.arremate.d.u;
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
/*    */ public class d
/*    */   extends e
/*    */ {
/*    */   public d(f paramf, br.com.arremate.j.l.a.d paramd) {
/* 22 */     super(paramf, (i)paramd);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<m> d() {
/* 27 */     ArrayList<m> arrayList = new ArrayList();
/*    */     
/*    */     try {
/* 30 */       int i = a().a().v();
/* 31 */       String str = a().l(i);
/*    */       
/* 33 */       if (str != null && str.length() > 0) {
/* 34 */         Document document = Jsoup.parse(str);
/* 35 */         Elements elements = document.select("table[class=td]");
/*    */         
/* 37 */         if (elements.size() <= 0) {
/* 38 */           return arrayList;
/*    */         }
/*    */         
/* 41 */         elements = elements.first().select("tr");
/*    */         
/* 43 */         if (elements == null) {
/* 44 */           return arrayList;
/*    */         }
/*    */ 
/*    */ 
/*    */         
/* 49 */         for (byte b = 0; b < elements.size(); b++) {
/* 50 */           m m = b(elements.get(b));
/*    */           
/* 52 */           if (a(m)) {
/*    */             break;
/*    */           }
/*    */           
/* 56 */           arrayList.add(0, m);
/*    */         } 
/*    */       } 
/* 59 */     } catch (Exception exception) {
/* 60 */       a.warn("Failed to captura new messages", exception);
/*    */     } 
/*    */     
/* 63 */     return arrayList;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private m b(Element paramElement) {
/* 74 */     String str1 = paramElement.select("span[class=mensagem2]").text();
/* 75 */     String str2 = paramElement.select("td[class=tex3b]").text();
/* 76 */     String str3 = paramElement.select("td[class=tex3]").text();
/*    */     
/* 78 */     str2 = str2.replace(str1, "").replace(":", "").replace("informa", "").replace("fala", "").trim();
/* 79 */     str1 = str1.replaceAll("[()]", "").trim();
/*    */     
/* 81 */     return new m(str3, y.a(str1), str2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public br.com.arremate.j.l.a.d a() {
/* 87 */     return (br.com.arremate.j.l.a.d)super.a();
/*    */   }
/*    */ 
/*    */   
/*    */   public g a() {
/* 92 */     return super.a();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */