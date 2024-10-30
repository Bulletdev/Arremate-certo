/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexTypeDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ComplexTypeDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements ComplexTypeDocument
/*    */ {
/*    */   public ComplexTypeDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b COMPLEXTYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "complexType");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelComplexType getComplexType() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       TopLevelComplexType topLevelComplexType = null;
/* 36 */       topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$0, 0);
/* 37 */       if (topLevelComplexType == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return topLevelComplexType;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setComplexType(TopLevelComplexType paramTopLevelComplexType) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       TopLevelComplexType topLevelComplexType = null;
/* 54 */       topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$0, 0);
/* 55 */       if (topLevelComplexType == null)
/*    */       {
/* 57 */         topLevelComplexType = (TopLevelComplexType)get_store().add_element_user(COMPLEXTYPE$0);
/*    */       }
/* 59 */       topLevelComplexType.set((XmlObject)paramTopLevelComplexType);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelComplexType addNewComplexType() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       TopLevelComplexType topLevelComplexType = null;
/* 72 */       topLevelComplexType = (TopLevelComplexType)get_store().add_element_user(COMPLEXTYPE$0);
/* 73 */       return topLevelComplexType;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ComplexTypeDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */