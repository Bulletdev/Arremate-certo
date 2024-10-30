/*    */ package org.apache.xmlbeans.impl.piccolo.xml;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
/*    */ import org.apache.xmlbeans.impl.piccolo.util.IndexedObject;
/*    */ import org.apache.xmlbeans.impl.piccolo.util.IndexedObjectImpl;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ElementDefinition
/*    */ {
/*    */   String name;
/*    */   AttributeDefinition[] attributes;
/*    */   Map attributeMap;
/* 37 */   int size = 0;
/*    */   
/*    */   public ElementDefinition() {
/* 40 */     this(null);
/*    */   }
/*    */   
/*    */   public ElementDefinition(String paramString) {
/* 44 */     this.name = paramString;
/* 45 */     this.attributes = new AttributeDefinition[4];
/* 46 */     this.attributeMap = new HashMap();
/* 47 */     this.size = 0;
/*    */   }
/*    */   
/*    */   public final String getName() {
/* 51 */     return this.name;
/*    */   }
/*    */   
/*    */   public final void setName(String paramString) {
/* 55 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public final AttributeDefinition[] getAttributes() {
/* 59 */     return this.attributes;
/*    */   }
/*    */   
/*    */   public final int getAttributeCount() {
/* 63 */     return this.size;
/*    */   }
/*    */   
/*    */   public final IndexedObject getIndexedAttribute(String paramString) {
/* 67 */     return (IndexedObject)this.attributeMap.get(paramString);
/*    */   }
/*    */   
/*    */   public final AttributeDefinition getAttribute(int paramInt) {
/* 71 */     return this.attributes[paramInt];
/*    */   }
/*    */   
/*    */   public final void addAttribute(AttributeDefinition paramAttributeDefinition) throws DuplicateKeyException {
/* 75 */     IndexedObjectImpl indexedObjectImpl = new IndexedObjectImpl(this.size, paramAttributeDefinition);
/* 76 */     Object object = this.attributeMap.put(paramAttributeDefinition.getQName(), indexedObjectImpl);
/*    */ 
/*    */     
/* 79 */     if (object != null) {
/* 80 */       this.attributeMap.put(paramAttributeDefinition.getQName(), object);
/* 81 */       throw new DuplicateKeyException("attribute '" + paramAttributeDefinition.getQName() + "' is already defined for element '" + this.name + "'.");
/*    */     } 
/*    */ 
/*    */     
/* 85 */     if (this.size >= this.attributes.length) {
/* 86 */       AttributeDefinition[] arrayOfAttributeDefinition = new AttributeDefinition[this.size * 2];
/* 87 */       System.arraycopy(this.attributes, 0, arrayOfAttributeDefinition, 0, this.size);
/* 88 */       this.attributes = arrayOfAttributeDefinition;
/*    */     } 
/* 90 */     this.attributes[this.size++] = paramAttributeDefinition;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\ElementDefinition.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */