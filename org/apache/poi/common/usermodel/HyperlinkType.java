/*     */ package org.apache.poi.common.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.Internal;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum HyperlinkType
/*     */ {
/*  29 */   NONE(-1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  35 */   URL(1),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   DOCUMENT(2),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   EMAIL(3),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  50 */   FILE(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "3.15 beta 3")
/*     */   @Deprecated
/*     */   private final int code;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Map<Integer, HyperlinkType> map;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "3.15 beta 3")
/*     */   @Deprecated
/*     */   HyperlinkType(int paramInt1) {
/*  70 */     this.code = paramInt1;
/*     */   }
/*     */   static {
/*  73 */     map = new HashMap<Integer, HyperlinkType>();
/*     */     
/*  75 */     for (HyperlinkType hyperlinkType : values()) {
/*  76 */       map.put(Integer.valueOf(hyperlinkType.getCode()), hyperlinkType);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "3.15 beta 3")
/*     */   @Deprecated
/*     */   public int getCode() {
/*  88 */     return this.code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "3.15 beta 3")
/*     */   @Deprecated
/*     */   public static HyperlinkType forInt(int paramInt) {
/* 101 */     HyperlinkType hyperlinkType = map.get(Integer.valueOf(paramInt));
/* 102 */     if (hyperlinkType == null) {
/* 103 */       throw new IllegalArgumentException("Invalid type: " + paramInt);
/*     */     }
/* 105 */     return hyperlinkType;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\commo\\usermodel\HyperlinkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */