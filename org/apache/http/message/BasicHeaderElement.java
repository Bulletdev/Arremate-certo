/*     */ package org.apache.http.message;
/*     */ 
/*     */ import org.apache.http.HeaderElement;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.LangUtils;
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
/*     */ public class BasicHeaderElement
/*     */   implements Cloneable, HeaderElement
/*     */ {
/*     */   private final String name;
/*     */   private final String value;
/*     */   private final NameValuePair[] parameters;
/*     */   
/*     */   public BasicHeaderElement(String paramString1, String paramString2, NameValuePair[] paramArrayOfNameValuePair) {
/*  59 */     this.name = (String)Args.notNull(paramString1, "Name");
/*  60 */     this.value = paramString2;
/*  61 */     if (paramArrayOfNameValuePair != null) {
/*  62 */       this.parameters = paramArrayOfNameValuePair;
/*     */     } else {
/*  64 */       this.parameters = new NameValuePair[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicHeaderElement(String paramString1, String paramString2) {
/*  75 */     this(paramString1, paramString2, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  80 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  85 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public NameValuePair[] getParameters() {
/*  90 */     return (NameValuePair[])this.parameters.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParameterCount() {
/*  95 */     return this.parameters.length;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NameValuePair getParameter(int paramInt) {
/* 101 */     return this.parameters[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public NameValuePair getParameterByName(String paramString) {
/* 106 */     Args.notNull(paramString, "Name");
/* 107 */     NameValuePair nameValuePair = null;
/* 108 */     for (NameValuePair nameValuePair1 : this.parameters) {
/* 109 */       if (nameValuePair1.getName().equalsIgnoreCase(paramString)) {
/* 110 */         nameValuePair = nameValuePair1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 114 */     return nameValuePair;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 119 */     if (this == paramObject) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (paramObject instanceof HeaderElement) {
/* 123 */       BasicHeaderElement basicHeaderElement = (BasicHeaderElement)paramObject;
/* 124 */       return (this.name.equals(basicHeaderElement.name) && LangUtils.equals(this.value, basicHeaderElement.value) && LangUtils.equals((Object[])this.parameters, (Object[])basicHeaderElement.parameters));
/*     */     } 
/*     */ 
/*     */     
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 133 */     int i = 17;
/* 134 */     i = LangUtils.hashCode(i, this.name);
/* 135 */     i = LangUtils.hashCode(i, this.value);
/* 136 */     for (NameValuePair nameValuePair : this.parameters) {
/* 137 */       i = LangUtils.hashCode(i, nameValuePair);
/*     */     }
/* 139 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     StringBuilder stringBuilder = new StringBuilder();
/* 145 */     stringBuilder.append(this.name);
/* 146 */     if (this.value != null) {
/* 147 */       stringBuilder.append("=");
/* 148 */       stringBuilder.append(this.value);
/*     */     } 
/* 150 */     for (NameValuePair nameValuePair : this.parameters) {
/* 151 */       stringBuilder.append("; ");
/* 152 */       stringBuilder.append(nameValuePair);
/*     */     } 
/* 154 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 161 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicHeaderElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */