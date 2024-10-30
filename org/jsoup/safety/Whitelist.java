/*     */ package org.jsoup.safety;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.Element;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Whitelist
/*     */ {
/*     */   private Set<TagName> tagNames;
/*     */   private Map<TagName, Set<AttributeKey>> attributes;
/*     */   private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes;
/*     */   private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols;
/*     */   private boolean preserveRelativeLinks;
/*     */   
/*     */   public static Whitelist none() {
/*  63 */     return new Whitelist();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Whitelist simpleText() {
/*  73 */     return (new Whitelist()).addTags(new String[] { "b", "em", "i", "strong", "u" });
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Whitelist basic() {
/*  90 */     return (new Whitelist()).addTags(new String[] { "a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em", "i", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong", "sub", "sup", "u", "ul" }).addAttributes("a", new String[] { "href" }).addAttributes("blockquote", new String[] { "cite" }).addAttributes("q", new String[] { "cite" }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto" }).addProtocols("blockquote", "cite", new String[] { "http", "https" }).addProtocols("cite", "cite", new String[] { "http", "https" }).addEnforcedAttribute("a", "rel", "nofollow");
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
/*     */   public static Whitelist basicWithImages() {
/* 116 */     return basic().addTags(new String[] { "img" }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width" }).addProtocols("img", "src", new String[] { "http", "https" });
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Whitelist relaxed() {
/* 133 */     return (new Whitelist()).addTags(new String[] { "a", "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd", "div", "dl", "dt", "em", "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", "q", "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul" }).addAttributes("a", new String[] { "href", "title" }).addAttributes("blockquote", new String[] { "cite" }).addAttributes("col", new String[] { "span", "width" }).addAttributes("colgroup", new String[] { "span", "width" }).addAttributes("img", new String[] { "align", "alt", "height", "src", "title", "width" }).addAttributes("ol", new String[] { "start", "type" }).addAttributes("q", new String[] { "cite" }).addAttributes("table", new String[] { "summary", "width" }).addAttributes("td", new String[] { "abbr", "axis", "colspan", "rowspan", "width" }).addAttributes("th", new String[] { "abbr", "axis", "colspan", "rowspan", "scope", "width" }).addAttributes("ul", new String[] { "type" }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto" }).addProtocols("blockquote", "cite", new String[] { "http", "https" }).addProtocols("cite", "cite", new String[] { "http", "https" }).addProtocols("img", "src", new String[] { "http", "https" }).addProtocols("q", "cite", new String[] { "http", "https" });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Whitelist() {
/* 172 */     this.tagNames = new HashSet<TagName>();
/* 173 */     this.attributes = new HashMap<TagName, Set<AttributeKey>>();
/* 174 */     this.enforcedAttributes = new HashMap<TagName, Map<AttributeKey, AttributeValue>>();
/* 175 */     this.protocols = new HashMap<TagName, Map<AttributeKey, Set<Protocol>>>();
/* 176 */     this.preserveRelativeLinks = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Whitelist addTags(String... paramVarArgs) {
/* 186 */     Validate.notNull(paramVarArgs);
/*     */     
/* 188 */     for (String str : paramVarArgs) {
/* 189 */       Validate.notEmpty(str);
/* 190 */       this.tagNames.add(TagName.valueOf(str));
/*     */     } 
/* 192 */     return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Whitelist addAttributes(String paramString, String... paramVarArgs) {
/* 209 */     Validate.notEmpty(paramString);
/* 210 */     Validate.notNull(paramVarArgs);
/* 211 */     Validate.isTrue((paramVarArgs.length > 0), "No attributes supplied.");
/*     */     
/* 213 */     TagName tagName = TagName.valueOf(paramString);
/* 214 */     if (!this.tagNames.contains(tagName))
/* 215 */       this.tagNames.add(tagName); 
/* 216 */     HashSet<AttributeKey> hashSet = new HashSet();
/* 217 */     for (String str : paramVarArgs) {
/* 218 */       Validate.notEmpty(str);
/* 219 */       hashSet.add(AttributeKey.valueOf(str));
/*     */     } 
/* 221 */     if (this.attributes.containsKey(tagName)) {
/* 222 */       Set<AttributeKey> set = this.attributes.get(tagName);
/* 223 */       set.addAll(hashSet);
/*     */     } else {
/* 225 */       this.attributes.put(tagName, hashSet);
/*     */     } 
/* 227 */     return this;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Whitelist addEnforcedAttribute(String paramString1, String paramString2, String paramString3) {
/* 243 */     Validate.notEmpty(paramString1);
/* 244 */     Validate.notEmpty(paramString2);
/* 245 */     Validate.notEmpty(paramString3);
/*     */     
/* 247 */     TagName tagName = TagName.valueOf(paramString1);
/* 248 */     if (!this.tagNames.contains(tagName))
/* 249 */       this.tagNames.add(tagName); 
/* 250 */     AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/* 251 */     AttributeValue attributeValue = AttributeValue.valueOf(paramString3);
/*     */     
/* 253 */     if (this.enforcedAttributes.containsKey(tagName)) {
/* 254 */       ((Map<AttributeKey, AttributeValue>)this.enforcedAttributes.get(tagName)).put(attributeKey, attributeValue);
/*     */     } else {
/* 256 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 257 */       hashMap.put(attributeKey, attributeValue);
/* 258 */       this.enforcedAttributes.put(tagName, hashMap);
/*     */     } 
/* 260 */     return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Whitelist preserveRelativeLinks(boolean paramBoolean) {
/* 278 */     this.preserveRelativeLinks = paramBoolean;
/* 279 */     return this;
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
/*     */   public Whitelist addProtocols(String paramString1, String paramString2, String... paramVarArgs) {
/*     */     Map<AttributeKey, HashSet> map;
/*     */     Set<Protocol> set;
/* 294 */     Validate.notEmpty(paramString1);
/* 295 */     Validate.notEmpty(paramString2);
/* 296 */     Validate.notNull(paramVarArgs);
/*     */     
/* 298 */     TagName tagName = TagName.valueOf(paramString1);
/* 299 */     AttributeKey attributeKey = AttributeKey.valueOf(paramString2);
/*     */ 
/*     */ 
/*     */     
/* 303 */     if (this.protocols.containsKey(tagName)) {
/* 304 */       map = (Map)this.protocols.get(tagName);
/*     */     } else {
/* 306 */       map = (Map)new HashMap<Object, Object>();
/* 307 */       this.protocols.put(tagName, map);
/*     */     } 
/* 309 */     if (map.containsKey(attributeKey)) {
/* 310 */       set = (Set)map.get(attributeKey);
/*     */     } else {
/* 312 */       set = new HashSet();
/* 313 */       map.put(attributeKey, (HashSet)set);
/*     */     } 
/* 315 */     for (String str : paramVarArgs) {
/* 316 */       Validate.notEmpty(str);
/* 317 */       Protocol protocol = Protocol.valueOf(str);
/* 318 */       set.add(protocol);
/*     */     } 
/* 320 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSafeTag(String paramString) {
/* 329 */     return this.tagNames.contains(TagName.valueOf(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isSafeAttribute(String paramString, Element paramElement, Attribute paramAttribute) {
/* 340 */     TagName tagName = TagName.valueOf(paramString);
/* 341 */     AttributeKey attributeKey = AttributeKey.valueOf(paramAttribute.getKey());
/*     */     
/* 343 */     if (this.attributes.containsKey(tagName) && (
/* 344 */       (Set)this.attributes.get(tagName)).contains(attributeKey)) {
/* 345 */       if (this.protocols.containsKey(tagName)) {
/* 346 */         Map map = this.protocols.get(tagName);
/*     */         
/* 348 */         return (!map.containsKey(attributeKey) || testValidProtocol(paramElement, paramAttribute, (Set<Protocol>)map.get(attributeKey)));
/*     */       } 
/* 350 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 355 */     return (!paramString.equals(":all") && isSafeAttribute(":all", paramElement, paramAttribute));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean testValidProtocol(Element paramElement, Attribute paramAttribute, Set<Protocol> paramSet) {
/* 361 */     String str = paramElement.absUrl(paramAttribute.getKey());
/* 362 */     if (str.length() == 0)
/* 363 */       str = paramAttribute.getValue(); 
/* 364 */     if (!this.preserveRelativeLinks) {
/* 365 */       paramAttribute.setValue(str);
/*     */     }
/* 367 */     for (Protocol protocol : paramSet) {
/* 368 */       String str1 = protocol.toString() + ":";
/* 369 */       if (str.toLowerCase().startsWith(str1)) {
/* 370 */         return true;
/*     */       }
/*     */     } 
/* 373 */     return false;
/*     */   }
/*     */   
/*     */   Attributes getEnforcedAttributes(String paramString) {
/* 377 */     Attributes attributes = new Attributes();
/* 378 */     TagName tagName = TagName.valueOf(paramString);
/* 379 */     if (this.enforcedAttributes.containsKey(tagName)) {
/* 380 */       Map map = this.enforcedAttributes.get(tagName);
/* 381 */       for (Map.Entry entry : map.entrySet()) {
/* 382 */         attributes.put(((AttributeKey)entry.getKey()).toString(), ((AttributeValue)entry.getValue()).toString());
/*     */       }
/*     */     } 
/* 385 */     return attributes;
/*     */   }
/*     */   
/*     */   static class TagName
/*     */     extends TypedValue
/*     */   {
/*     */     TagName(String param1String) {
/* 392 */       super(param1String);
/*     */     }
/*     */     
/*     */     static TagName valueOf(String param1String) {
/* 396 */       return new TagName(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AttributeKey extends TypedValue {
/*     */     AttributeKey(String param1String) {
/* 402 */       super(param1String);
/*     */     }
/*     */     
/*     */     static AttributeKey valueOf(String param1String) {
/* 406 */       return new AttributeKey(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class AttributeValue extends TypedValue {
/*     */     AttributeValue(String param1String) {
/* 412 */       super(param1String);
/*     */     }
/*     */     
/*     */     static AttributeValue valueOf(String param1String) {
/* 416 */       return new AttributeValue(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Protocol extends TypedValue {
/*     */     Protocol(String param1String) {
/* 422 */       super(param1String);
/*     */     }
/*     */     
/*     */     static Protocol valueOf(String param1String) {
/* 426 */       return new Protocol(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class TypedValue {
/*     */     private String value;
/*     */     
/*     */     TypedValue(String param1String) {
/* 434 */       Validate.notNull(param1String);
/* 435 */       this.value = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 440 */       byte b = 31;
/* 441 */       int i = 1;
/* 442 */       i = 31 * i + ((this.value == null) ? 0 : this.value.hashCode());
/* 443 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 448 */       if (this == param1Object) return true; 
/* 449 */       if (param1Object == null) return false; 
/* 450 */       if (getClass() != param1Object.getClass()) return false; 
/* 451 */       TypedValue typedValue = (TypedValue)param1Object;
/* 452 */       if (this.value == null)
/* 453 */       { if (typedValue.value != null) return false;  }
/* 454 */       else if (!this.value.equals(typedValue.value)) { return false; }
/* 455 */        return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 460 */       return this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\safety\Whitelist.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */