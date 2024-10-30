/*     */ package org.apache.commons.text.lookup;
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
/*     */ public enum DefaultStringLookup
/*     */ {
/*  34 */   BASE64_DECODER("base64Decoder", StringLookupFactory.INSTANCE.base64DecoderStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   BASE64_ENCODER("base64Encoder", StringLookupFactory.INSTANCE.base64EncoderStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   CONST("const", StringLookupFactory.INSTANCE.constantStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   DATE("date", StringLookupFactory.INSTANCE.dateStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   DNS("dns", StringLookupFactory.INSTANCE.dnsStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   ENVIRONMENT("env", StringLookupFactory.INSTANCE.environmentVariableStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   FILE("file", StringLookupFactory.INSTANCE.fileStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   JAVA("java", StringLookupFactory.INSTANCE.javaPlatformStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  76 */   LOCAL_HOST("localhost", StringLookupFactory.INSTANCE.localHostStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  81 */   PROPERTIES("properties", StringLookupFactory.INSTANCE.propertiesStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   RESOURCE_BUNDLE("resourceBundle", StringLookupFactory.INSTANCE.resourceBundleStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  91 */   SCRIPT("script", StringLookupFactory.INSTANCE.scriptStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  96 */   SYSTEM_PROPERTIES("sys", StringLookupFactory.INSTANCE.systemPropertyStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 101 */   URL("url", StringLookupFactory.INSTANCE.urlStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   URL_DECODER("urlDecoder", StringLookupFactory.INSTANCE.urlDecoderStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   URL_ENCODER("urlEncoder", StringLookupFactory.INSTANCE.urlEncoderStringLookup()),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 116 */   XML("xml", StringLookupFactory.INSTANCE.xmlStringLookup());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String key;
/*     */ 
/*     */ 
/*     */   
/*     */   private final StringLookup lookup;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DefaultStringLookup(String paramString1, StringLookup paramStringLookup) {
/* 131 */     this.key = paramString1;
/* 132 */     this.lookup = paramStringLookup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/* 141 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringLookup getStringLookup() {
/* 150 */     return this.lookup;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\DefaultStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */