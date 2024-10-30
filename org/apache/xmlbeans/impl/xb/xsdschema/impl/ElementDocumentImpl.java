/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.ElementDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ElementDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements ElementDocument
/*    */ {
/*    */   public ElementDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ELEMENT$0 = new b("http://www.w3.org/2001/XMLSchema", "element");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelElement getElement() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       TopLevelElement topLevelElement = null;
/* 36 */       topLevelElement = (TopLevelElement)get_store().find_element_user(ELEMENT$0, 0);
/* 37 */       if (topLevelElement == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return topLevelElement;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setElement(TopLevelElement paramTopLevelElement) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       TopLevelElement topLevelElement = null;
/* 54 */       topLevelElement = (TopLevelElement)get_store().find_element_user(ELEMENT$0, 0);
/* 55 */       if (topLevelElement == null)
/*    */       {
/* 57 */         topLevelElement = (TopLevelElement)get_store().add_element_user(ELEMENT$0);
/*    */       }
/* 59 */       topLevelElement.set((XmlObject)paramTopLevelElement);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelElement addNewElement() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       TopLevelElement topLevelElement = null;
/* 72 */       topLevelElement = (TopLevelElement)get_store().add_element_user(ELEMENT$0);
/* 73 */       return topLevelElement;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ElementDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */