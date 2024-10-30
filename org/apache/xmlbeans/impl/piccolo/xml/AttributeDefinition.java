/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
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
/*     */ public final class AttributeDefinition
/*     */ {
/*     */   public static final int IMPLIED = 1;
/*     */   public static final int REQUIRED = 2;
/*     */   public static final int FIXED = 3;
/*     */   public static final int ENUMERATION = 1;
/*     */   public static final int NOTATION = 2;
/*     */   public static final int CDATA = 3;
/*     */   public static final int ID = 4;
/*     */   public static final int IDREF = 5;
/*     */   public static final int IDREFS = 6;
/*     */   public static final int ENTITY = 7;
/*     */   public static final int ENTITIES = 8;
/*     */   public static final int NMTOKEN = 9;
/*     */   public static final int NMTOKENS = 10;
/*  45 */   private static final String[] valueTypeStrings = new String[] { null, "NMTOKEN", "NOTATION", "CDATA", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", "NMTOKEN", "NMTOKENS" };
/*     */ 
/*     */ 
/*     */   
/*  49 */   private static final String[] defaultTypeStrings = new String[] { null, "#IMPLIED", "#REQUIRED", "#FIXED" };
/*     */   
/*     */   String prefix;
/*     */   
/*     */   String localName;
/*     */   String qName;
/*     */   int valueType;
/*     */   int defaultType;
/*     */   String defaultValue;
/*     */   String[] possibleValues;
/*     */   
/*     */   public AttributeDefinition(String paramString1, String paramString2, String paramString3, int paramInt1, String[] paramArrayOfString, int paramInt2, String paramString4) {
/*  61 */     this.prefix = paramString1;
/*  62 */     this.localName = paramString2;
/*  63 */     this.qName = paramString3;
/*  64 */     this.valueType = paramInt1;
/*  65 */     this.possibleValues = paramArrayOfString;
/*  66 */     this.defaultType = paramInt2;
/*  67 */     this.defaultValue = paramString4;
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/*  71 */     return this.prefix;
/*     */   }
/*     */   
/*     */   public String getLocalName() {
/*  75 */     return this.localName;
/*     */   }
/*     */   
/*     */   public String getQName() {
/*  79 */     return this.qName;
/*     */   }
/*     */   
/*     */   public int getValueType() {
/*  83 */     return this.valueType;
/*     */   }
/*     */   
/*     */   public String getValueTypeString() {
/*  87 */     return getValueTypeString(this.valueType);
/*     */   }
/*     */   
/*     */   public static String getValueTypeString(int paramInt) {
/*  91 */     return valueTypeStrings[paramInt];
/*     */   }
/*     */   
/*     */   public int getDefaultType() {
/*  95 */     return this.defaultType;
/*     */   }
/*     */   
/*     */   public String getDefaultTypeString() {
/*  99 */     return getDefaultTypeString(this.defaultType);
/*     */   }
/*     */   
/*     */   public static String getDefaultTypeString(int paramInt) {
/* 103 */     return defaultTypeStrings[paramInt];
/*     */   }
/*     */   
/*     */   public String getDefaultValue() {
/* 107 */     return this.defaultValue;
/*     */   }
/*     */   
/*     */   public String[] getPossibleValues() {
/* 111 */     return this.possibleValues;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\AttributeDefinition.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */