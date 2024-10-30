/*    */ package org.apache.xmlbeans.impl.inst2xsd;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.impl.inst2xsd.util.Element;
/*    */ import org.apache.xmlbeans.impl.inst2xsd.util.Type;
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
/*    */ 
/*    */ public class VenetianBlindStrategy
/*    */   extends RussianDollStrategy
/*    */   implements XsdGenStrategy
/*    */ {
/*    */   protected void checkIfReferenceToGlobalTypeIsNeeded(Element paramElement, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {
/* 35 */     Type type = paramElement.getType();
/* 36 */     b b = paramElement.getName();
/*    */     
/* 38 */     if (type.isGlobal()) {
/*    */       return;
/*    */     }
/*    */     
/* 42 */     if (type.isComplexType())
/*    */     {
/* 44 */       for (byte b1 = 0;; b1++) {
/*    */         
/* 46 */         type.setName(new b(b.getNamespaceURI(), b.dT() + "Type" + (!b1 ? "" : ("" + b1))));
/*    */         
/* 48 */         Type type1 = paramTypeSystemHolder.getGlobalType(type.getName());
/* 49 */         if (type1 == null) {
/*    */           
/* 51 */           type.setGlobal(true);
/* 52 */           paramTypeSystemHolder.addGlobalType(type);
/*    */           
/*    */           break;
/*    */         } 
/*    */         
/* 57 */         if (compatibleTypes(type1, type)) {
/*    */           
/* 59 */           combineTypes(type1, type, paramInst2XsdOptions);
/* 60 */           paramElement.setType(type1);
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean compatibleTypes(Type paramType1, Type paramType2) {
/* 72 */     if (paramType1 == paramType2) {
/* 73 */       return true;
/*    */     }
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
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xsd\VenetianBlindStrategy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */