/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.MinExclusiveDocument;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinExclusiveDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements MinExclusiveDocument
/*    */ {
/*    */   public MinExclusiveDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b MINEXCLUSIVE$0 = new b("http://www.w3.org/2001/XMLSchema", "minExclusive");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Facet getMinExclusive() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       Facet facet = null;
/* 36 */       facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$0, 0);
/* 37 */       if (facet == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return facet;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMinExclusive(Facet paramFacet) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       Facet facet = null;
/* 54 */       facet = (Facet)get_store().find_element_user(MINEXCLUSIVE$0, 0);
/* 55 */       if (facet == null)
/*    */       {
/* 57 */         facet = (Facet)get_store().add_element_user(MINEXCLUSIVE$0);
/*    */       }
/* 59 */       facet.set((XmlObject)paramFacet);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Facet addNewMinExclusive() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       Facet facet = null;
/* 72 */       facet = (Facet)get_store().add_element_user(MINEXCLUSIVE$0);
/* 73 */       return facet;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\MinExclusiveDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */