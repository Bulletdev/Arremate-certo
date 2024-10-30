/*    */ package org.apache.poi.xslf.model;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.xslf.usermodel.XSLFShape;
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
/*    */ 
/*    */ 
/*    */ @Internal
/*    */ public abstract class PropertyFetcher<T>
/*    */ {
/*    */   private T _value;
/*    */   
/*    */   public abstract boolean fetch(XSLFShape paramXSLFShape);
/*    */   
/*    */   public T getValue() {
/* 42 */     return this._value;
/*    */   }
/*    */   
/*    */   public void setValue(T paramT) {
/* 46 */     this._value = paramT;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xslf\model\PropertyFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */