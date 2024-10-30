/*     */ package org.apache.xmlbeans.impl.xb.xmlschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpaceAttributeImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements SpaceAttribute
/*     */ {
/*     */   public SpaceAttributeImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b SPACE$0 = new b("http://www.w3.org/XML/1998/namespace", "space");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SpaceAttribute.Space.Enum getSpace() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       SimpleValue simpleValue = null;
/*  36 */       simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$0);
/*  37 */       if (simpleValue == null)
/*     */       {
/*  39 */         simpleValue = (SimpleValue)get_default_attribute_value(SPACE$0);
/*     */       }
/*  41 */       if (simpleValue == null)
/*     */       {
/*  43 */         return null;
/*     */       }
/*  45 */       return (SpaceAttribute.Space.Enum)simpleValue.getEnumValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SpaceAttribute.Space xgetSpace() {
/*  54 */     synchronized (monitor()) {
/*     */       
/*  56 */       check_orphaned();
/*  57 */       SpaceAttribute.Space space = null;
/*  58 */       space = (SpaceAttribute.Space)get_store().find_attribute_user(SPACE$0);
/*  59 */       if (space == null)
/*     */       {
/*  61 */         space = (SpaceAttribute.Space)get_default_attribute_value(SPACE$0);
/*     */       }
/*  63 */       return space;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetSpace() {
/*  72 */     synchronized (monitor()) {
/*     */       
/*  74 */       check_orphaned();
/*  75 */       return (get_store().find_attribute_user(SPACE$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSpace(SpaceAttribute.Space.Enum paramEnum) {
/*  84 */     synchronized (monitor()) {
/*     */       
/*  86 */       check_orphaned();
/*  87 */       SimpleValue simpleValue = null;
/*  88 */       simpleValue = (SimpleValue)get_store().find_attribute_user(SPACE$0);
/*  89 */       if (simpleValue == null)
/*     */       {
/*  91 */         simpleValue = (SimpleValue)get_store().add_attribute_user(SPACE$0);
/*     */       }
/*  93 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetSpace(SpaceAttribute.Space paramSpace) {
/* 102 */     synchronized (monitor()) {
/*     */       
/* 104 */       check_orphaned();
/* 105 */       SpaceAttribute.Space space = null;
/* 106 */       space = (SpaceAttribute.Space)get_store().find_attribute_user(SPACE$0);
/* 107 */       if (space == null)
/*     */       {
/* 109 */         space = (SpaceAttribute.Space)get_store().add_attribute_user(SPACE$0);
/*     */       }
/* 111 */       space.set((XmlObject)paramSpace);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetSpace() {
/* 120 */     synchronized (monitor()) {
/*     */       
/* 122 */       check_orphaned();
/* 123 */       get_store().remove_attribute(SPACE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SpaceImpl
/*     */     extends JavaStringEnumerationHolderEx
/*     */     implements SpaceAttribute.Space
/*     */   {
/*     */     public SpaceImpl(SchemaType param1SchemaType) {
/* 136 */       super(param1SchemaType, false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SpaceImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 141 */       super(param1SchemaType, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\impl\SpaceAttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */