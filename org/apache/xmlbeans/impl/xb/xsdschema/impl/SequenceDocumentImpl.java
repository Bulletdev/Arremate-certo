/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.SequenceDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SequenceDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements SequenceDocument
/*    */ {
/*    */   public SequenceDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b SEQUENCE$0 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ExplicitGroup getSequence() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       ExplicitGroup explicitGroup = null;
/* 36 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$0, 0);
/* 37 */       if (explicitGroup == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return explicitGroup;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSequence(ExplicitGroup paramExplicitGroup) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       ExplicitGroup explicitGroup = null;
/* 54 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$0, 0);
/* 55 */       if (explicitGroup == null)
/*    */       {
/* 57 */         explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$0);
/*    */       }
/* 59 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ExplicitGroup addNewSequence() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       ExplicitGroup explicitGroup = null;
/* 72 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$0);
/* 73 */       return explicitGroup;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SequenceDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */