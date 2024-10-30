/*    */ package org.apache.poi.xslf.model;
/*    */ 
/*    */ import org.apache.poi.xslf.usermodel.XSLFShape;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
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
/*    */ public abstract class ParagraphPropertyFetcher<T>
/*    */   extends PropertyFetcher<T>
/*    */ {
/*    */   int _level;
/*    */   
/*    */   public ParagraphPropertyFetcher(int paramInt) {
/* 34 */     this._level = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean fetch(XSLFShape paramXSLFShape) {
/* 39 */     XmlObject[] arrayOfXmlObject = paramXSLFShape.getXmlObject().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//p:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     if (arrayOfXmlObject.length == 1) {
/* 45 */       CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties)arrayOfXmlObject[0];
/* 46 */       return fetch(cTTextParagraphProperties);
/*    */     } 
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public abstract boolean fetch(CTTextParagraphProperties paramCTTextParagraphProperties);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xslf\model\ParagraphPropertyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */