/*    */ package org.apache.xmlbeans.impl.regex;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.xmlbeans.impl.common.XMLChar;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SchemaRegularExpression
/*    */   extends RegularExpression
/*    */ {
/*    */   private SchemaRegularExpression(String paramString) {
/* 27 */     super(paramString, "X");
/*    */   }
/*    */ 
/*    */   
/*    */   public static RegularExpression forPattern(String paramString) {
/* 32 */     SchemaRegularExpression schemaRegularExpression = (SchemaRegularExpression)knownPatterns.get(paramString);
/* 33 */     if (schemaRegularExpression != null)
/* 34 */       return schemaRegularExpression; 
/* 35 */     return new RegularExpression(paramString, "X");
/*    */   }
/*    */   
/* 38 */   static final Map knownPatterns = buildKnownPatternMap();
/*    */ 
/*    */   
/*    */   private static Map buildKnownPatternMap() {
/* 42 */     HashMap hashMap = new HashMap();
/* 43 */     hashMap.put("\\c+", new SchemaRegularExpression("\\c+") {
/* 44 */           public boolean matches(String param1String) { return XMLChar.isValidNmtoken(param1String); } });
/* 45 */     hashMap.put("\\i\\c*", new SchemaRegularExpression("\\i\\c*") {
/* 46 */           public boolean matches(String param1String) { return XMLChar.isValidName(param1String); } });
/* 47 */     hashMap.put("[\\i-[:]][\\c-[:]]*", new SchemaRegularExpression("[\\i-[:]][\\c-[:]]*") {
/* 48 */           public boolean matches(String param1String) { return XMLChar.isValidNCName(param1String); } });
/* 49 */     return hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\SchemaRegularExpression.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */