/*    */ package org.apache.xmlbeans.impl.jam.annotation;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.AnnotationValueImpl;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
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
/*    */ 
/*    */ public class DefaultAnnotationProxy
/*    */   extends AnnotationProxy
/*    */ {
/* 42 */   private List mValues = new ArrayList();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JAnnotationValue[] getValues() {
/* 53 */     JAnnotationValue[] arrayOfJAnnotationValue = new JAnnotationValue[this.mValues.size()];
/* 54 */     this.mValues.toArray((Object[])arrayOfJAnnotationValue);
/* 55 */     return arrayOfJAnnotationValue;
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
/*    */   public void setValue(String paramString, Object paramObject, JClass paramJClass) {
/* 67 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/* 68 */     if (paramJClass == null) throw new IllegalArgumentException("null type"); 
/* 69 */     if (paramObject == null) throw new IllegalArgumentException("null value"); 
/* 70 */     paramString = paramString.trim();
/* 71 */     this.mValues.add(new AnnotationValueImpl((ElementContext)getLogger(), paramString, paramObject, paramJClass));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\DefaultAnnotationProxy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */