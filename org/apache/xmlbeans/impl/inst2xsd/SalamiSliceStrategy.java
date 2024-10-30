/*    */ package org.apache.xmlbeans.impl.inst2xsd;
/*    */ 
/*    */ import org.apache.xmlbeans.impl.inst2xsd.util.Element;
/*    */ import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
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
/*    */ public class SalamiSliceStrategy
/*    */   extends RussianDollStrategy
/*    */   implements XsdGenStrategy
/*    */ {
/*    */   protected void checkIfElementReferenceIsNeeded(Element paramElement, String paramString, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {
/* 32 */     Element element = new Element();
/* 33 */     element.setGlobal(true);
/* 34 */     element.setName(paramElement.getName());
/* 35 */     element.setType(paramElement.getType());
/*    */     
/* 37 */     if (paramElement.isNillable()) {
/*    */       
/* 39 */       element.setNillable(true);
/* 40 */       paramElement.setNillable(false);
/*    */     } 
/*    */     
/* 43 */     element = addGlobalElement(element, paramTypeSystemHolder, paramInst2XsdOptions);
/*    */     
/* 45 */     paramElement.setRef(element);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xsd\SalamiSliceStrategy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */