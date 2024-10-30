/*     */ package org.apache.poi.openxml4j.opc.internal;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
/*     */ public final class ContentType
/*     */ {
/*     */   private final String type;
/*     */   private final String subType;
/*     */   private final Map<String, String> parameters;
/*     */   private static final Pattern patternTypeSubType;
/*     */   private static final Pattern patternTypeSubTypeParams;
/*     */   private static final Pattern patternParams;
/*     */   
/*     */   static {
/*  95 */     String str1 = "[\\x21-\\x7E&&[^\\(\\)<>@,;:\\\\/\"\\[\\]\\?={}\\x20\\x09]]";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     String str2 = "(" + str1 + "+)=(\"?" + str1 + "+\"?)";
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
/* 131 */     patternTypeSubType = Pattern.compile("^(" + str1 + "+)/(" + str1 + "+)$");
/*     */     
/* 133 */     patternTypeSubTypeParams = Pattern.compile("^(" + str1 + "+)/(" + str1 + "+)(;" + str2 + ")*$");
/*     */     
/* 135 */     patternParams = Pattern.compile(";" + str2);
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
/*     */   public ContentType(String paramString) throws InvalidFormatException {
/* 147 */     Matcher matcher = patternTypeSubType.matcher(paramString);
/* 148 */     if (!matcher.matches())
/*     */     {
/* 150 */       matcher = patternTypeSubTypeParams.matcher(paramString);
/*     */     }
/* 152 */     if (!matcher.matches()) {
/* 153 */       throw new InvalidFormatException("The specified content type '" + paramString + "' is not compliant with RFC 2616: malformed content type.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     if (matcher.groupCount() >= 2) {
/* 161 */       this.type = matcher.group(1);
/* 162 */       this.subType = matcher.group(2);
/*     */ 
/*     */       
/* 165 */       this.parameters = new HashMap<String, String>();
/*     */ 
/*     */       
/* 168 */       if (matcher.groupCount() >= 5) {
/* 169 */         Matcher matcher1 = patternParams.matcher(paramString.substring(matcher.end(2)));
/* 170 */         while (matcher1.find()) {
/* 171 */           this.parameters.put(matcher1.group(1), matcher1.group(2));
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 176 */       this.type = "";
/* 177 */       this.subType = "";
/* 178 */       this.parameters = Collections.emptyMap();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 187 */     return toString(true);
/*     */   }
/*     */   
/*     */   public final String toString(boolean paramBoolean) {
/* 191 */     StringBuffer stringBuffer = new StringBuffer();
/* 192 */     stringBuffer.append(getType());
/* 193 */     stringBuffer.append("/");
/* 194 */     stringBuffer.append(getSubType());
/*     */     
/* 196 */     if (paramBoolean) {
/* 197 */       for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
/* 198 */         stringBuffer.append(";");
/* 199 */         stringBuffer.append((String)entry.getKey());
/* 200 */         stringBuffer.append("=");
/* 201 */         stringBuffer.append((String)entry.getValue());
/*     */       } 
/*     */     }
/* 204 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 209 */     return (!(paramObject instanceof ContentType) || toString().equalsIgnoreCase(paramObject.toString()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 215 */     return toString().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSubType() {
/* 226 */     return this.subType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 235 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasParameters() {
/* 242 */     return (this.parameters != null && !this.parameters.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getParameterKeys() {
/* 249 */     if (this.parameters == null)
/* 250 */       return new String[0]; 
/* 251 */     return (String[])this.parameters.keySet().toArray((Object[])new String[this.parameters.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getParameter(String paramString) {
/* 262 */     return this.parameters.get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\ContentType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */