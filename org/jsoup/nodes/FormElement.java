/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.jsoup.Connection;
/*    */ import org.jsoup.Jsoup;
/*    */ import org.jsoup.helper.HttpConnection;
/*    */ import org.jsoup.helper.Validate;
/*    */ import org.jsoup.parser.Tag;
/*    */ import org.jsoup.select.Elements;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormElement
/*    */   extends Element
/*    */ {
/* 18 */   private final Elements elements = new Elements();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FormElement(Tag paramTag, String paramString, Attributes paramAttributes) {
/* 28 */     super(paramTag, paramString, paramAttributes);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Elements elements() {
/* 36 */     return this.elements;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FormElement addElement(Element paramElement) {
/* 45 */     this.elements.add(paramElement);
/* 46 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Connection submit() {
/* 57 */     String str = hasAttr("action") ? absUrl("action") : baseUri();
/* 58 */     Validate.notEmpty(str, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
/* 59 */     Connection.Method method = attr("method").toUpperCase().equals("POST") ? Connection.Method.POST : Connection.Method.GET;
/*    */ 
/*    */     
/* 62 */     return Jsoup.connect(str).data(formData()).method(method);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Connection.KeyVal> formData() {
/* 75 */     ArrayList<HttpConnection.KeyVal> arrayList = new ArrayList();
/*    */ 
/*    */     
/* 78 */     for (Element element : this.elements) {
/* 79 */       if (!element.tag().isFormSubmittable())
/* 80 */         continue;  String str = element.attr("name");
/* 81 */       if (str.length() == 0)
/*    */         continue; 
/* 83 */       if ("select".equals(element.tagName())) {
/* 84 */         Elements elements = element.select("option[selected]");
/* 85 */         for (Element element1 : elements)
/* 86 */           arrayList.add(HttpConnection.KeyVal.create(str, element1.val())); 
/*    */         continue;
/*    */       } 
/* 89 */       arrayList.add(HttpConnection.KeyVal.create(str, element.val()));
/*    */     } 
/*    */     
/* 92 */     return (List)arrayList;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 97 */     return super.equals(paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\FormElement.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */