/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomProperty
/*     */   extends MutableProperty
/*     */ {
/*     */   private String name;
/*     */   
/*     */   public CustomProperty() {
/*  37 */     this.name = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomProperty(Property paramProperty) {
/*  48 */     this(paramProperty, (String)null);
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
/*     */   public CustomProperty(Property paramProperty, String paramString) {
/*  60 */     super(paramProperty);
/*  61 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/*  81 */     this.name = paramString;
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
/*     */   public boolean equalsContents(Object paramObject) {
/*  98 */     CustomProperty customProperty = (CustomProperty)paramObject;
/*  99 */     String str1 = customProperty.getName();
/* 100 */     String str2 = getName();
/* 101 */     boolean bool = true;
/* 102 */     if (str1 == null) {
/* 103 */       bool = (str2 == null);
/*     */     } else {
/* 105 */       bool = str1.equals(str2);
/* 106 */     }  return (bool && customProperty.getID() == getID() && customProperty.getType() == getType() && customProperty.getValue().equals(getValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 117 */     return (int)getID();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 122 */     return (paramObject instanceof CustomProperty) ? equalsContents(paramObject) : false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\CustomProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */