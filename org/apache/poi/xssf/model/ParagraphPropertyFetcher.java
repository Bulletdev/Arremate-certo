/*    */ package org.apache.poi.xssf.model;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
/*    */ import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;
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
/*    */ @Internal
/*    */ public abstract class ParagraphPropertyFetcher<T>
/*    */ {
/*    */   private T _value;
/*    */   private int _level;
/*    */   
/*    */   public T getValue() {
/* 37 */     return this._value;
/*    */   }
/*    */   
/*    */   public void setValue(T paramT) {
/* 41 */     this._value = paramT;
/*    */   }
/*    */   
/*    */   public ParagraphPropertyFetcher(int paramInt) {
/* 45 */     this._level = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean fetch(CTShape paramCTShape) {
/* 55 */     XmlObject[] arrayOfXmlObject = paramCTShape.selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 60 */     if (arrayOfXmlObject.length == 1) {
/* 61 */       CTTextParagraphProperties cTTextParagraphProperties = (CTTextParagraphProperties)arrayOfXmlObject[0];
/* 62 */       return fetch(cTTextParagraphProperties);
/*    */     } 
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public abstract boolean fetch(CTTextParagraphProperties paramCTTextParagraphProperties);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\model\ParagraphPropertyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */