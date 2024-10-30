/*    */ package org.apache.poi.xslf.model;
/*    */ 
/*    */ import org.apache.poi.xslf.usermodel.XSLFShape;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TextBodyPropertyFetcher<T>
/*    */   extends PropertyFetcher<T>
/*    */ {
/*    */   public boolean fetch(XSLFShape paramXSLFShape) {
/* 37 */     XmlObject[] arrayOfXmlObject = paramXSLFShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:bodyPr");
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 42 */     if (arrayOfXmlObject.length == 1) {
/* 43 */       CTTextBodyProperties cTTextBodyProperties = (CTTextBodyProperties)arrayOfXmlObject[0];
/* 44 */       return fetch(cTTextBodyProperties);
/*    */     } 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public abstract boolean fetch(CTTextBodyProperties paramCTTextBodyProperties);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xslf\model\TextBodyPropertyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */