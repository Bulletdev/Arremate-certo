/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import org.jsoup.helper.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attribute
/*     */   implements Cloneable, Map.Entry<String, String>
/*     */ {
/*  13 */   private static final String[] booleanAttributes = new String[] { "allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String key;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Attribute(String paramString1, String paramString2) {
/*  30 */     Validate.notEmpty(paramString1);
/*  31 */     Validate.notNull(paramString2);
/*  32 */     this.key = paramString1.trim().toLowerCase();
/*  33 */     this.value = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKey() {
/*  41 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKey(String paramString) {
/*  49 */     Validate.notEmpty(paramString);
/*  50 */     this.key = paramString.trim().toLowerCase();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  58 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String setValue(String paramString) {
/*  66 */     Validate.notNull(paramString);
/*  67 */     String str = this.value;
/*  68 */     this.value = paramString;
/*  69 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/*  77 */     StringBuilder stringBuilder = new StringBuilder();
/*  78 */     html(stringBuilder, (new Document("")).outputSettings());
/*  79 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected void html(StringBuilder paramStringBuilder, Document.OutputSettings paramOutputSettings) {
/*  83 */     paramStringBuilder.append(this.key);
/*  84 */     if (!shouldCollapseAttribute(paramOutputSettings)) {
/*  85 */       paramStringBuilder.append("=\"");
/*  86 */       Entities.escape(paramStringBuilder, this.value, paramOutputSettings, true, false, false);
/*  87 */       paramStringBuilder.append('"');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  96 */     return html();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Attribute createFromEncoded(String paramString1, String paramString2) {
/* 106 */     String str = Entities.unescape(paramString2, true);
/* 107 */     return new Attribute(paramString1, str);
/*     */   }
/*     */   
/*     */   protected boolean isDataAttribute() {
/* 111 */     return (this.key.startsWith("data-") && this.key.length() > "data-".length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean shouldCollapseAttribute(Document.OutputSettings paramOutputSettings) {
/* 118 */     return (("".equals(this.value) || this.value.equalsIgnoreCase(this.key)) && paramOutputSettings.syntax() == Document.OutputSettings.Syntax.html && Arrays.binarySearch((Object[])booleanAttributes, this.key) >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 125 */     if (this == paramObject) return true; 
/* 126 */     if (!(paramObject instanceof Attribute)) return false;
/*     */     
/* 128 */     Attribute attribute = (Attribute)paramObject;
/*     */     
/* 130 */     if ((this.key != null) ? !this.key.equals(attribute.key) : (attribute.key != null)) return false; 
/* 131 */     if ((this.value != null) ? !this.value.equals(attribute.value) : (attribute.value != null)) return false;
/*     */     
/* 133 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 138 */     int i = (this.key != null) ? this.key.hashCode() : 0;
/* 139 */     i = 31 * i + ((this.value != null) ? this.value.hashCode() : 0);
/* 140 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute clone() {
/*     */     try {
/* 146 */       return (Attribute)super.clone();
/* 147 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 148 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Attribute.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */