/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlOptionCharEscapeMap
/*     */ {
/*  57 */   private static final HashMap _predefEntities = new HashMap();
/*     */   static {
/*  59 */     _predefEntities.put(new Character('<'), "&lt;");
/*  60 */     _predefEntities.put(new Character('>'), "&gt;");
/*  61 */     _predefEntities.put(new Character('&'), "&amp;");
/*  62 */     _predefEntities.put(new Character('\''), "&apos;");
/*  63 */     _predefEntities.put(new Character('"'), "&quot;");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   private HashMap _charMap = new HashMap();
/*     */   
/*     */   public static final int HEXADECIMAL = 2;
/*     */   
/*     */   public static final int DECIMAL = 1;
/*     */   public static final int PREDEF_ENTITY = 0;
/*     */   
/*     */   public boolean containsChar(char paramChar) {
/*  79 */     return this._charMap.containsKey(new Character(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMapping(char paramChar, int paramInt) throws XmlException {
/*     */     String str1, str2;
/*  88 */     Character character = new Character(paramChar);
/*  89 */     switch (paramInt) {
/*     */       
/*     */       case 0:
/*  92 */         str1 = (String)_predefEntities.get(character);
/*  93 */         if (str1 == null)
/*     */         {
/*  95 */           throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
/*     */         }
/*     */ 
/*     */         
/*  99 */         this._charMap.put(character, str1);
/*     */         return;
/*     */       
/*     */       case 1:
/* 103 */         this._charMap.put(character, "&#" + paramChar + ";");
/*     */         return;
/*     */       
/*     */       case 2:
/* 107 */         str2 = Integer.toHexString(paramChar);
/* 108 */         this._charMap.put(character, "&#x" + str2 + ";");
/*     */         return;
/*     */     } 
/*     */     
/* 112 */     throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addMappings(char paramChar1, char paramChar2, int paramInt) throws XmlException {
/* 123 */     if (paramChar1 > paramChar2)
/*     */     {
/* 125 */       throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
/*     */     }
/*     */     
/*     */     char c;
/* 129 */     for (c = paramChar1; c <= paramChar2; c = (char)(c + 1))
/*     */     {
/* 131 */       addMapping(c, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEscapedString(char paramChar) {
/* 140 */     return (String)this._charMap.get(new Character(paramChar));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlOptionCharEscapeMap.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */