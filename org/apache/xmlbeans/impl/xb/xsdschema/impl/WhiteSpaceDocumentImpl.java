/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.WhiteSpaceDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WhiteSpaceDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements WhiteSpaceDocument
/*     */ {
/*     */   public WhiteSpaceDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b WHITESPACE$0 = new b("http://www.w3.org/2001/XMLSchema", "whiteSpace");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WhiteSpaceDocument.WhiteSpace getWhiteSpace() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/*  36 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$0, 0);
/*  37 */       if (whiteSpace == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return whiteSpace;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWhiteSpace(WhiteSpaceDocument.WhiteSpace paramWhiteSpace) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/*  54 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().find_element_user(WHITESPACE$0, 0);
/*  55 */       if (whiteSpace == null)
/*     */       {
/*  57 */         whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().add_element_user(WHITESPACE$0);
/*     */       }
/*  59 */       whiteSpace.set((XmlObject)paramWhiteSpace);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WhiteSpaceDocument.WhiteSpace addNewWhiteSpace() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       WhiteSpaceDocument.WhiteSpace whiteSpace = null;
/*  72 */       whiteSpace = (WhiteSpaceDocument.WhiteSpace)get_store().add_element_user(WHITESPACE$0);
/*  73 */       return whiteSpace;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class WhiteSpaceImpl
/*     */     extends FacetImpl
/*     */     implements WhiteSpaceDocument.WhiteSpace
/*     */   {
/*     */     public WhiteSpaceImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class ValueImpl
/*     */       extends JavaStringEnumerationHolderEx
/*     */       implements WhiteSpaceDocument.WhiteSpace.Value
/*     */     {
/*     */       public ValueImpl(SchemaType param2SchemaType) {
/* 100 */         super(param2SchemaType, false);
/*     */       }
/*     */ 
/*     */       
/*     */       protected ValueImpl(SchemaType param2SchemaType, boolean param2Boolean) {
/* 105 */         super(param2SchemaType, param2Boolean);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\WhiteSpaceDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */