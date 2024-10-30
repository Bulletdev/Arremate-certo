/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicNameValuePair
/*     */   implements Serializable, Cloneable, NameValuePair
/*     */ {
/*     */   private static final long serialVersionUID = -6437800749411518984L;
/*     */   private final String name;
/*     */   private final String value;
/*     */   
/*     */   public BasicNameValuePair(String paramString1, String paramString2) {
/*  59 */     this.name = (String)Args.notNull(paramString1, "Name");
/*  60 */     this.value = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  70 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  77 */     if (this.value == null) {
/*  78 */       return this.name;
/*     */     }
/*  80 */     int i = this.name.length() + 1 + this.value.length();
/*  81 */     StringBuilder stringBuilder = new StringBuilder(i);
/*  82 */     stringBuilder.append(this.name);
/*  83 */     stringBuilder.append("=");
/*  84 */     stringBuilder.append(this.value);
/*  85 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  90 */     if (this == paramObject) {
/*  91 */       return true;
/*     */     }
/*  93 */     if (paramObject instanceof NameValuePair) {
/*  94 */       BasicNameValuePair basicNameValuePair = (BasicNameValuePair)paramObject;
/*  95 */       return (this.name.equals(basicNameValuePair.name) && LangUtils.equals(this.value, basicNameValuePair.value));
/*     */     } 
/*     */     
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 103 */     int i = 17;
/* 104 */     i = LangUtils.hashCode(i, this.name);
/* 105 */     i = LangUtils.hashCode(i, this.value);
/* 106 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 111 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicNameValuePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */