/*    */ package br.com.arremate.b.a.a;
/*    */ 
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */ {
/*    */   private final Document doc;
/*    */   
/*    */   public static final d a(String paramString) throws Exception {
/* 16 */     return new d(Jsoup.parse(paramString));
/*    */   }
/*    */   
/*    */   private d(Document paramDocument) {
/* 20 */     this.doc = paramDocument;
/*    */   }
/*    */   
/*    */   Elements a() {
/* 24 */     if (this.doc.html().toLowerCase().contains("você não está participando de nenhuma cotação/dispensa eletrônica")) {
/* 25 */       return new Elements();
/*    */     }
/*    */     
/* 28 */     Element element = this.doc.select("table[class=td] > tbody").first();
/* 29 */     if (element == null) {
/* 30 */       return new Elements();
/*    */     }
/*    */     
/* 33 */     return element.select("tr[class=estiloLinhaTabela]");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */