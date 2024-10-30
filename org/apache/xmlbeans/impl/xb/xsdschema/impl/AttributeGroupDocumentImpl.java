/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributeGroupDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements AttributeGroupDocument
/*    */ {
/*    */   public AttributeGroupDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ATTRIBUTEGROUP$0 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NamedAttributeGroup getAttributeGroup() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NamedAttributeGroup namedAttributeGroup = null;
/* 36 */       namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$0, 0);
/* 37 */       if (namedAttributeGroup == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return namedAttributeGroup;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAttributeGroup(NamedAttributeGroup paramNamedAttributeGroup) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NamedAttributeGroup namedAttributeGroup = null;
/* 54 */       namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$0, 0);
/* 55 */       if (namedAttributeGroup == null)
/*    */       {
/* 57 */         namedAttributeGroup = (NamedAttributeGroup)get_store().add_element_user(ATTRIBUTEGROUP$0);
/*    */       }
/* 59 */       namedAttributeGroup.set((XmlObject)paramNamedAttributeGroup);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NamedAttributeGroup addNewAttributeGroup() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NamedAttributeGroup namedAttributeGroup = null;
/* 72 */       namedAttributeGroup = (NamedAttributeGroup)get_store().add_element_user(ATTRIBUTEGROUP$0);
/* 73 */       return namedAttributeGroup;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AttributeGroupDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */