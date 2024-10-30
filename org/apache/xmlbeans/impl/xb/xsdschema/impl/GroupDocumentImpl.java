/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.GroupDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements GroupDocument
/*    */ {
/*    */   public GroupDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b GROUP$0 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NamedGroup getGroup() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NamedGroup namedGroup = null;
/* 36 */       namedGroup = (NamedGroup)get_store().find_element_user(GROUP$0, 0);
/* 37 */       if (namedGroup == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return namedGroup;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setGroup(NamedGroup paramNamedGroup) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NamedGroup namedGroup = null;
/* 54 */       namedGroup = (NamedGroup)get_store().find_element_user(GROUP$0, 0);
/* 55 */       if (namedGroup == null)
/*    */       {
/* 57 */         namedGroup = (NamedGroup)get_store().add_element_user(GROUP$0);
/*    */       }
/* 59 */       namedGroup.set((XmlObject)paramNamedGroup);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NamedGroup addNewGroup() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NamedGroup namedGroup = null;
/* 72 */       namedGroup = (NamedGroup)get_store().add_element_user(GROUP$0);
/* 73 */       return namedGroup;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\GroupDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */