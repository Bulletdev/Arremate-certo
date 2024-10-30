/*    */ package br.com.arremate.d.t;
/*    */ 
/*    */ import br.com.arremate.d.b;
/*    */ import br.com.arremate.h.e;
/*    */ import br.com.arremate.j.i;
/*    */ import br.com.arremate.l.h;
/*    */ import br.com.arremate.l.q.b.e;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */   public d(b paramb, i parami, boolean paramBoolean) {
/* 23 */     super(paramb, parami, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void r(String paramString) {
/*    */     try {
/* 29 */       Document document = Jsoup.parse(paramString);
/* 30 */       Element element = document.select("table[id=dtgPesquisaLote]").first();
/* 31 */       Elements elements1 = element.select("input[id^=dtgPesquisaLote_][id$=_nCdLote]");
/* 32 */       Elements elements2 = element.select(".tdTituloLista");
/*    */       
/* 34 */       elements1.stream().map(paramElement -> Integer.valueOf(Integer.parseInt(paramElement.attr("value"))))
/* 35 */         .forEachOrdered(paramInteger -> {
/*    */             Element element = paramDocument.select("input[id^=dtgPesquisaLote_][id$=_nCdLote][value=" + paramInteger + "]").first().parent().parent();
/*    */             e e1 = a().a(paramInteger.intValue());
/*    */             if (e1 != null) {
/*    */               a(e1, element, paramElements);
/*    */             }
/*    */           });
/* 42 */     } catch (Exception exception) {
/* 43 */       a.error("#005", exception);
/* 44 */       h("#005");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<h> b(e parame) {
/* 52 */     if (parame.bt() && isRunning()) {
/* 53 */       b b = c().get(Integer.valueOf(parame.v()));
/* 54 */       return b.e();
/*    */     } 
/* 56 */     if (j().isEmpty()) {
/* 57 */       b(parame.a());
/*    */     }
/*    */     
/* 60 */     for (String str : u()) {
/* 61 */       if (!"".equals(str)) {
/* 62 */         Document document = Jsoup.parse(str);
/*    */         
/* 64 */         Element element = document.select("input[id^=dtgPesquisaLote_][id$=_nCdLote][value=" + parame.v() + "]").first().parent().parent();
/* 65 */         if (element != null) {
/* 66 */           b b = new b(parame, (i)a(), this);
/* 67 */           b.i(element);
/* 68 */           return b.e();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 74 */     return new ArrayList<>();
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<String> u() {
/* 79 */     ArrayList<String> arrayList = new ArrayList();
/* 80 */     long l = 0L;
/*    */     
/*    */     try {
/* 83 */       for (Map.Entry<Integer, String> entry : j().entrySet()) {
/* 84 */         String str = (String)entry.getValue();
/* 85 */         e e1 = a().p(str);
/* 86 */         l += e1.k();
/* 87 */         arrayList.add(e1.getData());
/*    */       } 
/* 89 */     } catch (Exception exception) {
/* 90 */       a.error("#004", exception);
/* 91 */       h("#004");
/*    */     } 
/*    */     
/* 94 */     e(l);
/* 95 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\t\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */