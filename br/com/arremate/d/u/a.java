/*    */ package br.com.arremate.d.u;
/*    */ 
/*    */ import org.jsoup.nodes.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/*    */   private final Element e;
/*    */   
/*    */   public a(Element paramElement) {
/* 14 */     this.e = paramElement;
/*    */   }
/*    */   
/*    */   public String A() {
/* 18 */     String str = "";
/* 19 */     if (this.e == null) {
/* 20 */       return str;
/*    */     }
/*    */     
/*    */     try {
/* 24 */       str = this.e.select("input[name=ippCod]").first().attr("value");
/* 25 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 28 */     return str;
/*    */   }
/*    */   
/*    */   public String B() {
/* 32 */     String str = "";
/* 33 */     if (this.e == null) {
/* 34 */       return str;
/*    */     }
/*    */     
/*    */     try {
/* 38 */       str = this.e.select("input[name=valormin]").first().attr("value");
/* 39 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 42 */     return str;
/*    */   }
/*    */   
/*    */   public String C() {
/* 46 */     String str = "";
/* 47 */     if (this.e == null) {
/* 48 */       return str;
/*    */     }
/*    */     
/*    */     try {
/* 52 */       str = this.e.select("input[name=menorlance]").first().attr("value");
/* 53 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 56 */     return str;
/*    */   }
/*    */   
/*    */   public String D() {
/* 60 */     String str = "";
/* 61 */     if (this.e == null) {
/* 62 */       return str;
/*    */     }
/*    */     
/*    */     try {
/* 66 */       str = this.e.select("input[name=formajulg]").first().attr("value");
/* 67 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 70 */     return str;
/*    */   }
/*    */   
/*    */   public String E() {
/* 74 */     String str = "";
/* 75 */     if (this.e == null) {
/* 76 */       return str;
/*    */     }
/*    */     
/*    */     try {
/* 80 */       str = this.e.select("input[name=fatorEqualiz]").first().attr("value");
/* 81 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 84 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */