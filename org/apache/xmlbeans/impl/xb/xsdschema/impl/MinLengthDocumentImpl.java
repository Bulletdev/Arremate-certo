/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.MinLengthDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.NumFacet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MinLengthDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements MinLengthDocument
/*    */ {
/*    */   public MinLengthDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b MINLENGTH$0 = new b("http://www.w3.org/2001/XMLSchema", "minLength");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet getMinLength() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       NumFacet numFacet = null;
/* 36 */       numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$0, 0);
/* 37 */       if (numFacet == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMinLength(NumFacet paramNumFacet) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       NumFacet numFacet = null;
/* 54 */       numFacet = (NumFacet)get_store().find_element_user(MINLENGTH$0, 0);
/* 55 */       if (numFacet == null)
/*    */       {
/* 57 */         numFacet = (NumFacet)get_store().add_element_user(MINLENGTH$0);
/*    */       }
/* 59 */       numFacet.set((XmlObject)paramNumFacet);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NumFacet addNewMinLength() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       NumFacet numFacet = null;
/* 72 */       numFacet = (NumFacet)get_store().add_element_user(MINLENGTH$0);
/* 73 */       return numFacet;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\MinLengthDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */