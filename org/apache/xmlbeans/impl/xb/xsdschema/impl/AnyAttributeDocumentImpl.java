/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.AnyAttributeDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnyAttributeDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements AnyAttributeDocument
/*    */ {
/*    */   public AnyAttributeDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b ANYATTRIBUTE$0 = new b("http://www.w3.org/2001/XMLSchema", "anyAttribute");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Wildcard getAnyAttribute() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       Wildcard wildcard = null;
/* 36 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$0, 0);
/* 37 */       if (wildcard == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return wildcard;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setAnyAttribute(Wildcard paramWildcard) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       Wildcard wildcard = null;
/* 54 */       wildcard = (Wildcard)get_store().find_element_user(ANYATTRIBUTE$0, 0);
/* 55 */       if (wildcard == null)
/*    */       {
/* 57 */         wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$0);
/*    */       }
/* 59 */       wildcard.set((XmlObject)paramWildcard);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Wildcard addNewAnyAttribute() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       Wildcard wildcard = null;
/* 72 */       wildcard = (Wildcard)get_store().add_element_user(ANYATTRIBUTE$0);
/* 73 */       return wildcard;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AnyAttributeDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */