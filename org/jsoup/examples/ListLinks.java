/*    */ package org.jsoup.examples;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.helper.Validate;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ListLinks
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) throws IOException {
/* 16 */     Validate.isTrue((paramArrayOfString.length == 1), "usage: supply url to fetch");
/* 17 */     String str = paramArrayOfString[0];
/* 18 */     print("Fetching %s...", new Object[] { str });
/*    */     
/* 20 */     Document document = Jsoup.connect(str).get();
/* 21 */     Elements elements1 = document.select("a[href]");
/* 22 */     Elements elements2 = document.select("[src]");
/* 23 */     Elements elements3 = document.select("link[href]");
/*    */     
/* 25 */     print("\nMedia: (%d)", new Object[] { Integer.valueOf(elements2.size()) });
/* 26 */     for (Element element : elements2) {
/* 27 */       if (element.tagName().equals("img")) {
/* 28 */         print(" * %s: <%s> %sx%s (%s)", new Object[] { element.tagName(), element.attr("abs:src"), element.attr("width"), element.attr("height"), trim(element.attr("alt"), 20) });
/*    */         
/*    */         continue;
/*    */       } 
/* 32 */       print(" * %s: <%s>", new Object[] { element.tagName(), element.attr("abs:src") });
/*    */     } 
/*    */     
/* 35 */     print("\nImports: (%d)", new Object[] { Integer.valueOf(elements3.size()) });
/* 36 */     for (Element element : elements3) {
/* 37 */       print(" * %s <%s> (%s)", new Object[] { element.tagName(), element.attr("abs:href"), element.attr("rel") });
/*    */     } 
/*    */     
/* 40 */     print("\nLinks: (%d)", new Object[] { Integer.valueOf(elements1.size()) });
/* 41 */     for (Element element : elements1) {
/* 42 */       print(" * a: <%s>  (%s)", new Object[] { element.attr("abs:href"), trim(element.text(), 35) });
/*    */     } 
/*    */   }
/*    */   
/*    */   private static void print(String paramString, Object... paramVarArgs) {
/* 47 */     System.out.println(String.format(paramString, paramVarArgs));
/*    */   }
/*    */   
/*    */   private static String trim(String paramString, int paramInt) {
/* 51 */     if (paramString.length() > paramInt) {
/* 52 */       return paramString.substring(0, paramInt - 1) + ".";
/*    */     }
/* 54 */     return paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\examples\ListLinks.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */