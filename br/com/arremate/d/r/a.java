/*    */ package br.com.arremate.d.r;
/*    */ 
/*    */ import br.com.arremate.d.e;
/*    */ import br.com.arremate.d.g;
/*    */ import br.com.arremate.h.e;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.m;
/*    */ import br.com.arremate.m.y;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends e
/*    */ {
/* 19 */   private m b = null;
/*    */   
/*    */   public a(g paramg, i parami) {
/* 22 */     super(paramg, parami);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<m> d() {
/* 27 */     ArrayList<m> arrayList = new ArrayList();
/* 28 */     e e1 = a().v(a().a().v());
/*    */     
/*    */     try {
/* 31 */       Document document = Jsoup.parse(e1.getData());
/* 32 */       Elements elements = document.select("tr[class^=linha_]");
/*    */       
/* 34 */       for (byte b = 0; b < elements.size(); b++) {
/* 35 */         Elements elements1 = elements.get(b).select("td");
/*    */         
/* 37 */         m m1 = new m();
/* 38 */         m1.c(y.a(elements1.get(0).text()));
/* 39 */         m1.aE(elements1.get(1).text());
/*    */         
/* 41 */         String str1 = elements1.get(3).text();
/* 42 */         if (str1.contains("Batida Iminente para o item")) {
/* 43 */           byte[] arrayOfByte = str1.getBytes("ISO-8859-1");
/* 44 */           str1 = new String(arrayOfByte, "UTF-8");
/*    */         } 
/*    */         
/* 47 */         m1.f(str1);
/*    */         
/* 49 */         String str2 = elements1.get(2).text();
/* 50 */         if (!str2.toLowerCase().contains("pregão")) {
/* 51 */           m1.T(str2.replaceAll("\\D", ""));
/*    */         }
/*    */         
/* 54 */         if (d(m1)) {
/*    */           break;
/*    */         }
/*    */         
/* 58 */         arrayList.add(m1);
/*    */       } 
/*    */       
/* 61 */       if (!arrayList.isEmpty()) {
/* 62 */         this.b = arrayList.get(0);
/*    */       }
/*    */     }
/* 65 */     catch (Exception exception) {
/* 66 */       a.warn("Failed to get bidding message", exception);
/*    */     } 
/*    */     
/* 69 */     return arrayList;
/*    */   }
/*    */   
/*    */   private boolean d(m paramm) {
/* 73 */     if (this.b == null) {
/* 74 */       return false;
/*    */     }
/*    */     
/* 77 */     return (this.b.a(paramm) >= 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public c a() {
/* 82 */     return (c)super.a();
/*    */   }
/*    */ 
/*    */   
/*    */   public br.com.arremate.j.k.a a() {
/* 87 */     return (br.com.arremate.j.k.a)super.a();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\r\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */