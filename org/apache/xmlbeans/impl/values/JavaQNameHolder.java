/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.common.XMLChar;
/*     */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
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
/*     */ public class JavaQNameHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   private b _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  36 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_QNAME;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  41 */     return 1;
/*     */   }
/*     */   
/*  44 */   private static final NamespaceManager PRETTY_PREFIXER = new PrettyNamespaceManager();
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static class PrettyNamespaceManager
/*     */     implements NamespaceManager {
/*     */     public String find_prefix_for_nsuri(String param1String1, String param1String2) {
/*  50 */       return QNameHelper.suggestPrefix(param1String1);
/*     */     }
/*     */     private PrettyNamespaceManager() {}
/*     */     public String getNamespaceForPrefix(String param1String) {
/*  54 */       throw new RuntimeException("Should not be called");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String compute_text(NamespaceManager paramNamespaceManager) {
/*  61 */     if (paramNamespaceManager == null)
/*     */     {
/*     */ 
/*     */       
/*  65 */       paramNamespaceManager = PRETTY_PREFIXER;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     String str1 = this._value.getNamespaceURI();
/*  74 */     String str2 = this._value.dT();
/*     */     
/*  76 */     if (str1 == null || str1.length() == 0) {
/*  77 */       return str2;
/*     */     }
/*  79 */     String str3 = paramNamespaceManager.find_prefix_for_nsuri(str1, null);
/*     */     
/*  81 */     assert str3 != null;
/*     */     
/*  83 */     return "".equals(str3) ? str2 : (str3 + ":" + str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b validateLexical(String paramString, ValidationContext paramValidationContext, PrefixResolver paramPrefixResolver) {
/*     */     b b1;
/*     */     try {
/*  93 */       b1 = parse(paramString, paramPrefixResolver);
/*     */     }
/*  95 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*     */       
/*  97 */       paramValidationContext.invalid(xmlValueOutOfRangeException.getMessage());
/*  98 */       b1 = null;
/*     */     } 
/*     */     
/* 101 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static b parse(String paramString, PrefixResolver paramPrefixResolver) {
/*     */     String str1, str2;
/*     */     int i;
/* 109 */     for (i = paramString.length(); i > 0 && 
/* 110 */       XMLChar.isSpace(paramString.charAt(i - 1)); i--);
/*     */     byte b1;
/* 112 */     for (b1 = 0; b1 < i && 
/* 113 */       XMLChar.isSpace(paramString.charAt(b1)); b1++);
/*     */ 
/*     */     
/* 116 */     int j = paramString.indexOf(':', b1);
/* 117 */     if (j >= 0) {
/*     */       
/* 119 */       str1 = paramString.substring(b1, j);
/* 120 */       str2 = paramString.substring(j + 1, i);
/*     */     }
/*     */     else {
/*     */       
/* 124 */       str1 = "";
/* 125 */       str2 = paramString.substring(b1, i);
/*     */     } 
/*     */     
/* 128 */     if (str1.length() > 0 && !XMLChar.isValidNCName(str1)) {
/* 129 */       throw new XmlValueOutOfRangeException("QName", new Object[] { "Prefix not a valid NCName in '" + paramString + "'" });
/*     */     }
/* 131 */     if (!XMLChar.isValidNCName(str2)) {
/* 132 */       throw new XmlValueOutOfRangeException("QName", new Object[] { "Localname not a valid NCName in '" + paramString + "'" });
/*     */     }
/* 134 */     String str3 = (paramPrefixResolver == null) ? null : paramPrefixResolver.getNamespaceForPrefix(str1);
/*     */ 
/*     */     
/* 137 */     if (str3 == null) {
/*     */       
/* 139 */       if (str1.length() > 0) {
/* 140 */         throw new XmlValueOutOfRangeException("QName", new Object[] { "Can't resolve prefix '" + str1 + "'" });
/*     */       }
/* 142 */       str3 = "";
/*     */     } 
/*     */     
/* 145 */     if (str1 != null && str1.length() > 0) {
/* 146 */       return new b(str3, str2, str1);
/*     */     }
/* 148 */     return new b(str3, str2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/* 153 */     PrefixResolver prefixResolver = NamespaceContext.getCurrent();
/*     */     
/* 155 */     if (prefixResolver == null && has_store()) {
/* 156 */       prefixResolver = get_store();
/*     */     }
/* 158 */     this._value = parse(paramString, prefixResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_QName(b paramb) {
/* 164 */     assert paramb != null;
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (has_store()) {
/* 169 */       get_store().find_prefix_for_nsuri(paramb.getNamespaceURI(), null);
/*     */     }
/* 171 */     this._value = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_xmlanysimple(XmlAnySimpleType paramXmlAnySimpleType) {
/* 176 */     this._value = parse(paramXmlAnySimpleType.getStringValue(), NamespaceContext.getCurrent());
/*     */   }
/*     */   protected void set_nil() {
/* 179 */     this._value = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public b getQNameValue() {
/* 185 */     check_dated();
/* 186 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 192 */     return this._value.equals(((XmlObjectBase)paramXmlObject).qNameValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 197 */     return this._value.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaQNameHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */