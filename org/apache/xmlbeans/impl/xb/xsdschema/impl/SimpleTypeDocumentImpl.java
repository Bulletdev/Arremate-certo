/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleTypeDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleTypeDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements SimpleTypeDocument
/*    */ {
/*    */   public SimpleTypeDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelSimpleType getSimpleType() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       TopLevelSimpleType topLevelSimpleType = null;
/* 36 */       topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/* 37 */       if (topLevelSimpleType == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return topLevelSimpleType;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSimpleType(TopLevelSimpleType paramTopLevelSimpleType) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       TopLevelSimpleType topLevelSimpleType = null;
/* 54 */       topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/* 55 */       if (topLevelSimpleType == null)
/*    */       {
/* 57 */         topLevelSimpleType = (TopLevelSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*    */       }
/* 59 */       topLevelSimpleType.set((XmlObject)paramTopLevelSimpleType);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TopLevelSimpleType addNewSimpleType() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       TopLevelSimpleType topLevelSimpleType = null;
/* 72 */       topLevelSimpleType = (TopLevelSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/* 73 */       return topLevelSimpleType;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SimpleTypeDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */