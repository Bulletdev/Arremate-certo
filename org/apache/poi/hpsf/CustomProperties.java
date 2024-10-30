/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomProperties
/*     */   extends HashMap<Object, CustomProperty>
/*     */ {
/*  63 */   private final Map<Long, String> dictionaryIDToName = new HashMap<Long, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   private final Map<String, Long> dictionaryNameToID = new HashMap<String, Long>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isPure = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomProperty put(String paramString, CustomProperty paramCustomProperty) {
/*  88 */     if (paramString == null) {
/*     */ 
/*     */       
/*  91 */       this.isPure = false;
/*  92 */       return null;
/*     */     } 
/*  94 */     if (!paramString.equals(paramCustomProperty.getName())) {
/*  95 */       throw new IllegalArgumentException("Parameter \"name\" (" + paramString + ") and custom property's name (" + paramCustomProperty.getName() + ") do not match.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 100 */     Long long_1 = Long.valueOf(paramCustomProperty.getID());
/* 101 */     Long long_2 = this.dictionaryNameToID.get(paramString);
/* 102 */     this.dictionaryIDToName.remove(long_2);
/* 103 */     this.dictionaryNameToID.put(paramString, long_1);
/* 104 */     this.dictionaryIDToName.put(long_1, paramString);
/*     */ 
/*     */     
/* 107 */     CustomProperty customProperty = (CustomProperty)remove(long_2);
/* 108 */     put((K)long_1, (V)paramCustomProperty);
/* 109 */     return customProperty;
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
/*     */   private Object put(CustomProperty paramCustomProperty) throws ClassCastException {
/* 133 */     String str = paramCustomProperty.getName();
/*     */ 
/*     */     
/* 136 */     Long long_ = this.dictionaryNameToID.get(str);
/* 137 */     if (long_ != null) {
/* 138 */       paramCustomProperty.setID(long_.longValue());
/*     */     } else {
/*     */       
/* 141 */       long l = 1L;
/* 142 */       for (Long long_1 : this.dictionaryIDToName.keySet()) {
/* 143 */         long l1 = long_1.longValue();
/* 144 */         if (l1 > l)
/* 145 */           l = l1; 
/*     */       } 
/* 147 */       paramCustomProperty.setID(l + 1L);
/*     */     } 
/* 149 */     return put(str, paramCustomProperty);
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
/*     */   public Object remove(String paramString) {
/* 163 */     Long long_ = this.dictionaryNameToID.get(paramString);
/* 164 */     if (long_ == null)
/* 165 */       return null; 
/* 166 */     this.dictionaryIDToName.remove(long_);
/* 167 */     this.dictionaryNameToID.remove(paramString);
/* 168 */     return remove(long_);
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
/*     */   public Object put(String paramString1, String paramString2) {
/* 181 */     MutableProperty mutableProperty = new MutableProperty();
/* 182 */     mutableProperty.setID(-1L);
/* 183 */     mutableProperty.setType(31L);
/* 184 */     mutableProperty.setValue(paramString2);
/* 185 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString1);
/* 186 */     return put(customProperty);
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
/*     */   public Object put(String paramString, Long paramLong) {
/* 199 */     MutableProperty mutableProperty = new MutableProperty();
/* 200 */     mutableProperty.setID(-1L);
/* 201 */     mutableProperty.setType(20L);
/* 202 */     mutableProperty.setValue(paramLong);
/* 203 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString);
/* 204 */     return put(customProperty);
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
/*     */   public Object put(String paramString, Double paramDouble) {
/* 217 */     MutableProperty mutableProperty = new MutableProperty();
/* 218 */     mutableProperty.setID(-1L);
/* 219 */     mutableProperty.setType(5L);
/* 220 */     mutableProperty.setValue(paramDouble);
/* 221 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString);
/* 222 */     return put(customProperty);
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
/*     */   public Object put(String paramString, Integer paramInteger) {
/* 235 */     MutableProperty mutableProperty = new MutableProperty();
/* 236 */     mutableProperty.setID(-1L);
/* 237 */     mutableProperty.setType(3L);
/* 238 */     mutableProperty.setValue(paramInteger);
/* 239 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString);
/* 240 */     return put(customProperty);
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
/*     */   public Object put(String paramString, Boolean paramBoolean) {
/* 253 */     MutableProperty mutableProperty = new MutableProperty();
/* 254 */     mutableProperty.setID(-1L);
/* 255 */     mutableProperty.setType(11L);
/* 256 */     mutableProperty.setValue(paramBoolean);
/* 257 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString);
/* 258 */     return put(customProperty);
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
/*     */   public Object get(String paramString) {
/* 271 */     Long long_ = this.dictionaryNameToID.get(paramString);
/* 272 */     CustomProperty customProperty = (CustomProperty)get(long_);
/* 273 */     return (customProperty != null) ? customProperty.getValue() : null;
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
/*     */   public Object put(String paramString, Date paramDate) {
/* 288 */     MutableProperty mutableProperty = new MutableProperty();
/* 289 */     mutableProperty.setID(-1L);
/* 290 */     mutableProperty.setType(64L);
/* 291 */     mutableProperty.setValue(paramDate);
/* 292 */     CustomProperty customProperty = new CustomProperty(mutableProperty, paramString);
/* 293 */     return put(customProperty);
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
/*     */   public Set keySet() {
/* 305 */     return this.dictionaryNameToID.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> nameSet() {
/* 314 */     return this.dictionaryNameToID.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> idSet() {
/* 323 */     return this.dictionaryNameToID.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodepage(int paramInt) {
/* 334 */     MutableProperty mutableProperty = new MutableProperty();
/* 335 */     mutableProperty.setID(1L);
/* 336 */     mutableProperty.setType(2L);
/* 337 */     mutableProperty.setValue(Integer.valueOf(paramInt));
/* 338 */     put(new CustomProperty(mutableProperty));
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
/*     */   Map<Long, String> getDictionary() {
/* 351 */     return this.dictionaryIDToName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 360 */     if (paramObject instanceof Long) {
/* 361 */       return super.containsKey(paramObject);
/*     */     }
/* 363 */     if (paramObject instanceof String) {
/* 364 */       return super.containsKey(this.dictionaryNameToID.get(paramObject));
/*     */     }
/* 366 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 374 */     if (paramObject instanceof CustomProperty) {
/* 375 */       return super.containsValue(paramObject);
/*     */     }
/* 377 */     for (CustomProperty customProperty : values()) {
/* 378 */       if (customProperty.getValue() == paramObject) {
/* 379 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 383 */     return false;
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
/*     */   public int getCodepage() {
/* 395 */     int i = -1;
/* 396 */     for (Iterator<CustomProperty> iterator = values().iterator(); i == -1 && iterator.hasNext(); ) {
/*     */       
/* 398 */       CustomProperty customProperty = iterator.next();
/* 399 */       if (customProperty.getID() == 1L)
/* 400 */         i = ((Integer)customProperty.getValue()).intValue(); 
/*     */     } 
/* 402 */     return i;
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
/*     */   public boolean isPure() {
/* 417 */     return this.isPure;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPure(boolean paramBoolean) {
/* 427 */     this.isPure = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\CustomProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */