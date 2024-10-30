/*    */ package org.h2.value;
/*    */ 
/*    */ import java.text.CollationKey;
/*    */ import java.text.Collator;
/*    */ import org.h2.engine.SysProperties;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.util.SmallLRUCache;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompareModeDefault
/*    */   extends CompareMode
/*    */ {
/*    */   private final Collator collator;
/*    */   private final SmallLRUCache<String, CollationKey> collationKeys;
/*    */   
/*    */   protected CompareModeDefault(String paramString, int paramInt, boolean paramBoolean) {
/* 25 */     super(paramString, paramInt, paramBoolean);
/* 26 */     this.collator = CompareMode.getCollator(paramString);
/* 27 */     if (this.collator == null) {
/* 28 */       throw DbException.throwInternalError(paramString);
/*    */     }
/* 30 */     this.collator.setStrength(paramInt);
/* 31 */     int i = SysProperties.COLLATOR_CACHE_SIZE;
/* 32 */     if (i != 0) {
/* 33 */       this.collationKeys = SmallLRUCache.newInstance(i);
/*    */     } else {
/* 35 */       this.collationKeys = null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public int compareString(String paramString1, String paramString2, boolean paramBoolean) {
/*    */     int i;
/* 41 */     if (paramBoolean) {
/*    */       
/* 43 */       paramString1 = paramString1.toUpperCase();
/* 44 */       paramString2 = paramString2.toUpperCase();
/*    */     } 
/*    */     
/* 47 */     if (this.collationKeys != null) {
/* 48 */       CollationKey collationKey1 = getKey(paramString1);
/* 49 */       CollationKey collationKey2 = getKey(paramString2);
/* 50 */       i = collationKey1.compareTo(collationKey2);
/*    */     } else {
/* 52 */       i = this.collator.compare(paramString1, paramString2);
/*    */     } 
/* 54 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equalsChars(String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean) {
/* 60 */     return (compareString(paramString1.substring(paramInt1, paramInt1 + 1), paramString2.substring(paramInt2, paramInt2 + 1), paramBoolean) == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   private CollationKey getKey(String paramString) {
/* 65 */     synchronized (this.collationKeys) {
/* 66 */       CollationKey collationKey = (CollationKey)this.collationKeys.get(paramString);
/* 67 */       if (collationKey == null) {
/* 68 */         collationKey = this.collator.getCollationKey(paramString);
/* 69 */         this.collationKeys.put(paramString, collationKey);
/*    */       } 
/* 71 */       return collationKey;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\CompareModeDefault.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */