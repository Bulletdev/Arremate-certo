/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tag
/*     */ {
/*  14 */   private static final Map<String, Tag> tags = new HashMap<String, Tag>();
/*     */   
/*     */   private String tagName;
/*     */   private boolean isBlock = true;
/*     */   private boolean formatAsBlock = true;
/*     */   private boolean canContainBlock = true;
/*     */   private boolean canContainInline = true;
/*     */   private boolean empty = false;
/*     */   private boolean selfClosing = false;
/*     */   private boolean preserveWhitespace = false;
/*     */   private boolean formList = false;
/*     */   private boolean formSubmit = false;
/*     */   
/*     */   private Tag(String paramString) {
/*  28 */     this.tagName = paramString.toLowerCase();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  37 */     return this.tagName;
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
/*     */   public static Tag valueOf(String paramString) {
/*  49 */     Validate.notNull(paramString);
/*  50 */     Tag tag = tags.get(paramString);
/*     */     
/*  52 */     if (tag == null) {
/*  53 */       paramString = paramString.trim().toLowerCase();
/*  54 */       Validate.notEmpty(paramString);
/*  55 */       tag = tags.get(paramString);
/*     */       
/*  57 */       if (tag == null) {
/*     */         
/*  59 */         tag = new Tag(paramString);
/*  60 */         tag.isBlock = false;
/*  61 */         tag.canContainBlock = true;
/*     */       } 
/*     */     } 
/*  64 */     return tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlock() {
/*  73 */     return this.isBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean formatAsBlock() {
/*  82 */     return this.formatAsBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canContainBlock() {
/*  91 */     return this.canContainBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInline() {
/* 100 */     return !this.isBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isData() {
/* 109 */     return (!this.canContainInline && !isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 118 */     return this.empty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSelfClosing() {
/* 127 */     return (this.empty || this.selfClosing);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isKnownTag() {
/* 136 */     return tags.containsKey(this.tagName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isKnownTag(String paramString) {
/* 146 */     return tags.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean preserveWhitespace() {
/* 155 */     return this.preserveWhitespace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormListed() {
/* 163 */     return this.formList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFormSubmittable() {
/* 171 */     return this.formSubmit;
/*     */   }
/*     */   
/*     */   Tag setSelfClosing() {
/* 175 */     this.selfClosing = true;
/* 176 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 181 */     if (this == paramObject) return true; 
/* 182 */     if (!(paramObject instanceof Tag)) return false;
/*     */     
/* 184 */     Tag tag = (Tag)paramObject;
/*     */     
/* 186 */     if (this.canContainBlock != tag.canContainBlock) return false; 
/* 187 */     if (this.canContainInline != tag.canContainInline) return false; 
/* 188 */     if (this.empty != tag.empty) return false; 
/* 189 */     if (this.formatAsBlock != tag.formatAsBlock) return false; 
/* 190 */     if (this.isBlock != tag.isBlock) return false; 
/* 191 */     if (this.preserveWhitespace != tag.preserveWhitespace) return false; 
/* 192 */     if (this.selfClosing != tag.selfClosing) return false; 
/* 193 */     if (this.formList != tag.formList) return false; 
/* 194 */     if (this.formSubmit != tag.formSubmit) return false; 
/* 195 */     if (!this.tagName.equals(tag.tagName)) return false;
/*     */     
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 202 */     int i = this.tagName.hashCode();
/* 203 */     i = 31 * i + (this.isBlock ? 1 : 0);
/* 204 */     i = 31 * i + (this.formatAsBlock ? 1 : 0);
/* 205 */     i = 31 * i + (this.canContainBlock ? 1 : 0);
/* 206 */     i = 31 * i + (this.canContainInline ? 1 : 0);
/* 207 */     i = 31 * i + (this.empty ? 1 : 0);
/* 208 */     i = 31 * i + (this.selfClosing ? 1 : 0);
/* 209 */     i = 31 * i + (this.preserveWhitespace ? 1 : 0);
/* 210 */     i = 31 * i + (this.formList ? 1 : 0);
/* 211 */     i = 31 * i + (this.formSubmit ? 1 : 0);
/* 212 */     return i;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 216 */     return this.tagName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 221 */   private static final String[] blockTags = new String[] { "html", "head", "body", "frameset", "script", "noscript", "style", "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", "header", "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "s", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 228 */   private static final String[] inlineTags = new String[] { "object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 235 */   private static final String[] emptyTags = new String[] { "meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track" };
/*     */ 
/*     */ 
/*     */   
/* 239 */   private static final String[] formatAsInlineTags = new String[] { "title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", "s" };
/*     */ 
/*     */ 
/*     */   
/* 243 */   private static final String[] preserveWhitespaceTags = new String[] { "pre", "plaintext", "title", "textarea" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 248 */   private static final String[] formListedTags = new String[] { "button", "fieldset", "input", "keygen", "object", "output", "select", "textarea" };
/*     */ 
/*     */   
/* 251 */   private static final String[] formSubmitTags = new String[] { "input", "keygen", "object", "select", "textarea" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 257 */     for (String str : blockTags) {
/* 258 */       Tag tag = new Tag(str);
/* 259 */       register(tag);
/*     */     } 
/* 261 */     for (String str : inlineTags) {
/* 262 */       Tag tag = new Tag(str);
/* 263 */       tag.isBlock = false;
/* 264 */       tag.canContainBlock = false;
/* 265 */       tag.formatAsBlock = false;
/* 266 */       register(tag);
/*     */     } 
/*     */ 
/*     */     
/* 270 */     for (String str : emptyTags) {
/* 271 */       Tag tag = tags.get(str);
/* 272 */       Validate.notNull(tag);
/* 273 */       tag.canContainBlock = false;
/* 274 */       tag.canContainInline = false;
/* 275 */       tag.empty = true;
/*     */     } 
/*     */     
/* 278 */     for (String str : formatAsInlineTags) {
/* 279 */       Tag tag = tags.get(str);
/* 280 */       Validate.notNull(tag);
/* 281 */       tag.formatAsBlock = false;
/*     */     } 
/*     */     
/* 284 */     for (String str : preserveWhitespaceTags) {
/* 285 */       Tag tag = tags.get(str);
/* 286 */       Validate.notNull(tag);
/* 287 */       tag.preserveWhitespace = true;
/*     */     } 
/*     */     
/* 290 */     for (String str : formListedTags) {
/* 291 */       Tag tag = tags.get(str);
/* 292 */       Validate.notNull(tag);
/* 293 */       tag.formList = true;
/*     */     } 
/*     */     
/* 296 */     for (String str : formSubmitTags) {
/* 297 */       Tag tag = tags.get(str);
/* 298 */       Validate.notNull(tag);
/* 299 */       tag.formSubmit = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void register(Tag paramTag) {
/* 304 */     tags.put(paramTag.tagName, paramTag);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\Tag.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */