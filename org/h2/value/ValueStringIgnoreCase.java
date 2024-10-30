/*    */ package org.h2.value;
/*    */ 
/*    */ import org.h2.engine.SysProperties;
/*    */ import org.h2.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValueStringIgnoreCase
/*    */   extends ValueString
/*    */ {
/* 16 */   private static final ValueStringIgnoreCase EMPTY = new ValueStringIgnoreCase("");
/*    */   
/*    */   private int hash;
/*    */   
/*    */   protected ValueStringIgnoreCase(String paramString) {
/* 21 */     super(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 26 */     return 14;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/* 31 */     ValueStringIgnoreCase valueStringIgnoreCase = (ValueStringIgnoreCase)paramValue;
/* 32 */     return paramCompareMode.compareString(this.value, valueStringIgnoreCase.value, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 37 */     return (paramObject instanceof ValueString && this.value.equalsIgnoreCase(((ValueString)paramObject).value));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 43 */     if (this.hash == 0)
/*    */     {
/* 45 */       this.hash = this.value.toUpperCase().hashCode();
/*    */     }
/* 47 */     return this.hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSQL() {
/* 52 */     return "CAST(" + StringUtils.quoteStringSQL(this.value) + " AS VARCHAR_IGNORECASE)";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ValueStringIgnoreCase get(String paramString) {
/* 63 */     if (paramString.length() == 0) {
/* 64 */       return EMPTY;
/*    */     }
/* 66 */     ValueStringIgnoreCase valueStringIgnoreCase1 = new ValueStringIgnoreCase(StringUtils.cache(paramString));
/* 67 */     if (paramString.length() > SysProperties.OBJECT_CACHE_MAX_PER_ELEMENT_SIZE) {
/* 68 */       return valueStringIgnoreCase1;
/*    */     }
/* 70 */     ValueStringIgnoreCase valueStringIgnoreCase2 = (ValueStringIgnoreCase)Value.cache(valueStringIgnoreCase1);
/*    */ 
/*    */     
/* 73 */     if (valueStringIgnoreCase2.value.equals(paramString)) {
/* 74 */       return valueStringIgnoreCase2;
/*    */     }
/* 76 */     return valueStringIgnoreCase1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ValueString getNew(String paramString) {
/* 81 */     return get(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueStringIgnoreCase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */