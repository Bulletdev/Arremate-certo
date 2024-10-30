/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.EnumerationDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EnumerationDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements EnumerationDocument
/*    */ {
/*    */   public EnumerationDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ENUMERATION$0 = new b("http://www.w3.org/2001/XMLSchema", "enumeration");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NoFixedFacet getEnumeration() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NoFixedFacet noFixedFacet = null;
/* 36 */       noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$0, 0);
/* 37 */       if (noFixedFacet == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return noFixedFacet;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setEnumeration(NoFixedFacet paramNoFixedFacet) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NoFixedFacet noFixedFacet = null;
/* 54 */       noFixedFacet = (NoFixedFacet)get_store().find_element_user(ENUMERATION$0, 0);
/* 55 */       if (noFixedFacet == null)
/*    */       {
/* 57 */         noFixedFacet = (NoFixedFacet)get_store().add_element_user(ENUMERATION$0);
/*    */       }
/* 59 */       noFixedFacet.set((XmlObject)paramNoFixedFacet);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NoFixedFacet addNewEnumeration() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NoFixedFacet noFixedFacet = null;
/* 72 */       noFixedFacet = (NoFixedFacet)get_store().add_element_user(ENUMERATION$0);
/* 73 */       return noFixedFacet;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\EnumerationDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */