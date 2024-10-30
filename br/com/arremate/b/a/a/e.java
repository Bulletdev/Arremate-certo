/*    */ package br.com.arremate.b.a.a;
/*    */ 
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class e
/*    */ {
/*    */   private final Document doc;
/*    */   
/*    */   public static final e a(String paramString) throws Exception {
/* 15 */     return new e(Jsoup.parse(paramString));
/*    */   }
/*    */   
/*    */   private e(Document paramDocument) {
/* 19 */     this.doc = paramDocument;
/*    */   }
/*    */   
/*    */   Elements b() {
/* 23 */     if (this.doc.html().toLowerCase().contains("não existem cotações/dispensas")) {
/* 24 */       return new Elements();
/*    */     }
/*    */     
/* 27 */     Elements elements = this.doc.select("table[class=td] > tbody > tr");
/* 28 */     if (elements.isEmpty()) {
/* 29 */       return new Elements();
/*    */     }
/*    */     
/* 32 */     elements.remove(0);
/* 33 */     elements.remove(0);
/* 34 */     return elements;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */