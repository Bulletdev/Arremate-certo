/*     */ package org.apache.xmlbeans.impl.inst2xsd.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.values.XmlQNameImpl;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Type
/*     */ {
/*     */   private b _name;
/*  33 */   private int _kind = 1;
/*     */   
/*     */   public static final int SIMPLE_TYPE_SIMPLE_CONTENT = 1;
/*     */   
/*     */   public static final int COMPLEX_TYPE_SIMPLE_CONTENT = 2;
/*     */   public static final int COMPLEX_TYPE_COMPLEX_CONTENT = 3;
/*     */   public static final int COMPLEX_TYPE_MIXED_CONTENT = 4;
/*     */   public static final int COMPLEX_TYPE_EMPTY_CONTENT = 5;
/*  41 */   private int _topParticleForComplexOrMixedContent = 1;
/*     */   
/*     */   public static final int PARTICLE_SEQUENCE = 1;
/*     */   
/*     */   public static final int PARTICLE_CHOICE_UNBOUNDED = 2;
/*     */   
/*     */   private List _elements;
/*     */   
/*     */   private List _attributes;
/*     */   
/*     */   private Type _extensionType;
/*     */   
/*     */   private boolean _isGlobal = false;
/*     */   
/*     */   private List _enumerationValues;
/*     */   
/*     */   private boolean _acceptsEnumerationValue = true;
/*     */   
/*     */   private List _enumerationQNames;
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static Type createNamedType(b paramb, int paramInt) {
/*  63 */     assert paramb != null;
/*  64 */     Type type = new Type();
/*  65 */     type.setName(paramb);
/*  66 */     type.setContentType(paramInt);
/*  67 */     return type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type createUnnamedType(int paramInt) {
/*  76 */     assert paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 : "Unknown contentType: " + paramInt;
/*  77 */     Type type = new Type();
/*  78 */     type.setContentType(paramInt);
/*  79 */     return type;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public b getName() {
/*  85 */     return this._name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setName(b paramb) {
/*  90 */     this._name = paramb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getContentType() {
/* 103 */     return this._kind;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(int paramInt) {
/* 116 */     this._kind = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public List getElements() {
/* 121 */     ensureElements();
/* 122 */     return this._elements;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addElement(Element paramElement) {
/* 127 */     ensureElements();
/* 128 */     this._elements.add(paramElement);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setElements(List paramList) {
/* 133 */     ensureElements();
/* 134 */     this._elements.clear();
/* 135 */     this._elements.addAll(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   private void ensureElements() {
/* 140 */     if (this._elements == null) {
/* 141 */       this._elements = new ArrayList();
/*     */     }
/*     */   }
/*     */   
/*     */   public List getAttributes() {
/* 146 */     ensureAttributes();
/* 147 */     return this._attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addAttribute(Attribute paramAttribute) {
/* 152 */     ensureAttributes();
/* 153 */     this._attributes.add(paramAttribute);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute getAttribute(b paramb) {
/* 158 */     for (byte b1 = 0; b1 < this._attributes.size(); b1++) {
/*     */       
/* 160 */       Attribute attribute = this._attributes.get(b1);
/* 161 */       if (attribute.getName().equals(paramb))
/* 162 */         return attribute; 
/*     */     } 
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void ensureAttributes() {
/* 169 */     if (this._attributes == null) {
/* 170 */       this._attributes = new ArrayList();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isComplexType() {
/* 175 */     return (this._kind == 3 || this._kind == 4 || this._kind == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasSimpleContent() {
/* 182 */     return (this._kind == 1 || this._kind == 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTopParticleForComplexOrMixedContent() {
/* 191 */     return this._topParticleForComplexOrMixedContent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopParticleForComplexOrMixedContent(int paramInt) {
/* 199 */     this._topParticleForComplexOrMixedContent = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGlobal() {
/* 204 */     return this._isGlobal;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setGlobal(boolean paramBoolean) {
/* 209 */     assert paramBoolean && getName() != null;
/* 210 */     this._isGlobal = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getExtensionType() {
/* 215 */     return this._extensionType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExtensionType(Type paramType) {
/* 220 */     assert this._kind == 2 : "Extension used only for type which are COMPLEX_TYPE_SIMPLE_CONTENT";
/* 221 */     assert paramType != null && paramType.getName() != null : "Extended type must be a named type.";
/* 222 */     this._extensionType = paramType;
/*     */   }
/*     */ 
/*     */   
/*     */   public List getEnumerationValues() {
/* 227 */     ensureEnumerationValues();
/* 228 */     return this._enumerationValues;
/*     */   }
/*     */ 
/*     */   
/*     */   public List getEnumerationQNames() {
/* 233 */     ensureEnumerationValues();
/* 234 */     return this._enumerationQNames;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addEnumerationValue(String paramString, final XmlCursor xc) {
/* 239 */     assert this._kind == 1 || this._kind == 2 : "Enumerations possible only on simple content";
/* 240 */     ensureEnumerationValues();
/* 241 */     if (this._acceptsEnumerationValue && !this._enumerationValues.contains(paramString)) {
/*     */       
/* 243 */       this._enumerationValues.add(paramString);
/* 244 */       if (this._name.equals(XmlQName.type.getName())) {
/*     */ 
/*     */         
/* 247 */         PrefixResolver prefixResolver = new PrefixResolver() { private final XmlCursor val$xc;
/*     */             
/*     */             public String getNamespaceForPrefix(String param1String) {
/* 250 */               return xc.namespaceForPrefix(param1String);
/*     */             } private final Type this$0; }
/*     */           ;
/* 253 */         b b1 = XmlQNameImpl.validateLexical(paramString, null, prefixResolver);
/*     */         
/* 255 */         assert b1 != null : "The check for QName should allready have happened.";
/* 256 */         this._enumerationQNames.add(b1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void ensureEnumerationValues() {
/* 263 */     if (this._enumerationValues == null) {
/*     */       
/* 265 */       this._enumerationValues = new ArrayList();
/* 266 */       this._enumerationQNames = new ArrayList();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEnumeration() {
/* 272 */     return (this._acceptsEnumerationValue && this._enumerationValues != null && this._enumerationValues.size() > 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQNameEnumeration() {
/* 277 */     return (isEnumeration() && this._name.equals(XmlQName.type.getName()) && this._enumerationQNames != null && this._enumerationQNames.size() > 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeEnumeration() {
/* 282 */     this._acceptsEnumerationValue = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 287 */     return "Type{_name = " + this._name + ", _extensionType = " + this._extensionType + ", _kind = " + this._kind + ", _elements = " + this._elements + ", _attributes = " + this._attributes + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAllEnumerationsFrom(Type paramType) {
/* 298 */     assert this._kind == 1 || this._kind == 2 : "Enumerations possible only on simple content";
/* 299 */     ensureEnumerationValues();
/*     */     
/* 301 */     if (this._name.equals(XmlQName.type.getName()) && paramType._name.equals(XmlQName.type.getName())) {
/*     */       
/* 303 */       for (byte b1 = 0; b1 < paramType.getEnumerationValues().size(); b1++) {
/*     */         
/* 305 */         String str = paramType.getEnumerationValues().get(b1);
/* 306 */         b b2 = paramType.getEnumerationQNames().get(b1);
/* 307 */         if (this._acceptsEnumerationValue && !this._enumerationQNames.contains(b2))
/*     */         {
/* 309 */           this._enumerationValues.add(str);
/* 310 */           this._enumerationQNames.add(b2);
/*     */         }
/*     */       
/*     */       } 
/*     */     } else {
/*     */       
/* 316 */       for (byte b1 = 0; b1 < paramType.getEnumerationValues().size(); b1++) {
/*     */         
/* 318 */         String str = paramType.getEnumerationValues().get(b1);
/* 319 */         if (this._acceptsEnumerationValue && !this._enumerationValues.contains(str))
/*     */         {
/* 321 */           this._enumerationValues.add(str);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xs\\util\Type.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */