/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Token
/*     */ {
/*     */   TokenType type;
/*     */   
/*     */   private Token() {}
/*     */   
/*     */   String tokenType() {
/*  17 */     return getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   static class Doctype extends Token {
/*  21 */     final StringBuilder name = new StringBuilder();
/*  22 */     final StringBuilder publicIdentifier = new StringBuilder();
/*  23 */     final StringBuilder systemIdentifier = new StringBuilder();
/*     */     boolean forceQuirks = false;
/*     */     
/*     */     Doctype() {
/*  27 */       this.type = Token.TokenType.Doctype;
/*     */     }
/*     */     
/*     */     String getName() {
/*  31 */       return this.name.toString();
/*     */     }
/*     */     
/*     */     String getPublicIdentifier() {
/*  35 */       return this.publicIdentifier.toString();
/*     */     }
/*     */     
/*     */     public String getSystemIdentifier() {
/*  39 */       return this.systemIdentifier.toString();
/*     */     }
/*     */     
/*     */     public boolean isForceQuirks() {
/*  43 */       return this.forceQuirks;
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract class Tag extends Token {
/*     */     protected String tagName;
/*     */     private String pendingAttributeName;
/*     */     
/*     */     Tag() {
/*  52 */       this.selfClosing = false;
/*     */     }
/*     */     private StringBuilder pendingAttributeValue; boolean selfClosing; Attributes attributes;
/*     */     void newAttribute() {
/*  56 */       if (this.attributes == null) {
/*  57 */         this.attributes = new Attributes();
/*     */       }
/*  59 */       if (this.pendingAttributeName != null) {
/*     */         Attribute attribute;
/*  61 */         if (this.pendingAttributeValue == null) {
/*  62 */           attribute = new Attribute(this.pendingAttributeName, "");
/*     */         } else {
/*  64 */           attribute = new Attribute(this.pendingAttributeName, this.pendingAttributeValue.toString());
/*  65 */         }  this.attributes.put(attribute);
/*     */       } 
/*  67 */       this.pendingAttributeName = null;
/*  68 */       if (this.pendingAttributeValue != null) {
/*  69 */         this.pendingAttributeValue.delete(0, this.pendingAttributeValue.length());
/*     */       }
/*     */     }
/*     */     
/*     */     void finaliseTag() {
/*  74 */       if (this.pendingAttributeName != null)
/*     */       {
/*  76 */         newAttribute();
/*     */       }
/*     */     }
/*     */     
/*     */     String name() {
/*  81 */       Validate.isFalse((this.tagName == null || this.tagName.length() == 0));
/*  82 */       return this.tagName;
/*     */     }
/*     */     
/*     */     Tag name(String param1String) {
/*  86 */       this.tagName = param1String;
/*  87 */       return this;
/*     */     }
/*     */     
/*     */     boolean isSelfClosing() {
/*  91 */       return this.selfClosing;
/*     */     }
/*     */ 
/*     */     
/*     */     Attributes getAttributes() {
/*  96 */       return this.attributes;
/*     */     }
/*     */ 
/*     */     
/*     */     void appendTagName(String param1String) {
/* 101 */       this.tagName = (this.tagName == null) ? param1String : this.tagName.concat(param1String);
/*     */     }
/*     */     
/*     */     void appendTagName(char param1Char) {
/* 105 */       appendTagName(String.valueOf(param1Char));
/*     */     }
/*     */     
/*     */     void appendAttributeName(String param1String) {
/* 109 */       this.pendingAttributeName = (this.pendingAttributeName == null) ? param1String : this.pendingAttributeName.concat(param1String);
/*     */     }
/*     */     
/*     */     void appendAttributeName(char param1Char) {
/* 113 */       appendAttributeName(String.valueOf(param1Char));
/*     */     }
/*     */     
/*     */     void appendAttributeValue(String param1String) {
/* 117 */       ensureAttributeValue();
/* 118 */       this.pendingAttributeValue.append(param1String);
/*     */     }
/*     */     
/*     */     void appendAttributeValue(char param1Char) {
/* 122 */       ensureAttributeValue();
/* 123 */       this.pendingAttributeValue.append(param1Char);
/*     */     }
/*     */     
/*     */     void appendAttributeValue(char[] param1ArrayOfchar) {
/* 127 */       ensureAttributeValue();
/* 128 */       this.pendingAttributeValue.append(param1ArrayOfchar);
/*     */     }
/*     */     
/*     */     private final void ensureAttributeValue() {
/* 132 */       if (this.pendingAttributeValue == null) {
/* 133 */         this.pendingAttributeValue = new StringBuilder();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class StartTag
/*     */     extends Tag
/*     */   {
/*     */     StartTag() {}
/*     */     
/*     */     StartTag(String param1String) {
/* 145 */       this();
/* 146 */       this.tagName = param1String;
/*     */     }
/*     */     
/*     */     StartTag(String param1String, Attributes param1Attributes) {
/* 150 */       this();
/* 151 */       this.tagName = param1String;
/* 152 */       this.attributes = param1Attributes;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 157 */       if (this.attributes != null && this.attributes.size() > 0) {
/* 158 */         return "<" + name() + " " + this.attributes.toString() + ">";
/*     */       }
/* 160 */       return "<" + name() + ">";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class EndTag
/*     */     extends Tag
/*     */   {
/*     */     EndTag() {}
/*     */     
/*     */     EndTag(String param1String) {
/* 171 */       this();
/* 172 */       this.tagName = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 177 */       return "</" + name() + ">";
/*     */     }
/*     */   }
/*     */   
/*     */   static class Comment extends Token {
/* 182 */     final StringBuilder data = new StringBuilder();
/*     */     boolean bogus = false;
/*     */     
/*     */     Comment() {
/* 186 */       this.type = Token.TokenType.Comment;
/*     */     }
/*     */     
/*     */     String getData() {
/* 190 */       return this.data.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 195 */       return "<!--" + getData() + "-->";
/*     */     }
/*     */   }
/*     */   
/*     */   static class Character extends Token {
/*     */     private final String data;
/*     */     
/*     */     Character(String param1String) {
/* 203 */       this.type = Token.TokenType.Character;
/* 204 */       this.data = param1String;
/*     */     }
/*     */     
/*     */     String getData() {
/* 208 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 213 */       return getData();
/*     */     }
/*     */   }
/*     */   
/*     */   static class EOF extends Token {
/*     */     EOF() {
/* 219 */       this.type = Token.TokenType.EOF;
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isDoctype() {
/* 224 */     return (this.type == TokenType.Doctype);
/*     */   }
/*     */   
/*     */   Doctype asDoctype() {
/* 228 */     return (Doctype)this;
/*     */   }
/*     */   
/*     */   boolean isStartTag() {
/* 232 */     return (this.type == TokenType.StartTag);
/*     */   }
/*     */   
/*     */   StartTag asStartTag() {
/* 236 */     return (StartTag)this;
/*     */   }
/*     */   
/*     */   boolean isEndTag() {
/* 240 */     return (this.type == TokenType.EndTag);
/*     */   }
/*     */   
/*     */   EndTag asEndTag() {
/* 244 */     return (EndTag)this;
/*     */   }
/*     */   
/*     */   boolean isComment() {
/* 248 */     return (this.type == TokenType.Comment);
/*     */   }
/*     */   
/*     */   Comment asComment() {
/* 252 */     return (Comment)this;
/*     */   }
/*     */   
/*     */   boolean isCharacter() {
/* 256 */     return (this.type == TokenType.Character);
/*     */   }
/*     */   
/*     */   Character asCharacter() {
/* 260 */     return (Character)this;
/*     */   }
/*     */   
/*     */   boolean isEOF() {
/* 264 */     return (this.type == TokenType.EOF);
/*     */   }
/*     */   
/*     */   enum TokenType {
/* 268 */     Doctype,
/* 269 */     StartTag,
/* 270 */     EndTag,
/* 271 */     Comment,
/* 272 */     Character,
/* 273 */     EOF;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\Token.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */