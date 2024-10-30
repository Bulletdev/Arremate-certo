/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements AttributeDocument
/*    */ {
/*    */   public AttributeDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ATTRIBUTE$0 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelAttribute getAttribute() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       TopLevelAttribute topLevelAttribute = null;
/* 36 */       topLevelAttribute = (TopLevelAttribute)get_store().find_element_user(ATTRIBUTE$0, 0);
/* 37 */       if (topLevelAttribute == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return topLevelAttribute;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttribute(TopLevelAttribute paramTopLevelAttribute) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       TopLevelAttribute topLevelAttribute = null;
/* 54 */       topLevelAttribute = (TopLevelAttribute)get_store().find_element_user(ATTRIBUTE$0, 0);
/* 55 */       if (topLevelAttribute == null)
/*    */       {
/* 57 */         topLevelAttribute = (TopLevelAttribute)get_store().add_element_user(ATTRIBUTE$0);
/*    */       }
/* 59 */       topLevelAttribute.set((XmlObject)paramTopLevelAttribute);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelAttribute addNewAttribute() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       TopLevelAttribute topLevelAttribute = null;
/* 72 */       topLevelAttribute = (TopLevelAttribute)get_store().add_element_user(ATTRIBUTE$0);
/* 73 */       return topLevelAttribute;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AttributeDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */